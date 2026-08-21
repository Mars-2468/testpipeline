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
import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.NewWaterConnectionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.NewWaterConnectionRestDTO;


@Controller
public class NewWaterConnectionRestController {

	private static Log log = LogFactory.getLog(NewWaterConnectionRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private NewWaterConnectionService newWaterConnectionService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveNewWaterConnection")
	public @ResponseBody NewWaterConnectionRestDTO saveNewWaterConnectionAPI(
			@RequestBody NewWaterConnectionRestDTO newWaterConnectionRestDTO, HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[13];
		UserRegistrationDetails user = new UserRegistrationDetails();
		boolean categoryCI=false;

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveNewConnectionApplication");
		}
		NewWaterConnection newwaterConnection = new NewWaterConnection();
		try {
			
			if (newWaterConnectionRestDTO.getTitle() != null
					&& !newWaterConnectionRestDTO.getTitle().isEmpty()) {
		newwaterConnection.setTitle(newWaterConnectionRestDTO.getTitle());
				
			} else {
				String Title = "Title field is Required";
				condition = false;
				message.append(Title).append(",");
			}
			
			if (newWaterConnectionRestDTO.getName() != null
					&& !newWaterConnectionRestDTO.getName().isEmpty()) {
			newwaterConnection.setFirstName(newWaterConnectionRestDTO.getName());
			
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			newwaterConnection.setMiddleName(newWaterConnectionRestDTO.getFatherName());

			
			if (newWaterConnectionRestDTO.getSurname() != null
					&& !newWaterConnectionRestDTO.getSurname().isEmpty()) {
				newwaterConnection.setLastName(newWaterConnectionRestDTO.getSurname());
			} else {
				String lastName = "Surname field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
		
				newwaterConnection.setFullName(newWaterConnectionRestDTO.getFullName());
		
			if (newWaterConnectionRestDTO.getPinCode() != 0
					&& !String.valueOf(newWaterConnectionRestDTO.getPinCode()).isEmpty()) {
				newwaterConnection.setPinCode(String.valueOf(newWaterConnectionRestDTO.getPinCode()));

			} else {
				String PinCode = "Pin Code field is Required";
				condition = false;
				message.append(PinCode).append(",");
			}
			

			if (newWaterConnectionRestDTO.getEmail() != null
					&& !newWaterConnectionRestDTO.getEmail().isEmpty()) {
				newwaterConnection.setEmail(newWaterConnectionRestDTO.getEmail());

			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if (newWaterConnectionRestDTO.getMobileNo() != 0) {
				
					newwaterConnection.setMobileNo(newWaterConnectionRestDTO.getMobileNo());

			} else {
				String mobileNo = "Mobile No. field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			if (newWaterConnectionRestDTO.getAddress() != null
					&& !newWaterConnectionRestDTO.getAddress().isEmpty()) {
         newwaterConnection.setAddress(newWaterConnectionRestDTO.getAddress());

			} else {
				String Address = "Address field is Required";
				condition = false;
				message.append(Address).append(",");
			}
			
			if (newWaterConnectionRestDTO.getPlotNo() != null
					&& !newWaterConnectionRestDTO.getPlotNo().isEmpty()) {
         newwaterConnection.setPlotNo(newWaterConnectionRestDTO.getPlotNo());

			} else {
				String plotNo = "plotNo field is Required";
				condition = false;
				message.append(plotNo).append(",");
			}
			
         newwaterConnection.setBuildingName(newWaterConnectionRestDTO.getBuildingName());

			if (newWaterConnectionRestDTO.getLayoutName() != null && ! newWaterConnectionRestDTO.getLayoutName().isEmpty()) {
				newwaterConnection.setLayoutName(newWaterConnectionRestDTO.getLayoutName());

			} else {
				String layoutName = "Layout name field is Required";
				condition = false;
				message.append(layoutName).append(",");
			}
			
			newwaterConnection.setRoadName(newWaterConnectionRestDTO.getRoadName());

		  
				newwaterConnection.setLandmark(newWaterConnectionRestDTO.getLandmark());
				
				if(newWaterConnectionRestDTO.getCity()!=null && !newWaterConnectionRestDTO.getCity().isEmpty()) {
				newwaterConnection.setCity(newWaterConnectionRestDTO.getCity());
				}else {
					String city = "City field is Required";
					condition = false;
					message.append(city).append(",");
				}
				

			
			if (newWaterConnectionRestDTO.getZoneNo() != 0) {
				newwaterConnection.setZoneNo(String.valueOf(newWaterConnectionRestDTO.getZoneNo()));

			} else {
				String zoneNo = "zoneNo field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			
			if(newWaterConnectionRestDTO.getAlternateMobileNo()>0) {
				newwaterConnection.setAlterMobileNo(String.valueOf(newWaterConnectionRestDTO.getAlternateMobileNo()));
			}else {
				String alternateMobileNo = "Alternate Mobile No. field is Required";
				condition = false;
				message.append(alternateMobileNo).append(",");
			}
			
			

			if(newWaterConnectionRestDTO.getPurposeOfWater()!=null && !newWaterConnectionRestDTO.getPurposeOfWater().isEmpty()) {
				newwaterConnection.setPurposeOfWater(newWaterConnectionRestDTO.getPurposeOfWater());
			}else {
				String purposeOfWater = "Purpose Of Water field is Required";
				condition = false;
				message.append(purposeOfWater).append(",");
			}
			
			//Purpose Of Water Conditions
			
			//common docs
			
			//--files upto 3 
			
			if(newWaterConnectionRestDTO.getApplicantIdProofPDF()!=null && !newWaterConnectionRestDTO.getApplicantIdProofPDF().isEmpty()) {
				files[0]=newWaterConnectionRestDTO.getApplicantIdProofPDF();
			}else {
				String app = "Self-Attested Applicant's ID Proof(Aadhaar/PAN/Driving License/Passport) is Required";
				condition = false;
				message.append(app).append(",");	
			}
			
			if(!newWaterConnectionRestDTO.getPurposeOfWater().equals("INSTITUTIONAL") && !newWaterConnectionRestDTO.getPurposeOfWater().equals("RESIDENTIAL")) {
			if(newWaterConnectionRestDTO.getCopyOfTaxReceiptPDF()!=null && !newWaterConnectionRestDTO.getCopyOfTaxReceiptPDF().isEmpty()) {
				files[1]=newWaterConnectionRestDTO.getCopyOfTaxReceiptPDF();
			}else {
				String cotrp = "Copy Of Tax Receipt is Required";
				condition = false;
				message.append(cotrp).append(",");	
			}
			
			}else{
				files[1]=newWaterConnectionRestDTO.getCopyOfTaxReceiptPDF();
			}
			
			
			if(newWaterConnectionRestDTO.getPhotographsPDF()!=null && !newWaterConnectionRestDTO.getPhotographsPDF().isEmpty()) {
				files[2]=newWaterConnectionRestDTO.getPhotographsPDF();
			}else {
				String pp = "Photographs(Passport Size) is Required";
				condition = false;
				message.append(pp).append(",");	
			}
			
			
			
			
			
			//RESIDENTIAL
			if(newWaterConnectionRestDTO.getPurposeOfWater().equals("RESIDENTIAL")) {
				
				if(newWaterConnectionRestDTO.getResidentialTapSize()!=null && !newWaterConnectionRestDTO.getResidentialTapSize().isEmpty()) {
				newwaterConnection.setTapSize(newWaterConnectionRestDTO.getResidentialTapSize());
				}else {
					String tapSize = "Tap Size field is Required";
					condition = false;
					message.append(tapSize).append(",");	
				}
				
				//doc
				if(newWaterConnectionRestDTO.getCopyOfTaxReceiptresidentialPDF()!=null && !newWaterConnectionRestDTO.getCopyOfTaxReceiptresidentialPDF().isEmpty()) {
				
					files[3]= newWaterConnectionRestDTO.getCopyOfTaxReceiptresidentialPDF();
				}else {
					String copyOfReceipt = "Copy Of Tax Receipt/Rent Agreement/Consent Letter of Owner is Required";
					condition = false;
					message.append(copyOfReceipt).append(",");
				}
				
				if(newWaterConnectionRestDTO.getRegistrySaleDeedResidentialPDF()!=null && !newWaterConnectionRestDTO.getRegistrySaleDeedResidentialPDF().isEmpty()) {
					files[4]=newWaterConnectionRestDTO.getRegistrySaleDeedResidentialPDF();
				}else {
					String residentialSaledeed = "Registry/Sale/Lease Deed is Required";
					condition = false;
					message.append(residentialSaledeed).append(",");
				}
				
				
				//SLUM
			}else if(newWaterConnectionRestDTO.getPurposeOfWater().equals("SLUM")){
              	
				if(newWaterConnectionRestDTO.getSlum()!=null && !newWaterConnectionRestDTO.getSlum().isEmpty()) {
					newwaterConnection.setSlum(newWaterConnectionRestDTO.getSlum());
				}else {
					String slum = "Slum filed is Required";
					condition = false;
					message.append(slum).append(",");
				}
				
				
				//doc
				files[5]=newWaterConnectionRestDTO.getSlumCertificatePDF();

				//FLAT_SCHEME
			}else if(newWaterConnectionRestDTO.getPurposeOfWater().equals("FLAT_SCHEME")) {
				
				if(newWaterConnectionRestDTO.getTotalNoOfPlots()!=null && !newWaterConnectionRestDTO.getTotalNoOfPlots().isEmpty()) {
				newWaterConnectionRestDTO.setTotalNoOfPlots(newWaterConnectionRestDTO.getTotalNoOfPlots());
				}else {
					String totalNoOfFlats = "Total number of Flats filed is Required";
					condition = false;
					message.append(totalNoOfFlats).append(",");
				}
				
				//doc
				
				files[6]=newWaterConnectionRestDTO.getRegistrySaleDeedOfFlatSchemePDF();

				
				if(newWaterConnectionRestDTO.getConsonentLetterPDF()!=null && !newWaterConnectionRestDTO.getConsonentLetterPDF().isEmpty()) {
					files[7]=newWaterConnectionRestDTO.getConsonentLetterPDF();
				}else {
					String col = "Consent Letter From Flat Owners/Builder Application(Details of Flats) is Required";
					condition = false;
					message.append(col).append(",");
				}
				
				files[8]=newWaterConnectionRestDTO.getDodPDF();

				
				if(newWaterConnectionRestDTO.getBuildingSanactionPlanPDF()!=null && !newWaterConnectionRestDTO.getBuildingSanactionPlanPDF().isEmpty()) {
					files[9]=newWaterConnectionRestDTO.getBuildingSanactionPlanPDF();
				}else {
					String bspp = "NMC/NIT Building Sanction Plan is Required";
					condition = false;
					message.append(bspp).append(",");
				}
				
				if(newWaterConnectionRestDTO.getArchitectCompletionCertificatePDF()!=null && !newWaterConnectionRestDTO.getArchitectCompletionCertificatePDF().isEmpty()) {
					files[10]=newWaterConnectionRestDTO.getArchitectCompletionCertificatePDF();
				}else {
					String acap = "Architect Completion Certificate is Required";
					condition = false;
					message.append(acap).append(",");
				}
				
				//INSTITUTIONAL
			}else if(newWaterConnectionRestDTO.getPurposeOfWater().equals("INSTITUTIONAL")) {
				
				if(newWaterConnectionRestDTO.getCategoryOfInstitutional()!=null && !newWaterConnectionRestDTO.getCategoryOfInstitutional().isEmpty()) {
					newwaterConnection.setInstCategory(newWaterConnectionRestDTO.getCategoryOfInstitutional());
				}else {
					String coi = "Proposed Category for Institutional field is Required";
					condition = false;
					message.append(coi).append(",");
				}
				
				//doc
				categoryCI=true;
				
				
				//COMMERCIAL
			}else if(newWaterConnectionRestDTO.getPurposeOfWater().equals("COMMERCIAL")) {
				if(newWaterConnectionRestDTO.getCategoryOfCommercial()!=null && !newWaterConnectionRestDTO.getCategoryOfCommercial().isEmpty()) {
				newwaterConnection.setCommCategory(newWaterConnectionRestDTO.getCategoryOfCommercial());
				}else {
					String coc = "Proposed Category for Commercial field is Required";
					condition = false;
					message.append(coc).append(",");
				}
				
				//doc
				categoryCI=true;
			}
			
			//INSTITUTUIONAL && COMMERICAIL DOCS
			if(categoryCI) {
				if(newWaterConnectionRestDTO.getRegistrySaleDeedOfInstitutuionalPDF()!=null && !newWaterConnectionRestDTO.getRegistrySaleDeedOfInstitutuionalPDF().isEmpty()) {
					files[11]=newWaterConnectionRestDTO.getRegistrySaleDeedOfInstitutuionalPDF();
				}else {
					String rsdoi = "Registry/Sale Deed/Agreement of Rent/Consent Letter of Owner is Required";
					condition = false;
					message.append(rsdoi).append(",");
				}
				
				if(newWaterConnectionRestDTO.getGumastaLicensePDF()!=null && !newWaterConnectionRestDTO.getGumastaLicensePDF().isEmpty()) {
					files[12]=newWaterConnectionRestDTO.getGumastaLicensePDF();
				}else {
					String glp = "Gumasta License/Licenses For Running Business is Required";
					condition = false;
					message.append(glp).append(",");
				}
			}
			
			RTIApplication rtiApplication = new RTIApplication();

			if (newWaterConnectionRestDTO.getMobileUserNo() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(newWaterConnectionRestDTO.getMobileUserNo()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}
			String savedFilePath = NewWaterConnectionRestController.saveFile(files, request);
			if (condition) {
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("NEW-WATER-CONNECTION");
				rtiApplication.setTemplateName("WaternewConnectionApplication");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(48);
				rtiApplication.setApplicantName(newwaterConnection.getFullName());
				rtiApplication.setPhoneNumber(String.valueOf(newwaterConnection.getMobileNo()));
				rtiApplication.setMobileNumber(String.valueOf(newwaterConnection.getMobileNo()));
				
				
				rtiApplication.setMobileAppUserNumber(String.valueOf(newWaterConnectionRestDTO.getMobileUserNo()));
				rtiApplication.setEmail(newwaterConnection.getEmail());
				rtiApplication.setPdfUploadFromPortal(savedFilePath);

				rtiApplication.setZone(newwaterConnection.getZoneNo());

			//	rtiApplication.setApplicationCost(newwaterConnection.getFees);

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
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					newwaterConnection.setRtiapplrefno(rti.getRtiApplnNumber());
					//-------
					newwaterConnection.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = newWaterConnectionService.newWaterConnection(newwaterConnection);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						newWaterConnectionRestDTO.setResponseStatus("Requested data saved successfully");
						newWaterConnectionRestDTO.setResult(retunRti.getRtiApplnNumber());
						newWaterConnectionRestDTO.setResponseCode(HttpStatus.OK.value());
						reponse.setStatus(HttpStatus.OK.value());
						newWaterConnectionRestDTO.setStatus("ok");
						newWaterConnectionRestDTO.setApplicantIdProofPDF("");
						newWaterConnectionRestDTO.setCopyOfTaxReceiptPDF("");
						newWaterConnectionRestDTO.setPhotographsPDF("");
						newWaterConnectionRestDTO.setCopyOfTaxReceiptresidentialPDF("");
						newWaterConnectionRestDTO.setRegistrySaleDeedResidentialPDF("");
						newWaterConnectionRestDTO.setSlumCertificatePDF("");
						newWaterConnectionRestDTO.setRegistrySaleDeedOfFlatSchemePDF("");
						newWaterConnectionRestDTO.setConsonentLetterPDF("");
						newWaterConnectionRestDTO.setDodPDF("");
						newWaterConnectionRestDTO.setBuildingSanactionPlanPDF("");
						newWaterConnectionRestDTO.setArchitectCompletionCertificatePDF("");
						newWaterConnectionRestDTO.setRegistrySaleDeedOfInstitutuionalPDF("");
						newWaterConnectionRestDTO.setGumastaLicensePDF("");
						
					}
					String name = newwaterConnection.getFullName();
					String applnNo = retunRti.getRtiApplnNumber();
                   String mobileNo = retunRti.getPhoneNumber();
                   String email = retunRti.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
			}

			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					newWaterConnectionRestDTO.setResult(message.toString());
					newWaterConnectionRestDTO.setResponseStatus("Requested data not saved successfully");
					newWaterConnectionRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					newWaterConnectionRestDTO.setStatus("Internal Server Error");
					newWaterConnectionRestDTO.setApplicantIdProofPDF("");
					newWaterConnectionRestDTO.setCopyOfTaxReceiptPDF("");
					newWaterConnectionRestDTO.setPhotographsPDF("");
					newWaterConnectionRestDTO.setCopyOfTaxReceiptresidentialPDF("");
					newWaterConnectionRestDTO.setRegistrySaleDeedResidentialPDF("");
					newWaterConnectionRestDTO.setSlumCertificatePDF("");
					newWaterConnectionRestDTO.setRegistrySaleDeedOfFlatSchemePDF("");
					newWaterConnectionRestDTO.setConsonentLetterPDF("");
					newWaterConnectionRestDTO.setDodPDF("");
					newWaterConnectionRestDTO.setBuildingSanactionPlanPDF("");
					newWaterConnectionRestDTO.setArchitectCompletionCertificatePDF("");
					newWaterConnectionRestDTO.setRegistrySaleDeedOfInstitutuionalPDF("");
					newWaterConnectionRestDTO.setGumastaLicensePDF("");

					

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			newWaterConnectionRestDTO.setResponseStatus(ex.getMessage());
			newWaterConnectionRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			newWaterConnectionRestDTO.setStatus("Method not Allowed");
			newWaterConnectionRestDTO.setApplicantIdProofPDF("");
			newWaterConnectionRestDTO.setCopyOfTaxReceiptPDF("");
			newWaterConnectionRestDTO.setPhotographsPDF("");
			newWaterConnectionRestDTO.setCopyOfTaxReceiptresidentialPDF("");
			newWaterConnectionRestDTO.setRegistrySaleDeedResidentialPDF("");
			newWaterConnectionRestDTO.setSlumCertificatePDF("");
			newWaterConnectionRestDTO.setRegistrySaleDeedOfFlatSchemePDF("");
			newWaterConnectionRestDTO.setConsonentLetterPDF("");
			newWaterConnectionRestDTO.setDodPDF("");
			newWaterConnectionRestDTO.setBuildingSanactionPlanPDF("");
			newWaterConnectionRestDTO.setArchitectCompletionCertificatePDF("");
			newWaterConnectionRestDTO.setRegistrySaleDeedOfInstitutuionalPDF("");
			newWaterConnectionRestDTO.setGumastaLicensePDF("");

			
		}
		return newWaterConnectionRestDTO;
	}
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "NewWaterConnection";
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
