package com.mars.rti.ws.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
getterVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({
	 "ApplicationID",
	 "ServiceName",
	 "ApplicantName",
	 "EstimatedDisbursalDays",
	 "ApplicationSubmissionDate",
	 "ApplicationPaymentDate",
	 "NextActionRequiredDetails",
	 "FinalDecision",
	 "TotalNumberOfDesks",
	 "CurrentDeskNumber",
	 "NextDeskNumber",
	 "DeskDetails"
	})
public class TrackStatusResponseDTO {

	 @JsonProperty("ApplicationID")
	    private String ApplicationID;

	    @JsonProperty("ServiceName")
	    private String ServiceName;

	    @JsonProperty("ApplicantName")
	    private String ApplicantName;

	    @JsonProperty("EstimatedDisbursalDays")
	    private int EstimatedDisbursalDays;

	    @JsonProperty("ApplicationSubmissionDate")
	    private String ApplicationSubmissionDate;

	    @JsonProperty("ApplicationPaymentDate")
	    private String ApplicationPaymentDate;

	    @JsonProperty("NextActionRequiredDetails")
	    private String NextActionRequiredDetails;

	    @JsonProperty("FinalDecision")
	    private int FinalDecision;

	    @JsonProperty("TotalNumberOfDesks")
	    private int TotalNumberOfDesks;

	    @JsonProperty("CurrentDeskNumber")
	    private int CurrentDeskNumber;

	    @JsonProperty("NextDeskNumber")
	    private int NextDeskNumber;

	    @JsonProperty("DeskDetails")
	    private List<DeskDetailDTO> DeskDetails;
	public String getApplicationID() {
		return ApplicationID;
	}
	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getApplicantName() {
		return ApplicantName;
	}
	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}
	public int getEstimatedDisbursalDays() {
		return EstimatedDisbursalDays;
	}
	public void setEstimatedDisbursalDays(int estimatedDisbursalDays) {
		EstimatedDisbursalDays = estimatedDisbursalDays;
	}
	public String getApplicationSubmissionDate() {
		return ApplicationSubmissionDate;
	}
	public void setApplicationSubmissionDate(String applicationSubmissionDate) {
		ApplicationSubmissionDate = applicationSubmissionDate;
	}
	public String getApplicationPaymentDate() {
		return ApplicationPaymentDate;
	}
	public void setApplicationPaymentDate(String applicationPaymentDate) {
		ApplicationPaymentDate = applicationPaymentDate;
	}
	public String getNextActionRequiredDetails() {
		return NextActionRequiredDetails;
	}
	public void setNextActionRequiredDetails(String nextActionRequiredDetails) {
		NextActionRequiredDetails = nextActionRequiredDetails;
	}
	public int getFinalDecision() {
		return FinalDecision;
	}
	public void setFinalDecision(int finalDecision) {
		FinalDecision = finalDecision;
	}
	public int getTotalNumberOfDesks() {
		return TotalNumberOfDesks;
	}
	public void setTotalNumberOfDesks(int totalNumberOfDesks) {
		TotalNumberOfDesks = totalNumberOfDesks;
	}
	public int getCurrentDeskNumber() {
		return CurrentDeskNumber;
	}
	public void setCurrentDeskNumber(int currentDeskNumber) {
		CurrentDeskNumber = currentDeskNumber;
	}
	public int getNextDeskNumber() {
		return NextDeskNumber;
	}
	public void setNextDeskNumber(int nextDeskNumber) {
		NextDeskNumber = nextDeskNumber;
	}
	public List<DeskDetailDTO> getDeskDetails() {
		return DeskDetails;
	}
	public void setDeskDetails(List<DeskDetailDTO> deskDetails) {
		DeskDetails = deskDetails;
	}
    
    

    // getters and setters
}
