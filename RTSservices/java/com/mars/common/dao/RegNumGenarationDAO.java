package com.mars.common.dao;

import java.util.Hashtable;
import java.util.List;

import com.mars.common.model.RegNumGenaration;

/**
 * <p>
 * Title: RegNumGenarationDAO.java
 * </p>
 *
 * <p>
 * Description: This interface is used for hibernate operations for
 * RegNumGenaration
 * </p>
 *
 * @see com.mars.bnd.model.RegNumGenaration Copyright (c) 2014 for eGovernance
 *      Goa
 *
 * @version: 1.0
 *
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 *
 */

/**
 * @author ssamala01
 *
 */
public interface RegNumGenarationDAO {

	/**
	 * This method returns RegNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return RegNumGenaration as model object
	 */
	public RegNumGenaration get(long id);

	/**
	 * This method save/updates the RegNumGenaration information to the
	 * database.
	 *
	 * @param RegNumGenaration
	 *            object
	 *
	 */
	public void save(RegNumGenaration entity);

	/**
	 * This method to merge the RegNumGenaration information to the database.
	 *
	 * @param RegNumGenaration
	 *            object
	 *
	 */
	public RegNumGenaration merge(RegNumGenaration entity);

	/**
	 * This method delete RegNumGenaration for a given Id
	 *
	 * @param id
	 *            as long
	 *
	 */
	public void delete(long id);

	/**
	 * This method will return a list of all RegNumGenaration from the database
	 *
	 * @return List of RegNumGenaration
	 */
	public List<RegNumGenaration> getAll();

	/**
	 * This method save/updates a list of RegNumGenaration information to the
	 * database.
	 *
	 * @param listRegNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<RegNumGenaration> listRegNumGenaration);

	/**
	 * This method is used to delete a list of RegNumGenaration records from the
	 * database.
	 *
	 * @param listRegNumGenaration
	 *            as List
	 */
	public void deleteAll(List<RegNumGenaration> listRegNumGenaration);

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
			String orderBy, String sortBy);

	/**
	 * This method returns count of the RegNumGenaration objects from the
	 * database
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getRegNumGenarationCount();

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
			Object value);

	/**
	 * This method returns RegNumGenaration object for a given data
	 *
	 * @param RegNumGenaration
	 *            as regNumGenaration
	 * @return RegNumGenaration as model object
	 */
	public RegNumGenaration checkForDuplicates(RegNumGenaration regNumGenaration);

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
			Hashtable<String, Object> hstKeyValues);

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag);

	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,int year);
}
