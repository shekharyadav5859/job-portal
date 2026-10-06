package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jobportal.entity.UserEntity;
import com.jobportal.service.UserService;

@RestController 
@RequestMapping("/users") 
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

        @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping 
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }

   @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        System.out.print(id);
        return "Delete This User";
    }

  @PutMapping("/{id}")
public UserEntity updateUser(
        @PathVariable Long id,
        @RequestBody UserEntity user) {

    return userService.updateUser(id, user);
}
}

