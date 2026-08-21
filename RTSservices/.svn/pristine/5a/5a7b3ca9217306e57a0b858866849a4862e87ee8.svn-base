package com.mars.common.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.mars.common.model.PermissionGroup;
import com.mars.common.model.Role;
import com.mars.common.model.RolePermission;
import com.mars.common.model.User;
import com.mars.common.search.RoleSearch;
import com.mars.common.service.ApplicationService;
import com.mars.common.service.PermissionGroupService;
import com.mars.common.service.PermissionService;
import com.mars.common.service.RoleService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.ObjectDefinitionSourceImpl;
import com.mars.common.utils.SessionUser;

/**
 * <p>
 * Title: RoleController.java
 * </p>
 * 
 * <p>
 * Description: This is a Role controller class for controlling Role related
 * actions
 * </p>
 * 
 * @see com.mars.common.model.Role Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */
@Controller
public class RoleController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserService userService;

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

    public PermissionGroupService getPermissionGroupService()
    {
	return permissionGroupService;
    }

    public void setPermissionGroupService(PermissionGroupService permissionGroupService)
    {
	this.permissionGroupService = permissionGroupService;
    }

    public PermissionService getPermissionService()
    {
	return permissionService;
    }

    public void setPermissionService(PermissionService permissionService)
    {
	this.permissionService = permissionService;
    }

    
    public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
     * @param roleService
     *          sets the RoleService object.
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
     *          current HTTP request
     * @param response
     *          current HTTP response
     * @return a ModelAndView to render the response. This method is for saving
     *         Role entries to the database.
     */
    @RequestMapping("/role/saveRole.do")
    public ModelAndView saveRole(HttpServletRequest request, HttpServletResponse response, Role role) throws ServletException
    {
	HttpSession session = request.getSession();
	SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
    User user=userService.get(sessionUser.getUserId());
    /*Application application=new Application();
    //applicationService.get(applicationId);
    application.setApplicationId(Constants.APPLICATION_ID);
    application.getApplicationId();*/
	
   // applicationService.save(application);
  
    role.setApplication(applicationService.get(Constants.APPLICATION_ID));
  
   // int applicationID =0;
   
	
			//applicationID =Constants.APPLICATION_ID;
	
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveRole");
	}

	Set<RolePermission> rolePermissionSet = null;
	String deletedRolePermissionIds = "";

	if (role != null)
	{
		//applicationID =Constants.APPLICATION_ID;
		String strAddIds[] = null;
		String addPermissionIds = (CommonUtils.decodeString(request.getParameter("addPermissionIds")));
		addPermissionIds = CommonUtils.decodeString(addPermissionIds);
	    try
	    {
			 addPermissionIds = request.getParameter("addPermissionIds");
	
			if (addPermissionIds != null && addPermissionIds.length() > 0)
			{
			    strAddIds = addPermissionIds.split(",");
			}
	
			long[] rolePermissionId = CommonRequestUtils.getLongParameters(request, "role.rolePermissionSet.rolePermissionId");
			long[] permissionId = CommonRequestUtils.getLongParameters(request, "role.rolePermissionSet.permission");
	
			if (rolePermissionId != null && rolePermissionId.length > 0)
			{
			    int arrayLength = rolePermissionId.length;
			    rolePermissionSet = new HashSet<RolePermission>();
			    for (int i = 0; i < arrayLength; i++)
			    {
					boolean stillChecked = false;
					if (strAddIds != null && strAddIds.length > 0)
					{
					    for (String addId : strAddIds)
					    {
							if (Long.parseLong(addId) == permissionId[i])
							{
							    stillChecked = true;
							    // The Permission is checked so add it to set
							    RolePermission rolePermission = new RolePermission();
							    rolePermission.setRolePermissionId(rolePermissionId[i]);
							    rolePermission.setPermission(permissionService.get(permissionId[i]));
							    rolePermission.setRole(role);
							    rolePermission.setApplication(applicationService.get(Constants.APPLICATION_ID));
							    rolePermissionSet.add(rolePermission);
							    break;
							}
					    }
					}
					
				    if (!stillChecked && rolePermissionId[i] > 0)
				    {
					if (deletedRolePermissionIds.equals(""))
					    deletedRolePermissionIds += rolePermissionId[i];
					else
					    deletedRolePermissionIds += "," + rolePermissionId[i];
				    }
			    }
			}
	    } catch (Exception exception)
	    {
		exception.printStackTrace();
		log.error(exception.getMessage());
	    }

	    // role.setRolePermissionSet(rolePermissionSet);
	    Long tenancyId=(long) 1;
	   
	   
	 
	
	    Role roleObj = roleService.getByName(role.getRole_name(), role.getRoleId());
	
	  
	
	    if (roleObj != null)
	    {
		session.setAttribute("message", roleObj.getRole_name() + " already exists");
	    } else
	    {/*
	    	if(user.getTenancy()!=null){
	    		role.setTenancyId(user.getTenancy().getTenancyId());
	    	}*/
	    	
		role.setTenancyId((long) 1);
	
		
		roleService.save(role, rolePermissionSet, deletedRolePermissionIds);
	    securityMetadataSource.refresh();
		session.setAttribute("message", "Role saved successfully");
	    }
	}

	Role latestRole;
	if (role != null && role.getRoleId()>0)
	{
	    latestRole = roleService.get(role.getRoleId());
	} else
	{
	    latestRole = new Role();
	}

	setPermissionGroups(request, latestRole);
	

	ModelAndView modelandView = new ModelAndView("manageRole");
	modelandView.addObject("role", latestRole);
	return modelandView;
    }

    /**
     * 
     * @param request
     *          current HTTP request
     * @param response
     *          current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Role entries
     */
    @RequestMapping("/role/editRole.do")
    public ModelAndView editRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editRole");
	}

	Role role = null;
	String roleId = request.getParameter("roleId");
	if (roleId != null && roleId.length() > 0)
	{
	    role = roleService.get(Long.parseLong(roleId));
	} else
	{
	    role = new Role();
	}

	setPermissionGroups(request, role);

	return new ModelAndView("manageRole", "role", role);
    }

    private void setPermissionGroups(HttpServletRequest request, Role role) throws ServletException
    {
	List<PermissionGroup> permissionGroupList1 = new ArrayList<PermissionGroup>();
	List<PermissionGroup> permissionGroupList2 = new ArrayList<PermissionGroup>();
	List<PermissionGroup> permissionGroupList3 = new ArrayList<PermissionGroup>();
	List<PermissionGroup> permissionGroupList4 = new ArrayList<PermissionGroup>();
	List listObjects = roleService.getAssociatedPermissionsByRoleId(role.getRoleId());
	long groupId = 0;
	PermissionGroup permissionGroup = null;
	Set<Permission> permissionSet = null;
	List<PermissionGroup> listContents = new ArrayList<PermissionGroup>();
	if (listObjects != null && listObjects.size() > 0)
	{
	    for (int i = 0; i < listObjects.size(); i++)
	    {
		Object object[] = (Object[]) listObjects.get(i);
		long permissionGroupId = Long.parseLong(object[0].toString());
		String permissionGroupName = object[1].toString();
		long permissionId = Long.parseLong(object[2].toString());
		String linkName = object[3].toString();
		long rolePermissionId = Long.parseLong(object[4].toString());

		if (groupId != permissionGroupId)
		{
		    groupId = permissionGroupId;
		    permissionGroup = new PermissionGroup();
		    permissionGroup.setName(permissionGroupName);
		    permissionGroup.setPermissionGroupId(groupId);
		    permissionGroup.setChecked(true);
		    permissionSet = new HashSet<Permission>();
		    permissionGroup.setPermissionSet(permissionSet);
		    listContents.add(permissionGroup);
		}

		if (permissionGroupId == groupId)
		{
		    Permission permission = new Permission();
		    permission.setPermissionGroup(permissionGroup);
		    permission.setPermissionId(permissionId);
		    permission.setLinkName(linkName);
		    if (rolePermissionId == 0)
		    {
			permissionGroup.setChecked(false);
		    }
		    permission.setAssignedRolePermissionId(rolePermissionId);
		    permissionSet.add(permission);
		}
	    }
	}
	int i = 0;
	for (PermissionGroup group : listContents)
	{
	    Set<Permission> hstPermissions = group.getPermissionSet();
	    if (hstPermissions != null && hstPermissions.size() > 0)
	    {
		if (i % 4 == 0)
		{
		    permissionGroupList1.add(group);
		} else if (i % 4 == 1)
		{
		    permissionGroupList2.add(group);
		} else if (i % 4 == 2)
		{
		    permissionGroupList3.add(group);
		} else if (i % 4 == 3)
		{
		    permissionGroupList4.add(group);
		}
		i++;
	    }
	}
	request.setAttribute("permissionGroupList1", permissionGroupList1);
	request.setAttribute("permissionGroupList2", permissionGroupList2);
	request.setAttribute("permissionGroupList3", permissionGroupList3);
	request.setAttribute("permissionGroupList4", permissionGroupList4);
    }

    /**
     * 
     * @param request
     *          current HTTP request
     * @param response
     *          current HTTP response
     * @return a ModelAndView to render the response This method will display list
     *         of Role
     */
    @RequestMapping("/role/listRole.do")
    public ModelAndView listRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listRole");
	}
	RoleSearch searchOptions = new RoleSearch();
	setSearchParameters(searchOptions, request);



	List<Role> RoleList = roleService.getRoleByType(searchOptions);

	try
	{
	    long totalCount = roleService.getRoleCountBySearchOption(searchOptions);
	    request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
	    request.setAttribute("totalCount", totalCount);
	} catch (Exception e)
	{
	    e.printStackTrace();
	    log.error(e.getMessage());
	}

	// Check if the RoleList is null
	if (RoleList == null)
	{
		request.setAttribute("message","No Records Found ");
	    RoleList = new ArrayList<Role>();
	}
	request.setAttribute("currentPage", searchOptions.getCurrentPage());
	request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
	request.setAttribute(const_SortBy, searchOptions.getSortBy());
	request.setAttribute("SearchOptions", searchOptions);

	return new ModelAndView("listRole", "RoleList", RoleList);
    }

    private void setSearchParameters(RoleSearch searchOptions, HttpServletRequest request)
    {
	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
	String orderBy = request.getParameter(const_OrderBy);
	String sortBy = request.getParameter(const_SortBy);

	// setting default order by on role_name
	if (orderBy == null || orderBy.length() < 1)
	{
	    orderBy = "upper(role_name)";
	    sortBy = "asc";
	}

	try
	{
	    searchOptions.setCurrentPage(longCurrentPage);
	    searchOptions.setOrderBy(orderBy);
	    searchOptions.setSortBy(sortBy);

	    searchOptions.setRoleName(request.getParameter("searchRoleName"));
	} catch (Exception err)
	{
	    log.error(err.getMessage());
	}
    }

    /**
     * 
     * @param request
     *          current HTTP request
     * @param response
     *          current HTTP response
     * @return a ModelAndView to render the response This method deletes a Role
     *         entry from database
     */
    @RequestMapping("/role/deleteRole.do")
    public ModelAndView deleteRole(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveRole");
	}
	String roleId = request.getParameter("roleId");
	if (roleId != null && roleId.length() > 0)
	{
	    Role role = roleService.get(Long.parseLong(roleId));
	    if (role != null)
	    {
		try
		{
		    roleService.delete(Long.parseLong(roleId));
		    securityMetadataSource.refresh();
		} catch (Exception e)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editRole(request, response);
		}
		session.setAttribute("message", "Role deleted successfully");
	    }
	}
	return listRole(request, response);
    }
}
