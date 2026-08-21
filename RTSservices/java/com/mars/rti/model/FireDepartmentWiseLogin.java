package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fire_department_wise_login",schema="egovrti")
public class FireDepartmentWiseLogin {

			@Id
			@Column(name = "fire_department_wise_login_id", nullable = false, unique = true)
			@SequenceGenerator(name = "fire_department_wise_login_seq", sequenceName = "fire_department_wise_login_seq")
			@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_department_wise_login_seq")
			private long fireDepartmentWiseLoginId;
			
			@Column(name ="fire_department_wise_login_name",nullable= true)
			private String fireDepartmentWiseLoginName;

			public long getFireDepartmentWiseLoginId() {
				return fireDepartmentWiseLoginId;
			}

			public void setFireDepartmentWiseLoginId(long fireDepartmentWiseLoginId) {
				this.fireDepartmentWiseLoginId = fireDepartmentWiseLoginId;
			}

			public String getFireDepartmentWiseLoginName() {
				return fireDepartmentWiseLoginName;
			}

			public void setFireDepartmentWiseLoginName(String fireDepartmentWiseLoginName) {
				this.fireDepartmentWiseLoginName = fireDepartmentWiseLoginName;
			}

			
	}

