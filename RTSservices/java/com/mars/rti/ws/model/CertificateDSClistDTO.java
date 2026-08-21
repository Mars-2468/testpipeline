package com.mars.rti.ws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CertificateDSClistDTO {
	
	
	
	
	private List<CertificateRestDto> certlist;
	
	private List<FileRestDTO> filelist;

	@XmlElement(name = "attribute")
	public List<CertificateRestDto> getCertlist() {
		return certlist;
	}

	public void setCertlist(List<CertificateRestDto> certlist) {
		this.certlist = certlist;
	}

	@XmlElement(name = "attribute")
	public List<FileRestDTO> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<FileRestDTO> filelist) {
		this.filelist = filelist;
	}
	
	

}
