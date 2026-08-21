package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.TreeTrimmingReason;

@SuppressWarnings("serial")
@JsonPropertyOrder({"treeTrimmingReason", "response", "responseStatus"})
public class TreeTrimmingReasonRestDTO implements Serializable{

	private List<TreeTrimmingReason> treeTrimmingReason;

	private String responseStatus;

	private long response;

	public List<TreeTrimmingReason> getTreeTrimmingReason() {
		return treeTrimmingReason;
	}

	public void setTreeTrimmingReason(List<TreeTrimmingReason> treeTrimmingReason) {
		this.treeTrimmingReason = treeTrimmingReason;
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
