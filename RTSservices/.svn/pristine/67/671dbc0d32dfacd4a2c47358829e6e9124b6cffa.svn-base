package com.mars.common.model;

/**
 * Designation 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "designation_view", schema = "egovcommon")
public class Designation implements java.io.Serializable
{
	@Id	
    @Column(name="designation_id", nullable=false ,unique=true)	
   /* @SequenceGenerator(name="egovcommon.designation_seq", sequenceName="egovcommon.designation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.designation_seq") */
    private long designationId;

	@Column(name = "designation_name", unique = true, nullable = false)
	private String name;

	@Column(name = "status", unique = true, nullable = true)
	private String status;
    
    public Designation()
    {
    }

    public Designation(String name)
    {
	this.name = name;
    }

    public long getDesignationId()
    {
	return this.designationId;
    }

    public void setDesignationId(long designationId)
    {
	this.designationId = designationId;
    }

    public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getStatus()
    {
	return this.status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

}
