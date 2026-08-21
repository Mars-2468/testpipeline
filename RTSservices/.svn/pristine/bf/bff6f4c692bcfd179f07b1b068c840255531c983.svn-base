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

import com.mars.rti.model.TreeLocation;
import com.mars.rti.service.TreeLocationService;
import com.mars.rti.ws.model.TreeLocationRestDTO;

@Controller
public class TreeLocationRestController {
	@Autowired
	private TreeLocationService  treeLocationService;
	@RequestMapping(method = RequestMethod.GET, value ="/getTreeLocation")
	public @ResponseBody TreeLocationRestDTO gettreLocations(HttpServletResponse reponse) throws ServletException{
		TreeLocationRestDTO treeLocationRestDTO = new TreeLocationRestDTO();
		List<TreeLocation> treeLocation = new ArrayList<TreeLocation>();
		treeLocation = treeLocationService.gettreLocations();
		
		treeLocationRestDTO.setTreelocation(treeLocation);
		treeLocationRestDTO.setResponse(200);
		treeLocationRestDTO.setResponseStatus("ok");
		return treeLocationRestDTO;

}
}
