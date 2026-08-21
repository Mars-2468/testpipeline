package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "birth_registration_service", schema = "egovrti")
public class BirthRegistration {

	@Id
	@Column(name = "birth_registration_id", nullable = false, unique = true)
	@SequenceGenerator(name = "birth_registration_ser_seq", sequenceName = "birth_registration_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "birth_registration_ser_seq")
	private long birthRegistrationId;
	
	@Column(name = "applicant_address", nullable = true )
	private String address;
	
	@Column(name = "applicant_name", nullable = true )
	private String name;
	
	@Column(name = "mobile_no", nullable = true )
	private String ph_no;
	
	@Column(name = "email_id", nullable = true )
	private String email;
	
	@Column(name = "date_of_birth", nullable = true )
	private String dob;
	
	@Column(name = "place_of_birth", nullable = true )
	private long placeofbirth;
	
	@Column(name = "gender", nullable = true )
	private String gender;
	
	@Column(name = "hospital_name", nullable = true )
	private String hospitalname;
	
	@Column(name = "mother_residence_type", nullable = true )
	private int motherresidencetype;
	
	@Column(name = "child_name", nullable = true )
	private String childename;
	
	@Column(name = "father_name", nullable = true )
	private String fathername;
	
	@Column(name = "mother_name", nullable = true )
	private String mothername;
	
	@Column(name = "grand_father_name", nullable = true )
	private String grandfathername;
	
	@Column(name = "permanent_address", nullable = true )
	private String permanentaddress;
	
	@Column(name = "birth_place", nullable = true )
	private String birthplace;
	
	@Column(name = "status", nullable = true )
	private int status;
	
	@Column(name = "no_of_free_copies_issued", nullable = true )
	private long nooffreecopyissued;
	
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;
	
	@Column(name = "pdf_files_saved_path", nullable = true )
	private String pdfFilesSavedPath;
	
	@Column(name = "old_registration_number", nullable = true )
	private String oldregistrationno;
	
	@Column(name = "zone_no", nullable = true )
	private String zone;
	

	
	public long getBirthRegistrationId() {
		return birthRegistrationId;
	}
	public void setBirthRegistrationId(long birthRegistrationId) {
		this.birthRegistrationId = birthRegistrationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getPlaceofbirth() {
		return placeofbirth;
	}
	public void setPlaceofbirth(long placeofbirth) {
		this.placeofbirth = placeofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public int getMotherresidencetype() {
		return motherresidencetype;
	}
	public void setMotherresidencetype(int motherresidencetype) {
		this.motherresidencetype = motherresidencetype;
	}
	public String getChildename() {
		return childename;
	}
	public void setChildename(String childename) {
		this.childename = childename;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getGrandfathername() {
		return grandfathername;
	}
	public void setGrandfathername(String grandfathername) {
		this.grandfathername = grandfathername;
	}
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getNooffreecopyissued() {
		return nooffreecopyissued;
	}
	public void setNooffreecopyissued(long nooffreecopyissued) {
		this.nooffreecopyissued = nooffreecopyissued;
	}
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}
	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}
	public String getOldregistrationno() {
		return oldregistrationno;
	}
	public void setOldregistrationno(String oldregistrationno) {
		this.oldregistrationno = oldregistrationno;
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
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

	
	
	
	
}
