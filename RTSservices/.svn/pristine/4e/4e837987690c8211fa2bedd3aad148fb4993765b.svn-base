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
import javax.persistence.Transient;


@Entity
@Table(name = "report_parameters", schema = "egovrti")
public class ReportParameters implements java.io.Serializable,Comparable<ReportParameters>
{
	@Id	
    @Column(name="report_parameters_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="report_parameters_seq", sequenceName="report_parameters_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="report_parameters_seq") 
    private long reportParametersId;

	@Column(name="parameter_name", nullable=false ,unique=true)
	private String name;
    
	@Column(name="parameter_display_name", nullable=false ,unique=true)
    private String displayName;

	@Transient
	private String value;

	@Column(name="parameter_datatype", nullable=false ,unique=true)
    private String dataType;

	@Column(name="parameter_required", nullable=false ,unique=true)
    private int reportParameterRequired;

	@Column(name="default_value", nullable=true ,unique=true)
    private String defaultValue;
    
	@Column(name="internal_entity_name", nullable=true ,unique=true)
    private String internalEntityName;
    
	@Column(name="parameter_size", nullable=false ,unique=true)
    private int size;
    
	@Column(name="tenancyid", nullable=true ,unique=true)
    private int tenancyid;
	
	@ManyToOne
	@JoinColumn(name = "reports_id", nullable = false)
	private Reports reports;

    
    public String getInternalEntityName() {
		return internalEntityName;
	}

	public void setInternalEntityName(String internalEntityName) {
		this.internalEntityName = internalEntityName;
	}
	
    public ReportParameters()
    {
    }

    public ReportParameters(String name, String displayName, String value, String dataType, int reportParameterRequired, String defaultValue, String internalEntityName, int size)
    {
		this.name = name;
		this.displayName = displayName;
		this.value = value;
		this.dataType = dataType;
		this.reportParameterRequired = reportParameterRequired;
		this.defaultValue = defaultValue;
		this.internalEntityName = internalEntityName;
		this.size = size;
    }

    public ReportParameters(String name, String displayName, String value, String dataType, int reportParameterRequired, String defaultValue, String internalEntityName, int size, Reports reports)
    {
		this.name = name;
		this.displayName = displayName;
		this.value = value;
		this.dataType = dataType;
		this.reportParameterRequired = reportParameterRequired;
		this.defaultValue = defaultValue;
		this.internalEntityName = internalEntityName;
		this.size = size;		
		this.reports = reports;
    }

    public long getReportParametersId()
    {
    	return this.reportParametersId;
    }

    public void setReportParametersId(long reportParametersId)
    {
    	this.reportParametersId = reportParametersId;
    }

    public String getName()
    {
    	return this.name;
    }

    public void setName(String name)
    {
    	this.name = name;
    }

    public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
    
    public String getValue()
    {
    	return this.value;
    }

    public void setValue(String value)
    {
    	this.value = value;
    }

    public String getDataType()
    {
    	return this.dataType;
    }

    public void setDataType(String dataType)
    {
    	this.dataType = dataType;
    }

    public int getReportParameterRequired()
    {
    	return this.reportParameterRequired;
    }

    public void setReportParameterRequired(int reportParameterRequired)
    {
    	this.reportParameterRequired = reportParameterRequired;
    }

    public String getDefaultValue()
    {
    	return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue)
    {
    	this.defaultValue = defaultValue;
    }

    /**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public Reports getReports()
    {
    	return this.reports;
    }

    public void setReports(Reports reports)
    {
    	this.reports = reports;
    }

	public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}


	
	
	public int compareTo(ReportParameters arg0){
	    return this.reportParametersId > arg0.getReportParametersId() ? 1 : this.reportParametersId < arg0.getReportParametersId() ? -1 : 0;
	  }
    
}
