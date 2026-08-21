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
import com.mars.rti.model.NOCOfTrade;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.NOCOfTradeService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.NOCOfTradeRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class NOCOfTradeController {

	// extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(NOCOfTradeController.class);
	@Autowired
	private NOCOfTradeService nocTradeService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
	//
	// private static String const_OrderBy = "OrderBy";
	//
	// private static String const_SortBy = "SortBy";

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	// @RequestMapping("ws/rtiapplication/newRTIMandapApplication.do")
	// public ModelAndView newRTIMandapApplication(HttpServletRequest request,
	// HttpServletResponse response)
	// throws ServletException {
	// String baseDir = getServletContext().getRealPath("");
	// String folder = "mandapPermission";
	// File file = new File(baseDir, folder);
	// if (!file.exists()) {
	// file.mkdirs();
	// }
	// ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
	// modelAndView.addObject("folderName", folder);
	// return modelAndView;
	// }

	@RequestMapping("/rtsapplication/saveNOCOfTradeCertificates.do")
	public ModelAndView saveNOCOfTrade(HttpServletRequest request,
			HttpServletResponse response, NOCOfTrade nocTrade)
			throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking NOC Of Trade");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking NOCOfTrade");
		}
		String mobileNumber = "";
		RTIApplication retunRti=null;
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
			UserRegistrationDetails user = userService
					.getUserByMobileNo(mobileNumber);
			if (nocTrade != null) {

				RTIApplication rtiApplication = new RTIApplication();
				NOCOfTradeRestDTO nocTradeRestDTO = new NOCOfTradeRestDTO();
				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("NOC-OF-TRADE-CERTIFICATE");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(32);
				rtiApplication.setApplicantName(
						nocTrade.getFirstName() + " " + nocTrade.getMiddleName()
								+ " " + nocTrade.getLastName());
				rtiApplication.setPhoneNumber(nocTrade.getMobileNo());
				rtiApplication.setMobileNumber(nocTrade.getMobileNo());
				rtiApplication.setEmail(nocTrade.getEmail());
				rtiApplication.setZone(nocTrade.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicationCost(nocTrade.getFeesApplicable());

				rtiApplication.setApplicantName(nocTrade.getFullName());
				rtiApplication.setPdfUploadFromPortal(nocTrade.getFilesPath());
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails
						.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(
						CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication
						.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService
						.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService
							.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/"
							+ savedRti.getRtiApplicationId());
					nocTrade.setRtiapplrefno(rti.getRtiApplnNumber());
					nocTrade.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = nocTradeService.nocTrade(nocTrade);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						nocTradeRestDTO.setResponseStatus(
								"Requested data saved successfully");
						nocTradeRestDTO
								.setResponse(retunRti.getRtiApplicationId());
						nocTradeRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
					String name = nocTrade.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = nocTrade.getMobileNo();
					String email=nocTrade.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
				
				Object as_status=session.getAttribute("as_status");
				if(as_status!=null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSNOCOfTradeSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());			}
				}
			}
		return new ModelAndView("redirect:/ws/user/login.do");

	}
	@RequestMapping("ws/rtsapplication/newRtSNOCOfTradeSuccess.do")
	public ModelAndView	newRtSNOCOfTradeSuccess(HttpServletRequest
	request,HttpServletResponse response) {

	 String appNo = request.getParameter("rtsAppNo");
	 ModelAndView model = new ModelAndView("newRTINOCOfTradeSucess");

	 model.addObject("nocTrade",appNo);
	 return model;


	 } 

	@RequestMapping("/rtiapplication/editNOCOfTrade.do")
	public ModelAndView editNOCOfTrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {

		NOCOfTrade nocTrade = null;
		HttpSession session = request.getSession();
		System.out.println(" editNOCOfTrade");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null && request
					.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long
						.parseLong(request.getParameter("rtiApplicationRefId"));
				nocTrade = nocTradeService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				nocTrade = nocTradeService.get(rtiApplicationRefId);
			}

			if (nocTrade.getRti_ref_id() > 0) {
				rtiApplicationId = nocTrade.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService
						.findByProperty("rtiApplicationRefId",
								rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
				CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
				CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
				rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
						CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

		if (workflowProcessDetails != null) {
			String processId = workflowProcessDetails.getProcessId();
			if (processId != null) {
				processDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByProcessId(processId);
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
					personalTask
							.setWorkflowInitator(processDetails.getUserName());
					personalTask.setEntityDetails(
							processDetails.getEntityDetails());
					request.setAttribute("personalTask", personalTask);
				}
				if (task != null
						&& sessionUser.getUserName().equals(task.getAssignee()))
					request.setAttribute("userAccess", 1);

				request.setAttribute("workFlowTask", task);
			} else {

				request.setAttribute("workFlowCompleted", "1");
			}
		}

		ModelAndView modelAndView = new ModelAndView("manageNOCOfTrade",
				"nocTrade", nocTrade);

		return modelAndView;

	}

	@RequestMapping("/rtiapplication/createNOCOfTradeWork.do")
	public ModelAndView createNOCOfTradeWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		String rtiApplicationIdString = request
				.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService
				.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
						CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		NOCOfTrade nocTrade = nocTradeService.get(applicationId);
		String email = nocTrade.getEmail();
		String mobileNo = nocTrade.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (nocTrade != null) {
			if (workflowProcessDetails != null) {
				String processId = workflowProcessDetails.getProcessId();
				if (processId != null) {
					processDetails = workflowProcessDetailsService
							.getWorkflowProcessDetailsByProcessId(processId);
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
						personalTask
								.setEntityName(processDetails.getEntityName());
						personalTask.setWorkflowInitator(
								processDetails.getUserName());
						personalTask.setEntityDetails(
								processDetails.getEntityDetails());
						request.setAttribute("personalTask", personalTask);
					}

					rtiApplication.setWorkFlowStatus(3);
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter(
									"WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName()
							.equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION")
						.equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION")
						.equals("Reject")) {
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
				CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
				CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
				rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		// ModelAndView modelAndView = new
		// ModelAndView("manageMandapPermission",
		// "mandapPermission", mandapPermission);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editNOCOfTrade.do");
	}

}