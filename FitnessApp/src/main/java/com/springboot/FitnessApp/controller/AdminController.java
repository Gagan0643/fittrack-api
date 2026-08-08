package com.springboot.FitnessApp.controller;

import com.springboot.FitnessApp.dto.ActivityResponseDto;
import com.springboot.FitnessApp.dto.UserResponseDto;
import com.springboot.FitnessApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers () {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityResponseDto>> getAllActivites() {
        return ResponseEntity.ok(userService.getAllActivities());
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
