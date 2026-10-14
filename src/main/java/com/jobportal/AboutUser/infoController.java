package com.jobportal.AboutUser;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about-user")
public class infoController {

    private final infoService infoServ;

    public infoController(infoService infoServ) {
        this.infoServ = infoServ;
    }

    // Create profile
    @PostMapping
    public infoEntity createInfo(@RequestBody infoEntity info) {
        return infoServ.createInfo(info);
    }

    // Get all profiles
    @GetMapping
    public List<infoEntity> getAllInfo() {
        return infoServ.getAllInfo();
    }

    // Get profile by ID
    @GetMapping("/{id}")
    public infoEntity getInfoById(@PathVariable Long id) {
        return infoServ.getInfoById(id);
    }

    // Update profile
    @PutMapping("/{id}")
    public infoEntity updateInfo(
            @PathVariable Long id,
            @RequestBody infoEntity info) {
        return infoServ.updateInfo(id, info);
    }

    // Delete profile
    @DeleteMapping("/{id}")
    public String deleteInfo(@PathVariable Long id) {
        infoServ.deleteInfo(id);
        return "Profile deleted successfully";
    }
}
