package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.Gender;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "gender", "response", "responseStatus" })

public class GenderDTO  implements Serializable {
	
private List<Gender> gender;
	
	private String responseStatus;

	private long response;

	public List<Gender> getGender() {
		return gender;
	}

	public void setGender(List<Gender> gender) {
		this.gender = gender;
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
