package com.vedant.SpringSecurity.service;

import com.vedant.SpringSecurity.model.User;
import com.vedant.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    // We use BCrypt to hash passwords before saving them to the database
    // The '12' is the strength (work factor) of the hashing algorithm
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // Method to register a new user
    public User register(User user) {
        // Hash the user's plain text password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        // Save the new user to the database
        return repo.save(user);
    }

    // Method to verify a user's login credentials and generate a token
    public String verify(User user) {
        // Authenticate the user by checking the provided username and password
        Authentication authentication = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // If the credentials are correct and the user is authenticated
        if (authentication.isAuthenticated()) {
            // Generate and return a JWT token for the user
            return jwtService.generateToken(user.getUsername());
        }
        
        // Return a failure message if authentication fails
        return "Fail";
    }

    // Method to get a list of all users from the database
    public java.util.List<User> getAllUsers() {
        return repo.findAll();
    }
}
