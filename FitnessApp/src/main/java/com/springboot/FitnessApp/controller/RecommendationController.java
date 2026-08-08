package com.springboot.FitnessApp.controller;

import com.springboot.FitnessApp.dto.RecommendationRequestDto;
import com.springboot.FitnessApp.dto.RecommendationResponseDto;
import com.springboot.FitnessApp.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/track")
    public ResponseEntity<RecommendationResponseDto> generateRecommendation(@RequestBody RecommendationRequestDto reRecommendationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recommendationService.generateRecommendation(reRecommendationRequestDto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponseDto>> getAllUserRecommendations(@PathVariable String userId) {
        return ResponseEntity.ok(recommendationService.getAllUserRecommendations(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponseDto>> getAllActivityRecommendations(@PathVariable String activityId) {
        return ResponseEntity.ok(recommendationService.getAllActivityRecommendations(activityId));
    }

}
