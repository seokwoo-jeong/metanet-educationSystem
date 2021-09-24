package com.metanet.educationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude= {MultipartAutoConfiguration.class})
public class EducationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationSystemApplication.class, args);
	}

}
