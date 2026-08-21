package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.ZoneWard;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "wardName", "result", "response", "responseStatus" })
public class ZonewardRestDTO implements Serializable {
	
	private List<ZoneWard> wardName;
	
	private String responseStatus;

	private long response;	


	public List<ZoneWard> getWardName() {
		return wardName;
	}

	public void setWardName(List<ZoneWard> wardName) {
		this.wardName = wardName;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getResponse() {
		return response;
	}
	
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	

}
