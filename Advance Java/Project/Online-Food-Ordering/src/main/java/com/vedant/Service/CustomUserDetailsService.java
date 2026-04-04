package com.vedant.Service;

import com.vedant.model.USER_ROLE;
import com.vedant.model.User;
import com.vedant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Inject UserRepository to fetch user from database
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Find user by email (username = email here)
        User user = userRepository.findByEmail(username);

        // If user not found → throw exception
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Get user role (like ROLE_ADMIN, ROLE_CUSTOMER)
        USER_ROLE role = user.getRole();


        // Create list of authorities (roles)
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Convert role to Spring Security format
        authorities.add(new SimpleGrantedAuthority(role.toString()));

        // Return UserDetails object (used by Spring Security)
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),      // username
                user.getPassword(),   // encrypted password
                authorities           // roles
        );
    }
}