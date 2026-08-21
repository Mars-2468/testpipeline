package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({"title", "name", "fatherName",
		"surname", "fullName", "cityName", "plotNo", "buildingName",
		"streetName", "areaName", "pinCode", "nearbyLandmark", "mobileNumber",
		"emailId", "colonyName", "correspondenceAddress", "zoneNo", "wardNo",
		"dogDetails","result", "responseCode",
		"responseStatus", "status", "userMobileNumber", "operatedPdf",
		"firstVaccinationCertificate", "secondVaccinationCertificate",
		"dogOwnerIdProof", "dogOwnerAddressproof","noOfDog","nocNeighbour","placeDetail"})
public class DogLicenseRestDTO implements Serializable {

	private String title;
	private String name;
	private String fatherName;
	private String surname;
	private String fullName;
	private String cityName;
	private String plotNo;

	private String buildingName;

	private String streetName;

	private String areaName;

	private int pinCode;

	private String nearbyLandmark;

	private long mobileNumber;

	private String emailId;

	private String colonyName;

	private String correspondenceAddress;

	private int zoneNo;

	private String wardNo;

	private List<DogDetailsRestDTO> dogDetails;

	private String result;

	private int responseCode;

	private String responseStatus;

	private String status;

	private long userMobileNumber;

	private String operatedPdf;// not mandatory

	private String firstVaccinationCertificate;

	private String secondVaccinationCertificate;// not mandatory

	private String dogOwnerIdProof;

	private String dogOwnerAddressproof;

	private long noOfDog;
	
	private String nocNeighbour;
	
	private String placeDetail;
	// Getter methods with @XmlElement(name="") annotations

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
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

	@XmlElement(name = "cityName")
	public String getCityName() {
		return cityName;
	}

	@XmlElement(name = "plotNo")
	public String getPlotNo() {
		return plotNo;
	}

	@XmlElement(name = "buildingName")
	public String getBuildingName() {
		return buildingName;
	}

	@XmlElement(name = "streetName")
	public String getStreetName() {
		return streetName;
	}

	@XmlElement(name = "areaName")
	public String getAreaName() {
		return areaName;
	}

	@XmlElement(name = "pinCode")
	public int getPinCode() {
		return pinCode;
	}

	@XmlElement(name = "nearbyLandmark")
	public String getNearbyLandmark() {
		return nearbyLandmark;
	}

	@XmlElement(name = "mobileNumber")
	public long getMobileNumber() {
		return mobileNumber;
	}

	@XmlElement(name = "emailId")
	public String getEmailId() {
		return emailId;
	}

	@XmlElement(name = "colonyName")
	public String getColonyName() {
		return colonyName;
	}

	@XmlElement(name = "correspondenceAddress")
	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	@XmlElement(name = "zoneNo")
	public int getZoneNo() {
		return zoneNo;
	}

	@XmlElement(name = "wardNo")
	public String getWardNo() {
		return wardNo;
	}

	@XmlElement(name = "dogDetails")
	public List<DogDetailsRestDTO> getDogDetails() {
		return dogDetails;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	@XmlElement(name = "responseCode")
	public int getResponseCode() {
		return responseCode;
	}

	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	@XmlElement(name = "operatedPdf")
	public String getOperatedPdf() {
		return operatedPdf;
	}

	@XmlElement(name = "firstVaccinationCertificate")
	public String getFirstVaccinationCertificate() {
		return firstVaccinationCertificate;
	}

	@XmlElement(name = "secondVaccinationCertificate")
	public String getSecondVaccinationCertificate() {
		return secondVaccinationCertificate;
	}

	@XmlElement(name = "dogOwnerIdProof")
	public String getDogOwnerIdProof() {
		return dogOwnerIdProof;
	}

	@XmlElement(name = "dogOwnerAddressproof")
	public String getDogOwnerAddressproof() {
		return dogOwnerAddressproof;
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

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void setNearbyLandmark(String nearbyLandmark) {
		this.nearbyLandmark = nearbyLandmark;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public void setDogDetails(List<DogDetailsRestDTO> dogDetails) {
		this.dogDetails = dogDetails;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public void setResponseCode(int i) {
		this.responseCode = i;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public void setOperatedPdf(String operatedPdf) {
		this.operatedPdf = operatedPdf;
	}

	public void setFirstVaccinationCertificate(
			String firstVaccinationCertificate) {
		this.firstVaccinationCertificate = firstVaccinationCertificate;
	}

	public void setSecondVaccinationCertificate(
			String secondVaccinationCertificate) {
		this.secondVaccinationCertificate = secondVaccinationCertificate;
	}

	public void setDogOwnerIdProof(String dogOwnerIdProof) {
		this.dogOwnerIdProof = dogOwnerIdProof;
	}

	public void setDogOwnerAddressproof(String dogOwnerAddressproof) {
		this.dogOwnerAddressproof = dogOwnerAddressproof;
	}




	@XmlElement(name = "noOfDog")
	public long getNoOfDog() {
		return noOfDog;
	}



	public void setNoOfDog(long noOfDog) {
		this.noOfDog = noOfDog;
	}


	@XmlElement(name = "nocNeighbour")
	public String getNocNeighbour() {
		return nocNeighbour;
	}



	public void setNocNeighbour(String nocNeighbour) {
		this.nocNeighbour = nocNeighbour;
	}


	@XmlElement(name = "placeDetail")
	public String getPlaceDetail() {
		return placeDetail;
	}



	public void setPlaceDetail(String placeDetail) {
		this.placeDetail = placeDetail;
	}

	
}
