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
import com.mars.rti.model.WaterReconnection;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterReconnectionService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.WaterReconnectionRestDTO;

	@Controller
	public class WaterReconnectionRestController {
		

			private static Log log = LogFactory
					.getLog(WaterReconnectionRestController.class);

			@Autowired
			private RTIApplicationService rtiApplicationService;

			@Autowired
			private WaterReconnectionService waterReconnectionService;


			@RequestMapping(method = RequestMethod.POST, value = "/saveWaterReconnection")
			public @ResponseBody WaterReconnectionRestDTO saveWaterReconnectionService(
					@RequestBody WaterReconnectionRestDTO waterReconnectionRestDTO,
					HttpServletRequest request, HttpServletResponse reponse)
					throws ServletException {
				boolean condition = true;
				StringBuilder message = new StringBuilder();
				String[] files = new String[2];

				WaterReconnection waterReconnection = new WaterReconnection();
				try {
					//CAN No.
					if (waterReconnectionRestDTO.getCanNo() != null && !waterReconnectionRestDTO.getCanNo().isEmpty()) {
						waterReconnection.setCinNo(waterReconnectionRestDTO.getCanNo());
					} else {
						String can = "CanNo. field is Required";
						condition = false;
						message.append(can).append(",");
					}
					
					//Zone No
						if (waterReconnectionRestDTO.getZoneNo() != null && !waterReconnectionRestDTO.getZoneNo().isEmpty()) {

						waterReconnection.setZoneNo(String.valueOf(waterReconnectionRestDTO.getZoneNo()));

					} else {
						String zone = "ZoneNo. is Required";
						condition = false;
						message.append(zone).append(",");
					}
					//existingConsumerName
					if (waterReconnectionRestDTO.getExistingConsumerName() != null && !waterReconnectionRestDTO.getExistingConsumerName().isEmpty()) {
						waterReconnection.setConsumerName(waterReconnectionRestDTO.getExistingConsumerName());
					} else {
						String consumerName = "Existing Consumer Name field is Required";
						condition = false;
						message.append(consumerName).append(",");
					}
					//meterNo
					if (waterReconnectionRestDTO.getMeterNo() != null && !waterReconnectionRestDTO.getMeterNo().isEmpty()) {
						waterReconnection.setMeterNo(waterReconnectionRestDTO.getMeterNo());
					} else {
						String meterNo = "Meter No. field is Required";
						condition = false;
						message.append(meterNo).append(",");
					}
					
					//tapSize
					if (waterReconnectionRestDTO.getTapSize() != null && !waterReconnectionRestDTO.getTapSize().isEmpty()) {
						waterReconnection.setTap_size(waterReconnectionRestDTO.getTapSize());
					} else {
						String tapSize = "Tap Size field is Required";
						condition = false;
						message.append(tapSize).append(",");
					}
					
					//category
					if (waterReconnectionRestDTO.getCategory() != null && !waterReconnectionRestDTO.getCategory().isEmpty()) {
						waterReconnection.setCategory(waterReconnectionRestDTO.getCategory());
					} else {
						String category = "Category field is Required";
						condition = false;
						message.append(category).append(",");
					}
					
					//balanceArrears
					if (waterReconnectionRestDTO.getBalanceArrears() != null && !waterReconnectionRestDTO.getBalanceArrears().isEmpty()) {
						waterReconnection.setBalance_arrears(waterReconnectionRestDTO.getBalanceArrears());
					} else {
						String balanceArrears = "Balance Arrears field is Required";
						condition = false;
						message.append(balanceArrears).append(",");
					}
					
					//cutOffDate
					if (waterReconnectionRestDTO.getCutOffDate() != null && !waterReconnectionRestDTO.getCutOffDate().isEmpty()) {
						waterReconnection.setCut_off_date(waterReconnectionRestDTO.getCutOffDate());
					} else {
						String cutOffDate = "CutOffDate field is Required";
						condition = false;
						message.append(cutOffDate).append(",");
					}
					
					//consumerAddress
					if (waterReconnectionRestDTO.getConsumerAddress() != null && !waterReconnectionRestDTO.getConsumerAddress().isEmpty()) {
						waterReconnection.setConsumerAddress(waterReconnectionRestDTO.getConsumerAddress());
					} else {
						String conumerAddress = "Consumer Address field is Required";
						condition = false;
						message.append(conumerAddress).append(",");
					}
					
					//esr
					if (waterReconnectionRestDTO.getEsr() != null && !waterReconnectionRestDTO.getEsr().isEmpty()) {
						waterReconnection.setEsr(waterReconnectionRestDTO.getEsr());
					} else {
						String esr = "Esr field is Required";
						condition = false;
						message.append(esr).append(",");
					}
					
					//consumerEmailId
					if (waterReconnectionRestDTO.getConsumerEmailId() != null && !waterReconnectionRestDTO.getConsumerEmailId().isEmpty()) {
						waterReconnection.setEmail(waterReconnectionRestDTO.getConsumerEmailId());
					} else {
						String consumerEmailId = "consumerEmailId field is Required";
						condition = false;
						message.append(consumerEmailId).append(",");
					}
					
					
					//consumerMobileNo
					long consumerMobileNo = waterReconnectionRestDTO.getConsumerMobileNo();
					if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
						waterReconnection.setMobileNo(String.valueOf(consumerMobileNo));
					} else {
					    String errorMessage = "consumerMobileNo field is Required";
					    condition = false;
					    message.append(errorMessage).append(",");
					}

					
					
								
					//alternateMobileNo
					waterReconnection.setAlterMobileNo(String.valueOf(waterReconnectionRestDTO.getAlternateMobileNo()));

					
					
					
					//Files
					if (waterReconnectionRestDTO.getApplicantIdProofPdf() != null
							&& !waterReconnectionRestDTO.getApplicantIdProofPdf()
									.isEmpty()) {
						String doc0 = waterReconnectionRestDTO
								.getApplicantIdProofPdf();

						files[0] = doc0;
					} else {
						String doc0 = "Applicant Id Proof field is Required";
						condition = false;
						message.append(doc0).append(",");
					}

					if (waterReconnectionRestDTO.getCurrentBillCopyPdf() != null
							&& !waterReconnectionRestDTO.getCurrentBillCopyPdf()
									.isEmpty()) {
						String doc1 = waterReconnectionRestDTO
								.getCurrentBillCopyPdf();

						files[1] = doc1;
					} else {
						String doc1 = "Current Bill Copy field is Required";
						condition = false;
						message.append(doc1).append(",");
					}
					
					
					
					
					//save files method
					String savedFilePath = WaterReconnectionRestController
							.saveFile(files, request);
					
					RTIApplication rtiApplication = new RTIApplication();
					if (waterReconnectionRestDTO.getUserMobileNumber() != 0) {
						rtiApplication.setMobileAppUserNumber(String.valueOf(
								waterReconnectionRestDTO.getUserMobileNumber()));
					} else {
						String userMobilenumber = "User Mobile Number field is Required";
						condition = false;
						message.append(userMobilenumber).append(",");
					}
					if (condition) {
					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("WATER-RECONNECTION");
					rtiApplication.setDepartment("WATER-DEPARTMENT");
					rtiApplication.setTemplateName("water");
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(50);
					rtiApplication.setApplicantName(waterReconnection.getCinNo());

					
					rtiApplication.setPhoneNumber(waterReconnection.getMobileNo());
					if (waterReconnection.getAlterMobileNo() != null && !waterReconnection.getAlterMobileNo().isEmpty()) {
						rtiApplication.setMobileNumber(waterReconnection.getAlterMobileNo());

					}else {
						rtiApplication.setMobileNumber(waterReconnection.getMobileNo());
					}	
					rtiApplication.setPdfUploadFromPortal(savedFilePath);

					if(waterReconnection.getZoneNo() != null) {			   
						rtiApplication.setZone(
							waterReconnection.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterReconnection.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
							waterReconnection.getZoneNo().equals("Zone No.2 - Dharampeth") || waterReconnection.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
							waterReconnection.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterReconnection.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
							waterReconnection.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterReconnection.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
							waterReconnection.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterReconnection.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
							waterReconnection.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterReconnection.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
							waterReconnection.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterReconnection.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
							waterReconnection.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterReconnection.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
							waterReconnection.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterReconnection.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
							waterReconnection.getZoneNo().equals("Zone No.10 - Mangalwari")||waterReconnection.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}
					rtiApplication.setEmail(waterReconnection.getEmail());
					rtiApplication.setApplicantName(waterReconnection.getFullName());
					rtiApplication.setPdfUploadFromPortal(waterReconnection.getFilesPath());
					
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
						waterReconnection.setRtiapplrefno(rti.getRtiApplnNumber());
						waterReconnection.setRti_ref_id(savedRti.getRtiApplicationId());
						long water_regis_id = waterReconnectionService.getReferenceId(waterReconnection);
						rti.setRtiApplicationRefId(water_regis_id);
						RTIApplication retunRti = rtiApplicationService.merge(rti);
						if ((retunRti != null) && (water_regis_id > 0)) {
							LocalDate currentDate = LocalDate.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							String date = format.format(currentDate);
							MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
							formData.add("requestNo", waterReconnection.getRtiapplrefno());
							formData.add("date", date);
							//formData.add("salutation", waterReconnection.getTitle());
							//formData.add("firstName", waterReconnection.getFirstName());
							//formData.add("middleName", waterReconnection.getMiddleName());
							//formData.add("lastName", waterReconnection.getLastName());
							formData.add("type", "reconnection");
							formData.add("contactNo", waterReconnection.getMobileNo());
							formData.add("emailId", waterReconnection.getEmail());
							formData.add("contractAccountNo", waterReconnection.getCinNo());
							//formData.add("layoutName", layoutName);
							//formData.add("areaName", areaName);
							//formData.add("landmark", landmark);
							//formData.add("zone", "1");
							//formData.add("city", city);
							//formData.add("pin_code", pincode);
//							formData.add("purpose", "test");
							HttpHeaders headers = new HttpHeaders();
							headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
							HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
							 String url=CoreConstants.RECONNECTION_WATER_TEST_POST;

							//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
									String.class);
							if (log.isDebugEnabled()) {

								log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
							}

						
							waterReconnectionRestDTO.setResponseStatus("Requested data saved successfully");
							waterReconnectionRestDTO.setApplicantIdProofPdf("");
							waterReconnectionRestDTO.setCurrentBillCopyPdf("");
							
							waterReconnectionRestDTO.setResult(retunRti.getRtiApplnNumber());
							waterReconnectionRestDTO.setResponseCode(HttpStatus.OK.value());
							reponse.setStatus(HttpStatus.OK.value());
							waterReconnectionRestDTO.setStatus("ok");
						}
						String name = waterReconnection.getCinNo();
						String applnNo = rti.getRtiApplnNumber();
						String mobileNo = rti.getMobileNumber();
						String email=waterReconnection.getEmail();
						SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

					}
				}
				if (!condition) {
					if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						waterReconnectionRestDTO.setResult(message.toString());
						waterReconnectionRestDTO.setResponseStatus(
								"Requested data not saved successfully");
						waterReconnectionRestDTO.setApplicantIdProofPdf("");
						waterReconnectionRestDTO.setCurrentBillCopyPdf("");
					
						waterReconnectionRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						waterReconnectionRestDTO.setStatus("Internal Server Error");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				log.equals(ex.getMessage());
				waterReconnectionRestDTO.setApplicantIdProofPdf("");
				waterReconnectionRestDTO.setCurrentBillCopyPdf("");
				
				waterReconnectionRestDTO.setResponseStatus(ex.getMessage());
				waterReconnectionRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
				reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
				waterReconnectionRestDTO.setStatus("Method not Allowed");
				}

			return waterReconnectionRestDTO;
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

