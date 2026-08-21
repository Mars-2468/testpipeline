
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
import com.mars.rti.model.BiologicalWasteDisposal;
import com.mars.rti.model.ChangeInOwnershipType;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.BiologicalWasteService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class BiologicalWasteDisposalController  {
	// extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(BiologicalWasteDisposalController.class);
	@Autowired
	private  BiologicalWasteService biologicalWasteService;
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;
	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	
	@RequestMapping("/rtsapplication/saveBiologicalWasteDisposal.do")
	public ModelAndView saveBiologicalWasteDisposal(HttpServletRequest request,
			HttpServletResponse response,
			BiologicalWasteDisposal biologicalWasteDisposal)
			throws ServletException, Exception {

		HttpSession session = request.getSession(true);
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Mandap");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking MandapPermission");
		}
		String mobileNumber = "";
		mobileNumber = (String) session.getAttribute("mobileNo");
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService
					.getUserByMobileNo(mobileNumber);
			if (biologicalWasteDisposal != null) {

				RTIApplication rtiApplication = new RTIApplication();
				//MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("BIO-MEDICAL-WASTE");
				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
				rtiApplication.setTemplateName("bioMedicalApplication");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(101);
				rtiApplication.setApplicantName(biologicalWasteDisposal.getFirstName()
						+ " " + biologicalWasteDisposal.getMiddleName() + " "
						+ biologicalWasteDisposal.getLastName());
				rtiApplication.setPhoneNumber(biologicalWasteDisposal.getMobileNumber());
				rtiApplication.setMobileNumber(biologicalWasteDisposal.getMobileNumber());
				rtiApplication.setEmail(biologicalWasteDisposal.getEmail());
				rtiApplication.setZone(biologicalWasteDisposal.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);
			rtiApplication.setPdfUploadFromPortal(
					biologicalWasteDisposal.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/HD" + "/"+ savedRti.getRtiApplicationId()+ "/" + Year.now() );
					biologicalWasteDisposal.setRtiapplrefno(rti.getRtiApplnNumber());
					biologicalWasteDisposal.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = biologicalWasteService.BiologicalWasteDisposal(biologicalWasteDisposal);
					
					rti.setRtiApplicationRefId(birth_regis_id);
					retunRti = rtiApplicationService.merge(rti);
				String name = biologicalWasteDisposal.getFirstName() + " "+ biologicalWasteDisposal.getMiddleName() + " "+ biologicalWasteDisposal.getLastName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = biologicalWasteDisposal.getMobileNumber();
					String email=biologicalWasteDisposal.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
			
				return new ModelAndView("redirect:/ws/rtsapplication/newRTSBioMedicalWasteDisposalSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
			}

		}
			return new ModelAndView("redirect:/ws/user/login.do");
		
	}
	
	@RequestMapping("/ws/rtsapplication/newRTSBioMedicalWasteDisposalSuccess.do")
	public ModelAndView newRTSBioMedicalWasteDisposalSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSBioMedicalWasteDisposalSuccess");
		
		model.addObject("appNo",appNo);
		return model;
				
		
	}

	

	@RequestMapping("/rtsapplication/editBioMedicalWaste.do")
	public ModelAndView editBioMedicalWaste(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {

		BiologicalWasteDisposal biologicalWasteDisposal = null;
		HttpSession session = request.getSession();
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));
		long userId = sessionUser.getUserId();
		String a1 = request.getParameter("rtiApplicationRefId");

		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				biologicalWasteDisposal = biologicalWasteService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				biologicalWasteDisposal = biologicalWasteService.get(rtiApplicationRefId);
			}
			 String feees = request.getParameter("fees");

			if (biologicalWasteDisposal.getRti_ref_id() > 0) {
				rtiApplicationId = biologicalWasteDisposal.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
				if (rtiapplication.getApplicationCost() == 0.0 || rtiapplication.getApplicationCost() == 0) {
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);

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

		ModelAndView modelAndView = new ModelAndView("manageBioMedicalDisposal",
				"biologicalWasteDisposal",biologicalWasteDisposal);
		return modelAndView;

	}

	
	@RequestMapping("/rtiapplication/createBioMedicalWorkWork.do")
	public ModelAndView createBioMedicalWorkWork(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
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
						CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		BiologicalWasteDisposal biologicalWasteDisposal = biologicalWasteService
				.get(applicationId);
		String email = biologicalWasteDisposal.getEmail();
		String mobileNo = biologicalWasteDisposal.getMobileNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (biologicalWasteDisposal != null) {
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
				CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
				CoreConstants.RTI_BIOMEDICAL_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
				rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView(
				"redirect:/rtsapplication/editBioMedicalWaste.do");
	}
	
	
	@RequestMapping("/rtsapplication/saveBioMedical.do")
	public ModelAndView saveBioMedical(HttpServletRequest request,HttpServletResponse response,BiologicalWasteDisposal biologicalWasteDisposal)
			throws ServletException, Exception {
	    String fees = request.getParameter("demandfees");

        String refid =request.getParameter("bwdId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);

		biologicalWasteDisposal = biologicalWasteService.get(apprefid);

		if (biologicalWasteDisposal.getDemandfees() == null && fees!=null){
			biologicalWasteDisposal.setDemandfees(fees);

			biologicalWasteDisposal = biologicalWasteService.merge(biologicalWasteDisposal);

		}
		return new ModelAndView("redirect:/rtsapplication/editBioMedicalWaste.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees);	
		}

}