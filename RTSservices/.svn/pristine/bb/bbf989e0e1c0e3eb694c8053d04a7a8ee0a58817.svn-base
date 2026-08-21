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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.LayoutOfBuilding;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.LayoutOfBuildingService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.LayoutOfBuildingRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class LayoutOfBuildingController {
	private static Log log = LogFactory.getLog(LayoutOfBuildingController.class);
	@Autowired
	private LayoutOfBuildingService layoutOfBuildlingService;
	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";
//@RequestMapping("ws/rtiapplication/newRTILayoutApplication.do")
//public ModelAndView newRTILayoutApplication(HttpServletRequest request, HttpServletResponse response) 
//		throws ServletException {
//	ModelAndView modelAndView = new ModelAndView("newRTILayoutApplication");
//	return modelAndView;
//}


@RequestMapping(method = RequestMethod.POST, value = "/rtsapplication/saveLayoutCertificates.do")
public ModelAndView savelayoutCertificates(HttpServletRequest request, HttpServletResponse response,LayoutOfBuilding layOutOfBuilding)
		throws ServletException, Exception {
	HttpSession session = request.getSession();
	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	if (log.isDebugEnabled()) {
		log.debug("Invoking Building");
	}
	if (layOutOfBuilding != null) {

		RTIApplication rtiApplication = new RTIApplication();
		LayoutOfBuildingRestDTO layOutofBuildingDto = new LayoutOfBuildingRestDTO();
		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setSubject("LAYOUT-CERTIFICATE");
		rtiApplication.setWorkFlowStatus(0);
		rtiApplication.setFinalStatus("0");
		rtiApplication.setRtiserviceid(26);
//			rtiApplication.setApplicantName(mandapPermissionRestDTO.getFirstName());
		rtiApplication.setApplicantName(layOutOfBuilding.getFirstName() + " " + layOutOfBuilding.getMiddleName()
				+ " " + layOutOfBuilding.getLastName());
		rtiApplication.setPhoneNumber(layOutOfBuilding.getMobileNo());
		rtiApplication.setMobileNumber(layOutOfBuilding.getMobileNo());
		rtiApplication.setEmail(layOutOfBuilding.getEmailId());
		rtiApplication.setZone(layOutOfBuilding.getZoneNo());

		rtiApplication.setApplicationCost(15);

		rtiApplication.setApplicantName(layOutOfBuilding.getFirstName() + " " + layOutOfBuilding.getMiddleName()
				+ " " + layOutOfBuilding.getLastName());
		rtiApplication.setPdfUploadFromPortal(layOutOfBuilding.getFilesPath());
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
			layOutOfBuilding.setRtiapplrefno(rti.getRtiApplnNumber());
			layOutOfBuilding.setRti_ref_id(savedRti.getRtiApplicationId());
			long birth_regis_id = layoutOfBuildlingService.layoutOfBuilding(layOutOfBuilding);
			rti.setRtiApplicationRefId(birth_regis_id);
			// rti.setRtiApplicationRefId(birthRegistrationService.);
			RTIApplication retunRti = rtiApplicationService.merge(rti);

			if ((retunRti != null) && (birth_regis_id > 0)) {
				layOutofBuildingDto.setResponseStatus("Requested data saved successfully");
				layOutofBuildingDto.setResponse(retunRti.getRtiApplicationId());
				layOutofBuildingDto.setResult(retunRti.getRtiApplnNumber());
			}

			String name=layOutOfBuilding.getFirstName()+layOutOfBuilding.getMiddleName()+layOutOfBuilding.getLastName();
			String link = "https://tinyurl.com/4hhhy9w9";
			String applnNo= rti.getRtiApplnNumber();


			
			String msg = "Dear "+name+" your application with Application No. "+applnNo+" submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
			
			msg.replace("var3", "");

			SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", layOutOfBuilding.getMobileNo(), msg);
			SendEmail.sendEmail(layOutOfBuilding.getEmailId(), "Application Submitted Successfully" + applnNo, msg);
		}
	}
	
//	layoutOfBuildlingService. layoutRegistrationCertificateService(LayoutOfBuilding);
	
	ModelAndView modelAndView = new ModelAndView("newRTILayoutSucess");
	modelAndView.addObject("result", "data successfully saved");
	

	return modelAndView;


}

@RequestMapping("/rtsapplication/editLayoutOfBuilding.do")
public ModelAndView editLayoutPermission(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, Exception {

	LayoutOfBuilding layoutOfBuilding = null;
	HttpSession session = request.getSession();
	System.out.println(" editMandapPermission");
	long rtiApplicationRefId = 0;
	long rtiApplicationId = 0;
	RTIApplication rtiapplication = null;
	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
	if (request.getParameter("rtiApplicationRefId") != null
			&& request.getParameter("rtiApplicationRefId").length() > 0) {

		rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
		layoutOfBuilding = layoutOfBuildlingService.get(rtiApplicationRefId);

		if (layoutOfBuilding.getRti_ref_id() > 0) {
			rtiApplicationId = layoutOfBuilding.getRti_ref_id();
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

	ModelAndView modelAndView = new ModelAndView("manageLayOutOfBuilding", "layoutOfBuilding", layoutOfBuilding);

	return modelAndView;

}
@RequestMapping("/rtiapplication/createLayoutOfBuildingWork.do")
public ModelAndView createLayoutOfBuildingWork(HttpServletRequest request, HttpServletResponse response)
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
	LayoutOfBuilding layoutOfBuilding= layoutOfBuildlingService.get(applicationId);
	String email = layoutOfBuilding.getEmailId();
	String mobileNo = layoutOfBuilding.getMobileNo();
	String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
	String applicantName = rtiApplication.getApplicantName();
	if (layoutOfBuilding != null) {
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
				 String msg = "Dear "+applicantName+" your document verification has been successfully completed. Kindly use this link https://tinyurl.com/2yxwb9fd to make a payment in order for your application "+rtiApplnNumber+" to be processed further.Regards, NMCGOV";

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
				String msg = "Dear "+applicantName+" please click on this link https://tinyurl.com/359w8usz to download the Certificate for your application "+rtiApplnNumber+" Regards, NMCGOV";

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
	ModelAndView modelAndView = new ModelAndView("manageLayOutOfBuilding", "layoutOfBuilding", layoutOfBuilding);
	return modelAndView;
}
}
