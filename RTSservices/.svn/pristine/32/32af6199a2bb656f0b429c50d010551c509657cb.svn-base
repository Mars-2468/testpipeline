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

import com.mars.common.dao.SectorDAO;
import com.mars.common.model.Sector;
import com.mars.common.search.SectorSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: SectorDaoImpl.java </p>

 * @see com.mars.common.model.Sector
 
 * <p>Description: This class is used for hibernate operations for Sector module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("SectorDAO") 
public class SectorDAOImpl extends HibernateDaoSupport implements SectorDAO {

    private static final Log log = LogFactory.getLog(SectorDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns Sector object for a given Id
	 * 
	 * @param id as long
	 * @return Sector as model object
	 */
	public Sector get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Sector) getHibernateTemplate().get(Sector.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Sector information to the database.
	 * 
	 * @param Sector object
	 * 
	 */
	public void save(Sector entity) {
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
	 * This method to merge the Sector information to the database.
	 * 
	 * @param Sector object
	 * 
	 */
    public Sector merge(Sector entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Sector) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Sector instance");
        	}
        	Sector entity = (Sector) getHibernateTemplate().load(Sector.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Sector from the database
	 * 
	 * @return List of Sector
	 */
	public List<Sector> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Sector");
			}
			return getHibernateTemplate().loadAll(Sector.class);
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
     * @param listSector as List
     */
    public void deleteAll(List<Sector> listSector)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Sector");
	    	}
	    	getHibernateTemplate().deleteAll(listSector);
	    	log.debug("deleted successfuly a list of Sector records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Sector information to the database.
     * 
     * @param listSector as List
     * 
     */
    public void saveAll(List<Sector> listSector)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listSector);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the Sector objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getSectorList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select sector from Sector sector";
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
			List<Sector> list = query.list();
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
	 * This method returns list of the Sector objects available based on Search.
	 * 
	 * @param SectorSearch searchSector
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getSectorListBySearch(SectorSearch searchSector){
		if(log.isDebugEnabled()){
			log.debug("getSectorListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchSector.getCurrentPage();
			String orderBy=searchSector.getOrderBy();
			String sortBy=searchSector.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(searchSector.getName());
			long nodeMasterId=searchSector.getNodeMasterId();
			long wardId=searchSector.getWardId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select sector from Sector sector ";
			List<Sector> list=null;
			boolean flag=false;
			
			if (wardId > 0) {
				flag=true;
				sql.append(",WardSector wardSector where wardSector.sector=sector and wardSector.ward.wardId=" + wardId + " ");
			}
		
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(sector.name) like upper('%"+ name +"%')");
			}
			
			if(nodeMasterId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("sector.nodeMaster.nodeMasterId=" + nodeMasterId);
			}
			
			sql.insert(0, fromClause).append(" order by "+ orderBy + " " + sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
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
	 * This method returns count of the Sector objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getSectorCount(){
	    try {
			String fromClause = "select count(*) from Sector sector";
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
	 * This method returns count of the Sector objects available based on search criteria.
	 * @param SectorSearch searchSector
	 * @return long
	 * @exception Exception
	 */
	public long getSectorCountBySearch(SectorSearch searchSector){
		if(log.isDebugEnabled()){
			log.debug("getSectorCountBySearch Method is called");
		}
		
		try{
			
			String name=CommonUtils.getEscapedSQLString(searchSector.getName());
			long nodeMasterId=searchSector.getNodeMasterId();
			long wardId=searchSector.getWardId();
			
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(sector) from Sector sector";
			List list=null;
			boolean flag=false;
			
				if (wardId > 0) {
					flag=true;
					sql.append(",WardSector wardSector where wardSector.sector=sector and wardSector.ward.wardId=" + wardId + " ");
				}
			
				if(name!=null && name.length()>0){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("upper(sector.name) like upper('%"+ name +"%')");
				}
				
				if(nodeMasterId>0){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("sector.nodeMaster.nodeMasterId=" + nodeMasterId);
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
	 * This method returns list of Sector objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of Sector objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Sector.class);
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
	 * This method returns list of Sector objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Sector instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select sector from Sector sector where sector."+ propertyName + "= ?";
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
	 * This method returns Sector object for a given data
	 * 
	 * @param Sector as sector
	 * @return Sector as model object
	 */
	public Sector checkForDuplicates(Sector sector)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select sector from Sector sector where " ;

			if(sector.getSectorId() > 0)		
				fromClause = fromClause +" sectorId <> "+sector.getSectorId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" sector.{Many-to-one}.{Many-to-one}Id = "+sector.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(sector.getName()) +"')) and" ;
			fromClause = fromClause +" nodeMaster.nodeMasterId = " + sector.getNodeMaster().getNodeMasterId();
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Sector) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
}

