package com.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.entity.FollowUs;
import com.jobportal.repository.FollowRepo;

@Service
public class FollowService {

    public final FollowRepo followRepo;
 
    public FollowService(FollowRepo followRepo) {
        this.followRepo = followRepo;
    }

    public FollowUs follow(FollowUs follow) {
        return followRepo.save(follow);
    }

//get
    public List<FollowUs> getFollow(){
        return followRepo.findAll();
    }

//getFollwingData

public List<FollowUs> getFollowing(Long follower) {
    return followRepo.findByFollower(follower);
}

//getOtherData
public List<FollowUs> getFollower(Long follower){
    return followRepo.findByFollowing(follower);
}


}
 