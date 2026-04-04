package com.kshtriya.auth.auth_app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshtriya.auth.auth_app.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // 🔹 Disable CSRF (not needed for REST APIs)
                .csrf(csrf -> csrf.disable())

                // 🔹 Enable CORS
                .cors(Customizer.withDefaults())

                // 🔹 Stateless session (JWT based)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // 🔹 Public & secured endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated()
                )

                // 🔹 Add JWT filter
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)

                // 🔹 Custom 401 Unauthorized response
                .exceptionHandling(ex -> ex.authenticationEntryPoint(
                        (request, response, authException) -> {

                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json");

                            String message = "Unauthorized access";

                            Map<String, String> error = Map.of(
                                    "error", message
                            );

                            ObjectMapper mapper = new ObjectMapper();
                            mapper.writeValue(response.getOutputStream(), error);
                        }
                ))

                // 🔹 Optional basic auth
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}