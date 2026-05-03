package com.vedant.SpringSecurity.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    // 1. Declare a variable to hold your dynamically generated key
    private String secretKey;

    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            // 2. Assign the generated string to your variable instead of throwing it away
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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
}