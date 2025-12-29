package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // TEMPORARY STATIC USER (for testing)
        // email = jesil@gmail.com
        // password = jesil

        if (!email.equals("jesil@gmail.com")) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                "jesil@gmail.com",
                "{noop}jesil",   // {noop} = no password encoding
                Collections.emptyList()
        );
    }
}
