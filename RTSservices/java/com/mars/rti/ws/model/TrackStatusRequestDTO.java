package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackStatusRequestDTO {
	
	@JsonProperty("AppID")
	 private String appID;
	
	@JsonProperty("ServiceID")
	    private String serviceID;
	
	@JsonProperty("DeptName")
	    private String deptName;
	
	@JsonProperty("Language")
	    private String language;

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}