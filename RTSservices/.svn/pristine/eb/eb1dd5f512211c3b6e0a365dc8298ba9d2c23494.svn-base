package com.mars.rti.ws.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.NOCOfTrade;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.NOCOfTradeService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.NOCOfTradeRestDTO;

@Controller
public class NOCOfTradeRestController {

		private static Log log = LogFactory.getLog(NOCOfTradeRestController.class);

		@Autowired
		private RTIApplicationService rtiApplicationService;

		@Autowired
		private NOCOfTradeService nocTradeService;
		
		

		@RequestMapping(method = RequestMethod.POST, value = "/saveNOCOfTradeApplication")
		public @ResponseBody NOCOfTradeRestDTO saveNOCOfTrade(@RequestBody NOCOfTradeRestDTO nOCOfTradeRestDTO,
				HttpServletRequest request, HttpServletResponse reponse) throws ServletException {
			boolean condition = true;
			StringBuilder message = new StringBuilder();
			if (log.isDebugEnabled()) {
				log.debug("Invoking saveNOCOfTradeApplication");
			}
			NOCOfTrade nOCOfTrade = new NOCOfTrade();


			try {
				if (nOCOfTradeRestDTO.getTitle() != null
						&& !nOCOfTradeRestDTO.getTitle().isEmpty()) {
					nOCOfTrade.setTitle(nOCOfTradeRestDTO.getTitle());
				} else {
					String Title = "Title field is Required";
					condition = false;
					message.append(Title).append(",");
				}
				if (nOCOfTradeRestDTO.getFirstName() != null
						&& !nOCOfTradeRestDTO.getFirstName().isEmpty()) {
					nOCOfTrade.setFirstName(nOCOfTradeRestDTO.getFirstName());			
					} else {
					String FirstName = "FirstName field is Required";
					condition = false;
					message.append(FirstName).append(",");
				}			

				nOCOfTrade.setMiddleName(nOCOfTradeRestDTO.getMiddleName());
				
				if (nOCOfTradeRestDTO.getLastName() != null
						&& !nOCOfTradeRestDTO.getLastName().isEmpty()) {
					nOCOfTrade.setLastName(nOCOfTradeRestDTO.getLastName());			
					} else {
					String LastName = "LastName field is Required";
					condition = false;
					message.append(LastName).append(",");
				}
				if (nOCOfTradeRestDTO.getFullName() != null
						&& !nOCOfTradeRestDTO.getFullName().isEmpty()) {
					nOCOfTrade.setFullName(nOCOfTradeRestDTO.getFullName());
				} else {
					String FullName = "fullName field is Required";
					condition = false;
					message.append(FullName).append(",");
				}
				if (nOCOfTradeRestDTO.getPinCode() != 0) {
					nOCOfTrade.setPinCode(nOCOfTradeRestDTO.getPinCode());
					} else {
					String PinCode = "PinCode field is Required";
					condition = false;
					message.append(PinCode).append(",");
				}
				nOCOfTrade.setAadhaarNo(nOCOfTradeRestDTO.getAadhaarNo());
				if (nOCOfTradeRestDTO.getEmail() != null
						&& !nOCOfTradeRestDTO.getEmail().isEmpty()) {
					nOCOfTrade.setEmail(nOCOfTradeRestDTO.getEmail());
				} else {
					String Email = "Email field is Required";
					condition = false;
					message.append(Email).append(",");
				}
				if (nOCOfTradeRestDTO.getMobileNo() != 0) {
					nOCOfTrade.setMobileNo(String.valueOf(nOCOfTradeRestDTO.getMobileNo()));
					} else {
					String MobileNo = "MobileNo field is Required";
					condition = false;
					message.append(MobileNo).append(",");
				}
				if (nOCOfTradeRestDTO.getAddress() != null
						&& !nOCOfTradeRestDTO.getAddress().isEmpty()) {
					nOCOfTrade.setAddress(nOCOfTradeRestDTO.getAddress());
					} else {
					String Address = "Address field is Required";
					condition = false;
					message.append(Address).append(",");
				}
				if (nOCOfTradeRestDTO.getApplicationFor() != null
						&& !nOCOfTradeRestDTO.getApplicationFor().isEmpty()) {
					nOCOfTrade.setApplicationFor(nOCOfTradeRestDTO.getApplicationFor());
					} else {
					String ApplicationFor = "ApplicationFor field is Required";
					condition = false;
					message.append(ApplicationFor).append(",");
				}
				if (nOCOfTradeRestDTO.getBusinessName() != null
						&& !nOCOfTradeRestDTO.getBusinessName().isEmpty()) {
					nOCOfTrade.setBusinessName(nOCOfTradeRestDTO.getBusinessName());
					} else {
					String BusinessName = "BusinessName field is Required";
					condition = false;
					message.append(BusinessName).append(",");
				}
				if (nOCOfTradeRestDTO.getBusinessDetails() != null
						&& !nOCOfTradeRestDTO.getBusinessDetails().isEmpty()) {
					nOCOfTrade.setApplicationFor(nOCOfTradeRestDTO.getBusinessDetails());
					} else {
					String BusinessDetails = "BusinessDetails field is Required";
					condition = false;
					message.append(BusinessDetails).append(",");
				}
				if (nOCOfTradeRestDTO.getBusinessDate() != null
						&& !nOCOfTradeRestDTO.getBusinessDate().isEmpty()) {
					nOCOfTrade.setBusinessDate(nOCOfTradeRestDTO.getBusinessDate());
					} else {
					String BusinessDate = "BusinessDate field is Required";
					condition = false;
					message.append(BusinessDate).append(",");
				}
				if (nOCOfTradeRestDTO.getSpaceType() != null
						&& !nOCOfTradeRestDTO.getSpaceType().isEmpty()) {
					nOCOfTrade.setSpaceType(nOCOfTradeRestDTO.getSpaceType());
					} else {
					String SpaceType = "SpaceType field is Required";
					condition = false;
					message.append(SpaceType).append(",");
				}
				if (nOCOfTradeRestDTO.getLength() != 0) {
					nOCOfTrade.setLength(String.valueOf(nOCOfTradeRestDTO.getLength()));
					} else {
					String Length = "Length field is Required";
					condition = false;
					message.append(Length).append(",");
				}
				if (nOCOfTradeRestDTO.getHeight() != 0) {
					nOCOfTrade.setHeight(String.valueOf(nOCOfTradeRestDTO.getHeight()));
					} else {
					String Height = "Height field is Required";
					condition = false;
					message.append(Height).append(",");
				}
				if (nOCOfTradeRestDTO.getWidth() != 0) {
					nOCOfTrade.setWidth(String.valueOf(nOCOfTradeRestDTO.getWidth()));
					} else {
					String Width = "Width field is Required";
					condition = false;
					message.append(Width).append(",");
				}
				if (nOCOfTradeRestDTO.getZoneNo() != 0) {
					nOCOfTrade.setZoneNo(String.valueOf(nOCOfTradeRestDTO.getZoneNo()));
					} else {
					String ZoneNo = "ZoneNo field is Required";
					condition = false;
					message.append(ZoneNo).append(",");
				}
				if (nOCOfTradeRestDTO.getWardNo() != null
						&& !nOCOfTradeRestDTO.getWardNo().isEmpty()) {
					nOCOfTrade.setWardNo(nOCOfTradeRestDTO.getWardNo());
					} else {
					String WardNo = "WardNo field is Required";
					condition = false;
					message.append(WardNo).append(",");
				}
				if (nOCOfTradeRestDTO.getAreaName() != null
						&& !nOCOfTradeRestDTO.getAreaName().isEmpty()) {
					nOCOfTrade.setAreaName(nOCOfTradeRestDTO.getAreaName());
					} else {
					String AreaName = "AreaName field is Required";
					condition = false;
					message.append(AreaName).append(",");
				}
				if (nOCOfTradeRestDTO.getLicenceNo() != null
						&& !nOCOfTradeRestDTO.getLicenceNo().isEmpty()) {
					nOCOfTrade.setLicenceNo(nOCOfTradeRestDTO.getLicenceNo());
					} else {
					String LicenceNo = "LicenceNo field is Required";
					condition = false;
					message.append(LicenceNo).append(",");
				}
				if (nOCOfTradeRestDTO.getFullAddress() != null
						&& !nOCOfTradeRestDTO.getFullAddress().isEmpty()) {
					nOCOfTrade.setFullAddress(nOCOfTradeRestDTO.getFullAddress());
					} else {
					String FullAddress = "FullAddress field is Required";
					condition = false;
					message.append(FullAddress).append(",");
				}
				if (nOCOfTradeRestDTO.getFormerLicence() != null
						&& !nOCOfTradeRestDTO.getFormerLicence().isEmpty()) {
					nOCOfTrade.setFormerLicence(nOCOfTradeRestDTO.getFormerLicence());
					} else {
					String FormerLicence = "FormerLicence field is Required";
					condition = false;
					message.append(FormerLicence).append(",");
				}
				if (nOCOfTradeRestDTO.getCalnumber() != null
						&& !nOCOfTradeRestDTO.getCalnumber().isEmpty()) {
					nOCOfTrade.setCalnumber(nOCOfTradeRestDTO.getCalnumber());
					} else {
					String Calnumber = "Calnumber field is Required";
					condition = false;
					message.append(Calnumber).append(",");
				}
				if (nOCOfTradeRestDTO.getFeesApplicable() != 0.0) {
					nOCOfTrade.setFeesApplicable(nOCOfTradeRestDTO.getFeesApplicable());
					} else {
					String FeesApplicable = "FeesApplicable field is Required";
					condition = false;
					message.append(FeesApplicable).append(",");
				}
				
				
				if (condition) {
					RTIApplication rtiApplication = new RTIApplication();
					 rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					 rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("NOC-OF-TRADE-CERTIFICATE");
					rtiApplication.setTemplateName("NOCOfTradeApplication");
					rtiApplication.setDepartment("MARKET-DEPARTMENT");
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(32);
					rtiApplication.setApplicantName(nOCOfTrade.getFullName());
					rtiApplication.setPhoneNumber(nOCOfTrade.getMobileNo());
					rtiApplication.setMobileNumber(nOCOfTrade.getMobileNo());
					rtiApplication.setEmail(nOCOfTrade.getEmail());
					rtiApplication.setPdfUploadFromPortal(nOCOfTrade.getFilesPath());
					rtiApplication.setZone(nOCOfTrade.getZoneNo());

					rtiApplication.setApplicationCost(nOCOfTrade.getFeesApplicable());

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
						long noctrade_regis_id = nocTradeService.nocTrade(nOCOfTrade);
						rti.setRtiApplicationRefId(noctrade_regis_id);
						RTIApplication retunRti = rtiApplicationService.merge(rti);

						if ((retunRti != null) && (noctrade_regis_id > 0)) {
							nOCOfTradeRestDTO.setResponseStatus("Requested data saved successfully");
							nOCOfTradeRestDTO.setResult(retunRti.getRtiApplnNumber());
							nOCOfTradeRestDTO.setResponseCode(200);
							nOCOfTradeRestDTO.setStatus("ok");
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
						nOCOfTradeRestDTO.setResult(message.toString());
						nOCOfTradeRestDTO.setResponseStatus("Requested data not saved successfully");
						nOCOfTradeRestDTO.setResponseCode(500);
						nOCOfTradeRestDTO.setStatus("Internal Server Error");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				log.equals(ex.getMessage());
				nOCOfTradeRestDTO.setResponseStatus("Data fields are Empty");
				nOCOfTradeRestDTO.setResponseCode(405);
				nOCOfTradeRestDTO.setStatus("Method not Allowed");
			}
			return nOCOfTradeRestDTO;
		}
					
	

}
