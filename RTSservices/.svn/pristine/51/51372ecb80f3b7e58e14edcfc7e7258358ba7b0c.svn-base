package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.Country;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "country", "response", "responseStatus" })

public class CountryDTO implements Serializable {

private List<Country> country;
	
	private String responseStatus;

	private long response;

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
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
