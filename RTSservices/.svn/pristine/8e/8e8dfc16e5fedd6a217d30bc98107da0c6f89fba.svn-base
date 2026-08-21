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
import com.mars.rti.controller.PropertyTaxDemandToken;
import com.mars.rti.controller.PropertyTaxTokenGeneration;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.controller.TokenResponse;
import com.mars.rti.model.PropertyTaxDemand;
import com.mars.rti.model.PropertyTaxUtara;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxDemandService;
import com.mars.rti.service.PropertyTaxUtaraService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PropertyTaxDemandRestDTO;
import com.mars.rti.ws.model.PropertyTaxUtaraRestDTO;

@Controller

public class PropertyTaxDemandRestController {
	
	private static Log log = LogFactory.getLog(PropertyTaxDemandRestController.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxDemandService propertyTaxDemandService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/savePropertyTaxDemand")
	public @ResponseBody PropertyTaxDemandRestDTO savePropertyTaxDemand(
			@RequestBody PropertyTaxDemandRestDTO propertyTaxDemandRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String result=null;
		if (log.isDebugEnabled()) {
			log.debug("Invoking savePropertyTaxDemand");
		}
		
		PropertyTaxDemand propertyTaxDemand = new PropertyTaxDemand();
		
		try {

			if ((propertyTaxDemandRestDTO.getFullName() != null) && !propertyTaxDemandRestDTO.getFullName().isEmpty()) {
				propertyTaxDemand.setFullName(propertyTaxDemandRestDTO.getFullName());
			} else {
				String firstName = "Name field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			
			if ((propertyTaxDemandRestDTO.getEmailId() != null) && !propertyTaxDemandRestDTO.getEmailId().isEmpty()) {
				propertyTaxDemand.setEmailId(propertyTaxDemandRestDTO.getEmailId());
			} else {
				String email = "Email field is Required";
				condition = false;
				message.append(email).append(",");
			}
			
			
				propertyTaxDemand.setAreasPending(propertyTaxDemandRestDTO.getAreasPending());
		
			
			
			if ((propertyTaxDemandRestDTO.getAreasPendingStatus() != null) && !propertyTaxDemandRestDTO.getAreasPendingStatus().isEmpty()) {
				propertyTaxDemand.setAreasPendingStatus(propertyTaxDemandRestDTO.getAreasPendingStatus());
			} else {
				String areastatus = "Arrears Status  field is Required";
				condition = false;
				message.append(areastatus).append(",");
			}
			
			
				propertyTaxDemand.setDuesAmt(propertyTaxDemandRestDTO.getDuesAmt());
			
			
			
			if ((propertyTaxDemandRestDTO.getMobileNo() != null) && !propertyTaxDemandRestDTO.getMobileNo().isEmpty()) {
				propertyTaxDemand.setMobileNo(propertyTaxDemandRestDTO.getMobileNo());
			} else {
				String mobile = "  Mobile  field is Required";
				condition = false;
				message.append(mobile).append(",");
			}
			
			
			if (propertyTaxDemandRestDTO.getUpinNo() != null && !propertyTaxDemandRestDTO.getUpinNo().isEmpty()) {

				propertyTaxDemand.setUpinNo(propertyTaxDemandRestDTO.getUpinNo());
				propertyTaxDemand.setIndexNo(propertyTaxDemandRestDTO.getIndexNo());

			} else if (propertyTaxDemandRestDTO.getIndexNo() != null && !propertyTaxDemandRestDTO.getIndexNo().isEmpty()) {
				propertyTaxDemand.setIndexNo(propertyTaxDemandRestDTO.getIndexNo());
			} else {
				String indexUpin = "UPIN/Index No. field is Required";
				condition = false;
				message.append(indexUpin).append(",");
			}
			
			
			if ((propertyTaxDemandRestDTO.getNameOfProperyHolder() != null) && !propertyTaxDemandRestDTO.getNameOfProperyHolder().isEmpty()) {
				propertyTaxDemand.setNameOfProperyHolder(propertyTaxDemandRestDTO.getNameOfProperyHolder());
			} else {
				String nameOfProperyHolder = " NameOfProperyHolder  field is Required";
				condition = false;
				message.append(nameOfProperyHolder).append(",");
			}
			
			RTIApplication rtiApplication = new RTIApplication();
			if (propertyTaxDemandRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(propertyTaxDemandRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}

			if (condition) {
				String url = CoreConstants.TAX_REPORT_API;
				HttpHeaders headers = new HttpHeaders();

				PropertyTaxDemandToken propertyTax = new PropertyTaxDemandToken();
				propertyTax.setClientId(3);

				PropertyTaxDemandToken.RptInput rptInpt = new PropertyTaxDemandToken.RptInput();
				rptInpt.setReportKey("BillReceipt");
                

				PropertyTaxDemandToken.RptInput.ReportParameter reportParameter = new PropertyTaxDemandToken.RptInput.ReportParameter();
				reportParameter.setPtn(propertyTaxDemand.getUpinNo());
				if(propertyTaxDemand.getUpinNo()!=null) {
					reportParameter.setIsOldPin("false");
				}else {
					reportParameter.setIsOldPin("true");
				}
				reportParameter.setClientId(3);
				rptInpt.setReportParameter(reportParameter);
				propertyTax.setRptInpt(rptInpt);

				String token = PropertyTaxTokenGeneration.propertyTaxToken();
				propertyTax.setToken(token);
				

				RestTemplate restTemplate = new RestTemplate();
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonRequestBody = objectMapper.writeValueAsString(propertyTax);

				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

				ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, TokenResponse.class);

			    TokenResponse tokenResponse = responseEntity.getBody();
			    String code = tokenResponse.getErrorCode();
			     result = tokenResponse.getResult();
				HttpStatus statusCode = responseEntity.getStatusCode();

				
				if (log.isDebugEnabled()) {
					log.debug("Invoking propertyAssessmentToken = "
							+ token);
					log.debug(statusCode);
					log.debug(code);
					log.debug(result);
				}
			}
              if(result!=null && result.length()>0) {
          		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("PROPERTY-TAX-DEMAND");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setWorkFlowStatus(1);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(72);
				rtiApplication.setApplicantName(propertyTaxDemand.getFullName());
				rtiApplication.setPhoneNumber(propertyTaxDemand.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxDemand.getMobileNo());
				rtiApplication.setZone(propertyTaxDemand.getZoneNo());

				rtiApplication.setEmail(propertyTaxDemand.getEmailId());


				rtiApplication.setApplicantName(propertyTaxDemand.getFullName());
				rtiApplication.setPdfFilesSavedPath(result);
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/TD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					propertyTaxDemand.setRtiApplRefNo(rti.getRtiApplnNumber());
					propertyTaxDemand.setRtiRefId(savedRti.getRtiApplicationId());
					long zone_regis_id = propertyTaxDemandService.propertyTaxDemand(propertyTaxDemand);
					rti.setRtiApplicationRefId(zone_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (zone_regis_id > 0)) {
						
						propertyTaxDemandRestDTO.setResponseStatus("Requested data saved successfully");
						propertyTaxDemandRestDTO.setResult(retunRti.getRtiApplnNumber());
						response.setStatus(HttpStatus.OK.value());
						propertyTaxDemandRestDTO.setStatus("ok");
						propertyTaxDemandRestDTO.setResponseCode("200 ok");
						propertyTaxDemandRestDTO.setDemand(result);
						


					}
					String name = rti.getApplicantName();
		        	String applnNo = rti.getRtiApplnNumber();
		        	String mobileNo = propertyTaxDemand.getMobileNo();
		        	String email=propertyTaxDemand.getEmailId();
		        	SendSMSEmailController.sendApplicationCompleted(name, mobileNo, applnNo, email);

				}
              }else {
            	  condition=false;
            	  String invalidUpin="UPIN/Index No. is Invalid";
            	  message.append(invalidUpin).append("");
			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					propertyTaxDemandRestDTO.setResult(message.toString());
					propertyTaxDemandRestDTO.setResponseStatus(
							"Requested data not saved successfully");
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					propertyTaxDemandRestDTO.setStatus("Internal Server Error");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			propertyTaxDemandRestDTO.setResponseStatus(ex.getMessage());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			propertyTaxDemandRestDTO.setStatus("Method not Allowed");
		}
		return propertyTaxDemandRestDTO;
	}
			
	
}
