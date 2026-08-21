package com.mars.common.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.SalutationDAO;
import com.mars.common.model.Salutation;
import com.mars.common.service.SalutationService;
 /**

 * <p>Title: SalutationServiceImpl.java </p>

 * @see com.mars.property.model.Salutation
 
 * <p>Description: This class is used for hibernate operations for Salutation module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("salutationService")
public class SalutationServiceImpl implements SalutationService {

    private static final Log log = LogFactory.getLog(SalutationServiceImpl.class);

  	
	@Autowired
	private SalutationDAO salutationDAO;

	public void setSalutationDAO(SalutationDAO salutationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setSalutationDAO Method is called ");
		}
		this.salutationDAO = salutationDAO;
	}

	/**
	 * This method is saves the Salutation object
	 * 
	 * @param entity as Salutation object
	 * @return
	 * 
	 */
	public void save(Salutation entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		salutationDAO.save(entity);
	}

     /**
	 * This method to merge the Salutation information to the database.
	 * 
	 * @param Salutation object
	 * 
	 */
    public Salutation merge(Salutation entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return salutationDAO.merge(entity);
	}

	/**
	 * This method delete the salutation
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		salutationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Salutation Object
	 * 
	 */
	public Salutation get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return salutationDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Salutation from the database
	 * 
	 * @return List of Salutation
	 */
	public List<Salutation> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return salutationDAO.getAll();
	}
	
		/**
		 * This method returns list of the Salutation objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Salutation> getSalutationList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getSalutationList Method is called");
			}
			return salutationDAO.getSalutationList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the Salutation objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSalutationCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getSalutationCount Method is called");
			}
			return salutationDAO.getSalutationCount();
		}	
	
	
	/**
     * This method save/updates a list of Salutation information to the database.
     * 
     * @param listSalutation as List
     * 
     */
    public void saveAll(List<Salutation> listSalutation){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		salutationDAO.saveAll(listSalutation);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listSalutation as List
     */
    public void deleteAll(List<Salutation> listSalutation){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		salutationDAO.deleteAll(listSalutation);
    }
    
    /**
	 * This method returns list of Salutation objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Salutation> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return salutationDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Salutation object for a given data
	 * 
	 * @param Salutation as salutation
	 * @return Salutation as model object
	 */
	public Salutation checkForDuplicates(Salutation salutation)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return salutationDAO.checkForDuplicates(salutation);
		
	}
	
	    /**
	 * This method returns list of Salutation objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Salutation> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return salutationDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Salutation objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Salutation> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return salutationDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return salutationDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

