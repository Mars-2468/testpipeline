package com.mars.rti.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.Outbox;
import com.mars.rti.search.OutboxSearch;



/**
* <p>Title: OutboxService.java </p>

 * <p>Description: This interface is used for service implementations related to Outbox</p>

 * @see com.mars.common.model.Outbox
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface OutboxService {
	
	/**
	 * This method returns Outbox object for a given Id
	 * 
	 * @param id as long
	 * @return Outbox as model object
	 */
	public Outbox get(long id);
		
    /**
	 * This method save/updates the Outbox information to the database.
	 * 
	 * @param Outbox object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Outbox entity);
	  
	/**
	 * This method to merge the Outbox information to the database.
	 * 
	 * @param Outbox object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Outbox merge(Outbox entity); 
	    
    /**
	 * This method delete Outbox for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Outbox from the database
	 * 
	 * @return List of Outbox
	 */
	public List<Outbox> getAll();
	
	/**
     * This method save/updates a list of Outbox information to the database.
     * 
     * @param listOutbox as List
     * 
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Outbox> listOutbox);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listOutbox as List
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Outbox> listOutbox);
    
	    /**
		 * This method returns list of the Outbox objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)

		public List<Outbox> getOutboxList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the Outbox objects available based on Search
		 * 
		 * @param OutboxSearch searchOutbox
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Outbox> getOutboxListBySearch(OutboxSearch searchOutbox);
		
		
		/**
		 * This method returns count of the Outbox objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getOutboxCount();
		
		
		/**
		 * This method returns count of the Outbox objects from the database based on search
		 * @param OutboxSearch searchOutbox
		 * @return long
		 * @exception Exception
		 */
		public long getOutboxCountBySearch(OutboxSearch searchOutbox);
	
	
	/**
	 * This method returns list of Outbox objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Outbox> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Outbox object for a given data
	 * 
	 * @param Outbox as outbox
	 * @return Outbox as model object
	 */
	public Outbox checkForDuplicates(Outbox outbox);    

    /**
	 * This method returns list of Outbox objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Outbox> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Outbox objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Outbox> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
  
	
	

}
