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
import com.mars.rti.model.TradeLicenseOutdatedRenewalNotice;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseOutdatedRenewalService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicesnseOutadedRenewalRestDTO;

@Controller
public class TradeLicesnseOutadedRenewalRestController {
private static Log log = LogFactory.getLog(TradeLicesnseOutadedRenewalRestController.class);
@Autowired
private RTIApplicationService rtiApplicationService;

@Autowired
private TradeLicenseOutdatedRenewalService tradeLicenseOutdatedRenewalService;


@RequestMapping(method = RequestMethod.POST, value = "/saveTradeOutdatedRenewal")
public @ResponseBody TradeLicesnseOutadedRenewalRestDTO saveTradeOutdatedRenewal(
		@RequestBody TradeLicesnseOutadedRenewalRestDTO tradeLicesnseOutadedRenewalRestDTO, HttpServletRequest request,
		HttpServletResponse response) throws ServletException {
	boolean condition = true;
	StringBuilder message = new StringBuilder();
	String[] files = new String[5];
	if (log.isDebugEnabled()) {
		log.debug("Invoking saveTradeRenewal");
		TradeLicenseOutdatedRenewalNotice tradeLicenceRenewal = new TradeLicenseOutdatedRenewalNotice();
		
		try {

			if ((tradeLicesnseOutadedRenewalRestDTO.getName() != null) && !tradeLicesnseOutadedRenewalRestDTO.getName().isEmpty()) {
				tradeLicenceRenewal.setFirstName(tradeLicesnseOutadedRenewalRestDTO.getName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if ((tradeLicesnseOutadedRenewalRestDTO.getTitle() != null) && !tradeLicesnseOutadedRenewalRestDTO.getTitle().isEmpty()) {
				tradeLicenceRenewal.setTitle(tradeLicesnseOutadedRenewalRestDTO.getTitle());
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getSurName() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getSurName().isEmpty()) {
				tradeLicenceRenewal.setLastName(tradeLicesnseOutadedRenewalRestDTO.getSurName());
			} else {
				String LastName = "LastName field is Required";
				condition = false;
				message.append(LastName).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getFullName() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getFullName().isEmpty()) {
				tradeLicenceRenewal.setFullName(tradeLicesnseOutadedRenewalRestDTO.getFullName());
			} else {
				String FullName = "FullName field is Required";
				condition = false;
				message.append(FullName).append(",");
			}
			
			if (tradeLicesnseOutadedRenewalRestDTO.getPinCode() != 0) {
				tradeLicenceRenewal.setPinCode(tradeLicesnseOutadedRenewalRestDTO.getPinCode());
			} else {
				String ApplicantPinCode = "PinCode. field is Required";
				condition = false;
				message.append(ApplicantPinCode).append(",");

			}
			
			if (tradeLicesnseOutadedRenewalRestDTO.getMobileNo() != 0) {

				tradeLicenceRenewal.setMobileNumber(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}
			if ((tradeLicesnseOutadedRenewalRestDTO.getAddress() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getAddress().isEmpty()) {
				tradeLicenceRenewal.setAdressForCorrespondence(tradeLicesnseOutadedRenewalRestDTO.getAddress());
			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getWardNo() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getWardNo().isEmpty()) {
				tradeLicenceRenewal.setWardNo(tradeLicesnseOutadedRenewalRestDTO.getWardNo());
			} else {
				String ward = "Ward Number field is Required";
				condition = false;
				message.append(ward).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getAreaName() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getAreaName().isEmpty()) {
				tradeLicenceRenewal.setNameOfArea(tradeLicesnseOutadedRenewalRestDTO.getAreaName());
			} else {
				String AreaName = "AreaName field is Required";
				condition = false;
				message.append(AreaName).append(",");
			}
			if ((tradeLicesnseOutadedRenewalRestDTO.getEmail() != null) && !tradeLicesnseOutadedRenewalRestDTO.getEmail().isEmpty()) {
				tradeLicenceRenewal.setEmailID(tradeLicesnseOutadedRenewalRestDTO.getEmail());
			} else {
				String Email = "Email field is Required";
				condition = false;
				message.append(Email).append(",");
			}

			if (tradeLicesnseOutadedRenewalRestDTO.getZoneNo() != 0) {
				tradeLicenceRenewal.setZoneNo(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getZoneNo()));
			} else {
				String zone = "ZonNo. field is Required";
				condition = false;
				message.append(zone).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getTradelicenseNo() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getTradelicenseNo().isEmpty()) {
				tradeLicenceRenewal.setTradeLicenceNo(tradeLicesnseOutadedRenewalRestDTO.getTradelicenseNo());
			} else {
				String TradeLicenseNo = "TradeLicenseNo field is Required";
				condition = false;
				message.append(TradeLicenseNo).append(",");
			}
			if ((tradeLicesnseOutadedRenewalRestDTO.getFees() != 0.0 || tradeLicesnseOutadedRenewalRestDTO.getFees() != 0)) {
				tradeLicenceRenewal.setFeesApplicable(tradeLicesnseOutadedRenewalRestDTO.getFees());
			} else {
				String fees = "Fees field is Required";
				condition = false;
				message.append(fees).append(",");
			}
			
			if ((tradeLicesnseOutadedRenewalRestDTO.getUpdatedtradetype() != null)
					&& !tradeLicesnseOutadedRenewalRestDTO.getUpdatedtradetype().isEmpty()) {
				tradeLicenceRenewal.setUpdatedTradeType(tradeLicesnseOutadedRenewalRestDTO.getUpdatedtradetype());
			} else {
				String Updatedtradetype = "Updatedtradetype field is Required";
				condition = false;
				message.append(Updatedtradetype).append(",");
			}
			
			if (tradeLicesnseOutadedRenewalRestDTO.getMobileNo() != 0) {
				tradeLicenceRenewal.setMobileNumber(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getMobileNo()));
			} else {
				String mobile = "Mobile Number field is Required";
				condition = false;
				message.append(mobile).append(",");
			}
			

			String doc1 = tradeLicesnseOutadedRenewalRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

			files[0] = doc1;
			if (tradeLicesnseOutadedRenewalRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf() != null
					&& !tradeLicesnseOutadedRenewalRestDTO
							.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf()
							.isEmpty()) {
				String doc2 = tradeLicesnseOutadedRenewalRestDTO
						.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

				files[1] = doc2;
			} else {
				String doc2 = "NOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficer field is Required";
				condition = false;
				message.append(doc2).append(",");
			}

			if (tradeLicesnseOutadedRenewalRestDTO.getCopyoftheFormerLicencepdf() != null
					&& !tradeLicesnseOutadedRenewalRestDTO.getCopyoftheFormerLicencepdf().isEmpty()) {
				String doc3 = tradeLicesnseOutadedRenewalRestDTO.getCopyoftheFormerLicencepdf();

				files[2] = doc3;
			} else {
				String doc3 = "CopyoftheFormerLicencefield is Required";
				condition = false;
				message.append(doc3).append(",");
			}

			if (tradeLicesnseOutadedRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf() != null
					&& !tradeLicesnseOutadedRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf().isEmpty()) {
				String doc4 = tradeLicesnseOutadedRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf();
				files[3] = doc4;
			} else {
				String doc4 = "NoDuesCertificateforPropertyTax field is Required";
				condition = false;
				message.append(doc4).append(",");
			}

			String doc5 = tradeLicesnseOutadedRenewalRestDTO.getBuildingAuthorizationDocumentpdf();
			files[4] = doc5;

			String savedFilePath = TradeLicesnseOutadedRenewalRestController.saveFile(files,
					request);

			tradeLicenceRenewal.setMiddleName(tradeLicesnseOutadedRenewalRestDTO.getFatherName());
			tradeLicenceRenewal.setUpdatedOwnerName(tradeLicesnseOutadedRenewalRestDTO.getUpdatedownername());
			tradeLicenceRenewal.setUpdatedPartnerCount(tradeLicesnseOutadedRenewalRestDTO.getUpdatedpatnercount());
			tradeLicenceRenewal.setAadhaarNo(Long.parseLong(tradeLicesnseOutadedRenewalRestDTO.getAadharNo()));


			RTIApplication rtiApplication = new RTIApplication();
			if (tradeLicesnseOutadedRenewalRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileNumber(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (tradeLicesnseOutadedRenewalRestDTO.getMobileNo() != 0) {
				rtiApplication.setPhoneNumber(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}
			
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENSE-OutdatedRenewal-NOTICE");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(42);
				rtiApplication.setApplicantName(tradeLicenceRenewal.getFirstName() + " "
						+ tradeLicenceRenewal.getMiddleName() + " "
						+ tradeLicenceRenewal.getLastName());
				rtiApplication.setPhoneNumber(tradeLicenceRenewal.getMobileNumber());
				rtiApplication.setMobileNumber(tradeLicenceRenewal.getMobileNumber());
				rtiApplication.setZone(tradeLicenceRenewal.getZoneNo());
				rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicesnseOutadedRenewalRestDTO.getUserMobileNumber()));
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setEmail(tradeLicenceRenewal.getEmailID());

				rtiApplication.setApplicationCost(tradeLicenceRenewal.getFeesApplicable());
				// rtiApplication.setApplicationCost(15);

				rtiApplication.setApplicantName(tradeLicenceRenewal.getFullName());
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
					tradeLicenceRenewal.setRtiApplRefNo(rti.getRtiApplnNumber());
					tradeLicenceRenewal.setRtiRefId(savedRti.getRtiApplicationId());
					long zone_regis_id = tradeLicenseOutdatedRenewalService.tradeLicenseOutdatedRenewal(tradeLicenceRenewal);
					rti.setRtiApplicationRefId(zone_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					
					if ((retunRti != null) && (zone_regis_id > 0)) {
						tradeLicesnseOutadedRenewalRestDTO.setResponseStatus("Requested data saved successfully");
						tradeLicesnseOutadedRenewalRestDTO.setResponseCode(HttpStatus.OK.value());// 2145
						response.setStatus(HttpStatus.OK.value());
						tradeLicesnseOutadedRenewalRestDTO.setStatus("ok");
						tradeLicesnseOutadedRenewalRestDTO.setResult(retunRti.getRtiApplnNumber());
						tradeLicesnseOutadedRenewalRestDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
						tradeLicesnseOutadedRenewalRestDTO.setCopyoftheFormerLicencepdf("");
						tradeLicesnseOutadedRenewalRestDTO.setBuildingAuthorizationDocumentpdf("");
						tradeLicesnseOutadedRenewalRestDTO.setNoDuesCertificateforPropertyTaxpdf("");
					}
					String name = tradeLicenceRenewal.getFirstName() + tradeLicenceRenewal.getMiddleName()
							+ tradeLicenceRenewal.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenceRenewal.getMobileNumber(), msg);
					SendEmail.sendEmail(tradeLicenceRenewal.getEmailID(), "Application Submitted Successfully" + applnNo,
							msg);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					tradeLicesnseOutadedRenewalRestDTO.setResult(message.toString());
					tradeLicesnseOutadedRenewalRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					tradeLicesnseOutadedRenewalRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					tradeLicesnseOutadedRenewalRestDTO.setStatus("Internal Server Error");
					tradeLicesnseOutadedRenewalRestDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
					tradeLicesnseOutadedRenewalRestDTO.setCopyoftheFormerLicencepdf("");
					tradeLicesnseOutadedRenewalRestDTO.setBuildingAuthorizationDocumentpdf("");
					tradeLicesnseOutadedRenewalRestDTO.setNoDuesCertificateforPropertyTaxpdf("");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			tradeLicesnseOutadedRenewalRestDTO.setResponseStatus(ex.getMessage());
			tradeLicesnseOutadedRenewalRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicesnseOutadedRenewalRestDTO.setStatus("Method not Allowed");
			tradeLicesnseOutadedRenewalRestDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
			tradeLicesnseOutadedRenewalRestDTO.setCopyoftheFormerLicencepdf("");
			tradeLicesnseOutadedRenewalRestDTO.setBuildingAuthorizationDocumentpdf("");
			tradeLicesnseOutadedRenewalRestDTO.setNoDuesCertificateforPropertyTaxpdf("");
		}
	}
		return tradeLicesnseOutadedRenewalRestDTO;
	}
	
public static String saveFile(String data[], HttpServletRequest request) throws IOException {
	String filesPath = null;
	StringBuilder filesPathBuilder = new StringBuilder();
	String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicenseOutdatedRenewal";
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
