package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mars.common.utils.Constants;


@Entity
@Table(name = "stage", schema = "egovrti")
public class Stage implements java.io.Serializable
{
	@Id	
    @Column(name="stage_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="stage_seq", sequenceName="stage_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="stage_seq")
    private long stageId;

	@Column(name="description", nullable=true ,unique=true)	
	private String description;
    
	@Column(name="tenancyid", nullable=true ,unique=true)	
    private long tenancyid;

	@Column(name="status", nullable=true ,unique=true)	
	private Integer status = new Integer(Constants.ACTIVE);

    public Stage()
    {
    }

    public Stage(String description, Integer status)
    {
	this.description = description;
	this.status = status;
    }

    public long getStageId()
    {
	return this.stageId;
    }

    public void setStageId(long stageId)
    {
	this.stageId = stageId;
    }

    public String getDescription()
    {
	return this.description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

	public long getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(long tenancyid) {
		this.tenancyid = tenancyid;
	}


    
}
