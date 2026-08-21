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
@Table(name="property_transfer_registration",schema = "egovrti")
public class PropertyTaxTransferRegistration {

	
	@Id
	@Column(name="property_transfer_registration_id",nullable = false, unique = true)
	@SequenceGenerator(name="property_transfer_registration_seq",sequenceName = "property_transfer_registration_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "property_transfer_registration_seq")
	private long propertyTransferRegistrationId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_id")
	private String emailid;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="property_holder_name")
	private String  propertyHolderName;
	
	@Column(name="zone_no")
	private String zoneNo;
	
	@Column(name="ward_no")
	private String wardNo;
	
	@Column(name = "upin_no")
	private String upinNo;
	
	@Column(name = "index_no")
	private String indexNo;
	
	@Column(name="address")
	private String address;
	
	//new Fields
	
	@Column(name="ward_number")
	private String blockNo;
	
	@Column(name="ward_name")
	private String blockName;
	
	@Column(name="owner_name")
	private String ownerName;
	
	@Column(name="areas_pending")
    private double areasPending;
    
    @Column(name="areas_pending_status")
    private String areasPendingStatus;
    
	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name="total_demand")
	private String total_demand;
	
	@Column(name="tax_mobile_no")
	private String taxMobileNo;
	
	@Column(name="tax_pincode")
	private String taxPincode;

	@Column(name="fees")
	private double fees;
	
	@Column(name="payment_receipt")
	private String paymentReceipt;
	
	@Transient
	private String blockId;
	
	@Column(name="my_dropdown")
	private String myDropdown;

	@Column(name="dues_amt")
	private double duesAmt;
	
	@Column(name="mutation_id")
	private String mutationId;
	
	@Column(name="assessment_details_id")
	private String assessmentDetailsId;
	
	@Column(name="api_response_unique_id")
	private String api_response_unique_id;
	
	public long getPropertyTransferRegistrationId() {
		return propertyTransferRegistrationId;
	}

	public void setPropertyTransferRegistrationId(long propertyTransferRegistrationId) {
		this.propertyTransferRegistrationId = propertyTransferRegistrationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPropertyHolderName() {
		return propertyHolderName;
	}

	public void setPropertyHolderName(String propertyHolderName) {
		this.propertyHolderName = propertyHolderName;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getUpinNo() {
		return upinNo;
	}

	public void setUpinNo(String upinNo) {
		this.upinNo = upinNo;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getAreasPending() {
		return areasPending;
	}

	public void setAreasPending(double areasPending) {
		this.areasPending = areasPending;
	}

	public String getAreasPendingStatus() {
		return areasPendingStatus;
	}

	public void setAreasPendingStatus(String areasPendingStatus) {
		this.areasPendingStatus = areasPendingStatus;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
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

	public String getTotal_demand() {
		return total_demand;
	}

	public void setTotal_demand(String total_demand) {
		this.total_demand = total_demand;
	}

	public String getTaxMobileNo() {
		return taxMobileNo;
	}

	public void setTaxMobileNo(String taxMobileNo) {
		this.taxMobileNo = taxMobileNo;
	}

	public String getTaxPincode() {
		return taxPincode;
	}

	public void setTaxPincode(String taxPincode) {
		this.taxPincode = taxPincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getMyDropdown() {
		return myDropdown;
	}

	public void setMyDropdown(String myDropdown) {
		this.myDropdown = myDropdown;
	}

	public double getDuesAmt() {
		return duesAmt;
	}

	public void setDuesAmt(double duesAmt) {
		this.duesAmt = duesAmt;
	}

	public String getMutationId() {
		return mutationId;
	}

	public void setMutationId(String mutationId) {
		this.mutationId = mutationId;
	}

	public String getAssessmentDetailsId() {
		return assessmentDetailsId;
	}

	public void setAssessmentDetailsId(String assessmentDetailsId) {
		this.assessmentDetailsId = assessmentDetailsId;
	}

	public String getApi_response_unique_id() {
		return api_response_unique_id;
	}

	public void setApi_response_unique_id(String api_response_unique_id) {
		this.api_response_unique_id = api_response_unique_id;
	}
	
	
	
}
