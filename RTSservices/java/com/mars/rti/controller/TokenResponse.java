package com.mars.rti.controller;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TokenResponse {

	 @JsonProperty("ErrorCode")
	    private String errorCode;

	    @JsonProperty("Result")
	    private String result;

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}
	    
	    

}