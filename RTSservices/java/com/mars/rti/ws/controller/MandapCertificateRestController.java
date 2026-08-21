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

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.MandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MandapPermissionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MandapPermissionCertficateRestDTO;

@Controller
public class MandapCertificateRestController {
	
	
	private static Log log = LogFactory.getLog(MandapCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private MandapPermissionService mandapPermissionService;
	
	@RequestMapping(method = RequestMethod.POST, value ="/saveMandapApplication")
	public @ResponseBody MandapPermissionCertficateRestDTO saveMandapApplication(
		   @RequestBody MandapPermissionCertficateRestDTO mandapPermissionCertficateRestDTO,HttpServletRequest request,HttpServletResponse reponse) throws ServletException{

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[3];

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMandapApplication");
		}
		MandapPermission mandapPermission = new MandapPermission();

		try {
			
			if(mandapPermissionCertficateRestDTO.getApplicantTitle()!=null && !mandapPermissionCertficateRestDTO.getApplicantTitle().isEmpty()) {
				mandapPermission.setTitle(mandapPermissionCertficateRestDTO.getApplicantTitle());
			}
			else
			{
				String applicantTitle = "applicantTitle field is Required";
				condition = false;
				message.append(applicantTitle).append(",");
			}
			
			if(mandapPermissionCertficateRestDTO.getApplicantFirstName()!=null && !mandapPermissionCertficateRestDTO.getApplicantFirstName().isEmpty()) {
				mandapPermission.setFirstName(mandapPermissionCertficateRestDTO.getApplicantFirstName());
			}
			else
			{
				String applicantFirstName = "applicantFirstName field is Required";
				condition = false;
				message.append(applicantFirstName).append(",");
			}
//			if(mandapPermissionCertficateRestDTO.getApplicantMiddleName()!=null && mandapPermissionCertficateRestDTO.getApplicantMiddleName().isEmpty()) {
				mandapPermission.setMiddleName(mandapPermissionCertficateRestDTO.getApplicantMiddleName());
//			}
//			else
//			{
//				String middleName = "MiddleName field is Required";
//				condition = false;
//				message.append(middleName).append(",");
//			}
			if(mandapPermissionCertficateRestDTO.getApplicantLastName()!=null && !mandapPermissionCertficateRestDTO.getApplicantLastName().isEmpty()) {
				mandapPermission.setLastName(mandapPermissionCertficateRestDTO.getApplicantLastName());
			}
			else
			{
				String applicantLastName = "applicantLastName field is Required";
				condition = false;
				message.append(applicantLastName).append(",");
			}
			
			if(mandapPermissionCertficateRestDTO.getApplicantFullName()!=null && !mandapPermissionCertficateRestDTO.getApplicantFullName().isEmpty()) {
				mandapPermission.setFullName(mandapPermissionCertficateRestDTO.getApplicantFullName());
			}
			else
			{
				String applicantFullName = "applicantFullName field is Required";
				condition = false;
				message.append(applicantFullName).append(",");
			}
			
			
			if(mandapPermissionCertficateRestDTO.getApplicantPinCode()!= 0) {
				mandapPermission.setPinCode(mandapPermissionCertficateRestDTO.getApplicantPinCode());
			}
			else
			{
				String applicantPinCode = "applicantPinCode field is Required";
				condition = false;
				message.append(applicantPinCode).append(",");
			}
//			if(mandapPermissionCertficateRestDTO.getApplicantAadhaar()!=null && !mandapPermissionCertficateRestDTO.getApplicantAadhaar().isEmpty()) {
				mandapPermission.setAadharNo(mandapPermissionCertficateRestDTO.getApplicantAadhaar());
//			}
//			else
//			{
//				String adhaar = "Adhaar field is Required";
//				condition = false;
//				message.append(adhaar).append(",");
//			}
			if(mandapPermissionCertficateRestDTO.getApplicantemail()!=null && !mandapPermissionCertficateRestDTO.getApplicantemail().isEmpty()) {
				mandapPermission.setEmail(mandapPermissionCertficateRestDTO.getApplicantemail());
			}
			else
			{
				String applicantemail = "applicantemail field is Required";
				condition = false;
				message.append(applicantemail).append(",");
			}
			
			if(mandapPermissionCertficateRestDTO.getApplicantmobileno()!= 0) {
				mandapPermission.setMobileNo(String.valueOf(mandapPermissionCertficateRestDTO.getApplicantmobileno()));
			}
			else
			{
				String applicantmobileno = "applicantmobileno Number field is Required";
				condition = false;
				message.append(applicantmobileno).append(",");
			}
			
			if(mandapPermissionCertficateRestDTO.getApplicantaddress()!=null && !mandapPermissionCertficateRestDTO.getApplicantaddress().isEmpty()) {
				mandapPermission.setAddress(mandapPermissionCertficateRestDTO.getApplicantaddress());
			}
			else
			{
				String applicantaddress = "applicantaddress field is Required";
				condition = false;
				message.append(applicantaddress).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantzone()!= 0) {
				mandapPermission.setZoneNo(String.valueOf(mandapPermissionCertficateRestDTO.getApplicantzone()));
			}
			else
			{
				String applicantzone = "applicantzone Number field is Required";
				condition = false;
				message.append(applicantzone).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantward()!=null && !mandapPermissionCertficateRestDTO.getApplicantward().isEmpty()) {
				mandapPermission.setWardNo(mandapPermissionCertficateRestDTO.getApplicantward());
			}
			else
			{
				String applicantward = "applicantward Number field is Required";
				condition = false;
				message.append(applicantward).append(",");
			}
			
//			if (birthCertificateRestDTO.getPlaceofbirth().equals("OutOfIndia")) {
//				if (birthCertificateRestDTO.getCountryName() != null&& !birthCertificateRestDTO.getCountryName().isEmpty()) {
//				birthCertificate.setCountryName(birthCertificateRestDTO.getCountryName());
//
//				} else {
//					String countryName = "Country Name field is Required";
//					condition = false;
//					message.append(countryName).append(",");
//				}
//			}else if(birthCertificateRestDTO.getPlaceofbirth().equals("Home") || birthCertificateRestDTO.getPlaceofbirth().equals("Hospital")) {
//				birthCertificate.setCountryName(birthCertificateRestDTO.getCountryName());
//
//			}
	
		
			if(mandapPermissionCertficateRestDTO.getApplicantPurpose()!=null && !mandapPermissionCertficateRestDTO.getApplicantPurpose().isEmpty()) {
				mandapPermission.setPurpose(mandapPermissionCertficateRestDTO.getApplicantPurpose());
			}
			else
			{
				String applicantPurpose = "applicantPurpose field is Required";
				condition = false;
				message.append(applicantPurpose).append(",");
			}
		
			
			if(mandapPermissionCertficateRestDTO.getApplicantDateOfEvent()!=null && !mandapPermissionCertficateRestDTO.getApplicantDateOfEvent().isEmpty()) {
				mandapPermission.setEventDate(mandapPermissionCertficateRestDTO.getApplicantDateOfEvent());
			}
			else
			{
				String applicantDateOfEvent = "applicantDateOfEvent Of Event field is Required";
				condition = false;
				message.append(applicantDateOfEvent).append(",");
			}
			
			if("Exhibitions (प्रदर्शने)".equals(mandapPermissionCertficateRestDTO.getApplicantPurpose())) {
				if(mandapPermissionCertficateRestDTO.getApplicantExhibition()!=null && !mandapPermissionCertficateRestDTO.getApplicantExhibition().isEmpty()) {
				}
				else
				{
					String applicantExhibition = "applicantExhibition field is Required";
					condition = false;
					message.append(applicantExhibition).append(",");
				}
			}
			
			if(mandapPermissionCertficateRestDTO.getApplicantDurationStartdate()!=null && !mandapPermissionCertficateRestDTO.getApplicantDurationStartdate().isEmpty()) {
				mandapPermission.setPavilionStartDate(mandapPermissionCertficateRestDTO.getApplicantDurationStartdate());
			}
			else
			{
				String applicantDurationStartdate = "applicantDurationStartdate field is Required";
				condition = false;
				message.append(applicantDurationStartdate).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantDurationEnddate()!=null && !mandapPermissionCertficateRestDTO.getApplicantDurationEnddate().isEmpty()) {
				mandapPermission.setPavilionEndDate(mandapPermissionCertficateRestDTO.getApplicantDurationEnddate());
			}
			else
			{
				String durationEndDate = "applicantDurationEnddate field is Required";
				condition = false;
				message.append(durationEndDate).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantreasonForPavillion()!=null && !mandapPermissionCertficateRestDTO.getApplicantreasonForPavillion().isEmpty()) {
				mandapPermission.setReasonForCertificate(mandapPermissionCertficateRestDTO.getApplicantreasonForPavillion());
			}
			else
			{
				String applicantreasonForPavillion = "applicantreasonForPavillion field is Required";
				condition = false;
				message.append(applicantreasonForPavillion).append(",");
			}			
			if(mandapPermissionCertficateRestDTO.getApplicantpavillionlength()!=null && !mandapPermissionCertficateRestDTO.getApplicantpavillionlength().isEmpty()) {
				mandapPermission.setPavilionLength(mandapPermissionCertficateRestDTO.getApplicantpavillionlength());
			}
			else
			{
				String applicantpavillionlength = "applicantpavillionlength field is Required";
				condition = false;
				message.append(applicantpavillionlength).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantpavillionBreadth()!=null && !mandapPermissionCertficateRestDTO.getApplicantpavillionBreadth().isEmpty()) {
				mandapPermission.setPavilionBreadth(mandapPermissionCertficateRestDTO.getApplicantpavillionBreadth());
			}
			else
			{
				String applicantpavillionBreadth = "applicantpavillionBreadth field is Required";
				condition = false;
				message.append(applicantpavillionBreadth).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantpavillionfessTotalsize()!=null && !mandapPermissionCertficateRestDTO.getApplicantpavillionfessTotalsize().isEmpty()) {
				mandapPermission.setTotalSize(mandapPermissionCertficateRestDTO.getApplicantpavillionfessTotalsize());
			}
			else
			{
				String applicantpavillionfessTotalsize = "applicantpavillionfessTotalsize field is Required";
				condition = false;
				message.append(applicantpavillionfessTotalsize).append(",");
			}
			if(mandapPermissionCertficateRestDTO.getApplicantpavillionfessFeesApplicable()!= 0) {
				mandapPermission.setFees(mandapPermissionCertficateRestDTO.getApplicantpavillionfessFeesApplicable());
			}
			else
			{
				String applicantpavillionfessFeesApplicable = "applicantpavillionfessFeesApplicable field is Required";
				condition = false;
				message.append(applicantpavillionfessFeesApplicable).append(",");
			}
			//Files
			if (mandapPermissionCertficateRestDTO.getNocFromPoliceDepartment() != null
					&& !mandapPermissionCertficateRestDTO.getNocFromPoliceDepartment()
							.isEmpty()) {
				String doc1 = mandapPermissionCertficateRestDTO
						.getNocFromPoliceDepartment();

				files[0] = doc1;
			} else {
				String doc1 = "NOC From Police Department field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (mandapPermissionCertficateRestDTO.getNocFromTrafficDepartment() != null
					&& !mandapPermissionCertficateRestDTO.getNocFromTrafficDepartment()
							.isEmpty()) {
				String doc3 = mandapPermissionCertficateRestDTO
						.getNocFromTrafficDepartment();

				files[1] = doc3;
			} else {
				String doc3 = "NOC Traffic Police Department  field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (mandapPermissionCertficateRestDTO.getNocFromFireDepartment() != null
					&& !mandapPermissionCertficateRestDTO.getNocFromFireDepartment()
							.isEmpty()) {
				String doc2 = mandapPermissionCertficateRestDTO
						.getNocFromFireDepartment();

				files[2] = doc2;
			} else {
				String doc2 = "NOC Fire Police Department  field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			
			// Save FilesPath
						String savedFilePath = MandapCertificateRestController
								.saveFile(files, request);

//			UserRegistrationDetails user = new UserRegistrationDetails();
//			user.setMobileNo(mandapPermissionCertficateRestDTO.getApplicantmobileno());

			RTIApplication rtiApplication = new RTIApplication();
//			MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
			if (mandapPermissionCertficateRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						mandapPermissionCertficateRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "userMobilenumber field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}

			if(condition) {
			rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("MANDAP-CERTIFICATE");
			rtiApplication.setTemplateName("mandapPermission");
			rtiApplication.setDepartment("ESTATE-DEPARTMENT");

			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(23);
			//rtiApplication.setUserRegistrationDetails(user);
			rtiApplication.setApplicantName(mandapPermission.getFirstName() + " " + mandapPermission.getMiddleName()
					+ " " + mandapPermission.getLastName());
			rtiApplication.setPhoneNumber(mandapPermission.getMobileNo());
			rtiApplication.setMobileNumber(mandapPermission.getMobileNo());
			rtiApplication.setZone("2");
			rtiApplication.setEmail(mandapPermission.getEmail());
			rtiApplication.setZone(mandapPermission.getZoneNo());

			rtiApplication.setApplicationCost(mandapPermission.getFees());

			rtiApplication.setApplicantName(mandapPermission.getFullName());
			rtiApplication.setPdfUploadFromPortal(savedFilePath);
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
				rti.setRtiApplnNumber("RTS/ED"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
				mandapPermission.setRtiapplrefno(rti.getRtiApplnNumber());
				mandapPermission.setRti_ref_id(savedRti.getRtiApplicationId());
				long mandap_regis_id = mandapPermissionService.mandapPermission(mandapPermission);
				rti.setRtiApplicationRefId(mandap_regis_id);
				// rti.setRtiApplicationRefId(birthRegistrationService.);
				RTIApplication retunRti = rtiApplicationService.merge(rti);
                   

				if ((retunRti != null) && (mandap_regis_id > 0)) {
					mandapPermissionCertficateRestDTO.setResponseStatus("Requested data saved successfully");
					mandapPermissionCertficateRestDTO.setResponseCode(200);
					mandapPermissionCertficateRestDTO.setResult(retunRti.getRtiApplnNumber());
					mandapPermissionCertficateRestDTO.setStatus("ok");
					reponse.setStatus(HttpStatus.OK.value());
					mandapPermissionCertficateRestDTO.setNocFromFireDepartment("");
					mandapPermissionCertficateRestDTO.setNocFromPoliceDepartment("");
					mandapPermissionCertficateRestDTO.setNocFromTrafficDepartment("");
					
				}
				String name = mandapPermission.getFullName();
				String applnNo = retunRti.getRtiApplnNumber();
               String mobileNo = retunRti.getPhoneNumber();
               String email = retunRti.getEmail();
				SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

			}
		}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						mandapPermissionCertficateRestDTO.setResult(message.toString());
						mandapPermissionCertficateRestDTO.setResponseStatus("Requested data not saved successfully");
						mandapPermissionCertficateRestDTO.setResponseCode(500);
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						mandapPermissionCertficateRestDTO.setStatus("Internal Server Error");
						mandapPermissionCertficateRestDTO.setNocFromFireDepartment("");
						mandapPermissionCertficateRestDTO.setNocFromPoliceDepartment("");
						mandapPermissionCertficateRestDTO.setNocFromTrafficDepartment("");
					}
				}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			mandapPermissionCertficateRestDTO.setResponseStatus(ex.getMessage());
			mandapPermissionCertficateRestDTO.setResponseCode(405);
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			mandapPermissionCertficateRestDTO.setStatus("Method not Allowed");
			mandapPermissionCertficateRestDTO.setNocFromFireDepartment("");
			mandapPermissionCertficateRestDTO.setNocFromPoliceDepartment("");
			mandapPermissionCertficateRestDTO.setNocFromTrafficDepartment("");
		}


		return mandapPermissionCertficateRestDTO; 
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "mandapPermission";
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
