package com.pensionmanagement.pensioner.detail.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pensionmanagement.pensioner.detail.service.entity.Pensioner;
import com.pensionmanagement.pensioner.detail.service.service.PensionerService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pensioner")
@Slf4j
public class PensionerController {
	@Autowired
	private PensionerService pensionerService;
	private static final Logger log = LoggerFactory.getLogger(Pensioner.class);
	
	@PostConstruct
	public void savePensionertoDB() throws IOException
	{
		log.info("Inside PensionerController savePensioner");
		pensionerService.savePensionerDetails();
	}
	
	@GetMapping("/{aadharNo}")
	public Pensioner findPensionerByAdhar(@PathVariable("aadharNo") String aadharNo)
	{
		log.info("Inside PensionerController findPensionerByAadhar");
		return  pensionerService.findPensionerByAdhar(aadharNo);
	}

}
