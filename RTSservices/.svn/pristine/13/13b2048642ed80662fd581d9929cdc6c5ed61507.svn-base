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

import com.mars.rti.model.ZoneWard;
import com.mars.rti.service.ZoneWardService;
import com.mars.rti.ws.model.ZonewardRestDTO;

	@Controller
	public class ZoneWardRestController {
		@Autowired
		private ZoneWardService  zoneWardService;
		@RequestMapping(method = RequestMethod.GET, value ="/getZoneWard/{zoneNo}")
		public @ResponseBody ZonewardRestDTO getZoneWard(@PathVariable String zoneNo,HttpServletResponse reponse) throws ServletException{
			ZonewardRestDTO zoneWard = new ZonewardRestDTO();
			List<ZoneWard> zone = new ArrayList<ZoneWard>();
			zone = zoneWardService.getZoneWard(zoneNo);
			zoneWard.setWardName(zone);
			zoneWard.setResponse(200);
			zoneWard.setResponseStatus("0k");
			return zoneWard;
		}

	}



