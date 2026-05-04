package com.vedant.SpringSecurity.controller;

import com.vedant.SpringSecurity.model.User;
import com.vedant.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// This class handles the incoming HTTP requests related to Users
@RestController
public class UserController {

    @Autowired
    private UserService service;

    // Endpoint for registering a new user
    // The user details are sent in the request body
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // Endpoint for user login
    // Returns a JWT token if login is successful, or "Fail" if incorrect
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.verify(user);
    }

    // Endpoint to get a list of all registered users
    // This is protected and requires a valid JWT token to access
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}
