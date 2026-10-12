package com.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.FollowUs;

public interface FollowRepo extends JpaRepository<FollowUs ,Long> {

      List<FollowUs> findByFollower(Long follower);
      List<FollowUs> findByFollowing(Long follower);
} 
