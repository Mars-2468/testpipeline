package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "emailid", "mobileNo", "propertyHolderName", "zoneNo", "blockId", "blockNo", "blockName",
		"address", "pincode", "userMobileNumber", "result", "responseCode",
		"responseStatus", "status", "houseNo", "khasaraNo", "mouza", "plotNo", "selfAttestedIdProofDoc",
		"akhivtaPatrikaofCitySurveyDoc", "copyOfRegisteredSaleDeedDoc", "buildingMap", "waterBill",
		"regularizationLetter", "anyOtherSupportingDoc" })
public class PropertyTaxNewAssessmentRestDTO {

	private String name;

	private String emailid;

	private String mobileNo;

	private String propertyHolderName;

	private int zoneNo;

	private String blockId;

	private String blockNo;

	private String blockName;

	private String address;

	private String pincode;

	private long userMobileNumber;

	private String result;

	private int responseCode;

	private String responseStatus;

	private String status;

	// Extra Fields

	private String houseNo;

	private String khasaraNo;

	private String mouza;

	private String plotNo;

	// Files

	private String selfAttestedIdProofDoc;

	private String akhivtaPatrikaofCitySurveyDoc;

	private String copyOfRegisteredSaleDeedDoc;

	private String buildingMap;

	private String waterBill;

	private String regularizationLetter;

	private String anyOtherSupportingDoc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPropertyHolderName() {
		return propertyHolderName;
	}

	public void setPropertyHolderName(String propertyHolderName) {
		this.propertyHolderName = propertyHolderName;
	}

	public int getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
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

	public String getResponseStatus() {
		return responseStatus;
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

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	
	public String getKhasaraNo() {
		return khasaraNo;
	}

	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getSelfAttestedIdProofDoc() {
		return selfAttestedIdProofDoc;
	}

	public void setSelfAttestedIdProofDoc(String selfAttestedIdProofDoc) {
		this.selfAttestedIdProofDoc = selfAttestedIdProofDoc;
	}

	public String getAkhivtaPatrikaofCitySurveyDoc() {
		return akhivtaPatrikaofCitySurveyDoc;
	}

	public void setAkhivtaPatrikaofCitySurveyDoc(String akhivtaPatrikaofCitySurveyDoc) {
		this.akhivtaPatrikaofCitySurveyDoc = akhivtaPatrikaofCitySurveyDoc;
	}

	public String getCopyOfRegisteredSaleDeedDoc() {
		return copyOfRegisteredSaleDeedDoc;
	}

	public void setCopyOfRegisteredSaleDeedDoc(String copyOfRegisteredSaleDeedDoc) {
		this.copyOfRegisteredSaleDeedDoc = copyOfRegisteredSaleDeedDoc;
	}

	public String getBuildingMap() {
		return buildingMap;
	}

	public void setBuildingMap(String buildingMap) {
		this.buildingMap = buildingMap;
	}

	public String getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(String waterBill) {
		this.waterBill = waterBill;
	}

	public String getRegularizationLetter() {
		return regularizationLetter;
	}

	public void setRegularizationLetter(String regularizationLetter) {
		this.regularizationLetter = regularizationLetter;
	}

	public String getAnyOtherSupportingDoc() {
		return anyOtherSupportingDoc;
	}

	public void setAnyOtherSupportingDoc(String anyOtherSupportingDoc) {
		this.anyOtherSupportingDoc = anyOtherSupportingDoc;
	}
	
	
	

}
