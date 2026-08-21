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

import com.mars.common.model.DeliveryMode;
import com.mars.common.model.DeliveryModeFields;
import com.mars.common.utils.Constants;
import com.mars.rti.dao.DraftDAO;
import com.mars.rti.model.Draft;
import com.mars.rti.model.DraftType;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DraftSearch;
 /**

 * <p>Title: fileCreationDaoImpl.java </p>

 * @see com.mars.common.model.FileCreate
 
 * <p>Description: This class is used for hibernate operations for FileCreate module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("draftDAO")
public class DraftDAOImpl extends HibernateDaoSupport implements DraftDAO {

    private static final Log log = LogFactory.getLog(DraftDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
    @Override
	public Draft get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Draft) getHibernateTemplate().get(Draft.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
     
    @Override
	public void save(Draft entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			//FileCreation fileCreation = get(entity.getFileCreationId());
			//getHibernateTemplate().evict(fileCreation);
			//getHibernateTemplate().flush();
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
	}
    
  
    @Override
    public Draft merge(Draft entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
      		Draft acknowledgement = get(entity.getDraftId());
			getHibernateTemplate().evict(acknowledgement);
			getHibernateTemplate().flush();
      		
		    return (Draft) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Acknowledgement instance");
        	}
    		Draft entity = (Draft) getHibernateTemplate().load(Draft.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
 
	public List<Draft> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Draft");
			}
			return getHibernateTemplate().loadAll(Draft.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
 
	@Override
    public void deleteAll(List<Draft> listDraft)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Acknowledgement");
	    	}
	    	//getHibernateTemplate().deleteAll(listDraft);
	    	log.debug("deleted successfuly a list of Draft records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

 
	@Override
    public void saveAll(List<Draft> listDraft)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listDraft);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
 
	@Override
	public List<Draft> getDraftList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select draft from Draft draft";
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
			List<Draft> list = query.list();
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
	public List<Draft> getDraftListBySearch(DraftSearch draftSearch){
		if(log.isDebugEnabled()){
			log.debug("getDraftListBySearch Method is called");
		}
		
		try{
			long pageNumber=draftSearch.getCurrentPage();
			String orderBy=draftSearch.getOrderBy();
			String sortBy=draftSearch.getSortBy();
			
			String ackNumber = draftSearch.getDraftNumber();	 
			String subject = draftSearch.getSubject(); 
			String createDate = draftSearch.getCreationDate();
			String sentDate = draftSearch.getSentDate();
			
			Integer sentStatus = draftSearch.getSentStatus(); 
			long tenancyId = draftSearch.getTenancyId(); 
			
			
					
			StringBuffer sql=new StringBuffer();
			String fromClause="select draft from Draft draft";
			List<Draft> list=null;
			boolean flag=false;
			
			if(ackNumber!=null && ackNumber.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(draft.draftNumber) like upper('%"+ ackNumber +"%')");
			}
			
			if (createDate != null && createDate.length() > 0)
		    {
			 if (!flag){
					flag=true;
					sql.append(" where ");
				} else
					sql.append(" and ");
			sql.append(" to_date(draft.creationDate,'DD-MM-YYYY')  = to_date('" + createDate + "','" + Constants.DATE_FORMAT + "') ");
		    }
			
			if (sentDate != null && sentDate.length() > 0)
		    {
			 if (!flag){
					flag=true;
					sql.append(" where ");
				} else
					sql.append(" and ");
			sql.append(" to_date(draft.sentDate,'DD-MM-YYYY')  = to_date('" + sentDate + "','" + Constants.DATE_FORMAT + "') ");
		    }
			
	 	 
			if(tenancyId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append(" draft.tenancy.tenancyId = "+tenancyId);
			}
			if(sentStatus != null){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append(" draft.sentStatus = "+sentStatus);
			} 			 
			
			sql.insert(0, fromClause).append(" order by " + orderBy + " "+ sortBy);
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
	public long getDraftCount(){
	    try {
			String fromClause = "select count(*) from draft draft";
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
	public long getDraftCountBySearch(DraftSearch draftSearch){
		if(log.isDebugEnabled()){
			log.debug("getDraftCountBySearch Method is called");
		}
		
		try{
			 
			String ackNumber = draftSearch.getDraftNumber()	 ;
			String subject = draftSearch.getSubject(); 
			String createDate = draftSearch.getCreationDate();
			String sentDate = draftSearch.getSentDate();
			
			Integer sentStatus = draftSearch.getSentStatus(); 
			long tenancyId = draftSearch.getTenancyId();  
			
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(draft) from Draft draft";				
			boolean flag=false;
			
			if(ackNumber!=null && ackNumber.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(draft.draftNumber) like upper('%"+ ackNumber +"%')");
			}
			
			if (createDate != null && createDate.length() > 0)
		    {
			 if (!flag){
					flag=true;
					sql.append(" where ");
				} else
					sql.append(" and ");
			sql.append(" to_date(draft.creationDate,'DD-MM-YYYY')  = to_date('" + createDate + "','" + Constants.DATE_FORMAT + "') ");
		    }
			
			if (sentDate != null && sentDate.length() > 0)
		    {
			 if (!flag){
					flag=true;
					sql.append(" where ");
				} else
					sql.append(" and ");
			sql.append(" to_date(draft.sentDate,'DD-MM-YYYY')  = to_date('" + sentDate + "','" + Constants.DATE_FORMAT + "') ");
		    }
			
 		 
			if(tenancyId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append(" draft.tenancy.tenancyId = "+tenancyId);
			}
			if(sentStatus != null ){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append(" draft.sentStatus = "+sentStatus);
			}
			
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			
			List list=query.list();
			
			if(list!=null && list.size()>0)
				return Long.parseLong(list.get(0).toString());
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
    
    
    /**
	 * This method returns list of FileCreate objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Draft> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
    {
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
    
    /**
	 * This method returns list of FileCreate objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<Draft> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
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
			query.addEntity(RTIApplication.class);
			return query.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }	
    
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
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
    
    /**
	 * This method returns list of FileCreate objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<Draft> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Draft instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select draft from Draft draft where draft."+ propertyName + "= ?";
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

	/**
	 * This method returns FileCreate object for a given data
	 * 
	 * @param FileCreate as FileCreate
	 * @return FileCreate as model object
	 */
	@Override
	public Draft checkForDuplicates(Draft draft)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
	
		return null;	
	}

	public List<DeliveryMode> getDraftModeList(){
	  
		String queryString = "select deliveryMode from DeliveryMode deliveryMode where status="+1;
		Query queryObject = getSession().createQuery(queryString); 
	   	return queryObject.list();
	}
 
	 
	public DeliveryMode getDraftMode(long id){
		
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DeliveryMode) getHibernateTemplate().get(DeliveryMode.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		} 
		return null;
		
	}

	public DeliveryModeFields getDraftModeFields(long id){
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DeliveryModeFields) getHibernateTemplate().get(DeliveryModeFields.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		} 
		return null;
	}
	public List<DraftType> getAllDraftType(){
		String queryString = "select draftType from DraftType draftType where status="+1;
		Query queryObject = getSession().createQuery(queryString); 
	   	return queryObject.list();
	}
	
	public DraftType getDraftTypeById(long id){
		try {
			if (log.isDebugEnabled()) {
				log.debug("getDraftTypeById Method is called " + id);
			}
			return (DraftType) getHibernateTemplate().get(DraftType.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		} 
		return null;
	}
	 
 
	
}

