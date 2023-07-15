package com.subproblem.fitnesstrackingapp.dto;

import java.time.LocalDate;

public record WorkoutResponse(
        String id,
        LocalDate workoutDate,
        String exerciseType,
        PerformanceMetricsResponse performanceMetricsResponse
) {
}
