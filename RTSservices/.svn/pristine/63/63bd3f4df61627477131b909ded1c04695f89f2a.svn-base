
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
import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseTransferService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.LicenseTransferRestDTO;

@Controller
public class  LicenseTransferRestController {
private static Log log = LogFactory.getLog(LicenseTransferRestController.class);
@Autowired
private RTIApplicationService rtiApplicationService;

@Autowired
private TradeLicenseTransferService tradeLicenseTransferService;

@RequestMapping(method = RequestMethod.POST, value = "/saveTradeTransfer")
public @ResponseBody LicenseTransferRestDTO saveTradetransfer(
		@RequestBody LicenseTransferRestDTO LicenseTransferRestDTO, HttpServletRequest request,
		HttpServletResponse response) throws ServletException {
	boolean condition = true;
	StringBuilder message = new StringBuilder();
	String[] files = new String[5];
	if (log.isDebugEnabled()) {
		log.debug("Invoking saveTradeRenewal");
		TradeLicenseTransfer tradeLicenceTransfer = new TradeLicenseTransfer();
		
		try {

			if ((LicenseTransferRestDTO.getName() != null) && !LicenseTransferRestDTO.getName().isEmpty()) {
				tradeLicenceTransfer.setFirstName(LicenseTransferRestDTO.getName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if ((LicenseTransferRestDTO.getTitle() != null) && !LicenseTransferRestDTO.getTitle().isEmpty()) {
				tradeLicenceTransfer.setTitle(LicenseTransferRestDTO.getTitle());
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			
			if ((LicenseTransferRestDTO.getSurName() != null)
					&& !LicenseTransferRestDTO.getSurName().isEmpty()) {
				tradeLicenceTransfer.setLastName(LicenseTransferRestDTO.getSurName());
			} else {
				String LastName = "LastName field is Required";
				condition = false;
				message.append(LastName).append(",");
			}
			
			if ((LicenseTransferRestDTO.getFullName() != null)
					&& !LicenseTransferRestDTO.getFullName().isEmpty()) {
				tradeLicenceTransfer.setFullName(LicenseTransferRestDTO.getFullName());
			} else {
				String FullName = "FullName field is Required";
				condition = false;
				message.append(FullName).append(",");
			}
			
			if (LicenseTransferRestDTO.getPinCode() != 0) {
				tradeLicenceTransfer.setPinCode(LicenseTransferRestDTO.getPinCode());
			} else {
				String ApplicantPinCode = "PinCode. field is Required";
				condition = false;
				message.append(ApplicantPinCode).append(",");

			}
			
			if (LicenseTransferRestDTO.getMobileNo() != 0) {

				tradeLicenceTransfer.setMobileNo(String.valueOf(LicenseTransferRestDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}
			if ((LicenseTransferRestDTO.getAddress() != null)
					&& !LicenseTransferRestDTO.getAddress().isEmpty()) {
				tradeLicenceTransfer.setAddress(LicenseTransferRestDTO.getAddress());
			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			
			if ((LicenseTransferRestDTO.getApplicableFee() != 0.0 || LicenseTransferRestDTO.getApplicableFee() != 0)) {
				tradeLicenceTransfer.setFeesApplicable(LicenseTransferRestDTO.getApplicableFee());
			} else {
				String fees = "Fees field is Required";
				condition = false;
				message.append(fees).append(",");
			}
			
			if ((LicenseTransferRestDTO.getWardNo() != null)
					&& !LicenseTransferRestDTO.getWardNo().isEmpty()) {
				tradeLicenceTransfer.setWardNo(LicenseTransferRestDTO.getWardNo());
			} else {
				String ward = "Ward Number field is Required";
				condition = false;
				message.append(ward).append(",");
			}
			
			if ((LicenseTransferRestDTO.getAreaName() != null)
					&& !LicenseTransferRestDTO.getAreaName().isEmpty()) {
				tradeLicenceTransfer.setNameOfArea(LicenseTransferRestDTO.getAreaName());
			} else {
				String AreaName = "AreaName field is Required";
				condition = false;
				message.append(AreaName).append(",");
			}
			if ((LicenseTransferRestDTO.getEmail() != null) && !LicenseTransferRestDTO.getEmail().isEmpty()) {
				tradeLicenceTransfer.setEmail(LicenseTransferRestDTO.getEmail());
			} else {
				String Email = "Email field is Required";
				condition = false;
				message.append(Email).append(",");
			}

			if (LicenseTransferRestDTO.getZoneNo() != 0) {
				tradeLicenceTransfer.setZoneNo(String.valueOf(LicenseTransferRestDTO.getZoneNo()));
			} else {
				String zone = "ZonNo. field is Required";
				condition = false;
				message.append(zone).append(",");
			}
			
			if ((LicenseTransferRestDTO.getTradelicenseNo() != null)
					&& !LicenseTransferRestDTO.getTradelicenseNo().isEmpty()) {
				tradeLicenceTransfer.setTradeLicenseNo(LicenseTransferRestDTO.getTradelicenseNo());
			} else {
				String TradeLicenseNo = "TradeLicenseNo field is Required";
				condition = false;
				message.append(TradeLicenseNo).append(",");
			}
			
			if ((LicenseTransferRestDTO.getUpdatedtradetype() != null)
					&& !LicenseTransferRestDTO.getUpdatedtradetype().isEmpty()) {
				tradeLicenceTransfer.setUpdatedTradeType(LicenseTransferRestDTO.getUpdatedtradetype());
			} else {
				String Updatedtradetype = "Updatedtradetype field is Required";
				condition = false;
				message.append(Updatedtradetype).append(",");
			}
			
			if (LicenseTransferRestDTO.getMobileNo() != 0) {
				tradeLicenceTransfer.setMobileNo(String.valueOf(LicenseTransferRestDTO.getMobileNo()));
			} else {
				String mobile = "Mobile Number field is Required";
				condition = false;
				message.append(mobile).append(",");
			}
			

			String doc1 = LicenseTransferRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

			files[0] = doc1;
			if (LicenseTransferRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf() != null
					&& !LicenseTransferRestDTO
							.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf()
							.isEmpty()) {
				String doc2 = LicenseTransferRestDTO
						.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

				files[1] = doc2;
			} else {
				String doc2 = "NOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficer field is Required";
				condition = false;
				message.append(doc2).append(",");
			}

			if (LicenseTransferRestDTO.getCopyoftheFormerLicencepdf() != null
					&& !LicenseTransferRestDTO.getCopyoftheFormerLicencepdf().isEmpty()) {
				String doc3 = LicenseTransferRestDTO.getCopyoftheFormerLicencepdf();

				files[2] = doc3;
			} else {
				String doc3 = "CopyoftheFormerLicencefield is Required";
				condition = false;
				message.append(doc3).append(",");
			}

			if (LicenseTransferRestDTO.getNoDuesCertificateforPropertyTaxpdf() != null
					&& !LicenseTransferRestDTO.getNoDuesCertificateforPropertyTaxpdf().isEmpty()) {
				String doc4 = LicenseTransferRestDTO.getNoDuesCertificateforPropertyTaxpdf();
				files[3] = doc4;
			} else {
				String doc4 = "NoDuesCertificateforPropertyTax field is Required";
				condition = false;
				message.append(doc4).append(",");
			}

			String doc5 = LicenseTransferRestDTO.getBuildingAuthorizationDocumentpdf();
			files[4] = doc5;

			String savedFilePath = LicenseTransferRestController.saveFile(files,
					request);

			tradeLicenceTransfer.setMiddleName(LicenseTransferRestDTO.getFatherName());
			tradeLicenceTransfer.setUpdatedTradeName(LicenseTransferRestDTO.getUpdatedtradename());
			tradeLicenceTransfer.setUpdatedOwnerName(LicenseTransferRestDTO.getUpdatedownername());
			tradeLicenceTransfer.setUpdatedPartnerCount(LicenseTransferRestDTO.getUpdatedpatnercount());
			tradeLicenceTransfer.setAadhaarNo((LicenseTransferRestDTO.getAadharNo()));


			RTIApplication rtiApplication = new RTIApplication();
			if (LicenseTransferRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileNumber(String.valueOf(LicenseTransferRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (LicenseTransferRestDTO.getMobileNo() != 0) {
				rtiApplication.setPhoneNumber(String.valueOf(LicenseTransferRestDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}
			
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENSE-TRANSFER-NOTICE");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(42);
				rtiApplication.setApplicantName(tradeLicenceTransfer.getFirstName() + " "
						+ tradeLicenceTransfer.getMiddleName() + " "
						+ tradeLicenceTransfer.getLastName());
				rtiApplication.setPhoneNumber(tradeLicenceTransfer.getMobileNo());
				rtiApplication.setMobileNumber(tradeLicenceTransfer.getMobileNo());
				rtiApplication.setZone(tradeLicenceTransfer.getZoneNo());
				//rtiApplication.set(tradeLicesnseOutadedRenewalRestDTO.getUserMobileNumber();
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setEmail(tradeLicenceTransfer.getEmail());

				rtiApplication.setApplicationCost(tradeLicenceTransfer.getFeesApplicable());
				// rtiApplication.setApplicationCost(15);

				rtiApplication.setApplicantName(tradeLicenceTransfer.getFullName());
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
					tradeLicenceTransfer.setRtiapplrefno(rti.getRtiApplnNumber());
					tradeLicenceTransfer.setRti_ref_id(savedRti.getRtiApplicationId());
					long zone_regis_id = tradeLicenseTransferService.tradeLicenseTransfer(tradeLicenceTransfer);
					rti.setRtiApplicationRefId(zone_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					
					if ((retunRti != null) && (zone_regis_id > 0)) {
						LicenseTransferRestDTO.setResponseStatus("Requested data saved successfully");
						LicenseTransferRestDTO.setResponseCode(200);// 2145
						LicenseTransferRestDTO.setStatus("ok");
						response.setStatus(HttpStatus.OK.value());
						LicenseTransferRestDTO.setResult(retunRti.getRtiApplnNumber());
						
					}
					String name = tradeLicenceTransfer.getFirstName() + tradeLicenceTransfer.getMiddleName()
							+ tradeLicenceTransfer.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenceTransfer.getMobileNo(), msg);
					SendEmail.sendEmail(tradeLicenceTransfer.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					LicenseTransferRestDTO.setResult(message.toString());
					LicenseTransferRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					LicenseTransferRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					LicenseTransferRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			LicenseTransferRestDTO.setResponseStatus(ex.getMessage());
			LicenseTransferRestDTO.setResponseCode(405);
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			LicenseTransferRestDTO.setStatus("Method not Allowed");
		}
	}
		return LicenseTransferRestDTO;
	}
	
public static String saveFile(String data[], HttpServletRequest request) throws IOException {
	String filesPath = null;
	StringBuilder filesPathBuilder = new StringBuilder();
	String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicenseTransfer";
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
