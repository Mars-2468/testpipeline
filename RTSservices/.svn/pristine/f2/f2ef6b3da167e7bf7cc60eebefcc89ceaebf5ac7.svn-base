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

import com.mars.common.utils.CommonUtils;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.PropertyTaxNoDues;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxNoDuesService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PropertyTaxNoDueRestDTO;

@Controller
public class PropertyTaxnoDueRestController {
	
	private static Log log = LogFactory.getLog(PropertyTaxnoDueRestController.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxNoDuesService propertyTaxNoDuesService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/savePropertyTaxNoDues")
	public @ResponseBody PropertyTaxNoDueRestDTO savePropertyTaxNoDues(
			@RequestBody PropertyTaxNoDueRestDTO propertyTaxNoDueRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[2];
		if (log.isDebugEnabled()) {
			log.debug("Invoking PropertyTaxNoDues");
		}
		
		PropertyTaxNoDues propertyTaxNoDues = new PropertyTaxNoDues();
		
		try {

			if ((propertyTaxNoDueRestDTO.getName() != null) && !propertyTaxNoDueRestDTO.getName().isEmpty()) {
				propertyTaxNoDues.setName(propertyTaxNoDues.getName());
			} else {
				String name = "Name field is Required";
				condition = false;
				message.append(name).append(",");
			}
			
			
			if ((propertyTaxNoDueRestDTO.getEmail() != null) && !propertyTaxNoDueRestDTO.getEmail().isEmpty()) {
				propertyTaxNoDues.setEmailid(propertyTaxNoDueRestDTO.getEmail());
			} else {
				String email = "Email Id field is Required";
				condition = false;
				message.append(email).append(",");
			}
			
				propertyTaxNoDues.setAreasPending(propertyTaxNoDueRestDTO.getAreasPending());
		
			if ((propertyTaxNoDueRestDTO.getAreasPendingStatus() != null) && !propertyTaxNoDueRestDTO.getAreasPendingStatus().isEmpty()) {
				propertyTaxNoDues.setAreasPendingStatus(propertyTaxNoDueRestDTO.getAreasPendingStatus());
			} else {
				String areastatus = "Arrears Status  field is Required";
				condition = false;
				message.append(areastatus).append(",");
			}
			
			if (propertyTaxNoDueRestDTO.getDuesAmt() >0) {
				String due = "Dues amount is pending";
				condition = false;
				message.append(due).append(",");
			} else {
				propertyTaxNoDueRestDTO.setDuesAmt(propertyTaxNoDueRestDTO.getDuesAmt());

			}
			

			if (propertyTaxNoDueRestDTO.getUpinno() != null && !propertyTaxNoDueRestDTO.getUpinno().isEmpty()) {

				propertyTaxNoDues.setUpinNo(propertyTaxNoDueRestDTO.getUpinno());
				propertyTaxNoDues.setIndexNo(propertyTaxNoDueRestDTO.getIndexNo());

			} else if (propertyTaxNoDueRestDTO.getIndexNo() != null && !propertyTaxNoDueRestDTO.getIndexNo().isEmpty()) {
				propertyTaxNoDues.setIndexNo(propertyTaxNoDueRestDTO.getIndexNo());
			} else {
				String indexUpin = "UPIN/Index No. field is Required";
				condition = false;
				message.append(indexUpin).append(",");
			}
			
			
			if ((propertyTaxNoDueRestDTO.getMobileNo() != null) && !propertyTaxNoDueRestDTO.getMobileNo().isEmpty()) {
				propertyTaxNoDues.setMobileNo(propertyTaxNoDueRestDTO.getMobileNo());
			} else {
				String mobile = "  Mobile No. field is Required";
				condition = false;
				message.append(mobile).append(",");
			}
			
			
			
			if ((propertyTaxNoDueRestDTO.getTaxMobileNo() != null) && !propertyTaxNoDueRestDTO.getTaxMobileNo().isEmpty()) {
				propertyTaxNoDues.setTaxMobileNo(propertyTaxNoDueRestDTO.getTaxMobileNo());
			} else {
				String mobileNo = " Registered Mobile No. field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			
			if ((propertyTaxNoDueRestDTO.getPropertyHoldersName() != null) && !propertyTaxNoDueRestDTO.getPropertyHoldersName().isEmpty()) {
				propertyTaxNoDues.setPropertyHolderName(propertyTaxNoDueRestDTO.getPropertyHoldersName());
			} else {
				String nameOfProperyHolder = "Name Of Propery Holder  field is Required";
				condition = false;
				message.append(nameOfProperyHolder).append(",");
			}
			
			if ((propertyTaxNoDueRestDTO.getAddress() != null) && !propertyTaxNoDueRestDTO.getAddress().isEmpty()) {
				propertyTaxNoDues.setAddress(propertyTaxNoDueRestDTO.getAddress());
			} else {
				String address = "Address field is Required";
				condition = false;
				message.append(address).append(",");
			}
			
			
			if ((propertyTaxNoDueRestDTO.getBlockName() != null) && !propertyTaxNoDueRestDTO.getBlockName().isEmpty()) {
				propertyTaxNoDues.setBlockName(propertyTaxNoDueRestDTO.getBlockName());
			} else {
				String ward = " Ward Name field is Required";
				condition = false;
				message.append(ward).append(",");
			}
			
			
			if ((propertyTaxNoDueRestDTO.getBlockNo() != null) && !propertyTaxNoDueRestDTO.getBlockNo().isEmpty()) {
				propertyTaxNoDues.setBlockNo(propertyTaxNoDueRestDTO.getBlockNo());
			} else {
				String wardNo = "Ward No field is Required";
				condition = false;
				message.append(wardNo).append(",");
			}
			
			
			if (propertyTaxNoDueRestDTO.getZoneNo() >0) {
				propertyTaxNoDues.setZoneNo(String.valueOf(propertyTaxNoDueRestDTO.getZoneNo()));
			} else {
				String zone = "Zone No. field is Required";
				condition = false;
				message.append(zone).append(",");
			}
			
			
				propertyTaxNoDues.setHouseNo(propertyTaxNoDueRestDTO.getHouseNo());
			
			
			
			if ((propertyTaxNoDueRestDTO.getTaxMobileNo() != null) && !propertyTaxNoDueRestDTO.getHouseNo().isEmpty()) {
				propertyTaxNoDues.setHouseNo(propertyTaxNoDueRestDTO.getHouseNo());
			} else {
				String houseno = "House No  field is Required";
				condition = false;
				message.append(houseno).append(",");
			}
			
			if(propertyTaxNoDueRestDTO.getOwnerName()!=null && !propertyTaxNoDueRestDTO.getOwnerName().isEmpty()) {
				propertyTaxNoDues.setOwnerName(propertyTaxNoDueRestDTO.getOwnerName());
			}else {
				String ownerName = "Owner Name field is Required";
				condition = false;
				message.append(ownerName).append(",");
			}
			
			//Files
			
			if(propertyTaxNoDueRestDTO.getSelfAttestedApplicantIdproofDoc()!=null && !propertyTaxNoDueRestDTO.getSelfAttestedApplicantIdproofDoc().isEmpty()) {
				files[0]=propertyTaxNoDueRestDTO.getSelfAttestedApplicantIdproofDoc();
			}else {
				String houseno = " Self Attested Applicant's Id Proof is Required";
				condition = false;
				message.append(houseno).append(",");
			}
			
				files[1]=propertyTaxNoDueRestDTO.getAnyOtherSypportingDoc();
			
			RTIApplication rtiApplication = new RTIApplication();
			if (propertyTaxNoDueRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(propertyTaxNoDueRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
		

			if (condition) {
				String saveFilePath=PropertyTaxnoDueRestController.saveFile(files, request);
				propertyTaxNoDues.setFilesPath(saveFilePath);
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setSubject("PROPERTY-TAX-NO-DUES-CERTIFICATE");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(54);
				rtiApplication.setApplicantName(propertyTaxNoDues.getName());
				rtiApplication.setPhoneNumber(propertyTaxNoDues.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxNoDues.getMobileNo());
				rtiApplication.setEmail(propertyTaxNoDues.getEmailid());
				rtiApplication.setZone(String.valueOf(propertyTaxNoDueRestDTO.getZoneNo()));

				rtiApplication.setApplicantName(propertyTaxNoDues.getName());
				rtiApplication.setPdfUploadFromPortal(saveFilePath);
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
					rti.setRtiApplnNumber("RTS/PT" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					propertyTaxNoDues.setRtiapplrefno(rti.getRtiApplnNumber());
					propertyTaxNoDues.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxNoDuesService.propertyTaxNoDues(propertyTaxNoDues);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);
					if ((retunRti != null) && (birth_regis_id > 0)) {
					propertyTaxNoDueRestDTO.setResponseStatus("Requested data saved successfully");
					propertyTaxNoDueRestDTO.setResult(retunRti.getRtiApplnNumber());
					propertyTaxNoDueRestDTO.setResponseCode(HttpStatus.OK.value());
					response.setStatus(HttpStatus.OK.value());
					propertyTaxNoDueRestDTO.setStatus("ok");
					propertyTaxNoDueRestDTO.setSelfAttestedApplicantIdproofDoc("");
					propertyTaxNoDueRestDTO.setAnyOtherSypportingDoc("");
						String name = propertyTaxNoDues.getName();
			        	String applnNo = rti.getRtiApplnNumber();
			        	String mobileNo = propertyTaxNoDues.getMobileNo();
			        	String email=propertyTaxNoDues.getEmailid();
			        	SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
			}
			
			}	
			
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					propertyTaxNoDueRestDTO.setResult(message.toString());
					propertyTaxNoDueRestDTO.setResponseStatus("Requested data not saved successfully");
					propertyTaxNoDueRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					propertyTaxNoDueRestDTO.setStatus("Internal Server Error");
					propertyTaxNoDueRestDTO.setSelfAttestedApplicantIdproofDoc("");
					propertyTaxNoDueRestDTO.setAnyOtherSypportingDoc("");
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			propertyTaxNoDueRestDTO.setResponseStatus(ex.getMessage());
			propertyTaxNoDueRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			propertyTaxNoDueRestDTO.setStatus("Method not Allowed");
			propertyTaxNoDueRestDTO.setSelfAttestedApplicantIdproofDoc("");
			propertyTaxNoDueRestDTO.setAnyOtherSypportingDoc("");
		}
		return propertyTaxNoDueRestDTO;
	}
	
	

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "propertyTaxNoDues";
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
					String url = CoreConstants.UPLOAD_PATH;
					filesPath = url + "propertyTaxNoDues" + File.separator + fileName;
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

	
