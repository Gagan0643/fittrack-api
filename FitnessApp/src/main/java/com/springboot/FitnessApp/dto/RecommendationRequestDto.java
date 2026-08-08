package com.springboot.FitnessApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.FitnessApp.entity.Activity;
import com.springboot.FitnessApp.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendationRequestDto {

    private String type;

    private String recommendation;

    private List<String> improvements;

    private List<String> suggestions;

    private List<String> safety;

    private LocalDateTime createdAt;

    private String userId;

    private String activityId;

}
