package com.subproblem.fitnesstrackingapp.repository;

import com.subproblem.fitnesstrackingapp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByCode(Integer code);
}
