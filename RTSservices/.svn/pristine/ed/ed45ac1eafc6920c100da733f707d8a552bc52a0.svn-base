package com.mars.common.dao.impl;

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

import com.mars.common.dao.UserAttemptsDAO;
import com.mars.common.model.UserAttempts;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;


@Repository("userAttemptsAttemptsDAO")
public class UserAttemptsDAOImpl extends HibernateDaoSupport implements UserAttemptsDAO {
	
private static final Log log = LogFactory.getLog(UserAttemptsDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns UserAttempts object for a given Id
	 * 
	 * @param id
	 *            as long
	 * @return UserAttempts as model object
	 */
	public UserAttempts get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (UserAttempts) getHibernateTemplate().get(UserAttempts.class, new Long(id));
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
	 * This method returns UserAttempts object for a given Id
	 * 
	 * @param userAttemptsName
	 *            as String
	 * @return UserAttempts as model object
	 */
	public UserAttempts get(String userAttemptsName) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with userAttempts name is called " + userAttemptsName);
			}
			List<UserAttempts> userAttemptsList = getHibernateTemplate().find("select userAttempts from UserAttempts userAttempts where upper(userAttempts.userAttemptsName)=upper('" + userAttemptsName + "')");
			if (userAttemptsList != null && userAttemptsList.size() > 0) {
				return userAttemptsList.get(0);
			}
			return null;
			// return (UserAttempts) getHibernateTemplate().findByNamedParam("select userAttempts from UserAttempts userAttempts",
			// "userAttemptsName", userAttemptsName)[0];
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
	 * This method returns UserAttempts object for a given UserAttemptsname & UserAttemptsId
	 * 
	 * @param userAttemptsName
	 *            as String
	 * @param userAttemptsId
	 *            as long
	 * @return UserAttempts as model object
	 */
	public UserAttempts getByName(String userAttemptsName, long userAttemptsId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("getByName Method is called on " + userAttemptsName);
			}

			String fromClause = "select userAttempts from UserAttempts userAttempts where upper(userAttempts.userAttemptsName)=:userAttemptsName ";
			if (userAttemptsId > 0) {
				fromClause = fromClause + " and userAttemptsId<>" + userAttemptsId;
			}

			Query query = getSession().createQuery(fromClause);
			query.setParameter("userAttemptsName", userAttemptsName.toUpperCase());
			List list = query.list();

			if (list != null && list.size() > 0)
				return (UserAttempts) list.get(0);
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
	 * This method save/updates the UserAttempts information to the database.
	 * 
	 * @param UserAttempts
	 *            object
	 * @return
	 * 
	 */
	public void save(UserAttempts entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method with UserAttempts object is called ");
			}

			if (entity.getUserAttemptsId() > 0) {
				UserAttempts userAttempts = get(entity.getUserAttemptsId());
				getHibernateTemplate().evict(userAttempts);
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
	 * This method save/updates the UserAttempts information to the database.
	 * 
	 * @param UserAttempts
	 *            object
	 * @param deleteIds
	 *            as String
	 * @return
	 * 
	 */
	
	
	/**
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id
	 *            as long
	 */
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting UserAttempts instance");
			}
			UserAttempts entity = (UserAttempts) getHibernateTemplate().load(UserAttempts.class, new Long(id));
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
	 * This method will return a list of all UserAttempts from the database
	 * 
	 * @return List of UserAttempts
	 */
	public List<UserAttempts> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for UserAttempts");
			}
			CommonUtils.setFilter(getSession());
			return getHibernateTemplate().loadAll(UserAttempts.class);
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
	 * @param listUserAttempts
	 *            as List
	 */
	public void deleteAll(List<UserAttempts> listUserAttempts) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for UserAttempts");
			}
			getHibernateTemplate().deleteAll(listUserAttempts);
			log.debug("deleted successfuly a list of UserAttempts records from database");
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
	 * This method save/updates a list of UserAttempts information to the database.
	 * 
	 * @param listUserAttempts
	 *            as List
	 * 
	 */
	public void saveAll(List<UserAttempts> listUserAttempts) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listUserAttempts);
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
	 * This method returns list of the UserAttempts objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getUserAttemptsList(long pageNumber, String orderBy, String sortBy) {

		try {
			String fromClause = "select userAttempts from UserAttempts userAttempts";
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

			List<UserAttempts> list = query.list();

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
	 * This method returns list of the UserAttempts objects available based page number.
	 * 
	 * @param UserAttemptsSearch
	 *            searchOptions
	 * @return List
	 * @exception Exception
	 */

	/**
	 * This method returns count of the UserAttempts objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserAttemptsCount() {
		try {
			String fromClause = "select count(*) from UserAttempts userAttempts";
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
	 * This method returns list of the UserAttempts objects available based page number.
	 * 
	 * @param roleName
	 *            as String
	 * @param OfficeId
	 *            as long
	 * @param userAttemptsId
	 *            as long
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getUserAttemptssListByRoleName(String roleName, long OfficeId, long userAttemptsId) {
		try {
			if (roleName != null && roleName.length() > 0) {
				String fromClause = "select userAttemptsRole.userAttempts from UserAttemptsRole userAttemptsRole where " + " userAttemptsRole.role.role_name=:roleName and nvl(to_date(userAttemptsRole.userAttemptsRoleEndDate,'dd/mm/yyyy'),sysdate)>=sysdate ";
				if (userAttemptsId > 0) {
					fromClause = fromClause + "and userAttemptsRole.userAttempts.userAttemptsId<>" + userAttemptsId;
				}
				if (OfficeId > 0) {
					fromClause = fromClause + " and userAttemptsRole.userAttempts.employee.sectionOffice.office.officeId = :OfficeId ";
				}
				Query query = getSession().createQuery(fromClause);
					query.setParameter("roleName", roleName);
					if (OfficeId > 0) {
						query.setParameter("OfficeId", OfficeId);
					}
				
				List<UserAttempts> list = query.list();

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
	 * This method returns UserAttempts object for a Employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public UserAttempts getUserAttemptsByEmployeeId(long employeeId) {
		try {
			String fromClause = "select userAttempts from UserAttempts userAttempts where userAttempts.userAttemptsId= (select emp.userAttempts.userAttemptsId from EmployeeMaster emp where emp.employeeMasterId =:employeeId )";

			Query query = getSession().createQuery(fromClause);
			query.setParameter("employeeId", employeeId);
			List<UserAttempts> list = query.list();

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
	public List<UserAttempts> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
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
	public List<UserAttempts> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(UserAttempts.class);
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

	public List<UserAttempts> findByProperty(String propertyName, Object value) 
	{
		try 
		{
			log.info("finding UserAttempts instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select userAttempts from UserAttempts userAttempts where userAttempts."+ propertyName + "= ?";
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

	public List<UserAttempts> findByCondition(String condition) 
	{
		try 
		{
			log.info("finding UserAttempts instance with condition: "+ condition);
			String queryString = "select userAttempts from UserAttempts userAttempts ";
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
    public UserAttempts merge(UserAttempts userAttempts) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (UserAttempts) getHibernateTemplate().merge(userAttempts);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
  }
	@Override
	public UserAttempts getByUserName(String userName) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("getByUserName Method is called on " + userName);
			}

			String fromClause = "select userAttempts from UserAttempts userAttempts where upper(userAttempts.userName)=:userName )";

			Query query = getSession().createQuery(fromClause);
			query.setParameter("userName", userName.toUpperCase());
			List list = query.list();

			if (list != null && list.size() > 0)
				return (UserAttempts) list.get(0);
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
	@Override
	public void delete(UserAttempts userAttempts) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting UserAttempts instance");
			}
			getHibernateTemplate().delete(userAttempts);
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
	
}
