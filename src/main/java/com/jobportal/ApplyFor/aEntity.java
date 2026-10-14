
package com.jobportal.ApplyFor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_applications")
public class aEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long candidateId;
    private Long companyId;
    private Long postId;

    private String link;

    private String status = "APPLIED";
    private String companyReply;
    private String email;

    private LocalDateTime appliedAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

  

public String getCompanyReply() {
    return companyReply;
}

public void setCompanyReply(String companyReply) {
    this.companyReply = companyReply;
}

public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
}

