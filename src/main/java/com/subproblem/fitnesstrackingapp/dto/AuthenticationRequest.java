package com.subproblem.fitnesstrackingapp.dto;

public record AuthenticationRequest(
        String email,
        String password
) {
}
