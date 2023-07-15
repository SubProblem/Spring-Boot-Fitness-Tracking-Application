package com.subproblem.fitnesstrackingapp.repository;

import com.subproblem.fitnesstrackingapp.entity.PerformanceMetrics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerformanceMetricsRepository extends MongoRepository<PerformanceMetrics, String> {
}
