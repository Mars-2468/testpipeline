package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.TreeCuttingReason;

@SuppressWarnings("serial")
@JsonPropertyOrder({"treeCuttingReason", "response", "responseStatus"})
public class TreeCuttingReasonRestDTO implements Serializable{

	private List<TreeCuttingReason> treeCuttingReason;

	private String responseStatus;

	private long response;

	public List<TreeCuttingReason> getTreeCuttingReason() {
		return treeCuttingReason;
	}

	public void setTreeCuttingReason(List<TreeCuttingReason> treeCuttingReason) {
		this.treeCuttingReason = treeCuttingReason;
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
