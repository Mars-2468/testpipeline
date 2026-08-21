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

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.MobileTower;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MobileTowerService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MandapPermissionRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class MobileTowerController {

//	extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(MandapPermissionController.class);
	@Autowired
	private MobileTowerService mobileTowerService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

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

	@RequestMapping("/rtsapplication/saveMobileTower.do")
	public ModelAndView saveMobileTower(HttpServletRequest request, HttpServletResponse response,
			MobileTower mobileTower) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Mobile Tower");
		}
		if (mobileTower != null) {

			RTIApplication rtiApplication = new RTIApplication();
			MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
			rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("MOBILE-TOWER");
			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(31);
			rtiApplication.setApplicantName(mobileTower.getName());
			rtiApplication.setPhoneNumber(mobileTower.getMobileNo());
			rtiApplication.setMobileNumber(mobileTower.getMobileNo());
			rtiApplication.setZone(mobileTower.getZoneNo());

			rtiApplication.setEmail(mobileTower.getEmail());

			rtiApplication.setApplicationCost(mobileTower.getTotalFees());

			rtiApplication.setApplicantName(mobileTower.getName());
			rtiApplication.setPdfUploadFromPortal(mobileTower.getFilesPath());
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
				rti.setRtiApplnNumber("RTS/TPD"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
				mobileTower.setRtiapplrefno(rti.getRtiApplnNumber());
				mobileTower.setRti_ref_id(savedRti.getRtiApplicationId());
				long birth_regis_id = mobileTowerService.mobileTower(mobileTower);
				rti.setRtiApplicationRefId(birth_regis_id);
				// rti.setRtiApplicationRefId(birthRegistrationService.);
				RTIApplication retunRti = rtiApplicationService.merge(rti);
                   

				if ((retunRti != null) && (birth_regis_id > 0)) {
					mandapPermissionRestDTO.setResponseStatus("Requested data saved successfully");
					mandapPermissionRestDTO.setResponse(retunRti.getRtiApplicationId());
					mandapPermissionRestDTO.setResult(retunRti.getRtiApplnNumber());
				}
				String name=mobileTower.getName();
				String link = "https://tinyurl.com/4hhhy9w9";
				String applnNo= rti.getRtiApplnNumber();


				
				String msg = "Dear "+name+" your application with Application No. "+applnNo+" submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
				
				msg.replace("var3", "");

				SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", mobileTower.getMobileNo(), msg);
				SendEmail.sendEmail(mobileTower.getEmail(), "Application Submitted Successfully" + applnNo, msg);
				}
			ModelAndView model = new ModelAndView("newRTIMobileTowerSucess");
			return model;
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

	@RequestMapping("/rtiapplication/editMobileTower.do")
	public ModelAndView editMandapPermission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		MobileTower mobileTower = null;
		HttpSession session = request.getSession();
		System.out.println(" editMobileTower");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			mobileTower = mobileTowerService.get(rtiApplicationRefId);

			if (mobileTower.getRti_ref_id() > 0) {
				rtiApplicationId = mobileTower.getRti_ref_id();
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);

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

		ModelAndView modelAndView = new ModelAndView("manageMobileTower", "mobileTower", mobileTower);

		return modelAndView;

	}

	@RequestMapping("/rtiapplication/createMobileTower.do")
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
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		MobileTower mobileTower = mobileTowerService.get(applicationId);
		String email = mobileTower.getEmail();
		String mobileNo = mobileTower.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		if (mobileTower != null) {
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
					 String msg = "Dear "+applicantName+" your document verification has been successfully completed. Kindly use this link https://tinyurl.com/v5rpfw6v  to make a payment in order for your application "+rtiApplnNumber+" to be processed further.Regards, NMCGOV";

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
					String msg = "Dear "+applicantName+" please click on this link https://tinyurl.com/2xvycvs3 to download the Certificate for your application "+rtiApplnNumber+" Regards, NMCGOV";

					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Completion of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					rtiApplicationService.save(rtiApplication);
					String msg = "Dear "+applicantName+" your "+rtiApplnNumber+" has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/359w8usz to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
					 msg.replace("var3", "");
					SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				}
			}else{
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				rtiApplicationService.save(rtiApplication);
				String msg = "Dear "+applicantName+" your "+rtiApplnNumber+" has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/359w8usz to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
				 msg.replace("var3", "");
				SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
				SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
				request.setAttribute("workFlowCompleted", "1");
				
			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		ModelAndView modelAndView = new ModelAndView("manageMobileTower", "mobileTower", mobileTower);
		return modelAndView;
	}

	

}