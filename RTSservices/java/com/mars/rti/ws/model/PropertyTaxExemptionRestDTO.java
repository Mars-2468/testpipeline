package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "emailid", "mobileNo", "propertyHolderName", "zoneNo", "blockId", "blockNo", "blockName",
		"upinNo", "indexNo", "address", "ownerName", "areasPending", "areasPendingStatus",
		"taxMobileNo", "pincode", "duesAmt", "userMobileNumber", "result", "responseCode", "responseStatus", "status",
		"reason", "exemptionRegarding", "medalNo", "armyNo", "propertyId", "selfAttestedIdProofDoc",
		"iDexServiceManDoc", "photographOfExServicemen", "charityDoc", "auditReportDoc", "anyOtherSupportingDoc" })
public class PropertyTaxExemptionRestDTO {

	private String name;

	private String emailid;

	private String mobileNo;

	private String propertyHolderName;

	private int zoneNo;

	private String blockId;

	private String blockNo;

	private String blockName;

	private String upinNo;

	private String indexNo;

	private String address;

	private String ownerName;

	private double areasPending;

	private String areasPendingStatus;

	private String taxMobileNo;

	private String pincode;

	private double duesAmt;

	private long userMobileNumber;

	private String result;

	private int responseCode;

	private String responseStatus;

	private String status;

	// Extra Fields

	private String reason;

	private String exemptionRegarding;

	private String medalNo;

	private String armyNo;

	private String propertyId;

	// Files

	private String selfAttestedIdProofDoc;

	private String iDexServiceManDoc;

	private String photographOfExServicemen;

	private String charityDoc;

	private String auditReportDoc;

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

	public String getUpinNo() {
		return upinNo;
	}

	public void setUpinNo(String upinNo) {
		this.upinNo = upinNo;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getAreasPending() {
		return areasPending;
	}

	public void setAreasPending(double areasPending) {
		this.areasPending = areasPending;
	}

	public String getAreasPendingStatus() {
		return areasPendingStatus;
	}

	public void setAreasPendingStatus(String areasPendingStatus) {
		this.areasPendingStatus = areasPendingStatus;
	}


	public String getTaxMobileNo() {
		return taxMobileNo;
	}

	public void setTaxMobileNo(String taxMobileNo) {
		this.taxMobileNo = taxMobileNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getDuesAmt() {
		return duesAmt;
	}

	public void setDuesAmt(double duesAmt) {
		this.duesAmt = duesAmt;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getExemptionRegarding() {
		return exemptionRegarding;
	}

	public void setExemptionRegarding(String exemptionRegarding) {
		this.exemptionRegarding = exemptionRegarding;
	}

	public String getMedalNo() {
		return medalNo;
	}

	public void setMedalNo(String medalNo) {
		this.medalNo = medalNo;
	}

	public String getArmyNo() {
		return armyNo;
	}

	public void setArmyNo(String armyNo) {
		this.armyNo = armyNo;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getSelfAttestedIdProofDoc() {
		return selfAttestedIdProofDoc;
	}

	public void setSelfAttestedIdProofDoc(String selfAttestedIdProofDoc) {
		this.selfAttestedIdProofDoc = selfAttestedIdProofDoc;
	}

	public String getiDexServiceManDoc() {
		return iDexServiceManDoc;
	}

	public void setiDexServiceManDoc(String iDexServiceManDoc) {
		this.iDexServiceManDoc = iDexServiceManDoc;
	}

	public String getPhotographOfExServicemen() {
		return photographOfExServicemen;
	}

	public void setPhotographOfExServicemen(String photographOfExServicemen) {
		this.photographOfExServicemen = photographOfExServicemen;
	}

	public String getCharityDoc() {
		return charityDoc;
	}

	public void setCharityDoc(String charityDoc) {
		this.charityDoc = charityDoc;
	}

	public String getAuditReportDoc() {
		return auditReportDoc;
	}

	public void setAuditReportDoc(String auditReportDoc) {
		this.auditReportDoc = auditReportDoc;
	}

	public String getAnyOtherSupportingDoc() {
		return anyOtherSupportingDoc;
	}

	public void setAnyOtherSupportingDoc(String anyOtherSupportingDoc) {
		this.anyOtherSupportingDoc = anyOtherSupportingDoc;
	}


	

}
