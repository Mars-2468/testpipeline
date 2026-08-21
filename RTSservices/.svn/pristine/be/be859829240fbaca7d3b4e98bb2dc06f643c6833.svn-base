package com.mars.common.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.ReportsDAO;
import com.mars.common.model.Reports;
import com.mars.common.service.ReportsService;
import com.mars.common.utils.AuditTrail;

/**

 * <p>Title: ReportsServiceImpl.java </p>

 * @see com.egov.dpse.model.Reports
 
 * <p>Description: This class is used for hibernate operations for Reports module</p>

 * Copyright (c) 2014 for eGovernance Goa 

 * @version: 1.0

 * 
 
 */
@Service("reportsService")
public class ReportsServiceImpl implements ReportsService
{

    private static final Log log = LogFactory.getLog(ReportsServiceImpl.class);
    
    @Autowired
    private ReportsDAO reportsDAO;

    public void setReportsDAO(ReportsDAO reportsDAO)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("setReportsDAO Method is called ");
	}
	this.reportsDAO = reportsDAO;
    }

    /**
     * This method is saves the Reports object
     * 
     * @param entity as Reports object
     * 
     * @return
     * 
     */
    public void save(Reports entity)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("save Method is called ");
	}
	reportsDAO.save(entity);
    }
    
    /**
     * This method is saves the Reports object
     * 
     * @param entity as Reports object
     * @param deleteIds as String
     * 
     * @return
     * 
     */
    public void save(Reports entity,String deleteIds)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("save Method is called ");
	}
	reportsDAO.save(entity,deleteIds);
    }

    /**
     * This method delete the reports
     * 
     * @param Id as long
     * @return
     * 
     */
    public void delete(long id)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("delete Method is called ");
	}
	reportsDAO.delete(id);
    }

    /**
     * This method is used to get the Model object from the database using
     * hibernate based on id
     * 
     * @param Id as long
     * @return a Reports Object
     * 
     */
    public Reports get(long id)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("get Method is called");
	}
	return reportsDAO.get(id);
    }

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getAll()
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getAll Method is called");
	}
	return reportsDAO.getAll();
    }

    /**
     * This method returns list of the Reports objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Reports> getReportsList(long pageNumber, String orderBy, String sortBy)
    {

	if (log.isDebugEnabled())
	{
	    log.debug("getReportsList Method is called");
	}
	return reportsDAO.getReportsList(pageNumber, orderBy, sortBy);
    }

    /**
     * This method returns list of the Report objects available based on Search Criteria.
     * 
     * @param Reports searchOptions
     * @return List
     * @exception Exception
     */
     public List<Reports> getReportsListBySearch(Reports searchOptions) {
		if (log.isDebugEnabled())
		{
		    log.debug("getReportsListBySearch Method is called");
		}
		return reportsDAO.getReportsListBySearch(searchOptions);    	 
     }
    
     /**
      * This method returns count of the Reports objects from the database 
      * based on Search Criteria
      * 
      * @param Reports searchOptions
      * @return long
      * @exception Exception
      */
     public long getReportsCountBySearch(Reports searchOptions) {
 		if (log.isDebugEnabled())
		{
		    log.debug("getReportsCountBySearch Method is called");
		}
		return reportsDAO.getReportsCountBySearch(searchOptions);  
     }
     
    /**
     * This method returns count of the Reports objects available based on search criteria.
     * 
     * @return long
     * @exception Exception
     */
    public long getReportsCount()
    {
	if (log.isDebugEnabled())
	{
	    log.debug("saveAll Method is called");
	}
	return reportsDAO.getReportsCount();
    }

    /**
     * This method save/updates a list of Reports information to the database.
     * 
     * @param listReports as List
     * 
     */
    public void saveAll(List<Reports> listReports)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("saveAll Method is called");
	}
	reportsDAO.saveAll(listReports);
    }

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listReports as List
     */
    public void deleteAll(List<Reports> listReports)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("deleteAll Method is called");
	}
	reportsDAO.deleteAll(listReports);
    }

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getReportListByCategory(String reportType){
	
	if (log.isDebugEnabled())
	{
	    log.debug("deleteAll Method is called");
	}
	return reportsDAO.getReportListByCategory(reportType);
    }
    
    /**
     * This method will return a list of all Audit Trail Entities present in Audit Table
     * 
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityList()
    {
    	if (log.isDebugEnabled())
    	{
    	    log.debug("getAuditTrailEntityList Method is called");
    	}
    	return reportsDAO.getAuditTrailEntityList();
    }
    
    /**
     * This method will return a list of all Audit Trail Entity Properties present in Audit Table
     * @param String entityName
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityPropertyList(String entityName)
    {
    	if (log.isDebugEnabled())
    	{
    	    log.debug("getAuditTrailEntityPropertyList Method is called");
    	}
    	return reportsDAO.getAuditTrailEntityPropertyList(entityName);
    }
    
    public Reports getReportOnName(String reportName){
    	
    	if (log.isDebugEnabled())
    	{
    	    log.debug("getAuditTrailEntityPropertyList Method is called");
    	}
    	return reportsDAO.getReportOnName(reportName);
    }    
}
