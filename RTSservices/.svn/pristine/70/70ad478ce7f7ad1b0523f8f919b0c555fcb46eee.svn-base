package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.BankDAO;
import com.mars.common.model.Bank;
import com.mars.common.search.BankSearch;
import com.mars.common.service.BankService;
 /**

 * <p>Title: BankServiceImpl.java </p>

 * @see com.mars.common.model.Bank
 
 * <p>Description: This class is used for hibernate operations for Bank module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("bankService") 
public class BankServiceImpl implements BankService {

    private static final Log log = LogFactory.getLog(BankServiceImpl.class);

  	
	@Autowired
	private BankDAO bankDAO;

	public void setBankDAO(BankDAO bankDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setBankDAO Method is called ");
		}
		this.bankDAO = bankDAO;
	}

	/**
	 * This method is saves the Bank object
	 * 
	 * @param entity as Bank object
	 * @return
	 * 
	 */
	public void save(Bank entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		bankDAO.save(entity);
	}

     /**
	 * This method to merge the Bank information to the database.
	 * 
	 * @param Bank object
	 * 
	 */
    public Bank merge(Bank entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return bankDAO.merge(entity);
	}

	/**
	 * This method delete the bank
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		bankDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Bank Object
	 * 
	 */
	public Bank get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return bankDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Bank from the database
	 * 
	 * @return List of Bank
	 */
	public List<Bank> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return bankDAO.getAll();
	}
	
		/**
		 * This method returns list of the Bank objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Bank> getBankList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getBankList Method is called");
			}
			return bankDAO.getBankList(pageNumber,orderBy,sortBy);
		}
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
		public List<Bank> getBankListBySearch(BankSearch searchBank){
			if (log.isDebugEnabled()) {
				log.debug("getBankListBySearch Method is called");
			}
			return bankDAO.getBankListBySearch(searchBank);
			
		}
		
		
		/**
		 * This method returns count of the Bank objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getBankCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getBankCount Method is called");
			}
			return bankDAO.getBankCount();
		}	
	
	
	/**
     * This method save/updates a list of Bank information to the database.
     * 
     * @param listBank as List
     * 
     */
    public void saveAll(List<Bank> listBank){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		bankDAO.saveAll(listBank);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listBank as List
     */
    public void deleteAll(List<Bank> listBank){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		bankDAO.deleteAll(listBank);
    }
    
    /**
	 * This method returns list of Bank objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Bank> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return bankDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Bank object for a given data
	 * 
	 * @param Bank as bank
	 * @return Bank as model object
	 */
	public Bank checkForDuplicates(Bank bank)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return bankDAO.checkForDuplicates(bank);
		
	}
	
	    /**
	 * This method returns list of Bank objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Bank> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return bankDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Bank objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Bank> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return bankDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return bankDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	public Long getBankCountBySearch(BankSearch searchBank) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getBankCountBySearch Method is called");
		}
		return bankDAO.getBankCountBySearch(searchBank);
	}	
}

