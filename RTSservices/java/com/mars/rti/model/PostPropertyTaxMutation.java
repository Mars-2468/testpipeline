package com.mars.rti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostPropertyTaxMutation {
	
	@JsonProperty("citizenRequest")
	private CitizenRequest citizenRequest;
	
	@JsonProperty("token")
	private String token;
	
	 public CitizenRequest getCitizenRequest() {
		return citizenRequest;
	}


	public void setCitizenRequest(CitizenRequest citizenRequest) {
		this.citizenRequest = citizenRequest;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public static class CitizenRequest{
		 
		 @JsonProperty("REQUEST_TYPE")
			private String requestType;

			@JsonProperty("REQUESTER_NAME")
			private String requestName;
			
			@JsonProperty("REQUESTER_ADDRESS")
			private String requestAddress;
			
			@JsonProperty("PTN")
			private String ptn;
			
			@JsonProperty("INDEXNO")
			private String indexNo;
			
			@JsonProperty("REQUESTER_Phone")
			private String registeredPhone;
			
			@JsonProperty("REQUESTER_Email")
			private String requesterMail;
			
			@JsonProperty("REQUESTER_Mobile")
			private String requesterMobile;
			
			@JsonProperty("REQUESTER_HouseNo")
			private String requesterHouseNo;
			
			@JsonProperty("REQUESTER_MeasleNumber")
			private String measleNo;
			
			@JsonProperty("REQUESTER_Mauja")
			private String requesterMauja;
			
			@JsonProperty("REQUESTER_LandPlotNumber")
			private String requesterLandPlotNo;
			
			@JsonProperty("REQUESTER_Ward")
			private String requesterWard;
			
			@JsonProperty("CREATED_BY")
			private String createdBy;
			
			@JsonProperty("DOCUMENT_URL")
			private String documentUrl;
			
			@JsonProperty("REQUEST_NUMBER")
			private String requestNumber;

			public String getRequestType() {
				return requestType;
			}

			public void setRequestType(String requestType) {
				this.requestType = requestType;
			}

			public String getRequestName() {
				return requestName;
			}

			public void setRequestName(String requestName) {
				this.requestName = requestName;
			}

			public String getRequestAddress() {
				return requestAddress;
			}

			public void setRequestAddress(String requestAddress) {
				this.requestAddress = requestAddress;
			}

			public String getPtn() {
				return ptn;
			}

			public void setPtn(String ptn) {
				this.ptn = ptn;
			}

			public String getIndexNo() {
				return indexNo;
			}

			public void setIndexNo(String indexNo) {
				this.indexNo = indexNo;
			}

			public String getRegisteredPhone() {
				return registeredPhone;
			}

			public void setRegisteredPhone(String registeredPhone) {
				this.registeredPhone = registeredPhone;
			}

			public String getRequesterMail() {
				return requesterMail;
			}

			public void setRequesterMail(String requesterMail) {
				this.requesterMail = requesterMail;
			}

			public String getRequesterMobile() {
				return requesterMobile;
			}

			public void setRequesterMobile(String requesterMobile) {
				this.requesterMobile = requesterMobile;
			}

			public String getRequesterHouseNo() {
				return requesterHouseNo;
			}

			public void setRequesterHouseNo(String requesterHouseNo) {
				this.requesterHouseNo = requesterHouseNo;
			}

			public String getMeasleNo() {
				return measleNo;
			}

			public void setMeasleNo(String measleNo) {
				this.measleNo = measleNo;
			}

			public String getRequesterMauja() {
				return requesterMauja;
			}

			public void setRequesterMauja(String requesterMauja) {
				this.requesterMauja = requesterMauja;
			}

			public String getRequesterLandPlotNo() {
				return requesterLandPlotNo;
			}

			public void setRequesterLandPlotNo(String requesterLandPlotNo) {
				this.requesterLandPlotNo = requesterLandPlotNo;
			}

			public String getRequesterWard() {
				return requesterWard;
			}

			public void setRequesterWard(String requesterWard) {
				this.requesterWard = requesterWard;
			}

			public String getCreatedBy() {
				return createdBy;
			}

			public void setCreatedBy(String createdBy) {
				this.createdBy = createdBy;
			}

			public String getDocumentUrl() {
				return documentUrl;
			}

			public void setDocumentUrl(String documentUrl) {
				this.documentUrl = documentUrl;
			}

			public String getRequestNumber() {
				return requestNumber;
			}

			public void setRequestNumber(String requestNumber) {
				this.requestNumber = requestNumber;
			}
			
	 }
	
	
	
}
