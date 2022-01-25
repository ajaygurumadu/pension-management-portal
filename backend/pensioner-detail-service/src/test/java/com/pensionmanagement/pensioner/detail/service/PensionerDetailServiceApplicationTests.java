package com.pensionmanagement.pensioner.detail.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Optional;
import com.pensionmanagement.pensioner.detail.service.controller.PensionerController;
import com.pensionmanagement.pensioner.detail.service.entity.BankDetails;
import com.pensionmanagement.pensioner.detail.service.entity.Pensioner;
import com.pensionmanagement.pensioner.detail.service.repository.PensionerRepository;
import com.pensionmanagement.pensioner.detail.service.service.PensionerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PensionerDetailServiceApplicationTests {

	@Autowired
	private PensionerService service;

	@MockBean
	private PensionerRepository repository;
	@Autowired
	private PensionerController pensionerController;

	@Test
	   public void main() {
	      PensionerDetailServiceApplication.main(new String[] {});
	   }
	
	@Test
	public void getPensionerTest() {
		BankDetails bankDetails=new BankDetails(1,"SBI","Public","0987654321");
		Pensioner pensioner= new Pensioner((long) 1,"Ajay","ajay@gmail.com","14/04/1998","KJHG4321D","7000","1000","Self","0987654321",bankDetails);
		when(repository.save(pensioner)).thenReturn(pensioner);
		Assertions.assertEquals(pensioner, repository.save(pensioner));
		Assertions.assertSame(pensioner, pensioner);
	}
	
	@Test
	public void okNoBody() {
		ResponseEntity<Void> responseEntity = ResponseEntity.ok().build();
		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}
	
	
	@Test
	public void findPensionByAadharTest()
	{
		BankDetails bankDetails=new BankDetails(1,"SBI","Public","0987654321");
		Pensioner pensioner= new Pensioner((long) 1,"Ajay","ajay@gmail.com","14/04/1998","KJHG4321D","7000","1000","Self","0987654321",bankDetails);
		when(service.findPensionerByAdhar(pensioner.getAadharNo())).thenReturn(pensioner);
	}
	
	
	@Test
	public void getPensionerWithAadharNoTest()
	{
		String aadharNo="0987654321";
		Pensioner pensioner1=new Pensioner();
		pensioner1.setId((long)1);
		pensioner1.setAadharNo("0987654321");
		pensioner1.setAllowances("20000");
		pensioner1.setDob("14/08/1998");
		pensioner1.setEmail("ajay@gmail.com");
		pensioner1.setName("MAG");
		pensioner1.setPan("SFEW78H");
		pensioner1.setSalaryEarned("60000");
		pensioner1.setPensionClassification("Self");
		
		repository.save(pensioner1);
		when(pensionerController.findPensionerByAdhar(aadharNo)).thenReturn(pensioner1);
		assertThat(pensioner1);
	}
	
	
	
	
}
