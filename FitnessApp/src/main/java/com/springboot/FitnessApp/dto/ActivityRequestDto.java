package com.springboot.FitnessApp.dto;

import com.springboot.FitnessApp.entity.type.ActivityType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequestDto {

    private String userId;

    private ActivityType type;

    private Map<String, Object> additionalMetrics;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

}
