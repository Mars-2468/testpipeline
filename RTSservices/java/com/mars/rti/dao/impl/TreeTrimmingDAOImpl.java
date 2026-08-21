package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.TreeTrimmingDAO;
import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.TreeTrimmingDetails;
import com.mars.rti.model.TreesType;


/**
 *
 */

@Repository
public class TreeTrimmingDAOImpl extends HibernateDaoSupport implements TreeTrimmingDAO {

	private static final Log log = LogFactory.getLog(TreeCutingDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	@Override
	public void saveTreeTrimming(TreeTrimming treeTrimming) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Tree Trimming save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(treeTrimming);
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

	@Override
	public long treeTrimmingSave(TreeTrimming treeTrimming) {
		// TODO Auto-generated method stub {
		// TODO Auto-generated method stub
		TreeTrimming b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (TreeTrimming) getHibernateTemplate().merge(treeTrimming);

			if (b != null) {
				return b.getTreeTrimmingId();
			}
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
		return b.getTreeTrimmingId();
	}

	@Override
	public TreeTrimming get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TreeTrimming) getHibernateTemplate().get(TreeTrimming.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}


	@Override
	public TreeTrimming merge(TreeTrimming treeTrimming) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (TreeTrimming) getHibernateTemplate().merge(treeTrimming);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public TreeTrimming getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select treeTrimming from TreeTrimming treeTrimming where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TreeTrimming) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void savetreeTypeList(List<TreeTrimmingDetails> ttList) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Saving tree Tpe List save Method is called");
			}
			getHibernateTemplate().saveOrUpdateAll(ttList);
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


	@Override
	public List<TreeTrimmingDetails> getTreeTypeList(long id) {
		try{

			String sqlQuery="select treeTrimmingDetails from TreeTrimmingDetails treeTrimmingDetails where treeTrimmingDetails.treeTrimming.treeTrimmingId = "+id;

			Query query = getSession().createQuery(sqlQuery);

			List<TreeTrimmingDetails> list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	
}
	
	@Override
	public String getfees(String nameOfTree) {
		 try {
		        String sqlQuery = "SELECT tree_fees_trimming FROM egovcommon.garden_master_data ra WHERE ra.tree_name = :nameOfTree";

		        SQLQuery query = getSession().createSQLQuery(sqlQuery);
		        query.setParameter("nameOfTree", nameOfTree); // Use a parameter instead of concatenation to prevent SQL injection

		        // Execute the query and get the result as a single result (assuming you expect a single result)
		        String tree_fees = (String) query.uniqueResult();

		        return tree_fees;
		    } catch (HibernateException ex) {
		        log.error("Error in getDeptName", ex);
		        return null;
		    }
		}


	

}