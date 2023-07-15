package com.subproblem.fitnesstrackingapp.service;

import com.subproblem.fitnesstrackingapp.dto.ProductRequest;
import com.subproblem.fitnesstrackingapp.dto.ProductResponse;
import com.subproblem.fitnesstrackingapp.dto.UserResponse;
import com.subproblem.fitnesstrackingapp.entity.Product;
import com.subproblem.fitnesstrackingapp.repository.PerformanceMetricsRepository;
import com.subproblem.fitnesstrackingapp.repository.ProductRepository;
import com.subproblem.fitnesstrackingapp.repository.UserRepository;
import com.subproblem.fitnesstrackingapp.repository.WorkoutRepository;
import com.subproblem.fitnesstrackingapp.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final Convertor convertor;
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;
    private final PerformanceMetricsRepository performanceMetricsRepository;
    private final ProductRepository productRepository;
    public List<UserResponse> getAllUserInfo() {

        var users = userRepository.findAll();

        return convertor.userMapper(users);
    }

    public List<ProductResponse> getAllProduct() {

        var products = productRepository.findAll();

        return convertor.productMapper(products);
    }



    public ResponseEntity<?> addImageOfProduct(MultipartFile image, Integer code) throws IOException {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("Image is empty");
        }

        var product = productRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        product.setImage(image.getBytes());

        productRepository.save(product);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity<?> addProduct(ProductRequest request) {
        var product = productRepository.findByCode(request.code());
        if (product.isPresent()) {
            throw new IllegalStateException("Product already exists");
        }

        var newProduct = Product.builder()
                .description(request.description())
                .name(request.name())
                .calories(request.calories())
                .protein(request.protein())
                .carbs(request.carbs())
                .fat(request.fat())
                .code(request.code())
                .build();

        productRepository.save(newProduct);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteProduct(Integer code) {
        var product = productRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("Product does not exist"));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
