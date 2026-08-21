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

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TreeCutingService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TreeCutingRestDTO;

@Controller
public class TreeCutingRestController{

	private static Log log = LogFactory.getLog(TreeCutingRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TreeCutingService treeCutingService;



	@RequestMapping(method = RequestMethod.POST, value = "/saveTreeCutingApplication")
	public @ResponseBody TreeCutingRestDTO saveTreeCutingApplication(
			@RequestBody TreeCutingRestDTO treeCutingRestDTO, HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];
		UserRegistrationDetails user = new UserRegistrationDetails();
		
		if (log.isDebugEnabled()) {
			log.debug("Invoking save Tree Cuting");
		}
		TreeCuting treeCuting = new TreeCuting();

		try {
			if (treeCutingRestDTO.getTitle() != null && !treeCutingRestDTO.getTitle().isEmpty()) {
				treeCuting.setTitle(treeCutingRestDTO.getTitle());
			} else {
				String title  = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			
			if (treeCutingRestDTO.getName() != null && !treeCutingRestDTO.getName().isEmpty()) {
				treeCuting.setFirstName(treeCutingRestDTO.getName());
				
			} else {
				String name = "Name field is Required";
				condition = false;
				message.append(name).append(",");
			}
			
			treeCuting.setMiddlename(treeCutingRestDTO.getFatherName());

			if (treeCutingRestDTO.getSurname() != null && !treeCutingRestDTO.getSurname().isEmpty()) {
				treeCuting.setLastname(treeCutingRestDTO.getSurname());
			} else {
				String surname = "Surname field is Required";
				condition = false;
				message.append(surname).append(",");
			}
			
			if (treeCutingRestDTO.getFullName() != null && !treeCutingRestDTO.getFullName().isEmpty()) {
				treeCuting.setFullName(treeCutingRestDTO.getFullName());

			} else {
				String fullname = "Full Name field is Required";
				condition = false;
				message.append(fullname).append(",");
			}	
			
			treeCuting.setAadharNo(treeCutingRestDTO.getAadharNo());
			
			if (treeCutingRestDTO.getEmail() != null && !treeCutingRestDTO.getEmail().isEmpty()) {
				treeCuting.setEmail(treeCutingRestDTO.getEmail());

			} else {
				String Email = "Email  field is Required";
				condition = false;
				message.append(Email).append(",");
			}
			
			if (treeCutingRestDTO.getMobileNo() != 0) {
				treeCuting.setMobileNo(String.valueOf(treeCutingRestDTO.getMobileNo()));

			} else {
				String mobileNo = "mobileNo field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			if (treeCutingRestDTO.getApplicantPlotNo() != null && !treeCutingRestDTO.getApplicantPlotNo().isEmpty()) {
				treeCuting.setApplicantPlotNo(treeCutingRestDTO.getApplicantPlotNo());

			} else {
				String applicantPlotNo = "applicantPlotNo  field is Required";
				condition = false;
				message.append(applicantPlotNo).append(",");
			}
			
			
			treeCuting.setApplicantBuildingName(treeCutingRestDTO.getApplicantBuildingName());
			
			if (treeCutingRestDTO.getApplicantStreetName() != null && !treeCutingRestDTO.getApplicantStreetName().isEmpty()) {
				treeCuting.setApplicantStreetName(treeCutingRestDTO.getApplicantStreetName());

			} else {
				String applicantStreetName = "applicantStreetName  field is Required";
				condition = false;
				message.append(applicantStreetName).append(",");
			}
			
			if (treeCutingRestDTO.getAreaName() != null && !treeCutingRestDTO.getAreaName().isEmpty()) {
				treeCuting.setAreaName(treeCutingRestDTO.getAreaName());

			} else {
				String areaName = "areaName field is Required";
				condition = false;
				message.append(areaName).append(",");
			}
			
			if (treeCutingRestDTO.getApplicantcity() != null && !treeCutingRestDTO.getApplicantcity().isEmpty()) {
				treeCuting.setApplicantcity(treeCutingRestDTO.getApplicantcity());

			} else {
				String applicantcity = "applicantcity field is Required";
				condition = false;
				message.append(applicantcity).append(",");
			}
			
			treeCuting.setLandmark(treeCutingRestDTO.getLandmark());

			
			
			
			if (treeCutingRestDTO.getPincode() != 0) {
				treeCuting.setPincode(String.valueOf(treeCutingRestDTO.getPincode()));

			} else {
				String pinCode = "pin code field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			
					
			if (treeCutingRestDTO.getAddress() != null && !treeCutingRestDTO.getAddress().isEmpty()) {
			treeCuting.setAddress(treeCutingRestDTO.getAddress());

			} else {
				String addrees = "addrees field is Required";
				condition = false;
				message.append(addrees).append(",");
			}

			if (treeCutingRestDTO.getZoneNo() != 0) {
				treeCuting.setZoneNo(String.valueOf(treeCutingRestDTO.getZoneNo()));

			} else {
				String zoneNo = "zone no field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			
			if (treeCutingRestDTO.getTreecutingreason() != null &&! treeCutingRestDTO.getTreecutingreason().isEmpty()) {
				treeCuting.setResonetreecuting(treeCutingRestDTO.getTreecutingreason());

			} else {
				String treecutingreason = "treecutingreason field is Required";
				condition = false;
				message.append(treecutingreason).append(",");
			}
			
			if (treeCutingRestDTO.getNumberoftreecuting() != null &&! treeCutingRestDTO.getNumberoftreecuting().isEmpty()) {
				treeCuting.setNumberoftreecuting(treeCutingRestDTO.getNumberoftreecuting());

			} else {
				String numberoftreecuting = "numberoftreecuting field is Required";
				condition = false;
				message.append(numberoftreecuting).append(",");
			}
			
			if (treeCutingRestDTO.getLocationOfTree() != null &&! treeCutingRestDTO.getLocationOfTree().isEmpty()) {
				treeCuting.setLocationofTree(treeCutingRestDTO.getLocationOfTree());

			} else {
				String locationOfTree= "locationOfTree field is Required";
				condition = false;
				message.append(locationOfTree).append(",");
			}
			
			if (treeCutingRestDTO.getDetailedTreeAddress() != null &&! treeCutingRestDTO.getDetailedTreeAddress().isEmpty()) {
				treeCuting.setTreeAddress(treeCutingRestDTO.getDetailedTreeAddress());

			} else {
				String treeAddress= "treeAddress field is Required";
				condition = false;
				message.append(treeAddress	).append(",");
			}
			
			
      
			// file Uplode
			
			if ( treeCutingRestDTO.getApplicantIdPDF()!= null && !treeCutingRestDTO.getApplicantIdPDF().isEmpty()) {
				String doc0 = treeCutingRestDTO.getApplicantIdPDF();
				files[0] = doc0;
			} else {
				String doc0 = "applicantIdPDF field is Required";
				condition = false;
				message.append(doc0).append(",");
			}
			
			String doc1 = treeCutingRestDTO.getSanctionedPlanPDF();					
			files[1] = doc1;
			
			if (treeCutingRestDTO.getTreePhotoPDF()!= null && !treeCutingRestDTO.getTreePhotoPDF().isEmpty()) {
				String doc2 = treeCutingRestDTO.getTreePhotoPDF();

				files[2] = doc2;
			} else {
				String doc2 = " treePhotoPDF is required";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (treeCutingRestDTO.getNoObjectionCertificatePDF()!= null && !treeCutingRestDTO.getNoObjectionCertificatePDF().isEmpty()) {
				String doc3 = treeCutingRestDTO.getNoObjectionCertificatePDF();

				files[3] = doc3;
			} else {
				String doc3 = "noObjectionCertificatePDF field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			String doc4 = treeCutingRestDTO.getAnyOtherDocPDF();					
			files[4] = doc4;
						
					
			RTIApplication rtiApplication = new RTIApplication();
			String savedFilePath = TreeCutingRestController.saveFile(files, request);
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TREE-CUTTING");
				rtiApplication.setDepartment("GARDEN-DEPARTMENT");
				rtiApplication.setTemplateName("garden");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(73);
				rtiApplication.setApplicantName(treeCuting.getFullName());
				rtiApplication.setPhoneNumber(treeCuting.getMobileNo());
				rtiApplication.setMobileNumber(treeCuting.getMobileNo());
				
				if (treeCutingRestDTO.getMobileUserNo() != 0) {
					rtiApplication.setMobileAppUserNumber(String.valueOf(treeCutingRestDTO.getMobileUserNo()));
				} else {
					String userMobilenumber = "User Mobile Number field is Required";
					condition = false;
					message.append(userMobilenumber).append(",");
				}
				//rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseCancellationRestDTO.getMobileUserNo()));
				rtiApplication.setEmail(treeCutingRestDTO.getEmail());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setZone(String.valueOf(treeCutingRestDTO.getZoneNo()));

				//rtiApplication.setApplicationCost(treeCutingRestDTO.getFee);

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
					rti.setRtiApplnNumber("RTS/GD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					treeCuting.setRtiapplrefno(rti.getRtiApplnNumber());
					treeCuting.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = treeCutingService.treeCuting(treeCuting);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						treeCutingRestDTO.setResponseStatus("Requested data saved successfully");
						treeCutingRestDTO.setResult(retunRti.getRtiApplnNumber());
						treeCutingRestDTO.setResponseCode(200);
						treeCutingRestDTO.setStatus("ok");
						treeCutingRestDTO.setApplicantIdPDF("");
						treeCutingRestDTO.setSanctionedPlanPDF("");
						treeCutingRestDTO.setTreePhotoPDF("");
						treeCutingRestDTO.setNoObjectionCertificatePDF("");
						treeCutingRestDTO.setAnyOtherDocPDF("");
					}
					String name = treeCuting.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = treeCuting.getMobileNo();
					String email=treeCuting.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
			
				}
			}

			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					treeCutingRestDTO.setResult(message.toString());
					treeCutingRestDTO.setResponseStatus("Requested data not saved successfully");
					treeCutingRestDTO.setResponseCode(500);
					treeCutingRestDTO.setStatus("Internal Server Error");
					treeCutingRestDTO.setApplicantIdPDF("");
					treeCutingRestDTO.setSanctionedPlanPDF("");
					treeCutingRestDTO.setTreePhotoPDF("");
					treeCutingRestDTO.setNoObjectionCertificatePDF("");
					treeCutingRestDTO.setAnyOtherDocPDF("");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			treeCutingRestDTO.setResponseStatus("Data fields are Empty");
			treeCutingRestDTO.setResponseCode(405);
			treeCutingRestDTO.setStatus("Method not Allowed");
			treeCutingRestDTO.setApplicantIdPDF("");
			treeCutingRestDTO.setSanctionedPlanPDF("");
			treeCutingRestDTO.setTreePhotoPDF("");
			treeCutingRestDTO.setNoObjectionCertificatePDF("");
			treeCutingRestDTO.setAnyOtherDocPDF("");
		}
		return treeCutingRestDTO;
	}

	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "TreeCuting";
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
