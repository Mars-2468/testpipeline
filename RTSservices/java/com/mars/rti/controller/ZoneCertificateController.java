package com.mars.rti.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Zone;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.ZoneCertificate;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.ZoneCertificateService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class ZoneCertificateController extends MultiActionController implements InitializingBean{

	 private static String const_OrderBy = "OrderBy";

	 private static String const_SortBy = "SortBy";

	 private static Log log = LogFactory.getLog(ZoneCertificateController.class);
	 
	 @Autowired
	 private ZoneCertificateService zoneCertificateService;
	 
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
	 
	 
	 public void setZoneCertificateService(ZoneCertificateService zoneCertificateService){
		 this.zoneCertificateService=zoneCertificateService;
	 }


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    } 
	
	//save method
	@RequestMapping("/rtiapplication/zonecertificate.do")
    public ModelAndView ZoneCertificate(HttpServletRequest request, HttpServletResponse response,ZoneCertificate zoneCertificate)throws ServletException ,Exception 
    {
    	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listrtiApplicationzone");
		}
		HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long tenancyId=sessionUser.getTenancyId();
		
		    RTIApplicationSearch applicationSearch=new RTIApplicationSearch();
		    applicationSearch.setTenancyId(tenancyId);
		    applicationSearch.setIsRTIAppealApplication(0);
		    setSearchParameters(applicationSearch, request);
		    applicationSearch.setRtiApplicationNumber(""); 		    
		    applicationSearch.setIsRTIAppealApplication(0);
		    
		    List<ZoneCertificate> zoneCertificateList = zoneCertificateService.getZoneCertificateList(applicationSearch);
			try
			{
				long totalCount = zoneCertificateService.getRTIApplicationCount(applicationSearch);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		
		//request.setAttribute("user",user);
		request.setAttribute("currentPage", applicationSearch.getCurrentPage());
		request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
		request.setAttribute(const_SortBy, applicationSearch.getSortBy());
		request.setAttribute("SearchfileCreate", applicationSearch);
		//request.setAttribute("departmentList", departmentService.getAll());
		return new ModelAndView("listZoneCertificate","zoneCertificateList",zoneCertificateList);

	
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
			
			if(request.getParameter("rtiAplicationReceivedDepartment")!=null && !request.getParameter("rtiAplicationReceivedDepartment").equals("")){
				searchFileCreate.setRtiAplicationReceivedDepartment(Long.parseLong(request.getParameter("rtiAplicationReceivedDepartment")));
			}			
			if(request.getParameter("assignedDepartment")!=null && !request.getParameter("assignedDepartment").equals("")){
				searchFileCreate.setAssignedDepartment(Long.parseLong(request.getParameter("assignedDepartment")));
			}			
			if(request.getParameter("assignedSection")!=null && !request.getParameter("assignedSection").equals("")){
				searchFileCreate.setAssignedSection(Long.parseLong(request.getParameter("assignedSection")));
			}
			if(request.getParameter("assignedUser")!=null && !request.getParameter("assignedUser").equals("")){
				searchFileCreate.setAssignedUser(Long.parseLong(request.getParameter("assignedUser")));
			}
			
			searchFileCreate.setReceivedFileRefNo(request.getParameter("receivedFileRefNo"));
			
			String fileStatus = request.getParameter("finalStatus");
			searchFileCreate.setFinalStatus(fileStatus); 
			
			if(request.getParameter("isRTIAppealApplication")!=null && !request.getParameter("isRTIAppealApplication").equals("")){
				searchFileCreate.setIsRTIAppealApplication(Integer.parseInt(request.getParameter("isRTIAppealApplication")));
			}else{
				searchFileCreate.setIsRTIAppealApplication(null);
			}
			
			
    	}catch(Exception err){
    		log.error(err.getMessage());
    	}
    }
	 
	@RequestMapping("/rtiapplication/savezoneCertificate.do")
    public ModelAndView savezoneCertificate(HttpServletRequest request, HttpServletResponse response,ZoneCertificate zoneCertificate) throws ServletException ,Exception 
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		long userId = sessionUser.getUserId();
//		User user=userService.get(sessionUser.getUserId());
    	//ModelAndView modelAndView=new ModelAndView("manageBirthCertificate");
    	//BirthRegistration birthRegistration=null;
    	
		if (log.isDebugEnabled())
		{
			log.debug("Invoking zoneCertificate");
		}
		
		
		
		System.out.println("save controller");
		if(request.getParameter("zonecertificateid")!=null){			
			 
			zoneCertificate=new ZoneCertificate();
			
			if(request.getParameter("zonecertificateid") !=null){
				 String zonecertificateid=(request.getParameter("zonecertificateid"));
				 zoneCertificate.setZonecertificateid(Long.parseLong(zonecertificateid));
			}
			
			
			if(request.getParameter("name") !=null){
			    String appName=request.getParameter("name");
			    zoneCertificate.setName(appName); 
			}
			
			if(request.getParameter("address") !=null){
			    String address=request.getParameter("address");
			    zoneCertificate.setAddress(address); 
			}
			
			if(request.getParameter("ph_no") !=null){
			    String ph_no=request.getParameter("ph_no");
			    zoneCertificate.setPh_no(ph_no); 
			}
			if(request.getParameter("email") !=null){
			    String email=request.getParameter("email");
			    zoneCertificate.setEmail(email); 
			}
			if(request.getParameter("dob") !=null){
			    String dob=request.getParameter("dob");
			    zoneCertificate.setDob(dob); 
			}
			if(request.getParameter("areaName") !=null){
			    String areaName=request.getParameter("areaName");
			    zoneCertificate.setAreaName(areaName); 
			}
			if(request.getParameter("groupNo") !=null){
			    String groupNo=request.getParameter("groupNo");
			    zoneCertificate.setGroupNo(groupNo); 
			}
			//zone
			if(request.getParameter("zone") !=null){
			    String zone=request.getParameter("zone");
			    zoneCertificate.setZone(zone);
			    }
			if(request.getParameter("rtiapplrefno") !=null){
			    String rtiapplrefno=request.getParameter("rtiapplrefno");
			    zoneCertificate.setRtiapplrefno(rtiapplrefno);
			}
			if(request.getParameter("rtiApplicationRefId") !=null){
			    long  rtiApplicationRefId=Long.parseLong(request.getParameter("rtiApplicationRefId"));
			    zoneCertificate.setRti_ref_id(rtiApplicationRefId); 
			}
			
			
			
			zoneCertificateService.saveZoneCertificate(zoneCertificate);
			
			
			
			
		}
		long rtiApplicationId = 0;
		long rtiApplicationRefId = zoneCertificate.getRti_ref_id();
		RTIApplication rtiApplication = null;
		 if(zoneCertificate.getRti_ref_id()>0){
	   	    	rtiApplicationId= zoneCertificate.getRti_ref_id();
	   	    	rtiApplication = rTIApplicationService.get(rtiApplicationId);
	   	       }
	   	       else{
	   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
	   	    	   if(listRTI!=null && !listRTI.isEmpty()){
	   	    		rtiApplicationId = listRTI.get(0).getRtiApplicationId();
	   	    		rtiApplication = listRTI.get(0);
	   	    	   }
	   	       }
		 
	       //zone
			 String strSql2=" select zone_id,name from egovrti.zone  ";
			  List<ArrayList> zonelist = rTIApplicationService.getListBySQLQuery(strSql2, null);
			  List<Zone> newzonelist=new ArrayList<>();
			 for (int i = 0; i < zonelist.size(); i++){
			 Zone zone= new Zone();
			 zone.setZoneId( Long.parseLong(zonelist.get(i).get(0).toString()));
			 zone.setName(zonelist.get(i).get(1).toString());
			 newzonelist.add(zone);
			 }
				 request.setAttribute("zonelist",newzonelist);
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
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rTIApplicationService.save(rtiApplication);
					String msg = "Your Service Request via "+ rtiApplication.getRtiApplnNumber()  +" has been Rejected Regards, AMCORP";
					SendEmail.sendEmail(rtiApplication.getEmail(),"Rejection of your Appl. No."+ rtiApplication.getRtiApplnNumber(), msg);
					SendSMS.sendSingleSMS("1707166556311660472", "ASCDCL", rtiApplication.getPhoneNumber(), msg);
				}
				}
			request.setAttribute("workFlowCompleted", "1");
			}
		session.setAttribute("message", "Zone Certificate Saved Successfully");

		CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"zoneCertificate",rtiApplication);
	       ModelAndView modelAndView=new ModelAndView("manageZonecertificate","zoneCertificate",zoneCertificate);
		return modelAndView;
	
}
    
//@RequestMapping("/rtiapplication/newRTIZoneApplication.do")
//public ModelAndView newRTIZoneApplication(HttpServletRequest request, HttpServletResponse response) 
//throws ServletException {
//String baseDir = getServletContext().getRealPath("");
//String folder = "zoneCertificates";
//File file = new File(baseDir, folder);
//if (!file.exists()) {
//file.mkdirs();
//}
//ModelAndView modelAndView = new ModelAndView("newRTIZoneApplication");
//modelAndView.addObject("folderName",folder);
//return modelAndView;
//}
//	
//	  @RequestMapping("/rtiapplication/editzoneCertificate.do")
//	   public ModelAndView editzoneCertificate(HttpServletRequest request, HttpServletResponse response) throws ServletException ,Exception 
//	   { 
//		   HttpSession session = request.getSession();
//		   System.out.println("hiiii editzoneCertificate");
//	       long rtiApplicationRefId=0;
//	       ZoneCertificate zoneCertificate=null;
//	       long   zoneCertificateid=0;
//
//	       long rtiApplicationId=0;
//	       //DeathRegistration deathRegistration=null;
//	       RTIApplication rtiapplication = null;
//	       SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//	       if(request.getParameter("rtiApplicationRefId") !=null && request.getParameter("rtiApplicationRefId").length()>0 ){
//	    	   
//	    	   rtiApplicationRefId=Long.parseLong(request.getParameter("rtiApplicationRefId"));
//	    	   zoneCertificate= zoneCertificateService.get(rtiApplicationRefId);
//	   	    
//			 if(zoneCertificate.getRti_ref_id()>0){
//		   	    	rtiApplicationId= zoneCertificate.getRti_ref_id();
//		   	    	rtiapplication = rTIApplicationService.get(rtiApplicationId);
//		   	       }
//		   	       else{
//		   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
//		   	    	   if(listRTI!=null && !listRTI.isEmpty()){
//		   	    		rtiApplicationId = listRTI.get(0).getRtiApplicationId();
//		   	    		rtiapplication = listRTI.get(0);
//		   	    	   }
//		   	       }  
//	       }
//	       
//	       //zone
//			 String strSql2=" select zone_id,name from egovrti.zone  ";
//			  List<ArrayList> zonelist = rTIApplicationService.getListBySQLQuery(strSql2, null);
//			  List<Zone> newzonelist=new ArrayList<>();
//			 for (int i = 0; i < zonelist.size(); i++){
//			 Zone zone= new Zone();
//			 zone.setZoneId( Long.parseLong(zonelist.get(i).get(0).toString()));
//			 zone.setName(zonelist.get(i).get(1).toString());
//			 newzonelist.add(zone);
//			 }
//				 request.setAttribute("zonelist",newzonelist);
//		   
//	       request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
//			request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
//			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
//			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
//			request.setAttribute("rtiApplication", rtiapplication);
//			
//			WorkflowProcessDetails workflowProcessDetails = null;
//			WorkflowProcessDetails processDetails= null;
//			workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
//		
//			if(workflowProcessDetails!=null){
//				String processId = workflowProcessDetails.getProcessId();
//				if(processId != null){
//					   processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
//				    }
//				if (!workflowService.isProcessEnded(processId)){
//				String taskId = workflowService.getCurrentTaskId(processId);
//				Task task = null;
//				if(taskId!=null)
//				task = taskService.getTask(taskId);
//				if(processDetails != null){
//					PersonalTask personalTask = new PersonalTask();
//					personalTask.setTask(task);
//					personalTask.setEntityId(processDetails.getEntityId());
//					personalTask.setEntityName(processDetails.getEntityName());
//					personalTask.setWorkflowInitator(processDetails.getUserName());
//					personalTask.setEntityDetails(processDetails.getEntityDetails());
//					request.setAttribute("personalTask", personalTask);
//				}
//				if(task!=null && sessionUser.getUserName().equals(task.getAssignee()))
//				request.setAttribute("userAccess",1);
//		
//				request.setAttribute("workFlowTask", task);
//				}else{
//					
//				request.setAttribute("workFlowCompleted", "1");
//				}
//			} 
//		   
//
//			CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"zoneCertificate",rtiapplication);
//
//	   	   ModelAndView modelAndView=new ModelAndView("manageZonecertificate","zoneCertificate",zoneCertificate);    	
//			
//			
//			
//			return modelAndView;
//		
//	}
	  
	  
}
