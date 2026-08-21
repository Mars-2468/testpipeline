package com.mars.rti.ws.model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"education","hospitalName","hospitalAddress","medicalProfessionType","numberOfBeds","medicalCouncilRegNumber","otherProfessionalsDetails",
					"biologicalWasteDescription","otherDegree","email","mobileNo","firstName","middleName","lastName","degree_certificate_file",
					"council_register_file","aadhaar_card_file","current_prop_tax_file","rent_agreement_file","zoneNo","title",
					"applicantFullName","result","responseCode","responseStatus","status","userMobileNumber"})

public class BiomedicalRestDTO implements Serializable {
	
	private String education;
	private String hospitalName;
	private String hospitalAddress;
	private String medicalProfessionType;
	private int numberOfBeds;
	private String medicalCouncilRegNumber;
	private String otherProfessionalsDetails;
	private String biologicalWasteDescription;
	private String otherDegree;
	private String email;
	private long mobileNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String degree_certificate_file;
	private String council_register_file;
	private String aadhaar_card_file;
	private String current_prop_tax_file;
	private String rent_agreement_file;
	private String zoneNo;
	private String title;
	
	private String applicantFullName;

	private String result;

	private long responseCode;

	private String responseStatus;
	
	private String status;
	
	private long userMobileNumber; 
	
	
	
	@XmlElement(name = "education")
	public String getEducation() {
		return education;
	}
	
	@XmlElement(name = "hospitalName")
	public String getHospitalName() {
		return hospitalName;
	}
	@XmlElement(name = "hospitalAddress")
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	
	@XmlElement(name = "medicalProfessionType")
	public String getMedicalProfessionType() {
		return medicalProfessionType;
	}
	
	  @XmlElement(name = "numberOfBeds")
	    public int getNumberOfBeds() {
	        return numberOfBeds;
	    }

	    @XmlElement(name = "medicalCouncilRegNumber")
	    public String getMedicalCouncilRegNumber() {
	        return medicalCouncilRegNumber;
	    }

	    @XmlElement(name = "otherProfessionalsDetails")
	    public String getOtherProfessionalsDetails() {
	        return otherProfessionalsDetails;
	    }

	    @XmlElement(name = "biologicalWasteDescription")
	    public String getBiologicalWasteDescription() {
	        return biologicalWasteDescription;
	    }

	    @XmlElement(name = "otherDegree")
	    public String getOtherDegree() {
	        return otherDegree;
	    }

	    @XmlElement(name = "email")
	    public String getEmail() {
	        return email;
	    }

	    @XmlElement(name = "mobileNo")
	    public long getMobileNo() {
			return mobileNo;
		}

		@XmlElement(name = "firstName")
	    public String getFirstName() {
	        return firstName;
	    }

	    @XmlElement(name = "middleName")
	    public String getMiddleName() {
	        return middleName;
	    }

	    @XmlElement(name = "lastName")
	    public String getLastName() {
	        return lastName;
	    }

	    @XmlElement(name = "degree_certificate_file")
	    public String getDegree_certificate_file() {
	        return degree_certificate_file;
	    }

	    @XmlElement(name = "council_register_file")
	    public String getCouncil_register_file() {
	        return council_register_file;
	    }

	    @XmlElement(name = "aadhaar_card_file")
	    public String getAadhaar_card_file() {
	        return aadhaar_card_file;
	    }

	    @XmlElement(name = "current_prop_tax_file")
	    public String getCurrent_prop_tax_file() {
	        return current_prop_tax_file;
	    }

	    @XmlElement(name = "rent_agreement_file")
	    public String getRent_agreement_file() {
	        return rent_agreement_file;
	    }

	    @XmlElement(name = "zoneNo")
	    public String getZoneNo() {
	        return zoneNo;
	    }

	    @XmlElement(name = "title")
	    public String getTitle() {
	        return title;
	    }
	    
	    
	    
	    
	    @XmlElement(name = "applicantFullName")

		public String getApplicantFullName() {
			return applicantFullName;
		}
	    
	    
	    @XmlElement(name = "result")
		public String getResult() {
			return result;
		}

	    @XmlElement(name = "responseCode")
		public long getResponseCode() {
			return responseCode;
		}

	    @XmlElement(name = "responseStatus")
		public String getResponseStatus() {
			return responseStatus;
		}

	    @XmlElement(name = "status")
		public String getStatus() {
			return status;
		}
	    @XmlElement(name = "userMobileNumber")
		public long getUserMobileNumber() {
			return userMobileNumber;
		}

	    
	    
	    
	    
		public void setApplicantFullName(String applicantFullName) {
			this.applicantFullName = applicantFullName;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public void setResponseCode(long responseCode) {
			this.responseCode = responseCode;
		}

		public void setResponseStatus(String responseStatus) {
			this.responseStatus = responseStatus;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setUserMobileNumber(long userMobileNumber) {
			this.userMobileNumber = userMobileNumber;
		}

		public void setEducation(String education) {
			this.education = education;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}

		public void setHospitalAddress(String hospitalAddress) {
			this.hospitalAddress = hospitalAddress;
		}

		public void setMedicalProfessionType(String medicalProfessionType) {
			this.medicalProfessionType = medicalProfessionType;
		}

		public void setNumberOfBeds(int numberOfBeds) {
			this.numberOfBeds = numberOfBeds;
		}

		public void setMedicalCouncilRegNumber(String medicalCouncilRegNumber) {
			this.medicalCouncilRegNumber = medicalCouncilRegNumber;
		}

		public void setOtherProfessionalsDetails(String otherProfessionalsDetails) {
			this.otherProfessionalsDetails = otherProfessionalsDetails;
		}

		public void setBiologicalWasteDescription(String biologicalWasteDescription) {
			this.biologicalWasteDescription = biologicalWasteDescription;
		}

		public void setOtherDegree(String otherDegree) {
			this.otherDegree = otherDegree;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setDegree_certificate_file(String degree_certificate_file) {
			this.degree_certificate_file = degree_certificate_file;
		}

		public void setCouncil_register_file(String council_register_file) {
			this.council_register_file = council_register_file;
		}

		public void setAadhaar_card_file(String aadhaar_card_file) {
			this.aadhaar_card_file = aadhaar_card_file;
		}

		public void setCurrent_prop_tax_file(String current_prop_tax_file) {
			this.current_prop_tax_file = current_prop_tax_file;
		}

		public void setRent_agreement_file(String rent_agreement_file) {
			this.rent_agreement_file = rent_agreement_file;
		}

		public void setZoneNo(String zoneNo) {
			this.zoneNo = zoneNo;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	
	
	    
	

}
