package com.mars.workflow.dao.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.utils.Constants;
import com.mars.workflow.dao.WorkflowTemplateTaskDAO;
import com.mars.workflow.model.WorkflowTemplateTask;
 /**

 * <p>Title: WorkflowTemplateTaskDaoImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateTask
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateTask module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("workflowTemplateTaskDAO")  
public class WorkflowTemplateTaskDAOImpl extends HibernateDaoSupport implements WorkflowTemplateTaskDAO {

    private static final Log log = LogFactory.getLog(WorkflowTemplateTaskDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns WorkflowTemplateTask object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateTask as model object
	 */
	public WorkflowTemplateTask get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WorkflowTemplateTask) getHibernateTemplate().get(WorkflowTemplateTask.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the WorkflowTemplateTask information to the database.
	 * 
	 * @param WorkflowTemplateTask object
	 * 
	 */
	public void save(WorkflowTemplateTask entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
	}
    
     /**
	 * This method to merge the WorkflowTemplateTask information to the database.
	 * 
	 * @param WorkflowTemplateTask object
	 * 
	 */
    public WorkflowTemplateTask merge(WorkflowTemplateTask entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (WorkflowTemplateTask) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
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
        		log.debug("deleting WorkflowTemplateTask instance");
        	}
        	WorkflowTemplateTask entity = (WorkflowTemplateTask) getHibernateTemplate().load(WorkflowTemplateTask.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all WorkflowTemplateTask from the database
	 * 
	 * @return List of WorkflowTemplateTask
	 */
	public List<WorkflowTemplateTask> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for WorkflowTemplateTask");
			}
			return getHibernateTemplate().loadAll(WorkflowTemplateTask.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateTask as List
     */
    public void deleteAll(List<WorkflowTemplateTask> listWorkflowTemplateTask)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for WorkflowTemplateTask");
	    	}
	    	getHibernateTemplate().deleteAll(listWorkflowTemplateTask);
	    	log.debug("deleted successfuly a list of WorkflowTemplateTask records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of WorkflowTemplateTask information to the database.
     * 
     * @param listWorkflowTemplateTask as List
     * 
     */
    public void saveAll(List<WorkflowTemplateTask> listWorkflowTemplateTask)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listWorkflowTemplateTask);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the WorkflowTemplateTask objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getWorkflowTemplateTaskList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select workflowTemplateTask from WorkflowTemplateTask workflowTemplateTask";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}

			List<WorkflowTemplateTask> list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This method returns count of the WorkflowTemplateTask objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWorkflowTemplateTaskCount(){
	    try {
			String fromClause = "select count(*) from WorkflowTemplateTask workflowTemplateTask";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();
			
			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return 0;
	}
    
    
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
				    if(hstKeyValues.get(strKey) instanceof Collection){
						queryObject.setParameterList(strKey,(Collection)hstKeyValues.get(strKey));
				    } else {
				    	queryObject.setParameter(strKey,hstKeyValues.get(strKey));
				    }
				}
			}
	   		return queryObject.list();
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}	
    
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByHqlQuery(String hqlQuery) 
    {
		try 
	  	{
		    Query query = getSession().createQuery(hqlQuery);
			List list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
	
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(WorkflowTemplateTask.class);
			return query.list();
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
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
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
    }
    
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding WorkflowTemplateTask instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select workflowTemplateTask from WorkflowTemplateTask workflowTemplateTask where workflowTemplateTask."+ propertyName + "= ?";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, value);
	   		return queryObject.list();
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}	

	/**
	 * This method returns WorkflowTemplateTask object for a given data
	 * 
	 * @param WorkflowTemplateTask as workflowTemplateTask
	 * @return WorkflowTemplateTask as model object
	 */
	public WorkflowTemplateTask checkForDuplicates(WorkflowTemplateTask workflowTemplateTask)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateTask from WorkflowTemplateTask workflowTemplateTask where " ;

			if(workflowTemplateTask.getWorkflowTemplateTaskId() > 0)		
				fromClause = fromClause +" workflowTemplateTaskId <> :workflowTemplateTaskId and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" workflowTemplateTask.{Many-to-one}.{Many-to-one}Id = "+workflowTemplateTask.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(workflowTemplateTask.getName()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);		
			if(workflowTemplateTask.getWorkflowTemplateTaskId() > 0){
				query.setLong("workflowTemplateTaskId",workflowTemplateTask.getWorkflowTemplateTaskId());
			}
			
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (WorkflowTemplateTask) list.get(0);

		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;	
	}
}

