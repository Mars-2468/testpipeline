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

import com.mars.common.utils.Constants;
import com.mars.rti.dao.TreeCutingDAO;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.model.TreesType;
import com.mars.rti.search.RTIApplicationSearch;

@Repository
public class TreeCutingDAOImpl extends HibernateDaoSupport implements TreeCutingDAO {

	private static final Log log = LogFactory.getLog(MandapPermissionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	@Override
	public void saveTreeCuting(TreeCuting treeCuting) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Tree Cuting save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(treeCuting);
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
	public long treeCutingSave(TreeCuting treeCuting)  {
		// TODO Auto-generated method stub
		TreeCuting b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (TreeCuting) getHibernateTemplate().merge(treeCuting);

			if (b != null) {
				return b.getTreecutingId();
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
		return b.getTreecutingId();
	}

	@Override
	public TreeCuting get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TreeCuting) getHibernateTemplate().get(TreeCuting.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}


	@Override
	public TreeCuting merge(TreeCuting treeCuting) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (TreeCuting) getHibernateTemplate().merge(treeCuting);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public TreeCuting getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select treeCuting from TreeCuting treeCuting where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TreeCuting) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void savetreeTypeList(List<TreesType> ttList) {
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
	public List<TreesType> getTreeTypeList(long id) {
		try{

			String sqlQuery="select treesType from TreesType treesType where treesType.treeCutting.treecutingId = "+id;


			Query query = getSession().createQuery(sqlQuery);

			List<TreesType> list = query.list();

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
		        String sqlQuery = "SELECT tree_fees FROM egovcommon.garden_master_data ra WHERE ra.tree_name = :nameOfTree";

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


	@Override
	public List<RTIApplication> getTreeApplications(RTIApplicationSearch applicationSearch, String userZone,
			String userLevel, boolean isZoneUser) {
	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ra.* ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.tree_cuting frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	 

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());
	    query.addEntity(RTIApplication.class);

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);
	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    return query.list();
	}
	
	


	@Override
	public long getTreeApplicationsCount(RTIApplicationSearch applicationSearch, String userZone, String userLevel,
			boolean isZoneUser) {
		 boolean applyZoneFilter = !isZoneUser
		            && userZone != null
		            && !"".equals(userZone.trim());

		    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
		            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

		    StringBuilder sql = new StringBuilder();

		    sql.append("SELECT COUNT(*) ");
		    sql.append("FROM egovrti.rti_application ra ");
		    sql.append("JOIN egovrti.tree_cuting frm ");
		    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
		    sql.append("WHERE 1=1 ");
		 

		    if (applyZoneFilter) {
		        sql.append("AND ra.zone = :zone ");
		    }

		    if (applyAppNoFilter) {
		        sql.append("AND ra.rti_application_number = :appNo ");
		    }

		    SQLQuery query = getSession().createSQLQuery(sql.toString());

		    if (applyZoneFilter) {
		        query.setParameter("zone", userZone.trim());
		    }

		    if (applyAppNoFilter) {
		        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
		    }

		    return ((Number) query.uniqueResult()).longValue();
	}
	

}
