package com.springboot.FitnessApp.security;

import com.springboot.FitnessApp.dto.LoginRequestDto;
import com.springboot.FitnessApp.dto.LoginResponseDto;
import com.springboot.FitnessApp.dto.RegisterRequestDto;
import com.springboot.FitnessApp.dto.RegisterResponseDto;
import com.springboot.FitnessApp.entity.User;
import com.springboot.FitnessApp.entity.type.Roles;
import com.springboot.FitnessApp.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegisterResponseDto register(RegisterRequestDto registerRequestDto){

        User user = userRepository.findByUsername(registerRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User already exists");

        user = userRepository.save(User.builder()
                        .email(registerRequestDto.getEmail())
                        .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                        .username(registerRequestDto.getUsername())
                        .roles(registerRequestDto.getRoles())
                        .build()
                );

        return new RegisterResponseDto(user.getEmail(), user.getUsername());
    }


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

       User user = (User) authentication.getPrincipal();

       String token = authUtil.generateStringToken(user);

       return new LoginResponseDto(user.getId(), token);
    }


}
