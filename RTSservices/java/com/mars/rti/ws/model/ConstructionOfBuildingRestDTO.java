package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ConstructionOfBuilding")
@XmlType(propOrder = {"buildingRegistrationId","title","firstName","middleName","lastName","address",
"mobileNo","email","pincode","ownerName","revenueNo","peropertyNo","surveyNo","gatNo","khasaraNo","finalPlotNo","propertyAddress","propertyUsage","licenseNo","zoneNo","rtiapplrefno"})		
public class ConstructionOfBuildingRestDTO {

	private long buildingRegistrationId;

	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private String address;

	private String mobileNo;

	private String email;

	private int pincode;

	private String ownerName;

	private String revenueNo;

	private String peropertyNo;

	private String surveyNo;

	private String gatNo;

	private String khasaraNo;

	private String finalPlotNo;

	private String propertyAddress;

	private String propertyUsage;

	private String licenseNo;

	private String zoneNo;
	private String rtiapplrefno;

	private String responseStatus;
	private int status;
	private long response;
	private String result;
	@XmlElement(name = "mandapPermissionId")
	public long getBuildingRegistrationId() {
		return buildingRegistrationId;
	}
	public void setBuildingRegistrationId(long buildingRegistrationId) {
		this.buildingRegistrationId = buildingRegistrationId;
	}
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
	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement(name = "mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name = "pincode")
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@XmlElement(name = "ownerName")
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@XmlElement(name = "revenueNo")
	public String getRevenueNo() {
		return revenueNo;
	}
	public void setRevenueNo(String revenueNo) {
		this.revenueNo = revenueNo;
	}
	@XmlElement(name = "peropertyNo")
	public String getPeropertyNo() {
		return peropertyNo;
	}
	public void setPeropertyNo(String peropertyNo) {
		this.peropertyNo = peropertyNo;
	}
	@XmlElement(name = "surveyNo")
	public String getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}
	@XmlElement(name = "gatNo")
	public String getGatNo() {
		return gatNo;
	}
	public void setGatNo(String gatNo) {
		this.gatNo = gatNo;
	}
	@XmlElement(name = "khasaraNo")
	public String getKhasaraNo() {
		return khasaraNo;
	}
	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}
	@XmlElement(name = "finalPlotNo")
	public String getFinalPlotNo() {
		return finalPlotNo;
	}
	public void setFinalPlotNo(String finalPlotNo) {
		this.finalPlotNo = finalPlotNo;
	}
	@XmlElement(name = "propertyAddress")
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	@XmlElement(name = "propertyUsage")
	public String getPropertyUsage() {
		return propertyUsage;
	}
	public void setPropertyUsage(String propertyUsage) {
		this.propertyUsage = propertyUsage;
	}
	@XmlElement(name = "licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@XmlElement(name = "zoneNo")
	public String getZoneNo() {
		return zoneNo;
	}
	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@XmlElement(name = "rtiapplrefno")
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}
	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getResponse() {
		return response;
	}
	public void setResponse(long response) {
		this.response = response;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
