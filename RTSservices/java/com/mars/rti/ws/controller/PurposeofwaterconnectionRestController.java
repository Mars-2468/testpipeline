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

import com.mars.rti.model.Purposeofwaterconnection;
import com.mars.rti.service.PurposeofwaterconnectionService;
import com.mars.rti.ws.model.PurposeofwaterconnectionRestDTO;

@Controller
public class PurposeofwaterconnectionRestController {
	
	@Autowired
	private PurposeofwaterconnectionService  purposeofwaterconnectionService;
	@RequestMapping(method = RequestMethod.GET, value ="/getPurposeofwaterconnections")
	public @ResponseBody PurposeofwaterconnectionRestDTO getPurposeofwaterconnections(HttpServletResponse reponse) throws ServletException{
		PurposeofwaterconnectionRestDTO purposeofwaterconnectionRestDTO = new PurposeofwaterconnectionRestDTO();
		List<Purposeofwaterconnection> purposeofwaterconnection = new ArrayList<Purposeofwaterconnection>();
		purposeofwaterconnection = purposeofwaterconnectionService.getPurposeofwaterconnections();
		
		purposeofwaterconnectionRestDTO.setPurposeconnection(purposeofwaterconnection);
		purposeofwaterconnectionRestDTO.setResponse(200);
		purposeofwaterconnectionRestDTO.setResponseStatus("ok");
		return purposeofwaterconnectionRestDTO;
		
	}

}
