package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mars.rti.utils.CoreConstants;

@XmlRootElement(name = "BaseRestDTO")
@XmlType(
			propOrder =	{"responseCode","responseMessage"}
		)

public class BaseRestDTO implements java.io.Serializable {

	private Integer responseCode = new Integer(CoreConstants.WEBSERVICE_RESPONSECODE_SUCCESS);

	private String responseMessage = "Success";

	@XmlElement(name = "responseCode")
	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	@XmlElement(name = "responseMessage")
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}