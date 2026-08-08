package com.springboot.FitnessApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserResponseDto {
    private String Id;

    private String email;

    private String username;
}
