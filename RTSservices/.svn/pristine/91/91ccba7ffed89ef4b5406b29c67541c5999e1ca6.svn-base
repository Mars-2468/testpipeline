package com.mars.common.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.AreaDAO;
import com.mars.common.model.Area;
import com.mars.common.model.AreaWard;
import com.mars.common.model.WardMaster;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.AreaSearch;
import com.mars.common.service.AreaService;
 /**

 * <p>Title: AreaServiceImpl.java </p>

 * @see com.mars.common.model.Area
 
 * <p>Description: This class is used for hibernate operations for Area module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
  @Service("areaService")
public class AreaServiceImpl implements AreaService {

    private static final Log log = LogFactory.getLog(AreaServiceImpl.class);

  	
	@Autowired
	private AreaDAO areaDAO;

	public void setAreaDAO(AreaDAO areaDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setAreaDAO Method is called ");
		}
		this.areaDAO = areaDAO;
	}

	/**
	 * This method is saves the Area object
	 * 
	 * @param entity as Area object
	 * @return
	 * 
	 */
	public void save(Area entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		areaDAO.save(entity);
	}

     /**
	 * This method to merge the Area information to the database.
	 * 
	 * @param Area object
	 * 
	 */
    public Area merge(Area entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return areaDAO.merge(entity);
	}

	/**
	 * This method delete the area
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		areaDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Area Object
	 * 
	 */
	public Area get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return areaDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Area from the database
	 * 
	 * @return List of Area
	 */
	public List<Area> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return areaDAO.getAll();
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
		public List<Area> getAreaList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getAreaList Method is called");
			}
			return areaDAO.getAreaList(pageNumber,orderBy,sortBy);
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
			
			return areaDAO.getAreaListBySearch(searchArea);
		}
		
		
		/**
		 * This method returns count of the Area objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getAreaCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getAreaCount Method is called");
			}
			return areaDAO.getAreaCount();
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
			
			return areaDAO.getAreaCountBySearch(searchArea);
		}
	
	
	/**
     * This method save/updates a list of Area information to the database.
     * 
     * @param listArea as List
     * 
     */
    public void saveAll(List<Area> listArea){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		areaDAO.saveAll(listArea);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listArea as List
     */
    public void deleteAll(List<Area> listArea){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		areaDAO.deleteAll(listArea);
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
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return areaDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Area object for a given data
	 * 
	 * @param Area as area
	 * @return Area as model object
	 */
	public Area checkForDuplicates(Area area)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return areaDAO.checkForDuplicates(area);
		
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
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return areaDAO.getListByNamedQuery(namedQuery,hstKeyValues);
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
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return areaDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return areaDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	/*public void saveAreaZones(Area area,Set<AreaZone> areaZoneSet,String deletedAreaZoneIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveAreaZones Method is called");
		}
		areaDAO.saveAreaZones(area,areaZoneSet,deletedAreaZoneIds);
	}*/
	
	
	public Hashtable<Long,String> getUnassignedZonesOfArea(long areaId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getUnassignedZonesOfArea Method is called");
		}
		return areaDAO.getUnassignedZonesOfArea(areaId);	
	}
	
	public List<ZoneMaster> getZonesOnArea(long areaId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getZonesOnArea Method is called");
		}
		return areaDAO.getZonesOnArea(areaId);		
	}
	
	public Area getAreaForZone(long zoneId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getAreaForZone Method is called");
		}
		return areaDAO.getAreaForZone(zoneId);			
	}
	
	public void saveAreaWards(Area area,Set<AreaWard> areaWardSet,String deletedAreaWardIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveAreaWards Method is called");
		}
		areaDAO.saveAreaWards(area,areaWardSet,deletedAreaWardIds);
	}
	
	
	public Hashtable<Long,String> getUnassignedWardsOfArea(long areaId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getUnassignedWardsOfArea Method is called");
		}
		return areaDAO.getUnassignedWardsOfArea(areaId);	
	}
	
	public List<WardMaster> getWardsOnArea(long areaId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getWardsOnArea Method is called");
		}
		return areaDAO.getWardsOnArea(areaId);		
	}
	
	public Area getAreaForWard(long wardId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getAreaForWard Method is called");
		}
		return areaDAO.getAreaForWard(wardId);			
	}

}

