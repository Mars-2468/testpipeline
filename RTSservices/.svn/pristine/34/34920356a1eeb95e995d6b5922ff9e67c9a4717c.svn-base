package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.Space;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "space", "response", "responseStatus" })

public class SpaceDTO  implements Serializable {
	
private List<Space> space;
	
	private String responseStatus;

	private long response;

	public List<Space> getSpace() {
		return space;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setSpace(List<Space> space) {
		this.space = space;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
	

}
