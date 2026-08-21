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

import com.mars.rti.model.TreeCuttingReason;
import com.mars.rti.service.TreeCuttingReasonService;
import com.mars.rti.ws.model.TreeCuttingReasonRestDTO;

@Controller
public class TreeCuttingReasonRestController {

	@Autowired
	private TreeCuttingReasonService  treeCuttingReasonService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getTreeCuttingReason")
	public @ResponseBody TreeCuttingReasonRestDTO getTreeCuttingReason(HttpServletResponse reponse) throws ServletException{
		TreeCuttingReasonRestDTO treeDTO = new TreeCuttingReasonRestDTO();	
	List<TreeCuttingReason> tree = new ArrayList<TreeCuttingReason>();
	tree = treeCuttingReasonService.getTreeCutingReason();
	treeDTO.setTreeCuttingReason(tree);
	treeDTO.setResponse(200);
	treeDTO.setResponseStatus("ok");
		return 	treeDTO;
		
	}
}
