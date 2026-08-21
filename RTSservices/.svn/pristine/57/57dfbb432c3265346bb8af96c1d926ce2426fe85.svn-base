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
 * Ward
 */
@Entity
@Table(name = "zone_master", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class ZoneMaster implements java.io.Serializable {

	@Id
	@Column(name = "ZONE_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.ZONE_MASTER_SEQ", sequenceName = "egovcommon.ZONE_MASTER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.ZONE_MASTER_SEQ")
	@RemoteProperty
	private long zoneId;

	
	@Column(name = "NAME", nullable = false)
	@RemoteProperty
	private String zoneName;
	
	@Column(name = "NAME_RGL", nullable = true)
	private String zoneNamergl;
	
	@Column(name = "STATUS", nullable = true)
	@RemoteProperty
	private int status=1;
	
	@ManyToOne
	@JoinColumn(name = "CITY_ID", nullable = true)
	private City city = new City();
	
	@Column(name = "CODE", nullable = false)
	@RemoteProperty
	private String code;

	
	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneNamergl() {
		return zoneNamergl;
	}

	public void setZoneNamergl(String zoneNamergl) {
		this.zoneNamergl = zoneNamergl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
