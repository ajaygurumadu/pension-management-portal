package com.pensionmanagement.pensioner.detail.service.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionmanagement.pensioner.detail.service.entity.BankDetails;
import com.pensionmanagement.pensioner.detail.service.entity.Pensioner;
import com.pensionmanagement.pensioner.detail.service.repository.PensionerRepository;

@Service
public class PensionerService {
	@Autowired
	private PensionerRepository pensionerRepository;

	String line = "";
	public void savePensionerDetails() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C://Users//sagar//OneDrive//Desktop//FSE//backend//pensioner-detail-service//src//main//resources//details.csv"));
		while((line =br.readLine())!=null) {
		String [] data =line.split(",");
		Pensioner pensioner = new Pensioner();
		BankDetails bankDetails=new BankDetails();
		pensioner.setAadharNo(data[1]);
		pensioner.setAllowances(data[2]);
		pensioner.setDob(data[3]);
		pensioner.setEmail(data[4]);
		pensioner.setName(data[5]);
		pensioner.setPan(data[6]);
		pensioner.setPensionClassification(data[7]);
		pensioner.setSalaryEarned(data[8]);
		bankDetails.setAccountNo(data[9]);
		bankDetails.setBankName(data[10]);
		bankDetails.setSector(data[11]);
		pensioner.setBankDetails(bankDetails);
		pensionerRepository.save(pensioner);
		}
	}

	public Pensioner findPensionerByAdhar(String aadharNo) {
		return pensionerRepository.findAllByAadharNo(aadharNo);
	}

	

}
