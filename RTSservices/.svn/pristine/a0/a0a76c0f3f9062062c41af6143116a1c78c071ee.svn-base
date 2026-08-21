package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.Gender;
import com.mars.rti.model.TreeLocation;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "treelocation", "response", "responseStatus" })

public class TreeLocationRestDTO   implements Serializable {
	
private List<TreeLocation> treelocation;
	
	private String responseStatus;

	private long response;

	public List<TreeLocation> getTreelocation() {
		return treelocation;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setTreelocation(List<TreeLocation> treelocation) {
		this.treelocation = treelocation;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
	


}
