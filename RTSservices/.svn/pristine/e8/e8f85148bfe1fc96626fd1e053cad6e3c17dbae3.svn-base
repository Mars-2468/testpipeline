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

import com.mars.rti.model.NOCFireRecommendation;
import com.mars.rti.service.NOCFirerecommendationService;
import com.mars.rti.ws.model.NOCFirerecommendationDTO;

@Controller

public class NOCFirerecommendationRestController {

	
	@Autowired
	private NOCFirerecommendationService  nOCFirerecommendationService;
	@RequestMapping(method = RequestMethod.GET, value ="/getNOCFirerecommendation/{id}")
	public @ResponseBody NOCFirerecommendationDTO getNOCFirerecommendation(@PathVariable long id, HttpServletResponse reponse) throws ServletException{
		NOCFirerecommendationDTO nOCFirerecommendationDTO = new NOCFirerecommendationDTO();
		List<NOCFireRecommendation> nOCFireRecommendation = new ArrayList<>();
		NOCFireRecommendation nb = null;
		nb = nOCFirerecommendationService.get(id);
		nOCFireRecommendation.add(nb);
		nOCFirerecommendationDTO.setNOCFireRecommendation(nOCFireRecommendation);
		nOCFirerecommendationDTO.setResponse(200);
		nOCFirerecommendationDTO.setResponseStatus("ok");
		return nOCFirerecommendationDTO;
		
	}
}
