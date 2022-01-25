package com.pensionmanagement.processpension.valueObjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {
	private long id;
	private String bankName;
	private String accountNo;
	private String sector;
	public BankDetails(long id, String bankName, String accountNo, String sector) {
		super();
		this.id=id;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.sector = sector;
	}
	public BankDetails()
	{
		
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
