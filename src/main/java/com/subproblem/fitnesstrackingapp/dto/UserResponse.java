package com.subproblem.fitnesstrackingapp.dto;

import jakarta.annotation.Nullable;

import java.util.List;

public record UserResponse(
        String firstname,
        String lastname,
        String email,

        List<WorkoutResponse> workouts,
        List<ProductResponse> products
) {
}
