package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tree_trimming", schema = "egovrti")
public class TreeTrimming {
   
	@Id
	@Column(name = "tree_trimming_id", nullable = false, unique = true)
	@SequenceGenerator(name = "treetrimming_seq", sequenceName = "treetrimming_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treetrimming_seq")
	private long treeTrimmingId;

	@Column(name = "title", nullable = true)
	private String title;
	

	@Column(name = "first_name", nullable = true )
	private String firstName;

	@Column(name = "middle_name", nullable = true )
	private String middlename;
	
	@Column(name = "last_name" ,nullable = true)
	private String lastname;
	
	@Column(name = "full_name",nullable = true)
	private String fullName;
	

	@Column(name ="aadhar_no",nullable = true)
	private String aadharNo;
	
   @Column(name ="mobile_No" ,nullable =true)
	public String mobileNo;
	

	@Column(name ="email",nullable = true)
	private String email;
	

	@Column(name ="plotno",nullable = true)
	private String applicantPlotNo;
	

	@Column(name ="building_name",nullable = true)
	private String applicantBuildingName;
	
	@Column(name = "area_name",nullable = true)
	private String areaName;
	

	@Column(name ="street_name",nullable = true)
	private String applicantStreetName;
	
	@Column(name ="name_of_city",nullable = true)
	private String nameOfCity;
	
	@Column(name = "landmark" ,nullable = true)
	private String landmark;
	
	@Column(name = "pincode" ,nullable = true)
	private String pincode;
	

	@Column(name ="wardno",nullable = true)
	private String wardNo;
	
	@Column(name ="zone_no",nullable = true)
	private String zoneNo;
	
	
//	@Column(name ="totalfeesuptocha",nullable = true)
//	private String totalFeesUptoCha;
//	
//	@Column(name ="noOftreeuptopercentage",nullable = true)
//	private String noOfTreeUptoPercentage;
//	
	@Column(name ="totalfeeswithgst",nullable = true)
	private String totalFeesWithGST;
	

	public String getTotalFeesWithGST() {
		return totalFeesWithGST;
	}




	public void setTotalFeesWithGST(String totalFeesWithGST) {
		this.totalFeesWithGST = totalFeesWithGST;
	}




	@Column(name ="TreeType",nullable = true)
	private String treeType;
	

	@Column(name ="resone_tree_trimming",nullable = true)
	private String resonetreetrimming;
	
   
	@Column(name ="number_of_tree_trimming",nullable = true)
	private String numberoftreetrimming;
    
  
	@Column(name ="tax_paid_receipt",nullable = true)
	private String taxpaidrecipt;
	
	@Column(name ="aadhaar_card",nullable = true)
	private String aadhaarcard;
	
	@Column(name ="sanctioned_plan_construction",nullable = true)
	private String sanctionedplanconstruction;
	
	@Column(name ="Photograph_of_tree",nullable = true)
	private String photographoftree;
    
	@Column(name ="building_Permission",nullable = true)
	private String buildingPermission;
	
	@Transient
	private String filesPath;
	

	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;
	
	@Column(name ="address",nullable = true)
	private String address;
	

	@Column(name ="applicantcity",nullable = true)
	private String applicantcity;
	
	public String getApplicantPlotNo() {
		return applicantPlotNo;
	}




	public void setApplicantPlotNo(String applicantPlotNo) {
		this.applicantPlotNo = applicantPlotNo;
	}




	public String getApplicantBuildingName() {
		return applicantBuildingName;
	}




	public void setApplicantBuildingName(String applicantBuildingName) {
		this.applicantBuildingName = applicantBuildingName;
	}




	public String getApplicantStreetName() {
		return applicantStreetName;
	}




	public void setApplicantStreetName(String applicantStreetName) {
		this.applicantStreetName = applicantStreetName;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getWardNo() {
		return wardNo;
	}




	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}




	public String getApplicantcity() {
		return applicantcity;
	}




	public void setApplicantcity(String applicantcity) {
		this.applicantcity = applicantcity;
	}
	public String getMobileNo() {
		return mobileNo;
	}

	



	public long getTreeTrimmingId() {
		return treeTrimmingId;
	}




	public void setTreeTrimmingId(long treeTrimmingId) {
		this.treeTrimmingId = treeTrimmingId;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxpaidrecipt() {
		return taxpaidrecipt;
	}

	public void setTaxpaidrecipt(String taxpaidrecipt) {
		this.taxpaidrecipt = taxpaidrecipt;
	}

	public String getAadhaarcard() {
		return aadhaarcard;
	}

	public void setAadhaarcard(String aadhaarcard) {
		this.aadhaarcard = aadhaarcard;
	}

	public String getSanctionedplanconstruction() {
		return sanctionedplanconstruction;
	}

	public void setSanctionedplanconstruction(String sanctionedplanconstruction) {
		this.sanctionedplanconstruction = sanctionedplanconstruction;
	}

	

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getZoneNo() {
		return zoneNo;
	}




	public String getAadharNo() {
		return aadharNo;
	}




	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}


	public String getRtiapplrefno() {
		return rtiapplrefno;
	}




	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}




	public long getRti_ref_id() {
		return rti_ref_id;
	}




	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}




	




	public String getFilesPath() {
		return filesPath;
	}




	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}




	public String getTreeType() {
		return treeType;
	}




	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}




	public String getPhotographoftree() {
		return photographoftree;
	}




	public void setPhotographoftree(String photographoftree) {
		this.photographoftree = photographoftree;
	}




	public String getNameOfCity() {
		return nameOfCity;
	}




	public String getResonetreetrimming() {
		return resonetreetrimming;
	}




	public String getNumberoftreetrimming() {
		return numberoftreetrimming;
	}




	public String getBuildingPermission() {
		return buildingPermission;
	}




	public void setNameOfCity(String nameOfCity) {
		this.nameOfCity = nameOfCity;
	}




	public void setResonetreetrimming(String resonetreetrimming) {
		this.resonetreetrimming = resonetreetrimming;
	}




	public void setNumberoftreetrimming(String numberoftreetrimming) {
		this.numberoftreetrimming = numberoftreetrimming;
	}




	public void setBuildingPermission(String buildingPermission) {
		this.buildingPermission = buildingPermission;
	}
	@Column(name ="locationoftree" ,nullable =true)
	public String locationofTree;

public String getLocationofTree() {
	return locationofTree;
}




public void setLocationofTree(String locationofTree) {
	this.locationofTree = locationofTree;
}
  
@Column(name ="tree_address",nullable = true)
private String treeAddress;


public String getTreeAddress() {
	return treeAddress;
}




public void setTreeAddress(String treeAddress) {
	this.treeAddress = treeAddress;
}


@Column(name ="ownership",nullable = true)
private String ownership;

@Column(name ="totalnonheritage",nullable = true)
private String totalNonHeritage;

@Column(name ="totalheritage",nullable = true)
private String totalHeritage;

public String getOwnership() {
	return ownership;
}




public void setOwnership(String ownership) {
	this.ownership = ownership;
}




public String getTotalNonHeritage() {
	return totalNonHeritage;
}




public void setTotalNonHeritage(String totalNonHeritage) {
	this.totalNonHeritage = totalNonHeritage;
}




public String getTotalHeritage() {
	return totalHeritage;
}




public void setTotalHeritage(String totalHeritage) {
	this.totalHeritage = totalHeritage;
}

@Column(name ="demandletter",nullable = true)
private String demandletter;

@Column(name ="noc",nullable = true)
private String noc;

@Column(name ="rejectionletter",nullable = true)
private String rejectionletter;

@Column(name ="rejectionremark",nullable = true)
private String rejectionremark;

public String getDemandletter() {
	return demandletter;
}




public void setDemandletter(String demandletter) {
	this.demandletter = demandletter;
}




public String getNoc() {
	return noc;
}




public void setNoc(String noc) {
	this.noc = noc;
}




public String getRejectionletter() {
	return rejectionletter;
}




public void setRejectionletter(String rejectionletter) {
	this.rejectionletter = rejectionletter;
}




public String getRejectionremark() {
	return rejectionremark;
}




public void setRejectionremark(String rejectionremark) {
	this.rejectionremark = rejectionremark;
}

@Column(name ="plantation",nullable = true)
private String plantation;

@Column(name ="plantationletter",nullable = true)
private String plantationletter;

public String getPlantation() {
	return plantation;
}




public void setPlantation(String plantation) {
	this.plantation = plantation;
}




public String getPlantationletter() {
	return plantationletter;
}




public void setPlantationletter(String plantationletter) {
	this.plantationletter = plantationletter;
}


@Column(name = "citizennoc")
private String citizenNoc;

public String getCitizenNoc() {
	return citizenNoc;
}

public void setCitizenNoc(String citizenNoc) {
	this.citizenNoc = citizenNoc;
}


@Column(name = "actualnumberoftreetrimming")
private String actualNumberoftreetrimming;


public String getActualNumberoftreetrimming() {
	return actualNumberoftreetrimming;
}




public void setActualNumberoftreetrimming(String actualNumberoftreetrimming) {
	this.actualNumberoftreetrimming = actualNumberoftreetrimming;
}


@Column(name = "saveapproval")
private String saveApproval;

public String getSaveApproval() {
	return saveApproval;
}




public void setSaveApproval(String saveApproval) {
	this.saveApproval = saveApproval;
}


@Column(name = "treeremark")
private String treeRemark;

public String getTreeRemark() {
	return treeRemark;
}




public void setTreeRemark(String treeRemark) {
	this.treeRemark = treeRemark;
}






  



	
	
}

