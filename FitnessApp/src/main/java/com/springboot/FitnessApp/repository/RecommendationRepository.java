package com.springboot.FitnessApp.repository;

import com.springboot.FitnessApp.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
    List<Recommendation> findByUserId(String id);

    List<Recommendation> findByActivityId(String activityId);
}