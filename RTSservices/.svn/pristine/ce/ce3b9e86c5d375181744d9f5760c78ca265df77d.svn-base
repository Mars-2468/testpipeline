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

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TradeLicenseCancellation;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseCancellationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenseCancellationRestDTO;

@Controller
public class TradeLicenseCancellationRestDTOController {

	private static Log log = LogFactory.getLog(TradeLicenseCancellationRestDTOController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TradeLicenseCancellationService tradeLicenseCancellationService;
	

	@RequestMapping(method = RequestMethod.POST, value = "/saveTradeLicenseCancellationApplication")
	public @ResponseBody TradeLicenseCancellationRestDTO saveTradeLicenseCancellationApplication(
			@RequestBody TradeLicenseCancellationRestDTO tradeLicenseCancellationRestDTO, HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];
		UserRegistrationDetails user = new UserRegistrationDetails();

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMarriageApplication");
		}
		TradeLicenseCancellation tradeLicenseCancellation = new TradeLicenseCancellation();

		try {
			if (tradeLicenseCancellationRestDTO.getName() != null
					&& !tradeLicenseCancellationRestDTO.getName().isEmpty()) {
				tradeLicenseCancellation.setFirstName(tradeLicenseCancellationRestDTO.getName());
				;
			} else {
				String firstName = "First Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getTitle() != null
					&& !tradeLicenseCancellationRestDTO.getTitle().isEmpty()) {
				tradeLicenseCancellation.setTitle(tradeLicenseCancellationRestDTO.getTitle());
				;
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getSurname() != null
					&& !tradeLicenseCancellationRestDTO.getSurname().isEmpty()) {
				tradeLicenseCancellation.setLastName(tradeLicenseCancellationRestDTO.getSurname());
			} else {
				String lastName = "Last Name field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getPincode() != 0
					&& !String.valueOf(tradeLicenseCancellationRestDTO.getPincode()).isEmpty()) {
				tradeLicenseCancellation.setPinCode(tradeLicenseCancellationRestDTO.getPincode());

			} else {
				String PinCode = "Pin Code field is Required";
				condition = false;
				message.append(PinCode).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getEmailID() != null
					&& !tradeLicenseCancellationRestDTO.getEmailID().isEmpty()) {
				tradeLicenseCancellation.setEmailID(tradeLicenseCancellationRestDTO.getEmailID());

			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getMobileNumber() != 0) {
				tradeLicenseCancellation
						.setMobileNumber(String.valueOf(tradeLicenseCancellationRestDTO.getMobileNumber()));

			} else {
				String mobileNo = "Mobile No. field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getAdressForCorrespondence() != null
					&& !tradeLicenseCancellationRestDTO.getAdressForCorrespondence().isEmpty()) {
				tradeLicenseCancellation.setAdressForCorrespondence(tradeLicenseCancellationRestDTO.getAdressForCorrespondence());

			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getZoneNo() != 0) {
				tradeLicenseCancellation.setZoneNo(String.valueOf(tradeLicenseCancellationRestDTO.getZoneNo()));

			} else {
				String zoneNo = "Zone No field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getWardNo() != 0) {
				tradeLicenseCancellation.setWardNo(String.valueOf(tradeLicenseCancellationRestDTO.getWardNo()));

			} else {
				String Address = "WardNo field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getTradeLicenceNo() != null
					&& !tradeLicenseCancellationRestDTO.getTradeLicenceNo().isEmpty()) {
				tradeLicenseCancellation.setTradeLicenceNo(tradeLicenseCancellationRestDTO.getTradeLicenceNo());

			} else {
				String TradeLicenceNo = "TradeLicenceNo field is Required";
				condition = false;
				message.append(TradeLicenceNo).append(",");
			}
		
			if (tradeLicenseCancellationRestDTO.getUpdatedTradeType() != null
					&& !tradeLicenseCancellationRestDTO.getUpdatedTradeType().isEmpty()) {
				tradeLicenseCancellation.setUpdatedTradeType(tradeLicenseCancellationRestDTO.getUpdatedTradeType());

			} else {
				String tradeType = "trade Type field is Required";
				condition = false;
				message.append(tradeType).append(",");
			}
			tradeLicenseCancellation.setUpdatedOwnerName(tradeLicenseCancellationRestDTO.getUpdatedOwnerName());
			tradeLicenseCancellation.setUpdatedPartnerCount(tradeLicenseCancellationRestDTO.getUpdatedTradeType());
			
			if (tradeLicenseCancellationRestDTO.getFeesApplicable() != 0) {
				tradeLicenseCancellation.setFeesApplicable(tradeLicenseCancellationRestDTO.getFeesApplicable());

			} else {
				String feesApplicable = "feesApplicable field is Required";
				condition = false;
				message.append(feesApplicable).append(",");
			}
			

			
			
      
			// file Uplode
			
			if ( tradeLicenseCancellationRestDTO.getBuildingAuthorizationDocumentPDF()!= null
					&& !tradeLicenseCancellationRestDTO.getBuildingAuthorizationDocumentPDF()
							.isEmpty()) {
				String doc0 = tradeLicenseCancellationRestDTO.getBuildingAuthorizationDocumentPDF();

				files[0] = doc0;
			} else {
				String doc0 = "Building Authorization DocumentPDF field is Required";
				condition = false;
				message.append(doc0).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getCopyoftheFormerLicencePDF()!= null
					&& !tradeLicenseCancellationRestDTO.getCopyoftheFormerLicencePDF()
							.isEmpty()) {
				String doc1 = tradeLicenseCancellationRestDTO.getCopyoftheFormerLicencePDF();

				files[1] = doc1;
			} else {
				String doc1 = " Copy of the FormerLicencePDF";
				condition = false;
				message.append(doc1).append(",");
			}
			if (tradeLicenseCancellationRestDTO.getNocfortherelateddepartmentPDF()!= null
					&& !tradeLicenseCancellationRestDTO.getNocfortherelateddepartmentPDF()
							.isEmpty()) {
				String doc2 = tradeLicenseCancellationRestDTO.getNocfortherelateddepartmentPDF();

				files[2] = doc2;
			} else {
				String doc2 = " Noc for there lateddepartment PDF field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			String doc3 = tradeLicenseCancellationRestDTO.getNoDuesCertificateforPropertyTaxPDF();					
			files[3] = doc3;
			
			tradeLicenseCancellation.setMiddleName(tradeLicenseCancellationRestDTO.getFatherName());
			tradeLicenseCancellation.setFullName(tradeLicenseCancellationRestDTO.getFullName());
			tradeLicenseCancellation.setAadhaarNo(tradeLicenseCancellationRestDTO.getAadharNo());
			tradeLicenseCancellation.setNameOfArea(tradeLicenseCancellationRestDTO.getNameOfArea());
			tradeLicenseCancellation.setUpdateTradeName(tradeLicenseCancellationRestDTO.getUpdateTradeName());
			RTIApplication rtiApplication = new RTIApplication();
//			if (tradeLicenseCancellationRestDTO.getFilesPath() != null
//					&& !tradeLicenseCancellationRestDTO.getFilesPath().isEmpty()) {
//				rtiApplication.setPdfFilesSavedPath(tradeLicenseCancellationRestDTO.getFilesPath());
//			} else {
//				String pdf = "PdfFilesSavedPath field is Required";
//				condition = false;
//				message.append(pdf).append(",");
//			}
			if (tradeLicenseCancellationRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseCancellationRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			String savedFilePath = TradeLicenseCancellationRestDTOController
					.saveFile(files, request);
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENSE-CANCELLATION");
				rtiApplication.setTemplateName("tradelicensecancellationApplication");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(40);
				rtiApplication.setApplicantName(tradeLicenseCancellation.getFullName());
				rtiApplication.setPhoneNumber(tradeLicenseCancellation.getMobileNumber());
				rtiApplication.setMobileNumber(tradeLicenseCancellation.getMobileNumber());
				
				
				//rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseCancellationRestDTO.getMobileUserNo()));
				rtiApplication.setEmail(tradeLicenseCancellation.getEmailID());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);

				rtiApplication.setZone(tradeLicenseCancellation.getZoneNo());

				rtiApplication.setApplicationCost(tradeLicenseCancellation.getFeesApplicable());

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
					rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					tradeLicenseCancellation.setRtiApplRefNo(rti.getRtiApplnNumber());
					tradeLicenseCancellation.setRtiRefId(savedRti.getRtiApplicationId());
					long birth_regis_id = tradeLicenseCancellationService
							.tradeLicenseCancellation(tradeLicenseCancellation);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						tradeLicenseCancellationRestDTO.setResponseStatus("Requested data saved successfully");
						tradeLicenseCancellationRestDTO.setResult(retunRti.getRtiApplnNumber());
						tradeLicenseCancellationRestDTO.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						tradeLicenseCancellationRestDTO.setStatus("ok");
					}
					String name = tradeLicenseCancellation.getFirstName() + tradeLicenseCancellation.getMiddleName()
							+ tradeLicenseCancellation.getLastName();
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(tradeLicenseCancellation.getEmailID(),
							"Application Submitted Successfully" + applnNo, msg);
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenseCancellation.getMobileNumber(),
							msg);
				}
			}

			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					tradeLicenseCancellationRestDTO.setResult(message.toString());
					tradeLicenseCancellationRestDTO.setResponseStatus("Requested data not saved successfully");
					tradeLicenseCancellationRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					tradeLicenseCancellationRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			tradeLicenseCancellationRestDTO.setResponseStatus(ex.getMessage());
			tradeLicenseCancellationRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicenseCancellationRestDTO.setStatus("Method not Allowed");
		}
		return tradeLicenseCancellationRestDTO;
	}
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicenseCancellation";
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
