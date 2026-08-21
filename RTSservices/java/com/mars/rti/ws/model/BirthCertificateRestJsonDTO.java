package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BirthCertificateJsonValues")
@XmlType(propOrder = {"birthCertificateJsonValues"})

public class BirthCertificateRestJsonDTO {
	private String birthCertificateJsonValues;

	@XmlElement(name = "birthCertificateJsonValues")
	public String getBirthCertificateJsonValues() {
		return birthCertificateJsonValues;
	}

	public void setBirthCertificateJsonValues(String birthCertificateJsonValues) {
		this.birthCertificateJsonValues = birthCertificateJsonValues;
	}

	
		
	

}
