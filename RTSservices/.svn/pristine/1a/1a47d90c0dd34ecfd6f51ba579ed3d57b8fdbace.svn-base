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



/**
 * NodeMaster 
 */
@Entity
@Table(name = "NODE_MASTER", schema = "egovcommon")
public class NodeMaster implements java.io.Serializable
{

	@Id	
    @Column(name="NODE_MASTER_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.NODE_MASTER_SEQ", sequenceName="egovcommon.NODE_MASTER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.NODE_MASTER_SEQ") 
    private long nodeMasterId;

	@Column(name = "NAME", nullable = false)
    private String name;

	@Column(name = "CODE", nullable = false)
    private String code;

	@Column(name = "STATUS", nullable = true)
    private Integer status;

	@ManyToOne
    @JoinColumn(name = "WARD_ID", nullable = false)
    private Ward ward = new Ward();
    
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "nodeMaster")
	private Set<Sector> sectorSet = new HashSet<Sector>();
        
    //Used in assignSectors.jsp for Ward
    @Transient
    private boolean checked = true;
    
    @Column(name = "NAME_RGL", nullable = true)
    private String name_rgl;

    @Column(name = "CODE_RGL", nullable = true)
    private String code_rgl;
    
    /**
	 * @return the sectorSet
	 */
	public Set getSectorSet() {
		return sectorSet;
	}

	/**
	 * @param sectorSet the sectorSet to set
	 */
	public void setSectorSet(Set sectorSet) {
		this.sectorSet = sectorSet;
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

	public NodeMaster()
    {
    }

    public NodeMaster(String name, String code)
    {
	this.name = name;
	this.code = code;
    }

    public NodeMaster(String name, String code, Integer status, Ward ward)
    {
	this.name = name;
	this.code = code;
	this.status = status;
	this.ward = ward;
    }

    public long getNodeMasterId()
    {
	return this.nodeMasterId;
    }

    public void setNodeMasterId(long nodeMasterId)
    {
	this.nodeMasterId = nodeMasterId;
    }

    public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getCode()
    {
	return this.code;
    }

    public void setCode(String code)
    {
	this.code = code;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

    public Ward getWard()
    {
	return this.ward;
    }

    public void setWard(Ward ward)
    {
	this.ward = ward;
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
