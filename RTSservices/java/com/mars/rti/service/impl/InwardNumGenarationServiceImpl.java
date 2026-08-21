package com.mars.rti.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.InwardNumGenarationDAO;
import com.mars.rti.model.InwardNumGenaration;
import com.mars.rti.service.InwardNumGenarationService;

/**
 *
 * <p>
 * Title: InwardNumGenarationServiceImpl.java
 * </p>
 *
 * @see com.mars.fts.model.InwardNumGenaration <p>
 *      Description: This class is used for hibernate operations for
 *      InwardNumGenaration module
 *      </p>
 *
 *      Copyright (c) 2014 for eGovernance Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 */
@Service("inwardNumGenarationService")
public class InwardNumGenarationServiceImpl implements InwardNumGenarationService {

	private static final Log log = LogFactory
			.getLog(InwardNumGenarationServiceImpl.class);
	
	@Autowired
	private InwardNumGenarationDAO inwardNumGenarationDAO;

	public void setInwardNumGenarationDAO(InwardNumGenarationDAO inwardNumGenarationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setInwardNumGenarationDAO Method is called ");
		}
		this.inwardNumGenarationDAO = inwardNumGenarationDAO;
	}

	/**
	 * This method is saves the InwardNumGenaration object
	 *
	 * @param entity
	 *            as InwardNumGenaration object
	 * @return
	 *
	 */
	public void save(InwardNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		inwardNumGenarationDAO.save(entity);
	}

	/**
	 * This method to merge the InwardNumGenaration information to the database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	public InwardNumGenaration merge(InwardNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return inwardNumGenarationDAO.merge(entity);
	}

	/**
	 * This method delete the inwardNumGenaration
	 *
	 * @param Id
	 *            as long
	 * @return
	 *
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		inwardNumGenarationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 *
	 * @param Id
	 *            as long
	 * @return a InwardNumGenaration Object
	 *
	 */
	public InwardNumGenaration get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return inwardNumGenarationDAO.get(id);
	}

	/**
	 * This method will return a list of all InwardNumGenaration from the database
	 *
	 * @return List of InwardNumGenaration
	 */
	public List<InwardNumGenaration> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return inwardNumGenarationDAO.getAll();
	}

	/**
	 * This method returns list of the InwardNumGenaration objects available based
	 * page number.
	 *
	 * @param long PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<InwardNumGenaration> getInwardNumGenarationList(long pageNumber,
			String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("getInwardNumGenarationList Method is called");
		}
		return inwardNumGenarationDAO.getInwardNumGenarationList(pageNumber, orderBy,
				sortBy);
	}

	/**
	 * This method returns count of the InwardNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getInwardNumGenarationCount() {
		if (log.isDebugEnabled()) {
			log.debug("getInwardNumGenarationCount Method is called");
		}
		return inwardNumGenarationDAO.getInwardNumGenarationCount();
	}

	/**
	 * This method save/updates a list of InwardNumGenaration information to the
	 * database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<InwardNumGenaration> listInwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		inwardNumGenarationDAO.saveAll(listInwardNumGenaration);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 */
	public void deleteAll(List<InwardNumGenaration> listInwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		inwardNumGenarationDAO.deleteAll(listInwardNumGenaration);
	}

	/**
	 * This method returns list of InwardNumGenaration objects available based on
	 * the value for a particular property.
	 *
	 * @param String
	 *            propertyName
	 * @param Object
	 *            value
	 * @return List
	 * @exception Exception
	 */
	public List<InwardNumGenaration> findByProperty(String propertyName,
			Object value) {
		if (log.isDebugEnabled()) {
			log.debug("findByProperty Method is called");
		}
		return inwardNumGenarationDAO.findByProperty(propertyName, value);
	}

	/**
	 * This method returns InwardNumGenaration object for a given data
	 *
	 * @param InwardNumGenaration
	 *            as inwardNumGenaration
	 * @return InwardNumGenaration as model object
	 */
	public InwardNumGenaration checkForDuplicates(InwardNumGenaration inwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		return inwardNumGenarationDAO.checkForDuplicates(inwardNumGenaration);

	}

	/**
	 * This method returns list of InwardNumGenaration objects available based on
	 * the query names passed.
	 *
	 * @param String
	 *            namedQuery
	 * @param hstKeyValues
	 *            as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<InwardNumGenaration> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		if (log.isDebugEnabled()) {
			log.debug("getListByNamedQuery Method is called");
		}
		return inwardNumGenarationDAO.getListByNamedQuery(namedQuery, hstKeyValues);
	}

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return inwardNumGenarationDAO.getInwardNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String createNewInwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("createNewRegistrationNumber Method is called");
		}
		return inwardNumGenarationDAO.getInwardNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,int year){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return inwardNumGenarationDAO.getInwardNumber(propertyName,value,prefix, postFix, year);
	}
}
