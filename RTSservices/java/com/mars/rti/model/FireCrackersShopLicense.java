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
@Table( name = "fire_crackers_shop_license", schema="egovrti")
public class FireCrackersShopLicense {
	
	@Id
	@Column(name ="fire_crackers_shop_license_id",nullable=false,unique=true)
	@SequenceGenerator(name = "fire_crackers_shop_license_seq", sequenceName = "fire_crackers_shop_license_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_crackers_shop_license_seq")
	private long fireCrackersShopLicenseId;
	
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

	@Column(name = "pincode", nullable = true)
	private int pinCode;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;
	
	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "txt_date_of_birth", nullable = true)
	private String txtDateOfBirth;
	
	@Column(name = "agee", nullable = true)
	private String agee;
	
	@Column(name = "qualification_exp", nullable = true)
	private String qualificationExp;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "zone_no", nullable = true)
	private String zoneNo;

	@Column(name = "ward_no", nullable = true)
	private String wardNo;
	
	@Column(name = "near_by_police_station", nullable = true)
	private String nearByPoliceStation;
	
	@Column(name = "near_by_railway_station", nullable = true)
	private String nearByRailwayStation;
	
	@Column(name = "shop_location", nullable = true)
	private String shopLocation;
	
	@Column(name = "pavilion_start_date", nullable = true)
	private String pavilionStartDate;
	
	@Column(name = "pavilion_end_date", nullable = true)
	private String pavilionEndDate;
	
	@Column(name = "previous_license", nullable = true)
	private String previousLicense;
	
	@Column(name = "previous_license_number", nullable = true)
	private String previousLicenseNumber;
	
	@Column(name = "previousLicense_name_and_address", nullable = true)
	private String previousLicenseNameAndAddress;
	
	@Column(name = "reason_of_cancelation", nullable = true)
	private String reasonOfCancelation;
	
	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;
	
	@Column(name="nocfee")
	private double nocfee;
	
	@Column(name="environmentalfee")
	private double environmentalfee;
	
	@Column(name="totalfee")
	private double totalfee;
	
	@Column(name="name_of_professional")
	private String nameOfProfessional;
	
	
	@Column(name="place_of_establishment")
	private String placeOfEstablishment;
	
	@Column(name="fireremarks")
	private String fireremarks;
	
	@Column(name="fire_noc")
	private String fireNoc;
	

	public long getFireCrackersShopLicenseId() {
		return fireCrackersShopLicenseId;
	}

	public void setFireCrackersShopLicenseId(long fireCrackersShopLicenseId) {
		this.fireCrackersShopLicenseId = fireCrackersShopLicenseId;
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

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
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

	public String getTxtDateOfBirth() {
		return txtDateOfBirth;
	}

	public void setTxtDateOfBirth(String txtDateOfBirth) {
		this.txtDateOfBirth = txtDateOfBirth;
	}

	public String getAgee() {
		return agee;
	}

	public void setAgee(String agee) {
		this.agee = agee;
	}

	public String getQualificationExp() {
		return qualificationExp;
	}

	public void setQualificationExp(String qualificationExp) {
		this.qualificationExp = qualificationExp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getNearByPoliceStation() {
		return nearByPoliceStation;
	}

	public void setNearByPoliceStation(String nearByPoliceStation) {
		this.nearByPoliceStation = nearByPoliceStation;
	}

	public String getNearByRailwayStation() {
		return nearByRailwayStation;
	}

	public void setNearByRailwayStation(String nearByRailwayStation) {
		this.nearByRailwayStation = nearByRailwayStation;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public String getPavilionStartDate() {
		return pavilionStartDate;
	}

	public void setPavilionStartDate(String pavilionStartDate) {
		this.pavilionStartDate = pavilionStartDate;
	}

	public String getPavilionEndDate() {
		return pavilionEndDate;
	}

	public void setPavilionEndDate(String pavilionEndDate) {
		this.pavilionEndDate = pavilionEndDate;
	}

	public String getPreviousLicense() {
		return previousLicense;
	}

	public void setPreviousLicense(String previousLicense) {
		this.previousLicense = previousLicense;
	}

	public String getPreviousLicenseNumber() {
		return previousLicenseNumber;
	}

	public void setPreviousLicenseNumber(String previousLicenseNumber) {
		this.previousLicenseNumber = previousLicenseNumber;
	}

	public String getPreviousLicenseNameAndAddress() {
		return previousLicenseNameAndAddress;
	}

	public void setPreviousLicenseNameAndAddress(String previousLicenseNameAndAddress) {
		this.previousLicenseNameAndAddress = previousLicenseNameAndAddress;
	}

	public String getReasonOfCancelation() {
		return reasonOfCancelation;
	}

	public void setReasonOfCancelation(String reasonOfCancelation) {
		this.reasonOfCancelation = reasonOfCancelation;
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

	public double getNocfee() {
		return nocfee;
	}

	public void setNocfee(double nocfee) {
		this.nocfee = nocfee;
	}

	public double getEnvironmentalfee() {
		return environmentalfee;
	}

	public void setEnvironmentalfee(double environmentalfee) {
		this.environmentalfee = environmentalfee;
	}

	public double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}

	public String getNameOfProfessional() {
		return nameOfProfessional;
	}

	public void setNameOfProfessional(String nameOfProfessional) {
		this.nameOfProfessional = nameOfProfessional;
	}

	public String getPlaceOfEstablishment() {
		return placeOfEstablishment;
	}

	public void setPlaceOfEstablishment(String placeOfEstablishment) {
		this.placeOfEstablishment = placeOfEstablishment;
	}


	

	public String getFireremarks() {
		return fireremarks;
	}

	public void setFireremarks(String fireremarks) {
		this.fireremarks = fireremarks;
	}

	public String getFireNoc() {
		return fireNoc;
	}

	public void setFireNoc(String fireNoc) {
		this.fireNoc = fireNoc;
	}

	

	
	
	
}
