package com.mars.rti.ws.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.PartMap;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PartMapService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PartMapRestDTO;

@Controller
public class PartMapCertificateRestController {
	
	private static Log log = LogFactory.getLog(MandapCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PartMapService partMapService;	
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/savePartMapApplication")
	public @ResponseBody PartMapRestDTO savePartMapApplication(
		   @RequestBody PartMapRestDTO partMapRestDTO,HttpServletRequest request,HttpServletResponse reponse) throws ServletException{

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];

		
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMandapApplication");
		}
		PartMap partMap = new PartMap();

		try {
			if(partMapRestDTO.getTitle()!=null&&!partMapRestDTO.getTitle().isEmpty()) {
				partMap.setTitle(partMapRestDTO.getTitle());
			}else
			{
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			
			if(partMapRestDTO.getName()!=null&&!partMapRestDTO.getName().isEmpty()) {
				partMap.setFirstName(partMapRestDTO.getName());
			}else
			{
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
			partMap.setMiddleName(partMapRestDTO.getFatherName());
			
			if(partMapRestDTO.getSurname()!=null&&!partMapRestDTO.getSurname().isEmpty()) {
				partMap.setLastName(partMapRestDTO.getSurname());
			}else
			{
				String lastName = "Surname field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			if(partMapRestDTO.getFullName()!=null&&!partMapRestDTO.getFullName().isEmpty()) {
				partMap.setFullName(partMapRestDTO.getFullName());
			}else
			{
				String lastName = "FullName field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			if(partMapRestDTO.getPinCode()!=0) {
				partMap.setPinCode(partMapRestDTO.getPinCode());
			}else
			{
				String pinCode = "PinCode field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			
			partMap.setAadharNo(String.valueOf(partMapRestDTO.getAadharNo()));
			if(partMapRestDTO.getEmail()!=null&&!partMapRestDTO.getEmail().isEmpty()) {
				partMap.setEmail(partMapRestDTO.getEmail());
			}else
			{
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			
			if(partMapRestDTO.getMobileNo()!=0) {
				partMap.setMobileNo(String.valueOf(partMapRestDTO.getMobileNo()));
			}else
			{
				String mobileNumber = "Mobile Number  field is Required";
				condition = false;
				message.append(mobileNumber).append(",");
			}
			
			if(partMapRestDTO.getFullAddress()!=null&&!partMapRestDTO.getFullAddress().isEmpty()) {
				partMap.setFullAddress(partMapRestDTO.getFullAddress());
			}else
			{
				String fullAddress = "Full Address field is Required";
				condition = false;
				message.append(fullAddress).append(",");
			}
			
			if(partMapRestDTO.getKhasaraNo()!= 0) {
				partMap.setKhasaraNo(String.valueOf(partMap.getKhasaraNo()));
			}else
			{
				String khasaraNo = "KhasaraNo field is Required";
				condition = false;
				message.append(khasaraNo).append(",");
			}
			
//			if(partMapRestDTO.getZoneNo()!=0) {
//				partMap.setZoneNo(String.valueOf(partMapRestDTO.getZoneNo()));
//			}else
//			{
//				String zoneNo = "Zone no  field is Required";
//				condition = false;
//				message.append(zoneNo).append(",");
//			}
			
			//partMap.setZoneNo(String.valueOf(partMapRestDTO.getZoneNo()));
			partMap.setZoneNo(String.valueOf(partMap.getZoneNo()));
			
			if(partMapRestDTO.getCitySurveyNo()!=null&&!partMapRestDTO.getCitySurveyNo().isEmpty()) {
				partMap.setCitySurveyNo(partMapRestDTO.getCitySurveyNo());
			}else
			{
				String citySurveyNo = "City Survey No field is Required";
				condition = false;
				message.append(citySurveyNo).append(",");
			}
			
			if(partMapRestDTO.getMouje()!=null&&!partMapRestDTO.getMouje().isEmpty()) {
				partMap.setMouje(partMapRestDTO.getMouje());
			}else
			{
				String mouza = "Mouza field is Required";
				condition = false;
				message.append(mouza).append(",");
			}
			//Files
			
			
			if (partMapRestDTO.getCitySurvey712Coation() != null
					&& !partMapRestDTO.getCitySurvey712Coation()
							.isEmpty()) {
				String doc1 = partMapRestDTO
						.getCitySurvey712Coation();

				files[0] = doc1;
			} else {
				String doc1 = "City Survey & 7/12 Coation";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (partMapRestDTO.getCityServeyMap() != null
					&& !partMapRestDTO.getCityServeyMap()
							.isEmpty()) {
				String doc2 = partMapRestDTO
						.getCityServeyMap();

				files[1] = doc2;
			} else {
				String doc2 = "City Servey Map";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (partMapRestDTO.getKhasraMap() != null
					&& !partMapRestDTO.getKhasraMap()
							.isEmpty()) {
				String doc3 = partMapRestDTO
						.getKhasraMap();

				files[2] = doc3;
			} else {
				String doc3 = "Khasra Map";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (partMapRestDTO.getApplicantIdProof()!= null
					&& !partMapRestDTO.getApplicantIdProof().isEmpty()) {
				String doc4 = partMapRestDTO.getApplicantIdProof();

				files[3] = doc4;
			} else {
				String doc4 = "Applicant Id Proof field is Required";
				condition = false;
				message.append(doc4).append(",");
			}
			
			String savedFilePath = PartMapCertificateRestController
					.saveFile(files, request);

			RTIApplication rtiApplication = new RTIApplication();
			if (partMapRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						partMapRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			
//			UserRegistrationDetails user = new UserRegistrationDetails();
//			user.setMobileNo(partMapRestDTO.getMobileNo());
			if(condition) {
			rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("PARTMAP-CERTIFICATE");
			rtiApplication.setTemplateName("townPlanning");
			//rtiApplication.setUserRegistrationDetails(user);
			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(28);
			
			
			rtiApplication.setApplicantName(partMap.getFirstName() + " " + partMap.getMiddleName()
					+ " " + partMap.getLastName());
			rtiApplication.setPhoneNumber(partMap.getMobileNo());
			rtiApplication.setMobileNumber(partMap.getMobileNo());
			rtiApplication.setEmail(partMap.getEmail());
			rtiApplication.setZone(String.valueOf(partMap.getZoneNo()));

			//rtiApplication.setApplicationCost(15);

			rtiApplication.setApplicantName(partMap.getFirstName() + " " + partMap.getMiddleName()
					+ " " + partMap.getLastName());
			rtiApplication.setPdfUploadFromPortal(partMap.getFilesPath());
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
				rti.setRtiApplnNumber("RTS/TPD"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
				partMap.setRtiapplrefno(rti.getRtiApplnNumber());
				partMap.setRti_ref_id(savedRti.getRtiApplicationId());
				long birth_regis_id = partMapService.partMap(partMap);
				rti.setRtiApplicationRefId(birth_regis_id);
				// rti.setRtiApplicationRefId(birthRegistrationService.);
				RTIApplication retunRti = rtiApplicationService.merge(rti);

				if ((retunRti != null) && (birth_regis_id > 0)) {
					
					partMapRestDTO.setResponseStatus("Requested data saved successfully");
					partMapRestDTO.setResponseCode(200);
					partMapRestDTO.setResult(retunRti.getRtiApplnNumber());
					partMapRestDTO.setStatus("Ok");
					reponse.setStatus(HttpStatus.OK.value());
					partMapRestDTO.setCitySurvey712Coation("");
					partMapRestDTO.setCityServeyMap("");
					partMapRestDTO.setKhasraMap("");
					partMapRestDTO.setApplicantIdProof("");
				}

				String name=partMap.getFirstName()+partMap.getMiddleName()+partMap.getLastName();
				String link = "https://tinyurl.com/4hhhy9w9";
				String applnNo= rti.getRtiApplnNumber();


				
				String msg = "Dear "+name+" your application with Application No. "+applnNo+" submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
				
				msg.replace("var3", "");

				SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", partMap.getMobileNo(), msg);
				SendEmail.sendEmail(partMap.getEmail(), "Application Submitted Successfully" + applnNo, msg);
			}
		}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						partMapRestDTO.setResult(message.toString());
						partMapRestDTO.setResponseStatus("Requested data not saved successfully");
						partMapRestDTO.setResponseCode(500);
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						partMapRestDTO.setStatus("Internal Server Error");
						partMapRestDTO.setCitySurvey712Coation("");
						partMapRestDTO.setCityServeyMap("");
						partMapRestDTO.setKhasraMap("");
						partMapRestDTO.setApplicantIdProof("");

					}
				}
		}catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			partMapRestDTO.setResponseStatus(ex.getMessage());
			partMapRestDTO.setResponseCode(405);
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			partMapRestDTO.setStatus("Method Not Allowed");
			partMapRestDTO.setCitySurvey712Coation("");
			partMapRestDTO.setCityServeyMap("");
			partMapRestDTO.setKhasraMap("");
			partMapRestDTO.setApplicantIdProof("");

		}

		return partMapRestDTO;
	}
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "partMap";
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
