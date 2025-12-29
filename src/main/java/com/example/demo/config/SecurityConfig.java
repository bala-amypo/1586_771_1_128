package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // disable CSRF for simplicity in APIs
            .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()  // allow all auth endpoints
                .anyRequest().authenticated()  // everything else requires authentication
            .and()
            .httpBasic().disable(); // disable default login popup

        return http.build();
    }
}
