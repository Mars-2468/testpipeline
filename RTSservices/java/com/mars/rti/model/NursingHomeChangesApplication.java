package com.mars.rti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "nursing_home_changes_application", schema = "egovrti")
public class NursingHomeChangesApplication {

	@Id
	@Column(name = "nhca_id", nullable = false, unique = true)
	@SequenceGenerator(name = "nhca_id_ser_seq", sequenceName = "nhca_id_ser_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nhca_id_ser_seq")
	private long nhcaId;

	
	@Column(name="my_dropdown")
	private String myDropdown;
	
	
	@Column(name="my_dropdown1")
	private String myDropdown1;
	
	
	@Column(name = "nursing_home_reg_number")
	private String nursingHomeRegNumber;
	
	@Column(name="zone_no")
	private String zoneNo;
	
	@Transient
	private String filesPath;
	
	
	@Column(name = "sanctioned_bed_maternity")
	private String sanctionedBedMaternity;
	
	
	@Column(name = "sanctioned_bed_other")
	private String sanctionedBedOther;
	
	
	
	@Column(name = "total_fees")
	private double totalFees;
	
	
	@Column(name = "change_bed_maternity")
	private String changeBedMaternity;

	
	
	@Column(name = "change_bed_other")
	private String changeBedOther;
	

	//OneToMapping 
	
	@OneToMany(mappedBy = "nursingHomeChangesApplication")
   private List<NursingOwnerDetailsChange> nd = new ArrayList<NursingOwnerDetailsChange>();
	
	
	@OneToMany(mappedBy = "nursingHomeChangesApplication")
   private List<NursingOwnerDetails> sd = new ArrayList<NursingOwnerDetails>();

	
	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;

	@Column(name = "hq_doc")
	private String hqdoc;
	
	@Column(name = "zmo_doc")
	private String zmodoc;
	
	
	@Column(name="mho_remark")
	private String mhoRemark;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="hq_remark")
	private String hQRemark;
	
	
	@Column(name="place")
	private String place;

	public long getNhcaId() {
		return nhcaId;
	}


	public void setNhcaId(long nhcaId) {
		this.nhcaId = nhcaId;
	}


	public String getMyDropdown() {
		return myDropdown;
	}


	public void setMyDropdown(String myDropdown) {
		this.myDropdown = myDropdown;
	}


	public String getMyDropdown1() {
		return myDropdown1;
	}


	public void setMyDropdown1(String myDropdown1) {
		this.myDropdown1 = myDropdown1;
	}


	public String getNursingHomeRegNumber() {
		return nursingHomeRegNumber;
	}


	public void setNursingHomeRegNumber(String nursingHomeRegNumber) {
		this.nursingHomeRegNumber = nursingHomeRegNumber;
	}


	public String getZoneNo() {
		return zoneNo;
	}


	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}


	public String getFilesPath() {
		return filesPath;
	}


	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}


	public String getSanctionedBedMaternity() {
		return sanctionedBedMaternity;
	}


	public void setSanctionedBedMaternity(String sanctionedBedMaternity) {
		this.sanctionedBedMaternity = sanctionedBedMaternity;
	}


	public double getTotalFees() {
		return totalFees;
	}


	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}


	public String getChangeBedMaternity() {
		return changeBedMaternity;
	}


	public void setChangeBedMaternity(String changeBedMaternity) {
		this.changeBedMaternity = changeBedMaternity;
	}


	public String getChangeBedOther() {
		return changeBedOther;
	}


	public void setChangeBedOther(String changeBedOther) {
		this.changeBedOther = changeBedOther;
	}


	public List<NursingOwnerDetailsChange> getNd() {
		return nd;
	}


	public void setNd(List<NursingOwnerDetailsChange> nd) {
		this.nd = nd;
	}


	public List<NursingOwnerDetails> getSd() {
		return sd;
	}


	public void setSd(List<NursingOwnerDetails> sd) {
		this.sd = sd;
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


	public String getHqdoc() {
		return hqdoc;
	}


	public void setHqdoc(String hqdoc) {
		this.hqdoc = hqdoc;
	}


	public String getZmodoc() {
		return zmodoc;
	}


	public void setZmodoc(String zmodoc) {
		this.zmodoc = zmodoc;
	}


	public String getSanctionedBedOther() {
		return sanctionedBedOther;
	}


	public void setSanctionedBedOther(String sanctionedBedOther) {
		this.sanctionedBedOther = sanctionedBedOther;
	}


	public String getMhoRemark() {
		return mhoRemark;
	}


	public void setMhoRemark(String mhoRemark) {
		this.mhoRemark = mhoRemark;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String gethQRemark() {
		return hQRemark;
	}


	public void sethQRemark(String hQRemark) {
		this.hQRemark = hQRemark;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
	
	
	
		
}
