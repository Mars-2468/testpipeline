package com.mars.rti.ws.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.CitizenMyApplicationService;
import com.mars.rti.ws.model.CitizenMyApplicationRest2DTO;
import com.mars.rti.ws.model.CitizenMyApplicationRestDTO;

@Controller
public class CitizenMyApplicationRestController {

    @Autowired
    private CitizenMyApplicationService citizenMyApplicationService;

    @RequestMapping(method = RequestMethod.GET, value = "/getCitizenMyApplicationList/{mobileNo}")
    public @ResponseBody CitizenMyApplicationRestDTO getCitizenMyApplicationList(@PathVariable long mobileNo,  HttpServletResponse response) throws ServletException{
       
    	CitizenMyApplicationRestDTO citizenMyApplicationRestDTO = new CitizenMyApplicationRestDTO();
    	List<RTIApplication> myApplicationLit = new ArrayList<RTIApplication>();
    	
    	List<CitizenMyApplicationRest2DTO> myApplicationLit1 = new ArrayList<CitizenMyApplicationRest2DTO>();
    	myApplicationLit = citizenMyApplicationService.getListOfCitizen(mobileNo);
    	
    	String workflowStatus=null;
    	try{
    	for(RTIApplication r : myApplicationLit) {
    		
    		CitizenMyApplicationRest2DTO rts = new CitizenMyApplicationRest2DTO();
    		rts.setRtiApplicationNo(r.getRtiApplnNumber());
    		rts.setSubject(r.getSubject());
    		rts.setDate(r.getRegistrationDate());
    		if (String.valueOf(r.getWorkFlowStatus()).equals("0")) {
		    	workflowStatus="Citizen Form Submitted";
		    	rts.setStatus(workflowStatus);
		    }else if(String.valueOf(r.getWorkFlowStatus()).equals("3")) {
		    	workflowStatus="Citizen Payment Pending";
		    	rts.setStatus(workflowStatus);
		    }else if(String.valueOf(r.getWorkFlowStatus()).equals("2")) {
		    	workflowStatus="Citizen Payment Completed";
		    	rts.setStatus(workflowStatus);
		    }else if(String.valueOf(r.getWorkFlowStatus()).equals("1")) {
                   workflowStatus="Completed and File Uploaded for Citizen";
                   rts.setStatus(workflowStatus);
		    }else if(String.valueOf(r.getWorkFlowStatus()).equals("5")) {
		    	workflowStatus="Rejected";
		    	rts.setStatus(workflowStatus);
		    }
    		if(String.valueOf(r.getWorkFlowStatus()).equals("1")) {
			    rts.setCertificate(r.getPdfFilesSavedPath());
		    }else {
			    rts.setCertificate("Pending");
		    }
    		
    		myApplicationLit1.add(rts);
    		
    		
    	}

    	citizenMyApplicationRestDTO.setResponseCode(200);
    	citizenMyApplicationRestDTO.setStatus("Ok");
    	citizenMyApplicationRestDTO.setResponse("Record Found");
    	citizenMyApplicationRestDTO.setCitizenList(myApplicationLit1);
    	
    	}catch(Exception ex) {
    				ex.printStackTrace();
    				citizenMyApplicationRestDTO.setResponseCode(405);
    				citizenMyApplicationRestDTO.setResponse("Bad Request");
    				citizenMyApplicationRestDTO.setApplicationStatus("Record Not Found");
    			}
    	
    	
    	
        return citizenMyApplicationRestDTO;
    }
}


