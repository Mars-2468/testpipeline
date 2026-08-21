package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.NodeMaster;
import com.mars.common.search.NodeMasterSearch;
/**
* <p>Title: NodeMasterService.java </p>

 * <p>Description: This interface is used for service implementations related to NodeMaster</p>

 * @see com.mars.common.model.NodeMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface NodeMasterService {
  
	/**
	 * This method returns NodeMaster object for a given Id
	 * 
	 * @param id as long
	 * @return NodeMaster as model object
	 */
	public NodeMaster get(long id);
		
    /**
	 * This method save/updates the NodeMaster information to the database.
	 * 
	 * @param NodeMaster object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(NodeMaster entity);
	  
	/**
	 * This method to merge the NodeMaster information to the database.
	 * 
	 * @param NodeMaster object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public NodeMaster merge(NodeMaster entity); 
	    
    /**
	 * This method delete NodeMaster for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all NodeMaster from the database
	 * 
	 * @return List of NodeMaster
	 */
	public List<NodeMaster> getAll();
	
	/**
     * This method save/updates a list of NodeMaster information to the database.
     * 
     * @param listNode as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<NodeMaster> listNode);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listNode as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<NodeMaster> listNode);
    
	    /**
		 * This method returns list of the NodeMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<NodeMaster> getNodeList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the NodeMaster objects available based on Search.
		 * 
		 * @param NodeMasterSearch searchNodeMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<NodeMaster> getNodeListBySearch(NodeMasterSearch searchNodeMaster);
		
		/**
		 * This method returns count of the NodeMaster objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getNodeCount();
	
		
		/**
		 * This method returns count of the NodeMaster objects from the database based on Search
		 * @param NodeMasterSearch searchNodeMaster
		 * @return long
		 * @exception Exception
		 */
		public long getNodeCountBySearch(NodeMasterSearch searchNodeMaster);
	
	/**
	 * This method returns list of NodeMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<NodeMaster> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns NodeMaster object for a given data
	 * 
	 * @param NodeMaster as node
	 * @return NodeMaster as model object
	 */
	public NodeMaster checkForDuplicates(NodeMaster node);    

    /**
	 * This method returns list of NodeMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of NodeMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<NodeMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

