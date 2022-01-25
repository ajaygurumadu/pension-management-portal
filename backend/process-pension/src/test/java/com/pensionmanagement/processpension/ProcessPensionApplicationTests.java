package com.pensionmanagement.processpension;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.pensionmanagement.processpension.controller.ProcessPensionController;
import com.pensionmanagement.processpension.entity.PensionDetail;
import com.pensionmanagement.processpension.repository.PensionDetailRepository;
import com.pensionmanagement.processpension.service.PensionDetailService;
import com.pensionmanagement.processpension.valueObjects.BankDetails;
import com.pensionmanagement.processpension.valueObjects.Pensioner;
import com.pensionmanagement.processpension.valueObjects.ResponseTemplateVO;

@SpringBootTest
class ProcessPensionApplicationTests {

	@Autowired
	private PensionDetailService service;
	
	@Autowired
	private ProcessPensionController pensionerController;

	@MockBean
	private ResponseTemplateVO response;
	@MockBean
	private PensionDetailRepository repository;
	
	@Test
	public void getPensionerTest()
	{
		BankDetails bankDetails=new BankDetails(1,"SBI","Public","0987654321");
		Pensioner pensioner= new Pensioner((long) 1,"Ajay","ajay@gmail.com","14/04/1998","KJHG4321D","7000","1000","Self","0987654321",bankDetails);
		PensionDetail pensionDetail = new PensionDetail(999, 123, 33, "1");
		Assertions.assertNotNull(pensioner);
	    Assertions.assertNotNull(bankDetails);
	}
	@Test
	public void restTemplateTest()
	{
		BankDetails bankDetails=new BankDetails(1,"SBI","Public","0987654321");
		Pensioner pensioner= new Pensioner((long) 1,"Ajay","ajay@gmail.com","14/04/1998","KJHG4321D","7000","1000","Self","0987654321",bankDetails);
	    PensionDetail pensionDetail = new PensionDetail(999, 123, 33, "1");
		response.setPensioner(pensioner);
		response.setPensionDetails(pensionDetail);
		when(repository.save(pensionDetail)).thenReturn(pensionDetail);
		Assertions.assertNotNull(response);
	}
	
}
