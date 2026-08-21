package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.MarriageProofAge;
import com.mars.rti.service.MarriageProofAgeRestService;
import com.mars.rti.ws.model.MarriageProofAgeRestDTO;

@Controller
public class MarriageProofAgeRestController {

	@Autowired
	private MarriageProofAgeRestService marriageProofAgeRestService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getAgeProof")
	private  @ResponseBody MarriageProofAgeRestDTO getAgeProof(HttpServletRequest request,HttpServletResponse response){
		MarriageProofAgeRestDTO dto = new MarriageProofAgeRestDTO();
		
		List<MarriageProofAge> marriageProofAge = new ArrayList<MarriageProofAge>();
		marriageProofAge = marriageProofAgeRestService.getall();

		dto.setProofOfAge(marriageProofAge);
		dto.setResponse(HttpStatus.SC_OK);
		dto.setResponseStatus("ok");
		
		return dto;
	}
	
}
