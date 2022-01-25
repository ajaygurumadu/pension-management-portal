package com.pensionmanagement.cloud.gateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FallBackMethodController {

	@GetMapping("/pensionerServiceFallBack")
	public String userServiceFallBackMethod()
	{
		return "Pensioner Service is taking longer than Expected."+" Please try again later";
	}
	
	@GetMapping("/processPensionerServiceFallBack")
	public String processPensionerServiceFallBackMethod()
	{
		return "Process Pensioner Service is taking longer than Expected."+" Please try again later";
	}
}
