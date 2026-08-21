package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"mobileNumber","otp", "result", "responseStatus", "responseCode","requestType"})
public class OTPAuthenticationRestDTO {

	
	private long mobileNumber;
	
	private long otp;
	
	private String result;
	
	private String responseStatus;
	
	private String responseCode;
	
	private String requestType;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	
	
	
}
