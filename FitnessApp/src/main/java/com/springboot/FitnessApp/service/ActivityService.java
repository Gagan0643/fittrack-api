package com.springboot.FitnessApp.service;

import com.springboot.FitnessApp.dto.ActivityRequestDto;
import com.springboot.FitnessApp.dto.ActivityResponseDto;
import com.springboot.FitnessApp.entity.Activity;
import com.springboot.FitnessApp.entity.User;
import com.springboot.FitnessApp.repository.ActivityRepository;
import com.springboot.FitnessApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ActivityResponseDto trackActivity(ActivityRequestDto addActivityDto) {
        User user = userRepository.findById(addActivityDto.getUserId()).orElseThrow();

        Activity activity = Activity.builder()
                .type(addActivityDto.getType())
                .user(user)//setting fetched user(by userRepository.findById()) to user field in activity
                .additionalMetrics(addActivityDto.getAdditionalMetrics())
                .duration(addActivityDto.getDuration())
                .caloriesBurned(addActivityDto.getCaloriesBurned())
                .startTime(addActivityDto.getStartTime())
                .build();


        return modelMapper.map(activityRepository.save(activity), ActivityResponseDto.class);
    }

    public List<ActivityResponseDto> retrieveUserActivity(String id) {

        List<Activity> activities = activityRepository.findByUserId(id);

        return activities.stream()
                .map(activity -> modelMapper.map(activity, ActivityResponseDto.class))
                .toList();
    }
}
