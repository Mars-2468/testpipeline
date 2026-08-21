package com.mars.common.dao.impl;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.WardDAO;
import com.mars.common.model.Sector;
import com.mars.common.model.Ward;
import com.mars.common.model.WardSector;
import com.mars.common.search.WardSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: WardDaoImpl.java </p>

 * @see com.mars.common.model.Ward
 
 * <p>Description: This class is used for hibernate operations for Ward module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("WardDAO")
public class WardDAOImpl extends HibernateDaoSupport implements WardDAO {

    private static final Log log = LogFactory.getLog(WardDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	/**
	 * This method returns Ward object for a given Id
	 * 
	 * @param id as long
	 * @return Ward as model object
	 */
	public Ward get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Ward) getHibernateTemplate().get(Ward.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Ward information to the database.
	 * 
	 * @param Ward object
	 * 
	 */
	public void save(Ward entity) {
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
	 * This method to merge the Ward information to the database.
	 * 
	 * @param Ward object
	 * 
	 */
    public Ward merge(Ward entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Ward) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Ward instance");
        	}
        	Ward entity = (Ward) getHibernateTemplate().load(Ward.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Ward from the database
	 * 
	 * @return List of Ward
	 */
	public List<Ward> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Ward");
			}
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Ward.class).addOrder(Order.asc("code").ignoreCase()).list();
			//return getHibernateTemplate().loadAll(Ward.class);
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
     * @param listWard as List
     */
    public void deleteAll(List<Ward> listWard)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Ward");
	    	}
	    	getHibernateTemplate().deleteAll(listWard);
	    	log.debug("deleted successfuly a list of Ward records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Ward information to the database.
     * 
     * @param listWard as List
     * 
     */
    public void saveAll(List<Ward> listWard)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listWard);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the Ward objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getWardList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select ward from Ward ward";
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
			List<Ward> list = query.list();
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
	 * This method returns list of the Ward objects available based on Search.
	 * 
	 * @param WardSearch searchWard
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getWardListBySearch(WardSearch searchWard){
		if(log.isDebugEnabled()){
			log.debug("getWardListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchWard.getCurrentPage();
			String orderBy=searchWard.getOrderBy();
			String sortBy=searchWard.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(searchWard.getName());
			long cityId=searchWard.getCityId();
			StringBuffer sql=new StringBuffer();
			String fromClause="select ward from Ward ward";
			List<Ward> list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(ward.name) like upper('%"+ name +"%')");
			}
			if(cityId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("ward.city.cityId=" + cityId);
			}
			
			sql.insert(0, fromClause).append(" order by "+ orderBy+ " "+ sortBy);
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
	 * This method returns count of the Ward objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWardCount(){
	    try {
			String fromClause = "select count(*) from Ward ward";
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
	 * This method returns count of the Ward objects available based on search criteria.
	 * @param WardSearch searchWard
	 * @return long
	 * @exception Exception
	 */
	public long getWardCountBySearch(WardSearch searchWard){
		if(log.isDebugEnabled()){
			log.debug("getWardCountBySearch Method is called");
		}
		
		try{
			
			String name=CommonUtils.getEscapedSQLString(searchWard.getName());
			long cityId=searchWard.getCityId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(ward) from Ward ward";
			List list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");					
				}else
					sql.append(" and ");
				
				    sql.append("upper(ward.name) like upper('%"+ name +"%')");
			}
			if(cityId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
				    sql.append(" and ");
				
				    sql.append("ward.city.cityId=" + cityId);
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
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
	 * This method returns list of Ward objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of Ward objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Ward.class);
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
	 * This method returns list of Ward objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Ward instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select ward from Ward ward where ward."+ propertyName + "= ?";
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
	 * This method returns Ward object for a given data
	 * 
	 * @param Ward as ward
	 * @return Ward as model object
	 */
	public Ward checkForDuplicates(Ward ward)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select ward from Ward ward where " ;

			if(ward.getWardId() > 0)		
				fromClause = fromClause +" wardId <> "+ward.getWardId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" ward.{Many-to-one}.{Many-to-one}Id = "+ward.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(ward.getName()) +"')) and " ;
			fromClause = fromClause +" city.cityId = "+ ward.getCity().getCityId();
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Ward) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	public void saveWardSectors(Ward ward,Set<WardSector> wardSectorSet,String deletedWardSectorIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveWardSectors Method is called");
		}
		try
		{

			if (deletedWardSectorIds != null && deletedWardSectorIds.length() > 0 && !deletedWardSectorIds.equalsIgnoreCase("undefined"))
			{
			    String strIds[] = deletedWardSectorIds.split(",");
			    for (String deleteId : strIds)
			    {
				WardSector wardSector = getWardSectorn(Long.parseLong(deleteId));
				if (wardSector != null)
				{
				    getHibernateTemplate().delete(wardSector);
				}
			    }
			}
			
			getHibernateTemplate().evict(ward);
			getHibernateTemplate().flush();
		    
		    //Add Ward Sector separately not as part of Ward
		    if (wardSectorSet != null && wardSectorSet.size() > 0)
		    {
				for (WardSector wardSector : wardSectorSet)
				{
					getHibernateTemplate().saveOrUpdate(wardSector);
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
	
	
    private WardSector getWardSectorn(long id)
    {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("getWardSectorn is called " + id);
		    }
		    return (WardSector) getHibernateTemplate().get(WardSector.class, new Long(id));
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
    
    public List<Sector>getSectorsOnWard(long wardId)
    {
    	try 
	  	{
		  	log.info("finding Sector instance with wardId: "+ wardId );
			String queryString = "select wardSector.sector from WardSector wardSector where wardSector.ward.wardId= ?";
			queryString = queryString + " order by wardSector.sector.nodeMaster.name asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, wardId);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    public List<Sector> getSectorsOnWardAndNode(long wardId,long nodeMasterId)
    {
    	try 
	  	{
		  	log.info("finding Sector instance with wardId: "+ wardId + " and node id = " + nodeMasterId );
		  			  	
		  	StringBuffer sql = new StringBuffer();
	  	    String fromClause = "select wardSector.sector from WardSector wardSector";
	  	    List<Sector> list = null;
	  	    boolean flag=false;
	  	   if(nodeMasterId > 0 && !(wardId > 0))
	  	    {
	  		    String queryString = "select sector from Sector sector where sector.nodeMaster.nodeMasterId = ?";
			    Query queryObject = getSession().createQuery(queryString);
			    queryObject.setParameter(0, nodeMasterId);
			    list = queryObject.list();
	  	    }
	  	   else {
		  	    if(wardId > 0)
		  	    {
		  	    	if(!flag){
		  	    		flag=true;
		  	    		sql.append(" where ");
		  	    	}else
		  	    		sql.append(" and ");
		  	    	
		  	    	    sql.append("wardSector.ward.wardId=" + wardId);
		  	    }
		  	    if(nodeMasterId > 0 && wardId > 0)
		  	    {
		  	    	if(!flag){
		  	    		flag=true;
		  	    		sql.append(" where ");
		  	    	}else
		  	    		sql.append(" and ");
		  	    	
		  	    	    sql.append("wardSector.sector.nodeMaster.nodeMasterId = "+ nodeMasterId);
		  	    } 
		  	    
		  	  String orderBy="wardSector.sector.nodeMaster.name";
			  String sortBy="asc";
		  	    
		  	  sql.insert(0, fromClause).append("order by " + orderBy + " " + sortBy);
	  	    
	  	      Query query = getSession().createQuery(sql.toString());
	  	      list = query.list();
	  	   }
	  	   
	      return list;
		
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
}

