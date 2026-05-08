package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus; // 1. Use Spring's HttpStatus, not Apache's
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;

    // 2. Changed to public so other services can actually call this method
    public boolean validateUser(String userId) {
        try {
            Boolean isValid = userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId) // 3. Removed the extra '}' here
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            // Null-safe return just in case the body is empty
            return Boolean.TRUE.equals(isValid);

        } catch (WebClientResponseException e) {
            // 4. Spring Boot 3 syntax for checking status codes
            if (e.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                throw new RuntimeException("User not found: " + userId);
            } else if (e.getStatusCode().isSameCodeAs(HttpStatus.BAD_REQUEST)) {
                throw new RuntimeException("Invalid Request: " + userId);
            }

            // 5. Must have a fallback if the error is something else (like a 500 Internal Server Error)
            throw new RuntimeException("Unexpected error from User Service: " + e.getMessage());

        } catch (Exception e) {
            // Catches scenarios where the User Service is completely offline (Connection Refused)
            throw new RuntimeException("Could not connect to User Service: " + e.getMessage());
        }
    }
}