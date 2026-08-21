package com.mars.rti.dao.impl;

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

import com.mars.common.utils.Constants;
import com.mars.rti.dao.InwardNumGenarationDAO;
import com.mars.rti.model.InwardNumGenaration;

/**
 *
 * <p>
 * Title: InwardNumGenarationDaoImpl.java
 * </p>
 *
 * @see com.mars.fts.model.InwardGenaration <p>
 *      Description: This class is used for hibernate operations for
 *      InwardGenaration module
 *      </p>
 *
 *      Copyright (c) 2014 for eGovernance Goa
 *
 * @version: 1.0
 *
 * 
 */
@Repository("inwardNumGenarationDAO")
public class InwardNumGenarationDAOImpl extends HibernateDaoSupport implements
		InwardNumGenarationDAO {

	private static final Log log = LogFactory
			.getLog(InwardNumGenarationDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns InwardNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return InwardNumGenaration as model object
	 */
	public InwardNumGenaration get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (InwardNumGenaration) getHibernateTemplate().get(
					InwardNumGenaration.class, new Long(id));
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
	 * This method save/updates the InwardNumGenaration information to the
	 * database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	public void save(InwardNumGenaration entity) {
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
	 * This method to merge the InwardNumGenaration information to the database.
	 *
	 * @param InwardNumGenaration
	 *            object
	 *
	 */
	public InwardNumGenaration merge(InwardNumGenaration entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (InwardNumGenaration) getHibernateTemplate().merge(entity);
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
				log.debug("deleting InwardNumGenaration instance");
			}
			InwardNumGenaration entity = (InwardNumGenaration) getHibernateTemplate()
					.load(InwardNumGenaration.class, new Long(id));
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
	 * This method will return a list of all InwardNumGenaration from the database
	 *
	 * @return List of InwardNumGenaration
	 */
	public List<InwardNumGenaration> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for InwardNumGenaration");
			}
			return getHibernateTemplate().loadAll(InwardNumGenaration.class);
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
	 * @param listInwardNumGenaration
	 *            as List
	 */
	public void deleteAll(List<InwardNumGenaration> listInwardNumGenaration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for InwardNumGenaration");
			}
			getHibernateTemplate().deleteAll(listInwardNumGenaration);
			log
					.debug("deleted successfuly a list of InwardNumGenaration records from database");
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
	 * This method save/updates a list of InwardNumGenaration information to the
	 * database.
	 *
	 * @param listInwardNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<InwardNumGenaration> listInwardNumGenaration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listInwardNumGenaration);
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

		try {
			String fromClause = "select inwardNumGenaration from InwardNumGenaration inwardNumNumGenaration";
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

			List<InwardNumGenaration> list = query.list();

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
	 * This method returns count of the InwardNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getInwardNumGenarationCount() {
		try {
			String fromClause = "select count(*) from InwardNumGenaration inwardNumGenaration";
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
		try {
			log.info("finding InwardNumGenaration instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select inwardNumGenaration from InwardNumGenaration inwardNumGenaration  where inwardNumGenaration."
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

	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag) {
		try {
			log.info("finding InwardNumGenaration instance with property: "
					+ propertyName + ", value: " + value);

			Calendar cal=Calendar.getInstance();
		    int year=cal.get(Calendar.YEAR);

		    String queryString = "select inwardNumGenaration from InwardNumGenaration inwardNumGenaration where inwardNumGenaration."
					+ propertyName + "= ? " ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			InwardNumGenaration inwardNumGenaration=(InwardNumGenaration)queryObject.uniqueResult();
		    String inwardNum="0";
			if(inwardNumGenaration != null ){

				//Updating the Prefix or Post fix string changes if any for this entity name record.

				
				if(resetFlag && (inwardNumGenaration.getResetParam()!= null && !(inwardNumGenaration.getResetParam().equals(Integer.toString(year)))))
				{
					inwardNumGenaration.setResetParam(Integer.toString(year));
					inwardNumGenaration.setCurrentNo(0);
					//So that we get complete no along with Prefix and Postfix strings
					inwardNum=inwardNumGenaration.geNextInwardNumber();
				}else
					inwardNum=inwardNumGenaration.geNextInwardNumber();
			} else {
				inwardNumGenaration = new InwardNumGenaration();
				inwardNumGenaration.setResetParam(""+year);
				inwardNumGenaration.setCurrentNo(0);

				

				//So that we get complete no along with Prefix and Postfix strings
				inwardNum=inwardNumGenaration.geNextInwardNumber();
			}

			save(inwardNumGenaration);

			return inwardNum;
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
	 * This method returns InwardGenaration object for a given data
	 *
	 * @param InwardGenaration
	 *            as inwardNumGenaration
	 * @return InwardGenaration as model object
	 */
	public InwardNumGenaration checkForDuplicates(InwardNumGenaration inwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		try {

			String fromClause = "select inwardNumGenaration from InwardNumGenaration inwardNumGenaration where ";

			if (inwardNumGenaration.getInwardNumGenarationId()> 0)
				fromClause = fromClause + " inwardNumGenarationId <> "
						+ inwardNumGenaration.getInwardNumGenarationId() ;

			// Sample Code update accordingly
			// fromClause = fromClause
			// +" inwardNumGenaration.{Many-to-one}.{Many-to-one}Id = "+inwardNumGenaration.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			// fromClause = fromClause +" (upper(name) = upper('"+
			// CommonUtils.getEscapedSQLString(inwardNumGenaration.getName())
			// +"')) " ;

			Query query = getSession().createQuery(fromClause);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (InwardNumGenaration) list.get(0);
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










	public String getInwardNumber(String propertyName,String value,String prefix,String postFix,int year) {
		try {
			log.info("finding InwardNumGenaration instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select inwardNumGenaration from InwardNumGenaration inwardNumGenaration " +
		    		"where inwardNumGenaration.resetParam='"+ year+"' and inwardNumGenaration."
					+ propertyName + "= ?" ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			InwardNumGenaration inwardNumGenaration=(InwardNumGenaration)queryObject.uniqueResult();
		    String inwardNum="0";
			if(inwardNumGenaration != null ){
				//Updating the Prefix or Post fix string changes if any for this entity name record.
				if(prefix !=null && prefix.length() >0 && !prefix.equals(inwardNumGenaration.getPrefixStr()))
					inwardNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0 && !postFix.equals(inwardNumGenaration.getPostfixStr()))
					inwardNumGenaration.setPostfixStr(postFix);

				
				inwardNum=inwardNumGenaration.geNextInwardNumber();
			} else {
				inwardNumGenaration = new InwardNumGenaration();
				inwardNumGenaration.setResetParam(""+year);
				inwardNumGenaration.setEntityName(value);
				inwardNumGenaration.setCurrentNo(0);
				//So that we get complete no along with Prefix and Postfix strings
				if(prefix !=null && prefix.length() >0)
					inwardNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0)
					inwardNumGenaration.setPostfixStr(postFix);

				inwardNum=inwardNumGenaration.geNextInwardNumber();
			}

			save(inwardNumGenaration);

			return inwardNum;

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

