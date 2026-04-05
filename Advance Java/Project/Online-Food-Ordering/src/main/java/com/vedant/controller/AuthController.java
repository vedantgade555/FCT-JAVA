package com.vedant.controller;

import com.vedant.Service.CustomUserDetailsService;
import com.vedant.config.JwtProvider;
import com.vedant.model.Cart;
import com.vedant.model.USER_ROLE;
import com.vedant.model.User;
import com.vedant.repository.CartRepository;
import com.vedant.repository.UserRepository;
import com.vedant.request.LoginRequest;
import com.vedant.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CartRepository cartRepository;

    // ========================= SIGNUP API =========================
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception {

        // Check if email already exists
        User isEmailExists = userRepository.findByEmail(user.getEmail());
        if (isEmailExists != null) {
            throw new Exception("Email is already used with another account");
        }

        // Create new user object
        User createdUser = new User();
        createdUser.setEmail(user.getEmail());
        createdUser.setFullname(user.getFullname());
        createdUser.setRole(user.getRole());

        // Encrypt password before saving
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user to database
        User savedUser = userRepository.save(createdUser);

        // Create cart for new user
        Cart cart = new Cart();
        cart.setCustomer(savedUser);
        cartRepository.save(cart);

        // Create authentication object (login user after signup)
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

        // Store authentication in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        String jwt = jwtProvider.generateToken(authentication);

        // Prepare response
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Register Success");
        authResponse.setRole(savedUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    // ========================= SIGNIN API =========================
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest req) {

        String username = req.getEmail();
        String password = req.getPassword();

        // Authenticate user (check email & password)
        Authentication authentication = authenticate(username, password);

        // Get roles of user
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Get first role (if exists)
        String role = authorities.isEmpty() ? null :
                authorities.iterator().next().getAuthority();

        // Generate JWT token
        String jwt = jwtProvider.generateToken(authentication);

        // Prepare response
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Login Success"); // fixed message
        authResponse.setRole(USER_ROLE.valueOf(role));

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    // ========================= AUTHENTICATION LOGIC =========================
    private Authentication authenticate(String username, String password) {

        // Load user from database
        UserDetails userDetails =
                customUserDetailsService.loadUserByUsername(username);

        // If user not found
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username...");
        }

        // Check password (plain vs encrypted)
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password...");
        }

        // If everything is correct, return authentication object
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                userDetails.getAuthorities()
        );
    }
}