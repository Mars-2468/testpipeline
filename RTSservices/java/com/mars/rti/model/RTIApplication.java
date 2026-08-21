package com.mars.rti.model;

import com.mars.common.model.Department;
import com.mars.common.model.ReceivedMode;
import com.mars.common.model.Section;
import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(
   name = "rti_application",
   schema = "egovrti"
)
public class RTIApplication implements Serializable {
   @Id
   @Column(
      name = "rti_application_id",
      nullable = false,
      unique = true
   )
   @SequenceGenerator(
      name = "rti_application_seq",
      sequenceName = "rti_application_seq",
      allocationSize = 1
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "rti_application_seq"
   )
   private long rtiApplicationId;
   @Column(
      name = "rti_application_number",
      nullable = true,
      unique = true
   )
   private String rtiApplnNumber;
   @ManyToOne
   @JoinColumn(
      name = "application_department_id",
      nullable = true
   )
   private Department applicationDepartment = null;
   @Column(
      name = "inward_number"
   )
   private String inWardNumber;
   @Column(
      name = "registration_date",
      nullable = false
   )
   private String registrationDate;
   @Column(
      name = "received_date"
   )
   private String receivedDate;
   @Column(
      name = "closed_date"
   )
   private String closedDate;
   @Column(
      name = "subject",
      nullable = false
   )
   private String subject;
   @Column(
      name = "department",
      nullable = true
   )
   private String department;
   @Column(
      name = "information_required"
   )
   private String informationRequired;
   @Column(
      name = "number_of_copies"
   )
   private int numberOfCopies;
   @Column(
      name = "amount_per_copy"
   )
   private double amountPerCopy;
   @Column(
      name = "application_cost"
   )
   private double applicationCost;
   @Column(
      name = "workflow_status"
   )
   private Integer workFlowStatus;
   @Column(
      name = "final_status"
   )
   private String finalStatus;
   @Column(
      name = "final_status_when_parked"
   )
   private String finalStatusWhenParked;
   @Column(
      name = "is_application_parked"
   )
   private Integer isApplicationParked;
   @Column(
      name = "created_date"
   )
   private String createdDate;
   @Column(
      name = "template_name"
   )
   private String templateName;
   @ManyToOne
   @JoinColumn(
      name = "created_user_id"
   )
   private User createdUserId = null;
   @Column(
      name = "zone"
   )
   private String zone;
   @ManyToOne
   @JoinColumn(
      name = "assignee_user_id"
   )
   private User assigneeUserId = null;
   @ManyToOne
   @JoinColumn(
      name = "assigned_department_id"
   )
   private Department assignedDepartment = null;
   @ManyToOne
   @JoinColumn(
      name = "assigned_section_id"
   )
   private Section assignedSection = null;
   @ManyToOne
   @JoinColumn(
      name = "received_mode_id"
   )
   private ReceivedMode receivedMode = null;
   @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rtiApplication"
   )
   private List<RTIApplicationDetails> rtiApplicationDetails;
   @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rtiApplication"
   )
   private List<RTIApplicationNoting> rtiApplicationNoting = new ArrayList();
   @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rtiApplication"
   )
   private List<Draft> draftList = new ArrayList();
   @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rtiApplication"
   )
   private List<RTIApplicationPark> rtiApplicationPark = new ArrayList();
   @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rtiApplication"
   )
   private List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptance;
   @ManyToOne
   @JoinColumn(
      name = "fee_master_id"
   )
   private FeeMaster feeMaster = null;
   @Column(
      name = "is_feepaid"
   )
   private Integer isFeePaid;
   @Column(
      name = "applicant_name"
   )
   private String applicantName;
   @Column(
      name = "gender"
   )
   private int gender;
   @Column(
      name = "state",
      nullable = true
   )
   private String state = "Maharashtra";
   @Column(
      name = "phone_number",
      nullable = true
   )
   private String phoneNumber;
   @Column(
      name = "mobile_number",
      nullable = true
   )
   private String mobileNumber;
   @Column(
      name = "email",
      nullable = true
   )
   private String email;
   @Column(
      name = "mobile_app_user_number",
      nullable = true
   )
   private String mobileAppUserNumber;
   @Column(
      name = "pincode",
      nullable = true
   )
   private int pincode;
   @Column(
      name = "bpl"
   )
   private Integer bpl;
   @Column(
      name = "bpl_card_number"
   )
   private String bplCardNumber;
   @Column(
      name = "address_line1"
   )
   private String addressLine1;
   @Column(
      name = "address_line2"
   )
   private String addressLine2;
   @Column(
      name = "district"
   )
   private String district;
   @Column(
      name = "postal_charges"
   )
   private double postalCharges;
   @ManyToOne
   @JoinColumn(
      name = "tenancyid",
      nullable = true
   )
   private Tenancy tenancy = null;
   @Column(
      name = "rti_application_ref_number",
      nullable = true
   )
   private String rtiApplicationRefNumber;
   @Column(
      name = "rti_application_ref_id",
      nullable = true
   )
   private Long rtiApplicationRefId;
   @Column(
      name = "is_rti_appeal_application"
   )
   private Integer isRTIAppealApplication;
   @Column(
      name = "has_assigned_user"
   )
   private Integer hasAssignedUser;
   @Column(
      name = "rti_service_id"
   )
   private Integer rtiserviceid;
   @Column(
      name = "pdf_files_saved_path"
   )
   private String pdfFilesSavedPath;
   @Column(
      name = "pdf_upload_from_portal"
   )
   private String pdfUploadFromPortal;
   @Column(
      name = "police_noc"
   )
   private String policeNoc;
   @Column(
      name = "fire_noc"
   )
   private String fireNoc;
   @Column(
      name = "traffic_noc"
   )
   private String trafficNoc;
   @Column(
      name = "zone_map"
   )
   private String zoneMap;
   @Column(
      name = "property_payment_receipt"
   )
   private String propertyPaymentReceipt;
   @Column(
      name = "rejectionletter"
   )
   private String rejectionletter;
   @Column(
      name = "property_tax_certificate"
   )
   private String propertyTaxCertificate;
   @Transient
   private long rowNumber;
   @Column(
      name = "demandletter"
   )
   private String demandletter;
   @Column(
      name = "noc"
   )
   private String noc;
   @Column(
      name = "first_payment_fees"
   )
   private String firstPaymentFees;
   @Column(
      name = "tax_other_citizen_document_upload"
   )
   private String taxOtherCitizenDocumentUpload;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "user_mobile_no",
      nullable = true
   )
   private UserRegistrationDetails userRegistrationDetails;
   @Column(
      name = "citizennoc"
   )
   private String citizenNoc;
   @Column(
      name = "plantationletter",
      nullable = true
   )
   private String plantationletter;
   @Column(
      name = "workflow_comments"
   )
   private String workflowComments;

   public String getRejectionletter() {
      return this.rejectionletter;
   }

   public void setRejectionletter(String rejectionletter) {
      this.rejectionletter = rejectionletter;
   }

   public String getDemandletter() {
      return this.demandletter;
   }

   public void setDemandletter(String demandletter) {
      this.demandletter = demandletter;
   }

   public String getNoc() {
      return this.noc;
   }

   public void setNoc(String noc) {
      this.noc = noc;
   }

   public long getRtiApplicationId() {
      return this.rtiApplicationId;
   }

   public void setRtiApplicationId(long rtiApplicationId) {
      this.rtiApplicationId = rtiApplicationId;
   }

   public String getRtiApplnNumber() {
      return this.rtiApplnNumber;
   }

   public void setRtiApplnNumber(String rtiApplnNumber) {
      this.rtiApplnNumber = rtiApplnNumber;
   }

   public Department getApplicationDepartment() {
      return this.applicationDepartment;
   }

   public void setApplicationDepartment(Department applicationDepartment) {
      this.applicationDepartment = applicationDepartment;
   }

   public String getInWardNumber() {
      return this.inWardNumber;
   }

   public void setInWardNumber(String inWardNumber) {
      this.inWardNumber = inWardNumber;
   }

   public String getRegistrationDate() {
      return this.registrationDate;
   }

   public void setRegistrationDate(String registrationDate) {
      this.registrationDate = registrationDate;
   }

   public String getReceivedDate() {
      return this.receivedDate;
   }

   public void setReceivedDate(String receivedDate) {
      this.receivedDate = receivedDate;
   }

   public String getClosedDate() {
      return this.closedDate;
   }

   public void setClosedDate(String closedDate) {
      this.closedDate = closedDate;
   }

   public String getSubject() {
      return this.subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getDepartment() {
      return this.department;
   }

   public void setDepartment(String department) {
      this.department = department;
   }

   public String getInformationRequired() {
      return this.informationRequired;
   }

   public void setInformationRequired(String informationRequired) {
      this.informationRequired = informationRequired;
   }

   public int getNumberOfCopies() {
      return this.numberOfCopies;
   }

   public void setNumberOfCopies(int numberOfCopies) {
      this.numberOfCopies = numberOfCopies;
   }

   public double getAmountPerCopy() {
      return this.amountPerCopy;
   }

   public void setAmountPerCopy(double amountPerCopy) {
      this.amountPerCopy = amountPerCopy;
   }

   public double getApplicationCost() {
      return this.applicationCost;
   }

   public void setApplicationCost(double applicationCost) {
      this.applicationCost = applicationCost;
   }

   public Integer getWorkFlowStatus() {
      return this.workFlowStatus;
   }

   public void setWorkFlowStatus(Integer workFlowStatus) {
      this.workFlowStatus = workFlowStatus;
   }

   public String getFinalStatus() {
      return this.finalStatus;
   }

   public void setFinalStatus(String finalStatus) {
      this.finalStatus = finalStatus;
   }

   public String getFinalStatusWhenParked() {
      return this.finalStatusWhenParked;
   }

   public void setFinalStatusWhenParked(String finalStatusWhenParked) {
      this.finalStatusWhenParked = finalStatusWhenParked;
   }

   public Integer getIsApplicationParked() {
      return this.isApplicationParked;
   }

   public void setIsApplicationParked(Integer isApplicationParked) {
      this.isApplicationParked = isApplicationParked;
   }

   public String getCreatedDate() {
      return this.createdDate;
   }

   public void setCreatedDate(String createdDate) {
      this.createdDate = createdDate;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   public void setTemplateName(String templateName) {
      this.templateName = templateName;
   }

   public User getCreatedUserId() {
      return this.createdUserId;
   }

   public void setCreatedUserId(User createdUserId) {
      this.createdUserId = createdUserId;
   }

   public String getZone() {
      return this.zone;
   }

   public void setZone(String zone) {
      this.zone = zone;
   }

   public User getAssigneeUserId() {
      return this.assigneeUserId;
   }

   public void setAssigneeUserId(User assigneeUserId) {
      this.assigneeUserId = assigneeUserId;
   }

   public Department getAssignedDepartment() {
      return this.assignedDepartment;
   }

   public void setAssignedDepartment(Department assignedDepartment) {
      this.assignedDepartment = assignedDepartment;
   }

   public Section getAssignedSection() {
      return this.assignedSection;
   }

   public void setAssignedSection(Section assignedSection) {
      this.assignedSection = assignedSection;
   }

   public ReceivedMode getReceivedMode() {
      return this.receivedMode;
   }

   public void setReceivedMode(ReceivedMode receivedMode) {
      this.receivedMode = receivedMode;
   }

   public List<RTIApplicationDetails> getRtiApplicationDetails() {
      return this.rtiApplicationDetails;
   }

   public void setRtiApplicationDetails(List<RTIApplicationDetails> rtiApplicationDetails) {
      this.rtiApplicationDetails = rtiApplicationDetails;
   }

   public List<RTIApplicationNoting> getRtiApplicationNoting() {
      return this.rtiApplicationNoting;
   }

   public void setRtiApplicationNoting(List<RTIApplicationNoting> rtiApplicationNoting) {
      this.rtiApplicationNoting = rtiApplicationNoting;
   }

   public List<Draft> getDraftList() {
      return this.draftList;
   }

   public void setDraftList(List<Draft> draftList) {
      this.draftList = draftList;
   }

   public List<RTIApplicationPark> getRtiApplicationPark() {
      return this.rtiApplicationPark;
   }

   public void setRtiApplicationPark(List<RTIApplicationPark> rtiApplicationPark) {
      this.rtiApplicationPark = rtiApplicationPark;
   }

   public List<RTIApplicationReAssignAcceptance> getRtiApplicationReAssignAcceptance() {
      return this.rtiApplicationReAssignAcceptance;
   }

   public void setRtiApplicationReAssignAcceptance(List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptance) {
      this.rtiApplicationReAssignAcceptance = rtiApplicationReAssignAcceptance;
   }

   public FeeMaster getFeeMaster() {
      return this.feeMaster;
   }

   public void setFeeMaster(FeeMaster feeMaster) {
      this.feeMaster = feeMaster;
   }

   public Integer getIsFeePaid() {
      return this.isFeePaid;
   }

   public void setIsFeePaid(Integer isFeePaid) {
      this.isFeePaid = isFeePaid;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public void setApplicantName(String applicantName) {
      this.applicantName = applicantName;
   }

   public int getGender() {
      return this.gender;
   }

   public void setGender(int gender) {
      this.gender = gender;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getMobileNumber() {
      return this.mobileNumber;
   }

   public void setMobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getMobileAppUserNumber() {
      return this.mobileAppUserNumber;
   }

   public void setMobileAppUserNumber(String mobileAppUserNumber) {
      this.mobileAppUserNumber = mobileAppUserNumber;
   }

   public int getPincode() {
      return this.pincode;
   }

   public void setPincode(int pincode) {
      this.pincode = pincode;
   }

   public Integer getBpl() {
      return this.bpl;
   }

   public void setBpl(Integer bpl) {
      this.bpl = bpl;
   }

   public String getBplCardNumber() {
      return this.bplCardNumber;
   }

   public void setBplCardNumber(String bplCardNumber) {
      this.bplCardNumber = bplCardNumber;
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

   public String getDistrict() {
      return this.district;
   }

   public void setDistrict(String district) {
      this.district = district;
   }

   public double getPostalCharges() {
      return this.postalCharges;
   }

   public void setPostalCharges(double postalCharges) {
      this.postalCharges = postalCharges;
   }

   public Tenancy getTenancy() {
      return this.tenancy;
   }

   public void setTenancy(Tenancy tenancy) {
      this.tenancy = tenancy;
   }

   public String getRtiApplicationRefNumber() {
      return this.rtiApplicationRefNumber;
   }

   public void setRtiApplicationRefNumber(String rtiApplicationRefNumber) {
      this.rtiApplicationRefNumber = rtiApplicationRefNumber;
   }

   public Long getRtiApplicationRefId() {
      return this.rtiApplicationRefId;
   }

   public void setRtiApplicationRefId(Long rtiApplicationRefId) {
      this.rtiApplicationRefId = rtiApplicationRefId;
   }

   public Integer getIsRTIAppealApplication() {
      return this.isRTIAppealApplication;
   }

   public void setIsRTIAppealApplication(Integer isRTIAppealApplication) {
      this.isRTIAppealApplication = isRTIAppealApplication;
   }

   public Integer getHasAssignedUser() {
      return this.hasAssignedUser;
   }

   public void setHasAssignedUser(Integer hasAssignedUser) {
      this.hasAssignedUser = hasAssignedUser;
   }

   public Integer getRtiserviceid() {
      return this.rtiserviceid;
   }

   public void setRtiserviceid(Integer rtiserviceid) {
      this.rtiserviceid = rtiserviceid;
   }

   public String getPdfFilesSavedPath() {
      return this.pdfFilesSavedPath;
   }

   public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
      this.pdfFilesSavedPath = pdfFilesSavedPath;
   }

   public String getPdfUploadFromPortal() {
      return this.pdfUploadFromPortal;
   }

   public void setPdfUploadFromPortal(String pdfUploadFromPortal) {
      this.pdfUploadFromPortal = pdfUploadFromPortal;
   }

   public String getPoliceNoc() {
      return this.policeNoc;
   }

   public void setPoliceNoc(String policeNoc) {
      this.policeNoc = policeNoc;
   }

   public String getFireNoc() {
      return this.fireNoc;
   }

   public void setFireNoc(String fireNoc) {
      this.fireNoc = fireNoc;
   }

   public String getTrafficNoc() {
      return this.trafficNoc;
   }

   public void setTrafficNoc(String trafficNoc) {
      this.trafficNoc = trafficNoc;
   }

   public UserRegistrationDetails getUserRegistrationDetails() {
      return this.userRegistrationDetails;
   }

   public void setUserRegistrationDetails(UserRegistrationDetails userRegistrationDetails) {
      this.userRegistrationDetails = userRegistrationDetails;
   }

   public String getZoneMap() {
      return this.zoneMap;
   }

   public void setZoneMap(String zoneMap) {
      this.zoneMap = zoneMap;
   }

   public String getPropertyPaymentReceipt() {
      return this.propertyPaymentReceipt;
   }

   public void setPropertyPaymentReceipt(String propertyPaymentReceipt) {
      this.propertyPaymentReceipt = propertyPaymentReceipt;
   }

   public String getPropertyTaxCertificate() {
      return this.propertyTaxCertificate;
   }

   public void setPropertyTaxCertificate(String propertyTaxCertificate) {
      this.propertyTaxCertificate = propertyTaxCertificate;
   }

   public String getFirstPaymentFees() {
      return this.firstPaymentFees;
   }

   public void setFirstPaymentFees(String firstPaymentFees) {
      this.firstPaymentFees = firstPaymentFees;
   }

   public String getCitizenNoc() {
      return this.citizenNoc;
   }

   public void setCitizenNoc(String citizenNoc) {
      this.citizenNoc = citizenNoc;
   }

   public String getPlantationletter() {
      return this.plantationletter;
   }

   public void setPlantationletter(String plantationletter) {
      this.plantationletter = plantationletter;
   }

   public String getTaxOtherCitizenDocumentUpload() {
      return this.taxOtherCitizenDocumentUpload;
   }

   public void setTaxOtherCitizenDocumentUpload(String taxOtherCitizenDocumentUpload) {
      this.taxOtherCitizenDocumentUpload = taxOtherCitizenDocumentUpload;
   }

   public long getRowNumber() {
      return this.rowNumber;
   }

   public void setRowNumber(long rowNumber) {
      this.rowNumber = rowNumber;
   }

   public String getWorkflowComments() {
      return this.workflowComments;
   }

   public void setWorkflowComments(String workflowComments) {
      this.workflowComments = workflowComments;
   }
@Column(name = "aaplesarkar_user_mobile_no")
private String aapleSarkarUserMobileNo;

@Column(name = "aaple_user_track_id")
private String aaple_user_track_id;
@Column(name = "aaple_user_id")
private String aaple_user_id;
@Column(name = "aaple_service_id")
private String aaple_service_id;
@Column(name = "aaple_application_id")
private String aaple_application_id;
@Column(name = "service_id")
private Integer service_id;
@Column(name = "application_status")
private Integer application_status;
@Column(name = "isaplesarkarapp")
private Integer isApleSarkarApp;

public String getAapleSarkarUserMobileNo() {
	return aapleSarkarUserMobileNo;
}

public void setAapleSarkarUserMobileNo(String aapleSarkarUserMobileNo) {
	this.aapleSarkarUserMobileNo = aapleSarkarUserMobileNo;
}

public String getAaple_user_track_id() {
	return aaple_user_track_id;
}

public void setAaple_user_track_id(String aaple_user_track_id) {
	this.aaple_user_track_id = aaple_user_track_id;
}

public String getAaple_user_id() {
	return aaple_user_id;
}

public void setAaple_user_id(String aaple_user_id) {
	this.aaple_user_id = aaple_user_id;
}

public String getAaple_service_id() {
	return aaple_service_id;
}

public void setAaple_service_id(String aaple_service_id) {
	this.aaple_service_id = aaple_service_id;
}

public String getAaple_application_id() {
	return aaple_application_id;
}

public void setAaple_application_id(String aaple_application_id) {
	this.aaple_application_id = aaple_application_id;
}

public Integer getService_id() {
	return service_id;
}

public void setService_id(Integer service_id) {
	this.service_id = service_id;
}

public Integer getApplication_status() {
	return application_status;
}

public void setApplication_status(Integer application_status) {
	this.application_status = application_status;
}

public Integer getIsApleSarkarApp() {
	return isApleSarkarApp;
}

public void setIsApleSarkarApp(Integer isApleSarkarApp) {
	this.isApleSarkarApp = isApleSarkarApp;
}



}

