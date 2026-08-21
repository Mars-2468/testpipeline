package com.mars.rti.ws.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.controller.PropertyTaxToken;
import com.mars.rti.controller.PropertyTaxTokenGeneration;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.controller.TokenResponse;
import com.mars.rti.model.PropertyTaxUtara;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxUtaraService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PropertyTaxUtaraRestDTO;

@Controller
public class PropertyTaxUtaraRestController {

	private static Log log = LogFactory.getLog(PropertyTaxUtaraRestController.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxUtaraService propertyTaxUtaraService;

	@RequestMapping(method = RequestMethod.POST, value = "/savePropertyTaxUtara")
	public @ResponseBody PropertyTaxUtaraRestDTO savePropertyTaxUtara(
			@RequestBody PropertyTaxUtaraRestDTO propertyTaxUtaraRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String result = null;
		if (log.isDebugEnabled()) {
			log.debug("Invoking savePropertyTaxUtara");
		}

		PropertyTaxUtara propertyTaxUtara = new PropertyTaxUtara();

		try {

			if ((propertyTaxUtaraRestDTO.getFirstName() != null) && !propertyTaxUtaraRestDTO.getFirstName().isEmpty()) {
				propertyTaxUtara.setFirstName(propertyTaxUtaraRestDTO.getFirstName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}

			if ((propertyTaxUtaraRestDTO.getEmail() != null) && !propertyTaxUtaraRestDTO.getEmail().isEmpty()) {
				propertyTaxUtara.setEmail(propertyTaxUtaraRestDTO.getEmail());
			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}

			if ((propertyTaxUtaraRestDTO.getMobileNo() != null) && !propertyTaxUtaraRestDTO.getMobileNo().isEmpty()) {
				propertyTaxUtara.setMobileNo(propertyTaxUtaraRestDTO.getMobileNo());
			} else {
				String mobile = "Mobile Number  field is Required";
				condition = false;
				message.append(mobile).append(",");
			}


				propertyTaxUtara.setAreasPending(propertyTaxUtaraRestDTO.getAreasPending());
		

			if (propertyTaxUtaraRestDTO.getAreasPendingStatus() != null && !propertyTaxUtaraRestDTO.getAreasPendingStatus().isEmpty()){
				propertyTaxUtara.setAreasPendingStatus(propertyTaxUtaraRestDTO.getAreasPendingStatus());
			} else {
				String areastatus = "Arrears Status   field is Required";
				condition = false;
				message.append(areastatus).append(",");
			}

				propertyTaxUtara.setDuesAmt(propertyTaxUtaraRestDTO.getDuesAmt());
			
		
			if ((propertyTaxUtaraRestDTO.getHoldersName() != null)
					&& !propertyTaxUtaraRestDTO.getHoldersName().isEmpty()) {
				propertyTaxUtara.setHoldersName(propertyTaxUtaraRestDTO.getHoldersName());
			} else {
				String pname = "Property Holder Name   field is Required";
				condition = false;
				message.append(pname).append(",");
			}
			
			if (propertyTaxUtaraRestDTO.getUpinno() != null && !propertyTaxUtaraRestDTO.getUpinno().isEmpty()) {

				propertyTaxUtara.setUpinNo(propertyTaxUtaraRestDTO.getUpinno());
				propertyTaxUtara.setIndexNo(propertyTaxUtaraRestDTO.getIndexNo());

			} else if (propertyTaxUtaraRestDTO.getIndexNo() != null && !propertyTaxUtaraRestDTO.getIndexNo().isEmpty()) {
				
				propertyTaxUtara.setIndexNo(propertyTaxUtaraRestDTO.getIndexNo());
			} else {
				String indexUpin = "UPIN/Index No. field is Required";
				condition = false;
				message.append(indexUpin).append(",");
			}

			RTIApplication rtiApplication = new RTIApplication();
			if (propertyTaxUtaraRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(propertyTaxUtaraRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}

			if (condition) {
				String url = CoreConstants.TAX_REPORT_API;

				HttpHeaders headers = new HttpHeaders();

				PropertyTaxToken propertyTax = new PropertyTaxToken();
				propertyTax.setClientId(3);

				PropertyTaxToken.RptInput rptInpt = new PropertyTaxToken.RptInput();
				rptInpt.setReportKey("dcb_tax_report");

				PropertyTaxToken.RptInput.ReportParameter reportParameter = new PropertyTaxToken.RptInput.ReportParameter();
				reportParameter.setPtn(propertyTaxUtara.getUpinNo());

				rptInpt.setReportParameter(reportParameter);
				propertyTax.setRptInpt(rptInpt);

				String token = PropertyTaxTokenGeneration.propertyTaxToken();
				propertyTax.setToken(token);

				RestTemplate restTemplate = new RestTemplate();
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonRequestBody = objectMapper.writeValueAsString(propertyTax);

				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

				ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
						requestEntity, TokenResponse.class);

				TokenResponse tokenResponse = responseEntity.getBody();
				String code = tokenResponse.getErrorCode();
				result = tokenResponse.getResult();
				HttpStatus statusCode = responseEntity.getStatusCode();

				if (log.isDebugEnabled()) {
					log.debug("Invoking propertyAssessmentToken = " + token);
					log.debug(statusCode);
					log.debug(code);
					log.debug(result);
				}
				if (result != null && result.length() > 0) {
					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setTemplateName("propertytax");
					rtiApplication.setSubject("PROPERTY-TAX-UTARA-CERTIFICATE");
					rtiApplication.setDepartment("TAX-DEPARTMENT");
					rtiApplication.setWorkFlowStatus(1);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(55);
					rtiApplication.setApplicantName(propertyTaxUtara.getFirstName() + " "
							+ propertyTaxUtara.getMiddleName() + " " + propertyTaxUtara.getLastName());
					rtiApplication.setPhoneNumber(propertyTaxUtara.getMobileNo());
					rtiApplication.setMobileNumber(propertyTaxUtara.getMobileNo());
					rtiApplication.setEmail(propertyTaxUtara.getEmail());
					rtiApplication.setZone(propertyTaxUtara.getZoneNo());

					rtiApplication.setApplicantName(propertyTaxUtara.getFirstName());
					rtiApplication.setPdfFilesSavedPath(result);
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
						propertyTaxUtara.setRtiapplrefno(rti.getRtiApplnNumber());
						propertyTaxUtara.setRti_ref_id(savedRti.getRtiApplicationId());
						long birth_regis_id = propertyTaxUtaraService.propertyTaxUtara(propertyTaxUtara);
						rti.setRtiApplicationRefId(birth_regis_id);
						RTIApplication retunRti = rtiApplicationService.merge(rti);

						if ((retunRti != null) && (birth_regis_id > 0)) {
							propertyTaxUtaraRestDTO.setResponseStatus("Requested data saved successfully");
							propertyTaxUtaraRestDTO.setResult(retunRti.getRtiApplnNumber());
							propertyTaxUtaraRestDTO.setResponse(HttpStatus.OK.value());
							response.setStatus(HttpStatus.OK.value());
							propertyTaxUtaraRestDTO.setResponseStatus("ok");
							propertyTaxUtaraRestDTO.setDcbReport(result);


						}
						String name = rti.getApplicantName();
						String applnNo = rti.getRtiApplnNumber();
						String mobileNo = propertyTaxUtara.getMobileNo();
						String email = propertyTaxUtara.getEmail();
						SendSMSEmailController.sendApplicationCompleted(name, mobileNo, applnNo, email);

					}
				} else {
					condition = false;
	            	  String invalidUpin="UPIN/Index No. is Invalid";
					message.append(invalidUpin).append("");
				}
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					propertyTaxUtaraRestDTO.setResult(message.toString());
					propertyTaxUtaraRestDTO.setResponseStatus("Requested data not saved successfully");
					propertyTaxUtaraRestDTO.setResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					propertyTaxUtaraRestDTO.setResponseStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			propertyTaxUtaraRestDTO.setResponseStatus(ex.getMessage());
			propertyTaxUtaraRestDTO.setResponse(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			propertyTaxUtaraRestDTO.setResponseStatus("Method not Allowed");
		}
		return propertyTaxUtaraRestDTO;
	}

}
