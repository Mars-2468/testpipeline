package com.mars.rti.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.TradeTypeFees;

@JsonPropertyOrder({ "tradeTypeFees", "response", "responseStatus" })
public class TradeTypeFeesRestDTO {

	
	private List<TradeTypeFees> tradeTypeFees;

	private String responseStatus;

	private long response;

	public List<TradeTypeFees> getTradeTypeFees() {
		return tradeTypeFees;
	}

	public void setTradeTypeFees(List<TradeTypeFees> tradeTypeFees) {
		this.tradeTypeFees = tradeTypeFees;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
	
	
}
