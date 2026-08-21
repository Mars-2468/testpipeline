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
 * Ward
 */
@Entity
@Table(name = "WARD", schema = "egovcommon")
public class Ward implements java.io.Serializable {

	@Id
	@Column(name = "WARD_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.WARD_SEQ", sequenceName = "egovcommon.WARD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.WARD_SEQ")
	private long wardId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "ADDRESSLINE1", nullable = true)
	private String addressLine1;

	@Column(name = "ADDRESSLINE2", nullable = true)
	private String addressLine2;

	@Column(name = "ADDRESSLINE3", nullable = true)
	private String addressLine3;

	@Column(name = "STATUS", nullable = true)
	private Integer status;

	@Column(name = "FAS_BRANCH_CODE", nullable = true)
	private Integer fasBranchCode;

	@ManyToOne
	@JoinColumn(name = "CITY_ID", nullable = false)
	private City city = new City();

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "ward")
    private Set<WardSector> wardSectorSet = new HashSet<WardSector>();

	@Column(name = "NAME_RGL", nullable = true)
	private String name_rgl;

	@Column(name = "CODE_RGL", nullable = true)
	private String code_rgl;

	@Transient
	private long areaWardId;

	/**
	 * @return the wardSectorSet
	 */
	public Set getWardSectorSet() {
		return wardSectorSet;
	}

	/**
	 * @param wardSectorSet
	 *            the wardSectorSet to set
	 */
	public void setWardSectorSet(Set wardSectorSet) {
		this.wardSectorSet = wardSectorSet;
	}

	public Ward() {
	}

	public Ward(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public Ward(String name, String code, String addressLine1,
			String addressLine2, String addressLine3, Integer status, City city) {
		this.name = name;
		this.code = code;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.status = status;
		this.city = city;
	}

	public long getWardId() {
		return this.wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public Integer getStatus() {
		return this.status;
	}

	public Integer getFasBranchCode() {
		return fasBranchCode;
	}

	public void setFasBranchCode(Integer fasBranchCode) {
		this.fasBranchCode = fasBranchCode;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
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

	/**
	 * @return the areaWardId
	 */
	public long getAreaWardId() {
		return areaWardId;
	}

	/**
	 * @param areaWardId
	 *            the areaWardId to set
	 */
	public void setAreaWardId(long areaWardId) {
		this.areaWardId = areaWardId;
	}

}
