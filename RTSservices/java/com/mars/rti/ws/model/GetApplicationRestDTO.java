package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "applicationStatus", "amount", "rtsapplicationNo", "certificate", "responseCode", "status" })
public class GetApplicationRestDTO {

	private String applicationStatus;
	private double amount;
	private String rtsapplicationNo;
	private String certificate;
	private long responseCode;
	private String status;
	private String paymentLink;
	private long workflowStatus;
	private long serviceId;

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	@XmlElement(name = "amount")
	public double getAmount() {
		return amount;
	}

	@XmlElement(name = "rtsapplicationNo")
	public String getRtsapplicationNo() {
		return rtsapplicationNo;
	}

	@XmlElement(name = "certificate")
	public String getCertificate() {
		return certificate;
	}

	@XmlElement(name = "applicationStatus")
	public String getApplicationStatus() {
		return applicationStatus;
	}

	@XmlElement(name="responseCode")
	public long getResponseCode() {
		return responseCode;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setRtsapplicationNo(String rtsapplicationNo) {
		this.rtsapplicationNo = rtsapplicationNo;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentLink() {
		return paymentLink;
	}

	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}

	public long getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(long workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	


	
}
