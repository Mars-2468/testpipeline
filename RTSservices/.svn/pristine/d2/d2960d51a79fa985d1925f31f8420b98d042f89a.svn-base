package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.PropertyWard;
import com.mars.rti.service.PropertyWardService;
import com.mars.rti.ws.model.PropertyWardRestDTO;

@Controller
public class PropertyWardRestController {
	
	
	private Log log= LogFactory.getLog(PropertyWardRestController.class);
	@Autowired
	private PropertyWardService  propertyWardService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getWardApplication/{zoneId}")
	public @ResponseBody PropertyWardRestDTO getZoneApplication(@PathVariable String zoneId,HttpServletResponse reponse) throws ServletException{

		PropertyWardRestDTO propertyWardRestDTO = new PropertyWardRestDTO();
		List<PropertyWard> ward = new ArrayList<PropertyWard>();
		ward = propertyWardService.getwards(zoneId);
		
		propertyWardRestDTO.setWard(ward);
		return propertyWardRestDTO;
	}
}
