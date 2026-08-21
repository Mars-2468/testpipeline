package com.mars.rti.dao;

import java.util.Hashtable;
import java.util.List;

import com.mars.rti.model.OutwardNumGenaration;


/**
 * <p>
 * Title: OutwardNumGenarationDAO.java
 * </p>
 *
 * <p>
 * Description: This interface is used for hibernate operations for
 * OutwardNumGenaration
 * </p>
 *
 * @see com.mars.bnd.model.OutwardNumGenaration Copyright (c) 2014 for eGovernance
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
public interface OutwardNumGenarationDAO {

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
	public void save(OutwardNumGenaration entity);

	/**
	 * This method to merge the OutwardNumGenaration information to the database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	public OutwardNumGenaration merge(OutwardNumGenaration entity);

	/**
	 * This method delete OutwardNumGenaration for a given Id
	 *
	 * @param id
	 *            as long
	 *
	 */
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
	public void saveAll(List<OutwardNumGenaration> listOutwardNumGenaration);

	/**
	 * This method is used to delete a list of OutwardNumGenaration records from the
	 * database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 */
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

	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,int year);
}

