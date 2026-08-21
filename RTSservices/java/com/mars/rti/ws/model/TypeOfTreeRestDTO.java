package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.TypeOfTree;

@SuppressWarnings("serial")
@JsonPropertyOrder({"typeOfTree", "response", "responseStatus"})
public class TypeOfTreeRestDTO implements Serializable {

	private List<TypeOfTree> typeOfTree;

	private String responseStatus;

	private long response;

	public List<TypeOfTree> getTypeOfTree() {
		return typeOfTree;
	}

	public void setTypeOfTree(List<TypeOfTree> typeOfTree) {
		this.typeOfTree = typeOfTree;
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
