package com.pensionmanagement.pensioner.detail.service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="pensioner")
public class Pensioner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String name;
	  private String email;
	  private String dob;
	  private String pan;
	  private String salaryEarned;
	  private String allowances;
	  private String pensionClassification;
	  private String aadharNo;
	  @OneToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="id")
	  private BankDetails bankDetails;
	  
	public Pensioner(Long id, String name, String email, String dob, String pan, String salaryEarned, String allowances,
			String pensionClassification, String aadharNo, BankDetails bankDetails) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.pan = pan;
		this.salaryEarned = salaryEarned;
		this.allowances = allowances;
		this.pensionClassification = pensionClassification;
		this.aadharNo=aadharNo;
		this.bankDetails = bankDetails;
	}
	public Pensioner()
	{}

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

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	


	  
}