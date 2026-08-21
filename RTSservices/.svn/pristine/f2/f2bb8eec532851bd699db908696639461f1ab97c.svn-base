
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.FireRecommendationLatterRestDTO;
@Controller
public class FireRecommendationLatterRestController {

	private static Log log = LogFactory
			.getLog(FireRecommendationLatterRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private FireRecommendationService fireRecommendationService;


	@RequestMapping(method = RequestMethod.POST, value = "/saveFireRecommendattionApplication")
	public @ResponseBody FireRecommendationLatterRestDTO saveFireRecommendattionApplication(
			@RequestBody FireRecommendationLatterRestDTO fireRecommendationLatterRestDTO,
			HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException {
		boolean condition = true;

		StringBuilder message = new StringBuilder();
		String[] files = new String[6];

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveFireRecommendationApplication");
		}
		FireRecommendation fireRecommendation = new FireRecommendation();

		try {
			if (fireRecommendationLatterRestDTO.getFirstName() != null
					&& !fireRecommendationLatterRestDTO.getFirstName()
							.isEmpty()) {
				fireRecommendation.setFirstName(
						fireRecommendationLatterRestDTO.getFirstName());;
			} else {
				String firstName = "First Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if (fireRecommendationLatterRestDTO.getMiddleName() != null
					&& !fireRecommendationLatterRestDTO.getMiddleName()
							.isEmpty()) {
				fireRecommendation.setMiddleName(
						fireRecommendationLatterRestDTO.getMiddleName());
			} else {
				String middleName = "Middle Name field is Required";
				condition = false;
				message.append(middleName).append(",");
			}
			if (fireRecommendationLatterRestDTO.getTitle() != null
					&& !fireRecommendationLatterRestDTO.getTitle().isEmpty()) {
				fireRecommendation
						.setTitle(fireRecommendationLatterRestDTO.getTitle());;
			} else {
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			if (fireRecommendationLatterRestDTO.getLastName() != null
					&& !fireRecommendationLatterRestDTO.getLastName()
							.isEmpty()) {
				fireRecommendation.setLastName(
						fireRecommendationLatterRestDTO.getLastName());;
			} else {
				String lastName = "Last Name field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			if (fireRecommendationLatterRestDTO.getPlotNumber() != null
					&& !fireRecommendationLatterRestDTO.getPlotNumber()
							.isEmpty()) {
				fireRecommendation.setPlotNumber(
						fireRecommendationLatterRestDTO.getPlotNumber());;
			} else {
				String plotNo = " plot no field is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			if (fireRecommendationLatterRestDTO.getStreetName() != null
					&& !fireRecommendationLatterRestDTO.getStreetName()
							.isEmpty()) {
				fireRecommendation.setStreetName(
						fireRecommendationLatterRestDTO.getStreetName());
			} else {
				String streetName = "street name field is Required";
				condition = false;
				message.append(streetName).append(",");
			}

			if (fireRecommendationLatterRestDTO.getHouseNo() != 0) {
				fireRecommendation.setHouseNo(String.valueOf(
						fireRecommendationLatterRestDTO.getHouseNo()));
			} else {
				String houseNo = "House No field is Required";
				condition = false;
				message.append(houseNo).append(",");
			}
			if (fireRecommendationLatterRestDTO.getPinCode() != null
					&& !fireRecommendationLatterRestDTO.getPinCode()
							.isEmpty()) {
				fireRecommendation.setPinCode(
						fireRecommendationLatterRestDTO.getPinCode());
			} else {
				String pinCode = " pin code field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			if (fireRecommendationLatterRestDTO.getMobileNo() != null
					&& !fireRecommendationLatterRestDTO.getMobileNo()
							.isEmpty()) {
				fireRecommendation.setMobileNo(
						fireRecommendationLatterRestDTO.getMobileNo());
			} else {
				String mobileNo = " mobile No field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			if (fireRecommendationLatterRestDTO.getAppEmail() != null
					&& !fireRecommendationLatterRestDTO.getAppEmail()
							.isEmpty()) {
				fireRecommendation.setAppEmail(
						fireRecommendationLatterRestDTO.getAppEmail());
			} else {
				String appEmail = " Email field is Required";
				condition = false;
				message.append(appEmail).append(",");
			}
			if (fireRecommendationLatterRestDTO
					.getAddressOfPowerAttorney() != null
					&& !fireRecommendationLatterRestDTO
							.getAddressOfPowerAttorney().isEmpty()) {
				fireRecommendation.setAddressOfPowerAttorney(
						fireRecommendationLatterRestDTO
								.getAddressOfPowerAttorney());
			} else {
				String adreesAttorney = " Address of power Attorney field is Required";
				condition = false;
				message.append(adreesAttorney).append(",");
			}
			if (fireRecommendationLatterRestDTO.getHightOfBuilding() != null
					&& !fireRecommendationLatterRestDTO.getHightOfBuilding()
							.isEmpty()) {
				fireRecommendation.setHightOfBuilding(
						fireRecommendationLatterRestDTO.getHightOfBuilding());
			} else {
				String hightofBuilding = " hight of building  field is Required";
				condition = false;
				message.append(hightofBuilding).append(",");
			}
			if (fireRecommendationLatterRestDTO.getFloors() != null
					&& !fireRecommendationLatterRestDTO.getFloors().isEmpty()) {

				fireRecommendation
						.setFloors(fireRecommendationLatterRestDTO.getFloors());
			} else {

				String floor = " floor field is Required";
				condition = false;
				message.append(floor).append(",");
			}
			if (fireRecommendationLatterRestDTO.getBuilding() != null
					&& !fireRecommendationLatterRestDTO.getBuilding()
							.isEmpty()) {
				fireRecommendation.setTypeOfBuilding(fireRecommendationLatterRestDTO.getBuilding());
			} else {
				String building = "Building field is Required";
				condition = false;
				message.append(building).append(",");
			}
			if (fireRecommendationLatterRestDTO.getSubtype() != null
					&& !fireRecommendationLatterRestDTO.getSubtype()
							.isEmpty()) {
				fireRecommendation.setTypeOfHeight(fireRecommendationLatterRestDTO.getSubtype());
			} else {
				String subType = " sub type field is Required";
				condition = false;
				message.append(subType).append(",");
			}
			if (fireRecommendationLatterRestDTO.getSubtype1() != null
					&& !fireRecommendationLatterRestDTO.getSubtype1()
							.isEmpty()) {
				fireRecommendation.setTypeOfConstruction(fireRecommendationLatterRestDTO.getSubtype1());
			} else {
				String subType1 = "sub type1 field is Required";
				condition = false;
				message.append(subType1).append(",");
			}
			if (fireRecommendationLatterRestDTO.getTotalPlotArea() != null
					&& !fireRecommendationLatterRestDTO.getTotalPlotArea()
							.isEmpty()) {
				fireRecommendation.setTotalPlotArea(
						fireRecommendationLatterRestDTO.getTotalPlotArea());
			} else {
				String totalPlotArea = " plot area  field is Required";
				condition = false;
				message.append(totalPlotArea).append(",");
			}

			if (fireRecommendationLatterRestDTO.getBuildUpArea() != null
					&& !fireRecommendationLatterRestDTO.getBuildUpArea()
							.isEmpty()) {
				fireRecommendationLatterRestDTO.setBuildUpArea(
						fireRecommendationLatterRestDTO.getBuildUpArea());
			} else {
				String buildUpArea = " Build Up areafield is Required";
				condition = false;
				message.append(buildUpArea).append(",");
			}
			if (fireRecommendationLatterRestDTO.getSuperbuildarea() != null
					&& !fireRecommendationLatterRestDTO.getSuperbuildarea()
							.isEmpty()) {
				fireRecommendation.setSuperBuildUpArea(
						fireRecommendationLatterRestDTO.getSuperbuildarea());
			} else {
				String superbuildUpArea = "super Build Up areafield is Required";
				condition = false;
				message.append(superbuildUpArea).append(",");
			}
			if (fireRecommendationLatterRestDTO.getPresentPosition() != null
					&& !fireRecommendationLatterRestDTO.getPresentPosition()
							.isEmpty()) {
				fireRecommendation.setPresentPosition(
						fireRecommendationLatterRestDTO.getPresentPosition());
			} else {
				String presentPosition = "present position field is Required";
				condition = false;
				message.append(presentPosition).append(",");
			}
			if (fireRecommendationLatterRestDTO.getNumberOfExternal() != null
					&& !fireRecommendationLatterRestDTO.getNumberOfExternal()
							.isEmpty()) {
				fireRecommendation.setNumberOfExternal(
						fireRecommendationLatterRestDTO.getNumberOfExternal());
			} else {
				String numberofExternal = "number of External field is Required";
				condition = false;
				message.append(numberofExternal).append(",");
			}
			if (fireRecommendationLatterRestDTO.getWidthOfExternal() != null
					&& !fireRecommendationLatterRestDTO.getWidthOfExternal()
							.isEmpty()) {
				fireRecommendation.setWidthOfExternal(
						fireRecommendationLatterRestDTO.getWidthOfExternal());
			} else {
				String widthofExternal = "width of   External field is Required";
				condition = false;
				message.append(widthofExternal).append(",");
			}
			if (fireRecommendationLatterRestDTO
					.getNumInternalStaircaseProvided() != null
					&& !fireRecommendationLatterRestDTO
							.getNumInternalStaircaseProvided().isEmpty()) {
				fireRecommendation.setNumInternalStaircaseProvided(
						fireRecommendationLatterRestDTO
								.getNumInternalStaircaseProvided());
			} else {
				String numIntStaircase = "num internal staircase field is Required";
				condition = false;
				message.append(numIntStaircase).append(",");
			}
			if (fireRecommendationLatterRestDTO
					.getWidthInternalStaircaseProvided() != null
					&& !fireRecommendationLatterRestDTO
							.getWidthInternalStaircaseProvided().isEmpty()) {
				fireRecommendation.setWidthInternalStaircaseProvided(
						fireRecommendationLatterRestDTO
								.getWidthInternalStaircaseProvided());
			} else {
				String widthIntStaircase = "width internal staircase field is Required";
				condition = false;
				message.append(widthIntStaircase).append(",");
			}
			if (fireRecommendationLatterRestDTO.getElectricPump() != null
					&& !fireRecommendationLatterRestDTO.getElectricPump()
							.isEmpty()) {
				fireRecommendation.setElectricPump(
						fireRecommendationLatterRestDTO.getElectricPump());
			} else {
				String electricPump = "electric pump field is Required";
				condition = false;
				message.append(electricPump).append(",");
			}
			if (fireRecommendationLatterRestDTO.getDieselPump() != null
					&& !fireRecommendationLatterRestDTO.getDieselPump()
							.isEmpty()) {
				fireRecommendation.setDieselPump(
						fireRecommendationLatterRestDTO.getDieselPump());
			} else {
				String dieselPump = " Diesel pump field is Required";
				condition = false;
				message.append(dieselPump).append(",");
			}

			if (fireRecommendationLatterRestDTO.getJockyPump() != null
					&& !fireRecommendationLatterRestDTO.getJockyPump()
							.isEmpty()) {
				fireRecommendation.setJockyPump(
						fireRecommendationLatterRestDTO.getJockyPump());
			} else {
				String jockypump = "jocky pump field is Required";
				condition = false;
				message.append(jockypump).append(",");
			}
			if (fireRecommendationLatterRestDTO.getBoosterPump() != null
					&& !fireRecommendationLatterRestDTO.getBoosterPump()
							.isEmpty()) {
				fireRecommendation.setBoosterPump(
						fireRecommendationLatterRestDTO.getBoosterPump());
			} else {
				String boosterPump = "Booster Pump field is Required";
				condition = false;
				message.append(boosterPump).append(",");
			}
			if (fireRecommendationLatterRestDTO.getNoOfFloors() != null
					&& !fireRecommendationLatterRestDTO.getNoOfFloors()
							.isEmpty()) {
				fireRecommendation.setNoOfFloors(
						fireRecommendationLatterRestDTO.getNoOfFloors());
			} else {
				String noFloors = "No of Floors field is Required";
				condition = false;
				message.append(noFloors).append(",");
			}
			
			if (fireRecommendationLatterRestDTO.getZone() != 0) {
				fireRecommendation.setNoOfFloors(
						fireRecommendationLatterRestDTO.getNoOfFloors());
			} else {
				String noFloors = "Zone Number  field is Required";
				condition = false;
				message.append(noFloors).append(",");
			}
			
			if (fireRecommendationLatterRestDTO
					.getScrutinyFeesOnAboveTotal() != null
					&& !fireRecommendationLatterRestDTO
							.getScrutinyFeesOnAboveTotal().isEmpty()) {
				fireRecommendation.setScrutinyFeesOnAboveTotal(
						fireRecommendationLatterRestDTO
								.getScrutinyFeesOnAboveTotal());
			} else {
				String scruntinyFees = "No of scrutiny fees  field is Required";
				condition = false;
				message.append(scruntinyFees).append(",");
			}

			if (fireRecommendationLatterRestDTO.getFireWaterTankPDF() != null
					&& !fireRecommendationLatterRestDTO.getFireWaterTankPDF()
							.isEmpty()) {
				String doc0 = fireRecommendationLatterRestDTO
						.getFireWaterTankPDF();

				files[0] = doc0;
			} else {
				String doc0 = "fire water tank certificate field is Required";
				condition = false;
				message.append(doc0).append(",");
			}

			if (fireRecommendationLatterRestDTO.getpCertificatePDF() != null
					&& !fireRecommendationLatterRestDTO.getpCertificatePDF()
							.isEmpty()) {
				String doc1 = fireRecommendationLatterRestDTO
						.getpCertificatePDF();

				files[1] = doc1;
			} else {
				String doc1 = "p certificate field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			if (fireRecommendationLatterRestDTO.getNmcTaxReceiptPDF() != null
					&& !fireRecommendationLatterRestDTO.getNmcTaxReceiptPDF()
							.isEmpty()) {
				String doc2 = fireRecommendationLatterRestDTO
						.getNmcTaxReceiptPDF();

				files[2] = doc2;
			} else {
				String doc2 = "NMC receipt field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			if (fireRecommendationLatterRestDTO
					.getExistingBuildingSanctionPlanPDF() != null
					&& !fireRecommendationLatterRestDTO
							.getExistingBuildingSanctionPlanPDF().isEmpty()) {
				String doc3 = fireRecommendationLatterRestDTO
						.getExistingBuildingSanctionPlanPDF();

				files[3] = doc3;
			} else {
				String doc3 = "Existing Building Sanction field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			if (fireRecommendationLatterRestDTO.getSetsofPraposedPDF() != null
					&& !fireRecommendationLatterRestDTO.getSetsofPraposedPDF()
							.isEmpty()) {
				String doc4 = fireRecommendationLatterRestDTO
						.getSetsofPraposedPDF();

				files[4] = doc4;
			} else {
				String doc4 = "set of praposed  field is Required";
				condition = false;
				message.append(doc4).append(",");
			}

			// Save FilesPath
			String savedFilePath = BirthCertificateRestController
					.saveFile(files, request);

			fireRecommendation.setMiddleName(
					fireRecommendationLatterRestDTO.getMiddleName());
			fireRecommendation
					.setFullName(fireRecommendationLatterRestDTO.getFullName());
			fireRecommendation
					.setSurveyNo(fireRecommendationLatterRestDTO.getSurveyNo());
			fireRecommendation
					.setLandmark(fireRecommendationLatterRestDTO.getLandmark());
			fireRecommendation.setNameOfPowerAttorney(
					fireRecommendationLatterRestDTO.getNameOfPowerAttorney());
			fireRecommendation.setNoStandby(
					fireRecommendationLatterRestDTO.getNoStandby());
			fireRecommendation.setNumberOfBuilding(
					fireRecommendationLatterRestDTO.getNumberOfBuilding());
			fireRecommendation.setNumOfWings(
					fireRecommendationLatterRestDTO.getNumOfWings());
			fireRecommendation.setFrontMarginWidth(
					fireRecommendationLatterRestDTO.getFrontMarginWidth());
			fireRecommendation.setRealMargin(
					fireRecommendationLatterRestDTO.getRealMargin());
			fireRecommendation.setSideMargine(
					fireRecommendationLatterRestDTO.getSideMargine());
			fireRecommendation.setWidthOfEntrance(
					fireRecommendationLatterRestDTO.getWidthOfEntrance());
			fireRecommendation.setHeightOfEntrance(
					fireRecommendationLatterRestDTO.getHeightOfEntrance());
			fireRecommendation
					.setNoLift(fireRecommendationLatterRestDTO.getNoLift());
			fireRecommendation.setAreaOfBasement(
					fireRecommendationLatterRestDTO.getAreaOfBasement());
			fireRecommendation.setCapacityOfUnderGroundTank(
					fireRecommendationLatterRestDTO
							.getCapacityOfUnderGroundTank());
			fireRecommendation
					.setCapacityOFOverHeadTank(fireRecommendationLatterRestDTO
							.getCapacityOFOverHeadTank());
			fireRecommendation.setFireFightingSystemNBC(
					fireRecommendationLatterRestDTO.getFireFightingSystemNBC());
			fireRecommendation
					.setLocationOfTransferRoom(fireRecommendationLatterRestDTO
							.getLocationOfTransferRoom());
			fireRecommendation.setNumStandBy(
					fireRecommendationLatterRestDTO.getNumStandBy());
			fireRecommendation
					.setAcPlant(fireRecommendationLatterRestDTO.getAcPlant());
			fireRecommendation
					.setFloors(fireRecommendationLatterRestDTO.getFloors());
			fireRecommendation.setBuildUpArea(
					fireRecommendationLatterRestDTO.getTotalBuildUpArea());
			fireRecommendation.setCommArea(
					fireRecommendationLatterRestDTO.getComm_Area());
			fireRecommendation.setResidArea(
					fireRecommendationLatterRestDTO.getResid_Area());
		
//			fireRecommendation.setPrimumAr(
//					fireRecommendationLatterRestDTO.getPrimum_ar());
//			fireRecommendation.setOtherUse(
//					fireRecommendationLatterRestDTO.getBalcony_Area());
//			fireRecommendation
//					.setTotalTable(fireRecommendationLatterRestDTO.getFree_fsi());

			RTIApplication rtiApplication = new RTIApplication();
			if (fireRecommendationLatterRestDTO.getUserMobileNo() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						fireRecommendationLatterRestDTO.getUserMobileNo()));
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
				rtiApplication.setSubject("FIRE-NOC-RENEWAL");
				rtiApplication.setDepartment("FIRE-DEPARTMENT");
				rtiApplication.setTemplateName("fire");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(11);
				rtiApplication
						.setApplicantName(fireRecommendation.getFullName());
				rtiApplication.setPhoneNumber(fireRecommendation.getMobileNo());
				rtiApplication
						.setMobileNumber(fireRecommendation.getMobileNo());
				rtiApplication.setEmail(fireRecommendation.getAppEmail());
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						fireRecommendationLatterRestDTO.getUserMobileNo()));
				rtiApplication.setZone(fireRecommendation.getZoneNO());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);

				rtiApplication
						.setApplicationCost(Double.parseDouble(fireRecommendation.getTotalFeess()));

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
					fireRecommendation.setRtiapplrefno(rti.getRtiApplnNumber());
					fireRecommendation
							.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = fireRecommendationService
							.fireRecommendation(fireRecommendation);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						fireRecommendationLatterRestDTO.setResponseStatus(
								"Requested data saved successfully");
						fireRecommendationLatterRestDTO.setResponseCode(200);
						fireRecommendationLatterRestDTO
								.setResult(retunRti.getRtiApplnNumber());
						fireRecommendationLatterRestDTO.setStatus("ok");

					}
					String name = fireRecommendation.getFirstName()
							+ fireRecommendation.getLastName()
							+ fireRecommendation.getLastName();
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name
							+ " your application with Application No. "
							+ applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(fireRecommendation.getAppEmail(),
							"Application Submitted Successfully" + applnNo,
							msg);
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov",
							fireRecommendation.getMobileNo(), msg);
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					fireRecommendationLatterRestDTO
							.setResult(message.toString());
					fireRecommendationLatterRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					fireRecommendationLatterRestDTO.setResponseCode(500);
					fireRecommendationLatterRestDTO
							.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			fireRecommendationLatterRestDTO
					.setResponseStatus("Data field are Empty");
			fireRecommendationLatterRestDTO.setResponseCode(405);
			fireRecommendationLatterRestDTO.setStatus("Method not Allowed");
		}

		return fireRecommendationLatterRestDTO;
	}

	

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "FireRecommendationLatter";
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
