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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.UserRole;
import com.mars.common.service.RoleService;
import com.mars.common.service.UserRoleService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;

/**
 * <p>Title: UserRoleController.java </p>

 * <p>Description: This is a  UserRole controller class for controlling UserRole related actions</p>

 * @see com.mars.common.model.UserRole
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */

public class UserRoleController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(UserRoleController.class);

    private UserRoleService userRoleService;

    private UserService userService;

    private RoleService roleService;

    /**
     * @param userRoleService
     *            sets the UserRoleService object.
     */
    public void setUserRoleService(UserRoleService userRoleService)
    {
	this.userRoleService = userRoleService;
    }

    /**
     * @param userService
     *            sets the UserRoleService object.
     */
    public void setUserService(UserService userService)
    {
	this.userService = userService;
    }

    /**
     * @param roleService
     *            sets the UserRoleService object.
     */
    public void setRoleService(RoleService roleService)
    {
	this.roleService = roleService;
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
     *         UserRole entries to the database.
     */
    public ModelAndView saveUserRole(HttpServletRequest request, HttpServletResponse response, UserRole userRole) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveUserRole");
	}
	if (userRole != null)
	{

	    if (userRole.getUser() != null || (request.getParameter("userId") != null && request.getParameter("userId").length() > 0))
	    {
		long userId = Long.parseLong(request.getParameter("userId"));
		if (userRole.getUser() != null && userRole.getUser().getUserId() > 0)
		{
		    userId = userRole.getUser().getUserId();
		}
		userRole.setUser(userService.get(userId));
	    }

	    if (userRole.getRole() != null || (request.getParameter("roleId") != null && request.getParameter("roleId").length() > 0))
	    {
		long roleId = Long.parseLong(request.getParameter("roleId"));
		if (userRole.getRole() != null && userRole.getRole().getRoleId() > 0)
		{
		    roleId = userRole.getRole().getRoleId();
		}
		userRole.setRole(roleService.get(roleId));
	    }
	    userRoleService.save(userRole);
	    session.setAttribute("message", "userRole details saved successfully");
	}

	request.setAttribute("userList", userService.getAll());

	request.setAttribute("roleList", roleService.getAll());

	ModelAndView modelandView = new ModelAndView("manageUserRole");
	modelandView.addObject("userRole", userRole);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating UserRole entries
     */

    public ModelAndView editUserRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editUserRole");
	}

	UserRole userRole = null;
	String userRoleId = request.getParameter("userRoleId");
	if (userRoleId != null && userRoleId.length() > 0)
	{
	    userRole = userRoleService.get(Long.parseLong(userRoleId));
	} else
	{
	    userRole = new UserRole();
	}

	request.setAttribute("userList", userService.getAll());

	request.setAttribute("roleList", roleService.getAll());
	return new ModelAndView("manageUserRole", "userRole", userRole);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of UserRole
     */

    public ModelAndView listUserRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listUserRole");
		}
		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on userRoleId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "userRoleId";
			sortBy = "asc";
		}

		List<UserRole> UserRoleList = userRoleService.getUserRoleList(longCurrentPage,orderBy,sortBy);
				
		try
		{
			long totalCount = userRoleService.getUserRoleCount();
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e)
		{
	    	log.error(e.getMessage());
		}		

		//Check if the UserRoleList is null 		
		if(UserRoleList==null)
			UserRoleList = new ArrayList<UserRole>();

		request.setAttribute("currentPage", new Long(longCurrentPage));
		request.setAttribute(const_OrderBy, orderBy);
		request.setAttribute(const_SortBy, sortBy);	
		
		return new ModelAndView("listUserRole","UserRoleList",UserRoleList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a UserRole
     *         entry from database
     */

    public ModelAndView deleteUserRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveUserRole");
	}
	String userRoleId = request.getParameter("userRoleId");
	if (userRoleId != null && userRoleId.length() > 0)
	{
	    UserRole userRole = userRoleService.get(Long.parseLong(userRoleId));
	    if (userRole != null)
	    {
		userRoleService.delete(Long.parseLong(userRoleId));
		session.setAttribute("message", "userRole details deleted successfully");
	    }
	}
	return listUserRole(request, response);
    }
}
