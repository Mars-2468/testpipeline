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
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionUsageService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.WaterConnectionUsageRestDTO;

@Controller
public class WaterConnectionUsageRestController{
	

		private static Log log = LogFactory
				.getLog(WaterReconnectionRestController.class);

		@Autowired
		private RTIApplicationService rtiApplicationService;

		@Autowired
		private WaterConnectionUsageService waterConnectionUsageService;


		@RequestMapping(method = RequestMethod.POST, value = "/saveWaterConnectionUsage")
		public @ResponseBody WaterConnectionUsageRestDTO saveWaterConnectionUsage(
				@RequestBody WaterConnectionUsageRestDTO waterConnectionUsageRestDTO,
				HttpServletRequest request, HttpServletResponse reponse)
				throws ServletException {
			boolean condition = true;
			StringBuilder message = new StringBuilder();
			String[] files = new String[2];

			WaterConnectionUsage waterConnectionUsage = new WaterConnectionUsage();
			try {
				//CAN No.
				if (waterConnectionUsageRestDTO.getCanNo() != null && !waterConnectionUsageRestDTO.getCanNo().isEmpty()) {
					waterConnectionUsage.setCINNo(waterConnectionUsageRestDTO.getCanNo());
				} else {
					String can = "CanNo. field is Required";
					condition = false;
					message.append(can).append(",");
				}
				
				//Zone No
					if (waterConnectionUsageRestDTO.getZoneNo() != null && !waterConnectionUsageRestDTO.getZoneNo().isEmpty()) {

					waterConnectionUsage.setZoneNo(String.valueOf(waterConnectionUsageRestDTO.getZoneNo()));

				} else {
					String zone = "ZoneNo. is Required";
					condition = false;
					message.append(zone).append(",");
				}
				//existingConsumerName
				if (waterConnectionUsageRestDTO.getExistingConsumerName() != null && !waterConnectionUsageRestDTO.getExistingConsumerName().isEmpty()) {
					waterConnectionUsage.setConsumerName(waterConnectionUsageRestDTO.getExistingConsumerName());
				} else {
					String consumerName = "Consumer Name field is Required";
					condition = false;
					message.append(consumerName).append(",");
				}
				//meterNo
				if (waterConnectionUsageRestDTO.getMeterNo() != null && !waterConnectionUsageRestDTO.getMeterNo().isEmpty()) {
					waterConnectionUsage.setMeterNo(waterConnectionUsageRestDTO.getMeterNo());
				} else {
					String meterNo = "Meter No. field is Required";
					condition = false;
					message.append(meterNo).append(",");
				}
				
				//tapSize
				if (waterConnectionUsageRestDTO.getTapSize() != null && !waterConnectionUsageRestDTO.getTapSize().isEmpty()) {
					waterConnectionUsage.setTap_size(waterConnectionUsageRestDTO.getTapSize());
				} else {
					String tapSize = "Tap Size field is Required";
					condition = false;
					message.append(tapSize).append(",");
				}
				
				//category
				if (waterConnectionUsageRestDTO.getCategory() != null && !waterConnectionUsageRestDTO.getCategory().isEmpty()) {
					waterConnectionUsage.setCategory(waterConnectionUsageRestDTO.getCategory());
				} else {
					String category = "Category field is Required";
					condition = false;
					message.append(category).append(",");
				}
				
				//balanceArrears
				if (waterConnectionUsageRestDTO.getBalanceArrears() != null && !waterConnectionUsageRestDTO.getBalanceArrears().isEmpty()) {
					waterConnectionUsage.setBalance_arrears(waterConnectionUsageRestDTO.getBalanceArrears());
				} else {
					String balanceArrears = "Balance Arrears field is Required";
					condition = false;
					message.append(balanceArrears).append(",");
				}
				
				//cutOffDate
				if (waterConnectionUsageRestDTO.getCutOffDate() != null && !waterConnectionUsageRestDTO.getCutOffDate().isEmpty()) {
					waterConnectionUsage.setCut_off_date(waterConnectionUsageRestDTO.getCutOffDate());
				} else {
					String cutOffDate = "CutOffDate field is Required";
					condition = false;
					message.append(cutOffDate).append(",");
				}
				
				//consumerAddress
				if (waterConnectionUsageRestDTO.getConsumerAddress() != null && !waterConnectionUsageRestDTO.getConsumerAddress().isEmpty()) {
					waterConnectionUsage.setConsumerAddress(waterConnectionUsageRestDTO.getConsumerAddress());
				} else {
					String conumerAddress = "Consumer Address field is Required";
					condition = false;
					message.append(conumerAddress).append(",");
				}
				
				//esr
				if (waterConnectionUsageRestDTO.getEsr() != null && !waterConnectionUsageRestDTO.getEsr().isEmpty()) {
					waterConnectionUsage.setExistingEsr(waterConnectionUsageRestDTO.getEsr());
				} else {
					String esr = "Esr field is Required";
					condition = false;
					message.append(esr).append(",");
				}
				
				//consumerEmailId
				if (waterConnectionUsageRestDTO.getConsumerEmailId() != null && !waterConnectionUsageRestDTO.getConsumerEmailId().isEmpty()) {
					waterConnectionUsage.setEmail(waterConnectionUsageRestDTO.getConsumerEmailId());
				} else {
					String consumerEmailId = "consumerEmailId field is Required";
					condition = false;
					message.append(consumerEmailId).append(",");
				}
				
				
				//consumerMobileNo
				long consumerMobileNo = waterConnectionUsageRestDTO.getConsumerMobileNo();
				if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
					waterConnectionUsage.setMobileNo(String.valueOf(consumerMobileNo));
				} else {
				    String errorMessage = "consumerMobileNo field is Required";
				    condition = false;
				    message.append(errorMessage).append(",");
				}

				//alternateMobileNo
				waterConnectionUsage.setAlterMobileNo(String.valueOf(waterConnectionUsageRestDTO.getAlternateMobileNo()));

				
				//proposedCategory
				if (waterConnectionUsageRestDTO.getProposedCategory() != null && !waterConnectionUsageRestDTO.getProposedCategory().isEmpty()) {
					waterConnectionUsage.setProposedCategory(waterConnectionUsageRestDTO.getProposedCategory());
				} else {
					String proposedCategory = "proposedCategory field is Required";
					condition = false;
					message.append(proposedCategory).append(",");
				}
				
				
				
							

				//totalNumberOfResidentialFlats
				if (waterConnectionUsageRestDTO.getProposedCategory().equals("R1-Residential")) {
				if  (waterConnectionUsageRestDTO.getTotalNumberOfResidentialFlats() != null && !waterConnectionUsageRestDTO.getTotalNumberOfResidentialFlats().isEmpty()) {
					waterConnectionUsage.setTotalNumberOfResidentialFlats(waterConnectionUsageRestDTO.getTotalNumberOfResidentialFlats());
				} else {
					String totalNumberOfResidentialFlats = "totalNumberOfResidentialFlats field is Required";
					condition = false;
					message.append(totalNumberOfResidentialFlats).append(",");
				}
				}
				
				//Files
				if (waterConnectionUsageRestDTO.getApplicantIdProofPdf() != null
						&& !waterConnectionUsageRestDTO.getApplicantIdProofPdf()
								.isEmpty()) {
					String doc0 = waterConnectionUsageRestDTO
							.getApplicantIdProofPdf();

					files[0] = doc0;
				} else {
					String doc0 = "Applicant Id Proof field is Required";
					condition = false;
					message.append(doc0).append(",");
				}

				if (waterConnectionUsageRestDTO.getSupportingDocPdf() != null
						&& !waterConnectionUsageRestDTO.getSupportingDocPdf()
								.isEmpty()) {
					String doc1 = waterConnectionUsageRestDTO
							.getSupportingDocPdf();

					files[1] = doc1;
				} else {
					String doc1 = "Any other Supporting document field is Required";
					condition = false;
					message.append(doc1).append(",");
				}
				
				
						
				//save files method
				String savedFilePath = WaterReconnectionRestController
						.saveFile(files, request);
				
				RTIApplication rtiApplication = new RTIApplication();
				if (waterConnectionUsageRestDTO.getUserMobileNumber() != 0) {
					rtiApplication.setMobileAppUserNumber(String.valueOf(
							waterConnectionUsageRestDTO.getUserMobileNumber()));
				} else {
					String userMobilenumber = "User Mobile Number field is Required";
					condition = false;
					message.append(userMobilenumber).append(",");
				}
				if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-CONNECTION-USAGE-CERTIFICATE");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(51);
				rtiApplication.setPhoneNumber(waterConnectionUsage.getMobileNo());
				rtiApplication.setMobileNumber(waterConnectionUsage.getMobileNo());
				
				
				if (waterConnectionUsage.getAlterMobileNo() != null && !waterConnectionUsage.getAlterMobileNo().isEmpty()) {
					rtiApplication.setMobileNumber(waterConnectionUsage.getAlterMobileNo());


				}else {
					rtiApplication.setMobileNumber(waterConnectionUsage.getMobileNo());

				}
				
				
				rtiApplication.setPdfUploadFromPortal(savedFilePath);

				if(waterConnectionUsage.getZoneNo() != null) {			   
					rtiApplication.setZone(
							waterConnectionUsage.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								waterConnectionUsage.getZoneNo().equals("Zone No.2 - Dharampeth") || waterConnectionUsage.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
									waterConnectionUsage.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
										waterConnectionUsage.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterConnectionUsage.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
											waterConnectionUsage.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
												waterConnectionUsage.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterConnectionUsage.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
													waterConnectionUsage.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterConnectionUsage.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
														waterConnectionUsage.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterConnectionUsage.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
															waterConnectionUsage.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
																waterConnectionUsage.getZoneNo().equals("Zone No.10 - Mangalwari")||waterConnectionUsage.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
						    "");
					}
				rtiApplication.setEmail(waterConnectionUsage.getEmail());
				rtiApplication.setApplicantName(waterConnectionUsage.getCINNo());
				rtiApplication.setPdfUploadFromPortal(waterConnectionUsage.getFilesPath());
				
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
				
				
				
				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					waterConnectionUsage.setRtiapplrefno(rti.getRtiApplnNumber());
					waterConnectionUsage.setRti_ref_id(savedRti.getRtiApplicationId());
					long water_regis_id = waterConnectionUsageService.waterConnectionUsage(waterConnectionUsage);
					rti.setRtiApplicationRefId(water_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					if ((retunRti != null) && (water_regis_id > 0)) {
						if ((retunRti != null) && (waterConnectionUsage.getRti_ref_id() > 0)) {
							String requestNo = waterConnectionUsage.getRtiapplrefno();
							LocalDate currentDate = LocalDate.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							String date = format.format(currentDate);
							String mobileNo = waterConnectionUsage.getMobileNo();
							String emailId = waterConnectionUsage.getEmail();
							//String purpose = waterConnectionUsage.getPurpose();
							// String purpose = waterConnectionUsage.getPurpose();
							MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
							formData.add("requestNo", requestNo);
							formData.add("date", date);
							formData.add("contractAccountNo", waterConnectionUsage.getCINNo());
							formData.add("type", "changeOfUsage");
							formData.add("contactNo", mobileNo);
							formData.add("emailId", emailId);
							//formData.add("purpose", purpose);
							HttpHeaders headers = new HttpHeaders();
							headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
							HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData,
									headers);
							 String url=CoreConstants.CHANGE_USAGE_WATER_TEST_POST;

							//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
									requestEntity, String.class);
							if (log.isDebugEnabled()) {

								log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
							}

						}
						waterConnectionUsageRestDTO.setResponseStatus("Requested data saved successfully");
						waterConnectionUsageRestDTO.setResult(retunRti.getRtiApplnNumber());
						waterConnectionUsageRestDTO.setResponseCode(HttpStatus.OK.value());

						waterConnectionUsageRestDTO.setApplicantIdProofPdf("");
						waterConnectionUsageRestDTO.setSupportingDocPdf("");
						
						reponse.setStatus(HttpStatus.OK.value());
						waterConnectionUsageRestDTO.setStatus("ok");
					}
						String name = waterConnectionUsage.getCINNo();
						String applnNo = rti.getRtiApplnNumber();
						String mobileNo = rti.getMobileNumber();
						String email=waterConnectionUsage.getEmail();
						SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					waterConnectionUsageRestDTO.setResult(message.toString());
					waterConnectionUsageRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					waterConnectionUsageRestDTO.setApplicantIdProofPdf("");
					waterConnectionUsageRestDTO.setSupportingDocPdf("");
					
					waterConnectionUsageRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					waterConnectionUsageRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			waterConnectionUsageRestDTO.setResponseStatus(ex.getMessage());
			waterConnectionUsageRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			waterConnectionUsageRestDTO.setStatus("Method not Allowed");
			waterConnectionUsageRestDTO.setApplicantIdProofPdf("");
			waterConnectionUsageRestDTO.setSupportingDocPdf("");
			
			}

		return waterConnectionUsageRestDTO;
	}
		
		
		public static String saveFile(String data[], HttpServletRequest request) throws IOException {
			String filesPath = null;
			StringBuilder filesPathBuilder = new StringBuilder();
			String baseDir = CoreConstants.UPLOAD_PATH + "waterreconnection";
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