package com.vedant.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Get Authorization header (contains JWT token)
        String jwt = request.getHeader(JwtConstant.JWT_HEADER);

        // Check if header is present and starts with "Bearer "
        if (jwt != null && jwt.startsWith("Bearer ")) {

            // Remove "Bearer " (7 characters)
            jwt = jwt.substring(7);

            try {
                // Create secret key
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

                // Parse JWT token and extract data
                Claims claims = Jwts.parser()
                        .verifyWith(key)   // new method instead of setSigningKey
                        .build()
                        .parseSignedClaims(jwt)
                        .getPayload();

                // Get user details from token
                String email = String.valueOf(claims.get("email"));
                String authorities = String.valueOf(claims.get("authorities"));

                // Example: ROLE_ADMIN,ROLE_CUSTOMER
                List<GrantedAuthority> auth =
                        AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                // Create Authentication object
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(email, null, auth);

                // Set authentication in Security Context (very important)
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                // If token is invalid
                throw new BadCredentialsException("Invalid JWT token");
            }
        }

        // Continue filter chain
        filterChain.doFilter(request, response);
    }
}