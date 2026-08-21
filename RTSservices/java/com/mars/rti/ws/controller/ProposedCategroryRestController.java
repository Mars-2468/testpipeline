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

import com.mars.rti.model.ProposedCategrory;
import com.mars.rti.service.ProposedCategoryService;
import com.mars.rti.ws.model.ProposedCategroryRestDTO;

@Controller
public class ProposedCategroryRestController {
	
	@Autowired
	private ProposedCategoryService  proposedCategoryService;
	@RequestMapping(method = RequestMethod.GET, value ="/getProposedCategrory")
	public @ResponseBody ProposedCategroryRestDTO getProposedCategrory(HttpServletResponse reponse) throws ServletException{
		ProposedCategroryRestDTO proposedCategroryRestDTO = new ProposedCategroryRestDTO();
		List<ProposedCategrory> proposedCategrory = new ArrayList<ProposedCategrory>();
		proposedCategrory = proposedCategoryService.getCategoryname();
		
		proposedCategroryRestDTO.setProposedCategrory(proposedCategrory);
		proposedCategroryRestDTO.setResponse(200);
		proposedCategroryRestDTO.setResponseStatus("ok");
		return proposedCategroryRestDTO;
		
	}

}
