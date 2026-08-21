package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.http.HttpStatus;

@XmlRootElement(name = "TradeLicenceNew")
@XmlType(propOrder = {"title","firstName", "middleName","lastName","fullName", "pinCode","aadhaarNo" ,"email", "mobileNo" ,"address","nameOfBusiness", "businessDetails" , "businesDoneDate", "finalPlotNo", "spaceType", "length" ,"height",
		"width", "zoneNo","wardNo","areaName","businessUsagePlace","rtiapplrefno","rti_ref_id"}) 

public class TradeLicenceNewRestDTO {

private long tradeNewId;	
	
	private String title;
	
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String fullName;
	
	 private int pinCode;
	
	 private String aadhaarNo;
	
	 private String email;
	
	 private String mobileNo;
	
	 private String address;
	
	 private String nameOfBusiness;
	
	 private String businessDetails;
	
	 private String businesDoneDate;
	
	 private String spaceType;
	
	 private String length;
	 
	 private String height;
	 
	 private String width;
	 
	 private String zoneNo;
	 
	 private String wardNo;
	 
	 private String areaName; 
	 
	 private String businessUsagePlace;
	 
	 private String rtiapplrefno;
	 
	 private long rti_ref_id; 
	 
	 private String responseStatus;
	 
     private int status;
		
	 private HttpStatus response;
		
	 private String result;
	 
			
	 @XmlElement(name = "tradeNewId")
		public long getTradeNewId() {
		return tradeNewId;
	}
	public void setTradeNewId(long tradeNewId) {
		this.tradeNewId = tradeNewId;
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
		
		
		@XmlElement(name = "nameOfBusiness")
		public String getNameOfBusiness() {
			return nameOfBusiness;
		}
		public void setNameOfBusiness(String nameOfBusiness) {
			this.nameOfBusiness = nameOfBusiness;
		}
		
		@XmlElement(name = "businessDetails")
		public String getBusinessDetails() {
			return businessDetails;
		}
		public void setBusinessDetails(String businessDetails) {
			this.businessDetails = businessDetails;
		}
		
		@XmlElement(name = "businesDoneDate")
		public String getBusinesDoneDate() {
			return businesDoneDate;
		}
		public void setBusinesDoneDate(String businesDoneDate) {
			this.businesDoneDate = businesDoneDate;
		}
		
		@XmlElement(name = "spaceType")
		public String getSpaceType() {
			return spaceType;
		}
		public void setSpaceType(String spaceType) {
			this.spaceType = spaceType;
		}
		
		@XmlElement(name = "length")
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		
		@XmlElement(name = "height")
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		
		@XmlElement(name = "width")
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
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
		
		
		@XmlElement(name = "businessUsagePlace")
		public String getBusinessUsagePlace() {
			return businessUsagePlace;
		}
		public void setBusinessUsagePlace(String businessUsagePlace) {
			this.businessUsagePlace = businessUsagePlace;
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
