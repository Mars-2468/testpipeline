package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="genderofcrematious",schema="egovcommon")

public class GenderOfCrematious {
	
	@Id
	@Column(name = "genderid", nullable = false, unique = true)
	private long genderid;
	
	@Column(name = "gender", nullable = false)
    private String gender;
	
	public long getGenderid() {
		return genderid;
	}

	public void setGenderid(long genderid) {
		this.genderid = genderid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
