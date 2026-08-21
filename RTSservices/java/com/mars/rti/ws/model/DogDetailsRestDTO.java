package com.mars.rti.ws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "dogType", "dogSubType", "dogName", "gender", "dogAge", "dogColor", "dogHeight", "dogTailLength",
		"amount", "firstDoseDate", "secondDoseDate", "batchNo", "vaccineName", "surgeonName", "designation",
		"operated","dogImage" })
public class DogDetailsRestDTO implements Serializable{

	private String dogType;

	private String dogSubType;

	private String dogName;

	private String gender;

	private String dogAge;

	private String dogColor;

	private long dogHeight;

	private long dogTailLength;

	private double amount;

	private String firstDoseDate;

	private String secondDoseDate;

	private String batchNo;

	private String vaccineName;

	private String surgeonName;

	private String designation;

	private String operated;

	private String dogImage;
	

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

	public String getSurgeonName() {
		return surgeonName;
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

	public String getOperated() {
		return operated;
	}

	public void setOperated(String operated) {
		this.operated = operated;
	}

	public String getDogImage() {
		return dogImage;
	}

	public void setDogImage(String dogImage) {
		this.dogImage = dogImage;
	}
}
