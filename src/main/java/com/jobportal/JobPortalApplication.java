package com.jobportal;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class JobPortalApplication {

	public static void main(String[] args) {
       Dotenv dotenv = Dotenv.load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

		SpringApplication.run(JobPortalApplication.class, args);
		System.out.println("hello Spring");
		System.out.print(5+6);
		System.out.print("hello Spring");
	}

}
