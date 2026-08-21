//package com.mars.rti.ws.controller;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.Year;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//import java.util.UUID;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.mars.common.utils.CommonUtils;
//import com.mars.common.utils.SendEmail;
//import com.mars.common.utils.SendSMS;
//import com.mars.rti.model.MTPRegistrationCertificate;
//import com.mars.rti.model.RTIApplication;
//import com.mars.rti.model.RTIApplicationDetails;
//import com.mars.rti.service.MTPRegistrationCertificateService;
//import com.mars.rti.service.RTIApplicationService;
//import com.mars.rti.utils.CoreConstants;
//import com.mars.rti.ws.model.MTPRegistrationRestDTO;
//
//@Controller
//public class MTPRegistrationRestController {
//	
//	private static Log log = LogFactory.getLog(LicenseTransferRestController.class);
//	@Autowired
//	private RTIApplicationService rtiApplicationService;
//
//	@Autowired
//	private MTPRegistrationCertificateService mTPRegistrationCertificateService;
//
//
//	@RequestMapping(method = RequestMethod.POST, value = "/saveMtpRegistration")
//	public @ResponseBody MTPRegistrationRestDTO saveMtpRegistration(
//			@RequestBody MTPRegistrationRestDTO MTPRegistrationRestDTO, HttpServletRequest request,
//			HttpServletResponse reponse) throws ServletException {
//		boolean condition = true;
//		StringBuilder message = new StringBuilder();
//		String[] files = new String[16];
//		if (log.isDebugEnabled()) {
//			log.debug("Invoking saveMTP");
//			MTPRegistrationCertificate mTPRegistrationCertificate = new MTPRegistrationCertificate();
//			
//			
//			try {
//
//				if ((MTPRegistrationRestDTO.getTitle() != null) && !MTPRegistrationRestDTO.getTitle().isEmpty()) {
//					mTPRegistrationCertificate.setTitle(MTPRegistrationRestDTO.getTitle());
//				} else {
//					String Title = "Title field is Required";
//					condition = false;
//					message.append(Title).append(",");
//				}
//				
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getFullnamee() != null) && !MTPRegistrationRestDTO.getFullnamee().isEmpty()) {
//					mTPRegistrationCertificate.setFull_name(MTPRegistrationRestDTO.getFull_name());
//				} else {
//					String fullname = "fullName field is Required";
//					condition = false;
//					message.append(fullname).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getMiddle_name() != null) && !MTPRegistrationRestDTO.getMiddle_name().isEmpty()) {
//					mTPRegistrationCertificate.setMiddle_name(MTPRegistrationRestDTO.getMiddle_name());				
//					} else {
//					String MiddleName = "MiddleName field is Required";
//					condition = false;
//					message.append(MiddleName).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getLast_name() != null) && !MTPRegistrationRestDTO.getLast_name().isEmpty()) {
//					mTPRegistrationCertificate.setLast_name(MTPRegistrationRestDTO.getLast_name());				
//					} else {
//					String LastName = "LastName field is Required";
//					condition = false;
//					message.append(LastName).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getPlot_name() != null) && !MTPRegistrationRestDTO.getPlot_name().isEmpty()) {
//					mTPRegistrationCertificate.setPlot_name(MTPRegistrationRestDTO.getPlot_name());				
//					} else {
//					String PlotName = "PlotName field is Required";
//					condition = false;
//					message.append(PlotName).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getName_building() != null) && !MTPRegistrationRestDTO.getName_building().isEmpty()) {
//					mTPRegistrationCertificate.setName_building(MTPRegistrationRestDTO.getName_building());				
//					} else {
//					String Namebuilding = "Namebuilding field is Required";
//					condition = false;
//					message.append(Namebuilding).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getStreet() != null) && !MTPRegistrationRestDTO.getStreet().isEmpty()) {
//					mTPRegistrationCertificate.setStreet(MTPRegistrationRestDTO.getStreet());				
//					} else {
//					String Street = "Street field is Required";
//					condition = false;
//					message.append(Street).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getArea() != null) && !MTPRegistrationRestDTO.getArea().isEmpty()) {
//					mTPRegistrationCertificate.setArea(MTPRegistrationRestDTO.getArea());				
//					} else {
//					String Area = "Area field is Required";
//					condition = false;
//					message.append(Area).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getApplicantPinCode() != null) && !MTPRegistrationRestDTO.getApplicantPinCode().isEmpty()) {
//					mTPRegistrationCertificate.setApplicantPinCode(MTPRegistrationRestDTO.getApplicantPinCode());				
//					} else {
//					String ApplicantPinCode = "Applicant PinCode field is Required";
//					condition = false;
//					message.append(ApplicantPinCode).append(",");
//				}
//	
//				if ((MTPRegistrationRestDTO.getLandmark() != null) && !MTPRegistrationRestDTO.getLandmark().isEmpty()) {
//					mTPRegistrationCertificate.setLandmark(MTPRegistrationRestDTO.getLandmark());				
//					} else {
//					String Landmark = "Landmark  field is Required";
//					condition = false;
//					message.append(Landmark).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getPhone() != null) && !MTPRegistrationRestDTO.getPhone().isEmpty()) {
//					mTPRegistrationCertificate.setPhone(MTPRegistrationRestDTO.getPhone());				
//					} else {
//					String Phone = "PhoneNo  field is Required";
//					condition = false;
//					message.append(Phone).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getEmail() != null) && !MTPRegistrationRestDTO.getEmail().isEmpty()) {
//					mTPRegistrationCertificate.setEmail(MTPRegistrationRestDTO.getEmail());				
//					} else {
//					String Email = "Email  field is Required";
//					condition = false;
//					message.append(Email).append(",");
//				}
//	
//	
//				if ((MTPRegistrationRestDTO.getCurrent_address() != null) && !MTPRegistrationRestDTO.getCurrent_address().isEmpty()) {
//					mTPRegistrationCertificate.setCurrent_address(MTPRegistrationRestDTO.getCurrent_address());				
//					} else {
//					String CurrentAddress = "CurrentAddress  field is Required";
//					condition = false;
//					message.append(CurrentAddress).append(",");
//				}
//	
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getPregnancy_termination() != null) && !MTPRegistrationRestDTO.getPregnancy_termination().isEmpty()) {
//					mTPRegistrationCertificate.setPregnancy_termination(MTPRegistrationRestDTO.getPregnancy_termination());				
//					} else {
//					String PregnancyTermination = "PregnancyTermination  field is Required";
//					condition = false;
//					message.append(PregnancyTermination).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getName_of_place() != null) && !MTPRegistrationRestDTO.getName_of_place().isEmpty()) {
//					mTPRegistrationCertificate.setName_of_place(MTPRegistrationRestDTO.getName_of_place());				
//					} else {
//					String Nameofplace = "Nameofplace  field is Required";
//					condition = false;
//					message.append(Nameofplace).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getInstitute_type() != null) && !MTPRegistrationRestDTO.getInstitute_type().isEmpty()) {
//					mTPRegistrationCertificate.setInstitute_type(MTPRegistrationRestDTO.getInstitute_type());				
//					} else {
//					String InstituteType = "InstituteType  field is Required";
//					condition = false;
//					message.append(InstituteType).append(",");
//				}
//	
//				
//				if ((MTPRegistrationRestDTO.getZoneNo() != null) && !MTPRegistrationRestDTO.getZoneNo().isEmpty()) {
//					mTPRegistrationCertificate.setZoneNo(MTPRegistrationRestDTO.getZoneNo());				
//					} else {
//					String ZoneNo = "ZoneNo  field is Required";
//					condition = false;
//					message.append(ZoneNo).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getState() != null) && !MTPRegistrationRestDTO.getState().isEmpty()) {
//					mTPRegistrationCertificate.setState(MTPRegistrationRestDTO.getState());				
//					} else {
//					String State = "State  field is Required";
//					condition = false;
//					message.append(State).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getCategory_b() != null) && !MTPRegistrationRestDTO.getCategory_b().isEmpty()) {
//					mTPRegistrationCertificate.setCategory_b(MTPRegistrationRestDTO.getCategory_b());				
//					} else {
//					String Category_b = "Category_b  field is Required";
//					condition = false;
//					message.append(Category_b).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getPhonee() != null) && !MTPRegistrationRestDTO.getPhonee().isEmpty()) {
//					mTPRegistrationCertificate.setPhonee(MTPRegistrationRestDTO.getPhonee());				
//					} else {
//					String PhoneNo = "PhoneNo  field is Required";
//					condition = false;
//					message.append(PhoneNo).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getHospital_name() != null) && !MTPRegistrationRestDTO.getHospital_name().isEmpty()) {
//					mTPRegistrationCertificate.setHospital_name(MTPRegistrationRestDTO.getHospital_name());				
//					} else {
//					String HospitalName = "HospitalName  field is Required";
//					condition = false;
//					message.append(HospitalName).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getEmail_id() != null) && !MTPRegistrationRestDTO.getEmail_id().isEmpty()) {
//					mTPRegistrationCertificate.setEmail_id(MTPRegistrationRestDTO.getEmail_id());				
//					} else {
//					String Email_id = "Email_id  field is Required";
//					condition = false;
//					message.append(Email_id).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getEmail_id() != null) && !MTPRegistrationRestDTO.getEmail_id().isEmpty()) {
//					mTPRegistrationCertificate.setEmail_id(MTPRegistrationRestDTO.getEmail_id());				
//					} else {
//					String Email_id = "Email_id  field is Required";
//					condition = false;
//					message.append(Email_id).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getFull_adrresss() != null) && !MTPRegistrationRestDTO.getFull_adrresss().isEmpty()) {
//					mTPRegistrationCertificate.setFull_adrresss(MTPRegistrationRestDTO.getFull_adrresss());				
//					} else {
//					String Full_adrresss = "Full_adrresss  field is Required";
//					condition = false;
//					message.append(Full_adrresss).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getInstitute_typee() != null) && !MTPRegistrationRestDTO.getInstitute_typee().isEmpty()) {
//					mTPRegistrationCertificate.setInstitute_typee(MTPRegistrationRestDTO.getInstitute_typee());				
//					} else {
//					String Institute_typee = "Institute_typee  field is Required";
//					condition = false;
//					message.append(Institute_typee).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getTotal_beds() != null) && !MTPRegistrationRestDTO.getTotal_beds().isEmpty()) {
//					mTPRegistrationCertificate.setTotal_beds(MTPRegistrationRestDTO.getTotal_beds());				
//					} else {
//					String Total_beds = "Total_beds  field is Required";
//					condition = false;
//					message.append(Total_beds).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getNumber_of_beds() != null) && !MTPRegistrationRestDTO.getNumber_of_beds().isEmpty()) {
//					mTPRegistrationCertificate.setNumber_of_beds(MTPRegistrationRestDTO.getNumber_of_beds());				
//					} else {
//					String Number_of_beds = "Number_of_beds  field is Required";
//					condition = false;
//					message.append(Number_of_beds).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getNursing() != null) && !MTPRegistrationRestDTO.getNursing().isEmpty()) {
//					mTPRegistrationCertificate.setNursing(MTPRegistrationRestDTO.getNursing());				
//					} else {
//					String Nursing = "Nursing  field is Required";
//					condition = false;
//					message.append(Nursing).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getDeliveries_conducted() != null) && !MTPRegistrationRestDTO.getDeliveries_conducted().isEmpty()) {
//					mTPRegistrationCertificate.setDeliveries_conducted(MTPRegistrationRestDTO.getDeliveries_conducted());				
//					} else {
//					String Deliveries_conducted = "Deliveries_conducted  field is Required";
//					condition = false;
//					message.append(Deliveries_conducted).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getGynecological_operation_conducted() != null) && !MTPRegistrationRestDTO.getGynecological_operation_conducted().isEmpty()) {
//					mTPRegistrationCertificate.setGynecological_operation_conducted(MTPRegistrationRestDTO.getGynecological_operation_conducted());				
//					} else {
//					String Gynecological_operation_conducted = "Gynecological_operation_conducted  field is Required";
//					condition = false;
//					message.append(Gynecological_operation_conducted).append(",");
//				}
//				
//				if ((MTPRegistrationRestDTO.getMedical_practitioner_experience() != null) && !MTPRegistrationRestDTO.getMedical_practitioner_experience().isEmpty()) {
//					mTPRegistrationCertificate.setMedical_practitioner_experience(MTPRegistrationRestDTO.getMedical_practitioner_experience());				
//					} else {
//					String Medical_practitioner_experience = "Medical_practitioner_experience  field is Required";
//					condition = false;
//					message.append(Medical_practitioner_experience).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getFull_time_ssisted_workingnursing_patients() != null) && !MTPRegistrationRestDTO.getFull_time_ssisted_workingnursing_patients().isEmpty()) {
//					mTPRegistrationCertificate.setFull_time_ssisted_workingnursing_patients(MTPRegistrationRestDTO.getFull_time_ssisted_workingnursing_patients());				
//					} else {
//					String Full_time_ssisted_workingnursing_patients = "Full_time_ssisted_workingnursing_patients  field is Required";
//					condition = false;
//					message.append(Full_time_ssisted_workingnursing_patients).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getFacilities_available() != null) && !MTPRegistrationRestDTO.getFacilities_available().isEmpty()) {
//					mTPRegistrationCertificate.setFacilities_available(MTPRegistrationRestDTO.getFacilities_available());				
//					} else {
//					String Facilities_available = "Facilities_available  field is Required";
//					condition = false;
//					message.append(Facilities_available).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getOperationTableAndInstruments() != null) && !MTPRegistrationRestDTO.getOperationTableAndInstruments().isEmpty()) {
//					mTPRegistrationCertificate.setOperationTableAndInstruments(MTPRegistrationRestDTO.getOperationTableAndInstruments());				
//					} else {
//					String OperationTableAndInstruments = "OperationTableAndInstruments  field is Required";
//					condition = false;
//					message.append(OperationTableAndInstruments).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getDrugsAndParacetamol() != null) && !MTPRegistrationRestDTO.getDrugsAndParacetamol().isEmpty()) {
//					mTPRegistrationCertificate.setDrugsAndParacetamol(MTPRegistrationRestDTO.getDrugsAndParacetamol());			
//					} else {
//					String DrugsAndParacetamol = "DrugsAndParacetamol  field is Required";
//					condition = false;
//					message.append(DrugsAndParacetamol).append(",");
//				}
//				
//			
//				
//				if ((MTPRegistrationRestDTO.getAnestheticEquipments() != null) && !MTPRegistrationRestDTO.getAnestheticEquipments().isEmpty()) {
//					mTPRegistrationCertificate.setAnestheticEquipments(MTPRegistrationRestDTO.getAnestheticEquipments());			
//					} else {
//					String AnestheticEquipments = "AnestheticEquipments  field is Required";
//					condition = false;
//					message.append(AnestheticEquipments).append(",");
//				}
//				
//			
//				
//				if ((MTPRegistrationRestDTO.getOxygenCylinder() != null) && !MTPRegistrationRestDTO.getOxygenCylinder().isEmpty()) {
//					mTPRegistrationCertificate.setOxygenCylinder(MTPRegistrationRestDTO.getOxygenCylinder());			
//					} else {
//					String OxygenCylinder = "OxygenCylinder  field is Required";
//					condition = false;
//					message.append(OxygenCylinder).append(",");
//				}
//				
//				
//				
//				if ((MTPRegistrationRestDTO.getBloodBankRegistration() != null) && !MTPRegistrationRestDTO.getBloodBankRegistration().isEmpty()) {
//					mTPRegistrationCertificate.setBloodBankRegistration(MTPRegistrationRestDTO.getBloodBankRegistration());			
//					} else {
//					String BloodBankRegistration = "BloodBankRegistration  field is Required";
//					condition = false;
//					message.append(BloodBankRegistration).append(",");
//				}
//				
//			
//				
//				if ((MTPRegistrationRestDTO.getHsptl_ambulance() != null) && !MTPRegistrationRestDTO.getHsptl_ambulance().isEmpty()) {
//					mTPRegistrationCertificate.setHsptl_ambulance(MTPRegistrationRestDTO.getHsptl_ambulance());			
//					} else {
//					String Hsptl_ambulance = "Hsptl_ambulance  field is Required";
//					condition = false;
//					message.append(Hsptl_ambulance).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getPlace() != null) && !MTPRegistrationRestDTO.getPlace().isEmpty()) {
//					mTPRegistrationCertificate.setPlace(MTPRegistrationRestDTO.getPlace());			
//					} else {
//					String Place = "Place  field is Required";
//					condition = false;
//					message.append(Place).append(",");
//				}
//				
//				
//				if ((MTPRegistrationRestDTO.getDate_of_patients() != null) && !MTPRegistrationRestDTO.getDate_of_patients().isEmpty()) {
//					mTPRegistrationCertificate.setDate_of_patients(MTPRegistrationRestDTO.getDate_of_patients());			
//					} else {
//					String Date_of_patients = "Date_of_patients  field is Required";
//					condition = false;
//					message.append(Date_of_patients).append(",");
//				}
//				
//			//files
//				
//				
//				
//				
//				MTPRegistrationRestDTO.setGynacoligistDegreeCertificatepdf(MTPRegistrationRestDTO.getGynacoligistDegreeCertificatepdf());
//				MTPRegistrationRestDTO.setAdditionalQualificationCertificatepdf(MTPRegistrationRestDTO.getAdditionalQualificationCertificatepdf());
//				MTPRegistrationRestDTO.setMmcpdf(MTPRegistrationRestDTO.getMmcpdf());
//				MTPRegistrationRestDTO.setAffidivantpdf(MTPRegistrationRestDTO.getAffidivantpdf());
//				MTPRegistrationRestDTO.setAnesthicdegreee(MTPRegistrationRestDTO.getAnesthicdegreee());
//				MTPRegistrationRestDTO.setAnnesthicadditionalQualificationCertificatepdf(MTPRegistrationRestDTO.getAnnesthicadditionalQualificationCertificatepdf());
//				MTPRegistrationRestDTO.setAnnesthicmmcpdf(MTPRegistrationRestDTO.getAnnesthicmmcpdf());
//			MTPRegistrationRestDTO.setAnnesthicaffidivantpdf(MTPRegistrationRestDTO.getAnnesthicaffidivantpdf());
//			MTPRegistrationRestDTO.setBiomedicalpdf(MTPRegistrationRestDTO.getBiomedicalpdf());
//			MTPRegistrationRestDTO.setMaharastrapollutionpdf(MTPRegistrationRestDTO.getMaharastrapollutionpdf());
//			MTPRegistrationRestDTO.setHospitalmmcpdf(MTPRegistrationRestDTO.getHospitalmmcpdf());
//			MTPRegistrationRestDTO.setHospitalaffidivantpdf(MTPRegistrationRestDTO.getHospitalaffidivantpdf());
//			MTPRegistrationRestDTO.setUndertakingpdf(MTPRegistrationRestDTO.getUndertakingpdf());
//			MTPRegistrationRestDTO.setNursinghomepdf(MTPRegistrationRestDTO.getNursinghomepdf());
//			MTPRegistrationRestDTO.setBloodbankpdf(MTPRegistrationRestDTO.getBloodbankpdf());
//			MTPRegistrationRestDTO.setOtswabpdf(MTPRegistrationRestDTO.getOtswabpdf());	
//			
//				
//				
//				String savedFilePath = MTPRegistrationRestController.saveFile(files,
//						request);
//				
//				
//				
//				RTIApplication rtiApplication = new RTIApplication();
//				if (MTPRegistrationRestDTO.getUserMobileNumber() != 0) {
//					rtiApplication.setMobileNumber(String.valueOf(MTPRegistrationRestDTO.getUserMobileNumber()));
//				} else {
//					String userMobilenumber = "User Mobile Number field is Required";
//					condition = false;
//					message.append(userMobilenumber).append(",");
//				}
//				if (condition) {
//					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
//					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
//					rtiApplication.setSubject("MTP-REGISTRATION-CERTIFICATE");
//					rtiApplication.setDepartment("HEALTH-DEPARTMENT");
//					rtiApplication.setTemplateName("HEALTH-DEPARTMENT");
//					rtiApplication.setWorkFlowStatus(0);
//					rtiApplication.setFinalStatus("0");
//					rtiApplication.setRtiserviceid(1);
//					rtiApplication.setApplicantName(mTPRegistrationCertificate.getFullnamee() + " "
//							+ mTPRegistrationCertificate.getMiddle_name() + " "
//							+ mTPRegistrationCertificate.getLast_name());
//					rtiApplication.setPhoneNumber(mTPRegistrationCertificate.getPhone());
//					rtiApplication.setMobileNumber(mTPRegistrationCertificate.getPhonee());
//					rtiApplication.setZone(mTPRegistrationCertificate.getZoneNo());
//					rtiApplication.setPdfUploadFromPortal(savedFilePath);
//					rtiApplication.setEmail(mTPRegistrationCertificate.getEmail());
//
//			
//
//					rtiApplication.setApplicantName(mTPRegistrationCertificate.getFull_name());
//					List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
//					RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();
//
//					rtiApplicationDetails.setRtiApplication(rtiApplication);
//					rtiApplicationDetails.setStatus(0);
//					rtiApplicationDetails.setAssignToStatus(1);
//					rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
//					rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
//
//					rtiApplicationDetails.setComments("Form Submitted");// ();
//					rtiApplicationDetails.setWorkflowLevel(0);
//					rtiApplicationDetailsList.add(rtiApplicationDetails);
//					rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
//					RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
//					
//					if (savedRti.getRtiApplicationId() > 0) {
//						RTIApplication rti = rtiApplicationService.
//								get(savedRti.getRtiApplicationId());
//						rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/"
//								+ savedRti.getRtiApplicationId());
//						mTPRegistrationCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
//						mTPRegistrationCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
//						long birth_regis_id = mTPRegistrationCertificateService
//								.mTPRegistrationCertificate(mTPRegistrationCertificate);
//						rti.setRtiApplicationRefId(birth_regis_id);
//						// rti.setRtiApplicationRefId(birthRegistrationService.);
//						RTIApplication retunRti = rtiApplicationService.merge(rti);
//						
//						if ((retunRti != null) && (birth_regis_id > 0)) {
//							MTPRegistrationRestDTO.setResponseStatus(
//									"Requested data saved successfully");
//							MTPRegistrationRestDTO
//									.setResult(retunRti.getRtiApplnNumber());
//							MTPRegistrationRestDTO.setResponseCode(HttpStatus.OK.value());
//							reponse.setStatus(HttpStatus.OK.value());
//							MTPRegistrationRestDTO.setAdditionalQualificationCertificatepdf("");
//							MTPRegistrationRestDTO.setAffidivantpdf("");
//							MTPRegistrationRestDTO.setAnestheticEquipments("");
//							MTPRegistrationRestDTO.setAnesthetists_nursing_patients("");
//							MTPRegistrationRestDTO.setAnesthicdegreee("");
//							MTPRegistrationRestDTO.setAnnesthicadditionalQualificationCertificatepdf("");
//							MTPRegistrationRestDTO.setAnnesthicaffidivantpdf("");
//							MTPRegistrationRestDTO.setAnnesthicmmcpdf("");
//							MTPRegistrationRestDTO.setBiomedicalpdf("");
//							MTPRegistrationRestDTO.setBloodbankpdf("");
//							MTPRegistrationRestDTO.setBloodBankRegistration("");
//							MTPRegistrationRestDTO.setCategory_b("");
//							MTPRegistrationRestDTO.setGynacoligistDegreeCertificatepdf("");
//							MTPRegistrationRestDTO.setHospitalaffidivantpdf("");
//							MTPRegistrationRestDTO.setHospitalmmcpdf("");
//							MTPRegistrationRestDTO.setMaharastrapollutionpdf("");
//							MTPRegistrationRestDTO.setMmcpdf("");
//							MTPRegistrationRestDTO.setUndertakingpdf("");
//							MTPRegistrationRestDTO.setStatus("ok");
//							
//						}
//						String name = mTPRegistrationCertificate.getFull_name() + mTPRegistrationCertificate.getMiddle_name()
//						+ mTPRegistrationCertificate.getLast_name();
//				String applnNo = rti.getRtiApplnNumber();
//
//				String msg = "Dear " + name + " your application with Application No. " + applnNo
//						+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
//				msg.replace("var3", "");
//				SendEmail.sendEmail(mTPRegistrationCertificate.getEmail(),
//						"Application Submitted Successfully" + applnNo, msg);
//				SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", String.valueOf(mTPRegistrationCertificate.getPhone()),
//						msg);
//			}
//		}
//				if (!condition) {
//					if (message.charAt(message.length() - 1) == ',') {
//						message.deleteCharAt(message.length() - 1);
//						MTPRegistrationRestDTO.setResult(message.toString());
//						MTPRegistrationRestDTO.setResponseStatus("Requested data not saved successfully");
//						MTPRegistrationRestDTO.setAdditionalQualificationCertificatepdf("");
//						MTPRegistrationRestDTO.setAffidivantpdf("");
//						MTPRegistrationRestDTO.setAnestheticEquipments("");
//						MTPRegistrationRestDTO.setAnesthetists_nursing_patients("");
//						MTPRegistrationRestDTO.setAnesthicdegreee("");
//						MTPRegistrationRestDTO.setAnnesthicadditionalQualificationCertificatepdf("");
//						MTPRegistrationRestDTO.setAnnesthicaffidivantpdf("");
//						MTPRegistrationRestDTO.setAnnesthicmmcpdf("");
//						MTPRegistrationRestDTO.setBiomedicalpdf("");
//						MTPRegistrationRestDTO.setBloodbankpdf("");
//						MTPRegistrationRestDTO.setBloodBankRegistration("");
//						MTPRegistrationRestDTO.setCategory_b("");
//						MTPRegistrationRestDTO.setGynacoligistDegreeCertificatepdf("");
//						MTPRegistrationRestDTO.setHospitalaffidivantpdf("");
//						MTPRegistrationRestDTO.setHospitalmmcpdf("");
//						MTPRegistrationRestDTO.setMaharastrapollutionpdf("");
//						MTPRegistrationRestDTO.setMmcpdf("");
//						MTPRegistrationRestDTO.setUndertakingpdf("");
//						MTPRegistrationRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//						MTPRegistrationRestDTO.setStatus("Internal Server Error");
//					}
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				log.equals(ex.getMessage());
//				MTPRegistrationRestDTO.setResponseStatus(ex.getMessage());
//				MTPRegistrationRestDTO.setAdditionalQualificationCertificatepdf("");
//				MTPRegistrationRestDTO.setAffidivantpdf("");
//				MTPRegistrationRestDTO.setAnestheticEquipments("");
//				MTPRegistrationRestDTO.setAnesthetists_nursing_patients("");
//				MTPRegistrationRestDTO.setAnesthicdegreee("");
//				MTPRegistrationRestDTO.setAnnesthicadditionalQualificationCertificatepdf("");
//				MTPRegistrationRestDTO.setAnnesthicaffidivantpdf("");
//				MTPRegistrationRestDTO.setAnnesthicmmcpdf("");
//				MTPRegistrationRestDTO.setBiomedicalpdf("");
//				MTPRegistrationRestDTO.setBloodbankpdf("");
//				MTPRegistrationRestDTO.setBloodBankRegistration("");
//				MTPRegistrationRestDTO.setCategory_b("");
//				MTPRegistrationRestDTO.setGynacoligistDegreeCertificatepdf("");
//				MTPRegistrationRestDTO.setHospitalaffidivantpdf("");
//				MTPRegistrationRestDTO.setHospitalmmcpdf("");
//				MTPRegistrationRestDTO.setMaharastrapollutionpdf("");
//				MTPRegistrationRestDTO.setMmcpdf("");
//				MTPRegistrationRestDTO.setUndertakingpdf("");
//				MTPRegistrationRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
//				reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//				MTPRegistrationRestDTO.setStatus("Method not Allowed");
//				}
//		}
//			return MTPRegistrationRestDTO;
//		}
//		
//	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
//		String filesPath = null;
//		StringBuilder filesPathBuilder = new StringBuilder();
//		String baseDir = CoreConstants.UPLOAD_PATH + "mTPRegistrationCertificate";
//		File file = new File(baseDir);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		if (data != null) {
//			for (String element : data) {
//				if (element != null) {
//					byte[] pdfBytes = Base64.getDecoder().decode(element);
//					String fileName;
//					String uniqueFileName = UUID.randomUUID().toString().substring(0, 8) + ".pdf";
//					int l = uniqueFileName.lastIndexOf(".");
//					String imageext = uniqueFileName.substring(l, uniqueFileName.length());
//					fileName = uniqueFileName.substring(0, l);
//					fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
//					fileName = fileName.replaceAll("\\W", "");
//					fileName = fileName + "" + imageext;
//					File storeFile = new File(baseDir, fileName);
//					try (FileOutputStream outputStream = new FileOutputStream(storeFile)) {
//						outputStream.write(pdfBytes);
//						outputStream.flush();
//						outputStream.close();
//					}
//					filesPath = baseDir + File.separator + fileName;
//					filesPathBuilder.append(filesPath).append(",");
//				} else {
//					filesPathBuilder.append("null").append(",");
//
//				}
//			}
//		} else {
//			filesPathBuilder.append("null").append(",");
//		}
//		if (filesPathBuilder != null) {
//			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
//				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
//			}
//			filesPath = filesPathBuilder.toString();
//		}
//		return filesPath;
//	}
//}
