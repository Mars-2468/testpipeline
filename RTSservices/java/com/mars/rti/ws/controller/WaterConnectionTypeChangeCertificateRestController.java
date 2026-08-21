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
import com.mars.rti.model.WaterConnectionTypeChange;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionTypeChangeService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.WaterConnectionTypeChangeRestDTO;

	@Controller
	public class WaterConnectionTypeChangeCertificateRestController {
		

			private static Log log = LogFactory
					.getLog(WaterConnectionTypeChangeCertificateRestController.class);

			@Autowired
			private RTIApplicationService rtiApplicationService;

			@Autowired
			private WaterConnectionTypeChangeService waterConnectionTypeChangeService;


			@RequestMapping(method = RequestMethod.POST, value = "/saveWaterConnectionTypeChange")
			public @ResponseBody WaterConnectionTypeChangeRestDTO saveWaterConnectionTypeChange(
					@RequestBody WaterConnectionTypeChangeRestDTO waterConnectionTypeChangeRestDTO,
					HttpServletRequest request, HttpServletResponse reponse)
					throws ServletException {
				boolean condition = true;
				StringBuilder message = new StringBuilder();
				String[] files = new String[2];

				WaterConnectionTypeChange waterConnectionTypeChange = new WaterConnectionTypeChange();
				try {
					//CAN No.
					if (waterConnectionTypeChangeRestDTO.getCanNo() != null && !waterConnectionTypeChangeRestDTO.getCanNo().isEmpty()) {
						waterConnectionTypeChange.setCINNo(waterConnectionTypeChangeRestDTO.getCanNo());
					} else {
						String can = "CanNo. field is Required";
						condition = false;
						message.append(can).append(",");
					}
					
					//Zone No
						if (waterConnectionTypeChangeRestDTO.getZoneNo() != null && !waterConnectionTypeChangeRestDTO.getZoneNo().isEmpty()) {

						waterConnectionTypeChange.setZoneNo(String.valueOf(waterConnectionTypeChangeRestDTO.getZoneNo()));

					} else {
						String zone = "ZoneNo. is Required";
						condition = false;
						message.append(zone).append(",");
					}
					//existingConsumerName
					if (waterConnectionTypeChangeRestDTO.getExistingConsumerName() != null && !waterConnectionTypeChangeRestDTO.getExistingConsumerName().isEmpty()) {
						waterConnectionTypeChange.setConsumerName(waterConnectionTypeChangeRestDTO.getExistingConsumerName());
					} else {
						String consumerName = "Existing Consumer Name field is Required";
						condition = false;
						message.append(consumerName).append(",");
					}
					//meterNo
					if (waterConnectionTypeChangeRestDTO.getMeterNo() != null && !waterConnectionTypeChangeRestDTO.getMeterNo().isEmpty()) {
						waterConnectionTypeChange.setMeterNo(waterConnectionTypeChangeRestDTO.getMeterNo());
					} else {
						String meterNo = "Meter No. field is Required";
						condition = false;
						message.append(meterNo).append(",");
					}
					
					//tapSize
					if (waterConnectionTypeChangeRestDTO.getTapSize() != null && !waterConnectionTypeChangeRestDTO.getTapSize().isEmpty()) {
						waterConnectionTypeChange.setTap_size(waterConnectionTypeChangeRestDTO.getTapSize());
					} else {
						String tapSize = "Tap Size field is Required";
						condition = false;
						message.append(tapSize).append(",");
					}
					
					//category
					if (waterConnectionTypeChangeRestDTO.getCategory() != null && !waterConnectionTypeChangeRestDTO.getCategory().isEmpty()) {
						waterConnectionTypeChange.setCategory(waterConnectionTypeChangeRestDTO.getCategory());
					} else {
						String category = "Category field is Required";
						condition = false;
						message.append(category).append(",");
					}
					
					//balanceArrears
					if (waterConnectionTypeChangeRestDTO.getBalanceArrears() != null && !waterConnectionTypeChangeRestDTO.getBalanceArrears().isEmpty()) {
						waterConnectionTypeChange.setBalance_arrears(waterConnectionTypeChangeRestDTO.getBalanceArrears());
					} else {
						String balanceArrears = "Balance Arrears field is Required";
						condition = false;
						message.append(balanceArrears).append(",");
					}
					
					//cutOffDate
					if (waterConnectionTypeChangeRestDTO.getCutOffDate() != null && !waterConnectionTypeChangeRestDTO.getCutOffDate().isEmpty()) {
						waterConnectionTypeChange.setCut_off_date(waterConnectionTypeChangeRestDTO.getCutOffDate());
					} else {
						String cutOffDate = "CutOffDate field is Required";
						condition = false;
						message.append(cutOffDate).append(",");
					}
					
					//consumerAddress
					if (waterConnectionTypeChangeRestDTO.getConsumerAddress() != null && !waterConnectionTypeChangeRestDTO.getConsumerAddress().isEmpty()) {
						waterConnectionTypeChange.setConsumerAddress(waterConnectionTypeChangeRestDTO.getConsumerAddress());
					} else {
						String conumerAddress = "Consumer Address field is Required";
						condition = false;
						message.append(conumerAddress).append(",");
					}
					
					//esr
					if (waterConnectionTypeChangeRestDTO.getEsr() != null && !waterConnectionTypeChangeRestDTO.getEsr().isEmpty()) {
						waterConnectionTypeChange.setExistingEsr(waterConnectionTypeChangeRestDTO.getEsr());
					} else {
						String esr = "Esr field is Required";
						condition = false;
						message.append(esr).append(",");
					}
					
					//consumerEmailId
					if (waterConnectionTypeChangeRestDTO.getConsumerEmailId() != null && !waterConnectionTypeChangeRestDTO.getConsumerEmailId().isEmpty()) {
						waterConnectionTypeChange.setEmail(waterConnectionTypeChangeRestDTO.getConsumerEmailId());
					} else {
						String consumerEmailId = "consumerEmailId field is Required";
						condition = false;
						message.append(consumerEmailId).append(",");
					}
					
					
					//consumerMobileNo
					long consumerMobileNo = waterConnectionTypeChangeRestDTO.getConsumerMobileNo();
					if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
						waterConnectionTypeChange.setMobileNo(String.valueOf(consumerMobileNo));
					} else {
					    String errorMessage = "consumerMobileNo field is Required";
					    condition = false;
					    message.append(errorMessage).append(",");
					}

					
					
								
					//alternateMobileNo
					waterConnectionTypeChange.setAlterMobileNo(String.valueOf(waterConnectionTypeChangeRestDTO.getAlternateMobileNo()));

					//getProposedTapSize
					if (waterConnectionTypeChangeRestDTO.getProposedTapSize() != null && !waterConnectionTypeChangeRestDTO.getProposedTapSize().isEmpty()) {
						waterConnectionTypeChange.setProposedTapSize(waterConnectionTypeChangeRestDTO.getProposedTapSize());
					} else {
						String ProposedTapSize = "ProposedTapSize field is Required";
						condition = false;
						message.append(ProposedTapSize).append(",");
					}
					//Files
					if (waterConnectionTypeChangeRestDTO.getApplicantIdProofPdf() != null
							&& !waterConnectionTypeChangeRestDTO.getApplicantIdProofPdf()
									.isEmpty()) {
						String doc0 = waterConnectionTypeChangeRestDTO
								.getApplicantIdProofPdf();

						files[0] = doc0;
					} else {
						String doc0 = "Applicant Id Proof field is Required";
						condition = false;
						message.append(doc0).append(",");
					}

					if (waterConnectionTypeChangeRestDTO.getCurrentBillCopyPdf() != null
							&& !waterConnectionTypeChangeRestDTO.getCurrentBillCopyPdf()
									.isEmpty()) {
						String doc1 = waterConnectionTypeChangeRestDTO
								.getCurrentBillCopyPdf();

						files[1] = doc1;
					} else {
						String doc1 = "Current Bill Copy field is Required";
						condition = false;
						message.append(doc1).append(",");
					}
					
					
					
					//save files method
					String savedFilePath = WaterConnectionTypeChangeCertificateRestController
							.saveFile(files, request);
					
					RTIApplication rtiApplication = new RTIApplication();
					if (waterConnectionTypeChangeRestDTO.getUserMobileNumber() != 0) {
						rtiApplication.setMobileAppUserNumber(String.valueOf(
								waterConnectionTypeChangeRestDTO.getUserMobileNumber()));
					} else {
						String userMobilenumber = "User Mobile Number field is Required";
						condition = false;
						message.append(userMobilenumber).append(",");
					}
					if (condition) {
					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("WATER-CONNECTION-TYPE-CHANGE");
					rtiApplication.setDepartment("WATER-DEPARTMENT");
					rtiApplication.setTemplateName("water");
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(47);
					rtiApplication.setApplicantName(waterConnectionTypeChange.getCINNo());

					rtiApplication.setPhoneNumber(waterConnectionTypeChange.getMobileNo());
					if (waterConnectionTypeChange.getAlterMobileNo() != null && !waterConnectionTypeChange.getAlterMobileNo().isEmpty()) {
						rtiApplication.setMobileNumber(waterConnectionTypeChange.getAlterMobileNo());


					}else {
						rtiApplication.setMobileNumber(waterConnectionTypeChange.getMobileNo());

					}					rtiApplication.setPdfUploadFromPortal(savedFilePath);

					if(waterConnectionTypeChange.getZoneNo() != null) {			   
						rtiApplication.setZone(
							waterConnectionTypeChange.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.2 - Dharampeth") || waterConnectionTypeChange.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterConnectionTypeChange.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
							waterConnectionTypeChange.getZoneNo().equals("Zone No.10 - Mangalwari")||waterConnectionTypeChange.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}
					rtiApplication.setEmail(waterConnectionTypeChange.getEmail());
					rtiApplication.setApplicantName(waterConnectionTypeChange.getFullName());
					rtiApplication.setPdfUploadFromPortal(waterConnectionTypeChange.getFilesPath());
					
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
						waterConnectionTypeChange.setRtiapplrefno(rti.getRtiApplnNumber());
						waterConnectionTypeChange.setRti_ref_id(savedRti.getRtiApplicationId());
						long water_regis_id = waterConnectionTypeChangeService.getReferenceId(waterConnectionTypeChange);
						rti.setRtiApplicationRefId(water_regis_id);
						RTIApplication retunRti = rtiApplicationService.merge(rti);
						if ((retunRti != null) && (water_regis_id > 0)) {
							LocalDate currentDate = LocalDate.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							String date = format.format(currentDate);
							MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
							formData.add("requestNo", waterConnectionTypeChange.getRtiapplrefno());
							formData.add("date", date);
							//formData.add("salutation", waterConnectionTypeChange.getTitle());
							//formData.add("firstName", waterConnectionTypeChange.getFirstName());
							//formData.add("middleName", waterConnectionTypeChange.getMiddleName());
							//formData.add("lastName", waterConnectionTypeChange.getLastName());
							formData.add("type", "ChangeInConnectionSize");
							formData.add("contactNo", waterConnectionTypeChange.getMobileNo());
							formData.add("emailId", waterConnectionTypeChange.getEmail());
							formData.add("contractAccountNo", waterConnectionTypeChange.getCINNo());
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
							//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
							
							 String url=CoreConstants.CONNECTION_TYPE_CHANGE_WATER_TEST_POST;

							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
									String.class);
							if (log.isDebugEnabled()) {

								log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
							}

						
							waterConnectionTypeChangeRestDTO.setResponseStatus(
									"Requested data saved successfully");
							waterConnectionTypeChangeRestDTO.setApplicantIdProofPdf("");
					waterConnectionTypeChangeRestDTO.setCurrentBillCopyPdf("") ;
					
							waterConnectionTypeChangeRestDTO
									.setResult(retunRti.getRtiApplnNumber());
							waterConnectionTypeChangeRestDTO.setResponseCode(HttpStatus.OK.value());
							reponse.setStatus(HttpStatus.OK.value());
							waterConnectionTypeChangeRestDTO.setStatus("ok");}
						String name = waterConnectionTypeChange.getCINNo();
						String applnNo = rti.getRtiApplnNumber();
						String mobileNo = rti.getMobileNumber();
						String email=waterConnectionTypeChange.getEmail();
						SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

					}
				}
				if (!condition) {
					if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						waterConnectionTypeChangeRestDTO.setResult(message.toString());
						waterConnectionTypeChangeRestDTO.setResponseStatus(
								"Requested data not saved successfully");
					waterConnectionTypeChangeRestDTO.setApplicantIdProofPdf("");
					waterConnectionTypeChangeRestDTO.setCurrentBillCopyPdf("") ;
					
						waterConnectionTypeChangeRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						waterConnectionTypeChangeRestDTO.setStatus("Internal Server Error");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				waterConnectionTypeChangeRestDTO.setApplicantIdProofPdf("");
					waterConnectionTypeChangeRestDTO.setCurrentBillCopyPdf("") ;
					
				log.equals(ex.getMessage());
				waterConnectionTypeChangeRestDTO.setResponseStatus(ex.getMessage());
				waterConnectionTypeChangeRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
				reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
				waterConnectionTypeChangeRestDTO.setStatus("Method not Allowed");
			}

			return waterConnectionTypeChangeRestDTO;
		}
			
			
			public static String saveFile(String data[], HttpServletRequest request) throws IOException {
				String filesPath = null;
				StringBuilder filesPathBuilder = new StringBuilder();
				String baseDir = CoreConstants.UPLOAD_PATH + "waterconnectiontypechange";
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

