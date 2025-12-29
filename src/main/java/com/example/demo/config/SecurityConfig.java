// package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationFilter;
// import com.example.demo.security.CustomUserDetailsService;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import java.util.List;

// @Configuration
// public class SecurityConfig {

//     private final JwtAuthenticationFilter jwtFilter;
//     private final CustomUserDetailsService userDetailsService;

//     public SecurityConfig(
//             JwtAuthenticationFilter jwtFilter,
//             CustomUserDetailsService userDetailsService
//     ) {
//         this.jwtFilter = jwtFilter;
//         this.userDetailsService = userDetailsService;
//     }

//     // ✅ Password encoder
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // ✅ Authentication manager
//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration config
//     ) throws Exception {
//         return config.getAuthenticationManager();
//     }

//     // ✅ CORS CONFIGURATION (THIS FIXES SWAGGER)
//     @Bean
//     public CorsConfigurationSource corsConfigurationSource() {

//         CorsConfiguration config = new CorsConfiguration();

//         config.setAllowedOrigins(List.of("*"));
//         config.setAllowedMethods(List.of(
//                 "GET", "POST", "PUT", "DELETE", "OPTIONS"
//         ));
//         config.setAllowedHeaders(List.of("*"));
//         config.setAllowCredentials(false);

//         UrlBasedCorsConfigurationSource source =
//                 new UrlBasedCorsConfigurationSource();

//         source.registerCorsConfiguration("/**", config);
//         return source;
//     }

//     // ✅ SECURITY FILTER CHAIN
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//             // 🔥 REQUIRED FOR SWAGGER
//             .cors(Customizer.withDefaults())

//             .csrf(csrf -> csrf.disable())

//             .sessionManagement(sess ->
//                     sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )

//             .authorizeHttpRequests(auth -> auth
//                     .requestMatchers(
//                             "/auth/**",
//                             "/swagger-ui/**",
//                             "/v3/api-docs/**",
//                             "/status"
//                     ).permitAll()
//                     .requestMatchers("/api/**").authenticated()
//                     .anyRequest().permitAll()
//             );

//         // JWT filter
//         http.addFilterBefore(
//                 jwtFilter,
//                 UsernamePasswordAuthenticationFilter.class
//         );

//         return http.build();
//     }
// }


// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import java.util.List;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowedOrigins(List.of("*"));
//         config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//         config.setAllowedHeaders(List.of("*"));

//         UrlBasedCorsConfigurationSource source =
//                 new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", config);
//         return source;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//             .cors(Customizer.withDefaults())
//             .csrf(csrf -> csrf.disable())
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())
//             .sessionManagement(sess ->
//                     sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )
//             .authorizeHttpRequests(auth -> auth
//                     .requestMatchers(
//                             "/auth/**",
//                             "/swagger-ui/**",
//                             "/v3/api-docs/**"
//                     ).permitAll()
//                     .anyRequest().authenticated()
//             );

//         return http.build();
//     }
// }




package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   
            )
            .formLogin(form -> form.disable()); 

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
