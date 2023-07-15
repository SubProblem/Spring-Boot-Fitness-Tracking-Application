package com.subproblem.fitnesstrackingapp.dto;

import java.time.LocalDate;

public record UserCredentials(
        String firstname,
        String lastname,
        String email,
        LocalDate dateOfBirth
) {
}
