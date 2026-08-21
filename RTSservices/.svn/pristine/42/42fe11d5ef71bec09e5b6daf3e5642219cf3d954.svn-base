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
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RenewalNursingHomes;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.RenewalNursingHomesService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.NursingHomeRenewalRestDTO;

@Controller
public class NursingHomeRenewalRestController {
	private static Log log = LogFactory.getLog(NursingHomeRenewalRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	@Autowired
	private RenewalNursingHomesService renewalNursingHomesService;
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/saveRenewalNursingHome")
	public @ResponseBody NursingHomeRenewalRestDTO saveRenewalNursingHome(@RequestBody NursingHomeRenewalRestDTO nursingHomeRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {


		if (log.isDebugEnabled()) {
			log.debug("Invoking nursingHomes");
		}

		RenewalNursingHomes nursingHomes = new RenewalNursingHomes();
		StringBuilder errorMessage = new StringBuilder();
		boolean condition = true;
		String files[] = new String[14];
		try{

		if (nursingHomeRestDTO.getTitle() != null && !nursingHomeRestDTO.getTitle().isEmpty()) {
			nursingHomes.setTitle(nursingHomeRestDTO.getTitle());
		} else {
			errorMessage.append("Title field is required, ");
			condition = false;
		}

//		if (nursingHomeRestDTO.getFullname() != null && !nursingHomeRestDTO.getFullname().isEmpty()) {
//			nursingHomes.setFullname(nursingHomeRestDTO.getFullname());
//		} else {
//			errorMessage.append("Fullname is required, ");
//			condition = false;
//		}

		if (nursingHomeRestDTO.getName() != null && !nursingHomeRestDTO.getName().isEmpty()) {
			nursingHomes.setName(nursingHomeRestDTO.getName());
			nursingHomes.setFullname(nursingHomeRestDTO.getFullname()+" "+nursingHomeRestDTO.getFathername()+" "+nursingHomeRestDTO.getSurname());

		} else {
			errorMessage.append("Name field is required, ");
			condition = false;
		}

			nursingHomes.setFathername(nursingHomeRestDTO.getFathername());
		

		if (nursingHomeRestDTO.getSurname() != null && !nursingHomeRestDTO.getSurname().isEmpty()) {
			nursingHomes.setSurname(nursingHomeRestDTO.getSurname());
		} else {
			errorMessage.append("Surname field  is required, ");
			condition = false;
		}
			nursingHomes.setPlot(nursingHomeRestDTO.getPlot());
		

			nursingHomes.setBuilding(nursingHomeRestDTO.getBuilding());
		

		if (nursingHomeRestDTO.getStreet() != null && !nursingHomeRestDTO.getStreet().isEmpty()) {
			nursingHomes.setStreet(nursingHomeRestDTO.getStreet());
		} else {
			errorMessage.append("Street field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getCity() != null && !nursingHomeRestDTO.getCity().isEmpty()) {
			nursingHomes.setArea(nursingHomeRestDTO.getCity());
		} else {
			errorMessage.append("City filed is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getPincode() != null && !nursingHomeRestDTO.getPincode().isEmpty()) {
			nursingHomes.setPin(nursingHomeRestDTO.getPincode());
		} else {
			errorMessage.append("Pincode field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getLandmark() != null && !nursingHomeRestDTO.getLandmark().isEmpty()) {
			nursingHomes.setLandmark(nursingHomeRestDTO.getLandmark());
		} else {
			errorMessage.append("Landmark field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getPhone() != null && !nursingHomeRestDTO.getPhone().isEmpty()) {
			nursingHomes.setPhone(nursingHomeRestDTO.getPhone());
		} else {
			errorMessage.append("Mobile no. field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getTechqul() != null && !nursingHomeRestDTO.getTechqul().isEmpty()) {
			nursingHomes.setTechqul(nursingHomeRestDTO.getTechqul());
		} else {
			errorMessage.append("Technical Qualification if any, of the applicant. field is required, ");
			condition = false;
		}
		
		if (nursingHomeRestDTO.getZone() >0) {
			nursingHomes.setZoneNo(String.valueOf(nursingHomeRestDTO.getZone()));
		} else {
			errorMessage.append("Zone no. field is required, ");
			condition = false;
		}
		
	

		if (nursingHomeRestDTO.getSituation() != null && !nursingHomeRestDTO.getSituation().isEmpty()) {
			nursingHomes.setSituation(nursingHomeRestDTO.getSituation());
		} else {
			errorMessage.append("Principal office of the company,Society,Association filed is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getNameofother() != null && !nursingHomeRestDTO.getNameofother().isEmpty()) {
			nursingHomes.setNameofother(nursingHomeRestDTO.getNameofother());
		} else {
			errorMessage.append("Share nursing home details for registration field is required, ");
			condition = false;
		}
		
		if (nursingHomeRestDTO.getNursingplace() != null && !nursingHomeRestDTO.getNursingplace().isEmpty()) {
			nursingHomes.setNursingplace(nursingHomeRestDTO.getNursingplace());
		} else {
			errorMessage.append("Nursing Place field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getBriefdesc() != null && !nursingHomeRestDTO.getBriefdesc().isEmpty()) {
			nursingHomes.setBriefdesc(nursingHomeRestDTO.getBriefdesc());
		} else {
			errorMessage.append("Describe nursing home size, equipment, and related premises briefly field is required, ");
			condition = false;
		}
		
		if (nursingHomeRestDTO.getFloorspace() != null && !nursingHomeRestDTO.getFloorspace().isEmpty()) {
			nursingHomes.setFloorspace(nursingHomeRestDTO.getFloorspace());
		} else {
			errorMessage.append("patient ward rooms' floor space field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getArrangemedimmu() != null && !nursingHomeRestDTO.getArrangemedimmu().isEmpty()) {
			nursingHomes.setArrangemedimmu(nursingHomeRestDTO.getArrangemedimmu());
		} else {
			errorMessage.append("Employee medical check-up and immunization arrangements field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getFloorspaceofrooms() != null && !nursingHomeRestDTO.getFloorspaceofrooms().isEmpty()) {
			nursingHomes.setFloorspaceofrooms(nursingHomeRestDTO.getFloorspaceofrooms());
		} else {
			errorMessage.append("Room details, including usage and area field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getConvdetailsofemp() != null && !nursingHomeRestDTO.getConvdetailsofemp().isEmpty()) {
			nursingHomes.setConvdetailsofemp(nursingHomeRestDTO.getConvdetailsofemp());
		} else {
			errorMessage.append(" Patient and employee sanitation details and counts field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getDetailsstoragefood() != null
				&& !nursingHomeRestDTO.getDetailsstoragefood().isEmpty()) {
			nursingHomes.setDetailsstoragefood(nursingHomeRestDTO.getDetailsstoragefood());
		} else {
			errorMessage.append("Food storage and service details field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getEquipment() != null && !nursingHomeRestDTO.getEquipment().isEmpty()) {
			nursingHomes.setEquipment(nursingHomeRestDTO.getEquipment());
		} else {
			errorMessage.append("Equipment Anabel field are required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getCarryingnursinghome() != null
				&& !nursingHomeRestDTO.getCarryingnursinghome().isEmpty()) {
			nursingHomes.setCarryingnursinghome(nursingHomeRestDTO.getCarryingnursinghome());
		} else {
			errorMessage.append("premises are used for other purposes field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getNobedmpatient() != null && !nursingHomeRestDTO.getNobedmpatient().isEmpty()) {
			nursingHomes.setNobedmpatient(nursingHomeRestDTO.getNobedmpatient());
		} else {
			errorMessage.append("Number of Beds for Maternity Patients field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getNobedopatient() != null && !nursingHomeRestDTO.getNobedopatient().isEmpty()) {
			nursingHomes.setNobedopatient(nursingHomeRestDTO.getNobedopatient());
		} else {
			errorMessage.append("Number of Beds for Other Patients field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getPdetailsnuringemp() != null && !nursingHomeRestDTO.getPdetailsnuringemp().isEmpty()) {
			nursingHomes.setPdetailsnuringemp(nursingHomeRestDTO.getPdetailsnuringemp());
		} else {
			errorMessage.append("Personal Details of Nursing staff field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getPlaceofnstaff() != null && !nursingHomeRestDTO.getPlaceofnstaff().isEmpty()) {
			nursingHomes.setPlaceofnstaff(nursingHomeRestDTO.getPlaceofnstaff());
		} else {
			errorMessage.append("Place of Nursing Staff field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getQualification() != null && !nursingHomeRestDTO.getQualification().isEmpty()) {
			nursingHomes.setQualification(nursingHomeRestDTO.getQualification());
		} else {
			errorMessage.append("Resident/visiting physician qualifications field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getQualifiednurse() != null && !nursingHomeRestDTO.getQualifiednurse().isEmpty()) {
			nursingHomes.setQualifiednurse(nursingHomeRestDTO.getQualifiednurse());
		} else {
			errorMessage.append("Details ofQualifications for supervision field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getUnregmedunquilnursingstaff() != null
				&& !nursingHomeRestDTO.getUnregmedunquilnursingstaff().isEmpty()) {
			nursingHomes.setUnregmedunquilnursingstaff(nursingHomeRestDTO.getUnregmedunquilnursingstaff());
		} else {
			errorMessage.append("Details of Unregistered and Unqualified Nursing Staff are required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getQulnursemidwife() != null && !nursingHomeRestDTO.getQulnursemidwife().isEmpty()) {
			nursingHomes.setQulnursemidwife(nursingHomeRestDTO.getQulnursemidwife());
		} else {
			errorMessage.append("Nursing home is under the supervision field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getEmail() != null && !nursingHomeRestDTO.getEmail().isEmpty()) {
			nursingHomes.setEmail(nursingHomeRestDTO.getEmail());
		} else {
			errorMessage.append("Email field  is required, ");
			condition = false;
		}

		

		if (nursingHomeRestDTO.getUnregmedunquilnursing() != null
				&& !nursingHomeRestDTO.getUnregmedunquilnursing().isEmpty()) {
			nursingHomes.setUnregmedunquilnursing(nursingHomeRestDTO.getUnregmedunquilnursing());
		} else {
			errorMessage.append("Unregistered medical practitionar field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getAliennationality() != null && !nursingHomeRestDTO.getAliennationality().isEmpty()) {
			nursingHomes.setAliennationality(nursingHomeRestDTO.getAliennationality());
		} else {
			errorMessage.append("Alien Nationality details field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getApplicantintereste() != null
				&& !nursingHomeRestDTO.getApplicantintereste().isEmpty()) {
			nursingHomes.setApplicantintereste(nursingHomeRestDTO.getApplicantintereste());
		} else {
			errorMessage.append("Applicant intersted in other field is required, ");
			condition = false;
		}

			nursingHomes.setNoandexpdate(nursingHomeRestDTO.getNoandexpdate());
	
			if (nursingHomeRestDTO.getRenewalFromDate() != null && !nursingHomeRestDTO.getRenewalFromDate().isEmpty()) {
				nursingHomes.setRenewal_from_date(nursingHomeRestDTO.getRenewalFromDate());
			} else {
				errorMessage.append("Renewal From Date field is required, ");
				condition = false;
			}

			if (nursingHomeRestDTO.getRenewalToDate() != null && !nursingHomeRestDTO.getRenewalToDate().isEmpty()) {
				nursingHomes.setRenewal_to_date(nursingHomeRestDTO.getRenewalToDate());
			} else {
				errorMessage.append("Renewal To Date field is required, ");
				condition = false;
			}
			
			
			if (nursingHomeRestDTO.getFeesChargeToPatients()>0) {
				nursingHomes.setFee_charged(String.valueOf(nursingHomeRestDTO.getFeesChargeToPatients()));
			} else {
				errorMessage.append("Fees charged to Patients field is required, ");
				condition = false;
			}
			
			if (nursingHomeRestDTO.getFees() > 0) {
				nursingHomes.setFees(nursingHomeRestDTO.getFees());
			} else {
				errorMessage.append("Fees details field is required, ");
				condition = false;
			}
			
			

		if (nursingHomeRestDTO.getApplicantName() != null && !nursingHomeRestDTO.getApplicantName().isEmpty()) {
			nursingHomes.setApplicantName(nursingHomeRestDTO.getApplicantName());
		} else {
			errorMessage.append("Applicant's Name field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getApplicantAddress() != null && !nursingHomeRestDTO.getApplicantAddress().isEmpty()) {
			nursingHomes.setApplicantAddress(nursingHomeRestDTO.getApplicantAddress());
		} else {
			errorMessage.append("Applicant's Address field is required, ");
			condition = false;
		}
		

		if (nursingHomeRestDTO.getApplicantAddress1() != null && !nursingHomeRestDTO.getApplicantAddress1().isEmpty()) {
			nursingHomes.setApplicantAddress1(nursingHomeRestDTO.getApplicantAddress1());
		} else {
			errorMessage.append("Applicant's Address1 is required, ");
			condition = false;
		}

		
		if (nursingHomeRestDTO.getName_and_otherParticulars() != null
				&& !nursingHomeRestDTO.getName_and_otherParticulars().isEmpty()) {
			nursingHomes.setName_and_otherParticulars(nursingHomeRestDTO.getName_and_otherParticulars());
		} else {
			errorMessage.append("Name and Other Particulars field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getNursinghomePlace() != null && !nursingHomeRestDTO.getNursinghomePlace().isEmpty()) {
			nursingHomes.setNursinghomePlace(nursingHomeRestDTO.getNursinghomePlace());
		} else {
			errorMessage.append("Nursing Home situated field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getNationality1() != null && !nursingHomeRestDTO.getNationality1().isEmpty()) {
			nursingHomes.setNationality1(nursingHomeRestDTO.getNationality1());
		} else {
			errorMessage.append("Applicant Nationality field is required, ");
			condition = false;
		}
		
		if (nursingHomeRestDTO.getTotalPatients() != null && !nursingHomeRestDTO.getTotalPatients().isEmpty()) {
			nursingHomes.setTotalPatients(nursingHomeRestDTO.getTotalPatients());
		} else {
			errorMessage.append("Total Patients field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getMaternityPatients() != null && !nursingHomeRestDTO.getMaternityPatients().isEmpty()) {
			nursingHomes.setMaternityPatients(nursingHomeRestDTO.getMaternityPatients());
		} else {
			errorMessage.append("Maternity Patients field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getOtherPatients() != null && !nursingHomeRestDTO.getOtherPatients().isEmpty()) {
			nursingHomes.setOtherPatients(nursingHomeRestDTO.getOtherPatients());
		} else {
			errorMessage.append("Other Patients field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getRegistrationDate() != null && !nursingHomeRestDTO.getRegistrationDate().isEmpty()) {
			nursingHomes.setRegistrationDate(nursingHomeRestDTO.getRegistrationDate());
		} else {
			errorMessage.append("Number and date of registration field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getRenewalDate() != null && !nursingHomeRestDTO.getRenewalDate().isEmpty()) {
			nursingHomes.setRenewalDate(nursingHomeRestDTO.getRenewalDate());
		} else {
			errorMessage.append("Renewal Date field is required, ");
			condition = false;
		}
		

		if (nursingHomeRestDTO.getOutwardNo() != null && !nursingHomeRestDTO.getOutwardNo().isEmpty()) {
			nursingHomes.setOutwardNo(nursingHomeRestDTO.getOutwardNo());
		} else {
			errorMessage.append("Outward No. field is required, ");
			condition = false;
		}

		if (nursingHomeRestDTO.getZoneNo() != null && !nursingHomeRestDTO.getZoneNo().isEmpty()) {
			nursingHomes.setZoneNo(nursingHomeRestDTO.getZoneNo());
		} else {
			errorMessage.append("Zone No. field is required, ");
			condition = false;
		}

	
		
		

		//Conditions
         if(nursingHomeRestDTO.getPdetailsnuringemp().equals("yes")) {
        	 if (nursingHomeRestDTO.getPdetailsnuringdoc() != null && !nursingHomeRestDTO.getPdetailsnuringdoc().isEmpty()) {
     			files[0] = nursingHomeRestDTO.getPdetailsnuringdoc();
     		} else {
     			errorMessage.append("Names, Ages and qualification of the member is required, ");
     			condition = false;
     		}
         }else {
  			files[0] = nursingHomeRestDTO.getPdetailsnuringdoc();
         }
         
         
         if(nursingHomeRestDTO.getQualifiednurse().equals("yes")) {
        	 
        		if (nursingHomeRestDTO.getQualifiedNuerseDoc() != null
        				&& !nursingHomeRestDTO.getQualifiedNuerseDoc().isEmpty()) {
        			files[1] = nursingHomeRestDTO.getQualifiedNuerseDoc();
        		} else {
        			errorMessage.append("Qualified medical practitioner is required, ");
        			condition = false;
        		}
         }else {
 			files[1] = nursingHomeRestDTO.getQualifiedNuerseDoc();
         }
         
         
         if(nursingHomeRestDTO.getQulnursemidwife().equals("yes")) {
        	 if (nursingHomeRestDTO.getQulnursemidwifedoc() != null
     				&& !nursingHomeRestDTO.getQulnursemidwifedoc().isEmpty()) {
     			files[2]=nursingHomeRestDTO.getQulnursemidwifedoc();
     		} else {
     			errorMessage.append("supervision of a qualified nurse midwife is required, ");
     			condition = false;
     		}
         }else {
  			files[2]=nursingHomeRestDTO.getQulnursemidwifedoc();
         }
         
         if(nursingHomeRestDTO.getUnregmedunquilnursing().equals("yes")){
        		if (nursingHomeRestDTO.getUnregmedunquilnursingDoc() != null
        				&& !nursingHomeRestDTO.getUnregmedunquilnursingDoc().isEmpty()) {
        			files[3] = nursingHomeRestDTO.getUnregmedunquilnursingDoc();
        		} else {
        			errorMessage.append("unregistered medical practitioner is required, ");
        			condition = false;
        		}
         }else {
 			files[3] = nursingHomeRestDTO.getUnregmedunquilnursingDoc();

         }
         
         
     	//files

 		if (nursingHomeRestDTO.getMmc_file() != null && !nursingHomeRestDTO.getMmc_file().isEmpty()) {
 			files[4] = nursingHomeRestDTO.getMmc_file();
 		} else {
 			errorMessage.append("M.M.C. Master Certificate is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getMnc_file() != null && !nursingHomeRestDTO.getMnc_file().isEmpty()) {
 			files[5] = nursingHomeRestDTO.getMnc_file();
 		} else {
 			errorMessage.append("Educational certificates of Nursing Cadre is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getBio_medical_file() != null && !nursingHomeRestDTO.getBio_medical_file().isEmpty()) {
 			files[6] = nursingHomeRestDTO.getBio_medical_file();
 		} else {
 			errorMessage.append("Bio Medical waste Certificate is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getFire_noc_file() != null && !nursingHomeRestDTO.getFire_noc_file().isEmpty()) {
 			files[7] = nursingHomeRestDTO.getFire_noc_file();
 		} else {
 			errorMessage.append("Fire NOC is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getPollution_file() != null && !nursingHomeRestDTO.getPollution_file().isEmpty()) {
 			files[8] = nursingHomeRestDTO.getPollution_file();
 		} else {
 			errorMessage.append("Certificate of Maharashtra Pollution Control Board is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getWater_tax_file() != null && !nursingHomeRestDTO.getWater_tax_file().isEmpty()) {
 			files[9] = nursingHomeRestDTO.getWater_tax_file();
 		} else {
 			errorMessage.append("Current year property tax and water tax payment receipt is required, ");
 			condition = false;
 		}


 		if (nursingHomeRestDTO.getNotarized_file() != null && !nursingHomeRestDTO.getNotarized_file().isEmpty()) {
 			files[10] = nursingHomeRestDTO.getNotarized_file();
 		} else {
 			errorMessage.append("Notarized Affidavit regarding Parking is required, ");
 			condition = false;
 		}

 		if (nursingHomeRestDTO.getNursing_registration_file() != null && !nursingHomeRestDTO.getNursing_registration_file().isEmpty()) {
 			files[11] = nursingHomeRestDTO.getNursing_registration_file();
 		} else {
 			errorMessage.append("Nursing home registration certificate is required, ");
 			condition = false;
 		}
 		
 		if (nursingHomeRestDTO.getFire_noc_form_b_file() != null && !nursingHomeRestDTO.getFire_noc_form_b_file().isEmpty()) {
 			files[12] = nursingHomeRestDTO.getFire_noc_form_b_file();
 		} else {
 			errorMessage.append("Fire NOC Form B is required, ");
 			condition = false;
 		}
 			
 		if (nursingHomeRestDTO.getSign_and_date_file() != null
 				&& !nursingHomeRestDTO.getSign_and_date_file().isEmpty()) {
 			files[13] = nursingHomeRestDTO.getSign_and_date_file();
 		} else {
 			errorMessage.append("Signature and Date is required, ");
 			condition = false;
 		}
 		
 		String savedFilePath = ZoneCertificateRestController.saveFile(files,
 				request);
         
		RTIApplication rtiApplication = new RTIApplication();
		if (nursingHomeRestDTO.getUserMobileNumber()>0) {
			rtiApplication.setMobileAppUserNumber(String.valueOf(
					nursingHomeRestDTO.getUserMobileNumber()));
		} else {
			String userMobilenumber = "User Mobile Number is Required";
			condition = false;
			errorMessage.append(userMobilenumber).append(",");
		}
		
		
		
		if(condition) {

		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setTemplateName("nursingregistration");
		rtiApplication.setSubject("NURSING-HOME-REGISTRATION");
		rtiApplication.setDepartment("HEALTH-DEPARTMENT");
		rtiApplication.setWorkFlowStatus(0);
		rtiApplication.setFinalStatus("0");
		rtiApplication.setRtiserviceid(94);
		rtiApplication.setApplicantName(nursingHomes.getName() + " " + nursingHomes.getFathername()
				+ " " + nursingHomes.getSurname());
		rtiApplication.setPhoneNumber(nursingHomes.getPhone());
		rtiApplication.setMobileNumber(nursingHomes.getPhone());
		rtiApplication.setEmail(nursingHomes.getEmail());
		rtiApplication.setZone(nursingHomes.getZoneNo());
		rtiApplication.setApplicationCost(nursingHomes.getFees());
		rtiApplication.setMobileAppUserNumber(String.valueOf(nursingHomeRestDTO.getUserMobileNumber()));

		rtiApplication.setApplicantName(nursingHomes.getFullname());
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
			rti.setRtiApplnNumber("RTS/HD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
			nursingHomes.setRtiapplrefno(rti.getRtiApplnNumber());
			nursingHomes.setRti_ref_id(savedRti.getRtiApplicationId());
			long birth_regis_id = renewalNursingHomesService.nursingHomeRenewalApplications(nursingHomes);
			rti.setRtiApplicationRefId(birth_regis_id);
			 RTIApplication retunRti = rtiApplicationService.merge(rti);

			if ((retunRti != null) && (birth_regis_id > 0)) {
				nursingHomeRestDTO.setResponseStatus(
						"Requested data saved successfully");
				nursingHomeRestDTO
						.setResult(retunRti.getRtiApplnNumber());
				nursingHomeRestDTO.setResponseCode(HttpStatus.OK.value());
				response.setStatus(HttpStatus.OK.value());
				nursingHomeRestDTO.setStatus("ok");
				nursingHomeRestDTO.setQualifiedNuerseDoc("");
				nursingHomeRestDTO.setPdetailsnuringdoc("");
				nursingHomeRestDTO.setQulnursemidwifedoc("");
				nursingHomeRestDTO.setUnregmedunquilnursingDoc("");
				nursingHomeRestDTO.setMmc_file("");
				nursingHomeRestDTO.setMnc_file("");
				nursingHomeRestDTO.setBio_medical_file("");
				nursingHomeRestDTO.setFire_noc_file("");
				nursingHomeRestDTO.setPollution_file("");
				nursingHomeRestDTO.setWater_tax_file("");
				nursingHomeRestDTO.setNotarized_file("");
				nursingHomeRestDTO.setSign_and_date_file("");

			}
			String name = nursingHomes.getFullname();
			String link = "https://tinyurl.com/4hhhy9w9";
			String applnNo = rti.getRtiApplnNumber();

			String msg = "Dear " + name + " your application with Application No. " + applnNo
					+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

			msg.replace("var3", "");

			SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", nursingHomes.getPhone(), msg);
			SendEmail.sendEmail(nursingHomes.getEmail(), "Application Submitted Successfully" + applnNo,
					msg);
		}
		}
		if (!condition) {
			if (errorMessage.charAt(errorMessage.length() - 1) == ',') {
				errorMessage.deleteCharAt(errorMessage.length() - 1);
				nursingHomeRestDTO.setResult(errorMessage.toString());
				nursingHomeRestDTO.setResponseStatus(
						"Requested data not saved successfully");
				nursingHomeRestDTO.setQualifiedNuerseDoc("");
				nursingHomeRestDTO.setPdetailsnuringdoc("");
				nursingHomeRestDTO.setQulnursemidwifedoc("");
				nursingHomeRestDTO.setUnregmedunquilnursingDoc("");
				nursingHomeRestDTO.setMmc_file("");
				nursingHomeRestDTO.setMnc_file("");
				nursingHomeRestDTO.setBio_medical_file("");
				nursingHomeRestDTO.setFire_noc_file("");
				nursingHomeRestDTO.setPollution_file("");
				nursingHomeRestDTO.setWater_tax_file("");
				nursingHomeRestDTO.setNotarized_file("");
				nursingHomeRestDTO.setSign_and_date_file("");
				nursingHomeRestDTO.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				nursingHomeRestDTO.setStatus("Internal Server Error");
			}
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		log.equals(ex.getMessage());
		nursingHomeRestDTO.setResponseStatus(ex.getMessage());
		nursingHomeRestDTO.setQualifiedNuerseDoc("");
		nursingHomeRestDTO.setPdetailsnuringdoc("");
		nursingHomeRestDTO.setQulnursemidwifedoc("");
		nursingHomeRestDTO.setUnregmedunquilnursingDoc("");
		nursingHomeRestDTO.setMmc_file("");
		nursingHomeRestDTO.setMnc_file("");
		nursingHomeRestDTO.setBio_medical_file("");
		nursingHomeRestDTO.setFire_noc_file("");
		nursingHomeRestDTO.setPollution_file("");
		nursingHomeRestDTO.setWater_tax_file("");
		nursingHomeRestDTO.setNotarized_file("");
		nursingHomeRestDTO.setSign_and_date_file("");
		nursingHomeRestDTO.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		nursingHomeRestDTO.setStatus("Method not Allowed");
	}
	return nursingHomeRestDTO;
	
}
	
	
	
	
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "NursingHomeRenewal";
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
