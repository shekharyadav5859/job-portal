package com.jobportal.Authentiction;

import org.springframework.stereotype.Service;

@Service 
public class Login {
    private final  AuthRepository aRepo;
    
    public Login(AuthRepository aRepo){
        this.aRepo = aRepo;
        
    }
//email and pass
   public boolean Check(String email, String pass) {
    AuthEntity user = aRepo.findByEmail(email).orElse(null);
    if (user == null) {
        return false;
    }
   return user.getPassword().equals(pass);
}



    
}
