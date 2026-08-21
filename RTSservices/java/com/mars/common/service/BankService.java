package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Bank;
import com.mars.common.search.BankSearch;
/**
* <p>Title: BankService.java </p>

 * <p>Description: This interface is used for service implementations related to Bank</p>

 * @see com.mars.common.model.Bank
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface BankService {
  
	/**
	 * This method returns Bank object for a given Id
	 * 
	 * @param id as long
	 * @return Bank as model object
	 */
	public Bank get(long id);
		
    /**
	 * This method save/updates the Bank information to the database.
	 * 
	 * @param Bank object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Bank entity);
	  
	/**
	 * This method to merge the Bank information to the database.
	 * 
	 * @param Bank object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Bank merge(Bank entity); 
	    
    /**
	 * This method delete Bank for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Bank from the database
	 * 
	 * @return List of Bank
	 */
	public List<Bank> getAll();
	
	/**
     * This method save/updates a list of Bank information to the database.
     * 
     * @param listBank as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Bank> listBank);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listBank as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Bank> listBank);
    
	    /**
		 * This method returns list of the Bank objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Bank> getBankList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the Bank objects available based on Search.
		 * 
		 * @param BankSearch searchBank
		 * @return List
		 */
		public List<Bank> getBankListBySearch(BankSearch searchBank); 
		
		/**
		 * This method returns count of the Bank objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getBankCount();
		
		/**
		 * This method returns count of the Bank objects from the database
		 * @param BankSearch SearchBank
		 * @return long
		 * @exception Exception
		 */
		public Long getBankCountBySearch(BankSearch searchBank);
	
	
	/**
	 * This method returns list of Bank objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Bank> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Bank object for a given data
	 * 
	 * @param Bank as bank
	 * @return Bank as model object
	 */
	public Bank checkForDuplicates(Bank bank);    

    /**
	 * This method returns list of Bank objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Bank> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Bank objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Bank> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

