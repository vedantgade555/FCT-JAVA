package com.vedant.Service;

// Importing required classes
import com.vedant.config.JwtProvider;      // Used to extract data (like email) from JWT token
import com.vedant.model.User;              // User entity class
import com.vedant.repository.UserRepository; // Repository to interact with database
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Service layer component (business logic layer)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    // Injects UserRepository to perform DB operations like fetching user by email

    @Autowired
    private JwtProvider jwtProvider;
    // Injects JwtProvider to decode JWT token and extract user details

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {

        // Extract email from JWT token using JwtProvider
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        // Find user in database using extracted email
        User user = findUserByEmail(email);

        // Return the user object
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        // Fetch user from database using email
        User user = userRepository.findByEmail(email);

        // If user does not exist, throw exception
        if(user == null){
            throw new Exception("User not found");
        }

        // Return user if found
        return user;
    }
}