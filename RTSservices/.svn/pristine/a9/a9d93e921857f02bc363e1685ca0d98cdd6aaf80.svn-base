package com.mars.workflow.dao.impl;


import java.util.ArrayList;
import java.util.Collection;
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

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.workflow.dao.WorkflowTemplateUserMappingDAO;
import com.mars.workflow.model.WorkflowTemplateUserMapping;
import com.mars.workflow.model.WorkflowTemplateUserMappingSearch;
 /**

 * <p>Title: WorkflowTemplateUserMappingDaoImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMapping
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateUserMapping module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("workflowTemplateUserMappingDAO")  
public class WorkflowTemplateUserMappingDAOImpl extends HibernateDaoSupport implements WorkflowTemplateUserMappingDAO {

    private static final Log log = LogFactory.getLog(WorkflowTemplateUserMappingDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns WorkflowTemplateUserMapping object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateUserMapping as model object
	 */
	public WorkflowTemplateUserMapping get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
     CommonUtils.setFilter(getSession());
			return (WorkflowTemplateUserMapping) getHibernateTemplate().get(WorkflowTemplateUserMapping.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the WorkflowTemplateUserMapping information to the database.
	 * 
	 * @param WorkflowTemplateUserMapping object
	 * 
	 */
	public void save(WorkflowTemplateUserMapping entity) {
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
	 * This method to merge the WorkflowTemplateUserMapping information to the database.
	 * 
	 * @param WorkflowTemplateUserMapping object
	 * 
	 */
    public WorkflowTemplateUserMapping merge(WorkflowTemplateUserMapping entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (WorkflowTemplateUserMapping) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting WorkflowTemplateUserMapping instance");
        	}
        	WorkflowTemplateUserMapping entity = (WorkflowTemplateUserMapping) getHibernateTemplate().load(WorkflowTemplateUserMapping.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all WorkflowTemplateUserMapping from the database
	 * 
	 * @return List of WorkflowTemplateUserMapping
	 */
	public List<WorkflowTemplateUserMapping> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for WorkflowTemplateUserMapping");
			}
			return getHibernateTemplate().loadAll(WorkflowTemplateUserMapping.class);
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
     * @param listWorkflowTemplateUserMapping as List
     */
    public void deleteAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for WorkflowTemplateUserMapping");
	    	}
	    	getHibernateTemplate().deleteAll(listWorkflowTemplateUserMapping);
	    	log.debug("deleted successfuly a list of WorkflowTemplateUserMapping records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of WorkflowTemplateUserMapping information to the database.
     * 
     * @param listWorkflowTemplateUserMapping as List
     * 
     */
    public void saveAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listWorkflowTemplateUserMapping);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the WorkflowTemplateUserMapping objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping";
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

			List<WorkflowTemplateUserMapping> list = query.list();
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
	 * This method returns count of the WorkflowTemplateUserMapping objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWorkflowTemplateUserMappingCount(){
	    try {
			String fromClause = "select count(*) from WorkflowTemplateUserMapping workflowTemplateUserMapping";
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
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByHqlQuery(String hqlQuery) 
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
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(WorkflowTemplateUserMapping.class);
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
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding WorkflowTemplateUserMapping instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping where workflowTemplateUserMapping."+ propertyName + "= ?";
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
	 * This method returns WorkflowTemplateUserMapping object for a given data
	 * 
	 * @param WorkflowTemplateUserMapping as workflowTemplateUserMapping
	 * @return WorkflowTemplateUserMapping as model object
	 */
	public WorkflowTemplateUserMapping checkForDuplicates(WorkflowTemplateUserMapping workflowTemplateUserMapping)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping where " ;

			if(workflowTemplateUserMapping.getWorkflowTemplateUserMappingId() > 0)		
				fromClause = fromClause +" workflowTemplateUserMappingId <> :workflowTemplateUserMappingId and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" workflowTemplateUserMapping.{Many-to-one}.{Many-to-one}Id = "+workflowTemplateUserMapping.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(workflowTemplateUserMapping.getName()) +"')) " ;
			fromClause = fromClause +" workflowTemplate.workflowTemplateId = :workflowTemplateId and ";
			fromClause = fromClause +" area.areaId = :areaId";

			Query query = getSession().createQuery(fromClause);		
			if(workflowTemplateUserMapping.getWorkflowTemplateUserMappingId() > 0)	
				query.setLong("workflowTemplateUserMappingId", workflowTemplateUserMapping.getWorkflowTemplateUserMappingId());
			query.setLong("workflowTemplateId", workflowTemplateUserMapping.getWorkflowTemplate().getWorkflowTemplateId());
			query.setLong("areaId",workflowTemplateUserMapping.getArea().getAreaId());
			
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (WorkflowTemplateUserMapping) list.get(0);

		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	public WorkflowTemplateUserMapping getByEntityAndArea(long workflowTemplateId,long areaId)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping where " ;


			fromClause = fromClause +" workflowTemplate.workflowTemplateId = :workflowTemplateId ";
			fromClause = fromClause +" and area.areaId = :areaId";

			Query query = getSession().createQuery(fromClause);		
			query.setLong("workflowTemplateId", workflowTemplateId);
			query.setLong("areaId",areaId);
			
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (WorkflowTemplateUserMapping) list.get(0);

		} catch (Exception exception)
		{
			log.error(exception.getStackTrace(),exception);
	    	exception.printStackTrace();
		}
		return null;
	}
	

	public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingListBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping)
	{
		if(log.isDebugEnabled()){
			log.debug("getWorkflowTemplateUserMappingListBySearch Method is called");
		}
		try{
			long pageNumber=searchWorkflowTemplateUserMapping.getCurrentPage();
			String orderBy=searchWorkflowTemplateUserMapping.getOrderBy();
			String sortBy=searchWorkflowTemplateUserMapping.getSortBy();
			
			//long searchWorkflowTemplateUserMappingId=searchWorkflowTemplateUserMapping.getWorkflowTemplateUserMappingId();
			long searchWorkflowTemplateId=searchWorkflowTemplateUserMapping.getWorkflowTemplateId();
			long searchAreaId=searchWorkflowTemplateUserMapping.getAreaId();
			//long tenancyId=searchWorkflowTemplateUserMapping.getTenancyid();

			StringBuffer sql=new StringBuffer();
			String fromClause="select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping";
			List<WorkflowTemplateUserMapping> list=null;
			boolean flag=false;
			
			/*if(searchWorkflowTemplateUserMappingId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMappingId="+ searchWorkflowTemplateUserMappingId);
			}*/
			if(searchWorkflowTemplateId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMapping.workflowTemplate.workflowTemplateId=:searchWorkflowTemplateId");
			}
			if(searchAreaId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMapping.area.areaId=:searchAreaId");
			}
			/*if(tenancyId>0){
				
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
			   sql.append("user.tenancy.tenancyId="+tenancyId+" ");
			}*/
			sql.insert(0, fromClause).append(" order by "+ orderBy +" "+ sortBy);
			Query query=getSession().createQuery(sql.toString());
			if(searchWorkflowTemplateId > 0){
				query.setLong("searchWorkflowTemplateId", searchWorkflowTemplateId);
			}
			if(searchAreaId > 0){
				query.setLong("searchAreaId", searchAreaId);
			}
			
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
		}catch (NullPointerException nullpointerexception)
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
	
	public long getWorkflowTemplateUserMappingCountBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping)
	{
		if(log.isDebugEnabled()){
			log.debug("getWorkflowTemplateUserMappingCountBySearch Method is called");
		}
		try{
			//long searchWorkflowTemplateUserMappingId=searchWorkflowTemplateUserMapping.getWorkflowTemplateUserMappingId();
			long searchWorkflowTemplateId=searchWorkflowTemplateUserMapping.getWorkflowTemplateId();
			long searchAreaId=searchWorkflowTemplateUserMapping.getAreaId();
			//long tenancyId=searchWorkflowTemplateUserMapping.getTenancyid();

			StringBuffer sql=new StringBuffer();
			String fromClause="select count(workflowTemplateUserMapping) from WorkflowTemplateUserMapping workflowTemplateUserMapping";
			List list=null;
			boolean flag=false;
			
			/*if(searchWorkflowTemplateUserMappingId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMappingId="+ searchWorkflowTemplateUserMappingId);
			}*/
			if(searchWorkflowTemplateId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMapping.workflowTemplate.workflowTemplateId=:searchWorkflowTemplateId");
			}
			if(searchAreaId > 0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("workflowTemplateUserMapping.area.areaId=:searchAreaId");
			}
           /* if(tenancyId>0){
				
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
			   sql.append("user.tenancy.tenancyId="+tenancyId+" ");
			}*/
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			if(searchWorkflowTemplateId > 0){
				query.setLong("searchWorkflowTemplateId", searchWorkflowTemplateId);
			}
			if(searchAreaId > 0){
				query.setLong("searchAreaId", searchAreaId);
			}
			
			list=query.list();
					
			if(list!=null && list.size()>0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		}catch (NullPointerException nullpointerexception)
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
	
	public List<WorkflowTemplateUserMapping> getByArea(long areaId)
	{
		 
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select workflowTemplateUserMapping from WorkflowTemplateUserMapping workflowTemplateUserMapping where area.areaId ="+ areaId;

			Query query = getSession().createQuery(fromClause);		
			
			List<WorkflowTemplateUserMapping> list = query.list();

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

