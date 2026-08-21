package com.mars.rti.service.impl;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.model.WardMaster;
import com.mars.common.model.ZoneMaster;
import com.mars.common.service.AreaService;
import com.mars.common.service.UserService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.WorkflowTemplate;
import com.mars.workflow.model.WorkflowTemplateTask;
import com.mars.workflow.model.WorkflowTemplateUserMapping;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.service.WorkflowTemplateService;
import com.mars.workflow.service.WorkflowTemplateUserMappingService;
import com.mars.workflow.service.WorkflowUsersService;
import com.mars.workflow.utils.WorkflowConstants;
 /**

 * <p>Title: WorkflowUsersServiceImpl.java </p>

 * <p>Description: This class is used for hibernate operations for Grievance module</p>

 * Copyright (c) 2008 for Mars Telecom India Pvt Ltd

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>

 */
@Service("workflowUsersService") 
public class WorkflowUsersServiceImpl implements WorkflowUsersService {

    private static final Log log = LogFactory.getLog(WorkflowUsersServiceImpl.class);

    @Autowired
	private UserService userService;
	
    @Autowired
	private AreaService areaService;

    @Autowired
	private WorkflowTemplateService workflowTemplateService;
	
    @Autowired
	private WorkflowTemplateUserMappingService workflowTemplateUserMappingService;
	
    @Autowired
    RTIApplicationService  rTIApplicationService;
   
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @return the areaService
	 */
	public AreaService getAreaService() {
		return areaService;
	}

	/**
	 * @param areaService the areaService to set
	 */
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	/**
	 * @return the workflowTemplateService
	 */
	public WorkflowTemplateService getWorkflowTemplateService() {
		return workflowTemplateService;
	}

	/**
	 * @param workflowTemplateService the workflowTemplateService to set
	 */
	public void setWorkflowTemplateService(
			WorkflowTemplateService workflowTemplateService) {
		this.workflowTemplateService = workflowTemplateService;
	}

	
	/**
	 * @return the workflowTemplateUserMappingService
	 */
	public WorkflowTemplateUserMappingService getWorkflowTemplateUserMappingService() {
		return workflowTemplateUserMappingService;
	}

	/**
	 * @param workflowTemplateUserMappingService the workflowTemplateUserMappingService to set
	 */
	public void setWorkflowTemplateUserMappingService(
			WorkflowTemplateUserMappingService workflowTemplateUserMappingService) {
		this.workflowTemplateUserMappingService = workflowTemplateUserMappingService;
	}	


	/**
	 * This method will return a list of all ComplaintClass from the database
	 *
	 * @return List of ComplaintClass
	 */
	public HashMap<String, Object> getWorkflowUsers(HashMap<String, Object> hstMap) 
	{
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowUsers Method is called");
		}

		//hstMap.put("Dept_Clerk_user", "admin");
	//	hstMap.put("Zonal_Officer_user", "user1");
	//	hstMap.put("Deputy_Commissioner", "user2");
		//hstMap.put("Medical_Officer", "user3");
		
		String entityName = hstMap.get(WorkflowConstants.WORKFLOW_ENTITYNAME).toString();
		long entityId = Long.parseLong(hstMap.get(WorkflowConstants.WORKFLOW_ENTITYID).toString());
		//long areaId = -1;
		WardMaster wardMasterObj = null;
		ZoneMaster zoneMasterObj = null;
		

		List<WorkflowTemplate> workflowTemplateList = workflowTemplateService.findByProperty("workflowTemplateName", entityName);
		WorkflowTemplate workflowTemplate = new WorkflowTemplate();
		Set<WorkflowTemplateTask> workflowTemplateTaskSet = new LinkedHashSet<WorkflowTemplateTask>();
		if (workflowTemplateList != null && workflowTemplateList.size() > 0) {
			workflowTemplate = workflowTemplateList.get(0);
		}
		workflowTemplateTaskSet = workflowTemplate.getWorkflowTemplateTaskSet();

		if(workflowTemplateTaskSet != null && workflowTemplateTaskSet.size() > 0)
		{
			//if(entityName.equalsIgnoreCase("fileCreationWorkflow"))
			//{
				RTIApplication rTIApplication = rTIApplicationService.get(entityId);
				String a =rTIApplication.getZone();//subdepartment
				Long areaId = Long.parseLong(a);
				hstMap.put(WorkflowConstants.WORKFLOW_ENTITY_DETAILS, ""+rTIApplication.getRtiApplnNumber());

			//}	
		 
			
			/*if(wardMasterObj != null && areaService.getAreaForWard(wardMasterObj.getWardId()) != null)
				areaId = areaService.getAreaForWard(wardMasterObj.getWardId()).getAreaId();
			else if(zoneMasterObj != null && areaService.getAreaForZone(zoneMasterObj.getZoneId()) != null)
				areaId = areaService.getAreaForZone(zoneMasterObj.getZoneId()).getAreaId();*/
			
			Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet = null;
			WorkflowTemplateUserMapping workflowTemplateUserMapping = workflowTemplateUserMappingService.getByEntityAndArea(workflowTemplate.getWorkflowTemplateId(), areaId);
			if(workflowTemplateUserMapping != null)
			{
				workflowTemplateUserMappingDetailsSet =  workflowTemplateUserMapping.getWorkflowTemplateUserMappingDetailsSet();
				
				if (workflowTemplateUserMappingDetailsSet != null && workflowTemplateUserMappingDetailsSet.size() > 0) {
					for (WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails : workflowTemplateUserMappingDetailsSet) {
						String userName = "";
						/*
						User user = userService.getUserByEmployeeId(workflowTemplateUserMappingDetails.getEmployee().getEmployeeId());
						if(user == null)
							user = userService.getUserByEmployeeId(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getDefaultEmployee().getEmployeeId());
						
						if(user != null)
							userName = user.getUserName();
						
						hstMap.put(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getAssigneePlaceHolder(), userName);
						*/
						hstMap.put(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getAssigneePlaceHolder(), workflowTemplateUserMappingDetails.getUserName());
					}
				}
			} 
			
			if (workflowTemplateUserMappingDetailsSet == null || workflowTemplateUserMappingDetailsSet.size() == 0) 
			{
				for (WorkflowTemplateTask workflowTemplateTask : workflowTemplateTaskSet) {
					//hstMap.put(workflowTemplateTask.getAssigneePlaceHolder(), userService.getUserByEmployeeId(workflowTemplateTask.getDefaultEmployee().getEmployeeId()).getUserName());
					hstMap.put(workflowTemplateTask.getAssigneePlaceHolder(), workflowTemplateTask.getDefaultUserName());
				}
			}
		}
		
		return hstMap;
		
	} //end of getWorkflowUsers() method

	/**
	 * This method will return a list of all WorkFLowUsers for WebServices
	 *
	 * @return List of ComplaintClass
	 */
	
	public HashMap<String, Object> getWorkflowUsersforWS(HashMap<String, Object> hstMap) 
	{
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowUsersforWS Method is called");
		}

		//hstMap.put("Dept_Clerk_user", "admin");
	//	hstMap.put("Zonal_Officer_user", "user1");
	//	hstMap.put("Deputy_Commissioner", "user2");
		//hstMap.put("Medical_Officer", "user3");
		
		String entityName = hstMap.get(WorkflowConstants.WORKFLOW_ENTITYNAME).toString();
		long entityId = Long.parseLong(hstMap.get(WorkflowConstants.WORKFLOW_ENTITYID).toString());
		long areaId = -1;
		WardMaster wardMasterObj = null;
		ZoneMaster zoneMasterObj = null;
		

		List<WorkflowTemplate> workflowTemplateList = workflowTemplateService.findByProperty("workflowTemplateName", entityName,Long.valueOf((hstMap.get("tenancyId").toString())));
		WorkflowTemplate workflowTemplate = new WorkflowTemplate();
		Set<WorkflowTemplateTask> workflowTemplateTaskSet = new LinkedHashSet<WorkflowTemplateTask>();
		if (workflowTemplateList != null && workflowTemplateList.size() > 0) {
			workflowTemplate = workflowTemplateList.get(0);
		}
		workflowTemplateTaskSet = workflowTemplate.getWorkflowTemplateTaskSet();

		if(workflowTemplateTaskSet != null && workflowTemplateTaskSet.size() > 0)
		{
			if(entityName.equalsIgnoreCase("fileCreationWorkflow"))
			{
				RTIApplication rTIApplication = rTIApplicationService.get(entityId);				
				hstMap.put(WorkflowConstants.WORKFLOW_ENTITY_DETAILS, ""+rTIApplication.getRtiApplnNumber());

			}	
			
			/*if(wardMasterObj != null && areaService.getAreaForWard(wardMasterObj.getWardId()) != null)
				areaId = areaService.getAreaForWard(wardMasterObj.getWardId()).getAreaId();
			else if(zoneMasterObj != null && areaService.getAreaForZone(zoneMasterObj.getZoneId()) != null)
				areaId = areaService.getAreaForZone(zoneMasterObj.getZoneId()).getAreaId();*/
			
			Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet = null;
			WorkflowTemplateUserMapping workflowTemplateUserMapping = workflowTemplateUserMappingService.getByEntityAndArea(workflowTemplate.getWorkflowTemplateId(), areaId);
			if(workflowTemplateUserMapping != null)
			{
				workflowTemplateUserMappingDetailsSet =  workflowTemplateUserMapping.getWorkflowTemplateUserMappingDetailsSet();
				
				if (workflowTemplateUserMappingDetailsSet != null && workflowTemplateUserMappingDetailsSet.size() > 0) {
					for (WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails : workflowTemplateUserMappingDetailsSet) {
						String userName = "";
						/*
						User user = userService.getUserByEmployeeId(workflowTemplateUserMappingDetails.getEmployee().getEmployeeId());
						if(user == null)
							user = userService.getUserByEmployeeId(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getDefaultEmployee().getEmployeeId());
						
						if(user != null)           
							userName = user.getUserName();
						
						hstMap.put(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getAssigneePlaceHolder(), userName);
						*/
						hstMap.put(workflowTemplateUserMappingDetails.getWorkflowTemplateTask().getAssigneePlaceHolder(), workflowTemplateUserMappingDetails.getUserName());
					}
				}
			} 
			
			if (workflowTemplateUserMappingDetailsSet == null || workflowTemplateUserMappingDetailsSet.size() == 0) 
			{
				for (WorkflowTemplateTask workflowTemplateTask : workflowTemplateTaskSet) {
					//hstMap.put(workflowTemplateTask.getAssigneePlaceHolder(), userService.getUserByEmployeeId(workflowTemplateTask.getDefaultEmployee().getEmployeeId()).getUserName());
					hstMap.put(workflowTemplateTask.getAssigneePlaceHolder(), workflowTemplateTask.getDefaultUserName());
				}
			}
		}
		
		return hstMap;
		
	} //end of getWorkflowUsers() method

}

