package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.FollowUs;

import com.jobportal.service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowContro {

    private final FollowService followService;

    public FollowContro(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public FollowUs follow(@RequestBody FollowUs follow) {
        return followService.follow(follow);
    }

    @GetMapping
    public List<FollowUs> getFollow() {
        return followService.getFollow();
    }

   @GetMapping("/By/User/{id}")
public List<FollowUs> getFolloing(@PathVariable Long id) {
    return followService.getFollowing(id);
}

@GetMapping("/test")
public String test() {
    return "Follow API is working";
}

@PostMapping("/Demo")
 public int Demo(@RequestParam int a, @RequestParam int b)
  { return a + b; }


}  


