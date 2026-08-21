package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.DocumentMaster;
import com.mars.common.search.DocumentMasterSearch;
/**
 * <p>Title: DocumentMasterDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for DocumentMaster</p>

 * @see com.mars.common.model.DocumentMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface DocumentMasterDAO {

  
	/**
	 * This method returns DocumentMaster object for a given Id
	 * 
	 * @param id as long
	 * @return DocumentMaster as model object
	 */
	public DocumentMaster get(long id);
		
    
    /**
	 * This method save/updates the DocumentMaster information to the database.
	 * 
	 * @param DocumentMaster object
	 * 
	 */
	public void save(DocumentMaster entity);
	
     /**
	 * This method to merge the DocumentMaster information to the database.
	 * 
	 * @param DocumentMaster object
	 * 
	 */
    public DocumentMaster merge(DocumentMaster entity);
    
    /**
	 * This method delete DocumentMaster for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all DocumentMaster from the database
	 * 
	 * @return List of DocumentMaster
	 */
	public List<DocumentMaster> getAll();
	
	/**
     * This method save/updates a list of DocumentMaster information to the database.
     * 
     * @param listDocumentMaster as List
     * 
     */
    public void saveAll(List<DocumentMaster> listDocumentMaster);
    
    
    /**
     * This method is used to delete a list of DocumentMaster records from the database.
     * 
     * @param listDocumentMaster as List
     */
    public void deleteAll(List<DocumentMaster> listDocumentMaster);
    
	    /**
		 * This method returns list of the DocumentMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<DocumentMaster> getDocumentMasterList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the DocumentMaster objects available based on Search.
		 * 
		 * @param DocumentMasterSearch searchDocumentMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<DocumentMaster> getDocumentMasterListBySearch(DocumentMasterSearch searchDocumentMaster);
		
		
		/**
		 * This method returns count of the DocumentMaster objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDocumentMasterCount();
	
		/**
		 * This method returns count of the DocumentMaster objects from the database based on Search
		 * @param DocumentMasterSearch searchDocumentMaster
		 * @return long
		 * @exception Exception
		 */
		public long getDocumentMasterCountBySearch(DocumentMasterSearch searchDocumentMaster);
	
	/**
	 * This method returns list of DocumentMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<DocumentMaster> findByProperty(String propertyName, Object value);

	/**
	 * This method returns DocumentMaster object for a given data
	 * 
	 * @param DocumentMaster as documentMaster
	 * @return DocumentMaster as model object
	 */
	public DocumentMaster checkForDuplicates(DocumentMaster documentMaster);
	
	/**
	 * This method returns list of DocumentMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of DocumentMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public void SaveOrUpdateDocumentCheckListByentity(String docDmschecklistId,long entityId);
	
	public void DeleteDocumentCheckListByentity(String entityName, long entityId);
}

