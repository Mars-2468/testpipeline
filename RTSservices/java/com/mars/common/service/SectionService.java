package com.mars.common.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Section;

/**
 * <p>Title: SectionService.java </p>

 * <p>Description: This interface is used for service implementations related to Section</p>

 * @see com.mars.common.model.Section
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */
@Transactional(readOnly = true)
public interface SectionService
{

    /**
     * This method returns Section object for a given Id
     * 
     * @param id as long
     * @return Section as model object
     */
    public Section get(long id);

    /**
     * This method returns Section object for a given Section Name
     * 
     * @param userName as String
     * @return Section as model object
     */
   // public Section get(String userName);
    
    /**
     * This method returns Section object for a given Sectionname & SectionId
     * 
     * @param userName as String
     * @param userId as long
     * @return Section as model object
     */
    //public Section getByName(String userName, long userId);

    /**
     * This method save/updates the Section information to the database.
     * 
     * @param Section object
     * @param deleteIds as String
     * @return
     * 
     */
 /*   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void save(Section entity, String deleteIds);*/

    //Keeping it , as it is used in AuthenticationController for ChnagePassword
    /**
     * This method save/updates the Section information to the database.
     * 
     * @param Section object
     * @return
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void save(Section entity);

    /**
     * This method delete Section for a given Id
     * 
     * @param id as long
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id);

    /**
     * This method will return a list of all Section from the database
     * 
     * @return List of Section
     */
    public List<Section> getAll();

    /**
     * This method save/updates a list of Section information to the database.
     * 
     * @param listSection as List
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Section> listSection);

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listSection as List
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Section> listSection);

    /**
     * This method returns list of the Section objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Section> getSectionList(long pageNumber, String orderBy, String sortBy);
    
    /**
     * This method returns list of the Section objects available based page number.
     * 
     * @param SectionSearch searchOptions
     * @return List
     * @exception Exception
     */
  //  public List<Section> getSectionByType(SectionSearch searchOptions);

    /**
     * This method returns count of the Section objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getSectionCount();
    
    /**
     * This method returns count of the Section objects from the database
     * 
     * @param SectionSearch searchOptions
     * @return long
     * @exception Exception
     */
    //public long getSectionCountBySearchOption(SectionSearch searchOptions);

    /**
     * This method returns list of the Section objects available based page number.
     * @param roleName as String
     * @param OfficeId as long 
     * @param userId as long
     * @return List
     * @exception Exception
     */
   // public List<Section> getSectionsListByRoleName(String roleName, long OfficeId,long userId);
    
    /**
     * This method returns Section object for a Employee
     * 
     * @param employeeId
     * @return
     */
//	public Section getSectionByEmployeeId(long employeeId);
	
	 /**
	 * This method returns list of Grievance objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Grievance objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    public List<Section> findByProperty(String propertyName, Object value);	    
    
   // public List<Section> findByCondition(String condition);
    
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Section merge(Section user); 


}
