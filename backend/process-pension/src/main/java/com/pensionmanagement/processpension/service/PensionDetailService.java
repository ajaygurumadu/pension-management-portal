package com.pensionmanagement.processpension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pensionmanagement.processpension.entity.PensionDetail;
import com.pensionmanagement.processpension.repository.PensionDetailRepository;
import com.pensionmanagement.processpension.valueObjects.Pensioner;
import com.pensionmanagement.processpension.valueObjects.ResponseTemplateVO;

@Service
public class PensionDetailService {
	
	@Autowired
	private PensionDetailRepository pensionDetailRepository;
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public PensionDetail saveData( PensionDetail pensionDetail)
	{
		return pensionDetailRepository.save(pensionDetail);
	}


	public ResponseTemplateVO getPensionerWithAadharNo(String aadharNo) {
		ResponseTemplateVO vo=new ResponseTemplateVO();
		PensionDetail pensioner = new PensionDetail();
		String url = "http://PENSIONER-DETAIL-MICROSERVICE/pensioner/"+aadharNo;
		Pensioner pension=restTemplate.getForObject(url,Pensioner.class);
		double pensionAmount = 0;
		int bankCharges = 0;
		int salary=Integer.parseInt(pension.getSalaryEarned());
		 System.out.println(salary);
		try {
			  System.out.print(pension.getPensionClassification());
			if(pension.getPensionClassification()=="Self")
			{			
				  pensionAmount= (0.8)*salary;
				  System.out.print(pensionAmount);
			      pensionAmount=pensionAmount+Integer.parseInt(pension.getAllowances());
			      System.out.print(pensionAmount);
			}
			else
			{
			
				  pensionAmount= (0.5)*salary;
				  System.out.print(pensionAmount);
			      pensionAmount=pensionAmount+Integer.parseInt(pension.getAllowances());
			      System.out.print(pensionAmount);
			}
		}
			catch(Exception e)
			{
				System.out.print("Invalid pension details Exception");
			}
		if(pension.getBankDetails().getSector()=="Public")
	    {
	      bankCharges=500;
	    }
	    else
	    {
	      bankCharges=550;
	    }
		pensioner.setId(pension.getId());
		pensioner.setAadharNo(aadharNo);
		pensioner.setBankServiceCharge(bankCharges);
		pensioner.setPensionAmount(pensionAmount);
		vo.setPensionDetails(pensioner);
        vo.setPensioner(pension);
        return  vo;
	}
	
	
}
