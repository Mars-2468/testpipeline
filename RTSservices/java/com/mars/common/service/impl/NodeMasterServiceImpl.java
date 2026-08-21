package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.NodeMasterDAO;
import com.mars.common.model.NodeMaster;
import com.mars.common.search.NodeMasterSearch;
import com.mars.common.service.NodeMasterService;
 /**

 * <p>Title: NodeMasterServiceImpl.java </p>

 * @see com.mars.common.model.NodeMaster
 
 * <p>Description: This class is used for hibernate operations for NodeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("nodeMasterService") 
public class NodeMasterServiceImpl implements NodeMasterService {

    private static final Log log = LogFactory.getLog(NodeMasterServiceImpl.class);

  	
	@Autowired
	private NodeMasterDAO nodeMasterDAO;

	public void setNodeMasterDAO(NodeMasterDAO nodeMasterDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setNodeDAO Method is called ");
		}
		this.nodeMasterDAO = nodeMasterDAO;
	}

	/**
	 * This method is saves the NodeMaster object
	 * 
	 * @param entity as NodeMaster object
	 * @return
	 * 
	 */
	public void save(NodeMaster entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		nodeMasterDAO.save(entity);
	}

     /**
	 * This method to merge the NodeMaster information to the database.
	 * 
	 * @param NodeMaster object
	 * 
	 */
    public NodeMaster merge(NodeMaster entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return nodeMasterDAO.merge(entity);
	}

	/**
	 * This method delete the node
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		nodeMasterDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a NodeMaster Object
	 * 
	 */
	public NodeMaster get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return nodeMasterDAO.get(id);
	}
	
	/**
	 * This method will return a list of all NodeMaster from the database
	 * 
	 * @return List of NodeMaster
	 */
	public List<NodeMaster> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return nodeMasterDAO.getAll();
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
		public List<NodeMaster> getNodeList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getNodeList Method is called");
			}
			return nodeMasterDAO.getNodeList(pageNumber,orderBy,sortBy);
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
				log.debug("getNodeListBySearch Method is called");
			}
			
			return nodeMasterDAO.getNodeListBySearch(searchNodeMaster);
		}
		
		
		/**
		 * This method returns count of the NodeMaster objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getNodeCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getNodeCount Method is called");
			}
			return nodeMasterDAO.getNodeCount();
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
			
			return nodeMasterDAO.getNodeCountBySearch(searchNodeMaster);
		}
	
	/**
     * This method save/updates a list of NodeMaster information to the database.
     * 
     * @param listNode as List
     * 
     */
    public void saveAll(List<NodeMaster> listNode){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		nodeMasterDAO.saveAll(listNode);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listNode as List
     */
    public void deleteAll(List<NodeMaster> listNode){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		nodeMasterDAO.deleteAll(listNode);
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
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return nodeMasterDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns NodeMaster object for a given data
	 * 
	 * @param NodeMaster as node
	 * @return NodeMaster as model object
	 */
	public NodeMaster checkForDuplicates(NodeMaster node)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return nodeMasterDAO.checkForDuplicates(node);
		
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
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return nodeMasterDAO.getListByNamedQuery(namedQuery,hstKeyValues);
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
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return nodeMasterDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return nodeMasterDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

