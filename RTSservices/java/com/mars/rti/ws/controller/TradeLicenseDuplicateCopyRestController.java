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
import com.mars.rti.model.TradeLicenseDuplicateCopy;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseDuplicateCopyService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenseDuplicateCopyRestDTO;

@Controller
public class TradeLicenseDuplicateCopyRestController {
	
	private static Log log = LogFactory.getLog(TradeLicenseDuplicateCopyRestController.class);


	
	@Autowired
	private TradeLicenseDuplicateCopyService tradeLicenseDuplicateCopyService;
	
	@Autowired
	private RTIApplicationService rTIApplicationService;

	
	@RequestMapping(method = RequestMethod.POST, value ="/saveTradeLicenceDuplicateCopy")
	public @ResponseBody TradeLicenseDuplicateCopyRestDTO saveTradeLicenceDuplicateCopy(
		   @RequestBody TradeLicenseDuplicateCopyRestDTO tradeLicenseDuplicateCopyRestDTO,HttpServletResponse reponse, HttpServletRequest request) throws ServletException{

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveTradeLicenseDuplicateCopyApplication");
		}
		
		TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy = new TradeLicenseDuplicateCopy();
		try
		{
			if(tradeLicenseDuplicateCopyRestDTO.getTitle()!=null&&!tradeLicenseDuplicateCopyRestDTO.getTitle().isEmpty()) {
				tradeLicenseDuplicateCopy.setTitle(tradeLicenseDuplicateCopyRestDTO.getTitle());
			}else
			{
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			if(tradeLicenseDuplicateCopyRestDTO.getName()!=null&&!tradeLicenseDuplicateCopyRestDTO.getName().isEmpty()) {
				tradeLicenseDuplicateCopy.setFirstName(tradeLicenseDuplicateCopyRestDTO.getName());
			}else
			{
				String firstName = "First Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
				tradeLicenseDuplicateCopy.setMiddleName(tradeLicenseDuplicateCopyRestDTO.getFatherName());
				
			if(tradeLicenseDuplicateCopyRestDTO.getSurname()!=null&&!tradeLicenseDuplicateCopyRestDTO.getSurname().isEmpty()) {
				tradeLicenseDuplicateCopy.setLastName(tradeLicenseDuplicateCopyRestDTO.getSurname());
			}else
			{
				String lastName = "Last Name field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getFullName()!=null&&!tradeLicenseDuplicateCopyRestDTO.getFullName().isEmpty()) {
				tradeLicenseDuplicateCopy.setFullName(tradeLicenseDuplicateCopyRestDTO.getFullName());
			}else
			{
				String fullName = "Full Name field is Required";
				condition = false;
				message.append(fullName).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getPinCode()!=0) {
				tradeLicenseDuplicateCopy.setPinCode(tradeLicenseDuplicateCopyRestDTO.getPinCode());
			}else
			{
				String pinCode = "Pin Code field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			
			tradeLicenseDuplicateCopy.setAadhaarNo(tradeLicenseDuplicateCopyRestDTO.getAadhaarNo());
			
			if(tradeLicenseDuplicateCopyRestDTO.getEmailID()!=null&&!tradeLicenseDuplicateCopyRestDTO.getEmailID().isEmpty()) {
				tradeLicenseDuplicateCopy.setEmailID(tradeLicenseDuplicateCopyRestDTO.getEmailID());
			}else
			{
				String emailId = "Email ID field is Required";
				condition = false;
				message.append(emailId).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getMobileNumber()!=null&&!tradeLicenseDuplicateCopyRestDTO.getMobileNumber().isEmpty()) {
				tradeLicenseDuplicateCopy.setMobileNumber(tradeLicenseDuplicateCopyRestDTO.getMobileNumber());
			}else
			{
				String mobileNumber = "Mobile Number field is Required";
				condition = false;
				message.append(mobileNumber).append(",");
			}
			if(tradeLicenseDuplicateCopyRestDTO.getApplicableFee()!=0.0 && tradeLicenseDuplicateCopyRestDTO.getApplicableFee()!=0) {
				tradeLicenseDuplicateCopy.setFeesApplicable((int)(tradeLicenseDuplicateCopyRestDTO.getApplicableFee()));
						
			}else {
				String applicableFee="Fees field is Required";
				condition = false;
				message.append(applicableFee).append(",");
			}
			if(tradeLicenseDuplicateCopyRestDTO.getAdressForCorrespondence()!=null&&!tradeLicenseDuplicateCopyRestDTO.getAdressForCorrespondence().isEmpty()) {
				tradeLicenseDuplicateCopy.setAdressForCorrespondence(tradeLicenseDuplicateCopyRestDTO.getAdressForCorrespondence());
			}else
			{
				String adressForCorrespondence = "Adress For Correspondence field is Required";
				condition = false;
				message.append(adressForCorrespondence).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getZoneNo()!=null&&!tradeLicenseDuplicateCopyRestDTO.getZoneNo().isEmpty()) {
				tradeLicenseDuplicateCopy.setZoneNo(tradeLicenseDuplicateCopyRestDTO.getZoneNo());
			}else
			{
				String zoneNo = "Zone No field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getWardNo()!=null&&!tradeLicenseDuplicateCopyRestDTO.getWardNo().isEmpty()) {
				tradeLicenseDuplicateCopy.setWardNo(tradeLicenseDuplicateCopyRestDTO.getWardNo());
			}else
			{
				String wardNo = "Ward No field is Required";
				condition = false;
				message.append(wardNo).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getTradeLicenceNo()!=null&&!tradeLicenseDuplicateCopyRestDTO.getTradeLicenceNo().isEmpty()) {
				tradeLicenseDuplicateCopy.setTradeLicenceNo(tradeLicenseDuplicateCopyRestDTO.getTradeLicenceNo());
			}else
			{
				String tradeLicenceNo = "Trade LicenceNo  field is Required";
				condition = false;
				message.append(tradeLicenceNo).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getUpdatedTradeType()!=null&&!tradeLicenseDuplicateCopyRestDTO.getUpdatedTradeType().isEmpty()) {
				tradeLicenseDuplicateCopy.setUpdatedTradeType(tradeLicenseDuplicateCopyRestDTO.getUpdatedTradeType());
			}else
			{
				String updateTradeType = "Update Trade Type  field is Required";
				condition = false;
				message.append(updateTradeType).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getUpdatedOwnerName()!=null&&!tradeLicenseDuplicateCopyRestDTO.getUpdatedOwnerName().isEmpty()) {
				tradeLicenseDuplicateCopy.setUpdatedOwnerName(tradeLicenseDuplicateCopyRestDTO.getUpdatedOwnerName());
			}else
			{
				String updatedOwnerName = "Updated Owner Name field is Required";
				condition = false;
				message.append(updatedOwnerName).append(",");
			}
			
			if(tradeLicenseDuplicateCopyRestDTO.getUpdatedPartnerCount()!=null&&!tradeLicenseDuplicateCopyRestDTO.getUpdatedPartnerCount().isEmpty()) {
				tradeLicenseDuplicateCopy.setUpdatedPartnerCount(tradeLicenseDuplicateCopyRestDTO.getUpdatedPartnerCount());
			}else
			{
				String updatedPartnerCount = "Updated Partner Count field is Required";
				condition = false;
				message.append(updatedPartnerCount).append(",");
			}
			
			if (tradeLicenseDuplicateCopyRestDTO.getNocforTheRelatedDepartmentIssuedFromNMCDepartment() != null
					&& !tradeLicenseDuplicateCopyRestDTO.getNocforTheRelatedDepartmentIssuedFromNMCDepartment()
							.isEmpty()) {
				String doc1 = tradeLicenseDuplicateCopyRestDTO
						.getNocforTheRelatedDepartmentIssuedFromNMCDepartment();

				files[0] = doc1;
			} else {
				String doc1 = "NOC for The Related Department Issued From NMC Department";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (tradeLicenseDuplicateCopyRestDTO.getCopyOfTheFormerLicence() != null
					&& !tradeLicenseDuplicateCopyRestDTO.getCopyOfTheFormerLicence()
							.isEmpty()) {
				String doc2 = tradeLicenseDuplicateCopyRestDTO
						.getCopyOfTheFormerLicence();

				files[1] = doc2;
			} else {
				String doc2 = "Copy Of The Former Licence";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (tradeLicenseDuplicateCopyRestDTO.getNoDuesCertificateforPropertyTax() != null
					&& !tradeLicenseDuplicateCopyRestDTO.getNoDuesCertificateforPropertyTax()
							.isEmpty()) {
				String doc3 = tradeLicenseDuplicateCopyRestDTO
						.getNoDuesCertificateforPropertyTax();

				files[2] = doc3;
			} else {
				String doc3 = "No Dues Certificate for Property Tax";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (tradeLicenseDuplicateCopyRestDTO.getBuildingAuthorizationDocument() != null
					&& !tradeLicenseDuplicateCopyRestDTO.getBuildingAuthorizationDocument()
							.isEmpty()) {
				String doc4 = tradeLicenseDuplicateCopyRestDTO
						.getBuildingAuthorizationDocument();

				files[3] = doc4;
			} else {
				String doc4 = "Building Authorization Document";
				condition = false;
				message.append(doc4).append(",");
			}
			// Save FilesPath
			String savedFilePath = TradeLicenseDuplicateCopyRestController
					.saveFile(files, request);

		
			RTIApplication rtiApplication = new RTIApplication();
			if (tradeLicenseDuplicateCopyRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						tradeLicenseDuplicateCopyRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}			
			if(condition) {
			rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("TRADE-LICENSE-DUPLICATE");
			rtiApplication.setTemplateName("TradeLiceneceDuplicateCopy");
			rtiApplication.setDepartment("MARKET-DEPARTMENT");

			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(23);
			//rtiApplication.setUserRegistrationDetails(user);
			rtiApplication.setApplicantName(tradeLicenseDuplicateCopy.getFirstName() + " " + tradeLicenseDuplicateCopy.getMiddleName()
					+ " " + tradeLicenseDuplicateCopy.getLastName());
			rtiApplication.setPhoneNumber(tradeLicenseDuplicateCopy.getMobileNumber());
			rtiApplication.setMobileNumber(tradeLicenseDuplicateCopy.getMobileNumber());
			rtiApplication.setZone("2");
			rtiApplication.setEmail(tradeLicenseDuplicateCopy.getEmailID());
			rtiApplication.setZone(tradeLicenseDuplicateCopy.getZoneNo());

			rtiApplication.setApplicationCost(tradeLicenseDuplicateCopy.getFeesApplicable());

			rtiApplication.setApplicantName(tradeLicenseDuplicateCopy.getFullName());
			rtiApplication.setPdfUploadFromPortal(savedFilePath);
			List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
			RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

			rtiApplicationDetails.setRtiApplication(rtiApplication);
			rtiApplicationDetails.setStatus(0);
			rtiApplicationDetails.setAssignToStatus(1);
			rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
			rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDate());

			rtiApplicationDetails.setComments("Form Submitted");// ();
			rtiApplicationDetails.setWorkflowLevel(0);
			rtiApplicationDetailsList.add(rtiApplicationDetails);
			rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
			RTIApplication savedRti = rTIApplicationService.merge(rtiApplication);
			
			if (savedRti.getRtiApplicationId() > 0) {
				
				RTIApplication rti = rTIApplicationService.get(savedRti.getRtiApplicationId());
				rti.setRtiApplnNumber("RTS/ED"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
				tradeLicenseDuplicateCopy.setRtiApplRefNo(rti.getRtiApplnNumber());
				tradeLicenseDuplicateCopy.setRtiRefId(savedRti.getRtiApplicationId());
				long tradeDuplicate_regis_id = tradeLicenseDuplicateCopyService.tradeLicenseDuplicateCopy(tradeLicenseDuplicateCopy);
				rti.setRtiApplicationRefId(tradeDuplicate_regis_id);
				// rti.setRtiApplicationRefId(birthRegistrationService.);
				RTIApplication retunRti = rTIApplicationService.merge(rti);
                   

				if ((retunRti != null) && (tradeDuplicate_regis_id > 0)) {
					tradeLicenseDuplicateCopyRestDTO.setResponseStatus("Requested data saved successfully");
					tradeLicenseDuplicateCopyRestDTO.setResponseCode(HttpStatus.OK.value());
					reponse.setStatus(HttpStatus.OK.value());
					tradeLicenseDuplicateCopyRestDTO.setResult(retunRti.getRtiApplnNumber());
					tradeLicenseDuplicateCopyRestDTO.setStatus("ok");
					tradeLicenseDuplicateCopyRestDTO.setNocforTheRelatedDepartmentIssuedFromNMCDepartment("");
					tradeLicenseDuplicateCopyRestDTO.setCopyOfTheFormerLicence("");
					tradeLicenseDuplicateCopyRestDTO.setBuildingAuthorizationDocument("");
					tradeLicenseDuplicateCopyRestDTO.setNoDuesCertificateforPropertyTax("");
				}
				String name=tradeLicenseDuplicateCopy.getFullName();
				String link = "https://tinyurl.com/4hhhy9w9";
				String applnNo= rti.getRtiApplnNumber();


				
				String msg = "Dear "+name+" your application with Application No. "+applnNo+" submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
				
				msg.replace("var3", "");

				SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenseDuplicateCopy.getMobileNumber(), msg);
				SendEmail.sendEmail(tradeLicenseDuplicateCopy.getEmailID(), "Application Submitted Successfully" + applnNo, msg);

			}
		}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						tradeLicenseDuplicateCopyRestDTO.setResult(message.toString());
						tradeLicenseDuplicateCopyRestDTO.setResponseStatus("Requested data not saved successfully");
						tradeLicenseDuplicateCopyRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						tradeLicenseDuplicateCopyRestDTO.setStatus("Internal Server Error");
						tradeLicenseDuplicateCopyRestDTO.setNocforTheRelatedDepartmentIssuedFromNMCDepartment("");
						tradeLicenseDuplicateCopyRestDTO.setCopyOfTheFormerLicence("");
						tradeLicenseDuplicateCopyRestDTO.setBuildingAuthorizationDocument("");
						tradeLicenseDuplicateCopyRestDTO.setNoDuesCertificateforPropertyTax("");
					}
				}
			
			
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			tradeLicenseDuplicateCopyRestDTO.setResponseStatus(ex.getMessage());
			tradeLicenseDuplicateCopyRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicenseDuplicateCopyRestDTO.setStatus("Method not Allowed");
			tradeLicenseDuplicateCopyRestDTO.setNocforTheRelatedDepartmentIssuedFromNMCDepartment("");
			tradeLicenseDuplicateCopyRestDTO.setCopyOfTheFormerLicence("");
			tradeLicenseDuplicateCopyRestDTO.setBuildingAuthorizationDocument("");
			tradeLicenseDuplicateCopyRestDTO.setNoDuesCertificateforPropertyTax("");
		}

		return tradeLicenseDuplicateCopyRestDTO;
	}
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicenseDuplicateCopy";
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
