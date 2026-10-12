package com.jobportal.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface pRepository extends JpaRepository<pEntity,Long>  {

     List<pEntity> findByUserId(Long userId);
} 
