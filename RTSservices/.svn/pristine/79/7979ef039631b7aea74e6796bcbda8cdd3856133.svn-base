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
@Table(name = "mtp_registration_certificate", schema = "egovrti")
public class MTPRegistrationCertificate {

	@Id
	@Column(name = "mtpid", nullable = false, unique = true)
	@SequenceGenerator(name = "mttp_id_ser_seq", sequenceName = "mttp_id_ser_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mttp_id_ser_seq")
	
	private long mtpId;


	@Transient
	private String filesPath;
	  
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "current_address")
	private String current_address;
		
	@Column(name = "phone_Number")
	private String phoneNumber;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pregnancy_termination")
	private String pregnancy_termination;
	
	
	@Column(name = "name_of_place")
	private String name_of_place;
	
	@Column(name = "institute_type")
	private String institute_type;
	
	@Column(name = "other_institute_type")
	private String other_institute_type;
	
	
	@Column(name = "zone_no")
	private String zoneNo;

	
	
	@Column(name = "gynaecological")
	private String gynaecological;
	
	
	@Column(name = "resuscitation")
	private String resuscitation;
	
	
	@Column(name = "sterilization")
	private String sterilization;
	
	
	@Column(name = "emergency")
	private String emergency;
	
	
	
	@Column(name = "transportation")
	private String transportation;


	@Column(name = "gynaecologicalsurgery")
	private String gynaecologicalsurgery;


	@Column(name = "drugsparental")
	private String drugsparental;


	@Column(name = "resuscitationequipment")
	private String resuscitationequipment;


	@Column(name = "ownername")
	private String ownername;

	@Column(name = "place_full_adrresss")
	private String place_full_adrresss;

	@Column(name = "place_email_id")
	private String place_email_id;

	@Column(name = "place_phonee")
	private String place_phonee;

	@Column(name = "name_place")
	private String name_place;
	
	@Column(name = "nmcregnumber")
	private String nmcregnumber;
	
	@Column(name = "total_no_beds")
	private String total_no_beds;

	@Column(name = "obscticals")
	private String obscticals;

	@Column(name = "gyn_case")
	private String gyn_case;

	@Column(name = "no_of_deliveries")
	private String no_of_deliveries;

	@Column(name = "dilatation")
	private String dilatation;

	@Column(name = "abdominal")
	private String abdominal;

	@Column(name = "operation_tableandinstruments")
	private String operationTableAndInstruments;

	
	@Column(name = "drugsand_paracetamol")
	private String drugsAndParacetamol;

	
	@Column(name = "anesthetic_equipments")
	private String anestheticEquipments;

	
	@Column(name = "oxygen_cylinder")
	private String oxygenCylinder;

	
	@Column(name = "acknowledge")
	private String acknowledge;

	
	@Column(name = "uploaded_demand", nullable = true)
	private String uploadedDemand;

	
	@Column(name = "cell_remark", nullable = true)
	private String cellRemark;

	@Column(name="mho_remark")
	private String mhoRemark;
	
	@Column(name="hq_remark")
	private String hQRemark;

	@Column(name = "hq_doc")
	private String hqdoc;
	
	@Column(name = "zmo_doc")
	private String zmodoc;
	
	
	
	@Column(name = "nodaltocellremark")
	private String nodaltocellRemark;
	
	
	
	@OneToMany(mappedBy = "mTPRegistrationCertificate")
   private List<MTPDetails> mTPDetails = new ArrayList<MTPDetails>();
	
	
	@OneToMany(mappedBy = "mTPRegistrationCertificate")
	   private List<MTPAssistantDetails> mTPAssistantDetails = new ArrayList<MTPAssistantDetails>();
	
	
	@OneToMany(mappedBy = "mTPRegistrationCertificate")
	   private List<MTPNurseDetails> mTPNurseDetails = new ArrayList<MTPNurseDetails>();
	
	@OneToMany(mappedBy = "mTPRegistrationCertificate")
	   private List<MTPBloodBankDetails> mTPBloodBankDetails = new ArrayList<MTPBloodBankDetails>();
	
	@OneToMany(mappedBy = "mTPRegistrationCertificate")
	   private List<AnaesthetistDetails> anaesthetistDetails = new ArrayList<AnaesthetistDetails>();
	
	

	public String getUploadedDemand() {
		return uploadedDemand;
	}

	public void setUploadedDemand(String uploadedDemand) {
		this.uploadedDemand = uploadedDemand;
	}
	
	public String getCellRemark() {
		return cellRemark;
	}

	public void setCellRemark(String cellRemark) {
		this.cellRemark = cellRemark;
	}

	@Column(name = "rti_appl_ref_no", nullable = true ) 
	  private String rtiapplrefno;
	  
	  @Column(name = "rti_ref_id", nullable = true )
	  private long rti_ref_id;
	  
	  @Column(name = "pdf_files_saved_path", nullable = true )
	  private String pdfFilesSavedPath;
	  
	  
	
	public long getMtpId() {
		return mtpId;
	}

	public void setMtpId(long mtpId) {
		this.mtpId = mtpId;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getCurrent_address() {
		return current_address;
	}

	public void setCurrent_address(String current_address) {
		this.current_address = current_address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPregnancy_termination() {
		return pregnancy_termination;
	}

	public void setPregnancy_termination(String pregnancy_termination) {
		this.pregnancy_termination = pregnancy_termination;
	}

	public String getName_of_place() {
		return name_of_place;
	}

	public void setName_of_place(String name_of_place) {
		this.name_of_place = name_of_place;
	}

	public String getInstitute_type() {
		return institute_type;
	}

	public void setInstitute_type(String institute_type) {
		this.institute_type = institute_type;
	}

	public String getOther_institute_type() {
		return other_institute_type;
	}

	public void setOther_institute_type(String other_institute_type) {
		this.other_institute_type = other_institute_type;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getGynaecological() {
		return gynaecological;
	}

	public void setGynaecological(String gynaecological) {
		this.gynaecological = gynaecological;
	}

	public String getResuscitation() {
		return resuscitation;
	}

	public void setResuscitation(String resuscitation) {
		this.resuscitation = resuscitation;
	}

	public String getSterilization() {
		return sterilization;
	}

	public void setSterilization(String sterilization) {
		this.sterilization = sterilization;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getGynaecologicalsurgery() {
		return gynaecologicalsurgery;
	}

	public void setGynaecologicalsurgery(String gynaecologicalsurgery) {
		this.gynaecologicalsurgery = gynaecologicalsurgery;
	}

	public String getDrugsparental() {
		return drugsparental;
	}

	public void setDrugsparental(String drugsparental) {
		this.drugsparental = drugsparental;
	}

	public String getResuscitationequipment() {
		return resuscitationequipment;
	}

	public void setResuscitationequipment(String resuscitationequipment) {
		this.resuscitationequipment = resuscitationequipment;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getPlace_full_adrresss() {
		return place_full_adrresss;
	}

	public void setPlace_full_adrresss(String place_full_adrresss) {
		this.place_full_adrresss = place_full_adrresss;
	}

	public String getPlace_email_id() {
		return place_email_id;
	}

	public void setPlace_email_id(String place_email_id) {
		this.place_email_id = place_email_id;
	}

	public String getPlace_phonee() {
		return place_phonee;
	}

	public void setPlace_phonee(String place_phonee) {
		this.place_phonee = place_phonee;
	}

	public String getNmcregnumber() {
		return nmcregnumber;
	}

	public void setNmcregnumber(String nmcregnumber) {
		this.nmcregnumber = nmcregnumber;
	}

	public String getTotal_no_beds() {
		return total_no_beds;
	}

	public void setTotal_no_beds(String total_no_beds) {
		this.total_no_beds = total_no_beds;
	}

	public String getObscticals() {
		return obscticals;
	}

	public void setObscticals(String obscticals) {
		this.obscticals = obscticals;
	}

	public String getGyn_case() {
		return gyn_case;
	}

	public void setGyn_case(String gyn_case) {
		this.gyn_case = gyn_case;
	}

	public String getNo_of_deliveries() {
		return no_of_deliveries;
	}

	public void setNo_of_deliveries(String no_of_deliveries) {
		this.no_of_deliveries = no_of_deliveries;
	}

	public String getDilatation() {
		return dilatation;
	}

	public void setDilatation(String dilatation) {
		this.dilatation = dilatation;
	}

	public String getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(String abdominal) {
		this.abdominal = abdominal;
	}

	public String getOperationTableAndInstruments() {
		return operationTableAndInstruments;
	}

	public void setOperationTableAndInstruments(String operationTableAndInstruments) {
		this.operationTableAndInstruments = operationTableAndInstruments;
	}

	public String getDrugsAndParacetamol() {
		return drugsAndParacetamol;
	}

	public void setDrugsAndParacetamol(String drugsAndParacetamol) {
		this.drugsAndParacetamol = drugsAndParacetamol;
	}

	public String getAnestheticEquipments() {
		return anestheticEquipments;
	}

	public void setAnestheticEquipments(String anestheticEquipments) {
		this.anestheticEquipments = anestheticEquipments;
	}

	public String getOxygenCylinder() {
		return oxygenCylinder;
	}

	public void setOxygenCylinder(String oxygenCylinder) {
		this.oxygenCylinder = oxygenCylinder;
	}

	public String getAcknowledge() {
		return acknowledge;
	}

	public void setAcknowledge(String acknowledge) {
		this.acknowledge = acknowledge;
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

	public String getPdfFilesSavedPath() {
		return pdfFilesSavedPath;
	}

	public void setPdfFilesSavedPath(String pdfFilesSavedPath) {
		this.pdfFilesSavedPath = pdfFilesSavedPath;
	}

	  
	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	
	}

	public String getName_place() {
		return name_place;
	}

	public void setName_place(String name_place) {
		this.name_place = name_place;
	}

	public String getMhoRemark() {
		return mhoRemark;
	}

	public void setMhoRemark(String mhoRemark) {
		this.mhoRemark = mhoRemark;
	}

	public String gethQRemark() {
		return hQRemark;
	}

	public void sethQRemark(String hQRemark) {
		this.hQRemark = hQRemark;
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

	public List<MTPDetails> getmTPDetails() {
		return mTPDetails;
	}

	public void setmTPDetails(List<MTPDetails> mTPDetails) {
		this.mTPDetails = mTPDetails;
	}

	public List<MTPNurseDetails> getmTPNurseDetails() {
		return mTPNurseDetails;
	}

	public void setmTPNurseDetails(List<MTPNurseDetails> mTPNurseDetails) {
		this.mTPNurseDetails = mTPNurseDetails;
	}

	public List<MTPBloodBankDetails> getmTPBloodBankDetails() {
		return mTPBloodBankDetails;
	}

	public void setmTPBloodBankDetails(List<MTPBloodBankDetails> mTPBloodBankDetails) {
		this.mTPBloodBankDetails = mTPBloodBankDetails;
	}

	public List<AnaesthetistDetails> getAnaesthetistDetails() {
		return anaesthetistDetails;
	}

	public void setAnaesthetistDetails(List<AnaesthetistDetails> anaesthetistDetails) {
		this.anaesthetistDetails = anaesthetistDetails;
	}
	 
	  
		@Column(name = "inspectionstatus")
		private int inspectionstatus;



		public int getInspectionstatus() {
			return inspectionstatus;
		}

		public void setInspectionstatus(int inspectionstatus) {
			this.inspectionstatus = inspectionstatus;
		}

		public List<MTPAssistantDetails> getmTPAssistantDetails() {
			return mTPAssistantDetails;
		}

		public void setmTPAssistantDetails(List<MTPAssistantDetails> mTPAssistantDetails) {
			this.mTPAssistantDetails = mTPAssistantDetails;
		}

		public String getNodaltocellRemark() {
			return nodaltocellRemark;
		}

		public void setNodaltocellRemark(String nodaltocellRemark) {
			this.nodaltocellRemark = nodaltocellRemark;
		}
	
		
		
	
	
	
	
}
