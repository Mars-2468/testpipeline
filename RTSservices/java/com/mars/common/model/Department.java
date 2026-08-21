package com.mars.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.RemoteProperty;

 


@Entity
@Table(name = "department_view", schema = "egovcommon")

public class Department implements java.io.Serializable
{
	@Id	
    @Column(name="department_id", nullable=false ,unique=true)	
	@RemoteProperty
    private long departmentId;
	
	@Column(name = "department_name_rgl", nullable = true)
    private String nameRgl;

	@Column(name = "department_name", nullable = true)
    private String name;
	
	@Column(name = "tenancyid", nullable = true)
    private Integer tenancyId;
	
	/*@Column(name = "description", nullable = true)
    private String description;
	*/

	/*@Column(name = "code", nullable = false)
    private String code;*/

	
	@Transient
    private boolean checked = true;
	
	
	@OneToMany( mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Section> sectionSet= new HashSet<Section>();
	
	
	
	
   

	public Department()
    {
    }

    public Department(String name)
    {
	this.name = name;
    }



    public long getDepartmentId()
    {
	return this.departmentId;
    }

    public void setDepartmentId(long departmentId)
    {
	this.departmentId = departmentId;
    }

    public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

	public String getNameRgl() {
		return nameRgl;
	}

	public void setNameRgl(String nameRgl) {
		this.nameRgl = nameRgl;
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

	 public Set<Section> getSectionSet() {
			return sectionSet;
		}

		public void setSectionSet(Set<Section> sectionSet) {
			this.sectionSet = sectionSet;
		}

		public Integer getTenancyId() {
			return tenancyId;
		}

		public void setTenancyId(Integer tenancyId) {
			this.tenancyId = tenancyId;
		}

		

		/*public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

   */		
		
}
