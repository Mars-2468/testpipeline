package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlRootElement(name = "request")
@XmlType(propOrder = {"command","ts","txn","data","pdfRestDTO","certlist","filelist"})	
public class RequestDTO {

	
	
	private String command;
	
	private String ts;
	
	
	private String txn;
	
	
	private String data;
	


private PDFRestDTO  pdfRestDTO;



private CertificateDSClistDTO certlist;

private CertificateDSClistDTO filelist;


	@XmlElement(name = "command")
	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}

	@XmlElement(name = "ts")
	public String getTs() {
		return ts;
	}


	public void setTs(String ts) {
		this.ts = ts;
	}

	@XmlElement(name = "txn")
	public String getTxn() {
		return txn;
	}


	public void setTxn(String txn) {
		this.txn = txn;
	}

	@XmlElement(name = "data")
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	
	@XmlElement(name = "pdf")
	public PDFRestDTO getPdfRestDTO() {
		return pdfRestDTO;
	}


	public void setPdfRestDTO(PDFRestDTO pdfRestDTO) {
		this.pdfRestDTO = pdfRestDTO;
	}

	

	@XmlElement(name = "certificate")
	public CertificateDSClistDTO getCertlist() {
		return certlist;
	}


	public void setCertlist(CertificateDSClistDTO certlist) {
		this.certlist = certlist;
	}

	@XmlElement(name = "file")
	public CertificateDSClistDTO getFilelist() {
		return filelist;
	}


	public void setFilelist(CertificateDSClistDTO filelist) {
		this.filelist = filelist;
	}

	
	
	
	
	
	
	
	
}
