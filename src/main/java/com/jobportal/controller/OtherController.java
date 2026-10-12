package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.FollowUs;
import com.jobportal.service.FollowService;
@RestController 
@RequestMapping ("/Other")
public class OtherController {
    private final FollowService followService;
public OtherController(FollowService followService){
    this.followService = followService;
}

@GetMapping("/By/{id}")
public List<FollowUs> getFollower(@PathVariable Long id){
    return followService.getFollower(id);
}



}
