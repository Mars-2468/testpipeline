package com.mars.rti.ws.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.FeesMaster;
import com.mars.rti.service.FeesMasterService;
import com.mars.rti.ws.model.FeesMasterRestDTO;


@Controller
public class FeesMasterRestController 
{
	@Autowired
	private FeesMasterService feesMasterService ;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getFeesMaster/{serviceId}")
	public @ResponseBody FeesMasterRestDTO getFeesMaster(@PathVariable long serviceId,HttpServletResponse reponse) throws ServletException{

		FeesMasterRestDTO feesMasterRestDTO = new FeesMasterRestDTO();
		FeesMaster feesmaster = new FeesMaster();
		feesmaster = feesMasterService.getFees(serviceId);
		//feesmaster = feesMasterService.getFees(noofcopies);
		boolean checkservId=false;
		try {
		if(serviceId==1)
		{
			checkservId=true;
			feesMasterRestDTO.setSameday(feesmaster.getSameDay()+"");
			feesMasterRestDTO.setTillThirdDay(feesmaster.getTillThirdDay()+"");			
		}
		else if(serviceId==2) {
			checkservId=true;
			feesMasterRestDTO.setSameday(feesmaster.getSameDay()+"");			
			feesMasterRestDTO.setTillThirdDay(feesmaster.getTillThirdDay()+"");
		}
		else if(serviceId==3) {
			checkservId=true;
			feesMasterRestDTO.setIndianOperated(feesmaster.getIndianOperated()+"");			
			feesMasterRestDTO.setIndianNonOperated(feesmaster.getIndianNonOperated()+"");
			feesMasterRestDTO.setBreedOperated(feesmaster.getBreedOperated()+"");			
			feesMasterRestDTO.setBreedNonOperated(feesmaster.getBreedNonOperated()+"");
		}
		else if(serviceId==23) {
			checkservId=true;
			feesMasterRestDTO.setCircusExperimentalPerformancesOtherPurposes(feesmaster.getCircusExperimentalPerformancesOtherPurposes());
			feesMasterRestDTO.setExhibiCharitableInstitutions(feesmaster.getExhibiCharitableInstitutions());
			feesMasterRestDTO.setExhibiCommercial(feesmaster.getExhibiCommercial());
			feesMasterRestDTO.setExhibiGovernmentSemigovernmentInstitutionsCorporations(feesmaster.getExhibiGovernmentSemigovernmentInstitutionsCorporations());
			feesMasterRestDTO.setRegionandculture(feesmaster.getRegionandculture());
			feesMasterRestDTO.setWeddingsreceptions(feesmaster.getWeddingsreceptions());			
		}else if(serviceId==94) {
			checkservId=true;
			feesMasterRestDTO.setNoOfNursingBeds(feesmaster.getNoOfBeds1To5());
		}
		else
		{
			checkservId=false;
		}
		if(checkservId==true) {
			feesMasterRestDTO.setResponse("Request successfully");
			feesMasterRestDTO.setResponseStatus("ok");
			feesMasterRestDTO.setResponseCode(200);
			feesMasterRestDTO.setStatus("Method Allowed");
		}
		else 
		{
			feesMasterRestDTO.setResponse("Bad Request");
			feesMasterRestDTO.setResponseStatus("Enter Correct Service Id");
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			feesMasterRestDTO.setResponse("Bad Request");
			feesMasterRestDTO.setResponseStatus(ex.getMessage());
			feesMasterRestDTO.setResponseCode(405);
			feesMasterRestDTO.setStatus("Method not Allowed");
			
		}
		
		return feesMasterRestDTO;
	}
}
