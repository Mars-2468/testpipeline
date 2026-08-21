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
import com.mars.rti.service.FireComplianceCertificateService;
import com.mars.rti.ws.model.FirecompliancenocrestDTO;

@Controller
public class Firecompliancenocrestcontroller {
	
	@Autowired
	private FireComplianceCertificateService fireComplianceCertificateService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getFirecompliance/{serviceId}")
	public @ResponseBody FirecompliancenocrestDTO getFirecompliance(@PathVariable long serviceId,HttpServletResponse reponse) throws ServletException{
		
		
		FirecompliancenocrestDTO firecompliancenocrestDTO = new FirecompliancenocrestDTO();
		List<RTIApplication> fireCompliance = new ArrayList<>();
		List<RTIApplication> fireCompliance2 = new ArrayList<>();
		fireCompliance = fireComplianceCertificateService.getnoc(serviceId);
		boolean checkservId=false;
		
		
		try {
			if(fireCompliance !=null)
			{
				for(RTIApplication rs :fireCompliance) {

					RTIApplication rs1 = new RTIApplication();
					rs1.setRtiApplnNumber(rs.getRtiApplnNumber());
					rs1.setCreatedDate(rs.getCreatedDate());
					rs1.setApplicantName(rs.getApplicantName());
					rs1.setWorkFlowStatus(rs.getWorkFlowStatus());
					rs1.setRtiApplicationRefId(rs.getRtiApplicationRefId());
					fireCompliance2.add(rs1);
				}
				firecompliancenocrestDTO.setFireCompliance(fireCompliance2);
			}
			
			else 
			{
				FirecompliancenocrestDTO.setResponse("Bad Request");
				FirecompliancenocrestDTO.setResponseStatus("Enter Correct Service Id");
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				FirecompliancenocrestDTO.setResponse("Bad Request");
				FirecompliancenocrestDTO.setResponseStatus(ex.getMessage());
				FirecompliancenocrestDTO.setResponseStatus(405);
				FirecompliancenocrestDTO.setStatus("Method not Allowed");
				
			}
			
			return firecompliancenocrestDTO;
		
		}
		
	}


	


