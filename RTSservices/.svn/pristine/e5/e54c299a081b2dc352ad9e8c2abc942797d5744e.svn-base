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
import com.mars.rti.model.TradeLicenceNew;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenceNewService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenseNewDTO;

@Controller
public class TradeLicenseNew{
	
	private static Log log = LogFactory.getLog(TradeLicenseNew.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TradeLicenceNewService  tradeLicenceNewService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/saveTradeNew")
	public @ResponseBody TradeLicenseNewDTO saveTradeNew(
			@RequestBody TradeLicenseNewDTO tradeLicenseNewDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveTradeNew");
		}
	
		
		TradeLicenceNew tradeLicenceNew = new TradeLicenceNew();
		
		try {

			if ((tradeLicenseNewDTO.getName() != null) && !tradeLicenseNewDTO.getName().isEmpty()) {
				tradeLicenceNew.setFirstName(tradeLicenseNewDTO.getName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
			if ((tradeLicenseNewDTO.getTitle() != null) && !tradeLicenseNewDTO.getTitle().isEmpty()) {
				tradeLicenceNew.setTitle(tradeLicenseNewDTO.getTitle());
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			
			if ((tradeLicenseNewDTO.getSurName() != null)
					&& !tradeLicenseNewDTO.getSurName().isEmpty()) {
				tradeLicenceNew.setLastName(tradeLicenseNewDTO.getSurName());
			} else {
				String LastName = "SurName field is Required";
				condition = false;
				message.append(LastName).append(",");
			}
			
			

			if ((tradeLicenseNewDTO.getFullName() != null)
					&& !tradeLicenseNewDTO.getFullName().isEmpty()) {
				tradeLicenceNew.setFullName(tradeLicenseNewDTO.getFullName());
			} else {
				String FullName = "FullName field is Required";
				condition = false;
				message.append(FullName).append(",");
			}

			if (tradeLicenseNewDTO.getPinCode() != 0) {
				tradeLicenceNew.setPinCode(tradeLicenseNewDTO.getPinCode());
			} else {
				String ApplicantPinCode = "PinCode. field is Required";
				condition = false;
				message.append(ApplicantPinCode).append(",");

			}

			if (tradeLicenseNewDTO.getMobileNo() != 0) {

				tradeLicenceNew.setMobileNo(String.valueOf(tradeLicenseNewDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}

			if ((tradeLicenseNewDTO.getAddress() != null)
					&& !tradeLicenseNewDTO.getAddress().isEmpty()) {
				tradeLicenceNew.setAddress(tradeLicenseNewDTO.getAddress());
			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}

			if ((tradeLicenseNewDTO.getNameOfBusiness() != null)
					&& !tradeLicenseNewDTO.getNameOfBusiness().isEmpty()) {
				tradeLicenceNew.setNameOfBusiness(tradeLicenseNewDTO.getNameOfBusiness());
			} else {
				String NameOfBusiness = "NameOfBusiness field is Required";
				condition = false;
				message.append(NameOfBusiness).append(",");
			}

			if ((tradeLicenseNewDTO.getBusinessDetails() != null)
					&& !tradeLicenseNewDTO.getBusinessDetails().isEmpty()) {
				tradeLicenceNew.setBusinessDetails(tradeLicenseNewDTO.getBusinessDetails());
			} else {
				String BusinessDetails = "BusinessDetails field is Required";
				condition = false;
				message.append(BusinessDetails).append(",");
			}
			if ((tradeLicenseNewDTO.getBusinesDoneDate() != null)
					&& !tradeLicenseNewDTO.getBusinesDoneDate().isEmpty()) {
				tradeLicenceNew.setBusinesDoneDate(tradeLicenseNewDTO.getBusinesDoneDate());
			} else {
				String BusinesDoneDate = "BusinesDoneDate field is Required";
				condition = false;
				message.append(BusinesDoneDate).append(",");
			}

			if ((tradeLicenseNewDTO.getAreaName() != null)
					&& !tradeLicenseNewDTO.getAreaName().isEmpty()) {
				tradeLicenceNew.setAreaName(tradeLicenseNewDTO.getAreaName());
			} else {
				String AreaName = "AreaName field is Required";
				condition = false;
				message.append(AreaName).append(",");
			}

			if ((tradeLicenseNewDTO.getEmail() != null) && !tradeLicenseNewDTO.getEmail().isEmpty()) {
				tradeLicenceNew.setEmail(tradeLicenseNewDTO.getEmail());
			} else {
				String Email = "Email field is Required";
				condition = false;
				message.append(Email).append(",");
			}

			if ((tradeLicenseNewDTO.getHeight() != null) && !tradeLicenseNewDTO.getHeight().isEmpty()) {
				tradeLicenceNew.setHeight(tradeLicenseNewDTO.getHeight());
			} else {
				String Height = "Height field is Required";
				condition = false;
				message.append(Height).append(",");
			}
			if ((tradeLicenseNewDTO.getLength() != null) && !tradeLicenseNewDTO.getLength().isEmpty()) {
				tradeLicenceNew.setLength(tradeLicenseNewDTO.getLength());
			} else {
				String Length = "Length field is Required";
				condition = false;
				message.append(Length).append(",");
			}
			if ((tradeLicenseNewDTO.getWidth() != null) && !tradeLicenseNewDTO.getWidth().isEmpty()) {
				tradeLicenceNew.setWidth(tradeLicenseNewDTO.getWidth());
			} else {
				String Width = "Width field is Required";
				condition = false;
				message.append(Width).append(",");
			}

			if (tradeLicenseNewDTO.getZoneNo() != 0) {
				tradeLicenceNew.setZoneNo(String.valueOf(tradeLicenseNewDTO.getZoneNo()));
			} else {
				String zone = "ZonNo. field is Required";
				condition = false;
				message.append(zone).append(",");
			}

			

			if ((tradeLicenseNewDTO.getUpdatedtradetype() != null)
					&& !tradeLicenseNewDTO.getUpdatedtradetype().isEmpty()) {
				tradeLicenceNew.setUpdatedTradeType(tradeLicenseNewDTO.getUpdatedtradetype());
			} else {
				String Updatedtradetype = "Updatedtradetype field is Required";
				condition = false;
				message.append(Updatedtradetype).append(",");
			}
			if (tradeLicenseNewDTO.getMobileNo() != 0) {
				tradeLicenceNew.setMobileNo(String.valueOf(tradeLicenseNewDTO.getMobileNo()));
			} else {
				String mobile = "Mobile Number field is Required";
				condition = false;
				message.append(mobile).append(",");
			}

			if ((tradeLicenseNewDTO.getAddressofplaceusage() != null)
					&& !tradeLicenseNewDTO.getAddressofplaceusage().isEmpty()) {
				tradeLicenceNew.setAddress(tradeLicenseNewDTO.getAddressofplaceusage());
			} else {
				String Addressofplaceusage = "Addressofplaceusage field is Required";
				condition = false;
				message.append(Addressofplaceusage).append(",");
			}
			if (tradeLicenseNewDTO.getSpaceType() != null && !tradeLicenseNewDTO.getSpaceType().isEmpty()) {
				tradeLicenceNew.setSpaceType(tradeLicenseNewDTO.getSpaceType());

			} else {
				String space = "Space Tyope field is Required";
				condition = false;
				message.append(space).append(",");
			}
			
			String doc1 = tradeLicenseNewDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

			files[0] = doc1;
			if (tradeLicenseNewDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf() != null
					&& !tradeLicenseNewDTO
							.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf()
							.isEmpty()) {
				String doc2 = tradeLicenseNewDTO
						.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

				files[1] = doc2;
			} else {
				String doc2 = "NOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficer field is Required";
				condition = false;
				message.append(doc2).append(",");
			}

			

			if (tradeLicenseNewDTO.getNoDuesCertificateforPropertyTaxpdf() != null
					&& !tradeLicenseNewDTO.getNoDuesCertificateforPropertyTaxpdf().isEmpty()) {
				String doc4 = tradeLicenseNewDTO.getNoDuesCertificateforPropertyTaxpdf();
				files[2] = doc4;
			} else {
				String doc4 = "NoDuesCertificateforPropertyTax field is Required";
				condition = false;
				message.append(doc4).append(",");
			}

			String doc5 = tradeLicenseNewDTO.getBuildingAuthorizationDocumentpdf();
			files[3] = doc5;

			String savedFilePath = TradeLicenseNew.saveFile(files,
					request);

			
			
			tradeLicenceNew.setMiddleName(tradeLicenseNewDTO.getFatherName());
			tradeLicenceNew.setAadhaarNo(tradeLicenseNewDTO.getAadhaarNo());

			RTIApplication rtiApplication = new RTIApplication();
			if (tradeLicenseNewDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileNumber(String.valueOf(tradeLicenseNewDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (tradeLicenseNewDTO.getMobileNo() != 0) {
				rtiApplication.setPhoneNumber(String.valueOf(tradeLicenseNewDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}
			
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENCE-NEW");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus(CoreConstants.RTI_FINALSTATUS_NEW);
				rtiApplication.setRtiserviceid(5);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(tradeLicenceNew.getFullName());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicationCost(tradeLicenceNew.getFees());
				rtiApplication.setPhoneNumber(tradeLicenceNew.getMobileNo());
				rtiApplication.setMobileNumber(tradeLicenceNew.getMobileNo());
				rtiApplication.setEmail(tradeLicenceNew.getEmail());
              rtiApplication.setZone(String.valueOf(tradeLicenseNewDTO.getZoneNo()));
				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(tradeLicenceNew.getFullName());
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
					tradeLicenceNew.setRtiapplrefno(rti.getRtiApplnNumber());
					tradeLicenceNew.setRti_ref_id(savedRti.getRtiApplicationId());
					long zone_regis_id = tradeLicenceNewService.getReferenceId(tradeLicenceNew);
					rti.setRtiApplicationRefId(zone_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (zone_regis_id > 0)) {
						
						tradeLicenseNewDTO.setResponseStatus(
								"Requested data saved successfully");
						tradeLicenseNewDTO
								.setResult(retunRti.getRtiApplnNumber());
						tradeLicenseNewDTO.setResponseCode(HttpStatus.OK.value());
						response.setStatus(HttpStatus.OK.value());
						tradeLicenseNewDTO.setStatus("Data Saved Successfully");
						tradeLicenseNewDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
						tradeLicenseNewDTO.setNoDuesCertificateforPropertyTaxpdf("");
						tradeLicenseNewDTO.setBuildingAuthorizationDocumentpdf("");

					}
					String name = tradeLicenceNew.getFirstName() + tradeLicenceNew.getMiddleName()
							+ tradeLicenceNew.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenceNew.getMobileNo(), msg);
					SendEmail.sendEmail(tradeLicenceNew.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					tradeLicenseNewDTO.setResult(message.toString());
					tradeLicenseNewDTO.setResponseStatus(
							"Requested data not saved successfully");
					tradeLicenseNewDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					tradeLicenseNewDTO.setStatus("Internal Server Error");
					tradeLicenseNewDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
					tradeLicenseNewDTO.setNoDuesCertificateforPropertyTaxpdf("");
					tradeLicenseNewDTO.setBuildingAuthorizationDocumentpdf("");
				}
			}
		} catch (Exception ex) {
			tradeLicenseNewDTO.setResponseStatus(ex.getMessage());
			tradeLicenseNewDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicenseNewDTO.setStatus("Method not Allowed");
			tradeLicenseNewDTO.setnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf("");
			tradeLicenseNewDTO.setNoDuesCertificateforPropertyTaxpdf("");
			tradeLicenseNewDTO.setBuildingAuthorizationDocumentpdf("");
		}
		return tradeLicenseNewDTO;
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "tradeRenewal";
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