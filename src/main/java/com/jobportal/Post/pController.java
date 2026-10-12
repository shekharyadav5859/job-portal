
package com.jobportal.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Post")
public class pController {

    private final pService pServ;

    public pController(pService pServ) {
        this.pServ = pServ;
    }

    // Get All Posts
    @GetMapping("/get")
    public List<pEntity> getAllPost() {
        return pServ.getAllPosts();
    }

    // Get Post By ID
    @GetMapping("/get/{id}")
    public Optional<pEntity> getById(@PathVariable Long id) {
        return pServ.getPostById(id);
    }
//save
   @PostMapping("/save")
public pEntity PostData(@RequestBody pEntity post) {
    return pServ.PostSave(post);
}

    // Delete Post By ID
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        pServ.deletePost(id);
    }

    //getuserpost
    @GetMapping("/user/{userId}")
public List<pEntity> getPostsByUserId(@PathVariable Long userId) {
    return pServ.getPostsByUserId(userId);
}

//getInfnigth
@GetMapping("/main")
public List<pEntity> getNextPosts(
        @RequestParam(defaultValue = "0") Long lastId,
        @RequestParam(defaultValue = "10") int limit)
     {

    return pServ.getNextPosts( lastId ,limit);
} 
}

