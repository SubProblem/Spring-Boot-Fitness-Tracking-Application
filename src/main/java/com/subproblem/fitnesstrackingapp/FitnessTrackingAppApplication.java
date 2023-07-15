package com.subproblem.fitnesstrackingapp;

import com.subproblem.fitnesstrackingapp.dto.RegisterRequest;
import com.subproblem.fitnesstrackingapp.entity.Role;
import com.subproblem.fitnesstrackingapp.entity.User;
import com.subproblem.fitnesstrackingapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static com.subproblem.fitnesstrackingapp.entity.Role.ADMIN;

@SpringBootApplication
public class FitnessTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessTrackingAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//		return args -> {
//
//			var admin = User.builder()
//					.firstname("admin")
//					.lastname("admin")
//					.email("admin@mail.com")
//					.password(passwordEncoder.encode("admin"))
//					.role(ADMIN)
//					.build();
//
//			userRepository.save(admin);
//
//		};
//	}
}
