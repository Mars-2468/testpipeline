	
	package com.mars.rti.ws.controller;

	import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
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
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.IllegalWaterConnectionComplaint;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.IllegalWaterConnectionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.IllegalWaterConnectionRestDTO;

	@Controller
	public class IllegalWaterConnectionRestController {

		private static Log log = LogFactory
				.getLog(IllegalWaterConnectionRestController.class);

		@Autowired
		private RTIApplicationService rtiApplicationService;

		@Autowired
		private IllegalWaterConnectionService illegalWaterConnectionService;
		
		@RequestMapping(method = RequestMethod.POST, value = "/saveIllegalWaterConnectionComplaint")
		public @ResponseBody IllegalWaterConnectionRestDTO saveIllegalWaterConnectionComplaint(
				@RequestBody IllegalWaterConnectionRestDTO waterdto,
				HttpServletRequest request, HttpServletResponse reponse)
				throws ServletException {
			boolean condition = true;
			StringBuilder message = new StringBuilder();
			String[] files = new String[5];

			IllegalWaterConnectionComplaint water = new IllegalWaterConnectionComplaint();
			try {
				if (waterdto.getTitle() != null && !waterdto.getTitle().isEmpty()) {
					water.setTitle(waterdto.getTitle());
				} else {

					String title = "Title field is Required";
					condition = false;
					message.append(title).append(",");

				}

				if (waterdto.getName() != null && !waterdto.getName().isEmpty()) {
					water.setFirstName(waterdto.getName());
				} else {

					String name = "Name field is Required";
					condition = false;
					message.append(name).append(",");

				}
				water.setMiddleName(waterdto.getFatherName());

				if (waterdto.getSurname() != null
						&& !waterdto.getSurname().isEmpty()) {
					water.setLastName(waterdto.getSurname());
				} else {

					String surname = "Surname field is Required";
					condition = false;
					message.append(surname).append(",");

				}

				if (waterdto.getFullName() != null
						&& !waterdto.getFullName().isEmpty()) {
					water.setFullName(waterdto.getFullName());
				} else {

					String fullname = "Full Name field is Required";
					condition = false;
					message.append(fullname).append(",");

				}
				water.setBuildingName(waterdto.getBuildingName());
				water.setLandmark(waterdto.getLandmark());
				water.setAadharNo(waterdto.getAadhaarNo());

				if (waterdto.getStreetName() != null
						&& !waterdto.getStreetName().isEmpty()) {
					water.setStreetName(waterdto.getStreetName());
				} else {

					String streetname = "Street Name field is Required";
					condition = false;
					message.append(streetname).append(",");

				}

				if (waterdto.getPinCode() != 0) {
					water.setPinCode(String.valueOf(waterdto.getPinCode()));
				} else {

					String pincode = "Pincode field is Required";
					condition = false;
					message.append(pincode).append(",");

				}

				if (waterdto.getAreaName() != null
						&& !waterdto.getAreaName().isEmpty()) {
					water.setAreaName(waterdto.getAreaName());
				} else {

					String area = "Area Name field is Required";
					condition = false;
					message.append(area).append(",");

				}

				if (waterdto.getMobileNo() != 0) {
					water.setMobileNo(String.valueOf(waterdto.getMobileNo()));
				} else {

					String mobile = "Mobile Number field is Required";
					condition = false;
					message.append(mobile).append(",");

				}

				if (waterdto.getPlotNo() != null
						&& !waterdto.getPlotNo().isEmpty()) {
					water.setPlotNo(waterdto.getPlotNo());
				} else {

					String plotno = "plot Number field is Required";
					condition = false;
					message.append(plotno).append(",");

				}

				if (waterdto.getEmail() != null && !waterdto.getEmail().isEmpty()) {
					water.setEmailId(waterdto.getEmail());
				} else {

					String email = "Email field is Required";
					condition = false;
					message.append(email).append(",");

				}

				if (waterdto.getApplicantcity() != null
						&& !waterdto.getApplicantcity().isEmpty()) {
					water.setApplicantcity(waterdto.getApplicantcity());
				} else {

					String city = "City Name field is Required";
					condition = false;
					message.append(city).append(",");

				}

				if (waterdto.getFullAddress() != null
						&& !waterdto.getFullAddress().isEmpty()) {
					water.setAddressForCorrespondence(waterdto.getFullAddress());
				} else {

					String address = "Full Address field is Required";
					condition = false;
					message.append(address).append(",");

				}

				if (waterdto.getConsumerType() != null
						&& !waterdto.getConsumerType().isEmpty()) {
					water.setConsumer(waterdto.getConsumerType());
				} else {

					String consumer = "Consumer Type field is Required";
					condition = false;
					message.append(consumer).append(",");

				}
				if (waterdto.getConsumerType().equals("AnonymousConsumer")) {
					if (waterdto.getAnonymousConsumerZoneNo() != 0) {
						water.setZoneNo(String
								.valueOf(waterdto.getAnonymousConsumerZoneNo()));

					} else {

						String anonymousZone = "Zone Number field is Required";
						condition = false;
						message.append(anonymousZone).append(",");

					}
				} else if (waterdto.getConsumerType().equals("ExistingConsumer")) {
					water.setZoneNo(String
							.valueOf(waterdto.getAnonymousConsumerZoneNo()));

				}
				
				if (waterdto.getConsumerType().equals("AnonymousConsumer")) {
					if (waterdto.getAnonymousConsumerEsr() != null && !waterdto.getAnonymousConsumerEsr().isEmpty()) {
						water.setEsr(waterdto.getAnonymousConsumerEsr());

					} else {

						String anonymousEsr = "ESR field is Required";
						condition = false;
						message.append(anonymousEsr).append(",");

					}
				} else if (waterdto.getConsumerType().equals("ExistingConsumer")) {
					water.setEsr(waterdto.getAnonymousConsumerEsr());

				}
				if (waterdto.getConsumerType().equals("ExistingConsumer")) {

				if (waterdto.getCanNo() != null && !waterdto.getCanNo().isEmpty()) {
					water.setCinNo(waterdto.getCanNo());
				} else {

					String canno = "CAN Number field is Required";
					condition = false;
					message.append(canno).append(",");

				}
				} else if (waterdto.getConsumerType().equals("AnonymousConsumer")) {
					water.setCinNo("");

				}
				if (waterdto.getConsumerType().equals("ExistingConsumer")) {
					if (waterdto.getExistingConsumerZoneNo() != 0) {
						water.setExistingZone(String.valueOf(waterdto.getExistingConsumerZoneNo()));

					} else {

						String existingzone = "Zone field is Required";
						condition = false;
						message.append(existingzone).append(",");

					}
				} else if (waterdto.getConsumerType().equals("AnonymousConsumer")) {
					water.setExistingZone(String.valueOf(waterdto.getExistingConsumerZoneNo()));

				}
				
				if (waterdto.getConsumerType().equals("ExistingConsumer")) {
					if (waterdto.getExistingConsumerEsr() != null && !waterdto.getExistingConsumerEsr().isEmpty()) {
						water.setExistingEsr(waterdto.getExistingConsumerEsr());

					} else {

						String existingesr = "ESR field is Required";
						condition = false;
						message.append(existingesr).append(",");

					}
				} else if (waterdto.getConsumerType().equals("AnonymousConsumer")) {
					water.setExistingEsr(waterdto.getExistingConsumerEsr());

				}
				
				if (waterdto.getConsumerName() != null && !waterdto.getConsumerName().isEmpty()) {
					water.setConsumerName(waterdto.getConsumerName());
				} else {

					String consumername = "Consumer Name field is Required";
					condition = false;
					message.append(consumername).append(",");

				}
				
				if (waterdto.getConsumerAddress() != null && !waterdto.getConsumerAddress().isEmpty()) {
					water.setConsumerAddress(waterdto.getConsumerAddress());
				} else {

					String addressexisting = "Consumer Address field is Required";
					condition = false;
					message.append(addressexisting).append(",");

				}
				water.setConsumerNo(waterdto.getConsumerNo());

							
				if (waterdto.getMeterNo() != null && !waterdto.getMeterNo().isEmpty()) {
					water.setMeterNo(waterdto.getMeterNo());
				} else {

					String meterNo = "Meter Number field is Required";
					condition = false;
					message.append(meterNo).append(",");

				}

				if (waterdto.getDepositReceiptNo() != null && !waterdto.getDepositReceiptNo().isEmpty()) {
					water.setDepositReceiptNo(waterdto.getDepositReceiptNo());
				} else {

					String depositreceiptno = "Deposit Receipt Number field is Required";
					condition = false;
					message.append(depositreceiptno).append(",");

				}
				if (waterdto.getReceiptDate() != null && !waterdto.getReceiptDate().isEmpty()) {
					water.setDepositReceiptDate(waterdto.getReceiptDate());
				} else {

					String depositreceiptdate = "Deposit Receipt Date field is Required";
					condition = false;
					message.append(depositreceiptdate).append(",");

				}
				
				
				
				if (waterdto.getProblemDescription() != null && !waterdto.getProblemDescription().isEmpty()) {
					water.setPurposeOfIllegalConn(waterdto.getProblemDescription());
				} else {

					String problem = "Problem Description field is Required";
					condition = false;
					message.append(problem).append(",");

				}
				
				
				
				//Files
				if (waterdto.getApplicantIDProof() != null
						&& !waterdto.getApplicantIDProof()
								.isEmpty()) {
					String doc0 = waterdto.getApplicantIDProof();
					files[0] = doc0;
				} else {
					String doc0 = "Applicant Id Proof field is Required";
					condition = false;
					message.append(doc0).append(",");
				}

				if (waterdto.getCopyOfCurrentBill() != null
						&& !waterdto.getCopyOfCurrentBill()
								.isEmpty()) {
					String doc1 = waterdto.getCopyOfCurrentBill();
					files[1] = doc1;
				} else {
					String doc1 = "Current Bill Copy field is Required";
					condition = false;
					message.append(doc1).append(",");
				}
				
				if (waterdto.getCopyOfDemandPaidReceipt() != null
						&& !waterdto.getCopyOfDemandPaidReceipt()
								.isEmpty()) {
					String doc2 = waterdto.getCopyOfDemandPaidReceipt();
					files[2] = doc2;
				} else {
					String doc2 = "Demand Paid Proof field is Required";
					condition = false;
					message.append(doc2).append(",");
				}
				
				if (waterdto.getCopyOfOnwershipproof() != null
						&& !waterdto.getCopyOfOnwershipproof()
								.isEmpty()) {
					String doc3 = waterdto.getCopyOfOnwershipproof();
					files[3] = doc3;
				} else {
					String doc3 = "Ownership Proof field is Required";
					condition = false;
					message.append(doc3).append(",");
				}
				
				if (waterdto.getSignatureOfConsumer() != null
						&& !waterdto.getSignatureOfConsumer()
								.isEmpty()) {
					String doc4 = waterdto.getSignatureOfConsumer();
					files[4] = doc4;
				} else {
					String doc4 = "Signature of Consumer field is Required";
					condition = false;
					message.append(doc4).append(",");
				}
				
				//save files method
				String savedFilePath = IllegalWaterConnectionRestController
						.saveFile(files, request);
				
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
				rtiApplication.setSubject("ILLEGAL-WATER-CONNECTION");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(63);
				rtiApplication.setApplicantName(water.getFirstName() + " "
						+ water.getMiddleName() + " " + water.getLastName());
				rtiApplication.setPhoneNumber(water.getMobileNo());
				rtiApplication.setMobileNumber(water.getMobileNo());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setZone(water.getZoneNo());

				rtiApplication.setEmail(water.getEmailId());
				rtiApplication.setApplicantName(water.getFullName());
				rtiApplication.setPdfUploadFromPortal(water.getFilesPath());
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(3);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
				String anonymous_status = water.getConsumer();
				String a = "false";
				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					water.setRtiApplRefNo(rti.getRtiApplnNumber());
					water.setRtiRefId(savedRti.getRtiApplicationId());
					if ((anonymous_status.equals(a))) {
						String requestNo = water.getRtiApplRefNo();
						LocalDateTime currentDateTime = LocalDateTime.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						String dateTime = format.format(currentDateTime);
						String title = water.getTitle();
						String contractAccountNo = water.getCinNo();
						String house_no = water.getPlotNo();
						String building_name = water.getBuildingName();
						String landmark = water.getLandmark();
						String locality = water.getAreaName();
						String zone = water.getZoneNo();
						String emailId = water.getEmailId();
						String Nearest_location = water.getStreetName();
						String name = water.getFullName();
						String contactNo = water.getMobileNo();
						String existingZone = water.getExistingZone();
						String existingEsr = water.getEsr();
						String problem = water.getPurposeOfIllegalConn();

						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("id", "3");
						formData.add("Request_No", requestNo);
						formData.add("contractAccountNo", contractAccountNo);
						formData.add("title", title);
						formData.add("name", name);
						formData.add("house_no", house_no);
						formData.add("building_name", building_name);
						formData.add("landmark", landmark);
						formData.add("locality", locality);
						formData.add("zone", existingZone);
						formData.add("esr_code", existingEsr);
						formData.add("emailId", emailId);
						formData.add("contactNo", contactNo);
						formData.add("Comp_maincat", "technical_complaints");
						formData.add("Comp_Subcat1", "illegal_water");
						formData.add("Comp_Subcat2", "illegal_water");
						formData.add("Nearest_location", Nearest_location);
						formData.add("Problem_desc", problem);
						formData.add("Reg_date", dateTime);
						formData.add("anonymous_check", anonymous_status);
						formData.add("type", "non-anonymous");

						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						String url = "https://sampark.ocwindia.com/aaplesarkar/customer/Consumer_Complaint/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						if (log.isDebugEnabled()) {

							log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
						}
					} else {
						String requestNo = water.getRtiApplRefNo();
						LocalDateTime currentDateTime = LocalDateTime.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						String dateTime = format.format(currentDateTime);
						String title = water.getTitle();
						String contractAccountNo = water.getCinNo();
						String house_no = water.getPlotNo();
						String building_name = water.getBuildingName();
						String landmark = water.getLandmark();
						String locality = water.getAreaName();
						String zone = water.getZoneNo();
						String emailId = water.getEmailId();
						String Nearest_location = water.getStreetName();
						String name = water.getFullName();
						String contactNo = water.getMobileNo();
						String esr = water.getEsr();
						String problem = water.getPurposeOfIllegalConn();

						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("id", "3");
						formData.add("Request_No", requestNo);
						formData.add("title", title);
						formData.add("name", name);
						formData.add("house_no", house_no);
						formData.add("building_name", building_name);
						formData.add("landmark", landmark);
						formData.add("locality", locality);
						formData.add("zone", zone);
						formData.add("esr_code", esr);
						formData.add("emailId", emailId);
						formData.add("contactNo", contactNo);
						formData.add("Comp_maincat", "technical_complaints");
						formData.add("Comp_Subcat1", "illegal_water");
						formData.add("Comp_Subcat2", "illegal_water");
						formData.add("Nearest_location", Nearest_location);
						formData.add("Problem_desc", problem);
						formData.add("Reg_date", dateTime);
						formData.add("anonymous_check", anonymous_status);
						formData.add("type", "anonymous");

						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						String url = "https://sampark.ocwindia.com/aaplesarkar/customer/Consumer_Complaint/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						if (log.isDebugEnabled()) {

							log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
						}

					}
					
					long birth_regis_id = illegalWaterConnectionService.illegalWaterConnectionComplaint(water);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					
					if ((retunRti != null) && (birth_regis_id > 0)) {
						waterdto.setResponseStatus("Requested data saved successfully");
						waterdto.setApplicantIDProof("");
						waterdto.setCopyOfCurrentBill("");
						waterdto.setCopyOfDemandPaidReceipt("");
						waterdto.setCopyOfOnwershipproof("");
						waterdto.setSignatureOfConsumer("");
						waterdto.setResult(retunRti.getRtiApplnNumber());
						waterdto.setResponseCode(HttpStatus.OK.value());
				reponse.setStatus(HttpStatus.OK.value());
				waterdto.setStatus("ok");
			}
						
					String name = water.getFullName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", water.getMobileNo(), msg);
					SendEmail.sendEmail(water.getEmailId(),
							"Application Submitted Successfully" + applnNo, msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					waterdto.setResult(message.toString());
					waterdto.setResponseStatus("Requested data not saved successfully");
					waterdto.setApplicantIDProof("");
					waterdto.setCopyOfCurrentBill("");
					waterdto.setCopyOfDemandPaidReceipt("");
					waterdto.setCopyOfOnwershipproof("");
					waterdto.setSignatureOfConsumer("");
					waterdto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					waterdto.setStatus("Internal Server Error");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			waterdto.setApplicantIDProof("");
			waterdto.setCopyOfCurrentBill("");
			waterdto.setCopyOfDemandPaidReceipt("");
			waterdto.setCopyOfOnwershipproof("");
			waterdto.setSignatureOfConsumer("");
			log.equals(ex.getMessage());
			waterdto.setResponseStatus(ex.getMessage());
			waterdto.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			waterdto.setStatus("Method not Allowed");
		}

		return waterdto;
	}
		
		
		public static String saveFile(String data[], HttpServletRequest request) throws IOException {
			String filesPath = null;
			StringBuilder filesPathBuilder = new StringBuilder();
			String baseDir = CoreConstants.UPLOAD_PATH + "illegalWaterConnection";
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
