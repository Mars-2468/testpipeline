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
import com.mars.rti.model.MandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MandapPermissionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MandapPermissionRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class MandapPermissionController {
//	extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(MandapPermissionController.class);
	@Autowired
	private MandapPermissionService mandapPermissionService;
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

// 	@RequestMapping("ws/rtiapplication/newRTIMandapApplication.do")
// 	public ModelAndView newRTIMandapApplication(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException {
// 		String baseDir = getServletContext().getRealPath("");
//		String folder = "mandapPermission";
//		File file = new File(baseDir, folder);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
// 		ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
//		modelAndView.addObject("folderName", folder);
// 		return modelAndView;
// 	}

	@RequestMapping("/rtsapplication/saveMandapCertificates.do")
	public ModelAndView saveMandapPermission(HttpServletRequest request, HttpServletResponse response,
			MandapPermission mandapPermission) throws ServletException, Exception {

		HttpSession session = request.getSession(true);
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Mandap");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking MandapPermission");
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
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

			if (mandapPermission != null) {

				RTIApplication rtiApplication = new RTIApplication();
				MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("MANDAP-CERTIFICATE");
				rtiApplication.setDepartment("ESTATE-DEPARTMENT");
				rtiApplication.setTemplateName("mandapPermission");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(23);
				rtiApplication.setApplicantName(mandapPermission.getFirstName() + " " + mandapPermission.getMiddleName()
						+ " " + mandapPermission.getLastName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(mandapPermission.getMobileNo());
				rtiApplication.setMobileNumber(mandapPermission.getMobileNo());
				rtiApplication.setEmail(mandapPermission.getEmail());
				rtiApplication.setZone(mandapPermission.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicationCost(mandapPermission.getFees());
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

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/ED" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					mandapPermission.setRtiapplrefno(rti.getRtiApplnNumber());
					mandapPermission.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = mandapPermissionService.mandapPermission(mandapPermission);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						mandapPermissionRestDTO.setResponseStatus("Requested data saved successfully");
						mandapPermissionRestDTO.setResponse(retunRti.getRtiApplicationId());
						mandapPermissionRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
//					String name = mandapPermission.getFullName();
//					String link = "https://tinyurl.com/4hhhy9w9";
//					String applnNo = rti.getRtiApplnNumber();
//
//					String msg = "Dear " + name + " your application with Application No. " + applnNo
//							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
//
//					msg.replace("var3", "");
//
//					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", mandapPermission.getMobileNo(), msg);
//					SendEmail.sendEmail(mandapPermission.getEmail(), "Application Submitted Successfully" + applnNo,
//							msg);
					String name = mandapPermission.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = mandapPermission.getMobileNo();
					String email=mandapPermission.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
//				ModelAndView model = new ModelAndView("newRTIMandapPermissionSucess");
//				return model;
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSMandapPermissionSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}
			}
		}
//		ModelAndView modelAndView = new ModelAndView("newRTIMandapPermissionSucess");
//		modelAndView.addObject("result", "Save successfully done");
		return new ModelAndView("redirect:/ws/user/login.do");
//		 return new ModelAndView( "redirect:/newRTIMandapPermissionSucess.jsp");

		/*
		 * ModelAndView modelAndView = new ModelAndView("redirect:/abc.htm");
		 * modelAndView.addObject("newRTIMandapPermissionSucess" , new
		 * ModelAttribute()); return modelAndView;
		 */
	}

	
	
	@RequestMapping("ws/rtsapplication/newRtSMandapPermissionSuccess.do")
	public ModelAndView newRtSMandapPermissionSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTIMandapPermissionSucess");
		
		model.addObject("mandapPermission",appNo);
		return model;
				
		
	}
	
	
	@RequestMapping("/rtiapplication/editMandapPermission.do")
	public ModelAndView editMandapPermission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		MandapPermission mandapPermission = null;
		HttpSession session = request.getSession();
		System.out.println(" editMandapPermission");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		
		if (sessionUser != null) {
if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				mandapPermission = mandapPermissionService.get(rtiApplicationRefId);
				request.setAttribute("sendDemandStatus", mandapPermission.getSendDemandStatus());

			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				mandapPermission = mandapPermissionService.get(rtiApplicationRefId);

			}
		
			String feees = request.getParameter("feesDemand");
			if (mandapPermission.getRti_ref_id() > 0) {
			    rtiApplicationId = mandapPermission.getRti_ref_id();
			    rtiapplication = rtiApplicationService.get(rtiApplicationId);
			    if (feees != null && !feees.equals("") && !feees.isEmpty()) {
			        double rtsApplicationCost = rtiapplication.getApplicationCost();
			        double additionalFees = Double.parseDouble(feees);
			        double newApplicationCost = rtsApplicationCost + additionalFees;
			        rtiapplication.setApplicationCost(newApplicationCost);
			        rtiapplication = rtiApplicationService.merge(rtiapplication);
			    }
			}

			 else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);

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
		request.setAttribute("rtiApplication", rtiapplication);
		request.setAttribute("mandapPermission", mandapPermission);
		request.setAttribute("totalfees",rtiapplication.getApplicationCost());
		
		ModelAndView modelAndView = new ModelAndView("manageMandapPermission", "mandapPermission", mandapPermission);

		return modelAndView;

	}
		return new ModelAndView("redirect:/login.do");
	}

	@RequestMapping("/rtiapplication/createMandapPermissionWork.do")
	public ModelAndView createMandapPermissionWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		MandapPermission mandapPermission = mandapPermissionService.get(applicationId);
		String email = mandapPermission.getEmail();
		String mobileNo = mandapPermission.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MANDAP_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		// ModelAndView modelAndView = new ModelAndView("manageMandapPermission",
		// "mandapPermission", mandapPermission);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editMandapPermission.do");
	}

	@RequestMapping("/rtiapplication/saveMandapAddFee.do")
	public ModelAndView saveMandapAddFee(HttpServletRequest request,HttpServletResponse response, MandapPermission mandapPermission)
			throws ServletException, Exception {
		String feesDemand = request.getParameter("feesDemand");
		String refid = (String) request.getParameter("mandapPermissionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);

		mandapPermission = mandapPermissionService.get(apprefid);
		mandapPermission.setSendDemandStatus(1);

		if (mandapPermission.getFeesDemand() == null && feesDemand!=null) {
			mandapPermission.setFeesDemand(feesDemand);
			mandapPermission = mandapPermissionService.merge(mandapPermission);

		}
		return new ModelAndView("redirect:/rtiapplication/editMandapPermission.do?rtiApplicationRefId=" + apprefid + "&feesDemand=" + feesDemand);	
		}

	
}