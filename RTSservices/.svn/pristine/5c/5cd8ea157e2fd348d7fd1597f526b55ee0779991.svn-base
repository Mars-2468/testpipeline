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
@Table(name = "newly_constructed_property", schema = "egovrti")
public class NewlyConstructedProperty {

	@Id
	@Column(name = "newly_constructed_property_id", nullable = false, unique = true)
	@SequenceGenerator(name = "newly_constructed_property_seq", sequenceName = "newly_constructed_property_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newly_constructed_property_seq")
	private long newlyConstructedPropertyId;

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
	
	@Column(name = "building_name", nullable = true)
	private String buildingName;

	@Column(name = "street_name", nullable = true)
	private String streetName;

	@Column(name = "area_name", nullable = true)
	private String areaName;

	@Column(name = "landmark", nullable = true)
	private String landmark;

	@Column(name = "pincode", nullable = true)
	private int pinCode;

	@Column(name = "aadhaar_no", nullable = true)
	private String aadhaarNo;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "holders_name", nullable = true)
	private String holdersName;

	@Column(name = "house_no", nullable = true)
	private String houseNo;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;

	@Column(name = "ward_no", nullable = true)
	private String wardNo;


	@Column(name = "index_no", nullable = true)
	private String indexNo;

	@Column(name = "upin_no", nullable = true)
	private String upinNo;

	@Column(name = "property_address", nullable = true)
	private String propertyAddress;

	@Column(name = "area_of_property", nullable = true)
	private String areaOfProperty;
	
	@Column(name="measle_no")
	private String measleNo;

	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;
	
	@Column(name="mouje")
	private String mouje;
	
	
	@Column(name="fees")
	private double fees;
	
	@Column(name="payment_receipt")
	private String paymentReceipt;

	@Column(name="property_id")
	private String propertyId;
	
	//Newly Added Parameters
	@Column(name = "areas_pending")
	private double areasPending;

	@Column(name = "areas_pending_status")
	private String areasPendingStatus;
	
	@Column(name = "dues_amt")
	private double duesAmt;
	
	@Column(name = "ward_number")
	private String blockNo;

	@Column(name = "ward_name")
	private String blockName;
	
	public long getNewlyConstructedPropertyId() {
		return newlyConstructedPropertyId;
	}

	public void setNewlyConstructedPropertyId(long newlyConstructedPropertyId) {
		this.newlyConstructedPropertyId = newlyConstructedPropertyId;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHoldersName() {
		return holdersName;
	}

	public void setHoldersName(String holdersName) {
		this.holdersName = holdersName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
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

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getAreaOfProperty() {
		return areaOfProperty;
	}

	public void setAreaOfProperty(String areaOfProperty) {
		this.areaOfProperty = areaOfProperty;
	}

	public String getMeasleNo() {
		return measleNo;
	}

	public void setMeasleNo(String measleNo) {
		this.measleNo = measleNo;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getMouje() {
		return mouje;
	}

	public void setMouje(String mouje) {
		this.mouje = mouje;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
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




	
	
}
