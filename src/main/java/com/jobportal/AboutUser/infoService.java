package com.jobportal.AboutUser;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class infoService {

    private final infoRepository infoRepo;

    public infoService(infoRepository infoRepo) {
        this.infoRepo = infoRepo;
    }

    // Create profile
    public infoEntity createInfo(infoEntity info) {
        return infoRepo.save(info);
    }

    // Get all profiles
    public List<infoEntity> getAllInfo() {
        return infoRepo.findAll();
    }

    // Get profile by ID
    public infoEntity getInfoById(Long id) {
        return infoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    // Update profile
    public infoEntity updateInfo(Long id, infoEntity info) {
        infoEntity existingInfo = getInfoById(id);

        existingInfo.setUserId(info.getUserId());
        existingInfo.setAbout(info.getAbout());
        existingInfo.setEducation(info.getEducation());
        existingInfo.setExperience(info.getExperience());
        existingInfo.setSkills(info.getSkills());
        existingInfo.setLocation(info.getLocation());

        return infoRepo.save(existingInfo);
    }

    // Delete profile
    public void deleteInfo(Long id) {
        if (!infoRepo.existsById(id)) {
            throw new RuntimeException("Profile not found");
        }

        infoRepo.deleteById(id);
    }
}
