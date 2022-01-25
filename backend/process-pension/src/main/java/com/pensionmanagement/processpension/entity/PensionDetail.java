package com.pensionmanagement.processpension.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="pensionDetail")
public class PensionDetail {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double pensionAmount;
    private int bankServiceCharge;
    private String aadharNo;
	public PensionDetail(int id, double pensionAmount, int bankServiceCharge, String aadharNo) {
		super();
		this.id = id;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
		this.aadharNo=(aadharNo);
	}
	public PensionDetail() {
		// TODO Auto-generated constructor stub
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPensionAmount() {
		return pensionAmount;
	}
	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	public int getBankServiceCharge() {
		return bankServiceCharge;
	}
	public void setBankServiceCharge(int bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}
	
    
    
}
