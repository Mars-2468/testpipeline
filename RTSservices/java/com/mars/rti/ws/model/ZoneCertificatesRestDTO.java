package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ZoneCertificates")
@XmlType(propOrder = {"title","firstName", "middleName","lastName","address", "pinCode","email" ,"mobileNo", "buildingNo" ,"plotNo" ,"revenueNo" ,"gatNo", "khasaraNo" , "citySurveyNo", "finalPlotNo", "mouje", "architectName" ,"zoneCertificate" ,
		"feesApplicable", "rtiapplrefno","rti_ref_id"}) 

public class ZoneCertificatesRestDTO {
	
	private long zoneCertificatesId;



	private String title;
	
    private String firstName;
    
	
    private String middleName;
	
	
    private String lastName;
	
	
	
	
    private String address;
	
	
    private int pinCode;

	
	
	private String email;
	
	
	private String mobileNo;
	

	private String buildingNo;
	

	private String plotNo;
	

	private String revenueNo;
	
	
	private String gatNo;
	

	private String khasaraNo;
	
	
	private String citySurveyNo;
	

	private String finalPlotNo;
	
	
	private String mouje;
	

	private String architectName;
	

	
	private String zoneCertificate;
	

	private int feesApplicable;

	
	private String licenseNo;
	
	
	private String rtiapplrefno;
	
	private long rti_ref_id;
	
	private String responseStatus;
	private int status;
	private long response;
	private String result;
	
	//private String responseStatus;


	@XmlElement(name = "zoneCertificatesId")
	public long getZoneCertificatesId() {
		return zoneCertificatesId;
	}


	public void setZoneCertificatesId(long zoneCertificatesId) {
		this.zoneCertificatesId = zoneCertificatesId;
	}

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "pinCode")
	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@XmlElement(name = "buildingNo")
	public String getBuildingNo() {
		return buildingNo;
	}


	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	@XmlElement(name = "plotNo")
	public String getPlotNo() {
		return plotNo;
	}


	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	@XmlElement(name = "revenueNo")
	public String getRevenueNo() {
		return revenueNo;
	}


	public void setRevenueNo(String revenueNo) {
		this.revenueNo = revenueNo;
	}

	@XmlElement(name = "gatNo")
	public String getGatNo() {
		return gatNo;
	}


	public void setGatNo(String gatNo) {
		this.gatNo = gatNo;
	}

	@XmlElement(name = "khasaraNo")
	public String getKhasaraNo() {
		return khasaraNo;
	}


	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}

	@XmlElement(name = "citySurveyNo")
	public String getCitySurveyNo() {
		return citySurveyNo;
	}


	public void setCitySurveyNo(String citySurveyNo) {
		this.citySurveyNo = citySurveyNo;
	}

	@XmlElement(name = "finalPlotNo")
	public String getFinalPlotNo() {
		return finalPlotNo;
	}


	public void setFinalPlotNo(String finalPlotNo) {
		this.finalPlotNo = finalPlotNo;
	}

	@XmlElement(name = "mouje")
	public String getMouje() {
		return mouje;
	}


	public void setMouje(String mouje) {
		this.mouje = mouje;
	}

	@XmlElement(name = "architectName")
	public String getArchitectName() {
		return architectName;
	}


	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}

	@XmlElement(name = "zoneCertificate")
	public String getZoneCertificate() {
		return zoneCertificate;
	}


	public void setZoneCertificate(String zoneCertificate) {
		this.zoneCertificate = zoneCertificate;
	}

	@XmlElement(name = "feesApplicable")
	public int getFeesApplicable() {
		return feesApplicable;
	}


	public void setFeesApplicable(int feesApplicable) {
		this.feesApplicable = feesApplicable;
	}


	@XmlElement(name = "licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@XmlElement(name = "rtiapplrefno")
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}


	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	@XmlElement(name = "rtiapplrefno")
	public long getRti_ref_id() {
		return rti_ref_id;
	}


	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}


	public String getResponseStatus() {
		return responseStatus;
	}


	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public long getResponse() {
		return response;
	}


	public void setResponse(long response) {
		this.response = response;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	
	

}
