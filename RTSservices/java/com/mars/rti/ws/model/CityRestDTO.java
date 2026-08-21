package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * FeeMaster 
 */
@XmlRootElement(name = "City")
@XmlType(propOrder = {"cityId","name","code","status","name_rgl","code_rgl",
						"isTribal","isHill","isRemote","isBorder","isIsland","isBadclimate"})
public class CityRestDTO  implements java.io.Serializable {

    private long cityId;
	private String name;
    private String code;
    private Integer status=1;
    private String name_rgl;
	private String code_rgl;
    private Integer isTribal;
    private Integer isHill;
    private Integer isRemote;
    private Integer isBorder;
    private Integer isIsland;
    private Integer isBadclimate;

    public CityRestDTO() {
    }

    @XmlElement(name = "cityId")
	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@XmlElement(name = "name_rgl")
	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	@XmlElement(name = "code_rgl")
	public String getCode_rgl() {
		return code_rgl;
	}

	public void setCode_rgl(String code_rgl) {
		this.code_rgl = code_rgl;
	}

	@XmlElement(name = "isTribal")
	public Integer getIsTribal() {
		return isTribal;
	}

	public void setIsTribal(Integer isTribal) {
		this.isTribal = isTribal;
	}

	@XmlElement(name = "isHill")
	public Integer getIsHill() {
		return isHill;
	}

	public void setIsHill(Integer isHill) {
		this.isHill = isHill;
	}

	@XmlElement(name = "isRemote")
	public Integer getIsRemote() {
		return isRemote;
	}

	public void setIsRemote(Integer isRemote) {
		this.isRemote = isRemote;
	}

	@XmlElement(name = "isBorder")
	public Integer getIsBorder() {
		return isBorder;
	}

	public void setIsBorder(Integer isBorder) {
		this.isBorder = isBorder;
	}

	@XmlElement(name = "isIsland")
	public Integer getIsIsland() {
		return isIsland;
	}

	public void setIsIsland(Integer isIsland) {
		this.isIsland = isIsland;
	}

	@XmlElement(name = "isBadclimate")
	public Integer getIsBadclimate() {
		return isBadclimate;
	}

	public void setIsBadclimate(Integer isBadclimate) {
		this.isBadclimate = isBadclimate;
	}

}