package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.BankBranch;
import com.mars.common.search.BankBranchSearch;
/**
* <p>Title: BankBranchService.java </p>

 * <p>Description: This interface is used for service implementations related to BankBranch</p>

 * @see com.mars.common.model.BankBranch
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface BankBranchService {
  
	/**
	 * This method returns BankBranch object for a given Id
	 * 
	 * @param id as long
	 * @return BankBranch as model object
	 */
	public BankBranch get(long id);
		
    /**
	 * This method save/updates the BankBranch information to the database.
	 * 
	 * @param BankBranch object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(BankBranch entity);
	  
	/**
	 * This method to merge the BankBranch information to the database.
	 * 
	 * @param BankBranch object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public BankBranch merge(BankBranch entity); 
	    
    /**
	 * This method delete BankBranch for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all BankBranch from the database
	 * 
	 * @return List of BankBranch
	 */
	public List<BankBranch> getAll();
	
	/**
     * This method save/updates a list of BankBranch information to the database.
     * 
     * @param listBankBranch as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<BankBranch> listBankBranch);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listBankBranch as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<BankBranch> listBankBranch);
    
	    /**
		 * This method returns list of the BankBranch objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<BankBranch> getBankBranchList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the BankBranch objects available based on Search.
		 * 
		 * @param searchBankBranch
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<BankBranch> getBankBranchListBySearch(BankBranchSearch searchBankBranch);
		
		/**
		 * This method returns count of the BankBranch objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getBankBranchCount();
		
		/**
		 * This method returns count of the BankBranch objects from the database
		 * @param searchBankBranch
		 * @return long
		 * @exception Exception
		 */
		public long getBankBranchCountBySearch(BankBranchSearch searchBankBranch);
	
	
	/**
	 * This method returns list of BankBranch objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<BankBranch> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns BankBranch object for a given data
	 * 
	 * @param BankBranch as bankBranch
	 * @return BankBranch as model object
	 */
	public BankBranch checkForDuplicates(BankBranch bankBranch);    

    /**
	 * This method returns list of BankBranch objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<BankBranch> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of BankBranch objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<BankBranch> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
	
	 public List<BankBranch> getListByHqlQuery(String hqlQuery);
	 
}

