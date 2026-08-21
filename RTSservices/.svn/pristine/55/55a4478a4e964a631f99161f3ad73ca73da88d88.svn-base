package com.mars.rti.ws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.Dogtype;

@JsonPropertyOrder({ "dogtype", "breedtype", "indiantype", "response", "ResponseStatus", "ResponseCode", "status" })
public class DogMasterDataRestDTO {

	private String dogtype;

	private List<Dogtype> breedtype;

	private String indiantype;

	private String response;

	private String ResponseStatus;

	private int ResponseCode;

	private String status;

	@XmlElement(name = "dogtype")
	public String getDogtype() {
	    return dogtype;
	}

	@XmlElement(name = "breedtype")
	public List<Dogtype> getBreedtype() {
	    return breedtype;
	}

	@XmlElement(name = "indiantype")
	public String getIndiantype() {
	    return indiantype;
	}

	@XmlElement(name = "response")
	public String getResponse() {
	    return response;
	}

	@XmlElement(name = "ResponseStatus")
	public String getResponseStatus() {
	    return ResponseStatus;
	}

	@XmlElement(name = "ResponseCode")
	public int getResponseCode() {
	    return ResponseCode;
	}

	@XmlElement(name = "status")
	public String getStatus() {
	    return status;
	}

	public void setDogtype(String dogtype) {
		this.dogtype = dogtype;
	}

	public void setBreedtype(List<Dogtype> list) {
		this.breedtype = list;
	}

	public void setIndiantype(String indiantype) {
		this.indiantype = indiantype;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setResponseStatus(String responseStatus) {
		ResponseStatus = responseStatus;
	}

	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
