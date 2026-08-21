package com.mars.rti.service;

import java.util.Hashtable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.InwardNumGenaration;

/**
 * <p>
 * Title: InwardNumGenarationService.java
 * </p>
 *
 * <p>
 * Description: This interface is used for service implementations related to
 * InwardNumGenaration
 * </p>
 *
 * @see com.mars.fts.model.InwardNumGenaration Copyright (c) 2014 for eGovernance
 *      Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 *
 */
@Transactional(readOnly = false)
public interface InwardNumGenarationService {

	/**
	 * This method returns InwardNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return InwardNumGenaration as model object
	 */
	public InwardNumGenaration get(long id);

	/**
	 * This method save/updates the InwardNumGenaration information to the
	 * database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(InwardNumGenaration entity);

	/**
	 * This method to merge the InwardNumGenaration information to the database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public InwardNumGenaration merge(InwardNumGenaration entity);

	/**
	 * This method delete InwardNumGenaration for a given Id
	 *
	 * @param id
	 *            as long
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void delete(long id);

	/**
	 * This method will return a list of all InwardNumGenaration from the database
	 *
	 * @return List of InwardNumGenaration
	 */
	public List<InwardNumGenaration> getAll();

	/**
	 * This method save/updates a list of InwardNumGenaration information to the
	 * database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveAll(List<InwardNumGenaration> listInwardNumGenaration);

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void deleteAll(List<InwardNumGenaration> listInwardNumGenaration);

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
			String orderBy, String sortBy);

	/**
	 * This method returns count of the InwardNumGenaration objects from the
	 * database
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getInwardNumGenarationCount();

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
			Object value);

	/**
	 * This method returns InwardNumGenaration object for a given data
	 *
	 * @param InwardNumGenaration
	 *            as regNumGenaration
	 * @return InwardNumGenaration as model object
	 */
	public InwardNumGenaration checkForDuplicates(InwardNumGenaration inwardNumGenaration);

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
			Hashtable<String, Object> hstKeyValues);

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag);

	public String createNewInwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag);

	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,int year);
}

