package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "dog_license_service", schema = "egovrti")
public class DogLicense {
	
	@Id
	@Column(name = "dog_license_id", nullable = false, unique = true)
	@SequenceGenerator(name = "dog_license_ser_seq", sequenceName = "dog_license_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_license_ser_seq")
	private long dogId;
	
	@Column(name = "applicant_name", nullable = true )
	private String appName;
	
	@Column(name = "applicant_address", nullable = true )
	private String appAddress;
	
	@Column(name = "block_plot_no", nullable = true )
	private String blockNo;
	
	@Column(name = "ph_no", nullable = true )
	private String phNo;
	
	@Column(name = "email_id", nullable = true )
	private String emailId;
	
	@Column(name = "name_of_colony", nullable = true )
	private String nameColony;
	
	@Column(name = "zone_no", nullable = true)
	private String zone;
	
	@Column(name = "details_of_dog", nullable = true )
	private String detailsDog;
	
	@Column(name = "gender", nullable = true )
	private String gender;
	
	@Column(name = "age", nullable = true )
	private long age;
	
	@Column(name = "vaccination_details", nullable = true )
	private String vaccinationDetails;
	
	@Column(name = "date", nullable = true )
	private String date;
	
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}
	
	public long getDogId() {
		return dogId;
	}

	public void setDogId(long dogId) {
		this.dogId = dogId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppAddress() {
		return appAddress;
	}

	public void setAppAddress(String appAddress) {
		this.appAddress = appAddress;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNameColony() {
		return nameColony;
	}

	public void setNameColony(String nameColony) {
		this.nameColony = nameColony;
	}

	/*public int getWardNo() {
		return wardNo;
	}

	public void setWardNo(int wardNo) {
		this.wardNo = wardNo;
	}
*/
	
	
	public String getDetailsDog() {
		return detailsDog;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public void setDetailsDog(String detailsDog) {
		this.detailsDog = detailsDog;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getVaccinationDetails() {
		return vaccinationDetails;
	}

	public void setVaccinationDetails(String vaccinationDetails) {
		this.vaccinationDetails = vaccinationDetails;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	
	
	
	
}
