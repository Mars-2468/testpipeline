package com.mars.common.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.RegNumGenarationDAO;
import com.mars.common.model.RegNumGenaration;
import com.mars.common.service.RegNumGenarationService;

/**
 *
 * <p>
 * Title: RegNumGenarationServiceImpl.java
 * </p>
 *
 * @see com.mars.bnd.model.RegNumGenaration <p>
 *      Description: This class is used for hibernate operations for
 *      RegNumGenaration module
 *      </p>
 *
 *      Copyright (c) 2014 for eGovernance Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 */
@Service("regNumGenarationService")
public class RegNumGenarationServiceImpl implements RegNumGenarationService {

	private static final Log log = LogFactory
			.getLog(RegNumGenarationServiceImpl.class);
	
	@Autowired
	private RegNumGenarationDAO regNumGenarationDAO;

	public void setRegNumGenarationDAO(RegNumGenarationDAO regNumGenarationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setRegNumGenarationDAO Method is called ");
		}
		this.regNumGenarationDAO = regNumGenarationDAO;
	}

	/**
	 * This method is saves the RegNumGenaration object
	 *
	 * @param entity
	 *            as RegNumGenaration object
	 * @return
	 *
	 */
	public void save(RegNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		regNumGenarationDAO.save(entity);
	}

	/**
	 * This method to merge the RegNumGenaration information to the database.
	 *
	 * @param RegNumGenaration
	 *            object
	 *
	 */
	public RegNumGenaration merge(RegNumGenaration entity) {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return regNumGenarationDAO.merge(entity);
	}

	/**
	 * This method delete the regNumGenaration
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
		regNumGenarationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 *
	 * @param Id
	 *            as long
	 * @return a RegNumGenaration Object
	 *
	 */
	public RegNumGenaration get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return regNumGenarationDAO.get(id);
	}

	/**
	 * This method will return a list of all RegNumGenaration from the database
	 *
	 * @return List of RegNumGenaration
	 */
	public List<RegNumGenaration> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return regNumGenarationDAO.getAll();
	}

	/**
	 * This method returns list of the RegNumGenaration objects available based
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
	public List<RegNumGenaration> getRegNumGenarationList(long pageNumber,
			String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("getRegNumGenarationList Method is called");
		}
		return regNumGenarationDAO.getRegNumGenarationList(pageNumber, orderBy,
				sortBy);
	}

	/**
	 * This method returns count of the RegNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getRegNumGenarationCount() {
		if (log.isDebugEnabled()) {
			log.debug("getRegNumGenarationCount Method is called");
		}
		return regNumGenarationDAO.getRegNumGenarationCount();
	}

	/**
	 * This method save/updates a list of RegNumGenaration information to the
	 * database.
	 *
	 * @param listRegNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<RegNumGenaration> listRegNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		regNumGenarationDAO.saveAll(listRegNumGenaration);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listRegNumGenaration
	 *            as List
	 */
	public void deleteAll(List<RegNumGenaration> listRegNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		regNumGenarationDAO.deleteAll(listRegNumGenaration);
	}

	/**
	 * This method returns list of RegNumGenaration objects available based on
	 * the value for a particular property.
	 *
	 * @param String
	 *            propertyName
	 * @param Object
	 *            value
	 * @return List
	 * @exception Exception
	 */
	public List<RegNumGenaration> findByProperty(String propertyName,
			Object value) {
		if (log.isDebugEnabled()) {
			log.debug("findByProperty Method is called");
		}
		return regNumGenarationDAO.findByProperty(propertyName, value);
	}

	/**
	 * This method returns RegNumGenaration object for a given data
	 *
	 * @param RegNumGenaration
	 *            as regNumGenaration
	 * @return RegNumGenaration as model object
	 */
	public RegNumGenaration checkForDuplicates(RegNumGenaration regNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		return regNumGenarationDAO.checkForDuplicates(regNumGenaration);

	}

	/**
	 * This method returns list of RegNumGenaration objects available based on
	 * the query names passed.
	 *
	 * @param String
	 *            namedQuery
	 * @param hstKeyValues
	 *            as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<RegNumGenaration> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		if (log.isDebugEnabled()) {
			log.debug("getListByNamedQuery Method is called");
		}
		return regNumGenarationDAO
				.getListByNamedQuery(namedQuery, hstKeyValues);
	}

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return regNumGenarationDAO.getRegistrationNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String createNewRegistrationNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag){
		if (log.isDebugEnabled()) {
			log.debug("createNewRegistrationNumber Method is called");
		}
		return regNumGenarationDAO.getRegistrationNumber(propertyName, value, prefix, postFix,resetFlag);
	}

	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,int year){
		if (log.isDebugEnabled()) {
			log.debug("getRegistrationNumber Method is called");
		}
		return regNumGenarationDAO.getRegistrationNumber(propertyName, value, prefix, postFix,year);
	}
}
