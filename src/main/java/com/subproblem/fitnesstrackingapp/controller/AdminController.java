package com.subproblem.fitnesstrackingapp.controller;


import com.subproblem.fitnesstrackingapp.dto.ProductRequest;
import com.subproblem.fitnesstrackingapp.dto.ProductResponse;
import com.subproblem.fitnesstrackingapp.dto.UserResponse;
import com.subproblem.fitnesstrackingapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/secured/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public List<UserResponse> getAllUsersInfo() {
        return adminService.getAllUserInfo();
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest request) {
        return adminService.addProduct(request);
    }

    @GetMapping("/product")
    public List<ProductResponse> getAllProducts() {
        return adminService.getAllProduct();
    }

    @PostMapping("/product/image/{code}")
    public ResponseEntity<?> addProduct(@RequestParam("image") MultipartFile image,
                                        @PathVariable("code") Integer code) throws IOException {
        return adminService.addImageOfProduct(image, code);
    }

    @DeleteMapping("/product/{code}")
    public ResponseEntity<?> deleteProduct(@PathVariable("code") Integer code) {
        return adminService.deleteProduct(code);
    }

}
