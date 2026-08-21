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

import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.ws.model.RemondationofnocRestDTO;

@Controller
class RemondationofnocController {
	
	@Autowired
	private FireRecommendationService fireRecommendationService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getFireRecommendation/{serviceId}")
	public @ResponseBody RemondationofnocRestDTO getFireRecommendation(@PathVariable long serviceId,HttpServletResponse reponse) throws ServletException{
	
		RemondationofnocRestDTO remondationofnocRestDTO = new RemondationofnocRestDTO();
		List<RTIApplication> fireRecommendation = new ArrayList<>();
		List<RTIApplication> fireRecommendation2 = new ArrayList<>();
		fireRecommendation = fireRecommendationService.getnoc(serviceId);
		//feesmaster = feesMasterService.getFees(noofcopies);
		boolean checkservId=false;
		
		try {
			if(fireRecommendation !=null)
			{
				for(RTIApplication rs :fireRecommendation) {

					RTIApplication rs1 = new RTIApplication();
					rs1.setRtiApplnNumber(rs.getRtiApplnNumber());
					rs1.setCreatedDate(rs.getCreatedDate());
					rs1.setApplicantName(rs.getApplicantName());
					rs1.setWorkFlowStatus(rs.getWorkFlowStatus());
					rs1.setRtiApplicationRefId(rs.getRtiApplicationRefId());
					fireRecommendation2.add(rs1);
				}
				remondationofnocRestDTO.setFireRecommendation(fireRecommendation2);
			}
			
			else 
			{
				remondationofnocRestDTO.setResponse("Bad Request");
				remondationofnocRestDTO.setResponseStatus("Enter Correct Service Id");
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				remondationofnocRestDTO.setResponse("Bad Request");
				remondationofnocRestDTO.setResponseStatus(ex.getMessage());
				remondationofnocRestDTO.setResponseStatus(405);
				remondationofnocRestDTO.setStatus("Method not Allowed");
				
			}
			
			return remondationofnocRestDTO;
		
		}
	
	
	@RequestMapping(method = RequestMethod.GET, value ="/getFireRecommendationDetails/{serviceId}")
	public @ResponseBody RemondationofnocRestDTO getFireRecommendationDetails(@PathVariable long serviceId,HttpServletResponse reponse) throws ServletException{
	
		RemondationofnocRestDTO remondationofnocRestDTO = new RemondationofnocRestDTO();
	       FireRecommendation fr = new FireRecommendation();
	       List<FireDetails> frd = new ArrayList<>();
		//fr = fireRecommendationService.getnocDetails(serviceId);
		frd=fireRecommendationService.getFireDetails(serviceId);
		
		try {
			if(fr !=null)
			{
				
				//remondationofnocRestDTO.setFireDetails(fr);
				remondationofnocRestDTO.setFire(frd);
				
			}
			
			else 
			{
				remondationofnocRestDTO.setResponse("Bad Request");
				remondationofnocRestDTO.setResponseStatus("Enter Correct Service Id");
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				remondationofnocRestDTO.setResponse("Bad Request");
				remondationofnocRestDTO.setResponseStatus(ex.getMessage());
				remondationofnocRestDTO.setResponseStatus(405);
				remondationofnocRestDTO.setStatus("Method not Allowed");
				
			}
			
			return remondationofnocRestDTO;
		
		}
	
}
		
