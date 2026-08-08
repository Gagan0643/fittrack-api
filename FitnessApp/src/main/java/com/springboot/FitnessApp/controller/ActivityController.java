package com.springboot.FitnessApp.controller;

import com.springboot.FitnessApp.dto.ActivityRequestDto;
import com.springboot.FitnessApp.dto.ActivityResponseDto;
import com.springboot.FitnessApp.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/track")
    public ResponseEntity<ActivityResponseDto> trackActivity(@RequestBody ActivityRequestDto activityRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.trackActivity(activityRequestDto));
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<ActivityResponseDto>> retrieveActivity(@RequestHeader("X-UserId") String id) {
        return ResponseEntity.ok(activityService.retrieveUserActivity(id));
    }
}
