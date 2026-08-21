package com.mars.rti.ws.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ReportRequest")
@XmlType(propOrder = {"reportName","reportParameters","reportType","hasmap"})

public class ReportRestDTO {
	
	private String reportName;
	private String reportParameters;
	private String reportType;
	private HashMap<String, Object> hasmap;
	
	
	@XmlElement(name = "hasmap") 
	public HashMap<String, Object> getHasmap() {
		return hasmap;
	}
	public void setHasmap(HashMap<String, Object> hasmap) {
		this.hasmap = hasmap;
	}
	@XmlElement(name = "reportName") 
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	@XmlElement(name = "reportParameters") 
	public String getReportParameters() {
		return reportParameters;
	}
	public void setReportParameters(String reportParameters) {
		this.reportParameters = reportParameters;
	}
	@XmlElement(name = "reportType") 
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	

}
