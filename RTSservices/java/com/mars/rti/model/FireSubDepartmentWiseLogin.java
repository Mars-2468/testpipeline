package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fire_sub_department_wise_login",schema="egovrti")
public class FireSubDepartmentWiseLogin {

			@Id
			@Column(name = "fire_sub_department_wise_login_id", nullable = false, unique = true)
			@SequenceGenerator(name = "fire_sub_department_wise_login_seq", sequenceName = "fire_sub_department_wise_login_seq")
			@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_sub_department_wise_login_seq")
			private long fireSubDepartmentWiseLoginId;
			
			@Column(name ="fire_sub_department_wise_login_name",nullable= true)
			private String fireSubDepartmentWiseLoginName;

			public long getFireSubDepartmentWiseLoginId() {
				return fireSubDepartmentWiseLoginId;
			}

			public void setFireSubDepartmentWiseLoginId(long fireSubDepartmentWiseLoginId) {
				this.fireSubDepartmentWiseLoginId = fireSubDepartmentWiseLoginId;
			}

			public String getFireSubDepartmentWiseLoginName() {
				return fireSubDepartmentWiseLoginName;
			}

			public void setFireSubDepartmentWiseLoginName(String fireSubDepartmentWiseLoginName) {
				this.fireSubDepartmentWiseLoginName = fireSubDepartmentWiseLoginName;
			}

			
			
	}

