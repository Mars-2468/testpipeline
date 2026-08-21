package com.mars.rti.controller;

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
import com.mars.rti.model.PostPropertyTaxReassessment;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TaxExemptionNonResidential;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TaxExemptionNonResidentialService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class TaxExemptionNonResidentialController {

	private static Log log = LogFactory.getLog(TradeLicenceRenewalController.class);

	@Autowired
	private TaxExemptionNonResidentialService taxExemptionNonResidentialService;

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

	@RequestMapping("/rtsapplication/saveTaxExemptionNonResidential.do")
	// rtsapplication/saveZoneCertificates.do
	public ModelAndView saveTaxExemptionNonResidential(HttpServletRequest request, HttpServletResponse response,
			TaxExemptionNonResidential taxExemptionNonResidential) throws ServletException, Exception {
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

			if (taxExemptionNonResidential != null) {
				// TradeLicencePartnerChangeRestDTO tradeLicencePartnerChangeRestDTO = new
				// TradeLicencePartnerChangeRestDTO();
				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("TAX-EXEMPTION-NON-RESIDENTIAL");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(52);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(taxExemptionNonResidential.getName());
				rtiApplication.setPdfUploadFromPortal(taxExemptionNonResidential.getFilesPath());
				// rtiApplication.setApplicationCost(1000);
				rtiApplication.setPhoneNumber(taxExemptionNonResidential.getMobileNo());
				rtiApplication.setEmail(taxExemptionNonResidential.getEmailid());
				rtiApplication.setZone(PropertyTaxPTNDetailsController.getZoneNo(taxExemptionNonResidential.getZoneNo()));
				rtiApplication.setUserRegistrationDetails(user);

				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(taxExemptionNonResidential.getName());
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
					taxExemptionNonResidential.setRtiapplrefno(rti.getRtiApplnNumber());
					taxExemptionNonResidential.setRti_ref_id(savedRti.getRtiApplicationId());
					long trade_regis_id = taxExemptionNonResidentialService.getReferenceId(taxExemptionNonResidential);
					rti.setRtiApplicationRefId(trade_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rTIApplicationService.merge(rti);

					 String url = "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/SaveRTSRequest";
						HttpHeaders headers = new HttpHeaders();

						PostPropertyTaxReassessment postPropertyTaxMutation = new PostPropertyTaxReassessment();
						PostPropertyTaxReassessment.CitizenRequest pptm = new PostPropertyTaxReassessment.CitizenRequest();
						pptm.setCreatedBy("4377");
						pptm.setDocumentUrl(taxExemptionNonResidential.getFilesPath());
						pptm.setIndexNo(taxExemptionNonResidential.getIndexNo());
						pptm.setMeasleNo("");
						pptm.setPtn(taxExemptionNonResidential.getUpinNo());
						pptm.setRegisteredPhone(taxExemptionNonResidential.getMobileNo());
						pptm.setRequestAddress(taxExemptionNonResidential.getAddress());
						pptm.setRequesterHouseNo("");
						pptm.setRequesterLandPlotNo("");
						pptm.setRequesterMail(taxExemptionNonResidential.getEmailid());
						pptm.setRequesterMauja("");
						pptm.setRequesterMobile(taxExemptionNonResidential.getMobileNo());
						pptm.setRequesterWard(taxExemptionNonResidential.getBlockId());
						pptm.setRequestName(taxExemptionNonResidential.getName());
						pptm.setRequesterMobile(taxExemptionNonResidential.getMobileNo());
						pptm.setRequestNumber(retunRti.getRtiApplnNumber());
						pptm.setRemarks(taxExemptionNonResidential.getReason());
						pptm.setRequestType("RTSTEXNRP");
						
						postPropertyTaxMutation.setCitizenRequest(pptm);
						String token = PropertyTaxTokenGeneration.propertyTaxToken();
						postPropertyTaxMutation.setToken(token);

						RestTemplate restTemplate = new RestTemplate();
						ObjectMapper objectMapper = new ObjectMapper();
						String jsonRequestBody = objectMapper.writeValueAsString(postPropertyTaxMutation);

						headers.setContentType(MediaType.APPLICATION_JSON);

						HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

						ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
						HttpStatus statusCode = responseEntity.getStatusCode();
				        System.out.println("HTTP Status Code: " + statusCode);
				        if (statusCode == HttpStatus.OK) {
				            String responseBody = responseEntity.getBody();
				            log.debug("Response Body: " + responseBody);
				            JsonNode rootNode = objectMapper.readTree(responseBody);

				            JsonNode resultNode = rootNode.get("SaveRTSRequestResult").get("Result");
				            JsonNode resultListNode = rootNode.get("SaveRTSRequestResult").get("ResultList");
				            JsonNode responsecode = rootNode.get("SaveRTSRequestResult").get("ResponseCode");
				            JsonNode message = rootNode.get("SaveRTSRequestResult").get("ResponseMessage");


				             result = resultNode.asText();
				             resultList = resultListNode.size();
				             responseCode=responsecode.asText();
				             responseMessage=message.asText();
				           

				         
						
						if (log.isDebugEnabled()) {
							log.debug(statusCode);
							log.debug(result);
							log.debug(resultList);
						}
					}
				        if(responseCode.equals("GCPT10100")) {
				        
				        	String name = taxExemptionNonResidential.getName();
							String link = "https://tinyurl.com/4fk84wup";
							String applnNo = rti.getRtiApplnNumber();

							String msg = "Dear " + taxExemptionNonResidential.getName()
									+ " please click on this link https://tinyurl.com/5emnw6u7 to download the Certificate for your application "
									+ taxExemptionNonResidential.getRtiapplrefno()+ " Regards, NMCGOV";

							msg.replace("var3", "");
							SendEmail.sendEmail(taxExemptionNonResidential.getEmailid(), "Completion of your Appl. No." + taxExemptionNonResidential.getRtiapplrefno(), msg);
							SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", taxExemptionNonResidential.getMobileNo(), msg);
				
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxNonResidentialSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				 }else {
					 //rtiApplicationService.delete(retunRti.getRtiApplicationId());
					 request.setAttribute("message", responseMessage);
					 return new ModelAndView("newRTIPropertyTaxForNonResidential");
				 }
				}
			}
		}catch(Exception ex){
			 rtiApplicationService.delete(retunRti.getRtiApplicationId());
			 request.setAttribute("message", responseMessage);
			 return new ModelAndView("newRTIPropertyTaxForNonResidential");
		}
			
	}
		
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	
	
	@RequestMapping("ws/rtsapplication/newRtSPropertyTaxNonResidentialSuccess.do")
	public ModelAndView newRtSPropertyTaxNonResidentialSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTITaxExemptionNonResidentialSuccess");
		
		model.addObject("taxExemptionNonResidential",appNo);
		return model;
				
		
	}
	
	
	
	@RequestMapping("/rtsapplication/savePropertyTaxNonResidentialFees.do")
	public ModelAndView savePropertyTaxNonResidentialFees(HttpServletRequest request,
			HttpServletResponse response, TaxExemptionNonResidential taxExemptionNonResidential)
			throws ServletException, Exception {
		String fees = request.getParameter("fees");
		long apprefid = Long.parseLong(request.getParameter("id")); 
		RTIApplication rtsapplication;
		taxExemptionNonResidential = taxExemptionNonResidentialService.get(apprefid);
		if (taxExemptionNonResidential.getFees() == 0.0 && fees!=null && fees.length()>0) {
			apprefid = taxExemptionNonResidential.getRti_ref_id();
			rtsapplication = rtiApplicationService.get(taxExemptionNonResidential.getRti_ref_id());
			taxExemptionNonResidential.setFees(Double.parseDouble(fees));
			taxExemptionNonResidential = taxExemptionNonResidentialService.merge(taxExemptionNonResidential);
			rtsapplication.setApplicationCost(taxExemptionNonResidential.getFees());
			rtiApplicationService.save(rtsapplication);
		}
		return new ModelAndView("redirect:/rtsapplication/editNonResidentialProperty.do?rtiApplicationRefId=" + taxExemptionNonResidential.getTaxExemptionId());	
		}
	
	
	@RequestMapping("/rtsapplication/editNonResidentialProperty.do")
	public ModelAndView editNonResidentialProperty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		TaxExemptionNonResidential property = null;
		HttpSession session = request.getSession();
		System.out.println("editPropertyTaxDemand");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			property = taxExemptionNonResidentialService.get(rtiApplicationRefId);

			if (property.getRti_ref_id() > 0) {
				rtiApplicationId = property.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);

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
				if (task != null && sessionUser.getUserName().equals(task.getAssignee()))
					request.setAttribute("userAccess", 1);

				request.setAttribute("workFlowTask", task);
			} else {

				request.setAttribute("workFlowCompleted", "1");
			}
		}

		ModelAndView modelAndView = new ModelAndView("managePropertyTaxNonResidentialProperty", "propertyTaxAssessment", property);

		return modelAndView;

	}
	
	
	@RequestMapping("/rtiapplication/createPropertyTaxNonResidentialWork.do")
	public ModelAndView createPropertyTaxNonResidentialWork(HttpServletRequest request, HttpServletResponse response)
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
		TaxExemptionNonResidential taxExemptionNonResidential = taxExemptionNonResidentialService.get(applicationId);
		String email = taxExemptionNonResidential.getEmailid();
		String mobileNo = taxExemptionNonResidential.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		if (taxExemptionNonResidential != null) {
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
					String link = "https://tinyurl.com/4hhhy9w9";
					String msg = "Dear " + applicantName
							+ " your document verification has been successfully completed. Kindly use this link https://tinyurl.com/2yxwb9fd to make a payment in order for your application "
							+ rtiApplnNumber + " to be processed further.Regards, NMCGOV";

					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
					SendSMS.sendSingleSMS("1507167421309610108", "NMCGov", mobileNo, msg);

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
		return new ModelAndView("redirect:/rtsapplication/editNonResidentialProperty.do?rtiApplicationRefId="+rtirefId);
	}
	
}
