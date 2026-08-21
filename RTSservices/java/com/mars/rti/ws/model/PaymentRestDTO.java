package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"applicationNumber","name","applicationName","fees","responseCode","status"})
public class PaymentRestDTO {

	private String applicationNumber;
	private String name;
	private String applicationName;
	private double fees;
	private long responseCode;
	private String status;
	
	@XmlElement(name="applicationNumber")
	public String getApplicationNumber() {
		return applicationNumber;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	
	@XmlElement(name="applicationName")
	public String getApplicationName() {
		return applicationName;
	}
	
	@XmlElement(name="fees")
	public double getFees() {
		return fees;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
