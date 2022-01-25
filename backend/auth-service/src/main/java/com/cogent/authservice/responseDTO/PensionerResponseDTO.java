package com.cogent.authservice.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;




@Getter
@Setter
public class PensionerResponseDTO implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	  private String name;
	  private String email;
	  private String dob;
	  private String pan;
	  private String salaryEarned;
	  private String allowances;
	  private String pensionClassification;
	  private String aadharNo;
	  private String password;
	  private BankDetails bankDetails;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getSalaryEarned() {
		return salaryEarned;
	}
	public void setSalaryEarned(String salaryEarned) {
		this.salaryEarned = salaryEarned;
	}
	public String getAllowances() {
		return allowances;
	}
	public void setAllowances(String allowances) {
		this.allowances = allowances;
	}
	public String getPensionClassification() {
		return pensionClassification;
	}
	public void setPensionClassification(String pensionClassification) {
		this.pensionClassification = pensionClassification;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	  
}
