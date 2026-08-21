package com.mars.rti.dao.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.utils.Constants;
import com.mars.rti.dao.InboxDAO;
import com.mars.rti.model.Inbox;
import com.mars.rti.search.InboxSearch;

@Repository("inboxDAO")
public class InboxDAOImpl extends HibernateDaoSupport implements InboxDAO {


 private static final Log log = LogFactory.getLog(InboxDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	@Override
	public Inbox get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Inbox) getHibernateTemplate().get(Inbox.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	

	@Override
	public void save(Inbox entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().evict(entity);
			getHibernateTemplate().flush();

			getHibernateTemplate().saveOrUpdate(entity);
			
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		
	}

	@Override
	public Inbox merge(Inbox entity) {
		try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Inbox) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(long id) {
		 try {
	    		if(log.isDebugEnabled()){
	        		log.debug("deleting Inbox instance");
	        	}
	    		Inbox entity = (Inbox) getHibernateTemplate().load(Inbox.class, new Long(id));
				getHibernateTemplate().delete(entity);
	            log.debug("delete successful");
			} catch (Exception exception)
			{
		    	log.error(exception.getStackTrace());
		    	exception.printStackTrace();
			}
		
	}

	@Override
	public List<Inbox> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Inbox");
			}
			return getHibernateTemplate().loadAll(Inbox.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAll(List<Inbox> listInbox) {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listInbox);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		
	}

	@Override
	public void deleteAll(List<Inbox> listInbox) {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Inbox");
	    	}
	    	getHibernateTemplate().deleteAll(listInbox);
	    	log.debug("deleted successfuly a list of Inbox records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		
	}
	



	@Override
	public List<Inbox> getInboxList(long pageNumber, String orderBy,
			String sortBy) {
		try {
			String fromClause = "select inbox from Inbox inbox";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			List<Inbox> list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Inbox> getInboxListBySearch(InboxSearch searchInbox) {
		if(log.isDebugEnabled()){
			log.debug("getInboxListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchInbox.getCurrentPage();
			String orderBy=searchInbox.getOrderBy();
			String sortBy=searchInbox.getSortBy();
			
			long userId=searchInbox.getUserId();
			StringBuffer sql=new StringBuffer();
			String fromClause="select inbox from Inbox inbox";
			List<Inbox> list=null;
			boolean flag=false;
			
			if(userId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				   sql.append("inbox.user.userId="+userId+" ");
			}
			sql.append(" and inbox.active=1 ");
			sql.insert(0, fromClause).append(" order by "+ orderBy+ " "+ sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			list=query.list();
			return list;
		}catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			nullpointerexception.printStackTrace();
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}	
	}
		@Override
	public long getInboxCount() {
		try {
			String fromClause = "select count(*) from Inbox inbox";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();
			
			
			
			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return 0;
	}

	@Override
	public long getInboxCountBySearch(InboxSearch searchInbox) {
		if(log.isDebugEnabled()){
			log.debug("getInboxCountBySearch Method is called");
		}
		
		try{
			
			long userId=searchInbox.getUserId();
			StringBuffer sql=new StringBuffer();
			String fromClause="select count (*) from Inbox inbox";
			List list=null;
			boolean flag=false;
			
			if(userId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("inbox.user.userId="+userId+" ");
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			list=query.list();
			
			if(list!=null && list.size()>0){
				return Long.parseLong(list.get(0).toString());
			}
			  
			else
				return 0;
			
		}catch (NullPointerException nullpointerexception) {
    		log.error(nullpointerexception.getStackTrace());
    		throw new NullPointerException();
    	} catch (HibernateException hibernateException) {
    		log.error(hibernateException.getStackTrace());
    		throw new HibernateException(hibernateException.getMessage());
    	} catch (Exception exception) {
    		log.error(exception.getStackTrace());
    		exception.printStackTrace();
    		throw new RuntimeException(exception.getCause());
    	}	
		
	}

	@Override
	public List<Inbox> findByProperty(String propertyName, Object value) {
		try 
	  	{
		  	log.info("finding Inbox instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select inbox from Inbox inbox where inbox."+ propertyName + "= ?";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, value);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public Inbox checkForDuplicates(Inbox inbox) {
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select inbox from Inbox inbox where " ;

			if(inbox.getInboxId() > 0)		
				fromClause = fromClause +" inboxId <> "+inbox.getInboxId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" inbox.{Many-to-one}.{Many-to-one}Id = "+inbox.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(inbox.getInboxId()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Inbox) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}

	@Override
	public List<Inbox> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		try 
	  	{
		    Query queryObject = getSession().getNamedQuery(namedQuery);
			if(hstKeyValues!=null && hstKeyValues.size()>0)
			{
				Enumeration<String> enumeration = hstKeyValues.keys();
				while(enumeration.hasMoreElements())
				{
				    String strKey = enumeration.nextElement();
				    queryObject.setParameter(strKey,hstKeyValues.get(strKey));
				}
			}
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Inbox> getEntityListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		try{
			if (log.isDebugEnabled())
			{
		    	log.debug("getEntitytListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			query.addEntity(Inbox.class);
			return query.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ArrayList> getListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		try{
			List<ArrayList> listContents = null;
			if (log.isDebugEnabled())
			{
		    	log.debug("getListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			List listQueryData = query.list();
			
			if(listQueryData!=null && listQueryData.size()>0)
			{
				listContents = new ArrayList<ArrayList>();
				
				//Adding Columns Names to the list
				String strColumnNames[] = query.getReturnAliases();
				ArrayList<Object> listColumns = new ArrayList<Object>();
				for(int k=0;k<strColumnNames.length;k++)
				{
					listColumns.add(strColumnNames[k]);
				}
				listContents.add(listColumns);

				// Adding data to the list
				for(int i=0;i<listQueryData.size();i++)
				{
					ArrayList<Object> listData = new ArrayList<Object>();
					Object[] objectArray = (Object[])listQueryData.get(i);
					for(int j=0;j<objectArray.length;j++)
					{
						if(objectArray[j] instanceof Integer )
							listData.add(Integer.parseInt(objectArray[j].toString()));
						else if (objectArray[j] instanceof Long )
							listData.add(Long.parseLong(objectArray[j].toString()));
						else if(objectArray[j] instanceof Double )
							listData.add(Double.parseDouble(objectArray[j].toString()));
						else 
							listData.add(objectArray[j].toString());
							
						listContents.add(listData);
					}
				}
			}
			return listContents;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public long getInboxSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

}
