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

import com.mars.rti.model.ZoneEsr;
import com.mars.rti.service.ZoneEsrService;
import com.mars.rti.ws.model.ZoneEsrRestDTO;


@Controller
public class ZoneEsrRestController {

	
	@Autowired
	private ZoneEsrService  zoneEsrService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getEsr/{zoneNo}")
	public @ResponseBody ZoneEsrRestDTO getEsr(@PathVariable long zoneNo,HttpServletResponse reponse) throws ServletException{
		ZoneEsrRestDTO zoneEsrRestDTO = new ZoneEsrRestDTO();
		List<ZoneEsr> zone = new ArrayList<ZoneEsr>();
		zone = zoneEsrService.getZoneWard(zoneNo);
		zoneEsrRestDTO.setEsr(zone);
		zoneEsrRestDTO.setResponse(200);
		zoneEsrRestDTO.setResponseStatus("0k");
		return zoneEsrRestDTO;
	}
	
}
