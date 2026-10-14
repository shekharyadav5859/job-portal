package com.jobportal.Follow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface fRepository extends JpaRepository<fEntity, Long> {

    List<fEntity> findByFollower(Long follower);

    List<fEntity> findByFollowing(Long following);
}
