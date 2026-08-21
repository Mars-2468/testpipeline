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
import com.mars.workflow.dao.WorkflowTemplateUserMappingDetailsDAO;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
 /**

 * <p>Title: WorkflowTemplateUserMappingDetailsDaoImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMappingDetails
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateUserMappingDetails module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("workflowTemplateUserMappingDetailsDAO")  
public class WorkflowTemplateUserMappingDetailsDAOImpl extends HibernateDaoSupport implements WorkflowTemplateUserMappingDetailsDAO {

    private static final Log log = LogFactory.getLog(WorkflowTemplateUserMappingDetailsDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns WorkflowTemplateUserMappingDetails object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateUserMappingDetails as model object
	 */
	public WorkflowTemplateUserMappingDetails get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WorkflowTemplateUserMappingDetails) getHibernateTemplate().get(WorkflowTemplateUserMappingDetails.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the WorkflowTemplateUserMappingDetails information to the database.
	 * 
	 * @param WorkflowTemplateUserMappingDetails object
	 * 
	 */
	public void save(WorkflowTemplateUserMappingDetails entity) {
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
	 * This method to merge the WorkflowTemplateUserMappingDetails information to the database.
	 * 
	 * @param WorkflowTemplateUserMappingDetails object
	 * 
	 */
    public WorkflowTemplateUserMappingDetails merge(WorkflowTemplateUserMappingDetails entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (WorkflowTemplateUserMappingDetails) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting WorkflowTemplateUserMappingDetails instance");
        	}
        	WorkflowTemplateUserMappingDetails entity = (WorkflowTemplateUserMappingDetails) getHibernateTemplate().load(WorkflowTemplateUserMappingDetails.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all WorkflowTemplateUserMappingDetails from the database
	 * 
	 * @return List of WorkflowTemplateUserMappingDetails
	 */
	public List<WorkflowTemplateUserMappingDetails> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for WorkflowTemplateUserMappingDetails");
			}
			return getHibernateTemplate().loadAll(WorkflowTemplateUserMappingDetails.class);
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
     * @param listWorkflowTemplateUserMappingDetails as List
     */
    public void deleteAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for WorkflowTemplateUserMappingDetails");
	    	}
	    	getHibernateTemplate().deleteAll(listWorkflowTemplateUserMappingDetails);
	    	log.debug("deleted successfuly a list of WorkflowTemplateUserMappingDetails records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of WorkflowTemplateUserMappingDetails information to the database.
     * 
     * @param listWorkflowTemplateUserMappingDetails as List
     * 
     */
    public void saveAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listWorkflowTemplateUserMappingDetails);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the WorkflowTemplateUserMappingDetails objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getWorkflowTemplateUserMappingDetailsList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select workflowTemplateUserMappingDetails from WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails";
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

			List<WorkflowTemplateUserMappingDetails> list = query.list();
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
	 * This method returns count of the WorkflowTemplateUserMappingDetails objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWorkflowTemplateUserMappingDetailsCount(){
	    try {
			String fromClause = "select count(*) from WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails";
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
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByHqlQuery(String hqlQuery) 
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
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(WorkflowTemplateUserMappingDetails.class);
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
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding WorkflowTemplateUserMappingDetails instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select workflowTemplateUserMappingDetails from WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails where workflowTemplateUserMappingDetails."+ propertyName + "= ?";
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
	 * This method returns WorkflowTemplateUserMappingDetails object for a given data
	 * 
	 * @param WorkflowTemplateUserMappingDetails as workflowTemplateUserMappingDetails
	 * @return WorkflowTemplateUserMappingDetails as model object
	 */
	public WorkflowTemplateUserMappingDetails checkForDuplicates(WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateUserMappingDetails from WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails where " ;

			if(workflowTemplateUserMappingDetails.getWorkflowTemplateUserMappingDetailsId() > 0)		
				fromClause = fromClause +" workflowTemplateUserMappingDetailsId <> :workflowTemplateUserMappingDetailsId and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" workflowTemplateUserMappingDetails.{Many-to-one}.{Many-to-one}Id = "+workflowTemplateUserMappingDetails.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(workflowTemplateUserMappingDetails.getName()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);
			query.setLong("workflowTemplateUserMappingDetailsId",workflowTemplateUserMappingDetails.getWorkflowTemplateUserMappingDetailsId());
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (WorkflowTemplateUserMappingDetails) list.get(0);

		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public List<WorkflowTemplateUserMappingDetails> getByName(String userName) {
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateUserMappingDetails from WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails where workflowTemplateUserMappingDetails.userName="+"'"+userName+"'";

			Query query = getSession().createQuery(fromClause);		
			
			List<WorkflowTemplateUserMappingDetails> list = query.list();

			if (list != null && list.size() > 0) 
				return list;

		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
}

