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

import com.mars.common.model.Permission;
import com.mars.common.search.PermissionSearch;
import com.mars.common.service.ApplicationService;
import com.mars.common.service.PermissionGroupService;
import com.mars.common.service.PermissionService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.ObjectDefinitionSourceImpl;

/**
 * <p>Title: PermissionController.java </p>

 * <p>Description: This is a  Permission controller class for controlling Permission related actions</p>

 * @see com.mars.common.model.Permission
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : SmartRaj development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class PermissionController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(PermissionController.class);

    
    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionGroupService permissionGroupService;
    
    @Autowired
    private ObjectDefinitionSourceImpl securityMetadataSource;

    public void setSecurityMetadataSource(ObjectDefinitionSourceImpl securityMetadataSource) {
      this.securityMetadataSource = securityMetadataSource;
    }

    /**
     * @param permissionService
     *            sets the PermissionService object.
     */
    public void setPermissionService(PermissionService permissionService)
    {
	this.permissionService = permissionService;
    }

    /**
     * @param permissionGroupService
     *            sets the PermissionService object.
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
     *         Permission entries to the database.
     */
    @RequestMapping("/permission/savePermission.do")
    public ModelAndView savePermission(HttpServletRequest request, HttpServletResponse response, Permission permission) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePermission");
	}
	if (permission != null)
		permission.setApplication(applicationService.get(Constants.APPLICATION_ID));

	{
		if (permission.getPermissionGroup() != null || (request.getParameter("permissionGroupId") != null && request.getParameter("permissionGroupId").length() > 0))
	    {
		long permissionGroupId = Long.parseLong(request.getParameter("permissionGroupId"));
		if (permission.getPermissionGroup() != null && permission.getPermissionGroup().getPermissionGroupId() > 0)
		{
		    permissionGroupId = permission.getPermissionGroup().getPermissionGroupId();
		}
		permission.setPermissionGroup(permissionGroupService.get(permissionGroupId));
	    }
		
		Permission permissionObjByUrl = permissionService.getByUrl(permission.getLinkUrl(), permission.getPermissionId());
				
		if (permissionObjByUrl != null) {
				session.setAttribute("message", permission.getLinkUrl() + " already exists");
		} else {
			Permission permissionObjByNameGroup = permissionService.getByNameGroup(permission.getLinkName(),
					permission.getPermissionGroup().getPermissionGroupId(), permission.getPermissionId());
			if (permissionObjByNameGroup != null)
				session.setAttribute("message", permission.getLinkName() + " already exists in this Group");
			else {
			    permissionService.save(permission);
			    securityMetadataSource.refresh();
			    session.setAttribute("message", "Permission saved successfully");
			}
		}
	}

	request.setAttribute("permissionGroupList", permissionGroupService.getAll());

	ModelAndView modelandView = new ModelAndView("managePermission");
	modelandView.addObject("permission", permission);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Permission entries
     */
    @RequestMapping("/permission/editPermission.do")
    public ModelAndView editPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editPermission");
	}

	Permission permission = null;
	String permissionId = request.getParameter("permissionId");
	if (permissionId != null && permissionId.length() > 0)
	{
	    permission = permissionService.get(Long.parseLong(permissionId));
	} else
	{
	    permission = new Permission();
	}

	request.setAttribute("permissionGroupList", permissionGroupService.getAll());
	return new ModelAndView("managePermission", "permission", permission);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Permission
     */
    @RequestMapping("/permission/listPermission.do")
    public ModelAndView listPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listPermission");
		}
				
		PermissionSearch searchOptions = new PermissionSearch();
		setSearchParameters(searchOptions, request);
	
		List<Permission> PermissionList = permissionService.getPermissionByType(searchOptions);
				
		try
		{
			long totalCount = permissionService.getPermissionCountBySearchOption(searchOptions);
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e)
		{
	    	log.error(e.getMessage());
		}		

		//Check if the PermissionList is null 		
		if(PermissionList==null)
			PermissionList = new ArrayList<Permission>();
		
		request.setAttribute("currentPage", searchOptions.getCurrentPage());
		request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
		request.setAttribute(const_SortBy, searchOptions.getSortBy());
		request.setAttribute("SearchOptions", searchOptions);
		request.setAttribute("permissionGroupList", permissionGroupService.getAll());
		
		return new ModelAndView("listPermission","PermissionList",PermissionList);
    }
    
    private void setSearchParameters(PermissionSearch searchOptions, HttpServletRequest request) {
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
    	
    	// setting default order by on linkName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "upper(linkName)";
			sortBy = "asc";
    	}
		
    	try {
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);							
		
			searchOptions.setName(request.getParameter("searchPermissionName"));
			searchOptions.setUrl(request.getParameter("searchPermissionUrl"));			
						
			String permissionGroupIdValue = request.getParameter("searchPermissionGroupId");
			if(permissionGroupIdValue != null && permissionGroupIdValue.length() > 0)
				searchOptions.setGroupId(Long.parseLong(permissionGroupIdValue));							
		} catch(Exception err) {
			log.error(err.getMessage());
		}
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Permission
     *         entry from database
     */
    @RequestMapping("/permission/deletePermission.do")
    public ModelAndView deletePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePermission");
	}
	String permissionId = request.getParameter("permissionId");
	if (permissionId != null && permissionId.length() > 0)
	{
	    Permission permission = permissionService.get(Long.parseLong(permissionId));
	    if (permission != null)
	    {
	    try{	
		permissionService.delete(Long.parseLong(permissionId));
		securityMetadataSource.refresh();
	    }catch(Exception e){
	    	session.setAttribute("message", "Cannot delete this record as it is used in other page");
    		return editPermission(request, response);
	    }
		session.setAttribute("message", "Permission deleted successfully");
	    }
	}
	return listPermission(request, response);
    }
}
