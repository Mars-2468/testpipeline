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




/**
 * City
 */
@Entity
@Table(name = "city_master", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class CityMaster implements java.io.Serializable
{

	@Id
	@Column(name = "city_id", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.CITY_MASTER_SEQ", sequenceName = "egovcommon.CITY_MASTER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.CITY_MASTER_SEQ")
	@RemoteProperty
    private long cityId;

	@Column(name = "city_name", nullable = false)
	@RemoteProperty
	private String cityName;
	
	@Column(name = "status", nullable = true)
	@RemoteProperty
	private int status=1;
	
	/*@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private Category category = null;
*/
	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @param cityId
	 * @param cityName
	 * @param status
	 */
	public CityMaster(long cityId, String cityName, int status) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.status = status;
	}

	/**
	 * 
	 */
	public CityMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
*/
	
	
	
	
}
