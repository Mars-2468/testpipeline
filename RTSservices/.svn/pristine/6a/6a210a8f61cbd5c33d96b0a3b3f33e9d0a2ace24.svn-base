package com.mars.rti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

import com.mars.common.model.Department;
import com.mars.common.model.User;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.SectionService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.dms.service.DmsDocumentCheckListService;
import com.mars.dms.service.DmsDocumentService;
import com.mars.mail.service.MailService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RTIApplicationNoting;
import com.mars.rti.model.RTIApplicationReAssignAcceptance;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.OutwardNumGenarationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;



/**
 * <p>Title: rtiApplicationController.java </p>

 * <p>Description: This is a  FileCreate controller class for controlling rtiApplication related actions</p>

 * @see com.mars.common.model.rtiApplication
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class RTIApplicationVerificationController extends MultiActionController implements InitializingBean
	{
	
	    private static String const_OrderBy = "OrderBy";
	
	    private static String const_SortBy = "SortBy";
	
	    private static Log log = LogFactory.getLog(RTIApplicationVerificationController.class);
	
	    @Autowired
	    private RTIApplicationService rtiApplicationService;
	
	    
	    @Autowired
	    private DepartmentService departmentService;
	    
	    @Autowired
		private TenancyService tenancyService;
	    
	    @Autowired
	    private com.mars.rti.service.OutwardNumGenarationService outwardNumGenarationService;
	    
	    
	    
	    @Autowired
		private MailService mailService;
	    
	    @Autowired
	    private UserService userService; 
	    
	    @Autowired
	    private SectionService sectionService;     
	    
	    private String DMS_ENTITY_NAME =  com.mars.rti.utils.CoreConstants.RTI_APPLICATION_NEW;
	
		private String DMS_ENTITY_FOLDER_PATH = com.mars.rti.utils.CoreConstants.RTI_APPLICATION_NEW_PATH;
	
		@Autowired
		private DmsDocumentService dmsDocumentService;
	
		@Autowired
		private DocumentMasterService documentMasterService;
		
		@Autowired
		private DmsDocumentCheckListService dmsDocumentCheckListService;
		
		@Autowired
		WorkflowProcessDetailsService workflowProcessDetailsService;
	
		@Autowired
		private WorkflowService workflowService;
	
		@Autowired
		private TaskService taskService;
	 
	
	
		public void setOutwardNumGenarationService(
				OutwardNumGenarationService outwardNumGenarationService) {
			this.outwardNumGenarationService = outwardNumGenarationService;
		}
	    
	    
	 
		public void setDepartmentService(DepartmentService departmentService) {
			this.departmentService = departmentService;
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
	
		public void setDmsDocumentService(DmsDocumentService dmsDocumentService) {
			this.dmsDocumentService = dmsDocumentService;
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		public void setSectionService(SectionService sectionService) {
			this.sectionService = sectionService;
		}
		
		public void setMailService(MailService mailService) {
			this.mailService = mailService;
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
		//df.setLenient(true);
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
	    }
	    
	
	    @RequestMapping("/rtiApplicationVerification/editRTIApplicationAction.do")
	    public ModelAndView editRTIApplicationAction(HttpServletRequest request, HttpServletResponse response) throws ServletException
	    {
			if (log.isDebugEnabled())
			{
			    log.debug("Invoking editrtiApplicationAction");
			}
			
			 HttpSession session = request.getSession();
			 SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
			 User user=userService.get(sessionUser.getUserId());
			 RTIApplication rtiApplication = null;
			 RTIApplicationDetails rtiApplicationDetails = null;
			 String rtiApplicationId = request.getParameter("manageRTIApplicationId");
			
			if (StringUtils.isNotEmpty(rtiApplicationId) && !rtiApplicationId.equals("0"))
				{
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));	    
				rtiApplicationDetails = rtiApplicationService.getRTIApplicationDetailsByRTIApplicationIdandStatus(Long.parseLong(rtiApplicationId), 0);
					if(rtiApplication != null || rtiApplicationDetails != null){ 
					    request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
						request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
						request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
						request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
	
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
						 
						request.setAttribute("departmentList", departmentService.findByProperty("tenancyId", 1)); 
						request.setAttribute("tenancyList", tenancyService.getAll());
						request.setAttribute("rtiApplicationDetails", rtiApplicationDetails);
						session.setAttribute("manageUploadToken",session.getAttribute(Constants.SESSION_TOKEN_KEY));
						
						setDMSParameters(request, rtiApplication, rtiApplicationDetails);
						CommonTokenUtils.setNewToken(request);
						
						request.setAttribute("actionTaken", request.getParameter("actionTaken"));
						request.setAttribute("user", user);
						request.setAttribute("totalNotingCount", rtiApplication.getRtiApplicationNoting().size());
						
						request.setAttribute("totalAmount", (rtiApplication.getApplicationCost()+rtiApplication.getPostalCharges()+(rtiApplication.getAmountPerCopy()*rtiApplication.getNumberOfCopies()))); 
						
						
						return new ModelAndView("manageRTIApplicationVerification", "rtiApplication", rtiApplication);
				} else{
					 return listRTIApplication(request, response);
				}
			}else{
			   return listRTIApplication(request, response);
			}		
	    }
	    
	    //Re assign
	    @RequestMapping("/rtiApplicationVerification/saveRTIApplicationAction.do")
	    public ModelAndView saveRTIApplicationAction(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
	    {//
	    	HttpSession session = request.getSession();
	    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			User user=userService.get(sessionUser.getUserId());
	    	
			if (log.isDebugEnabled())
			{
				log.debug("Invoking savertiApplication");
			}
	
			RTIApplication rtiApplication=null;			
			String rtiApplicationId = request.getParameter("rtiApplicationId");
			String rtiApplicationDetailsId = request.getParameter("rtiApplicationDetailsId");	
			String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
			if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) &&  StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level)
					&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0") ) {		
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
				RTIApplicationDetails rtiApplicationDetails1=null;
				if(rtiApplication != null){	
					int assignStatus=1;
					List<RTIApplicationDetails> rtiApplicationDetailsList =  new ArrayList<RTIApplicationDetails>();
					RTIApplicationDetails rtiApplicationDetails=rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));												
					//rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
						
					
					String isAssignedToOther = request.getParameter("isAssignedToOther");
					String sendToReAssign = request.getParameter("sendToReAssign");
					String toUserId = request.getParameter("userId");
					if(sendToReAssign!=null && sendToReAssign.equals("1")){
						
						User assignedToUser = userService.get(Long.parseLong(toUserId));
						User assignedByUser = userService.get(userId);
						
						RTIApplicationReAssignAcceptance  rtiIApplicationReAssignAcceptance = new RTIApplicationReAssignAcceptance();
						rtiIApplicationReAssignAcceptance.setRtiApplication(rtiApplication);
						rtiIApplicationReAssignAcceptance.setAcceptStatus(0);
						rtiIApplicationReAssignAcceptance.setAssignedBy(assignedByUser);
						rtiIApplicationReAssignAcceptance.setAssignedTo(assignedToUser);
						rtiIApplicationReAssignAcceptance.setAssignedDate(CommonUtils.getCurrentStringDate());
						
						List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = new  ArrayList<RTIApplicationReAssignAcceptance>();						
						rtiApplicationReAssignAcceptanceList.add(rtiIApplicationReAssignAcceptance);
						
						rtiApplication.setHasAssignedUser(0);
						rtiApplication.setRtiApplicationReAssignAcceptance(rtiApplicationReAssignAcceptanceList);									
						assignStatus = 1;
						
					}else if(isAssignedToOther !=null && isAssignedToOther.length()>0 && isAssignedToOther.equals("1") && StringUtils.isNotEmpty(toUserId) ){	
						
						User toUser = userService.get(Long.parseLong(toUserId));
						Department department = toUser.getDepartment();
						//Section section = toUser.getSection();					
						
						rtiApplicationDetails.setRtiApplication(rtiApplication);
						rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_FORWARD);	
						rtiApplicationDetails.setAssignToStatus(1);
						rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());				
						rtiApplicationDetails.setToUser(toUser);					
									
						rtiApplicationDetails1= new RTIApplicationDetails();	
						rtiApplicationDetails1.setRtiApplication(rtiApplication);
						rtiApplicationDetails1.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
						rtiApplicationDetails1.setAssignToStatus(0);							
						rtiApplicationDetails1.setAssignedStartDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails1.setUser(toUser);
						//rtiApplicationDetails1.setSection(section);
						rtiApplicationDetails1.setDepartment(department);	
						rtiApplicationDetails1.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level));
						rtiApplicationDetails1.setComments("Re-Assign Task");
						
						rtiApplication.setAssignedDepartment(department);
						//rtiApplication.setAssignedSection(section);
						rtiApplication.setAssigneeUserId(toUser);
						rtiApplication.setHasAssignedUser(1);
						
						assignStatus = assignToUser(request, response);	
					}			
		
					
					if(assignStatus == 1){
						rtiApplicationDetailsList.add(rtiApplicationDetails);
						//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
						if(rtiApplicationDetails1!=null){
							rtiApplicationDetailsList.add(rtiApplicationDetails1);
							//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
						}					
						rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
						session.setAttribute("message", "RTI Application Successfully Assigned...");
						rtiApplicationService.merge(rtiApplication);	
					}else{
						session.setAttribute("errMessage",	"Please Try Again...");
					}				
				}
			}else{
				session.setAttribute("errMessage",	"Please Try Again...");
			}
			
			return listRTIApplication(request, response);
	    }
	   
	    
	    @RequestMapping("/rtiApplicationVerification/saveRTIApplicationNoting.do")
	    //public ModelAndView saveFileNoting(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception
	    public void saveRTIApplicationNoting(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception
	    {
	    	HttpSession session = request.getSession();
	    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			User user=userService.get(sessionUser.getUserId());
	    	
			if (log.isDebugEnabled())
			{
				log.debug("Invoking saveRTIApplicationNoting");
			}
	
			RTIApplication rtiApplication=null;			
			String rtiApplicationId = request.getParameter("rtiApplicationId");
			String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
			if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) 
					&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {		
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
				if(rtiApplication != null){	
					if(user!=null && userId>0){					
						RTIApplicationNoting rtiApplicationNoting = new RTIApplicationNoting(); 					
						rtiApplicationNoting.setRtiApplication(rtiApplication);
						//rtiApplicationNoting.setNoting(request.getParameter("notings"));
						rtiApplicationNoting.setNoting(request.getParameter("notingText"));						
						rtiApplicationNoting.setNotingDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationNoting.setNotingUser(user);
						rtiApplicationNoting.setStatus(1);
						rtiApplicationNoting.setRtiApplicationDetailsId(Long.parseLong(rtiApplicationDetailsId));
						//rtiApplication.addRtiApplicationNoting(rtiApplicationNoting);					
						rtiApplicationService.merge(rtiApplication);
						session.setAttribute("message", "Noting Saved Successfully..");
					}			
					else{
						session.setAttribute("errMessage",	"Please Try Again...");
					}				
				}
			}else{
				session.setAttribute("errMessage",	"Please Try Again...");
			}
			
			//return listrtiApplication(request, response);
	    }
	    
    @RequestMapping("/rtiApplicationVerification/reVerify.do")
    public ModelAndView reVerify(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
    {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user=userService.get(sessionUser.getUserId());
		
		if (log.isDebugEnabled())
		{
			log.debug("Invoking reVerify");
		}
	
		RTIApplication rtiApplication=null;			
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
		
		if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) 
				&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {
			String finalStatus= request.getParameter("inspectionFinalStatus");
			String inspectionTransactionName= request.getParameter("inspectionTransactionName");
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
			String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
			if(rtiApplication != null){				
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails= rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));				
				RTIApplicationDetails rtiApplicationDetails1 = null;
				String toUserId = request.getParameter("userId");								
				int assignStatus=1;
				//rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
				session.setAttribute("message", "Your Comments Saved Successfully..");
				String isAssignedToOther=request.getParameter("isAssignedToOther");						
				
				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
				String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
				
				if(toUserId==null || toUserId.equals("") || toUserId.length()==0){	
					RTIApplicationDetails rtiApplicationDetailsLastUser = rtiApplicationService.getRTIApplicationDetailsByRTIApplicationIdandWFLevel(Long.parseLong(rtiApplicationId),
											rtiApplicationDetails.getWorkflowLevel()-1);
					toUserId = rtiApplicationDetailsLastUser.getUser().getUserId() +"";
					request.removeAttribute("userId");
					request.setAttribute("userId", toUserId+"");
				}
				
				/*if(strWorkflowAction!=null && OrestrWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB))
				{
					rtiApplication.setWorkFlowStatus(0);						
					rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);			
					session.setAttribute("message", "WorkFlow discarded successfully");	
					assignStatus = -1;	
					rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
					rtiApplicationDetails.setAssignToStatus(-1);					
					rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplicationDetails.setWorkflowLevel(0);
				} else*/	
				 if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(CoreConstants.APPL_REVERIFY_TRANSITION)) 
						|| inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_REVERIFY_TRANSITION) 
						|| finalStatus.equalsIgnoreCase(CoreConstants.APPL_REVERIFY_TRANSITION))
				{
					session.setAttribute("message", "WorkFlow process successfully sent for Re-Verification...");
					rtiApplication.setFinalStatus(CoreConstants.APPL_REVERIFY_TRANSITION);		
					if(isAssignedToOther !=null && isAssignedToOther.length()>0 && isAssignedToOther.equals("1") &&  StringUtils.isNotEmpty(toUserId)){
						if(assignStatus != -1){
							
							User toUser = userService.get(Long.parseLong(toUserId));
							Department department = toUser.getDepartment();
							//Section section = toUser.getSection();
							
							rtiApplicationDetails.setRtiApplication(rtiApplication);
							rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_RE_VERIFY);	
							rtiApplicationDetails.setAssignToStatus(1);
							rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());				
							rtiApplicationDetails.setToUser(userService.get(Long.parseLong(toUserId)));							
										
							rtiApplicationDetails1= new RTIApplicationDetails();	
							rtiApplicationDetails1.setRtiApplication(rtiApplication);
							rtiApplicationDetails1.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
							rtiApplicationDetails1.setAssignToStatus(0);							
							rtiApplicationDetails1.setAssignedStartDate(CommonUtils.getCurrentStringDateAndTime());
							rtiApplicationDetails1.setUser(userService.get(Long.parseLong(toUserId)));
							//rtiApplicationDetails1.setSection(section);
							rtiApplicationDetails1.setDepartment(department);	
							rtiApplicationDetails1.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level)-1);
							rtiApplicationDetails1.setComments("RTI Application Re-Verification");
							
							rtiApplication.setAssignedDepartment(department);
							//rtiApplication.setAssignedSection(section);
							rtiApplication.setAssigneeUserId(toUser);
							if(request.getAttribute("userId") == null || request.getAttribute("userId").equals("") ){
								request.setAttribute("userId", toUserId+"");
							}
							assignStatus = assignToUser(request, response);
						}								
					}
				}				
				
				if(assignStatus !=0){	
					rtiApplicationDetailsList.add(rtiApplicationDetails); 
					//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
					if(rtiApplicationDetails1!=null){
						rtiApplicationDetailsList.add(rtiApplicationDetails1);
						//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
					}	
					rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);					
					rtiApplicationService.merge(rtiApplication);	
				}else{			
					session.setAttribute("errMessage",	"Please Try Again...");
				}	
				
			}
		}else{
			session.setAttribute("errMessage",	"Please Try Again...");
		}
		return listRTIApplication(request, response);
	}
	    
	
    @RequestMapping("/rtiApplicationVerification/discard.do")
    public ModelAndView discard(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
    {
    	HttpSession session = request.getSession(); 
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user=userService.get(sessionUser.getUserId());
		
		if (log.isDebugEnabled())
		{
			log.debug("Invoking discard");
		}
	
		RTIApplication rtiApplication=null;			
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
		String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
		if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) &&  StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level)
				&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {
			//String finalStatus= request.getParameter("inspectionFinalStatus");
			String inspectionTransactionName= request.getParameter("inspectionTransactionName");
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
			if(rtiApplication != null){		
				List<RTIApplicationDetails> rtiApplicationDetailsList =  new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails= rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));				
				/*RTIApplicationDetails rtiApplicationDetails1 = null;
				String toUserId = request.getParameter("userId");	
				rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
				String isAssignedToOther=request.getParameter("isAssignedToOther");*/
													
				
				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
				String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
										
				
				if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB)) &&
						inspectionTransactionName!=null && inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_DISCARD_APPLICATION))
				{
					rtiApplication.setWorkFlowStatus(CoreConstants.RTI_STATUS_REJECT);					
					rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);		
					rtiApplication.setClosedDate(CommonUtils.getCurrentStringDate());
			 
					session.setAttribute("message", "RTI Application Discarded Successfully..");
				 	rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
					rtiApplicationDetails.setAssignToStatus(-1);					
					rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplicationDetails.setWorkflowLevel(0);
					
					rtiApplicationDetailsList.add(rtiApplicationDetails); 
					rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList); 
					rtiApplicationService.merge(rtiApplication); 
				}
			}
		}else{
			session.setAttribute("errMessage",	"Please Try Again...");
		}
		return listRTIApplication(request, response);
	
    }
    
	    @RequestMapping("/rtiApplicationVerification/assignForVerification.do")
	    public ModelAndView assignForVerification(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
	    {
	    	HttpSession session = request.getSession();
	    	/*SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			User user=userService.get(sessionUser.getUserId());*/
	    	
			if (log.isDebugEnabled())
			{
				log.debug("Invoking savertiApplication");
			}
	
			RTIApplication rtiApplication=null;			
			String rtiApplicationId = request.getParameter("rtiApplicationId");
			String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
			String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
			if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId)  && StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level) 
					&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {		
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
				String finalStatus= request.getParameter("inspectionFinalStatus");
				String inspectionTransactionName= request.getParameter("inspectionTransactionName");
				if(rtiApplication != null){				
					List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
					RTIApplicationDetails rtiApplicationDetails = rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));
					RTIApplicationDetails rtiApplicationDetails1 = null;
					String toUserId = request.getParameter("userId");								
					int assignStatus=1;
					//rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
					session.setAttribute("message", "Your Comments Saved Successfully..");
					String isAssignedToOther=request.getParameter("isAssignedToOther");						
					
					request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
					request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
					String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
					
					/*if(strWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB))
					{
						rtiApplication.setWorkFlowStatus(0);						
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);			
						session.setAttribute("message", "WorkFlow discarded successfully");	
						assignStatus = -1;	
						rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
						rtiApplicationDetails.setAssignToStatus(-1);					
						rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails.setWorkflowLevel(0);
						//rtiApplicationDetails.setToUser();					
					}		
					else*/ if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(CoreConstants.APPL_VERIFICATION_TRANSITION)) 
							|| inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_VERIFICATION_TRANSITION) 
							|| finalStatus.equalsIgnoreCase(CoreConstants.APPL_VERIFICATION_TRANSITION))
					{
						session.setAttribute("message", "WorkFlow process successfully sent for Re-Verification");
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_VERIFICATION);
						if(isAssignedToOther !=null && isAssignedToOther.length()>0 && isAssignedToOther.equals("1") && StringUtils.isNotEmpty(toUserId)){											
							if(assignStatus != -1){
								
								User toUser = userService.get(Long.parseLong(toUserId));
								Department department = toUser.getDepartment();
								//Section section = toUser.getSection();

								rtiApplicationDetails.setRtiApplication(rtiApplication);
								rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_FORWARD);	
								rtiApplicationDetails.setAssignToStatus(1);
								rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());				
								rtiApplicationDetails.setToUser(toUser);								
											
								rtiApplicationDetails1= new RTIApplicationDetails();	
								rtiApplicationDetails1.setRtiApplication(rtiApplication);
								rtiApplicationDetails1.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
								rtiApplicationDetails1.setAssignToStatus(0);							
								rtiApplicationDetails1.setAssignedStartDate(CommonUtils.getCurrentStringDateAndTime());
								rtiApplicationDetails1.setUser(toUser);
								//rtiApplicationDetails1.setSection(section);
								rtiApplicationDetails1.setDepartment(department);	
								rtiApplicationDetails1.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level)+1);
								rtiApplicationDetails1.setComments("RTI Application  Verification");
								
								rtiApplication.setAssignedDepartment(department);
								//rtiApplication.setAssignedSection(section);
								rtiApplication.setAssigneeUserId(toUser);
								
								assignStatus = assignToUser(request, response);
		
							}
						}	
					}
					if(assignStatus != 0){					
						rtiApplicationDetailsList.add(rtiApplicationDetails);						
						///rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
						if(rtiApplicationDetails1!=null){
							rtiApplicationDetailsList.add(rtiApplicationDetails1);
							//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
						}					
						rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
						rtiApplicationService.merge(rtiApplication);	
					}else{			
						
						session.setAttribute("errMessage",	"Please Try Again...");
					}				
				}
			}else{
				session.setAttribute("errMessage",	"Please Try Again...");
			}
			
			return listRTIApplication(request, response);
	    }
	    
	    
	    @RequestMapping("/rtiApplicationVerification/assignForApproval.do")
	    public ModelAndView assignForApproval(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
	    {
	    	System.out.println("assignForApproval=================================================");
	    	HttpSession session = request.getSession();
	    	/*SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			User user=userService.get(sessionUser.getUserId());*/
	    	
			if (log.isDebugEnabled())
			{
				log.debug("Invoking assignForApproval");
			}
	
			RTIApplication  rtiApplication=null;			
			String rtiApplicationId = request.getParameter("rtiApplicationId");
			String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
			String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
			if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId)  && StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level) 
					&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {		
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
				String finalStatus= request.getParameter("inspectionFinalStatus");
				String inspectionTransactionName= request.getParameter("inspectionTransactionName");
				if(rtiApplication != null){			
					List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
					RTIApplicationDetails rtiApplicationDetails = rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));
					RTIApplicationDetails rtiApplicationDetails1 = null;
					String toUserId = request.getParameter("userId");								
					int assignStatus=1;
					///rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
					session.setAttribute("message", "Your Comments Saved Successfully..");
					String isAssignedToOther=request.getParameter("isAssignedToOther");						
					
					request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
					request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
					String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
					
					/*if(strWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB))
					{
						rtiApplication.setWorkFlowStatus(0);						
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);			
						session.setAttribute("message", "WorkFlow discarded successfully");	
						assignStatus = -1;	
						rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
						rtiApplicationDetails.setAssignToStatus(-1);					
						rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails.setWorkflowLevel(0);
						//rtiApplicationDetails.setToUser();					
					} 
					else*/ if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(CoreConstants.APPL_APPROVAL_TRANSITION)) 
							|| inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_APPROVAL_TRANSITION) 
							|| finalStatus.equalsIgnoreCase(CoreConstants.APPL_APPROVAL_TRANSITION))
					{
						session.setAttribute("message", "WorkFlow process successfully sent for Approval");
						rtiApplication.setFinalStatus(CoreConstants.APPL_APPROVAL_LEVEL);
						if(isAssignedToOther !=null && isAssignedToOther.length()>0 && isAssignedToOther.equals("1") && StringUtils.isNotEmpty(toUserId)){											
							if(assignStatus != -1){
								
								User toUser = userService.get(Long.parseLong(toUserId));
								Department department = toUser.getDepartment();
								//Section section = toUser.getSection();
								
								rtiApplicationDetails.setRtiApplication(rtiApplication);
								rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_FORWARD);	
								rtiApplicationDetails.setAssignToStatus(1);
								rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());				
								rtiApplicationDetails.setToUser(toUser);
																			
								rtiApplicationDetails1 = new RTIApplicationDetails();
								rtiApplicationDetails1.setRtiApplication(rtiApplication);
								rtiApplicationDetails1.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
								rtiApplicationDetails1.setAssignToStatus(0);							
								rtiApplicationDetails1.setAssignedStartDate(CommonUtils.getCurrentStringDateAndTime());
								rtiApplicationDetails1.setUser(toUser);
								//rtiApplicationDetails1.setSection(section);
								rtiApplicationDetails1.setDepartment(department);	
								rtiApplicationDetails1.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level)+1);
								rtiApplicationDetails1.setComments("RTI Application Approval");
								
								rtiApplication.setAssignedDepartment(department);
								//rtiApplication.setAssignedSection(section);
								rtiApplication.setAssigneeUserId(toUser);
								
								assignStatus = assignToUser(request, response);
		
							}
						}	
					}
					if(assignStatus != 0){				
						rtiApplicationDetailsList.add(rtiApplicationDetails);
						//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
						if(rtiApplicationDetails1!=null){
							rtiApplicationDetailsList.add(rtiApplicationDetails1);
							//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
						}					
						rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
						rtiApplicationService.merge(rtiApplication);	
					}else{			
						
						session.setAttribute("errMessage",	"Please Try Again...");
					}				
				}
			}else{
				session.setAttribute("errMessage",	"Please Try Again...");
			}
			System.out.println("assignForApproval=================================================");
			return listRTIApplication(request, response);
	    }
	    
	    
	    
	    @RequestMapping("/rtiApplicationVerification/approveAndSendForClosing.do")
	    public ModelAndView approveAndSendForClosing(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
	    {
	    	System.out.println("assignForClosing=================================================");
	    	HttpSession session = request.getSession();
	    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			User user=userService.get(sessionUser.getUserId());
	    	
			if (log.isDebugEnabled())
			{
				log.debug("Invoking approveRTIApplicationAndSendForClosing");
			}
	
			RTIApplication rtiApplication=null;			
			String rtiApplicationId = request.getParameter("rtiApplicationId");
			String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
			String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
			if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) && StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level)
					&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {
				String finalStatus= request.getParameter("inspectionFinalStatus");
				String inspectionTransactionName= request.getParameter("inspectionTransactionName");
				rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
				if(rtiApplication != null){	
					List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
					RTIApplicationDetails rtiApplicationDetails= rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));				
					RTIApplicationDetails rtiApplicationDetails1 = null;
					String toUserId = request.getParameter("userId");								
					int assignStatus=1;
					//rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
					session.setAttribute("message", "Your Comments Saved Successfully..");
					String isAssignedToOther=request.getParameter("isAssignedToOther");						
					
					request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
					request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
					String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
											
					
					/*if(strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB))
					{
						rtiApplication.setWorkFlowStatus(0);						
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);			
						session.setAttribute("message", "WorkFlow discarded successfully");	
						assignStatus = -1;	
						rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
						rtiApplicationDetails.setAssignToStatus(-1);					
						rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails.setWorkflowLevel(0);
					} 
					else*/ if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(CoreConstants.APPL_APPROVE_TRANSITION)) 
							|| inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_APPROVE_TRANSITION) 
							|| finalStatus.equalsIgnoreCase(CoreConstants.APPL_APPROVE_TRANSITION))
					{
						session.setAttribute("message", "WorkFlow process Completed successfully and Approved...");
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_APPROVED);							
						if(assignStatus != -1){
							
							User toUser = userService.get(Long.parseLong(toUserId));
							Department department = toUser.getDepartment();
							//Section section = toUser.getSection();
							
							rtiApplicationDetails.setRtiApplication(rtiApplication);
							rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_FORWARD);	
							rtiApplicationDetails.setAssignToStatus(1);
							rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());				
							rtiApplicationDetails.setToUser(toUser); 
										
							rtiApplicationDetails1= new RTIApplicationDetails();
							rtiApplicationDetails1.setRtiApplication(rtiApplication);
							rtiApplicationDetails1.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
							rtiApplicationDetails1.setAssignToStatus(0);							
							rtiApplicationDetails1.setAssignedStartDate(CommonUtils.getCurrentStringDateAndTime());
							rtiApplicationDetails1.setUser(toUser);
							//rtiApplicationDetails1.setSection(section);
							rtiApplicationDetails1.setDepartment(department);	
							rtiApplicationDetails1.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level)+1);
							rtiApplicationDetails1.setComments("RTI Application Closing");
							
							rtiApplication.setAssignedDepartment(department);
							//rtiApplication.setAssignedSection(section);
							rtiApplication.setAssigneeUserId(toUser);
							
							assignStatus = assignToUser(request, response);
							
						}								
						
					}
					
					if(assignStatus !=0){	
						rtiApplicationDetailsList.add(rtiApplicationDetails);
						//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
						if(rtiApplicationDetails1!=null){
							rtiApplicationDetailsList.add(rtiApplicationDetails1);
							//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
						}	
						rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
						rtiApplicationService.merge(rtiApplication);	
					}else{			
						session.setAttribute("errMessage",	"Please Try Again...");
					}	
					
				}
			}else{
				session.setAttribute("errMessage",	"Please Try Again...");
			}
			System.out.println("assignForClosing=================================================");
			return listRTIApplication(request, response);
	 }
	    
    @RequestMapping("/rtiApplicationVerification/closeRTIApplication.do")
    public ModelAndView closeRTIApplication(HttpServletRequest request, HttpServletResponse response)  throws ServletException,Exception 
    {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user=userService.get(sessionUser.getUserId());
		
		if (log.isDebugEnabled())
		{
			log.debug("Invoking closeRTIApplication");
		}
	
		RTIApplication rtiApplication=null;			
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		String rtiApplicationDetailsId=request.getParameter("rtiApplicationDetailsId");	
		String rtiApplicationDetailsWF_Level = request.getParameter("rtiApplicationDetailsWF_Level");
		if (StringUtils.isNotEmpty(rtiApplicationId) && StringUtils.isNotEmpty(rtiApplicationDetailsId) &&  StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level)
				&& !rtiApplicationId.equals("0") && !rtiApplicationDetailsId.equals("0")) {
			String finalStatus= request.getParameter("inspectionFinalStatus");
			String inspectionTransactionName= request.getParameter("inspectionTransactionName");
			rtiApplication = rtiApplicationService.get(Long.parseLong(rtiApplicationId));
			if(rtiApplication != null){		
				List<RTIApplicationDetails> rtiApplicationDetailsList =  new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails= rtiApplicationService.getRTIApplicationDetailsById(Long.parseLong(rtiApplicationDetailsId));				
				RTIApplicationDetails rtiApplicationDetails1 = null;
				String toUserId = request.getParameter("userId");								
				int assignStatus=1;
				//rtiApplicationDetails.setComments(request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS));	
				session.setAttribute("message", "Your Comments Saved Successfully..");
				String isAssignedToOther=request.getParameter("isAssignedToOther");						
				
				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, ""+rtiApplication.getRtiApplicationId());
				String strWorkflowAction = request.getParameter(WorkflowConstants.WORKFLOW_ACTION);			
										
				
				/*if(strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(WorkflowConstants.WORKFLOW_ACTION_KILL_JOB))
				{
					rtiApplication.setWorkFlowStatus(0);						
					rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_DISCARDED);			
					session.setAttribute("message", "WorkFlow discarded successfully");	
					assignStatus = -1;	
					rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_REJECT);
					rtiApplicationDetails.setAssignToStatus(-1);					
					rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplicationDetails.setWorkflowLevel(0);
				}	
				else*/ if((strWorkflowAction!=null && strWorkflowAction.equalsIgnoreCase(CoreConstants.APPL_CLOSE_APPLICATION_TRANSITION)) 
						|| inspectionTransactionName.equalsIgnoreCase(CoreConstants.APPL_CLOSE_APPLICATION_TRANSITION) 
						|| finalStatus.equalsIgnoreCase(CoreConstants.APPL_CLOSE_APPLICATION_TRANSITION))
				{
					session.setAttribute("message", "WorkFlow process Completed successfully and Closed...");	
					rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_CLOSED);
					if(assignStatus != -1){
						
						rtiApplication.setFinalStatus(CoreConstants.APPL_STATUS_CLOSED);
						rtiApplication.setClosedDate(CommonUtils.getCurrentStringDate());
						rtiApplication.setWorkFlowStatus(CoreConstants.RTI_STATUS_CLOSED);
						
						rtiApplicationDetails.setRtiApplication(rtiApplication);
						rtiApplicationDetails.setStatus(CoreConstants.RTI_STATUS_CLOSED);	
						rtiApplicationDetails.setAssignToStatus(2);
						rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());	
						//rtiApplicationDetails.setWorkflowLevel(Integer.parseInt(rtiApplicationDetailsWF_Level)+1);
					}			
				}
				
				if(assignStatus !=0){	
					rtiApplicationDetailsList.add(rtiApplicationDetails);
					//rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
/*					if(rtiApplicationDetails1!=null){
						rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
					}	 */					
					rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
					rtiApplicationService.merge(rtiApplication);	
				}else{			
					session.setAttribute("errMessage",	"Please Try Again...");
				}	
				
			}
		}else{
			session.setAttribute("errMessage",	"Please Try Again...");
		}
		return listRTIApplication(request, response);
	}
    
    public ModelAndView listRTIApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listrtiApplication");
		}
		HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long tenancyId=sessionUser.getTenancyId();
		
		    RTIApplicationSearch searchOptions=new RTIApplicationSearch();
		    searchOptions.setTenancyId(tenancyId);
			setSearchParameters(searchOptions, request);
		     searchOptions.setRtiApplicationNumber(""); 
			
			List<RTIApplication> rtiApplicationList = rtiApplicationService.getRTIApplicationList(searchOptions);
			try
			{
				long totalCount = rtiApplicationService.getRTIApplicationCount(searchOptions);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the fileCreateList is null 		
		if(rtiApplicationList==null){
			rtiApplicationList = new ArrayList<RTIApplication>();	
		}
		
		User  user= userService.get(sessionUser.getUserId());
		
		request.setAttribute("user",user);
		request.setAttribute("currentPage", searchOptions.getCurrentPage());
		request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
		request.setAttribute(const_SortBy, searchOptions.getSortBy());
		request.setAttribute("applicaationSearch", searchOptions);
		
			
		return new ModelAndView("listRTIApplication","rtiApplicationList",rtiApplicationList);
    }
   
	public int assignToUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception {
    	HttpSession session = request.getSession();
    	String rtiApplicationId = request.getParameter("rtiApplicationId");
    	String assignToUser = request.getParameter("userId");
    	Object assignToUserSetUser = request.getAttribute("userId");
    	if(assignToUserSetUser!=null && assignToUserSetUser.toString().length()>0 && (assignToUser == null || assignToUser.length() == 0)){
    		assignToUser = assignToUserSetUser.toString();
    	}
    	int returnValue =0 ;
    	//request.setAttribute("renewLicense", renewLicense);
    	if(rtiApplicationId!=null && !rtiApplicationId.isEmpty() && !rtiApplicationId.equals("")){
    		if(assignToUser!=null && !assignToUser.isEmpty() && !assignToUser.equals("")){
	    		String pesonaltaskId=null;
		    	String processId=null;
		    	WorkflowProcessDetails workflowProcessDetails = null;
				WorkflowProcessDetails processDetails= null;						
				workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(rtiApplicationId),CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
		
				if(workflowProcessDetails!=null){
					processId = workflowProcessDetails.getProcessId();
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
							pesonaltaskId=personalTask.getTask().getId();
						}		
						request.setAttribute("workFlowTask", task);
					}
				}
				if(pesonaltaskId!=null && !pesonaltaskId.isEmpty() && !pesonaltaskId.equals("")){
					if(request.getParameter("selectedTaskIds") != null){		
						User user = userService.get(Long.parseLong(assignToUser));
						workflowService.reassignTask(pesonaltaskId, user.getUserName());						
						session.setAttribute("message", "SuccessFully Assigned To User: " + user.getFirstName());	
						returnValue = 1;
					}						
				}		
    	 }
    	}
    	
    	return returnValue;
    }
 
 
    private void setSearchParameters(RTIApplicationSearch searchFileCreate,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
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
			
			searchFileCreate.setRtiApplicationNumber(request.getParameter("rtiApplicationNumber"));
			searchFileCreate.setSubject(request.getParameter("subject"));
			searchFileCreate.setCreationToDate(request.getParameter("creationToDate"));
			searchFileCreate.setCreationFromDate(request.getParameter("creationFromDate"));
			
			if(request.getParameter("assignedDepartment")!=null && !request.getParameter("assignedDepartment").equals(""))
			searchFileCreate.setAssignedDepartment(Long.parseLong(request.getParameter("assignedDepartment")));
			
			if(request.getParameter("assignedSection")!=null && !request.getParameter("assignedSection").equals(""))
			searchFileCreate.setAssignedSection(Long.parseLong(request.getParameter("assignedSection")));
			
			if(request.getParameter("assignedUser")!=null && !request.getParameter("assignedUser").equals(""))
			searchFileCreate.setAssignedUser(Long.parseLong(request.getParameter("assignedUser")));

			searchFileCreate.setReceivedFileRefNo(request.getParameter("receivedFileRefNo"));
			
			String fileStatus = request.getParameter("finalStatus");
			searchFileCreate.setFinalStatus(fileStatus); 
			
    	}catch(Exception err){
    		log.error(err.getMessage());
    	}
    }
    
	 private void setDMSParameters(HttpServletRequest request, Object entity, RTIApplicationDetails rtiApplicationDetails) {	  		 

			 	HttpSession session = request.getSession();
			 	clearSessionAttributes(session);
			 	RTIApplication rtiApplication = (RTIApplication) entity;
		  		long entityId = rtiApplication.getRtiApplicationId();

		    	String entityName = this.DMS_ENTITY_NAME;
		    	String folderPath = this.DMS_ENTITY_FOLDER_PATH;
		    	folderPath = folderPath.replace("[ENTITY_ID]", ""+entityId);
		    	
			    //DMS Integration related Info
			    //request.setAttribute("DMS_WORKSPACE_NAME",Constants.WORKSPACE_NAME);
			    request.setAttribute("DMS_FOLDER_PATH",folderPath);
			    request.setAttribute("DMS_ENTITY_NAME",entityName);
			    request.setAttribute("DMS_ENTITY_ID",entityId);
			    request.setAttribute("dmsDocumentsList",dmsDocumentService.getDocumentsByEntity(entityName, entityId));
			   			   			    
			    //session.setAttribute("workspace",Constants.WORKSPACE_NAME);
			    session.setAttribute("selectedFolderPath",folderPath);
			    session.setAttribute("entityName",entityName);
			    session.setAttribute("entityId",entityId);
			    session.setAttribute("selectedDocumentType",entityName+"_DOC");
			 
	      	    
				session.setAttribute("rtiApplicationDetailsIdNoting",rtiApplicationDetails.getRtiApplicationDetailsId());
				session.setAttribute("rtiApplicationIdNoting",request.getParameter("manageRTIApplicationId"));
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
			session.setAttribute("rtiApplicationDetailsIdNoting","");
			session.setAttribute("rtiApplicationIdNoting","");
 	} 
	
}
