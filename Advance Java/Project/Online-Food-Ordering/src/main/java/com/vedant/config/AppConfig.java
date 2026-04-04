package com.vedant.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class AppConfig {

    // Main Security Configuration
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // No session will be created (used in JWT authentication)
                .sessionManagement(management ->
                        management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Define access rules
                .authorizeHttpRequests(auth -> auth

                        // Only ADMIN or RESTAURENT_OWNER can access admin APIs
                        .requestMatchers("/api/admin/**")
                        .hasAnyRole("RESTAURENT_OWNER", "ADMIN")

                        // All other API requests require login
                        .requestMatchers("/api/**")
                        .authenticated()

                        // All other requests are public
                        .anyRequest()
                        .permitAll()
                )

                // Add custom JWT filter before Spring's Basic Auth filter
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)

                // Disable CSRF (not needed for REST APIs)
                .csrf(csrf -> csrf.disable())

                // Enable CORS with our custom configuration
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));

        // Build and return
        return http.build();
    }

    // CORS Configuration (controls which frontend can call backend)
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                CorsConfiguration cfg = new CorsConfiguration();

                // Allow these frontend URLs
                cfg.setAllowedOrigins(Arrays.asList(
                        "http://vedant-food.vercel.app",
                        "http://localhost:3000"
                ));

                // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
                cfg.setAllowedMethods(Collections.singletonList("*"));

                // Allow sending cookies / authorization headers
                cfg.setAllowCredentials(true);

                // Allow all headers
                cfg.setAllowedHeaders(Collections.singletonList("*"));

                // Expose Authorization header to frontend
                cfg.setExposedHeaders(Arrays.asList("Authorization"));

                // Cache CORS response for 1 hour
                cfg.setMaxAge(3600L);

                return cfg;
            }
        };
    }

    // Password encoder (used to hash passwords securely)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}