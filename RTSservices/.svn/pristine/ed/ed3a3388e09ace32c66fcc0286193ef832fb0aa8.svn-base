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
@Table(name = "property_tax_demand", schema = "egovrti")
public class PropertyTaxDemand {
	
	@Id
	@Column(name = "property_demand_id", nullable = false, unique = true)
	@SequenceGenerator(name = "propertydemand_seq", sequenceName = "propertydemand_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "propertydemand_seq")
	
	private long propertyDemandID;
	
	@Column(name = "title", nullable = true)
	private String title;
	
	@Column(name = "first_name", nullable = true)
	private String firstName;
	
	@Column(name = "middle_name", nullable = true)
	private String middleName;
	
	@Column(name = "last_name", nullable = true)
	private String lastName;
	
	@Column(name = "full_name", nullable = true)
	private String fullName;
	
	@Column(name = "plot_no", nullable = true)
	private String plotNo;
	
	@Column(name = "name_of_building", nullable = true)
	private String buildingName;
	
	@Column(name = "name_of_street", nullable = true)
	private String streetName;
	
	@Column(name = "nearby_landmark", nullable = true)
	private String landmark;
	
	@Column(name = "pincode", nullable = true)
	private String pinCode;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;

	@Column(name = "email_id", nullable = true)
	private String emailId;
	
	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;
	
	@Column(name = "address_for_correspondence", nullable = true)
	private String addressForCorrespondence;
	
	@Column(name = "property_holder_name", nullable = true)
	private String nameOfProperyHolder;
	
	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "ward_no", nullable = true)
	private String wardNo;
	
	@Column(name = "name_of_area", nullable = true)
	private String areaName;
	
	@Column(name = "house_no", nullable = true)
	private String houseNo;
	
	@Column(name = "index_no", nullable = true)
	private String indexNo;
	
	@Column(name = "upin_no", nullable = true)
	private String upinNo;
	
	@Transient
	private String filesPath;
	
	@Column(name = "rti_appl_refno",nullable = true)
	private String rtiApplRefNo;
	
	@Column(name = "rti_ref_id",nullable = true)
	private long rtiRefId;
	
	//New Fields
	@Column(name = "areas_pending")
	private double areasPending;

	@Column(name = "areas_pending_status")
	private String areasPendingStatus;
	
	@Column(name = "dues_amt")
	private double duesAmt;

	public long getPropertyDemandID() {
		return propertyDemandID;
	}

	public void setPropertyDemandID(long propertyDemandID) {
		this.propertyDemandID = propertyDemandID;
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

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddressForCorrespondence() {
		return addressForCorrespondence;
	}

	public void setAddressForCorrespondence(String addressForCorrespondence) {
		this.addressForCorrespondence = addressForCorrespondence;
	}

	public String getNameOfProperyHolder() {
		return nameOfProperyHolder;
	}

	public void setNameOfProperyHolder(String nameOfProperyHolder) {
		this.nameOfProperyHolder = nameOfProperyHolder;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getUpinNo() {
		return upinNo;
	}

	public void setUpinNo(String upinNo) {
		this.upinNo = upinNo;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
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

	public double getDuesAmt() {
		return duesAmt;
	}

	public void setDuesAmt(double duesAmt) {
		this.duesAmt = duesAmt;
	}
	
	
}
