package com.foxder.project.REST_APIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class RestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApIsApplication.class, args);
	}

}
