package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "area", schema = "egovcommon")
public class Area implements java.io.Serializable
{
	@Id	
    @Column(name="area_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="area_seq", sequenceName="area_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="area_seq") 
    private long areaId;

	@Column(name="name", nullable=false ,unique=true)
	private String name;

	@Column(name="name_rgl", nullable=true ,unique=true)
	private String name_rgl;
   /* 
	@Column(name="tenancyid", nullable=true ,unique=true)
	private int tenancyid;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Set<AreaSector> areaSectorSet = new LinkedHashSet<AreaSector>();
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Set<AreaWard> areaWardSet = new LinkedHashSet<AreaWard>();*/

	/**
	 * @return the areaId
	 */
	public long getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name_mr
	 */
	
	/**
	 * @return the areaSectorSet
	 */
	/*public Set<AreaSector> getAreaSectorSet() {
		return areaSectorSet;
	}*/

	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	/**
	 * @param areaSectorSet the areaSectorSet to set
	 */
	/*public void setAreaSectorSet(Set<AreaSector> areaSectorSet) {
		this.areaSectorSet = areaSectorSet;
	}

	*//**
	 * @return the areaWardSet
	 *//*
	public Set<AreaWard> getAreaWardSet() {
		return areaWardSet;
	}

	*//**
	 * @param areaWardSet the areaWardSet to set
	 *//*
	public void setAreaWardSet(Set<AreaWard> areaWardSet) {
		this.areaWardSet = areaWardSet;
	}

	public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}*/
	
}
