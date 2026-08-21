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

import com.mars.common.dao.AreaDAO;
import com.mars.common.model.Area;
import com.mars.common.model.AreaWard;
import com.mars.common.model.WardMaster;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.AreaSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: AreaDaoImpl.java </p>

 * @see com.mars.common.model.Area
 
 * <p>Description: This class is used for hibernate operations for Area module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Repository("areaDAO")
public class AreaDAOImpl extends HibernateDaoSupport implements AreaDAO {

    private static final Log log = LogFactory.getLog(AreaDAOImpl.class);

  
	/**
	 * This method returns Area object for a given Id
	 * 
	 * @param id as long
	 * @return Area as model object
	 */
	 @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	public Area get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Area) getHibernateTemplate().get(Area.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Area information to the database.
	 * 
	 * @param Area object
	 * 
	 */
	public void save(Area entity) {
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
	 * This method to merge the Area information to the database.
	 * 
	 * @param Area object
	 * 
	 */
    public Area merge(Area entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Area) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Area instance");
        	}
        	Area entity = (Area) getHibernateTemplate().load(Area.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Area from the database
	 * 
	 * @return List of Area
	 */
	public List<Area> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Area");
			}
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Area.class).addOrder( Order.asc("name").ignoreCase()).list();
			//return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Area.class).addOrder(Order.asc("areaName").ignoreCase()).list();
			/*return getHibernateTemplate().loadAll(Area.class);*/
			
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
     * @param listArea as List
     */
    public void deleteAll(List<Area> listArea)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Area");
	    	}
	    	getHibernateTemplate().deleteAll(listArea);
	    	log.debug("deleted successfuly a list of Area records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Area information to the database.
     * 
     * @param listArea as List
     * 
     */
    public void saveAll(List<Area> listArea)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listArea);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the Area objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getAreaList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select area from Area area";
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
			List<Area> list = query.list();
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
	 * This method returns list of the Area objects available based on Search.
	 * 
	 * @param AreaSearch searchArea
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getAreaListBySearch(AreaSearch searchArea){
		if(log.isDebugEnabled()){
			log.debug("getAreaListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchArea.getCurrentPage();
			String orderBy=searchArea.getOrderBy();
			String sortBy=searchArea.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(searchArea.getName());
			StringBuffer sql=new StringBuffer();
			String fromClause="select area from Area area";
			List<Area> list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("area.name like '%"+ name +"%'");
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
	 * This method returns count of the Area objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getAreaCount(){
	    try {
			String fromClause = "select count(*) from Area area";
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
	 * This method returns count of the Area objects available based on search criteria.
	 * @param AreaSearch searchArea
	 * @return long
	 * @exception Exception
	 */
	public long getAreaCountBySearch(AreaSearch searchArea){
		if(log.isDebugEnabled()){
			log.debug("getAreaCountBySearch Method is called");
		}
		
		try{
			
			String name=CommonUtils.getEscapedSQLString(searchArea.getName());
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(area) from Area area";
			List list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");					
				}else
					sql.append(" and ");
				
				    sql.append("area.name like '%"+ name +"%'");
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
	 * This method returns list of Area objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of Area objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Area.class);
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
	 * This method returns list of Area objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Area> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Area instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select area from Area area where area."+ propertyName + "= ?";
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
	 * This method returns Area object for a given data
	 * 
	 * @param Area as area
	 * @return Area as model object
	 */
	public Area checkForDuplicates(Area area)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select area from Area area where " ;

			if(area.getAreaId() > 0)		
				fromClause = fromClause +" areaId <> "+area.getAreaId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" area.{Many-to-one}.{Many-to-one}Id = "+area.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" name = '"+ CommonUtils.getEscapedSQLString(area.getName()) +"' " ;
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Area) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	/*public void saveAreaZones(Area area,Set<AreaZone> areaZoneSet,String deletedAreaZoneIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveAreaZones Method is called");
		}
		try
		{

			if (deletedAreaZoneIds != null && deletedAreaZoneIds.length() > 0 && !deletedAreaZoneIds.equalsIgnoreCase("undefined"))
			{
			    String strIds[] = deletedAreaZoneIds.split(",");
			    for (String deleteId : strIds)
			    {
			    	AreaZone areaZone = getAreaZone(Long.parseLong(deleteId));
				if (areaZone != null)
				{
				    getHibernateTemplate().delete(areaZone);
				}
			    }
			}
			
			getHibernateTemplate().evict(area);
			getHibernateTemplate().flush();
		    
		    //Add Area ZoneMaster separately not as part of Area
		    if (areaZoneSet != null && areaZoneSet.size() > 0)
		    {
				for (AreaZone areaZone : areaZoneSet)
				{
					getHibernateTemplate().saveOrUpdate(areaZone);
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
	*/
	
 /*   private AreaZone getAreaZone(long id)
    {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("getAreaZone is called " + id);
		    }
		    return (AreaZone) getHibernateTemplate().get(AreaZone.class, new Long(id));
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
    */
    public Hashtable<Long,String> getUnassignedZonesOfArea(long areaId)
    {
    	/*try 
	  	{
    		Hashtable<Long,String> unAssignedZoneHT  = new Hashtable<Long,String>();
		  	log.info("getUnassignedZonesOfArea for  areaId: "+ areaId );
			String queryString = "select zoneMaster from ZoneMaster zoneMaster where zoneMaster not in (select areaZone.zoneMaster from AreaZone areaZone where areaZone.area.areaId != ?)";
			queryString = queryString + " order by zoneMaster.zoneName asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, areaId);
		    List<ZoneMaster> unAssignedZonesList =  queryObject.list();
	   		
		    for (ZoneMaster zoneMaster : unAssignedZonesList) {
		    	unAssignedZoneHT.put(new Long(zoneMaster.getZoneId()), zoneMaster.getZoneName());
			}
	   		return unAssignedZoneHT;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;*/
    	
    	try 
	  	{
    		Hashtable<Long,String> unAssignedZoneHT  = new Hashtable<Long,String>();
		  	log.info("getUnassignedZonesOfArea for  areaId: "+ areaId );
			String queryString = "select zoneMaster from ZoneMaster zoneMaster where zoneMaster not in (select areaZone.zoneMaster from AreaZone areaZone where areaZone.area.areaId != ?)";
			queryString = queryString + " order by zoneMaster.zoneName asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, areaId);
		    List<ZoneMaster> unAssignedZonesList =  queryObject.list();
	   		
		    for (ZoneMaster zoneMaster : unAssignedZonesList) {
		    	unAssignedZoneHT.put(new Long(zoneMaster.getZoneId()), zoneMaster.getZoneName());
			}
	   		return unAssignedZoneHT;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    public List<ZoneMaster> getZonesOnArea(long areaId)
    {
    	try 
	  	{
		  	log.info("finding ZoneMaster instance with areaId: "+ areaId );
			String queryString = "select areaZone.zoneMaster from AreaZone areaZone where areaZone.area.areaId= ?";
			queryString = queryString + " order by areaZone.zoneMaster.zoneName asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, areaId);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    
    public Area getAreaForZone(long zoneId)
    {
		try 
	  	{
		  	log.info("finding AreaZone instance with zoneId : " + zoneId);
			String queryString = "select areaZone.area from AreaZone areaZone where areaZone.zoneMaster.zoneId="+zoneId;
		    Query queryObject = getSession().createQuery(queryString);
		    List<Area> areaList = queryObject.list();
		    if(areaList != null && areaList.size() > 0)
		    	return areaList.get(0);
		    else
		    	return null;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    public void saveAreaWards(Area area,Set<AreaWard> areaWardSet,String deletedAreaWardIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveAreaWards Method is called");
		}
		try
		{

			if (deletedAreaWardIds != null && deletedAreaWardIds.length() > 0 && !deletedAreaWardIds.equalsIgnoreCase("undefined"))
			{
			    String strIds[] = deletedAreaWardIds.split(",");
			    for (String deleteId : strIds)
			    {
				AreaWard areaWard = getAreaWard(Long.parseLong(deleteId));
				if (areaWard != null)
				{
				    getHibernateTemplate().delete(areaWard);
				}
			    }
			}
			
			getHibernateTemplate().evict(area);
			getHibernateTemplate().flush();
		    
		    //Add Area WardMaster separately not as part of Area
		    if (areaWardSet != null && areaWardSet.size() > 0)
		    {
				for (AreaWard areaWard : areaWardSet)
				{
					getHibernateTemplate().saveOrUpdate(areaWard);
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

	private AreaWard getAreaWard(long id)
    {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("getAreaWard is called " + id);
		    }
		    return (AreaWard) getHibernateTemplate().get(AreaWard.class, new Long(id));
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
    
    public Hashtable<Long,String> getUnassignedWardsOfArea(long areaId)
    {
    	try 
	  	{
    		Hashtable<Long,String> unAssignedWardHT  = new Hashtable<Long,String>();
		  	log.info("getUnassignedWardsOfArea for  areaId: "+ areaId );
			String queryString = "select wardMaster from WardMaster wardMaster where wardMaster not in (select areaWard.wardMaster from AreaWard areaWard where areaWard.area.areaId != ?)";
			queryString = queryString + " order by wardMaster.name asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, areaId);
		    List<WardMaster> unAssignedWardsList =  queryObject.list();
	   		
		    for (WardMaster wardMaster : unAssignedWardsList) {
		    	unAssignedWardHT.put(new Long(wardMaster.getWardId()), wardMaster.getName());
			}
	   		return unAssignedWardHT;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    public List<WardMaster> getWardsOnArea(long areaId)
    {
    	try 
	  	{
		  	log.info("finding WardMaster instance with areaId: "+ areaId );
			String queryString = "select areaWard.wardMaster from AreaWard areaWard where areaWard.area.areaId= ?";
			queryString = queryString + " order by areaWard.wardMaster.name asc";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, areaId);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
    
    
    public Area getAreaForWard(long wardId)
    {
		try 
	  	{
		  	log.info("finding AreaWard instance with wardId : " + wardId);
			String queryString = "select areaWard.area from AreaWard areaWard where areaWard.wardMaster.wardId="+wardId;
		    Query queryObject = getSession().createQuery(queryString);
		    List<Area> areaList = queryObject.list();
		    if(areaList != null && areaList.size() > 0)
		    	return areaList.get(0);
		    else
		    	return null;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }
 }