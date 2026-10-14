
package com.jobportal.ApplyFor;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class aService {

    private final aRepository aRepo;

    public aService(aRepository aRepo) {
        this.aRepo = aRepo;
    }

    // CandidateApplies
    public aEntity apply(aEntity application) {
        return aRepo.save(application);
    }

    // Get all applications
    public List<aEntity> getAllApplications() {
        return aRepo.findAll();
    }

    // Get application by ID
    public aEntity getApplicationById(Long id) {
        return aRepo.findById(id).orElse(null);
    }
//company reply
    public aEntity replyToApplication(
        Long applicationId,
        String status,
        String companyReply) {

    aEntity application = aRepo.findById(applicationId)
            .orElseThrow(() ->
                new RuntimeException("Application not found"));

    application.setStatus(status);
    application.setCompanyReply(companyReply);

    return aRepo.save(application);
}
}

