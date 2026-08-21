package com.mars.rti.ws.model;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mars.rti.model.ZoneCrematious;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "ZoneCrematious" })


public class ZoneCrematiousDTO   implements Serializable{
	
	private List<ZoneCrematious> ZoneCrematious;

	@XmlElement(name = "ZoneCrematious")
	public List<ZoneCrematious> getZoneCrematious() {
		return ZoneCrematious;
	}

	public void setZoneCrematious(List<ZoneCrematious> zoneCrematious) {
		ZoneCrematious = zoneCrematious;
	}

}
