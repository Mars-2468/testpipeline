package com.mars.rti.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BirthRegistration")
@XmlType(propOrder = {"registrationid","address","name","ph_no","email","dob","placeofbirth",
"gender","hospitalname","childename","fathername","grandfathername","permanentaddress","birthplace","nooffreecopyissued","rtiapplrefno","oldregistrationno","mothername","status","motherresidencetype","result","response","pdfsavedpath","workFlowStatus","responseStatus","wardOffcierName","wardName"})		
public class BirthRegistrationRestDTO implements java.io.Serializable {
	
    private long registrationid;
	
	private String address;
	
	private String name;
	
	private String ph_no;	

	private String email;
		
	private String dob;

	private long placeofbirth;

	private String gender;	
	
	private String hospitalname;
	
	private int motherresidencetype;
	
	private String result;
	
	private long response;
	
	private String childename;
		
	private String fathername;
		
	private String mothername;
	
	private String grandfathername;
	
	private String permanentaddress;
	
	private String birthplace;
		
	private int status;
		
	private long nooffreecopyissued;
	
	private String rtiapplrefno;
		
	private String oldregistrationno;
	
	private String pdfsavedpath;
	
	private Integer workFlowStatus;
	
	private String responseStatus;
	
	private String wardOffcierName;
	
	private String wardName;

	 @XmlElement(name = "pdfsavedpath")
	 public String getPdfsavedpath() {
		return pdfsavedpath;
	}

	public void setPdfsavedpath(String pdfsavedpath) {
		this.pdfsavedpath = pdfsavedpath;
	}

	@XmlElement(name = "registrationid")
	public long getRegistrationid() {
		return registrationid;
	}

	 @XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	 @XmlElement(name = "name")
	public String getName() {
		return name;
	}

	 @XmlElement(name = "ph_no")
	public String getPh_no() {
		return ph_no;
	}


	 @XmlElement(name = "email")
	public String getEmail() {
		return email;
	}


	 @XmlElement(name = "dob")
	public String getDob() {
		return dob;
	}


	 @XmlElement(name = "placeofbirth")
	public long getPlaceofbirth() {
		return placeofbirth;
	}


	 @XmlElement(name = "gender")
	public String getGender() {
		return gender;
	}

	 @XmlElement(name = "hospitalname")
	public String getHospitalname() {
		return hospitalname;
	}

	 @XmlElement(name = "motherresidencetype")
	public int getMotherresidencetype() {
		return motherresidencetype;
	}

	 @XmlElement(name = "childename")
	public String getChildename() {
		return childename;
	}

	 @XmlElement(name = "fathername")
	public String getFathername() {
		return fathername;
	}

	 @XmlElement(name = "mothername")
	public String getMothername() {
		return mothername;
	}

	 @XmlElement(name = "grandfathername")
	public String getGrandfathername() {
		return grandfathername;
	}

	 @XmlElement(name = "permanentaddress")
	public String getPermanentaddress() {
		return permanentaddress;
	}

	 @XmlElement(name = "birthplace")
	public String getBirthplace() {
		return birthplace;
	}

	 @XmlElement(name = "status")
	public int getStatus() {
		return status;
	}

	 @XmlElement(name = "nooffreecopyissued")
	public long getNooffreecopyissued() {
		return nooffreecopyissued;
	}

	 @XmlElement(name = "rtiapplrefno")
	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	 @XmlElement(name = "oldregistrationno")
	public String getOldregistrationno() {
		return oldregistrationno;
	}


	public void setRegistrationid(long registrationid) {
		this.registrationid = registrationid;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setPlaceofbirth(long placeofbirth) {
		this.placeofbirth = placeofbirth;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}


	public void setMotherresidencetype(int motherresidencetype) {
		this.motherresidencetype = motherresidencetype;
	}


	public void setChildename(String childename) {
		this.childename = childename;
	}


	public void setFathername(String fathername) {
		this.fathername = fathername;
	}


	public void setMothername(String mothername) {
		this.mothername = mothername;
	}


	public void setGrandfathername(String grandfathername) {
		this.grandfathername = grandfathername;
	}


	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}


	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public void setNooffreecopyissued(long nooffreecopyissued) {
		this.nooffreecopyissued = nooffreecopyissued;
	}


	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}


	public void setOldregistrationno(String oldregistrationno) {
		this.oldregistrationno = oldregistrationno;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	 public void setResult(String result) {
		this.result = result;
	}

	 @XmlElement(name = "response")
	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	 @XmlElement(name = "workFlowStatus")
	public Integer getWorkFlowStatus() {
		return workFlowStatus;
	}

	public void setWorkFlowStatus(Integer integer) {
		this.workFlowStatus = integer;
	}

	 @XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	 @XmlElement(name = "wardOffcierName")
	public String getWardOffcierName() {
		return wardOffcierName;
	}

	public void setWardOffcierName(String wardOffcierName) {
		this.wardOffcierName = wardOffcierName;
	}

	 @XmlElement(name = "wardName")
	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	
	
	
}
