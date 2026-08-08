package com.springboot.FitnessApp.service;

import com.springboot.FitnessApp.dto.ActivityResponseDto;
import com.springboot.FitnessApp.dto.RegisterRequestDto;
import com.springboot.FitnessApp.dto.RegisterResponseDto;
import com.springboot.FitnessApp.dto.UserResponseDto;
import com.springboot.FitnessApp.entity.Activity;
import com.springboot.FitnessApp.entity.User;
import com.springboot.FitnessApp.repository.ActivityRepository;
import com.springboot.FitnessApp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;


    public void deleteUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid user Id"));
        userRepository.delete(user);
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    public List<ActivityResponseDto> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();

        return activities.stream()
                .map(activity -> modelMapper.map(activity, ActivityResponseDto.class))
                .toList();
    }
}
