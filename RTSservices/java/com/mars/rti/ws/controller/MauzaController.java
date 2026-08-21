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

import com.mars.rti.model.Mauza;
import com.mars.rti.service.MauzaService;
import com.mars.rti.ws.model.MauzaDTO;

@Controller

public class MauzaController {
	
	@Autowired
	private MauzaService  mauzaService;
	@RequestMapping(method = RequestMethod.GET, value ="/getMauza")
	public @ResponseBody MauzaDTO getMauza(HttpServletResponse reponse) throws ServletException{
		MauzaDTO mauzaDTO = new MauzaDTO();	
		List<Mauza> mauza = new ArrayList<Mauza>();
		mauza = mauzaService.getMauza();
		mauzaDTO.setMauza(mauza);
		mauzaDTO.setResponse(200);
		mauzaDTO.setResponseStatus("ok");
			return 	mauzaDTO;
			
		}
}
