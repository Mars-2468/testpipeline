package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"canNo", "zoneNo", "existingConsumerName",
		"meterNo", "tapSize", "category", "balanceArrears", "cutOffDate",
		"consumerAddress", "esr", "consumerEmailId", "consumerMobileNo", "title", "applicantName",
		"applicantFatherName", "applicantSurname", "fullName", "alternateMobileNo",
		"applicantAddress", "userMobileNumber", "applicantIdProofPdf","currentBillCopyPdf","ownershipProofpdf","supportingDocPdf","responseStatus",
		"responseCode", "result", "status"})
public class ChangeInOwnershipTypeRestDTO implements Serializable {
	private String canNo;
	private String zoneNo;
	private String existingConsumerName;
	private String meterNo;
	private String tapSize;
	private String category;
	private String balanceArrears;
	private String cutOffDate;
	private String consumerAddress;
	private String esr;
	private String consumerEmailId;
	private long consumerMobileNo;
	private String title;
	private String applicantName;
	private String applicantFatherName;
	private String applicantSurname;
	private String fullName;
	private long alternateMobileNo;
	private String applicantAddress;
	private long userMobileNumber;
	
	private String applicantIdProofPdf;
	private String currentBillCopyPdf;
	private String ownershipProofpdf;	
	private String supportingDocPdf;
	private String responseStatus;
	private long responseCode;
	private String result;
	private String status;
	
	

	@XmlElement(name = "canNo")
	public String getCanNo() {
		return canNo;
	}

	@XmlElement(name = "zoneNo")
	public String getZoneNo() {
		return zoneNo;
	}
	

	@XmlElement(name = "existingConsumerName")
	public String getExistingConsumerName() {
		return existingConsumerName;
	}
	
	@XmlElement(name = "meterNo")
	public String getMeterNo() {
		return meterNo;
	}

	
	@XmlElement(name = "tapSize")
	public String getTapSize() {
		return tapSize;
	}
	
	@XmlElement(name = "category")
	public String getCategory() {
		return category;
	}

	
	@XmlElement(name = "balanceArrears")
	public String getBalanceArrears() {
		return balanceArrears;
	}

	@XmlElement(name = "cutOffDate")
	public String getCutOffDate() {
		return cutOffDate;
	}

	@XmlElement(name = "consumerAddress")
	public String getConsumerAddress() {
		return consumerAddress;
	}
	
	@XmlElement(name = "esr")
	public String getEsr() {
		return esr;
	}
	
	@XmlElement(name = "consumerEmailId")
	public String getConsumerEmailId() {
		return consumerEmailId;
	}
	
	@XmlElement(name = "consumerMobileNo")
	public long getConsumerMobileNo() {
		return consumerMobileNo;
	}
	

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "applicantName")
	public String getApplicantName() {
		return applicantName;
	}

	@XmlElement(name = "applicantFatherName")
	public String getApplicantFatherName() {
		return applicantFatherName;
	}

	@XmlElement(name = "applicantSurname")
	public String getApplicantSurname() {
		return applicantSurname;
	}

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}
	
	@XmlElement(name = "alternateMobileNo")
	public long getAlternateMobileNo() {
		return alternateMobileNo;
	}

	@XmlElement(name = "applicantAddress")
	public String getApplicantAddress() {
		return applicantAddress;
	}

	
	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	
	@XmlElement(name = "applicantIdProofPdf")
	public String getApplicantIdProofPdf() {
		return applicantIdProofPdf;
	}
	
	@XmlElement(name = "currentBillCopyPdf")
	public String getCurrentBillCopyPdf() {
		return currentBillCopyPdf;
	}
	
		
	@XmlElement(name = "ownershipProofpdf")
	public String getOwnershipProofpdf() {
		return ownershipProofpdf;
	}
	
	@XmlElement(name = "supportingDocPdf")
	public String getSupportingDocPdf() {
		return supportingDocPdf;
	}

	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	@XmlElement(name = "responseCode")
	public long getResponseCode() {
		return responseCode;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}
	//

	public void setCanNo(String canNo) {
		this.canNo = canNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public void setExistingConsumerName(String existingConsumerName) {
		this.existingConsumerName = existingConsumerName;
	}
	
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	
	public void setTapSize(String tapSize) {
		this.tapSize = tapSize;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setBalanceArrears(String balanceArrears) {
		this.balanceArrears = balanceArrears;
	}

	public void setCutOffDate(String cutOffDate) {
		this.cutOffDate = cutOffDate;
	}

	
	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	public void setEsr(String esr) {
		this.esr = esr;
	}

	public void setConsumerEmailId(String consumerEmailId) {
		this.consumerEmailId = consumerEmailId;
	}
	
	public void setConsumerMobileNo(long consumerMobileNo) {
		this.consumerMobileNo = consumerMobileNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public void setApplicantFatherName(String applicantFatherName) {
		this.applicantFatherName = applicantFatherName;
	}

	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAlternateMobileNo(long alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}
	
	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}
	
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	
	public void setApplicantIdProofPdf(String applicantIdProofPdf) {
		this.applicantIdProofPdf = applicantIdProofPdf;
	}

	public void setCurrentBillCopyPdf(String currentBillCopyPdf) {
		this.currentBillCopyPdf = currentBillCopyPdf;
	}

	
	public void setOwnershipProofpdf(String ownershipProofpdf) {
		this.ownershipProofpdf = ownershipProofpdf;
	}

	public void setSupportingDocPdf(String supportingDocPdf) {
		this.supportingDocPdf = supportingDocPdf;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	
	
	
}
