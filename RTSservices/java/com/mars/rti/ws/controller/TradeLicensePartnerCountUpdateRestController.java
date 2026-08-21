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
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TradeLicencePartnerCountUpdate;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicencePartnerCountUpdateService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicensePartnerCountUpdateRestDTO;

@Controller
public class TradeLicensePartnerCountUpdateRestController {

	private static Log log = LogFactory.getLog(TradeLicensePartnerCountUpdateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TradeLicencePartnerCountUpdateService tradeLicencePartnerCountUpdateService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/saveTradeLicenseCountUpdate")
	public @ResponseBody TradeLicensePartnerCountUpdateRestDTO saveTradeLicenseCountUpdate(@RequestBody TradeLicensePartnerCountUpdateRestDTO tradeLicensePartnerCountUpdateRestDTO,HttpServletRequest request,HttpServletResponse response)
	throws ServletException{
		
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		
		
		try {
			TradeLicencePartnerCountUpdate trade = new TradeLicencePartnerCountUpdate();
	

		if(tradeLicensePartnerCountUpdateRestDTO.getTitle()!=null && !tradeLicensePartnerCountUpdateRestDTO.getTitle().isEmpty()) {
			trade.setTitle(tradeLicensePartnerCountUpdateRestDTO.getTitle());
		}else {
			String title="Title field is Required";
			condition = false;
			message.append(title).append(",");
		}

		if(tradeLicensePartnerCountUpdateRestDTO.getName()!=null && !tradeLicensePartnerCountUpdateRestDTO.getName().isEmpty()) {
			trade.setFirstName(tradeLicensePartnerCountUpdateRestDTO.getName());
		}else {
			String name="Name field is Required";
			condition = false;
			message.append(name).append(",");
		}
		trade.setMiddleName(tradeLicensePartnerCountUpdateRestDTO.getFatherName());
		if(tradeLicensePartnerCountUpdateRestDTO.getSurname()!=null && !tradeLicensePartnerCountUpdateRestDTO.getSurname().isEmpty()) {
			trade.setLastName(tradeLicensePartnerCountUpdateRestDTO.getSurname());
		}else {
			String surname="Surname field is Required";
			condition = false;
			message.append(surname).append(",");
		}
		if(tradeLicensePartnerCountUpdateRestDTO.getFullName()!=null && !tradeLicensePartnerCountUpdateRestDTO.getFullName().isEmpty()) {
			trade.setFullName(tradeLicensePartnerCountUpdateRestDTO.getFullName());
		}else {
			String fullname="Full Name field is Required";
			condition = false;
			message.append(fullname).append(",");
		}
		if(tradeLicensePartnerCountUpdateRestDTO.getCityName()!=null && !tradeLicensePartnerCountUpdateRestDTO.getCityName().isEmpty()) {
			trade.setApplicantcity(tradeLicensePartnerCountUpdateRestDTO.getCityName());
		}else {
			String cityName="City Name field is Required";
			condition = false;
			message.append(cityName).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getPinCode()!=0) {
			trade.setPinCode((int)tradeLicensePartnerCountUpdateRestDTO.getPinCode());
		}else {
			String pincode="PinCode field is Required";
			condition = false;
			message.append(pincode).append(",");
		}
		
		trade.setAadhaarNo(tradeLicensePartnerCountUpdateRestDTO.getAadhaarNo());

		if(tradeLicensePartnerCountUpdateRestDTO.getEmail()!=null && !tradeLicensePartnerCountUpdateRestDTO.getEmail().isEmpty()) {
			trade.setEmail(tradeLicensePartnerCountUpdateRestDTO.getEmail());
		}else {
			String email="Email field is Required";
			condition = false;
			message.append(email).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getMobileNo()!=0) {
			trade.setMobileNo(String.valueOf(tradeLicensePartnerCountUpdateRestDTO.getMobileNo()));
		}else {
			String mobileNo="Mobile Number field is Required";
			condition = false;
			message.append(mobileNo).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getAddress()!=null && !tradeLicensePartnerCountUpdateRestDTO.getAddress().isEmpty()) {
			trade.setAddress(tradeLicensePartnerCountUpdateRestDTO.getAddress());
		}else {
			String address="Address field is Required";
			condition = false;
			message.append(address).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getZoneNo()!=0) {
			trade.setZoneNo(String.valueOf(tradeLicensePartnerCountUpdateRestDTO.getZoneNo()));
		}else {
			String zoneNo="Zone Number field is Required";
			condition = false;
			message.append(zoneNo).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getWardNo()!=null && !tradeLicensePartnerCountUpdateRestDTO.getWardNo().isEmpty()) {
			trade.setWardNo(tradeLicensePartnerCountUpdateRestDTO.getWardNo());
		}else {
			String wardNo="Ward Number field is Required";
			condition = false;
			message.append(wardNo).append(",");
		}
		
		trade.setAreaName(tradeLicensePartnerCountUpdateRestDTO.getAreaName());

		
		if(tradeLicensePartnerCountUpdateRestDTO.getTradeLicenseNo()!=null && !tradeLicensePartnerCountUpdateRestDTO.getTradeLicenseNo().isEmpty()) {
			trade.setTradeLicenseNo(tradeLicensePartnerCountUpdateRestDTO.getTradeLicenseNo());
		}else {
			String tradeLicenseNo="Trade License Number field is Required";
			condition = false;
			message.append(tradeLicenseNo).append(",");
		}
		
		trade.setUpdatedTradeName(tradeLicensePartnerCountUpdateRestDTO.getUpdatedTradeName());

		
		if(tradeLicensePartnerCountUpdateRestDTO.getUpdatedOwnerName()!=null && !tradeLicensePartnerCountUpdateRestDTO.getUpdatedOwnerName().isEmpty()) {
			trade.setUpdatedOwnerName(tradeLicensePartnerCountUpdateRestDTO.getUpdatedOwnerName());
		}else {
			String updatedOwnerName="Updated Owner Name field is Required";
			condition = false;
			message.append(updatedOwnerName).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getUpdatedTradeType()!=null && !tradeLicensePartnerCountUpdateRestDTO.getUpdatedTradeType().isEmpty()) {
			trade.setUpdatedTradeType(tradeLicensePartnerCountUpdateRestDTO.getUpdatedTradeType());
		}else {
			String updatedTradeType="Updated Trade Type field is Required";
			condition = false;
			message.append(updatedTradeType).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getUpdatedPartnerCount()!=null && !tradeLicensePartnerCountUpdateRestDTO.getUpdatedPartnerCount().isEmpty()) {
			trade.setUpdatedPartnerCount(tradeLicensePartnerCountUpdateRestDTO.getUpdatedTradeType());
		}else {
			String updatedPartnerCount="Updated Partner Count field is Required";
			condition = false;
			message.append(updatedPartnerCount).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getApplicableFee()!=0.0 && tradeLicensePartnerCountUpdateRestDTO.getApplicableFee()!=0) {
			trade.setApplicableFee((int)(tradeLicensePartnerCountUpdateRestDTO.getApplicableFee()));
		}else {
			String applicableFee="Fees field is Required";
			condition = false;
			message.append(applicableFee).append(",");
		}
		
		///Files
		if(tradeLicensePartnerCountUpdateRestDTO.getnOCforTheRelatedDepartmentIssuedFromTheNMC()!=null && !tradeLicensePartnerCountUpdateRestDTO.getnOCforTheRelatedDepartmentIssuedFromTheNMC().isEmpty()) {
	             String doc0 = tradeLicensePartnerCountUpdateRestDTO.getnOCforTheRelatedDepartmentIssuedFromTheNMC();
	             files[0]=doc0;
		}else {
			String doc0="NOC for the related department issued from the NMC field is Required";
			condition = false;
			message.append(doc0).append(",");
		}
		
		if(tradeLicensePartnerCountUpdateRestDTO.getCopyOfTheFormerLicence()!=null && !tradeLicensePartnerCountUpdateRestDTO.getCopyOfTheFormerLicence().isEmpty()) {
            String doc1 = tradeLicensePartnerCountUpdateRestDTO.getCopyOfTheFormerLicence();
            files[1]=doc1;
	}else {
		String doc1="Copy of the Former Licence field is Required";
		condition = false;
		message.append(doc1).append(",");
	}
		
		String doc2 = tradeLicensePartnerCountUpdateRestDTO.getNoDuesCertificateForPropertyTax();
        files[2]=doc2;
        
		if(tradeLicensePartnerCountUpdateRestDTO.getBuildingAuthorizationDocument()!=null && !tradeLicensePartnerCountUpdateRestDTO.getBuildingAuthorizationDocument().isEmpty()) {
            String doc3 = tradeLicensePartnerCountUpdateRestDTO.getBuildingAuthorizationDocument();
            files[3]=doc3;
	}else {
		String doc3="Building Authorization Document field is Required";
		condition = false;
		message.append(doc3).append(",");
	}
		//save files method
		String savedFilePath = TradeLicensePartnerCountUpdateRestController
				.saveFile(files, request);
		
		
		RTIApplication rtiApplication = new RTIApplication();
		if (tradeLicensePartnerCountUpdateRestDTO.getUserMobileNumber() != 0) {
			rtiApplication.setMobileAppUserNumber(String.valueOf(
					tradeLicensePartnerCountUpdateRestDTO.getUserMobileNumber()));
		} else {
			String userMobilenumber = "User Mobile Number field is Required";
			condition = false;
			message.append(userMobilenumber).append(",");
			
		}
		
		if (condition) {
		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setSubject("TRADE-LICENCE-PARTNEW-COUNT-UPDATE");
		rtiApplication.setDepartment("MARKET-DEPARTMENT");
		rtiApplication.setTemplateName("marketDepartment");
		rtiApplication.setWorkFlowStatus(0);
		rtiApplication.setFinalStatus("0");
		rtiApplication.setRtiserviceid(39);
		// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
		rtiApplication.setApplicantName(trade.getFullName());
		rtiApplication.setPdfUploadFromPortal(savedFilePath);
		rtiApplication.setApplicationCost(trade.getApplicableFee());
		rtiApplication.setPhoneNumber(trade.getMobileNo());
		rtiApplication.setEmail(trade.getEmail());
		rtiApplication.setZone(trade.getZoneNo());

		// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
		rtiApplication.setApplicantName(trade.getFullName());
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
			rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
			trade.setRtiapplrefno(rti.getRtiApplnNumber());
			trade.setRti_ref_id(savedRti.getRtiApplicationId());
			long trade_regis_id = tradeLicencePartnerCountUpdateService
					.getReferenceId(trade);
			rti.setRtiApplicationRefId(trade_regis_id);
			// rti.setRtiApplicationRefId(birthRegistrationService.);
			RTIApplication retunRti = rtiApplicationService.merge(rti);

			if ((retunRti != null) && (trade_regis_id > 0)) {
				tradeLicensePartnerCountUpdateRestDTO.setResponseStatus("Requested data saved successfully");
				tradeLicensePartnerCountUpdateRestDTO.setResponseCode(HttpStatus.OK.value());
				response.setStatus(HttpStatus.OK.value());
				tradeLicensePartnerCountUpdateRestDTO.setnOCforTheRelatedDepartmentIssuedFromTheNMC("");
				tradeLicensePartnerCountUpdateRestDTO.setCopyOfTheFormerLicence("");
				tradeLicensePartnerCountUpdateRestDTO.setNoDuesCertificateForPropertyTax("");
				tradeLicensePartnerCountUpdateRestDTO.setBuildingAuthorizationDocument("");
				tradeLicensePartnerCountUpdateRestDTO.setResult(retunRti.getRtiApplnNumber());
				tradeLicensePartnerCountUpdateRestDTO.setStatus("ok");
			}
			String name = trade.getFullName();
			String link = "https://tinyurl.com/4hhhy9w9";
			String applnNo = rti.getRtiApplnNumber();

			String msg = "Dear " + name + " your application with Application No. " + applnNo
					+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

			msg.replace("var3", "");

			SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", trade.getMobileNo(),
					msg);
			SendEmail.sendEmail(trade.getEmail(),
					"Application Submitted Successfully" + applnNo, msg);
		
		
		}
		
		}
		if (!condition) {
			if (message.charAt(message.length() - 1) == ',') {
				message.deleteCharAt(message.length() - 1);
				tradeLicensePartnerCountUpdateRestDTO.setResult(message.toString());
				tradeLicensePartnerCountUpdateRestDTO.setResponseStatus("Requested data not saved successfully");
				tradeLicensePartnerCountUpdateRestDTO.setnOCforTheRelatedDepartmentIssuedFromTheNMC("");
				tradeLicensePartnerCountUpdateRestDTO.setCopyOfTheFormerLicence("");
				tradeLicensePartnerCountUpdateRestDTO.setNoDuesCertificateForPropertyTax("");
				tradeLicensePartnerCountUpdateRestDTO.setBuildingAuthorizationDocument("");
				tradeLicensePartnerCountUpdateRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				tradeLicensePartnerCountUpdateRestDTO.setStatus("Internal Server Error");
			}
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			tradeLicensePartnerCountUpdateRestDTO.setResponseStatus(ex.getMessage());
			tradeLicensePartnerCountUpdateRestDTO.setnOCforTheRelatedDepartmentIssuedFromTheNMC("");
			tradeLicensePartnerCountUpdateRestDTO.setCopyOfTheFormerLicence("");
			tradeLicensePartnerCountUpdateRestDTO.setNoDuesCertificateForPropertyTax("");
			tradeLicensePartnerCountUpdateRestDTO.setBuildingAuthorizationDocument("");
			tradeLicensePartnerCountUpdateRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicensePartnerCountUpdateRestDTO.setStatus("Method not Allowed");
		}

		return tradeLicensePartnerCountUpdateRestDTO;
	}
	
	
	
	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicensePartnerCountUpdate";
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
