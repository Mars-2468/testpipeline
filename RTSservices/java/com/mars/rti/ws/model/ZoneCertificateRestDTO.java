package com.mars.rti.ws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@SuppressWarnings("serial")
@JsonPropertyOrder({"applicantTitle", "applicantName", "applicantFatherName",
		"applicantSurname", "applicantFullName", "applicantPinCode", "email",
		"phoneNo", "address", "zone", "gatNo", "khasara", "citySurvey",
		"zonecertificateinDays", "feesApplicable", "mouza","aadhaarNo",
		"citySurveyLocation", "citySurveyMap" ,"applicantIdProof", "khasaraMap", "result",
		"response", "userMobileNumber", "responseStatus"})

public class ZoneCertificateRestDTO implements Serializable {

	private String applicantTitle;

	private String applicantName;

	private String applicantFatherName;

	private String applicantSurname;

	private String applicantFullName;

	private long applicantPinCode;

	private String email;
	
    private long aadhaarNo;

	private long phoneNo;

	private String address;

	private int zone;

	private String gatNo;

	private String khasara;

	private String citySurvey;

	private long zonecertificateinDays;

	private double feesApplicable;

	private String mouza;

	private String citySurveyLocation;

	private String citySurveyMap;

	private String khasaraMap;
	
	private String applicantIdProof;

	private String result;

	private long response;

	private long userMobileNumber;

	private String responseStatus;

	public String getApplicantTitle() {
		return applicantTitle;
	}

	public void setApplicantTitle(String applicantTitle) {
		this.applicantTitle = applicantTitle;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantFatherName() {
		return applicantFatherName;
	}

	public void setApplicantFatherName(String applicantFatherName) {
		this.applicantFatherName = applicantFatherName;
	}

	public String getApplicantSurname() {
		return applicantSurname;
	}

	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public long getApplicantPinCode() {
		return applicantPinCode;
	}

	public void setApplicantPinCode(long applicantPinCode) {
		this.applicantPinCode = applicantPinCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public String getGatNo() {
		return gatNo;
	}

	public void setGatNo(String gatNo) {
		this.gatNo = gatNo;
	}

	public String getKhasara() {
		return khasara;
	}

	public void setKhasara(String khasara) {
		this.khasara = khasara;
	}

	public String getCitySurvey() {
		return citySurvey;
	}

	public void setCitySurvey(String citySurvey) {
		this.citySurvey = citySurvey;
	}

	public long getZonecertificateinDays() {
		return zonecertificateinDays;
	}

	public void setZonecertificateinDays(long zonecertificateinDays) {
		this.zonecertificateinDays = zonecertificateinDays;
	}

	public double getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(double feesApplicable) {
		this.feesApplicable = feesApplicable;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getCitySurveyLocation() {
		return citySurveyLocation;
	}

	public void setCitySurveyLocation(String citySurveyLocation) {
		this.citySurveyLocation = citySurveyLocation;
	}

	public String getCitySurveyMap() {
		return citySurveyMap;
	}

	public void setCitySurveyMap(String citySurveyMap) {
		this.citySurveyMap = citySurveyMap;
	}

	public String getKhasaraMap() {
		return khasaraMap;
	}

	public void setKhasaraMap(String khasaraMap) {
		this.khasaraMap = khasaraMap;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getApplicantIdProof() {
		return applicantIdProof;
	}

	public void setApplicantIdProof(String applicantIdProof) {
		this.applicantIdProof = applicantIdProof;
	}


}
