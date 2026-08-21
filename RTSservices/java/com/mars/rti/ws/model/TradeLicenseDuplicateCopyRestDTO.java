package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({"title","name","fatherName","surname","fullName","userMobileNumber","pinCode","aadhaarNo","emailID","mobileNumber",
    "adressForCorrespondence","zoneNo","wardNo","nameOfArea","tradeLicenceNo","updateTradeName","updatedTradeType",
    "updatedOwnerName","updatedPartnerCount","applicableFee","nocForRelatedDepartment","copyOfFormerLicence","propertyTaxNoDue","buildingAuthorizationDocument"})
public class TradeLicenseDuplicateCopyRestDTO implements Serializable{
	
	private String title;

	private String name;

	private String fatherName;

	private String surname;

	private long userMobileNumber;

	
	private String fullName;

	private int pinCode;

	private long aadhaarNo;

	private String emailID;

	private String mobileNumber;

	private String adressForCorrespondence;

	private String zoneNo;

	private String wardNo;

	private String nameOfArea;

	private String tradeLicenceNo;

	private String updateTradeName;

	private String updatedTradeType;

	private String updatedOwnerName;

	private String updatedPartnerCount;
	
	private String nocforTheRelatedDepartmentIssuedFromNMCDepartment;

	private String copyOfTheFormerLicence;
	
	private String noDuesCertificateforPropertyTax;
	
	private String buildingAuthorizationDocument;
	
	private String responseStatus;
	
	private double applicableFee;
	
	private String result;
	
	private int responseCode;
	
	private String status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdressForCorrespondence() {
		return adressForCorrespondence;
	}

	public void setAdressForCorrespondence(String adressForCorrespondence) {
		this.adressForCorrespondence = adressForCorrespondence;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getNameOfArea() {
		return nameOfArea;
	}

	public void setNameOfArea(String nameOfArea) {
		this.nameOfArea = nameOfArea;
	}

	public String getTradeLicenceNo() {
		return tradeLicenceNo;
	}

	public void setTradeLicenceNo(String tradeLicenceNo) {
		this.tradeLicenceNo = tradeLicenceNo;
	}

	public String getUpdateTradeName() {
		return updateTradeName;
	}

	public void setUpdateTradeName(String updateTradeName) {
		this.updateTradeName = updateTradeName;
	}

	public String getUpdatedTradeType() {
		return updatedTradeType;
	}

	public void setUpdatedTradeType(String updatedTradeType) {
		this.updatedTradeType = updatedTradeType;
	}

	public String getUpdatedOwnerName() {
		return updatedOwnerName;
	}

	public void setUpdatedOwnerName(String updatedOwnerName) {
		this.updatedOwnerName = updatedOwnerName;
	}

	public String getUpdatedPartnerCount() {
		return updatedPartnerCount;
	}

	public void setUpdatedPartnerCount(String updatedPartnerCount) {
		this.updatedPartnerCount = updatedPartnerCount;
	}

	public String getNocforTheRelatedDepartmentIssuedFromNMCDepartment() {
		return nocforTheRelatedDepartmentIssuedFromNMCDepartment;
	}

	public void setNocforTheRelatedDepartmentIssuedFromNMCDepartment(
			String nocforTheRelatedDepartmentIssuedFromNMCDepartment) {
		this.nocforTheRelatedDepartmentIssuedFromNMCDepartment = nocforTheRelatedDepartmentIssuedFromNMCDepartment;
	}

	public String getCopyOfTheFormerLicence() {
		return copyOfTheFormerLicence;
	}

	public void setCopyOfTheFormerLicence(String copyOfTheFormerLicence) {
		this.copyOfTheFormerLicence = copyOfTheFormerLicence;
	}

	

	public String getBuildingAuthorizationDocument() {
		return buildingAuthorizationDocument;
	}

	public void setBuildingAuthorizationDocument(String buildingAuthorizationDocument) {
		this.buildingAuthorizationDocument = buildingAuthorizationDocument;
	}

	

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	@XmlElement(name="applicableFee")
	public double getApplicableFee() {
		return applicableFee;
	}

	public void setApplicableFee(double applicableFee) {
		this.applicableFee = applicableFee;
	}

	public String getNoDuesCertificateforPropertyTax() {
		return noDuesCertificateforPropertyTax;
	}

	public void setNoDuesCertificateforPropertyTax(
			String noDuesCertificateforPropertyTax) {
		this.noDuesCertificateforPropertyTax = noDuesCertificateforPropertyTax;
	} 
	
		
}
