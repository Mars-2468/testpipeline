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

import com.mars.rti.model.TreeTrimmingReason;
import com.mars.rti.service.TreeTrimmingReasonService;
import com.mars.rti.ws.model.TreeTrimmingReasonRestDTO;

@Controller
public class TreeTrimmingReasonRestController {

	@Autowired
	private TreeTrimmingReasonService  treeTrimmingReasonService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getTreeTrimmingReason")
	public @ResponseBody TreeTrimmingReasonRestDTO getTreeTrimmingReason(HttpServletResponse reponse) throws ServletException{
		TreeTrimmingReasonRestDTO treeDTO = new TreeTrimmingReasonRestDTO();	
	List<TreeTrimmingReason> tree = new ArrayList<TreeTrimmingReason>();
	tree = treeTrimmingReasonService.getTreeTrimmingReason();
	treeDTO.setTreeTrimmingReason(tree);
	treeDTO.setResponse(200);
	treeDTO.setResponseStatus("ok");
		return 	treeDTO;
		
	}
	
	
}
