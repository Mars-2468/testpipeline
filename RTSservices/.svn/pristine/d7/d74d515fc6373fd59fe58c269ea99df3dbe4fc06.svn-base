package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;


@Entity
@Table(name = "city", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class City implements java.io.Serializable
{
	
	@Id	
    @Column(name="city_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.city_seq", sequenceName="egovcommon.city_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.city_seq")
	@RemoteProperty
    private long cityId;

	@Column(name="name", nullable=false ,unique=true)
	@RemoteProperty
	private String name;
	
	@Column(name="code", nullable=false ,unique=true)
	@RemoteProperty
    private String code;
	
	@Column(name="status", nullable=true ,unique=true)
	@RemoteProperty
    private Integer status=1;
	
	/*@ManyToOne
	@JoinColumn(name = "taluka_id", nullable = true)
    private Taluka taluka = new Taluka();*/
    
	@Column(name="name_rgl", nullable=true ,unique=true)
    private String name_rgl;

	@Column(name="code_rgl", nullable=true ,unique=true)
	private String code_rgl;
    
	@Column(name="is_tribal", nullable=true ,unique=true)
    private Integer isTribal;
	
	@Column(name="is_hill", nullable=true ,unique=true)
    private Integer isHill;
	
	@Column(name="is_remote", nullable=true ,unique=true)
    private Integer isRemote;
	
	@Column(name="is_border", nullable=true ,unique=true)
    private Integer isBorder;
	
	@Column(name="is_island", nullable=true ,unique=true)
    private Integer isIsland;
	
	@Column(name="is_badclimate", nullable=true ,unique=true)
    private Integer isBadclimate;
    
	/*@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	@NotFound(action=NotFoundAction.IGNORE)
	private CityCategory category = new CityCategory();*/
    
    
	public Integer getIsTribal() {
		return isTribal;
	}

	public void setIsTribal(Integer isTribal) {
		this.isTribal = isTribal;
	}

	public Integer getIsHill() {
		return isHill;
	}

	public void setIsHill(Integer isHill) {
		this.isHill = isHill;
	}

	public Integer getIsRemote() {
		return isRemote;
	}

	public void setIsRemote(Integer isRemote) {
		this.isRemote = isRemote;
	}

	public Integer getIsBorder() {
		return isBorder;
	}

	public void setIsBorder(Integer isBorder) {
		this.isBorder = isBorder;
	}

	public Integer getIsIsland() {
		return isIsland;
	}

	public void setIsIsland(Integer isIsland) {
		this.isIsland = isIsland;
	}

	public Integer getIsBadclimate() {
		return isBadclimate;
	}

	public void setIsBadclimate(Integer isBadclimate) {
		this.isBadclimate = isBadclimate;
	}

	public City()
    {
    }

    public City(String name, String code)
    {
	this.name = name;
	this.code = code;
    }

    public City(String name, String code, Integer status, Taluka taluka)
    {
	this.name = name;
	this.code = code;
	this.status = status;
	
    }
    
    

  /*  public CityCategory getCategory() {
		return category;
	}

	public void setCategory(CityCategory category) {
		this.category = category;
	}
*/
	

    public long getCityId()
    {
	return this.cityId;
    }

    public void setCityId(long cityId)
    {
	this.cityId = cityId;
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

 /*   public Taluka getTaluka()
    {
	return this.taluka;
    }

    public void setTaluka(Taluka taluka)
    {
	this.taluka = taluka;
    }
*/
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
