package com.cogent.authservice.responseDTO;

public class BankDetails {
	private long id;
	private String bankName;
	private String accountNo;
	private String sector;
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
