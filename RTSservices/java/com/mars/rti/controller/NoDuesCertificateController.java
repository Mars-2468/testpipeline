package com.mars.rti.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.NoDuesCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.NoDuesCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class NoDuesCertificateController extends MultiActionController
		implements InitializingBean {
	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory
			.getLog(NoDuesCertificateController.class);

	@Autowired
	private NoDuesCertificateService noDuesCertificateService;
	
	 @Autowired
		private WorkflowProcessDetailsService workflowProcessDetailsService;
	    @Autowired
		 private RTIApplicationService rTIApplicationService;
	    
	    @Autowired
		private WorkflowService workflowService;

		@Autowired
		private TaskService taskService;
		
		/*@Autowired
		private WorkflowTemplateTaskService workflowTemplateTaskService;
		
		@Autowired
		private WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService; */
		

		public void setrTIApplicationService(RTIApplicationService rTIApplicationService) {
			this.rTIApplicationService = rTIApplicationService;
		}
		
		public void setWorkflowProcessDetailsService(WorkflowProcessDetailsService workflowProcessDetailsService) {
	  		this.workflowProcessDetailsService = workflowProcessDetailsService;
	  	}
		
	/*    public void setWorkflowTemplateUserMappingDetailsService(
				WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService) {
			this.workflowTemplateUserMappingDetailsService = workflowTemplateUserMappingDetailsService;
		}

		public void setWorkflowTemplateTaskService(
				WorkflowTemplateTaskService workflowTemplateTaskService) {
			this.workflowTemplateTaskService = workflowTemplateTaskService;
		}*/
		
		public void setWorkflowService(WorkflowService workflowService) {
	  		this.workflowService = workflowService;
	  	}

	    public void setTaskService(TaskService taskService) {
	  		this.taskService = taskService;
	  	}
	 
	       

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		df.setLenient(true);
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				df, true));
	}

	@RequestMapping("/rtiapplication/noDuesCertificate.do")
	public ModelAndView noDuesCertificate(HttpServletRequest request,
			HttpServletResponse response, NoDuesCertificate noDuesCertificate)
			throws ServletException, Exception {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listrtiApplicationNoDuesCertificateService");
		}
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long tenancyId = sessionUser.getTenancyId();

		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		applicationSearch.setTenancyId(tenancyId);
		applicationSearch.setIsRTIAppealApplication(0);
		setSearchParameters(applicationSearch, request);
		applicationSearch.setRtiApplicationNumber("");
		applicationSearch.setIsRTIAppealApplication(0);

		List<NoDuesCertificate> noDuesCertificates = noDuesCertificateService
				.getNoDuesCertificateList(applicationSearch);
		try {
			long totalCount = noDuesCertificateService
					.getRTIApplicationCount(applicationSearch);
			request.setAttribute("maximumPages",
					new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// request.setAttribute("user",user);
		request.setAttribute("currentPage", applicationSearch.getCurrentPage());
		request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
		request.setAttribute(const_SortBy, applicationSearch.getSortBy());
		request.setAttribute("SearchfileCreate", applicationSearch);
		// request.setAttribute("departmentList", departmentService.getAll());
		return new ModelAndView("noDuesCertificates", "noDuesCertificates",
				noDuesCertificates);

	}

	private void setSearchParameters(RTIApplicationSearch searchFileCreate,
			HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("setSearchParameters Method is called");
		}

		try {
			long longCurrentPage = CommonUtils
					.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);

			// setting default order by on fileCreateId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "rtiApplicationId";
				sortBy = "desc";
			}

			searchFileCreate.setCurrentPage(longCurrentPage);
			searchFileCreate.setOrderBy(orderBy);
			searchFileCreate.setSortBy(sortBy);

			searchFileCreate.setRtiApplicationNumber(request
					.getParameter("rtiApplicationNumber"));
			searchFileCreate.setSubject(request.getParameter("subject"));
			searchFileCreate.setCreationToDate(request
					.getParameter("creationToDate"));
			searchFileCreate.setCreationFromDate(request
					.getParameter("creationFromDate"));

			if (request.getParameter("rtiAplicationReceivedDepartment") != null
					&& !request.getParameter("rtiAplicationReceivedDepartment")
							.equals("")) {
				searchFileCreate
						.setRtiAplicationReceivedDepartment(Long.parseLong(request
								.getParameter("rtiAplicationReceivedDepartment")));
			}
			if (request.getParameter("assignedDepartment") != null
					&& !request.getParameter("assignedDepartment").equals("")) {
				searchFileCreate.setAssignedDepartment(Long.parseLong(request
						.getParameter("assignedDepartment")));
			}
			if (request.getParameter("assignedSection") != null
					&& !request.getParameter("assignedSection").equals("")) {
				searchFileCreate.setAssignedSection(Long.parseLong(request
						.getParameter("assignedSection")));
			}
			if (request.getParameter("assignedUser") != null
					&& !request.getParameter("assignedUser").equals("")) {
				searchFileCreate.setAssignedUser(Long.parseLong(request
						.getParameter("assignedUser")));
			}

			searchFileCreate.setReceivedFileRefNo(request
					.getParameter("receivedFileRefNo"));

			String fileStatus = request.getParameter("finalStatus");
			searchFileCreate.setFinalStatus(fileStatus);

			if (request.getParameter("isRTIAppealApplication") != null
					&& !request.getParameter("isRTIAppealApplication").equals(
							"")) {
				searchFileCreate.setIsRTIAppealApplication(Integer
						.parseInt(request
								.getParameter("isRTIAppealApplication")));
			} else {
				searchFileCreate.setIsRTIAppealApplication(null);
			}

		} catch (Exception err) {
			log.error(err.getMessage());
		}
	}

	@RequestMapping("/rtiapplication/saveNoDuesCertificate.do")
	public ModelAndView saveNoDuesCertificate(HttpServletRequest request,
			HttpServletResponse response, NoDuesCertificate noDuesCertificate) {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		if(noDuesCertificate.getNdcId()>0){
		NoDuesCertificate oldNoDuesCertificate = noDuesCertificateService
				.getNoDuesCertificate(noDuesCertificate.getNdcId());
		System.out.println(noDuesCertificate);
		oldNoDuesCertificate.setCitySurveyNumber(noDuesCertificate
				.getCitySurveyNumber());
		oldNoDuesCertificate.setAreaName(noDuesCertificate.getAreaName());
		oldNoDuesCertificate.setBuildingName(noDuesCertificate
				.getBuildingName());
		oldNoDuesCertificate.setElectricMeterNumber(noDuesCertificate
				.getElectricMeterNumber());
		oldNoDuesCertificate.setCitySurveyNumber(noDuesCertificate
				.getCitySurveyNumber());
		oldNoDuesCertificate.setNoDuesReason(noDuesCertificate
				.getNoDuesReason());
		oldNoDuesCertificate.setMobileNumber(noDuesCertificate
				.getMobileNumber());
		oldNoDuesCertificate.setPartName(noDuesCertificate.getPartName());
		oldNoDuesCertificate.setEmail(noDuesCertificate.getEmail());
		oldNoDuesCertificate.setPropertyHolderName(noDuesCertificate
				.getPropertyHolderName());
		oldNoDuesCertificate.setTapAccountNumber(noDuesCertificate
				.getTapAccountNumber());
		oldNoDuesCertificate.setElectricMeterNumber(noDuesCertificate
				.getElectricMeterNumber());
		oldNoDuesCertificate.setZonalOffice(noDuesCertificate.getZonalOffice());
		oldNoDuesCertificate.setGeoLocation(noDuesCertificate.getGeoLocation());
		oldNoDuesCertificate.setLandmark(noDuesCertificate.getLandmark());
		oldNoDuesCertificate.setPincode(noDuesCertificate.getPincode());
		oldNoDuesCertificate.setPlotNo(noDuesCertificate.getPlotNo());
		oldNoDuesCertificate.setStreetName(noDuesCertificate.getStreetName());
		noDuesCertificateService.saveNoDuesCertificate(oldNoDuesCertificate);
	}
		long rtiApplicationId = 0;
		long rtiApplicationRefId = noDuesCertificate.getRti_ref_id();
		RTIApplication rtiApplication = null;
		 if(noDuesCertificate.getRti_ref_id()>0){
	   	    	rtiApplicationId= noDuesCertificate.getRti_ref_id();
	   	    	rtiApplication = rTIApplicationService.get(rtiApplicationId);
	   	       }
	   	       else{
	   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
	   	    	   if(listRTI!=null && !listRTI.isEmpty()){
	   	    		rtiApplicationId = listRTI.get(0).getRtiApplicationId();
	   	    		rtiApplication = listRTI.get(0);
	   	    	   }
	   	       }
		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails= null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
	
		if(workflowProcessDetails!=null){
			String processId = workflowProcessDetails.getProcessId();
			if(processId != null){
				   processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
			    }
			if (!workflowService.isProcessEnded(processId)){
			String taskId = workflowService.getCurrentTaskId(processId);
			Task task = null;
			if(taskId!=null)
			task = taskService.getTask(taskId);
			if(processDetails != null){
				PersonalTask personalTask = new PersonalTask();
				personalTask.setTask(task);
				personalTask.setEntityId(processDetails.getEntityId());
				personalTask.setEntityName(processDetails.getEntityName());
				personalTask.setWorkflowInitator(processDetails.getUserName());
				personalTask.setEntityDetails(processDetails.getEntityDetails());
				request.setAttribute("personalTask", personalTask);
			}
			//RTIApplication rtiApplication = null;
			if(rtiApplication!=null){
	   	    	//rtiApplication=rTIApplicationService.get(Long.parseLong(deathRegistration.getRtiapplrefno()));
	   	    	rtiApplication.setWorkFlowStatus(3);
	   	    	rTIApplicationService.save(rtiApplication);
				String link ="https://tinyurl.com/4hhhy9w9";
				String msg = "Dear " + rtiApplication.getApplicantName() +" for your Appl. No. " + rtiApplication.getRtiApplnNumber() 
						+" please use this link " 
						+ link+ " to make the payment. Regards, AMCORP";
				
				msg.replace("var3", "");
				//birthRegistration.setPh_no("9052724068");
				SendEmail.sendEmail(rtiApplication.getEmail(),"Payment link for your Appl. No."+ rtiApplication.getRtiApplnNumber(), msg);
				SendSMS.sendSingleSMS("1707166556311660472", "ASCDCL", rtiApplication.getPhoneNumber(), msg);
			}
			if(request.getParameter("WORKFLOW_TRANSISTION").isEmpty() || request.getParameter("WORKFLOW_TRANSISTION")==null){
				
			}
			if(task!=null && sessionUser.getUserName().equals(task.getAssignee()))
			request.setAttribute("userAccess",1);
	
			request.setAttribute("workFlowTask", task);
			}else{
				if(request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")){
				//RTIApplication rtiApplication = null;
				//rtiApplication=rTIApplicationService.get(Long.parseLong(birthRegistration.getRtiapplrefno()));
				//if(birthRegistration.getRtiapplrefno()!=null){
		   	    	
		   	    	rtiApplication.setWorkFlowStatus(1);
		   	    	rTIApplicationService.save(rtiApplication);
					String link ="https://tinyurl.com/4hhhy9w9";
					String msg = "Dear " + rtiApplication.getApplicantName() +" for your Appl. No. " 
					+ rtiApplication.getRtiApplnNumber() 
							+" is completed. Please login to RTS and download your certificate " 
							 +" Regards, AMCORP";
					
					msg.replace("var3", "");
					//birthRegistration.setPh_no("9052724068");
					SendEmail.sendEmail(rtiApplication.getEmail(),"Completion of your Appl. No."+ rtiApplication.getRtiApplnNumber(), msg);
					//SendSMS.sendSingleSMS("1707166556311660472", "ASCDCL", birthRegistration.getPh_no(), msg);
				}
				else if(request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")){
					rtiApplication.setWorkFlowStatus(5);
					rTIApplicationService.save(rtiApplication);
					String msg = "Your Service Request via "+ rtiApplication.getRtiApplnNumber()  +" has been Rejected Regards, AMCORP";
					SendEmail.sendEmail(rtiApplication.getEmail(),"Rejection of your Appl. No."+ rtiApplication.getRtiApplnNumber(), msg);
					SendSMS.sendSingleSMS("1707166556311660472", "ASCDCL", rtiApplication.getPhoneNumber(), msg);
				}
				}
			request.setAttribute("workFlowCompleted", "1");
			}
		session.setAttribute("message", "No Dues Certificate Saved Successfully");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manageNoDuesCertificate");
		modelAndView.addObject("noDuesCertificate", noDuesCertificate);
		return modelAndView;

	}

	@RequestMapping("/rtiapplication/editNoDuesCertificate.do")
	public ModelAndView editNoDuesCertificate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		NoDuesCertificate noDuesCertificate = null;
		HttpSession session = request.getSession();
		   
	       long rtiApplicationRefId=0;
	      // TreeTrimming  treeTrimming=null;
	      // long dogid=0;
	       long rtiApplicationId=0;
	       //DeathRegistration deathRegistration=null;
	       RTIApplication rtiapplication = null;
	       SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
	       if(request.getParameter("rtiApplicationRefId") !=null && request.getParameter("rtiApplicationRefId").length()>0 ){
	    	   
	    	   rtiApplicationRefId=Long.parseLong(request.getParameter("rtiApplicationRefId"));
	    	   noDuesCertificate= noDuesCertificateService.get(rtiApplicationRefId);
	   	    
			 if(noDuesCertificate.getRti_ref_id()>0){
		   	    	rtiApplicationId= noDuesCertificate.getRti_ref_id();
		   	    	rtiapplication = rTIApplicationService.get(rtiApplicationId);
		   	       }
		   	       else{
		   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
		   	    	   if(listRTI!=null && !listRTI.isEmpty()){
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
			WorkflowProcessDetails processDetails= null;
			workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		
			if(workflowProcessDetails!=null){
				String processId = workflowProcessDetails.getProcessId();
				if(processId != null){
					   processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
				    }
				if (!workflowService.isProcessEnded(processId)){
				String taskId = workflowService.getCurrentTaskId(processId);
				Task task = null;
				if(taskId!=null)
				task = taskService.getTask(taskId);
				if(processDetails != null){
					PersonalTask personalTask = new PersonalTask();
					personalTask.setTask(task);
					personalTask.setEntityId(processDetails.getEntityId());
					personalTask.setEntityName(processDetails.getEntityName());
					personalTask.setWorkflowInitator(processDetails.getUserName());
					personalTask.setEntityDetails(processDetails.getEntityDetails());
					request.setAttribute("personalTask", personalTask);
				}
				if(task!=null && sessionUser.getUserName().equals(task.getAssignee()))
				request.setAttribute("userAccess",1);
		
				request.setAttribute("workFlowTask", task);
				}else{
					
				request.setAttribute("workFlowCompleted", "1");
				}
			} 
	

		ModelAndView modelAndView = new ModelAndView("manageNoDuesCertificate",
				"noDuesCertificate", noDuesCertificate);

		return modelAndView;

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
