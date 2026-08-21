package com.mars.common.model;

/**
 * <p>Title: Reports.java </p>

 * <p>Description: Model class for Reports</p>

 * Copyright (c) 2008 for eGovernance Goa

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 *
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mars.common.search.BaseSearchObject;

@Entity
@Table(name = "reports", schema = "egovrti")
public class Reports extends BaseSearchObject implements java.io.Serializable
{

	@Id	
    @Column(name="reports_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="reports_seq", sequenceName="reports_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="reports_seq") 
    private long reportsId;

	@Column(name="report_display_name", nullable=false ,unique=true)
    private String reportDisplayName;

	@Column(name="report_name", nullable=false ,unique=true)
    private String reportName;

	@Column(name="report_path", nullable=false ,unique=true)
    private String reportPath;

	@Column(name="report_type", nullable=false ,unique=true)
    private String reportType;

	@Column(name="tenancyid", nullable=true ,unique=true)	
    private Long tenancyid;
	
	@Column(name="is_multilingual", nullable=false ,unique=true)
    private Integer isMultilingual = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reports")	
    private Set<ReportParameters> reportParameters = new HashSet<ReportParameters>();

    public Reports()
    {
    }

    public Reports(String reportDisplayName, String reportName, String reportPath, String reportType)
    {
	this.reportDisplayName = reportDisplayName;
	this.reportName = reportName;
	this.reportPath = reportPath;
	this.reportType = reportType;
    }

    public Reports(String reportDisplayName, String reportName, String reportPath, String reportType, Set<ReportParameters> reportParameters)
    {
	this.reportDisplayName = reportDisplayName;
	this.reportName = reportName;
	this.reportPath = reportPath;
	this.reportType = reportType;
	this.reportParameters = reportParameters;
    }

    public long getReportsId()
    {
	return this.reportsId;
    }

    public void setReportsId(long reportsId)
    {
	this.reportsId = reportsId;
    }

    public String getReportDisplayName()
    {
	return this.reportDisplayName;
    }

    public void setReportDisplayName(String reportDisplayName)
    {
	this.reportDisplayName = reportDisplayName;
	if(this.reportDisplayName != null  && this.reportDisplayName.length() > 0)
		setSearchParamSet(true);
    }

    public String getReportName()
    {
	return this.reportName;
    }

    public void setReportName(String reportName)
    {
	this.reportName = reportName;
	if(this.reportName != null  && this.reportName.length() > 0)
		setSearchParamSet(true);
    }

    public String getReportPath()
    {
	return this.reportPath;
    }

    public void setReportPath(String reportPath)
    {
	this.reportPath = reportPath;
	if(this.reportPath != null  && this.reportPath.length() > 0)
		setSearchParamSet(true);
    }

    public String getReportType()
    {
	return this.reportType;
    }

    public void setReportType(String reportType)
    {
	this.reportType = reportType;
	if(this.reportType != null  && this.reportType.length() > 0)
		setSearchParamSet(true);
    }


    public Integer getIsMultilingual() {
		return isMultilingual;
	}

	public void setIsMultilingual(Integer isMultilingual) {
		this.isMultilingual = isMultilingual;
	}

	public Set<ReportParameters> getReportParameters()
    {
	return this.reportParameters;
    }

    public void setReportParameters(Set<ReportParameters> reportParameters)
    {
	this.reportParameters = reportParameters;
    }

	public Long getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(Long tenancyid) {
		this.tenancyid = tenancyid;
	}
    
}
