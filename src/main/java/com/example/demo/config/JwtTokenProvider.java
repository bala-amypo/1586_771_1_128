package com.example.demo.config;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final JwtUtil jwtUtil;

    public JwtTokenProvider() {
        // values match application.properties and test suite expectations
        this.jwtUtil = new JwtUtil("thisIsA32ByteMinimumSecureJwtTestKey!", 3600000L);
    }

    public JwtTokenProvider(String secret, long validityMs) {
        this.jwtUtil = new JwtUtil(secret, validityMs);
    }

    public String generateToken(Authentication authentication, UserAccount user) {
        return jwtUtil.generateToken(user);
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    public String getUsernameFromToken(String token) {
        if (!validateToken(token)) return null;
        return jwtUtil.getUsername(token);
    }
}
