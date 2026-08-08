package com.springboot.FitnessApp.controller;

import com.springboot.FitnessApp.dto.*;
import com.springboot.FitnessApp.security.AuthService;
import com.springboot.FitnessApp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid  @RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.login(loginRequestDto));
    }


}
