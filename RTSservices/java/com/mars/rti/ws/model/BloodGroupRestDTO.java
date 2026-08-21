package com.mars.rti.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.BloodGroup;

@JsonPropertyOrder({ "bloodgroup", "response", "responseStatus" })
public class BloodGroupRestDTO {

	
	private List<BloodGroup> bloodgroup;

	private String responseStatus;

	private long response;

	public List<BloodGroup> getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(List<BloodGroup> bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
	
}
