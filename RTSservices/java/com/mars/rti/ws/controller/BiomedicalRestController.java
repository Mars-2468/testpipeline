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
//import com.mars.common.model.UserRegistrationDetails;
//import com.mars.common.utils.CommonUtils;
//import com.mars.common.utils.SendEmail;
//import com.mars.common.utils.SendSMS;
//import com.mars.rti.model.BiologicalWasteDisposal;
//import com.mars.rti.model.RTIApplication;
//import com.mars.rti.model.RTIApplicationDetails;
//import com.mars.rti.service.BiologicalWasteService;
//import com.mars.rti.service.RTIApplicationService;
//import com.mars.rti.utils.CoreConstants;
//import com.mars.rti.ws.model.BiomedicalRestDTO;
//
//@Controller
//
//public class BiomedicalRestController {
//	
//	
//	private static Log log = LogFactory.getLog(BiomedicalRestController.class);
//
//	@Autowired
//	private RTIApplicationService rtiApplicationService;
//
//	@Autowired
//	private BiologicalWasteService biologicalWasteDisposalService;
//	
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/saveBiomedicalApplication")
//	public @ResponseBody BiomedicalRestDTO saveBiomedicalApplication(
//			@RequestBody BiomedicalRestDTO biomedicalRestDTO, HttpServletRequest request,
//			HttpServletResponse reponse) throws ServletException {
//		boolean condition = true;
//		StringBuilder message = new StringBuilder();
//		String[] files = new String[6];
//
//		UserRegistrationDetails user = new UserRegistrationDetails();
//
//		if (log.isDebugEnabled()) {
//			log.debug("Invoking saveBiomedicalApplication");
//		}
//		BiologicalWasteDisposal biologicalWasteDisposal = new BiologicalWasteDisposal();
//		
//		try {
//			if (biomedicalRestDTO.getTitle() != null
//					&& !biomedicalRestDTO.getTitle().isEmpty()) {
//				biologicalWasteDisposal.setTitle(biomedicalRestDTO.getTitle());
//			} else {
//				String applicantTitle = "Title field is Required";
//				condition = false;
//				message.append(applicantTitle).append(",");
//			}
//			
//			if (biomedicalRestDTO.getFirstName() != null
//					&& !biomedicalRestDTO.getFirstName().isEmpty()) {
//				biologicalWasteDisposal.setFirstName(biomedicalRestDTO.getFirstName());
//			} else {
//				String applicantFirstName = "Name field is Required";
//				condition = false;
//				message.append(applicantFirstName).append(",");
//			}
//			biologicalWasteDisposal.setMiddleName(biomedicalRestDTO.getMiddleName());
//
//			
//			if (biomedicalRestDTO.getLastName() != null
//					&& !biomedicalRestDTO.getLastName().isEmpty()) {
//				biologicalWasteDisposal.setLastName(biomedicalRestDTO.getLastName());
//			} else {
//				String applicantLastName = "Surname field is Required";
//				condition = false;
//				message.append(applicantLastName).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getEmail() != null && !biomedicalRestDTO.getEmail().isEmpty()) {
//				biologicalWasteDisposal.setEmail(biomedicalRestDTO.getEmail());
//			} else {
//				String email = "Email field is Required";
//				condition = false;
//				message.append(email).append(",");
//			}
//			if (biomedicalRestDTO.getMobileNo() != 0) {
//				biologicalWasteDisposal.setMobile((String.valueOf(biomedicalRestDTO.getMobileNo())));
//			} else {
//				String mobileNo = "MobileNo. field is Required";
//				condition = false;
//				message.append(mobileNo).append(",");
//
//			}
//			
//			
//			
//			if (biomedicalRestDTO.getEducation() != null && !biomedicalRestDTO.getEmail().isEmpty()) {
//				biologicalWasteDisposal.setEducation(biomedicalRestDTO.getEducation());
//			} else {
//				String education = "Education field is Required";
//				condition = false;
//				message.append(education).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getHospitalName() != null && !biomedicalRestDTO.getHospitalName().isEmpty()) {
//				biologicalWasteDisposal.setHospitalName(biomedicalRestDTO.getHospitalName());
//			} else {
//				String hospitalname = "hospitalname field is Required";
//				condition = false;
//				message.append(hospitalname).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getHospitalAddress() != null && !biomedicalRestDTO.getHospitalAddress().isEmpty()) {
//				biologicalWasteDisposal.setHospitalAddress(biomedicalRestDTO.getHospitalAddress());
//			} else {
//				String hospitalAddress = "HospitalAddress field is Required";
//				condition = false;
//				message.append(hospitalAddress).append(",");
//			}
//			
//			
//			
//			
//			
//			if (biomedicalRestDTO.getMedicalProfessionType() != null && !biomedicalRestDTO.getMedicalProfessionType().isEmpty()) {
//				biologicalWasteDisposal.setMedicalProfessionType(biomedicalRestDTO.getMedicalProfessionType());
//			} else {
//				String medicalProfessionType = "MedicalProfessionType field is Required";
//				condition = false;
//				message.append(medicalProfessionType).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getNumberOfBeds() != 0) {
//				biologicalWasteDisposal.setNumberOfBeds(biomedicalRestDTO.getNumberOfBeds());
//			} else {
//				String numberOfBeds = "NumberOfBeds. field is Required";
//				condition = false;
//				message.append(numberOfBeds).append(",");
//
//			}
//			
//			
//			if (biomedicalRestDTO.getMedicalCouncilRegNumber() != null && !biomedicalRestDTO.getMedicalCouncilRegNumber().isEmpty()) {
//				biologicalWasteDisposal.setMedicalCouncilRegNumber(biomedicalRestDTO.getMedicalCouncilRegNumber());
//			} else {
//				String medicalCouncilRegNumber = "MedicalCouncilRegNumber field is Required";
//				condition = false;
//				message.append(medicalCouncilRegNumber).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getOtherProfessionalsDetails() != null && !biomedicalRestDTO.getOtherProfessionalsDetails().isEmpty()) {
//				biologicalWasteDisposal.setOtherProfessionalsDetails(biomedicalRestDTO.getOtherProfessionalsDetails());
//			} else {
//				String otherProfessionalsDetails = "OtherProfessionalsDetails field is Required";
//				condition = false;
//				message.append(otherProfessionalsDetails).append(",");
//			}
//			
//			
//			
//			if (biomedicalRestDTO.getBiologicalWasteDescription() != null && !biomedicalRestDTO.getBiologicalWasteDescription().isEmpty()) {
//				biologicalWasteDisposal.setBiologicalWasteDescription(biomedicalRestDTO.getBiologicalWasteDescription());
//			} else {
//				String biologicalWasteDescription = "BiologicalWasteDescription field is Required";
//				condition = false;
//				message.append(biologicalWasteDescription).append(",");
//			}
//			
//			
//			if (biomedicalRestDTO.getOtherDegree() != null && !biomedicalRestDTO.getOtherDegree().isEmpty()) {
//				biologicalWasteDisposal.setOtherDegree(biomedicalRestDTO.getOtherDegree());
//			} else {
//				String otherDegree = "OtherDegree field is Required";
//				condition = false;
//				message.append(otherDegree).append(",");
//			}
//
//			
//			if (biomedicalRestDTO.getZoneNo() != null && !biomedicalRestDTO.getZoneNo().isEmpty()) {
//				biologicalWasteDisposal.setZoneNo(biomedicalRestDTO.getZoneNo());
//			} else {
//				String zoneNo = "zoneNo field is Required";
//				condition = false;
//				message.append(zoneNo).append(",");
//			}
//			
//			//files
//			
//			String doc1 = biomedicalRestDTO
//					.getRent_agreement_file();
//
//			files[0] = doc1;
//			if (biomedicalRestDTO
//					.getRent_agreement_file() != null
//					&& !biomedicalRestDTO
//							.getRent_agreement_file()
//							.isEmpty()) {
//				String doc2 = biomedicalRestDTO
//						.getRent_agreement_file();
//
//				files[1] = doc2;
//			} else {
//				String doc2 = "Rent Agreement field is Required";
//				condition = false;
//				message.append(doc2).append(",");
//			}
//
//			if (biomedicalRestDTO.getDegree_certificate_file() != null
//					&& !biomedicalRestDTO.getDegree_certificate_file().isEmpty()) {
//				String doc3 = biomedicalRestDTO.getDegree_certificate_file();
//
//				files[2] = doc3;
//			} else {
//				String doc3 = "Degree Certificate is Required";
//				condition = false;
//				message.append(doc3).append(",");
//			}
//
//			if (biomedicalRestDTO.getCurrent_prop_tax_file() != null
//					&& !biomedicalRestDTO.getCurrent_prop_tax_file().isEmpty()) {
//				String doc4 = biomedicalRestDTO.getCurrent_prop_tax_file();
//				files[3] = doc4;
//			} else {
//				String doc4 = "Current_prop_tax_file field is Required";
//				condition = false;
//				message.append(doc4).append(",");
//			}
//
//			
//			if (biomedicalRestDTO.getCouncil_register_file() != null
//					&& !biomedicalRestDTO.getCouncil_register_file().isEmpty()) {
//				String doc5 = biomedicalRestDTO.getCouncil_register_file();
//				files[4] = doc5;
//			} else {
//				String doc5 = "Council_register_file field is Required";
//				condition = false;
//				message.append(doc5).append(",");
//			}
//
//			
//			if (biomedicalRestDTO.getAadhaar_card_file() != null
//					&& !biomedicalRestDTO.getAadhaar_card_file().isEmpty()) {
//				String doc6 = biomedicalRestDTO.getAadhaar_card_file();
//				files[5] = doc6;
//			} else {
//				String doc6 = "Aadhaar_card_file field is Required";
//				condition = false;
//				message.append(doc6).append(",");
//			}
//			
//			RTIApplication rtiApplication = new RTIApplication();
//
//			if (biomedicalRestDTO.getUserMobileNumber() !=0) {
//				rtiApplication.setMobileAppUserNumber(String.valueOf(biomedicalRestDTO.getUserMobileNumber()));
//				} else {
//				String userMobilenumber = "User Mobile Number field is Required";
//				condition = false;
//				message.append(userMobilenumber).append(",");
//			}
//			String savedFilePath = BiomedicalRestController
//					.saveFile(files, request);
//			if (condition) {
//				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setSubject("BIOMEDICAL-CERTIFICATE");
//				rtiApplication.setTemplateName("biomedicalApplication");
//				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
//				rtiApplication.setWorkFlowStatus(0);
//				rtiApplication.setFinalStatus("0");
//				rtiApplication.setRtiserviceid(2);
//				//rtiApplication.setUserRegistrationDetails(user);
//				rtiApplication.setApplicantName(biologicalWasteDisposal.getLastName());
//				rtiApplication.setPhoneNumber(biologicalWasteDisposal.getMobile());
//				rtiApplication.setMobileNumber(biologicalWasteDisposal.getMobile());
//				rtiApplication.setEmail(biologicalWasteDisposal.getEmail());
//				rtiApplication.setPdfUploadFromPortal(savedFilePath);
//				rtiApplication.setZone(biologicalWasteDisposal.getZoneNo());
//				
//				
//				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
//				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();
//
//				rtiApplicationDetails.setRtiApplication(rtiApplication);
//				rtiApplicationDetails.setStatus(0);
//				rtiApplicationDetails.setAssignToStatus(1);
//				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
//				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
//				
//				rtiApplicationDetails.setComments("Form Submitted");// ();
//				rtiApplicationDetails.setWorkflowLevel(0);
//				rtiApplicationDetailsList.add(rtiApplicationDetails);
//				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
//				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
//				
//				if (savedRti.getRtiApplicationId() > 0) {
//					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
//					rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
//					biologicalWasteDisposal.setRtiapplrefno(rti.getRtiApplnNumber());
//					biologicalWasteDisposal.setRti_ref_id(savedRti.getRtiApplicationId());
//					long death_regis_id = biologicalWasteDisposalService.BiologicalWasteDisposal(biologicalWasteDisposal);
//					rti.setRtiApplicationRefId(death_regis_id);
//					RTIApplication retunRti = rtiApplicationService.merge(rti);
//					
//					if ((retunRti != null) && (death_regis_id > 0)) {
//						biomedicalRestDTO.setResponseStatus("Requested data saved successfully");
//						biomedicalRestDTO.setResult(retunRti.getRtiApplnNumber());
//						biomedicalRestDTO.setResponseCode(HttpStatus.OK.value());
//				reponse.setStatus(HttpStatus.OK.value());
//				biomedicalRestDTO.setAadhaar_card_file("");
//				biomedicalRestDTO.setCouncil_register_file("");
//				biomedicalRestDTO.setCurrent_prop_tax_file("");
//				biomedicalRestDTO.setDegree_certificate_file("");
//				biomedicalRestDTO.setRent_agreement_file("");
//			
//				biomedicalRestDTO.setStatus("ok");
//					}
//					String name = biologicalWasteDisposal.getLastName() + biologicalWasteDisposal.getLastName()
//							+ biologicalWasteDisposal.getLastName();
//					String applnNo = rti.getRtiApplnNumber();
//
//					String msg = "Dear " + name
//							+ " your application with Application No. "
//							+ applnNo
//							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
//					msg.replace("var3", "");
//					SendEmail.sendEmail(biologicalWasteDisposal.getEmail(),
//							"Application Submitted Successfully" + applnNo,
//							msg);
//					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov",
//							biologicalWasteDisposal.getMobile(), msg);	
//					}
//			}
//
//			
//			if (!condition) {
//				if (message.charAt(message.length() - 1) == ',') {
//					message.deleteCharAt(message.length() - 1);
//					biomedicalRestDTO.setResult(message.toString());
//					biomedicalRestDTO.setResponseStatus("Requested data not saved successfully");
//					biomedicalRestDTO.setAadhaar_card_file("");
//					biomedicalRestDTO.setCouncil_register_file("");
//					biomedicalRestDTO.setCurrent_prop_tax_file("");
//					biomedicalRestDTO.setDegree_certificate_file("");
//					biomedicalRestDTO.setRent_agreement_file("");
//				
//					biomedicalRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//					biomedicalRestDTO.setStatus("Internal Server Error");
//					
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.error(ex.getMessage());
//			biomedicalRestDTO.setResponseStatus(ex.getMessage());
//			biomedicalRestDTO.setAadhaar_card_file("");
//			biomedicalRestDTO.setCouncil_register_file("");
//			biomedicalRestDTO.setCurrent_prop_tax_file("");
//			biomedicalRestDTO.setDegree_certificate_file("");
//			biomedicalRestDTO.setRent_agreement_file("");
//
//			biomedicalRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
//			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//			biomedicalRestDTO.setStatus("Method not Allowed");
//			}
//		return biomedicalRestDTO;
//	}
//			
//	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
//		String filesPath = null;
//		StringBuilder filesPathBuilder = new StringBuilder();
//		String baseDir = CoreConstants.UPLOAD_PATH + "biologicalWasteDisposal";
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
