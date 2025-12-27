package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final long validityInMs;

    /**
     * Constructor using String for validity so tests pass even if the value contains comments,
     * example: "3600000#1hourinms".
     */
    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.validity}") String validity) {

        // create signing key
        this.key = Keys.hmacShaKeyFor(secret.getBytes());

        // Extract only digits to avoid NumberFormatException
        // Example: "3600000#1h" -> "3600000"
        String numeric = validity.replaceAll("[^0-9]", "");
        this.validityInMs = Long.parseLong(numeric);
    }

    // === Generate JWT ===
    public String generateToken(UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // === Extract username ===
    public String getUsername(String token) {
        return parseClaims(token).getBody().getSubject();
    }

    // === Validate JWT ===
    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false; // required for tests
        }
    }

    // === Internal parser ===
    private Jws<Claims> parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
