package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "LayoutOfBuilding")
@XmlType(propOrder = { "layoutRegistrationId", "title", "firstName", "middleName", "lastName", "fullAddress", "mobileNo",
		"emailId", "ownerName", "plotNo", "revenueNo", "surveyNo", "gatNo", "khasaraNo", "finalPlotNo",
		"mouje", "road", "society", "licenseNo", "addressOfOwner" , "rtiapplrefno"})
public class LayoutOfBuildingRestDTO {

	private long layoutRegistrationId;

	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private String fullAddress;

	private String mobileNo;

	private String emailId;

	private String ownerName;

	private String plotNo;

	private String revenueNo;

	private String surveyNo;

	private String gatNo;

	private String khasaraNo;

	private String finalPlotNo;

	private String mouje;

	private String road;

	private String society;

	private String licenseNo;

	private String addressOfOwner;
	private String rtiapplrefno;

	private String responseStatus;
	private int status;
	private long response;
	private String result;
	
	@XmlElement(name = "layoutRegistrationId")
	public long getLayoutRegistrationId() {
		return layoutRegistrationId;
	}
	public void setLayoutRegistrationId(long layoutRegistrationId) {
		this.layoutRegistrationId = layoutRegistrationId;
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
	@XmlElement(name = "fullAddress")
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	@XmlElement(name = "mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@XmlElement(name = "emailId")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@XmlElement(name = "ownerName")
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@XmlElement(name = "plotNo")
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	@XmlElement(name = "revenueNo")
	public String getRevenueNo() {
		return revenueNo;
	}
	public void setRevenueNo(String revenueNo) {
		this.revenueNo = revenueNo;
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
	@XmlElement(name = "mouje")
	public String getMouje() {
		return mouje;
	}
	public void setMouje(String mouje) {
		this.mouje = mouje;
	}
	@XmlElement(name = "road")
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	@XmlElement(name = "society")
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	@XmlElement(name = "licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@XmlElement(name = "addressOfOwner")
	public String getAddressOfOwner() {
		return addressOfOwner;
	}
	public void setAddressOfOwner(String addressOfOwner) {
		this.addressOfOwner = addressOfOwner;
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
