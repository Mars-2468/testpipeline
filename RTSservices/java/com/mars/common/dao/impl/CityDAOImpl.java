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

import com.mars.common.dao.CityDAO;
import com.mars.common.model.City;
import com.mars.common.search.CitySearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: CityDaoImpl.java </p>

 * @see com.mars.common.model.City
 
 * <p>Description: This class is used for hibernate operations for City module</p>

 * Copyright (c) 2008 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : Balaji H P
 
 */
 @Repository("cityDAO")
public class CityDAOImpl extends HibernateDaoSupport implements CityDAO {

    private static final Log log = LogFactory.getLog(CityDAOImpl.class);

  
    @Autowired
  	public void init(SessionFactory factory) {
  		setSessionFactory(factory);
  	}
	/**
	 * This method returns City object for a given Id
	 * 
	 * @param id as long
	 * @return City as model object
	 */
	public City get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (City) getHibernateTemplate().get(City.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the City information to the database.
	 * 
	 * @param City object
	 * 
	 */
	public void save(City entity) {
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
	 * This method to merge the City information to the database.
	 * 
	 * @param City object
	 * 
	 */
    public City merge(City entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (City) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting City instance");
        	}
        	City entity = (City) getHibernateTemplate().load(City.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all City from the database
	 * 
	 * @return List of City
	 */
	public List<City> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for City");
			}
			return getHibernateTemplate().loadAll(City.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listCity as List
     */
    public void deleteAll(List<City> listCity)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for City");
	    	}
	    	getHibernateTemplate().deleteAll(listCity);
	    	log.debug("deleted successfuly a list of City records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of City information to the database.
     * 
     * @param listCity as List
     * 
     */
    public void saveAll(List<City> listCity)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listCity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the City objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<City> getCityList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select city from City city";
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
			List<City> list = query.list();
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
	 * This method returns list of the City objects available based on Search.
	 * 
	 * @param CitySearch searchCity
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<City> getCityListBySearch(CitySearch searchCity){
		if(log.isDebugEnabled()){
			log.debug("getCityListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchCity.getCurrentPage();
			String orderBy=searchCity.getOrderBy();
			String sortBy=searchCity.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(searchCity.getName());
			long talukaId=searchCity.getTalukaId();
			StringBuffer sql=new StringBuffer();
			String fromClause="select city from City city";
			List<City> list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(city.name) like upper(:name)");
			}
			if(talukaId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("city.taluka.talukaId= :talukaId");
			}
			
			sql.insert(0, fromClause).append(" order by " + orderBy + " "+ sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if(name!=null && name.length()>0)
			query.setString("name", "%"+name.toUpperCase()+"%");
			if(talukaId>0)
			query.setLong("talukaId", talukaId);

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
	 * This method returns count of the City objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getCityCount(){
	    try {
			String fromClause = "select count(*) from City city";
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
	 * This method returns count of the City objects available based on search criteria.
	 * @param CitySearch searchCity
	 * @return long
	 * @exception Exception
	 */
	public long getCityCountBySearch(CitySearch searchCity){
		if(log.isDebugEnabled()){
			log.debug("getCityCountBySearch Method is called");
		}
		
		try{
			String name=CommonUtils.getEscapedSQLString(searchCity.getName());
			long talukaId=searchCity.getTalukaId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(city) from City city";
			List list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(city.name) like upper(:name)");
			}
			if(talukaId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("city.taluka.talukaId= :talukaId");
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			
			if(name!=null && name.length()>0)
			query.setString("name", "%"+name.toUpperCase()+"%");
			if(talukaId>0)
			query.setLong("talukaId", talukaId);

			list=query.list();
			
			if(list!=null && list.size()>0)
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
	 * This method returns list of City objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<City> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of City objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<City> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(City.class);
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
	 * This method returns list of City objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<City> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding City instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select city from City city where city."+ propertyName + "= ?";
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
	 * This method returns City object for a given data
	 * 
	 * @param City as city
	 * @return City as model object
	 */
	public City checkForDuplicates(City city)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select city from City city where " ;

			if(city.getCityId() > 0)		
				fromClause = fromClause +" cityId <> :cityId  and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" city.{Many-to-one}.{Many-to-one}Id = "+city.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(name) = upper(:name))";
			//fromClause= fromClause + " taluka.talukaId = " + city.getTaluka().getTalukaId();
		
			Query query = getSession().createQuery(fromClause);	
			
			if(city.getCityId() > 0)		
			query.setLong("cityId", city.getCityId());
			query.setString("name", "%"+CommonUtils.getEscapedSQLString(city.getName()).toUpperCase()+"%");
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (City) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	@Override
	public List<City> getAllByTenancy(long tenancyId) {
		if(log.isDebugEnabled()){
			log.debug("getCityListBySearch Method is called");
		}
		
		try{
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select city from City city,Tenancy tenancy where city.cityId=tenancy.city.cityId ";
			List<City> list=null;
			boolean flag=false;
			
			if(tenancyId>0){
				 if(!flag){
						flag=true;
						
					}else
						sql.append(" and ");
					
				 sql.append("and tenancyId= :tenancyId");
				 
			}
			
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			if(tenancyId>0)
				query.setLong("tenancyId", tenancyId);
			list=query.list();
			return list;
		}catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
	
	public City getByName(String name) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + name);
			}
			List<City> cityList = getHibernateTemplate().find("select city from City city where upper(city.name)=upper('" + name + "')");
			if (cityList != null && cityList.size() > 0) {
				return cityList.get(0);
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
	
	@Override
	public City getByTenancyId(long tenancyId) {
try{
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select city from City city,Tenancy tenancy where city.cityId=tenancy.city.cityId ";
			boolean flag=false;
			
			if(tenancyId>0){
				 if(!flag){
						flag=true;
						
					}else
						sql.append(" and ");
					
				 sql.append("and tenancyId= :tenancyId");
				 
			}
			
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			if(tenancyId>0)
				query.setLong("tenancyId", tenancyId);
			List list = query.list();
			if (list != null && list.size() > 0) 
				return (City) list.get(0);
		}catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
	
}

