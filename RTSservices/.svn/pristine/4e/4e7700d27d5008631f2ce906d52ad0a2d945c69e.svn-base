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

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;


/**
 * Wards
 */
@Entity
@Table(name = "ward_master", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class WardMaster implements java.io.Serializable {

	
	@Id
	@Column(name = "WARD_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.WARD_MASTER_SEQ", sequenceName = "egovcommon.WARD_MASTER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.WARD_MASTER_SEQ")
	@RemoteProperty
    private long wardId;

    @Column(name = "wardnumber_rgl", nullable = true)
    private String wardNumber_rgl;
    
    @Column(name = "name", nullable = false)
	@RemoteProperty
    private String name; 
    
	@Column(name = "name_rgl", nullable = true)
    private String name_rgl;
    
	@Column(name = "code", nullable = false)
	@RemoteProperty    
	private String code;
    
	@Column(name = "code_rgl", nullable = true)
    private String code_rgl;

	@Column(name = "addressline1", nullable = true)
    private String addressLine1;

	@Column(name = "addressline2", nullable = true)
    private String addressLine2;

	@Column(name = "addressline3", nullable = true)
    private String addressLine3;

	@Column(name = "status", nullable = true)
	@RemoteProperty
    private Integer status=1;
    
/*    private int tenancyid;
*/    
	/*@Column(name = "STATUS", nullable = true)
	private Zone zone = null;*/
   
	@ManyToOne
	@JoinColumn(name = "zone_id", nullable = false)
	private ZoneMaster zoneMaster = new ZoneMaster();

	@Column(name="fas_branch_code", nullable=true ,unique=true)	
    private Integer fasBranchCode; 
	
	
	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public String getWardNumber_rgl() {
		return wardNumber_rgl;
	}

	public void setWardNumber_rgl(String wardNumber_rgl) {
		this.wardNumber_rgl = wardNumber_rgl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_rgl() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode_rgl() {
		return code_rgl;
	}

	public void setCode_rgl(String code_rgl) {
		this.code_rgl = code_rgl;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ZoneMaster getZoneMaster() {
		return zoneMaster;
	}

	public void setZoneMaster(ZoneMaster zoneMaster) {
		this.zoneMaster = zoneMaster;
	}

	public Integer getFasBranchCode() {
		return fasBranchCode;
	}

	public void setFasBranchCode(Integer fasBranchCode) {
		this.fasBranchCode = fasBranchCode;
	}

}
