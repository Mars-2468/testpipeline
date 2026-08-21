package com.mars.rti.ws.model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")

@JsonPropertyOrder({
    "full_name", "middle_name", "last_name", "plot_name", "name_building", "outwardNo", "area", "street", "applicantPinCode",
    "landmark", "pregnancy_termination", "phone", "email", "current_address", "name_of_place", "other_institute_name",
    "other_institute_type", "institute_type", "state", "services_offered", "category_b", "fullnamee", "phonee",
    "hospital_name", "email_id", "full_adrresss", "institute_typee", "total_beds", "number_of_beds", "nursing",
    "deliveries_conducted", "gynecological_operation_conducted", "medical_practitioner_experience",
    "anesthetists_nursing_patients", "full_time_ssisted_workingnursing_patients", "facilities_available",
    "operationTableAndInstruments", "drugsAndParacetamol", "anestheticEquipments", "oxygenCylinder", "pcpndt",
    "bloodBankRegistration", "hsptl_ambulance", "place", "date_of_patients", "zoneNo", "userMobileNumber", "result",
    "responseStatus", "status", "responseCode", "gynacoligistDegreeCertificatepdf", "additionalQualificationCertificatepdf",
    "mmcpdf", "affidivantpdf", "anesthicdegreee", "annesthicadditionalQualificationCertificatepdf", "annesthicmmcpdf",
    "annesthicaffidivantpdf", "biomedicalpdf", "maharastrapollutionpdf", "hospitalmmcpdf", "hospitalaffidivantpdf",
    "undertakingpdf", "nursinghomepdf", "bloodbankpdf", "otswabpdf"
})





public class MTPRegistrationRestDTO implements Serializable {
	
	
	  private String title;
	    private String full_name;
	    private String middle_name;
	    private String last_name;
	    private String plot_name;
	    private String name_building;
	    private String outwardNo;
	    private String area;
	    private String street;
	    private String applicantPinCode;
	    private String landmark;
	    private String pregnancy_termination;
	    private String phone;
	    private String email;
	    private String current_address;
	    private String name_of_place;
	    private String other_institute_name;
	    private String other_institute_type;
	    private String institute_type;
	    private String state;
	    private String services_offered;
	    private String category_b;
	    private String fullnamee;
	    private String phonee;
	    private String hospital_name;
	    private String email_id;
	    private String full_adrresss;
	    private String institute_typee;
	    private String total_beds;
	    private String number_of_beds;
	    private String nursing;
	    private String deliveries_conducted;
	    private String gynecological_operation_conducted;
	    private String medical_practitioner_experience;
	    private String anesthetists_nursing_patients;
	    private String full_time_ssisted_workingnursing_patients;
	    private String facilities_available;
	    private String operationTableAndInstruments;
	    private String drugsAndParacetamol;
	    private String anestheticEquipments;
	    private String oxygenCylinder;
	    private String pcpndt;
	    private String bloodBankRegistration;
	    private String hsptl_ambulance;
	    private String place;
	    private String date_of_patients;
	    private String zoneNo;
	    private long userMobileNumber;
	    
	    private String result;
	    
		private String responseStatus;

		private String status;

		private long responseCode;
	    
	    private String gynacoligistDegreeCertificatepdf;

		private String additionalQualificationCertificatepdf ;

		private String mmcpdf;

		private String affidivantpdf;
		
		
		   private String anesthicdegreee;

			private String annesthicadditionalQualificationCertificatepdf ;

			private String annesthicmmcpdf;

			private String annesthicaffidivantpdf;
			
			
			 private String biomedicalpdf;

				private String maharastrapollutionpdf;

				private String hospitalmmcpdf;

				private String hospitalaffidivantpdf;
				
				private String undertakingpdf;
				
				private String nursinghomepdf;
				
				private String bloodbankpdf;
				
				private String otswabpdf;

				
				@XmlElement(name = "title")
				public String getTitle() {
					return title;
				}

				@XmlElement(name = "full_name")
				public String getFull_name() {
					return full_name;
				}
				@XmlElement(name = "middle_name")
				public String getMiddle_name() {
					return middle_name;
				}
				@XmlElement(name = "last_name")
				public String getLast_name() {
					return last_name;
				}
				@XmlElement(name = "plot_name")
				public String getPlot_name() {
					return plot_name;
				}
				@XmlElement(name = "name_building")
				public String getName_building() {
					return name_building;
				}
				@XmlElement(name = "outwardNo")
				public String getOutwardNo() {
					return outwardNo;
				}
				@XmlElement(name = "area")
				public String getArea() {
					return area;
				}
				@XmlElement(name = "street")
				public String getStreet() {
					return street;
				}
				@XmlElement(name = "applicantPinCode")
				public String getApplicantPinCode() {
					return applicantPinCode;
				}
				@XmlElement(name = "landmark")
				public String getLandmark() {
					return landmark;
				}
				@XmlElement(name = "pregnancy_termination")
				public String getPregnancy_termination() {
					return pregnancy_termination;
				}
				@XmlElement(name = "phone")
				public String getPhone() {
					return phone;
				}
				@XmlElement(name = "email")
				public String getEmail() {
					return email;
				}
				@XmlElement(name = "current_address")
				public String getCurrent_address() {
					return current_address;
				}
				@XmlElement(name = "name_of_place")
				public String getName_of_place() {
					return name_of_place;
				}
				@XmlElement(name = "other_institute_name")
				public String getOther_institute_name() {
					return other_institute_name;
				}
				@XmlElement(name = "other_institute_type")
				public String getOther_institute_type() {
					return other_institute_type;
				}
				@XmlElement(name = "institute_type")
				public String getInstitute_type() {
					return institute_type;
				}
				@XmlElement(name = "state")
				public String getState() {
					return state;
				}
				@XmlElement(name = "services_offered")
				public String getServices_offered() {
					return services_offered;
				}
				@XmlElement(name = "category_b")
				public String getCategory_b() {
					return category_b;
				}
				@XmlElement(name = "fullnamee")
				public String getFullnamee() {
					return fullnamee;
				}
				@XmlElement(name = "phonee")
				public String getPhonee() {
					return phonee;
				}
				@XmlElement(name = "hospital_name")
				public String getHospital_name() {
					return hospital_name;
				}
				@XmlElement(name = "email_id")
				public String getEmail_id() {
					return email_id;
				}
				@XmlElement(name = "full_adrresss")
				public String getFull_adrresss() {
					return full_adrresss;
				}
				@XmlElement(name = "institute_typee")
				public String getInstitute_typee() {
					return institute_typee;
				}
				@XmlElement(name = "total_beds")
				public String getTotal_beds() {
					return total_beds;
				}
				@XmlElement(name = "number_of_beds")
				public String getNumber_of_beds() {
					return number_of_beds;
				}
				@XmlElement(name = "nursing")
				public String getNursing() {
					return nursing;
				}
				@XmlElement(name = "deliveries_conducted")
				public String getDeliveries_conducted() {
					return deliveries_conducted;
				}
				@XmlElement(name = "gynecological_operation_conducted")
				public String getGynecological_operation_conducted() {
					return gynecological_operation_conducted;
				}
				@XmlElement(name = "medical_practitioner_experience")
				public String getMedical_practitioner_experience() {
					return medical_practitioner_experience;
				}
				@XmlElement(name = "anesthetists_nursing_patients")
				public String getAnesthetists_nursing_patients() {
					return anesthetists_nursing_patients;
				}
				@XmlElement(name = "full_time_ssisted_workingnursing_patients")
				public String getFull_time_ssisted_workingnursing_patients() {
					return full_time_ssisted_workingnursing_patients;
				}
				@XmlElement(name = "facilities_available")
				public String getFacilities_available() {
					return facilities_available;
				}
				@XmlElement(name = "operationTableAndInstruments")
				public String getOperationTableAndInstruments() {
					return operationTableAndInstruments;
				}
				@XmlElement(name = "drugsAndParacetamol")
				public String getDrugsAndParacetamol() {
					return drugsAndParacetamol;
				}
				@XmlElement(name = "anestheticEquipments")
				public String getAnestheticEquipments() {
					return anestheticEquipments;
				}
				@XmlElement(name = "oxygenCylinder")
				public String getOxygenCylinder() {
					return oxygenCylinder;
				}
				@XmlElement(name = "pcpndt")
				public String getPcpndt() {
					return pcpndt;
				}
				@XmlElement(name = "bloodBankRegistration")
				public String getBloodBankRegistration() {
					return bloodBankRegistration;
				}
				@XmlElement(name = "hsptl_ambulance")
				public String getHsptl_ambulance() {
					return hsptl_ambulance;
				}
				@XmlElement(name = "place")
				public String getPlace() {
					return place;
				}
				@XmlElement(name = "date_of_patients")
				public String getDate_of_patients() {
					return date_of_patients;
				}
				@XmlElement(name = "zoneNo")
				public String getZoneNo() {
					return zoneNo;
				}
				@XmlElement(name = "userMobileNumber")
				public long getUserMobileNumber() {
					return userMobileNumber;
				}
				@XmlElement(name = "result")
				public String getResult() {
					return result;
				}
				@XmlElement(name = "gynacoligistDegreeCertificatepdf")
				public String getGynacoligistDegreeCertificatepdf() {
					return gynacoligistDegreeCertificatepdf;
				}
				@XmlElement(name = "additionalQualificationCertificatepdf")
				public String getAdditionalQualificationCertificatepdf() {
					return additionalQualificationCertificatepdf;
				}
				@XmlElement(name = "mmcpdf")
				public String getMmcpdf() {
					return mmcpdf;
				}
				@XmlElement(name = "affidivantpdf")
				public String getAffidivantpdf() {
					return affidivantpdf;
				}
				@XmlElement(name = "anesthicdegreee")
				public String getAnesthicdegreee() {
					return anesthicdegreee;
				}
				@XmlElement(name = "annesthicadditionalQualificationCertificatepdf")
				public String getAnnesthicadditionalQualificationCertificatepdf() {
					return annesthicadditionalQualificationCertificatepdf;
				}
				@XmlElement(name = "annesthicmmcpdf")
				public String getAnnesthicmmcpdf() {
					return annesthicmmcpdf;
				}
				@XmlElement(name = "annesthicaffidivantpdf")
				public String getAnnesthicaffidivantpdf() {
					return annesthicaffidivantpdf;
				}
				@XmlElement(name = "biomedicalpdf")
				public String getBiomedicalpdf() {
					return biomedicalpdf;
				}
				@XmlElement(name = "maharastrapollutionpdf")
				public String getMaharastrapollutionpdf() {
					return maharastrapollutionpdf;
				}
				@XmlElement(name = "hospitalmmcpdf")
				public String getHospitalmmcpdf() {
					return hospitalmmcpdf;
				}
				@XmlElement(name = "hospitalaffidivantpdf")
				public String getHospitalaffidivantpdf() {
					return hospitalaffidivantpdf;
				}
				@XmlElement(name = "undertakingpdf")
				public String getUndertakingpdf() {
					return undertakingpdf;
				}
				@XmlElement(name = "nursinghomepdf")
				public String getNursinghomepdf() {
					return nursinghomepdf;
				}
				@XmlElement(name = "bloodbankpdf")
				public String getBloodbankpdf() {
					return bloodbankpdf;
				}
				@XmlElement(name = "otswabpdf")
				public String getOtswabpdf() {
					return otswabpdf;
				}

				
				@XmlElement(name = "responseStatus")
				
				public String getResponseStatus() {
					return responseStatus;
				}
				@XmlElement(name = "status")
				public String getStatus() {
					return status;
				}
				@XmlElement(name = "responseCode")
				public long getResponseCode() {
					return responseCode;
				}

				public void setTitle(String title) {
					this.title = title;
				}

				public void setFull_name(String full_name) {
					this.full_name = full_name;
				}

				public void setMiddle_name(String middle_name) {
					this.middle_name = middle_name;
				}

				public void setLast_name(String last_name) {
					this.last_name = last_name;
				}

				public void setPlot_name(String plot_name) {
					this.plot_name = plot_name;
				}

				public void setName_building(String name_building) {
					this.name_building = name_building;
				}

				public void setOutwardNo(String outwardNo) {
					this.outwardNo = outwardNo;
				}

				public void setArea(String area) {
					this.area = area;
				}

				public void setStreet(String street) {
					this.street = street;
				}

				public void setApplicantPinCode(String applicantPinCode) {
					this.applicantPinCode = applicantPinCode;
				}

				public void setLandmark(String landmark) {
					this.landmark = landmark;
				}

				public void setPregnancy_termination(String pregnancy_termination) {
					this.pregnancy_termination = pregnancy_termination;
				}

				public void setPhone(String phone) {
					this.phone = phone;
				}

				public void setEmail(String email) {
					this.email = email;
				}

				public void setCurrent_address(String current_address) {
					this.current_address = current_address;
				}

				public void setName_of_place(String name_of_place) {
					this.name_of_place = name_of_place;
				}

				public void setOther_institute_name(String other_institute_name) {
					this.other_institute_name = other_institute_name;
				}

				public void setOther_institute_type(String other_institute_type) {
					this.other_institute_type = other_institute_type;
				}

				public void setInstitute_type(String institute_type) {
					this.institute_type = institute_type;
				}

				public void setState(String state) {
					this.state = state;
				}

				public void setServices_offered(String services_offered) {
					this.services_offered = services_offered;
				}

				public void setCategory_b(String category_b) {
					this.category_b = category_b;
				}

				public void setFullnamee(String fullnamee) {
					this.fullnamee = fullnamee;
				}

				public void setPhonee(String phonee) {
					this.phonee = phonee;
				}

				public void setResponseStatus(String responseStatus) {
					this.responseStatus = responseStatus;
				}

				public void setStatus(String status) {
					this.status = status;
				}

				public void setResponseCode(long responseCode) {
					this.responseCode = responseCode;
				}

				public void setHospital_name(String hospital_name) {
					this.hospital_name = hospital_name;
				}

				public void setEmail_id(String email_id) {
					this.email_id = email_id;
				}

				public void setFull_adrresss(String full_adrresss) {
					this.full_adrresss = full_adrresss;
				}

				public void setInstitute_typee(String institute_typee) {
					this.institute_typee = institute_typee;
				}

				public void setTotal_beds(String total_beds) {
					this.total_beds = total_beds;
				}

				public void setNumber_of_beds(String number_of_beds) {
					this.number_of_beds = number_of_beds;
				}

				public void setNursing(String nursing) {
					this.nursing = nursing;
				}

				public void setDeliveries_conducted(String deliveries_conducted) {
					this.deliveries_conducted = deliveries_conducted;
				}

				public void setGynecological_operation_conducted(String gynecological_operation_conducted) {
					this.gynecological_operation_conducted = gynecological_operation_conducted;
				}

				public void setMedical_practitioner_experience(String medical_practitioner_experience) {
					this.medical_practitioner_experience = medical_practitioner_experience;
				}

				public void setAnesthetists_nursing_patients(String anesthetists_nursing_patients) {
					this.anesthetists_nursing_patients = anesthetists_nursing_patients;
				}

				public void setFull_time_ssisted_workingnursing_patients(String full_time_ssisted_workingnursing_patients) {
					this.full_time_ssisted_workingnursing_patients = full_time_ssisted_workingnursing_patients;
				}

				public void setFacilities_available(String facilities_available) {
					this.facilities_available = facilities_available;
				}

				public void setOperationTableAndInstruments(String operationTableAndInstruments) {
					this.operationTableAndInstruments = operationTableAndInstruments;
				}

				public void setDrugsAndParacetamol(String drugsAndParacetamol) {
					this.drugsAndParacetamol = drugsAndParacetamol;
				}

				public void setAnestheticEquipments(String anestheticEquipments) {
					this.anestheticEquipments = anestheticEquipments;
				}

				public void setOxygenCylinder(String oxygenCylinder) {
					this.oxygenCylinder = oxygenCylinder;
				}

				public void setPcpndt(String pcpndt) {
					this.pcpndt = pcpndt;
				}

				public void setBloodBankRegistration(String bloodBankRegistration) {
					this.bloodBankRegistration = bloodBankRegistration;
				}

				public void setHsptl_ambulance(String hsptl_ambulance) {
					this.hsptl_ambulance = hsptl_ambulance;
				}

				public void setPlace(String place) {
					this.place = place;
				}

				public void setDate_of_patients(String date_of_patients) {
					this.date_of_patients = date_of_patients;
				}

				public void setZoneNo(String zoneNo) {
					this.zoneNo = zoneNo;
				}

				public void setUserMobileNumber(long userMobileNumber) {
					this.userMobileNumber = userMobileNumber;
				}

				public void setResult(String result) {
					this.result = result;
				}

				public void setGynacoligistDegreeCertificatepdf(String gynacoligistDegreeCertificatepdf) {
					this.gynacoligistDegreeCertificatepdf = gynacoligistDegreeCertificatepdf;
				}

				public void setAdditionalQualificationCertificatepdf(String additionalQualificationCertificatepdf) {
					this.additionalQualificationCertificatepdf = additionalQualificationCertificatepdf;
				}

				public void setMmcpdf(String mmcpdf) {
					this.mmcpdf = mmcpdf;
				}

				public void setAffidivantpdf(String affidivantpdf) {
					this.affidivantpdf = affidivantpdf;
				}

				public void setAnesthicdegreee(String anesthicdegreee) {
					this.anesthicdegreee = anesthicdegreee;
				}

				public void setAnnesthicadditionalQualificationCertificatepdf(String annesthicadditionalQualificationCertificatepdf) {
					this.annesthicadditionalQualificationCertificatepdf = annesthicadditionalQualificationCertificatepdf;
				}

				public void setAnnesthicmmcpdf(String annesthicmmcpdf) {
					this.annesthicmmcpdf = annesthicmmcpdf;
				}

				public void setAnnesthicaffidivantpdf(String annesthicaffidivantpdf) {
					this.annesthicaffidivantpdf = annesthicaffidivantpdf;
				}

				public void setBiomedicalpdf(String biomedicalpdf) {
					this.biomedicalpdf = biomedicalpdf;
				}

				public void setMaharastrapollutionpdf(String maharastrapollutionpdf) {
					this.maharastrapollutionpdf = maharastrapollutionpdf;
				}

				public void setHospitalmmcpdf(String hospitalmmcpdf) {
					this.hospitalmmcpdf = hospitalmmcpdf;
				}

				public void setHospitalaffidivantpdf(String hospitalaffidivantpdf) {
					this.hospitalaffidivantpdf = hospitalaffidivantpdf;
				}

				public void setUndertakingpdf(String undertakingpdf) {
					this.undertakingpdf = undertakingpdf;
				}

				public void setNursinghomepdf(String nursinghomepdf) {
					this.nursinghomepdf = nursinghomepdf;
				}

				public void setBloodbankpdf(String bloodbankpdf) {
					this.bloodbankpdf = bloodbankpdf;
				}

				public void setOtswabpdf(String otswabpdf) {
					this.otswabpdf = otswabpdf;
				}
				
				
				
				
				
				
				
				
			
			

}
