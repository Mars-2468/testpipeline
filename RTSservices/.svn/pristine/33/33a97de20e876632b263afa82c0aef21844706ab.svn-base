package com.mars.common.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.RoleDAO;
import com.mars.common.model.Role;
import com.mars.common.model.RolePermission;
import com.mars.common.search.RoleSearch;
import com.mars.common.service.RoleService;

/**
 * 
 * <p>
 * Title: RoleServiceImpl.java
 * </p>
 * 
 * @see com.mars.common.model.Role <p>
 *      Description: This class is used for hibernate operations for Role module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService
{

    private static final Log log = LogFactory.getLog(RoleServiceImpl.class);

    @Autowired
    private RoleDAO roleDAO;

    public void setRoleDAO(RoleDAO roleDAO)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("setRoleDAO Method is called ");
	}
	this.roleDAO = roleDAO;
    }

    /**
     * This method is saves the Role object
     * 
     * @param entity  as Role object
     * @param rolePermissionSet set Of role Permissions to Add
     * @param deleteIds as String
     * 
     * @return
     * 
     */
    public void save(Role entity, Set<RolePermission> rolePermissionSet, String deleteIds)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("save Method is called ");
	}

	roleDAO.save(entity, rolePermissionSet, deleteIds);
    }

    /**
     * This method delete the role
     * 
     * @param Id
     *          as long
     * @return
     * 
     */
    public void delete(long id)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("delete Method is called ");
	}
	roleDAO.delete(id);
    }

    /**
     * This method is used to get the Model object from the database using
     * hibernate based on id
     * 
     * @param Id
     *          as long
     * @return a Role Object
     * 
     */
    public Role get(long id)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("get Method is called");
	}
	return roleDAO.get(id);
    }

    /**
     * This method is used to get the Model object from the database using
     * hibernate based on roleName & roleId
     * 
     * @param roleName as String
     * @param roleId as long
     * @return a Role Object
     * 
     */
    public Role getByName(String roleName, long roleId)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getByName Method is called on " + roleName);
	}
	return roleDAO.getByName(roleName, roleId);
    }

    /**
     * This method will return a list of all Role from the database
     * 
     * @return List of Role
     */
    public List<Role> getAll()
    {
	if (log.isDebugEnabled())
	{
	    log.debug("get Method is called");
	}
	return roleDAO.getAll();
    }

    /**
     * This method returns list of the Role objects available based page number.
     * 
     * @param long PageNumber
     * @param String
     *          orderBy
     * @param String
     *          sortBy
     * @return List
     * @exception Exception
     */
    public List<Role> getRoleList(long pageNumber, String orderBy, String sortBy)
    {

	if (log.isDebugEnabled())
	{
	    log.debug("get Method is called");
	}
	return roleDAO.getRoleList(pageNumber, orderBy, sortBy);
    }

    /**
     * This method returns list of the Role objects available based page number.
     * 
     * @param RoleSearch searchOptions
     * @return List
     * @exception Exception
     */
    public List<Role> getRoleByType(RoleSearch searchOptions)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getRoleByType Method is called");
	}

	return roleDAO.getRoleByType(searchOptions);
    }

    /**
     * This method returns count of the Role objects available based on search
     * criteria.
     * 
     * @return long
     * @exception Exception
     */
    public long getRoleCount()
    {
	if (log.isDebugEnabled())
	{
	    log.debug("saveAll Method is called");
	}
	return roleDAO.getRoleCount();
    }

    /**
     * This method returns count of the Role objects from the database
     * 
     * @return RoleSearch searchOptions
     * @exception Exception
     */
    public long getRoleCountBySearchOption(RoleSearch searchOptions)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getRoleCountBySearchOption Method is called");
	}

	return roleDAO.getRoleCountBySearchOption(searchOptions);
    }

    /**
     * This method save/updates a list of Role information to the database.
     * 
     * @param listRole
     *          as List
     * 
     */
    public void saveAll(List<Role> listRole)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("saveAll Method is called");
	}
	roleDAO.saveAll(listRole);
    }

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listRole
     *          as List
     */
    public void deleteAll(List<Role> listRole)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("deleteAll Method is called");
	}
	roleDAO.deleteAll(listRole);
    }

    /**
     * This method returns count of the Role objects from the database
     * @param roleId as long
     * @return list of objects
     * @exception Exception
     */
    public List<Object> getAssociatedPermissionsByRoleId(long roleId)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getAssociatedPermissionsByRoleId Method is called");
	}
	return roleDAO.getAssociatedPermissionsByRoleId(roleId);
    }
    
    /**
     * This method returns Role object from the database
     * 
     * @param roleName
     * @return
     */
	public Role getByRoleName(String roleName)
	{
	if (log.isDebugEnabled())
	{
	    log.debug("getByRoleName Method is called");
	}
	return roleDAO.getByRoleName(roleName);
    }
}
