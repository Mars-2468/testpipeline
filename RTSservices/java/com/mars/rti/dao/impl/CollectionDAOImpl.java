package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.mars.rti.dao.CollectionDAO;
import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.search.RTIApplicationSearch;
@Repository("collectionDAO")
public class CollectionDAOImpl extends HibernateDaoSupport implements CollectionDAO {
	
	
	private static final Log log =LogFactory.getLog(CollectionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	
	
	@Override
	public Collection saveCollection(Collection collection) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(collection);
		} catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
		    hibernateException.printStackTrace();
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
		    exception.printStackTrace();
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
		return collection;
		
	}
	
	@Override
	public Collection getCollection(long id) {
		try{

			String sqlQuery="select collection from Collection collection where collection.rtiApplication = "+id;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (Collection) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public List<CollectionBuffer> getAllFailedCollections(String sqlQuery,long pageNumber,RTIApplicationSearch searchOptions) {
		try{
			String orderBy = "ra.rti_application_id";
			String sortBy = "desc";
			String fromClause = getSearchQuery(searchOptions);

			sqlQuery = StringUtils.isNotEmpty(fromClause) ? sqlQuery + "and " + fromClause : sqlQuery;

			sqlQuery = sqlQuery + " order by " + orderBy + " " + sortBy;
			SQLQuery query = getSession().createSQLQuery(sqlQuery);
			List listQueryData=query.list();

			if (listQueryData != null && listQueryData.size() > 0) {
				 List<CollectionBuffer> listcbs=null;
						
					query.addEntity(CollectionBuffer.class);
					if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
						if (pageNumber > 1) {
							query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
							query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
						} else {
							query.setFirstResult(0);
							query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
						}
					}
					listcbs = query.list();
			        return listcbs;
					}
					
				
			
			
			
		}catch(Exception exception){
			
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	
		
	}

	@Override
	public void updateAllFailedCollectionList(long collectionBufferId,String refNumber) {
		
		  String sqlQuery=" update CollectionBuffer set  status=1,refNumber='"+refNumber+"' Where collectionBufferId = " + collectionBufferId ;
		try{
			
		 this.getHibernateTemplate().bulkUpdate(sqlQuery);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}




	@Override
	public void saveCollectionList(List<Collection> listcollection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("SaveCollectionList save Method is called");
			}
			getHibernateTemplate().saveOrUpdateAll(listcollection);
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
	public long getAllFailedCollectionsCount(String string,
			long longCurrentPage,RTIApplicationSearch searchOptions) {
		try{
			String fromClause = getSearchQuery(searchOptions);

			string = StringUtils.isNotEmpty(fromClause) ? string + "and " + fromClause : string;

			SQLQuery query = getSession().createSQLQuery(string);
			List listQueryData=query.list();
			
			if (listQueryData != null && listQueryData.size() > 0) {
					
				listQueryData = query.list();
					return Long.parseLong(listQueryData.get(0).toString());
					
			}
		}catch(Exception exception){
			
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return 0;
	
		
	}


	private String getSearchQuery(RTIApplicationSearch searchOptions) {
		String condition = " and ";
		String fromClause = "";
		boolean conditionFound = false;
		//String fromDate=searchOptions.getFromDate();
		//String toDate=searchOptions.getToDate();zy
		long tenancyId=searchOptions.getTenancyId();
		
		if (searchOptions != null) {

			String searchrtiApplnNumber = searchOptions.getRtiApplicationNumber();
			String RegistrationFromDate =  searchOptions.getCreationFromDate();
			String RegistrationToDate =  searchOptions.getCreationToDate();
			
			if (StringUtils.isNotEmpty(searchrtiApplnNumber)) {
				if (conditionFound)
					fromClause = fromClause + condition;
				
				fromClause = fromClause +"ra.rti_application_number='"+searchrtiApplnNumber+"'";
				conditionFound = true;
			}
			
			if((RegistrationFromDate != null && RegistrationFromDate.length() > 0) && (RegistrationToDate != null && RegistrationToDate.length() > 0))
			{
				if (conditionFound)
					fromClause = fromClause + condition;
				fromClause = fromClause +(" (to_timestamp(ra.registration_date,'DD/MM/YYYY HH24:MI:SS') between to_timestamp('" + RegistrationFromDate + "','DD/MM/YYYY HH24:MI:SS') " +
	    				"and to_timestamp('" + RegistrationToDate + "','DD/MM/YYYY HH24:MI:SS'))");
				conditionFound = true;
			}
			
		}
		return fromClause;
	}
	
	@Override
	public Collection getCollections(long id) {
		try{


			String sqlQuery="select collection from Collection collection where collection_id = "+id;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (Collection) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
}
