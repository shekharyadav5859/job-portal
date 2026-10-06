package com.jobportal.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.entity.UserEntity;
import com.jobportal.repository.UserRepository;

@Service 
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //save
    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }
//getAllUser
    public List<UserEntity> getAllUser(){
    return userRepository.findAll();
    }

//DeletOneUser
public void deleteUser(Long id){
    userRepository.deleteById(id);
}

//UserUpdata

public UserEntity updateUser(Long id, UserEntity user) {

    UserEntity existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());
    existingUser.setPhona(user.getPhona());
    existingUser.setRole(user.getRole());
    existingUser.setLocation(user.getLocation());
    existingUser.setAbout(user.getAbout());
    existingUser.setEducation(user.getEducation());
    existingUser.setExperience(user.getExperience());
    existingUser.setSkills(user.getSkills());

    return userRepository.save(existingUser);
}

}
