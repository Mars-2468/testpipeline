package com.mars.rti.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.Inbox;
import com.mars.rti.search.InboxSearch;




	/**
	* <p>Title: InboxService.java </p>

	 * <p>Description: This interface is used for service implementations related to Inbox</p>

	 * @see com.mars.common.model.Inbox
	 
	 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

	 * @version: 1.0

	 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
	 * 
	 */
	@Transactional(readOnly = true)
	public interface InboxService {
	  
		/**
		 * This method returns Inbox object for a given Id
		 * 
		 * @param id as long
		 * @return Inbox as model object
		 */
		public Inbox get(long id);
			
	    /**
		 * This method save/updates the Inbox information to the database.
		 * 
		 * @param Inbox object
		 * 
		 */
	   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public void save(Inbox entity);
		  
		/**
		 * This method to merge the Inbox information to the database.
		 * 
		 * @param Inbox object
		 * 
		 */
	   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	    public Inbox merge(Inbox entity); 
		    
	    /**
		 * This method delete Inbox for a given Id
		 * 
		 * @param id as long
		 * 
		 */
		 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	    public void delete(long id) ;
		
		/**
		 * This method will return a list of all Inbox from the database
		 * 
		 * @return List of Inbox
		 */
		public List<Inbox> getAll();
		
		/**
	     * This method save/updates a list of Inbox information to the database.
	     * 
	     * @param listInbox as List
	     * 
	     */
		 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	    public void saveAll(List<Inbox> listInbox);
	    
	    /**
	     * This method is used to delete a list of Module records from the database.
	     * 
	     * @param listInbox as List
	     */
		 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	    public void deleteAll(List<Inbox> listInbox);
		 
		 
	    
		    /**
			 * This method returns list of the Inbox objects available based page number.
			 * 
			 * @param long PageNumber
			 * @param String orderBy
			 * @param String sortBy
			 * @return List
			 * @exception Exception
			 */
			public List<Inbox> getInboxList(long pageNumber,String orderBy, String sortBy);
			
			/**
			 * This method returns list of the Inbox objects available based on Search
			 * 
			 * @param InboxSearch searchInbox
			 * @param 
			 * @param 
			 * @return List
			 * @exception Exception
			 */
			public List<Inbox> getInboxListBySearch(InboxSearch searchInbox);
			
			
			/**
			 * This method returns count of the Inbox objects from the database
			 * 
			 * @return long
			 * @exception Exception
			 */
			public long getInboxCount();
			
			
			/**
			 * This method returns count of the Inbox objects from the database based on search
			 * @param InboxSearch searchInbox
			 * @return long
			 * @exception Exception
			 */
			public long getInboxCountBySearch(InboxSearch searchInbox);
		
		
		/**
		 * This method returns list of Inbox objects available based on the value for a particular property.
		 * @param String propertyName
		 * @param Object value
		 * @return List
		 * @exception Exception
		 */
	    public List<Inbox> findByProperty(String propertyName, Object value);	    

		/**
		 * This method returns Inbox object for a given data
		 * 
		 * @param Inbox as inbox
		 * @return Inbox as model object
		 */
		public Inbox checkForDuplicates(Inbox inbox);    

	    /**
		 * This method returns list of Inbox objects available based on the query names passed.
		 * @param String namedQuery
		 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
		 * @return List
		 * @exception Exception
		 */
		public List<Inbox> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

	    /**
		 * This method returns list of Inbox objects available based on the SQL query and parameters.
		 * @param String SQL Query
		 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
		 * @return List
		 * @exception Exception
		 */
		public List<Inbox> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
		
	    /**
		 * This method returns list selected columns as list based on the SQL query and parameters.
		 * @param String SQL Query
		 * @return List
		 * @exception Exception
		 */
		@SuppressWarnings("rawtypes")
		public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
		
}
