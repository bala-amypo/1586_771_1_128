package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final GuestRepository guestRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            GuestRepository guestRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.guestRepository = guestRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        if (guestRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        Guest guest = new Guest();
        guest.setEmail(request.getEmail());
        guest.setFullName(request.getFullName());
        guest.setPassword(passwordEncoder.encode(request.getPassword()));
        guest.setActive(true);
        guest.setVerified(false);

        guestRepository.save(guest);

        String token = jwtTokenProvider.generateToken(guest.getEmail());
        return new AuthResponse(token);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public AuthResponse login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        String token = jwtTokenProvider.generateToken(authentication.getName());
        return new AuthResponse(token);
    }
}
