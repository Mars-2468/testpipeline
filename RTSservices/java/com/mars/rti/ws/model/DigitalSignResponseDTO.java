package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "response")
@XmlType(propOrder = {"command","ts","txn","data","requrl","status"})	
public class DigitalSignResponseDTO {
	
	private String command;
	private String ts;
	
	private String txn;
	
	private String status;
	
	
	private String data;
	
private String Requrl;

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
@XmlElement(name = "status")
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
@XmlElement(name = "data")
public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}
@XmlElement(name = "Requrl")
public String getRequrl() {
	return Requrl;
}

public void setRequrl(String requrl) {
	Requrl = requrl;
}
	
	
	
}
