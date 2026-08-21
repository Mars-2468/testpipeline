package com.mars.rti.ws.controller;

	import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

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
import com.mars.rti.model.TradeLicencePartnerChange;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicencePartnerChangeService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TradeLicenseOwnerPartnerChangeRestDTO;

	@Controller
	public class TradeLicenseOwnerPartnerChangeRestController{
			private static Log log = LogFactory.getLog(TradeLicenseOwnerPartnerChangeRestController.class);

			@Autowired
			private RTIApplicationService rtiApplicationService;

			@Autowired
			private TradeLicencePartnerChangeService tradeLicencePartnerChangeService;
			
			@RequestMapping(method = RequestMethod.POST, value = "/saveTradeOwnerPartnerChangeApplication")
			public @ResponseBody TradeLicenseOwnerPartnerChangeRestDTO saveTradeOwnerPartnerChangeApplication(@RequestBody TradeLicenseOwnerPartnerChangeRestDTO tradeLicenseOwnerPartnerChangeRestDTO,
					HttpServletRequest request, HttpServletResponse reponse) throws ServletException {
				boolean condition = true;
				StringBuilder message = new StringBuilder();
				String[] files = new String[5];

				UserRegistrationDetails user = new UserRegistrationDetails();

				if (log.isDebugEnabled()) {
					log.debug("Invoking saveTradeLicenseOwnerPartnerChange");
				}
				TradeLicencePartnerChange tradeLicencePartnerChange = new TradeLicencePartnerChange();


				try {
					if (tradeLicenseOwnerPartnerChangeRestDTO.getTitle() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getTitle().isEmpty()) {
						tradeLicencePartnerChange.setTitle(tradeLicenseOwnerPartnerChangeRestDTO.getTitle());
					} else {
						String Title = "Title field is Required";
						condition = false;
						message.append(Title).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getName() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getName().isEmpty()) {
						tradeLicencePartnerChange.setFirstName(tradeLicenseOwnerPartnerChangeRestDTO.getName());			
						} else {
						String FirstName = "Name field is Required";
						condition = false;
						message.append(FirstName).append(",");
					}			

					tradeLicencePartnerChange.setMiddleName(tradeLicenseOwnerPartnerChangeRestDTO.getFatherName());
					
					if (tradeLicenseOwnerPartnerChangeRestDTO.getSurname() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getSurname().isEmpty()) {
						tradeLicencePartnerChange.setLastName(tradeLicenseOwnerPartnerChangeRestDTO.getSurname());			
						} else {
						String LastName = "Surname field is Required";
						condition = false;
						message.append(LastName).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getFullName() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getFullName().isEmpty()) {
						tradeLicencePartnerChange.setFullName(tradeLicenseOwnerPartnerChangeRestDTO.getFullName());
					} else {
						String FullName = "Full Name field is Required";
						condition = false;
						message.append(FullName).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getPinCode() != 0) {
						tradeLicencePartnerChange.setPinCode(tradeLicenseOwnerPartnerChangeRestDTO.getPinCode());
						} else {
						String PinCode = "Pin Code field is Required";
						condition = false;
						message.append(PinCode).append(",");
					}
					tradeLicencePartnerChange.setAadhaarNo(String.valueOf(tradeLicenseOwnerPartnerChangeRestDTO.getAadhaarNo()));
					if (tradeLicenseOwnerPartnerChangeRestDTO.getEmailID() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getEmailID().isEmpty()) {
						tradeLicencePartnerChange.setEmail(tradeLicenseOwnerPartnerChangeRestDTO.getEmailID());
					} else {
						String Email = "Email Id field is Required";
						condition = false;
						message.append(Email).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getMobileNumber() != 0) {
						tradeLicencePartnerChange.setMobileNo(String.valueOf(tradeLicenseOwnerPartnerChangeRestDTO.getMobileNumber()));
						} else {
						String MobileNo = "Mobile No field is Required";
						condition = false;
						message.append(MobileNo).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getAdressForCorrespondence() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getAdressForCorrespondence().isEmpty()) {
						tradeLicencePartnerChange.setAddress(tradeLicenseOwnerPartnerChangeRestDTO.getAdressForCorrespondence());
						} else {
						String Address = "Address field is Required";
						condition = false;
						message.append(Address).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getZoneNo() != 0) {
						tradeLicencePartnerChange.setZoneNo(String.valueOf(tradeLicenseOwnerPartnerChangeRestDTO.getZoneNo()));
						} else {
						String ZoneNo = "Zone No field is Required";
						condition = false;
						message.append(ZoneNo).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getWardNo() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getWardNo().isEmpty()) {
						tradeLicencePartnerChange.setWardNo(tradeLicenseOwnerPartnerChangeRestDTO.getWardNo());
						} else {
						String WardNo = "Ward No field is Required";
						condition = false;
						message.append(WardNo).append(",");
					}
					tradeLicencePartnerChange.setAreaName(tradeLicenseOwnerPartnerChangeRestDTO.getNameOfArea());
						
					if (tradeLicenseOwnerPartnerChangeRestDTO.getTradeLicenceNo() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getTradeLicenceNo().isEmpty()) {
						tradeLicencePartnerChange.setTradeLicenseNo(tradeLicenseOwnerPartnerChangeRestDTO.getTradeLicenceNo());
						} else {
						String TradeLicenceNo = "Trade Licence No field is Required";
						condition = false;
						message.append(TradeLicenceNo).append(",");
					}
					
						tradeLicencePartnerChange.setUpdatedTradeName(tradeLicenseOwnerPartnerChangeRestDTO.getUpdateTradeName());
						
					if (tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedTradeType() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedTradeType().isEmpty()) {
						tradeLicencePartnerChange.setUpdatedTradeType(tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedTradeType());
						} else {
						String UpdatedTradeType = "Updated Trade Type field is Required";
						condition = false;
						message.append(UpdatedTradeType).append(",");
					}
										
					if (tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedOwnerName() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedOwnerName().isEmpty()) {
						tradeLicencePartnerChange.setUpdatedOwnerName(tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedOwnerName());
						} else {
						String UpdatedOwnerName = "Updated Owner Name field is Required";
						condition = false;
						message.append(UpdatedOwnerName).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedPartnerCount() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedPartnerCount().isEmpty()) {
						tradeLicencePartnerChange.setUpdatedPartnerCount(tradeLicenseOwnerPartnerChangeRestDTO.getUpdatedPartnerCount());
						} else {
						String UpdatedPartnerCount = "Updated Partner Count field is Required";
						condition = false;
						message.append(UpdatedPartnerCount).append(",");
					}
					
					if (tradeLicenseOwnerPartnerChangeRestDTO.getFeesApplicable() != 0.0
							|| tradeLicenseOwnerPartnerChangeRestDTO.getFeesApplicable() != 0) {
						tradeLicencePartnerChange.setApplicableFee(String.valueOf(tradeLicenseOwnerPartnerChangeRestDTO.getFeesApplicable()));
					} else {
						String feesApplicable = "Fees Applicable field is Required";
						condition = false;
						message.append(feesApplicable).append(",");
					}
					
					RTIApplication rtiApplication = new RTIApplication();

					if (tradeLicenseOwnerPartnerChangeRestDTO.getUserMobileNumber() !=0) {
						rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseOwnerPartnerChangeRestDTO.getUserMobileNumber()));
						} else {
						String userMobilenumber = "User Mobile Number field is Required";
						condition = false;
						message.append(userMobilenumber).append(",");
					}
					if (tradeLicenseOwnerPartnerChangeRestDTO.getNocForRelatedDepartment() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getNocForRelatedDepartment()
									.isEmpty()) {
						String doc1 = tradeLicenseOwnerPartnerChangeRestDTO.getNocForRelatedDepartment();

						files[0] = doc1;
					} else {
						String doc1 = "NocForRelatedDepartment field is Required";
						condition = false;
						message.append(doc1).append(",");
					}
					
					if (tradeLicenseOwnerPartnerChangeRestDTO.getCopyOfFormerLicence() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getCopyOfFormerLicence()
									.isEmpty()) {
						String doc2 = tradeLicenseOwnerPartnerChangeRestDTO.getCopyOfFormerLicence();

						files[1] = doc2;
					} else {
						String doc2 = "CopyOfFormerLicence field is Required";
						condition = false;
						message.append(doc2).append(",");
					}
					String doc3 = tradeLicenseOwnerPartnerChangeRestDTO
							.getPropertyTaxNoDue();
					files[2] = doc3;

					if (tradeLicenseOwnerPartnerChangeRestDTO.getBuildingAuthorizationDocument() != null
							&& !tradeLicenseOwnerPartnerChangeRestDTO.getBuildingAuthorizationDocument()
									.isEmpty()) {
						String doc4 = tradeLicenseOwnerPartnerChangeRestDTO.getBuildingAuthorizationDocument();

						files[3] = doc4;
					} else {
						String doc4 = "BuildingAuthorizationDocument field is Required";
						condition = false;
						message.append(doc4).append(",");
					}
					String savedFilePath = DeathCertificateRestController
							.saveFile(files, request);


					
					
					
					if (condition) {
						 rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
						 rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplication.setSubject("TRADE-LICENCE-PARTNER-CHANGE");
						rtiApplication.setTemplateName("tradeLicencePartnerChangeApplication");
						rtiApplication.setDepartment("MARKET-DEPARTMENT");
						rtiApplication.setWorkFlowStatus(0);
						rtiApplication.setFinalStatus("0");
						rtiApplication.setRtiserviceid(36);
						rtiApplication.setApplicantName(tradeLicencePartnerChange.getFullName());
						rtiApplication.setPhoneNumber(tradeLicencePartnerChange.getMobileNo());
						rtiApplication.setMobileNumber(tradeLicencePartnerChange.getMobileNo());
						rtiApplication.setEmail(tradeLicencePartnerChange.getEmail());
						rtiApplication.setPdfUploadFromPortal(savedFilePath);
						rtiApplication.setZone(tradeLicencePartnerChange.getZoneNo());
						rtiApplication.setApplicationCost(Double.parseDouble(tradeLicencePartnerChange.getApplicableFee()));
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
							tradeLicencePartnerChange.setRtiapplrefno(rti.getRtiApplnNumber());
							tradeLicencePartnerChange.setRti_ref_id(savedRti.getRtiApplicationId());
							long tradeLicencePartnerChange_regis_id = tradeLicencePartnerChangeService.getReferenceId(tradeLicencePartnerChange);
							rti.setRtiApplicationRefId(tradeLicencePartnerChange_regis_id);
							RTIApplication retunRti = rtiApplicationService.merge(rti);

							if ((retunRti != null) && (tradeLicencePartnerChange_regis_id > 0)) {
								tradeLicenseOwnerPartnerChangeRestDTO.setResponseStatus("Requested data saved successfully");
								tradeLicenseOwnerPartnerChangeRestDTO.setResult(retunRti.getRtiApplnNumber());
								tradeLicenseOwnerPartnerChangeRestDTO.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						tradeLicenseOwnerPartnerChangeRestDTO.setNocForRelatedDepartment("");
						tradeLicenseOwnerPartnerChangeRestDTO.setCopyOfFormerLicence("");
						tradeLicenseOwnerPartnerChangeRestDTO.setPropertyTaxNoDue("");
						tradeLicenseOwnerPartnerChangeRestDTO.setBuildingAuthorizationDocument("");
						tradeLicenseOwnerPartnerChangeRestDTO.setStatus("ok");
							}
							String name = tradeLicencePartnerChange.getFirstName() + tradeLicencePartnerChange.getMiddleName()
							+ tradeLicencePartnerChange.getLastName();
					        String applnNo = rti.getRtiApplnNumber();

							
							String msg = "Dear " + name + " your application with Application No. " + applnNo
									+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
							msg.replace("var3", "");
							SendEmail.sendEmail(tradeLicencePartnerChange.getEmail(), "Application Submitted Successfully" + applnNo,
									msg);
							SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicencePartnerChange.getMobileNo(), msg);
						}
					}
					if (!condition) {
						if (message.charAt(message.length() - 1) == ',') {
							message.deleteCharAt(message.length() - 1);
							tradeLicenseOwnerPartnerChangeRestDTO.setResult(message.toString());
							tradeLicenseOwnerPartnerChangeRestDTO.setResponseStatus("Requested data not saved successfully");
							tradeLicenseOwnerPartnerChangeRestDTO.setNocForRelatedDepartment("");
							tradeLicenseOwnerPartnerChangeRestDTO.setCopyOfFormerLicence("");
							tradeLicenseOwnerPartnerChangeRestDTO.setPropertyTaxNoDue("");
							tradeLicenseOwnerPartnerChangeRestDTO.setBuildingAuthorizationDocument("");
							tradeLicenseOwnerPartnerChangeRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
							reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
							tradeLicenseOwnerPartnerChangeRestDTO.setStatus("Internal Server Error");
							}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					log.equals(ex.getMessage());
					tradeLicenseOwnerPartnerChangeRestDTO.setNocForRelatedDepartment("");
					tradeLicenseOwnerPartnerChangeRestDTO.setCopyOfFormerLicence("");
					tradeLicenseOwnerPartnerChangeRestDTO.setPropertyTaxNoDue("");
					tradeLicenseOwnerPartnerChangeRestDTO.setBuildingAuthorizationDocument("");
					tradeLicenseOwnerPartnerChangeRestDTO.setResponseStatus(ex.getMessage());
					tradeLicenseOwnerPartnerChangeRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
					reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
					tradeLicenseOwnerPartnerChangeRestDTO.setStatus("Method not Allowed");
				}
				return tradeLicenseOwnerPartnerChangeRestDTO;
			}
			
			public static String saveFile(String data[], HttpServletRequest request) throws IOException {
				String filesPath = null;
				StringBuilder filesPathBuilder = new StringBuilder();
				String baseDir = CoreConstants.UPLOAD_PATH + "tradeRenewalPartner";
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
		

	




