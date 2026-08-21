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

import com.mars.common.dao.NodeMasterDAO;
import com.mars.common.model.NodeMaster;
import com.mars.common.search.NodeMasterSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: NodeMasterDaoImpl.java </p>

 * @see com.mars.common.model.NodeMaster
 
 * <p>Description: This class is used for hibernate operations for NodeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("NodeMasterDAO")
public class NodeMasterDAOImpl extends HibernateDaoSupport implements NodeMasterDAO {

    private static final Log log = LogFactory.getLog(NodeMasterDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	/**
	 * This method returns NodeMaster object for a given Id
	 * 
	 * @param id as long
	 * @return NodeMaster as model object
	 */
	public NodeMaster get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (NodeMaster) getHibernateTemplate().get(NodeMaster.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the NodeMaster information to the database.
	 * 
	 * @param NodeMaster object
	 * 
	 */
	public void save(NodeMaster entity) {
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
	 * This method to merge the NodeMaster information to the database.
	 * 
	 * @param NodeMaster object
	 * 
	 */
    public NodeMaster merge(NodeMaster entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (NodeMaster) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting NodeMaster instance");
        	}
        	NodeMaster entity = (NodeMaster) getHibernateTemplate().load(NodeMaster.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all NodeMaster from the database
	 * 
	 * @return List of NodeMaster
	 */
	public List<NodeMaster> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for NodeMaster");
			}
			return getHibernateTemplate().loadAll(NodeMaster.class);
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
     * @param listNode as List
     */
    public void deleteAll(List<NodeMaster> listNode)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for NodeMaster");
	    	}
	    	getHibernateTemplate().deleteAll(listNode);
	    	log.debug("deleted successfuly a list of Node Master records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of NodeMaster information to the database.
     * 
     * @param listNode as List
     * 
     */
    public void saveAll(List<NodeMaster> listNode)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listNode);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the NodeMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getNodeList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select nodeMaster from NodeMaster nodeMaster";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			List<NodeMaster> list = query.list();
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
	 * This method returns list of the NodeMaster objects available based on Search.
	 * 
	 * @param NodeMasterSearch searchNodeMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getNodeListBySearch(NodeMasterSearch searchNodeMaster){
		if(log.isDebugEnabled()){
			log.debug("getNodeCountBySearch Method is called");
		}
		
		try{
			
			long pageNumber=searchNodeMaster.getCurrentPage();
			String orderBy=searchNodeMaster.getOrderBy();
			String sortBy=searchNodeMaster.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(searchNodeMaster.getName());
			long wardId=searchNodeMaster.getWardId();
			StringBuffer sql=new StringBuffer();
			String fromClause="select nodeMaster from NodeMaster nodeMaster";
			List<NodeMaster> list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(nodeMaster.name) like upper('%"+ name +"%')");
			}
			if(wardId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("nodeMaster.ward.wardId="+ wardId);
			}
			
			sql.insert(0, fromClause).append(" order by " +orderBy+ " "+ sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
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
	 * This method returns count of the NodeMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getNodeCount(){
	    try {
			String fromClause = "select count(*) from NodeMaster nodeMaster";
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
	 * This method returns count of the NodeMaster objects available based on search criteria.
	 * @param NodeMasterSearch searchNodeMaster
	 * @return long
	 * @exception Exception
	 */
	public long getNodeCountBySearch(NodeMasterSearch searchNodeMaster){
		if(log.isDebugEnabled()){
			log.debug("getNodeCountBySearch Method is called");
		}
		
		try{
			
			String name=CommonUtils.getEscapedSQLString(searchNodeMaster.getName());
			long wardId=searchNodeMaster.getWardId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(nodeMaster) from NodeMaster nodeMaster";
			List list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(nodeMaster.name) like upper('%"+ name +"%')");
			}
			
			if(wardId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("nodeMaster.ward.wardId=" + wardId);
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			list=query.list();
			
			if(list!=null && list.size()>0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		}catch (NullPointerException nullpointerexception) {
    		log.error(nullpointerexception.getStackTrace());
    		throw new NullPointerException();
    	} catch (HibernateException hibernateException) {
    		log.error(hibernateException.getStackTrace());
    		throw new HibernateException(hibernateException.getMessage());
    	} catch (Exception exception) {
    		log.error(exception.getStackTrace());
    		exception.printStackTrace();
    		throw new RuntimeException(exception.getCause());
    	}	
	}
	
	
	
    /**
	 * This method returns list of NodeMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}	
    
    /**
	 * This method returns list of NodeMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(NodeMaster.class);
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
	 * This method returns list of NodeMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding NodeMaster instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select nodeMaster from NodeMaster nodeMaster where nodeMaster."+ propertyName + "= ?";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, value);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}	

	/**
	 * This method returns NodeMaster object for a given data
	 * 
	 * @param NodeMaster as node
	 * @return NodeMaster as model object
	 */
	public NodeMaster checkForDuplicates(NodeMaster nodeMaster)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select nodeMaster from NodeMaster nodeMaster where " ;

			if(nodeMaster.getNodeMasterId() > 0)		
				fromClause = fromClause +" nodeMasterId <> "+nodeMaster.getNodeMasterId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" node.{Many-to-one}.{Many-to-one}Id = "+node.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(nodeMaster.getName()) +"')) and " ;
			fromClause = fromClause +" ward.wardId = "+ nodeMaster.getWard().getWardId();
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (NodeMaster) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
}

