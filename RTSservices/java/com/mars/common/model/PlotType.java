package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * PlotType
 */
@Entity
@Table(name = "PLOT_TYPE", schema = "egovcommon")
public class PlotType implements java.io.Serializable {

	@Id
	@Column(name = "PLOT_TYPE_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.PLOT_TYPE_SEQ", sequenceName = "egovcommon.PLOT_TYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.PLOT_TYPE_SEQ")
	private long plotTypeId;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	public PlotType() {
	}

	public PlotType(String description, Integer status, Sector sector,
			Integer type) {
		this.description = description;
		this.status = status;
	}

	public long getPlotTypeId() {
		return plotTypeId;
	}

	public void setPlotTypeId(long plotTypeId) {
		this.plotTypeId = plotTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
