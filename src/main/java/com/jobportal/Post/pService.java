package com.jobportal.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service 
public class pService {
    private final pRepository  pRepo;
    public pService (pRepository pRepo){
        this.pRepo = pRepo;
    }
    

    //save
    public pEntity PostSave(pEntity post){
        return pRepo.save(post);
    }

      // Get All Posts
    public List<pEntity> getAllPosts() {
        return pRepo.findAll();
    }

      // Get Post By ID
    public Optional<pEntity> getPostById(Long id) {
        return pRepo.findById(id);
    }

    // Delete Post
    public void deletePost(Long id) {
        pRepo.deleteById(id);
    }

    //Post by UserId
    public List<pEntity> getPostsByUserId(Long userId ) {
    return pRepo.findByUserId(userId);
}
//
public List<pEntity> getNextPosts(Long lastId ,int limit) {

    List<pEntity> allPosts = pRepo.findAll();

    allPosts.sort(
        (a, b) -> a.getId().compareTo(b.getId())
    );

    List<pEntity> result = new ArrayList<>();

    for (pEntity post : allPosts) {

        if (post.getId() > lastId) {
            result.add(post);
        }

        if (result.size() >= limit) {
            break;
        }
    }

    return result;
}



}
