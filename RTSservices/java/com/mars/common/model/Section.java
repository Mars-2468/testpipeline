package com.mars.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;



@Entity
@Table(name = "section", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")

public class Section implements java.io.Serializable
{
	@Id	
    @Column(name="section_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.section_seq", sequenceName="egovcommon.section_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.section_seq")
    @RemoteProperty
    private long sectionId;
	
	
	 @RemoteProperty
	@Column(name = "name", nullable = true)
    private String name;
	
	@Column(name = "description", nullable = true)
    private String description;
	

	@Column(name = "code", nullable = false)
    private String code;
	
	@Column(name = "status", nullable = true)
    private int status;
	
	@Transient
    private boolean checked = true;
		
	 @ManyToOne
	 @JoinColumn(name = "department_id", nullable = true)
	 private Department department = new Department();    
	 
	 
	 @OneToMany( mappedBy = "section", cascade = CascadeType.ALL)
		private Set<User> userSet= new HashSet<User>();
	 
	 
	 
	 
	 
	 
	
    public Section()
    {
    }

    public Section(String name)
    {
	this.name = name;
    }



   

    public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

}
