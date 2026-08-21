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
@Table(name = "death_registration_service", schema = "egovrti")
public class DeathCertificate {

	@Id
	@Column(name = "death_registration_id", nullable = false, unique = true)
	@SequenceGenerator(name = "death_registration_seq", sequenceName = "death_registration_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "death_registration_seq")
	private long death_registration_id;

	@Column(name = "applicant_title", nullable = true)
	private String applicantTitle;

	@Column(name = "aplcnt_first_name", nullable = true)
	private String applicantFirstName;

	@Column(name = "aplcnt_middle_name", nullable = true)
	private String applicantMiddleName;

	@Column(name = "aplcnt_last_name", nullable = true)
	private String applicantLastName;

	@Column(name = "applicant_full_name", nullable = true)
	private String applicantFullName;

	@Column(name = "aplcnt_plot_no", nullable = true)
	private String applicantPlotNo;

	@Column(name = "aplcnt_building_name", nullable = true)
	private String applicantBuildingName;

	@Column(name = "aplcnt_area", nullable = true)
	private String applicantAreaName;

	@Column(name = "aplcnt_nearby_landmark", nullable = true)
	private String applicantNearbyLandmark;

	@Column(name = "aplcnt_pincode", nullable = true)
	private String applicantPinCode;

	@Column(name = "aplcnt_relationship", nullable = true)
	private String applicantRelationship;

	@Column(name = "aplcnt_street", nullable = true)
	private String applicantStreetName;

	@Column(name = "aplcnt_mobile_no", nullable = true)
	private String ph_no;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "aplcnt_corspndnce_addrs", nullable = true)
	private String address;

	@Column(name = "father_name", nullable = true)
	private String fatherName;

	@Column(name = "mother_name", nullable = true)
	private String motherName;

	@Column(name = "wife_name", nullable = true)
	private String wifeName;

	@Column(name = "grandfather_name", nullable = true)
	private String grandfatherName;

	@Column(name = "gender", nullable = true)
	private String gender;

	@Column(name = "name_of_deceased", nullable = true)
	private String nameOfDeceased;

	@Column(name = "infant_age", nullable = true)
	private String infantAge;

	@Column(name = "date_of_death", nullable = true)
	private String dateOfDeath;

	@Column(name = "place_of_death", nullable = true)
	private String placeOfDeath;

	@Column(name = "aadhaar_no", nullable = true)
	private String aadhaarNo;
	
	@Column(name = "death_type", nullable = true)
	private String deathType;

	
	@Column(name = "body_donated", nullable = true)
	private String bodyDonated;


	@Column(name = "zone_no", nullable = true)
	private String zone;

	@Column(name = "name_of_crematorium", nullable = true)
	private String nameofCrematorium;

	@Column(name = "reason_of_death", nullable = true)
	private String reasonOfDeath;

	@Column(name = "reason_for_certificate", nullable = true)
	private String reasonForCertificate;

	@Column(name = "same", nullable = true)
	private String certificateExpectedInDays;
	
	@Column(name = "hospital_name", nullable = true)
	private String hospitalName;


	@Column(name = "crtificate_copies", nullable = true)
	private long noOfCertificateCopies;

	@Column(name = "fees_applicable", nullable = true)
	private double feesApplicable;

	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

//	@Column(name = "pdf_files_saved_path", nullable = true)
//	private String pdfFilesSavedPath;

	@Transient
	private String filesPath;

	public long getDeath_registration_id() {
		return death_registration_id;
	}

	public void setDeath_registration_id(long death_registration_id) {
		this.death_registration_id = death_registration_id;
	}

	public String getApplicantTitle() {
		return applicantTitle;
	}

	public void setApplicantTitle(String applicantTitle) {
		this.applicantTitle = applicantTitle;
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

	public String getApplicantAreaName() {
		return applicantAreaName;
	}

	public void setApplicantAreaName(String applicantAreaName) {
		this.applicantAreaName = applicantAreaName;
	}

	public String getApplicantNearbyLandmark() {
		return applicantNearbyLandmark;
	}

	public void setApplicantNearbyLandmark(String applicantNearbyLandmark) {
		this.applicantNearbyLandmark = applicantNearbyLandmark;
	}

	public String getApplicantPinCode() {
		return applicantPinCode;
	}

	public void setApplicantPinCode(String applicantPinCode) {
		this.applicantPinCode = applicantPinCode;
	}

	public String getApplicantRelationship() {
		return applicantRelationship;
	}

	public void setApplicantRelationship(String applicantRelationship) {
		this.applicantRelationship = applicantRelationship;
	}

	public String getApplicantStreetName() {
		return applicantStreetName;
	}

	public void setApplicantStreetName(String applicantStreetName) {
		this.applicantStreetName = applicantStreetName;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public String getGrandfatherName() {
		return grandfatherName;
	}

	public void setGrandfatherName(String grandfatherName) {
		this.grandfatherName = grandfatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNameOfDeceased() {
		return nameOfDeceased;
	}

	public void setNameOfDeceased(String nameOfDeceased) {
		this.nameOfDeceased = nameOfDeceased;
	}

	public String getInfantAge() {
		return infantAge;
	}

	public void setInfantAge(String infantAge) {
		this.infantAge = infantAge;
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

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getNameofCrematorium() {
		return nameofCrematorium;
	}

	public void setNameofCrematorium(String nameofCrematorium) {
		this.nameofCrematorium = nameofCrematorium;
	}

	public String getReasonOfDeath() {
		return reasonOfDeath;
	}

	public void setReasonOfDeath(String reasonOfDeath) {
		this.reasonOfDeath = reasonOfDeath;
	}

	public String getReasonForCertificate() {
		return reasonForCertificate;
	}

	public void setReasonForCertificate(String reasonForCertificate) {
		this.reasonForCertificate = reasonForCertificate;
	}

//	public String getCertificateExpectedInDays() {
//		return certificateExpectedInDays;
//	}
//
//	public void setCertificateExpectedInDays(String certificateExpectedInDays) {
//		this.certificateExpectedInDays = certificateExpectedInDays;
//	}

	public long getNoOfCertificateCopies() {
		return noOfCertificateCopies;
	}

	public void setNoOfCertificateCopies(long noOfCertificateCopies) {
		this.noOfCertificateCopies = noOfCertificateCopies;
	}

	public double getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(double feesApplicable) {
		this.feesApplicable = feesApplicable;
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

	public String getDeathType() {
		return deathType;
	}

	public void setDeathType(String deathType) {
		this.deathType = deathType;
	}

//	public String getPdfFilesSavedPath() {
//		return pdfFilesSavedPath;
//	}
//
//	public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
//		this.pdfFilesSavedPath = pdfFilesSavedPath;
//	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	
	public String getCertificateExpectedInDays() {
		return certificateExpectedInDays;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setCertificateExpectedInDays(String certificateExpectedInDays) {
		this.certificateExpectedInDays = certificateExpectedInDays;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	@Column(name = "city_name", nullable = true)
	private String cityName;

	@Column(name = "death_home_address", nullable = true)
	private String deathHomeAddress;

	public String getCityName() {
		return cityName;
	}

	public String getDeathHomeAddress() {
		return deathHomeAddress;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setDeathHomeAddress(String deathHomeAddress) {
		this.deathHomeAddress = deathHomeAddress;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getBodyDonated() {
		return bodyDonated;
	}

	public void setBodyDonated(String bodyDonated) {
		this.bodyDonated = bodyDonated;
	}
	
	
}
