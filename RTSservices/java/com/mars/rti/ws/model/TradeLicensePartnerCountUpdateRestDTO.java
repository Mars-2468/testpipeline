package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title", "name", "fatherName",
		"surname", "fullName", "cityName", "pinCode", "aadhaarNo",
		"email", "mobileNo", "address", "zoneNo", "wardNo", "areaName",
		"tradeLicenseNo", "updatedTradeName", "updatedTradeType",
		"updatedOwnerName", "updatedPartnerCount", "applicableFee",
		"userMobileNumber", "responseStatus", "responseCode",
		"result", "status", "nOCforTheRelatedDepartmentIssuedFromTheNMC",
		"copyOfTheFormerLicence", "noDuesCertificateForPropertyTax",
		"buildingAuthorizationDocument"})
public class TradeLicensePartnerCountUpdateRestDTO implements Serializable{

	private String title;
	private String name;
	private String fatherName;
	private String surname;
	private String fullName;
	private String cityName;
	private long pinCode;
	private String aadhaarNo;
	private String email;
	private long mobileNo;
	private String address;
	private int zoneNo;
	private String wardNo;
	private String areaName;
	private String tradeLicenseNo;
	private String updatedTradeName;
	private String updatedTradeType;
	private String updatedOwnerName;
	private String updatedPartnerCount;
	private double applicableFee;
	private long userMobileNumber;
	private String responseStatus;
	private int responseCode;
	private String result;
	private String status;

	private String nOCforTheRelatedDepartmentIssuedFromTheNMC;

	private String copyOfTheFormerLicence;

	private String noDuesCertificateForPropertyTax;

	private String buildingAuthorizationDocument;

	@XmlElement(name = "nOCforTheRelatedDepartmentIssuedFromTheNMC")
	public String getnOCforTheRelatedDepartmentIssuedFromTheNMC() {
		return nOCforTheRelatedDepartmentIssuedFromTheNMC;
	}

	@XmlElement(name = "copyOfTheFormerLicence")
	public String getCopyOfTheFormerLicence() {
		return copyOfTheFormerLicence;
	}

	@XmlElement(name = "noDuesCertificateForPropertyTax")
	public String getNoDuesCertificateForPropertyTax() {
		return noDuesCertificateForPropertyTax;
	}

	@XmlElement(name = "buildingAuthorizationDocument")
	public String getBuildingAuthorizationDocument() {
		return buildingAuthorizationDocument;
	}

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "fatherName")
	public String getFatherName() {
		return fatherName;
	}

	@XmlElement(name = "surname")
	public String getSurname() {
		return surname;
	}

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}

	@XmlElement(name = "cityName")
	public String getCityName() {
		return cityName;
	}

	@XmlElement(name = "pinCode")
	public long getPinCode() {
		return pinCode;
	}

	@XmlElement(name = "aadhaarNo")
	public String getAadhaarNo() {
		return aadhaarNo;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	@XmlElement(name = "mobileNo")
	public long getMobileNo() {
		return mobileNo;
	}

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	@XmlElement(name = "zoneNo")
	public int getZoneNo() {
		return zoneNo;
	}

	@XmlElement(name = "wardNo")
	public String getWardNo() {
		return wardNo;
	}

	@XmlElement(name = "areaName")
	public String getAreaName() {
		return areaName;
	}

	@XmlElement(name = "tradeLicenseNo")
	public String getTradeLicenseNo() {
		return tradeLicenseNo;
	}

	@XmlElement(name = "updatedTradeName")
	public String getUpdatedTradeName() {
		return updatedTradeName;
	}

	@XmlElement(name = "updatedTradeType")
	public String getUpdatedTradeType() {
		return updatedTradeType;
	}

	@XmlElement(name = "updatedOwnerName")
	public String getUpdatedOwnerName() {
		return updatedOwnerName;
	}

	@XmlElement(name = "updatedPartnerCount")
	public String getUpdatedPartnerCount() {
		return updatedPartnerCount;
	}

	@XmlElement(name = "applicableFee")
	public double getApplicableFee() {
		return applicableFee;
	}

	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	
	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	@XmlElement(name = "responseCode")
	public int getResponseCode() {
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setTradeLicenseNo(String tradeLicenseNo) {
		this.tradeLicenseNo = tradeLicenseNo;
	}

	public void setUpdatedTradeName(String updatedTradeName) {
		this.updatedTradeName = updatedTradeName;
	}

	public void setUpdatedTradeType(String updatedTradeType) {
		this.updatedTradeType = updatedTradeType;
	}

	public void setUpdatedOwnerName(String updatedOwnerName) {
		this.updatedOwnerName = updatedOwnerName;
	}

	public void setUpdatedPartnerCount(String updatedPartnerCount) {
		this.updatedPartnerCount = updatedPartnerCount;
	}

	public void setApplicableFee(double applicableFee) {
		this.applicableFee = applicableFee;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setnOCforTheRelatedDepartmentIssuedFromTheNMC(
			String nOCforTheRelatedDepartmentIssuedFromTheNMC) {
		this.nOCforTheRelatedDepartmentIssuedFromTheNMC = nOCforTheRelatedDepartmentIssuedFromTheNMC;
	}

	public void setCopyOfTheFormerLicence(String copyOfTheFormerLicence) {
		this.copyOfTheFormerLicence = copyOfTheFormerLicence;
	}

	public void setNoDuesCertificateForPropertyTax(
			String noDuesCertificateForPropertyTax) {
		this.noDuesCertificateForPropertyTax = noDuesCertificateForPropertyTax;
	}

	public void setBuildingAuthorizationDocument(
			String buildingAuthorizationDocument) {
		this.buildingAuthorizationDocument = buildingAuthorizationDocument;
	}

}
