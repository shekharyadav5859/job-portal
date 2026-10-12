package com.jobportal.JobApply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface jRepo extends JpaRepository<jEntity ,Long> {

   List<jEntity> findByCompanyId(Long companyId);
} 
