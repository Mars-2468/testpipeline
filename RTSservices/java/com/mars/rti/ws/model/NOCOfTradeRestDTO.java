package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "title", "firstName", "middleName", "lastName",
	"fullName", "pinCode", "aadhaarNo", "email", "mobileNo",
	"address", "applicationFor", "businessName","businessDetails","businessDate","spaceType", "length", "height", "width",
	"zoneNo", "wardNo", "areaName", "licenceNo", "fullAddress", "formerLicence", "calnumber",
	"feesApplicable", "pdfFilesSavedPath", "result", "response", "responseStatus"})
public class NOCOfTradeRestDTO implements Serializable {

		
	private String title;
	
	private String firstName;
	
	private String middleName;

	private String lastName;

	private String fullName;
	
	private int pinCode;
	
	private String aadhaarNo;
	
	private String email;

	private long mobileNo;

	private String address; 
	
	private String applicationFor;
	
	private String businessName;
	
	private String businessDetails;
	
	private String businessDate;
	
	private String spaceType;
	
	private long length;
	
	private long height;
	
	private long width;
	
	private int zoneNo;

	private String wardNo;

	private String areaName;
	
	private String licenceNo;

	private String fullAddress;

	private String formerLicence;
	
	private String calnumber;
	
	private double feesApplicable;

	private String pdfFilesSavedPath;
		
	private String result;

	private long response;

	private String responseStatus;
	
	private long responseCode;
	private String status;

	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	
	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	
	@XmlElement(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}
	
	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	
	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}
	
	@XmlElement(name = "pinCode")
	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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
	
	@XmlElement(name = "applicationFor")
	public String getApplicationFor() {
		return applicationFor;
	}
	
	@XmlElement(name = "businessName")
	public String getBusinessName() {
		return businessName;
	}
	@XmlElement(name = "businessDetails")
	public String getBusinessDetails() {
		return businessDetails;
	}
	@XmlElement(name = "businessDate")
	public String getBusinessDate() {
		return businessDate;
	}
	@XmlElement(name = "spaceType")
	public String getSpaceType() {
		return spaceType;
	}
	@XmlElement(name = "length")
	public long getLength() {
		return length;
	}
	@XmlElement(name = "height")
	public long getHeight() {
		return height;
	}
	@XmlElement(name = "width")
	public long getWidth() {
		return width;
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
	@XmlElement(name = "licenceNo")
	public String getLicenceNo() {
		return licenceNo;
	}
	@XmlElement(name = "fullAddress")
	public String getFullAddress() {
		return fullAddress;
	}
	@XmlElement(name = "formerLicence")
	public String getFormerLicence() {
		return formerLicence;
	}
	@XmlElement(name = "calnumber")
	public String getCalnumber() {
		return calnumber;
	}
	@XmlElement(name = "feesApplicable")
	public double getFeesApplicable() {
		return feesApplicable;
	}
	@XmlElement(name = "pdfFilesSavedPath")
	public String getPdfFilesSavedPath() {
		return pdfFilesSavedPath;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public void setApplicationFor(String applicationFor) {
		this.applicationFor = applicationFor;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setBusinessDetails(String businessDetails) {
		this.businessDetails = businessDetails;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public void setWidth(long width) {
		this.width = width;
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

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public void setFormerLicence(String formerLicence) {
		this.formerLicence = formerLicence;
	}

	public void setCalnumber(String calnumber) {
		this.calnumber = calnumber;
	}

	public void setFeesApplicable(double feesApplicable) {
		this.feesApplicable = feesApplicable;
	}

	public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
		this.pdfFilesSavedPath = pdfFilesSavedPath;
	}

	public String getResult() {
		return result;
	}

	public long getResponse() {
		return response;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	
	public String getStatus() {
		return status;
	}

	

	public void setStatus(String status) {
		this.status = status;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}
	
	
	

	
}
