package com.mars.common.dao.impl;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.RegNumGenarationDAO;
import com.mars.common.model.RegNumGenaration;
import com.mars.common.utils.Constants;

/**
 *
 * <p>
 * Title: RegNumGenarationDaoImpl.java
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
 * 
 */
@Repository("regNumGenarationDAO")
public class RegNumGenarationDAOImpl extends HibernateDaoSupport implements
		RegNumGenarationDAO {

	private static final Log log = LogFactory
			.getLog(RegNumGenarationDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns RegNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return RegNumGenaration as model object
	 */
	public RegNumGenaration get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (RegNumGenaration) getHibernateTemplate().get(
					RegNumGenaration.class, new Long(id));
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	/**
	 * This method save/updates the RegNumGenaration information to the
	 * database.
	 *
	 * @param RegNumGenaration
	 *            object
	 *
	 */
	public void save(RegNumGenaration entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	/**
	 * This method to merge the RegNumGenaration information to the database.
	 *
	 * @param RegNumGenaration
	 *            object
	 *
	 */
	public RegNumGenaration merge(RegNumGenaration entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (RegNumGenaration) getHibernateTemplate().merge(entity);
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	/**
	 * This method is used to delete a record from the database using hibernate.
	 *
	 * @param id
	 *            as long
	 */
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting RegNumGenaration instance");
			}
			RegNumGenaration entity = (RegNumGenaration) getHibernateTemplate()
					.load(RegNumGenaration.class, new Long(id));
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	/**
	 * This method will return a list of all RegNumGenaration from the database
	 *
	 * @return List of RegNumGenaration
	 */
	public List<RegNumGenaration> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for RegNumGenaration");
			}
			return getHibernateTemplate().loadAll(RegNumGenaration.class);
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 *
	 * @param listRegNumGenaration
	 *            as List
	 */
	public void deleteAll(List<RegNumGenaration> listRegNumGenaration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for RegNumGenaration");
			}
			getHibernateTemplate().deleteAll(listRegNumGenaration);
			log
					.debug("deleted successfuly a list of RegNumGenaration records from database");
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
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
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listRegNumGenaration);
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
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

		try {
			String fromClause = "select regNumGenaration from RegNumGenaration regNumGenaration";
			fromClause = fromClause + " order by " + orderBy + " " + sortBy;
			Query query = getSession().createQuery(fromClause);

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query
							.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				} else {
					query.setFirstResult(0);
					query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
				}
			}

			List<RegNumGenaration> list = query.list();

			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}

	}

	/**
	 * This method returns count of the RegNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getRegNumGenarationCount() {
		try {
			String fromClause = "select count(*) from RegNumGenaration regNumGenaration";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();

			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
			return 0;
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
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
		try {
			Query queryObject = getSession().getNamedQuery(namedQuery);
			if (hstKeyValues != null && hstKeyValues.size() > 0) {
				Enumeration<String> enumeration = hstKeyValues.keys();
				while (enumeration.hasMoreElements()) {
					String strKey = enumeration.nextElement();
					queryObject.setParameter(strKey, hstKeyValues.get(strKey));
				}
			}
			return queryObject.list();
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
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
		try {
			log.info("finding RegNumGenaration instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select regNumGenaration from RegNumGenaration regNumGenaration where regNumGenaration."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag) {
		try {
			log.info("finding RegNumGenaration instance with property: "
					+ propertyName + ", value: " + value);

			Calendar cal=Calendar.getInstance();
		    int year=cal.get(Calendar.YEAR);

		    String queryString = "select regNumGenaration from RegNumGenaration regNumGenaration where regNumGenaration."
					+ propertyName + "= ? " ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			RegNumGenaration regNumGenaration=(RegNumGenaration)queryObject.uniqueResult();
		    String regNum="0";
			if(regNumGenaration != null ){

				//Updating the Prefix or Post fix string changes if any for this entity name record.

				if(prefix !=null && prefix.length() >0 && !prefix.equals(regNumGenaration.getPrefixStr()))
					regNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0 && !postFix.equals(regNumGenaration.getPostfixStr()))
					regNumGenaration.setPostfixStr(postFix);

				if(resetFlag && (regNumGenaration.getResetParam()!= null && !(regNumGenaration.getResetParam().equals(Integer.toString(year)))))
				{
					regNumGenaration.setResetParam(Integer.toString(year));
					regNumGenaration.setCurrentNo(0);
					//So that we get complete no along with Prefix and Postfix strings
					regNum=regNumGenaration.getNexRegNumber();
				}else
					regNum=regNumGenaration.getNexRegNumber();
			} else {
				regNumGenaration = new RegNumGenaration();
				regNumGenaration.setResetParam(""+year);
				regNumGenaration.setEntityName(value);
				regNumGenaration.setCurrentNo(0);

				if(prefix !=null && prefix.length() >0)
					regNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0)
					regNumGenaration.setPostfixStr(postFix);

				//So that we get complete no along with Prefix and Postfix strings
				regNum=regNumGenaration.getNexRegNumber();
			}

			save(regNumGenaration);

			return regNum;
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
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
		try {

			String fromClause = "select regNumGenaration from RegNumGenaration regNumGenaration where ";

			if (regNumGenaration.getRegNumGenarationId() > 0)
				fromClause = fromClause + " regNumGenarationId <> "
						+ regNumGenaration.getRegNumGenarationId() ;

			// Sample Code update accordingly
			// fromClause = fromClause
			// +" regNumGenaration.{Many-to-one}.{Many-to-one}Id = "+regNumGenaration.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			// fromClause = fromClause +" (upper(name) = upper('"+
			// CommonUtils.getEscapedSQLString(regNumGenaration.getName())
			// +"')) " ;

			Query query = getSession().createQuery(fromClause);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (RegNumGenaration) list.get(0);
			else
				return null;
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	public String getRegistrationNumber(String propertyName,String value,String prefix,String postFix,int year) {
		try {
			log.info("finding RegNumGenaration instance with property: "
					+ propertyName + ", value: " + value);



		    String queryString = "select regNumGenaration from RegNumGenaration regNumGenaration " +
		    		"where regNumGenaration.resetParam='"+ year+"' and regNumGenaration."
					+ propertyName + "= ?" ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			RegNumGenaration regNumGenaration=(RegNumGenaration)queryObject.uniqueResult();
		    String regNum="0";
			if(regNumGenaration != null ){

				//Updating the Prefix or Post fix string changes if any for this entity name record.

				if(prefix !=null && prefix.length() >0 && !prefix.equals(regNumGenaration.getPrefixStr()))
					regNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0 && !postFix.equals(regNumGenaration.getPostfixStr()))
					regNumGenaration.setPostfixStr(postFix);

				regNum=regNumGenaration.getNexRegNumber();
			} else {
				regNumGenaration = new RegNumGenaration();
				regNumGenaration.setResetParam(""+year);
				regNumGenaration.setEntityName(value);
				regNumGenaration.setCurrentNo(0);

				if(prefix !=null && prefix.length() >0)
					regNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0)
					regNumGenaration.setPostfixStr(postFix);

				//So that we get complete no along with Prefix and Postfix strings
				regNum=regNumGenaration.getNexRegNumber();
			}

			save(regNumGenaration);

			return regNum;

		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}
	

}
