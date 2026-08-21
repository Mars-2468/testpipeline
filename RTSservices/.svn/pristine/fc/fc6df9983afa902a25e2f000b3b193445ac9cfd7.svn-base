package com.mars.common.dao.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.UserDAO;
import com.mars.common.model.User;
import com.mars.common.model.UserRole;
import com.mars.common.search.UserSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * 
 * <p>
 * Title: UserDaoImpl.java
 * </p>
 * 
 * @see com.mars.common.model.User <p>
 *      Description: This class is used for hibernate operations for User module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Repository("UserDAO")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static final Log log = LogFactory.getLog(UserDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns User object for a given Id
	 * 
	 * @param id
	 *            as long
	 * @return User as model object
	 */
	public User get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (User) getHibernateTemplate().get(User.class, new Long(id));
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
	 * This method returns User object for a given Id
	 * 
	 * @param userName
	 *            as String
	 * @return User as model object
	 */
	public User get(String userName) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with user name is called " + userName);
			}
			List<User> userList = getHibernateTemplate().find("select user from User user where upper(user.userName)=upper('" + userName + "')");
			if (userList != null && userList.size() > 0) {
				return userList.get(0);
			}
			return null;
			// return (User) getHibernateTemplate().findByNamedParam("select user from User user",
			// "userName", userName)[0];
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
	 * This method returns User object for a given Username & UserId
	 * 
	 * @param userName
	 *            as String
	 * @param userId
	 *            as long
	 * @return User as model object
	 */
	public User getByName(String userName, long userId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("getByName Method is called on " + userName);
			}

			String fromClause = "select user from User user where upper(user.userName)=upper('" + userName + "')";
			if (userId > 0) {
				fromClause = fromClause + " and userId<>" + userId;
			}

			Query query = getSession().createQuery(fromClause);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (User) list.get(0);
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
	 * This method save/updates the User information to the database.
	 * 
	 * @param User
	 *            object
	 * @return
	 * 
	 */
	public void save(User entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method with User object is called ");
			}

			if (entity.getUserId() > 0) {
				User user = get(entity.getUserId());
				getHibernateTemplate().evict(user);
				getHibernateTemplate().flush();
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
	 * This method save/updates the User information to the database.
	 * 
	 * @param User
	 *            object
	 * @param deleteIds
	 *            as String
	 * @return
	 * 
	 */
	public void save(User entity, String deleteIds) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method with User and Roles is called ");
			}

			if (entity.getUserId() > 0) {
				if (deleteIds != null && deleteIds.length() > 0 && !deleteIds.equalsIgnoreCase("undefined")) {
					String strIds[] = deleteIds.split(",");
					for (String deleteId : strIds) {
						UserRole userRole = getUserRole(Long.parseLong(deleteId));
						if (userRole != null) {
							getHibernateTemplate().delete(userRole);
						}
					}
				}
				User user = get(entity.getUserId());
				getHibernateTemplate().evict(user);
				getHibernateTemplate().flush();
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

	private UserRole getUserRole(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (UserRole) getHibernateTemplate().get(UserRole.class, new Long(id));
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
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id
	 *            as long
	 */
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting User instance");
			}
			User entity = (User) getHibernateTemplate().load(User.class, new Long(id));
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
	 * This method will return a list of all User from the database
	 * 
	 * @return List of User
	 */
	public List<User> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for User");
			}
			return getHibernateTemplate().loadAll(User.class);
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
	 * @param listUser
	 *            as List
	 */
	public void deleteAll(List<User> listUser) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for User");
			}
			getHibernateTemplate().deleteAll(listUser);
			log.debug("deleted successfuly a list of User records from database");
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
	 * This method save/updates a list of User information to the database.
	 * 
	 * @param listUser
	 *            as List
	 * 
	 */
	public void saveAll(List<User> listUser) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listUser);
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
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUserList(long pageNumber, String orderBy, String sortBy) {

		try {
			String fromClause = "select user from User user";
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

			List<User> list = query.list();

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
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param UserSearch
	 *            searchOptions
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUserByType(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserByType Method is called");
		}

		try {
			long pageNumber = searchOptions.getCurrentPage();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();
			
			StringBuffer sql = getHqlQueryOnSearch(searchOptions);
			String fromClause = "select user from User user ";
			List<User> list = null;			

			sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);

			Query query = getSession().createQuery(sql.toString());

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

			return list;
		} catch (NullPointerException nullpointerexception) {
			nullpointerexception.printStackTrace();
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
	 * This method returns count of the User objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserCount() {
		try {
			String fromClause = "select count(*) from User user";
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
	 * This method returns count of the User objects from the database
	 * 
	 * @param UserSearch
	 *            searchOptions
	 * @return long
	 * @exception Exception
	 */
	public long getUserCountBySearchOption(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserCountBySearchOption Method is called");
		}

		try {
			StringBuffer sql = getHqlQueryOnSearch(searchOptions);
			String fromClause = "select count(*) from User user ";
			List list = null;

			sql.insert(0, fromClause);
			Query query = getSession().createQuery(sql.toString());
			list = query.list();

			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		} catch (NullPointerException nullpointerexception) {
			nullpointerexception.printStackTrace();
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
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param roleName
	 *            as String
	 * @param OfficeId
	 *            as long
	 * @param userId
	 *            as long
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUsersListByRoleName(String roleName, long OfficeId, long userId) {
		try {
			if (roleName != null && roleName.length() > 0) {
				String fromClause = "select userRole.user from UserRole userRole where " + " userRole.role.role_name='" + roleName + 
				"' and nvl(to_date(userRole.userRoleEndDate,'dd/mm/yyyy'),sysdate)>=sysdate ";
				if (userId > 0) {
					fromClause = fromClause + "and userRole.user.userId<>" + userId;
				}
				if (OfficeId > 0) {
					fromClause = fromClause + " and userRole.user.employee.sectionOffice.office.officeId = " + OfficeId;
				}
				Query query = getSession().createQuery(fromClause);

				List<User> list = query.list();

				if (list != null && list.size() > 0) {
					return list;
				}
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
	 * This method returns User object for a Employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public User getUserByEmployeeId(long employeeId) {
		try {
			String fromClause = "select user from User user where user.userId= (select emp.user.userId from EmployeeMaster emp where emp.employeeMasterId = "+employeeId+")";

			Query query = getSession().createQuery(fromClause);

			List<User> list = query.list();

			if (list != null && list.size() > 0) {
				return list.get(0);
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
	 * This method returns list of Grievance objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<User> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
    {
		try
	  	{
		    Query queryObject = getSession().getNamedQuery(namedQuery);
			if(hstKeyValues!=null && hstKeyValues.size()>0)
			{
				Enumeration<String> enumeration = hstKeyValues.keys();
				while(enumeration.hasMoreElements())
				{
				    String strKey = enumeration.nextElement();
				    queryObject.setParameter(strKey,hstKeyValues.get(strKey));
				}
			}
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

    /**
	 * This method returns list of Grievance objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<User> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		try{
			if (log.isDebugEnabled())
			{
		    	log.debug("getEntitytListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			query.addEntity(User.class);
			return query.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }

    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		try{
			List<ArrayList> listContents = null;
			if (log.isDebugEnabled())
			{
		    	log.debug("getListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			List listQueryData = query.list();

			if(listQueryData!=null && listQueryData.size()>0)
			{
				listContents = new ArrayList<ArrayList>();

				//Adding Columns Names to the list
				String strColumnNames[] = query.getReturnAliases();
				ArrayList<Object> listColumns = new ArrayList<Object>();
				for(int k=0;k<strColumnNames.length;k++)
				{
					listColumns.add(strColumnNames[k]);
				}
				listContents.add(listColumns);

				// Adding data to the list
				for(int i=0;i<listQueryData.size();i++)
				{
					ArrayList<Object> listData = new ArrayList<Object>();
					Object[] objectArray = (Object[])listQueryData.get(i);
					for(int j=0;j<objectArray.length;j++)
					{
						if(objectArray[j] instanceof Integer )
							listData.add(Integer.parseInt(objectArray[j].toString()));
						else if (objectArray[j] instanceof Long )
							listData.add(Long.parseLong(objectArray[j].toString()));
						else if(objectArray[j] instanceof Double )
							listData.add(Double.parseDouble(objectArray[j].toString()));
						else
							listData.add(objectArray[j].toString());

						listContents.add(listData);
					}
				}
			}
			return listContents;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }	

	public List<User> findByProperty(String propertyName, Object value) 
	{
		try 
		{
			log.info("finding User instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select user from User user where user."+ propertyName + "= ? order by user.firstName ASC";
			if(!propertyName.contains("tenancy") ){
				CommonUtils.setFilter(getSession());
			}
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace());
			exception.printStackTrace();
		}
		return null;
	}

	public List<User> findByCondition(String condition) 
	{
		try 
		{
			log.info("finding User instance with condition: "+ condition);
			String queryString = "select user from User user ";
			if(condition != null && condition.length() > 0)
				queryString = queryString + " where " +condition;
		    Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace());
			exception.printStackTrace();
		}
		return null;
	}	
    public User merge(User user) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (User) getHibernateTemplate().merge(user);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
  }
    
    private StringBuffer getHqlQueryOnSearch(UserSearch searchOptions){
    	
		String username = searchOptions.getUsername();
		String firstName = searchOptions.getFirstName();
		String middleName = searchOptions.getMiddleName();
		String lastName = searchOptions.getLastName();
		long designationId = searchOptions.getDesignationId();
		long departmentId = searchOptions.getDepartmentId();
		long applicationId = searchOptions.getApplicationId();
		String applicationName = searchOptions.getApplicationName();
		long tenancyId=searchOptions.getTenancyId();
		long sectionId=searchOptions.getSectionId();

		StringBuffer sql = new StringBuffer();
		int count = 0;
		
		/*if (applicationId > 0) {
			count++;
			sql.append("inner join user.userApplicationSet userApplication where userApplication.application.applicationId=" + applicationId + " ");
		}*/
		
		if (applicationName != null && applicationName.length() > 0 && applicationId == 0) {
			count++;

			sql.append("inner join user.userApplicationSet userApplication where userApplication.application.name like '%" + applicationName + "%' ");
		}	
		
		if (username != null && username.length() > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(user.userName) like upper('%" + username + "%') ");
		}

		if (firstName != null && firstName.length() > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(user.firstName) like upper('%" + firstName + "%') ");
		}
		
		if (middleName != null && middleName.length() > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(user.middleName) like upper('%" + middleName + "%') ");
		}

		if (lastName != null && lastName.length() > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(user.lastName) like upper('%" + lastName + "%') ");
		}

		if (designationId > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("user.designation.designationId=" + designationId + " ");
		}
		if (departmentId> 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("user.department.departmentId=" + departmentId + " ");
		}
		if(tenancyId>0){
			
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");
		   sql.append("user.tenancy.tenancyId="+tenancyId+" ");
		}
		if(sectionId>0){
			
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");
		   sql.append("user.section.sectionId="+sectionId+" ");
		}
		return sql;
    }
    
    public long saveToDb(String a) {
		int i=0;
		try {

				String sqlString = a;
				Query query = getSession().createSQLQuery(sqlString);
				Statement st=getSession().connection().createStatement();
				i= st.executeUpdate(sqlString);
				  
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
			//	sample.setErrorMessgeDetails(exception.getMessage());
				
				exception.printStackTrace();
			}
			return i;
	}
	@Override
	public List<User> getUserListForWorkFlow(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserByType Method is called");
		}
		String username = searchOptions.getUsername();
		String firstName = searchOptions.getFirstName();
		String middleName = searchOptions.getMiddleName();
		String lastName = searchOptions.getLastName();
		long designationId = searchOptions.getDesignationId();
		long departmentId = searchOptions.getDepartmentId();
		long applicationId = searchOptions.getApplicationId();
		String applicationName = searchOptions.getApplicationName();
		try {
			long pageNumber = searchOptions.getCurrentPage();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();
			StringBuffer sql = getHqlQueryOnSearch(searchOptions);
			String fromClause = "select user from User user ";
			List<User> list = null;		
			
			sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);

			Query query = getSession().createQuery(sql.toString());
			if (applicationId > 0) {
				query.setLong("applicationId", applicationId);
			}
			if (applicationName != null && applicationName.length() > 0 && applicationId == 0) {
				query.setString("applicationName", "%"+applicationName.toUpperCase()+"%");	
			}
			if (username != null && username.length() > 0) {
				query.setString("username", "%"+username.toUpperCase()+"%");	

			}
			if (firstName != null && firstName.length() > 0) {
				query.setString("firstName", "%"+firstName.toUpperCase()+"%");	
			}
			if (middleName != null && middleName.length() > 0) {
				query.setString("middleName", "%"+middleName.toUpperCase()+"%");	
			}
			if (lastName != null && lastName.length() > 0) {
				query.setString("lastName", "%"+lastName.toUpperCase()+"%");	
			}
			if (designationId > 0) {
				query.setLong("designationId", designationId);			}
			if (departmentId> 0) {
				query.setLong("departmentId", departmentId);
			}

			list = query.list();
			if(list!=null && list.size()>0)
				return list;
			else
				return null;
		} catch (NullPointerException nullpointerexception) {
			nullpointerexception.printStackTrace();
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
	
	
	@Override
	 public List<User> getUserByApplication(int applicationId) {
	 	if (log.isDebugEnabled()) {
	 		log.debug("getUserByApplication Method is called");
	 	}
	 	try {
	 		String usertype="E";
	 		StringBuffer sql = new StringBuffer();
	 		if (applicationId > 0) {
	 			/*sql.append("inner join user.userApplicationSet userApplication where userApplication.application.applicationId=:applicationId");*/
	 			sql.append("inner join user.userRoleSet userRole where userRole.application.applicationId=:applicationId and userRole.user.userType=:usertype");
	 		}
	 		String fromClause = "select user from User user ";
	 		List<User> list = null;	
	 		sql.insert(0, fromClause);
	 		CommonUtils.setFilter(getSession());
	 		Query query = getSession().createQuery(sql.toString());
	 		if (applicationId > 0) {
	 			query.setInteger("applicationId", applicationId);
	 		}
	 		if(usertype != null){
	 			query.setString("usertype", usertype);
	 		}
	 		
	 		list = query.list();
	 		return list;
	 	} catch (NullPointerException nullpointerexception) {
	 		nullpointerexception.printStackTrace();
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
}
