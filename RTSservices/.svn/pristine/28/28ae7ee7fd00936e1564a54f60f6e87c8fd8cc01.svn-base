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
@Table(name = "biological_waste_disposal", schema = "egovrti")
public class BiologicalWasteDisposal {

	@Id
	@Column(name = "bwd_id", nullable = false, unique = true)
	@SequenceGenerator(name = "bwd_id_ser_seq", sequenceName = "bwd_id_ser_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bwd_id_ser_seq")
	private long bwdId;
	
	@Column(name = "title",nullable = true)
	private String title;

	@Column(name = "firstname",nullable = true)
	private String firstName;

	@Column(name = "middlename",nullable = true)
	private String middleName;

	@Column(name = "lastname",nullable = true)
	private String lastName;

	

	@Column(name = "fullname",nullable = true)
	private String fullName;

	@Column(name = "email",nullable = true)
	private String email;
    
	@Column(name = "mobilenumber",nullable = true)
	private String mobileNumber;
	

	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;
	
	@Column(name = "education",nullable = true)
	private String education;

	@Column(name = "otherdegree",nullable = true)
	private String otherDegree;
	
	//new one
	
	@Column(name = "hospitalname",nullable = true)
	private String hospitalName;
	
	@Column(name = "hospitaladdress",nullable = true)
	private String hospitalAddress;
	
	@Column(name = "medicalprofessiontype",nullable = true)
	private String medicalProfessionType;
	
	
	@Column(name = "numberofbeds",nullable = true)
	private String numberOfBeds;
	
	@Column(name = "medicalcouncilregnumber",nullable = true)
	private String medicalCouncilRegNumber;
	
	@Column(name = "otherprofessionalsdetails",nullable = true)
	private String otherProfessionalsDetails;
	

	@Column(name = "biologicalwastedescription",nullable = true)
	private String biologicalWasteDescription;
	@Transient
	private String filesPath;
	
	@Column(name="zone_no")
	private String zoneNo;

	public long getBwdId() {
		return bwdId;
	}

	public void setBwdId(long bwdId) {
		this.bwdId = bwdId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOtherDegree() {
		return otherDegree;
	}

	public void setOtherDegree(String otherDegree) {
		this.otherDegree = otherDegree;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getMedicalProfessionType() {
		return medicalProfessionType;
	}

	public void setMedicalProfessionType(String medicalProfessionType) {
		this.medicalProfessionType = medicalProfessionType;
	}

	public String getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public String getMedicalCouncilRegNumber() {
		return medicalCouncilRegNumber;
	}

	public void setMedicalCouncilRegNumber(String medicalCouncilRegNumber) {
		this.medicalCouncilRegNumber = medicalCouncilRegNumber;
	}

	public String getOtherProfessionalsDetails() {
		return otherProfessionalsDetails;
	}

	public void setOtherProfessionalsDetails(String otherProfessionalsDetails) {
		this.otherProfessionalsDetails = otherProfessionalsDetails;
	}

	public String getBiologicalWasteDescription() {
		return biologicalWasteDescription;
	}

	public void setBiologicalWasteDescription(String biologicalWasteDescription) {
		this.biologicalWasteDescription = biologicalWasteDescription;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	@Column(name = "demandfees",nullable = true)
	private String demandfees;

	public String getDemandfees() {
		return demandfees;
	}

	public void setDemandfees(String demandfees) {
		this.demandfees = demandfees;
	}

	
	


	

	
}
