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

import com.mars.rti.model.MarriageOccupation;
import com.mars.rti.service.MarriageOccupationService;
import com.mars.rti.ws.model.MarriageOccupationRestDTO;

@Controller
public class MarriageOccupationRestController {

	@Autowired
	private MarriageOccupationService marriageOccupationService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getOccupation")
	private  @ResponseBody MarriageOccupationRestDTO getOccupation(HttpServletRequest request,HttpServletResponse response){
		MarriageOccupationRestDTO dto = new MarriageOccupationRestDTO();
		
		List<MarriageOccupation> marriageOccupation = new ArrayList<MarriageOccupation>();
		marriageOccupation = marriageOccupationService.getall();

		dto.setOccupation(marriageOccupation);
		dto.setResponse(HttpStatus.SC_OK);
		dto.setResponseStatus("ok");
		return dto;
	}
	
}
