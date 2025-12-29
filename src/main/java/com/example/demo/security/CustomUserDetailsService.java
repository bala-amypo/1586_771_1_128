package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) {
        return null;
    }
}
