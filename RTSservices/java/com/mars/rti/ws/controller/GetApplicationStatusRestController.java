package com.mars.rti.ws.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.GetApplicationRestDTO;

@Controller
public class GetApplicationStatusRestController {
	
	@Autowired
	private RTIApplicationService rtsApplicationService;

	@RequestMapping(method = RequestMethod.POST,value="/getApplicationStatus")
	public @ResponseBody GetApplicationRestDTO getApplication(@RequestBody GetApplicationRestDTO getApplicationRestDTO,HttpServletResponse response) {
		String workflowStatus=null;
		try {
		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		RTIApplication rtiApplication=new RTIApplication();
		String rtsappNo= getApplicationRestDTO.getRtsapplicationNo();
		//long serviceId=getApplicationRestDTO.getServiceId();
		if(rtsappNo!=null) {
			applicationSearch.setRtiApplicationNumber(rtsappNo);
		    rtiApplication = rtsApplicationService.findByServiceIdApplicationSearch(rtsappNo);
		    getApplicationRestDTO.setAmount(rtiApplication.getApplicationCost());
		    if (String.valueOf(rtiApplication.getWorkFlowStatus()).equals("0")) {
		    	workflowStatus="Under Process";
		    getApplicationRestDTO.setApplicationStatus(workflowStatus);
		    }else if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("3")) {
		    	workflowStatus="Payment Pending";
			    getApplicationRestDTO.setApplicationStatus(workflowStatus);
		    }else if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("2")) {
		    	workflowStatus="Payment Completed";
			    getApplicationRestDTO.setApplicationStatus(workflowStatus);
		    }else if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("1")) {
                   workflowStatus="Completed and Certificate Issued";
   			    getApplicationRestDTO.setApplicationStatus(workflowStatus);
		    }else if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("5")) {
		    	workflowStatus="Rejected";
   			    getApplicationRestDTO.setApplicationStatus(workflowStatus);
		    }
		    getApplicationRestDTO.setWorkflowStatus(rtiApplication.getWorkFlowStatus());
		    String paymentLink="https://nmcnagpur.gov.in/RTSservices/ws/pay.do?rtsNo="+rtsappNo;
		    if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("1")) {
			    getApplicationRestDTO.setCertificate(rtiApplication.getPdfFilesSavedPath());
		    }else {
			    
			    getApplicationRestDTO.setCertificate("Pending");
		    }
		    if(String.valueOf(rtiApplication.getWorkFlowStatus()).equals("3")) {
		    	 getApplicationRestDTO.setPaymentLink(paymentLink);
		    }else {
		    	getApplicationRestDTO.setPaymentLink(paymentLink);
		    }
		    getApplicationRestDTO.setResponseCode(200);
		    getApplicationRestDTO.setStatus("ok");

		}
		else {
			getApplicationRestDTO.setResponseCode(500);
		    getApplicationRestDTO.setCertificate("Pending");
		    getApplicationRestDTO.setStatus("Internal Server Error");

		}
		}catch(Exception ex) {
			ex.printStackTrace();
			getApplicationRestDTO.setResponseCode(405);
		    getApplicationRestDTO.setCertificate("Pending");
			getApplicationRestDTO.setStatus("Method Not Allowed");
		    getApplicationRestDTO.setApplicationStatus("Record Not Found");
		}
		
		return getApplicationRestDTO;
		
		
	}
}
