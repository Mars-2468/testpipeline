package com.mars.rti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "doglicence", schema = "egovrti")
public class DogLicenseCertificate {
	
	@Id
	@Column(name = "dog_license_id", nullable = false, unique = true)
	@SequenceGenerator(name = "dog_license_ser_seq", sequenceName = "dog_license_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_license_ser_seq")
	private long dogId;
	
	@Column(name = "title", nullable = true )
	private String title;
	
	@Column(name = "first_name", nullable = true )
	private String firstName;
	
	@Column(name = "middle_name", nullable = true )
	private String middleName;
	
	@Column(name = "last_name", nullable = true )
	private String lastName;
	
	@Column(name = "name", nullable = true )
	private String name;
	
	@Column(name = "plot_no", nullable = true )
	private String plotNo;  
	
	@Column(name = "building_name", nullable = true )
	private String buildingName;
	
	@Column(name = "street_name", nullable = true )
	private String streetName;
	
	@Column(name = "area_name", nullable = true )
	private String areaName;
	
	@Column(name = "pin_code", nullable = true )
	private String pinCode;
	
	@Column(name = "nearby_landmark", nullable = true )
	private String nearbyLandmark;
	
	@Column(name = "mobile_number", nullable = true )
	private String mobileNumber;
	
	@Column(name = "email", nullable = true )
	private String emailId;
	
	@Column(name = "colony_name", nullable = true )
	private String colonyName;
	
	@Column(name = "correspondence_address", nullable = true )
	private String correspondenceAddress;
	
	@Column(name = "zone_no", nullable = true )
	private String zoneNo;
	
	@Column(name = "ward_no", nullable = true )
	private String wardNo;
	
	@Column(name = "no_of_dog", nullable = true )
	private long noOfDog;
	
	@Column(name = "renewaldog", nullable = true )
	private String renewaldog;
	
//	@Column(name = "dog_details", nullable = true )
//	private String dogDetails;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "dog_details_id", nullable = false,unique=true)
//	private DogDetails dogDetails = new DogDetails();
	
//	@Column(name = "dog_type", nullable = true )
//	private String dogType;
//	
//	@Column(name = "dog_sub_type", nullable = true )
//	private String dogSubType; 
//	
//	@Column(name = "dog_name", nullable = true )
//	private String dogName;
//	
//	@Column(name = "gender", nullable = true )
//	private String gender;
//	
//	@Column(name = "dog_age", nullable = true )
//	private long dogAge;
//	
//	@Column(name = "dog_color", nullable = true )
//	private String dogColor;
//	
//	@Column(name = "dog_height", nullable = true )
//	private long dogHeight;
//	
//	@Column(name = "dog_tail_length", nullable = true )
//	private long dogTailLength;
//	
//	@Column(name = "amount", nullable = true )
//	private double amount;
//	
//	@Column(name = "first_dose_date", nullable = true )
//	private String firstDoseDate;
//	
//	@Column(name = "second_dose_date", nullable = true )
//	private String secondDoseDate;
//	
//	@Column(name = "batch_no", nullable = true )
//	private String batchNo;
//	
//	@Column(name = "vaccine_name", nullable = true )
//	private String vaccineName;
//	
//	@Column(name = "surgeon_name", nullable = true )
//	private String surgeonName;
//	
//	@Column(name = "designation", nullable = true )
//	private String designation;
	
//	@Column(name = "vaccination_certificate", nullable = true )
//	private String vaccinationCertificate;
	
	@Column(name = "rti_appl_ref_no", nullable = true ) 
	private String rtiapplrefno;
	  
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;
	
	@OneToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL,*/ mappedBy = "dogLicenseCertificate")
   private List<DogDetails> dogDetails = new ArrayList<DogDetails>();
  
	@Column(name = "dog_files")
	private String dogFiles;
	
	@Column(name = "operated_files")
	private String dogOpertedFiles;
	
	@Column(name = "applicant_city")
	  private String applicantcity;
	
//	@Column(name = "operated", nullable = true )
//	private String operated;

//	    public List<DogDetails> getDogDetails() {
//	return dogDetails;
//}
//
//public void setDogDetails(List<DogDetails> dogDetails) {
//	this.dogDetails = dogDetails;
//}
	@Column(name = "vaccination_second")
	private String vaccinationsecond;
	
	@Column(name="certificate_issued")
	private String certificate_issued;
	
//Renewal Status
	
	@Column(name="renewal_status")
	private int renewalStatus;
	
		@Transient
		private String filesPath;

		public String getDogOpertedFiles() {
			return dogOpertedFiles;
		}

		public void setDogOpertedFiles(String dogOpertedFiles) {
			this.dogOpertedFiles = dogOpertedFiles;
		}

		public long getDogId() {
			return dogId;
		}

		public void setDogId(long dogId) {
			this.dogId = dogId;
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

		public String getPinCode() {
			return pinCode;
		}

		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}

		public String getNearbyLandmark() {
			return nearbyLandmark;
		}

		public void setNearbyLandmark(String nearbyLandmark) {
			this.nearbyLandmark = nearbyLandmark;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getColonyName() {
			return colonyName;
		}

		public void setColonyName(String colonyName) {
			this.colonyName = colonyName;
		}

		public String getCorrespondenceAddress() {
			return correspondenceAddress;
		}

		public void setCorrespondenceAddress(String correspondenceAddress) {
			this.correspondenceAddress = correspondenceAddress;
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

		public long getNoOfDog() {
			return noOfDog;
		}

		public void setNoOfDog(long noOfDog) {
			this.noOfDog = noOfDog;
		}

//		public String getDogDetails() {
//			return dogDetails;
//		}
//
//		public void setDogDetails(String dogDetails) {
//			this.dogDetails = dogDetails;
//		}

//		public String getDogType() {
//			return dogType;
//		}
//
//		public void setDogType(String dogType) {
//			this.dogType = dogType;
//		}
//
//		public String getDogSubType() {
//			return dogSubType;
//		}
//
//		public void setDogSubType(String dogSubType) {
//			this.dogSubType = dogSubType;
//		}
//
//		public String getDogName() {
//			return dogName;
//		}
//
//		public void setDogName(String dogName) {
//			this.dogName = dogName;
//		}
//
//		public String getGender() {
//			return gender;
//		}
//
//		public void setGender(String gender) {
//			this.gender = gender;
//		}
//
//		public long getDogAge() {
//			return dogAge;
//		}
//
//		public void setDogAge(long dogAge) {
//			this.dogAge = dogAge;
//		}
//
//		public String getDogColor() {
//			return dogColor;
//		}
//
//		public void setDogColor(String dogColor) {
//			this.dogColor = dogColor;
//		}
//
//		public long getDogHeight() {
//			return dogHeight;
//		}
//
//		public void setDogHeight(long dogHeight) {
//			this.dogHeight = dogHeight;
//		}
//
//		public long getDogTailLength() {
//			return dogTailLength;
//		}
//
//		public void setDogTailLength(long dogTailLength) {
//			this.dogTailLength = dogTailLength;
//		}
//
//		public double getAmount() {
//			return amount;
//		}
//
//		public void setAmount(double amount) {
//			this.amount = amount;
//		}
//
//		public String getFirstDoseDate() {
//			return firstDoseDate;
//		}
//
//		public void setFirstDoseDate(String firstDoseDate) {
//			this.firstDoseDate = firstDoseDate;
//		}
//
//		public String getSecondDoseDate() {
//			return secondDoseDate;
//		}
//
//		public void setSecondDoseDate(String secondDoseDate) {
//			this.secondDoseDate = secondDoseDate;
//		}
//
//		public String getBatchNo() {
//			return batchNo;
//		}
//
//		public void setBatchNo(String batchNo) {
//			this.batchNo = batchNo;
//		}
//
//		public String getVaccineName() {
//			return vaccineName;
//		}
//
//		public void setVaccineName(String vaccineName) {
//			this.vaccineName = vaccineName;
//		}
//
//		public String getSurgeonName() {
//			return surgeonName;
//		}
//
//		public void setSurgeonName(String surgeonName) {
//			this.surgeonName = surgeonName;
//		}
//
//		public String getDesignation() {
//			return designation;
//		}
//
//		public void setDesignation(String designation) {
//			this.designation = designation;
//		}

//		public String getVaccinationCertificate() {
//			return vaccinationCertificate;
//		}
//
//		public void setVaccinationCertificate(String vaccinationCertificate) {
//			this.vaccinationCertificate = vaccinationCertificate;
//		}

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

		public String getFilesPath() {
			return filesPath;
		}

		public void setFilesPath(String filesPath) {
			this.filesPath = filesPath;
		}

//		public String getOperated() {
//			return operated;
//		}
//
//		public void setOperated(String operated) {
//			this.operated = operated;
//		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<DogDetails> getDogDetails() {
			return dogDetails;
		}

		public void setDogDetails(List<DogDetails> dogDetails) {
			this.dogDetails = dogDetails;
		}

		public String getDogFiles() {
			return dogFiles;
		}

		public void setDogFiles(String dogFiles) {
			this.dogFiles = dogFiles;
		}

		public String getVaccinationsecond() {
			return vaccinationsecond;
		}

		public void setVaccinationsecond(String vaccinationsecond) {
			this.vaccinationsecond = vaccinationsecond;
		}

		public String getApplicantcity() {
			return applicantcity;
		}

		public void setApplicantcity(String applicantcity) {
			this.applicantcity = applicantcity;
		}

		public String getRenewaldog() {
			return renewaldog;
		}

		public void setRenewaldog(String renewaldog) {
			this.renewaldog = renewaldog;
		}

		public String getCertificate_issued() {
			return certificate_issued;
		}

		public void setCertificate_issued(String certificate_issued) {
			this.certificate_issued = certificate_issued;
		}

		public int getRenewalStatus() {
			return renewalStatus;
		}

		public void setRenewalStatus(int renewalStatus) {
			this.renewalStatus = renewalStatus;
		}

//		public DogDetails getDogDetails() {
//			return dogDetails;
//		}
//
//		public void setDogDetails(DogDetails dogDetails) {
//			this.dogDetails = dogDetails;
//		}  
	
	
	
}
