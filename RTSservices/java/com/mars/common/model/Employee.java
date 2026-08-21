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
 * Employee 
 */
@Entity
@Table(name = "EMPLOYEE", schema = "egovrti")
public class Employee implements java.io.Serializable
{

	@Id
	@Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    private long employeeId;

	@Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

	@Column(name = "MIDDLE_NAME", nullable = true)
    private String middleName;
    
	@Column(name = "EMAIL", nullable = false)
    private String email="";

	@Column(name = "LAST_NAME", nullable = true)
    private String lastName;

	@Column(name = "STATUS", nullable = true)
    private Integer status;
   
	@Column(name = "TENANCYID", nullable = true)
    private Integer tenancyId;

	@ManyToOne
	@JoinColumn(name = "designation_id", nullable = false)
    private Designation designation = new Designation();
    
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department = new Department();

    @ManyToOne
    @JoinColumn(name = "SUPERIOR_ID", nullable = true)
    private Employee superior = null;

    public Employee()
    {
    }

    public Employee(String firstName)
    {
	this.firstName = firstName;
    }

    public Employee(String firstName, String middleName, String lastName, Integer status, Designation designation, Department department, Employee superior)
    {
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.status = status;
	this.designation = designation;
	this.department = department;
	this.superior = superior;
    }

    public long getEmployeeId()
    {
	return this.employeeId;
    }

    public void setEmployeeId(long employeeId)
    {
	this.employeeId = employeeId;
    }

    public String getFirstName()
    {
	return this.firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getMiddleName()
    {
	return this.middleName;
    }

    public void setMiddleName(String middleName)
    {
	this.middleName = middleName;
    }

    public String getLastName()
    {
	return this.lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

    
    
    public Integer getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Integer tenancyId) {
		this.tenancyId = tenancyId;
	}

	public Designation getDesignation()
    {
	return this.designation;
    }

    public void setDesignation(Designation designation)
    {
	this.designation = designation;
    }

    public Department getDepartment()
    {
	return this.department;
    }

    public void setDepartment(Department department)
    {
	this.department = department;
    }

    public Employee getSuperior()
    {
	return this.superior;
    }

    public void setSuperior(Employee superior)
    {
	this.superior = superior;
    }

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
