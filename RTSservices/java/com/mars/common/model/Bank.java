package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Bank 
 */
@Entity
@Table(name = "BANK", schema = "egovcommon")
public class Bank implements java.io.Serializable
{

	@Id	
	@Column(name="BANK_ID", nullable=false ,unique=true)	
	@SequenceGenerator(name="egovcommon.BANK_SEQ", sequenceName="egovcommon.BANK_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.BANK_SEQ")
    private long bankId;

	@Column(name = "BANK_NAME", nullable = false)
    private String bankName;

	@Column(name = "STATUS", nullable = true)
    private Integer status;
    
	@Column(name = "BANK_NAME_RGL", nullable = true)
    private String bankName_rgl;
    
	@Column(name = "WEBSITE", nullable = true)
    private String website;

    public String getBankName_rgl() {
		return bankName_rgl;
	}

	public void setBankName_mr(String bankName_rgl) {
		this.bankName_rgl = bankName_rgl;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	public Bank()
    {
    }

    public Bank(String bankName)
    {
	this.bankName = bankName;
    }

    public Bank(String bankName, Integer status)
    {
	this.bankName = bankName;
	this.status = status;
    }

    public long getBankId()
    {
	return this.bankId;
    }

    public void setBankId(long bankId)
    {
	this.bankId = bankId;
    }

    public String getBankName()
    {
	return this.bankName;
    }

    public void setBankName(String bankName)
    {
	this.bankName = bankName;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

}
