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
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterDisconnectionService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.WaterDisconnectionRestDTO;

@Controller
public class WaterDisconnectionRestController {
	
	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	@Autowired
	private WaterDisconnectionService  waterDisconnectionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/saveWaterDisconnection")
	public @ResponseBody WaterDisconnectionRestDTO saveWaterDisconnection(
			@RequestBody WaterDisconnectionRestDTO waterDisconnectionRestDTO, HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException {
		
		WaterDisconnection waterDisconnection = new WaterDisconnection();
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[2];
		try {
			//CAN No.
			if (waterDisconnectionRestDTO.getCanNo() != null && !waterDisconnectionRestDTO.getCanNo().isEmpty()) {
				waterDisconnection.setCINNo(waterDisconnectionRestDTO.getCanNo());
			} else {
				String can = "CanNo. field is Required";
				condition = false;
				message.append(can).append(",");
			}
			
			//Zone No
				if (waterDisconnectionRestDTO.getZoneNo() != null && !waterDisconnectionRestDTO.getZoneNo().isEmpty()) {

				waterDisconnection.setZoneNo(String.valueOf(waterDisconnectionRestDTO.getZoneNo()));

			} else {
				String zone = "ZoneNo. is Required";
				condition = false;
				message.append(zone).append(",");
			}
			//existingConsumerName
			if (waterDisconnectionRestDTO.getExistingConsumerName() != null && !waterDisconnectionRestDTO.getExistingConsumerName().isEmpty()) {
				waterDisconnection.setConsumerName(waterDisconnectionRestDTO.getExistingConsumerName());
			} else {
				String consumerName = "Existing Consumer Name field is Required";
				condition = false;
				message.append(consumerName).append(",");
			}
			//meterNo
			if (waterDisconnectionRestDTO.getMeterNo() != null && !waterDisconnectionRestDTO.getMeterNo().isEmpty()) {
				waterDisconnection.setMeterNo(waterDisconnectionRestDTO.getMeterNo());
			} else {
				String meterNo = "Meter No. field is Required";
				condition = false;
				message.append(meterNo).append(",");
			}
			
			//tapSize
			if (waterDisconnectionRestDTO.getTapSize() != null && !waterDisconnectionRestDTO.getTapSize().isEmpty()) {
				waterDisconnection.setTap_size(waterDisconnectionRestDTO.getTapSize());
			} else {
				String tapSize = "Tap Size field is Required";
				condition = false;
				message.append(tapSize).append(",");
			}
			
			//category
			if (waterDisconnectionRestDTO.getCategory() != null && !waterDisconnectionRestDTO.getCategory().isEmpty()) {
				waterDisconnection.setCategory(waterDisconnectionRestDTO.getCategory());
			} else {
				String category = "Category field is Required";
				condition = false;
				message.append(category).append(",");
			}
			
			//balanceArrears
			if (waterDisconnectionRestDTO.getBalanceArrears() != null && !waterDisconnectionRestDTO.getBalanceArrears().isEmpty()) {
				waterDisconnection.setBalance_arrears(waterDisconnectionRestDTO.getBalanceArrears());
			} else {
				String balanceArrears = "Balance Arrears field is Required";
				condition = false;
				message.append(balanceArrears).append(",");
			}
			
			//cutOffDate
			if (waterDisconnectionRestDTO.getCutOffDate() != null && !waterDisconnectionRestDTO.getCutOffDate().isEmpty()) {
				waterDisconnection.setCut_off_date(waterDisconnectionRestDTO.getCutOffDate());
			} else {
				String cutOffDate = "CutOffDate field is Required";
				condition = false;
				message.append(cutOffDate).append(",");
			}
			
			//getConsumerAddress
			if (waterDisconnectionRestDTO.getConsumerAddress() != null && !waterDisconnectionRestDTO.getConsumerAddress().isEmpty()) {
				waterDisconnection.setConsumerAddress(waterDisconnectionRestDTO.getConsumerAddress());
			} else {
				String ConsumerAddress = "ConsumerAddress field is Required";
				condition = false;
				message.append(ConsumerAddress).append(",");
			}
			
			
			//esr
			if (waterDisconnectionRestDTO.getEsr() != null && !waterDisconnectionRestDTO.getEsr().isEmpty()) {
				waterDisconnection.setExistingEsr(waterDisconnectionRestDTO.getEsr());
			} else {
				String esr = "Esr field is Required";
				condition = false;
				message.append(esr).append(",");
			}
			
			//consumerEmailId
			if (waterDisconnectionRestDTO.getConsumerEmailId() != null && !waterDisconnectionRestDTO.getConsumerEmailId().isEmpty()) {
				waterDisconnection.setEmail(waterDisconnectionRestDTO.getConsumerEmailId());
			} else {
				String consumerEmailId = "consumerEmailId field is Required";
				condition = false;
				message.append(consumerEmailId).append(",");
			}
			
			
			//consumerMobileNo
			long consumerMobileNo = waterDisconnectionRestDTO.getConsumerMobileNo();
			if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
				waterDisconnection.setMobileNo(String.valueOf(consumerMobileNo));
			} else {
			    String errorMessage = "consumerMobileNo field is Required";
			    condition = false;
			    message.append(errorMessage).append(",");
			}

			
		
			//alternateMobileNo
			waterDisconnection.setAlterMobileNo(String.valueOf(waterDisconnectionRestDTO.getAlternateMobileNo()));

			//applicantAddress
			if (waterDisconnectionRestDTO.getDisconnectionType() != null && !waterDisconnectionRestDTO.getDisconnectionType().isEmpty()) {
				waterDisconnection.setDisconnectionType(waterDisconnectionRestDTO.getDisconnectionType());
			} else {
				String DisconnectionType = "DisconnectionType field is Required";
				condition = false;
				message.append(DisconnectionType).append(",");
			}
			
			
			//Files
			if (waterDisconnectionRestDTO.getApplicantIdProofPdf() != null
					&& !waterDisconnectionRestDTO.getApplicantIdProofPdf()
							.isEmpty()) {
				String doc0 = waterDisconnectionRestDTO
						.getApplicantIdProofPdf();

				files[0] = doc0;
			} else {
				String doc0 = "Applicant Id Proof field is Required";
				condition = false;
				message.append(doc0).append(",");
			}

			
			
			
				String doc1 = waterDisconnectionRestDTO.getOwnershipProofpdf();

				files[1] = doc1;
			
			//save files method
			String savedFilePath = ChangeInOwnershipTypeRestController
					.saveFile(files, request);

		
			RTIApplication rtiApplication = new RTIApplication();
			if (waterDisconnectionRestDTO.getUserMobileNumber() !=0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(waterDisconnectionRestDTO.getUserMobileNumber()));
				} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-DISCONNECTION-CERTIFICATE");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(6);
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicantName(waterDisconnection.getCINNo());
				rtiApplication.setPhoneNumber(waterDisconnection.getMobileNo());
				
				if (waterDisconnection.getAlterMobileNo() != null && !waterDisconnection.getAlterMobileNo().isEmpty()) {
					rtiApplication.setMobileNumber(waterDisconnection.getAlterMobileNo());


				}else {
					rtiApplication.setMobileNumber(waterDisconnection.getMobileNo());
				}
				rtiApplication.setEmail(waterDisconnection.getEmail());
//				rtiApplication.setZone(waterDisconnection.getZoneNo());
				
				if (waterDisconnection.getZoneNo() != null) {
					rtiApplication.setZone(waterDisconnection.getZoneNo().equals("Zone No.1 - Laxmi Nagar")
							|| waterDisconnection.getZoneNo().equals("Zone No.01 - Laxmi Nagar")
									? "1"
									: waterDisconnection.getZoneNo().equals("Zone No.2 - Dharampeth")
											|| waterDisconnection.getZoneNo().equals("Zone No.02 - Dharampeth")
													? "2"
													: waterDisconnection.getZoneNo().equals("Zone No.3 - Hanuman Nagar")
															|| waterDisconnection.getZoneNo()
																	.equals("Zone No.03 - Hanuman Nagar")
																			? "3"
																			: waterDisconnection.getZoneNo()
																					.equals("Zone No.4 - Dhantoli")
																					|| waterDisconnection.getZoneNo()
																							.equals("Zone No.04 - Dhantoli")
																									? "4"
																									: waterDisconnection
																											.getZoneNo()
																											.equals("Zone No.5 - Nehru Nagar")
																											|| waterDisconnection
																													.getZoneNo()
																													.equals("Zone No.05 - Nehru Nagar")
																															? "5"
																															: waterDisconnection
																																	.getZoneNo()
																																	.equals("Zone No.6 - Gandhibagh")
																																	|| waterDisconnection
																																			.getZoneNo()
																																			.equals("Zone No.06 - Gandhibagh")
																																					? "6"
																																					: waterDisconnection
																																							.getZoneNo()
																																							.equals("Zone No.7 - Satranjipura")
																																							|| waterDisconnection
																																									.getZoneNo()
																																									.equals("Zone No.07 - Satranjipura")
																																											? "7"
																																											: waterDisconnection
																																													.getZoneNo()
																																													.equals("Zone No.8 - Lakadganj")
																																													|| waterDisconnection
																																															.getZoneNo()
																																															.equals("Zone No.08 - Lakadganj")
																																																	? "8"
																																																	: waterDisconnection
																																																			.getZoneNo()
																																																			.equals("Zone No.9 - Ashi Nagar")
																																																			|| waterDisconnection
																																																					.getZoneNo()
																																																					.equals("Zone No.09 - Ashi Nagar")
																																																							? "9"
																																																							: waterDisconnection
																																																									.getZoneNo()
																																																									.equals("Zone No.10 - Mangalwari")
																																																									|| waterDisconnection
																																																											.getZoneNo()
																																																											.equals("Zone No.010 - Mangalwari")
																																																													? "10"
																																																													: "");
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
					waterDisconnection.setRtiapplrefno(rti.getRtiApplnNumber());
					waterDisconnection.setRti_ref_id(savedRti.getRtiApplicationId());
						String requestNo = waterDisconnection.getRtiapplrefno();
						LocalDate currentDate = LocalDate.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String date = format.format(currentDate);
						String mobileNo = waterDisconnection.getMobileNo();
						String emailId = waterDisconnection.getEmail();
//						String purpose = waterDisconnection.getPurpose();
						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("requestNo", requestNo);
						formData.add("date", date);
						formData.add("contractAccountNo", waterDisconnection.getCINNo());
						formData.add("type", "disconnection");
						formData.add("contactNo", mobileNo);
						formData.add("emailId", emailId);
//						formData.add("purpose", purpose);
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						 String url=CoreConstants.DISCONNECTION_WATER_TEST_POST;

						
						//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						
						long birth_regis_id = waterDisconnectionService.waterDisconnection(waterDisconnection);
						rti.setRtiApplicationRefId(birth_regis_id);
						RTIApplication retunRti = rtiApplicationService.merge(rti);
					if ((retunRti != null) && (birth_regis_id > 0)) {
						waterDisconnectionRestDTO.setResponseStatus("Requested data saved successfully");
						waterDisconnectionRestDTO.setApplicantIdProofPdf("");
						waterDisconnectionRestDTO.setOwnershipProofpdf("");
						waterDisconnectionRestDTO.setResult(retunRti.getRtiApplnNumber());
						waterDisconnectionRestDTO.setResponseCode(200);
						waterDisconnectionRestDTO.setStatus("ok");
						reponse.setStatus(HttpStatus.OK.value());

					}
					String name = waterDisconnection.getCINNo();
					String applnNo = rti.getRtiApplnNumber();
					String rtimobileNo = rti.getMobileNumber();
					String email=waterDisconnection.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, rtimobileNo, applnNo, email);
			}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					waterDisconnectionRestDTO.setResult(message.toString());
					waterDisconnectionRestDTO.setResponseStatus("Requested data not saved successfully");
					waterDisconnectionRestDTO.setResponseStatus("Requested data saved successfully");
					waterDisconnectionRestDTO.setApplicantIdProofPdf("");
					waterDisconnectionRestDTO.setOwnershipProofpdf("");
					waterDisconnectionRestDTO.setResponseCode(500);
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					waterDisconnectionRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			waterDisconnectionRestDTO.setResponseStatus(ex.getMessage());
			waterDisconnectionRestDTO.setResponseCode(405);
			waterDisconnectionRestDTO.setResponseStatus("Requested data saved successfully");
			waterDisconnectionRestDTO.setApplicantIdProofPdf("");
			waterDisconnectionRestDTO.setOwnershipProofpdf("");
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			waterDisconnectionRestDTO.setStatus("Method not Allowed");
		}
		return waterDisconnectionRestDTO;
	}

	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "waterDisconnection";
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
					String url = CoreConstants.UPLOAD_PATH;
					filesPath = url + "waterDisconnection" + File.separator + fileName;
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
