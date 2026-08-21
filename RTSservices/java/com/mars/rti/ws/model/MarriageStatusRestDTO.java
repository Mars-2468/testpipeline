package com.mars.rti.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.MarriageStatus;

@JsonPropertyOrder({ "status", "response", "responseStatus" })
public class MarriageStatusRestDTO {

	
	private List<MarriageStatus> status;

	private String responseStatus;

	private long response;

	public List<MarriageStatus> getStatus() {
		return status;
	}

	public void setStatus(List<MarriageStatus> status) {
		this.status = status;
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
