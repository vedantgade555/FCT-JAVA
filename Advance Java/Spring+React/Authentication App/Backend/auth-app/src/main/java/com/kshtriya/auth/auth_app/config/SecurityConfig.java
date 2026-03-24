package com.kshtriya.auth.auth_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Take a reference from the documentation
// https://docs.enterprise.spring.io/spring-security/reference/migration-7/configuration.html


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF so your React frontend can send POST requests to /register without a token
                .csrf(csrf -> csrf.disable())

                // 2. Configure endpoint access rules using Lambda DSL
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/register").permitAll() // Open to public
                        .anyRequest().authenticated()                         // Secure everything else
                )

                // 3. Enable basic authentication (useful for testing before JWT is fully set up)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("vedant")
//                .password("abc")
//                .roles("ADMIN")
//                .build();
//
//        // Combined the two "Jay" users into one, giving him both roles
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("Jay")
//                .password("abd")
//                .roles("ADMIN", "USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

}