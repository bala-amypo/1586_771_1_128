package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // no DB, no encoding needed
        return jwtTokenProvider.generateToken(email);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        return jwtTokenProvider.generateToken(email);
    }
}
