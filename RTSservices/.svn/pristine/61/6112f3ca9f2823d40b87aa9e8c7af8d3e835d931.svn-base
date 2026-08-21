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

import com.mars.rti.model.CitizenZone;
import com.mars.rti.service.CitizenZoneService;
import com.mars.rti.ws.model.CitezenZoneDTO;

@Controller
public class CitzenZoneRestController {

	@Autowired
	private CitizenZoneService  CitizenZoneService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getZoneApplication")
	public @ResponseBody CitezenZoneDTO getZoneApplication(HttpServletResponse reponse) throws ServletException{

		CitezenZoneDTO citezenZoneDTO = new CitezenZoneDTO();
		List<CitizenZone> zone = new ArrayList<CitizenZone>();
		zone = CitizenZoneService.getzones();
		
		citezenZoneDTO.setZoneName(zone);
		return citezenZoneDTO;
	}
}
