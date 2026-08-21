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
import com.mars.rti.model.TreeTrimming;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TreeTrimmingService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TreeTrimmingRestDTO;

@Controller
public class TreeTrimmingRestController{

	private static Log log = LogFactory.getLog(TreeTrimmingRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private TreeTrimmingService treeTrimmingService;



	@RequestMapping(method = RequestMethod.POST, value = "/saveTreeTrimmingApplication")
	public @ResponseBody TreeTrimmingRestDTO saveTreeTrimmingApplication(
			@RequestBody TreeTrimmingRestDTO treeTrimmingRestDTO, HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[5];
		UserRegistrationDetails user = new UserRegistrationDetails();
		
		if (log.isDebugEnabled()) {
			log.debug("Invoking save Tree Trimming");
		}
		TreeTrimming treeTrimming = new TreeTrimming();

		try {
			if (treeTrimmingRestDTO.getTitle() != null && !treeTrimmingRestDTO.getTitle().isEmpty()) {
				treeTrimming.setTitle(treeTrimmingRestDTO.getTitle());
			} else {
				String title  = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			
			if (treeTrimmingRestDTO.getName() != null && !treeTrimmingRestDTO.getName().isEmpty()) {
				treeTrimming.setFirstName(treeTrimmingRestDTO.getName());
				
			} else {
				String name = "name field is Required";
				condition = false;
				message.append(name).append(",");
			}
			
			treeTrimming.setMiddlename(treeTrimmingRestDTO.getFatherName());

			if (treeTrimmingRestDTO.getSurname() != null && !treeTrimmingRestDTO.getSurname().isEmpty()) {
				treeTrimming.setLastname(treeTrimmingRestDTO.getSurname());
			} else {
				String surname = "Surname field is Required";
				condition = false;
				message.append(surname).append(",");
			}
			
			if (treeTrimmingRestDTO.getFullName() != null && !treeTrimmingRestDTO.getFullName().isEmpty()) {
				treeTrimming.setFullName(treeTrimmingRestDTO.getFullName());

			} else {
				String fullname = "Full Name field is Required";
				condition = false;
				message.append(fullname).append(",");
			}	
			
			treeTrimming.setAadharNo(treeTrimmingRestDTO.getAadharNo());
			
			if (treeTrimmingRestDTO.getEmail() != null && !treeTrimmingRestDTO.getEmail().isEmpty()) {
				treeTrimming.setEmail(treeTrimmingRestDTO.getEmail());

			} else {
				String Email = "Email  field is Required";
				condition = false;
				message.append(Email).append(",");
			}
			
			if (treeTrimmingRestDTO.getMobileNo() != 0) {
				treeTrimming.setMobileNo(String.valueOf(treeTrimmingRestDTO.getMobileNo()));

			} else {
				String mobileNo = "mobileNo field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			if (treeTrimmingRestDTO.getApplicantPlotNo() != null && !treeTrimmingRestDTO.getApplicantPlotNo().isEmpty()) {
				treeTrimming.setApplicantPlotNo(treeTrimmingRestDTO.getApplicantPlotNo());

			} else {
				String applicantPlotNo = "applicantPlotNo  field is Required";
				condition = false;
				message.append(applicantPlotNo).append(",");
			}
			
			
			treeTrimming.setApplicantBuildingName(treeTrimmingRestDTO.getApplicantBuildingName());
			
			if (treeTrimmingRestDTO.getApplicantStreetName() != null && !treeTrimmingRestDTO.getApplicantStreetName().isEmpty()) {
				treeTrimming.setApplicantStreetName(treeTrimmingRestDTO.getApplicantStreetName());

			} else {
				String applicantStreetName = "applicantStreetName  field is Required";
				condition = false;
				message.append(applicantStreetName).append(",");
			}
			
			if (treeTrimmingRestDTO.getAreaName() != null && !treeTrimmingRestDTO.getAreaName().isEmpty()) {
				treeTrimming.setAreaName(treeTrimmingRestDTO.getAreaName());

			} else {
				String areaName = "areaName field is Required";
				condition = false;
				message.append(areaName).append(",");
			}
			
			if (treeTrimmingRestDTO.getApplicantcity() != null && !treeTrimmingRestDTO.getApplicantcity().isEmpty()) {
				treeTrimming.setApplicantcity(treeTrimmingRestDTO.getApplicantcity());

			} else {
				String applicantcity = "applicantcity field is Required";
				condition = false;
				message.append(applicantcity).append(",");
			}
			
			treeTrimming.setLandmark(treeTrimmingRestDTO.getLandmark());

			
			
			
			if (treeTrimmingRestDTO.getPincode() != 0) {
				treeTrimming.setPincode(String.valueOf(treeTrimmingRestDTO.getPincode()));

			} else {
				String pinCode = "pin code field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
			
					
			if (treeTrimmingRestDTO.getAddress() != null && !treeTrimmingRestDTO.getAddress().isEmpty()) {
			treeTrimming.setAddress(treeTrimmingRestDTO.getAddress());

			} else {
				String addrees = "addrees field is Required";
				condition = false;
				message.append(addrees).append(",");
			}

			if (treeTrimmingRestDTO.getZoneNo() != 0) {
				treeTrimming.setZoneNo(String.valueOf(treeTrimmingRestDTO.getZoneNo()));

			} else {
				String zoneNo = "zone no field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			
			if (treeTrimmingRestDTO.getTreetrimmingreason() != null &&! treeTrimmingRestDTO.getTreetrimmingreason().isEmpty()) {
				treeTrimming.setResonetreetrimming(treeTrimmingRestDTO.getTreetrimmingreason());

			} else {
				String treetrimmingreason = "treetrimmingreason field is Required";
				condition = false;
				message.append(treetrimmingreason).append(",");
			}
			
			if (treeTrimmingRestDTO.getNumberoftreetrimming() != null &&! treeTrimmingRestDTO.getNumberoftreetrimming().isEmpty()) {
				treeTrimming.setNumberoftreetrimming(treeTrimmingRestDTO.getNumberoftreetrimming());

			} else {
				String numberoftreetrimming = "numberoftreetrimming field is Required";
				condition = false;
				message.append(numberoftreetrimming).append(",");
			}
			
			if (treeTrimmingRestDTO.getLocationOfTree() != null &&! treeTrimmingRestDTO.getLocationOfTree().isEmpty()) {
				treeTrimming.setLocationofTree(treeTrimmingRestDTO.getLocationOfTree());

			} else {
				String locationOfTree= "locationOfTree field is Required";
				condition = false;
				message.append(locationOfTree).append(",");
			}
			
			if (treeTrimmingRestDTO.getDetailedTreeAddress() != null &&! treeTrimmingRestDTO.getDetailedTreeAddress().isEmpty()) {
				treeTrimming.setTreeAddress(treeTrimmingRestDTO.getDetailedTreeAddress());

			} else {
				String locationOfTree= "locationOfTree field is Required";
				condition = false;
				message.append(locationOfTree).append(",");
			}
			
			
      
			// file Uplode
			
			if ( treeTrimmingRestDTO.getApplicantIdPDF()!= null && !treeTrimmingRestDTO.getApplicantIdPDF().isEmpty()) {
				String doc0 = treeTrimmingRestDTO.getApplicantIdPDF();
				files[0] = doc0;
			} else {
				String doc0 = "applicantIdPDF field is Required";
				condition = false;
				message.append(doc0).append(",");
			}
			
			String doc1 = treeTrimmingRestDTO.getSanctionedPlanPDF();					
			files[1] = doc1;
			
			if (treeTrimmingRestDTO.getTreePhotoPDF()!= null && !treeTrimmingRestDTO.getTreePhotoPDF().isEmpty()) {
				String doc2 = treeTrimmingRestDTO.getTreePhotoPDF();

				files[2] = doc2;
			} else {
				String doc2 = " treePhotoPDF is required";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (treeTrimmingRestDTO.getNoObjectionCertificatePDF()!= null && !treeTrimmingRestDTO.getNoObjectionCertificatePDF().isEmpty()) {
				String doc3 = treeTrimmingRestDTO.getNoObjectionCertificatePDF();

				files[3] = doc3;
			} else {
				String doc3 = "noObjectionCertificatePDF field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			String doc4 = treeTrimmingRestDTO.getAnyOtherDocPDF();					
			files[4] = doc4;
			RTIApplication rtiApplication = new RTIApplication();
//			if (tradeLicenseCancellationRestDTO.getFilesPath() != null
//					&& !tradeLicenseCancellationRestDTO.getFilesPath().isEmpty()) {
//				rtiApplication.setPdfFilesSavedPath(tradeLicenseCancellationRestDTO.getFilesPath());
//			} else {
//				String pdf = "PdfFilesSavedPath field is Required";
//				condition = false;
//				message.append(pdf).append(",");
//			}
			
			String savedFilePath = TreeTrimmingRestController
					.saveFile(files, request);
			if (treeTrimmingRestDTO.getMobileUserNo() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(treeTrimmingRestDTO.getMobileUserNo()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				
				rtiApplication.setSubject("TREE-TRIMMING");
				rtiApplication.setDepartment("GARDEN-DEPARTMENT");
				rtiApplication.setTemplateName("garden");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(75);
				
				rtiApplication.setApplicantName(treeTrimming.getFullName());
				rtiApplication.setPhoneNumber(treeTrimming.getMobileNo());
				rtiApplication.setMobileNumber(treeTrimming.getMobileNo());
				
				
				//rtiApplication.setMobileAppUserNumber(String.valueOf(tradeLicenseCancellationRestDTO.getMobileUserNo()));
				rtiApplication.setEmail(treeTrimmingRestDTO.getEmail());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);
				rtiApplication.setZone(String.valueOf(treeTrimmingRestDTO.getZoneNo()));

				//rtiApplication.setApplicationCost(treeTrimmingRestDTO.getFee);

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
					treeTrimming.setRtiapplrefno(rti.getRtiApplnNumber());
					treeTrimming.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = treeTrimmingService.treeTrimming(treeTrimming);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						treeTrimmingRestDTO.setResponseStatus("Requested data saved successfully");
						treeTrimmingRestDTO.setResult(retunRti.getRtiApplnNumber());
						treeTrimmingRestDTO.setResponseCode(200);
						treeTrimmingRestDTO.setStatus("ok");
						treeTrimmingRestDTO.setApplicantIdPDF("");
						treeTrimmingRestDTO.setSanctionedPlanPDF("");
						treeTrimmingRestDTO.setTreePhotoPDF("");
						treeTrimmingRestDTO.setNoObjectionCertificatePDF("");
						treeTrimmingRestDTO.setAnyOtherDocPDF("");
						
						
					}
					String name = treeTrimming.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = treeTrimming.getMobileNo();
					String email=treeTrimming.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
			
				}
			}

			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					treeTrimmingRestDTO.setResult(message.toString());
					treeTrimmingRestDTO.setResponseStatus("Requested data not saved successfully");
					treeTrimmingRestDTO.setResponseCode(500);
					treeTrimmingRestDTO.setStatus("Internal Server Error");
					treeTrimmingRestDTO.setApplicantIdPDF("");
					treeTrimmingRestDTO.setSanctionedPlanPDF("");
					treeTrimmingRestDTO.setTreePhotoPDF("");
					treeTrimmingRestDTO.setNoObjectionCertificatePDF("");
					treeTrimmingRestDTO.setAnyOtherDocPDF("");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			treeTrimmingRestDTO.setResponseStatus("Data fields are Empty");
			treeTrimmingRestDTO.setResponseCode(405);
			treeTrimmingRestDTO.setStatus("Method not Allowed");
			treeTrimmingRestDTO.setApplicantIdPDF("");
			treeTrimmingRestDTO.setSanctionedPlanPDF("");
			treeTrimmingRestDTO.setTreePhotoPDF("");
			treeTrimmingRestDTO.setNoObjectionCertificatePDF("");
			treeTrimmingRestDTO.setAnyOtherDocPDF("");
		}
		return treeTrimmingRestDTO;
	}


	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "TreeTrimmingApplication";
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
