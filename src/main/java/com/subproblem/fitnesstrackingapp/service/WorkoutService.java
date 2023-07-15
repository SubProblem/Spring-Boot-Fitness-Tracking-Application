package com.subproblem.fitnesstrackingapp.service;

import com.subproblem.fitnesstrackingapp.dto.WorkoutResponse;
import com.subproblem.fitnesstrackingapp.entity.PerformanceMetrics;
import com.subproblem.fitnesstrackingapp.entity.User;
import com.subproblem.fitnesstrackingapp.entity.Workout;
import com.subproblem.fitnesstrackingapp.repository.PerformanceMetricsRepository;
import com.subproblem.fitnesstrackingapp.repository.UserRepository;
import com.subproblem.fitnesstrackingapp.repository.WorkoutRepository;
import com.subproblem.fitnesstrackingapp.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor

@Service
public class WorkoutService {

    private final Convertor convertor;
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;
    private final PerformanceMetricsRepository performanceMetricsRepository;

    public ResponseEntity<?> addWorkout(Authentication authentication, WorkoutResponse workout) {

        var user = (User) authentication.getPrincipal();

        workoutRepository.findByworkoutDate(workout.workoutDate()).
                ifPresent(e -> {
                    throw new IllegalStateException("Workout already exists");
                });

        var performanceMetrics = workout.performanceMetricsResponse();

        var newPerformanceMetrics = PerformanceMetrics.builder()
                .caloriesBurned(performanceMetrics.caloriesBurned())
                .duration(performanceMetrics.duration())
                .intensity(performanceMetrics.intensity())
                .build();
        performanceMetricsRepository.save(newPerformanceMetrics);


        var newWorkout = Workout.builder()
                .workoutDate(workout.workoutDate())
                .exerciseType(workout.exerciseType())
                .build();

        newWorkout.setPerformanceMetrics(newPerformanceMetrics);

        workoutRepository.save(newWorkout);

        user.getWorkouts().add(newWorkout);

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteWorkout(String id) {

        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var workout = workoutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Workout does not exist"));

        workoutRepository.delete(workout);

        user.getWorkouts().remove(workout);

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
