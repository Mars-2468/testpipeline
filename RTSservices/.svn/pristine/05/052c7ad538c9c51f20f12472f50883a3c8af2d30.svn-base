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
@Table(name = "water_pressure", schema = "egovrti")

public class WaterPressure {

	@Id
	@Column(name = "waterpressure_id", nullable = false, unique = true)
	@SequenceGenerator(name = "water_pressure_seq", sequenceName = "water_pressure_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "water_pressure_seq")
	
   private long waterPressureId;
	
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
	private String pinCode;
	
	@Column(name = "aadhar_no", nullable = true)
	private String aadhaarNo;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "address_for_correspondence", nullable = true)
	private String fullAddress; 
	
	@Column(name = "consumer", nullable = true)
	private String consumer;

	@Column(name = "cin_no", nullable = true)
	private String CINNo;
	
	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "existing_zone", nullable = true)
	private String existingZone;

	@Column(name = "existing_esr", nullable = true)
	private String existingEsr;
	
	@Column(name = "esr", nullable = true)
	private String esr;

	@Column(name = "consumer_name", nullable = true)
	private String consumerName;

	@Column(name = "consumer_address", nullable = true)
	private String exitingAddress;
	
	@Column(name = "consumer_no", nullable = true)
	private String consumerNo;
	
	@Column(name = "meter_no", nullable = true)
	private String meterNo;
	
	@Column(name = "deposit_receipt_no", nullable = true)
	private String depositReceiptNo;
	
	@Column(name = "deposit_receipt_date", nullable = true)
	private String depositReceiptDate;
	
	@Column(name = "problem_desc", nullable = true)
	private String problemDesc;
	
	@Transient
	private String filesPath;
	
	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name = "applicant_city")
	private String applicantcity;
	
	public long getWaterPressureId() {
		return waterPressureId;
	}

	public void setWaterPressureId(long waterPressureId) {
		this.waterPressureId = waterPressureId;
	}

	public String getTitle() {
		return title;
	}

	public String getApplicantcity() {
		return applicantcity;
	}

	public void setApplicantcity(String applicantcity) {
		this.applicantcity = applicantcity;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
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

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getCINNo() {
		return CINNo;
	}

	public void setCINNo(String cINNo) {
		CINNo = cINNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getExistingZone() {
		return existingZone;
	}

	public void setExistingZone(String existingZone) {
		this.existingZone = existingZone;
	}

	public String getExistingEsr() {
		return existingEsr;
	}

	public void setExistingEsr(String existingEsr) {
		this.existingEsr = existingEsr;
	}

	public String getEsr() {
		return esr;
	}

	public void setEsr(String esr) {
		this.esr = esr;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getExitingAddress() {
		return exitingAddress;
	}

	public void setExitingAddress(String exitingAddress) {
		this.exitingAddress = exitingAddress;
	}

	public String getConsumerNo() {
		return consumerNo;
	}

	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getDepositReceiptNo() {
		return depositReceiptNo;
	}

	public void setDepositReceiptNo(String depositReceiptNo) {
		this.depositReceiptNo = depositReceiptNo;
	}

	public String getDepositReceiptDate() {
		return depositReceiptDate;
	}

	public void setDepositReceiptDate(String depositReceiptDate) {
		this.depositReceiptDate = depositReceiptDate;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
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
	@Column(name = "tap_size", nullable = true)
	  private String tap_size;
	
	@Column(name = "category", nullable = true)
      private String category;
	
	@Column(name = "balance_arrears", nullable = true)
      private String balance_arrears;
	
	@Column(name = "cut_off_date", nullable = true)
      private String cut_off_date;

	public String getTap_size() {
		return tap_size;
	}

	public void setTap_size(String tap_size) {
		this.tap_size = tap_size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBalance_arrears() {
		return balance_arrears;
	}

	public void setBalance_arrears(String balance_arrears) {
		this.balance_arrears = balance_arrears;
	}

	public String getCut_off_date() {
		return cut_off_date;
	}

	public void setCut_off_date(String cut_off_date) {
		this.cut_off_date = cut_off_date;
	}
	@Column(name = "demand_fees", nullable = true)
	private String demandfees;
	
	@Column(name = "uploaded_demand", nullable = true)
	private String uploadedDemand;
	
	@Column(name = "payment_status", nullable = true)
	private String paymentStatus;
	
	@Column(name = "acknowledgement", nullable = true)
	private String acknowledgement;

	public String getDemandfees() {
		return demandfees;
	}

	public void setDemandfees(String demandfees) {
		this.demandfees = demandfees;
	}

	public String getUploadedDemand() {
		return uploadedDemand;
	}

	public void setUploadedDemand(String uploadedDemand) {
		this.uploadedDemand = uploadedDemand;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	

	
	

	 
	
}
