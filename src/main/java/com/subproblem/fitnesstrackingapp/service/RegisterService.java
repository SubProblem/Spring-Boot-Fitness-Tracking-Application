package com.subproblem.fitnesstrackingapp.service;

import com.subproblem.fitnesstrackingapp.dto.RegisterRequest;
import com.subproblem.fitnesstrackingapp.entity.Role;
import com.subproblem.fitnesstrackingapp.entity.User;
import com.subproblem.fitnesstrackingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.subproblem.fitnesstrackingapp.entity.Role.USER;

@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public ResponseEntity<?> registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .password(passwordEncoder.encode(request.password()))
                .role(USER)
                .build();

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
