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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TradeLicencePartnerCountUpdate;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicencePartnerCountUpdateService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class TradeLicencePartnerCountUpdateController {

	private static Log log = LogFactory.getLog(TradeLicenceRenewalController.class);

	@Autowired
	private TradeLicencePartnerCountUpdateService tradeLicencePartnerCountUpdateService;

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

	@RequestMapping("/rtsapplication/saveTradeLicencePartnerCountUpdate.do")
	public ModelAndView saveTradeLicencePartnerCountUpdate(HttpServletRequest request, HttpServletResponse response,
			TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveTradeLicencePartnerCountUpdate");
		}

		String mobileNumber = "";
		RTIApplication retunRti = null;
		String user_name = null;
		Object user_login = request.getSession().getAttribute("name");
		if (user_login != null) {
			user_name = (String) user_login;
		}
		Object obileNumber = session.getAttribute("mobileNo");
		if (obileNumber != null) {
			mobileNumber = String.valueOf(obileNumber);
		} else {
			mobileNumber = (String) session.getAttribute("mobileNo");
		}
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			if (tradeLicencePartnerCountUpdate != null) {
				// TradeLicencePartnerChangeRestDTO tradeLicencePartnerChangeRestDTO = new
				// TradeLicencePartnerChangeRestDTO();
				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENCE-PARTNEW-COUNT-UPDATE");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(39);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(tradeLicencePartnerCountUpdate.getFullName());
				rtiApplication.setPdfUploadFromPortal(tradeLicencePartnerCountUpdate.getFilesPath());
				rtiApplication.setApplicationCost(tradeLicencePartnerCountUpdate.getApplicableFee());
				rtiApplication.setPhoneNumber(tradeLicencePartnerCountUpdate.getMobileNo());
				rtiApplication.setEmail(tradeLicencePartnerCountUpdate.getEmail());
				rtiApplication.setZone(tradeLicencePartnerCountUpdate.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(tradeLicencePartnerCountUpdate.getFullName());
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
					rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					tradeLicencePartnerCountUpdate.setRtiapplrefno(rti.getRtiApplnNumber());
					tradeLicencePartnerCountUpdate.setRti_ref_id(savedRti.getRtiApplicationId());
					long trade_regis_id = tradeLicencePartnerCountUpdateService
							.getReferenceId(tradeLicencePartnerCountUpdate);
					rti.setRtiApplicationRefId(trade_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					retunRti = rTIApplicationService.merge(rti);

//				if ((retunRti != null) && (trade_regis_id > 0)) {
//					tradeLicencePartnerChangeRestDTO.setResponseStatus("Requested data saved successfully");
//					tradeLicencePartnerChangeRestDTO.setResponse(retunRti.getRtiApplicationId());
//					tradeLicencePartnerChangeRestDTO.setResult(retunRti.getRtiApplnNumber());
//
//				}
					String name = tradeLicencePartnerCountUpdate.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = tradeLicencePartnerCountUpdate.getMobileNo();
					String email = tradeLicencePartnerCountUpdate.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
//				ModelAndView modelAndView = new ModelAndView("newRTITradeRenewalPartnerCountUpdateSuccess",
//						"tradeLicencePartnerCountUpdate", tradeLicencePartnerCountUpdate);
//				modelAndView.addObject("result", "data successfully saved");
//				return modelAndView;

				Object as_status = session.getAttribute("as_status");
				if (as_status != null) {
					return new ModelAndView(
							"redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo=" + retunRti.getRtiApplnNumber());

				} else {
					return new ModelAndView(
							"redirect:/ws/rtsapplication/newRtSTradeLicensePartnerCountUpdateSuccess.do?rtsAppNo="
									+ retunRti.getRtiApplnNumber());
				}
			}
		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}

	@RequestMapping("ws/rtsapplication/newRtSTradeLicensePartnerCountUpdateSuccess.do")
	public ModelAndView newRtSTradeLicensePartnerCountUpdateSuccess(HttpServletRequest request,
			HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTITradeRenewalPartnerCountUpdateSuccess");

		model.addObject("tradeLicencePartnerCountUpdate", appNo);
		return model;

	}

	@RequestMapping("/rtsapplication/editTradeLicencePartnerCountUpdate.do")
	public ModelAndView editTradeLicencePartnerCountUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		log.info("Document Uploaded");
		HttpSession session = request.getSession();
		System.out.println("hiiii edittradeCertificate");
		long rtiApplicationRefId = 0;
		TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate = null;
		long tradeLicencePartnerCountUpdateId = 0;

		long rtiApplicationId = 0;
		// DeathRegistration deathRegistration=null;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				tradeLicencePartnerCountUpdate = tradeLicencePartnerCountUpdateService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				tradeLicencePartnerCountUpdate = tradeLicencePartnerCountUpdateService.get(rtiApplicationRefId);
			}

			if (tradeLicencePartnerCountUpdate.getRti_ref_id() > 0) {
				rtiApplicationId = tradeLicencePartnerCountUpdate.getRti_ref_id();
				rtiapplication = rTIApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

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
		ModelAndView modelAndView = new ModelAndView("manageTradeLicencePartnerCountUpdate",
				"tradeLicencePartnerCountUpdate", tradeLicencePartnerCountUpdate);
		log.info("success");
		return modelAndView;

	}

	@RequestMapping("/rtiapplication/createTradeLicencePartnerCountUpdateWork.do")
	public ModelAndView createTradeLicencePartnerCountUpdateWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate = tradeLicencePartnerCountUpdateService
				.get(applicationId);
		String email = tradeLicencePartnerCountUpdate.getEmail();
		String mobileNo = tradeLicencePartnerCountUpdate.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (tradeLicencePartnerCountUpdate != null) {
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
					SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			} else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
				rtiApplication.setWorkflowComments(workflow_comments);

				rtiApplicationService.save(rtiApplication);
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		// ModelAndView modelAndView = new ModelAndView("manageMandapPermission",
		// "mandapPermission", mandapPermission);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtsapplication/editTradeLicencePartnerCountUpdate.do");
	}

}
