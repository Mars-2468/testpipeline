package com.mars.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.ReportsDAO;
import com.mars.common.model.ReportParameters;
import com.mars.common.model.Reports;
import com.mars.common.utils.AuditTrail;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**

 * <p>Title: ReportsDaoImpl.java </p>

 * @see com.egov.dpse.model.Reports
 
 * <p>Description: This class is used for hibernate operations for Reports module</p>

 * Copyright (c) 2014 for eGovernance Goa 

 * @version: 1.0

 * 
 
 */
@Repository("reportsDAO")
public class ReportsDAOImpl extends HibernateDaoSupport implements ReportsDAO
{

    private static final Log log = LogFactory.getLog(ReportsDAOImpl.class);
    
    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
    /**
     * This method returns Reports object for a given Id
     * 
     * @param id as long
     * @return Reports as model object
     */
    public Reports get(long id)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("get Method is called " + id);
	    }
	    return (Reports) getHibernateTemplate().get(Reports.class, new Long(id));
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

    /**
     * This method save/updates the Reports information to the database.
     * 
     * @param Reports object
     * 
     */
    public void save(Reports entity)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("save Method is called ");
	    }
	    getHibernateTemplate().saveOrUpdate(entity);
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

    /**
     * This method save/updates the Reports information to the database.
     * 
     * @param Reports object
     * @param deleteIds as String
     * 
     */
    public void save(Reports entity,String deleteIds)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("save Method is called ");
	    }
	    
		if (deleteIds != null && deleteIds.length() > 0 && !deleteIds.equalsIgnoreCase("undefined")) {
			String strIds[] = deleteIds.split(",");
			for (String deleteId : strIds) {
				ReportParameters reportParameters = getReportParameters(Long.parseLong(deleteId));
				if (reportParameters != null) {
					getHibernateTemplate().delete(reportParameters);
				}
			}
		}
		
	    getHibernateTemplate().saveOrUpdate(entity);
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
    
    private ReportParameters getReportParameters(long id) {
        try {
          if (log.isDebugEnabled()) {
            log.debug("getReportParams Method is called " + id);
          }
          return (ReportParameters) getHibernateTemplate().get(ReportParameters.class, new Long(id));
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
    
    /**
     * This method is used to delete a record from the database using hibernate.
     * 
     * @param id as long
     */
    public void delete(long id)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("deleting Reports instance");
	    }
	    Reports entity = (Reports) getHibernateTemplate().load(Reports.class, new Long(id));
	    getHibernateTemplate().delete(entity);
	    log.debug("delete successful");
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

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getAll()
    {
	try
	{

	    if (log.isDebugEnabled())
	    {
		log.debug("get all Method is called for Reports");
	    }
	    return getHibernateTemplate().loadAll(Reports.class);
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

    /**
     * This method will return a list of all Reports from the database
     * 
     * @return List of Reports
     */
    public List<Reports> getReportListByCategory(String reportType)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("get all Method is called for Reports");
	    }
	    String fromClause = "select reports from Reports reports where reports.reportType=:reportType ";
	    fromClause = fromClause + " order by reports.reportsId, reports.reportDisplayName asc";
	    Query query = getSession().createQuery(fromClause);
	    query.setParameter("reportType", reportType);
	    List<Reports> list = query.list();
	    return list;
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
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listReports as List
     */
    public void deleteAll(List<Reports> listReports)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("deleteAll Method is called for Reports");
	    }
	    getHibernateTemplate().deleteAll(listReports);
	    log.debug("deleted successfuly a list of Reports records from database");
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

    /**
     * This method save/updates a list of Reports information to the database.
     * 
     * @param listReports as List
     * 
     */
    public void saveAll(List<Reports> listReports)
    {
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("saveAll Method is called ");
	    }
	    getHibernateTemplate().saveOrUpdateAll(listReports);
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

	try
	{
	    String fromClause = "select reports from Reports reports";
	    fromClause = fromClause + " order by " + orderBy + " " + sortBy;
	    Query query = getSession().createQuery(fromClause);

	    if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue())
	    {
		if (pageNumber > 1)
		{
		    query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
		} else
		{
		    query.setFirstResult(0);
		    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
		}
	    }

	    List<Reports> list = query.list();

	    if (list != null && list.size() > 0)
	    {
		return list;
	    }
	    return null;
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

    /**
     * This method returns list of the Report objects available based on Search Criteria.
     * 
     * @param Reports searchOptions
     * @return List
     * @exception Exception
     */
     public List<Reports> getReportsListBySearch(Reports searchOptions) {
		try
		{
			long pageNumber = searchOptions.getCurrentPage();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();

			String reportName = CommonUtils.getEscapedSQLString(searchOptions.getReportName());
			String reportDisplayName = CommonUtils.getEscapedSQLString(searchOptions.getReportDisplayName());
			String reportPath = CommonUtils.getEscapedSQLString(searchOptions.getReportPath());
			String reportType = CommonUtils.getEscapedSQLString(searchOptions.getReportType());
			
			int count = 0;
			StringBuffer sql = new StringBuffer();
		    String fromClause = "select reports from Reports reports ";
		    
			if (reportName != null && reportName.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportName) like :reportName ");
			}		    
		    
			if (reportDisplayName != null && reportDisplayName.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportDisplayName) like :reportDisplayName ");
			}	
			
			if (reportPath != null && reportPath.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportPath) like :reportPath ");
			}	
			
			if (reportType != null && reportType.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportType) like :reportType ");
			}
			
		    sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);

			Query query = getSession().createQuery(sql.toString());
			if (reportName != null && reportName.length() > 0)
				query.setParameter("reportName", "%"+reportName.toUpperCase()+"%");
			if (reportDisplayName != null && reportDisplayName.length() > 0)
				query.setParameter("reportDisplayName", "%"+reportDisplayName.toUpperCase()+"%");
			if (reportPath != null && reportPath.length() > 0)
				query.setParameter("reportPath", "%"+reportPath.toUpperCase()+"%");
			if (reportType != null && reportType.length() > 0)
				query.setParameter("reportType", "%"+reportType.toUpperCase()+"%");
			
		    if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue())
		    {
			if (pageNumber > 1)
			{
			    query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
			    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
			} else
			{
			    query.setFirstResult(0);
			    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
			}
		    }

		    List<Reports> list = query.list();

		    if (list != null && list.size() > 0)
		    {
			return list;
		    }
		    return null;
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
    
     /**
      * This method returns count of the Reports objects from the database 
      * based on Search Criteria
      * 
      * @param Reports searchOptions
      * @return long
      * @exception Exception
      */
     public long getReportsCountBySearch(Reports searchOptions) {
 		try
		{
			long pageNumber = searchOptions.getCurrentPage();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();

			String reportName = CommonUtils.getEscapedSQLString(searchOptions.getReportName());
			String reportDisplayName = CommonUtils.getEscapedSQLString(searchOptions.getReportDisplayName());
			String reportPath = CommonUtils.getEscapedSQLString(searchOptions.getReportPath());
			String reportType = CommonUtils.getEscapedSQLString(searchOptions.getReportType());
			
			int count = 0;
			StringBuffer sql = new StringBuffer();
		    String fromClause = "select count(*) from Reports reports ";
		    
		    if (reportName != null && reportName.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportName) like :reportName ");
			}		    
		    
			if (reportDisplayName != null && reportDisplayName.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportDisplayName) like :reportDisplayName ");
			}	
			
			if (reportPath != null && reportPath.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportPath) like :reportPath ");
			}	
			
			if (reportType != null && reportType.length() > 0) {
				if (count == 0) {
					count++;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("UPPER(reportType) like :reportType ");
			}
			
		    sql.insert(0, fromClause);

			Query query = getSession().createQuery(sql.toString());
			if (reportName != null && reportName.length() > 0)
				query.setParameter("reportName", "%"+reportName.toUpperCase()+"%");
			if (reportDisplayName != null && reportDisplayName.length() > 0)
				query.setParameter("reportDisplayName", "%"+reportDisplayName.toUpperCase()+"%");
			if (reportPath != null && reportPath.length() > 0)
				query.setParameter("reportPath", "%"+reportPath.toUpperCase()+"%");
			if (reportType != null && reportType.length() > 0)
				query.setParameter("reportType", "%"+reportType.toUpperCase()+"%");
			List list = query.list();

			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;

		} catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw nullpointerexception;
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
     
     
    /**
     * This method returns count of the Reports objects available based on search criteria.
     * 
     * @return long
     * @exception Exception
     */
    public long getReportsCount()
    {
	try
	{
	    String fromClause = "select count(*) from Reports reports";
	    Query query = getSession().createQuery(fromClause);
	    List list = query.list();

	    if (list != null && list.size() > 0)
	    {
		return Long.parseLong(list.get(0).toString());
	    }
	    return 0;
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
    
    /**
     * This method will return a list of all Audit Trail Entities present in Audit Table
     * 
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityList()
    {
		List<AuditTrail> auditTrailList = new ArrayList<AuditTrail>();

		try {
    		SQLQuery query = getSession().createSQLQuery("select distinct ENTITY_NAME from AUDIT_TRAIL order by ENTITY_NAME");
    		query.addScalar("ENTITY_NAME", Hibernate.STRING);
		    List<String> list = query.list();

		    if (list != null && list.size() > 0)
		    {
				for (String entityName : list) {
					AuditTrail auditTrail = new AuditTrail();
	   				auditTrail.setEntityName(entityName);
	    			auditTrailList.add(auditTrail);
				}
		    }
    		    
		}catch (Exception exception) {
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
		
	    return auditTrailList;
    }
    
    /**
     * This method will return a list of all Audit Trail Entity Properties present in Audit Table
     * @param String entityName
     * @return List of AuditTrail objects
     */    
    public List<AuditTrail>  getAuditTrailEntityPropertyList(String entityName)
    {
		List<AuditTrail> auditTrailList = new ArrayList<AuditTrail>();

		try {
			String query1 = "select distinct ENTITY_PROPERTY from AUDIT_TRAIL ";
    		
    		if (entityName != null && entityName.length() > 0)	
    			query1 = query1 + " where ENTITY_NAME = :entityName  ";
    				
    		query1 = query1 + " order by ENTITY_PROPERTY";			
    		SQLQuery query = getSession().createSQLQuery(query1);
    		if (entityName != null && entityName.length() > 0)	
    			query.setParameter("entityName", entityName);
    		query.addScalar("ENTITY_PROPERTY", Hibernate.STRING);
		    List<String> list = query.list();

		    if (list != null && list.size() > 0)
		    {
				for (String propertyName : list) {
					AuditTrail auditTrail = new AuditTrail();
					auditTrail.setPropertyName(propertyName);
	    			auditTrailList.add(auditTrail);
				}
		    }
    		    
		}catch (Exception exception) {
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
		
	    return auditTrailList;
    }
    
    public Reports getReportOnName(String reportName){
    	try
    	{
    	    String fromClause = "select reports from Reports reports where upper(reports.reportName)=upper('"+reportName+"')";
    	    Query query = getSession().createQuery(fromClause);    	    

    	    List<Reports> list = query.list();

    	    if (list != null && list.size() > 0)
    	    {
    		return (Reports)list.get(0);
    	    }
    	    return null;
    	}catch (Exception exception)
    	{
    	    exception.printStackTrace();
    	}
		return null;
    }

}
