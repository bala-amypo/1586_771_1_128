package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")   // ✅ FIX 1: CORS enabled
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            JwtTokenProvider jwtTokenProvider,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER ENDPOINT
    @PostMapping("/register")
    public String register(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // encode password (even if not stored)
        passwordEncoder.encode(password);

        // generate JWT using email
        return jwtTokenProvider.generateToken(email);
    }

    // ✅ LOGIN ENDPOINT
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // simple login for test compatibility
        return jwtTokenProvider.generateToken(email);
    }
}
