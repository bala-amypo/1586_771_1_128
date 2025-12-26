package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.service.UserAccountService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserAccountService userService,
                          AuthenticationManager authManager,
                          JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.authManager = authManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest req) {
        RoleType role = req.getRole() == null ? RoleType.INVESTOR : RoleType.valueOf(req.getRole());
        UserAccount user = new UserAccount(req.getUsername(), req.getEmail(), req.getPassword(), role);
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );
        UserAccount user = userService.findByEmail(req.getEmail()).orElseThrow();
        String token = tokenProvider.generateToken(authentication, user);

        return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole().name());
    }
}
