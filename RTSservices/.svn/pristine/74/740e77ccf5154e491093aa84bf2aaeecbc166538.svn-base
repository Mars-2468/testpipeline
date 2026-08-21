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
import com.mars.rti.dao.FeeMasterDAO;
import com.mars.rti.model.FeeMaster;
import com.mars.rti.search.FeeMasterSearch;
 /**

 * <p>Title: FeeMasterDaoImpl.java </p>

 * @see com.mars.common.model.FeeMaster
 
 * <p>Description: This class is used for hibernate operations for FeeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("FeeMasterDAO")
public class FeeMasterDAOImpl extends HibernateDaoSupport implements FeeMasterDAO {

    private static final Log log = LogFactory.getLog(FeeMasterDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	/**
	 * This method returns FeeMaster object for a given Id
	 * 
	 * @param id as long
	 * @return FeeMaster as model object
	 */
	public FeeMaster get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (FeeMaster) getHibernateTemplate().get(FeeMaster.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the FeeMaster information to the database.
	 * 
	 * @param FeeMaster object
	 * 
	 */
	public void save(FeeMaster entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
	}
    
     /**
	 * This method to merge the FeeMaster information to the database.
	 * 
	 * @param FeeMaster object
	 * 
	 */
    public FeeMaster merge(FeeMaster entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (FeeMaster) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
  }
    
    /**
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id as long
	 */
    public void delete(long id) {
        try {
    		if(log.isDebugEnabled()){
        		log.debug("deleting FeeMaster instance");
        	}
        	FeeMaster entity = (FeeMaster) getHibernateTemplate().load(FeeMaster.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all FeeMaster from the database
	 * 
	 * @return List of FeeMaster
	 */
	public List<FeeMaster> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for FeeMaster");
			}
			return getHibernateTemplate().loadAll(FeeMaster.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listFeeMaster as List
     */
    public void deleteAll(List<FeeMaster> listFeeMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for FeeMaster");
	    	}
	    	getHibernateTemplate().deleteAll(listFeeMaster);
	    	log.debug("deleted successfuly a list of FeeMaster records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of FeeMaster information to the database.
     * 
     * @param listFeeMaster as List
     * 
     */
    public void saveAll(List<FeeMaster> listFeeMaster)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listFeeMaster);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the FeeMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getFeeMasterList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select feeMaster from FeeMaster feeMaster";
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
			List<FeeMaster> list = query.list();
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
	
	/**
	 * This method returns list of the FeeMaster objects available based on Search.
	 * 
	 * @param FeeMasterSearch searchFeeMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getFeeMasterListBySearch(FeeMasterSearch searchFeeMaster){
		if(log.isDebugEnabled()){
			log.debug("getFeeMasterListBySearch Method is called");
		}
		
		try{
			long pageNumber=searchFeeMaster.getCurrentPage();
			String orderBy=searchFeeMaster.getOrderBy();
			String sortBy=searchFeeMaster.getSortBy();
			StringBuffer sql=new StringBuffer();
			String fromClause="select feeMaster from FeeMaster feeMaster";
			List<FeeMaster> list=null;
			boolean flag=false;
			
			if(searchFeeMaster!=null){
				
				if(searchFeeMaster.getName()!=null && searchFeeMaster.getName().length()>0){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("upper(feeMaster.name) like upper('%"+ searchFeeMaster.getName() +"%')");
				}
				
				if(searchFeeMaster.getCategory()==0 ||searchFeeMaster.getCategory()==1){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("feeMaster.category="+ searchFeeMaster.getCategory() +"");
				}
				if((searchFeeMaster.getFromDate() != null && searchFeeMaster.getFromDate().length() > 0) )
				{
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
						
					sql.append("(to_date('"+searchFeeMaster.getFromDate()+"','" + Constants.DATE_FORMAT + "') between to_date(feeMaster.fromDate,'" + Constants.DATE_FORMAT + "') " +
		    				"and to_date(feeMaster.toDate,'" + Constants.DATE_FORMAT + "'))");
					
				}
				if( (searchFeeMaster.getToDate() != null && searchFeeMaster.getToDate().length() > 0) )
				{
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
						
					sql.append("(to_date('"+searchFeeMaster.getToDate()+"','" + Constants.DATE_FORMAT + "') between to_date(feeMaster.fromDate,'" + Constants.DATE_FORMAT + "') " +
		    				"and to_date(feeMaster.toDate,'" + Constants.DATE_FORMAT + "'))");
					
				}
				
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
	
	
	/**
	 * This method returns count of the FeeMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getFeeMasterCount(){
	    try {
			String fromClause = "select count(*) from FeeMaster feeMaster";
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
	
	
	/**
	 * This method returns count of the FeeMaster objects available based on search criteria.
	 * @param FeeMasterSearch searchFeeMaster
	 * @return long
	 * @exception Exception
	 */
	public long getFeeMasterCountBySearch(FeeMasterSearch searchFeeMaster){
		if(log.isDebugEnabled()){
			log.debug("getFeeMasterCountBySearch Method is called");
		}
		
		try{
			//String name=CommonUtils.getEscapedSQLString(searchFeeMaster.getName());
			//long talukaId=searchFeeMaster.getTalukaId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(feeMaster) from FeeMaster feeMaster";
			List list=null;
			boolean flag=false;
         if(searchFeeMaster!=null){
				
				if(searchFeeMaster.getName()!=null && searchFeeMaster.getName().length()>0){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("upper(feeMaster.name) like upper('%"+ searchFeeMaster.getName() +"%')");
				}
				
				if(searchFeeMaster.getCategory()==0 ||searchFeeMaster.getCategory()==1){
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
					    sql.append("feeMaster.category="+ searchFeeMaster.getCategory() +"");
				}
				if((searchFeeMaster.getFromDate() != null && searchFeeMaster.getFromDate().length() > 0) )
				{
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
						
					sql.append("(to_date('"+searchFeeMaster.getFromDate()+"','" + Constants.DATE_FORMAT + "') between to_date(feeMaster.fromDate,'" + Constants.DATE_FORMAT + "') " +
		    				"and to_date(feeMaster.toDate,'" + Constants.DATE_FORMAT + "'))");
					
				}
				if( (searchFeeMaster.getToDate() != null && searchFeeMaster.getToDate().length() > 0) )
				{
					if(!flag){
						flag=true;
						sql.append(" where ");
					}else
						sql.append(" and ");
					
						
					sql.append("(to_date('"+searchFeeMaster.getToDate()+"','" + Constants.DATE_FORMAT + "') between to_date(feeMaster.fromDate,'" + Constants.DATE_FORMAT + "') " +
		    				"and to_date(feeMaster.toDate,'" + Constants.DATE_FORMAT + "'))");
					
				}
				
				
				
				
				
			}
			
			
			
			
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			list=query.list();
			
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
	 * This method returns list of FeeMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of FeeMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(FeeMaster.class);
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
	 * This method returns list of FeeMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding FeeMaster instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select feeMaster from FeeMaster feeMaster where feeMaster."+ propertyName + "= ?";
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
	 * This method returns FeeMaster object for a given data
	 * 
	 * @param FeeMaster as feeMaster
	 * @return FeeMaster as model object
	 */
	public List checkForDuplicates(FeeMaster feeMaster)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select * from egovrti.fee_master fe where " ;

			/*if(feeMaster.getFeeMasterId() > 0)		
				fromClause = fromClause +" feeMasterId <> "+feeMaster.getFeeMasterId()+" and ";*/
			
			fromClause+= " (to_date('"+feeMaster.getFromDate()+"','DD/MM/YYYY') between to_date(fe.from_date,'dd/mm/yyyy') and to_date(fe.to_date,'dd/mm/yyyy')) or  (to_date('"+feeMaster.getToDate()+"','DD/MM/YYYY') between to_date(fe.from_date,'dd/mm/yyyy') and to_date(fe.to_date,'dd/mm/yyyy'))";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" feeMaster.{Many-to-one}.{Many-to-one}Id = "+feeMaster.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(feeMaster.getName()) +"')) and " ;
		
			Query query = getSession().createSQLQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return  list;

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	public FeeMaster getAmount(){
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {			
			String fromClause = "select feeMaster from FeeMaster feeMaster where feeMaster.effectiveDate = " +
								"(select max(feeMaster1.effectiveDate) from FeeMaster feeMaster1)";
		
			Query query = getSession().createQuery(fromClause);		
			List<FeeMaster> list = query.list();

			if (list != null && list.size() > 0) 
				return (FeeMaster) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	public FeeMaster getApplicationCopyFeeDetails(String createdDate,int feeCategory)
    {
		try
	  	{
		  	log.info("finding FeeMaster instance");

			String sqlQueryString = " select fm.* from egovrti.FEE_MASTER fm " +
				" where to_date('"+createdDate+"', 'DD/MM/YYYY')"+
				" between  to_date(fm.from_date, 'DD/MM/YYYY') and  to_date(fm.to_date, 'DD/MM/YYYY') and fm.fee_category="+feeCategory+" ";
			
		    SQLQuery query = getSession().createSQLQuery(sqlQueryString);
			query.addEntity(FeeMaster.class);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (FeeMaster) list.get(0);
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
	
	public FeeMaster getApplicationFeeDetails()
    {
		try
	  	{
		  	log.info("finding FeeMaster instance");

			String sqlQueryString = " select fm.* from egovrti.FEE_MASTER fm " ;
				/*" where ft.fee_type_id = fm.fee_type_id"+
				" and ft.name = 'RTI_APPLICATION'"+
				" order by to_date(fm.effective_date, 'DD/MM/YYYY') desc limit 1";*/
			
		    SQLQuery query = getSession().createSQLQuery(sqlQueryString);
			query.addEntity(FeeMaster.class);
			List list = query.list();

			if (list != null && list.size() > 0)
				return (FeeMaster) list.get(0);
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
}

