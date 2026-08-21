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

import com.mars.rti.model.TypeOfTree;
import com.mars.rti.service.TypeOfTreeService;
import com.mars.rti.ws.model.TypeOfTreeRestDTO;

@Controller
public class TypeOfTreeRestController {

	@Autowired
	private TypeOfTreeService  typeOfTreeService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getTreeType")
	public @ResponseBody TypeOfTreeRestDTO getTreeType(HttpServletResponse reponse) throws ServletException{
	TypeOfTreeRestDTO treeDTO = new TypeOfTreeRestDTO();	
	List<TypeOfTree> tree = new ArrayList<TypeOfTree>();
	tree = typeOfTreeService.getTypeOfTree();
	treeDTO.setTypeOfTree(tree);
	treeDTO.setResponse(200);
	treeDTO.setResponseStatus("ok");
		return 	treeDTO;
		
	}
}
