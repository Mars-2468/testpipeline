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
import com.mars.rti.model.FireCrackersShopLicense;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.FireCrackersShopLicenseService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;
@Controller
public class FireCrackesShopLicenseController {
	private static Log log = LogFactory.getLog(FireCrackesShopLicenseController.class);
	@Autowired
	private FireCrackersShopLicenseService fireCrackersShopLicenseService;
	@Autowired
	private RTIApplicationService rtiApplicationService;


	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;
	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private UserService userIdService;
	
	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FeesMasterController feesMaster;
	
	@Autowired
	private UserService userServices;


	@RequestMapping("/rtsapplication/saveFireCrackersShopLicense.do")
	public ModelAndView saveFireCrackersShopLicense(HttpServletRequest request,
			HttpServletResponse response,
			FireCrackersShopLicense fireCrackersShopLicense)
			throws ServletException, Exception {

		HttpSession session = request.getSession(true);
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Fire Crackers");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking Fire Crackers");
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
			Object as_status=session.getAttribute("as_status");

			if (fireCrackersShopLicense != null) {

				RTIApplication rtiApplication = new RTIApplication();
//				MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("Fire Crackers Shop License");
				rtiApplication.setDepartment("FIRE-DEPARTMENT");
				rtiApplication.setTemplateName("fireCrackerLicense");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(93);
				rtiApplication.setApplicantName(fireCrackersShopLicense.getFirstName()
						+ " " + fireCrackersShopLicense.getMiddleName() + " "
						+ fireCrackersShopLicense.getLastName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(fireCrackersShopLicense.getMobileNo());
				rtiApplication.setMobileNumber(fireCrackersShopLicense.getMobileNo());
				rtiApplication.setEmail(fireCrackersShopLicense.getEmail());
				rtiApplication.setZone(fireCrackersShopLicense.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);
			
				rtiApplication.setApplicationCost(feesMaster.setFireServiceFees());
				rtiApplication.setInWardNumber(fireCrackersShopLicense.getWardNo());
				rtiApplication.setApplicantName(fireCrackersShopLicense.getFullName());
				rtiApplication.setPdfUploadFromPortal(fireCrackersShopLicense.getFilesPath());
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
				RTIApplication retunRti = null;
				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService
							.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/FCSL" + "/" + Year.now()+ "/"
							+ savedRti.getRtiApplicationId() );
					fireCrackersShopLicense.setRtiapplrefno(rti.getRtiApplnNumber());
					fireCrackersShopLicense
							.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = fireCrackersShopLicenseService
							.fireCrackersShopLicenseSave(fireCrackersShopLicense);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					retunRti = rtiApplicationService.merge(rti);

//					if ((retunRti != null) && (birth_regis_id > 0)) {
//						mandapPermissionRestDTO.setResponseStatus(
//								"Requested data saved successfully");
//						mandapPermissionRestDTO
//								.setResponse(retunRti.getRtiApplicationId());
//						mandapPermissionRestDTO
//								.setResult(retunRti.getRtiApplnNumber());
//					}

					String name = fireCrackersShopLicense.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = fireCrackersShopLicense.getMobileNo();
					String email=fireCrackersShopLicense.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}

				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRTSFireCrackersShopLicenseSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}			}
		}
		
		return new ModelAndView("redirect:/ws/user/login.do");
		
	}

	
	@RequestMapping("ws/rtsapplication/newRTSFireCrackersShopLicenseSuccess.do")
	public ModelAndView newRTSFireCrackersShopLicenseSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSFireCrackersShopLicenseSuccess");
		
		model.addObject("appNo",appNo);
		return model;
				
		
	}

//
//	
//
	@RequestMapping("/rtiapplication/editFireCrackersShopLicense.do")
	public ModelAndView editFireCrackersShopLicense(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		FireCrackersShopLicense fireCrackersShopLicense = null;
		HttpSession session = request.getSession();
		System.out.println("editFireCrackersShopLicense");
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
				fireCrackersShopLicense = fireCrackersShopLicenseService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				fireCrackersShopLicense = fireCrackersShopLicenseService.get(rtiApplicationRefId);
			}
			if (fireCrackersShopLicense.getRti_ref_id() > 0) {
				rtiApplicationId = fireCrackersShopLicense.getRti_ref_id();
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_FIRE_CRACKER_LICENSE);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_FIRE_CRACKER_LICENSE);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_FIRE_CRACKER_LICENSE);

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
			ModelAndView modelAndView = new ModelAndView("manageFireCrackersShopLicense", "fireCrackersShopLicense", fireCrackersShopLicense);


		return modelAndView;
	}
	return new ModelAndView("redirect:/login.do");
}

	
@RequestMapping("/rtiapplication/createFireCrackersShopLicenseWork.do")
public ModelAndView createFireCrackersShopLicenseWork(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, Exception {
	String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
	long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
	RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

	HttpSession session = request.getSession();
	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	WorkflowProcessDetails workflowProcessDetails = null;
	WorkflowProcessDetails processDetails = null;
	workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
			CoreConstants.RTI_FIRE_CRACKER_LICENSE);

	String id = request.getParameter("id");
	long applicationId = Long.parseLong(id);
	FireCrackersShopLicense fireCrackersShopLicense = fireCrackersShopLicenseService.get(applicationId);
	String email = fireCrackersShopLicense.getEmail();
	String mobileNo = fireCrackersShopLicense.getMobileNo();
	String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
	String applicantName = rtiApplication.getApplicantName();
	long rtirefId = rtiApplication.getRtiApplicationRefId();

	if (fireCrackersShopLicense != null) {
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
	request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_FIRE_CRACKER_LICENSE);
	request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_FIRE_CRACKER_LICENSE);
	request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
	request.setAttribute("rtiApplication", rtiApplication);
	request.setAttribute("rtiApplicationRefId", rtiApplicationId);

	session.setAttribute("rtirefId", rtirefId);
	return new ModelAndView("redirect:/rtiapplication/editFireCrackersShopLicense.do");
}
	
	@RequestMapping("/rtsapplication/saveFireCracker.do")
	public ModelAndView saveFireCracker(HttpServletRequest request, HttpServletResponse response,
			FireCrackersShopLicense fireCrackersShopLicense) throws ServletException, Exception {
		String fireremarks = request.getParameter("fireremarks");
	    String reupload=request.getParameter("apid");

		String refid = (String) request.getSession().getAttribute("refid");
		long apprefid = 0;
		if (refid != null) {
			apprefid = Long.parseLong(refid);
			fireCrackersShopLicense = fireCrackersShopLicenseService.get(apprefid);
			  if (fireremarks != null) {
				apprefid = Long.parseLong(refid);
				fireCrackersShopLicense.setFireremarks(fireremarks);
				fireCrackersShopLicense = fireCrackersShopLicenseService.merge(fireCrackersShopLicense);
		
			}
			  
			  if(reupload!=null &&!reupload.isEmpty()) {
				  fireCrackersShopLicense.setFireNoc(null);
				  fireCrackersShopLicense.setFireremarks(null);
					fireCrackersShopLicense = fireCrackersShopLicenseService.merge(fireCrackersShopLicense);
					RTIApplication application = rtiApplicationService.get(fireCrackersShopLicense.getRti_ref_id());
					application.setFireNoc(null);
					rtiApplicationService.merge(application);
			
			  }
			
			/*
			 * if(fireCrackersShopLicense.getFireremarks()!=null) {
			 * 
			 * RTIApplication rtiApplication =
			 * rtiApplicationService.get(fireCrackersShopLicense.getRti_ref_id());
			 * rtiApplication.setWorkFlowStatus(2);
			 * rtiApplicationService.save(rtiApplication);
			 * 
			 * }
			 */

		}
		return new ModelAndView(
				"redirect:/rtiapplication/editFireCrackersShopLicense.do?rtiApplicationRefId=" + apprefid);

	}

	
	
	/*
	 * @RequestMapping("/rtsapplication/createFireCrackersShopLicenseWork.do")
	 * public ModelAndView createFireCrackersShopLicenseWork(HttpServletRequest
	 * request, HttpServletResponse response) throws ServletException, Exception {
	 * String cid = request.getParameter("cid"); long rtiApplicationId =0; long
	 * rtirefId=0; RTIApplication rtiApplication = null; HttpSession session =
	 * request.getSession(); if(cid!=null) { String rtiApplicationIdString=
	 * request.getParameter("rtiApplicationRefIds"); if(rtiApplicationIdString!=null
	 * && !rtiApplicationIdString.isEmpty()) { rtiApplicationId =
	 * Long.parseLong(rtiApplicationIdString); rtiApplication =
	 * rtiApplicationService.get(rtiApplicationId); FireCrackersShopLicense
	 * fireCrackersShopLicense =
	 * fireCrackersShopLicenseService.get(rtiApplication.getRtiApplicationRefId());
	 * String email = fireCrackersShopLicense.getEmail(); String mobileNo =
	 * fireCrackersShopLicense.getMobileNo(); String rtiApplnNumber =
	 * rtiApplication.getRtiApplnNumber(); String applicantName =
	 * rtiApplication.getApplicantName(); rtirefId =
	 * rtiApplication.getRtiApplicationRefId();
	 * 
	 * if(cid.equals("1")) {
	 * 
	 * rtiApplication.setWorkFlowStatus(1);//Close application
	 * SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo,
	 * rtiApplnNumber, email);
	 * 
	 * }else if(cid.equals("5")){ rtiApplication.setWorkFlowStatus(5);//reject
	 * rtiApplicationService.save(rtiApplication);
	 * SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo,
	 * rtiApplnNumber, email);
	 * 
	 * } rtiApplication.setWorkflowComments(request.getParameter("remarks"));
	 * rtiApplicationService.save(rtiApplication);
	 * request.setAttribute("workFlowCompleted", "1");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
	 * request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
	 * CoreConstants.ganeshMandapPermission);
	 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
	 * CoreConstants.ganeshMandapPermission);
	 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
	 * request.setAttribute("rtiApplication", rtiApplication);
	 * request.setAttribute("rtiApplicationRefId", rtiApplicationId);
	 * session.setAttribute("rtirefId", rtirefId); return new
	 * ModelAndView("redirect:/rtiapplication/editFireCrackersShopLicense.do"); }
	 */

}
