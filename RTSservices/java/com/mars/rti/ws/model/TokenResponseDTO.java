package com.mars.rti.ws.model;

public class TokenResponseDTO {

	  private String data;   // bearer token
	    private String message;
	    private boolean success;

	    public String getData() {
	        return data;
	    }
	    public void setData(String data) {
	        this.data = data;
	    }

	    public String getMessage() {
	        return message;
	    }
	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public boolean isSuccess() {
	        return success;
	    }
	    public void setSuccess(boolean success) {
	        this.success = success;
	    }
	}