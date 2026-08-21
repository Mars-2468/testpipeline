package com.mars.rti.ws.model;


	

	import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonPropertyOrder({ "title", "name", "fatherName", "surname",
		"fullName", "pinCode", "aadhaarNo", "emailID", "mobileNumber",
		"adressForCorrespondence", "zoneNo", "wardNo","nameOfArea","tradeLicenceNo","updateTradeName", "updatedTradeType", "updatedOwnerName", "updatedPartnerCount",
		"feesApplicable", "userMobileNumber",
		"responseStatus", "responseCode", "result","status",
		"nocForRelatedDepartment","copyOfFormerLicence","propertyTaxNoDue","buildingAuthorizationDocument"})
	public class TradeLicenseOwnerPartnerChangeRestDTO  implements Serializable{
		private String title;
		private String name;
		private String fatherName;
		private String surname;
		private String fullName;
		private int pinCode;
		private long aadhaarNo;
		private String emailID;
		private long mobileNumber;
		private String adressForCorrespondence;
		private int zoneNo;
		private String wardNo;
		private String nameOfArea;
		
		private String tradeLicenceNo;
		private String updateTradeName;
		private String updatedTradeType;
		private String updatedOwnerName;
		private String updatedPartnerCount;
		private double feesApplicable;
		private long userMobileNumber;

		private String responseStatus;

		private long responseCode;

		private String result;

		private String status;

		//Pdf
		private String nocForRelatedDepartment;
		private String copyOfFormerLicence;
		private String propertyTaxNoDue;
		private String buildingAuthorizationDocument;

		
		@XmlElement(name = "feesApplicable")
		public double getFeesApplicable() {
			return feesApplicable;
		}
		@XmlElement(name = "userMobileNumber")
		public long getUserMobileNumber() {
			return userMobileNumber;
		}
		@XmlElement(name = "nocForRelatedDepartment")
		public String getNocForRelatedDepartment() {
			return nocForRelatedDepartment;
		}
		@XmlElement(name = "copyOfFormerLicence")
		public String getCopyOfFormerLicence() {
			return copyOfFormerLicence;
		}
		@XmlElement(name = "propertyTaxNoDue")
		public String getPropertyTaxNoDue() {
			return propertyTaxNoDue;
		}
		@XmlElement(name = "buildingAuthorizationDocument")
		public String getBuildingAuthorizationDocument() {
			return buildingAuthorizationDocument;
		}

		public void setFeesApplicable(double feesApplicable) {
			this.feesApplicable = feesApplicable;
		}

		public void setUserMobileNumber(long userMobileNumber) {
			this.userMobileNumber = userMobileNumber;
		}

		public void setNocForRelatedDepartment(String nocForRelatedDepartment) {
			this.nocForRelatedDepartment = nocForRelatedDepartment;
		}

		public void setCopyOfFormerLicence(String copyOfFormerLicence) {
			this.copyOfFormerLicence = copyOfFormerLicence;
		}

		public void setPropertyTaxNoDue(String propertyTaxNoDue) {
			this.propertyTaxNoDue = propertyTaxNoDue;
		}

		public void setBuildingAuthorizationDocument(String buildingAuthorizationDocument) {
			this.buildingAuthorizationDocument = buildingAuthorizationDocument;
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
		public void setName(String name) {
			this.name = name;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		@XmlElement(name = "fullName")
		public String getFullName() {
			return fullName;
		}
		@XmlElement(name = "pinCode")
		public int getPinCode() {
			return pinCode;
		}
		
		@XmlElement(name = "aadhaarNo")
		public long getAadhaarNo() {
			return aadhaarNo;
		}
		
		@XmlElement(name = "email")
		public String getEmailID() {
			return emailID;
		}
		
		
		@XmlElement(name = "address")
		public String getAdressForCorrespondence() {
			return adressForCorrespondence;
		}
		@XmlElement(name = "mobileNo")
		public long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		
		
		@XmlElement(name = "wardNo")
		public String getWardNo() {
			return wardNo;
		}
		@XmlElement(name = "zoneNo")
		public int getZoneNo() {
			return zoneNo;
		}

		public void setZoneNo(int zoneNo) {
			this.zoneNo = zoneNo;
		}

		@XmlElement(name = "areaName")
		public String getNameOfArea() {
			return nameOfArea;
		}
		
		@XmlElement(name = "licenceNo")
		public String getTradeLicenceNo() {
			return tradeLicenceNo;
		}
		
		@XmlElement(name = "updateTradeName")
		public String getUpdateTradeName() {
			return updateTradeName;
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
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public void setPinCode(int pinCode) {
			this.pinCode = pinCode;
		}
		public void setAadhaarNo(long aadhaarNo) {
			this.aadhaarNo = aadhaarNo;
		}
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		
		public void setAdressForCorrespondence(String adressForCorrespondence) {
			this.adressForCorrespondence = adressForCorrespondence;
		}
		
		public void setWardNo(String wardNo) {
			this.wardNo = wardNo;
		}
		public void setNameOfArea(String nameOfArea) {
			this.nameOfArea = nameOfArea;
		}
		public void setTradeLicenceNo(String tradeLicenceNo) {
			this.tradeLicenceNo = tradeLicenceNo;
		}
		public void setUpdateTradeName(String updateTradeName) {
			this.updateTradeName = updateTradeName;
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

		

		public String getResult() {
			return result;
		}

		
		public String getResponseStatus() {
			return responseStatus;
		}

		public long getResponseCode() {
			return responseCode;
		}

		public String getStatus() {
			return status;
		}

		public void setResult(String result) {
			this.result = result;
		}

		

		public void setResponseStatus(String responseStatus) {
			this.responseStatus = responseStatus;
		}

		public void setResponseCode(long responseCode) {
			this.responseCode = responseCode;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	

}
