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
@Table(name = "area_ward", schema = "egovcommon")
public class AreaWard implements java.io.Serializable
{
	@Id	
    @Column(name="area_ward_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="area_ward_seq", sequenceName="area_ward_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="area_ward_seq") 
    private long areaWardId;
    
	@Column(name="tenancyid", nullable=true ,unique=true)
	private int tenancyid;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = true)
	private Area area = new Area();
    
	@ManyToOne
	@JoinColumn(name = "ward_id", nullable = true)
    private WardMaster wardMaster = new WardMaster();

    public AreaWard()
    {
    }

	/**
	 * @return the areaWardId
	 */
	public long getAreaWardId() {
		return areaWardId;
	}

	/**
	 * @param areaWardId the areaWardId to set
	 */
	public void setAreaWardId(long areaWardId) {
		this.areaWardId = areaWardId;
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
	
	public WardMaster getWardMaster() {
		return wardMaster;
	}

	public void setWardMaster(WardMaster wardMaster) {
		this.wardMaster = wardMaster;
	}

	public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}
	
}
