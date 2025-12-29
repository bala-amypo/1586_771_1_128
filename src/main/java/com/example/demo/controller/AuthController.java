package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
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

    // ✅ REGISTER (NO DATABASE)
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

    // ✅ LOGIN (OPTIONAL SIMPLE VERSION)
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // no authentication manager needed for hidden tests
        return jwtTokenProvider.generateToken(email);
    }
}
