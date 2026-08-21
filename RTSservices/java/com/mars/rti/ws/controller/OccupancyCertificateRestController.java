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
import com.mars.rti.model.OccupancyCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.OccupancyCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.OccupancyCertificateRestDTO;
@Controller
public class OccupancyCertificateRestController 
{
	private static Log log = LogFactory.getLog(MandapCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private OccupancyCertificateService occupancyCertificateService;

	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/saveOccupancyCertificate")
	public @ResponseBody OccupancyCertificateRestDTO saveOccupancyCertificate(
		   @RequestBody OccupancyCertificateRestDTO occupancyCertificateRestDTO,HttpServletResponse reponse,HttpServletRequest request) throws ServletException{
		
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMandapApplication");
		}
		OccupancyCertificate  occupancyCertificate = new OccupancyCertificate();
		try {
			if(occupancyCertificateRestDTO.getTitle()!=null&&!occupancyCertificateRestDTO.getTitle().isEmpty()) {
				occupancyCertificate.setTitle(occupancyCertificateRestDTO.getTitle());
			}else
			{
				String tittle = "Tittle field is Required";
				condition = false;
				message.append(tittle).append(",");
			}
			if(occupancyCertificateRestDTO.getName()!=null&&!occupancyCertificateRestDTO.getName().isEmpty()) {
				occupancyCertificate.setFirstName(occupancyCertificateRestDTO.getName());
			}else
			{
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
				occupancyCertificate.setMiddleName(occupancyCertificateRestDTO.getFatherName());
			
			
			if(occupancyCertificateRestDTO.getSurname()!=null&&!occupancyCertificateRestDTO.getSurname().isEmpty()) {
				occupancyCertificate.setLastName(occupancyCertificateRestDTO.getSurname());
			}else
			{
				String lastName = "Surname field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			if(occupancyCertificateRestDTO.getFullName()!=null&&!occupancyCertificateRestDTO.getFullName().isEmpty()) {
				occupancyCertificate.setFullName(occupancyCertificateRestDTO.getFullName());
			}else
			{
				String lastName = "FullName field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			
			if(occupancyCertificateRestDTO.getPinCode()!=0) {
				occupancyCertificate.setPinCode(occupancyCertificateRestDTO.getPinCode());
			}else
			{
				String pinCode = "PinCode field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			
			occupancyCertificate.setAadharNo(occupancyCertificateRestDTO.getAadhaarNumber());
			
			if(occupancyCertificateRestDTO.getEmail()!=null&&!occupancyCertificateRestDTO.getEmail().isEmpty()) {
				occupancyCertificate.setEmail(occupancyCertificateRestDTO.getEmail());
			}else
			{
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			
			if(occupancyCertificateRestDTO.getMobileNo()!=null&&!occupancyCertificateRestDTO.getMobileNo().isEmpty()) {
				occupancyCertificate.setMobileNo(occupancyCertificateRestDTO.getMobileNo());
			}else
			{
				String mobileNumber = "MobileNumber field is Required";
				condition = false;
				message.append(mobileNumber).append(",");
			}
			
			if(occupancyCertificateRestDTO.getAddress()!=null&&!occupancyCertificateRestDTO.getAddress().isEmpty()) {
				occupancyCertificate.setAddress(occupancyCertificateRestDTO.getAddress());
			}else
			{
				String address = "Address field is Required";
				condition = false;
				message.append(address).append(",");
			}
			
			if(occupancyCertificateRestDTO.getBuildingNo()!=null&&!occupancyCertificateRestDTO.getBuildingNo().isEmpty()) {
				occupancyCertificate.setBuildingNo(occupancyCertificateRestDTO.getBuildingNo());
			}else
			{
				String buildingNo = "BuildingNo field is Required";
				condition = false;
				message.append(buildingNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getPlotNo()!=null&&!occupancyCertificateRestDTO.getPlotNo().isEmpty()) {
				occupancyCertificate.setPlotNo(occupancyCertificateRestDTO.getPlotNo());
			}else
			{
				String plotNo = "PlotNo field is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getRevenueNo()!=null&&!occupancyCertificateRestDTO.getRevenueNo().isEmpty()) {
				occupancyCertificate.setRevenueNo(occupancyCertificateRestDTO.getRevenueNo());
			}else
			{
				String revenueNo = "RevenueNo field is Required";
				condition = false;
				message.append(revenueNo).append(",");
			}
			
			occupancyCertificate.setGatNo(occupancyCertificateRestDTO.getGatNo());
			
					
			if(occupancyCertificateRestDTO.getKhasaraNo()!=null&&!occupancyCertificateRestDTO.getKhasaraNo().isEmpty()) {
				occupancyCertificate.setKhasaraNo(occupancyCertificateRestDTO.getKhasaraNo());
			}else
			{
				String khasaraNo = "KhasaraNo field is Required";
				condition = false;
				message.append(khasaraNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getCitySurveyNo()!=null&&!occupancyCertificateRestDTO.getCitySurveyNo().isEmpty()) {
				occupancyCertificate.setCitySurveyNo(occupancyCertificateRestDTO.getCitySurveyNo());
			}else
			{
				String citySurveyNo = "CitySurveyNo field is Required";
				condition = false;
				message.append(citySurveyNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getFinalPlotNo()!=null&&!occupancyCertificateRestDTO.getFinalPlotNo().isEmpty()) {
				
				occupancyCertificate.setFinalPlotNo(occupancyCertificateRestDTO.getFinalPlotNo());
			}else
			{
				String finalPlotNo = "FinalPlotNo field is Required";
				condition = false;
				message.append(finalPlotNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getMouje()!=null&&!occupancyCertificateRestDTO.getMouje().isEmpty()) {
				occupancyCertificate.setMouje(occupancyCertificateRestDTO.getMouje());
			}else
			{
				String mouje = "Mouje field is Required";
				condition = false;
				message.append(mouje).append(",");
			}
			
			if(occupancyCertificateRestDTO.getArchitectName()!=null&&!occupancyCertificateRestDTO.getArchitectName().isEmpty()) {
				occupancyCertificate.setArchitectName(occupancyCertificateRestDTO.getArchitectName());
			}else
			{
				String architectName = "ArchitectName field is Required";
				condition = false;
				message.append(architectName).append(",");
			}
			
			if(occupancyCertificateRestDTO.getStructuralLicenseNO()!=null&&!occupancyCertificateRestDTO.getStructuralLicenseNO().isEmpty()) {
				occupancyCertificate.setStructuralLicenseNo(occupancyCertificateRestDTO.getStructuralLicenseNO());
			}else
			{
				String structuralLicenseNo = "StructuralLicenseNo field is Required";
				condition = false;
				message.append(structuralLicenseNo).append(",");
			}
			
			if(occupancyCertificateRestDTO.getOccupancyCertificate()!=null&&!occupancyCertificateRestDTO.getOccupancyCertificate().isEmpty()) {
				occupancyCertificate.setOccupancyCertificate(occupancyCertificateRestDTO.getOccupancyCertificate());
			}else
			{
				String OccupancyCertificate = "OccupancyCertificate field is Required";
				condition = false;
				message.append(OccupancyCertificate).append(",");
			}
			
			if(occupancyCertificateRestDTO.getArea()!=null&&!occupancyCertificateRestDTO.getArea().isEmpty()) {
				occupancyCertificate.setArea(occupancyCertificateRestDTO.getArea());
			}else
			{
				String area = "Area field is Required";
				condition = false;
				message.append(area).append(",");
			}
			
			if(occupancyCertificateRestDTO.getFeesApplicable()!=0) {
				occupancyCertificate.setFeesApplicable(occupancyCertificateRestDTO.getFeesApplicable());
			}else
			{
				String feesApplicable = "FeesApplicable field is Required";
				condition = false;
				message.append(feesApplicable).append(",");
			}
			
			if(occupancyCertificateRestDTO.getZoneNo()!=0) {
				occupancyCertificate.setZoneNo(String.valueOf(occupancyCertificateRestDTO.getZoneNo()));
			}else
			{
				String zoneNo = "FeesApplicable field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			occupancyCertificate.setZoneNo(String.valueOf(occupancyCertificateRestDTO.getZoneNo()));

			
			if (occupancyCertificateRestDTO.getConstructionStartingDateCertificate() != null
					&& !occupancyCertificateRestDTO.getConstructionStartingDateCertificate()
							.isEmpty()) {
				String doc1 = occupancyCertificateRestDTO
						.getConstructionStartingDateCertificate();

				files[0] = doc1;
			} else {
				String doc1 = "Construction Starting Date Certificate";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (occupancyCertificateRestDTO.getArchitectCertificate() != null
					&& !occupancyCertificateRestDTO.getArchitectCertificate()
							.isEmpty()) {
				String doc2 = occupancyCertificateRestDTO
						.getArchitectCertificate();

				files[1] = doc2;
			} else {
				String doc2 = "Architect Certificate";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (occupancyCertificateRestDTO.getTaxRecipt() != null
					&& !occupancyCertificateRestDTO.getTaxRecipt()
							.isEmpty()) {
				String doc3 = occupancyCertificateRestDTO
						.getTaxRecipt();

				files[2] = doc3;
			} else {
				String doc3 = "Tax Recipt";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (occupancyCertificateRestDTO.getConstructionPermissionCertificate() != null
					&& !occupancyCertificateRestDTO.getConstructionPermissionCertificate()
							.isEmpty()) {
				String doc4 = occupancyCertificateRestDTO
						.getConstructionPermissionCertificate();

				files[3] = doc4;
			} else {
				String doc4 = "Construction Permission Certificate";
				condition = false;
				message.append(doc4).append(",");
			}
			String savedFilePath = OccupancyCertificateRestController
					.saveFile(files, servletContext, request);

						
			
		
				
			RTIApplication rtiApplication = new RTIApplication();
			if (occupancyCertificateRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						occupancyCertificateRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}				
				if(condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("OCCUPANCY-CERTIFICATE");
				rtiApplication.setTemplateName("townPlanning");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(25);
				rtiApplication.setApplicantName(occupancyCertificate.getFullName());
				rtiApplication.setPdfUploadFromPortal(occupancyCertificate.getFilesPath());
				rtiApplication.setApplicationCost(occupancyCertificate.getFeesApplicable());
				rtiApplication.setZone(occupancyCertificate.getMouzaZone());

				rtiApplication.setPhoneNumber(occupancyCertificate.getMobileNo());
				rtiApplication.setMobileNumber(occupancyCertificate.getMobileNo());
				rtiApplication.setEmail(occupancyCertificate.getEmail());


				rtiApplication.setApplicationCost(occupancyCertificate.getFeesApplicable());

				rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");

			    rtiApplication.setApplicantName(occupancyCertificateRestDTO.getName());
				rtiApplication.setApplicantName(occupancyCertificate.getFirstName());
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

				// birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);

				// if(birthRegistrationService.birthRegistrationCertificate(birthRegistration){

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/TPD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					occupancyCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					occupancyCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
					long occupancy_regis_id = occupancyCertificateService.getReferenceId(occupancyCertificate);
					rti.setRtiApplicationRefId(occupancy_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (occupancy_regis_id > 0)) {
						occupancyCertificateRestDTO.setResponseStatus("Requested data saved successfully");
						occupancyCertificateRestDTO.setResponseCode(200);
						occupancyCertificateRestDTO.setResult(retunRti.getRtiApplnNumber());
						occupancyCertificateRestDTO.setStatus("Ok");
						reponse.setStatus(HttpStatus.OK.value());
						occupancyCertificateRestDTO.setConstructionStartingDateCertificate("");
						occupancyCertificateRestDTO.setArchitectCertificate("");
						occupancyCertificateRestDTO.setTaxRecipt("");
						occupancyCertificateRestDTO.setConstructionPermissionCertificate("");

					}
					String name = occupancyCertificate.getFirstName() + occupancyCertificate.getMiddleName()
							+ occupancyCertificate.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", occupancyCertificate.getMobileNo(), msg);
					SendEmail.sendEmail(occupancyCertificate.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						occupancyCertificateRestDTO.setResult(message.toString());
						occupancyCertificateRestDTO.setResponseStatus("Requested data not saved successfully");
						occupancyCertificateRestDTO.setResponseCode(500);
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						occupancyCertificateRestDTO.setStatus("Internal Server Error");
						occupancyCertificateRestDTO.setConstructionStartingDateCertificate("");
						occupancyCertificateRestDTO.setArchitectCertificate("");
						occupancyCertificateRestDTO.setTaxRecipt("");
						occupancyCertificateRestDTO.setConstructionPermissionCertificate("");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				log.equals(ex.getMessage());
				occupancyCertificateRestDTO.setResponseStatus(ex.getMessage());
				occupancyCertificateRestDTO.setResponseCode(405);
				reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
				occupancyCertificateRestDTO.setStatus("Method not Allowed");
				occupancyCertificateRestDTO.setConstructionStartingDateCertificate("");
				occupancyCertificateRestDTO.setArchitectCertificate("");
				occupancyCertificateRestDTO.setTaxRecipt("");
				occupancyCertificateRestDTO.setConstructionPermissionCertificate("");
			}

			return occupancyCertificateRestDTO;
		}
	
	
	public static String saveFile(String data[], ServletContext servletContext,
			HttpServletRequest request) throws IOException {
			String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = servletContext.getRealPath("") + File.separator
				+ "occupancyCertificates";
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			for (String element : data) {
				if (element != null) {
					byte[] pdfBytes = Base64.getDecoder().decode(element);
					String fileName;
					String uniqueFileName = UUID.randomUUID().toString()
							.substring(0, 8) + ".pdf";
					int l = uniqueFileName.lastIndexOf(".");
					String imageext = uniqueFileName.substring(l,
							uniqueFileName.length());
					fileName = uniqueFileName.substring(0, l);
					fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
					fileName = fileName.replaceAll("\\W", "");
					fileName = fileName + "" + imageext;
					File storeFile = new File(baseDir, fileName);
					try (FileOutputStream outputStream = new FileOutputStream(
							storeFile)) {
						outputStream.write(pdfBytes);
						outputStream.flush();
						outputStream.close();

					}

					String url = "https" + "://" + // "http" + "://
							request.getServerName() + request.getRequestURI() + // "/people"
							"?" + // "?"
							request.getQueryString();
					String[] url1 = url.split("/mobileapp");
					filesPath = url1[0] + "/occupancyCertificates/" + fileName;
				}
				filesPathBuilder.append(filesPath).append(",");

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
