package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.NOCFireRecommendation;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "fire_recommendation_main", "response", "responseStatus" })

public class NOCFirerecommendationDTO  implements Serializable {
	
private List<NOCFireRecommendation> NOCFireRecommendation;
	
	private String responseStatus;

	private long response;

	public List<NOCFireRecommendation> getNOCFireRecommendation() {
		return NOCFireRecommendation;
	}

	public void setNOCFireRecommendation(List<NOCFireRecommendation> nOCFireRecommendation) {
		NOCFireRecommendation = nOCFireRecommendation;
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
