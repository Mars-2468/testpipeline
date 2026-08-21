package com.mars.rti.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.OutwardNumGenarationDAO;
import com.mars.rti.model.OutwardNumGenaration;
import com.mars.rti.service.OutwardNumGenarationService;

/**
 *
 * <p>
 * Title: OutwardNumGenarationServiceImpl.java
 * </p>
 *
 * @see com.mars.fts.model.OutwardNumGenaration <p>
 *      Description: This class is used for hibernate operations for
 *      OutwardNumGenaration module
 *      </p>
 *
 *      Copyright (c) 2014 for eGovernance Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 */
@Service("outwardNumGenarationService")
public class OutwardNumGenarationServiceImpl implements OutwardNumGenarationService {

	private static final Log log = LogFactory
			.getLog(OutwardNumGenarationServiceImpl.class);
	
	@Autowired
	private OutwardNumGenarationDAO outwardNumGenarationDAO;

	public void setOutwardNumGenarationDAO(OutwardNumGenarationDAO outwardNumGenarationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setOutwardNumGenarationDAO Method is called ");
		}
		this.outwardNumGenarationDAO = outwardNumGenarationDAO;
	}

	/**
	 * This method is saves the OutwardNumGenaration object
	 *
	 * @param entity
	 *            as OutwardNumGenaration object
	 * @return
	 *
	 */
	public void save(OutwardNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		outwardNumGenarationDAO.save(entity);
	}

	/**
	 * This method to merge the OutwardNumGenaration information to the database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	public OutwardNumGenaration merge(OutwardNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return outwardNumGenarationDAO.merge(entity);
	}

	/**
	 * This method delete the outwardNumGenaration
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
		outwardNumGenarationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 *
	 * @param Id
	 *            as long
	 * @return a OutwardNumGenaration Object
	 *
	 */
	public OutwardNumGenaration get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return outwardNumGenarationDAO.get(id);
	}

	/**
	 * This method will return a list of all OutwardNumGenaration from the database
	 *
	 * @return List of OutwardNumGenaration
	 */
	public List<OutwardNumGenaration> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return outwardNumGenarationDAO.getAll();
	}

	/**
	 * This method returns list of the OutwardNumGenaration objects available based
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
	public List<OutwardNumGenaration> getOutwardNumGenarationList(long pageNumber,
			String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("getOutwardNumGenarationList Method is called");
		}
		return outwardNumGenarationDAO.getOutwardNumGenarationList(pageNumber, orderBy,
				sortBy);
	}

	/**
	 * This method returns count of the OutwardNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getOutwardNumGenarationCount() {
		if (log.isDebugEnabled()) {
			log.debug("getOutwardNumGenarationCount Method is called");
		}
		return outwardNumGenarationDAO.getOutwardNumGenarationCount();
	}

	/**
	 * This method save/updates a list of OutwardNumGenaration information to the
	 * database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<OutwardNumGenaration> listOutwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		outwardNumGenarationDAO.saveAll(listOutwardNumGenaration);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 */
	public void deleteAll(List<OutwardNumGenaration> listOutwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		outwardNumGenarationDAO.deleteAll(listOutwardNumGenaration);
	}

	/**
	 * This method returns list of OutwardNumGenaration objects available based on
	 * the value for a particular property.
	 *
	 * @param String
	 *            propertyName
	 * @param Object
	 *            value
	 * @return List
	 * @exception Exception
	 */
	public List<OutwardNumGenaration> findByProperty(String propertyName,
			Object value) {
		if (log.isDebugEnabled()) {
			log.debug("findByProperty Method is called");
		}
		return outwardNumGenarationDAO.findByProperty(propertyName, value);
	}

	/**
	 * This method returns OutwardNumGenaration object for a given data
	 *
	 * @param OutwardNumGenaration
	 *            as outwardNumGenaration
	 * @return OutwardNumGenaration as model object
	 */
	public OutwardNumGenaration checkForDuplicates(OutwardNumGenaration outwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		return outwardNumGenarationDAO.checkForDuplicates(outwardNumGenaration);

	}

	/**
	 * This method returns list of OutwardNumGenaration objects available based on
	 * the query names passed.
	 *
	 * @param String
	 *            namedQuery
	 * @param hstKeyValues
	 *            as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<OutwardNumGenaration> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		if (log.isDebugEnabled()) {
			log.debug("getListByNamedQuery Method is called");
		}
		return outwardNumGenarationDAO.getListByNamedQuery(namedQuery, hstKeyValues);
	}

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return outwardNumGenarationDAO.getOutwardNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String createNewOutwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("createNewRegistrationNumber Method is called");
		}
		return outwardNumGenarationDAO.getOutwardNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,int year){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return outwardNumGenarationDAO.getOutwardNumber(propertyName,value,prefix, postFix, year);
	}
}
