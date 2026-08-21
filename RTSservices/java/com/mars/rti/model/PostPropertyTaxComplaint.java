package com.mars.rti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostPropertyTaxComplaint {
	
	@JsonProperty("objectionDetail")
	private ObjectionDetail objectionDetail;
	
	@JsonProperty("token")
	private String token;
	
	

	public ObjectionDetail getObjectionDetail() {
		return objectionDetail;
	}


	public void setObjectionDetail(ObjectionDetail objectionDetail) {
		this.objectionDetail = objectionDetail;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public static class ObjectionDetail{
		 
		 @JsonProperty("REQUEST_Type")
			private String requestType;

			@JsonProperty("REQUESTER_NAME")
			private String requestName;
			
			@JsonProperty("REQUESTER_ADDRESS")
			private String requestAddress;
			
			@JsonProperty("SystemPTN")
			private String ptn;
			
			@JsonProperty("OldPTN")
			private String indexNo;
			
			@JsonProperty("REQUESTER_Email")
			private String requesterMail;
			
			@JsonProperty("REQUESTER_Mobile")
			private String requesterMobile;
			
			@JsonProperty("REQUESTER_Remark")
			private String remarks;
			
			@JsonProperty("Old_MEASURMENTAREA")
			private String oldMeasurement;
			
			@JsonProperty("New_MEASURMENTAREA")
			private String newMeasurement;
			
			@JsonProperty("Old_NTB")
			private String oldNtb;
			
			@JsonProperty("New_NTB")
			private String newNtb;
			
			@JsonProperty("Old_UsageFactor")
			private String oldUsageFactor;
			
			@JsonProperty("New_UsageFactor")
			private String newUsageFactor;
			
			@JsonProperty("Old_AgeFactor")
			private String oldAgeFactor;
			
			@JsonProperty("New_AgeFactor")
			private String newAgeFactor;
			
			@JsonProperty("Objection_Remark")
			private String remark;
			
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

			public String getRemarks() {
				return remarks;
			}

			public void setRemarks(String remarks) {
				this.remarks = remarks;
			}

			public String getOldMeasurement() {
				return oldMeasurement;
			}

			public void setOldMeasurement(String oldMeasurement) {
				this.oldMeasurement = oldMeasurement;
			}

			public String getNewMeasurement() {
				return newMeasurement;
			}

			public void setNewMeasurement(String newMeasurement) {
				this.newMeasurement = newMeasurement;
			}

			public String getOldNtb() {
				return oldNtb;
			}

			public void setOldNtb(String oldNtb) {
				this.oldNtb = oldNtb;
			}

			public String getNewNtb() {
				return newNtb;
			}

			public void setNewNtb(String newNtb) {
				this.newNtb = newNtb;
			}

			public String getOldUsageFactor() {
				return oldUsageFactor;
			}

			public void setOldUsageFactor(String oldUsageFactor) {
				this.oldUsageFactor = oldUsageFactor;
			}

			public String getNewUsageFactor() {
				return newUsageFactor;
			}

			public void setNewUsageFactor(String newUsageFactor) {
				this.newUsageFactor = newUsageFactor;
			}

			public String getOldAgeFactor() {
				return oldAgeFactor;
			}

			public void setOldAgeFactor(String oldAgeFactor) {
				this.oldAgeFactor = oldAgeFactor;
			}

			public String getNewAgeFactor() {
				return newAgeFactor;
			}

			public void setNewAgeFactor(String newAgeFactor) {
				this.newAgeFactor = newAgeFactor;
			}

			public String getRemark() {
				return remark;
			}

			public void setRemark(String remark) {
				this.remark = remark;
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
