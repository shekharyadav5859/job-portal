
package com.jobportal.Authentiction;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final Login log;

    public AuthController(AuthService authService ,Login log) {
        this.authService = authService;
        this.log = log;
    }

    // 1. OTP send API
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(
            @RequestParam String email) {

        authService.generateAndSendOtp(email);

        return ResponseEntity.ok("OTP sent to email");
    }

    // 2. OTP verify  data save 
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(
            @RequestBody VerifyOtpRequest request) {

        try {
            AuthEntity auth = new AuthEntity();
            auth.setEmail(request.getEmail());
            auth.setPassword(request.getPassword());

            AuthEntity saved = authService.verifyOtpAndSave(
                    auth, request.getOtp());

            return ResponseEntity.ok(
                    "OTP verified and user registered. ID: "
                    + saved.getId());

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // OTP verification request data
    public static class VerifyOtpRequest {
        private String email;
        private String password;
        private String otp;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }
    }

    
@GetMapping("/users")
public List<AuthEntity> getAllUsers() {
    return authService.getAllUsers();
}




//Login

@PostMapping("/Login")
public String login(@RequestBody LoginRequest request) {

    boolean result = log.Check(
        request.getEmail(),
        request.getPassword()
    );

    if (result) {
        return "Login successful";
    }

    return "Invalid email or password";
}



 

}
