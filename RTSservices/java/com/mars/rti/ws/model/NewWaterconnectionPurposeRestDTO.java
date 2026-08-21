package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.NewWaterConnectionPurpose;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "purpose", "response", "responseStatus" })

public class NewWaterconnectionPurposeRestDTO  implements Serializable {
	
private List<NewWaterConnectionPurpose> purpose;
	
	private String responseStatus;

	private long response;

	public List<NewWaterConnectionPurpose> getPurpose() {
		return purpose;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setPurpose(List<NewWaterConnectionPurpose> purpose) {
		this.purpose= purpose;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
	

}
