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
import com.mars.rti.model.NOCOfTrade;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.NOCOfTradeService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.NOCOfTradeCertificateRestDTO;


@Controller
public class NOCOfTradeCertificateRestController {
	private static Log log = LogFactory.getLog(NOCOfTradeCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private NOCOfTradeService nocTradeService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveNOCOfTradeCertificate")
	public @ResponseBody NOCOfTradeCertificateRestDTO saveNOCOfTradeCertificate(
			@RequestBody NOCOfTradeCertificateRestDTO noc, HttpServletRequest request, HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[3];

		UserRegistrationDetails user = new UserRegistrationDetails();
		
		if (log.isDebugEnabled())
			log.debug("Invoking saveNOCOfTradeCertificate");

		NOCOfTrade nOCOfTrade = new NOCOfTrade();
		try {
			if (noc.getTitle() != null
					&& !noc.getTitle().isEmpty()) {
				nOCOfTrade.setTitle(noc.getTitle());
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			if (noc.getName() != null
					&& !noc.getName().isEmpty()) {
				nOCOfTrade.setFirstName(noc.getName());			
				} else {
				String Name = "Name field is Required";
				condition = false;
				message.append(Name).append(",");
			}		
			nOCOfTrade.setMiddleName(noc.getFatherName());
			if (noc.getSurname() != null
					&& !noc.getSurname().isEmpty()) {
				nOCOfTrade.setLastName(noc.getSurname());			
				} else {
				String Surname = "Surname field is Required";
				condition = false;
				message.append(Surname).append(",");
			}	
			if (noc.getFullName() != null
					&& !noc.getFullName().isEmpty()) {
				nOCOfTrade.setFullName(noc.getFullName());
			} else {
				String FullName = "Full Name field is Required";
				condition = false;
				message.append(FullName).append(",");
			}
			if (noc.getPinCode() != 0) {
				nOCOfTrade.setPinCode(noc.getPinCode());
				} else {
				String PinCode = "Pin Code field is Required";
				condition = false;
				message.append(PinCode).append(",");
			}
			
			nOCOfTrade.setAadhaarNo(noc.getAadhaarNo());
			
			if (noc.getEmail() != null
					&& !noc.getEmail().isEmpty()) {
				nOCOfTrade.setEmail(noc.getEmail());
			} else {
				String Email = "Email Id field is Required";
				condition = false;
				message.append(Email).append(",");
			}
			if (noc.getMobileNo() != 0) {
				nOCOfTrade.setMobileNo(String.valueOf(noc.getMobileNo()));
				} else {
				String MobileNo = "Mobile No field is Required";
				condition = false;
				message.append(MobileNo).append(",");
			}
			if (noc.getAddress() != null
					&& !noc.getAddress().isEmpty()) {
				nOCOfTrade.setAddress(noc.getAddress());
				} else {
				String Address = "Address For Correspondence field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			if (noc.getBusinessName() != null
					&& !noc.getBusinessName().isEmpty()) {
				nOCOfTrade.setBusinessName(noc.getBusinessName());
				} else {
				String BusinessName = "Business Name field is Required";
				condition = false;
				message.append(BusinessName).append(",");
			}
			if (noc.getBusinessDetails() != null
					&& !noc.getBusinessDetails().isEmpty()) {
				nOCOfTrade.setBusinessDetails(noc.getBusinessDetails());
				} else {
				String BusinessDetails = "Business Details field is Required";
				condition = false;
				message.append(BusinessDetails).append(",");
			}
			if (noc.getBusinessDate() != null
					&& !noc.getBusinessDate().isEmpty()) {
				nOCOfTrade.setBusinessDate(noc.getBusinessDate());
				} else {
				String BusinessDate = "Business Date field is Required";
				condition = false;
				message.append(BusinessDate).append(",");
			}
			if (noc.getSpaceType() != null
					&& !noc.getSpaceType().isEmpty()) {
				nOCOfTrade.setSpaceType(noc.getSpaceType());
				} else {
				String SpaceType = "Space Type field is Required";
				condition = false;
				message.append(SpaceType).append(",");
			}
			if (noc.getLength() != null
					&& !noc.getLength().isEmpty()) {
				nOCOfTrade.setLength(noc.getLength());
				} else {
				String Length = "Length field is Required";
				condition = false;
				message.append(Length).append(",");
			}
			if (noc.getHeight() != null
					&& !noc.getHeight().isEmpty()) {
				nOCOfTrade.setHeight(noc.getHeight());
				} else {
				String Height = "Height field is Required";
				condition = false;
				message.append(Height).append(",");
			}
			if (noc.getWidth() != null
					&& !noc.getWidth().isEmpty()) {
				nOCOfTrade.setWidth(noc.getWidth());
				} else {
				String Width = "Width field is Required";
				condition = false;
				message.append(Width).append(",");
			}
			if (noc.getZoneNo() != 0) {
				nOCOfTrade.setZoneNo(String.valueOf(noc.getZoneNo()));
				} else {
				String ZoneNo = "Zone No field is Required";
				condition = false;
				message.append(ZoneNo).append(",");
			}
			if (noc.getWardNo() != null
					&& !noc.getWardNo().isEmpty()) {
				nOCOfTrade.setWardNo(noc.getWardNo());
				} else {
				String WardNo = "Ward No field is Required";
				condition = false;
				message.append(WardNo).append(",");
			}
			if (noc.getAreaName() != null
					&& !noc.getAreaName().isEmpty()) {
				nOCOfTrade.setAreaName(noc.getAreaName());
				} else {
				String AreaName = "Area Name field is Required";
				condition = false;
				message.append(AreaName).append(",");
			}
			if (noc.getBusinessAddress() != null
					&& !noc.getBusinessAddress().isEmpty()) {
				nOCOfTrade.setFullAddress(noc.getBusinessAddress());
				} else {
				String BusinessAddress = "Business Address field is Required";
				condition = false;
				message.append(BusinessAddress).append(",");
			}
			if (noc.getNumberOfCertificateCopy() != null
					&& !noc.getNumberOfCertificateCopy().isEmpty()) {
				nOCOfTrade.setCalnumber(noc.getNumberOfCertificateCopy());
				} else {
				String NumberOfCertificateCopy = "Number Of Certificate Copies field is Required";
				condition = false;
				message.append(NumberOfCertificateCopy).append(",");
			}
			
			if (noc.getFeesApplicable() != 0.0
					|| noc.getFeesApplicable() != 0) {
				nOCOfTrade.setFeesApplicable(noc.getFeesApplicable());
			} else {
				String feesApplicable = "Fees Applicable field is Required";
				condition = false;
				message.append(feesApplicable).append(",");
			}
			RTIApplication rtiApplication = new RTIApplication();

			if (noc.getUserMobileNumber() !=0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(noc.getUserMobileNumber()));
				} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (noc.getNocDoc() != null
					&& !noc.getNocDoc()
							.isEmpty()) {
				String doc1 = noc.getNocDoc();

				files[0] = doc1;
			} else {
				String doc1 = "Noc For Related Department field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			if (noc.getNodueCertificate() != null
					&& !noc.getNodueCertificate()
							.isEmpty()) {
				String doc2 = noc.getNodueCertificate();

				files[1] = doc2;
			} else {
				String doc1 = "No Dues Certificate field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			String doc3 = noc
					.getBuildingAuthorizationDoc();
			files[2] = doc3;
			
			String savedFilePath = NOCOfTradeCertificateRestController
					.saveFile(files, request);

			
			
			if (condition) {
				 rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				 rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("NOC-OF-TRADE-CERTIFICATE");
				rtiApplication.setTemplateName("nocOfTrade");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(32);
				rtiApplication.setApplicantName(noc.getFullName());
				rtiApplication.setPhoneNumber(String.valueOf(noc.getMobileNo()));
				rtiApplication.setMobileNumber(String.valueOf(noc.getMobileNo()));
				rtiApplication.setEmail(noc.getEmail());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setZone(String.valueOf(noc.getZoneNo()));

				rtiApplication.setApplicationCost(noc.getFeesApplicable());

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
					nOCOfTrade.setRtiapplrefno(rti.getRtiApplnNumber());
					nOCOfTrade.setRti_ref_id(savedRti.getRtiApplicationId());
					long nOCOfTrade_regis_id = nocTradeService.nocTrade(nOCOfTrade);
					rti.setRtiApplicationRefId(nOCOfTrade_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (nOCOfTrade_regis_id > 0)) {
						noc.setResponseStatus("Requested data saved successfully");
						noc.setResult(retunRti.getRtiApplnNumber());
						noc.setResponseCode(HttpStatus.OK.value());
				reponse.setStatus(HttpStatus.OK.value());
				noc.setNocDoc("");
				noc.setNodueCertificate("");
				noc.setBuildingAuthorizationDoc("");
				noc.setStatus("ok");
				
					}
					String name = nOCOfTrade.getFirstName() + nOCOfTrade.getMiddleName()
					+ nOCOfTrade.getLastName();
			        String applnNo = rti.getRtiApplnNumber();

					
					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(nOCOfTrade.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", nOCOfTrade.getMobileNo(), msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					noc.setResult(message.toString());
					noc.setResponseStatus("Requested data not saved successfully");
					noc.setNocDoc("");
					noc.setNodueCertificate("");
					noc.setBuildingAuthorizationDoc("");
					noc.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					noc.setStatus("Internal Server Error");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			noc.setNocDoc("");
			noc.setNodueCertificate("");
			noc.setBuildingAuthorizationDoc("");
			noc.setResponseStatus(ex.getMessage());
			noc.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			noc.setStatus("Method not Allowed");
		}
		return noc;
	}
	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "nocOfTrade";
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