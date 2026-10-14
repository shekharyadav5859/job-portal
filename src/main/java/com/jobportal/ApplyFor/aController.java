
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

    // Candidate applies 
    @PostMapping
    public aEntity apply(@RequestBody aEntity application) {
        return aServ.apply(application);
    }

    // Get all applications
    @GetMapping
    public List<aEntity> getAllApplications() {
        return aServ.getAllApplications();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public aEntity getApplicationById(@PathVariable Long id) {
        return aServ.getApplicationById(id);
    }
//compan  replay
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
