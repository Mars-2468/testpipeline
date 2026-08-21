package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title","firstName","middleName","lastName","fullName","plotNo","buildingName",
	"streetName","areaName","landmark","pincode","aadhaarNo","email","mobileNo","address","canNo",
	"zoneNo","consumerName","consumerAddress","meterNo","depositReceiptNo","depositReceiptDate",
	"purpose","pdfFilesSavedPath","result","response","responseStatus"})
public class NewWaterReconnectionRestDTO implements Serializable {

	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private String fullName;
	
	private String plotNo;
	
	private String buildingName;
	
	private String streetName;
	
	private String areaName;
	
	private String landmark;
	
	private long pincode;
	
	private String aadhaarNo;
	
	private String email;
	
	private long mobileNo;
	
	private String address;
	
	private String canNo;
	
	private int zoneNo;
	
	private String consumerName;
	
	private String consumerAddress;
	
	private String meterNo;
	
	private String depositReceiptNo;
	
	private String depositReceiptDate;
	
	private String purpose;
	
    private String pdfFilesSavedPath;
	
	private String result;

	private long response;

	private String responseStatus;

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElement(name = "plotNo")
	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	@XmlElement(name = "buildingName")
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@XmlElement(name = "streetName")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@XmlElement(name = "areaName")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@XmlElement(name = "landmark")
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@XmlElement(name = "pincode")
	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@XmlElement(name = "aadhaarNo")
	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "mobileNo")
	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
//	@XmlElement(name = "canNo")
//	public String getCinNo() {
//		return canNo;
//	}
//
//	public void setCinNo(String canNo) {
//		this.cinNo = cinNo;
//	}
	@XmlElement(name = "canNo")
	public String getCanNo() {
		return canNo;
	}

	public void setCanNo(String canNo) {
		this.canNo = canNo;
	}

	@XmlElement(name = "zoneNo")
	public int getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	@XmlElement(name = "consumerName")
	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	@XmlElement(name = "consumerAddress")
	public String getConsumerAddress() {
		return consumerAddress;
	}

	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	@XmlElement(name = "meterNo")
	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	@XmlElement(name = "depositReceiptNo")
	public String getDepositReceiptNo() {
		return depositReceiptNo;
	}

	public void setDepositReceiptNo(String depositReceiptNo) {
		this.depositReceiptNo = depositReceiptNo;
	}

	@XmlElement(name = "depositReceiptDate")
	public String getDepositReceiptDate() {
		return depositReceiptDate;
	}

	public void setDepositReceiptDate(String depositReceiptDate) {
		this.depositReceiptDate = depositReceiptDate;
	}

	@XmlElement(name = "purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@XmlElement(name = "pdfFilesSavedPath")
	public String getPdfFilesSavedPath() {
		return pdfFilesSavedPath;
	}

	public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
		this.pdfFilesSavedPath = pdfFilesSavedPath;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@XmlElement(name = "response")
	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
}
