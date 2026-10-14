package com.jobportal.Follow;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class fController {

    private final fService fServ;

    public fController(fService fServ) {
        this.fServ = fServ;
    }

    // Follow a user
    @PostMapping
    public fEntity follow(@RequestBody fEntity follow) {
        return fServ.follow(follow);
    }

    // Get all follow records
    @GetMapping
    public List<fEntity> getAllFollow() {
        return fServ.getAllFollow();
    }

    // Get users followed by a particular user
    @GetMapping("/following/{id}")
    public List<fEntity> getFollowing(@PathVariable Long id) {
        return fServ.getFollowing(id);
    }

    // Get followers of a particular user
    @GetMapping("/followers/{id}")
    public List<fEntity> getFollowers(@PathVariable Long id) {
        return fServ.getFollowers(id);
    }

    // Unfollow
    @DeleteMapping("/{id}")
    public String unfollow(@PathVariable Long id) {
        fServ.unfollow(id);
        return "Unfollow successful";
    }

   

    
}