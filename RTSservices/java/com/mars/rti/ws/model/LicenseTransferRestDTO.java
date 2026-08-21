
package com.mars.rti.ws.model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "title", "name","fatherName","surName","fullName","pinCode","aadhaarNo","email","aadhaarNo","mobileNo",
	                  "address","zoneNo","wardNo","areaName","tradeLicenseNo","updatedTradeName","updatedTradeType",
	                  "updatedOwnerName","updatedPartnerCount", "feesApplicable", "responseCode",
	          		"nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf",
	        		"copyoftheFormerLicencepdf","applicableFee","noDuesCertificateforPropertyTaxpdf", "buildingAuthorizationDocumentpdf",
	        		"userMobileNumber","result"
})

public class LicenseTransferRestDTO implements Serializable{
	
	private String title;

	private String name;

	private String fatherName;

	private String surName;

	private String fullName;

	private long pinCode;

private String aadharNo;

	private String email;

	private long mobileNo;

	private String address;
	
	private String result;
	

	private long zoneNo;

	private String wardNo;

	private String areaName;
	
	private String updatedtradename;
	
	private String updatedownername;
	
	private String updatedpatnername;
	
	private double applicableFee;

	private String updatedpatnercount;

   private  String tradelicenseNo;
   
	private String updatedtradetype;

	private String responseStatus;

	private String status;

	private long responseCode;

	private String nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf;

	private String copyoftheFormerLicencepdf;

	private String noDuesCertificateforPropertyTaxpdf;

	private String buildingAuthorizationDocumentpdf;

	private long userMobileNumber;
	
	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@XmlElement(name = "updatedpatnercount")
	public String getUpdatedpatnercount() {
		return updatedpatnercount;
	}
	public void setUpdatedpatnercount(String updatedpatnercount) {
		this.updatedpatnercount = updatedpatnercount;
	}
	@XmlElement(name = "tradelicenseNo")
	public String getTradelicenseNo() {
		return tradelicenseNo;
	}
	public void setTradelicenseNo(String tradelicenseNo) {
		this.tradelicenseNo = tradelicenseNo;
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
	@XmlElement(name = "surName")
	public String getSurName() {
		return surName;
	}
	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}
	@XmlElement(name = "pinCode")
	public long getPinCode() {
		return pinCode;
	}
	@XmlElement(name = "aadharNo")
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
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
	public long getZoneNo() {
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
	@XmlElement(name = "updatedtradename")
	public String getUpdatedtradename() {
		return updatedtradename;
	}
	@XmlElement(name = "updatedownername")
	public String getUpdatedownername() {
		return updatedownername;
	}
	@XmlElement(name = "updatedpatnername")
	public String getUpdatedpatnername() {
		return updatedpatnername;
	}
	@XmlElement(name = "updatedtradetype")
	public String getUpdatedtradetype() {
		return updatedtradetype;
	}
	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}
	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}
	@XmlElement(name = "responseCode")
	public long getResponseCode() {
		return responseCode;
	}
	@XmlElement(name = "nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf")
	public String getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf() {
		return nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf;
	}
	@XmlElement(name = "copyoftheFormerLicencepdf")
	public String getCopyoftheFormerLicencepdf() {
		return copyoftheFormerLicencepdf;
	}
	@XmlElement(name = "noDuesCertificateforPropertyTaxpdf")
	public String getNoDuesCertificateforPropertyTaxpdf() {
		return noDuesCertificateforPropertyTaxpdf;
	}
	@XmlElement(name = "buildingAuthorizationDocumentpdf")
	public String getBuildingAuthorizationDocumentpdf() {
		return buildingAuthorizationDocumentpdf;
	}
	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
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
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
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
	public void setZoneNo(long zoneNo) {
		this.zoneNo = zoneNo;
	}
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public void setUpdatedtradename(String updatedtradename) {
		this.updatedtradename = updatedtradename;
	}
	public void setUpdatedownername(String updatedownername) {
		this.updatedownername = updatedownername;
	}
	public void setUpdatedpatnername(String updatedpatnername) {
		this.updatedpatnername = updatedpatnername;
	}
	public void setUpdatedtradetype(String updatedtradetype) {
		this.updatedtradetype = updatedtradetype;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}
	public void setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf(
			String nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf) {
		this.nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf = nOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf;
	}
	public void setCopyoftheFormerLicencepdf(String copyoftheFormerLicencepdf) {
		this.copyoftheFormerLicencepdf = copyoftheFormerLicencepdf;
	}
	public void setNoDuesCertificateforPropertyTaxpdf(String noDuesCertificateforPropertyTaxpdf) {
		this.noDuesCertificateforPropertyTaxpdf = noDuesCertificateforPropertyTaxpdf;
	}
	public void setBuildingAuthorizationDocumentpdf(String buildingAuthorizationDocumentpdf) {
		this.buildingAuthorizationDocumentpdf = buildingAuthorizationDocumentpdf;
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
	
	
	
	
	
	


}