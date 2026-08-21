
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
import com.mars.rti.model.TradeLicenseNameChange;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseNameChangeService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenseNameChangeRestDTO;

	@Controller
	public class TradeLicenseNameChangeRestController {

			private static Log log = LogFactory.getLog(TradeLicenseNameChangeRestController.class);

			@Autowired
			private RTIApplicationService rtiApplicationService;

			@Autowired
			private TradeLicenseNameChangeService tradeLicenseNameChangeService;
	
			@RequestMapping(method = RequestMethod.POST, value = "/saveTradeNameChangeApplication")
			public @ResponseBody TradeLicenseNameChangeRestDTO saveTradeLicenseNameChange(@RequestBody TradeLicenseNameChangeRestDTO tradeLicenseNameChangeRestDTO,
					HttpServletRequest request, HttpServletResponse reponse) throws ServletException {
				boolean condition = true;
				StringBuilder message = new StringBuilder();
				String[] files = new String[4];

				UserRegistrationDetails user = new UserRegistrationDetails();

				if (log.isDebugEnabled()) {
					log.debug("Invoking saveTradeLicenseNameChange");
				}
				TradeLicenseNameChange tradeLicenseNameChange = new TradeLicenseNameChange();


				try {
					if (tradeLicenseNameChangeRestDTO.getTitle() != null
							&& !tradeLicenseNameChangeRestDTO.getTitle().isEmpty()) {
						tradeLicenseNameChange.setTitle(tradeLicenseNameChangeRestDTO.getTitle());
					} else {
						String Title = "Title field is Required";
						condition = false;
						message.append(Title).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getName() != null
							&& !tradeLicenseNameChangeRestDTO.getName().isEmpty()) {
						tradeLicenseNameChange.setFirstName(tradeLicenseNameChangeRestDTO.getName());			
						} else {
						String Name = "Name field is Required";
						condition = false;
						message.append(Name).append(",");
					}			

					tradeLicenseNameChange.setMiddleName(tradeLicenseNameChangeRestDTO.getFatherName());
					
					if (tradeLicenseNameChangeRestDTO.getSurname() != null
							&& !tradeLicenseNameChangeRestDTO.getSurname().isEmpty()) {
						tradeLicenseNameChange.setLastName(tradeLicenseNameChangeRestDTO.getSurname());			
						} else {
						String Surname = "Surname field is Required";
						condition = false;
						message.append(Surname).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getFullName() != null
							&& !tradeLicenseNameChangeRestDTO.getFullName().isEmpty()) {
						tradeLicenseNameChange.setFullName(tradeLicenseNameChangeRestDTO.getFullName());
					} else {
						String FullName = "Full Name field is Required";
						condition = false;
						message.append(FullName).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getPinCode() != 0) {
						tradeLicenseNameChange.setPinCode(tradeLicenseNameChangeRestDTO.getPinCode());
						} else {
						String PinCode = "Pin Code field is Required";
						condition = false;
						message.append(PinCode).append(",");
					}
					tradeLicenseNameChange.setAadhaarNo(tradeLicenseNameChangeRestDTO.getAadhaarNo());
					if (tradeLicenseNameChangeRestDTO.getEmailID() != null
							&& !tradeLicenseNameChangeRestDTO.getEmailID().isEmpty()) {
						tradeLicenseNameChange.setEmailID(tradeLicenseNameChangeRestDTO.getEmailID());
					} else {
						String Email = "Email Id field is Required";
						condition = false;
						message.append(Email).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getMobileNumber() != 0) {
						tradeLicenseNameChange.setMobileNumber(String.valueOf(tradeLicenseNameChangeRestDTO.getMobileNumber()));
						} else {
						String MobileNo = "Mobile No field is Required";
						condition = false;
						message.append(MobileNo).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getAdressForCorrespondence() != null
							&& !tradeLicenseNameChangeRestDTO.getAdressForCorrespondence().isEmpty()) {
						tradeLicenseNameChange.setAdressForCorrespondence(tradeLicenseNameChangeRestDTO.getAdressForCorrespondence());
						} else {
						String Address = "Address field is Required";
						condition = false;
						message.append(Address).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getZoneNo() != 0) {
						tradeLicenseNameChange.setZoneNo(String.valueOf(tradeLicenseNameChangeRestDTO.getZoneNo()));
						} else {
						String ZoneNo = "Zone No field is Required";
						condition = false;
						message.append(ZoneNo).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getWardNo() != null
							&& !tradeLicenseNameChangeRestDTO.getWardNo().isEmpty()) {
						tradeLicenseNameChange.setWardNo(tradeLicenseNameChangeRestDTO.getWardNo());
						} else {
						String WardNo = "Ward No field is Required";
						condition = false;
						message.append(WardNo).append(",");
					}
					tradeLicenseNameChange.setNameOfArea(tradeLicenseNameChangeRestDTO.getNameOfArea());
						
					if (tradeLicenseNameChangeRestDTO.getTradeLicenceNo() != null
							&& !tradeLicenseNameChangeRestDTO.getTradeLicenceNo().isEmpty()) {
						tradeLicenseNameChange.setTradeLicenceNo(tradeLicenseNameChangeRestDTO.getTradeLicenceNo());
						} else {
						String TradeLicenceNo = "Trade Licence No field is Required";
						condition = false;
						message.append(TradeLicenceNo).append(",");
					}
					
						tradeLicenseNameChange.setUpdateTradeName(tradeLicenseNameChangeRestDTO.getUpdateTradeName());
						
					if (tradeLicenseNameChangeRestDTO.getUpdatedTradeType() != null
							&& !tradeLicenseNameChangeRestDTO.getUpdatedTradeType().isEmpty()) {
						tradeLicenseNameChange.setUpdatedTradeType(tradeLicenseNameChangeRestDTO.getUpdatedTradeType());
						} else {
						String UpdatedTradeType = "Updated Trade Type field is Required";
						condition = false;
						message.append(UpdatedTradeType).append(",");
					}
										
					if (tradeLicenseNameChangeRestDTO.getUpdatedOwnerName() != null
							&& !tradeLicenseNameChangeRestDTO.getUpdatedOwnerName().isEmpty()) {
						tradeLicenseNameChange.setUpdatedOwnerName(tradeLicenseNameChangeRestDTO.getUpdatedOwnerName());
						} else {
						String UpdatedOwnerName = "Updated Owner Name field is Required";
						condition = false;
						message.append(UpdatedOwnerName).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getUpdatedPartnerCount() != null
							&& !tradeLicenseNameChangeRestDTO.getUpdatedPartnerCount().isEmpty()) {
						tradeLicenseNameChange.setUpdatedPartnerCount(tradeLicenseNameChangeRestDTO.getUpdatedPartnerCount());
						} else {
						String UpdatedPartnerCount = "Updated Partner Count field is Required";
						condition = false;
						message.append(UpdatedPartnerCount).append(",");
					}
					
					if (tradeLicenseNameChangeRestDTO.getFeesApplicable() != 0.0
							|| tradeLicenseNameChangeRestDTO.getFeesApplicable() != 0) {
						tradeLicenseNameChange.setFeesApplicable(tradeLicenseNameChangeRestDTO.getFeesApplicable());
					} else {
						String feesApplicable = "Fees Applicable field is Required";
						condition = false;
						message.append(feesApplicable).append(",");
					}
					
					RTIApplication rtiApplication = new RTIApplication();

					if (tradeLicenseNameChangeRestDTO.getUserMobileNumber() !=0) {
						rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseNameChangeRestDTO.getUserMobileNumber()));
						} else {
						String userMobilenumber = "User Mobile Number field is Required";
						condition = false;
						message.append(userMobilenumber).append(",");
					}
					if (tradeLicenseNameChangeRestDTO.getNocForRelatedDepartment() != null
							&& !tradeLicenseNameChangeRestDTO.getNocForRelatedDepartment()
									.isEmpty()) {
						String doc1 = tradeLicenseNameChangeRestDTO.getNocForRelatedDepartment();

						files[0] = doc1;
					} else {
						String doc1 = "Noc For Related Department field is Required";
						condition = false;
						message.append(doc1).append(",");
					}
					
					if (tradeLicenseNameChangeRestDTO.getCopyOfFormerLicence() != null
							&& !tradeLicenseNameChangeRestDTO.getCopyOfFormerLicence()
									.isEmpty()) {
						String doc2 = tradeLicenseNameChangeRestDTO.getCopyOfFormerLicence();

						files[1] = doc2;
					} else {
						String doc2 = "Copy Of Former Licence field is Required";
						condition = false;
						message.append(doc2).append(",");
					}
					String doc3 = tradeLicenseNameChangeRestDTO
							.getPropertyTaxNoDue();
					files[2] = doc3;

					if (tradeLicenseNameChangeRestDTO.getBuildingAuthorizationDocument() != null
							&& !tradeLicenseNameChangeRestDTO.getBuildingAuthorizationDocument()
									.isEmpty()) {
						String doc4 = tradeLicenseNameChangeRestDTO.getBuildingAuthorizationDocument();

						files[3] = doc4;
					} else {
						String doc4 = "Building Authorization Document field is Required";
						condition = false;
						message.append(doc4).append(",");
					}
					String savedFilePath = TradeLicenseNameChangeRestController
							.saveFile(files, request);


					
					
					
					if (condition) {
						 rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
						 rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplication.setSubject("TRADE-LICENSE-NAME-CHANGE");
						rtiApplication.setTemplateName("tradeLicenseNameChangeApplication");
						rtiApplication.setDepartment("MARKET-DEPARTMENT");
						rtiApplication.setWorkFlowStatus(0);
						rtiApplication.setFinalStatus("0");
						rtiApplication.setRtiserviceid(34);
						rtiApplication.setApplicantName(tradeLicenseNameChange.getFullName());
						rtiApplication.setPhoneNumber(tradeLicenseNameChange.getMobileNumber());
						rtiApplication.setMobileNumber(tradeLicenseNameChange.getMobileNumber());
						rtiApplication.setEmail(tradeLicenseNameChange.getEmailID());
						rtiApplication.setPdfUploadFromPortal(savedFilePath);
						rtiApplication.setZone(tradeLicenseNameChange.getZoneNo());

						rtiApplication.setApplicationCost(tradeLicenseNameChange.getFeesApplicable());

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
							tradeLicenseNameChange.setRtiApplRefNo(rti.getRtiApplnNumber());
							tradeLicenseNameChange.setRtiRefId(savedRti.getRtiApplicationId());
							long tradeLicenseNameChange_regis_id = tradeLicenseNameChangeService.tradeLicenseNameChange(tradeLicenseNameChange);
							rti.setRtiApplicationRefId(tradeLicenseNameChange_regis_id);
							RTIApplication retunRti = rtiApplicationService.merge(rti);

							if ((retunRti != null) && (tradeLicenseNameChange_regis_id > 0)) {
								tradeLicenseNameChangeRestDTO.setResponseStatus("Requested data saved successfully");
								tradeLicenseNameChangeRestDTO.setResult(retunRti.getRtiApplnNumber());
								tradeLicenseNameChangeRestDTO.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						tradeLicenseNameChangeRestDTO.setNocForRelatedDepartment("");
						tradeLicenseNameChangeRestDTO.setCopyOfFormerLicence("");
						tradeLicenseNameChangeRestDTO.setPropertyTaxNoDue("");
						tradeLicenseNameChangeRestDTO.setBuildingAuthorizationDocument("");
						tradeLicenseNameChangeRestDTO.setStatus("ok");}
							String name = tradeLicenseNameChange.getFirstName() + tradeLicenseNameChange.getMiddleName()
							+ tradeLicenseNameChange.getLastName();
					        String applnNo = rti.getRtiApplnNumber();

							
							String msg = "Dear " + name + " your application with Application No. " + applnNo
									+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
							msg.replace("var3", "");
							SendEmail.sendEmail(tradeLicenseNameChange.getEmailID(), "Application Submitted Successfully" + applnNo,
									msg);
							SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenseNameChange.getMobileNumber(), msg);
						}
					}
					if (!condition) {
						if (message.charAt(message.length() - 1) == ',') {
							message.deleteCharAt(message.length() - 1);
							tradeLicenseNameChangeRestDTO.setResult(message.toString());
							tradeLicenseNameChangeRestDTO.setResponseStatus("Requested data not saved successfully");
							tradeLicenseNameChangeRestDTO.setNocForRelatedDepartment("");
							tradeLicenseNameChangeRestDTO.setCopyOfFormerLicence("");
							tradeLicenseNameChangeRestDTO.setPropertyTaxNoDue("");
							tradeLicenseNameChangeRestDTO.setBuildingAuthorizationDocument("");
							tradeLicenseNameChangeRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
							reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
							tradeLicenseNameChangeRestDTO.setStatus("Internal Server Error");
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					log.equals(ex.getMessage());
					tradeLicenseNameChangeRestDTO.setResponseStatus(ex.getMessage());
					tradeLicenseNameChangeRestDTO.setNocForRelatedDepartment("");
					tradeLicenseNameChangeRestDTO.setCopyOfFormerLicence("");
					tradeLicenseNameChangeRestDTO.setPropertyTaxNoDue("");
					tradeLicenseNameChangeRestDTO.setBuildingAuthorizationDocument("");
					tradeLicenseNameChangeRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
					reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
					tradeLicenseNameChangeRestDTO.setStatus("Method not Allowed");}
				return tradeLicenseNameChangeRestDTO;
			}
			
			public static String saveFile(String data[], HttpServletRequest request) throws IOException {
				String filesPath = null;
				StringBuilder filesPathBuilder = new StringBuilder();
				String baseDir = CoreConstants.UPLOAD_PATH + "tradeLicenseNameChange";
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
		

	


