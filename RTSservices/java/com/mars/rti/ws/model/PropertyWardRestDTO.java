package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.PropertyWard;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "ward"})
public class PropertyWardRestDTO implements Serializable{

	private List<PropertyWard> ward;

	public List<PropertyWard> getWard() {
		return ward;
	}

	public void setWard(List<PropertyWard> ward) {
		this.ward = ward;
	}

	

}
