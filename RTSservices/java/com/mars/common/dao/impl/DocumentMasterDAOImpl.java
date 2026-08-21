package com.mars.common.dao.impl;


import java.util.ArrayList;
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

import com.mars.common.dao.DocumentMasterDAO;
import com.mars.common.model.DocumentMaster;
import com.mars.common.search.DocumentMasterSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: DocumentMasterDaoImpl.java </p>

 * @see com.mars.common.model.DocumentMaster
 
 * <p>Description: This class is used for hibernate operations for DocumentMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("documentMasterDAO") 
public class DocumentMasterDAOImpl extends HibernateDaoSupport implements DocumentMasterDAO {

    private static final Log log = LogFactory.getLog(DocumentMasterDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns DocumentMaster object for a given Id
	 * 
	 * @param id as long
	 * @return DocumentMaster as model object
	 */
	public DocumentMaster get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DocumentMaster) getHibernateTemplate().get(DocumentMaster.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the DocumentMaster information to the database.
	 * 
	 * @param DocumentMaster object
	 * 
	 */
	public void save(DocumentMaster entity) {
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
	 * This method to merge the DocumentMaster information to the database.
	 * 
	 * @param DocumentMaster object
	 * 
	 */
    public DocumentMaster merge(DocumentMaster entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (DocumentMaster) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting DocumentMaster instance");
        	}
        	DocumentMaster entity = (DocumentMaster) getHibernateTemplate().load(DocumentMaster.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all DocumentMaster from the database
	 * 
	 * @return List of DocumentMaster
	 */
	public List<DocumentMaster> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for DocumentMaster");
			}
			CommonUtils.setFilter(getSession());
			return getHibernateTemplate().loadAll(DocumentMaster.class);
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
     * @param listDocumentMaster as List
     */
    public void deleteAll(List<DocumentMaster> listDocumentMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for DocumentMaster");
	    	}
	    	getHibernateTemplate().deleteAll(listDocumentMaster);
	    	log.debug("deleted successfuly a list of DocumentMaster records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of DocumentMaster information to the database.
     * 
     * @param listDocumentMaster as List
     * 
     */
    public void saveAll(List<DocumentMaster> listDocumentMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listDocumentMaster);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the DocumentMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getDocumentMasterList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select documentMaster from DocumentMaster documentMaster";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			CommonUtils.setFilter(getSession());
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			List<DocumentMaster> list = query.list();
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
	 * This method returns list of the DocumentMaster objects available based on Search.
	 * 
	 * @param DocumentMasterSearch searchDocumentMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getDocumentMasterListBySearch(DocumentMasterSearch searchDocumentMaster){
		if(log.isDebugEnabled()){
			log.debug("getDocumentMasterListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchDocumentMaster.getCurrentPage();
			String orderBy=searchDocumentMaster.getOrderBy();
			String sortBy=searchDocumentMaster.getSortBy();
			
			String description=CommonUtils.getEscapedSQLString(searchDocumentMaster.getDescription());
			long stageId=searchDocumentMaster.getStageId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select documentMaster from DocumentMaster documentMaster";
			List<DocumentMaster> list=null;
			boolean flag=false;
			
			if(description!=null && description.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(documentMaster.description) like upper(:description)");
			}
			if(stageId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("documentMaster.stage.stageId=:stageId");
			}
			
			sql.insert(0, fromClause).append(" order by "+ orderBy +" "+ sortBy);
			CommonUtils.setFilter(getSession());
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			
			if(description!=null && description.length()>0){
				query.setString("description", "%"+description.toUpperCase()+"%");
			}
			if(stageId>0){
				query.setLong("stageId", stageId);
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
	 * This method returns count of the DocumentMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getDocumentMasterCount(){
	    try {
			String fromClause = "select count(*) from DocumentMaster documentMaster";
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
	 * This method returns count of the DocumentMaster objects available based on search criteria.
	 * @param DocumentMasterSearch searchDocumentMaster
	 * @return long
	 * @exception Exception
	 */
	public long getDocumentMasterCountBySearch(DocumentMasterSearch searchDocumentMaster){
		if(log.isDebugEnabled()){
			log.debug("getDocumentMasterCountBySearch Method is called");
		}
		
		try{
			String description=CommonUtils.getEscapedSQLString(searchDocumentMaster.getDescription());
			long stageId=searchDocumentMaster.getStageId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(documentMaster) from DocumentMaster documentMaster";
			List list=null;
			boolean flag=false;
			
			if(description!=null && description.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(documentMaster.description) like upper(:description)");
			}
			if(stageId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("documentMaster.stage.stageId=:stageId");
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			CommonUtils.setFilter(getSession());
			if(description!=null && description.length()>0){
				query.setString("description", "%"+description.toUpperCase()+"%");
			}
			if(stageId>0){
				query.setLong("stageId", stageId);
			}
			
			
			list=query.list();
			
			if(list!=null && list.size()>0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
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
	 * This method returns list of DocumentMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
			CommonUtils.setFilter(getSession());
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}	
    
    /**
	 * This method returns list of DocumentMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(DocumentMaster.class);
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
			CommonUtils.setFilter(getSession());
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
	 * This method returns list of DocumentMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding DocumentMaster instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select documentMaster from DocumentMaster documentMaster where documentMaster."+ propertyName + "= ?";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, value);
		    CommonUtils.setFilter(getSession());
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}	

	/**
	 * This method returns DocumentMaster object for a given data
	 * 
	 * @param DocumentMaster as documentMaster
	 * @return DocumentMaster as model object
	 */
	public DocumentMaster checkForDuplicates(DocumentMaster documentMaster)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select documentMaster from DocumentMaster documentMaster where " ;

			if(documentMaster.getDocumentMasterId() > 0)		
				fromClause = fromClause +" documentMasterId <> "+documentMaster.getDocumentMasterId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" documentMaster.{Many-to-one}.{Many-to-one}Id = "+documentMaster.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(description) = upper('"+ CommonUtils.getEscapedSQLString(documentMaster.getDescription()) +"')) and " ;
			fromClause = fromClause +" stage.stageId = "+ documentMaster.getStage().getStageId();
		
			CommonUtils.setFilter(getSession());
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (DocumentMaster) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public void SaveOrUpdateDocumentCheckListByentity(String docDmschecklistId,long entityId) {
		if( log.isDebugEnabled() ) {
			log.debug( "DeleteDocumentCheckListByentity Method is called" );
		}
		try{
			String sqlQuery ="update dms_document_check_list set entity_id ="+entityId+" where dms_document_check_list_id in ("+docDmschecklistId+")";
			Query query = getSession().createSQLQuery(sqlQuery);
			int count = query.executeUpdate();
		}catch (Exception exception) {
			log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
	}
	
	@Override
	public void DeleteDocumentCheckListByentity(String entityName, long entityId) {
		
		if( log.isDebugEnabled() ) {
			log.debug( "DeleteDocumentCheckListByentity Method is called" );
		}
		try{
			String sqlQuery ="Delete from dms_document_check_list where entity_id ="+entityId+" and entity_name='"+entityName+"'";
			Query query = getSession().createSQLQuery(sqlQuery);
			int count = query.executeUpdate();
		}catch (Exception exception) {
			log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		
	}
}

