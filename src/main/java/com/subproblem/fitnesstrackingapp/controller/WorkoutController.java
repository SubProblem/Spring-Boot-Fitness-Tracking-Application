package com.subproblem.fitnesstrackingapp.controller;

import com.subproblem.fitnesstrackingapp.dto.WorkoutResponse;
import com.subproblem.fitnesstrackingapp.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/secured/user/workout")
public class WorkoutController {


    private final WorkoutService workoutService;


    @PostMapping
    public ResponseEntity<?> addWorkout(@RequestBody WorkoutResponse workout, Authentication authentication) {
        return workoutService.addWorkout(authentication, workout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkout(@PathVariable("id") String id) {
        return workoutService.deleteWorkout(id);
    }
}
