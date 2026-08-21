package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * Taluka 
 */
@Entity
@Table(name = "TALUKA", schema = "egovcommon")
public class Taluka implements java.io.Serializable
{

	@Id	
    @Column(name="TALUKA_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.TALUKA_SEQ", sequenceName="egovcommon.TALUKA_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.TALUKA_SEQ") 
    private long talukaId;

	@Column(name = "NAME", nullable = false)
    private String name;

	@Column(name = "CODE", nullable = false)
    private String code;

	@Column(name = "STATUS", nullable = true)
    private Integer status;

	@ManyToOne
    @JoinColumn(name = "DISTRICT_ID", nullable = false)
    private District district = new District();
    
    @Column(name = "NAME_RGL", nullable = true)
    private String name_rgl;

    @Column(name = "CODE_RGL", nullable = true)
    private String code_rgl;

    public Taluka()
    {
    }

    public Taluka(String name, String code)
    {
	this.name = name;
	this.code = code;
    }

    public Taluka(String name, String code, Integer status, District district)
    {
	this.name = name;
	this.code = code;
	this.status = status;
	this.district = district;
    }

    public long getTalukaId()
    {
	return this.talukaId;
    }

    public void setTalukaId(long talukaId)
    {
	this.talukaId = talukaId;
    }

    public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getCode()
    {
	return this.code;
    }

    public void setCode(String code)
    {
	this.code = code;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

    public District getDistrict()
    {
	return this.district;
    }

    public void setDistrict(District district)
    {
	this.district = district;
    }

	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	public String getCode_rgl() {
		return code_rgl;
	}

	public void setCode_rgl(String code_rgl) {
		this.code_rgl = code_rgl;
	}

}
