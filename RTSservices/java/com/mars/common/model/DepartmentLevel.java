package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_department_level",schema="egovcommon")
public class DepartmentLevel {

	
	@Id
	@Column(name="user_department_id")
	private long userDepartmentId;
	
	@Column(name="user_department_level")
	private String userDepartmentLevel;

	public long getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}

	public String getUserDepartmentLevel() {
		return userDepartmentLevel;
	}

	public void setUserDepartmentLevel(String userDepartmentLevel) {
		this.userDepartmentLevel = userDepartmentLevel;
	}
	
	
}
