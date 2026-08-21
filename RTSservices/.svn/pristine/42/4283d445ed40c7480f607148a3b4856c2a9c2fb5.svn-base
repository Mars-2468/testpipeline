package com.mars.rti.service;

import java.util.Hashtable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.OutwardNumGenaration;


/**
 * <p>
 * Title: OutwardNumGenarationService.java
 * </p>
 *
 * <p>
 * Description: This interface is used for service implementations related to
 * OutwardNumGenaration
 * </p>
 *
 * @see com.mars.fts.model.OutwardNumGenaration Copyright (c) 2014 for eGovernance
 *      Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 *
 */
@Transactional(readOnly = false)
public interface OutwardNumGenarationService {

	/**
	 * This method returns OutwardNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return OutwardNumGenaration as model object
	 */
	public OutwardNumGenaration get(long id);

	/**
	 * This method save/updates the OutwardNumGenaration information to the
	 * database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(OutwardNumGenaration entity);

	/**
	 * This method to merge the OutwardNumGenaration information to the database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public OutwardNumGenaration merge(OutwardNumGenaration entity);

	/**
	 * This method delete OutwardNumGenaration for a given Id
	 *
	 * @param id
	 *            as long
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void delete(long id);

	/**
	 * This method will return a list of all OutwardNumGenaration from the database
	 *
	 * @return List of OutwardNumGenaration
	 */
	public List<OutwardNumGenaration> getAll();

	/**
	 * This method save/updates a list of OutwardNumGenaration information to the
	 * database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 *
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveAll(List<OutwardNumGenaration> listOutwardNumGenaration);

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void deleteAll(List<OutwardNumGenaration> listOutwardNumGenaration);

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
			String orderBy, String sortBy);

	/**
	 * This method returns count of the OutwardNumGenaration objects from the
	 * database
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getOutwardNumGenarationCount();

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
			Object value);

	/**
	 * This method returns OutwardNumGenaration object for a given data
	 *
	 * @param OutwardNumGenaration
	 *            as regNumGenaration
	 * @return OutwardNumGenaration as model object
	 */
	public OutwardNumGenaration checkForDuplicates(OutwardNumGenaration outwardNumGenaration);

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
			Hashtable<String, Object> hstKeyValues);

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag);

	public String createNewOutwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag);

	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,int year);
}

