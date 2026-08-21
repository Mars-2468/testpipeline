package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.ProposedCategrory;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "proposedCategrory", "response", "responseStatus" })


public class ProposedCategroryRestDTO  implements Serializable {
	
private List<ProposedCategrory> proposedCategrory;
	
	private String responseStatus;

	private long response;

	public List<ProposedCategrory> getProposedCategrory() {
		return proposedCategrory;
	}

	public void setProposedCategrory(List<ProposedCategrory> proposedCategrory) {
		this.proposedCategrory = proposedCategrory;
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
