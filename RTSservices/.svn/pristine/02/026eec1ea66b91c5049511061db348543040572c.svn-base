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
import com.mars.rti.model.WaterConnectionNoDue;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionNoDueService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.WaterNoDuesRestDTO;

@Controller
public class WaterNoDuesRestController {

	private static Log log = LogFactory.getLog(WaterNoDuesRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private WaterConnectionNoDueService waterService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveWaterNoDues")
	public @ResponseBody WaterNoDuesRestDTO saveWaterNoDues(@RequestBody WaterNoDuesRestDTO waterdto,HttpServletRequest request,HttpServletResponse response)throws SecurityException{
		
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[0];
		
		WaterConnectionNoDue water = new WaterConnectionNoDue();
		try {
			//CAN No.
			if (waterdto.getCanNo() != null && !waterdto.getCanNo().isEmpty()) {
				water.setCinNo(waterdto.getCanNo());
			} else {
				String can = "CanNo. field is Required";
				condition = false;
				message.append(can).append(",");
			}
			
			//Zone No
				if (waterdto.getCanNo() != null && !waterdto.getCanNo().isEmpty()) {

				water.setZoneNo(String.valueOf(waterdto.getZoneNo()));

			} else {
				String zone = "ZoneNo. is Required";
				condition = false;
				message.append(zone).append(",");
			}
			//existingConsumerName
			if (waterdto.getExistingConsumerName() != null && !waterdto.getExistingConsumerName().isEmpty()) {
				water.setConsumerName(waterdto.getExistingConsumerName());
			} else {
				String consumerName = "Existing Consumer Name field is Required";
				condition = false;
				message.append(consumerName).append(",");
			}
			//meterNo
			if (waterdto.getMeterNo() != null && !waterdto.getMeterNo().isEmpty()) {
				water.setMeterNo(waterdto.getMeterNo());
			} else {
				String meterNo = "Meter No. field is Required";
				condition = false;
				message.append(meterNo).append(",");
			}
			
			//tapSize
			if (waterdto.getTapSize() != null && !waterdto.getTapSize().isEmpty()) {
				water.setTap_size(waterdto.getTapSize());
			} else {
				String tapSize = "Tap Size field is Required";
				condition = false;
				message.append(tapSize).append(",");
			}
			
			//category
			if (waterdto.getCategory() != null && !waterdto.getCategory().isEmpty()) {
				water.setCategory(waterdto.getCategory());
			} else {
				String category = "Category field is Required";
				condition = false;
				message.append(category).append(",");
			}
			
			//balanceArrears
			if (waterdto.getBalanceArrears() != null && !waterdto.getBalanceArrears().isEmpty()) {
				water.setBalance_arrears(waterdto.getBalanceArrears());
			} else {
				String balanceArrears = "Balance Arrears field is Required";
				condition = false;
				message.append(balanceArrears).append(",");
			}
			
			//cutOffDate
			if (waterdto.getCutOffDate() != null && !waterdto.getCutOffDate().isEmpty()) {
				water.setCut_off_date(waterdto.getCutOffDate());
			} else {
				String cutOffDate = "CutOffDate field is Required";
				condition = false;
				message.append(cutOffDate).append(",");
			}
			
			//consumerAddress
			if (waterdto.getConsumerAddress() != null && !waterdto.getConsumerAddress().isEmpty()) {
				water.setConsumerAddress(waterdto.getConsumerAddress());
			} else {
				String conumerAddress = "Consumer Address field is Required";
				condition = false;
				message.append(conumerAddress).append(",");
			}
			
			//esr
			if (waterdto.getEsr() != null && !waterdto.getEsr().isEmpty()) {
				water.setExistingEsr(waterdto.getEsr());
			} else {
				String esr = "Esr field is Required";
				condition = false;
				message.append(esr).append(",");
			}
			
			//consumerEmailId
			if (waterdto.getConsumerEmailId() != null && !waterdto.getConsumerEmailId().isEmpty()) {
				water.setEmailId(waterdto.getConsumerEmailId());
			} else {
				String consumerEmailId = "consumerEmailId field is Required";
				condition = false;
				message.append(consumerEmailId).append(",");
			}
			
			
			//consumerMobileNo
			long consumerMobileNo = waterdto.getConsumerMobileNo();
			if (consumerMobileNo != 0 && String.valueOf(consumerMobileNo).length() > 0) {
				water.setMobileNo(String.valueOf(consumerMobileNo));
			} else {
			    String errorMessage = "consumerMobileNo field is Required";
			    condition = false;
			    message.append(errorMessage).append(",");
			}

			
			
						
			//alternateMobileNo
			water.setAlterMobileNo(String.valueOf(waterdto.getAlternateMobileNo()));

			
			
			
			//Files
		
			
			//save files method
//			String savedFilePath = WaterNoDuesRestController
//					.saveFile(files, servletContext, request);
			
			RTIApplication rtiApplication = new RTIApplication();
			if (waterdto.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						waterdto.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-NO-DUES-CERTIFICATE");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(68);
//				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setPhoneNumber(water.getMobileNo());
				rtiApplication.setMobileNumber(water.getMobileNo());
				
				
				if (water.getAlterMobileNo() != null && !water.getAlterMobileNo().isEmpty()) {
					rtiApplication.setMobileNumber(water.getAlterMobileNo());
				}else {
					rtiApplication.setMobileNumber(water.getMobileNo());
				}

				rtiApplication.setEmail(water.getEmailId());

				if(water.getZoneNo() != null) {			   
					rtiApplication.setZone(
							water.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| water.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								water.getZoneNo().equals("Zone No.2 - Dharampeth") || water.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
									water.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| water.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
										water.getZoneNo().equals("Zone No.4 - Dhantoli")|| water.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
											water.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| water.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
												water.getZoneNo().equals("Zone No.6 - Gandhibagh")|| water.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
													water.getZoneNo().equals("Zone No.7 - Satranjipura")|| water.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
														water.getZoneNo().equals("Zone No.8 - Lakadganj")|| water.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
															water.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| water.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
																water.getZoneNo().equals("Zone No.10 - Mangalwari")|| water.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
						    "");
					}


				rtiApplication.setApplicantName(water.getFullName());
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
					water.setRtiapplrefno(rti.getRtiApplnNumber());
					water.setRti_ref_id(savedRti.getRtiApplicationId());
					String requestNo = water.getRtiapplrefno();
					LocalDate currentDate = LocalDate.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String date = format.format(currentDate);
					String contractAccountNo = water.getCinNo();
					String contactNo = water.getMobileNo();
					String emailId = water.getEmailId();
//					String purpose = water.getPurposeOfNoDue();

					MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
					formData.add("requestNo", water.getRtiapplrefno());
					formData.add("date", date);
					formData.add("contractAccountNo", contractAccountNo);
					formData.add("contactNo", contactNo);
					formData.add("emailId", emailId);
					formData.add("type", "noDueCertificate");
//					formData.add("purpose", purpose);

					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
					HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
					String url=CoreConstants.NO_DUES_WATER_TEST_POST;

					//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
							requestEntity, String.class);
					
					long birth_regis_id = waterService.fetchWaterCertificate(water);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					
					if ((retunRti != null) && (birth_regis_id > 0)) {
						waterdto.setResponseStatus("Requested data saved successfully");
						waterdto.setResponseCode(200);
						waterdto.setResult(retunRti.getRtiApplnNumber());
						waterdto.setStatus("ok");
						response.setStatus(HttpStatus.OK.value());
						
					}
					String name = water.getCinNo();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = rti.getMobileNumber();
					String email=water.getEmailId();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					waterdto.setResult(message.toString());
					waterdto.setResponseStatus("Requested data not saved successfully");
					waterdto.setResponseCode(500);
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					waterdto.setStatus("Internal Server Error");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			waterdto.setResponseStatus(ex.getMessage());
			waterdto.setResponseCode(405);
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			waterdto.setStatus("Method not Allowed");
			
		}

		return waterdto;
	}

	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "waterConnectionNoDue";
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
					filesPath = url + "waterConnectionNoDue" + File.separator + fileName;
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
