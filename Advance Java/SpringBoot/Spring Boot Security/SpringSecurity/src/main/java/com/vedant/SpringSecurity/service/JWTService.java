package com.vedant.SpringSecurity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    // 1. Declare a variable to hold your dynamically generated key
    private String secretKey;

    public JWTService() {
        try {
            // Generate a secure key when the service starts
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            // 2. Assign the generated string to your variable
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Method to create a new token when a user logs in
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)                     // Any extra payload data you want to add
                .setSubject(username)                  // The user this token belongs to
                .setIssuedAt(new Date(System.currentTimeMillis())) // Token creation time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Valid for 30 minutes
                .signWith(getKey(), SignatureAlgorithm.HS256) // Cryptographic signature
                .compact();                            // Builds the token string
    }

    // Helper method to decode the Base64 secret and generate a cryptographic Key object
    private Key getKey() {
        // 3. Use the instance variable here
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // converts string into the bytes
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Method to get the username out of the token
    public String extractUsername(String token) {
        // The subject of the token is the username
        return extractClaim(token, Claims::getSubject);
    }

    // Generic method to extract any piece of data (claim) from the token
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    // Method to parse the token and read all its data
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey()) // We need the secret key to verify the token is valid
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Method to check if the token is valid for the user
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        // It's valid if the username matches and the token hasn't expired yet
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Helper method to check if the token time has expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Helper method to get the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}