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
import com.mars.rti.model.TradeLicenceRenewal;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenceRenewalService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenceRenewalRestDTO;

@Controller
public class TradeLicenseRenewalCertificateRestController {
	private static Log log = LogFactory.getLog(TradeLicenseRenewalCertificateRestController.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TradeLicenceRenewalService tradeLicenceRenewalService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveTradeRenewal")
	public @ResponseBody TradeLicenceRenewalRestDTO saveTradeRenewal(
			@RequestBody TradeLicenceRenewalRestDTO tradeLicenceRenewalRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveTradeRenewal");
		}
		TradeLicenceRenewal tradeLicenceRenewal = new TradeLicenceRenewal();
		try {

			if ((tradeLicenceRenewalRestDTO.getName() != null) && !tradeLicenceRenewalRestDTO.getName().isEmpty()) {
				tradeLicenceRenewal.setFirstName(tradeLicenceRenewalRestDTO.getName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getTitle() != null) && !tradeLicenceRenewalRestDTO.getTitle().isEmpty()) {
				tradeLicenceRenewal.setTitle(tradeLicenceRenewal.getTitle());
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getSurName() != null)
					&& !tradeLicenceRenewalRestDTO.getSurName().isEmpty()) {
				tradeLicenceRenewal.setLastName(tradeLicenceRenewalRestDTO.getSurName());
			} else {
				String LastName = "LastName field is Required";
				condition = false;
				message.append(LastName).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getFullName() != null)
					&& !tradeLicenceRenewalRestDTO.getFullName().isEmpty()) {
				tradeLicenceRenewal.setFullName(tradeLicenceRenewalRestDTO.getFullName());
			} else {
				String FullName = "FullName field is Required";
				condition = false;
				message.append(FullName).append(",");
			}

			if (tradeLicenceRenewalRestDTO.getPinCode() != 0) {
				tradeLicenceRenewal.setPinCode(tradeLicenceRenewalRestDTO.getPinCode());
			} else {
				String ApplicantPinCode = "PinCode. field is Required";
				condition = false;
				message.append(ApplicantPinCode).append(",");

			}

			if (tradeLicenceRenewalRestDTO.getMobileNo() != 0) {

				tradeLicenceRenewal.setMobileNo(String.valueOf(tradeLicenceRenewalRestDTO.getMobileNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}

			if ((tradeLicenceRenewalRestDTO.getAddress() != null)
					&& !tradeLicenceRenewalRestDTO.getAddress().isEmpty()) {
				tradeLicenceRenewal.setAddress(tradeLicenceRenewal.getAddress());
			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getNameOfBusiness() != null)
					&& !tradeLicenceRenewalRestDTO.getNameOfBusiness().isEmpty()) {
				tradeLicenceRenewal.setNameOfBusiness(tradeLicenceRenewal.getNameOfBusiness());
			} else {
				String NameOfBusiness = "NameOfBusiness field is Required";
				condition = false;
				message.append(NameOfBusiness).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getBusinessDetails() != null)
					&& !tradeLicenceRenewalRestDTO.getBusinessDetails().isEmpty()) {
				tradeLicenceRenewal.setBusinessDetails(tradeLicenceRenewal.getBusinessDetails());
			} else {
				String BusinessDetails = "BusinessDetails field is Required";
				condition = false;
				message.append(BusinessDetails).append(",");
			}
			if ((tradeLicenceRenewalRestDTO.getBusinesDoneDate() != null)
					&& !tradeLicenceRenewalRestDTO.getBusinesDoneDate().isEmpty()) {
				tradeLicenceRenewal.setBusinesDoneDate(tradeLicenceRenewal.getBusinesDoneDate());
			} else {
				String BusinesDoneDate = "BusinesDoneDate field is Required";
				condition = false;
				message.append(BusinesDoneDate).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getBusinessUsagePlace() != null)
					&& !tradeLicenceRenewalRestDTO.getBusinessUsagePlace().isEmpty()) {
				tradeLicenceRenewal.setBusinessUsagePlace(tradeLicenceRenewal.getBusinessUsagePlace());
			} else {
				String BusinessUsagePlace = "BusinessUsagePlace field is Required";
				condition = false;
				message.append(BusinessUsagePlace).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getAreaName() != null)
					&& !tradeLicenceRenewalRestDTO.getAreaName().isEmpty()) {
				tradeLicenceRenewal.setAreaName(tradeLicenceRenewal.getAreaName());
			} else {
				String AreaName = "AreaName field is Required";
				condition = false;
				message.append(AreaName).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getEmail() != null) && !tradeLicenceRenewalRestDTO.getEmail().isEmpty()) {
				tradeLicenceRenewal.setEmail(tradeLicenceRenewal.getEmail());
			} else {
				String Email = "Email field is Required";
				condition = false;
				message.append(Email).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getHeight() != null) && !tradeLicenceRenewalRestDTO.getHeight().isEmpty()) {
				tradeLicenceRenewal.setHeight(tradeLicenceRenewal.getHeight());
			} else {
				String Height = "Height field is Required";
				condition = false;
				message.append(Height).append(",");
			}
			if ((tradeLicenceRenewalRestDTO.getLength() != null) && !tradeLicenceRenewalRestDTO.getLength().isEmpty()) {
				tradeLicenceRenewal.setLength(tradeLicenceRenewal.getLength());
			} else {
				String Length = "Length field is Required";
				condition = false;
				message.append(Length).append(",");
			}
			if ((tradeLicenceRenewalRestDTO.getWidth() != null) && !tradeLicenceRenewalRestDTO.getWidth().isEmpty()) {
				tradeLicenceRenewal.setWidth(tradeLicenceRenewal.getWidth());
			} else {
				String Width = "Width field is Required";
				condition = false;
				message.append(Width).append(",");
			}

			if (tradeLicenceRenewalRestDTO.getZoneNo() != 0) {
				tradeLicenceRenewal.setZoneNo(String.valueOf(tradeLicenceRenewalRestDTO.getZoneNo()));
			} else {
				String zone = "ZonNo. field is Required";
				condition = false;
				message.append(zone).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getTradeLicenseNo() != null)
					&& !tradeLicenceRenewalRestDTO.getTradeLicenseNo().isEmpty()) {
				tradeLicenceRenewal.setTradeLicenseNo(tradeLicenceRenewalRestDTO.getTradeLicenseNo());
			} else {
				String TradeLicenseNo = "TradeLicenseNo field is Required";
				condition = false;
				message.append(TradeLicenseNo).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getUpdatedtradetype() != null)
					&& !tradeLicenceRenewalRestDTO.getUpdatedtradetype().isEmpty()) {
				tradeLicenceRenewal.setUpdatedTradeType(tradeLicenceRenewalRestDTO.getUpdatedtradetype());
			} else {
				String Updatedtradetype = "Updatedtradetype field is Required";
				condition = false;
				message.append(Updatedtradetype).append(",");
			}
			if (tradeLicenceRenewalRestDTO.getMobileNo() != 0) {
				tradeLicenceRenewal.setMobileNo(String.valueOf(tradeLicenceRenewalRestDTO.getMobileNo()));
			} else {
				String mobile = "Mobile Number field is Required";
				condition = false;
				message.append(mobile).append(",");
			}

			if ((tradeLicenceRenewalRestDTO.getAddressofplaceusage() != null)
					&& !tradeLicenceRenewalRestDTO.getAddressofplaceusage().isEmpty()) {
				tradeLicenceRenewal.setAddress(tradeLicenceRenewalRestDTO.getAddressofplaceusage());
			} else {
				String Addressofplaceusage = "Addressofplaceusage field is Required";
				condition = false;
				message.append(Addressofplaceusage).append(",");
			}
			if (tradeLicenceRenewalRestDTO.getSpaceType() != null && !tradeLicenceRenewalRestDTO.getSpaceType().isEmpty()) {
				tradeLicenceRenewal.setSpaceType(tradeLicenceRenewalRestDTO.getSpaceType());

			} else {
				String space = "Space Tyope field is Required";
				condition = false;
				message.append(space).append(",");
			}

			String doc1 = tradeLicenceRenewalRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

			files[0] = doc1;
			if (tradeLicenceRenewalRestDTO
					.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf() != null
					&& !tradeLicenceRenewalRestDTO
							.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf()
							.isEmpty()) {
				String doc2 = tradeLicenceRenewalRestDTO
						.getnOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficerpdf();

				files[1] = doc2;
			} else {
				String doc2 = "NOCfortherelateddepartmentissuedfromtheNMCDepartmentOfficerGovtSemiGovtOfficer field is Required";
				condition = false;
				message.append(doc2).append(",");
			}

			if (tradeLicenceRenewalRestDTO.getCopyoftheFormerLicencepdf() != null
					&& !tradeLicenceRenewalRestDTO.getCopyoftheFormerLicencepdf().isEmpty()) {
				String doc3 = tradeLicenceRenewalRestDTO.getCopyoftheFormerLicencepdf();

				files[2] = doc3;
			} else {
				String doc3 = "CopyoftheFormerLicencefield is Required";
				condition = false;
				message.append(doc3).append(",");
			}

			if (tradeLicenceRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf() != null
					&& !tradeLicenceRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf().isEmpty()) {
				String doc4 = tradeLicenceRenewalRestDTO.getNoDuesCertificateforPropertyTaxpdf();
				files[3] = doc4;
			} else {
				String doc4 = "NoDuesCertificateforPropertyTax field is Required";
				condition = false;
				message.append(doc4).append(",");
			}

			String doc5 = tradeLicenceRenewalRestDTO.getBuildingAuthorizationDocumentpdf();
			files[4] = doc5;

			String savedFilePath = TradeLicenseRenewalCertificateRestController.saveFile(files,
					request);

			
			
			tradeLicenceRenewal.setMiddleName(tradeLicenceRenewalRestDTO.getFatherName());
			tradeLicenceRenewal.setAadhaarNo(tradeLicenceRenewalRestDTO.getAadhaarNo());

			RTIApplication rtiApplication = new RTIApplication();
			if (tradeLicenceRenewalRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileNumber(String.valueOf(tradeLicenceRenewalRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (tradeLicenceRenewalRestDTO.getMobileNo() != 0) {
				rtiApplication.setPhoneNumber(String.valueOf(tradeLicenceRenewalRestDTO.getMobileNo()));
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
				rtiApplication.setApplicantName(tradeLicenceRenewal.getFullName());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicationCost(tradeLicenceRenewal.getFees());
				rtiApplication.setPhoneNumber(tradeLicenceRenewal.getMobileNo());
				rtiApplication.setMobileNumber(tradeLicenceRenewal.getMobileNo());
				rtiApplication.setEmail(tradeLicenceRenewal.getEmail());
              rtiApplication.setZone(String.valueOf(tradeLicenceRenewalRestDTO.getZoneNo()));
				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(tradeLicenceRenewal.getFullName());
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
					tradeLicenceRenewal.setRtiapplrefno(rti.getRtiApplnNumber());
					tradeLicenceRenewal.setRti_ref_id(savedRti.getRtiApplicationId());
					long zone_regis_id = tradeLicenceRenewalService.getReferenceId(tradeLicenceRenewal);
					rti.setRtiApplicationRefId(zone_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (zone_regis_id > 0)) {
						tradeLicenceRenewalRestDTO.setResponseStatus("Requested data saved successfully");
						tradeLicenceRenewalRestDTO.setResult(retunRti.getRtiApplnNumber());// RTS/TPD/2023/2145
						tradeLicenceRenewalRestDTO.setResponseCode(HttpStatus.OK.value());
						response.setStatus(HttpStatus.OK.value());
						tradeLicenceRenewalRestDTO.setStatus("ok");

					}
					String name = tradeLicenceRenewal.getFirstName() + tradeLicenceRenewal.getMiddleName()
							+ tradeLicenceRenewal.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenceRenewal.getMobileNo(), msg);
					SendEmail.sendEmail(tradeLicenceRenewal.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					tradeLicenceRenewalRestDTO.setResult(message.toString());
					tradeLicenceRenewalRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					tradeLicenceRenewalRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					tradeLicenceRenewalRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			tradeLicenceRenewalRestDTO.setResponseStatus(ex.getMessage());
			tradeLicenceRenewalRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			tradeLicenceRenewalRestDTO.setStatus("Method not Allowed");
		}
		return tradeLicenceRenewalRestDTO;
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
