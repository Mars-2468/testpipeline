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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.RolePermission;
import com.mars.common.service.PermissionService;
import com.mars.common.service.RolePermissionService;
import com.mars.common.service.RoleService;
import com.mars.common.utils.CommonUtils;

/**
 * <p>Title: RolePermissionController.java </p>

 * <p>Description: This is a  RolePermission controller class for controlling RolePermission related actions</p>

 * @see com.mars.common.model.RolePermission
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */
@Controller
public class RolePermissionController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(RolePermissionController.class);

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * @param rolePermissionService
     *            sets the RolePermissionService object.
     */
    public void setRolePermissionService(RolePermissionService rolePermissionService)
    {
	this.rolePermissionService = rolePermissionService;
    }

    /**
     * @param roleService
     *            sets the RolePermissionService object.
     */
    public void setRoleService(RoleService roleService)
    {
	this.roleService = roleService;
    }

    /**
     * @param permissionService
     *            sets the RolePermissionService object.
     */
    public void setPermissionService(PermissionService permissionService)
    {
	this.permissionService = permissionService;
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
     *         RolePermission entries to the database.
     */
 
    public ModelAndView saveRolePermission(HttpServletRequest request, HttpServletResponse response, RolePermission rolePermission) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveRolePermission");
	}
	if (rolePermission != null)
	{

	    if (rolePermission.getRole() != null || (request.getParameter("roleId") != null && request.getParameter("roleId").length() > 0))
	    {
		long roleId = Long.parseLong(request.getParameter("roleId"));
		if (rolePermission.getRole() != null && rolePermission.getRole().getRoleId() > 0)
		{
		    roleId = rolePermission.getRole().getRoleId();
		}
		rolePermission.setRole(roleService.get(roleId));
	    }

	    if (rolePermission.getPermission() != null || (request.getParameter("permissionId") != null && request.getParameter("permissionId").length() > 0))
	    {
		long permissionId = Long.parseLong(request.getParameter("permissionId"));
		if (rolePermission.getPermission() != null && rolePermission.getPermission().getPermissionId() > 0)
		{
		    permissionId = rolePermission.getPermission().getPermissionId();
		}
		rolePermission.setPermission(permissionService.get(permissionId));
	    }
	    rolePermissionService.save(rolePermission);
	    session.setAttribute("message", "rolePermission details saved successfully");
	}

	request.setAttribute("roleList", roleService.getAll());

	request.setAttribute("permissionList", permissionService.getAll());

	ModelAndView modelandView = new ModelAndView("manageRolePermission");
	modelandView.addObject("rolePermission", rolePermission);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating RolePermission entries
     */

    public ModelAndView editRolePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editRolePermission");
	}

	RolePermission rolePermission = null;
	String rolePermissionId = request.getParameter("rolePermissionId");
	if (rolePermissionId != null && rolePermissionId.length() > 0)
	{
	    rolePermission = rolePermissionService.get(Long.parseLong(rolePermissionId));
	} else
	{
	    rolePermission = new RolePermission();
	}

	request.setAttribute("roleList", roleService.getAll());

	request.setAttribute("permissionList", permissionService.getAll());
	return new ModelAndView("manageRolePermission", "rolePermission", rolePermission);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of RolePermission
     */

    public ModelAndView listRolePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listRolePermission");
		}
		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on rolePermissionId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "rolePermissionId";
			sortBy = "asc";
		}

		List<RolePermission> RolePermissionList = rolePermissionService.getRolePermissionList(longCurrentPage,orderBy,sortBy);
				
		try
		{
			long totalCount = rolePermissionService.getRolePermissionCount();
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e)
		{
	    	log.error(e.getMessage());
		}		

		//Check if the RolePermissionList is null 		
		if(RolePermissionList==null)
			RolePermissionList = new ArrayList<RolePermission>();

		request.setAttribute("currentPage", new Long(longCurrentPage));
		request.setAttribute(const_OrderBy, orderBy);
		request.setAttribute(const_SortBy, sortBy);	
		
		return new ModelAndView("listRolePermission","RolePermissionList",RolePermissionList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a RolePermission
     *         entry from database
     */

    public ModelAndView deleteRolePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveRolePermission");
	}
	String rolePermissionId = request.getParameter("rolePermissionId");
	if (rolePermissionId != null && rolePermissionId.length() > 0)
	{
	    RolePermission rolePermission = rolePermissionService.get(Long.parseLong(rolePermissionId));
	    if (rolePermission != null)
	    {
		rolePermissionService.delete(Long.parseLong(rolePermissionId));
		session.setAttribute("message", "rolePermission details deleted successfully");
	    }
	}
	return listRolePermission(request, response);
    }
}
