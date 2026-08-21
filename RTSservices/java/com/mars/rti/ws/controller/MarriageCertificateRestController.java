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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MarriageCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MarriageCertificateRestDTO;

@Controller
public class MarriageCertificateRestController {

	private static Log log = LogFactory.getLog(MarriageCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private MarriageCertificateService marriageCertificateService;
	

	@RequestMapping(method = RequestMethod.POST, value = "/saveMarriageApplication")
	@ResponseBody
	public  ResponseEntity<MarriageCertificateRestDTO> saveMarriageApplication(@RequestBody MarriageCertificateRestDTO marriageCertificateRestDTO,
			HttpServletRequest request, HttpServletResponse reponse) throws ServletException {
		boolean condition = true;
				
			StringBuilder message = new StringBuilder();
			String[] files = new String[22];
		
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMarriageApplication");
		}
		 MarriageCertificate marriageCertificate = new MarriageCertificate();

		try {
			if (marriageCertificateRestDTO.getApplicantName() != null
					&& !marriageCertificateRestDTO.getApplicantName().isEmpty()) {
				  marriageCertificate.setFirstName(marriageCertificateRestDTO.getApplicantName());;
			} else {
				String firstName = "First Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			if (marriageCertificateRestDTO.getApplicantTitle() != null
					&& !marriageCertificateRestDTO.getApplicantTitle().isEmpty()) {
				  marriageCertificate.setTitle(marriageCertificateRestDTO.getApplicantTitle());;
			} else {
				String title = "Title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			if (marriageCertificateRestDTO.getApplicantSurname() != null
					&& !marriageCertificateRestDTO.getApplicantSurname().isEmpty()) {
				  marriageCertificate.setLastName(marriageCertificateRestDTO.getApplicantSurname());;
			} else {
				String lastName = "Last Name field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			if (marriageCertificateRestDTO.getApplicantemail() != null
					&& !marriageCertificateRestDTO.getApplicantemail().isEmpty()) {
				  marriageCertificate.setTitle(marriageCertificateRestDTO.getApplicantemail());;
			} else {
				String email = " Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			if (marriageCertificateRestDTO.getApplicantmobileNumber() != 0) {
				  marriageCertificate.setMobileNumber(String.valueOf(marriageCertificateRestDTO.getApplicantmobileNumber()));
			} else {
				String mobileNumber = " Mobile Number field is Required";
				condition = false;
				message.append(mobileNumber).append(",");
			}
			
			if (marriageCertificateRestDTO.getApplicantfullAddress() != null
					&& !marriageCertificateRestDTO.getApplicantfullAddress().isEmpty()) {
				  marriageCertificate.setFullAddress(marriageCertificateRestDTO.getApplicantfullAddress());;
			} else {
				String address= " Full Address field is Required";
				condition = false;
				message.append(address).append(",");
			}
			if (marriageCertificateRestDTO.getMarriageDate() != null
					&& !marriageCertificateRestDTO.getMarriageDate().isEmpty()) {
				  marriageCertificate.setMarriageDate(marriageCertificateRestDTO.getMarriageDate());;
			} else {
				String marriageDate= " Marriage Date field is Required";
				condition = false;
				message.append(marriageDate).append(",");
			}
			if (marriageCertificateRestDTO.getMarriagePlace() != null
					&& !marriageCertificateRestDTO.getMarriagePlace().isEmpty()) {
				  marriageCertificate.setMarriagePlace(marriageCertificateRestDTO.getMarriagePlace());;
			} else {
				String placeMarriage= " Marriage place field is Required";
				condition = false;
				message.append(placeMarriage).append(",");
			}
			if (marriageCertificateRestDTO.getMarriageLawReligion() != null
					&& !marriageCertificateRestDTO.getMarriageLawReligion().isEmpty()) {
				  marriageCertificate.setMarriageLawReligion(marriageCertificateRestDTO.getMarriageLawReligion());;
			} else {
				String MarriageLowReligion= " Marriae Law Religien field is Required";
				condition = false;
				message.append(MarriageLowReligion).append(",");
			}
			if (marriageCertificateRestDTO.getZoneNo() != 0) {
				  marriageCertificate.setZoneNo(String.valueOf(marriageCertificateRestDTO.getZoneNo()));;
			} else {
				String zoneNo= " ZoneNo field is Required";
				condition = false;
				message.append(zoneNo).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandTitle() != null
					&& !marriageCertificateRestDTO.getHusbandTitle().isEmpty()) {
				  marriageCertificate.setHusbandTitle(marriageCertificateRestDTO.getHusbandTitle());;
			} else {
				String husbandTitle= " husband title Religien field is Required";
				condition = false;
				message.append(husbandTitle).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandLastName() != null
					&& !marriageCertificateRestDTO.getHusbandLastName().isEmpty()) {
				  marriageCertificate.setHusbandLastName(marriageCertificateRestDTO.getHusbandLastName());;
			} else {
				String husbandSurname= " husband lastname field is Required";
				condition = false;
				message.append(husbandSurname).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandFirstName() != null
					&& !marriageCertificateRestDTO.getHusbandFirstName().isEmpty()) {
				  marriageCertificate.setHusbandFirstName(marriageCertificateRestDTO.getHusbandFirstName());;
			} else {
				String husbandFirstName= " husband First name field is Required";
				condition = false;
				message.append(husbandFirstName).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandFatherName() != null
					&& !marriageCertificateRestDTO.getHusbandFatherName().isEmpty()) {
				  marriageCertificate.setHusbandFatherName(marriageCertificateRestDTO.getHusbandFatherName());;
			} else {
				String husbandFatherName= " husband Father name field is Required";
				condition = false;
				message.append(husbandFatherName).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandBirthReligion() != null
					&& !marriageCertificateRestDTO.getHusbandBirthReligion().isEmpty()) {
				  marriageCertificate.setHusbandBirthReligion(marriageCertificateRestDTO.getHusbandBirthReligion());;
			} else {
				String husbandReligienName= " husband Birth Religien field is Required";
				condition = false;
				message.append(husbandReligienName).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandFullAddr() != null
					&& !marriageCertificateRestDTO.getHusbandFullAddr().isEmpty()) {
				  marriageCertificate.setHusbandFullAddr(marriageCertificateRestDTO.getHusbandFullAddr());;
			} else {
				String husbandAddressName= " husband Full address field is Required";
				condition = false;
				message.append(husbandAddressName).append(",");
			}
			
			if (marriageCertificateRestDTO.getHusbandSolemAgeYear() != 0) {
				  marriageCertificate.setHusbandSolemAgeYear(String.valueOf(marriageCertificateRestDTO.getHusbandSolemAgeYear()));;
			} else {
				String husbandSolem= " Husband Solem Age Year field is Required";
				condition = false;
				message.append(husbandSolem).append(",");
			}
			if (marriageCertificateRestDTO.getHusbanndAgeProof() != null
					&& !marriageCertificateRestDTO.getHusbanndAgeProof().isEmpty()) {
				  marriageCertificate.setHusbandFullAddr(marriageCertificateRestDTO.getHusbanndAgeProof());
			} else {
				String husbandProofOfAge= " husband age proof field is Required";
				condition = false;
				message.append(husbandProofOfAge).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandOccup() != null
					&& !marriageCertificateRestDTO.getHusbandOccup().isEmpty()) {
				  marriageCertificate.setHusbandOccup(marriageCertificateRestDTO.getHusbandOccup());
			} else {
				String husbandOccupation = " husbandOccupation  field is Required";
				condition = false;
				message.append(husbandOccupation).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandStatus() != null
					&& !marriageCertificateRestDTO.getHusbandStatus().isEmpty()) {
				  marriageCertificate.setHusbandStatus(marriageCertificateRestDTO.getHusbandStatus());
			} else {
				String Statusmarriagetime = " Husband Status field is Required";
				condition = false;
				message.append(Statusmarriagetime).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getHusbandWitnSignAndDate().isEmpty()) {
				  marriageCertificate.setHusbandWitnSignAndDate(marriageCertificateRestDTO.getHusbandWitnSignAndDate());
			} else {
				String SignatureHusband = " Signature and Date Husband  field is Required";
				condition = false;
				message.append(SignatureHusband).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandPhotograph()!= null
					&& !marriageCertificateRestDTO.getHusbandPhotograph().isEmpty()) {
				  marriageCertificate.setHusbandPhotograph(marriageCertificateRestDTO.getHusbandPhotograph());
			} else {
				String husbandPhotograph  = " Husband Photograph field is Required";
				condition = false;
				message.append(husbandPhotograph).append(",");
			}
			if (marriageCertificateRestDTO.getWifeTitle()!= null
					&& !marriageCertificateRestDTO.getWifeTitle().isEmpty()) {
				  marriageCertificate.setWifeTitle(marriageCertificateRestDTO.getWifeTitle());
			} else {
				String titleWife  = " Title field is Required";
				condition = false;
				message.append(titleWife).append(",");
			}
			if (marriageCertificateRestDTO.getWifeLastName()!= null
					&& !marriageCertificateRestDTO.getWifeLastName().isEmpty()) {
				  marriageCertificate.setWifeLastName(marriageCertificateRestDTO.getWifeLastName());
			} else {
				String wifeSurname  = " Wife Last Name field is Required";
				condition = false;
				message.append(wifeSurname).append(",");
			}
			if (marriageCertificateRestDTO.getWifeFirstName()!= null
					&& !marriageCertificateRestDTO.getWifeFirstName().isEmpty()) {
				  marriageCertificate.setWifeFirstName(marriageCertificateRestDTO.getWifeFirstName());
			} else {
				String wifeName  = " Wife name field is Required";
				condition = false;
				message.append(wifeName).append(",");
			}
			if (marriageCertificateRestDTO.getWifeFatherName()!= null
					&& !marriageCertificateRestDTO.getWifeFatherName().isEmpty()) {
				  marriageCertificate.setWifeFatherName(marriageCertificateRestDTO.getWifeFatherName());
			} else {
				String wifeFatherName = " Wife Father name field is Required";
				condition = false;
				message.append(wifeFatherName).append(",");
			}
			if (marriageCertificateRestDTO.getWifeBirthReligion()!= null
					&& !marriageCertificateRestDTO.getWifeBirthReligion().isEmpty()) {
				  marriageCertificate.setWifeBirthReligion(marriageCertificateRestDTO.getWifeBirthReligion());
			} else {
				String wifeReligionBirth= " Wife Birth Religion field is Required";
				condition = false;
				message.append(wifeReligionBirth).append(",");
			}
			
			if (marriageCertificateRestDTO.getWifeFullAddress()!= null
					&& !marriageCertificateRestDTO.getWifeFullAddress().isEmpty()) {
				  marriageCertificate.setWifeFullAddress(marriageCertificateRestDTO.getWifeFullAddress());
			} else {
				String wifeFullAddress= " Wife Wife Full Address field is Required";
				condition = false;
				message.append(wifeFullAddress).append(",");
			}
			if (marriageCertificateRestDTO.getWifeSolemAgeYear()!= 0) {
				  marriageCertificate.setWifeSolemAgeYear(String.valueOf(marriageCertificateRestDTO.getWifeSolemAgeYear()));
			} else {
				String wifeSolemAge= "Wife Solem Age year field is Required";
				condition = false;
				message.append(wifeSolemAge).append(",");
			}
			if (marriageCertificateRestDTO.getWifeAgeProof()!= null
					&& !marriageCertificateRestDTO.getWifeAgeProof().isEmpty()) {
				  marriageCertificate.setWifeAgeProof(marriageCertificateRestDTO.getWifeAgeProof());
			} else {
				String wifeAgeproof= " Wife age proof field is Required";
				condition = false;
				message.append(wifeAgeproof).append(",");
			}
			if (marriageCertificateRestDTO.getWifeStatus()!= null
					&& !marriageCertificateRestDTO.getWifeStatus().isEmpty()) {
				  marriageCertificate.setWifeStatus(marriageCertificateRestDTO.getWifeStatus());
			} else {
				String wifeStatus= " Wife Status at field is Required";
				condition = false;
				message.append(wifeStatus).append(",");
			}
			if (marriageCertificateRestDTO.getWifeWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getWifeWitnSignAndDate().isEmpty()) {
				  marriageCertificate.setWifeWitnSignAndDate(marriageCertificateRestDTO.getWifeWitnSignAndDate());
			} else {
				String wifeSignature= " Wife Signature Date field is Required";
				condition = false;
				message.append(wifeSignature).append(",");
			}
			if (marriageCertificateRestDTO.getWifePhotograph()!= null
					&& !marriageCertificateRestDTO.getWifePhotograph().isEmpty()) {
				  marriageCertificate.setWifePhotograph(marriageCertificateRestDTO.getWifePhotograph());
			} else {
				String wifePhotograp= " Wife Photograph field is Required";
				condition = false;
				message.append(wifePhotograp).append(",");
			}
			
			if (marriageCertificateRestDTO.getFirstWitnFullName()!= null
					&& !marriageCertificateRestDTO.getFirstWitnFullName().isEmpty()) {
				  marriageCertificate.setFirstWitnFullName(marriageCertificateRestDTO.getFirstWitnFullName());
			} else {
				String WitnessFullname= " Witness Full name field is Required";
				condition = false;
				message.append(WitnessFullname).append(",");
			}

			if (marriageCertificateRestDTO.getFirstWitnFullAddr()!= null
					&& !marriageCertificateRestDTO.getFirstWitnFullAddr().isEmpty()) {
				  marriageCertificate.setFirstWitnFullAddr(marriageCertificateRestDTO.getFirstWitnFullAddr());
			} else {
				String WitnessFullAddress= " Witness Full Address field is Required";
				condition = false;
				message.append(WitnessFullAddress).append(",");
			}
			if (marriageCertificateRestDTO.getFirstWitnOccup()!= null
					&& !marriageCertificateRestDTO.getFirstWitnOccup().isEmpty()) {
				  marriageCertificate.setFirstWitnOccup(marriageCertificateRestDTO.getFirstWitnOccup());
			} else {
				String WitnessOccupation = " Witness Occupation  field is Required";
				condition = false;
				message.append(WitnessOccupation).append(",");
			}
			if (marriageCertificateRestDTO.getFirstWitnOfficeAddr()!= null
					&& !marriageCertificateRestDTO.getFirstWitnOfficeAddr().isEmpty()) {
				  marriageCertificate.setFirstWitnOfficeAddr(marriageCertificateRestDTO.getFirstWitnOfficeAddr());
			} else {
				String WitnessOffice = " Witness Office Address  field is Required";
				condition = false;
				message.append(WitnessOffice).append(",");
			}
			if (marriageCertificateRestDTO.getFirstWitnRelMarCouple()!= null
					&& !marriageCertificateRestDTO.getFirstWitnRelMarCouple().isEmpty()) {
				  marriageCertificate.setFirstWitnRelMarCouple(marriageCertificateRestDTO.getFirstWitnRelMarCouple());
			} else {
				String relationMarried = " Relation with Married Couple  field is Required";
				condition = false;
				message.append(relationMarried).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getHusbandWitnSignAndDate().isEmpty()) {
				  marriageCertificate.setHusbandWitnSignAndDate(marriageCertificateRestDTO.getHusbandWitnSignAndDate());
			} else {
				String signatureWitness= " Relation with Married Couple  field is Required";
				condition = false;
				message.append(signatureWitness).append(",");
			}
			if (marriageCertificateRestDTO.getFirstWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getFirstWitnPhotograph().isEmpty()) {
				  marriageCertificate.setFirstWitnPhotograph(marriageCertificateRestDTO.getFirstWitnPhotograph());
			} else {
				String photographWitness= " photograph  field is Required";
				condition = false;
				message.append(photographWitness).append(",");
			}
			
			if (marriageCertificateRestDTO.getSecondWitnFullName()!= null
					&& !marriageCertificateRestDTO.getSecondWitnFullName().isEmpty()) {
				  marriageCertificate.setSecondWitnFullName(marriageCertificateRestDTO.getSecondWitnFullName());
			} else {
				String SecWitnessFullname= " sec Witness Full name field is Required";
				condition = false;
				message.append(SecWitnessFullname).append(",");
			}

			if (marriageCertificateRestDTO.getSecondWitnFullAddr()!= null
					&& !marriageCertificateRestDTO.getSecondWitnFullAddr().isEmpty()) {
				  marriageCertificate.setSecondWitnFullAddr(marriageCertificateRestDTO.getSecondWitnFullAddr());
			} else {
				String secWitnessFullAddress= "sec Witness Full Address field is Required";
				condition = false;
				message.append(secWitnessFullAddress).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnOccup()!= null
					&& !marriageCertificateRestDTO.getSecondWitnOccup().isEmpty()) {
				  marriageCertificate.setSecondWitnOccup(marriageCertificateRestDTO.getSecondWitnOccup());
			} else {
				String secWitnessOccupation = "sec Witness Occupation  field is Required";
				condition = false;
				message.append(secWitnessOccupation).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnOfficeAddr()!= null
					&& !marriageCertificateRestDTO.getSecondWitnOfficeAddr().isEmpty()) {
				  marriageCertificate.setSecondWitnOfficeAddr(marriageCertificateRestDTO.getSecondWitnOfficeAddr());
			} else {
				String secWitnessOffice = " sec Witness Office Address  field is Required";
				condition = false;
				message.append(secWitnessOffice).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnRelMarCouple()!= null
					&& !marriageCertificateRestDTO.getSecondWitnRelMarCouple().isEmpty()) {
				  marriageCertificate.setSecondWitnRelMarCouple(marriageCertificateRestDTO.getSecondWitnRelMarCouple());
			} else {
				String secrelationMarried = " sec Relation with Married Couple  field is Required";
				condition = false;
				message.append(secrelationMarried).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getSecondWitnSignAndDate().isEmpty()) {
				  marriageCertificate.setSecondWitnSignAndDate(marriageCertificateRestDTO.getSecondWitnSignAndDate());
			} else {
				String secsignatureWitness= "sec Relation with Married Couple  field is Required";
				condition = false;
				message.append(secsignatureWitness).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getSecondWitnPhotograph().isEmpty()) {
				  marriageCertificate.setSecondWitnPhotograph(marriageCertificateRestDTO.getFirstWitnPhotograph());
			} else {
				String secphotographWitness= " sec widphotograph  field is Required";
				condition = false;
				message.append(secphotographWitness).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnFullName()!= null
					&& !marriageCertificateRestDTO.getThirdWitnFullName().isEmpty()) {
				  marriageCertificate.setThirdWitnFullName(marriageCertificateRestDTO.getThirdWitnFullName());
			} else {
				String thWitnessFullname= "third Witness Full name field is Required";
				condition = false;
				message.append(thWitnessFullname).append(",");
			}

			if (marriageCertificateRestDTO.getThirdWitnFullAddr()!= null
					&& !marriageCertificateRestDTO.getThirdWitnFullAddr().isEmpty()) {
				  marriageCertificate.setThirdWitnFullAddr(marriageCertificateRestDTO.getThirdWitnFullAddr());
			} else {
				String secWitnessFullAddress= "third Witness Full Address field is Required";
				condition = false;
				message.append(secWitnessFullAddress).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnOccup()!= null
					&& !marriageCertificateRestDTO.getThirdWitnOccup().isEmpty()) {
				  marriageCertificate.setThirdWitnOccup(marriageCertificateRestDTO.getThirdWitnOccup());
			} else {
				String thirdWitnessOccupation = "third Witness Occupation  field is Required";
				condition = false;
				message.append(thirdWitnessOccupation).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnOfficeAddr()!= null
					&& !marriageCertificateRestDTO.getThirdWitnOfficeAddr().isEmpty()) {
				  marriageCertificate.setThirdWitnOfficeAddr(marriageCertificateRestDTO.getThirdWitnOfficeAddr());
			} else {
				String thirdWitnessOffice = " third Witness Office Address  field is Required";
				condition = false;
				message.append(thirdWitnessOffice).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnRelMarCouple()!= null
					&& !marriageCertificateRestDTO.getThirdWitnRelMarCouple().isEmpty()) {
				  marriageCertificate.setThirdWitnRelMarCouple(marriageCertificateRestDTO.getThirdWitnRelMarCouple());
			} else {
				String thirdsrelationMarried = " third Relation with Married Couple  field is Required";
				condition = false;
				message.append(thirdsrelationMarried).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getThirdWitnSignAndDate().isEmpty()) {
				  marriageCertificate.setThirdWitnSignAndDate(marriageCertificateRestDTO.getThirdWitnSignAndDate());
			} else {
				String thirdsignatureWitness= "third witness Sign and date field is Required";
				condition = false;
				message.append(thirdsignatureWitness).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getThirdWitnPhotograph().isEmpty()) {
				  marriageCertificate.setThirdWitnPhotograph(marriageCertificateRestDTO.getThirdWitnPhotograph());
			} else {
				String secphotographWitness= " third widphotograph  field is Required";
				condition = false;
				message.append(secphotographWitness).append(",");
			}
			if (marriageCertificateRestDTO.getPriestName()!= null
					&& !marriageCertificateRestDTO.getPriestName().isEmpty()) {
				  marriageCertificate.setPriestName(marriageCertificateRestDTO.getPriestName());
			} else {
				String Priestname= " Name of Priest field is Required";
				condition = false;
				message.append(Priestname).append(",");
			}
			if (marriageCertificateRestDTO.getPriestFullAddr()!= null
					&& !marriageCertificateRestDTO.getPriestFullAddr().isEmpty()) {
				  marriageCertificate.setPriestFullAddr(marriageCertificateRestDTO.getPriestFullAddr());
			} else {
				String Priestname= " Priest Full address field is Required";
				condition = false;
				message.append(Priestname).append(",");
			}
			if (marriageCertificateRestDTO.getPriestReligion()!= null
					&& !marriageCertificateRestDTO.getPriestReligion().isEmpty()) {
				  marriageCertificate.setPriestReligion(marriageCertificateRestDTO.getPriestReligion());
			} else {
				String Priestname= " Priest Religion field is Required";
				condition = false;
				message.append(Priestname).append(",");
			}
			if (marriageCertificateRestDTO.getPriestAge()!= null
					&& !marriageCertificateRestDTO.getPriestAge().isEmpty()) {
				  marriageCertificate.setPriestAge(marriageCertificateRestDTO.getPriestAge());
			} else {
				String PriestAge= " Priest Age field is Required";
				condition = false;
				message.append(PriestAge).append(",");
			}
			if (marriageCertificateRestDTO.getFeeApplicable()!= 0.0 || marriageCertificateRestDTO.getFeeApplicable()!= 0) {
				  marriageCertificate.setFeeApplicable(marriageCertificateRestDTO.getFeeApplicable());
			} else {
				String priestFees= "Fees Applicable field is Required";
				condition = false;
				message.append(priestFees).append(",");
			}
			if (marriageCertificateRestDTO.getDaysCalculatedForCertificate()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getDaysCalculatedForCertificate()).isEmpty()) {
				  marriageCertificate.setDaysCalculatedForCertificate(marriageCertificateRestDTO.getDaysCalculatedForCertificate());
			} else {
				String daysCalculate= " Day calculate field is Required";
				condition = false;
				message.append(daysCalculate).append(",");
			}
			
			//new fields 
			if (marriageCertificateRestDTO.getHusbandOccupationOthers()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getHusbandOccupationOthers()).isEmpty()) {
				  marriageCertificate.setHusbandOccupOthers(marriageCertificateRestDTO.getHusbandOccupationOthers());
			} else {
				String HusbandOccupationOthers= " HusbandOccupationOthers field is Required";
				condition = false;
				message.append(HusbandOccupationOthers).append(",");
			}
			
			
			if (marriageCertificateRestDTO.getFirstwitndate()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getFirstwitndate()).isEmpty()) {
				  marriageCertificate.setFirstWitndate(marriageCertificateRestDTO.getFirstwitndate());
			} else {
				String firstwitndate= " firstwitndate field is Required";
				condition = false;
				message.append(firstwitndate).append(",");
			}
			
			
			if (marriageCertificateRestDTO.getFirstaadhaarno()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getFirstaadhaarno()).isEmpty()) {
				  marriageCertificate.setFirstAadhaarNo(marriageCertificateRestDTO.getFirstaadhaarno());
			} else {
				String firstaadhaarno= " Day calculate field is Required";
				condition = false;
				message.append(firstaadhaarno).append(",");
			}
			
			if (marriageCertificateRestDTO.getSecondwitndate()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getSecondwitndate()).isEmpty()) {
				  marriageCertificate.setSecondWitndate(marriageCertificateRestDTO.getSecondwitndate());
			} else {
				String secondwitndate= " secondwitndate field is Required";
				condition = false;
				message.append(secondwitndate).append(",");
			}
			
			if (marriageCertificateRestDTO.getSecondaadhaarno()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getSecondaadhaarno()).isEmpty()) {
				  marriageCertificate.setSecondAadhaarNo(marriageCertificateRestDTO.getSecondaadhaarno());
			} else {
				String secondaadhaarno= " Day secondaadhaarno field is Required";
				condition = false;
				message.append(secondaadhaarno).append(",");
			}
			
			if (marriageCertificateRestDTO.getThirdwitndate()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getThirdwitndate()).isEmpty()) {
				  marriageCertificate.setThirdWitndate(marriageCertificateRestDTO.getThirdwitndate());
			} else {
				String thirdwitndate= " thirdwitndate field is Required";
				condition = false;
				message.append(thirdwitndate).append(",");
			}
			
			if (marriageCertificateRestDTO.getThirdaadhaarno()!= null
					&& !String.valueOf(marriageCertificateRestDTO.getThirdaadhaarno()).isEmpty()) {
				  marriageCertificate.setThirdAadhaarNo(marriageCertificateRestDTO.getThirdaadhaarno());
			} else {
				String thirdaadhaarno= " thirdaadhaarno field is Required";
				condition = false;
				message.append(thirdaadhaarno).append(",");
			}
//			if (marriageCertificateRestDTO.getMarriageCard()!= null
//					&& !String.valueOf(marriageCertificateRestDTO.getMarriageCard()).isEmpty()) {
//				  marriageCertificate.setMarriageCard(marriageCertificateRestDTO.getMarriageCard());
//			} else {
//				String marriageCard= " Name oMarriage Card field is Required";
//				condition = false;
//				message.append(marriageCard).append(",");
//			}
//			if (marriageCertificateRestDTO.getProofOfResidence()!= null
//					&& !String.valueOf(marriageCertificateRestDTO.getProofOfResidence()).isEmpty()) {
//				  marriageCertificate.setProofOfResidence(marriageCertificateRestDTO.getProofOfResidence());
//			} else {
//				String proofofResident= "Proof of Resident field is Required";
//				condition = false;
//				message.append(proofofResident).append(",");
//			}
//			if (marriageCertificateRestDTO.getCourtFeeStamps()!= null
//					&& !String.valueOf(marriageCertificateRestDTO.getCourtFeeStamps()).isEmpty()) {
//				  marriageCertificate.setCourtFeeStamps(marriageCertificateRestDTO.getCourtFeeStamps());
//			} else {
//				String courtFees= " Name of Court fees field is Required";
//				condition = false;
//				message.append(courtFees).append(",");
//			}
//			if (marriageCertificateRestDTO.getPhotoOfHusbandAndWife()!= null
//					&& !String.valueOf(marriageCertificateRestDTO.getPhotoOfHusbandAndWife()).isEmpty()) {
//				  marriageCertificate.setPhotoOfHusbandAndWife(marriageCertificateRestDTO.getPhotoOfHusbandAndWife());
//			} else {
//				String PhotoHusbandAndWife= " photograp of husand and wife field is Required";
//				condition = false;
//				message.append(PhotoHusbandAndWife).append(",");
//			}
			
			if (marriageCertificateRestDTO.getHusbanndAgeProof()!= null
					&& !marriageCertificateRestDTO.getHusbanndAgeProof()
							.isEmpty()) {
				String doc1 = marriageCertificateRestDTO.getHusbanndAgeProof();

				files[0] = doc1;
			} else {
				String doc1 = "Husbannd Age Proof field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (marriageCertificateRestDTO.getHusbandWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getHusbandWitnSignAndDate()
							.isEmpty()) {
				String doc2 = marriageCertificateRestDTO.getHusbandWitnSignAndDate();

				files[1] = doc2;
			} else {
				String doc2 = "Husbannd Sign and Date field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			if (marriageCertificateRestDTO.getHusbandPhotograph()!= null
					&& !marriageCertificateRestDTO.getHusbandPhotograph()
							.isEmpty()) {
				String doc3 = marriageCertificateRestDTO.getHusbandPhotograph();

				files[2] = doc3;
			} else {
				String doc2 = "Husbannd photograph field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			if (marriageCertificateRestDTO.getWifeAgeProof()!= null
					&& !marriageCertificateRestDTO.getWifeAgeProof()
							.isEmpty()) {
				String doc4 = marriageCertificateRestDTO.getWifeAgeProof();

				files[3] = doc4;
			} else {
				String doc4 = "wife age proof  field is Required";
				condition = false;
				message.append(doc4).append(",");
			}
//			if (marriageCertificateRestDTO.getWifeAgeProof()!= null
//					&& !marriageCertificateRestDTO.getWifeAgeProof()
//							.isEmpty()) {
//				String doc4 = marriageCertificateRestDTO.getWifeAgeProof();
//
//				files[3] = doc4;
//			} else {
//				String doc4 = "wife age proof  field is Required";
//				condition = false;
//				message.append(doc4).append(",");
//			}
			
			if (marriageCertificateRestDTO.getWifeWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getWifeWitnSignAndDate()
							.isEmpty()) {
				String doc5 = marriageCertificateRestDTO.getWifeWitnSignAndDate();

				files[4] = doc5;
			} else {
				String doc5 = "wife sing and date field is Required";
				condition = false;
				message.append(doc5).append(",");
			}
			
			if (marriageCertificateRestDTO.getWifePhotograph()!= null
					&& !marriageCertificateRestDTO.getWifePhotograph()
							.isEmpty()) {
				String doc6 = marriageCertificateRestDTO.getWifePhotograph();

				files[5] = doc6;
			} else {
				String doc6 = "wife photograph field is Required";
				condition = false;
				message.append(doc6).append(",");
			}

			if (marriageCertificateRestDTO.getFirstWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getFirstWitnPhotograph()
							.isEmpty()) {
				String doc7 = marriageCertificateRestDTO.getFirstWitnPhotograph();

				files[6] = doc7;
			} else {
				String doc7 = "Frist witness field is Required";
				condition = false;
				message.append(doc7).append(",");
			}
			if (marriageCertificateRestDTO.getFirstWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getFirstWitnSignAndDate()
							.isEmpty()) {
				String doc8 = marriageCertificateRestDTO.getFirstWitnSignAndDate();

				files[7] = doc8;
			} else {
				String doc8 = "Frist witness sing and date field is Required";
				condition = false;
				message.append(doc8).append(",");
			}
			
			if (marriageCertificateRestDTO.getSecondWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getSecondWitnSignAndDate()
							.isEmpty()) {
				String doc9 = marriageCertificateRestDTO.getSecondWitnSignAndDate();

				files[8] = doc9;
			} else {
				String doc9 = "second witness sing and date field is Required";
				condition = false;
				message.append(doc9).append(",");
			}
			if (marriageCertificateRestDTO.getSecondWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getSecondWitnPhotograph()
							.isEmpty()) {
				String doc10 = marriageCertificateRestDTO.getSecondWitnPhotograph();

				files[9] = doc10;
			} else {
				String doc10 = "second photograph field is Required";
				condition = false;
				message.append(doc10).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnSignAndDate()!= null
					&& !marriageCertificateRestDTO.getThirdWitnSignAndDate()
							.isEmpty()) {
				String doc11 = marriageCertificateRestDTO.getThirdWitnSignAndDate();

				files[10] = doc11;
			} else {
				String doc11 = "Third witnes sign and date field is Required";
				condition = false;
				message.append(doc11).append(",");
			}
			if (marriageCertificateRestDTO.getThirdWitnPhotograph()!= null
					&& !marriageCertificateRestDTO.getThirdWitnPhotograph()
							.isEmpty()) {
				String doc12 = marriageCertificateRestDTO.getThirdWitnPhotograph();

				files[11] = doc12;
			} else {
				String doc12 = "Third witnes photograph field is Required";
				condition = false;
				message.append(doc12).append(",");
			}
			
			if (marriageCertificateRestDTO.getPriestSignAndDate()!= null
					&& !marriageCertificateRestDTO.getPriestSignAndDate()
							.isEmpty()) {
				String doc13 = marriageCertificateRestDTO.getPriestSignAndDate();

				files[12] = doc13;
			} else {
				String doc13 = "Third persites field is Required";
				condition = false;
				message.append(doc13).append(",");
			}
			if (marriageCertificateRestDTO.getMarriageCard()!= null
					&& !marriageCertificateRestDTO.getMarriageCard()
							.isEmpty()) {
				String doc14 = marriageCertificateRestDTO.getMarriageCard();

				files[13] = doc14;
			} else {
				String doc14 = "Marriage card field is Required";
				condition = false;
				message.append(doc14).append(",");
			}
			
			String doc15 = marriageCertificateRestDTO.getHusbandDivorcedProof();					
			files[14] = doc15;
			
			String doc16= marriageCertificateRestDTO.getWifeDivorcedProof();					
			files[15] = doc16;
			
			String doc17= marriageCertificateRestDTO.getPropertyTaxPaid();					
			files[16] = doc17;
			
			String doc18= marriageCertificateRestDTO.getAffidavit();					
			files[17] = doc18;
			
			String doc19= marriageCertificateRestDTO.getDeathCertificateOfSpouse();					
			files[18] = doc19;
			
			if (marriageCertificateRestDTO.getCourtFeeStamps()!= null
					&& !marriageCertificateRestDTO.getCourtFeeStamps()
							.isEmpty()) {
				String doc20 = marriageCertificateRestDTO.getCourtFeeStamps();

				files[19] = doc20;
			} else {
				String doc20 = "Court fees stamp field is Required";
				condition = false;
				message.append(doc20).append(",");
			}
			if (marriageCertificateRestDTO.getProofOfResidence()!= null
					&& !marriageCertificateRestDTO.getProofOfResidence()
							.isEmpty()) {
				String doc21 = marriageCertificateRestDTO.getProofOfResidence();

				files[20] = doc21;
			} else {
				String doc21 = "Proof of residence field is Required";
				condition = false;
				message.append(doc21).append(",");
			}
			if (marriageCertificateRestDTO.getPhotoOfHusbandAndWife()!= null
					&& !marriageCertificateRestDTO.getPhotoOfHusbandAndWife()
							.isEmpty()) {
				String doc22 = marriageCertificateRestDTO.getPhotoOfHusbandAndWife();

				files[21] = doc22;
			} else {
				String doc22 = "Husband and wife field is Required";
				condition = false;
				message.append(doc22).append(",");
			}

			// Save FilesPath
						String savedFilePath = MarriageCertificateRestController
								.saveFile(files, request);
			
			
//		
			marriageCertificate.setAadhaarNo(String.valueOf(marriageCertificateRestDTO.getApplicantaadhaarNo()));
			//marriageCertificate.setAffidavit(marriageCertificateRestDTO.getAffidavit());
			//marriageCertificate.setCourtFeeStamps(marriageCertificateRestDTO.getCourtFeeStamps());
			marriageCertificate.setDaysCalculatedForCertificate(marriageCertificateRestDTO.getDaysCalculatedForCertificate());
		//marriageCertificate.setDeathCertificateOfSpouse(marriageCertificateRestDTO.getDeathCertificateOfSpouse());
			marriageCertificate.setEmail(marriageCertificateRestDTO.getApplicantemail());
			marriageCertificate.setFeeApplicable(marriageCertificateRestDTO.getFeeApplicable());
			
			marriageCertificate.setFirstOccupOthers(marriageCertificateRestDTO.getFirstOccupOthers());
			marriageCertificate.setFirstRelationOthers(marriageCertificateRestDTO.getFirstRelationOthers());
			marriageCertificate.setFirstWitnFullAddr(marriageCertificateRestDTO.getFirstWitnFullAddr());
			marriageCertificate.setFirstWitnFullName(marriageCertificateRestDTO.getFirstWitnFullName());
			marriageCertificate.setFirstWitnOccup(marriageCertificateRestDTO.getFirstOccupOthers());
			marriageCertificate.setFirstWitnOfficeAddr(marriageCertificateRestDTO.getFirstWitnOfficeAddr());
			marriageCertificate.setFirstWitnPhotograph(marriageCertificateRestDTO.getFirstWitnPhotograph());
			marriageCertificate.setFirstWitnRelMarCouple(marriageCertificateRestDTO.getFirstWitnRelMarCouple());
			marriageCertificate.setFirstWitnSignAndDate(marriageCertificateRestDTO.getFirstWitnSignAndDate());
			marriageCertificate.setFullAddress(marriageCertificateRestDTO.getFirstWitnFullAddr());
			marriageCertificate.setFullName(marriageCertificateRestDTO.getFirstWitnFullName());
			marriageCertificate.setHusbandAadhaarNo(String.valueOf(marriageCertificateRestDTO.getHusbandAadhaarNo()));
			marriageCertificate.setHusbandAdoptReligion(marriageCertificate.getHusbandAdoptReligion());
			marriageCertificate.setHusbandAltName(marriageCertificate.getHusbandAltName());
			marriageCertificate.setHusbandBirthReligion(marriageCertificateRestDTO.getHusbandBirthReligion());
			//marriageCertificate.setHusbandDivorcedProof(marriageCertificateRestDTO.getHusbandDivorcedProof());
			marriageCertificate.setHusbandFatherName(marriageCertificateRestDTO.getHusbandFatherName());
			marriageCertificate.setHusbandFirstName(marriageCertificateRestDTO.getHusbandFirstName());
			marriageCertificate.setHusbandFullAddr(marriageCertificate.getHusbandFullAddr());
			marriageCertificate.setHusbandLastName(marriageCertificateRestDTO.getHusbandLastName());
			marriageCertificate.setHusbandOccup(marriageCertificateRestDTO.getHusbandOccup());
			marriageCertificate.setHusbandOccupOthers(marriageCertificateRestDTO.getHusbandOccupOthers());
			marriageCertificate.setHusbandOfficeAddr(marriageCertificateRestDTO.getHusbandOfficeAddr());
			marriageCertificate.setHusbandPhotograph(marriageCertificateRestDTO.getHusbandPhotograph());
			marriageCertificate.setHusbandSolemAgeMonth(String.valueOf(marriageCertificateRestDTO.getHusbandSolemAgeMonth()));
				
			marriageCertificate.setHusbandSolemAgeYear(String.valueOf(marriageCertificateRestDTO.getHusbandSolemAgeYear()));
			marriageCertificate.setHusbandStatus(marriageCertificateRestDTO.getHusbandStatus());
			marriageCertificate.setHusbandTitle(marriageCertificateRestDTO.getHusbandTitle());
			marriageCertificate.setHusbandWitnSignAndDate(marriageCertificateRestDTO.getHusbandWitnSignAndDate());
			marriageCertificate.setHusbanndAgeProof(marriageCertificateRestDTO.getHusbanndAgeProof());
			
			//marriageCertificate.setMarriageCard(marriageCertificateRestDTO.getMarriageCard());
			marriageCertificate.setMarriageCertificateID(marriageCertificate.getMarriageCertificateID());
			
			marriageCertificate.setMarriageDate(marriageCertificateRestDTO.getMarriageDate());
			marriageCertificate.setMarriageLawReligion(marriageCertificateRestDTO.getMarriageLawReligion());

			marriageCertificate.setMarriagePlace(marriageCertificateRestDTO.getMarriagePlace());
			marriageCertificate.setMiddleName(marriageCertificateRestDTO.getApplicantFatherName());
			
			marriageCertificate.setMobileNumber(String.valueOf(marriageCertificateRestDTO.getApplicantmobileNumber()));
			//marriageCertificate.setPhotoOfHusbandAndWife(marriageCertificateRestDTO.getPhotoOfHusbandAndWife());
			
			marriageCertificate.setPinCode(marriageCertificateRestDTO.getApplicantpinCode());
			marriageCertificate.setPriestAge(marriageCertificateRestDTO.getPriestAge());
			
			marriageCertificate.setPriestFullAddr(marriageCertificateRestDTO.getPriestFullAddr());
			marriageCertificate.setPriestName(marriageCertificateRestDTO.getPriestName());
			marriageCertificate.setPriestReligion(marriageCertificateRestDTO.getPriestReligion());
			marriageCertificate.setPriestSignAndDate(marriageCertificateRestDTO.getPriestSignAndDate());
			//marriageCertificate.setProofOfResidence(marriageCertificateRestDTO.getProofOfResidence());
		//	marriageCertificate.setPropertyTaxPaid(marriageCertificateRestDTO.getPropertyTaxPaid());
			marriageCertificate.setSecondOccupOthers(marriageCertificateRestDTO.getSecondOccupOthers());
			marriageCertificate.setSecondRelationOthers(marriageCertificateRestDTO.getSecondRelationOthers());
			marriageCertificate.setSecondWitnFullAddr(marriageCertificateRestDTO.getSecondWitnFullAddr());
			marriageCertificate.setSecondWitnFullName(marriageCertificateRestDTO.getSecondWitnFullName());
			marriageCertificate.setSecondWitnOccup(marriageCertificateRestDTO.getSecondWitnOccup());
			marriageCertificate.setSecondWitnOfficeAddr(marriageCertificateRestDTO.getSecondWitnOfficeAddr());
			marriageCertificate.setSecondWitnPhotograph(marriageCertificateRestDTO.getSecondWitnPhotograph());
			marriageCertificate.setSecondWitnRelMarCouple(marriageCertificateRestDTO.getSecondWitnRelMarCouple());
			
			marriageCertificate.setSecondWitnSignAndDate(marriageCertificateRestDTO.getSecondWitnSignAndDate());
			marriageCertificate.setThirdOccupOthers(marriageCertificateRestDTO.getThirdOccupOthers());
			marriageCertificate.setThirdRelationOthers(marriageCertificateRestDTO.getThirdRelationOthers());
			marriageCertificate.setThirdWitnFullAddr(marriageCertificateRestDTO.getThirdWitnFullAddr());
			marriageCertificate.setThirdWitnFullName(marriageCertificateRestDTO.getThirdWitnFullName());
			marriageCertificate.setThirdWitnOccup(marriageCertificateRestDTO.getThirdWitnOccup());
			marriageCertificate.setThirdWitnOfficeAddr(marriageCertificateRestDTO.getThirdWitnOfficeAddr());
			marriageCertificate.setThirdWitnPhotograph(marriageCertificateRestDTO.getThirdWitnPhotograph());
			marriageCertificate.setThirdWitnRelMarCouple(marriageCertificateRestDTO.getThirdWitnRelMarCouple());
			marriageCertificate.setThirdWitnSignAndDate(marriageCertificateRestDTO.getThirdWitnSignAndDate());
			marriageCertificate.setWifeAadhaarNo(String.valueOf(marriageCertificateRestDTO.getWifeAadhaarNo()));
			marriageCertificate.setWifeAdoptReligion(marriageCertificateRestDTO.getWifeAdoptReligion());
			marriageCertificate.setWifeAgeProof(marriageCertificateRestDTO.getWifeAgeProof());
			marriageCertificate.setWifealtName(marriageCertificateRestDTO.getWifealtName());
			marriageCertificate.setWifeBirthReligion(marriageCertificateRestDTO.getWifeBirthReligion());
		//	marriageCertificate.setWifeDivorcedProof(marriageCertificateRestDTO.getWifeDivorcedProof());
			marriageCertificate.setWifeFatherName(marriageCertificateRestDTO.getWifeFirstName());
			marriageCertificate.setWifeFirstName(marriageCertificateRestDTO.getWifeFirstName());
			marriageCertificate.setWifeFullAddress(marriageCertificateRestDTO.getWifeFullAddress());
			marriageCertificate.setWifeLastName(marriageCertificateRestDTO.getWifeLastName());
			marriageCertificate.setWifePhotograph(marriageCertificateRestDTO.getWifePhotograph());
			marriageCertificate.setWifeSolemAgeMonth(String.valueOf(marriageCertificateRestDTO.getWifeSolemAgeMonth()));
			marriageCertificate.setWifeSolemAgeYear(String.valueOf(marriageCertificateRestDTO.getWifeSolemAgeYear()));
			marriageCertificate.setWifeStatus(marriageCertificateRestDTO.getWifeStatus());
			marriageCertificate.setWifeTitle(marriageCertificateRestDTO.getWifeTitle());
			marriageCertificate.setWifeWitnSignAndDate(marriageCertificateRestDTO.getWifeWitnSignAndDate());
			//marriageCertificate.setPhotoOfHusbandAndWife(marriageCertificateRestDTO.getPhotoOfHusbandAndWife());
			marriageCertificate.setZoneNo(String.valueOf(marriageCertificateRestDTO.getZoneNo()));
			
			
		
			RTIApplication rtiApplication = new RTIApplication();
			if (marriageCertificateRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						marriageCertificateRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}			
			if (condition) {	
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			
			 rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("MARRIAGE-CERTIFICATE");
			rtiApplication.setTemplateName("MARRIAGE-Application");
			rtiApplication.setDepartment("HEALTH-DEPARTMENT");
			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(11);
			rtiApplication.setApplicantName(marriageCertificate.getFullName());
			rtiApplication.setPhoneNumber(marriageCertificate.getMobileNumber());
			rtiApplication.setMobileNumber(marriageCertificate.getMobileNumber());
			rtiApplication.setEmail(marriageCertificate.getEmail());
			rtiApplication.setMobileAppUserNumber(String.valueOf(marriageCertificate.getMobileNumber()));
			rtiApplication.setZone(marriageCertificate.getZoneNo());
			rtiApplication.setPdfUploadFromPortal(savedFilePath);

			rtiApplication.setApplicationCost(marriageCertificate.getFeeApplicable());

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
				marriageCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
				marriageCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
				long birth_regis_id =marriageCertificateService.marriageCertificate(marriageCertificate);
				rti.setRtiApplicationRefId(birth_regis_id);
				RTIApplication retunRti = rtiApplicationService.merge(rti);

				if ((retunRti != null) && (birth_regis_id > 0)) {
				marriageCertificateRestDTO.setResponseStatus("Requested data saved successfully");
				marriageCertificateRestDTO.setResponseCode(200);
				marriageCertificateRestDTO.setResult(retunRti.getRtiApplnNumber());
				marriageCertificateRestDTO.setStatus("ok");
				reponse.setStatus(HttpStatus.OK.value());

				}
				String name = marriageCertificate.getFirstName() + marriageCertificate.getLastName()
						+ marriageCertificate.getLastName();
				String applnNo = rti.getRtiApplnNumber();

				String msg = "Dear " + name + " your application with Application No. " + applnNo
						+ " submitted successfully. Kindly Save for RTS Tracking record.Regards, NMCGOV";
				msg.replace("var3", "");
				SendEmail.sendEmail(marriageCertificate.getEmail(), "Application Submitted Successfully" + applnNo, msg);
				SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", marriageCertificate.getMobileNumber(), msg);
			}
		}
		if (!condition) {
			if (message.charAt(message.length() - 1) == ',') {
				message.deleteCharAt(message.length() - 1);
				marriageCertificateRestDTO.setResult(message.toString());
				marriageCertificateRestDTO.setResponseStatus("Requested data not saved successfully");
				marriageCertificateRestDTO.setResponseCode(500);
				reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				marriageCertificateRestDTO.setStatus("Internal Server Error");
			}
		}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			marriageCertificateRestDTO.setResponseStatus(ex.getMessage());
			marriageCertificateRestDTO.setResponseCode(405);
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			marriageCertificateRestDTO.setStatus("Method not Allowed");
		}

		return new ResponseEntity<>(marriageCertificateRestDTO, HttpStatus.OK);

	}
	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "marriageForm";
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
