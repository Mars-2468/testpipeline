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
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.WardMasterDAO;
import com.mars.common.model.WardMaster;
import com.mars.common.search.WardMasterSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
/**

 * <p>Title: WardMasterDaoImpl.java </p>

 * @see com.mars.common.model.Bank
 
 * <p>Description: This class is used for hibernate operations for Bank module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("WardMasterDAO")
public class WardMasterDAOImpl extends HibernateDaoSupport implements WardMasterDAO {

    private static final Log log = LogFactory.getLog(WardMasterDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns WardMaster object for a given Id
	 * 
	 * @param id as long
	 * @return WardMaster as model object
	 */
	public WardMaster get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WardMaster) getHibernateTemplate().get(WardMaster.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the WardMaster information to the database.
	 * 
	 * @param WardMaster object
	 * 
	 */
	public void save(WardMaster entity) {
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
	 * This method to merge the WardMaster information to the database.
	 * 
	 * @param WardMaster object
	 * 
	 */
    public WardMaster merge(WardMaster entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (WardMaster) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting WardMaster instance");
        	}
        	WardMaster entity = (WardMaster) getHibernateTemplate().load(WardMaster.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all WardMaster from the database
	 * 
	 * @return List of WardMaster
	 */
	@SuppressWarnings("unchecked")
	public List<WardMaster> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for WardMaster");
			}
			CommonUtils.setFilter(getSession());
			//return getHibernateTemplate().loadAll(WardMaster.class);
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(WardMaster.class).addOrder( Order.asc("name").ignoreCase()).list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
	    	PrintWriter pw=null;
			try {
				pw = new PrintWriter(new File("/root/Desktop/WardExceptionTxt.txt"));
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
     * @param listWardMaster as List
     */
    public void deleteAll(List<WardMaster> listWardMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for WardMaster");
	    	}
	    	getHibernateTemplate().deleteAll(listWardMaster);
	    	log.debug("deleted successfuly a list of WardMaster records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of WardMaster information to the database.
     * 
     * @param listWardMaster as List
     * 
     */
    public void saveAll(List<WardMaster> listWardMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listWardMaster);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the WardMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getWardMasterList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select wardMaster from WardMaster wardMaster";
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
			List<WardMaster> list = query.list();
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
	 * This method returns list of the WardMaster objects available based on Search.
	 * 
	 * @param WardMasterSearch searchWardMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	
	
	/**
	 * This method returns count of the WardMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWardMasterCount(){
	    try {
			String fromClause = "select count(*) from WardMaster wardMaster";
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
	 * This method returns list of WardMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of WardMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(WardMaster.class);
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
    
    /**
	 * This method returns list of WardMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding WardMaster instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select wardMaster from WardMaster wardMaster where wardMaster."+ propertyName + "= ?";
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
	 * This method returns WardMaster object for a given data
	 * 
	 * @param WardMaster as wardMaster
	 * @return WardMaster as model object
	 */
	public WardMaster checkForDuplicates(WardMaster wardMaster)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select wardMaster from WardMaster wardMaster where " ;

			/*if(wardMaster.getWardMasterId() > 0)		
				fromClause = fromClause +" wardMasterId <> "+wardMaster.getWardMasterId()+" and ";*/
			
			//Sample Code update accordingly
			//fromClause = fromClause +" wardMaster.{Many-to-one}.{Many-to-one}Id = "+wardMaster.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			/*fromClause = fromClause +" (upper(number) = upper('"+ CommonUtils.getEscapedSQLString(wardMaster.getNumber()) +"')) and " ;
			fromClause = fromClause +" wardMaster.sector.sectorId = " + wardMaster.getSector().getSectorId();
		*/
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (WardMaster) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	
	public List<WardMaster> getWardList(WardMasterSearch searchOptions) {
		try {
			long pageNumber = searchOptions.getCurrentPage();
			//long displayPageSize = searchOptions.getDisplayPageSize();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();
			// to sort by wardGroup
		/*	if (StringUtils.isNotEmpty(orderBy) && orderBy.equalsIgnoreCase("wardGroup.wardGroupId"))
				orderBy = "";
			else
				orderBy = "," + orderBy;*/

			String sqlString = "select wardMaster from WardMaster wardMaster";

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
			List<WardMaster> list = query.list();

			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
	
	public long getWardCount(WardMasterSearch searchOptions) {
		try {

			String sqlString = "select count(*) from WardMaster wardMaster";
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
	
	
	private String getSearchQuery(WardMasterSearch searchOptions) {
		String condition = " and ";
		String fromClause = "";
		boolean conditionFound = false;
		if (searchOptions != null) {

			String strsearchWardName = searchOptions.getSearchName();
			
			if (StringUtils.isNotEmpty(strsearchWardName)) {
				if (conditionFound)
					fromClause = fromClause + condition;

				fromClause = fromClause + " lower(wardMaster.name) like lower('%" + CommonUtils.getEscapedSQLString(strsearchWardName) + "%')";
				conditionFound = true;
			}
			
		}
		return fromClause;
	}
	
	public List<WardMaster> getWardMasterListBasedOnZoneId(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with getWardMasterListBasedOnZoneId is called " + id);
			}
			String strQuery = "select wardMaster from WardMaster wardMaster where wardMaster.zoneMaster.zoneId=" + id ;
			Query query = getSession().createQuery(strQuery);
			List<WardMaster> wardList = query.list();
			if (wardList != null && wardList.size() > 0)
				return  wardList;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public List<WardMaster> getWardMasterListBySearch(
			WardMasterSearch searchWardMaster) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getWardMasterCountBySearch(WardMasterSearch searchWardMaster) {
		// TODO Auto-generated method stub
		return 0;
	}
}

