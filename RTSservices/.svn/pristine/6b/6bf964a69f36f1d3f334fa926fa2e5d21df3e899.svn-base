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
import com.mars.rti.dao.OutwardNumGenarationDAO;
import com.mars.rti.model.OutwardNumGenaration;

/**
 *
 * <p>
 * Title: OutwardNumGenarationDaoImpl.java
 * </p>
 *
 * @see com.mars.fts.model.OutwardGenaration <p>
 *      Description: This class is used for hibernate operations for
 *      OutwardGenaration module
 *      </p>
 *
 *      Copyright (c) 2014 for eGovernance Goa
 *
 * @version: 1.0
 *
 * 
 */
@Repository("outwardNumGenarationDAO")
public class OutwardNumGenarationDAOImpl extends HibernateDaoSupport implements
		OutwardNumGenarationDAO {

	private static final Log log = LogFactory
			.getLog(OutwardNumGenarationDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns OutwardNumGenaration object for a given Id
	 *
	 * @param id
	 *            as long
	 * @return OutwardNumGenaration as model object
	 */
	public OutwardNumGenaration get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (OutwardNumGenaration) getHibernateTemplate().get(
					OutwardNumGenaration.class, new Long(id));
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
	 * This method save/updates the OutwardNumGenaration information to the
	 * database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	public void save(OutwardNumGenaration entity) {
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
	 * This method to merge the OutwardNumGenaration information to the database.
	 *
	 * @param OutwardNumGenaration
	 *            object
	 *
	 */
	public OutwardNumGenaration merge(OutwardNumGenaration entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (OutwardNumGenaration) getHibernateTemplate().merge(entity);
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
				log.debug("deleting OutwardNumGenaration instance");
			}
			OutwardNumGenaration entity = (OutwardNumGenaration) getHibernateTemplate()
					.load(OutwardNumGenaration.class, new Long(id));
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
	 * This method will return a list of all OutwardNumGenaration from the database
	 *
	 * @return List of OutwardNumGenaration
	 */
	public List<OutwardNumGenaration> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for OutwardNumGenaration");
			}
			return getHibernateTemplate().loadAll(OutwardNumGenaration.class);
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
	 * @param listOutwardNumGenaration
	 *            as List
	 */
	public void deleteAll(List<OutwardNumGenaration> listOutwardNumGenaration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for OutwardNumGenaration");
			}
			getHibernateTemplate().deleteAll(listOutwardNumGenaration);
			log
					.debug("deleted successfuly a list of OutwardNumGenaration records from database");
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
	 * This method save/updates a list of OutwardNumGenaration information to the
	 * database.
	 *
	 * @param listOutwardNumGenaration
	 *            as List
	 *
	 */
	public void saveAll(List<OutwardNumGenaration> listOutwardNumGenaration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listOutwardNumGenaration);
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

		try {
			String fromClause = "select outwardNumGenaration from OutwardNumGenaration outwardNumNumGenaration";
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

			List<OutwardNumGenaration> list = query.list();

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
	 * This method returns count of the OutwardNumGenaration objects available based
	 * on search criteria.
	 *
	 * @return long
	 * @exception Exception
	 */
	public long getOutwardNumGenarationCount() {
		try {
			String fromClause = "select count(*) from OutwardNumGenaration outwardNumGenaration";
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
		try {
			log.info("finding OutwardNumGenaration instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select outwardNumGenaration from OutwardNumGenaration outwardNumGenaration  where outwardNumGenaration."
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

	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,Boolean resetFlag) {
		try {
			log.info("finding OutwardNumGenaration instance with property: "
					+ propertyName + ", value: " + value);

			Calendar cal=Calendar.getInstance();
		    int year=cal.get(Calendar.YEAR);

		    String queryString = "select outwardNumGenaration from OutwardNumGenaration outwardNumGenaration where outwardNumGenaration."
					+ propertyName + "= ? " ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			OutwardNumGenaration outwardNumGenaration=(OutwardNumGenaration)queryObject.uniqueResult();
		    String outwardNum="0";
			if(outwardNumGenaration != null ){

				//Updating the Prefix or Post fix string changes if any for this entity name record.

				
				if(resetFlag && (outwardNumGenaration.getResetParam()!= null && !(outwardNumGenaration.getResetParam().equals(Integer.toString(year)))))
				{
					outwardNumGenaration.setResetParam(Integer.toString(year));
					outwardNumGenaration.setCurrentNo(0);
					//So that we get complete no along with Prefix and Postfix strings
					outwardNum=outwardNumGenaration.geNextOutwardNumber();
				}else
					outwardNum=outwardNumGenaration.geNextOutwardNumber();
			} else {
				outwardNumGenaration = new OutwardNumGenaration();
				outwardNumGenaration.setResetParam(""+year);
				outwardNumGenaration.setCurrentNo(0);

				

				//So that we get complete no along with Prefix and Postfix strings
				outwardNum=outwardNumGenaration.geNextOutwardNumber();
			}

			save(outwardNumGenaration);

			return outwardNum;
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
	 * This method returns OutwardGenaration object for a given data
	 *
	 * @param OutwardGenaration
	 *            as outwardNumGenaration
	 * @return OutwardGenaration as model object
	 */
	public OutwardNumGenaration checkForDuplicates(OutwardNumGenaration outwardNumGenaration) {
		if (log.isDebugEnabled()) {
			log.debug("checkForDuplicates Method is called");
		}
		try {

			String fromClause = "select outwardNumGenaration from OutwardNumGenaration outwardNumGenaration where ";

			if (outwardNumGenaration.getOutwardNumGenarationId()> 0)
				fromClause = fromClause + " outwardNumGenarationId <> "
						+ outwardNumGenaration.getOutwardNumGenarationId() ;

			// Sample Code update accordingly
			// fromClause = fromClause
			// +" outwardNumGenaration.{Many-to-one}.{Many-to-one}Id = "+outwardNumGenaration.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			// fromClause = fromClause +" (upper(name) = upper('"+
			// CommonUtils.getEscapedSQLString(outwardNumGenaration.getName())
			// +"')) " ;

			Query query = getSession().createQuery(fromClause);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (OutwardNumGenaration) list.get(0);
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










	public String getOutwardNumber(String propertyName,String value,String prefix,String postFix,int year) {
		try {
			log.info("finding RegNumGenaration instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select outwardNumGenaration from OutwardNumGenaration outwardNumGenaration " +
		    		"where outwardNumGenaration.resetParam='"+ year+"' and outwardNumGenaration."
					+ propertyName + "= ?" ;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			OutwardNumGenaration outwardNumGenaration=(OutwardNumGenaration)queryObject.uniqueResult();
		    String outwardNum="0";
			if(outwardNumGenaration != null ){
				//Updating the Prefix or Post fix string changes if any for this entity name record.
				if(prefix !=null && prefix.length() >0 && !prefix.equals(outwardNumGenaration.getPrefixStr()))
					outwardNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0 && !postFix.equals(outwardNumGenaration.getPostfixStr()))
					outwardNumGenaration.setPostfixStr(postFix);

				
				outwardNum=outwardNumGenaration.geNextOutwardNumber();
			} else {
				outwardNumGenaration = new OutwardNumGenaration();
				outwardNumGenaration.setResetParam(""+year);
				outwardNumGenaration.setEntityName(value);
				outwardNumGenaration.setCurrentNo(0);
				//So that we get complete no along with Prefix and Postfix strings
				if(prefix !=null && prefix.length() >0)
					outwardNumGenaration.setPrefixStr(prefix);

				if(postFix !=null && postFix.length() >0)
					outwardNumGenaration.setPostfixStr(postFix);

				outwardNum=outwardNumGenaration.geNextOutwardNumber();
			}

			save(outwardNumGenaration);

			return outwardNum;

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

