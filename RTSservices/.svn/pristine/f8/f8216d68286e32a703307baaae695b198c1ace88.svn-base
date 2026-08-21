package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({"CitizenList","status","response","ApplicationStatus"})
public class CitizenMyApplicationRestDTO implements Serializable
{
	private List<CitizenMyApplicationRest2DTO> CitizenList;
	
	private String status;
	
	private String response;
	
	private String ApplicationStatus;
	
	private int responseCode;
	
	@XmlElement(name= "CitizenList")
	public List<CitizenMyApplicationRest2DTO> getCitizenList() {
		return CitizenList;
	}
	
	public void setCitizenList(List<CitizenMyApplicationRest2DTO> citizenList) {
		CitizenList = citizenList;
	}
	
	@XmlElement(name= "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "response")
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@XmlElement(name = "ApplicationStatus")
	public String getApplicationStatus() {
		return ApplicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		ApplicationStatus = applicationStatus;
	}
	
	@XmlElement(name = "responseCode")
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}	
}
