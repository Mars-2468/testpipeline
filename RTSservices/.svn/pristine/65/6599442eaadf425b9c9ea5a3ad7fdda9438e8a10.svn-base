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

import com.mars.rti.model.Country;
import com.mars.rti.service.CountryService;
import com.mars.rti.ws.model.CountryDTO;


@Controller
public class CountryRestController {
	
	@Autowired
	private CountryService  countryService;
	@RequestMapping(method = RequestMethod.GET, value ="/getCountry")
	public @ResponseBody CountryDTO getCountry(HttpServletResponse reponse) throws ServletException{
		CountryDTO countryDTO = new CountryDTO();
		List<Country> country = new ArrayList<Country>();
		country = countryService.getCountry();
		
	countryDTO.setCountry(country);
	countryDTO.setResponse(200);
	countryDTO.setResponseStatus("ok");
		return 	countryDTO;
		
	}

}
