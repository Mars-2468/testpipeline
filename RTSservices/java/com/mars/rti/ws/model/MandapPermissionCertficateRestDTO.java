package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "applicantTitle", "applicantFirstName", "applicantMiddleName", "applicantLastName",
		"applicantFullName", "applicantPinCode", "applicantAadhaar", "applicantemail", "applicantmobileno",
		"applicantaddress", "applicantzone", "applicantward", "applicantPurpose", "applicantDateOfEvent",
		"applicantExhibition", "applicantDurationStartdate", "applicantDurationEnddate", "applicantreasonForPavillion",
		"applicantpavillionlength", "applicantpavillionBreadth", "applicantpavillionfessTotalsize",
		"applicantpavillionfessFeesApplicable", "nocFromPoliceDepartment", "nocFromTrafficDepartment",
		"nocFromFireDepartment", "userMobileNumber", "result", "response", "responseCode", "responseStatus", "status" })

public class MandapPermissionCertficateRestDTO implements Serializable {

	private String applicantTitle;

	private String applicantFirstName;

	private String applicantMiddleName;

	private String applicantLastName;

	private String applicantFullName;

	private int applicantPinCode;

	private String applicantAadhaar;

	private String applicantemail;

	private long applicantmobileno;

	private String applicantaddress;

	private int applicantzone;

	private String applicantward;

	private String applicantPurpose;

	private String applicantDateOfEvent;

	private String applicantExhibition;

	private String applicantDurationStartdate;

	private String applicantDurationEnddate;

	private String applicantreasonForPavillion;

	private String applicantpavillionlength;

	private String applicantpavillionBreadth;

	private String applicantpavillionfessTotalsize;

	private double applicantpavillionfessFeesApplicable;

	private String nocFromPoliceDepartment;

	private String nocFromTrafficDepartment;

	private String nocFromFireDepartment;

	private long userMobileNumber;

	private String result;

	private long response;

	private int responseCode;

	private String status;

	private String responseStatus;

	@XmlElement(name = "applicantTitle")
	public String getApplicantTitle() {
		return applicantTitle;
	}

	@XmlElement(name = "applicantFirstName")
	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public void setApplicantTitle(String applicantTitle) {
		this.applicantTitle = applicantTitle;
	}

	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}

	public void setApplicantMiddleName(String applicantMiddleName) {
		this.applicantMiddleName = applicantMiddleName;
	}

	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public void setApplicantPinCode(int applicantPinCode) {
		this.applicantPinCode = applicantPinCode;
	}

	public void setApplicantAadhaar(String applicantAadhaar) {
		this.applicantAadhaar = applicantAadhaar;
	}

	public void setApplicantemail(String applicantemail) {
		this.applicantemail = applicantemail;
	}

	public void setApplicantmobileno(long applicantmobileno) {
		this.applicantmobileno = applicantmobileno;
	}

	public void setApplicantaddress(String applicantaddress) {
		this.applicantaddress = applicantaddress;
	}

	public void setApplicantzone(int applicantzone) {
		this.applicantzone = applicantzone;
	}

	public void setApplicantward(String applicantward) {
		this.applicantward = applicantward;
	}

	public void setApplicantPurpose(String applicantPurpose) {
		this.applicantPurpose = applicantPurpose;
	}

	public void setApplicantDateOfEvent(String applicantDateOfEvent) {
		this.applicantDateOfEvent = applicantDateOfEvent;
	}

	public void setApplicantExhibition(String applicantExhibition) {
		this.applicantExhibition = applicantExhibition;
	}

	public void setApplicantDurationStartdate(String applicantDurationStartdate) {
		this.applicantDurationStartdate = applicantDurationStartdate;
	}

	public void setApplicantDurationEnddate(String applicantDurationEnddate) {
		this.applicantDurationEnddate = applicantDurationEnddate;
	}

	public void setApplicantreasonForPavillion(String applicantreasonForPavillion) {
		this.applicantreasonForPavillion = applicantreasonForPavillion;
	}

	public void setApplicantpavillionlength(String applicantpavillionlength) {
		this.applicantpavillionlength = applicantpavillionlength;
	}

	public void setApplicantpavillionBreadth(String applicantpavillionBreadth) {
		this.applicantpavillionBreadth = applicantpavillionBreadth;
	}

	public void setApplicantpavillionfessTotalsize(String applicantpavillionfessTotalsize) {
		this.applicantpavillionfessTotalsize = applicantpavillionfessTotalsize;
	}

	public void setApplicantpavillionfessFeesApplicable(double applicantpavillionfessFeesApplicable) {
		this.applicantpavillionfessFeesApplicable = applicantpavillionfessFeesApplicable;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	@XmlElement(name = "applicantMiddleName")
	public String getApplicantMiddleName() {
		return applicantMiddleName;
	}

	@XmlElement(name = "applicantLastName")
	public String getApplicantLastName() {
		return applicantLastName;
	}

	@XmlElement(name = "applicantFullName")
	public String getApplicantFullName() {
		return applicantFullName;
	}

	@XmlElement(name = "applicantPinCode")
	public int getApplicantPinCode() {
		return applicantPinCode;
	}

	@XmlElement(name = "applicantAadhaar")
	public String getApplicantAadhaar() {
		return applicantAadhaar;
	}

	@XmlElement(name = "applicantemail")
	public String getApplicantemail() {
		return applicantemail;
	}

	@XmlElement(name = "applicantmobileno")
	public long getApplicantmobileno() {
		return applicantmobileno;
	}

	@XmlElement(name = "applicantaddress")
	public String getApplicantaddress() {
		return applicantaddress;
	}

	@XmlElement(name = "applicantzone")
	public int getApplicantzone() {
		return applicantzone;
	}

	@XmlElement(name = "applicantward")
	public String getApplicantward() {
		return applicantward;
	}

	@XmlElement(name = "applicantPurpose")
	public String getApplicantPurpose() {
		return applicantPurpose;
	}

	@XmlElement(name = "applicantDateOfEvent")
	public String getApplicantDateOfEvent() {
		return applicantDateOfEvent;
	}

	@XmlElement(name = "applicantExhibition")
	public String getApplicantExhibition() {
		return applicantExhibition;
	}

	@XmlElement(name = "applicantDurationStartdate")
	public String getApplicantDurationStartdate() {
		return applicantDurationStartdate;
	}

	@XmlElement(name = "applicantDurationEnddate")
	public String getApplicantDurationEnddate() {
		return applicantDurationEnddate;
	}

	@XmlElement(name = "applicantreasonForPavillion")
	public String getApplicantreasonForPavillion() {
		return applicantreasonForPavillion;
	}

	@XmlElement(name = "applicantpavillionlength")
	public String getApplicantpavillionlength() {
		return applicantpavillionlength;
	}

	@XmlElement(name = "applicantpavillionBreadth")
	public String getApplicantpavillionBreadth() {
		return applicantpavillionBreadth;
	}

	@XmlElement(name = "applicantpavillionfessTotalsize")
	public String getApplicantpavillionfessTotalsize() {
		return applicantpavillionfessTotalsize;
	}

	@XmlElement(name = "applicantpavillionfessFeesApplicable")
	public double getApplicantpavillionfessFeesApplicable() {
		return applicantpavillionfessFeesApplicable;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	@XmlElement(name = "response")
	public long getResponse() {
		return response;
	}

	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	@XmlElement(name = "nocFromPoliceDepartment")
	public String getNocFromPoliceDepartment() {
		return nocFromPoliceDepartment;
	}

	@XmlElement(name = "nocFromTrafficDepartment")
	public String getNocFromTrafficDepartment() {
		return nocFromTrafficDepartment;
	}

	@XmlElement(name = "nocFromFireDepartment")
	public String getNocFromFireDepartment() {
		return nocFromFireDepartment;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNocFromPoliceDepartment(String nocFromPoliceDepartment) {
		this.nocFromPoliceDepartment = nocFromPoliceDepartment;
	}

	public void setNocFromTrafficDepartment(String nocFromTrafficDepartment) {
		this.nocFromTrafficDepartment = nocFromTrafficDepartment;
	}

	public void setNocFromFireDepartment(String nocFromFireDepartment) {
		this.nocFromFireDepartment = nocFromFireDepartment;
	}

	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

}
