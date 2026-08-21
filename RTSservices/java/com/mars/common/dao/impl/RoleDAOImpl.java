package com.mars.common.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.RoleDAO;
import com.mars.common.model.Role;
import com.mars.common.model.RolePermission;
import com.mars.common.search.RoleSearch;
import com.mars.common.utils.Constants;

/**

 * <p>Title: RoleDaoImpl.java </p>

 * @see com.monsanto.common.model.Role
 
 * <p>Description: This class is used for hibernate operations for Role module</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("RoleDAO")
public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO
{

    private static final Log log = LogFactory.getLog(RoleDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
    /**
     * This method returns Role object for a given Id
     * 
     * @param id as long
     * @return Role as model object
     */
    public Role get(long id)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("get Method is called " + id);
	    }
	    return (Role) getHibernateTemplate().get(Role.class, new Long(id));
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method returns Role object for a given Role name & Role Id
     * 
     * @param roleName as String
     * @param roleId as long
     * @return Role as model object
     */
    public Role getByName(String roleName, long roleId)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("get Method is called on " + roleName);
	    }

	    String fromClause = "select role from Role role where upper(role.role_name)=upper('" + roleName + "')";
	    if (roleId > 0)
	    {
		fromClause = fromClause + " and roleId<>" + roleId;
	    }
	    Query query = getSession().createQuery(fromClause);
	    List list = query.list();

	    if (list != null && list.size() > 0)
		return (Role) list.get(0);
	    else
		return null;
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method save/updates the Role information to the database.
     * 
     * @param entity as Role object
     * @param rolePermissionSet set Of role Permissions to Add
     * @param deleteIds as String
     * @return
     * 
     */
    public void save(Role entity, Set<RolePermission> rolePermissionSet, String deleteIds)
    {
	try
	{
	    long roleId = entity.getRoleId();
	    if (log.isDebugEnabled())
	    {
		log.debug("save Method is called ");
	    }
	    if (roleId>0)
	    {
		if (deleteIds != null && deleteIds.length() > 0 && !deleteIds.equalsIgnoreCase("undefined"))
		{
		    String strIds[] = deleteIds.split(",");
		    for (String deleteId : strIds)
		    {
			RolePermission rolePermission = getRolePermission(Long.parseLong(deleteId));
			if (rolePermission != null)
			{
			    getHibernateTemplate().delete(rolePermission);
			}
		    }
		}
		Role role = get(entity.getRoleId());
		getHibernateTemplate().evict(role);
		getHibernateTemplate().flush();
	    }
	    getHibernateTemplate().saveOrUpdate(entity);
	    
	    //Add Role PErmissiosn separately not as part of Role
	    if (rolePermissionSet != null && rolePermissionSet.size() > 0)
	    {
		for (RolePermission rolePermission : rolePermissionSet)
		{
		    //If Its new permission then only add else leave it as it is already there in DB
		    if (rolePermission.getRolePermissionId() == 0)
		    {
			if(roleId==0){
			    rolePermission.setRole(entity);
			}
			getHibernateTemplate().save(rolePermission);
		    }
		}
	    }

	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    hibernateException.printStackTrace();
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    exception.printStackTrace();
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    private RolePermission getRolePermission(long id)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("get Method is called " + id);
	    }
	    return (RolePermission) getHibernateTemplate().get(RolePermission.class, new Long(id));
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method is used to delete a record from the database using hibernate.
     * 
     * @param id as long
     */
    public void delete(long id)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("deleting Role instance");
	    }
	    Role entity = (Role) getHibernateTemplate().load(Role.class, new Long(id));
	    getHibernateTemplate().delete(entity);
	    log.debug("delete successful");
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method will return a list of all Role from the database
     * 
     * @return List of Role
     */
    public List<Role> getAll()
    {
	try
	{

	    if (log.isDebugEnabled())
	    {
		log.debug("get all Method is called for Role");
	    }
	    return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Role.class).addOrder(Order.asc("role_name").ignoreCase()).list();
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listRole as List
     */
    public void deleteAll(List<Role> listRole)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("deleteAll Method is called for Role");
	    }
	    getHibernateTemplate().deleteAll(listRole);
	    log.debug("deleted successfuly a list of Role records from database");
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method save/updates a list of Role information to the database.
     * 
     * @param listRole as List
     * 
     */
    public void saveAll(List<Role> listRole)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("saveAll Method is called ");
	    }
	    getHibernateTemplate().saveOrUpdateAll(listRole);
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    hibernateException.printStackTrace();
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    exception.printStackTrace();
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method returns list of the Role objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Role> getRoleList(long pageNumber, String orderBy, String sortBy)
    {

	try
	{
	    String fromClause = "select role from Role role";
	    fromClause = fromClause + " order by " + orderBy + " " + sortBy;
	    Query query = getSession().createQuery(fromClause);

	    if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue())
	    {
		if (pageNumber > 1)
		{
		    query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
		} else
		{
		    query.setFirstResult(0);
		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
		}
	    }

	    List<Role> list = query.list();

	    if (list != null && list.size() > 0)
	    {
		return list;
	    }
	    return null;
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
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

	try
	{
	    long pageNumber = searchOptions.getCurrentPage();
	    String orderBy = searchOptions.getOrderBy();
	    String sortBy = searchOptions.getSortBy();

	    String roleName = searchOptions.getRoleName();

	    int count = 0;
	    StringBuffer sql = new StringBuffer();
	    String fromClause = "select role from Role role ";
	    List<Role> list = null;

	    if (roleName != null && !"".equals(roleName))
	    {
		sql.append("where ");
		sql.append("upper(role_name) like '%" + roleName.toUpperCase() + "%' ");
	    }

	    sql.insert(0, fromClause).append("order by " + orderBy + " " + sortBy);

	    Query query = getSession().createQuery(sql.toString());

		/*
		 * if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) { if
		 * (pageNumber > 1) { query.setFirstResult((int) ((pageNumber - 1) *
		 * Constants.DEFAULT_ROWS_PER_PAGE));
		 * query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue()); } else {
		 * query.setFirstResult(0);
		 * query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue()); //
		 * query.setMaxResults(20); } }
		 */

	    list = query.list();

	    if (list != null && list.size() > 0)
	    {
		return list;
	    }
	    return null;
	    
	   
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method returns count of the Role objects available based on search criteria.
     * 
     * @return long
     * @exception Exception
     */
    public long getRoleCount()
    {
	try
	{
	    String fromClause = "select count(*) from Role role";
	    Query query = getSession().createQuery(fromClause);
	    List list = query.list();

	    if (list != null && list.size() > 0)
	    {
		return Long.parseLong(list.get(0).toString());
	    }
	    return 0;
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
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

	try
	{
	    long pageNumber = searchOptions.getCurrentPage();
	    String orderBy = searchOptions.getOrderBy();
	    String sortBy = searchOptions.getSortBy();

	    String roleName = searchOptions.getRoleName();

	    int count = 0;
	    StringBuffer sql = new StringBuffer();
	    String fromClause = "select count(*) from Role role ";
	    List list = null;

	    if (roleName != null && roleName.length() > 0)
	    {
		sql.append("where ");
		sql.append("role_name like '%" + roleName + "%' ");
	    }

	    sql.insert(0, fromClause);
	    Query query = getSession().createQuery(sql.toString());
	    list = query.list();

	    if (list != null && list.size() > 0)
		return Long.parseLong(list.get(0).toString());
	    else
		return 0;
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
    }

    /**
     * This method returns count of the Role objects from the database
     * @param roleId as long
     * @return list of objects
     * @exception Exception
     */
    public List<Object> getAssociatedPermissionsByRoleId(long roleId)
    {
	String fromClause = null;
	if (roleId > 0)
	{
	    fromClause = "SELECT PERMISSION_GROUP_ID,NAME,PERMISSION_ID,LINK_NAME,ROLE_PERMISSION_ID FROM "
		    + "( SELECT PERMISSION_GROUP.PERMISSION_GROUP_ID,PERMISSION_GROUP.NAME,PERMISSIONS.PERMISSION_ID,PERMISSIONS.LINK_NAME,0 AS ROLE_PERMISSION_ID FROM egovcommon.PERMISSIONS,egovcommon.PERMISSION_GROUP "
		    + " WHERE PERMISSIONS.PERMISSION_GROUP_ID = PERMISSION_GROUP.PERMISSION_GROUP_ID  " + " AND PERMISSIONS.PERMISSION_ID NOT IN "
		    + "(SELECT PERMISSION_ID FROM egovcommon.ROLE_PERMISSION WHERE ROLE_ID=" + roleId + " )" + " UNION "
		    + "SELECT PERMISSION_GROUP.PERMISSION_GROUP_ID,PERMISSION_GROUP.NAME,PERMISSIONS.PERMISSION_ID,PERMISSIONS.LINK_NAME,ROLE_PERMISSION.ROLE_PERMISSION_ID FROM egovcommon.PERMISSIONS, "
		    + "egovcommon.ROLE_PERMISSION, egovcommon.PERMISSION_GROUP WHERE PERMISSIONS.PERMISSION_GROUP_ID = PERMISSION_GROUP.PERMISSION_GROUP_ID "
		    + " AND PERMISSIONS.PERMISSION_ID = ROLE_PERMISSION.PERMISSION_ID AND ROLE_ID=" + roleId + " ) as a"
		    + " GROUP BY PERMISSION_GROUP_ID,NAME,PERMISSION_ID,LINK_NAME,ROLE_PERMISSION_ID ORDER BY upper(NAME) ASC";

	} else
	{
	    fromClause = "SELECT PERMISSION_GROUP_ID,NAME,PERMISSION_ID,LINK_NAME,ROLE_PERMISSION_ID FROM (SELECT PERMISSION_GROUP.PERMISSION_GROUP_ID,PERMISSION_GROUP.NAME,PERMISSIONS.PERMISSION_ID,PERMISSIONS.LINK_NAME,0 AS ROLE_PERMISSION_ID FROM egovcommon.PERMISSIONS,egovcommon.PERMISSION_GROUP "
		    + " WHERE PERMISSIONS.PERMISSION_GROUP_ID = PERMISSION_GROUP.PERMISSION_GROUP_ID ) as PERM GROUP BY PERMISSION_GROUP_ID,NAME,PERMISSION_ID,LINK_NAME,ROLE_PERMISSION_ID ORDER BY NAME ASC";
	}
	SQLQuery query = getSession().createSQLQuery(fromClause);
	query.addScalar("PERMISSION_GROUP_ID", Hibernate.LONG);
	query.addScalar("NAME", Hibernate.STRING);
	query.addScalar("PERMISSION_ID", Hibernate.LONG);
	query.addScalar("LINK_NAME", Hibernate.STRING);
	query.addScalar("ROLE_PERMISSION_ID", Hibernate.LONG);
	List<Object> list = query.list();
	return list;
    }
    
    /**
     * This method returns Role object from the database
     * 
     * @param roleName
     * @return
     */
	public Role getByRoleName(String roleName)
	{
		try
		{
		    String fromClause = "select role from Role role where upper(role.role_name)=upper('"+roleName+"')";
		    		    		    
		    Query query = getSession().createQuery(fromClause);
	
		    List<Role> list = query.list();
	
		    if (list != null && list.size() > 0)
		    {
			return list.get(0);
		    }
		    return null;
		} catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
	}
    
}
