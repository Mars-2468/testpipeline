package com.mars.rti.ws.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.ZoneEsr;

@JsonPropertyOrder({"esr", "result", "response", "responseStatus"})
public class ZoneEsrRestDTO {

	private List<ZoneEsr> esr;

	private String responseStatus;

	private long response;

	public List<ZoneEsr> getEsr() {
		return esr;
	}

	public void setEsr(List<ZoneEsr> esr) {
		this.esr = esr;
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
