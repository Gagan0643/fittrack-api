package com.springboot.FitnessApp.service;

import com.springboot.FitnessApp.dto.RecommendationRequestDto;
import com.springboot.FitnessApp.dto.RecommendationResponseDto;
import com.springboot.FitnessApp.entity.Activity;
import com.springboot.FitnessApp.entity.Recommendation;
import com.springboot.FitnessApp.entity.User;
import com.springboot.FitnessApp.repository.ActivityRepository;
import com.springboot.FitnessApp.repository.RecommendationRepository;
import com.springboot.FitnessApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;
    private final ModelMapper modelMapper;

    public RecommendationResponseDto generateRecommendation(RecommendationRequestDto recommendationRequestDto) {
        User user = userRepository.findById(recommendationRequestDto.getUserId())
                .orElseThrow(()-> new RuntimeException("Invalid UserId"+ recommendationRequestDto.getUserId()));

        Activity activity = activityRepository.findById(recommendationRequestDto.getActivityId()).orElseThrow(()-> new RuntimeException("Invalid ActivityId"+ recommendationRequestDto.getActivityId()));

            Recommendation recommendation = Recommendation.builder()
                    .type(recommendationRequestDto.getType())
                    .recommendation(recommendationRequestDto.getRecommendation())
                    .improvements(recommendationRequestDto.getImprovements())
                    .suggestions(recommendationRequestDto.getSuggestions())
                    .safety(recommendationRequestDto.getSafety())
                    .createdAt(recommendationRequestDto.getCreatedAt())
                    .user(user)//setting fetched user(by userRepository.findById() ) to user field in recommendation
                    .activity(activity)//setting fetched activity(by activityRepository.findById() ) to activity field in recommendation
                    .build();

            return modelMapper.map(recommendationRepository.save(recommendation), RecommendationResponseDto.class);
    }


    public List<RecommendationResponseDto> getAllUserRecommendations(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("Invalid user: "+ userId));

        List<Recommendation> recommendations = recommendationRepository.findByUserId(userId);

        return recommendations.stream()
                .map(recommendation -> modelMapper.map(recommendation, RecommendationResponseDto.class))
                .toList();
    }

    public List<RecommendationResponseDto> getAllActivityRecommendations(String activityId) {
        Activity activity = activityRepository.findById(activityId).orElseThrow(()->new IllegalArgumentException("Invalid activity: "+ activityId));

        List<Recommendation> recommendations = recommendationRepository.findByActivityId(activityId);

        return recommendations.stream()
                .map(recommendation -> modelMapper.map(recommendation, RecommendationResponseDto.class))
                .toList();
    }
}
