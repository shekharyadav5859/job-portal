
package com.jobportal.ApplyFor;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class aController {

    private final aService aServ;

    public aController(aService aServ) {
        this.aServ = aServ;
    }

    // CandidatApplies 
    @PostMapping
    public aEntity apply(@RequestBody aEntity application) {
        return aServ.apply(application);
    }

    // GetAllApplications
    @GetMapping
    public List<aEntity> getAllApplications() {
        return aServ.getAllApplications();
    }

    // GetApplicationByID
    @GetMapping("/{id}")
    public aEntity getApplicationById(@PathVariable Long id) {
        return aServ.getApplicationById(id);
    }
//companReplay
    @PutMapping("/{id}/reply")
public aEntity replyToApplication(
        @PathVariable Long id,
        @RequestBody aEntity request) {

    return aServ.replyToApplication(
            id,
            request.getStatus(),
            request.getCompanyReply()
    );
}
}
