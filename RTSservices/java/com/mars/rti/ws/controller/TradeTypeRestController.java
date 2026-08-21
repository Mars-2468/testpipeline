package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.TradeType;
import com.mars.rti.service.TradeTypeService;
import com.mars.rti.ws.model.TradeTypeRestDTO;

@Controller
public class TradeTypeRestController {

	@Autowired
	private TradeTypeService tradeTypeService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getTradeType")
	private  @ResponseBody TradeTypeRestDTO getTradeType(HttpServletRequest request,HttpServletResponse response){
		TradeTypeRestDTO dto = new TradeTypeRestDTO();
		
		List<TradeType> tradeType = new ArrayList<TradeType>();
		tradeType = tradeTypeService.getall();

		dto.setTradeType(tradeType);
		dto.setResponse(HttpStatus.SC_OK);
		dto.setResponseStatus("ok");
		return dto;
	}
}
