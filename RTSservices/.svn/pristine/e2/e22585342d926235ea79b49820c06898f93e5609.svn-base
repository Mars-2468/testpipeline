package com.mars.rti.ws.controller;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterPressure;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterPressureService;
import com.mars.rti.ws.model.WaterConnectionForceCertificateRestDTO;

@Controller
public class WaterConnectionForceCertificateRestController 
{
	private static Log log = LogFactory.getLog(MandapCertificateRestController.class);

	@Autowired
	private WaterPressureService waterPressureService; 
	
	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/savewaterConnectionForceCertificate")
	public @ResponseBody WaterConnectionForceCertificateRestDTO savewaterConnectionForceCertificateRestDTO(
		   @RequestBody WaterConnectionForceCertificateRestDTO waterConnectionForceCertificateRestDTO,HttpServletResponse reponse,  HttpServletRequest request) throws ServletException{

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];

		
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMandapApplication");
		}
		WaterPressure waterPressure = new WaterPressure();
		
		try {
			if(waterConnectionForceCertificateRestDTO.getTitle()!=null&&!waterConnectionForceCertificateRestDTO.getTitle().isEmpty()) {
				waterPressure.setTitle(waterConnectionForceCertificateRestDTO.getTitle());
			}else
			{
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			if(waterConnectionForceCertificateRestDTO.getName()!=null&&!waterConnectionForceCertificateRestDTO.getName().isEmpty()) {
				waterPressure.setTitle(waterConnectionForceCertificateRestDTO.getName());
			}else
			{
				String firstName = "First Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
			waterPressure.setMiddleName(waterConnectionForceCertificateRestDTO.getFatherName());
			
			if(waterConnectionForceCertificateRestDTO.getSurname()!=null&&!waterConnectionForceCertificateRestDTO.getSurname().isEmpty()) {
				waterPressure.setTitle(waterConnectionForceCertificateRestDTO.getSurname());
			}else
			{
				String lastName = "Last Name field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			if(waterConnectionForceCertificateRestDTO.getFullName()!=null&&!waterConnectionForceCertificateRestDTO.getFullName().isEmpty()) {
				waterPressure.setFullName(waterConnectionForceCertificateRestDTO.getFullName());
			}else
			{
				String fullName = "Full Name field is Required";
				condition = false;
				message.append(fullName).append(",");
			}
			if(waterConnectionForceCertificateRestDTO.getPlotNo()!=null&&!waterConnectionForceCertificateRestDTO.getPlotNo().isEmpty()) {
				waterPressure.setPlotNo(waterConnectionForceCertificateRestDTO.getPlotNo());
			}else
			{
				String plotNo = "Plot No field is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			
			waterPressure.setBuildingName(waterConnectionForceCertificateRestDTO.getBuildingName());
			
			if(waterConnectionForceCertificateRestDTO.getStreetName()!=null&&!waterConnectionForceCertificateRestDTO.getStreetName().isEmpty()) {
				waterPressure.setStreetName(waterConnectionForceCertificateRestDTO.getStreetName());
			}else
			{
				String streetName = "Street Name field is Required";
				condition = false;
				message.append(streetName).append(",");
			}
			
			if(waterConnectionForceCertificateRestDTO.getAreaName()!=null&&!waterConnectionForceCertificateRestDTO.getAreaName().isEmpty()) {
				waterPressure.setAreaName(waterConnectionForceCertificateRestDTO.getAreaName());
			}else
			{
				String areaName = "Area Name field is Required";
				condition = false;
				message.append(areaName).append(",");
			}
			
			waterPressure.setLandmark(waterConnectionForceCertificateRestDTO.getLandmark());
			
			if(waterConnectionForceCertificateRestDTO.getPinCode()!=null&&!waterConnectionForceCertificateRestDTO.getPinCode().isEmpty()) {
				waterPressure.setPinCode(waterConnectionForceCertificateRestDTO.getPinCode());
			}else
			{
				String pinCode = "Pin Code field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			waterPressure.setAadhaarNo(waterConnectionForceCertificateRestDTO.getAadhaarNo());
			
			if(waterConnectionForceCertificateRestDTO.getEmail()!=null&&!waterConnectionForceCertificateRestDTO.getEmail().isEmpty()) {
				waterPressure.setEmail(waterConnectionForceCertificateRestDTO.getEmail());
			}else
			{
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if(waterConnectionForceCertificateRestDTO.getMobileNo()!=null&&!waterConnectionForceCertificateRestDTO.getMobileNo().isEmpty()) {
				waterPressure.setMobileNo(waterConnectionForceCertificateRestDTO.getMobileNo());
			}else
			{
				String mobileNo = "Mobile No field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			
			if(waterConnectionForceCertificateRestDTO.getFullAddress()!=null&&!waterConnectionForceCertificateRestDTO.getFullAddress().isEmpty()) {
				waterPressure.setFullAddress(waterConnectionForceCertificateRestDTO.getFullAddress());
			}else
			{
				String fullAddress = "Full Address field is Required";
				condition = false;
				message.append(fullAddress).append(",");
			}
			
			if (waterConnectionForceCertificateRestDTO.getConsumer() != null
					&& !waterConnectionForceCertificateRestDTO.getConsumer().isEmpty()) {
				waterPressure.setConsumer(waterConnectionForceCertificateRestDTO.getConsumer());
			} else {

				String consumer = "Consumer Type field is Required";
				condition = false;
				message.append(consumer).append(",");

			}
			if (waterConnectionForceCertificateRestDTO.getConsumer().equals("AnonymousConsumer")) {
				if (waterConnectionForceCertificateRestDTO.getZoneNo() != 0) {
					waterPressure.setZoneNo(String.valueOf(waterConnectionForceCertificateRestDTO.getZoneNo()));
				} else {

					String anonymousZone = "Zone Number field is Required";
					condition = false;
					message.append(anonymousZone).append(",");

				}
			} else if (waterConnectionForceCertificateRestDTO.getConsumer().equals("ExistingConsumer")) {
					waterPressure.setZoneNo(String.valueOf(waterConnectionForceCertificateRestDTO.getExistingZone()));
			}
			
			if (waterConnectionForceCertificateRestDTO.getConsumer().equals("AnonymousConsumer")) {
				if (waterConnectionForceCertificateRestDTO.getEsr() != null && !waterConnectionForceCertificateRestDTO.getEsr().isEmpty()) {
					waterPressure.setEsr(waterConnectionForceCertificateRestDTO.getEsr());

				} else {

					String anonymousEsr = "ESR field is Required";
					condition = false;
					message.append(anonymousEsr).append(",");

				}
			} else if (waterConnectionForceCertificateRestDTO.getConsumer().equals("ExistingConsumer")) {			
				waterPressure.setEsr(waterConnectionForceCertificateRestDTO.getExistingEsr());
			}
			
			if (waterConnectionForceCertificateRestDTO.getConsumer().equals("ExistingConsumer")) {
				if (waterConnectionForceCertificateRestDTO.getExistingZone() != null && !waterConnectionForceCertificateRestDTO.getExistingZone().isEmpty()) {
					waterPressure.setExistingZone(String.valueOf(waterConnectionForceCertificateRestDTO.getExistingZone()));

				} else {

					String existingzone = "Zone field is Required";
					condition = false;
					message.append(existingzone).append(",");

				}
			} else if (waterConnectionForceCertificateRestDTO.getConsumer().equals("AnonymousConsumer")) {
				waterPressure.setExistingZone(String.valueOf(waterConnectionForceCertificateRestDTO.getExistingZone()));

			}
			
			if (waterConnectionForceCertificateRestDTO.getConsumer().equals("ExistingConsumer")) {
				if (waterConnectionForceCertificateRestDTO.getExistingEsr() != null && !waterConnectionForceCertificateRestDTO.getExistingEsr().isEmpty()) {
					waterPressure.setExistingEsr(waterConnectionForceCertificateRestDTO.getExistingEsr());

				} else {

					String existingesr = "ESR field is Required";
					condition = false;
					message.append(existingesr).append(",");

				}
			} else if (waterConnectionForceCertificateRestDTO.getConsumer().equals("AnonymousConsumer")) {
				waterPressure.setExistingEsr(waterConnectionForceCertificateRestDTO.getExistingEsr());

			}
			if (waterConnectionForceCertificateRestDTO.getApplicantIDProof() != null
					&& !waterConnectionForceCertificateRestDTO.getApplicantIDProof()
							.isEmpty()) {
				String doc1 = waterConnectionForceCertificateRestDTO
						.getApplicantIDProof();

				files[0] = doc1;
			} else {
				String doc1 = "Applicant ID Proof";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (waterConnectionForceCertificateRestDTO.getCopyOfCurrentBill() != null
					&& !waterConnectionForceCertificateRestDTO.getCopyOfCurrentBill()
							.isEmpty()) {
				String doc2 = waterConnectionForceCertificateRestDTO
						.getCopyOfCurrentBill();

				files[1] = doc2;
			} else {
				String doc2 = "Copy Of Current Bill";
				condition = false;
				message.append(doc2).append(",");
			}
			
		    if (waterConnectionForceCertificateRestDTO.getConsumer().equals("ExistingConsumer")) {
				if (waterConnectionForceCertificateRestDTO.getCanNO() != null && !waterConnectionForceCertificateRestDTO.getCanNO().isEmpty()) {
					waterPressure.setCINNo(waterConnectionForceCertificateRestDTO.getCanNO());
				} else {

					String canno = "CAN Number field is Required";
					condition = false;
					message.append(canno).append(",");

				}
				     }else {
				    	 waterPressure.setCINNo(waterConnectionForceCertificateRestDTO.getCanNO());
				     }
		    
			
			if (waterConnectionForceCertificateRestDTO.getCopyOfDemandPaidReceipt() != null
					&& !waterConnectionForceCertificateRestDTO.getCopyOfDemandPaidReceipt()
							.isEmpty()) {
				String doc3 = waterConnectionForceCertificateRestDTO
						.getCopyOfDemandPaidReceipt();

				files[2] = doc3;
			} else {
				String doc3 = "Copy Of Demand Paid Receipt";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (waterConnectionForceCertificateRestDTO.getCopyOfAddressOwnershipProof() != null
					&& !waterConnectionForceCertificateRestDTO.getCopyOfAddressOwnershipProof()
							.isEmpty()) {
				String doc4 = waterConnectionForceCertificateRestDTO
						.getCopyOfAddressOwnershipProof();

				files[3] = doc4;
			} else {
				String doc4 = "Copy Of Address Owner ship Proof";
				condition = false;
				message.append(doc4).append(",");
			}
			
			if (waterConnectionForceCertificateRestDTO.getSignatureOfConsumer() != null
					&& !waterConnectionForceCertificateRestDTO.getSignatureOfConsumer()
							.isEmpty()) {
				String doc5 = waterConnectionForceCertificateRestDTO
						.getSignatureOfConsumer();

				files[4] = doc5;
			} else {
				String doc5 = "Applicant ID Proof";
				condition = false;
				message.append(doc5).append(",");
			}
			String savedFilePath = MandapCertificateRestController
					.saveFile(files, request);
			
			RTIApplication rtiApplication = new RTIApplication();
			

			if(condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATERCONNECTIONFORCE-CERTIFICATE");
				rtiApplication.setTemplateName("waterPressure");
				rtiApplication.setDepartment("WATER-DEPARTMENT");

				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(23);
				//rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setApplicantName(   waterPressure.getFirstName() + " " +    waterPressure.getMiddleName()
						+ " " +    waterPressure.getLastName());
				rtiApplication.setPhoneNumber(   waterPressure.getMobileNo());
				rtiApplication.setMobileNumber(   waterPressure.getMobileNo());
				rtiApplication.setZone("2");
				rtiApplication.setEmail(   waterPressure.getEmail());
				rtiApplication.setZone(   waterPressure.getZoneNo());
				rtiApplication.setApplicantName(   waterPressure.getFullName());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
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
				
				
				String anonymous_status = waterPressure.getConsumer();
				String a = "false";
				if (savedRti.getRtiApplicationId() > 0) {
					
					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/ED"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
					   waterPressure.setRtiapplrefno(rti.getRtiApplnNumber());
					   waterPressure.setRti_ref_id(savedRti.getRtiApplicationId());
					   
					   
					   
					   
					   
					   if ((anonymous_status.equals(a))) {
							String requestNo = waterPressure.getRtiapplrefno();
							LocalDateTime currentDateTime = LocalDateTime.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							String dateTime = format.format(currentDateTime);
							String title = waterPressure.getTitle();
							String contractAccountNo = waterPressure.getCINNo();
							String house_no = waterPressure.getPlotNo();
							String building_name = waterPressure.getBuildingName();
							String landmark = waterPressure.getLandmark();
							String locality = waterPressure.getAreaName();
							String zone = waterPressure.getZoneNo();
							String emailId = waterPressure.getEmail();
							String Nearest_location = waterPressure.getStreetName();
							String name = waterPressure.getFullName();
							String contactNo = waterPressure.getMobileNo();
							String existingZone = waterPressure.getExistingZone();
							String existingEsr = waterPressure.getEsr();
							String problem = waterPressure.getProblemDesc();

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
							formData.add("Comp_Subcat1", "waterPressure_quality");
							formData.add("Comp_Subcat2", "waterPressure_quality");
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
							String requestNo = waterPressure.getRtiapplrefno();
							LocalDateTime currentDateTime = LocalDateTime.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							String dateTime = format.format(currentDateTime);
							String title = waterPressure.getTitle();
							String contractAccountNo = waterPressure.getCINNo();
							String house_no = waterPressure.getPlotNo();
							String building_name = waterPressure.getBuildingName();
							String landmark = waterPressure.getLandmark();
							String locality = waterPressure.getAreaName();
							String zone = waterPressure.getZoneNo();
							String emailId = waterPressure.getEmail();
							String Nearest_location = waterPressure.getStreetName();
							String name = waterPressure.getFullName();
							String contactNo = waterPressure.getMobileNo();
							String esr = waterPressure.getEsr();
							String problem = waterPressure.getProblemDesc();

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
							formData.add("Comp_Subcat1", "waterPressure_quality");
							formData.add("Comp_Subcat2", "waterPressure_quality");
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

					   
					   
					   
					   
					   
					long mandap_regis_id =    waterPressureService.   waterPressure(   waterPressure);
					rti.setRtiApplicationRefId(mandap_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
	                   

					if ((retunRti != null) && (mandap_regis_id > 0)) {
						waterConnectionForceCertificateRestDTO.setResponseStatus("Requested data saved successfully");
						waterConnectionForceCertificateRestDTO.setResponse(200);
						waterConnectionForceCertificateRestDTO.setResult(retunRti.getRtiApplnNumber());
						waterConnectionForceCertificateRestDTO.setStatus("ok");
						reponse.setStatus(HttpStatus.OK.value());
						waterConnectionForceCertificateRestDTO.setApplicantIDProof("");
						waterConnectionForceCertificateRestDTO.setCopyOfAddressOwnershipProof("");
						waterConnectionForceCertificateRestDTO.setCopyOfCurrentBill("");
						waterConnectionForceCertificateRestDTO.setCopyOfDemandPaidReceipt("");
						waterConnectionForceCertificateRestDTO.setSignatureOfConsumer("");
					}
					String name=   waterPressure.getFullName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo= rti.getRtiApplnNumber();


					
					String msg = "Dear "+name+" your application with Application No. "+applnNo+" submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
					
					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov",    waterPressure.getMobileNo(), msg);
					SendEmail.sendEmail(   waterPressure.getEmail(), "Application Submitted Successfully" + applnNo, msg);

				}
			}
				if (!condition) {
					if (message.charAt(message.length() - 1) == ',') {
							message.deleteCharAt(message.length() - 1);
							waterConnectionForceCertificateRestDTO.setResult(message.toString());
							waterConnectionForceCertificateRestDTO.setResponseStatus("Requested data not saved successfully");
							waterConnectionForceCertificateRestDTO.setResponse(500);
							waterConnectionForceCertificateRestDTO.setStatus("Internal Server Error");
							reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
							waterConnectionForceCertificateRestDTO.setApplicantIDProof("");
							waterConnectionForceCertificateRestDTO.setCopyOfAddressOwnershipProof("");
							waterConnectionForceCertificateRestDTO.setCopyOfCurrentBill("");
							waterConnectionForceCertificateRestDTO.setCopyOfDemandPaidReceipt("");
							waterConnectionForceCertificateRestDTO.setSignatureOfConsumer("");

						}
					}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			log.equals(ex.getMessage());
			waterConnectionForceCertificateRestDTO.setResponseStatus("Requested data not savedsuccessfully");
			waterConnectionForceCertificateRestDTO.setResponse(405);
			waterConnectionForceCertificateRestDTO.setStatus("Method not Allowed");
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			waterConnectionForceCertificateRestDTO.setApplicantIDProof("");
			waterConnectionForceCertificateRestDTO.setCopyOfAddressOwnershipProof("");
			waterConnectionForceCertificateRestDTO.setCopyOfCurrentBill("");
			waterConnectionForceCertificateRestDTO.setCopyOfDemandPaidReceipt("");
			waterConnectionForceCertificateRestDTO.setSignatureOfConsumer("");

		}
		return waterConnectionForceCertificateRestDTO;
	}
		
}
