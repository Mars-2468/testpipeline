package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.BankBranchDAO;
import com.mars.common.model.BankBranch;
import com.mars.common.search.BankBranchSearch;
import com.mars.common.service.BankBranchService;
 /**

 * <p>Title: BankBranchServiceImpl.java </p>

 * @see com.mars.common.model.BankBranch
 
 * <p>Description: This class is used for hibernate operations for BankBranch module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("bankBranchService")
public class BankBranchServiceImpl implements BankBranchService {

    private static final Log log = LogFactory.getLog(BankBranchServiceImpl.class);

  	
	@Autowired
	private BankBranchDAO bankBranchDAO;

	public void setBankBranchDAO(BankBranchDAO bankBranchDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setBankBranchDAO Method is called ");
		}
		this.bankBranchDAO = bankBranchDAO;
	}

	/**
	 * This method is saves the BankBranch object
	 * 
	 * @param entity as BankBranch object
	 * @return
	 * 
	 */
	public void save(BankBranch entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		bankBranchDAO.save(entity);
	}

     /**
	 * This method to merge the BankBranch information to the database.
	 * 
	 * @param BankBranch object
	 * 
	 */
    public BankBranch merge(BankBranch entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return bankBranchDAO.merge(entity);
	}

	/**
	 * This method delete the bankBranch
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		bankBranchDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a BankBranch Object
	 * 
	 */
	public BankBranch get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return bankBranchDAO.get(id);
	}
	
	/**
	 * This method will return a list of all BankBranch from the database
	 * 
	 * @return List of BankBranch
	 */
	public List<BankBranch> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return bankBranchDAO.getAll();
	}
	
		/**
		 * This method returns list of the BankBranch objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<BankBranch> getBankBranchList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getBankBranchList Method is called");
			}
			return bankBranchDAO.getBankBranchList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the BankBranch objects available based on Search.
		 * 
		 * @param searchBankBranch
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<BankBranch> getBankBranchListBySearch(BankBranchSearch searchBankBranch){
			if(log.isDebugEnabled()){
				log.debug("getBankBranchListBySearch Method is called");
			}
			return bankBranchDAO.getBankBranchListBySearch(searchBankBranch);
		}
		
		
		/**
		 * This method returns count of the BankBranch objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getBankBranchCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getBankBranchCount Method is called");
			}
			return bankBranchDAO.getBankBranchCount();
		}	
		
		/**
		 * This method returns count of the BankBranch objects from the database
		 * @param searchBankBranch
		 * @return long
		 * @exception Exception
		 */
		public long getBankBranchCountBySearch(BankBranchSearch searchBankBranch)
		{
			if (log.isDebugEnabled()) {
				log.debug("getBankBranchCountBySearch Method is called");
			}
			return bankBranchDAO.getBankBranchCountBySearch(searchBankBranch);
		}
	
	
	/**
     * This method save/updates a list of BankBranch information to the database.
     * 
     * @param listBankBranch as List
     * 
     */
    public void saveAll(List<BankBranch> listBankBranch){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		bankBranchDAO.saveAll(listBankBranch);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listBankBranch as List
     */
    public void deleteAll(List<BankBranch> listBankBranch){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		bankBranchDAO.deleteAll(listBankBranch);
    }
    
    /**
	 * This method returns list of BankBranch objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<BankBranch> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return bankBranchDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns BankBranch object for a given data
	 * 
	 * @param BankBranch as bankBranch
	 * @return BankBranch as model object
	 */
	public BankBranch checkForDuplicates(BankBranch bankBranch)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return bankBranchDAO.checkForDuplicates(bankBranch);
		
	}
	
	    /**
	 * This method returns list of BankBranch objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<BankBranch> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return bankBranchDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of BankBranch objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<BankBranch> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return bankBranchDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return bankBranchDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	 public List<BankBranch> getListByHqlQuery(String hqlQuery) 
	    {
		 if (log.isDebugEnabled()) 
	    	{
				log.debug("getListByHqlQuery Method is called");
			}
			return bankBranchDAO.getListByHqlQuery(hqlQuery);
		}
	

}

