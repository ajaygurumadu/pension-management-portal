package com.pensionmanagement.processpension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.Generated;

@SpringBootApplication
@EnableEurekaClient 
@Generated
public class ProcessPensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	
	

}
