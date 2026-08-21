package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.utils.CommonUtils;
import com.mars.rti.model.BirthRegistration;
import com.mars.rti.model.DeathRegistration;
import com.mars.rti.model.DogLicense;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.BirthRegistrationService;
import com.mars.rti.service.DeathRegistrationService;
import com.mars.rti.service.DogLicenseService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.BirthRegistrationRestDTO;
import com.mars.rti.ws.model.DeathRegistrationRestDTO;
import com.mars.rti.ws.model.DogLicenseRestDTO;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.service.WorkflowUsersService;
import com.mars.workflow.utils.WorkflowConstants;



@Controller
public class BirthRestController {
private static Log log = LogFactory.getLog(BirthRestController.class);	

@Autowired
private RTIApplicationService rtiApplicationService;

@Autowired
private BirthRegistrationService birthRegistrationService;

@Autowired
private DeathRegistrationService deathRegistrationService;

@Autowired
private DogLicenseService dogLicenseService;

@Autowired
private WorkflowUsersService workflowUsersService;

@Autowired
private WorkflowService workflowService;


public void setWorkflowUsersService(WorkflowUsersService workflowUsersService) {
	this.workflowUsersService = workflowUsersService;
}



public void setWorkflowService(WorkflowService workflowService) {
	this.workflowService = workflowService;
}



public void setDeathRegistrationService(
		DeathRegistrationService deathRegistrationService) {
	this.deathRegistrationService =deathRegistrationService;
}


	
public BirthRegistrationService getBirthRegistrationService() {
	return birthRegistrationService;
}

public void setBirthRegistrationService(
		BirthRegistrationService birthRegistrationService) {
	this.birthRegistrationService = birthRegistrationService;
}

public RTIApplicationService getRtiApplicationService() {
	return rtiApplicationService;
}

public void setRtiApplicationService(RTIApplicationService rtiApplicationService) {
	this.rtiApplicationService = rtiApplicationService;
}


@RequestMapping(method = RequestMethod.POST, value = "birthRegistration/saveRegistrationApplication")
 //@RequestMapping(method = RequestMethod.GET, value = "birthRegistration1/getRegistrationApplication1/{regid}")
public ModelAndView saveBirthRegistartionApplication(@RequestBody BirthRegistrationRestDTO birthRegistrationRestDTO, HttpServletResponse response) throws ServletException {
//public ModelAndView getBirthRegistartionApplication1(@PathVariable String regid, HttpServletResponse response) throws ServletException {	
if (log.isDebugEnabled()) {
		log.debug("Invoking saveFireNocApplication");
	}
	BirthRegistration birthRegistration = new BirthRegistration();
	//BirthRegistrationRestDTO birthRegistrationRestDTO=new BirthRegistrationRestDTO();
	
    System.out.println("save start :");
	try{
		
		
		
		/*birthRegistrationRestDTO.setAddress("Hyd");
		birthRegistrationRestDTO.setBirthplace("1");
		birthRegistrationRestDTO.setChildename("sagar");
		birthRegistrationRestDTO.setDob("01/02/2022");
		birthRegistrationRestDTO.setEmail("ss@gmail.com");
		birthRegistrationRestDTO.setFathername("sasi");		
		birthRegistrationRestDTO.setGender("1");		
		birthRegistrationRestDTO.setGrandfathername("kiran");		
		birthRegistrationRestDTO.setHospitalname("hyd hsptl");
		birthRegistrationRestDTO.setMothername("dddd");
		birthRegistrationRestDTO.setName("krishna");
		birthRegistrationRestDTO.setPermanentaddress("HHHHH");
		birthRegistrationRestDTO.setPh_no("23455");
		birthRegistrationRestDTO.setPlaceofbirth(1);
		*/
		 birthRegistration.setAddress(birthRegistrationRestDTO.getAddress());
		birthRegistration.setBirthplace(birthRegistrationRestDTO.getBirthplace());
		birthRegistration.setChildename(birthRegistrationRestDTO.getChildename());
		birthRegistration.setDob(birthRegistrationRestDTO.getDob());
		birthRegistration.setEmail(birthRegistrationRestDTO.getEmail());
		birthRegistration.setFathername(birthRegistrationRestDTO.getFathername());
		birthRegistration.setGender(birthRegistrationRestDTO.getGender());
		birthRegistration.setGrandfathername(birthRegistrationRestDTO.getFathername());
		birthRegistration.setHospitalname(birthRegistrationRestDTO.getHospitalname());
		birthRegistration.setMothername(birthRegistrationRestDTO.getMothername());
		
		//birthRegistration.setMotherresidencetype(birthRegistrationRestDTO.getMotherresidencetype());
		birthRegistration.setName(birthRegistrationRestDTO.getName());
		//birthRegistration.setNooffreecopyissued(birthRegistrationRestDTO.getNooffreecopyissued());
		//birthRegistration.setOldregistrationno(birthRegistrationRestDTO.getOldregistrationno());
		birthRegistration.setPermanentaddress(birthRegistrationRestDTO.getPermanentaddress());
		birthRegistration.setPh_no(birthRegistrationRestDTO.getPh_no());
		birthRegistration.setPlaceofbirth(birthRegistrationRestDTO.getPlaceofbirth());
		//birthRegistration.setRegistrationid(birthRegistrationRestDTO.getRegistrationid());
		
		birthRegistration.setStatus(1);
		
		RTIApplication rtiApplication=new RTIApplication();
		
		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setSubject("BIRTH-REGISTRATION");
		rtiApplication.setWorkFlowStatus(0);						
		rtiApplication.setFinalStatus("0");	 
		rtiApplication.setRtiserviceid(1);
		
		//rtiApplication.setTenancy("1");
		//rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");
		
		rtiApplication.setApplicantName(birthRegistrationRestDTO.getName());			
		List<RTIApplicationDetails> rtiApplicationDetailsList  = new ArrayList<RTIApplicationDetails>(); 
		RTIApplicationDetails rtiApplicationDetails=new RTIApplicationDetails();
				
		
		rtiApplicationDetails.setRtiApplication(rtiApplication);
		rtiApplicationDetails.setStatus(0);	
		rtiApplicationDetails.setAssignToStatus(1);	
		rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
		rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
		
		rtiApplicationDetails.setComments("Form Submitted");//();
		rtiApplicationDetails.setWorkflowLevel(0);			
		rtiApplicationDetailsList.add(rtiApplicationDetails);		
		rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
		RTIApplication savedRti=rtiApplicationService.merge(rtiApplication);
		
		
		//birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);
		
		//if(birthRegistrationService.birthRegistrationCertificate(birthRegistration){
		
		if(savedRti.getRtiApplicationId()>0){
			RTIApplication rti=rtiApplicationService.get(savedRti.getRtiApplicationId());
			rti.setRtiApplnNumber("RTS/HD/2022/"+savedRti.getRtiApplicationId());
			birthRegistration.setRtiapplrefno(rti.getRtiApplnNumber());
			birthRegistration.setRti_ref_id(savedRti.getRtiApplicationId());
			long birth_regis_id=birthRegistrationService.birthRegistrationSave(birthRegistration);
			rti.setRtiApplicationRefId(birth_regis_id);
			//rti.setRtiApplicationRefId(birthRegistrationService.);
			RTIApplication retunRti=rtiApplicationService.merge(rti);
		
			
			if((retunRti!=null) && (birth_regis_id>0)){
				birthRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
				birthRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
				birthRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());
			}
		}		
	 //}
	    //birth service save method
		
		  System.out.println("save end :");
      } catch (Exception ex) {
		
		ex.printStackTrace();
		log.equals(ex.getMessage());
		birthRegistrationRestDTO.setResponseStatus("Requested data not saved successfully");
	}finally {
		
		/*if(BirthRegistrationRestDTO.getFireNocRegistrationId() > 0 && fireNocRegistrationRestDTO.getResponseCode()==0){
			BirthRegistrationRestDTO.delete(fireNocRegistrationRestDTO.getFireNocRegistrationId());
		}*/
	}
	
	ModelAndView mav = new ModelAndView("marsRestView");
	mav.addObject("birthRegistrationRestDTO", birthRegistrationRestDTO);
	return mav;
}

public void setWorkFlowActive(long entityId,String processName,String entityName,String userName){

	String workflowProcessName = processName;
	//HashMap<String, Object> workflowMap = getWorkflowUsers(entity);
	HashMap<String, Object> workflowMap = new HashMap<String, Object>();
	workflowMap.put(WorkflowConstants.WORKFLOW_ENTITYNAME, entityName);
	workflowMap.put(WorkflowConstants.WORKFLOW_ENTITYID, entityId);
	workflowMap.put(WorkflowConstants.WORKFLOW_USER_NAME, userName);
	workflowUsersService.getWorkflowUsers(workflowMap);

	workflowService.createWorkflow(workflowProcessName, workflowMap);
}

@RequestMapping(method = RequestMethod.POST, value = "birthRegistration/getRegistrationApplication")
public ModelAndView getBirthRegistartionApplication(@RequestBody BirthRegistrationRestDTO requestRestDTO, HttpServletResponse response) throws ServletException {
	if (log.isDebugEnabled()) {
		log.debug("Invoking saveFireNocApplication");
	}
	BirthRegistration birthRegistration = new BirthRegistration();
	BirthRegistrationRestDTO birthRegistrationRestDTO=new BirthRegistrationRestDTO();
	
	RTIApplicationSearch applicationSearch=new RTIApplicationSearch();
   	    
    applicationSearch.setRtiApplicationNumber(requestRestDTO.getRtiapplrefno());
    applicationSearch.setRtiserviceid(1);
    
    System.out.println("refn id:"+requestRestDTO.getRtiapplrefno());
    List<RTIApplication> rtiApplicationList = rtiApplicationService.getRTIApplicationList(applicationSearch);   
   
    System.out.println("get start :");
	try{
		
		if(rtiApplicationList!=null){
			
	    	birthRegistration=birthRegistrationService.get(rtiApplicationList.get(0).getRtiApplicationRefId());
	    	 birthRegistrationRestDTO.setName(birthRegistration.getName());
	    	 //birthRegistrationRestDTO.setPdfsavedpath(birthRegistration.getPdf_files_saved_path());
	    	 
	    	 birthRegistrationRestDTO.setWardName("E-5");
	    	 birthRegistrationRestDTO.setWardOffcierName("AMCADMIN");
	    	 birthRegistrationRestDTO.setPh_no(birthRegistration.getPh_no());
	    	 birthRegistrationRestDTO.setWorkFlowStatus(rtiApplicationList.get(0).getWorkFlowStatus());
	    	 birthRegistrationRestDTO.setRtiapplrefno(rtiApplicationList.get(0).getRtiApplnNumber());   	   
		}
	    
      } catch (Exception ex) {
		
		ex.printStackTrace();
		birthRegistrationRestDTO.setResponseStatus("Requested RTS Ref_no not found");
		log.equals(ex.getMessage());
	}finally {
		/*if(BirthRegistrationRestDTO.getFireNocRegistrationId() > 0 && fireNocRegistrationRestDTO.getResponseCode()==0){
			BirthRegistrationRestDTO.delete(fireNocRegistrationRestDTO.getFireNocRegistrationId());
		}*/
	}
	
	ModelAndView mav = new ModelAndView("marsRestView");
	mav.addObject("birthRegistrationRestDTO", birthRegistrationRestDTO);
	  System.out.println("get end :");
	return mav;
}


@RequestMapping(method = RequestMethod.POST, value = "deathRegistration/saveRegistrationApplication")
//@RequestMapping(method = RequestMethod.GET, value = "birthRegistration1/getRegistrationApplication1/{regid}")
public ModelAndView saveDeathRegistartionApplication(@RequestBody DeathRegistrationRestDTO deathRegistrationRestDTO, HttpServletResponse response) throws ServletException {
//public ModelAndView getBirthRegistartionApplication1(@PathVariable String regid, HttpServletResponse response) throws ServletException {	
if (log.isDebugEnabled()) {
		log.debug("Invoking deathApplication");
	}
	DeathRegistration deathRegistration = new DeathRegistration();
	
   System.out.println("save start :");
	try{
				
			 deathRegistration.setDeathRegistrationId(deathRegistrationRestDTO.getDeathRegistrationId());	
				    
		    deathRegistration.setApplicantName(deathRegistrationRestDTO.getApplicantName()); 			
		   
		    deathRegistration.setApplicantAddress(deathRegistrationRestDTO.getApplicantAddress()); 		
		
		    deathRegistration.setMobileNo(deathRegistrationRestDTO.getMobileNo()); 
		
		    deathRegistration.setEmailId(deathRegistrationRestDTO.getEmailId()); 	
		   
		    deathRegistration.setDateOfBirth(deathRegistrationRestDTO.getDateOfBirth()); 
		
		    deathRegistration.setDateOfDeath(deathRegistrationRestDTO.getDateOfDeath()); 
		
		    deathRegistration.setPlaceOfDeath(deathRegistrationRestDTO.getPlaceOfDeath()); 
			
			deathRegistration.setGender(deathRegistrationRestDTO.getGender()); 
				
		    deathRegistration.setAgeAtDeathTime(deathRegistrationRestDTO.getAgeAtDeathTime()); 
		
		    deathRegistration.setNameOfDeceased(deathRegistrationRestDTO.getNameOfDeceased()); 
		
		    deathRegistration.setFatherName(deathRegistrationRestDTO.getFatherName()); 
		
		    deathRegistration.setAddressOfDeceased(deathRegistrationRestDTO.getAddressOfDeceased()); 
		
		    deathRegistration.setReasonOfDeath(deathRegistrationRestDTO.getReasonOfDeath()); 
		
		    deathRegistration.setNameofCrematorium(deathRegistrationRestDTO.getNameOfCrematorium()); 
			
		    deathRegistration.setOldRegistrationNumber(deathRegistrationRestDTO.getOldRegistrationNumber()); 
		
		
		    //DeathRegistration deathRegis=deathRegistrationService.deathRegistrationSave(deathRegistration);
		
		
		RTIApplication rtiApplication=new RTIApplication();
		
		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setSubject("DEATH-REGISTRATION");
		rtiApplication.setWorkFlowStatus(0);						
		rtiApplication.setFinalStatus("0");	 
		rtiApplication.setRtiserviceid(2);
		
		//rtiApplication.setTenancy("1");
		//rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");
		
		//rtiApplication.setApplicantName(birthRegistrationRestDTO);			
		List<RTIApplicationDetails> rtiApplicationDetailsList  = new ArrayList<RTIApplicationDetails>(); 
		RTIApplicationDetails rtiApplicationDetails=new RTIApplicationDetails();
				
		
		rtiApplicationDetails.setRtiApplication(rtiApplication);
		rtiApplicationDetails.setStatus(0);	
		rtiApplicationDetails.setAssignToStatus(1);	
		rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
		rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
		
		rtiApplicationDetails.setComments("Form Submitted");//();
		rtiApplicationDetails.setWorkflowLevel(0);			
		rtiApplicationDetailsList.add(rtiApplicationDetails);		
		rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
		RTIApplication savedRti=rtiApplicationService.merge(rtiApplication);
		
		if(savedRti.getRtiApplicationId()>0){
			RTIApplication rti=rtiApplicationService.get(savedRti.getRtiApplicationId());
			rti.setRtiApplnNumber("RTS/HD/2022/"+savedRti.getRtiApplicationId());
			
		    deathRegistration.setRtiapplrefno(rti.getRtiApplnNumber());
		    deathRegistration.setRti_ref_id(savedRti.getRtiApplicationId());
		    
		    DeathRegistration deathRegis=deathRegistrationService.deathRegistrationSave(deathRegistration);
			rti.setRtiApplicationRefId(deathRegis.getDeathRegistrationId());
			RTIApplication retunRti=rtiApplicationService.merge(rti);
		
			
			if((retunRti!=null) && (deathRegis.getDeathRegistrationId()>0)){
				
				deathRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
				deathRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
				deathRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());
			}
		}		
	 
	    //birth service save method
		
		  System.out.println("save end :");
     } catch (Exception ex) {
		
		ex.printStackTrace();
		log.equals(ex.getMessage());
		//birthRegistrationRestDTO.setResponseStatus("Requested data not saved successfully");
	}finally {
		
		/*if(BirthRegistrationRestDTO.getFireNocRegistrationId() > 0 && fireNocRegistrationRestDTO.getResponseCode()==0){
			BirthRegistrationRestDTO.delete(fireNocRegistrationRestDTO.getFireNocRegistrationId());
		}*/
	}
	
	ModelAndView mav = new ModelAndView("marsRestView");
	mav.addObject("deathRegistrationRestDTO", deathRegistrationRestDTO);
	return mav;
}

@RequestMapping(method = RequestMethod.POST, value = "dogRegistration/saveDogRegistartionApplication")
//@RequestMapping(method = RequestMethod.GET, value = "birthRegistration1/getRegistrationApplication1/{regid}")
public ModelAndView saveDogRegistartionApplication(@RequestBody DogLicenseRestDTO dogLicenseRestDTO, HttpServletResponse response) throws ServletException {
//public ModelAndView getBirthRegistartionApplication1(@PathVariable String regid, HttpServletResponse response) throws ServletException {	
if (log.isDebugEnabled()) {
		log.debug("Invoking deathApplication");
	}
DogLicense dogLicense = new DogLicense();
	
 System.out.println("save start :");
	try{
									
				
			    dogLicense.setAppName(dogLicenseRestDTO.getAreaName()); 
					
			
			    dogLicense.setAppAddress(dogLicense.getAppAddress()); 					
			
			    dogLicense.setBlockNo(dogLicense.getBlockNo()); 
				
			    dogLicense.setPhNo(dogLicense.getPhNo()); 			
		
			    dogLicense.setEmailId(dogLicense.getEmailId()); 			
		
			    dogLicense.setNameColony(dogLicense.getNameColony()); 			
			
			//    dogLicense.setWardNo(dogLicense.getWardNo()); 
					
			    dogLicense.setDetailsDog(dogLicense.getDetailsDog()); 
				
			//    dogLicense.setSex(dogLicense.getSex()); 			
		
			    dogLicense.setAge(dogLicense.getAge()); 
			
			    dogLicense.setVaccinationDetails(dogLicense.getVaccinationDetails()); 
					
			    dogLicense.setDate(dogLicense.getDate()); 			
		
			    //dogLicense.setRtiapplrefno(dogLicense); 			
			
			   //dogLicenseService.dogLicenseCertificate(dogLicense);

		
		    //DeathRegistration deathRegis=deathRegistrationService.deathRegistrationSave(deathRegistration);
		
		
		RTIApplication rtiApplication=new RTIApplication();
		
		rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
		rtiApplication.setSubject("DEATH-REGISTRATION");
		rtiApplication.setWorkFlowStatus(0);						
		rtiApplication.setFinalStatus("0");	 
		rtiApplication.setRtiserviceid(2);
		
		//rtiApplication.setTenancy("1");
		//rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");
		
		//rtiApplication.setApplicantName(birthRegistrationRestDTO);			
		List<RTIApplicationDetails> rtiApplicationDetailsList  = new ArrayList<RTIApplicationDetails>(); 
		RTIApplicationDetails rtiApplicationDetails=new RTIApplicationDetails();
				
		
		rtiApplicationDetails.setRtiApplication(rtiApplication);
		rtiApplicationDetails.setStatus(0);	
		rtiApplicationDetails.setAssignToStatus(1);	
		rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
		rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
		
		rtiApplicationDetails.setComments("Form Submitted");//();
		rtiApplicationDetails.setWorkflowLevel(0);			
		rtiApplicationDetailsList.add(rtiApplicationDetails);		
		rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
		RTIApplication savedRti=rtiApplicationService.merge(rtiApplication);
		
		if(savedRti.getRtiApplicationId()>0){
			RTIApplication rti=rtiApplicationService.get(savedRti.getRtiApplicationId());
			rti.setRtiApplnNumber("RTS/HD/2022/"+savedRti.getRtiApplicationId());
			
			dogLicense.setRtiapplrefno(rti.getRtiApplnNumber());
			dogLicense.setRti_ref_id(savedRti.getRtiApplicationId());
		    
			DogLicense getDogLicense=dogLicenseService.dogLicenseSave(dogLicense);
			
			rti.setRtiApplicationRefId(getDogLicense.getDogId());
			RTIApplication retunRti=rtiApplicationService.merge(rti);
		
			
			if((retunRti!=null) && (getDogLicense.getDogId()>0)){
				
				dogLicenseRestDTO.setResponseStatus("Requested data saved successfully");
				//dogLicenseRestDTO.setResponse(retunRti.getRtiApplicationId());
				dogLicenseRestDTO.setResult(retunRti.getRtiApplnNumber());
			}
		}		
	 
	    //birth service save method
		
		  System.out.println("save end :");
   } catch (Exception ex) {
		
		ex.printStackTrace();
		log.equals(ex.getMessage());
		//birthRegistrationRestDTO.setResponseStatus("Requested data not saved successfully");
	}finally {
		
		/*if(BirthRegistrationRestDTO.getFireNocRegistrationId() > 0 && fireNocRegistrationRestDTO.getResponseCode()==0){
			BirthRegistrationRestDTO.delete(fireNocRegistrationRestDTO.getFireNocRegistrationId());
		}*/
	}
	
	ModelAndView mav = new ModelAndView("marsRestView");
	mav.addObject("dogLicenseRestDTO", dogLicenseRestDTO);
	return mav;
}

}
