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
import com.mars.rti.model.NewlyConstructedProperty;
import com.mars.rti.model.PostPropertyTaxMutation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.NewlyConstructedPropertyService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class NewlyConstructedPropertyController {
//	extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(MandapPermissionController.class);
	@Autowired
	private NewlyConstructedPropertyService newlyConstructedPropertyService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private PropertyTaxPTNDetailsController propertyTaxPTNDetailsController;

	@RequestMapping("/rtsapplication/saveNewlyConstructedProperty.do")
	public ModelAndView saveNewlyConstructedProperty(HttpServletRequest request, HttpServletResponse response,
			NewlyConstructedProperty newlyConstructedProperty) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Newly Constructed Property");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking Newly Constructed Property");
		}
		String mobileNumber = "";
		RTIApplication retunRti = null;
		String result = null;
		int resultList = 0;
		String responseCode = null;
		String responseMessage = null;
		String user_name=null;
		Object user_login= request.getSession().getAttribute("name");
		if(user_login!=null) {
			 user_name = (String)user_login;
		}
		Object obileNumber= session.getAttribute("mobileNo");
		if(obileNumber!=null) {
		mobileNumber=String.valueOf(obileNumber);
		}else {
		mobileNumber = (String) session.getAttribute("mobileNo");
		}
		if (mobileNumber != null) {
			try {
				UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
				if (newlyConstructedProperty != null) {

					RTIApplication rtiApplication = new RTIApplication();
					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("REASSESSMENT-FOR-RENOVATION");
					rtiApplication.setDepartment("TAX-DEPARTMENT");
					rtiApplication.setTemplateName("propertytax");
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(56);
					rtiApplication.setApplicantName(newlyConstructedProperty.getFirstName() + " "
							+ newlyConstructedProperty.getMiddleName() + " " + newlyConstructedProperty.getLastName());
					rtiApplication.setPhoneNumber(newlyConstructedProperty.getMobileNo());
					rtiApplication.setMobileNumber(newlyConstructedProperty.getMobileNo());
					rtiApplication.setZone(PropertyTaxPTNDetailsController.getZoneNo(newlyConstructedProperty.getZoneNo()));

					rtiApplication.setEmail(newlyConstructedProperty.getEmail());

					// rtiApplication.setApplicationCost(newlyConstructedProperty.getFees());

					rtiApplication.setApplicantName(newlyConstructedProperty.getFullName());
					rtiApplication.setPdfUploadFromPortal(newlyConstructedProperty.getFilesPath());
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
					rtiApplication.setUserRegistrationDetails(user);

					RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
					if (savedRti.getRtiApplicationId() > 0) {

						RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
						rti.setRtiApplnNumber("RTS/PT" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
						newlyConstructedProperty.setRtiapplrefno(rti.getRtiApplnNumber());
						newlyConstructedProperty.setRti_ref_id(savedRti.getRtiApplicationId());
						long birth_regis_id = newlyConstructedPropertyService
								.newlyConstructedProperty(newlyConstructedProperty);
						rti.setRtiApplicationRefId(birth_regis_id);
						retunRti = rtiApplicationService.merge(rti);

						String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/SaveRTSRequest";

						// String url =
						// "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/SaveRTSRequest";
						HttpHeaders headers = new HttpHeaders();

						PostPropertyTaxMutation postPropertyTaxMutation = new PostPropertyTaxMutation();
						PostPropertyTaxMutation.CitizenRequest pptm = new PostPropertyTaxMutation.CitizenRequest();
						pptm.setCreatedBy("4377");
						pptm.setDocumentUrl(PropertyTaxUploadURLGenerationController.generateTaxUploadURL(PropertyTaxPTNDetailsController.getFilesPath(newlyConstructedProperty.getFilesPath()), request));

						pptm.setIndexNo(newlyConstructedProperty.getIndexNo());
						pptm.setMeasleNo(newlyConstructedProperty.getMeasleNo());
						pptm.setPtn(newlyConstructedProperty.getUpinNo());
						pptm.setRegisteredPhone(newlyConstructedProperty.getMobileNo());
						pptm.setRequestAddress(newlyConstructedProperty.getPropertyAddress());
						pptm.setRequesterHouseNo(newlyConstructedProperty.getHouseNo());
						pptm.setRequesterLandPlotNo(newlyConstructedProperty.getPlotNo());
						pptm.setRequesterMail(newlyConstructedProperty.getEmail());
						pptm.setRequesterMauja("");
						pptm.setRequesterMobile(newlyConstructedProperty.getMobileNo());
						pptm.setRequesterWard(newlyConstructedProperty.getBlockNo());
						pptm.setRequestName(newlyConstructedProperty.getFullName());
						pptm.setRequesterMobile(newlyConstructedProperty.getMobileNo());
						pptm.setRequestNumber(retunRti.getRtiApplnNumber());
						pptm.setRequestType("RTSANCP");

						postPropertyTaxMutation.setCitizenRequest(pptm);
						String token = PropertyTaxTokenGeneration.propertyTaxToken();
						postPropertyTaxMutation.setToken(token);

						RestTemplate restTemplate = new RestTemplate();
						ObjectMapper objectMapper = new ObjectMapper();
						String jsonRequestBody = objectMapper.writeValueAsString(postPropertyTaxMutation);

						headers.setContentType(MediaType.APPLICATION_JSON);

						HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

						ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
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
							responseCode = responsecode.asText();
							responseMessage = message.asText();

							if (log.isDebugEnabled()) {
								log.debug(statusCode);
								log.debug(result);
								log.debug(responseCode);
								log.debug(retunRti.getRtiApplnNumber());
							}
						}
						if (responseCode.equals("GCPT10100")) {

							String name = newlyConstructedProperty.getFullName();
							String applnNo = rti.getRtiApplnNumber();
							String mobileNo = newlyConstructedProperty.getMobileNo();
							String email=newlyConstructedProperty.getEmail();
							SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
							return new ModelAndView(
									"redirect:/ws/rtsapplication/newRtSNewConstructedPropertySuccess.do?rtsAppNo="
											+ retunRti.getRtiApplnNumber());

						} else {
							rtiApplicationService.delete(retunRti.getRtiApplicationId());
							request.setAttribute("message", responseMessage);
							return new ModelAndView("newRTSNewlyConstructedProperty");
						}
					}
				}
			} catch (Exception ex) {
				rtiApplicationService.delete(retunRti.getRtiApplicationId());
				request.setAttribute("message", responseMessage);
				return new ModelAndView("newRTSNewlyConstructedProperty");
			}

		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}

	@RequestMapping("ws/rtsapplication/newRtSNewConstructedPropertySuccess.do")
	public ModelAndView newRtSNewConstructedPropertySuccess(HttpServletRequest request, HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSNewlyConstructedPropertySuccess");

		model.addObject("newlyConstructedProperty", appNo);
		return model;

	}

//	@RequestMapping("/rtsapplication/editNewlyConstructedproperty.do")
//	public ModelAndView editNewlyConstructedproperty(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, Exception {
//
//		NewlyConstructedProperty property = null;
//		HttpSession session = request.getSession();
//		System.out.println("editPropertyTaxDemand");
//		long rtiApplicationRefId = 0;
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		if(sessionUser!=null) {
//		if (request.getParameter("rtiApplicationRefId") != null
//				&& request.getParameter("rtiApplicationRefId").length() > 0) {
//
//			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
//			property = newlyConstructedPropertyService.get(rtiApplicationRefId);
//
//			if (property.getRti_ref_id() > 0) {
//				rtiApplicationId = property.getRti_ref_id();
//				rtiapplication = rtiApplicationService.get(rtiApplicationId);
//			} else {
//				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
//						rtiApplicationRefId);
//				if (listRTI != null && !listRTI.isEmpty()) {
//					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
//					rtiapplication = listRTI.get(0);
//				}
//			}
//		}
//
//		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
//		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
//		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
//		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
//		request.setAttribute("rtiApplication", rtiapplication);
//
//		WorkflowProcessDetails workflowProcessDetails = null;
//		WorkflowProcessDetails processDetails = null;
//		workflowProcessDetails = workflowProcessDetailsService
//				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
//
//		if (workflowProcessDetails != null) {
//			String processId = workflowProcessDetails.getProcessId();
//			if (processId != null) {
//				processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
//			}
//			if (!workflowService.isProcessEnded(processId)) {
//				String taskId = workflowService.getCurrentTaskId(processId);
//				Task task = null;
//				if (taskId != null)
//					task = taskService.getTask(taskId);
//				if (processDetails != null) {
//					PersonalTask personalTask = new PersonalTask();
//					personalTask.setTask(task);
//					personalTask.setEntityId(processDetails.getEntityId());
//					personalTask.setEntityName(processDetails.getEntityName());
//					personalTask.setWorkflowInitator(processDetails.getUserName());
//					personalTask.setEntityDetails(processDetails.getEntityDetails());
//					request.setAttribute("personalTask", personalTask);
//				}
//				if (task != null && sessionUser.getUserName().equals(task.getAssignee()))
//					request.setAttribute("userAccess", 1);
//
//				request.setAttribute("workFlowTask", task);
//			} else {
//
//				request.setAttribute("workFlowCompleted", "1");
//			}
//		}
//
//		ModelAndView modelAndView = new ModelAndView("manageNewlyContructedProperty", "propertyTaxAssessment", property);
//
//		return modelAndView;
//		}else {
//			return new ModelAndView("/login.do");
//		}
//		}

	@RequestMapping("/rtsapplication/saveNewlyConstructedPropertyFees.do")
	public ModelAndView saveNewlyConstructedPropertyFees(HttpServletRequest request, HttpServletResponse response,
			NewlyConstructedProperty newlyConstructedProperty) throws ServletException, Exception {
		String fees = request.getParameter("fees");
		long apprefid = Long.parseLong(request.getParameter("id"));
		RTIApplication rtsapplication;
		newlyConstructedProperty = newlyConstructedPropertyService.get(apprefid);
		if (newlyConstructedProperty.getFees() == 0.0 && fees != null && fees.length() > 0) {
			apprefid = newlyConstructedProperty.getRti_ref_id();
			rtsapplication = rtiApplicationService.get(newlyConstructedProperty.getRti_ref_id());
			newlyConstructedProperty.setFees(Double.parseDouble(fees));
			newlyConstructedProperty = newlyConstructedPropertyService.merge(newlyConstructedProperty);
			rtsapplication.setApplicationCost(newlyConstructedProperty.getFees());
			rtiApplicationService.save(rtsapplication);
		}
		return new ModelAndView("redirect:/rtsapplication/editNewlyConstructedproperty.do?rtiApplicationRefId="
				+ newlyConstructedProperty.getNewlyConstructedPropertyId());
	}

	@RequestMapping("/rtiapplication/createNewlyConstructedPropertyWork.do")
	public ModelAndView createNewlyConstructedPropertyWork(HttpServletRequest request, HttpServletResponse response)
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
		NewlyConstructedProperty newlyConstructedProperty = newlyConstructedPropertyService.get(applicationId);
		String email = newlyConstructedProperty.getEmail();
		String mobileNo = newlyConstructedProperty.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		if (newlyConstructedProperty != null) {
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
					String paymentLink = "http://tinyurl.com";
					String paymentLink2 = "ysvdjecd";

					String msg = "Dear " + applicantName
							+ " your document verification has been successfully completed. Kindly use this link "
							+ paymentLink + "/" + paymentLink2 + " to make a payment in order for your application "
							+ rtiApplnNumber + " to be processed further. Regards, NMCGOV";

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
		return new ModelAndView(
				"redirect:/rtsapplication/editNewlyConstructedproperty.do?rtiApplicationRefId=" + rtirefId);
	}

	@RequestMapping("/rtsapplication/editNewlyConstructedproperty.do")
	public ModelAndView editNewlyConstructedproperty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		NewlyConstructedProperty property = null;
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
				property = newlyConstructedPropertyService.get(rtiApplicationRefId);

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

      			request.setAttribute("rtiApplication", rtiapplication);



			} 
		}else {
			return new ModelAndView("/login.do");
		}
		return new ModelAndView("manageNewlyContructedProperty", "propertyTaxAssessment",property);
	}

}