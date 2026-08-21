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
import org.directwebremoting.Container;
import org.directwebremoting.extend.InitializingBean;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Crematorium;
import com.mars.common.model.Hospital;
import com.mars.common.model.Zone;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.DeathCertificate;
import com.mars.rti.model.DeathRegistration;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.DeathCertificateService;
import com.mars.rti.service.DeathRegistrationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class DeathRegistartionController extends MultiActionController implements InitializingBean {
	
	 private static String const_OrderBy = "OrderBy";

	 private static String const_SortBy = "SortBy";

	 private static Log log = (Log) LogFactory.getLog(DeathRegistartionController.class);
	 
	 @Autowired
	 private DeathRegistrationService deathRegistrationService;
	 
	 @Autowired
	 private DeathCertificateService deathCertificateService;

	 @Autowired
	 private RTIApplicationService rTIApplicationService;
	 
	 
	@Autowired
		private WorkflowProcessDetailsService workflowProcessDetailsService;
	 
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
	public void setDeathRegistrationService(
			DeathRegistrationService deathRegistrationService) {
		this.deathRegistrationService =deathRegistrationService;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

   
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }
	
	//save Functionality
	
	@RequestMapping("/services/deathRegistrationCertificate.do")
    public ModelAndView deathRegistrationCertificate(HttpServletRequest request, HttpServletResponse response, DeathRegistration deathRegistration) throws ServletException ,Exception 
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		long userId = sessionUser.getUserId();
//		User user=userService.get(sessionUser.getUserId());
    	ModelAndView modelAndView=new ModelAndView("manageDeathCertificate");    	
		
		return modelAndView;
	
}
	
	
	
   @RequestMapping("/rtiapplication/saveDeathRegistrationCertificate.do")  
    public ModelAndView saveDeathRegistrationCertificate(HttpServletRequest request, HttpServletResponse response) throws ServletException ,Exception 
    {
	HttpSession session = request.getSession();
   	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		long userId = sessionUser.getUserId();
//		User user=userService.get(sessionUser.getUserId());
   	ModelAndView modelAndView=new ModelAndView("manageDeathRegistration");
   	DeathRegistration deathRegistration=null;
		if (log.isDebugEnabled())
		{
			log.debug("Invoking saveDeathRegistrationCertificate");
		}
		
		System.out.println("save controller");
		if(request.getParameter("deathRegistrationId")!=null){			
			 
			deathRegistration=new DeathRegistration();
			
			if(request.getParameter("deathRegistrationId") !=null){
				 String deathRegistrationId=request.getParameter("deathRegistrationId");
				 deathRegistration.setDeathRegistrationId(Long.parseLong(deathRegistrationId));
			}			 
			
			if(request.getParameter("applicantName") !=null){
			    String applicantName=request.getParameter("applicantName");
			    deathRegistration.setApplicantName(applicantName); 
			}
			
			if(request.getParameter("applicantAddress") !=null){
			    String applicantAddress=request.getParameter("applicantAddress");
			    deathRegistration.setApplicantAddress(applicantAddress); 
			}
			
			if(request.getParameter("mobileNo") !=null){
			    String mobileNo=request.getParameter("mobileNo");
			    deathRegistration.setMobileNo(mobileNo); 
			}
			
			if(request.getParameter("emailId") !=null){
			    String emailId=request.getParameter("emailId");
			    deathRegistration.setEmailId(emailId); 
			}
			if(request.getParameter("dateOfBirth") !=null){
			    String dateOfBirth=request.getParameter("dateOfBirth");
			    deathRegistration.setDateOfBirth(dateOfBirth); 
			}
			
			if(request.getParameter("dateOfDeath") !=null){
			    String dateOfDeath=request.getParameter("dateOfDeath");
			    deathRegistration.setDateOfDeath(dateOfDeath); 
			}
			
			if(request.getParameter("placeOfDeath") !=null){
			    String placeOfDeath=request.getParameter("placeOfDeath");
			    deathRegistration.setPlaceOfDeath(placeOfDeath); 
			}
			
			if(request.getParameter("gender") !=null){
				 String gender=request.getParameter("gender");
				    deathRegistration.setGender(gender); 
			}
			
			if(request.getParameter("ageAtDeathTime") !=null){
			    String ageAtDeathTime=request.getParameter("ageAtDeathTime");
			    deathRegistration.setAgeAtDeathTime(ageAtDeathTime); 
			}
			
			if(request.getParameter("nameOfDeceased") !=null){
			    String nameOfDeceased=request.getParameter("nameOfDeceased");
			    deathRegistration.setNameOfDeceased(nameOfDeceased); 
			}
			    if(request.getParameter("fatherName") !=null){
			    String fatherName=request.getParameter("fatherName");
			    deathRegistration.setFatherName(fatherName); 
			}
			
			if(request.getParameter("addressOfDeceased") !=null){
			    String addressOfDeceased=request.getParameter("addressOfDeceased");
			    deathRegistration.setAddressOfDeceased(addressOfDeceased); 
			}
			if(request.getParameter("reasonOfDeath") !=null){
			    String reasonOfDeath=request.getParameter("reasonOfDeath");
			    deathRegistration.setReasonOfDeath(reasonOfDeath); 
			}
			
			if(request.getParameter("nameOfCrematorium") !=null){
			    String nameOfCrematorium =request.getParameter("nameOfCrematorium");
			    deathRegistration.setNameofCrematorium(nameOfCrematorium); 
			}
			
			if(request.getParameter("oldRegistrationNumber") !=null){
			    String oldRegistrationNumber=request.getParameter("oldRegistrationNumber");
			    deathRegistration.setOldRegistrationNumber(oldRegistrationNumber); 
			}
			if(request.getParameter("rtiApplicationRefId") !=null){
			    long  rtiApplicationRefId=Long.parseLong(request.getParameter("rtiApplicationRefId"));
			    deathRegistration.setRti_ref_id(rtiApplicationRefId); 
			}
			//new ones
			if(request.getParameter("grandfatherName") !=null){
			    String  grandfatherName=request.getParameter("grandfatherName");
			    deathRegistration.setGrandfatherName(grandfatherName); 
			}
			
			if(request.getParameter("motherName") !=null){
			    String  motherName=request.getParameter("motherName");
			    deathRegistration.setMotherName(motherName); 
			}
			
			if(request.getParameter("hospitalName") !=null){
			    String  hospitalName=request.getParameter("hospitalName");
			    deathRegistration.setHospitalName(hospitalName); 
			}
			
			if(request.getParameter("zone") !=null){
			    String  zone=request.getParameter("zone");
			    deathRegistration.setZone(zone); 
			}
			if(request.getParameter("wifeName") !=null){
			    String  wifeName=request.getParameter("wifeName");
			    deathRegistration.setWifeName(wifeName); 
			}
			if(request.getParameter("deathType") !=null){
			    String  deathType=request.getParameter("deathType");
			    deathRegistration.setDeathType(deathType); 
			}
			if(request.getParameter("reasonForCertificate") !=null){
			    String  reasonForCertificate=request.getParameter("reasonForCertificate");
			    deathRegistration.setReasonForCertificate(reasonForCertificate); 
			}
			if(request.getParameter("applicantTitle") !=null){
			    String  applicantTitle=request.getParameter("applicantTitle");
			    deathRegistration.setApplicantTitle(applicantTitle); 
			}
			if(request.getParameter("applicantFirstName") !=null){
			    String  applicantFirstName=request.getParameter("applicantFirstName");
			    deathRegistration.setApplicantFirstName(applicantFirstName);
			}
			if(request.getParameter("applicantMiddleName") !=null){
			    String  applicantMiddleName=request.getParameter("applicantMiddleName");
			    deathRegistration.setApplicantMiddleName(applicantMiddleName);
			}
			if(request.getParameter("applicantLastName") !=null){
			    String  applicantLastName=request.getParameter("applicantLastName");
			    deathRegistration.setApplicantLastName(applicantLastName);
			}
			if(request.getParameter("applicantPlotNo") !=null){
			    String  applicantPlotNo=request.getParameter("applicantPlotNo");
			    deathRegistration.setApplicantPlotNo(applicantPlotNo);
			}
			if(request.getParameter("applicantBuildingName") !=null){
			    String  applicantBuildingName=request.getParameter("applicantBuildingName");
			    deathRegistration.setApplicantBuildingName(applicantBuildingName);
			}
			if(request.getParameter("applicantStreet") !=null){
			    String  applicantStreet=request.getParameter("applicantStreet");
			    deathRegistration.setApplicantStreet(applicantStreet);
			}
			if(request.getParameter("applicantArea") !=null){
			    String  applicantArea=request.getParameter("applicantArea");
			    deathRegistration.setApplicantArea(applicantArea);
			}
			if(request.getParameter("applicantNearByLandmark") !=null){
			    String  applicantNearByLandmark=request.getParameter("applicantNearByLandmark");
			    deathRegistration.setApplicantNearByLandmark(applicantNearByLandmark);
			}
			if(request.getParameter("applicantPinCode") !=null){
			    String  applicantPinCode=request.getParameter("applicantPinCode");
			    deathRegistration.setApplicantPinCode(applicantPinCode);
			}
			if(request.getParameter("applicantRelationship") !=null){
			    String  applicantRelationship=request.getParameter("applicantRelationship");
			    deathRegistration.setApplicantRelationship(applicantRelationship);
			}
			if(request.getParameter("applicantCorrespondenceAddress") !=null){
			    String  applicantCorrespondenceAddress=request.getParameter("applicantCorrespondenceAddress");
			    deathRegistration.setApplicantCorrespondenceAddress(applicantCorrespondenceAddress);
			}
			deathRegistrationService.deathRegistrationCertificate(deathRegistration);
		}
		session.setAttribute("message", "Death Registration  Saved Successfully");
		long rtiApplicationId = 0;
		long rtiApplicationRefId = deathRegistration.getDeathRegistrationId();
		RTIApplication rtiApplication = null;
		 if(deathRegistration.getRti_ref_id()>0){
	   	    	rtiApplicationId= deathRegistration.getRti_ref_id();
	   	    	rtiApplication = rTIApplicationService.get(rtiApplicationId);
	   	       }
	   	       else{
	   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
	   	    	   if(listRTI!=null && !listRTI.isEmpty()){
	   	    		rtiApplicationId = listRTI.get(0).getRtiApplicationId();
	   	    		rtiApplication = listRTI.get(0);
	   	    	   }
	   	       }
		// hospital
		 String strSql1="select * from egovrti.hospital  ";
		  List<ArrayList> hospitallist = rTIApplicationService.getListBySQLQuery(strSql1, null);
		  List<Hospital> newhospitallist=new ArrayList<>();
		 for (int i = 0; i < hospitallist.size(); i++){
		 Hospital hospital= new Hospital();
		 hospital.setHospitalId( Long.parseLong(hospitallist.get(i).get(0).toString()));
		 hospital.setName(hospitallist.get(i).get(1).toString());
		 newhospitallist.add(hospital);
		 }
			 request.setAttribute("hospitallist",newhospitallist);
 
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


	// cremotorium
	 String strSql3="select crematorium_id,crematorium_name from egovrti.crematorium  ";
	  List<ArrayList> crematoriumlist = rTIApplicationService.getListBySQLQuery(strSql3, null);
	  List<Crematorium> newcrematoriumlist=new ArrayList<>();
	 for (int i = 0; i < crematoriumlist.size(); i++){
     Crematorium crematorium= new Crematorium();
	 crematorium.setCrematoriumId( Long.parseLong(crematoriumlist.get(i).get(0).toString()));
	 crematorium.setName(crematoriumlist.get(i).get(1).toString());
	 newcrematoriumlist.add(crematorium);
	 }
		 request.setAttribute("crematoriumlist",newcrematoriumlist);
		
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
		 
       
		session.setAttribute("message", "Death Registration Saved Successfully");
		
		CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"DeathRegistration",rtiApplication);
	      // setUploadDocsOnEditMode(request,getServletContext(),"BirthRegistration",birthRegistration.getBirthRegistrationId());
	session.setAttribute("message", "Death Registration Saved Successfully");
		
	CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"DeathRegistration",rtiApplication);
	 modelAndView=new ModelAndView("manageDeathRegistration","deathRegistration",deathRegistration); 
	return modelAndView;
	
}
   

   @RequestMapping("/rtiapplication/editDeathRegistrationCertificate.do")
   public ModelAndView  editDeathRegistrationCertificate(HttpServletRequest request, HttpServletResponse response) throws ServletException ,Exception 
   {
	   System.out.println("Hello  editDeath");
	   System.out.println("id@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+request.getParameter("rtiApplicationRefId"));
       HttpSession session = request.getSession();
       long rtiApplicationRefId=0;
         long rtiApplicationId=0;
       DeathCertificate deathCertificate=null;
       RTIApplication rtiApplication = null;
       SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
       if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId")!=null) {
			if(request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0) {
			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			deathCertificate = deathCertificateService.get(rtiApplicationRefId);
		}else if(session.getAttribute("rtirefId")!=null) {
			Object a = session.getAttribute("rtirefId");
			rtiApplicationRefId =  (long) a;
			deathCertificate = deathCertificateService.get(rtiApplicationRefId);
		}
   	    
		 if(deathCertificate.getRti_ref_id()>0){
	   	    	rtiApplicationId= deathCertificate.getRti_ref_id();
	   	    	rtiApplication = rTIApplicationService.get(rtiApplicationId);
	   	       }
	   	       else{
	   	    	   List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
	   	    	   if(listRTI!=null && !listRTI.isEmpty()){
	   	    		rtiApplicationId = listRTI.get(0).getRtiApplicationId();
	   	    		rtiApplication = listRTI.get(0);
	   	    	   }
	   	       }  
       }
    // hospital
//		 String strSql1="select * from egovrti.hospital  ";
//		  List<ArrayList> hospitallist = rTIApplicationService.getListBySQLQuery(strSql1, null);
//		  List<Hospital> newhospitallist=new ArrayList<>();
//		 for (int i = 0; i < hospitallist.size(); i++){
//		 Hospital hospital= new Hospital();
//		 hospital.setHospitalId( Long.parseLong(hospitallist.get(i).get(0).toString()));
//		 hospital.setName(hospitallist.get(i).get(1).toString());
//		 newhospitallist.add(hospital);
//		 }
//			 request.setAttribute("hospitallist",newhospitallist);

//zone
//String strSql2=" select zone_id,name from egovrti.zone  ";
//List<ArrayList> zonelist = rTIApplicationService.getListBySQLQuery(strSql2, null);
//List<Zone> newzonelist=new ArrayList<>();
//for (int i = 0; i < zonelist.size(); i++){
//Zone zone= new Zone();
//zone.setZoneId( Long.parseLong(zonelist.get(i).get(0).toString()));
//zone.setName(zonelist.get(i).get(1).toString());
//newzonelist.add(zone);
//}
//	 request.setAttribute("zonelist",newzonelist);


	// cremotorium
//	 String strSql3="select crematorium_id,crematorium_name from egovrti.crematorium  ";
//	  List<ArrayList> crematoriumlist = rTIApplicationService.getListBySQLQuery(strSql3, null);
//	  List<Crematorium> newcrematoriumlist=new ArrayList<>();
//	 for (int i = 0; i < crematoriumlist.size(); i++){
//   Crematorium crematorium= new Crematorium();
//	 crematorium.setCrematoriumId( Long.parseLong(crematoriumlist.get(i).get(0).toString()));
//	 crematorium.setName(crematoriumlist.get(i).get(1).toString());
//	 newcrematoriumlist.add(crematorium);
//	 }
//		 request.setAttribute("crematoriumlist",newcrematoriumlist);
       
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
			if(task!=null && sessionUser.getUserName().equals(task.getAssignee()))
			request.setAttribute("userAccess",1);
	
			request.setAttribute("workFlowTask", task);
			}else{
				
			request.setAttribute("workFlowCompleted", "1");
			}
		} 
      
		 CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"deathCertificate",rtiApplication);
     // setUploadDocsOnEditMode(request,"BirthRegistration",birthRegistration.getBirthRegistrationId());
		 if(deathCertificate.getPlaceOfDeath().equals("Hospital"))
			 deathCertificate.setPlaceOfDeath("2");
		 else if(deathCertificate.getPlaceOfDeath().equals("Home"))
			 deathCertificate.setPlaceOfDeath("1");
   	   ModelAndView modelAndView=new ModelAndView("manageDeathRegistration","deathCertificate",deathCertificate);    	
		
		
		
		return modelAndView;
	
   
   }else {
		return new ModelAndView("/login.do");
	}
	}
   
   

@Override
public void afterContainerSetup(Container arg0) {
	// TODO Auto-generated method stub
	
}

}


