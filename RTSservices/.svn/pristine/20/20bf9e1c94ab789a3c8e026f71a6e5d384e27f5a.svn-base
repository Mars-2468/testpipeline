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

import com.mars.rti.model.Title;
import com.mars.rti.service.TitleRestService;
import com.mars.rti.ws.model.TitleRestDTO;


@Controller
public class TitleRestController {
	@Autowired
	private TitleRestService  titleRestService;
	@RequestMapping(method = RequestMethod.GET, value ="/getTitle")
	public @ResponseBody TitleRestDTO geTitle(HttpServletResponse reponse) throws ServletException{
		TitleRestDTO tittleRestDTO = new TitleRestDTO();
		List<Title> title = new ArrayList<Title>();
		title = titleRestService.getTitle();
		
		tittleRestDTO.setTitle(title);
		tittleRestDTO.setResponse(200);
		tittleRestDTO.setResponseStatus("ok");
		return tittleRestDTO;
		
	}
}
