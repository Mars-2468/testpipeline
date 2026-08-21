package com.mars.rti.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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

import com.mars.common.service.DepartmentService;
import com.mars.common.service.DesignationService;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.ReceivedModeService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.dms.service.DmsDocumentCheckListService;
import com.mars.dms.service.DmsDocumentService;
import com.mars.mail.service.MailService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.FeeMasterService;
import com.mars.rti.service.InboxService;
import com.mars.rti.service.OutboxService;
import com.mars.rti.service.OutwardNumGenarationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.service.WorkflowTemplateTaskService;
import com.mars.workflow.service.WorkflowTemplateUserMappingDetailsService;
import com.mars.workflow.utils.WorkflowConstants;

/**
 * <p>Title: RTIApplicationController.java </p>

 * <p>Description: This is a  rtiApplication controller class for controlling rtiApplication related actions</p>

 * @see com.mars.common.model.RTIApplication
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class RTIApplicationEmailSmsController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(RTIApplicationEmailSmsController.class);
    
    private String DMS_ENTITY_NAME = CoreConstants.RTI_APPLICATION_NEW;

	private String DMS_ENTITY_FOLDER_PATH = CoreConstants.RTI_APPLICATION_NEW_PATH;

    @Autowired
    private RTIApplicationService rtiApplicationService;
    
    @Autowired
    private FeeMasterService feeMasterService;

    @Autowired
    private DepartmentService departmentService;
       
    @Autowired
    private UserService userService;
    
    @Autowired
    private ReceivedModeService receivedModeService;
    
    @Autowired
    private DesignationService designationService;
    @Autowired
    private OutwardNumGenarationService outwardNumGenarationService;
    
    @Autowired
    private OutboxService outboxService;

    @Autowired
    private InboxService inboxService;
    
    @Autowired
	private TenancyService tenancyService;
    
    @Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private DmsDocumentService dmsDocumentService;

	@Autowired
	private DocumentMasterService documentMasterService;
	
	@Autowired
	private DmsDocumentCheckListService dmsDocumentCheckListService;
	
	@Autowired
	private WorkflowTemplateTaskService workflowTemplateTaskService;
	
	@Autowired
	private WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService; 
	
    public void setWorkflowTemplateUserMappingDetailsService(
			WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService) {
		this.workflowTemplateUserMappingDetailsService = workflowTemplateUserMappingDetailsService;
	}

	public void setWorkflowTemplateTaskService(
			WorkflowTemplateTaskService workflowTemplateTaskService) {
		this.workflowTemplateTaskService = workflowTemplateTaskService;
	}
	
    /**
     * @param rtiApplicationService
     *            sets the RTIApplicationService object.
     */
    public void setRTIApplicationService(RTIApplicationService rtiApplicationService){
    	this.rtiApplicationService = rtiApplicationService;
    }
    
    public void setFeeMasterService(FeeMasterService feeMasterService) {
		this.feeMasterService = feeMasterService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setWorkflowProcessDetailsService(WorkflowProcessDetailsService workflowProcessDetailsService) {
  		this.workflowProcessDetailsService = workflowProcessDetailsService;
  	}

    public void setWorkflowService(WorkflowService workflowService) {
  		this.workflowService = workflowService;
  	}

    public void setTaskService(TaskService taskService) {
  		this.taskService = taskService;
  	}
    
    public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
    
    public void setDmsDocumentCheckListService(DmsDocumentCheckListService dmsDocumentCheckListService) {
		this.dmsDocumentCheckListService = dmsDocumentCheckListService;
	}

	public void setDocumentMasterService(DocumentMasterService documentMasterService) {
		this.documentMasterService = documentMasterService;
	}

	public DmsDocumentService getDmsDocumentService() {
		return dmsDocumentService;
	}
	
	public void setRtiApplicationService(RTIApplicationService rtiApplicationService) {
		this.rtiApplicationService = rtiApplicationService;
	}

	public void setOutwardNumGenarationService(OutwardNumGenarationService outwardNumGenarationService) {
		this.outwardNumGenarationService = outwardNumGenarationService;
	}

	public void setOutboxService(OutboxService outboxService) {
		this.outboxService = outboxService;
	}

	public void setInboxService(InboxService inboxService) {
		this.inboxService = inboxService;
	}
	
	public void setTenancyService(TenancyService tenancyService) {
		this.tenancyService = tenancyService;
	}

	public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }   
		 
    public ModelAndView editRTIApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editfileCreation");
		}
		
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
		RTIApplication rtiApplication = null;
		String rtiApplicationId = request.getParameter("rtiApplicationId"); 
		
		if (StringUtils.isNotEmpty(rtiApplicationId))
		{
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId)); 
		    request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
			request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		   
			//request.setAttribute("FILE_HISTORY",fileCreationService.getUserFileCreationDetailsByQuery("fileCreation.fileCreationId",Long.parseLong(fileCreationId)));
		} else
		{
			rtiApplication = new RTIApplication();
		}
		 
		
		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails= null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplication.getRtiApplicationId(),CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
	
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
		 
		request.setAttribute("receivedModeList", receivedModeService.getAll()); 
		request.setAttribute("departmentList", departmentService.getAll()); 
		//request.setAttribute("tenancyList", tenancyService.getAll());
		session.setAttribute("manageUploadToken",session.getAttribute(Constants.SESSION_TOKEN_KEY));
		CommonTokenUtils.setNewToken(request);
		setDMSParameters(request, rtiApplication);

		//FeeMaster feemaster = feeMasterService.getApplicationFeeDetails();
    	//rtiApplication.setApplicationCost(feemaster.getAmount()); 
		
		return new ModelAndView("manageRTIApplication", "rtiApplication", rtiApplication);
		
   }  
    
    
    @RequestMapping("/emailsms/emailSMS.do")
	public ModelAndView emailSMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception{
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking manageReAssignRTIApplicationTask");
		}
		
		 HttpSession session = request.getSession();
		 SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
		 RTIApplication rtiApplication = null; 
		 String rtiApplicationId = request.getParameter("rtiApplicationId");
		
		if (org.apache.commons.lang.StringUtils.isNotEmpty(rtiApplicationId) && !rtiApplicationId.equals("0"))
			{
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));	     
				if(rtiApplication != null ){ 
					 
					request.setAttribute("actionOnFile", request.getParameter("actionTaken"));
					session.setAttribute("manageUploadToken",session.getAttribute(Constants.SESSION_TOKEN_KEY));
					
					CommonTokenUtils.setNewToken(request); 					
					
					return new ModelAndView("rtiApplicationEmailSMS", "rtiApplication", rtiApplication);
			} else{
				 return editRTIApplication(request, response);
			}
		}else{
			return editRTIApplication(request, response);
		}		
    }
	
    private void setDMSParameters(HttpServletRequest request, Object entity) { 

	 	HttpSession session = request.getSession();
	 	clearSessionAttributes(session);
	 	RTIApplication rtiApplication = (RTIApplication) entity;
  		long entityId = rtiApplication.getRtiApplicationId();

    	String entityName = this.DMS_ENTITY_NAME;
    	String folderPath = this.DMS_ENTITY_FOLDER_PATH;
    	folderPath = folderPath.replace("[ENTITY_ID]", ""+entityId);
    	
	    //DMS Integration related Info
	    request.setAttribute("DMS_WORKSPACE_NAME",Constants.WORKSPACE_NAME);
	    request.setAttribute("DMS_FOLDER_PATH",folderPath);
	    request.setAttribute("DMS_ENTITY_NAME",entityName);
	    request.setAttribute("DMS_ENTITY_ID",entityId);
	    request.setAttribute("dmsDocumentsList",dmsDocumentService.getDocumentsByEntity(entityName, entityId));
	    
	    session.setAttribute("workspace",Constants.WORKSPACE_NAME);
	    session.setAttribute("selectedFolderPath",folderPath);
	    session.setAttribute("entityName",entityName);
	    session.setAttribute("entityId",entityId);
	    session.setAttribute("selectedDocumentType",entityName+"_DOC");      	
	} 

	public void clearSessionAttributes(HttpSession session){
		session.setAttribute("workspace",null);
	    session.setAttribute("selectedFolderPath",null);
	    session.setAttribute("entityName",null);
	    session.setAttribute("entityId","");
	    session.setAttribute("uploadType", null);
	    session.setAttribute("selectedDocumentType",null);
	    session.setAttribute("dmsDocumentCheckListId", "");
		session.setAttribute("documentMasterId","");
}
    
		
}
