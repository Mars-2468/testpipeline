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
import com.mars.rti.ws.model.PaymentRestDTO;

@Controller
public class PaymentRestController {

	
	@Autowired
	private RTIApplicationService rtsApplicationService;
	
	@RequestMapping(method=RequestMethod.POST, value="/getPaymentDetails")
	public @ResponseBody PaymentRestDTO getPaymentDetails(@RequestBody PaymentRestDTO paymentRestDTO,HttpServletResponse response) {
		
		try {
			RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
			RTIApplication rtiApplication=new RTIApplication();
			String rtsappNo= paymentRestDTO.getApplicationNumber();
			if(rtsappNo!=null) {
				applicationSearch.setRtiApplicationNumber(rtsappNo);
				rtiApplication = rtsApplicationService.findByRTIApplicationNumber(rtsappNo);
				paymentRestDTO.setApplicationName(rtiApplication.getSubject());
				paymentRestDTO.setName(rtiApplication.getApplicantName());
				paymentRestDTO.setFees(rtiApplication.getApplicationCost());
				paymentRestDTO.setResponseCode(200);        
				paymentRestDTO.setStatus("ok");
			}else {
				paymentRestDTO.setResponseCode(500);
				paymentRestDTO.setStatus("Internal Server Error");
			}
		
		
	}catch(Exception ex) {
		ex.printStackTrace();
		paymentRestDTO.setResponseCode(405);
		paymentRestDTO.setStatus("Method Not Allowed");
	}
		return paymentRestDTO;
	}
}
