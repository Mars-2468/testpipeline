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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.mars.rti.model.DogDetails;
import com.mars.rti.model.DogLicenseCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.DogDetailsService;
import com.mars.rti.service.DogLicenceCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.DogDetailsRestDTO;
import com.mars.rti.ws.model.DogLicenseRestDTO;

@Controller
public class DogLicenseRestController {

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private DogLicenceCertificateService dogLicenceCertificateService;

	@Autowired
	private DogDetailsService dogDetailsService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveDogLicense")
	public @ResponseBody DogLicenseRestDTO saveDogLicense(
			@RequestBody DogLicenseRestDTO dogdto, HttpServletRequest request,
			HttpServletResponse reponse) {
		double amount = 0;
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		String[] vaccinationfiles = new String[2];
		String dogImage = "";
		try {
			DogLicenseCertificate dog = new DogLicenseCertificate();
			List<DogDetailsRestDTO> dogLicenseRestDTO = null;
			UserRegistrationDetails user = new UserRegistrationDetails();

			List<DogDetails> dogdetails1 = new ArrayList<DogDetails>();
			if (dogdto.getAreaName() != null) {
				dog.setAreaName(dogdto.getAreaName());
			} else {
				String areaName = "AreaName field is Required";
				condition = false;
				message.append(areaName).append(",");
			}

			dog.setBuildingName(dogdto.getBuildingName());
			if (dogdto.getColonyName() != null) {
				dog.setColonyName(dogdto.getColonyName());
			} else {
				String colonyName = "Colony Name field is Required";
				condition = false;
				message.append(colonyName).append(",");
			}
			if (dogdto.getCorrespondenceAddress() != null) {
				dog.setCorrespondenceAddress(dogdto.getCorrespondenceAddress());
			} else {
				String address = "Address field is Required";
				condition = false;
				message.append(address).append(",");
			}

			if (dogdto.getEmailId() != null) {
				dog.setEmailId(dogdto.getEmailId());
			} else {
				String emailid = "EmailId is Required";
				condition = false;
				message.append(emailid).append(",");
			}

			if (dogdto.getName() != null) {
				dog.setFirstName(dogdto.getName());
			} else {
				String name = "Name is Required";
				condition = false;
				message.append(name).append(",");
			}
			dog.setMiddleName(dogdto.getFatherName());
			if (dogdto.getSurname() != null) {
				dog.setLastName(dogdto.getSurname());
			} else {
				String lastName = "Surname is Required";
				condition = false;
				message.append(lastName).append(",");
			}

			if (dogdto.getCityName() != null
					|| !dogdto.getCityName().isEmpty()) {
				dog.setApplicantcity(dogdto.getCityName());
			} else {
				String cityname = "City Name is Required";
				condition = false;
				message.append(cityname).append(",");
			}
			
			if (dogdto.getMobileNumber() != 0) {
				dog.setMobileNumber(String.valueOf(dogdto.getMobileNumber()));
			} else {
				String lastName = "Mobile Number is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			if (dogdto.getFullName() != null
					|| !dogdto.getFullName().isEmpty()) {
				dog.setName(dogdto.getFullName());
			} else {
				String fullname = "Full Name is Required";
				condition = false;
				message.append(fullname).append(",");
			}

			dog.setNearbyLandmark(dogdto.getNearbyLandmark());

			if (dogdto.getPinCode() != 0) {
				dog.setPinCode(String.valueOf(dogdto.getPinCode()));
			} else {
				String pinCode = "Pincode is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			if (dogdto.getPlotNo() != null) {
				dog.setPlotNo(dogdto.getPlotNo());
			} else {
				String plotNo = "PlotNo. is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			dog.setStreetName(dogdto.getStreetName());
			if (dogdto.getTitle() != null) {
				dog.setTitle(dogdto.getTitle());
			} else {
				String title = "Title is Required";
				condition = false;
				message.append(title).append(",");
			}
			if (dogdto.getWardNo() != null) {
				dog.setWardNo(dogdto.getWardNo());
			} else {
				String title = "WardNo. is Required";
				condition = false;
				message.append(title).append(",");
			}
			if (dogdto.getZoneNo() != 0) {
				dog.setZoneNo(String.valueOf(dogdto.getZoneNo()));
			} else {
				String title = "ZoneNo. is Required";
				condition = false;
				message.append(title).append(",");
			}

			// files

			if (dogdto.getFirstVaccinationCertificate() != null
					&& !dogdto.getFirstVaccinationCertificate().isEmpty()) {
				String vacdoc1 = dogdto.getFirstVaccinationCertificate();
				vaccinationfiles[0] = vacdoc1;
			} else {
				String vacdoc1 = "First Vaccination Certificate field is Required";
				condition = false;
				message.append(vacdoc1).append(",");
			}
			if (dogdto.getSecondVaccinationCertificate() != null
					&& !dogdto.getSecondVaccinationCertificate().isEmpty()) {
				String vacdoc2 = dogdto.getSecondVaccinationCertificate();
				vaccinationfiles[1] = vacdoc2;
			} else {
				String vacdoc2 = "Current/Second Vaccination Certificate field is Required";
				condition = false;
				message.append(vacdoc2).append(",");
			}

//			String vacdoc2 = dogdto.getSecondVaccinationCertificate();
//			vaccinationfiles[1] = vacdoc2;

			// operated

			// List OF Documents files save path
			if (dogdto.getDogOwnerIdProof() != null
					&& !dogdto.getDogOwnerIdProof().isEmpty()) {
				String doc0 = dogdto.getDogOwnerIdProof();
				files[0] = doc0;
			} else {
				String doc0 = "Dog Owner Id Proof field is Required";
				condition = false;
				message.append(doc0).append(",");
			}

			if (dogdto.getDogOwnerAddressproof() != null
					&& !dogdto.getDogOwnerAddressproof().isEmpty()) {
				String doc1 = dogdto.getDogOwnerAddressproof();
				files[1] = doc1;
			} else {
				String doc1 = "Dog Owner Address Proof field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if(dogdto.getNoOfDog()>=4) {
				if(dogdto.getNocNeighbour()!=null && !dogdto.getNocNeighbour().isEmpty()) {
					files[2] = dogdto.getNocNeighbour();
				}else {
					String doc2="NOC from Neighbour's field is required";
					condition=false;
					message.append(doc2).append(",");
				}
			}
			
			if(dogdto.getNoOfDog()>=4) {
				if(dogdto.getPlaceDetail()!=null && !dogdto.getPlaceDetail().isEmpty()) {
					files[3] = dogdto.getPlaceDetail();
				}else {
					String doc3="Available Place details field is required";
					condition=false;
					message.append(doc3).append(",");
				}
			}

			
			RTIApplication rtiApplication = new RTIApplication();

			// dog details validations
			if(dogdto.getDogDetails().get(0).getDogType().equals("BreedDog")) {
			if (dogdto.getDogDetails().get(0).getAmount() == 0 || dogdto.getDogDetails().get(0).getAmount() == 0.0) {
				String amount1 = "Amount field is Required";
				condition = false;
				message.append(amount1).append(",");
			}
		}
//			if (dogdto.getDogDetails().get(0).getBatchNo() == null
//					|| dogdto.getDogDetails().get(0).getBatchNo().isEmpty()) {
//				String batch = "Batch nummber field is Required";
//				condition = false;
//				message.append(batch).append(",");
//			}
			if (dogdto.getDogDetails().get(0).getDesignation() == null || dogdto
					.getDogDetails().get(0).getDesignation().isEmpty()) {
				String desg = "Designation field is Required";
				condition = false;
				message.append(desg).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogAge() == null
					|| dogdto.getDogDetails().get(0).getDogAge().isEmpty()) {
				String age = "Dog Age field is Required";
				condition = false;
				message.append(age).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogColor() == null
					|| dogdto.getDogDetails().get(0).getDogColor().isEmpty()) {
				String color = "Dog color field is Required";
				condition = false;
				message.append(color).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogHeight() == 0) {
				String height = "Dog height field is Required";
				condition = false;
				message.append(height).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogName() == null
					|| dogdto.getDogDetails().get(0).getDogName().isEmpty()) {
				String dogname = "Dog name field is Required";
				condition = false;
				message.append(dogname).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogSubType() == null || dogdto
					.getDogDetails().get(0).getDogSubType().isEmpty()) {
				String subtype = "Dog subtype field is Required";
				condition = false;
				message.append(subtype).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogType() == null
					|| dogdto.getDogDetails().get(0).getDogType().isEmpty()) {
				String type = "Dog type field is Required";
				condition = false;
				message.append(type).append(",");
			}
			if (dogdto.getDogDetails().get(0).getFirstDoseDate() == null
					|| dogdto.getDogDetails().get(0).getFirstDoseDate()
							.isEmpty()) {
				String dose = "First Dose field is Required";
				condition = false;
				message.append(dose).append(",");
			}
			if (dogdto.getDogDetails().get(0).getSecondDoseDate() == null
					|| dogdto.getDogDetails().get(0).getSecondDoseDate()
							.isEmpty()) {
				String dose = "Current/Second Dose Date field is Required";
				condition = false;
				message.append(dose).append(",");
			}
			if (dogdto.getDogDetails().get(0).getGender() == null
					|| dogdto.getDogDetails().get(0).getGender().isEmpty()) {
				String gender = " Dog gender field is Required";
				condition = false;
				message.append(gender).append(",");
			}

			

				if (dogdto.getDogDetails().get(0).getOperated() == null
						|| dogdto.getDogDetails().get(0).getOperated()
								.isEmpty()) {
					String operated = "Operated field is Required";
					condition = false;
					message.append(operated).append(",");
				}
			
				String operatedfile = null;
				
				//Operated Document 
				//if (dogdto.getDogDetails().get(0).getDogType().equals("IndianDog")&& 
						if (dogdto.getDogDetails().get(0).getOperated().equals("Operated")) {

					if(dogdto.getOperatedPdf()!=null && !dogdto.getOperatedPdf().isEmpty()) {
					 operatedfile = dogdto.getOperatedPdf();
				}else {
					
					String operatedpdf = "Operated Document is Required";
					condition = false;
					message.append(operatedpdf).append(",");
				}
					
				}
				//end
			
				

			if (dogdto.getDogDetails().get(0).getSurgeonName() == null || dogdto
					.getDogDetails().get(0).getSurgeonName().isEmpty()) {
				String surgeon = "Surgeon name field is Required";
				condition = false;
				message.append(surgeon).append(",");
			}
			if (dogdto.getDogDetails().get(0).getVaccineName() == null || dogdto
					.getDogDetails().get(0).getVaccineName().isEmpty()) {
				String vaccine = "Vaccine name field is Required";
				condition = false;
				message.append(vaccine).append(",");
			}
			if (dogdto.getDogDetails().get(0).getDogTailLength() == 0) {
				String length = "Tail length field is Required";
				condition = false;
				message.append(length).append(",");
			}

			if (dogdto.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(
						String.valueOf(dogdto.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			

			if (dogdto.getNoOfDog() >0) {
				dog.setNoOfDog(dogdto.getNoOfDog());
			} else {
				String noofDog = "No Of Dog is required";
				condition = false;
				message.append(noofDog).append(",");
			}
			
			
			// save files method
						String savedFilePath = DogLicenseRestController.saveFile(files, request);
						String savedVaccinationFilePath = DogLicenseRestController
								.saveVaccinationFile(vaccinationfiles,
										request);
						String savedOperatedFilePath = DogLicenseRestController
								.saveOperatedFile(operatedfile, request);

						dog.setDogFiles(savedVaccinationFilePath);
						dog.setDogOpertedFiles(savedOperatedFilePath);
						
			//Dog Image
		    if(dogdto.getDogDetails().get(0).getDogImage()!=null && !dogdto.getDogDetails().get(0).getDogImage().isEmpty()) {
		    	 dogImage = dogdto.getDogDetails().get(0).getDogImage();
		    }else {
		    	String dogIamge= "Dog Image is required";
		    	message.append(dogIamge).append(",");
		    }
		    

						
			if (condition) {
				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("DOGLICENCE-CERTIFICATE");
				rtiApplication.setTemplateName("dogLicense");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(3);
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setApplicantName(dog.getName());
				rtiApplication.setPhoneNumber(dog.getMobileNumber());
				rtiApplication.setMobileNumber(dog.getMobileNumber());
				rtiApplication.setEmail(dog.getEmailId());
				rtiApplication.setZone(dog.getZoneNo());
				// rtiApplication.setUserRegistrationDetails(user);
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
					rti.setRtiApplnNumber(
							"RTS/SWM/"+savedRti.getRtiApplicationId()+"/"+Year.now());
					dog.setRtiapplrefno(rti.getRtiApplnNumber());
					dog.setRti_ref_id(savedRti.getRtiApplicationId());
					long dogId = dogLicenceCertificateService
							.saveDogLicenceCertificate(dog);
					dog.setDogId(dogId);
					rti.setRtiApplicationRefId(dogId);
					dogLicenseRestDTO = dogdto.getDogDetails();
					amount = dogdto.getDogDetails().get(0).getAmount();
					for (DogDetailsRestDTO dogdetails : dogLicenseRestDTO) {
						DogDetails dogdetails2 = new DogDetails();
						dogdetails2.setAmount(dogdetails.getAmount());
						dogdetails2.setBatchNo(dogdetails.getBatchNo());
						dogdetails2.setDesignation(dogdetails.getDesignation());
						dogdetails2.setDogAge(dogdetails.getDogAge());
						dogdetails2.setDogColor(dogdetails.getDogColor());
						dogdetails2.setDogHeight(dogdetails.getDogHeight());
						dogdetails2.setDogLicenseCertificate(dog);
						dogdetails2.setDogName(dogdetails.getDogName());
						dogdetails2.setDogSubType(dogdetails.getDogSubType());
						dogdetails2.setDogTailLength(
								dogdetails.getDogTailLength());
						dogdetails2.setDogType(dogdetails.getDogType());
						dogdetails2.setFirstDoseDate(
								dogdetails.getFirstDoseDate());
						dogdetails2.setGender(dogdetails.getGender());
						dogdetails2.setOperated(dogdetails.getOperated());
						dogdetails2.setSecondDoseDate(
								dogdetails.getSecondDoseDate());
						dogdetails2.setSurgeonName(dogdetails.getSurgeonName());
						dogdetails2.setVaccineName(dogdetails.getVaccineName());
					    String dogImagePath = saveDogImage(dogImage,request);
						dogdetails2.setDogImagefiles(dogImagePath);
						dogdetails1.add(dogdetails2);

						if (dogdetails2 != null) {
							dogdetails2.setDogLicenseCertificate(dog);
							dogDetailsService.saveDogDetails(dogdetails2);
						}
					}
					rtiApplication.setApplicationCost(amount);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (dogId > 0)) {
						dogdto.setResponseStatus(
								"Requested data saved successfully");
						dogdto.setOperatedPdf("");
						dogdto.setFirstVaccinationCertificate("");
						dogdto.setSecondVaccinationCertificate("");
						dogdto.setDogOwnerIdProof("");
						dogdto.setDogOwnerAddressproof("");
						dogdto.getDogDetails().get(0).setDogImage("");
						dogdto.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						dogdto.setResult(retunRti.getRtiApplnNumber());
						dogdto.setStatus("ok");
					}

					String name = dog.getFirstName() + " " + dog.getMiddleName()
							+ " " + dog.getLastName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();
					String msg = "Dear " + name
							+ " your application with Application No. "
							+ applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(dog.getEmailId(),
							"Application Submitted Successfully" + applnNo,
							msg);
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov",
							dog.getMobileNumber(), msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					dogdto.setResult(message.toString());
					dogdto.setResponseStatus(
							"Requested data not saved successfully");
					dogdto.setOperatedPdf("");
					dogdto.setFirstVaccinationCertificate("");
					dogdto.setSecondVaccinationCertificate("");
					dogdto.setDogOwnerIdProof("");
					dogdto.setDogOwnerAddressproof("");
					dogdto.getDogDetails().get(0).setDogImage("");
					dogdto.setResponseCode(
							HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					dogdto.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			dogdto.setResponseStatus(ex.getMessage());
			dogdto.setOperatedPdf("");
			dogdto.setFirstVaccinationCertificate("");
			dogdto.setSecondVaccinationCertificate("");
			dogdto.setDogOwnerIdProof("");
			dogdto.setDogOwnerAddressproof("");
			dogdto.getDogDetails().get(0).setDogImage("");
			dogdto.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			dogdto.setStatus("Method not Allowed");
		}

		return dogdto;

	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "dogLicence";
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

	public static String saveVaccinationFile(String data[], HttpServletRequest request)
			throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "dogDetails";
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

	public static String saveOperatedFile(String data, HttpServletRequest request)
			throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir =  CoreConstants.UPLOAD_PATH + "dogDetailsOperated";
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			byte[] pdfBytes = Base64.getDecoder().decode(data);
			String fileName;
			String uniqueFileName = UUID.randomUUID().toString().substring(0, 8)
					+ ".pdf";
			int l = uniqueFileName.lastIndexOf(".");
			String imageext = uniqueFileName.substring(l,
					uniqueFileName.length());
			fileName = uniqueFileName.substring(0, l);
			fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
			fileName = fileName.replaceAll("\\W", "");
			fileName = fileName + "" + imageext;
			File storeFile = new File(baseDir, fileName);
			try (FileOutputStream outputStream = new FileOutputStream(
					storeFile)) {
				outputStream.write(pdfBytes);
				outputStream.flush();
				outputStream.close();

			}

			filesPath = baseDir + File.separator + fileName;

			filesPathBuilder.append(filesPath).append(",");

		} else {
			filesPathBuilder.append(",");
		}
		if (filesPathBuilder != null) {
			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
			}
			filesPath = filesPathBuilder.toString();
		}
		return filesPath;
	}
	
	public String saveDogImage(String data, HttpServletRequest request)
			throws IOException {
		
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir =  CoreConstants.UPLOAD_PATH+ "dogDetails";
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			byte[] pdfBytes = Base64.getDecoder().decode(data);
			String fileName;
			String uniqueFileName = UUID.randomUUID().toString().substring(0, 8)
					+ ".jpg";
			int l = uniqueFileName.lastIndexOf(".");
			String imageext = uniqueFileName.substring(l,
					uniqueFileName.length());
			fileName = uniqueFileName.substring(0, l);
			fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
			fileName = fileName.replaceAll("\\W", "");
			fileName = fileName + "" + imageext;
			File storeFile = new File(baseDir, fileName);
			try (FileOutputStream outputStream = new FileOutputStream(
					storeFile)) {
				outputStream.write(pdfBytes);
				outputStream.flush();
				outputStream.close();

			}

			filesPath = baseDir + File.separator + fileName;


			filesPathBuilder.append(filesPath).append(",");

		} else {
			filesPathBuilder.append(",");
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
