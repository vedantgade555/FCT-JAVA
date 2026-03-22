package com.kshtriya.auth.auth_app.exceptions;

import com.kshtriya.auth.auth_app.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // This catches EVERYTHING
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleEverything(Exception ex) {

        ErrorResponse errorResponse = new ErrorResponse(
                "Something went wrong: " + ex.getMessage(),"500",404
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}