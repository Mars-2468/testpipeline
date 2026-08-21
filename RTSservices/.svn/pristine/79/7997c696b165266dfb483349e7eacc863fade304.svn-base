package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.CitizenHospital;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "HospitalName" })
public class CitizenHospitalRestDTO implements Serializable {
	private List<CitizenHospital> HospitalName;

	@XmlElement(name = "HospitalName")
	public List<CitizenHospital> getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(List<CitizenHospital> hospitalName) {
		HospitalName = hospitalName;
	}

}
