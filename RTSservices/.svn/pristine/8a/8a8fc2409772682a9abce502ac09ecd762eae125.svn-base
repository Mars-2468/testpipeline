package com.mars.rti.ws.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mars.common.utils.CommonUtils;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.ChangeInOwnershipType;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.ChangeInOwnershipTypeService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.ChangeInOwnershipTypeRestDTO;

@Controller
public class ChangeInOwnershipTypeRestController {

	private static Log log = LogFactory.getLog(ChangeInOwnershipTypeRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private ChangeInOwnershipTypeService changeInOwnershipTypeService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/saveChangeInOwnershipCertificate")
	public @ResponseBody ChangeInOwnershipTypeRestDTO saveChangeInOwnershipCertificate(
			@RequestBody ChangeInOwnershipTypeRestDTO changeInOwnershipTypeRestDTO, HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		
		ChangeInOwnershipType changeInOwnershipType = new ChangeInOwnershipType();
		try {
			
			//CAN No.
			if (changeInOwnershipTypeRestDTO.getCanNo() != null && !changeInOwnershipTypeRestDTO.getCanNo().isEmpty()) {
				changeInOwnershipType.setCINNo(changeInOwnershipTypeRestDTO.getCanNo());
			} else {
				String can = "CanNo. field is Required";
				condition = false;
				message.append(can).append(",");
			}
			
			//Zone No
				if (changeInOwnershipTypeRestDTO.getZoneNo() != null && !changeInOwnershipTypeRestDTO.getZoneNo().isEmpty()) {


				changeInOwnershipType.setZoneNo(String.valueOf(changeInOwnershipTypeRestDTO.getZoneNo()));

			} else {
				String zone = "ZoneNo. is Required";
				condition = false;
				message.append(zone).append(",");
			}
			//existingConsumerName
			if (changeInOwnershipTypeRestDTO.getExistingConsumerName() != null && !changeInOwnershipTypeRestDTO.getExistingConsumerName().isEmpty()) {
				changeInOwnershipType.setExistingConsumerName(changeInOwnershipTypeRestDTO.getExistingConsumerName());
			} else {
				String consumerName = "Existing Consumer Name field is Required";
				condition = false;
				message.append(consumerName).append(",");
			}
			//meterNo
			if (changeInOwnershipTypeRestDTO.getMeterNo() != null && !changeInOwnershipTypeRestDTO.getMeterNo().isEmpty()) {
				changeInOwnershipType.setMeterNo(changeInOwnershipTypeRestDTO.getMeterNo());
			} else {
				String meterNo = "Meter No. field is Required";
				condition = false;
				message.append(meterNo).append(",");
			}
			
			//tapSize
			if (changeInOwnershipTypeRestDTO.getTapSize() != null && !changeInOwnershipTypeRestDTO.getTapSize().isEmpty()) {
				changeInOwnershipType.setTap_size(changeInOwnershipTypeRestDTO.getTapSize());
			} else {
				String tapSize = "Tap Size field is Required";
				condition = false;
				message.append(tapSize).append(",");
			}
			
			//category
			if (changeInOwnershipTypeRestDTO.getCategory() != null && !changeInOwnershipTypeRestDTO.getCategory().isEmpty()) {
				changeInOwnershipType.setCategory(changeInOwnershipTypeRestDTO.getCategory());
			} else {
				String category = "Category field is Required";
				condition = false;
				message.append(category).append(",");
			}
			
			//balanceArrears
			if (changeInOwnershipTypeRestDTO.getBalanceArrears() != null && !changeInOwnershipTypeRestDTO.getBalanceArrears().isEmpty()) {
				changeInOwnershipType.setBalance_arrears(changeInOwnershipTypeRestDTO.getBalanceArrears());
			} else {
				String balanceArrears = "Balance Arrears field is Required";
				condition = false;
				message.append(balanceArrears).append(",");
			}
			
			//cutOffDate
			if (changeInOwnershipTypeRestDTO.getCutOffDate() != null && !changeInOwnershipTypeRestDTO.getCutOffDate().isEmpty()) {
				changeInOwnershipType.setCut_off_date(changeInOwnershipTypeRestDTO.getCutOffDate());
			} else {
				String cutOffDate = "CutOffDate field is Required";
				condition = false;
				message.append(cutOffDate).append(",");
			}
			
			//consumerAddress
			if (changeInOwnershipTypeRestDTO.getConsumerAddress() != null && !changeInOwnershipTypeRestDTO.getConsumerAddress().isEmpty()) {
				changeInOwnershipType.setConsumerAddress(changeInOwnershipTypeRestDTO.getConsumerAddress());
			} else {
				String conumerAddress = "Consumer Address field is Required";
				condition = false;
				message.append(conumerAddress).append(",");
			}
			
			//esr
			if (changeInOwnershipTypeRestDTO.getEsr() != null && !changeInOwnershipTypeRestDTO.getEsr().isEmpty()) {
				changeInOwnershipType.setExistingEsr(changeInOwnershipTypeRestDTO.getEsr());
			} else {
				String esr = "Esr field is Required";
				condition = false;
				message.append(esr).append(",");
			}
			
			//consumerEmailId
			if (changeInOwnershipTypeRestDTO.getConsumerEmailId() != null && !changeInOwnershipTypeRestDTO.getConsumerEmailId().isEmpty()) {
				changeInOwnershipType.setEmailId(changeInOwnershipTypeRestDTO.getConsumerEmailId());
			} else {
				String consumerEmailId = "consumerEmailId field is Required";
				condition = false;
				message.append(consumerEmailId).append(",");
			}
			
			
			//consumerMobileNo
			long consumerMobileNo = changeInOwnershipTypeRestDTO.getConsumerMobileNo();
			if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
			    changeInOwnershipType.setMobileNo(String.valueOf(consumerMobileNo));
			} else {
			    String errorMessage = "consumerMobileNo field is Required";
			    condition = false;
			    message.append(errorMessage).append(",");
			}

			
			//title
			if (changeInOwnershipTypeRestDTO.getTitle() != null && !changeInOwnershipTypeRestDTO.getTitle().isEmpty()) {
				changeInOwnershipType.setTitle(changeInOwnershipTypeRestDTO.getTitle());
			} else {
				String title = "title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			
			//applicantName
			if (changeInOwnershipTypeRestDTO.getApplicantName() != null && !changeInOwnershipTypeRestDTO.getApplicantName().isEmpty()) {
				changeInOwnershipType.setFirstName(changeInOwnershipTypeRestDTO.getApplicantName());
			} else {
				String applicantName = "applicantName field is Required";
				condition = false;
				message.append(applicantName).append(",");
			}
			
			//applicantFatherName
				changeInOwnershipType.setMiddleName(changeInOwnershipTypeRestDTO.getApplicantFatherName());
			
				//applicantSurname
				if (changeInOwnershipTypeRestDTO.getApplicantSurname() != null && !changeInOwnershipTypeRestDTO.getApplicantSurname().isEmpty()) {
					changeInOwnershipType.setLastName(changeInOwnershipTypeRestDTO.getApplicantSurname());
				} else {
					String applicantSurname = "applicantSurname field is Required";
					condition = false;
					message.append(applicantSurname).append(",");
				}
				
				
				//fullName
			if (changeInOwnershipTypeRestDTO.getFullName() != null && !changeInOwnershipTypeRestDTO.getFullName().isEmpty()) {
				changeInOwnershipType.setFullName(changeInOwnershipTypeRestDTO.getFullName());
			} else {
				String fullName = "fullName field is Required";
				condition = false;
				message.append(fullName).append(",");
			}
			
						
			//alternateMobileNo
			changeInOwnershipType.setAlterMobileNo(String.valueOf(changeInOwnershipTypeRestDTO.getAlternateMobileNo()));

			//applicantAddress
			if (changeInOwnershipTypeRestDTO.getApplicantAddress() != null && !changeInOwnershipTypeRestDTO.getApplicantAddress().isEmpty()) {
				changeInOwnershipType.setAddressForCorrespondence(changeInOwnershipTypeRestDTO.getApplicantAddress());
			} else {
				String applicantAddress = "applicantAddress field is Required";
				condition = false;
				message.append(applicantAddress).append(",");
			}
			
			
			//Files
			if (changeInOwnershipTypeRestDTO.getApplicantIdProofPdf() != null
					&& !changeInOwnershipTypeRestDTO.getApplicantIdProofPdf()
							.isEmpty()) {
				String doc0 = changeInOwnershipTypeRestDTO
						.getApplicantIdProofPdf();

				files[0] = doc0;
			} else {
				String doc0 = "Applicant Id Proof field is Required";
				condition = false;
				message.append(doc0).append(",");
			}

			if (changeInOwnershipTypeRestDTO.getCurrentBillCopyPdf() != null
					&& !changeInOwnershipTypeRestDTO.getCurrentBillCopyPdf()
							.isEmpty()) {
				String doc1 = changeInOwnershipTypeRestDTO
						.getCurrentBillCopyPdf();

				files[1] = doc1;
			} else {
				String doc1 = "Current Bill Copy field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			
			
			if (changeInOwnershipTypeRestDTO.getOwnershipProofpdf() != null
					&& !changeInOwnershipTypeRestDTO.getOwnershipProofpdf()
							.isEmpty()) {
				String doc2 = changeInOwnershipTypeRestDTO.getOwnershipProofpdf();

				files[2] = doc2;
			} else {
				String doc2 = "Ownership Proof field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			
//			if (changeInOwnershipTypeRestDTO.getSupportingDocPdf() != null
//					&& !changeInOwnershipTypeRestDTO.getSupportingDocPdf()
//							.isEmpty()) {
				String doc3 = changeInOwnershipTypeRestDTO.getSupportingDocPdf();

				files[3] = doc3;
//			} else {
//				String doc3 = "Supporting Document field is Required";
//				condition = false;
//				message.append(doc3).append(",");
//			}
			
			//save files method
			String savedFilePath = ChangeInOwnershipTypeRestController
					.saveFile(files, request);
			
			RTIApplication rtiApplication = new RTIApplication();
			if (changeInOwnershipTypeRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						changeInOwnershipTypeRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("CHANGE-IN-OWNERSHIP-CERTIFICATE");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(49);
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicantName(changeInOwnershipType.getCINNo());
				rtiApplication.setPhoneNumber(changeInOwnershipType.getMobileNo());
				rtiApplication.setMobileNumber(changeInOwnershipType.getMobileNo());

				
				if (changeInOwnershipType.getAlterMobileNo() != null && !changeInOwnershipType.getAlterMobileNo().isEmpty()) {
				    rtiApplication.setMobileNumber(changeInOwnershipType.getAlterMobileNo());
				} else {
				    rtiApplication.setMobileNumber(changeInOwnershipType.getMobileNo());
				}

				
				rtiApplication.setEmail(changeInOwnershipType.getEmailId());

				if(changeInOwnershipType.getZoneNo() != null) {			   
					rtiApplication.setZone(
						changeInOwnershipType.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| changeInOwnershipType.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
						changeInOwnershipType.getZoneNo().equals("Zone No.2 - Dharampeth") || changeInOwnershipType.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
						changeInOwnershipType.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| changeInOwnershipType.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
						changeInOwnershipType.getZoneNo().equals("Zone No.4 - Dhantoli")|| changeInOwnershipType.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
						changeInOwnershipType.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| changeInOwnershipType.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
						changeInOwnershipType.getZoneNo().equals("Zone No.6 - Gandhibagh")|| changeInOwnershipType.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
						changeInOwnershipType.getZoneNo().equals("Zone No.7 - Satranjipura")|| changeInOwnershipType.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
						changeInOwnershipType.getZoneNo().equals("Zone No.8 - Lakadganj")|| changeInOwnershipType.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
						changeInOwnershipType.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| changeInOwnershipType.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
						changeInOwnershipType.getZoneNo().equals("Zone No.10 - Mangalwari")|| changeInOwnershipType.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
						    "");
					}

				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					changeInOwnershipType.setRtiApplRefNo(rti.getRtiApplnNumber());
					changeInOwnershipType.setRtiRefId(savedRti.getRtiApplicationId());
					String requestNo = changeInOwnershipType.getRtiApplRefNo();
					LocalDate currentDate = LocalDate.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String date = format.format(currentDate);
					String mobileNo = changeInOwnershipType.getMobileNo();
					String emailId = changeInOwnershipType.getEmailId();
					String purpose = changeInOwnershipType.getPurposeOfOwnership();
					MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
					formData.add("requestNo", requestNo);
					formData.add("date", date);
					formData.add("contractAccountNo", changeInOwnershipType.getCINNo());
					formData.add("type", "changeOfOwnership");
					formData.add("contactNo", mobileNo);
					formData.add("emailId", emailId);
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
					HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
					String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
							requestEntity, String.class);
					
					long birth_regis_id = changeInOwnershipTypeService.changeInOwnershipType(changeInOwnershipType);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					
					if ((retunRti != null) && (birth_regis_id > 0)) {
						changeInOwnershipTypeRestDTO.setResponseStatus("Requested data saved successfully");
						changeInOwnershipTypeRestDTO.setApplicantIdProofPdf("");
						changeInOwnershipTypeRestDTO.setCurrentBillCopyPdf("");
						changeInOwnershipTypeRestDTO.setOwnershipProofpdf("");
						changeInOwnershipTypeRestDTO.setSupportingDocPdf("");
						changeInOwnershipTypeRestDTO.setResponseCode(200);
						changeInOwnershipTypeRestDTO.setResult(retunRti.getRtiApplnNumber());
						changeInOwnershipTypeRestDTO.setStatus("ok");
						reponse.setStatus(HttpStatus.OK.value());
					}

					String name = changeInOwnershipType.getCINNo();
					String applnNo = rti.getRtiApplnNumber();
					String rtimobileNo = rti.getMobileNumber();
					String email=changeInOwnershipType.getEmailId();
					SendSMSEmailController.sendApplicationSubmitted(name, rtimobileNo, applnNo, email);
			
//					String msg = "Dear " + name + " your application with Application No. " + applnNo
//							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
//
//					msg.replace("var3", "");
//
//					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", changeInOwnershipType.getMobileNo(), msg);
//					SendEmail.sendEmail(changeInOwnershipType.getEmailId(),
//							"Application Submitted Successfully" + applnNo, msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					changeInOwnershipTypeRestDTO.setResult(message.toString());
					changeInOwnershipTypeRestDTO.setResponseStatus("Requested data not saved successfully");
					changeInOwnershipTypeRestDTO.setApplicantIdProofPdf("");
					changeInOwnershipTypeRestDTO.setCurrentBillCopyPdf("");
					changeInOwnershipTypeRestDTO.setOwnershipProofpdf("");
					changeInOwnershipTypeRestDTO.setSupportingDocPdf("");
					changeInOwnershipTypeRestDTO.setResponseCode(500);
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					changeInOwnershipTypeRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			changeInOwnershipTypeRestDTO.setResponseStatus(ex.getMessage());
			changeInOwnershipTypeRestDTO.setApplicantIdProofPdf("");
			changeInOwnershipTypeRestDTO.setCurrentBillCopyPdf("");
			changeInOwnershipTypeRestDTO.setOwnershipProofpdf("");
			changeInOwnershipTypeRestDTO.setSupportingDocPdf("");
			changeInOwnershipTypeRestDTO.setResponseCode(405);
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			changeInOwnershipTypeRestDTO.setStatus("Method not Allowed");
		}

		return changeInOwnershipTypeRestDTO;
	}

	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "ChangeInOwnershipType";
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			for (String element : data) {
				if (element != null) {
					byte[] pdfBytes = Base64.getDecoder().decode(element);
					String fileName;
					String uniqueFileName = UUID.randomUUID().toString().substring(0, 8) + ".pdf";
					int l = uniqueFileName.lastIndexOf(".");
					String imageext = uniqueFileName.substring(l, uniqueFileName.length());
					fileName = uniqueFileName.substring(0, l);
					fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
					fileName = fileName.replaceAll("\\W", "");
					fileName = fileName + "" + imageext;
					File storeFile = new File(baseDir, fileName);
					try (FileOutputStream outputStream = new FileOutputStream(storeFile)) {
						outputStream.write(pdfBytes);
						outputStream.flush();
						outputStream.close();
					}
					filesPath = baseDir + File.separator + fileName;
					filesPathBuilder.append(filesPath).append(",");
				} else {
					filesPathBuilder.append("null").append(",");

				}
			}
		} else {
			filesPathBuilder.append("null").append(",");
		}
		if (filesPathBuilder != null) {
			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
			}
			filesPath = filesPathBuilder.toString();
		}
		return filesPath;
	}
}
