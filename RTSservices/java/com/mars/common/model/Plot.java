package com.mars.common.model;

import javax.persistence.CascadeType;
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
 * Plot
 */
@Entity
@Table(name = "PLOT", schema = "egovcommon")
public class Plot implements java.io.Serializable {

	@Id
	@Column(name = "PLOT_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.PLOT_SEQ", sequenceName = "egovcommon.PLOT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.PLOT_SEQ")
	private long plotId;

	@Column(name = "PLOT_NUMBER", nullable = true)
	private String number;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PLOT_TYPE_ID", nullable = true)
	private PlotType plotType = new PlotType();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SECTOR_ID", nullable = true)
	private Sector sector = new Sector();

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	public Plot() {
	}

	public Plot(String number, Integer status, Sector sector, PlotType plotType) {
		this.number = number;
		this.status = status;
		this.sector = sector;
		this.plotType = plotType;
	}

	public long getPlotId() {
		return this.plotId;
	}

	public void setPlotId(long plotId) {
		this.plotId = plotId;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Sector getSector() {
		return sector;
	}

	public PlotType getPlotType() {
		return plotType;
	}

	public void setPlotType(PlotType plotType) {
		this.plotType = plotType;
	}
}
