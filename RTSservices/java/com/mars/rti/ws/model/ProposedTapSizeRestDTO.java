package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.ProposedTapSize;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "proposedTapSize", "response", "responseStatus" })
public class ProposedTapSizeRestDTO  implements Serializable {
	
private List<ProposedTapSize> proposedTapSize;
	
	private String responseStatus;

	private long response;

	public List<ProposedTapSize> getProposedTapSize() {
		return proposedTapSize;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setProposedTapSize(List<ProposedTapSize> proposedTapSize) {
		this.proposedTapSize = proposedTapSize;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	
	
}
