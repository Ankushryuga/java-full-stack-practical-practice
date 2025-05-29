package com.rest_microservice.rest_microservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf->csrf.disable()) // disable CSRF for testing; enable in production with proper config
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/user/register").permitAll() // allow open access
//                        .requestMatchers("/user/login").permitAll()
//                        .requestMatchers("/user/**").permitAll()
//                        .anyRequest().authenticated() // protect other endpoints
//                );

        http.csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth->auth.anyRequest().permitAll());
        return http.build();
    }
}
