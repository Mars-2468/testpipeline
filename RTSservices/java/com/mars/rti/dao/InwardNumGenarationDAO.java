package com.mars.rti.dao;

import java.util.Hashtable;
import java.util.List;

import com.mars.rti.model.InwardNumGenaration;


/**
 * <p>
 * Title: InwardNumGenarationDAO.java
 * </p>
 *
 * <p>
 * Description: This interface is used for hibernate operations for
 * InwardNumGenaration
 * </p>
 *
 * @see com.mars.bnd.model.InwardNumGenaration Copyright (c) 2014 for eGovernance
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
public interface InwardNumGenarationDAO {

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
	public void save(InwardNumGenaration entity);

	/**
	 * This method to merge the InwardNumGenaration information to the database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	public InwardNumGenaration merge(InwardNumGenaration entity);

	/**
	 * This method delete InwardNumGenaration for a given Id
	 *
	 * @param id
	 *            as long
	 *
	 */
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
	public void saveAll(List<InwardNumGenaration> listInwardNumGenaration);

	/**
	 * This method is used to delete a list of InwardNumGenaration records from the
	 * database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 */
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

	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,int year);
}

