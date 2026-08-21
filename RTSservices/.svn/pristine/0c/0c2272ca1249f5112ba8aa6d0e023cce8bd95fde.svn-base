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

import com.mars.rti.model.CitizenHospital;
import com.mars.rti.service.CitizenHospitalService;
import com.mars.rti.ws.model.CitizenHospitalRestDTO;

@Controller
public class CitizenHospitalRestController 
{
	@Autowired
	private CitizenHospitalService citizenHospitalService ;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getCitizenHospitalList/{zoneNo}")
	public @ResponseBody CitizenHospitalRestDTO getCitizenHospitalList(@PathVariable String zoneNo,HttpServletResponse reponse) throws ServletException{

		CitizenHospitalRestDTO citizenHospitalRestDTO = new CitizenHospitalRestDTO();
		List<CitizenHospital> hospitalname = new ArrayList<CitizenHospital>();
		hospitalname = citizenHospitalService.getAllHospitalList(zoneNo);
		
		citizenHospitalRestDTO.setHospitalName(hospitalname);
		return citizenHospitalRestDTO;
	}
	
}
