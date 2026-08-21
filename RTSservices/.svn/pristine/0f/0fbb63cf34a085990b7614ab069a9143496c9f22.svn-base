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
 * NodeMaster
 */
@Entity
@Table(name = "WARD_SECTOR", schema = "egovcommon")
public class WardSector implements java.io.Serializable {

	@Id
	@Column(name = "WARD_SECTOR_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.WARD_SECTOR_SEQ", sequenceName = "egovcommon.WARD_SECTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.WARD_SECTOR_SEQ")
	private long wadrSectorId;

	@ManyToOne
	@JoinColumn(name = "WARD_ID", nullable = false)
	private Ward ward = new Ward();

	@ManyToOne
	@JoinColumn(name = "SECTOR_ID", nullable = false)
	private Sector sector = new Sector();

	public WardSector() {
	}

	/**
	 * @return the wadrSectorId
	 */
	public long getWadrSectorId() {
		return wadrSectorId;
	}

	/**
	 * @param wadrSectorId
	 *            the wadrSectorId to set
	 */
	public void setWadrSectorId(long wadrSectorId) {
		this.wadrSectorId = wadrSectorId;
	}

	/**
	 * @return the ward
	 */
	public Ward getWard() {
		return ward;
	}

	/**
	 * @param ward
	 *            the ward to set
	 */
	public void setWard(Ward ward) {
		this.ward = ward;
	}

	/**
	 * @return the sector
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
