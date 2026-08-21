package com.mars.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Reports;
import com.mars.common.utils.AuditTrail;

/**
 * <p>Title: ReportsService.java </p>

 * <p>Description: This interface is used for service implementations related to Reports</p>

 * @see com.egov.dpse.model.Reports
 
 * Copyright (c) 2014 for eGovernance Goa 

 * @version: 1.0

 * 
 * 
 */
@Transactional(readOnly = true)
public interface ReportsService
{

    /**
     * This method returns Reports object for a given Id
     * 
     * @param id as long
     * @return Reports as model object
     */
    public Reports get(long id);

    /**
     * This method save/updates the Reports information to the database.
     * 
     * @param Reports object
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void save(Reports entity);

    /**
     * This method save/updates the Reports information to the database.
     * 
     * @param Reports object
     * @param deleteIds as String
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void save(Reports entity,String deleteIds);
    
    /**
     * This method delete Reports for a given Id
     * 
     * @param id as long
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id);

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getAll();

    /**
     * This method save/updates a list of Reports information to the database.
     * 
     * @param listReports as List
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Reports> listReports);

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listReports as List
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Reports> listReports);

    /**
     * This method returns list of the Reports objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Reports> getReportsList(long pageNumber, String orderBy, String sortBy);

    /**
     * This method returns list of the Report objects available 
     * based on Search Criteria.
     * 
     * @param Reports searchOptions
     * @return List
     * @exception Exception
     */
     public List<Reports> getReportsListBySearch(Reports searchOptions);
     
     /**
      * This method returns count of the Reports objects from the database 
      * based on Search Criteria
      * 
      * @param Reports searchOptions
      * @return long
      * @exception Exception
      */
     public long getReportsCountBySearch(Reports searchOptions);
     
    /**
     * This method returns count of the Reports objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getReportsCount();

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getReportListByCategory(String reportType);
    
    /**
     * This method will return a list of all Audit Trail Entities present in Audit Table
     * 
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityList();
    
    /**
     * This method will return a list of all Audit Trail Entity Properties present in Audit Table
     * @param String entityName
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityPropertyList(String entityName);
    
    public Reports getReportOnName(String reportName);
    
}
