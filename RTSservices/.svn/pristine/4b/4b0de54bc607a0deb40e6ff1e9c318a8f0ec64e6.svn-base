
package com.mars.rti.controller;

import java.io.PrintWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PostPropertyTaxComplaint;
import com.mars.rti.model.PropertyComplaintRegistration;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxComplaintService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class PropertyComplaintRegistrationController {

	private static Log log = LogFactory.getLog(TradeLicenceRenewalController.class);

	@Autowired
	private PropertyTaxComplaintService taxExemptionNonResidentialService;

	@Autowired
	private RTIApplicationService rTIApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxPTNDetailsController propertyTaxPTNDetailsController;
//	
//	public ZoneCertificatesService getZoneCertificatesService() {
//		return zoneCertificatesService;
//	}
//
//	public void setzoneCertificatesService(ZoneCertificatesService zoneCertificatesService) {
//		this.zoneCertificatesService = zoneCertificatesService;
//	}

	private static final int THRESHOLD_SIZE = 102410243; // 3MB
	private static final int MAX_FILE_SIZE = 1024102410; // 10MB
	private static final int REQUEST_SIZE = 1024102450; // 50MB

	@RequestMapping("/rtsapplication/savePropertyTaxComplaint.do")
	public ModelAndView savePropertyTaxComplaint(HttpServletRequest request, HttpServletResponse response,
			PropertyComplaintRegistration propertyTaxComplaint) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Tax Exmption");
		}
		String mobileNumber = "";
		RTIApplication retunRti=null;
		String result=null;
		int resultList=0;
		String responseCode=null;
		String responseMessage=null;
		mobileNumber = (String) session.getAttribute("mobileNo");
		if (mobileNumber != null) {
			try {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);

			if (propertyTaxComplaint != null) {
				// TradeLicencePartnerChangeRestDTO tradeLicencePartnerChangeRestDTO = new
				// TradeLicencePartnerChangeRestDTO();
				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("PROPERTY-OBJECTION-REGISTRATION");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(67);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(propertyTaxComplaint.getFullName());
				rtiApplication.setPdfUploadFromPortal(propertyTaxComplaint.getFilesPath());
				// rtiApplication.setApplicationCost(1000);
				rtiApplication.setPhoneNumber(propertyTaxComplaint.getMobileNo());
				rtiApplication.setEmail(propertyTaxComplaint.getEmailId());
				rtiApplication.setZone(PropertyTaxPTNDetailsController.getZoneNo(propertyTaxComplaint.getZoneNo()));
				rtiApplication.setUserRegistrationDetails(user);

				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(propertyTaxComplaint.getFullName());
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
				RTIApplication savedRti = rTIApplicationService.merge(rtiApplication);

				// birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);

				// if(birthRegistrationService.birthRegistrationCertificate(birthRegistration){

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rTIApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/PT" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					propertyTaxComplaint.setRtiapplrefno(rti.getRtiApplnNumber());
					propertyTaxComplaint.setRti_ref_id(savedRti.getRtiApplicationId());
					long trade_regis_id = taxExemptionNonResidentialService.getReferenceId(propertyTaxComplaint);
					rti.setRtiApplicationRefId(trade_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rTIApplicationService.merge(rti);

					 String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/SaveRTSObjectionRequest";
					 //String url = "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/SaveRTSObjectionRequest";
						HttpHeaders headers = new HttpHeaders();

						PostPropertyTaxComplaint postPropertyTaxComplaint = new PostPropertyTaxComplaint();
						PostPropertyTaxComplaint.ObjectionDetail pptm = new PostPropertyTaxComplaint.ObjectionDetail();
						pptm.setCreatedBy("4377");
						pptm.setDocumentUrl(PropertyTaxUploadURLGenerationController.generateTaxUploadURL(PropertyTaxPTNDetailsController.getFilesPath(propertyTaxComplaint.getFilesPath()), request));
						pptm.setIndexNo(propertyTaxComplaint.getIndexNo());
						pptm.setNewAgeFactor(propertyTaxComplaint.getAgeFactor());
						pptm.setPtn(propertyTaxComplaint.getUpinNo());
						pptm.setNewMeasurement(propertyTaxComplaint.getBuiltUpArea());
						pptm.setNewNtb(propertyTaxComplaint.getNtb());
						pptm.setNewUsageFactor(propertyTaxComplaint.getFactorUsage());
						pptm.setOldAgeFactor(propertyTaxComplaint.getOldageFactorId());
						pptm.setOldMeasurement(propertyTaxComplaint.getOldbuiltUpArea());
						pptm.setOldNtb(propertyTaxComplaint.getOldntbId());
						pptm.setOldUsageFactor(propertyTaxComplaint.getOldfactorUsageId());
						pptm.setPtn(propertyTaxComplaint.getUpinNo());
						pptm.setRemark(propertyTaxComplaint.getObjectionRemarks());
						pptm.setRequestAddress(propertyTaxComplaint.getAddress());
						pptm.setRequesterMobile(propertyTaxComplaint.getMobileNo());
						pptm.setRequesterMail(propertyTaxComplaint.getEmailId());
						pptm.setRequestName(propertyTaxComplaint.getFullName());
						pptm.setRequesterMobile(propertyTaxComplaint.getMobileNo());
						pptm.setRequestNumber(retunRti.getRtiApplnNumber());
						pptm.setRemarks(propertyTaxComplaint.getReason());
						pptm.setRequestType("RTSObjection");
						
						postPropertyTaxComplaint.setObjectionDetail(pptm);
						String token = PropertyTaxTokenGeneration.propertyTaxToken();
						postPropertyTaxComplaint.setToken(token);

						RestTemplate restTemplate = new RestTemplate();
						ObjectMapper objectMapper = new ObjectMapper();
						String jsonRequestBody = objectMapper.writeValueAsString(postPropertyTaxComplaint);

						headers.setContentType(MediaType.APPLICATION_JSON);

						HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

						ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
						HttpStatus statusCode = responseEntity.getStatusCode();
				        System.out.println("HTTP Status Code: " + statusCode);
				        if (statusCode == HttpStatus.OK) {
				            String responseBody = responseEntity.getBody();
				            log.debug("Response Body: " + responseBody);
				            JsonNode rootNode = objectMapper.readTree(responseBody);


				            JsonNode responsecode = rootNode.get("SaveRTSObjectionRequestResult").get("ResponseCode");
				            JsonNode message = rootNode.get("SaveRTSObjectionRequestResult").get("ResponseMessage");


				            
				             responseCode=responsecode.asText();
				             responseMessage=message.asText();
				           

				         
						
				             if (log.isDebugEnabled()) {
									log.debug(statusCode);
									log.debug(result);
									log.debug(responseCode);
									log.debug(retunRti.getRtiApplnNumber());
								}
					}
				        if(responseCode.equals("GCPT10100")) {
				        
				        	String name = propertyTaxComplaint.getFullName();
				        	String applnNo = rti.getRtiApplnNumber();
				        	String mobileNo = propertyTaxComplaint.getMobileNo();
				        	String email=propertyTaxComplaint.getEmailId();
				        	SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyCompliantSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				 }else {
					 rtiApplicationService.delete(retunRti.getRtiApplicationId());
					 request.setAttribute("message", responseMessage);
					 return new ModelAndView("newRTIPropertyComplaintRegistration");
				 }
				}
			}
		}catch(Exception ex){
			 rtiApplicationService.delete(retunRti.getRtiApplicationId());
			 request.setAttribute("message", result);
			 return new ModelAndView("newRTIPropertyComplaintRegistration");
		}
			
	}
		
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	
	@RequestMapping("ws/rtsapplication/newRtSPropertyCompliantSuccess.do")
	public ModelAndView newRtSPropertyCompliantSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTIPropertyTaxComplaintSucess");
		
		model.addObject("propertyTaxComplaint",appNo);
		return model;
				
		
	}
	
	
	@RequestMapping("/rtsapplication/savePropertyTaxComplaintFees.do")
	public ModelAndView savePropertyTaxComplaintFees(HttpServletRequest request,
			HttpServletResponse response, PropertyComplaintRegistration propertyComplaintRegistration)
			throws ServletException, Exception {
		String fees = request.getParameter("fees");
		long apprefid = Long.parseLong(request.getParameter("id")); 
		RTIApplication rtsapplication;
		propertyComplaintRegistration = taxExemptionNonResidentialService.get(apprefid);
		if (propertyComplaintRegistration.getFees() == 0.0 && fees!=null && fees.length()>0) {
			apprefid = propertyComplaintRegistration.getRti_ref_id();
			rtsapplication = rtiApplicationService.get(propertyComplaintRegistration.getRti_ref_id());
			propertyComplaintRegistration.setFees(Double.parseDouble(fees));
			propertyComplaintRegistration = taxExemptionNonResidentialService.merge(propertyComplaintRegistration);
			rtsapplication.setApplicationCost(propertyComplaintRegistration.getFees());
			rtiApplicationService.save(rtsapplication);
		}
		return new ModelAndView("redirect:/rtsapplication/editPropertyComplaint.do?rtiApplicationRefId=" + propertyComplaintRegistration.getPropertyComplaintRegistrationID());	
		}
	
	
		/*
		 * @RequestMapping("/rtsapplication/editPropertyComplaint.do") public
		 * ModelAndView editPropertyComplaint(HttpServletRequest request,
		 * HttpServletResponse response) throws ServletException, Exception {
		 * 
		 * PropertyComplaintRegistration propertyComplaint = null; HttpSession session =
		 * request.getSession(); System.out.println("editPropertyTaxDemand"); long
		 * rtiApplicationRefId = 0; long rtiApplicationId = 0; RTIApplication
		 * rtiapplication = null; SessionUser sessionUser = (SessionUser)
		 * session.getAttribute("SessionUser"); if
		 * (request.getParameter("rtiApplicationRefId") != null &&
		 * request.getParameter("rtiApplicationRefId").length() > 0) {
		 * 
		 * rtiApplicationRefId =
		 * Long.parseLong(request.getParameter("rtiApplicationRefId"));
		 * propertyComplaint =
		 * taxExemptionNonResidentialService.get(rtiApplicationRefId);
		 * 
		 * if (propertyComplaint.getRti_ref_id() > 0) { rtiApplicationId =
		 * propertyComplaint.getRti_ref_id(); rtiapplication =
		 * rtiApplicationService.get(rtiApplicationId); } else { List<RTIApplication>
		 * listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
		 * rtiApplicationRefId); if (listRTI != null && !listRTI.isEmpty()) {
		 * rtiApplicationId = listRTI.get(0).getRtiApplicationId(); rtiapplication =
		 * listRTI.get(0); } } }
		 * 
		 * request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		 * request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		 * request.setAttribute("rtiApplication", rtiapplication);
		 * 
		 * WorkflowProcessDetails workflowProcessDetails = null; WorkflowProcessDetails
		 * processDetails = null; workflowProcessDetails = workflowProcessDetailsService
		 * .getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * 
		 * if (workflowProcessDetails != null) { String processId =
		 * workflowProcessDetails.getProcessId(); if (processId != null) {
		 * processDetails =
		 * workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId)
		 * ; } if (!workflowService.isProcessEnded(processId)) { String taskId =
		 * workflowService.getCurrentTaskId(processId); Task task = null; if (taskId !=
		 * null) task = taskService.getTask(taskId); if (processDetails != null) {
		 * PersonalTask personalTask = new PersonalTask(); personalTask.setTask(task);
		 * personalTask.setEntityId(processDetails.getEntityId());
		 * personalTask.setEntityName(processDetails.getEntityName());
		 * personalTask.setWorkflowInitator(processDetails.getUserName());
		 * personalTask.setEntityDetails(processDetails.getEntityDetails());
		 * request.setAttribute("personalTask", personalTask); } if (task != null &&
		 * sessionUser.getUserName().equals(task.getAssignee()))
		 * request.setAttribute("userAccess", 1);
		 * 
		 * request.setAttribute("workFlowTask", task); } else {
		 * 
		 * request.setAttribute("workFlowCompleted", "1"); } }
		 * 
		 * ModelAndView modelAndView = new ModelAndView("managePropertyComplaint",
		 * "propertyTaxAssessment", propertyComplaint);
		 * 
		 * return modelAndView;
		 * 
		 * }
		 */
	
	@RequestMapping("/rtsapplication/createPropertyTaxComplaint.do")
	public ModelAndView createPropertyTaxComplaint(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		
			String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
			long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
			RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

			HttpSession session = request.getSession();
			SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

			WorkflowProcessDetails workflowProcessDetails = null;
			WorkflowProcessDetails processDetails = null;
			workflowProcessDetails = workflowProcessDetailsService
					.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);

			String id = request.getParameter("id");
			long applicationId = Long.parseLong(id);
			PropertyComplaintRegistration propertyComplaintRegistration = taxExemptionNonResidentialService.get(applicationId);
			String email = propertyComplaintRegistration.getEmailId();
			String mobileNo = propertyComplaintRegistration.getMobileNo();
			String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
			String applicantName = rtiApplication.getApplicantName();
			long rtirefId = rtiApplication.getRtiApplicationRefId();
			if (propertyComplaintRegistration != null) {
				if (workflowProcessDetails != null) {
					String processId = workflowProcessDetails.getProcessId();
					if (processId != null) {
						processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
					}
					if (!workflowService.isProcessEnded(processId)) {
						String taskId = workflowService.getCurrentTaskId(processId);
						Task task = null;
						if (taskId != null)
							task = taskService.getTask(taskId);
						if (processDetails != null) {
							PersonalTask personalTask = new PersonalTask();
							personalTask.setTask(task);
							personalTask.setEntityId(processDetails.getEntityId());
							personalTask.setEntityName(processDetails.getEntityName());
							personalTask.setWorkflowInitator(processDetails.getUserName());
							personalTask.setEntityDetails(processDetails.getEntityDetails());
							request.setAttribute("personalTask", personalTask);
						}

						rtiApplication.setWorkFlowStatus(3);
						rtiApplicationService.save(rtiApplication);
						String paymentLink="http://tinyurl.com";
						String paymentLink2="ysvdjecd";
						
					    String msg = "Dear "+applicantName+" your document verification has been successfully completed. Kindly use this link "+paymentLink+"/"+paymentLink2+" to make a payment in order for your application "+rtiApplnNumber+" to be processed further. Regards, NMCGOV";

					    
						msg.replace("var3", "");
						SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
						SendSMS.sendSingleSMS("1707168751764084788", "NMCGov", mobileNo, msg);

						if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
								|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

						}
						if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
							request.setAttribute("userAccess", 1);
							request.setAttribute("workFlowTask", task);
						}
					} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

						rtiApplication.setWorkFlowStatus(1);
						rtiApplicationService.save(rtiApplication);
						String msg = "Dear " + applicantName
								+ " please click on this link https://tinyurl.com/359w8usz to download the Certificate for your application "
								+ rtiApplnNumber + " Regards, NMCGOV";

						msg.replace("var3", "");
						SendEmail.sendEmail(email, "Completion of your Appl. No." + rtiApplnNumber, msg);
						SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", mobileNo, msg);
						request.setAttribute("workFlowCompleted", "1");
					} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
						rtiApplication.setWorkFlowStatus(5);
						rtiApplicationService.save(rtiApplication);
						String msg = "Dear " + applicantName + " your " + rtiApplnNumber
								+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/359w8usz to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
						msg.replace("var3", "");
						SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
						SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
						request.setAttribute("workFlowCompleted", "1");
					}
				}

			}
			request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
			request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
			request.setAttribute("rtiApplication", rtiApplication);
			request.setAttribute("rtiApplicationRefId", rtiApplicationId);
			return new ModelAndView("redirect:/rtsapplication/editPropertyComplaint.do?rtiApplicationRefId="+rtirefId);
		}
	
	
	@RequestMapping("/rtsapplication/getPropertyMeasurementDetails.do")
	public void getPropertyMeasurementDetails(HttpServletRequest request,HttpServletResponse response)throws ServletException {
		try {
			
			JSONObject json = new JSONObject();
			String resultValue=null;
			
			//String URL="https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetRTSPropertyMeasurementList";
			String URL="https://nmctax.cybertech.com/GeocivicServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetRTSPropertyMeasurementList";

			 RestTemplate restTemplate = new RestTemplate();

		        HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_JSON);

		        String token = PropertyTaxTokenGeneration.propertyTaxToken();
		        String ptn = request.getParameter("upinNo");

		        String jsonRequestBody = "{ \"PTN\": \"" + ptn + "\", \"token\": \"" + token + "\" }";

		        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
		        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);

		        HttpStatus statusCode = responseEntity.getStatusCode();
		        System.out.println("HTTP Status Code: " + statusCode);
		        if (statusCode == HttpStatus.OK) {
		            String responseBody = responseEntity.getBody();
		            System.out.println("Response Body: " + responseBody);
		            ObjectMapper objectMapper = new ObjectMapper();
		            JsonNode jsonNode = objectMapper.readTree(responseBody);

		            JsonNode resultList = jsonNode.get("GetRTSPropertyMeasurementListResult").get("ResultList");
		                JsonNode item = resultList.get(0);
		                String ageFactor = item.get("AGEFACTOR").asText();
		                int ageFactorId = item.get("AGE_FACTOR_ID").asInt();
		                int ntbid = item.get("BUIDLING_TYPE_ID").asInt();
		                String netArea = item.get("MEASURMENT_NETAREA").asText();
		                String ntb = item.get("NTB").asText();
		                String usageFactor = item.get("USAGEFACTOR").asText();
		                int usageFactorId = item.get("USAGE_FACTOR_ID").asInt();
		                
		                json.put("oldntb", ntb);
		                json.put("oldntbId", ntbid);
		                
		                json.put("oldfactorUsage", usageFactor);
		                json.put("oldfactorUsageId", usageFactorId);
		                
		                json.put("oldageFactor", ageFactor);
		                json.put("oldageFactorId", ageFactorId);
		                
		                json.put("oldbuiltUpArea", netArea);
		        		PrintWriter pw = response.getWriter();

		        		pw.print(json.toString());
		        		pw.flush();
		        		pw.close();
		          
		            }
		            
		}catch(Exception ex) {
			
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
		
		        
	
	
	
		@RequestMapping("/rtsapplication/getPropertyNtbList.do")
		public void getPropertyNtbList(HttpServletRequest request,HttpServletResponse response)throws ServletException {
			try {
				
				JSONObject json = new JSONObject();
				
				//String URL="https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";
				String URL="https://nmctax.cybertech.com/GeocivicServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";
				 RestTemplate restTemplate = new RestTemplate();

			        HttpHeaders headers = new HttpHeaders();
			        headers.setContentType(MediaType.APPLICATION_JSON);

			        String token = PropertyTaxTokenGeneration.propertyTaxToken();

			        String jsonRequestBody = "{ " +
			    		    "\"input\": { " +
			    		        "\"LevelType\": \"NTB\", " +
			    		        "\"ID\": \"65\", " +
			    		        "\"ClientId\": \"3\" " +
			    		    "}, " +
			    		    "\"token\": \"" + token + "\"" +
			    		"}";
			        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);

			        HttpStatus statusCode = responseEntity.getStatusCode();
			        System.out.println("HTTP Status Code: " + statusCode);
			        if (statusCode == HttpStatus.OK) {
			            String responseBody = responseEntity.getBody();
			            System.out.println("Response Body: " + responseBody);
			            
			            ObjectMapper objectMapper = new ObjectMapper();

			            JsonNode rootNode = objectMapper.readTree(responseBody);

			            JsonNode resultList = rootNode.path("GetDropdownListResult").path("ResultList");

			            String[] displayNames = new String[resultList.size()];
			            int[] ids = new int[resultList.size()];

			            for (int i = 0; i < resultList.size(); i++) {
			                JsonNode item = resultList.get(i);
			                displayNames[i] = item.get("DisplayName").asText();
			                ids[i] = item.get("ID").asInt();
			        		
			          
			            }
			            
			            json.put("displayName", displayNames);
			            json.put("Id", ids);
			            PrintWriter pw = response.getWriter();

		        		pw.print(json.toString());
		        		pw.flush();
		        		pw.close();
			            
			}
			        
			}catch(Exception ex) {
				
				log.error(ex.getMessage());
				ex.printStackTrace();
			}
		
	
	
		}
		
		
		
		
		@RequestMapping("/rtsapplication/getPropertyAgeFactorList.do")
		public void getPropertyAgeFactorList(HttpServletRequest request,HttpServletResponse response)throws ServletException {
			try {
				
				JSONObject json = new JSONObject();
				
				//String URL="https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";
				String URL="https://nmctax.cybertech.com/GeocivicServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";

				 RestTemplate restTemplate = new RestTemplate();

			        HttpHeaders headers = new HttpHeaders();
			        headers.setContentType(MediaType.APPLICATION_JSON);

			        String token = PropertyTaxTokenGeneration.propertyTaxToken();

			        String jsonRequestBody = "{ " +
			    		    "\"input\": { " +
			    		        "\"LevelType\": \"AgeFactor\", " +
			    		        "\"ID\": \"66\", " +
			    		        "\"ClientId\": \"3\" " +
			    		    "}, " +
			    		    "\"token\": \"" + token + "\"" +
			    		"}";
			        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);

			        HttpStatus statusCode = responseEntity.getStatusCode();
			        System.out.println("HTTP Status Code: " + statusCode);
			        if (statusCode == HttpStatus.OK) {
			            String responseBody = responseEntity.getBody();
			            System.out.println("Response Body: " + responseBody);
			            
			            ObjectMapper objectMapper = new ObjectMapper();

			            JsonNode rootNode = objectMapper.readTree(responseBody);

			            JsonNode resultList = rootNode.path("GetDropdownListResult").path("ResultList");

			            String[] displayNames = new String[resultList.size()];
			            int[] ids = new int[resultList.size()];

			            for (int i = 0; i < resultList.size(); i++) {
			                JsonNode item = resultList.get(i);
			                displayNames[i] = item.get("DisplayName").asText();
			                ids[i] = item.get("ID").asInt();
			        		
			          
			            }
			            
			            json.put("displayName", displayNames);
			            json.put("Id", ids);
			            PrintWriter pw = response.getWriter();

		        		pw.print(json.toString());
		        		pw.flush();
		        		pw.close();
			            
			}
			        
			}catch(Exception ex) {
				
				log.error(ex.getMessage());
				ex.printStackTrace();
			}
		
	
	
		}
		
		

		@RequestMapping("/rtsapplication/getPropertyUsageFactorList.do")
		public void getPropertyUsageFactorList(HttpServletRequest request,HttpServletResponse response)throws ServletException {
			try {
				
				JSONObject json = new JSONObject();
				
				//String URL="https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";
				String URL="https://nmctax.cybertech.com/GeocivicServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/GetDropdownList";

				 RestTemplate restTemplate = new RestTemplate();

			        HttpHeaders headers = new HttpHeaders();
			        headers.setContentType(MediaType.APPLICATION_JSON);

			        String token = PropertyTaxTokenGeneration.propertyTaxToken();

			        String jsonRequestBody = "{ " +
			    		    "\"input\": { " +
			    		        "\"LevelType\": \"Usagefactor\", " +
			    		        "\"ID\": \"63\", " +
			    		        "\"ClientId\": \"3\" " +
			    		    "}, " +
			    		    "\"token\": \"" + token + "\"" +
			    		"}";
			        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);

			        HttpStatus statusCode = responseEntity.getStatusCode();
			        System.out.println("HTTP Status Code: " + statusCode);
			        if (statusCode == HttpStatus.OK) {
			            String responseBody = responseEntity.getBody();
			            System.out.println("Response Body: " + responseBody);
			            
			            ObjectMapper objectMapper = new ObjectMapper();

			            JsonNode rootNode = objectMapper.readTree(responseBody);

			            JsonNode resultList = rootNode.path("GetDropdownListResult").path("ResultList");

			            String[] displayNames = new String[resultList.size()];
			            int[] ids = new int[resultList.size()];

			            for (int i = 0; i < resultList.size(); i++) {
			                JsonNode item = resultList.get(i);
			                displayNames[i] = item.get("DisplayName").asText();
			                ids[i] = item.get("ID").asInt();
			        		
			          
			            }
			            
			            json.put("displayName", displayNames);
			            json.put("Id", ids);
			            PrintWriter pw = response.getWriter();

		        		pw.print(json.toString());
		        		pw.flush();
		        		pw.close();
			            
			}
			        
			}catch(Exception ex) {
				
				log.error(ex.getMessage());
				ex.printStackTrace();
			}
		
	
	
		}
		
		
		@RequestMapping("/rtsapplication/editPropertyComplaint.do")
		public ModelAndView editPropertyComplaint(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, Exception {

			PropertyComplaintRegistration propertyComplaint = null;
			HttpSession session = request.getSession();
			System.out.println("editPropertyTaxDemand");
			long rtiApplicationRefId = 0;
			long rtiApplicationId = 0;
			RTIApplication rtiapplication = null;
			SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			if (sessionUser != null) {
				if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {

				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				propertyComplaint = taxExemptionNonResidentialService.get(rtiApplicationRefId);

				if (propertyComplaint.getRti_ref_id() > 0) {
					rtiApplicationId = propertyComplaint.getRti_ref_id();
					rtiapplication = rtiApplicationService.get(rtiApplicationId);
				} else {
					List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
							rtiApplicationRefId);
					if (listRTI != null && !listRTI.isEmpty()) {
						rtiApplicationId = listRTI.get(0).getRtiApplicationId();
						rtiapplication = listRTI.get(0);
					}
				}

	      			request.setAttribute("rtiApplication", rtiapplication);



				} 
			}else {
				return new ModelAndView("/login.do");
			}
			return new ModelAndView("managePropertyComplaint", "propertyTaxAssessment", propertyComplaint);
		}
}
		        

		
	


