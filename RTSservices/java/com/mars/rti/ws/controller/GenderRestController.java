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

import com.mars.rti.model.Gender;
import com.mars.rti.service.GenderService;
import com.mars.rti.ws.model.GenderDTO;

@Controller
public class GenderRestController {
	@Autowired
	private GenderService  genderService;
	@RequestMapping(method = RequestMethod.GET, value ="/getGender")
	public @ResponseBody GenderDTO getGender(HttpServletResponse reponse) throws ServletException{
		GenderDTO genderDTO = new GenderDTO();
		List<Gender> gender = new ArrayList<Gender>();
		gender = genderService.getGender();
		
		genderDTO.setGender(gender);
		genderDTO.setResponse(200);
		genderDTO.setResponseStatus("ok");
		return genderDTO;
		
	}
}
