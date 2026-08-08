package com.springboot.FitnessApp.repository;

import com.springboot.FitnessApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByUsername(String username);

}