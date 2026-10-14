package com.jobportal.Follow;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class fService {

    private final fRepository fRepo;

    public fService(fRepository fRepo) {
        this.fRepo = fRepo;
    }

    // Follow a user
    public fEntity follow(fEntity follow) {

        if (follow.getFollower() == null ||
            follow.getFollowing() == null) {
            throw new RuntimeException("Follower and following IDs are required");
        }

        if (follow.getFollower().equals(follow.getFollowing())) {
            throw new RuntimeException("You cannot follow yourself");
        }

        boolean alreadyFollowing = fRepo
                .findByFollower(follow.getFollower())
                .stream()
                .anyMatch(f ->
                    f.getFollowing().equals(follow.getFollowing()));

        if (alreadyFollowing) {
            throw new RuntimeException("Already following this user");
        }

        return fRepo.save(follow);
    }

    // Get all follow records
    public List<fEntity> getAllFollow() {
        return fRepo.findAll();
    }

    // Get users followed by a particular user
    public List<fEntity> getFollowing(Long userId) {
        return fRepo.findByFollower(userId);
    }

    // Get users who follow a particular user
    public List<fEntity> getFollowers(Long userId) {
        return fRepo.findByFollowing(userId);
    }

    // Unfollow
    public void unfollow(Long id) {
        if (!fRepo.existsById(id)) {
            throw new RuntimeException("Follow record not found");
        }

        fRepo.deleteById(id);
    }
}