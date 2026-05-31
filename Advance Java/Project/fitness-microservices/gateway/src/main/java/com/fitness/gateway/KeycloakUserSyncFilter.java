package com.fitness.gateway;

import com.fitness.gateway.user.RegisterRequest;
import com.fitness.gateway.user.UserService;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class KeycloakUserSyncFilter implements WebFilter {

    private final UserService userService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String headerUserId = exchange.getRequest().getHeaders().getFirst("X-User-ID");
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        // 1. Prevent NPE: Only parse the token if it actually exists
        RegisterRequest registerRequest = (token != null) ? getUserDetails(token) : null;

        // 2. Resolve the final userId (Header takes priority, token fallback)
        String resolvedUserId = headerUserId;
        if (resolvedUserId == null && registerRequest != null) {
            resolvedUserId = registerRequest.getKeycloakId();
        }

        if (resolvedUserId != null && token != null) {
            final String finalUserId = resolvedUserId; // Make effectively final for lambda

            // 3. Mutate the request BEFORE entering the reactive chain.
            // Good practice: If the header was missing, inject it so downstream services have it.
            ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
                    .header("X-User-ID", finalUserId)
                    .build();

            ServerWebExchange mutatedExchange = exchange.mutate()
                    .request(mutatedRequest)
                    .build();

            return userService.validateUser(finalUserId)
                    .flatMap(exists -> {
                        if (!exists) {
                            if (registerRequest != null) {
                                log.info("User {} does not exist. Registering...", finalUserId);

                                // 4. CRITICAL FIX: After registration succeeds, continue the chain!
                                return userService.registerUser(registerRequest)
                                        .then(chain.filter(mutatedExchange));
                            } else {
                                log.warn("Cannot register user {}: Missing JWT details", finalUserId);
                                // Pass request through, let downstream handle unauthorized state
                                return chain.filter(mutatedExchange);
                            }
                        } else {
                            log.info("User {} already exists.", finalUserId);
                            // User exists, continue the chain
                            return chain.filter(mutatedExchange);
                        }
                    });
        }

        // If no token, just pass through (or return 401 Unauthorized if this gateway is strict)
        return chain.filter(exchange);
    }

    private RegisterRequest getUserDetails(String token) {
        // Prevent substring/replace errors if token is malformed
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        try {
            // substring(7) is slightly more performant and accurate than replace("Bearer ", "")
            String tokenWithoutBearer = token.substring(7).trim();
            SignedJWT signedJWT = SignedJWT.parse(tokenWithoutBearer);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setEmail(claims.getStringClaim("email"));
            registerRequest.setKeycloakId(claims.getStringClaim("sub"));
            registerRequest.setPassword("dummy@123"); // Consider security implications of this in prod!
            registerRequest.setFirstName(claims.getStringClaim("given_name"));
            registerRequest.setLastName(claims.getStringClaim("family_name"));

            return registerRequest;
        } catch (Exception e) {
            // 5. Replaced printStackTrace with proper SLF4J logging
            log.error("Failed to parse JWT token for user sync", e);
            return null;
        }
    }
}