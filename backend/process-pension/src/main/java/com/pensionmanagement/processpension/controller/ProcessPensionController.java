package com.pensionmanagement.processpension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.processpension.entity.PensionDetail;
import com.pensionmanagement.processpension.service.PensionDetailService;
import com.pensionmanagement.processpension.valueObjects.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/pension")
@Slf4j
public class ProcessPensionController {
	@Autowired
	private PensionDetailService pensionDetailService;
	
	@PostMapping("/")
    public PensionDetail saveData(@RequestBody PensionDetail pensionDetail) {
        return pensionDetailService.saveData(pensionDetail);
    }

    @GetMapping("/{aadharNo}")
    public ResponseTemplateVO getPensionerWithAadharNo(@PathVariable("aadharNo") String aadharNo) {
//        
        return pensionDetailService.getPensionerWithAadharNo(aadharNo);
    }


    
}
