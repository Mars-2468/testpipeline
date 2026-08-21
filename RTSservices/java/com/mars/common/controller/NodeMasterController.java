package com.mars.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.NodeMaster;
import com.mars.common.search.NodeMasterSearch;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.WardService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: NodeMasterController.java </p>

 * <p>Description: This is a  NodeMaster controller class for controlling NodeMaster related actions</p>

 * @see com.mars.common.model.NodeMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class NodeMasterController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(NodeMasterController.class);

    @Autowired
    private NodeMasterService nodeMasterService;

    @Autowired
    private WardService wardService;

    /**
     * @param nodeMasterService
     *            sets the NodeMasterService object.
     */
    public void setNodeMasterService(NodeMasterService nodeMasterService)
    {
	this.nodeMasterService = nodeMasterService;
    }

    /**
     * @param wardService
     *            sets the NodeMasterService object.
     */
    public void setWardService(WardService wardService)
    {
	this.wardService = wardService;
    }

    public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for saving
     *         NodeMaster entries to the database.
     */
    @RequestMapping("/nodemaster/saveNodeMaster.do")
    public ModelAndView saveNodeMaster(HttpServletRequest request, HttpServletResponse response, NodeMaster node) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveNode");
	}

	if (node != null)
	{

	    if (node.getWard() != null || (request.getParameter("wardId") != null && request.getParameter("wardId").length() > 0))
	    {
		long wardId = Long.parseLong(request.getParameter("wardId"));
		if (node.getWard() != null && node.getWard().getWardId() > 0)
		{
		    wardId = node.getWard().getWardId();
		}
		node.setWard(wardService.get(wardId));
	    }
	    NodeMaster nodeObj = null;

	    // Check for Duplicate NodeMaster
	    //TODO: Uncomment if you need to check duplicates and update the query in the NodedaoImpl.checkForDuplicates
	    nodeObj = nodeMasterService.checkForDuplicates(node);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (nodeObj != null)
		{
		    session.setAttribute("message", "Node with the same name already exists.");
		} else
		{
		    nodeMasterService.save(node);
		    session.setAttribute("message", "Node details saved successfully");
		}
	    }
	}

	request.setAttribute("wardList", wardService.getAll());

	ModelAndView modelandView = new ModelAndView("manageNodeMaster");
	modelandView.addObject("node", node);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating NodeMaster entries
     */
    @RequestMapping("/nodemaster/editNodeMaster.do")
    public ModelAndView editNodeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editNode");
	}

	NodeMaster node = null;
	String nodeMasterId = request.getParameter("nodeMasterId");
	if (StringUtils.isNotEmpty(nodeMasterId))
	{
	    node = nodeMasterService.get(Long.parseLong(nodeMasterId));
	} else
	{
	    node = new NodeMaster();
	}

	request.setAttribute("wardList", wardService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageNodeMaster", "node", node);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of NodeMaster
     */
    @RequestMapping("/nodemaster/listNodeMaster.do")
    public ModelAndView listNodeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listNode");
		}
		    NodeMasterSearch searchNodeMaster=new NodeMasterSearch();
		    setSearchParameters(searchNodeMaster, request);
		    
			List<NodeMaster> NodeList = nodeMasterService.getNodeListBySearch(searchNodeMaster);
			try
			{
				long totalCount = nodeMasterService.getNodeCountBySearch(searchNodeMaster);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the NodeList is null 		
		if(NodeList==null)
			NodeList = new ArrayList<NodeMaster>();
		
			request.setAttribute("wardList", wardService.getAll());
			request.setAttribute("currentPage", searchNodeMaster.getCurrentPage());
			request.setAttribute(const_OrderBy, searchNodeMaster.getOrderBy());
			request.setAttribute(const_SortBy, searchNodeMaster.getSortBy());	
			request.setAttribute("SearchNodeMaster", searchNodeMaster);
		return new ModelAndView("listNodeMaster","NodeList",NodeList);
    }
    
    /**
     * @param NodeMasterSearch searchNodeMaster
     * @param request
     */
    private void setSearchParameters(NodeMasterSearch searchNodeMaster,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on nodeId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			if(request.getParameter("searchWardId")!=null && request.getParameter("searchWardId").length()>0)
				searchNodeMaster.setWardId(Long.parseLong(request.getParameter("searchWardId")));
			searchNodeMaster.setName(request.getParameter("searchName"));
			searchNodeMaster.setCurrentPage(longCurrentPage);
			searchNodeMaster.setOrderBy(orderBy);
			searchNodeMaster.setSortBy(sortBy);
    	}catch(Exception err){
    		log.error(err.getMessage());
    	}
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a NodeMaster
     *         entry from database
     */
    @RequestMapping("/nodemaster/deleteNodeMaster.do")
    public ModelAndView deleteNodeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteNode");
	}
	String nodeMasterId = request.getParameter("nodeMasterId");
	if (StringUtils.isNotEmpty(nodeMasterId))
	{
	    NodeMaster node = nodeMasterService.get(Long.parseLong(nodeMasterId));
	    if (node != null)
	    {
		try
		{
		    nodeMasterService.delete(Long.parseLong(nodeMasterId));
		    session.setAttribute("message", "Node details deleted successfully");
		} catch (Exception exception)
		{
			exception.printStackTrace();
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editNodeMaster(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Node details you are trying to delete is already deleted.");
	    }
	}
	return listNodeMaster(request, response);
    }    
    
    
}
