package com.jobportal.JobApply;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name ="Job")  
public class jEntity {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String title;
   @Column(length = 2000)
    private String description;
    private String companyName;
    private String location;
    private String jobType;
    private Integer salaryMin;
    private Integer salaryMax;
    private String skillsRequired;
    private LocalDateTime createdAt;
    private Long companyId;

public Long getCompanyId() {
    return companyId;
}

public void setCompanyId(Long companyId) {
    this.companyId = companyId;
}


      @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
