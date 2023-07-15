package com.subproblem.fitnesstrackingapp.controller;

import com.subproblem.fitnesstrackingapp.dto.ProductResponse;
import com.subproblem.fitnesstrackingapp.dto.UserCredentials;
import com.subproblem.fitnesstrackingapp.dto.UserResponse;
import com.subproblem.fitnesstrackingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/secured/user")
public class UserController {

    private final UserService userService;


    @GetMapping
    public UserResponse getUserInfo(Authentication authentication) {
        return userService.getUserInfo(authentication);
    }

    @GetMapping("/credentials")
    public UserCredentials getUserCredentialsOnly(Authentication authentication) {
        return userService.getUserCredentialsOnly(authentication);
    }

    @GetMapping("/products")
    public List<ProductResponse> getUsersProducts(Authentication authentication) {
        return userService.getUsersProducts(authentication);
    }

    @PostMapping("/products/{code}")
    public ResponseEntity<?> addProduct(@PathVariable("code") Integer code, Authentication authentication) {
        return userService.addProduct(authentication, code);
    }
}
