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

/**
 * District
 */
@Entity
@Table(name = "DISTRICT", schema = "egovcommon")
public class District implements java.io.Serializable {

	@Id
	@Column(name = "DISTRICT_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.DISTRICT_SEQ", sequenceName = "egovcommon.DISTRICT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.DISTRICT_SEQ")
	private long districtId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private State state = new State();

	@Column(name = "NAME_RGL", nullable = true)
	private String name_rgl;

	@Column(name = "CODE_RGL", nullable = true)
	private String code_rgl;

	public District() {
	}

	public District(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public District(String name, String code, Integer status, State state) {
		this.name = name;
		this.code = code;
		this.status = status;
		this.state = state;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

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
