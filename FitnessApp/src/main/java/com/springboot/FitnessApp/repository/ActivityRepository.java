package com.springboot.FitnessApp.repository;

import com.springboot.FitnessApp.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, String> {

    List<Activity> findByUserId(String id);
}