
package com.jobportal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return """
            <html>
                <head>
                    <title>Job Portal</title>
                </head>
                <body style="font-family: Arial; text-align: center; padding: 60px;">
                    <h1>Welcome to Job Portal</h1>
                    <p>Your career journey starts here.</p>
                    <p>Spring Boot REST API is running.</p>
                    <a href="/about-user">View User Profiles</a>
                    <br><br>
                    <a href="/Post/get">View Posts</a>
                    <br><br>
                    <a href="/Job/Company/get">View Jobs</a>
                </body>
            </html>
            """;
    }
}

