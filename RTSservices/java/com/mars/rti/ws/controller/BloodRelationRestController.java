package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.BloodRelation;
import com.mars.rti.service.BloodRelationService;
import com.mars.rti.ws.model.BloodRelationRestDTO;

@Controller
public class BloodRelationRestController {

	@Autowired
	private BloodRelationService bloodRelationService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getBloodRelation")
	public @ResponseBody BloodRelationRestDTO getBloodRelation(HttpServletResponse reponse) throws ServletException{
		BloodRelationRestDTO bloodRelationRestDTO = new BloodRelationRestDTO();
		List<BloodRelation> bloodRelation = new ArrayList<BloodRelation>();
		bloodRelation = bloodRelationService.getBloodrelation();
		bloodRelationRestDTO.setBloodrelation(bloodRelation);
		bloodRelationRestDTO.setResponse(200);
		bloodRelationRestDTO.setResponseStatus("ok");
		return bloodRelationRestDTO;
		
	}
	
}
