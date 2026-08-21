package com.mars.common.dao.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.PermissionDAO;
import com.mars.common.model.Permission;
import com.mars.common.search.PermissionSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;


/**
 * 
 * <p>
 * Title: PermissionDaoImpl.java
 * </p>
 * 
 * @see com.mars.common.model.Permission <p>
 *      Description: This class is used for hibernate operations for Permission
 *      module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Repository("permissionDAO")
public class PermissionDAOImpl extends HibernateDaoSupport implements PermissionDAO {

  private static final Log log = LogFactory.getLog(PermissionDAOImpl.class);

  /**
   * This method returns Permission object for a given Id
   * 
   * @param id
   *          as long
   * @return Permission as model object
   */
   @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  public Permission get(long id) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("get Method is called " + id);
      }
      return (Permission) getHibernateTemplate().get(Permission.class, new Long(id));
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }
  
  /**
   * This method returns Permission object for a given linkUrl & permissionId
   * 
   * @param linkUrl as String
   * @param permissionId as long
   * @return Permission as model object
   * */
  public Permission getByUrl(String linkUrl, long permissionId) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("getByUrl Method is called on " + linkUrl);
      }
      
      String fromClause = "select permission from Permission permission where upper(permission.linkUrl)=upper(:linkUrl)";
		if(permissionId > 0){
	    	fromClause = fromClause+" and permissionId<>:permissionId";
	    }
	    Query query = getSession().createQuery(fromClause);
	    query.setString("linkUrl", CommonUtils.getEscapedSQLString(linkUrl));
	    if(permissionId > 0)
	    query.setLong("permissionId", permissionId);
	    List list = query.list();

	    if (list != null && list.size() > 0)
	    	return (Permission) list.get(0);
	    else
	    	return null;
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }
  
  /**
   * This method returns Permission object for a given linkName, permissionGroupId & permissionId
   * 
   * @param linkName as String
   * @param permissionGroupId as long
   * @param permissionId as long
   * @return Permission as model object
   */
  public Permission getByNameGroup(String linkName, long permissionGroupId, long permissionId) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("getByNameGroup Method is called on " + linkName);
      }
      
      String fromClause = "select permission from Permission permission where upper(permission.linkName)=upper(:linkName) and " +
      		"permission.permissionGroup.permissionGroupId= :permissionGroupId ";
		if(permissionId > 0){
	    	fromClause = fromClause+" and permissionId<> :permissionId";
	    }
	    Query query = getSession().createQuery(fromClause);
	    query.setString("linkName", CommonUtils.getEscapedSQLString(linkName));
	    query.setLong("permissionGroupId", permissionGroupId);
	    if(permissionId > 0)
	    query.setLong("permissionId", permissionId);
	    List list = query.list();

	    if (list != null && list.size() > 0)
	    	return (Permission) list.get(0);
	    else
	    	return null;
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method save/updates the Permission information to the database.
   * 
   * @param Permission
   *          object
   * 
   */
  public void save(Permission entity) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("save Method is called ");
      }
      getHibernateTemplate().saveOrUpdate(entity);
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      hibernateException.printStackTrace();
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      exception.printStackTrace();
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method is used to delete a record from the database using hibernate.
   * 
   * @param id
   *          as long
   */
  public void delete(long id) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("deleting Permission instance");
      }
      Permission entity = (Permission) getHibernateTemplate().load(Permission.class, new Long(id));
      getHibernateTemplate().delete(entity);
      log.debug("delete successful");
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method will return a list of all Permission from the database
   * 
   * @return List of Permission
   */
  public List<Permission> getAll() {
    try {

      if (log.isDebugEnabled()) {
        log.debug("get all Method is called for Permission");
      }
      return getHibernateTemplate().loadAll(Permission.class);
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method is used to delete a list of Module records from the database.
   * 
   * @param listPermission
   *          as List
   */
  public void deleteAll(List<Permission> listPermission) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("deleteAll Method is called for Permission");
      }
      getHibernateTemplate().deleteAll(listPermission);
      log.debug("deleted successfuly a list of Permission records from database");
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method save/updates a list of Permission information to the database.
   * 
   * @param listPermission
   *          as List
   * 
   */
  public void saveAll(List<Permission> listPermission) {
    try {
      if (log.isDebugEnabled()) {
        log.debug("saveAll Method is called ");
      }
      getHibernateTemplate().saveOrUpdateAll(listPermission);
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      hibernateException.printStackTrace();
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      exception.printStackTrace();
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }

  /**
   * This method returns list of the Permission objects available based page
   * number.
   * 
   * @param long PageNumber
   * @param String
   *          orderBy
   * @param String
   *          sortBy
   * @return List
   * @exception Exception
   */
  public List<Permission> getPermissionList(long pageNumber, String orderBy, String sortBy) {

    try {
      String fromClause = "select permission from Permission permission";
      fromClause = fromClause + " order by " + orderBy + " " + sortBy;
      Query query = getSession().createQuery(fromClause);

      if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
        if (pageNumber > 1) {
          query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
          query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
        } else {
          query.setFirstResult(0);
          query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
        }
      }

      List<Permission> list = query.list();

      if (list != null && list.size() > 0) {
        return list;
      }
      return null;
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }

  }
  
  /**
   * This method returns list of the Permission objects available based page number.
   * 
   * @param PermissionSearch searchOptions
   * @return List
   * @exception Exception
   */
  public List<Permission> getPermissionByType(PermissionSearch searchOptions) {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionByType Method is called");
	  }
	  
	  try {
		  	long pageNumber = searchOptions.getCurrentPage();
	  		String orderBy = searchOptions.getOrderBy();
	  	    String sortBy = searchOptions.getSortBy();
  	        	      	   
	  	    String name = CommonUtils.getEscapedSQLString(searchOptions.getName());
		  	String url = CommonUtils.getEscapedSQLString(searchOptions.getUrl());
		  	long groupId = searchOptions.getGroupId();
  	    
		  	int count = 0;
	  	    StringBuffer sql = new StringBuffer();
	  	    String fromClause = "select permission from Permission permission ";    	    
	  	    List<Permission> list = null;
  	    
	  	    if(name != null && name.length() > 0) {
	  	    	if(count == 0) {
	  	    		count++;
	  	    		sql.append("where ");
	  	    	}
	  	    	else
	  	    		sql.append("and ");
  	    	
	  	    	sql.append("upper(linkName) like :name ");
	    	}
	  	  
		  	if(url != null && url.length() > 0) {
		    	if(count == 0) {
		    		count++;
		    		sql.append("where ");
		    	}
		    	else
		    		sql.append("and ");
		    	
		    	sql.append("upper(linkUrl) like :url ");
	    	}
		  	
		  	if(groupId > 0) {
		  		if(count == 0) {
		    		count++;
		    		sql.append("where ");
		    	}
		    	else
		    		sql.append("and ");
		  	
		  		sql.append("permissionGroup.permissionGroupId=:groupId ");
		  	}
		  		if(count == 0) {
		    		count++;
		    		sql.append("where ");
		    	}
		    	else
		    		sql.append("and ");
		  	
		  		sql.append(" permission.application.applicationId=:applicationId ");
		  	
		  	
		  	sql.insert(0, fromClause).append("order by " + orderBy + " " + sortBy);
    	    
    	    Query query = getSession().createQuery(sql.toString());
    	    query.setInteger("applicationId", Constants.APPLICATION_ID);
    	    if(name != null && name.length() > 0) {
        	    query.setString("name", "%"+name.toUpperCase()+"%");
        	    }
        	    if(url != null && url.length() > 0) {
        	    	  query.setString("url", "%"+url.toUpperCase()+"%");	
        	    }
        	  	if(groupId > 0) {
        	  		 query.setLong("groupId", groupId);
        	  	}
    	    if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
	    		if (pageNumber > 1) {
	    		    query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
	    		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
	    		} else {
	    		    query.setFirstResult(0);
	    		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
	    		}
    	    }
    	    
    	    list = query.list();
    	    if (list != null && list.size() > 0)
    	    {
    		return list;
    	    }
    	    return null;
	  } catch (NullPointerException nullpointerexception) {
	      log.error(nullpointerexception.getStackTrace());
	      throw new NullPointerException();
	    } catch (HibernateException hibernateException) {
	      log.error(hibernateException.getStackTrace());
	      throw new HibernateException(hibernateException.getMessage());
	    } catch (Exception exception) {
	      log.error(exception.getStackTrace());
	      throw new RuntimeException(exception.getCause());
	    }
  }

  /**
   * This method returns count of the Permission objects available based on
   * search criteria.
   * 
   * @return long
   * @exception Exception
   */
  public long getPermissionCount() {
    try {
      String fromClause = "select count(*) from Permission permission";
      Query query = getSession().createQuery(fromClause);
      List list = query.list();

      if (list != null && list.size() > 0) {
        return Long.parseLong(list.get(0).toString());
      }
      return 0;
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
  }
  
  /**
   * This method returns count of the Permission objects from the database
   * 
   * @return PermissionSearch searchOptions
   * @exception Exception
   */
  public long getPermissionCountBySearchOption(PermissionSearch searchOptions) {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionCountBySearchOption Method is called");
	  }
	  
	  try {
		  long pageNumber = searchOptions.getCurrentPage();
	  		String orderBy = searchOptions.getOrderBy();
	  	    String sortBy = searchOptions.getSortBy();
	        	      	   
	  	    String name = CommonUtils.getEscapedSQLString(searchOptions.getName());
		  	String url = CommonUtils.getEscapedSQLString(searchOptions.getUrl());
		  	long groupId = searchOptions.getGroupId();
	    
		  	int count = 0;
	  	    StringBuffer sql = new StringBuffer();
	  	    String fromClause = "select count(*) from Permission permission ";    	    
	  	    List list = null;
	    
	  	  if(name != null && name.length() > 0) {
	  	    	if(count == 0) {
	  	    		count++;
	  	    		sql.append("where ");
	  	    	}
	  	    	else
	  	    		sql.append("and ");
	    	
	  	    	sql.append("upper(linkName) like  :name  ");
	    	}
	  	  
		  	if(url != null && url.length() > 0) {
		    	if(count == 0) {
		    		count++;
		    		sql.append("where ");
		    	}
		    	else
		    		sql.append("and ");
		    	
		    	sql.append("upper(linkUrl) like :url ");
	    	}
		  	
		  	if(groupId > 0) {
		  		if(count == 0) {
		    		count++;
		    		sql.append("where ");
		    	}
		    	else
		    		sql.append("and ");
		  	
		  		sql.append("permissionGroup.permissionGroupId=:groupId ");
		  	}
		  	if(count == 0) {
	    		count++;
	    		sql.append("where ");
	    	}
	    	else
	    		sql.append("and ");
	  	
	  		sql.append(" permission.application.applicationId=:applicationId ");
	  		
		  	sql.insert(0, fromClause);    	    
	  	    Query query = getSession().createQuery(sql.toString());
	  	  query.setInteger("applicationId", Constants.APPLICATION_ID);
	  	  if(name != null && name.length() > 0) {
	    	    query.setString("name", "%"+name.toUpperCase()+"%");
	    	    }
	    	    if(url != null && url.length() > 0) {
	    	    	  query.setString("url", "%"+url.toUpperCase()+"%");	
	    	    }
	    	  	if(groupId > 0) {
	    	  		 query.setLong("groupId", groupId);
	    	  	}
	  	    list = query.list();
	  	    
	  	    if (list != null && list.size() > 0)
	  	    	return Long.parseLong(list.get(0).toString());
	  	    else
	  	    	return 0;
	  } catch (NullPointerException nullpointerexception) {
	      log.error(nullpointerexception.getStackTrace());
	      throw new NullPointerException();
	    } catch (HibernateException hibernateException) {
	      log.error(hibernateException.getStackTrace());
	      throw new HibernateException(hibernateException.getMessage());
	    } catch (Exception exception) {
	      log.error(exception.getStackTrace());
	      throw new RuntimeException(exception.getCause());
	    }
  }

  /**
   * This method is used to permissions and associated roles.
   * 
   * @param Hashtable
   *          of permission and rols
   */
  public Hashtable<String, String> getRolePermissions() {
    Hashtable<String, String> hstPermissionRoles = null;
    try {
      hstPermissionRoles = new Hashtable<String, String>();
      String fromClause = "SELECT LINK_URL,ROLE.ROLE_ID FROM egovcommon.ROLE_PERMISSION, egovcommon.ROLE, egovcommon.PERMISSIONS WHERE ROLE.ROLE_ID = ROLE_PERMISSION.ROLE_ID AND "
          + "ROLE_PERMISSION.PERMISSION_ID = PERMISSIONS.PERMISSION_ID";

      SQLQuery query = getSession().createSQLQuery(fromClause);
      query.addScalar("LINK_URL", Hibernate.STRING);
      query.addScalar("ROLE_ID", Hibernate.LONG);

      List<Object[]> list = query.list();
      for (Object[] obj : list) {
        String strURL = (String) obj[0];
        strURL = strURL.split("\\*")[0];
        long roleId = (Long) obj[1];
        if (hstPermissionRoles.containsKey(strURL)) {
          String strRoles = hstPermissionRoles.get(strURL).toString();
          strRoles = strRoles + ",ROLE_USER_ID_" + roleId;
          hstPermissionRoles.put(strURL, strRoles);
        } else {
          String strRoles = "ROLE_USER_ID_" + roleId;
          hstPermissionRoles.put(strURL, strRoles);
        }
      }
    } catch (NullPointerException nullpointerexception) {
      log.error(nullpointerexception.getStackTrace());
      throw new NullPointerException();
    } catch (HibernateException hibernateException) {
      log.error(hibernateException.getStackTrace());
      throw new HibernateException(hibernateException.getMessage());
    } catch (Exception exception) {
      exception.printStackTrace();
      log.error(exception.getStackTrace());
      throw new RuntimeException(exception.getCause());
    }
    return hstPermissionRoles;
  }

  /**
   * This method is used to permission links for roleIds .
   * 
   * @param Hashtable
   *          of permission and rols
   */
  public Hashtable<String, String> getPermissionsByRoleIds(String roleIds)
    {
    Hashtable<String, String> hstPermissionRoles = null;
    try
    {
        hstPermissionRoles = new Hashtable<String, String>();
        
        String fromClause = "SELECT DISTINCT PERMISSIONS.LINK_URL FROM egovcommon.PERMISSIONS, egovcommon.ROLE_PERMISSION WHERE ROLE_ID IN ("+roleIds+")" +
        		" AND PERMISSIONS.PERMISSION_ID = ROLE_PERMISSION.PERMISSION_ID ORDER BY PERMISSIONS.LINK_URL";

        SQLQuery query = getSession().createSQLQuery(fromClause);
        query.addScalar("LINK_URL", Hibernate.STRING);

        List<Object> list = query.list();
        for (Object object : list)
        {
          String strURL = object.toString();
          strURL= strURL.split("\\*")[0];
          if (hstPermissionRoles.containsKey(strURL))
          {
             hstPermissionRoles.put(strURL, strURL);
          } else
          {
              hstPermissionRoles.put(strURL,strURL );
          }
        }
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
        exception.printStackTrace();
        log.error(exception.getStackTrace());
        throw new RuntimeException(exception.getCause());
    }
    return hstPermissionRoles;
    }

  
 
  public void setDefaultSchema(){
	  try {
	 // String sqlString = "SET search_path to propertysurvey";
	 // Query query = getSession().createSQLQuery(sqlString);
	//  List list = query.list();

	  getSession().connection().prepareStatement("SET search_path to egovaccountsrental").execute();

	  } catch (Exception exception) {
	  log.error(exception.getStackTrace(), exception);
	  exception.printStackTrace();
	  }
	 }
  
	/*@Override
	public Hashtable<String, String> getRolePermissions(long applicationId) {
		 Hashtable<String, String> hstPermissionRoles = null;
		    try {
		      hstPermissionRoles = new Hashtable<String, String>();
		      String fromClause = "SELECT LINK_URL,ROLE.ROLE_ID FROM egovcommon.ROLE_PERMISSION, egovcommon.ROLE, egovcommon.PERMISSIONS ,egovcommon.APPLICATION  "
		      		+ "WHERE ROLE.ROLE_ID = ROLE_PERMISSION.ROLE_ID AND "
		          + "ROLE_PERMISSION.PERMISSION_ID = PERMISSIONS.PERMISSION_ID AND ROLE.APPLICATION_ID=APPLICATION.APPLICATION_ID "
		          + " AND PERMISSIONS.APPLICATION_ID=APPLICATION.APPLICATION_ID AND ROLE_PERMISSION.APPLICATION_ID=APPLICATION.APPLICATION_ID AND APPLICATION.APPLICATION_ID="+applicationId+" ";

		      SQLQuery query = getSession().createSQLQuery(fromClause);
		      query.addScalar("LINK_URL", Hibernate.STRING);
		      query.addScalar("ROLE_ID", Hibernate.LONG);

		      List<Object[]> list = query.list();
		      for (Object[] obj : list) {
		        String strURL = (String) obj[0];
		        strURL = strURL.split("\\*")[0];
		        long roleId = (Long) obj[1];
		        if (hstPermissionRoles.containsKey(strURL)) {
		          String strRoles = hstPermissionRoles.get(strURL).toString();
		          strRoles = strRoles + ",ROLE_USER_ID_" + roleId;
		          hstPermissionRoles.put(strURL, strRoles);
		        } else {
		          String strRoles = "ROLE_USER_ID_" + roleId;
		          hstPermissionRoles.put(strURL, strRoles);
		        }
		      }
		    } catch (NullPointerException nullpointerexception) {
		      log.error(nullpointerexception.getStackTrace());
		      throw new NullPointerException();
		    } catch (HibernateException hibernateException) {
		      log.error(hibernateException.getStackTrace());
		      throw new HibernateException(hibernateException.getMessage());
		    } catch (Exception exception) {
		      exception.printStackTrace();
		      log.error(exception.getStackTrace());
		      throw new RuntimeException(exception.getCause());
		    }
		    return hstPermissionRoles;
	}*/
		  public Hashtable<String, String> getRolePermissions(long applicationId) {
		            Hashtable<String, String> hstPermissionRoles = null;
		               try {
		                 hstPermissionRoles = new Hashtable<String, String>();
		                 String fromClause = "SELECT LINK_URL,ROLE.ROLE_ID FROM egovcommon.ROLE_PERMISSION, egovcommon.ROLE, egovcommon.PERMISSIONS ,egovcommon.APPLICATION  "
		                                 + "WHERE ROLE.ROLE_ID = ROLE_PERMISSION.ROLE_ID AND "
		                     + "ROLE_PERMISSION.PERMISSION_ID = PERMISSIONS.PERMISSION_ID AND ROLE.APPLICATION_ID=APPLICATION.APPLICATION_ID "
		                     + " AND PERMISSIONS.APPLICATION_ID=APPLICATION.APPLICATION_ID AND ROLE_PERMISSION.APPLICATION_ID=APPLICATION.APPLICATION_ID AND APPLICATION.APPLICATION_ID="+applicationId+" ";

		                 SQLQuery query = getSession().createSQLQuery(fromClause);
		                 query.addScalar("LINK_URL", Hibernate.STRING);
		                 query.addScalar("ROLE_ID", Hibernate.LONG);

		                 List<Object[]> list = query.list();
		                 for (Object[] obj : list) {
		                   String strURL = (String) obj[0];
		                   strURL = strURL.split("\\*")[0];
		                   long roleId = (Long) obj[1];
		                   if (hstPermissionRoles.containsKey(strURL)) {
		                     String strRoles = hstPermissionRoles.get(strURL).toString();
		                     strRoles = strRoles + ",ROLE_USER_ID_" + roleId;
		                     hstPermissionRoles.put(strURL, strRoles);
		                   } else {
		                     String strRoles = "ROLE_USER_ID_" + roleId;
		                     hstPermissionRoles.put(strURL, strRoles);
		                   }
		                 }
		               } catch (NullPointerException nullpointerexception) {
		                 log.error(nullpointerexception.getStackTrace());
		                 throw new NullPointerException();
		               } catch (HibernateException hibernateException) {
		                 log.error(hibernateException.getStackTrace());
		                 throw new HibernateException(hibernateException.getMessage());
		               } catch (Exception exception) {
		                 exception.printStackTrace();
		                 log.error(exception.getStackTrace());
		                 throw new RuntimeException(exception.getCause());
		               }
		               return hstPermissionRoles;
		   }


  
	@Override
	public Hashtable<String, String> getPermissionsByRoleIds(String roleIds,long applicationId) {
		Hashtable<String, String> hstPermissionRoles = null;
	    try
	    {
	        hstPermissionRoles = new Hashtable<String, String>();
	        
	        String fromClause = "SELECT DISTINCT PERMISSIONS.LINK_URL FROM egovcommon.PERMISSIONS, egovcommon.ROLE_PERMISSION ,egovcommon.APPLICATION  "
	        		+ "WHERE ROLE_ID IN ("+roleIds+")  AND PERMISSIONS.PERMISSION_ID = ROLE_PERMISSION.PERMISSION_ID  "
	        		+ " AND PERMISSIONS.APPLICATION_ID=APPLICATION.APPLICATION_ID AND ROLE_PERMISSION.APPLICATION_ID=APPLICATION.APPLICATION_ID AND APPLICATION.APPLICATION_ID=:applicationId "
	        		+ "ORDER BY PERMISSIONS.LINK_URL";
	
	        SQLQuery query = getSession().createSQLQuery(fromClause);
	        query.addScalar("LINK_URL", Hibernate.STRING);
	        //query.setParameterList("roleIds", CommonUtils.convertStringIds2Long(roleIds));
	        query.setParameter("applicationId", applicationId);
	
	        List<Object> list = query.list();
	        for (Object object : list)
	        {
	          String strURL = object.toString();
	          strURL= strURL.split("\\*")[0];
	          if (hstPermissionRoles.containsKey(strURL))
	          {
	             hstPermissionRoles.put(strURL, strURL);
	          } else
	          {
	              hstPermissionRoles.put(strURL,strURL );
	          }
	        }
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
	        exception.printStackTrace();
	        log.error(exception.getStackTrace());
	        throw new RuntimeException(exception.getCause());
	    }
	    return hstPermissionRoles;
	}
	
	@Override
	public Hashtable<String, String> getPermissionsByRoleNames(String roleName)
	{
	Hashtable<String, String> hstPermissionRoles = null;
	try
	{
	    hstPermissionRoles = new Hashtable<String, String>();
	 
	    String fromClause= "select distinct p.link_url from egovcommon.permissions p, egovcommon.role_permission rp, "
	    		+ "egovcommon.role r where upper(r.role_name)=upper('"+roleName.trim()+"') and r.role_id=rp.role_id and p.permission_id=rp.permission_id "
	    		+ "order by p.link_url";
	    
	    SQLQuery query = getSession().createSQLQuery(fromClause);
	    query.addScalar("LINK_URL", Hibernate.STRING);

	    List<Object> list = query.list();
	    for (Object object : list)
	    {
	      String strURL = object.toString();
	      strURL= strURL.split("\\*")[0];
	      if (hstPermissionRoles.containsKey(strURL))
	      {
	         hstPermissionRoles.put(strURL, strURL);
	      } else
	      {
	          hstPermissionRoles.put(strURL,strURL );
	      }
	    }
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
	    exception.printStackTrace();
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
	return hstPermissionRoles;
	}
}
