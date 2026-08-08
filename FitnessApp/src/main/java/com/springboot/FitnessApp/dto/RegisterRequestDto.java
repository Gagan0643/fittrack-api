package com.springboot.FitnessApp.dto;

import com.springboot.FitnessApp.entity.type.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {

    @NotNull
    @Email(message = "Not a valid email")
    private String email;

    @Size(min = 6, message = "password must be length of 6 at least")
    private String password;

    private String username;

    private Set<Roles> roles = new HashSet<>();
}
