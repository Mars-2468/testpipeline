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


@Entity
@Table(name = "area_sector", schema = "egovrti")
public class AreaSector implements java.io.Serializable
{
	@Id	
    @Column(name="area_sector_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="area_sector_seq", sequenceName="area_sector_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="area_sector_seq") 
    private long areaSectorId;
    
	@Column(name="tenancyid", nullable=true ,unique=true)
	private int tenancyid;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = true)
	private Area area = new Area();
    
	@ManyToOne
	@JoinColumn(name = "sector_id", nullable = true)
	private Sector sector = new Sector();

    public AreaSector()
    {
    }

	/**
	 * @return the areaSectorId
	 */
	public long getAreaSectorId() {
		return areaSectorId;
	}


	/**
	 * @param areaSectorId the areaSectorId to set
	 */
	public void setAreaSectorId(long areaSectorId) {
		this.areaSectorId = areaSectorId;
	}


	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}


	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}


	/**
	 * @return the sector
	 */
	public Sector getSector() {
		return sector;
	}


	/**
	 * @param sector the sector to set
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}
	
}
