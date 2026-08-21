package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.http.HttpStatus;

@XmlRootElement(name = "TradeLicencePartnerChange")
@XmlType(propOrder = {"title","name", "fatherName","surname","fullName", "pinCode","aadhaarNo" ,"email", "mobileNo" ,"address" , "zoneNo","wardNo","areaName","tradeLicenseNo","updatedTradeName","updatedTradeType","updatedOwnerName","updatedPartnerCount","rtiapplrefno","rti_ref_id"}) 



public class TradeLicencePartnerChangeRestDTO {
	
	private long tradeLicencePartnerChangeId;	
	
	private String title;
	
	
	private String name;
	
	private String fatherName;
	
	private String surname;
	
	private String fullName;
	
	 private int pinCode;
	
	 private String aadhaarNo;
	
	 private String email;
	
	 private String mobileNo;
	
	 private String address;
	
	
	 
	 private String zoneNo;
	 
	 private String wardNo;
	 
	 private String areaName; 
	 
	 private String tradeLicenseNo;
	 
	 private String updatedTradeName;
	 
	 private String updatedTradeType;
	 
	 private String updatedOwnerName;
	 
	 private String updatedPartnerCount;
	 
	 private String rtiapplrefno;
	 
	 private long rti_ref_id; 
	 
	 private String responseStatus;
	 
     private int status;
		
	 private HttpStatus response;
		
	 private String result;

	

	public long getTradeLicencePartnerChangeId() {
		return tradeLicencePartnerChangeId;
	}

	public void setTradeLicencePartnerChangeId(long tradeLicencePartnerChangeId) {
		this.tradeLicencePartnerChangeId = tradeLicencePartnerChangeId;
	}

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "fatherName")
	public String getFatherName() {
		return fatherName;
	}

	@XmlElement(name = "surname")
	public String getSurname() {
		return surname;
	}

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElement(name = "pinCode")
	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@XmlElement(name = "aadhaarNo")
	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
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

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "zoneNo")
	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	@XmlElement(name = "wardNo")
	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	@XmlElement(name = "areaName")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	@XmlElement(name = "tradeLicenseNo")
	public String getTradeLicenseNo() {
		return tradeLicenseNo;
	}

	public void setTradeLicenseNo(String tradeLicenseNo) {
		this.tradeLicenseNo = tradeLicenseNo;
	}

	@XmlElement(name = "updatedTradeName")
	public String getUpdatedTradeName() {
		return updatedTradeName;
	}

	public void setUpdatedTradeName(String updatedTradeName) {
		this.updatedTradeName = updatedTradeName;
	}

	@XmlElement(name = "updatedTradeType")
	public String getUpdatedTradeType() {
		return updatedTradeType;
	}

	public void setUpdatedTradeType(String updatedTradeType) {
		this.updatedTradeType = updatedTradeType;
	}

	@XmlElement(name = "updatedOwnerName")
	public String getUpdatedOwnerName() {
		return updatedOwnerName;
	}

	public void setUpdatedOwnerName(String updatedOwnerName) {
		this.updatedOwnerName = updatedOwnerName;
	}

	@XmlElement(name = "updatedPartnerCount")
	public String getUpdatedPartnerCount() {
		return updatedPartnerCount;
	}

	public void setUpdatedPartnerCount(String updatedPartnerCount) {
		this.updatedPartnerCount = updatedPartnerCount;
	}

	@XmlElement(name = "rtiapplrefno")
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}
	@XmlElement(name = "rti_ref_id")
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

	public HttpStatus getResponse() {
		return response;
	}

	public void setResponse(HttpStatus response) {
		this.response = response;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
