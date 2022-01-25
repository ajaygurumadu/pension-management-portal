package com.pensionmanagement.pensioner.detail.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PensionerDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailServiceApplication.class, args);
	}
	

}
