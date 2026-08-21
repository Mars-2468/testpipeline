package com.mars.rti.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.ws.model.TrackStatusResponseDTO;
import com.mars.rti.ws.model.DeskDetailDTO;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
getterVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({
	 "RecordStatus",
	 "Message",
	 "ApplicationStatus"
	})
public class TrackStatusMainDTO {
	
	@JsonProperty("RecordStatus")
	private boolean RecordStatus;
	
	@JsonProperty("Message")
	private String Message;
	
	@JsonProperty("ApplicationStatus")
	 private TrackStatusResponseDTO ApplicationStatus;

	

	public boolean isRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(boolean recordStatus) {
		RecordStatus = recordStatus;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public TrackStatusResponseDTO getApplicationStatus() {
		return ApplicationStatus;
	}

	public void setApplicationStatus(TrackStatusResponseDTO applicationStatus) {
		ApplicationStatus = applicationStatus;
	}

	
	 
	 

}
