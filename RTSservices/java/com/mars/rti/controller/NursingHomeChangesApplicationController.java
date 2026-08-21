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
import com.mars.rti.model.FeesMaster;
import com.mars.rti.model.NursingHomeChangesApplication;
import com.mars.rti.model.NursingHomes;
import com.mars.rti.model.NursingOwnerDetails;
import com.mars.rti.model.NursingOwnerDetailsChange;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.FeesMasterService;
import com.mars.rti.service.NursingHomeChangesApplicationService;
import com.mars.rti.service.NursingOwnerDetailsChangeService;
import com.mars.rti.service.NursingOwnerDetailsService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.MandapPermissionRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class NursingHomeChangesApplicationController {


	private static Log log = LogFactory
			.getLog(NursingHomeChangesApplicationController.class);

	@Autowired
	private NursingHomeChangesApplicationService nursingHomeChangesApplicationService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private FeesMasterController feesMasterController;
	
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
	
	@Autowired
    private FeesMasterService feesMasterService ;
	
	
	@Autowired
	private NursingOwnerDetailsChangeService nursingOwnerDetailsChangeService;
	
	@Autowired
	private NursingOwnerDetailsService nursingOwnerDetailsService;
	

	
	@RequestMapping("/rtiapplication/saveNursingHomeChangesApplication.do")
	public ModelAndView saveNursingHomeChangesApplication(
			HttpServletRequest request, HttpServletResponse response,
			NursingHomeChangesApplication nursingHomeChangesApplication) {
		HttpSession session = request.getSession(true);
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (log.isDebugEnabled()) {
			log.debug("Invoking NursingHomeChangesApplication");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking NursingHomeChangesApplication");
		}
		
		//Nursing homes Change--Addition Owner Details
		String[] additionOwnerName =  request.getParameterValues("additionOwnerName");
		String [] additinAddress = request.getParameterValues("additionOwnerName");
		String [] addtitonMobileNo = request.getParameterValues("additionOwnerName");
		String [] additionalEmail = request.getParameterValues("email");
		
		//Nursing homes Change--Change Owner Details
		String[] changeOwnerName =  request.getParameterValues("changeOwnerName");
		String [] changeAddress = request.getParameterValues("changeAddress");
		String [] changeMobileNo = request.getParameterValues("changeMobileNo");
		String [] changeEmail = request.getParameterValues("changeEmail");

		
		
		String mobileNumber = "";
		RTIApplication retunRti=null;
		String user_name=null;
		Object user_login= request.getSession().getAttribute("name");
		double fees=0;
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

			if (nursingHomeChangesApplication != null) {

				RTIApplication rtiApplication = new RTIApplication();
				
				if((changeOwnerName!=null && additionOwnerName==null) || nursingHomeChangesApplication.getSanctionedBedMaternity()!=null) {
				 fees=feesMasterController.setNursingHomeChangeApplicationFees(nursingHomeChangesApplication.getSanctionedBedMaternity(), nursingHomeChangesApplication.getSanctionedBedOther());
	                rtiApplication.setApplicationCost(fees);
	                nursingHomeChangesApplication.setTotalFees(fees);
	                
				}else {
					fees=feesMasterController.setNursingHomeFees(nursingHomeChangesApplication.getChangeBedMaternity(), nursingHomeChangesApplication.getChangeBedOther());
	                rtiApplication.setApplicationCost(fees);
	                nursingHomeChangesApplication.setTotalFees(fees);
				}
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("nursingregistration");
				rtiApplication.setSubject("NURSING-HOME-CHANGES-CERTIFICATE");
				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(96);
				if(changeOwnerName!=null && changeEmail!=null && changeMobileNo!=null) {
					rtiApplication.setApplicantName(changeOwnerName[0]);
					rtiApplication.setPhoneNumber(changeMobileNo[0]);
					rtiApplication.setMobileNumber(changeMobileNo[0]);
					rtiApplication.setEmail(changeEmail[0]);

				}else if(additionOwnerName!=null && addtitonMobileNo!=null && additionalEmail!=null){
					rtiApplication.setApplicantName(additionOwnerName[0]);
					rtiApplication.setPhoneNumber(addtitonMobileNo[0]);
					rtiApplication.setMobileNumber(addtitonMobileNo[0]);
					rtiApplication.setEmail(additionalEmail[0]);
				}else {
					rtiApplication.setApplicantName(nursingHomeChangesApplication.getName());
					rtiApplication.setPhoneNumber(nursingHomeChangesApplication.getMobileNo());
					rtiApplication.setMobileNumber(nursingHomeChangesApplication.getMobileNo());
					rtiApplication.setEmail(nursingHomeChangesApplication.getEmailId());
				}
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
			
				rtiApplication.setZone(nursingHomeChangesApplication.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicationCost(nursingHomeChangesApplication.getTotalFees());

				rtiApplication.setPdfUploadFromPortal(nursingHomeChangesApplication.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/HD" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					nursingHomeChangesApplication.setRtiapplrefno(rti.getRtiApplnNumber());
					nursingHomeChangesApplication.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = nursingHomeChangesApplicationService.nursingHomeChangesApplications(nursingHomeChangesApplication);
					rti.setRtiApplicationRefId(birth_regis_id);
					 retunRti = rtiApplicationService.merge(rti);

					 nursingHomeChangesApplication=nursingHomeChangesApplicationService.get(birth_regis_id);
					 //Saving NurongOwner and ChangeOwner Details
					 if(additionOwnerName!=null && additionOwnerName.length>0) {
					 for(int i=0;i<additionOwnerName.length;i++) {
						 NursingOwnerDetails nod = new NursingOwnerDetails();
						 
						 if(additionOwnerName!=null) {
							 nod.setAdditionAddress(additinAddress[i]);
							 
						 }
						 if(addtitonMobileNo!=null) {
							 nod.setAdditionMobileNo(addtitonMobileNo[i]);

						 }

						 if(additionOwnerName!=null) {
							 nod.setAdditionOwnerName(additionOwnerName[i]);
						 }
						 if(additionalEmail!=null) {
							 nod.setEmail(additionalEmail[i]);
						 }
						 
						 nod.setNursingHomeChangesApplication(nursingHomeChangesApplication);
						 nursingOwnerDetailsService.mergeNurseOwnerDetails(nod);
					 }
					 }
					 
					 
					 if(changeOwnerName!=null && changeOwnerName.length>0) {
						 for(int i =0;i<changeOwnerName.length;i++) {
							 NursingOwnerDetailsChange ndc = new NursingOwnerDetailsChange();
							 if(changeAddress!=null) {
								 ndc.setChangeAddress(changeAddress[i]);
							 }
							 
							 if(changeMobileNo!=null) {
								 ndc.setChangeMobileNo(changeMobileNo[i]);
							 }
							 
							 if(changeOwnerName!=null) {
								 ndc.setChangeOwnerName(changeOwnerName[i]);
							 }
							 
							 if(changeEmail!=null) {
								 ndc.setChangeEmail(changeEmail[i]);
							 }
							 ndc.setNursingHomeChangesApplication(nursingHomeChangesApplication);
							 nursingOwnerDetailsChangeService.mergeownerDetails(ndc);
							 
						 }
					 }

					SendSMSEmailController.sendApplicationSubmitted(retunRti.getApplicantName(),retunRti.getMobileNumber() , retunRti.getRtiApplnNumber(), retunRti.getEmail());
				}
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRTSNursingHomeChangesSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}
			}
		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	

	@RequestMapping("ws/rtsapplication/newRTSNursingHomeChangesSuccess.do")
	public ModelAndView newRTSNursingHomeChangesSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSHursingChangesSuccess");
		
		model.addObject("rtsNo",appNo);
		return model;
				
		
	}
	@RequestMapping("/rtsapplication/saveChangeInBedsMhoRemark.do")
	public ModelAndView saveMhoRemark(HttpServletRequest request, HttpServletResponse response,
			NursingHomeChangesApplication nh) throws ServletException, Exception {
	    String approvalRemark = request.getParameter("approvalRemark");
	    String approvalRemark1 = request.getParameter("approvalRemark1");

		String refid = request.getParameter("nhcaId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);

		nh = nursingHomeChangesApplicationService.get(apprefid);

		if (approvalRemark !=null && nh.getMhoRemark()==null) {
			nh.setMhoRemark(approvalRemark);

			nh = nursingHomeChangesApplicationService.merge(nh);

		}else if (approvalRemark1 !=null && nh.gethQRemark()==null) {
			nh.sethQRemark(approvalRemark1);

			nh = nursingHomeChangesApplicationService.merge(nh);
		}
		return new ModelAndView(
				"redirect:/rtsapplication/editNursingHomeChangesApplication.do?rtiApplicationRefId=" + apprefid);
	}
	
	
	@RequestMapping("/rtsapplication/editNursingHomeChangesApplication.do")
	public ModelAndView editNursingHomeChangesApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		NursingHomeChangesApplication nursingHomeChangesApplication = null;
		HttpSession session = request.getSession();
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		List<NursingOwnerDetails> nod=null;
		List<NursingOwnerDetailsChange> ndc=null;
		
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId=0;
		if (sessionUser != null) {
			 userId = sessionUser.getUserId();
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				nursingHomeChangesApplication = nursingHomeChangesApplicationService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				nursingHomeChangesApplication = nursingHomeChangesApplicationService.get(rtiApplicationRefId);
			}
			if (nursingHomeChangesApplication.getRti_ref_id() > 0) {
				rtiApplicationId = nursingHomeChangesApplication.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
			
			if(nursingHomeChangesApplication.getSd()!=null && nursingHomeChangesApplication.getSd().size()>0) {
				nod = nursingHomeChangesApplication.getSd();
			}
			if(nursingHomeChangesApplication.getNd()!=null && nursingHomeChangesApplication.getNd().size()>0) {
				ndc = nursingHomeChangesApplication.getNd();
			}
		}
		
        request.setAttribute("nod", nod);
        request.setAttribute("ndc", ndc);
		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_NURSING_REGISTRATION);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_NURSING_REGISTRATION);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_NURSING_REGISTRATION);

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
		
		User user = userservice.get(userId);
		String userLoginId = user.getUserLevel();
        if(userLoginId!=null && !userLoginId.isEmpty()) {

		if(userLoginId.equals("L1")) {
			request.setAttribute("forLogin", "L1");
		}else if (userLoginId.equals("L2")) {
			request.setAttribute("forLogin", "L2");
		}else if (userLoginId.equals("L3")) {
			request.setAttribute("forLogin", "L3");
		}else if (userLoginId.equals("L4")) {
			request.setAttribute("forLogin", "L4");
		}
		else
		{
			request.setAttribute("forLogin", "nothing");
		}
		
        }
        
	   	   ModelAndView modelAndView=new ModelAndView("manageNursingHomeChangesApplication","nursingHomeChangesApplication",nursingHomeChangesApplication);    	

				return modelAndView;
		
		
	}	return new ModelAndView("redirect:/login.do");
}
	
	
	@RequestMapping("/rtsapplication/createNursingHomeChanges.do")
	public ModelAndView createNursingHomeChanges(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_NURSING_REGISTRATION);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		NursingHomeChangesApplication nursingHomeChangesApplication = nursingHomeChangesApplicationService.get(applicationId);
		
		String email = rtiApplication.getEmail();
		String mobileNo = rtiApplication.getPhoneNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (nursingHomeChangesApplication != null) {
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
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			} else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				rtiApplicationService.save(rtiApplication);
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_NURSING_REGISTRATION);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_NURSING_REGISTRATION);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtsapplication/editNursingHomeChangesApplication.do");
	}
	
}
		

