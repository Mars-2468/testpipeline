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

import com.mars.rti.model.GenderOfCrematious;
import com.mars.rti.service.GenderOfCrematiousService;
import com.mars.rti.ws.model.GenderOfCrematiousDTO;

@Controller
public class GenderOfCrematiousController {
	@Autowired
	private GenderOfCrematiousService  genderOfCrematiousService;
	@RequestMapping(method = RequestMethod.GET, value ="/getGenderOfCrematious")
	public @ResponseBody GenderOfCrematiousDTO getGenderOfCrematious(HttpServletResponse reponse) throws ServletException{
		GenderOfCrematiousDTO genderDTO = new GenderOfCrematiousDTO();
		List<GenderOfCrematious> gender = new ArrayList<GenderOfCrematious>();
		gender = genderOfCrematiousService.getGenderOfCrematious();
		genderDTO.setGender(gender);
		genderDTO.setResponse(200);
		genderDTO.setResponseStatus("ok");
		return genderDTO;
	}
}
