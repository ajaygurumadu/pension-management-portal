package com.pensionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient 
public class AuthenticationService {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationService.class, args);
	}
}