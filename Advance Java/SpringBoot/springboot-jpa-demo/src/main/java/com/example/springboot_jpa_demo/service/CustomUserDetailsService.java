package com.example.springboot_jpa_demo.service;

// 1. Remove the wildcard import and explicitly import only what you need
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 2. Explicitly import YOUR custom entity (adjust the package name if necessary)
import com.example.springboot_jpa_demo.entity.User; 
import com.example.springboot_jpa_demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // This now correctly references your JPA entity
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // You correctly fully-qualified the Spring Security User builder here!
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()) 
                .build();
    }
}