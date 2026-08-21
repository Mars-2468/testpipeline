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

/**
 * Sector
 */
@Entity
@Table(name = "SECTOR", schema = "egovcommon")
public class Sector implements java.io.Serializable {

	@Id
	@Column(name = "SECTOR_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.SECTOR_SEQ", sequenceName = "egovcommon.SECTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.SECTOR_SEQ")
	private long sectorId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "NODE_ID", nullable = false)
	private NodeMaster nodeMaster = new NodeMaster();

	// This is not part of hbm. Using it internally to differentiate whether a
	// Sector is assigned or not to ward
	// while displaying the Sectors in assignSectors.jsp. For Ward
	@Transient
	private long assignedWardSectorId = 0;

	@Column(name = "NAME_RGL", nullable = true)
	private String name_rgl;

	/**
	 * @return the assignedWardSectorId
	 */
	public long getAssignedWardSectorId() {
		return assignedWardSectorId;
	}

	/**
	 * @param assignedWardSectorId
	 *            the assignedWardSectorId to set
	 */
	public void setAssignedWardSectorId(long assignedWardSectorId) {
		this.assignedWardSectorId = assignedWardSectorId;
	}

	public Sector() {
	}

	public Sector(String name) {
		this.name = name;
	}

	public Sector(String name, Integer status, NodeMaster nodeMaster) {
		this.name = name;
		this.status = status;
		this.nodeMaster = nodeMaster;
	}

	public long getSectorId() {
		return this.sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public NodeMaster getNodeMaster() {
		return this.nodeMaster;
	}

	public void setNodeMaster(NodeMaster nodeMaster) {
		this.nodeMaster = nodeMaster;
	}

	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

}
