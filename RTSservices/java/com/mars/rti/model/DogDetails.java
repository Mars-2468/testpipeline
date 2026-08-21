package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "dog_details", schema = "egovrti")
public class DogDetails {

	@Id
	@Column(name = "dog_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "dog_details_ser_seq", sequenceName = "dog_details_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_details_ser_seq")
	private long dogDetailsId;
	

	@Column(name = "dog_type", nullable = true )
	private String dogType;
	
	@Column(name = "dog_sub_type", nullable = true )
	private String dogSubType; 
	
	@Column(name = "dog_name", nullable = true )
	private String dogName;
	
	@Column(name = "gender", nullable = true )
	private String gender;
	
	@Column(name = "dog_age", nullable = true )
	private String dogAge;
	
	@Column(name = "dog_color", nullable = true )
	private String dogColor;
	
	@Column(name = "dog_height", nullable = true )
	private long dogHeight;
	
	@Column(name = "dog_tail_length", nullable = true )
	private long dogTailLength;
	
	@Column(name = "amount", nullable = true )
	private double amount;
	
	@Column(name = "first_dose_date", nullable = true )
	private String firstDoseDate;
	
	@Column(name = "second_dose_date", nullable = true )
	private String secondDoseDate;
	
	@Column(name = "batch_no", nullable = true )
	private String batchNo;
	
	@Column(name = "vaccine_name", nullable = true )
	private String vaccineName;
	
	@Column(name = "surgeon_name", nullable = true )
	private String surgeonName;
	
	@Column(name = "designation", nullable = true )
	private String designation;
	
	@Column(name = "operated", nullable = true )
	private String operated;
	
	@Column(name = "dog_img_files", nullable = true )
	private String dogImagefiles;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dog_license_id", nullable = false)
	private DogLicenseCertificate dogLicenseCertificate;

	public long getDogDetailsId() {
		return dogDetailsId;
	}

	public void setDogDetailsId(long dogDetailsId) {
		this.dogDetailsId = dogDetailsId;
	}

	public String getDogType() {
		return dogType;
	}

	public void setDogType(String dogType) {
		this.dogType = dogType;
	}

	public String getDogSubType() {
		return dogSubType;
	}

	public void setDogSubType(String dogSubType) {
		this.dogSubType = dogSubType;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDogAge() {
		return dogAge;
	}

	public void setDogAge(String dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogColor() {
		return dogColor;
	}

	public void setDogColor(String dogColor) {
		this.dogColor = dogColor;
	}

	public long getDogHeight() {
		return dogHeight;
	}

	public void setDogHeight(long dogHeight) {
		this.dogHeight = dogHeight;
	}

	public long getDogTailLength() {
		return dogTailLength;
	}

	public void setDogTailLength(long dogTailLength) {
		this.dogTailLength = dogTailLength;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFirstDoseDate() {
		return firstDoseDate;
	}

	public void setFirstDoseDate(String firstDoseDate) {
		this.firstDoseDate = firstDoseDate;
	}

	public String getSecondDoseDate() {
		return secondDoseDate;
	}

	public void setSecondDoseDate(String secondDoseDate) {
		this.secondDoseDate = secondDoseDate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getOperated() {
		return operated;
	}

	public void setOperated(String operated) {
		this.operated = operated;
	}

	public String getSurgeonName() {
		return surgeonName;
	}

	public DogLicenseCertificate getDogLicenseCertificate() {
		return dogLicenseCertificate;
	}

	public void setDogLicenseCertificate(DogLicenseCertificate dogLicenseCertificate) {
		this.dogLicenseCertificate = dogLicenseCertificate;
	}

	public void setSurgeonName(String surgeonName) {
		this.surgeonName = surgeonName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDogImagefiles() {
		return dogImagefiles;
	}

	public void setDogImagefiles(String dogImagefiles) {
		this.dogImagefiles = dogImagefiles;
	}


	
	
}
