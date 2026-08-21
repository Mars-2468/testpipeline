package com.mars.common.model;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

@DataTransferObject(type = "hibernate3")
public class ResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RemoteProperty
	private String responseUrl;
	
	@RemoteProperty
	private Integer responseCode=new Integer(0);
	
	@RemoteProperty
	private boolean error=false;

	public ResponseData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResponseUrl() {
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl) {
		this.responseUrl = responseUrl;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	

}
