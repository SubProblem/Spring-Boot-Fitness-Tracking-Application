package com.subproblem.fitnesstrackingapp.service;

import com.subproblem.fitnesstrackingapp.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogOutService {

    private final JwtService jwtService;

    public ResponseEntity<?> logOut() {
        ResponseCookie cookie = jwtService.generateEmptyJwtCookie();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("Signed Out Successfully");
    }
}
