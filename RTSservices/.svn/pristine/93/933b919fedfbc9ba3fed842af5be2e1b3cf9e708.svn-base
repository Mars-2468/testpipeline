package com.mars.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.PermissionGroup;
import com.mars.common.service.ApplicationService;
import com.mars.common.service.PermissionGroupService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.ObjectDefinitionSourceImpl;

/**
 * <p>Title: PermissionGroupController.java </p>

 * <p>Description: This is a  PermissionGroup controller class for controlling PermissionGroup related actions</p>

 * @see com.mars.common.model.PermissionGroup
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */
@Controller
public class PermissionGroupController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(PermissionGroupController.class);

    @Autowired
    private PermissionGroupService permissionGroupService;
    
    @Autowired
    private ObjectDefinitionSourceImpl securityMetadataSource;

    public void setSecurityMetadataSource(ObjectDefinitionSourceImpl securityMetadataSource) {
      this.securityMetadataSource = securityMetadataSource;
    }

    /**
     * @param permissionGroupService
     *            sets the PermissionGroupService object.
     */
    public void setPermissionGroupService(PermissionGroupService permissionGroupService)
    {
	this.permissionGroupService = permissionGroupService;
    }

    public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    /** protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
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
     *         PermissionGroup entries to the database.
     */
    @Autowired
    private ApplicationService applicationService;
    
    @RequestMapping("/permissiongroup/savePermissionGroup.do")
    public ModelAndView savePermissionGroup(HttpServletRequest request, HttpServletResponse response, PermissionGroup permissionGroup) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePermissionGroup");
	}
	if (permissionGroup != null)
	{
		permissionGroup.setApplication(applicationService.get(Constants.APPLICATION_ID));
		PermissionGroup permissionGroupObj = permissionGroupService.getByName(permissionGroup.getName(), permissionGroup.getPermissionGroupId());
		
		if (permissionGroupObj != null) {
			session.setAttribute("message", permissionGroupObj.getName() + " already exists");
		}
		else{
			permissionGroupService.save(permissionGroup);
			securityMetadataSource.refresh();
		    session.setAttribute("message", "Permission Group  saved successfully");
		}
	}

	ModelAndView modelandView = new ModelAndView("managePermissionGroup");
	modelandView.addObject("permissionGroup", permissionGroup);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating PermissionGroup entries
     */
    @RequestMapping("/permissiongroup/editPermissionGroup.do")
    public ModelAndView editPermissionGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editPermissionGroup");
	}

	PermissionGroup permissionGroup = null;
	String permissionGroupId = request.getParameter("permissionGroupId");
	if (permissionGroupId != null && permissionGroupId.length() > 0)
	{
	    permissionGroup = permissionGroupService.get(Long.parseLong(permissionGroupId));
	} else
	{
	    permissionGroup = new PermissionGroup();
	}

	return new ModelAndView("managePermissionGroup", "permissionGroup", permissionGroup);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of PermissionGroup
     */
    @RequestMapping("/permissiongroup/listPermissionGroup.do")
    public ModelAndView listPermissionGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listPermissionGroup");
		}
		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on permissionGroupId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(name)";
			sortBy = "asc";
		}

		List<PermissionGroup> PermissionGroupList = permissionGroupService.getPermissionGroupList(longCurrentPage,orderBy,sortBy);
				
		try
		{
			long totalCount = permissionGroupService.getPermissionGroupCount();
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e)
		{
	    	log.error(e.getMessage());
		}		

		//Check if the PermissionGroupList is null 		
		if(PermissionGroupList==null)
			PermissionGroupList = new ArrayList<PermissionGroup>();

		request.setAttribute("currentPage", new Long(longCurrentPage));
		request.setAttribute(const_OrderBy, orderBy);
		request.setAttribute(const_SortBy, sortBy);	
		
		return new ModelAndView("listPermissionGroup","PermissionGroupList",PermissionGroupList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a PermissionGroup
     *         entry from database
     */
    @RequestMapping("/permissiongroup/deletePermissionGroup.do")
    public ModelAndView deletePermissionGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePermissionGroup");
	}
	String permissionGroupId = request.getParameter("permissionGroupId");
	if (permissionGroupId != null && permissionGroupId.length() > 0)
	{
	    PermissionGroup permissionGroup = permissionGroupService.get(Long.parseLong(permissionGroupId));
	    if (permissionGroup != null)
	    {
	    try{	
		permissionGroupService.delete(Long.parseLong(permissionGroupId));
		securityMetadataSource.refresh();
	    }catch(Exception e){
	    	session.setAttribute("message", "Cannot delete this record as it is used in other page");
    		return editPermissionGroup(request, response);
	    }
		session.setAttribute("message", "Permission Group deleted successfully");
	    }
	}
	return listPermissionGroup(request, response);
    }
    /**
     * 
     * @param searchOptions
     * @param request
     */
private void setSearchParameters(PermissionGroup searchOptions,HttpServletRequest request) {
	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
	String orderBy = request.getParameter(const_OrderBy);
	String sortBy = request.getParameter(const_SortBy);

	// setting default order by on inwardId
	if (orderBy == null || orderBy.length() < 1) {
		orderBy = "upper(name)";
		sortBy = "asc";
	}
	searchOptions.setCurrentPage(longCurrentPage);
	searchOptions.setOrderBy(orderBy);
	searchOptions.setSortBy(sortBy);
		searchOptions.setName(request.getParameter("searchName"));
}
/**
 * 
 * @param request
 * @param response
 * @return
 * @throws ServletException
 */
@RequestMapping("/permissiongroup/listPermissionGroupBySearch.do")
public ModelAndView listPermissionGroupBySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException
{
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listHeadOfAccountBySearch");
	}


	PermissionGroup searchOptions = new PermissionGroup();
	setSearchParameters(searchOptions,request);
	
	List<PermissionGroup> PermissionGroupList = permissionGroupService.getPermissionGroupListBySearch(searchOptions);
	
	try
	{
	    long totalCount = permissionGroupService.getPermissionGroupCountBySearchOption(searchOptions);
	    request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount )));
	    request.setAttribute("totalCount", totalCount);
	
	} catch (Exception e)
	{
	    log.error(e.getMessage());
	}
	if (PermissionGroupList == null)
	{
		request.setAttribute("message","No Records Found ");
		PermissionGroupList = new ArrayList<PermissionGroup>();
	}
	request.setAttribute("currentPage", searchOptions.getCurrentPage());
	request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
	request.setAttribute(const_SortBy, searchOptions.getSortBy());	
	request.setAttribute("searchOptions", searchOptions);
	return new ModelAndView("listPermissionGroup","PermissionGroupList",PermissionGroupList);
}
}
