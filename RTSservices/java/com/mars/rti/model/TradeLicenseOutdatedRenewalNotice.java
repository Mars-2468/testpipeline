package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tradelicense_outdated_renewalnotice", schema = "egovrti")
public class TradeLicenseOutdatedRenewalNotice {
	
	@Id
	@Column(name = "tradelicense_outdatedrenewal_id", nullable = false, unique = true)
	@SequenceGenerator(name = "tradeLicenseoutdatedrenewal_seq", sequenceName = "tradeLicenseoutdatedrenewal_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tradeLicenseoutdatedrenewal_seq")
	private long tradeLicenseOutdatedRenewalID;

	@Column(name = "title")
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "pincode")
	private int pinCode;

	@Column(name = "aadhaar_no")
	private long aadhaarNo;

	@Column(name = "email")
	private String emailID;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "address_for_correspondence")
	private String adressForCorrespondence;

	@Column(name = "zone_no")
	private String zoneNo;

	@Column(name = "ward_no")
	private String wardNo;

	@Column(name = "area_name")
	private String nameOfArea;

	@Column(name = "trade_licenseno")
	private String tradeLicenceNo;

	@Column(name = "updated_trade_name")
	private String updateTradeName;

	@Column(name = "updated_trade_type")
	private String updatedTradeType;

	@Column(name = "updated_owner_name")
	private String updatedOwnerName;

	@Column(name = "updated_partner_count")
	private String updatedPartnerCount;

	@Column(name = "noc_for_related_dept")
	private String nocForRelatedDepartment;

	@Column(name = "copy_Of_former_license")
	private String copyOfFormerLicence;

	@Column(name = "property_tax_no_due")
	private String propertyTaxNoDue;

	@Column(name = "building_auth_document")
	private String buildingAuthorizationDocument;
	
	@Column(name = "rti_appl_refno",nullable = true)
	private String rtiApplRefNo;
	
	@Column(name = "rti_ref_id",nullable = true)
	private long rtiRefId;
	
	@Transient
	private String filesPath;
	
	@Column(name = "fees_applicable",nullable = true)
	private double feesApplicable;

	public long getTradeLicenseOutdatedRenewalID() {
		return tradeLicenseOutdatedRenewalID;
	}

	public void setTradeLicenseOutdatedRenewalID(long tradeLicenseOutdatedRenewalID) {
		this.tradeLicenseOutdatedRenewalID = tradeLicenseOutdatedRenewalID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdressForCorrespondence() {
		return adressForCorrespondence;
	}

	public void setAdressForCorrespondence(String adressForCorrespondence) {
		this.adressForCorrespondence = adressForCorrespondence;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getNameOfArea() {
		return nameOfArea;
	}

	public void setNameOfArea(String nameOfArea) {
		this.nameOfArea = nameOfArea;
	}

	public String getTradeLicenceNo() {
		return tradeLicenceNo;
	}

	public void setTradeLicenceNo(String tradeLicenceNo) {
		this.tradeLicenceNo = tradeLicenceNo;
	}

	public String getUpdateTradeName() {
		return updateTradeName;
	}

	public void setUpdateTradeName(String updateTradeName) {
		this.updateTradeName = updateTradeName;
	}

	public String getUpdatedTradeType() {
		return updatedTradeType;
	}

	public void setUpdatedTradeType(String updatedTradeType) {
		this.updatedTradeType = updatedTradeType;
	}

	public String getUpdatedOwnerName() {
		return updatedOwnerName;
	}

	public void setUpdatedOwnerName(String updatedOwnerName) {
		this.updatedOwnerName = updatedOwnerName;
	}

	public String getUpdatedPartnerCount() {
		return updatedPartnerCount;
	}

	public void setUpdatedPartnerCount(String updatedPartnerCount) {
		this.updatedPartnerCount = updatedPartnerCount;
	}

	public String getNocForRelatedDepartment() {
		return nocForRelatedDepartment;
	}

	public void setNocForRelatedDepartment(String nocForRelatedDepartment) {
		this.nocForRelatedDepartment = nocForRelatedDepartment;
	}

	public String getCopyOfFormerLicence() {
		return copyOfFormerLicence;
	}

	public void setCopyOfFormerLicence(String copyOfFormerLicence) {
		this.copyOfFormerLicence = copyOfFormerLicence;
	}

	public String getPropertyTaxNoDue() {
		return propertyTaxNoDue;
	}

	public void setPropertyTaxNoDue(String propertyTaxNoDue) {
		this.propertyTaxNoDue = propertyTaxNoDue;
	}

	public String getBuildingAuthorizationDocument() {
		return buildingAuthorizationDocument;
	}

	public void setBuildingAuthorizationDocument(String buildingAuthorizationDocument) {
		this.buildingAuthorizationDocument = buildingAuthorizationDocument;
	}

	public String getRtiApplRefNo() {
		return rtiApplRefNo;
	}

	public void setRtiApplRefNo(String rtiApplRefNo) {
		this.rtiApplRefNo = rtiApplRefNo;
	}

	public long getRtiRefId() {
		return rtiRefId;
	}

	public void setRtiRefId(long rtiRefId) {
		this.rtiRefId = rtiRefId;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public double getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(double feesApplicable) {
		this.feesApplicable = feesApplicable;
	}

}
