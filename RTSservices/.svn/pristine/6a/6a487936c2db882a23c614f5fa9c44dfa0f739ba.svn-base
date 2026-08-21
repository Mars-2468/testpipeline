package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.CitizenZone;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "zoneName"})
public class CitezenZoneDTO implements Serializable {

	private List<CitizenZone> zoneName;

	@XmlElement(name = "zoneName")
	public List<CitizenZone> getZoneName() {
		return zoneName;
	}

	public void setZoneName(List<CitizenZone> zoneName) {
		this.zoneName = zoneName;
	}

	
}
