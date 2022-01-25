package com.pensionmanagement.processpension.valueObjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.pensionmanagement.processpension.entity.PensionDetail;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResponseTemplateVO {
	
	private PensionDetail pensionDetails;
	private Pensioner pensioner;
	public Pensioner getPensioner() {
		return pensioner;
	}
	public void setPensioner(Pensioner pensioner) {
		this.pensioner = pensioner;
	}
	public PensionDetail getPensionDetails() {
		return pensionDetails;
	}
	public void setPensionDetails(PensionDetail pensionDetails) {
		this.pensionDetails = pensionDetails;
	}

}
