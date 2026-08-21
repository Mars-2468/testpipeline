package com.mars.common.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Area;
import com.mars.common.model.AreaWard;
import com.mars.common.model.WardMaster;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.AreaSearch;
/**
* <p>Title: AreaService.java </p>

 * <p>Description: This interface is used for service implementations related to Area</p>

 * @see com.mars.common.model.Area
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface AreaService {
  
	/**
	 * This method returns Area object for a given Id
	 * 
	 * @param id as long
	 * @return Area as model object
	 */
	public Area get(long id);
		
    /**
	 * This method save/updates the Area information to the database.
	 * 
	 * @param Area object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Area entity);
	  
	/**
	 * This method to merge the Area information to the database.
	 * 
	 * @param Area object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Area merge(Area entity); 
	    
    /**
	 * This method delete Area for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Area from the database
	 * 
	 * @return List of Area
	 */
	public List<Area> getAll();
	
	/**
     * This method save/updates a list of Area information to the database.
     * 
     * @param listArea as List
     * 
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Area> listArea);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listArea as List
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Area> listArea);
    
    /**
	 * This method returns list of the Area objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getAreaList(long pageNumber,String orderBy, String sortBy);
	
	/**
	 * This method returns list of the Area objects available based on Search
	 * 
	 * @param AreaSearch searchArea
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getAreaListBySearch(AreaSearch searchArea);
	
	
	/**
	 * This method returns count of the Area objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getAreaCount();
	
	
	/**
	 * This method returns count of the Area objects from the database based on search
	 * @param AreaSearch searchArea
	 * @return long
	 * @exception Exception
	 */
	public long getAreaCountBySearch(AreaSearch searchArea);
	
	
	/**
	 * This method returns list of Area objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Area> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Area object for a given data
	 * 
	 * @param Area as area
	 * @return Area as model object
	 */
	public Area checkForDuplicates(Area area);    

    /**
	 * This method returns list of Area objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Area objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Area> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
/*   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveAreaZones(Area area,Set<AreaZone> areaZoneSet,String deletedAreaZoneIds);*/
	
	public Hashtable<Long,String> getUnassignedZonesOfArea(long areaId);
	
	public List<ZoneMaster> getZonesOnArea(long areaId);
	
	public Area getAreaForZone(long zoneId);
	  
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveAreaWards(Area area,Set<AreaWard> areaWardSet,String deletedAreaWardIds);
	
	public Hashtable<Long,String> getUnassignedWardsOfArea(long areaId);
	
	public List<WardMaster> getWardsOnArea(long areaId);
	
	public Area getAreaForWard(long wardId);

}

