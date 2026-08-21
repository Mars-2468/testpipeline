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

import com.mars.rti.model.ReasonForTreeTrimming;
import com.mars.rti.service.ReasinForTreeTrimmingService;
import com.mars.rti.ws.model.ReasonForTreeTrimmingRestDTO;

@Controller
public class ReasonForTreeTrimmingRestController {
	
	@Autowired
	private ReasinForTreeTrimmingService  reasinForTreeTrimmingService;
	@RequestMapping(method = RequestMethod.GET, value ="/getReasonForTreeTrimming")
	public @ResponseBody ReasonForTreeTrimmingRestDTO getReasonForTreeTrimming(HttpServletResponse reponse) throws ServletException{
		ReasonForTreeTrimmingRestDTO reasonForTreeTrimmingRestDTO = new ReasonForTreeTrimmingRestDTO();
		List<ReasonForTreeTrimming> reasonForTreeTrimming = new ArrayList<ReasonForTreeTrimming>();
		reasonForTreeTrimming = reasinForTreeTrimmingService.getresReasonForTreeTrimmings();
		
		reasonForTreeTrimmingRestDTO.setReasonForTreeTrimming(reasonForTreeTrimming);
		reasonForTreeTrimmingRestDTO.setResponse(200);
		reasonForTreeTrimmingRestDTO.setResponseStatus("ok");
		return reasonForTreeTrimmingRestDTO;
		
	}

}
