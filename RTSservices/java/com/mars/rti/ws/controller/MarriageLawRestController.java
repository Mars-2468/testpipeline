package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.MarriageLaw;
import com.mars.rti.service.MarriageLawRestService;
import com.mars.rti.ws.model.MarriageLawRestDTO;

@Controller
public class MarriageLawRestController {

	@Autowired
	private MarriageLawRestService marriageLawRestService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getReligion")
	private @ResponseBody MarriageLawRestDTO getReligion(HttpServletRequest request,HttpServletResponse response) throws ServletException {

		MarriageLawRestDTO marriageLawRestDTO = new MarriageLawRestDTO();
		List<MarriageLaw> marriageLaw = new ArrayList<MarriageLaw>();
		marriageLaw = marriageLawRestService.getall();

		marriageLawRestDTO.setMarriagaLaw(marriageLaw);
		marriageLawRestDTO.setResponse(HttpStatus.SC_OK);
		marriageLawRestDTO.setResponseStatus("ok");
		return marriageLawRestDTO;
	}
}
