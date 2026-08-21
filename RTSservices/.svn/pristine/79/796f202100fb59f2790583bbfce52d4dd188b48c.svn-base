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

import com.mars.rti.model.BloodGroup;
import com.mars.rti.service.BloodGroupService;
import com.mars.rti.ws.model.BloodGroupRestDTO;

@Controller
public class BloodGroupRestController {

	@Autowired
	private BloodGroupService bloodGroupService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getBloodGroup")
	public @ResponseBody BloodGroupRestDTO getBloodGroup(HttpServletResponse reponse) throws ServletException{
		BloodGroupRestDTO bloodGroupRestDTO = new BloodGroupRestDTO();
		List<BloodGroup> bloodGroup = new ArrayList<BloodGroup>();
		bloodGroup = bloodGroupService.getBloodGroup();
		
		bloodGroupRestDTO.setBloodgroup(bloodGroup);
		bloodGroupRestDTO.setResponse(200);
		bloodGroupRestDTO.setResponseStatus("ok");
		return bloodGroupRestDTO;
		
	}
	
}
