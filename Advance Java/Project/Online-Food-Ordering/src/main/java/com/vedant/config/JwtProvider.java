package com.vedant.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Service
public class JwtProvider {

    // Secret key used to sign the JWT token
    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    // Method to generate JWT token
    public String generateToken(Authentication auth){

        // Get roles/authorities of logged-in user
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        // Convert authorities into string
        String roles = populateAuthorities(authorities);

        // Create JWT token
        String jwt = Jwts.builder()
                .setIssuedAt(new Date()) // token creation time
                .setExpiration(new Date(new Date().getTime() + 864000000)) // token expiry (10 days)
                .claim("email", auth.getName()) // store user email in token
                .claim("authorities", roles) // store roles in token
                .signWith(key) // sign token with secret key
                .compact(); // generate token string

        return jwt;
    }

    // Method to extract email from JWT token
    public String getEmailFromJwtToken(String jwt){

        // Remove "Bearer " prefix from token
        jwt = jwt.substring(7);

        // Parse token and extract claims (data)
        Claims claims = Jwts.parser()
                .verifyWith(key) // verify token with secret key
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

        // Get email from token
        String email = String.valueOf(claims.get("email"));

        return email;
    }

    // Method to convert authorities (roles) into comma separated string
    private String populateAuthorities(Collection<? extends GrantedAuthority> authorities){

        // Use Set to avoid duplicate roles
        Set<String> auths = new HashSet<>();

        // Loop through all roles
        for(GrantedAuthority authority : authorities){
            auths.add(authority.getAuthority()); // add role
        }

        // Convert roles into comma-separated string
        return String.join(",", auths);
    }
}