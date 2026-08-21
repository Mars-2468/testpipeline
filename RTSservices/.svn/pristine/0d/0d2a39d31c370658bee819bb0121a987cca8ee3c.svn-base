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

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
/**
 * Tenancy 
 */
@Entity
@Table(name = "TENANCY", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class Tenancy implements java.io.Serializable
{

	@Id	
	@Column(name="TENANCYID", nullable=true ,unique=true)	
	@SequenceGenerator(name="egovcommon.TENANCY_SEQ", sequenceName="egovcommon.TENANCY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.TENANCY_SEQ")
	@RemoteProperty
    private long tenancyId;

	@Column(name = "NAME", nullable = false)
    private String name;

	@Column(name = "STATUS", nullable = true)
    private Integer status=1;
    
	@Column(name = "NAME_RGL", nullable = true)
    private String name_rgl;
    
	@Column(name = "CODE", nullable = true)
    private String code;

	@Column(name = "CATEGORY", nullable = true)
    private String category;
	
	
	@Column(name = "municipal_name", nullable = true)
    private String municipalName;
	
	@Column(name = "email", nullable = true)
    private String email;
	
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city = new City();

	public long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(long tenancyId) {
		this.tenancyId = tenancyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getMunicipalName() {
		return municipalName;
	}

	public void setMunicipalName(String municipalName) {
		this.municipalName = municipalName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
