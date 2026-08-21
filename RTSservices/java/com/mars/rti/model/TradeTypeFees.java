package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trade_type_fees_master",schema="egovcommon")
public class TradeTypeFees {

	@Id
	@Column(name="tradetypeid")
	private long tradetypeid;
	
	@Column(name="tradetype")
	private String tradetype;
	
	@Column(name="tradetypefees")
	private String tradetypefees;

	public long getTradetypeid() {
		return tradetypeid;
	}

	public void setTradetypeid(long tradetypeid) {
		this.tradetypeid = tradetypeid;
	}

	public String getTradetype() {
		return tradetype;
	}

	public void setTradetype(String tradetype) {
		this.tradetype = tradetype;
	}

	public String getTradetypefees() {
		return tradetypefees;
	}

	public void setTradetypefees(String tradetypefees) {
		this.tradetypefees = tradetypefees;
	}
	
	

}
