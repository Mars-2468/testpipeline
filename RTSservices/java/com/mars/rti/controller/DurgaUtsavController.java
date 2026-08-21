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

import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.DurgaUtsavMandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.DurgaUtsavService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MandapPermissionRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class DurgaUtsavController {

	private static Log log = LogFactory.getLog(DurgaUtsavController.class);
	@Autowired
	private DurgaUtsavService mandapPermissionService;
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private UserService userIdService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userServices;

	@RequestMapping("/rtsapplication/saveDurgaUtsavMandapPermission.do")
	public ModelAndView saveDurgaUtsavMandapPermission(HttpServletRequest request, HttpServletResponse response,
			DurgaUtsavMandapPermission mandapPermission) throws ServletException, Exception {

		HttpSession session = request.getSession(true);
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Mandap");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking MandapPermission");
		}
		String mobileNumber = "";
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
			Object as_status = session.getAttribute("as_status");

			if (mandapPermission != null) {

				RTIApplication rtiApplication = new RTIApplication();
				MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("Durga Utsav Mandap Permission");
				rtiApplication.setDepartment("ESTATE-DEPARTMENT");
				rtiApplication.setTemplateName("ganeshMandapPermission");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(91);
				rtiApplication.setApplicantName(mandapPermission.getFirstName() + " " + mandapPermission.getMiddleName()
						+ " " + mandapPermission.getLastName());
				if (as_status != null && user_name == null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);

				}
				rtiApplication.setPhoneNumber(mandapPermission.getMobileNo());
				rtiApplication.setMobileNumber(mandapPermission.getMobileNo());
				rtiApplication.setEmail(mandapPermission.getEmail());
				rtiApplication.setZone(mandapPermission.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				double gateLength = Double.parseDouble(mandapPermission.getGateLength());
				double gateBreadth = Double.parseDouble(mandapPermission.getGateBreadth());
				double totalgatelength = gateLength * gateBreadth;
				double totalGateFees = (totalgatelength <= 9) ? 250 : 500;
				double cleaningfess = 500.0;
				mandapPermission.setCleaningfees(cleaningfess);

				rtiApplication.setApplicationCost(totalGateFees + cleaningfess);
				rtiApplication.setInWardNumber(mandapPermission.getWardNo());
				rtiApplication.setApplicantName(mandapPermission.getFullName());
				rtiApplication.setPdfUploadFromPortal(mandapPermission.getFilesPath());
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
				RTIApplication retunRti = null;
				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/DUR" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					mandapPermission.setRtiapplrefno(rti.getRtiApplnNumber());
					mandapPermission.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = mandapPermissionService.durgaUtsavMandapPermission(mandapPermission);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						mandapPermissionRestDTO.setResponseStatus("Requested data saved successfully");
						mandapPermissionRestDTO.setResponse(retunRti.getRtiApplicationId());
						mandapPermissionRestDTO.setResult(retunRti.getRtiApplnNumber());
					}

					String name = mandapPermission.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = mandapPermission.getMobileNo();
					String email = mandapPermission.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}

				if (as_status != null && user_name == null) {
					return new ModelAndView(
							"redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo=" + retunRti.getRtiApplnNumber());

				} else {
					return new ModelAndView(
							"redirect:/ws/rtsapplication/newRtSDurgaUtsavMandapPermissionSuccess.do?rtsAppNo="
									+ retunRti.getRtiApplnNumber());
				}
			}

		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}

	@RequestMapping("ws/rtsapplication/newRtSDurgaUtsavMandapPermissionSuccess.do")
	public ModelAndView newRtSGaneshMandapPermissionSuccess(HttpServletRequest request, HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSDurgaUtsavMandapPermissionSucess");

		model.addObject("appNo", appNo);
		return model;

	}

	@RequestMapping("/rtsapplication/editDurgaUtsavMandapPermission.do")
	public ModelAndView editDurgaUtsavMandapPermission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		DurgaUtsavMandapPermission mandapPermission = null;
		HttpSession session = request.getSession();
		System.out.println(" editTreeCuting");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid", request.getParameter("rtiApplicationRefId"));
		String a1 = request.getParameter("rtiApplicationRefId");
		if (sessionUser != null) {
			long userId = sessionUser.getUserId();
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0
					|| session.getAttribute("rtirefId") != null) {
				if (request.getParameter("rtiApplicationRefId") != null
						&& request.getParameter("rtiApplicationRefId").length() > 0) {
					rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
					mandapPermission = mandapPermissionService.get(rtiApplicationRefId);
				} else if (session.getAttribute("rtirefId") != null) {
					Object a = session.getAttribute("rtirefId");
					rtiApplicationRefId = (long) a;
					mandapPermission = mandapPermissionService.get(rtiApplicationRefId);
				}
				String feees = request.getParameter("fees");
				if (mandapPermission.getRti_ref_id() > 0) {
					rtiApplicationId = mandapPermission.getRti_ref_id();
					rtiapplication = rtiApplicationService.get(rtiApplicationId);
					if (rtiapplication.getApplicationCost() == 200.0 || rtiapplication.getApplicationCost() == 200) {
						if (feees != null && feees != "" && !feees.isEmpty()) {
							rtiapplication.setApplicationCost(Double.parseDouble(feees));
							rtiapplication = rtiApplicationService.merge(rtiapplication);
						}
					}

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
			request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.ganeshMandapPermission);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.ganeshMandapPermission);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
			request.setAttribute("rtiApplication", rtiapplication);

			WorkflowProcessDetails workflowProcessDetails = null;
			WorkflowProcessDetails processDetails = null;
			workflowProcessDetails = workflowProcessDetailsService
					.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.ganeshMandapPermission);

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

			User user = userServices.get(userId);
			String userLevel = user.getUserLevel();
			if (userLevel != null && !userLevel.isEmpty()) {
				if (userLevel.equals("L1")) {
					request.setAttribute("forLogin", "L1");
				} else if (userLevel.equals("L2")) {
					request.setAttribute("forLogin", "L2");
				} else if (userLevel.equals("L3")) {
					request.setAttribute("forLogin", "L3");

				} else if (userLevel.equals("L4")) {
					request.setAttribute("forLogin", "L4");
				} else {
					request.setAttribute("forLogin", "nothing");
				}
			}

			request.setAttribute("totalfees", rtiapplication.getApplicationCost());
			ModelAndView modelAndView = new ModelAndView("manageDurgaUtsavMandapPermission", "mandapPermission",
					mandapPermission);

			return modelAndView;
		}
		return new ModelAndView("redirect:/login.do");
	}

	@RequestMapping("/rtsapplication/saveDurgaUtsavMandap.do")
	public ModelAndView saveGaneshMandap(HttpServletRequest request, HttpServletResponse response,
			DurgaUtsavMandapPermission gneshMandapPermission) throws ServletException, Exception {
		String fees = request.getParameter("fees");
		String ploiceremarks = request.getParameter("ploiceremarks");
		String trafficremarks = request.getParameter("trafficremarks");
		String fireremarks = request.getParameter("fireremarks");

		String refid = (String) request.getSession().getAttribute("refid");
		long apprefid = 0;
		if (refid != null) {
			apprefid = Long.parseLong(refid);
			gneshMandapPermission = mandapPermissionService.get(apprefid);
			if (gneshMandapPermission.getFees() == 0.0 && fees != null) {
				gneshMandapPermission.setFees(Double.parseDouble(fees));
				gneshMandapPermission = mandapPermissionService.merge(gneshMandapPermission);
				return new ModelAndView(
						"redirect:/rtsapplication/editDurgaUtsavMandapPermission.do?rtiApplicationRefId=" + apprefid
								+ "&fees=" + fees);

			} else if (ploiceremarks != null) {
				apprefid = Long.parseLong(refid);
				gneshMandapPermission.setPloiceremarks(ploiceremarks);
				gneshMandapPermission = mandapPermissionService.merge(gneshMandapPermission);
				return new ModelAndView(
						"redirect:/rtsapplication/editDurgaUtsavMandapPermission.do?rtiApplicationRefId=" + apprefid);

			} else if (trafficremarks != null) {
				apprefid = Long.parseLong(refid);
				gneshMandapPermission.setTrafficremarks(trafficremarks);
				gneshMandapPermission = mandapPermissionService.merge(gneshMandapPermission);
				return new ModelAndView(
						"redirect:/rtsapplication/editDurgaUtsavMandapPermission.do?rtiApplicationRefId=" + apprefid);

			} else if (fireremarks != null) {
				apprefid = Long.parseLong(refid);
				gneshMandapPermission.setFireremarks(fireremarks);
				gneshMandapPermission = mandapPermissionService.merge(gneshMandapPermission);
				return new ModelAndView(
						"redirect:/rtsapplication/editDurgaUtsavMandapPermission.do?rtiApplicationRefId=" + apprefid);

			}

		}
		return new ModelAndView(
				"redirect:/rtsapplication/editDurgaUtsavMandapPermission.do?rtiApplicationRefId=" + apprefid);

	}

	@RequestMapping("/rtsapplication/createDurgaUtsavMandapPermissionWork.do")
	public ModelAndView createDurgaUtsavMandapPermissionWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.ganeshMandapPermission);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		DurgaUtsavMandapPermission mandapPermission = mandapPermissionService.get(applicationId);
		String email = mandapPermission.getEmail();
		String mobileNo = mandapPermission.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		User user = userIdService.get(sessionUser.getUserId());

		if (mandapPermission != null) {
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
					rtiApplication.setAssigneeUserId(user);
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

					rtiApplication.setAssigneeUserId(user);
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					rtiApplication.setAssigneeUserId(user);
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

				rtiApplication.setAssigneeUserId(user);
				rtiApplicationService.save(rtiApplication);

				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.ganeshMandapPermission);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.ganeshMandapPermission);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtsapplication/editDurgaUtsavMandapPermission.do");
	}

}