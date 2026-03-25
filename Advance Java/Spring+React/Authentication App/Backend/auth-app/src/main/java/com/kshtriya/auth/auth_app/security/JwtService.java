package com.kshtriya.auth.auth_app.security;

import com.kshtriya.auth.auth_app.entity.Role;
import com.kshtriya.auth.auth_app.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// Make sure to import your actual User and Role entities here!
// import com.kshtriya.auth.auth_app.entity.User;
// import com.kshtriya.auth.auth_app.entity.Role;

@Service
public class JwtService {

    private final SecretKey key;
    private final long accessTtlSeconds;
    private final long refreshTtlSeconds;
    private final String issuer;

    public JwtService(
            @Value("${security.jwt.secret}") String secret,
            @Value("${security.jwt.access-ttl-seconds}") long accessTtlSeconds,
            @Value("${security.jwt.refresh-ttl-seconds}") long refreshTtlSeconds,
            @Value("${security.jwt.issuer}") String issuer
    ) {

        if (secret == null || secret.length() < 64) {
            throw new IllegalArgumentException("Secret length must be at least 64 characters for HS512");
        }

        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessTtlSeconds = accessTtlSeconds;
        this.refreshTtlSeconds = refreshTtlSeconds;
        this.issuer = issuer;
    }

    public String generateAccessToken(User user) {
        Instant now = Instant.now();

        List<String> roles = user.getRoles() == null ? List.of() :
                user.getRoles().stream().map(Role::getName).toList();

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .subject(user.getId().toString())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(accessTtlSeconds)))
                // Using individual .claim() calls is much safer and cleaner than Map.of()
                .claim("email", user.getEmail())
                .claim("roles", roles)
                .claim("typ", "access")
                .signWith(key)
                .compact();
    }

    // generate refresh token

    //jti is an user unique id
    public String generateRefreshToken(User user, String jti) {
        Instant now = Instant.now();

        return Jwts.builder()
                .id(jti)
                .subject(user.getId().toString())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(refreshTtlSeconds)))
                .claim("typ", "refresh")
                .signWith(key)
                .compact();
    }

    // parse the token
    public Jws<Claims> parse(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(key) // Uses the secure key we generated in the constructor
                    .build()
                    .parseSignedClaims(token);
        } catch (JwtException | IllegalArgumentException e) {
            // JwtException catches expired, malformed, or tampered tokens.
            // IllegalArgumentException catches null or empty token strings.

            // In a production app, you might want to log this error here
            // before throwing it so you know why requests are failing!
            throw e;
        }
    }

    public boolean isAccessToken(String token) {
        Claims c = parse(token).getPayload();
        return "access".equals(c.get("typ"));
    }

    public boolean isRefreshToken(String token) {
        Claims c = parse(token).getPayload();
        return "refresh".equals(c.get("typ"));
    }

    public UUID getUserId(String token) {
        Claims c = parse(token).getPayload();
        return UUID.fromString(c.getSubject());
    }

    public String getJti(String token) {
        return parse(token).getPayload().getId();
    }
}