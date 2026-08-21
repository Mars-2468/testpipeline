//package com.mars.rti.ws.controller;
//
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
//import com.mars.rti.model.NursingHomeChangesApplication;
//import com.mars.rti.model.RTIApplication;
//import com.mars.rti.model.RTIApplicationDetails;
//import com.mars.rti.service.NursingHomeChangesApplicationService;
//import com.mars.rti.service.RTIApplicationService;
//import com.mars.rti.utils.CoreConstants;
//import com.mars.rti.ws.model.ChangeInNoOfBedsDTO;
//
//@Controller
//public class ChangeInNoOfBedsController {
//
//	
//	private static Log log = LogFactory.getLog(ChangeInNoOfBedsController.class);
//	@Autowired
//	private RTIApplicationService rtiApplicationService;
//	
//	@Autowired
//	private NursingHomeChangesApplicationService nursingHomeChangesApplicationService;
//	
//	@RequestMapping(method = RequestMethod.POST, value ="/saveChangeInNumberOfBedsApplication")
//	public @ResponseBody ChangeInNoOfBedsDTO saveChangeInNumberOfBedsApplication(@RequestBody ChangeInNoOfBedsDTO changeInNoOfBedsDTO,HttpServletRequest request,HttpServletResponse response)throws ServletException{
//		if (log.isDebugEnabled()) {
//			log.debug("Invoking saveZoneApplication");
//		}
//		boolean condition = true;
//		StringBuilder message = new StringBuilder();
//		String[] files = new String[6];
//		NursingHomeChangesApplication nhca = new NursingHomeChangesApplication();
//	
//		try{
//			
//			if(changeInNoOfBedsDTO.getNursingHomeOwner()!=null && !changeInNoOfBedsDTO.getNursingHomeOwner().isEmpty()) {
//				nhca.setNursingHomeOwner(changeInNoOfBedsDTO.getNursingHomeOwner());
//				
//			}else {
//				String ownername="Nursing Home Owner Name Field is required";
//				condition=false;
//				message.append(ownername).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getHospitalAddress()!=null && !changeInNoOfBedsDTO.getHospitalAddress().isEmpty()) {
//				nhca.setHospitalAddress(changeInNoOfBedsDTO.getHospitalAddress());
//			}else {
//				String hospitaladdress="Hospital Address filed is required";
//				condition=false;
//				message.append(hospitaladdress).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getNursingHomeRegNumber()!=null && !changeInNoOfBedsDTO.getNursingHomeOwner().isEmpty()) {
//				nhca.setNursingHomeRegNumber(changeInNoOfBedsDTO.getNursingHomeRegNumber());
//			}else {
//				String regnumber="Home Registration Number Field is required";
//				condition=false;
//				message.append(regnumber).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getSanctionedBedMaternity()>0) {
//				nhca.setSanctionedBedMaternity(String.valueOf(changeInNoOfBedsDTO.getSanctionedBedMaternity()));
//
//			}else {
//				String sanctionedMaternity = "Sanctioned Maternity Beds Field is required";
//				condition=false;
//				message.append(sanctionedMaternity).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getSanctionedBedOther()>0) {
//				nhca.setSanctionedBedOther(String.valueOf(changeInNoOfBedsDTO.getSanctionedBedOther()));
//			}else {
//				String sactionedBedOther="Nusrsing Patients Beds Field is required";
//				condition=false;
//				message.append(sactionedBedOther).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getMobile()>0) {
//				nhca.setMobile(String.valueOf(changeInNoOfBedsDTO.getMobile()));
//			}else {
//				String mobileNo="Mobile Number field is required";
//				condition=false;
//				message.append(mobileNo).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getChangeBedMaternity()>0) {
//				nhca.setChangeBedMaternity(String.valueOf(changeInNoOfBedsDTO.getChangeBedMaternity()));
//			}else {
//				String changeBedMaternity="Change in Maternity Beds field is reuired";
//				condition=false;
//				message.append(changeBedMaternity).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getChangeBedOther()>0) {
//				nhca.setChangeBedOther(String.valueOf(changeInNoOfBedsDTO.getChangeBedOther()));
//			
//			}else {
//				String changeInBedsOther="Change in nursing patient beds field is reuqired";
//				condition=false;
//				message.append(changeInBedsOther).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getChangeOwnerName()!=null && !changeInNoOfBedsDTO.getChangeOwnerName().isEmpty()) {
//				nhca.setChangeOwnerName(changeInNoOfBedsDTO.getChangeOwnerName());
//			}else {
//				
//				String changedOwneeName="Change in Owner Name field is required";
//				condition=false;
//				message.append(changedOwneeName).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getZoneNo()>0) {
//				nhca.setZoneNo(String.valueOf(changeInNoOfBedsDTO.getZoneNo()));
//				
//			}else {
//				String zoneno= "Zone No. filed is required";
//			    condition=false;
//			    message.append(zoneno).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getFees()>0 || changeInNoOfBedsDTO.getFees()>0.0) {
//				nhca.setFees(changeInNoOfBedsDTO.getFees());
//			}else {
//				String fees="Fees field is required";
//				condition=false;
//				message.append(fees).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getDegreeCertificate()!=null && !changeInNoOfBedsDTO.getDegreeCertificate().isEmpty()) {
//				files[0]=changeInNoOfBedsDTO.getDegreeCertificate();
//			}else {
//				String degreeCertificate="Degree certificate field is required";
//				condition=false;
//				message.append(degreeCertificate).append(",");
//			}
//			
//			
//			if(changeInNoOfBedsDTO.getMmcCertificate()!=null && !changeInNoOfBedsDTO.getMmcCertificate().isEmpty()) {
//				files[1]=changeInNoOfBedsDTO.getMmcCertificate();
//			}else {
//				String mmcertificate="M.M.C Certificate filed is rrequired";
//				condition=false;
//				message.append(mmcertificate).append(",");
//				
//			}
//			
//			if(changeInNoOfBedsDTO.getAdditionalQualificationCertificate()!=null && !changeInNoOfBedsDTO.getAdditionalQualificationCertificate().isEmpty()) {
//				files[2]=changeInNoOfBedsDTO.getAdditionalQualificationCertificate();
//			}else {
//				String additionalCertificate="Additional Qualification certificate is required";
//				condition=false;
//				message.append(additionalCertificate).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getAadhaarCard()!=null && !changeInNoOfBedsDTO.getAadhaarCard().isEmpty()) {
//				files[3] =changeInNoOfBedsDTO.getAadhaarCard();
//			}else {
//				String aadhar="Aadhaar cared field is required"	;
//				condition=false;
//				message.append(aadhar).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getPanCard()!=null && !changeInNoOfBedsDTO.getPanCard().isEmpty()) {
//				files[4]=changeInNoOfBedsDTO.getPanCard();
//			}else {
//				String pancard="Pan card field is required";
//				condition=false;
//				message.append(pancard).append(",");
//			}
//			
//			if(changeInNoOfBedsDTO.getAppointmentLetter()!=null && !changeInNoOfBedsDTO.getAppointmentLetter().isEmpty()) {
//				files[5]=changeInNoOfBedsDTO.getAppointmentLetter();
//			}else {
//				String appointmentLetter = "Appointment Letter field is required";
//				condition=false;
//				message.append(appointmentLetter).append(",");
//			}
//			
//			String savedFilePath = ChangeInNoOfBedsController.saveFile(files,
//					request);
//			
//			
//			RTIApplication rtiApplication = new RTIApplication();
//			if (changeInNoOfBedsDTO.getUserMobileNumber() != 0) {
//				rtiApplication.setMobileAppUserNumber(String.valueOf(
//						changeInNoOfBedsDTO.getUserMobileNumber()));
//			} else {
//				String userMobilenumber = "User Mobile Number field is Required";
//				condition = false;
//				message.append(userMobilenumber).append(",");
//			}			
//			
//			if(condition) {
//				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setTemplateName("nursingregistration");
//				rtiApplication.setSubject("NURSING-HOME-CHANGES-CERTIFICATE");
//				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
//				rtiApplication.setWorkFlowStatus(0);
//				rtiApplication.setFinalStatus("0");
//				rtiApplication.setRtiserviceid(96);
//				rtiApplication.setApplicantName(changeInNoOfBedsDTO.getNursingHomeOwner());
//				rtiApplication.setPhoneNumber(String.valueOf(changeInNoOfBedsDTO.getMobile()));
//				rtiApplication.setMobileNumber(String.valueOf(changeInNoOfBedsDTO.getMobile()));
//				rtiApplication.setZone(String.valueOf(changeInNoOfBedsDTO.getZoneNo()));
//				rtiApplication.setPdfUploadFromPortal(savedFilePath);
//
//				rtiApplication.setApplicationCost(changeInNoOfBedsDTO.getFees());
//
//				rtiApplication.setApplicantName(changeInNoOfBedsDTO.getNursingHomeOwner());
//				rtiApplication.setPdfUploadFromPortal(savedFilePath);
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
//
//					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
//					rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
//					changeInNoOfBedsDTO.setRtiapplrefno(rti.getRtiApplnNumber());
//					changeInNoOfBedsDTO.setRti_ref_id(savedRti.getRtiApplicationId());
//					long changeInbedsId = nursingHomeChangesApplicationService.nursingHomeChangesApplications(nhca);
//					rti.setRtiApplicationRefId(changeInbedsId);
//					RTIApplication retunRti = rtiApplicationService.merge(rti);
//
//					if ((retunRti != null) && (changeInbedsId > 0)) {
//						changeInNoOfBedsDTO.setResponseStatus(
//								"Requested data saved successfully");
//						changeInNoOfBedsDTO
//								.setResult(retunRti.getRtiApplnNumber());
//						changeInNoOfBedsDTO.setResponseCode(HttpStatus.OK.value());
//						response.setStatus(HttpStatus.OK.value());
//						changeInNoOfBedsDTO.setDegreeCertificate("");
//						changeInNoOfBedsDTO.setAdditionalQualificationCertificate("");
//						changeInNoOfBedsDTO.setMmcCertificate("");
//						changeInNoOfBedsDTO.setAadhaarCard("");
//						changeInNoOfBedsDTO.setPanCard("");
//						changeInNoOfBedsDTO.setAppointmentLetter("");
//						changeInNoOfBedsDTO.setStatus("ok");
//					}
//					String name = nhca.getNursingHomeOwner();
//					String link = "https://tinyurl.com/4hhhy9w9";
//					String applnNo = rti.getRtiApplnNumber();
//
//					String msg = "Dear " + name + " your application with Application No. " + applnNo
//							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
//
//					msg.replace("var3", "");
//
//					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", nhca.getPhone(), msg);
//					SendEmail.sendEmail(nhca.getEmail(), "Application Submitted Successfully" + applnNo,
//							msg);
//				}
//			}
//			if (!condition) {
//				if (message.charAt(message.length() - 1) == ',') {
//					message.deleteCharAt(message.length() - 1);
//					changeInNoOfBedsDTO.setResult(message.toString());
//					changeInNoOfBedsDTO.setResponseStatus(
//							"Requested data not saved successfully");
//					changeInNoOfBedsDTO.setDegreeCertificate("");
//					changeInNoOfBedsDTO.setAdditionalQualificationCertificate("");
//					changeInNoOfBedsDTO.setMmcCertificate("");
//					changeInNoOfBedsDTO.setAadhaarCard("");
//					changeInNoOfBedsDTO.setPanCard("");
//					changeInNoOfBedsDTO.setAppointmentLetter("");
//					changeInNoOfBedsDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//					changeInNoOfBedsDTO.setStatus("Internal Server Error");
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.equals(ex.getMessage());
//			changeInNoOfBedsDTO.setResponseStatus(ex.getMessage());
//			changeInNoOfBedsDTO.setDegreeCertificate("");
//			changeInNoOfBedsDTO.setAdditionalQualificationCertificate("");
//			changeInNoOfBedsDTO.setMmcCertificate("");
//			changeInNoOfBedsDTO.setAadhaarCard("");
//			changeInNoOfBedsDTO.setPanCard("");
//			changeInNoOfBedsDTO.setAppointmentLetter("");
//			changeInNoOfBedsDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
//			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//			changeInNoOfBedsDTO.setStatus("Method not Allowed");
//		}
//		return changeInNoOfBedsDTO;
//	}
//
//	
//	
//	
//	
//	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
//		String filesPath = null;
//		StringBuilder filesPathBuilder = new StringBuilder();
//		String baseDir = CoreConstants.UPLOAD_PATH + "changeInBeds";
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
