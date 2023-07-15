package com.subproblem.fitnesstrackingapp.controller;

import com.subproblem.fitnesstrackingapp.dto.AuthenticationRequest;
import com.subproblem.fitnesstrackingapp.dto.RegisterRequest;
import com.subproblem.fitnesstrackingapp.repository.UserRepository;
import com.subproblem.fitnesstrackingapp.service.AuthenticationService;
import com.subproblem.fitnesstrackingapp.service.LogOutService;
import com.subproblem.fitnesstrackingapp.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final RegisterService registerService;
    private final AuthenticationService authenticationService;
    private final LogOutService logOutService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return registerService.registerUser(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut() {
        return logOutService.logOut();
    }
}
