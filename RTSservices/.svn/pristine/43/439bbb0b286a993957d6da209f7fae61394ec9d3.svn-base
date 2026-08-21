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
@Table(name = "birth_registration_service", schema = "egovrti")
public class BirthCertificate {

	@Id
	@Column(name = "birth_registration_id", nullable = false, unique = true)
	@SequenceGenerator(name = "birth_registration_seq", sequenceName = "birth_registration_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "birth_registration_seq")
	private long birthRegistrationId;
	
	@Column(name = "applicant_address", nullable = true )
	private String address;
	
	@Column(name = "applicant_name", nullable = true )
	private String name;
	
	@Column(name = "mobile_no", nullable = true )
	private String ph_no;
	
	@Column(name = "email_id", nullable = true )
	private String email;
	
    @Column(name = "date_of_birth", nullable = true )
    private String dob;
	 
	@Column(name = "gender", nullable = true )
	private String gender;
	
	@Column(name = "child_name", nullable = true )
	private String childeName;
	
	@Column(name = "father_name", nullable = true )
	private String fatherName;
	
	@Column(name = "mother_name", nullable = true )
	private String motherName;
	
	@Column(name = "applcnt_title", nullable = true )
	private String applicantTitle;
	  
	 @Column(name = "first_name", nullable = true )
	  private String  applicantFirstName;
	  
	 @Column(name = "middle_name", nullable = true )
	  private String applicantMiddleName;
	  
	 @Column(name = "last_name", nullable = true )
	  private String applicantLastName;
	  
	 @Column(name = "plot_no", nullable = true )
	  private String applicantPlotNo;
	  
	 @Column(name = "building_name", nullable = true )
	  private String applicantBuildingName;
	  
	 @Column(name = "area_name", nullable = true )
	  private String applicantAreaName;
	  
	 @Column(name = "nearby_landmark", nullable = true )
	  private String applicantNearbyLandmark;
	  
	 @Column(name = "pincode", nullable = true )
	  private String applicantPinCode;
	  
	 @Column(name = "applicant_relationship", nullable = true )
	  private String applicantRelationship;
	 
	 @Column(name = "street_name", nullable = true )
	 private String applicantStreetName;
	 
	 @Column(name = "blood_group", nullable = true ) 
	 private String bloodGroup;
	 
	  @Column(name = "blood_relation", nullable = true )
	  private String bloodRelation;
	  
	  @Column(name = "place_of_birth", nullable = true ) 
	  private String placeofbirth;
	  
	  @Column(name = "zone_no", nullable = true )
	  private String zone;
	  
	  @Column(name="hospital_name")
	  private String hospitalName;
	  
	  @Column(name = "certificate_reason", nullable = true ) 
	  private String reasonForCertificate;
	  
	  @Column(name = "certificate_expected", nullable = true ) 
	  private String certificateExpectedInDays;
	  
	  @Column(name = "certificate_copies", nullable = true )
	  private long  noOfCertificateCopies;
	  
	  @Column(name = "applicable_fee", nullable = true ) 
	  private double feesApplicable;
	  
	  @Column(name = "rti_appl_ref_no", nullable = true ) 
	  private String rtiapplrefno;
	  
	  @Column(name = "rti_ref_id", nullable = true )
	  private long rti_ref_id;
	  
	  @Column(name = "pdf_files_saved_path", nullable = true )
	  private String pdfFilesSavedPath;
	  
	  @Column(name = "applicant_full_name", nullable = true )
	  private String applicantFullName;
	  
	  @Column(name = "aadhaar_no")
	  private String aadhaarNo;
	  
	  
	  @Column(name = "applicant_city")
	  private String applicantcity;
	  
	  @Column(name = "country_name ")
	  private String countryName;
	  
	  @Column(name = "home_address ")
	  private String homeAddress;
	  
	  @Column(name = "child_name_fixed ")
	  private String childNameFixed;
	  
	    @Transient
		private String filesPath;  
	  
	public long getBirthRegistrationId() {
		return birthRegistrationId;
	}

	public void setBirthRegistrationId(long birthRegistrationId) {
		this.birthRegistrationId = birthRegistrationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	  public String getDob() {
		  return dob; 
	}
	  
	  public void setDob(String dob) {
		  this.dob = dob;
		}
	 
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getChildeName() {
		return childeName;
	}

	public void setChildeName(String childeName) {
		this.childeName = childeName;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodRelation() {
		return bloodRelation;
	}

	public void setBloodRelation(String bloodRelation) {
		this.bloodRelation = bloodRelation;
	}

	public String getPlaceofbirth() {
		return placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getReasonForCertificate() {
		return reasonForCertificate;
	}

	public void setReasonForCertificate(String reasonForCertificate) {
		this.reasonForCertificate = reasonForCertificate;
	}

	public String getCertificateExpectedInDays() {
		return certificateExpectedInDays;
	}

	public void setCertificateExpectedInDays(String certificateExpectedInDays) {
		this.certificateExpectedInDays = certificateExpectedInDays;
	}

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

	public String getPdfFilesSavedPath() {
		return pdfFilesSavedPath;
	}

	public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
		this.pdfFilesSavedPath = pdfFilesSavedPath;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getApplicantcity() {
		return applicantcity;
	}

	public void setApplicantcity(String applicantcity) {
		this.applicantcity = applicantcity;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getChildNameFixed() {
		return childNameFixed;
	}

	public void setChildNameFixed(String childNameFixed) {
		this.childNameFixed = childNameFixed;
	}
	
	

}
