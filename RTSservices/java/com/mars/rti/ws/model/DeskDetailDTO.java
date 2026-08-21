package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
getterVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({
	 "DeskNumber",
	 "ReviewActionBy",
	 "ReviewActionDateTime",
	 "ReviewActionDetails",
	 "DeskRemark"
	})
public class DeskDetailDTO {

	 @JsonProperty("DeskNumber")
	    private String DeskNumber;

	    @JsonProperty("ReviewActionBy")
	    private String ReviewActionBy;

	    @JsonProperty("ReviewActionDateTime")
	    private String ReviewActionDateTime;

	    @JsonProperty("ReviewActionDetails")
	    private String ReviewActionDetails;

	    @JsonProperty("DeskRemark")
	    private String DeskRemark;
    
	public String getDeskNumber() {
		return DeskNumber;
	}
	public void setDeskNumber(String deskNumber) {
		DeskNumber = deskNumber;
	}
	public String getReviewActionBy() {
		return ReviewActionBy;
	}
	public void setReviewActionBy(String reviewActionBy) {
		ReviewActionBy = reviewActionBy;
	}
	public String getReviewActionDateTime() {
		return ReviewActionDateTime;
	}
	public void setReviewActionDateTime(String reviewActionDateTime) {
		ReviewActionDateTime = reviewActionDateTime;
	}
	public String getReviewActionDetails() {
		return ReviewActionDetails;
	}
	public void setReviewActionDetails(String reviewActionDetails) {
		ReviewActionDetails = reviewActionDetails;
	}
	public String getDeskRemark() {
		return DeskRemark;
	}
	public void setDeskRemark(String deskRemark) {
		DeskRemark = deskRemark;
	}
	

    // getters and setters
    
}
