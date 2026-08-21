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

import com.mars.rti.model.Space;
import com.mars.rti.service.SpaceService;
import com.mars.rti.ws.model.SpaceDTO;

@Controller
public class SpaceRestController {
	
	@Autowired
	private SpaceService  spaceService;
	@RequestMapping(method = RequestMethod.GET, value ="/getSpace")
	public @ResponseBody SpaceDTO getSpace(HttpServletResponse reponse) throws ServletException{
		SpaceDTO spaceDTO = new SpaceDTO();
		List<Space> space = new ArrayList<Space>();
		space = spaceService.getSpace();
		
		spaceDTO.setSpace(space);
		spaceDTO.setResponse(200);
		spaceDTO.setResponseStatus("ok");
			return 	spaceDTO;
			
		}
		
	}


