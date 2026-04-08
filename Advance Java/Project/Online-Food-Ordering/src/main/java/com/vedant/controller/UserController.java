package com.vedant.controller;

// Import required classes
import com.vedant.Service.UserService;  // Service layer to handle business logic
import com.vedant.model.User;           // User entity class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
// Marks this class as REST Controller
// Base URL for all APIs in this controller -> /api/users
public class UserController {

    @Autowired
    private UserService userService;
    // Injects UserService to access user-related business logic

    @GetMapping("/profile")
    // Handles GET request -> /api/users/profile
    public ResponseEntity<User> findUserByJwtToken(
            @RequestHeader("Authorization") String jwt) throws Exception {
        // Reads JWT token from Authorization header

        // Calls service to extract user using JWT token
        User user = userService.findUserByJwtToken(jwt);

        // Returns user data with HTTP status 200 (OK)
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}