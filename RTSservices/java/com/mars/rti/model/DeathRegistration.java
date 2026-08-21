package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "death_registration_service", schema = "egovrti" )
public class DeathRegistration implements java.io.Serializable{
	
	@Id	
	@Column(name="death_registration_id", nullable=false ,unique=true)	
	@SequenceGenerator(name="death_registration_id_seq", sequenceName="death_registration_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="death_registration_id_seq") 
	private long deathRegistrationId;
	
	@Column(name = "date_of_birth", nullable = true)
	private String dateOfBirth;
	
	@Column(name = "date_of_death", nullable = true)
	private String dateOfDeath;
	
	@Column(name = "place_of_death", nullable = true)
	private String placeOfDeath;
	
	
	@Column(name = "age_at_death_time", nullable = true)
	private String ageAtDeathTime;
	
	
	@Column(name = "infant_age", nullable = true)
	private String infantAge;
	
	@Column(name = "gender", nullable = true)
	private String gender;
	
	
	@Column(name = "applicant_name", nullable = true)
	private String applicantName;
	
	@Column(name = "applicant_address", nullable = true)
	private String applicantAddress;
	
	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "email_id", nullable = true)
	private String emailId;
	
	@Column(name = "name_of_deceased", nullable = true)
	private String nameOfDeceased;
	
	@Column(name = "father_name", nullable = true)
	private String fatherName;
	
	@Column(name = "address_of_deceased", nullable = true)
	private String addressOfDeceased;
	
	@Column(name = "reason_of_death", nullable = true)
	private String reasonOfDeath;
	
	@Column(name = "old_registration_number", nullable = true)
	private String oldRegistrationNumber;
	
	/*
	 * @Column(name = "name_of_crematorium", nullable = true) private String
	 * nameOfCrematorium;
	 */
	
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
	
	@Column(name = "name_of_crematorium", nullable = true)
	private String nameofCrematorium;
	
	
	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;
	

	@Column(name = "grandfather_name", nullable = true)
	private String grandfatherName;
	

	@Column(name = "mothername", nullable = true)
	private String motherName;
	

	@Column(name = "hospital_name", nullable = true)
	private String hospitalName;
	

	@Column(name = "zone_no", nullable = true)
	private String zone;
	
	@Column(name = "wife_name", nullable = true)
	private String wifeName;
	
	@Column(name = "death_type", nullable = true)
	private String deathType;
	
	@Column(name = "reason_for_certificate", nullable = true)
	private String reasonForCertificate;
	
	@Column(name = "applicant_title", nullable = true)
	 private String applicantTitle;
	
	@Column(name = "aplcnt_first_name", nullable = true)
	private String applicantFirstName;
	
	@Column(name = "aplcnt_middle_name", nullable = true)
	private String applicantMiddleName;
	
	@Column(name = "aplcnt_last_name", nullable = true)
	private String applicantLastName;
	
	@Column(name = "aplcnt_plot_no", nullable = true)
	 private String applicantPlotNo;
	  
	@Column(name = "aplcnt_building_name", nullable = true)
	  private String applicantBuildingName;
	 
	@Column(name = "aplcnt_street", nullable = true)
	  private String applicantStreet;
	 
	@Column(name = "aplcnt_area", nullable = true)
	 private String applicantArea;
	  
	@Column(name = "aplcnt_nearby_landmark", nullable = true)
	  private String applicantNearByLandmark;
	  
	@Column(name = "aplcnt_pincode", nullable = true)
	  private String applicantPinCode;
	  
	  //private String applicemailId;
	  
	@Column(name = "aplcnt_relationship", nullable = true)
	  private String applicantRelationship;
	  
	@Column(name = "aplcnt_corspndnce_addrs", nullable = true)
	  private String applicantCorrespondenceAddress;
	
	@Column(name = "crtificate_expctd_in_days", nullable = true)
	private String certificateExpectedInDays;
	
	@Column(name = "crtificate_copies", nullable = true)
	private String noOfCertificateCopies;
	
	@Column(name = "fees_applicable", nullable = true)
	private String feesApplicable;
	 
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	public long getDeathRegistrationId() {
		return deathRegistrationId;
	}

	public void setDeathRegistrationId(long deathRegistrationId) {
		this.deathRegistrationId = deathRegistrationId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getPlaceOfDeath() {
		return placeOfDeath;
	}

	public void setPlaceOfDeath(String placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}

	public String getAgeAtDeathTime() {
		return ageAtDeathTime;
	}

	public void setAgeAtDeathTime(String ageAtDeathTime) {
		this.ageAtDeathTime = ageAtDeathTime;
	}

	public String getInfantAge() {
		return infantAge;
	}

	public void setInfantAge(String infantAge) {
		this.infantAge = infantAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNameOfDeceased() {
		return nameOfDeceased;
	}

	public void setNameOfDeceased(String nameOfDeceased) {
		this.nameOfDeceased = nameOfDeceased;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddressOfDeceased() {
		return addressOfDeceased;
	}

	public void setAddressOfDeceased(String addressOfDeceased) {
		this.addressOfDeceased = addressOfDeceased;
	}

	public String getReasonOfDeath() {
		return reasonOfDeath;
	}

	public void setReasonOfDeath(String reasonOfDeath) {
		this.reasonOfDeath = reasonOfDeath;
	}

	public String getOldRegistrationNumber() {
		return oldRegistrationNumber;
	}

	public void setOldRegistrationNumber(String oldRegistrationNumber) {
		this.oldRegistrationNumber = oldRegistrationNumber;
	}

	public String getNameofCrematorium() {
		return nameofCrematorium;
	}

	public void setNameofCrematorium(String nameofCrematorium) {
		this.nameofCrematorium = nameofCrematorium;
	}

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getGrandfatherName() {
		return grandfatherName;
	}

	public void setGrandfatherName(String grandfatherName) {
		this.grandfatherName = grandfatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public String getDeathType() {
		return deathType;
	}

	public void setDeathType(String deathType) {
		this.deathType = deathType;
	}

	public String getReasonForCertificate() {
		return reasonForCertificate;
	}

	public void setReasonForCertificate(String reasonForCertificate) {
		this.reasonForCertificate = reasonForCertificate;
	}

	public String getApplicantTitle() {
		return applicantTitle;
	}

	public void setApplicantTitle(String applicantTitle) {
		this.applicantTitle = applicantTitle;
	}

	public String getApplicantRelationship() {
		return applicantRelationship;
	}

	public void setApplicantRelationship(String applicantRelationship) {
		this.applicantRelationship = applicantRelationship;
	}

	public String getApplicantCorrespondenceAddress() {
		return applicantCorrespondenceAddress;
	}

	public void setApplicantCorrespondenceAddress(String applicantCorrespondenceAddress) {
		this.applicantCorrespondenceAddress = applicantCorrespondenceAddress;
	}

	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}

	public String getApplicantMiddleName() {
		return applicantMiddleName;
	}

	public void setApplicantMiddleName(String applicantMiddleName) {
		this.applicantMiddleName = applicantMiddleName;
	}

	public String getApplicantLastName() {
		return applicantLastName;
	}

	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
	}

	public String getApplicantPlotNo() {
		return applicantPlotNo;
	}

	public void setApplicantPlotNo(String applicantPlotNo) {
		this.applicantPlotNo = applicantPlotNo;
	}

	public String getApplicantBuildingName() {
		return applicantBuildingName;
	}

	public void setApplicantBuildingName(String applicantBuildingName) {
		this.applicantBuildingName = applicantBuildingName;
	}

	public String getApplicantStreet() {
		return applicantStreet;
	}

	public void setApplicantStreet(String applicantStreet) {
		this.applicantStreet = applicantStreet;
	}

	public String getApplicantArea() {
		return applicantArea;
	}

	public void setApplicantArea(String applicantArea) {
		this.applicantArea = applicantArea;
	}

	public String getApplicantNearByLandmark() {
		return applicantNearByLandmark;
	}

	public void setApplicantNearByLandmark(String applicantNearByLandmark) {
		this.applicantNearByLandmark = applicantNearByLandmark;
	}

	public String getApplicantPinCode() {
		return applicantPinCode;
	}

	public void setApplicantPinCode(String applicantPinCode) {
		this.applicantPinCode = applicantPinCode;
	}

	public String getCertificateExpectedInDays() {
		return certificateExpectedInDays;
	}

	public void setCertificateExpectedInDays(String certificateExpectedInDays) {
		this.certificateExpectedInDays = certificateExpectedInDays;
	}

	public String getNoOfCertificateCopies() {
		return noOfCertificateCopies;
	}

	public void setNoOfCertificateCopies(String noOfCertificateCopies) {
		this.noOfCertificateCopies = noOfCertificateCopies;
	}

	public String getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(String feesApplicable) {
		this.feesApplicable = feesApplicable;
	}

	

	
}
