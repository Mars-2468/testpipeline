package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Salutation 
 */
@Entity
@Table(name = "SALUTATION", schema = "egovrti")
public class Salutation implements java.io.Serializable
{

	@Id
	@Column(name = "SALUTATION_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "SALUTATION_SEQ", sequenceName = "SALUTATION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALUTATION_SEQ")
    private long salutationId;

	@Column(name = "SALUTATION_NAME", nullable = false)
    private String salutationName;

	@Column(name = "STATUS", nullable = true)
    private Integer status;
    
	@Column(name = "TENANCYID", nullable = true)
    private Integer tenancyId;

    public Salutation()
    {
    }

    public Salutation(String salutationName)
    {
	this.salutationName = salutationName;
    }

    public Salutation(String salutationName, Integer status)
    {
	this.salutationName = salutationName;
	this.status = status;
    }

    public long getSalutationId()
    {
	return this.salutationId;
    }

    public void setSalutationId(long salutationId)
    {
	this.salutationId = salutationId;
    }

    public String getSalutationName()
    {
	return this.salutationName;
    }

    public void setSalutationName(String salutationName)
    {
	this.salutationName = salutationName;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

	public Integer getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Integer tenancyId) {
		this.tenancyId = tenancyId;
	}

}
