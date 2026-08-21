package com.mars.common.dao.impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

import com.mars.common.dao.ZoneMasterDAO;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.ZoneMasterSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: ZoneMasterDaoImpl.java </p>

 * @see com.mars.common.model.ZoneMaster
 
 * <p>Description: This class is used for hibernate operations for ZoneMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("ZoneMasterDAO")
public class ZoneMasterDAOImpl extends HibernateDaoSupport implements ZoneMasterDAO {

    private static final Log log = LogFactory.getLog(ZoneMasterDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns ZoneMaster object for a given Id
	 * 
	 * @param id as long
	 * @return ZoneMaster as model object
	 */
	public ZoneMaster get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (ZoneMaster) getHibernateTemplate().get(ZoneMaster.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the ZoneMaster information to the database.
	 * 
	 * @param ZoneMaster object
	 * 
	 */
	public void save(ZoneMaster entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
	}
    
     /**
	 * This method to merge the ZoneMaster information to the database.
	 * 
	 * @param ZoneMaster object
	 * 
	 */
    public ZoneMaster merge(ZoneMaster entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (ZoneMaster) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
  }
    
    /**
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id as long
	 */
    public void delete(long id) {
        try {
    		if(log.isDebugEnabled()){
        		log.debug("deleting ZoneMaster instance");
        	}
        	ZoneMaster entity = (ZoneMaster) getHibernateTemplate().load(ZoneMaster.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all ZoneMaster from the database
	 * 
	 * @return List of ZoneMaster
	 */
	public List<ZoneMaster> getAll() {
		try {
			String fromClause = "select zoneMaster from ZoneMaster zoneMaster order by zoneMaster.zoneId asc";
//			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			List<ZoneMaster> list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
	    	
	    	PrintWriter pw=null;
			try {
				pw = new PrintWriter(new File("/root/Desktop/ZoneExceptionTxt.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	exception.printStackTrace(pw);
			pw.close();
		}
		return null;
	}
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listZoneMaster as List
     */
    public void deleteAll(List<ZoneMaster> listZoneMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for ZoneMaster");
	    	}
	    	getHibernateTemplate().deleteAll(listZoneMaster);
	    	log.debug("deleted successfuly a list of ZoneMaster records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of ZoneMaster information to the database.
     * 
     * @param listZoneMaster as List
     * 
     */
    public void saveAll(List<ZoneMaster> listZoneMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listZoneMaster);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the ZoneMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getZoneMasterList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select zoneMaster from ZoneMaster zoneMaster";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			
			List<ZoneMaster> list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method returns list of the ZoneMaster objects available based On Search
	 * 
	 * @param searchZoneMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getZoneMasterListBySearch(ZoneMasterSearch searchZoneMaster){
		if(log.isDebugEnabled()){
			log.debug("getZoneMasterListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchZoneMaster.getCurrentPage();
			String orderBy=searchZoneMaster.getOrderBy();
			String sortBy=searchZoneMaster.getSortBy();
		/*	
			String name=CommonUtils.getEscapedSQLString(searchZoneMaster.getName());
			long stateId=searchZoneMaster.getStateId();
			*/
			StringBuffer sql=new StringBuffer();
			String fromClause="select zoneMaster from ZoneMaster zoneMaster";
			List<ZoneMaster> list=null;
			boolean flag=false;
			
			/*if((name!=null && name.length()>0)){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(zoneMaster.name) like upper('%"+ name +"%')");
			}
			
			if(stateId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				 
				   sql.append("zoneMaster.state.stateId=" +stateId);
			}*/
			sql.insert(0, fromClause).append(" order by " + orderBy +" " +sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			list=query.list();
			return list;
		}catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			nullpointerexception.printStackTrace();
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
	 * This method returns count of the ZoneMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getZoneMasterCount(){
	    try {
			String fromClause = "select count(*) from ZoneMaster zoneMaster";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();
			
			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * This method returns count of the ZoneMaster objects available based on search criteria.
	 * @param searchZoneMaster
	 * @return long
	 * @exception Exception
	 */
    public long getZoneMasterCountBySearch(ZoneMasterSearch searchZoneMaster){
    	if(log.isDebugEnabled()){
    		log.debug("getZoneMasterCountBySearch Method is called");
    	}
    	
    	try{
    		
    		/*String name=CommonUtils.getEscapedSQLString(searchZoneMaster.getName());
    		long stateId=searchZoneMaster.getStateId();
    		*/
    		StringBuffer sql=new StringBuffer();
    		String fromClause="select count(zoneMaster) from ZoneMaster zoneMaster";
    		List list=null;
    		boolean flag=false;
    		
    		/*if(name!=null && name.length()>0){
    			if(!flag){
    				flag=true;
    				sql.append(" where ");
    			}else
    				sql.append(" and ");
    			
    			    sql.append("upper(zoneMaster.name) like upper('%"+ name +"%')");
    		} 
    		
    		if(stateId>0){
    			if(!flag){
    				flag=true;
    				sql.append(" where ");
    			}else
    				sql.append(" and ");
               
    			    sql.append("zoneMaster.state.stateId=" + stateId);
    		}*/
    		sql.insert(0, fromClause);
    		Query query=getSession().createQuery(sql.toString());
    		list=query.list();
    		
    		if (list != null && list.size() > 0)
    			return Long.parseLong(list.get(0).toString());
    		else
    			return 0;
    		
    	}catch (NullPointerException nullpointerexception) {
    		log.error(nullpointerexception.getStackTrace());
    		throw new NullPointerException();
    	} catch (HibernateException hibernateException) {
    		log.error(hibernateException.getStackTrace());
    		throw new HibernateException(hibernateException.getMessage());
    	} catch (Exception exception) {
    		log.error(exception.getStackTrace());
    		exception.printStackTrace();
    		throw new RuntimeException(exception.getCause());
    	}		
    }
    
    /**
	 * This method returns list of ZoneMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of ZoneMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(ZoneMaster.class);
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
		try {
			List<ArrayList> listContents = null;
			if (log.isDebugEnabled()) {
				log.debug("getListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0) {
				Enumeration<String> enumeration = hstDataTypes.keys();
				while (enumeration.hasMoreElements()) {
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes
							.get(strKey));
				}
			}
			List listQueryData = query.list();

			if (listQueryData != null && listQueryData.size() > 0) {
				listContents = new ArrayList<ArrayList>();

				// Adding Columns Names to the list
				/*String strColumnNames[] = query.getReturnAliases();
				ArrayList<Object> listColumns = new ArrayList<Object>();
				for (int k = 0; k < strColumnNames.length; k++) {
					listColumns.add(strColumnNames[k]);
				}
				listContents.add(listColumns);*/

				// Adding data to the list
				for (int i = 0; i < listQueryData.size(); i++) {
					ArrayList<Object> listData = new ArrayList<Object>();
					Object[] objectArray = (Object[]) listQueryData.get(i);
					for (int j = 0; j < objectArray.length; j++) {
						if (objectArray[j] instanceof Integer)
							listData.add(Integer.parseInt(objectArray[j].toString()));
						else if (objectArray[j] instanceof Long)
							listData.add(Long.parseLong(objectArray[j].toString()));
						else if (objectArray[j] instanceof Double)
							listData.add(Double.parseDouble(objectArray[j].toString()));
						else if(objectArray[j] instanceof String)
							listData.add(objectArray[j].toString());
						else if(objectArray[j]==null)
							listData.add("NA");
						else 
							listData.add(objectArray[j].toString());
					}

					listContents.add(listData);
				}
			}
			return listContents;
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			exception.printStackTrace();
		}
		return null;
	}
    
    /**
	 * This method returns list of ZoneMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding ZoneMaster instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select zoneMaster from ZoneMaster zoneMaster where zoneMaster."+ propertyName + "= ?";
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

	/**
	 * This method returns ZoneMaster object for a given data
	 * 
	 * @param ZoneMaster as zoneMaster
	 * @return ZoneMaster as model object
	 */
	public ZoneMaster checkForDuplicates(ZoneMaster zoneMaster)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select zoneMaster from ZoneMaster zoneMaster where " ;

			if(zoneMaster.getZoneId() > 0)		
				fromClause = fromClause +" zoneMasterId <> "+zoneMaster.getZoneId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" zoneMaster.{Many-to-one}.{Many-to-one}Id = "+zoneMaster.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			/*fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(zoneMaster.getName()) +"')) and " ;
			fromClause = fromClause +" state.stateId = "+ zoneMaster.getState().getStateId();
		*/
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (ZoneMaster) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	public List<ZoneMaster> getZoneMasterList(ZoneMasterSearch searchOptions) {
		try {
			long pageNumber = searchOptions.getCurrentPage();
			//long displayPageSize = searchOptions.getDisplayPageSize();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();
			// to sort by zoneMasterGroup
		/*	if (StringUtils.isNotEmpty(orderBy) && orderBy.equalsIgnoreCase("zoneMasterGroup.zoneMasterGroupId"))
				orderBy = "";
			else
				orderBy = "," + orderBy;*/

			String sqlString = "select zoneMaster from ZoneMaster zoneMaster ";

			String fromClause = getSearchQuery(searchOptions);

			sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;

			fromClause = sqlString + " order by " + orderBy + " " + sortBy;

			Query query = getSession().createQuery(fromClause);

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				} else {
					query.setFirstResult(0);
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				}
			}
			List<ZoneMaster> list = query.list();

			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
	
	public long getZoneMasterCount(ZoneMasterSearch searchOptions) {
		try {

			String sqlString = "select count(*) from ZoneMaster zoneMaster";
			String fromClause = getSearchQuery(searchOptions);

			sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
			Query query = getSession().createQuery(sqlString);
			List list = query.list();
			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return 0;
	}
	
	private String getSearchQuery(ZoneMasterSearch searchOptions) {
		String condition = " and ";
		String fromClause = "";
		boolean conditionFound = false;
		if (searchOptions != null) {

			String strsearchZoneMasterName = searchOptions.getSearchZoneName();
			String strStatus = searchOptions.getSearchStatus();
			
			if (StringUtils.isNotEmpty(strsearchZoneMasterName)) {
				if (conditionFound)
					fromClause = fromClause + condition;

				fromClause = fromClause + " lower(zoneMaster.zoneName) like lower('%" + CommonUtils.getEscapedSQLString(strsearchZoneMasterName) + "%')";
				conditionFound = true;
			}
			
			if (StringUtils.isNotEmpty(strStatus) && Integer.parseInt(strStatus)>-1) {
				if (conditionFound)
					fromClause = fromClause + condition;
				fromClause = fromClause +"zoneMaster.status="+strStatus;
				conditionFound = true;
			}
			/*if (StringUtils.isNotEmpty(status)) {
				if (conditionFound)
					fromClause = fromClause + condition;

				//fromClause = fromClause + " zoneMaster.isActive =" + status;
				conditionFound = true;
			}*/
		}
		return fromClause;
	}
	
	
	public List<ZoneMaster> getZoneMasterListBasedOnCityId(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with getZoneMasterListBasedOnCityId is called " + id);
			}
			String strQuery = "select zoneMaster from ZoneMaster zoneMaster where zoneMaster.city.cityId=" + id ;
			Query query = getSession().createQuery(strQuery);
			List<ZoneMaster> zoneMasterList = query.list();
			if (zoneMasterList != null && zoneMasterList.size() > 0)
				return  zoneMasterList;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
}

