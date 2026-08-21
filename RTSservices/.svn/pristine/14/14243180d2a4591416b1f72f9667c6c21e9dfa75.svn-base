package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ApplicationStatus")

@XmlType(propOrder = {"applicationRefNumber","applicationStatus"})

public class ApplicationStatusRestDTO implements java.io.Serializable{	

	private String applicationRefNumber;
	private int applicationStatus;
	 	

	@XmlElement(name = "applicationRefNumber")
	public String getApplicationRefNumber() {
		return applicationRefNumber;
	}

	public void setApplicationRefNumber(String applicationRefNumber) {
		this.applicationRefNumber = applicationRefNumber;
	}

	@XmlElement(name = "applicationStatus")
	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int statusValue) {
		this.applicationStatus = statusValue;
	}
}