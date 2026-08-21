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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.BirthCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.BirthCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.BirthCertificateRestDTO;

@Controller
public class BirthCertificateRestController {

	private static Log log = LogFactory
			.getLog(BirthCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private BirthCertificateService birthCertificateService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveBirthApplication")
	public @ResponseBody BirthCertificateRestDTO saveBirthApplication(
			@RequestBody BirthCertificateRestDTO birthCertificateRestDTO,
			HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveBirthApplication");
		}
		BirthCertificate birthCertificate = new BirthCertificate();
		// UserRegistrationDetails user = new UserRegistrationDetails();

		try {
			if (birthCertificateRestDTO.getApplicantName() != null
					&& !birthCertificateRestDTO.getApplicantName()
							.isEmpty()) {
				birthCertificate.setApplicantFirstName(
						birthCertificateRestDTO.getApplicantName());
			} else {
				String firstName = "Firstname field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if (birthCertificateRestDTO.getApplicantAreaName() != null
					&& !birthCertificateRestDTO.getApplicantAreaName()
							.isEmpty()) {
				birthCertificate.setApplicantAreaName(
						birthCertificateRestDTO.getApplicantAreaName());
			} else {
				String areaName = "AreaName field is Required";
				condition = false;
				message.append(areaName).append(",");
			}
			
			if (birthCertificateRestDTO.getCityName() != null
					&& !birthCertificateRestDTO.getCityName()
							.isEmpty()) {
				birthCertificate.setApplicantcity(birthCertificateRestDTO.getCityName());
			} else {
				String cityName = "City Name field is Required";
				condition = false;
				message.append(cityName).append(",");
			}

			if (birthCertificateRestDTO.getPlaceofbirth().equals("Hospital")) {
				if (birthCertificateRestDTO.getHospitalName() != null
						&& !birthCertificateRestDTO.getHospitalName()
								.isEmpty()) {
				birthCertificate.setHospitalName(birthCertificateRestDTO.getHospitalName());

					
				} else {
					String hospitalname = "Hospital Name field is Required";
					condition = false;
					message.append(hospitalname).append(",");
				}
			}else if(birthCertificateRestDTO.getPlaceofbirth().equals("Home") || birthCertificateRestDTO.getPlaceofbirth().equals("OutOfIndia")) {
				birthCertificate.setHospitalName(birthCertificateRestDTO.getHospitalName());

			}
			
			
			if (birthCertificateRestDTO.getPlaceofbirth().equals("Home")) {
				if (birthCertificateRestDTO.getHomeAddress() != null
						&& !birthCertificateRestDTO.getHomeAddress()
								.isEmpty()) {
				birthCertificate.setHomeAddress(birthCertificateRestDTO.getHomeAddress());

					
				} else {
					String hospitaladdress = "Home Address field is Required";
					condition = false;
					message.append(hospitaladdress).append(",");
				}
			}else if(birthCertificateRestDTO.getPlaceofbirth().equals("Hospital") || birthCertificateRestDTO.getPlaceofbirth().equals("OutOfIndia")) {
				birthCertificate.setHomeAddress(birthCertificateRestDTO.getHomeAddress());

			}
			
		
			
			// Save File From Json BASE64
			if (birthCertificateRestDTO.getPlaceofbirth().equals("Hospital")) {
				if (birthCertificateRestDTO.getHospitalCertificatePdf() != null
						&& !birthCertificateRestDTO.getHospitalCertificatePdf()
								.isEmpty()) {
					String doc1 = birthCertificateRestDTO
							.getHospitalCertificatePdf();

					files[0] = doc1;
				} else {
					String doc1 = "Hospital Certificate field is Required";
					condition = false;
					message.append(doc1).append(",");
				}

			} 
			
			
			if (birthCertificateRestDTO.getPlaceofbirth().equals("OutOfIndia")) {
				if (birthCertificateRestDTO.getCountryName() != null
						&& !birthCertificateRestDTO.getCountryName()
								.isEmpty()) {
				birthCertificate.setCountryName(birthCertificateRestDTO.getCountryName());

				} else {
					String countryName = "Country Name field is Required";
					condition = false;
					message.append(countryName).append(",");
				}
			}
			
			
			if (birthCertificateRestDTO.getPlaceofbirth().equals("OutOfIndia")) {
				if (birthCertificateRestDTO.getRegardingPermanentSettelmentInIndiaPdf() != null
						&& !birthCertificateRestDTO.getRegardingPermanentSettelmentInIndiaPdf()
								.isEmpty()) {
				String doc6=birthCertificateRestDTO.getRegardingPermanentSettelmentInIndiaPdf();
				files[1] = doc6;

				} else {
					String country = "Attachment regarding Permanent Settelment in India field is Required";
					condition = false;
					message.append(country).append(",");
				}
			}
			
			
			
			if (birthCertificateRestDTO.getFatherormotherIdProofPdf() != null
					&& !birthCertificateRestDTO.getFatherormotherIdProofPdf()
							.isEmpty()) {
				String doc2 = birthCertificateRestDTO.getFatherormotherIdProofPdf();

				files[2] = doc2;
			} else {
				String doc2 = "Father/Mother Id Proof field is Required";
				condition = false;
				message.append(doc2).append(",");
			}

			if (birthCertificateRestDTO.getApplicantIdProofPdf() != null
					&& !birthCertificateRestDTO.getApplicantIdProofPdf()
							.isEmpty()) {
				String doc3 = birthCertificateRestDTO.getApplicantIdProofPdf();

				files[3] = doc3;
			} else {
				String doc3 = "Applicant Id Proof field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			
			String doc5 = birthCertificateRestDTO
					.getCertificateissuesByWardmemberPdf();
			files[4] = doc5;

			// Save FilesPath
			String savedFilePath = BirthCertificateRestController
					.saveFile(files, request);

			birthCertificate.setApplicantBuildingName(
					birthCertificateRestDTO.getApplicantBuildingName());

			birthCertificate.setApplicantMiddleName(
					birthCertificateRestDTO.getApplicantFatherName());

			if (birthCertificateRestDTO.getApplicantSurname() != null
					&& !birthCertificateRestDTO.getApplicantSurname()
							.isEmpty()) {
				birthCertificate.setApplicantLastName(
						birthCertificateRestDTO.getApplicantSurname());
			} else {
				String middleName = "LastName field is Required";
				condition = false;
				message.append(middleName).append(",");
			}
			if (birthCertificateRestDTO.getApplicantFullName() != null
					&& !birthCertificateRestDTO.getApplicantFullName()
							.isEmpty()) {
				birthCertificate.setApplicantFullName(
						birthCertificateRestDTO.getApplicantFullName());
			} else {
				String FullName = "FullName field is Required";
				condition = false;
				message.append(FullName).append(",");
			}

			birthCertificate.setApplicantNearbyLandmark(
					birthCertificateRestDTO.getApplicantNearbyLandmark());

			if (birthCertificateRestDTO.getApplicantPinCode() != 0) {
				birthCertificate.setApplicantPinCode(String.valueOf(
						birthCertificateRestDTO.getApplicantPinCode()));
			} else {
				String pinCode = "Pincode field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			if (birthCertificateRestDTO.getApplicantPlotNo() != null
					&& !birthCertificateRestDTO.getApplicantPlotNo()
							.isEmpty()) {
				birthCertificate.setApplicantPlotNo(
						birthCertificateRestDTO.getApplicantPlotNo());
			} else {
				String plotNo = "PlotNo. field is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			if (birthCertificateRestDTO.getApplicantRelationship() != null
					&& !birthCertificateRestDTO.getApplicantRelationship()
							.isEmpty()) {
				birthCertificate.setApplicantRelationship(
						birthCertificateRestDTO.getApplicantRelationship());
			} else {
				String relationship = "RelationShip of Applicant field is Required";
				condition = false;
				message.append(relationship).append(",");
			}
			birthCertificate.setApplicantStreetName(
					birthCertificateRestDTO.getApplicantStreetName());

			if (birthCertificateRestDTO.getApplicantTitle() != null
					&& !birthCertificateRestDTO.getApplicantTitle().isEmpty()) {
				birthCertificate.setApplicantTitle(
						birthCertificateRestDTO.getApplicantTitle());
			} else {
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}

			if (birthCertificateRestDTO.getEmail() != null
					&& !birthCertificateRestDTO.getEmail().isEmpty()) {
				birthCertificate.setEmail(birthCertificateRestDTO.getEmail());
			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if (birthCertificateRestDTO.getAddress() != null
					&& !birthCertificateRestDTO.getAddress().isEmpty()) {
				birthCertificate
						.setAddress(birthCertificateRestDTO.getAddress());
			} else {
				String address = "Address field is Required";
				condition = false;
				message.append(address).append(",");
			}

			if (birthCertificateRestDTO.getPhoneNo() != 0) {
				birthCertificate.setPh_no(
						String.valueOf(birthCertificateRestDTO.getPhoneNo()));
			} else {
				String phoneNo = "PhoneNo. field is Required";
				condition = false;
				message.append(phoneNo).append(",");

			}

			if (birthCertificateRestDTO.getZone() != 0) {
				birthCertificate.setZone(
						String.valueOf(birthCertificateRestDTO.getZone()));
			} else {
				String zone = "ZonNo. field is Required";
				condition = false;
				message.append(zone).append(",");
			}
			
			//Child Name fixed if No
			if(birthCertificateRestDTO.getCheckChildName().equals("NO")) {
			if (birthCertificateRestDTO.getChildName() != null
					&& !birthCertificateRestDTO.getChildName().isEmpty()) {
				if(birthCertificateRestDTO.getChildName().equals("BABY")) {
				birthCertificate
						.setChildeName(birthCertificateRestDTO.getChildName());
				}else {
					String checkchildname = "Incorrect child name";
					condition = false;
					message.append(checkchildname).append(",");
				}
			} else {
				String childname = "Child Name field is Required";
				condition = false;
				message.append(childname).append(",");
			}
			
			}
			
			
			if(birthCertificateRestDTO.getCheckChildName().equals("YES")) {
				if (birthCertificateRestDTO.getChildName() != null
						&& !birthCertificateRestDTO.getChildName().isEmpty()) {
					birthCertificate
					.setChildeName(birthCertificateRestDTO.getChildName());
				} else {
					String childname = "Child Name field is Required";
					condition = false;
					message.append(childname).append(",");
				}
				
				}


			if (birthCertificateRestDTO.getDateOfBirth() != null
					&& !birthCertificateRestDTO.getDateOfBirth().isEmpty()) {
				birthCertificate
						.setDob(birthCertificateRestDTO.getDateOfBirth());
			} else {
				String dob = "Date of Birth field is Required";
				condition = false;
				message.append(dob).append(",");
			}

			if (birthCertificateRestDTO.getCertificateExpectedInDays() != 0) {
				birthCertificate.setCertificateExpectedInDays(
						String.valueOf(birthCertificateRestDTO
								.getCertificateExpectedInDays()));
			} else {
				String certificateExpectedDays = "Certificate Expected in Days field is Required";
				condition = false;
				message.append(certificateExpectedDays).append(",");
			}

			if (birthCertificateRestDTO.getGender() != null
					&& !birthCertificateRestDTO.getGender().isEmpty()) {
				birthCertificate.setGender(birthCertificateRestDTO.getGender());
			} else {
				String gender = "Gender field is Required";
				condition = false;
				message.append(gender).append(",");
			}

			if (birthCertificateRestDTO.getPlaceofbirth() != null
					&& !birthCertificateRestDTO.getPlaceofbirth().isEmpty()) {
				birthCertificate.setPlaceofbirth(
						birthCertificateRestDTO.getPlaceofbirth());
			} else {
				String placeofbirth = "Place Of Birth field is Required";
				condition = false;
				message.append(placeofbirth).append(",");
			}

			if (birthCertificateRestDTO.getReasonForCertificate() != null
					&& !birthCertificateRestDTO.getReasonForCertificate()
							.isEmpty()) {
				birthCertificate.setReasonForCertificate(
						birthCertificateRestDTO.getReasonForCertificate());
			} else {
				String reasonofcertificate = "Reason Of Certificate field is Required";
				condition = false;
				message.append(reasonofcertificate).append(",");
			}

			if (birthCertificateRestDTO.getFeesApplicable() != 0.0
					|| birthCertificateRestDTO.getFeesApplicable() != 0) {
				birthCertificate.setFeesApplicable(
						birthCertificateRestDTO.getFeesApplicable());
			} else {
				String feesApplicable = "Fees Applicable field is Required";
				condition = false;
				message.append(feesApplicable).append(",");
			}

			if (birthCertificateRestDTO.getNoOfCertificateCopies() != 0) {
				birthCertificate.setNoOfCertificateCopies(
						birthCertificateRestDTO.getNoOfCertificateCopies());
			} else {
				String noOfcertificate = "No.Of Certificate field is Required";
				condition = false;
				message.append(noOfcertificate).append(",");
			}

			if (birthCertificateRestDTO.getFatherName() != null
					&& !birthCertificateRestDTO.getFatherName().isEmpty()) {
				birthCertificate
						.setFatherName(birthCertificateRestDTO.getFatherName());
			} else {
				String fattherName = "Father Name field is Required";
				condition = false;
				message.append(fattherName).append(",");
			}

			if (birthCertificateRestDTO.getMotherName() != null
					&& !birthCertificateRestDTO.getMotherName().isEmpty()) {
				birthCertificate
						.setMotherName(birthCertificateRestDTO.getMotherName());
			} else {
				String motherName = "Mother Name field is Required";
				condition = false;
				message.append(motherName).append(",");
			}

			birthCertificate
					.setBloodGroup(birthCertificateRestDTO.getBloodGroup());
			birthCertificate.setBloodRelation(
					birthCertificateRestDTO.getBloodRelation());
			birthCertificate
					.setAadhaarNo(birthCertificateRestDTO.getAadhaarNo());

			RTIApplication rtiApplication = new RTIApplication();
			if (birthCertificateRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						birthCertificateRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (condition) {
				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("BIRTH-CERTIFICATE");
				rtiApplication.setTemplateName("birthApplication");
				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(1);
				// rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setApplicantName(
						birthCertificate.getApplicantFullName());
				rtiApplication.setPhoneNumber(birthCertificate.getPh_no());
				rtiApplication.setMobileNumber(birthCertificate.getPh_no());
				rtiApplication.setEmail(birthCertificate.getEmail());
				rtiApplication.setZone(birthCertificate.getZone());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicationCost(
						birthCertificate.getFeesApplicable());

				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails
						.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(
						CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication
						.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService
						.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rtiApplicationService
							.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/"
							+ savedRti.getRtiApplicationId());
					birthCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					birthCertificate
							.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = birthCertificateService
							.birthCertificate(birthCertificate);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						birthCertificateRestDTO.setResponseStatus(
								"Requested data saved successfully");
						birthCertificateRestDTO
								.setResult(retunRti.getRtiApplnNumber());
						birthCertificateRestDTO.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						birthCertificateRestDTO.setRegardingPermanentSettelmentInIndiaPdf("");
						birthCertificateRestDTO.setHospitalCertificatePdf(""); 
						birthCertificateRestDTO.setFatherormotherIdProofPdf("");
						birthCertificateRestDTO.setApplicantIdProofPdf("");
						birthCertificateRestDTO.setCertificateissuesByWardmemberPdf("");
						birthCertificateRestDTO.setStatus("ok");
					}
					String name = birthCertificate.getApplicantFirstName()
							+ birthCertificate.getApplicantMiddleName()
							+ birthCertificate.getApplicantLastName();
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name
							+ " your application with Application No. "                       
							+ applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(birthCertificate.getEmail(),
							"Application Submitted Successfully" + applnNo,
							msg);
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov",
							birthCertificate.getPh_no(), msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					birthCertificateRestDTO.setResult(message.toString());
					birthCertificateRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					birthCertificateRestDTO.setRegardingPermanentSettelmentInIndiaPdf("");
					birthCertificateRestDTO.setHospitalCertificatePdf("");
					birthCertificateRestDTO.setFatherormotherIdProofPdf("");
					birthCertificateRestDTO.setApplicantIdProofPdf("");
					birthCertificateRestDTO.setCertificateissuesByWardmemberPdf("");
					birthCertificateRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					birthCertificateRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
			birthCertificateRestDTO.setResponseStatus(ex.getMessage());
			birthCertificateRestDTO.setRegardingPermanentSettelmentInIndiaPdf("");
			birthCertificateRestDTO.setHospitalCertificatePdf("");
			birthCertificateRestDTO.setFatherormotherIdProofPdf("");
			birthCertificateRestDTO.setApplicantIdProofPdf("");
			birthCertificateRestDTO.setCertificateissuesByWardmemberPdf("");
			birthCertificateRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			birthCertificateRestDTO.setStatus("Method not Allowed");
		}
		return birthCertificateRestDTO;
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "birthcertificate";
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
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/getRTSRegistrationform/{servicesid}")
	public @ResponseBody String getRTSRegistrationform(@PathVariable("servicesid") long serviceId,HttpServletRequest  request, HttpServletResponse reponse)
			throws ServletException {
		
		String url=null;
		
		if(serviceId==1) {
		 url="https://nagpur.egovmars.in/RTSservices/kiosk/rtiapplication/newRTIBirthApplication.do";
		
		}else if(serviceId==2) {
			url="https://nagpur.egovmars.in/RTSservices/kiosk/rtiapplication/newRTIBirthApplication.do";
		}else if(serviceId==3) {
			url="https://nagpur.egovmars.in/RTSservices/kiosk/user/login.do";

		} else if(serviceId==4) {
			url="https://nagpur.egovmars.in/RTSservices/kiosk/user/registration.do";

		}
		
		return url;
		
	}
	

}