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
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.DeathCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.DeathCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.DeathCertificateRestDTO;

@Controller
public class DeathCertificateRestController {

	private static Log log = LogFactory.getLog(DeathCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private DeathCertificateService deathCertificateService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveDeathApplication")
	public @ResponseBody DeathCertificateRestDTO saveDeathApplication(
			@RequestBody DeathCertificateRestDTO deathCertificateRestDTO, HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[6];

		UserRegistrationDetails user = new UserRegistrationDetails();

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveDeathApplication");
		}
		DeathCertificate deathCertificate = new DeathCertificate();

		try {
			if (deathCertificateRestDTO.getApplicantTitle() != null
					&& !deathCertificateRestDTO.getApplicantTitle().isEmpty()) {
				deathCertificate.setApplicantTitle(deathCertificateRestDTO.getApplicantTitle());
			} else {
				String applicantTitle = "Title field is Required";
				condition = false;
				message.append(applicantTitle).append(",");
			}
			if (deathCertificateRestDTO.getName() != null
					&& !deathCertificateRestDTO.getName().isEmpty()) {
				deathCertificate.setApplicantFirstName(deathCertificateRestDTO.getName());
			} else {
				String applicantFirstName = "Name field is Required";
				condition = false;
				message.append(applicantFirstName).append(",");
			}
			deathCertificate.setApplicantMiddleName(deathCertificateRestDTO.getFathersName());

			if (deathCertificateRestDTO.getSurname() != null
					&& !deathCertificateRestDTO.getSurname().isEmpty()) {
				deathCertificate.setApplicantLastName(deathCertificateRestDTO.getSurname());
			} else {
				String applicantLastName = "Surname field is Required";
				condition = false;
				message.append(applicantLastName).append(",");
			}
			
			if (deathCertificateRestDTO.getApplicantFullName() != null
					&& !deathCertificateRestDTO.getApplicantFullName().isEmpty()) {
				deathCertificate.setApplicantFullName(deathCertificateRestDTO.getApplicantFullName());
			} else {
				String applicantFullName = "applicantFullName field is Required";
				condition = false;
				message.append(applicantFullName).append(",");
			}
			if (deathCertificateRestDTO.getApplicantPlotNo() != null
					&& !deathCertificateRestDTO.getApplicantPlotNo().isEmpty()) {
				deathCertificate.setApplicantPlotNo(deathCertificateRestDTO.getApplicantPlotNo());
			} else {
				String applicantPlotNo = "applicantPlotNo. field is Required";
				condition = false;
				message.append(applicantPlotNo).append(",");
			}
			deathCertificate.setApplicantBuildingName(deathCertificateRestDTO.getApplicantBuildingName());
			deathCertificate.setApplicantStreetName(deathCertificateRestDTO.getApplicantStreetName());
			if (deathCertificateRestDTO.getApplicantAreaName() != null
					&& !deathCertificateRestDTO.getApplicantAreaName().isEmpty()) {
				deathCertificate.setApplicantAreaName(deathCertificateRestDTO.getApplicantAreaName());
			} else {
				String applicantAreaName = "applicantAreaName field is Required";
				condition = false;
				message.append(applicantAreaName).append(",");
			}
			deathCertificate.setApplicantNearbyLandmark(deathCertificateRestDTO.getApplicantNearbyLandmark());
			if (deathCertificateRestDTO.getCityName() != null
					&& !deathCertificateRestDTO.getCityName().isEmpty()) {
				deathCertificate.setCityName(deathCertificateRestDTO.getCityName());
			} else {
				String CityName = "CityName field is Required";
				condition = false;
				message.append(CityName).append(",");
			}
			if (deathCertificateRestDTO.getApplicantPinCode() != 0) {
				deathCertificate.setApplicantPinCode(String.valueOf(deathCertificateRestDTO.getApplicantPinCode()));
			} else {
				String applicantPinCode = "applicantPinCode field is Required";
				condition = false;
				message.append(applicantPinCode).append(",");
			}
			if (deathCertificateRestDTO.getEmail() != null && !deathCertificateRestDTO.getEmail().isEmpty()) {
				deathCertificate.setEmail(deathCertificateRestDTO.getEmail());
			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if (deathCertificateRestDTO.getMobileNo() != 0) {
				deathCertificate.setPh_no(String.valueOf(deathCertificateRestDTO.getMobileNo()));
			} else {
				String mobileNo = "MobileNo. field is Required";
				condition = false;
				message.append(mobileNo).append(",");

			}
			
			deathCertificate.setAadhaarNo(String.valueOf(deathCertificateRestDTO.getAadhaarNo()));

			if (deathCertificateRestDTO.getApplicantRelationship() != null
					&& !deathCertificateRestDTO.getApplicantRelationship().isEmpty()) {
				deathCertificate.setApplicantRelationship(deathCertificateRestDTO.getApplicantRelationship());
			} else {
				String applicantRelationship = "applicantRelationship field is Required";
				condition = false;
				message.append(applicantRelationship).append(",");
			}
			
			if (deathCertificateRestDTO.getAddress() != null && !deathCertificateRestDTO.getAddress().isEmpty()) {
				deathCertificate.setAddress(deathCertificateRestDTO.getAddress());
			} else {
				String address = "address field is Required";
				condition = false;
				message.append(address).append(",");
			}
			if (deathCertificateRestDTO.getNameOfDeceased() != null
					&& !deathCertificateRestDTO.getNameOfDeceased().isEmpty()) {
				deathCertificate.setNameOfDeceased(deathCertificateRestDTO.getNameOfDeceased());
			} else {
				String nameOfDeceased = "nameOfDeceased field is Required";
				condition = false;
				message.append(nameOfDeceased).append(",");
			}
			if (deathCertificateRestDTO.getGender() != null && !deathCertificateRestDTO.getGender().isEmpty()) {
				deathCertificate.setGender(deathCertificateRestDTO.getGender());
			} else {
				String gender = "gender field is Required";
				condition = false;
				message.append(gender).append(",");
			}
			if (deathCertificateRestDTO.getDeceasedAge() != null && !deathCertificateRestDTO.getDeceasedAge().isEmpty()) {
				deathCertificate.setInfantAge(deathCertificateRestDTO.getDeceasedAge());
			} else {
				String DeceasedAge = "DeceasedAge field is Required";
				condition = false;
				message.append(DeceasedAge).append(",");
			}

			if (deathCertificateRestDTO.getFatherName() != null && !deathCertificateRestDTO.getFatherName().isEmpty()) {
				deathCertificate.setFatherName(deathCertificateRestDTO.getFatherName());
			} else {
				String fatherName = "fatherName field is Required";
				condition = false;
				message.append(fatherName).append(",");
			}

			if (deathCertificateRestDTO.getMotherName() != null && !deathCertificateRestDTO.getMotherName().isEmpty()) {
				deathCertificate.setMotherName(deathCertificateRestDTO.getMotherName());
			} else {
				String motherName = "motherName field is Required";
				condition = false;
				message.append(motherName).append(",");
			}
			deathCertificate.setWifeName(deathCertificateRestDTO.getWifeorhusbandName());
			deathCertificate.setGrandfatherName(deathCertificateRestDTO.getGrandfatherName());
			if (deathCertificateRestDTO.getDateOfDeath() != null
					&& !deathCertificateRestDTO.getDateOfDeath().isEmpty()) {
				deathCertificate.setDateOfDeath(deathCertificateRestDTO.getDateOfDeath());
			} else {
				String dateOfDeath = "dateOfDeath field is Required";
				condition = false;
				message.append(dateOfDeath).append(",");
			}
			if (deathCertificateRestDTO.getPlaceofdeath() != null
					&& !deathCertificateRestDTO.getPlaceofdeath().isEmpty()) {
				deathCertificate.setPlaceOfDeath(
						deathCertificateRestDTO.getPlaceofdeath());
			} else {
				String Placeofdeath = "Place Of Death field is Required";
				condition = false;
				message.append(Placeofdeath).append(",");
			}
			if (deathCertificateRestDTO.getPlaceofdeath().equals("Home")) {
				if (deathCertificateRestDTO.getDeathHomeAddress() != null
						&& !deathCertificateRestDTO.getDeathHomeAddress()
								.isEmpty()) {
					deathCertificate.setDeathHomeAddress(deathCertificateRestDTO.getDeathHomeAddress());
		
				} else {
					String DeathHomeAddress = "Death Home Address field is Required";
					condition = false;
					message.append(DeathHomeAddress).append(",");
				}
			}else if(deathCertificateRestDTO.getPlaceofdeath().equals("Hospital")) {
				deathCertificate.setDeathHomeAddress(deathCertificateRestDTO.getDeathHomeAddress());

			}
			
			
			if (deathCertificateRestDTO.getPlaceofdeath().equals("Hospital")) {
				if (deathCertificateRestDTO.getHospitalName() != null
						&& !deathCertificateRestDTO.getHospitalName()
								.isEmpty()) {
				deathCertificate.setHospitalName(deathCertificateRestDTO.getHospitalName());

					
				} else {
					String hospitalname = "Hospital Name field is Required";
					condition = false;
					message.append(hospitalname).append(",");
				}
			}else if(deathCertificateRestDTO.getPlaceofdeath().equals("Home")) {
				deathCertificate.setHospitalName(deathCertificateRestDTO.getHospitalName());

			}
			// Save File From Json BASE64
						if (deathCertificateRestDTO.getPlaceofdeath().equals("Hospital")) {
							if (deathCertificateRestDTO.getHospitalFilePdf() != null
									&& !deathCertificateRestDTO.getHospitalFilePdf()
											.isEmpty()) {
								String doc1 = deathCertificateRestDTO
										.getHospitalFilePdf();

								files[0] = doc1;
							} else {
								String doc1 = "Hospital Certificate field is Required";
								condition = false;
								message.append(doc1).append(",");
							}

						} else if(deathCertificateRestDTO.getPlaceofdeath().equals("Home") ) {
							String doc1 = deathCertificateRestDTO
									.getHospitalFilePdf();

							files[0] = doc1;
						}
						
					
						
						
						if (deathCertificateRestDTO.getZone() != 0) {
							deathCertificate.setZone(String.valueOf(deathCertificateRestDTO.getZone()));
						} else {
							String zone = "Zone No. field is Required";
							condition = false;
							message.append(zone).append(",");
						}		
						if (deathCertificateRestDTO.getNameofCrematorium() != null
								&& !deathCertificateRestDTO.getNameofCrematorium().isEmpty()) {
							deathCertificate.setNameofCrematorium(deathCertificateRestDTO.getNameofCrematorium());
						} else {
							String nameofCrematorium = "nameofCrematorium field is Required";
							condition = false;
							message.append(nameofCrematorium).append(",");
						}
						
						deathCertificate.setReasonOfDeath(deathCertificateRestDTO.getReasonOfDeath());

			if (deathCertificateRestDTO.getDeathType() != null && !deathCertificateRestDTO.getDeathType().isEmpty()) {
				deathCertificate.setDeathType(deathCertificateRestDTO.getDeathType());
			} else {
				String deathType = "deathType field is Required";
				condition = false;
				message.append(deathType).append(",");
			}
			
			if (deathCertificateRestDTO.getIsbodyDonated() != null
					&& !deathCertificateRestDTO.getIsbodyDonated().isEmpty()) {
				deathCertificate.setBodyDonated(deathCertificateRestDTO.getIsbodyDonated());
			} else {
				String IsbodyDonated = "IsbodyDonated field is Required";
				condition = false;
				message.append(IsbodyDonated).append(",");
			}
			
			if (deathCertificateRestDTO.getIsbodyDonated().equals("Yes")) {
				if (deathCertificateRestDTO.getBodyDonatePdf() != null
						&& !deathCertificateRestDTO.getBodyDonatePdf().isEmpty()) {
					String doc2 = deathCertificateRestDTO.getBodyDonatePdf();

					files[4] = doc2;
				} else {
					String doc2 = "bodyDonatePdf field is Required";
					condition = false;
					message.append(doc2).append(",");
				}

			} else if(deathCertificateRestDTO.getIsbodyDonated().equals("No") ) {
				String doc2 = deathCertificateRestDTO.getBodyDonatePdf();

				files[4] = doc2;
			}
			
			
			// Save File From Json BASE64
			if (deathCertificateRestDTO.getIsbodyDonated().equals("No")) {
				if (deathCertificateRestDTO.getCermationFilePdf() != null
						&& !deathCertificateRestDTO.getCermationFilePdf()
								.isEmpty()) {
					String doc2 = deathCertificateRestDTO.getCermationFilePdf();

					files[3] = doc2;
				} else {
					String doc2 = "cermationFilePdf field is Required";
					condition = false;
					message.append(doc2).append(",");
				}

			} else if(deathCertificateRestDTO.getIsbodyDonated().equals("Yes") ) {
				String doc2 = deathCertificateRestDTO.getCermationFilePdf();

				files[3] = doc2;
			}
			
			deathCertificate.setReasonForCertificate(deathCertificateRestDTO.getReasonForCertificate());
			
			
			if (deathCertificateRestDTO.getCertificateExpectedInDays() != 0) {
				deathCertificate.setCertificateExpectedInDays(String.valueOf(deathCertificateRestDTO.getCertificateExpectedInDays()));
			} else {
				String certificateExpectedInDays = "certificateExpectedInDays field is Required";
				condition = false;
				message.append(certificateExpectedInDays).append(",");
			}

			if (deathCertificateRestDTO.getNoOfCertificateCopies() != 0) {
	deathCertificate.setNoOfCertificateCopies(deathCertificateRestDTO.getNoOfCertificateCopies());
} else {
	String noOfCertificateCopies = "No.Of Certificate field is Required";
	condition = false;
	message.append(noOfCertificateCopies).append(",");
}
				
			if (deathCertificateRestDTO.getFeesApplicable() != 0.0
					|| deathCertificateRestDTO.getFeesApplicable() != 0) {
				deathCertificate.setFeesApplicable(deathCertificateRestDTO.getFeesApplicable());
			} else {
				String feesApplicable = "Fees Applicable field is Required";
				condition = false;
				message.append(feesApplicable).append(",");
			}
			
			RTIApplication rtiApplication = new RTIApplication();

			if (deathCertificateRestDTO.getUserMobileNumber() !=0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(deathCertificateRestDTO.getUserMobileNumber()));
				} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			
			
			
			
			if (deathCertificateRestDTO.getDeceasedIdProofPdf() != null
					&& !deathCertificateRestDTO.getDeceasedIdProofPdf()
							.isEmpty()) {
				String doc3 = deathCertificateRestDTO.getDeceasedIdProofPdf();

				files[1] = doc3;
			} else {
				String doc3 = "Deceased Id Proof field is Required";
				condition = false;
				message.append(doc3).append(",");
			}

			if (deathCertificateRestDTO.getApplicantIdPdf() != null
					&& !deathCertificateRestDTO.getApplicantIdPdf()
							.isEmpty()) {
				String doc4 = deathCertificateRestDTO.getApplicantIdPdf();

				files[2] = doc4;
			} else {
				String doc4 = "Applicant Id Proof field is Required";
				condition = false;
				message.append(doc4).append(",");
			}
//			if (deathCertificateRestDTO.getCermationFilePdf() != null
//					&& !deathCertificateRestDTO.getCermationFilePdf()
//							.isEmpty()) {
//				String doc4 = deathCertificateRestDTO.getCermationFilePdf();
//				files[3] = doc4;
//			} else {
//				String doc4 = "Crematoriums File field is Required";
//				condition = false;
//				message.append(doc4).append(",");
//			}
			String doc5 = deathCertificateRestDTO.getCertiCorrespondentPdf();
			files[5] = doc5;
			String savedFilePath = DeathCertificateRestController.saveFile(files, request);

//			if (deathCertificateRestDTO.getUserMobileNumber() !=0) {
//				user.setMobileNo(String.valueOf(deathCertificateRestDTO.getUserMobileNumber()));
//				} else {
//				String userMobilenumber = "User Mobile Number field is Required";
//				condition = false;
//				message.append(userMobilenumber).append(",");
//			}
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("DEATH-CERTIFICATE");
				rtiApplication.setTemplateName("deathApplication");
				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(2);
				//rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setApplicantName(deathCertificate.getApplicantFullName());
				rtiApplication.setPhoneNumber(deathCertificate.getPh_no());
				rtiApplication.setMobileNumber(deathCertificate.getPh_no());
				rtiApplication.setEmail(deathCertificate.getEmail());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setZone(deathCertificate.getZone());

				rtiApplication.setApplicationCost(deathCertificate.getFeesApplicable());

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
					rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					deathCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					deathCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
					long death_regis_id = deathCertificateService.deathCertificateSave(deathCertificate);
					rti.setRtiApplicationRefId(death_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (death_regis_id > 0)) {
						deathCertificateRestDTO.setResponseStatus("Requested data saved successfully");
						deathCertificateRestDTO.setResult(retunRti.getRtiApplnNumber());
						deathCertificateRestDTO.setResponseCode(HttpStatus.OK.value());
				reponse.setStatus(HttpStatus.OK.value());
				deathCertificateRestDTO.setHospitalFilePdf("");
				deathCertificateRestDTO.setDeceasedIdProofPdf("");
				deathCertificateRestDTO.setApplicantIdPdf("");
				deathCertificateRestDTO.setCermationFilePdf("");
				deathCertificateRestDTO.setBodyDonatePdf("");
				deathCertificateRestDTO.setCertiCorrespondentPdf("");

				deathCertificateRestDTO.setStatus("ok");
					}
				
					String applnNo = rti.getRtiApplnNumber();
					
					String name = deathCertificate.getApplicantFullName();
				
					String mobileNo = deathCertificate.getPh_no();
					String email=deathCertificate.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					deathCertificateRestDTO.setResult(message.toString());
					deathCertificateRestDTO.setResponseStatus("Requested data not saved successfully");
					deathCertificateRestDTO.setHospitalFilePdf("");
					deathCertificateRestDTO.setDeceasedIdProofPdf("");
					deathCertificateRestDTO.setApplicantIdPdf("");
					deathCertificateRestDTO.setCermationFilePdf("");
					deathCertificateRestDTO.setBodyDonatePdf("");
					deathCertificateRestDTO.setCertiCorrespondentPdf("");

					deathCertificateRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					deathCertificateRestDTO.setStatus("Internal Server Error");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			deathCertificateRestDTO.setResponseStatus(ex.getMessage());
			deathCertificateRestDTO.setHospitalFilePdf("");
			deathCertificateRestDTO.setDeceasedIdProofPdf("");
			deathCertificateRestDTO.setApplicantIdPdf("");
			deathCertificateRestDTO.setCermationFilePdf("");
			deathCertificateRestDTO.setBodyDonatePdf("");
			deathCertificateRestDTO.setCertiCorrespondentPdf("");

			deathCertificateRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			deathCertificateRestDTO.setStatus("Method not Allowed");
			}
		return deathCertificateRestDTO;
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "deathCertificates";
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


