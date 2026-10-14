

package com.jobportal.Authentiction;

import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository aRepo;
    private final EmailService emailService;
 

   

    private final Map<String, String> otpStore = new ConcurrentHashMap<>();

    public AuthService(AuthRepository aRepo, EmailService emailService) {
        this.aRepo = aRepo;
        this.emailService = emailService;
    }

    // 1. OTP generate  email send
    public String generateAndSendOtp(String email) {

        String otp = String.valueOf(100000 + new SecureRandom().nextInt(900000));

        otpStore.put(email, otp);

        emailService.sendOtp(email, otp);

        return otp;
    }

    // 2. OTP verify  data save
    public AuthEntity verifyOtpAndSave(AuthEntity auth,
                                       String otp) {

        String savedOtp = otpStore.get(auth.getEmail());

        if (savedOtp == null || !savedOtp.equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        if (aRepo.existsByEmail(auth.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // OTP 
        auth.setVerify(true);

        AuthEntity saved = aRepo.save(auth);

        otpStore.remove(auth.getEmail());

        return saved;
    }

    //getuser
 public List<AuthEntity> getAllUsers() {
        return aRepo.findAll();
    }

    //LoginSystem 
    
    
}
