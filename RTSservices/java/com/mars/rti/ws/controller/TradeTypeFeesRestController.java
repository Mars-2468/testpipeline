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

import com.mars.rti.model.TradeTypeFees;
import com.mars.rti.service.TradeTypeFeesService;
import com.mars.rti.ws.model.TradeTypeFeesRestDTO;

@Controller
public class TradeTypeFeesRestController {

	@Autowired
	private TradeTypeFeesService tradeTypeFeesService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getTradeTypeFees")
	private  @ResponseBody TradeTypeFeesRestDTO getTradeTypeFees(HttpServletRequest request,HttpServletResponse response){
		TradeTypeFeesRestDTO dto = new TradeTypeFeesRestDTO();
		
		List<TradeTypeFees> tradeType = new ArrayList<TradeTypeFees>();
		tradeType = tradeTypeFeesService.getall();

		dto.setTradeTypeFees(tradeType);
		dto.setResponse(HttpStatus.SC_OK);
		dto.setResponseStatus("ok");
		return dto;
	}
}
