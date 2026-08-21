package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * State
 */
@Entity
@Table(name = "STATE", schema = "egovcommon")
public class State implements java.io.Serializable {

	@Id
	@Column(name = "STATE_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.STATE_SEQ", sequenceName = "egovcommon.STATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.STATE_SEQ")
	private long stateId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	@Column(name = "NAME_RGL", nullable = true)
	private String name_rgl;

	@Column(name = "CODE_RGL", nullable = true)
	private String code_rgl;

	@Column(name = "REGION", nullable = true)
	private Integer region;

	public State() {
	}

	public State(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public State(String name, String code, Integer status) {
		this.name = name;
		this.code = code;
		this.status = status;
	}

	public long getStateId() {
		return this.stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
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

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

}
