package com.kshtriya.auth.auth_app.security;

import com.kshtriya.auth.auth_app.entity.User;
import com.kshtriya.auth.auth_app.helper.UserHelper;
import com.kshtriya.auth.auth_app.repositories.UserRepository;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            // ✅ Check access token
            if (!jwtService.isAccessToken(token)) {
                filterChain.doFilter(request, response);
                return;
            }

            try {
                Jws<Claims> jwsClaims = jwtService.parse(token);
                Claims payload = jwsClaims.getPayload();

                String userId = payload.getSubject();
                UUID userUuid = UserHelper.parseUUID(userId);

                userRepository.findById(userUuid).ifPresent(user -> {

                    if (SecurityContextHolder.getContext().getAuthentication() == null) {

                        // ✅ Check if user is enabled
                        if (!user.isEnable()) {
                           try{
                               filterChain.doFilter(request,response);

                           }catch (IOException | ServletException e){
                               throw new RuntimeException(e);
                           }
                           return;
                        }

                        // ✅ Convert roles
                        List<GrantedAuthority> authorities =
                                user.getRoles() == null ? List.of() :
                                        user.getRoles().stream()
                                                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                                                .collect(Collectors.toList());

                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(
                                        user,
                                        null,
                                        authorities
                                );

                        authToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request)
                        );

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }

                    if(SecurityContextHolder.getContext().getAuthentication() == null)
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                });

            } catch (ExpiredJwtException e) {
                log.warn("JWT expired: {}", e.getMessage());
            } catch (MalformedJwtException e) {
                log.warn("Invalid JWT format: {}", e.getMessage());
            } catch (JwtException e) {
                log.warn("JWT error: {}", e.getMessage());
            } catch (Exception e) {
                log.error("Unexpected error in JWT filter", e);
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().startsWith("/auth");
    }
}