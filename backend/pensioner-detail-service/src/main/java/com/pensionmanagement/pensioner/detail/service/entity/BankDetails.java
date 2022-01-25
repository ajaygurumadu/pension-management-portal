package com.pensionmanagement.pensioner.detail.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankDetails{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
	private long id;
	private String bankName;
	private String accountNo;
	private String sector;
	
	   public BankDetails() {
	    }
	public BankDetails(long id, String bankName, String accountNo, String sector) {
		super();
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.sector = sector;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	

}
