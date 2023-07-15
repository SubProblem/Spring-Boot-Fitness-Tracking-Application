package com.subproblem.fitnesstrackingapp.config;


import com.subproblem.fitnesstrackingapp.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.subproblem.fitnesstrackingapp.entity.Permission.*;
import static com.subproblem.fitnesstrackingapp.entity.Role.ADMIN;
import static com.subproblem.fitnesstrackingapp.entity.Role.USER;

@RequiredArgsConstructor

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                                auth.requestMatchers("/api/v1/auth/**").permitAll()

                                        .requestMatchers("/api/v1/secured/user/**").hasAnyRole(USER.name())
                                        .requestMatchers(HttpMethod.GET, "/api/v1/secured/user/**").hasAuthority(USER_READ.name())
                                        .requestMatchers(HttpMethod.POST, "/api/v1/secured/user/**").hasAuthority(USER_CREATE.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/v1/secured/user/**").hasAuthority(USER_DELETE.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/v1/secured/user/**").hasAuthority(USER_UPDATE.name())

                                        .requestMatchers("/api/v1/secured/admin/**").hasRole(ADMIN.name())
                                        .requestMatchers(HttpMethod.GET, "/api/v1/secured/admin/**").hasAuthority(ADMIN_READ.name())
                                        .requestMatchers(HttpMethod.POST, "/api/v1/secured/admin/**").hasAuthority(ADMIN_CREATE.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/v1/secured/admin/**").hasAuthority(ADMIN_DELETE.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/v1/secured/admin/**").hasAuthority(ADMIN_UPDATE.name())
                                        .anyRequest()
                                        .authenticated()
                        )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
