package com.mars.common.dao.impl;


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

import com.mars.common.dao.PlotDAO;
import com.mars.common.model.Plot;
import com.mars.common.search.PlotSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: PlotDaoImpl.java </p>

 * @see com.mars.common.model.Plot
 
 * <p>Description: This class is used for hibernate operations for Plot module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("PlotDAO")
public class PlotDAOImpl extends HibernateDaoSupport implements PlotDAO {

    private static final Log log = LogFactory.getLog(PlotDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns Plot object for a given Id
	 * 
	 * @param id as long
	 * @return Plot as model object
	 */
	public Plot get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Plot) getHibernateTemplate().get(Plot.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Plot information to the database.
	 * 
	 * @param Plot object
	 * 
	 */
	public void save(Plot entity) {
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
	 * This method to merge the Plot information to the database.
	 * 
	 * @param Plot object
	 * 
	 */
    public Plot merge(Plot entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Plot) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Plot instance");
        	}
        	Plot entity = (Plot) getHibernateTemplate().load(Plot.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Plot from the database
	 * 
	 * @return List of Plot
	 */
	public List<Plot> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Plot");
			}
			return getHibernateTemplate().loadAll(Plot.class);
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
     * @param listPlot as List
     */
    public void deleteAll(List<Plot> listPlot)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Plot");
	    	}
	    	getHibernateTemplate().deleteAll(listPlot);
	    	log.debug("deleted successfuly a list of Plot records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Plot information to the database.
     * 
     * @param listPlot as List
     * 
     */
    public void saveAll(List<Plot> listPlot)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listPlot);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the Plot objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getPlotList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select plot from Plot plot";
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
			List<Plot> list = query.list();
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
	 * This method returns list of the Plot objects available based on Search.
	 * 
	 * @param PlotSearch searchPlot
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getPlotListBySearch(PlotSearch searchPlot){
		if(log.isDebugEnabled()){
			log.debug("getPlotListBySearch Method is called");
		}
		
		try{
			
			long pageNumber=searchPlot.getCurrentPage();
			String orderBy=searchPlot.getOrderBy();
			String sortBy=searchPlot.getSortBy();
			
			String number=CommonUtils.getEscapedSQLString(searchPlot.getNumber());
			long plotTypeId=searchPlot.getPlotTypeId();
			long sectorId=searchPlot.getSectorId();
			long nodeId=searchPlot.getNodeMasterId();
			long wardId=searchPlot.getWardId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select plot from Plot plot";
			List<Plot> list=null;
			boolean flag=false;
			
			if(number!=null && number.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(plot.number) like upper('%"+ number +"%')");
			}
			if(plotTypeId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.plotType.plotTypeId=" + plotTypeId);
			} 
			if(sectorId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.sector.sectorId=" + sectorId);
			}
			if(nodeId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.sector.nodeMaster.nodeMasterId=" + nodeId);
			}
			if(wardId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.sector.nodeMaster.ward.wardId=" + wardId);
			}
			
			sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
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
	 * This method returns count of the Plot objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getPlotCount(){
	    try {
			String fromClause = "select count(*) from Plot plot";
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
	 * This method returns count of the Plot objects available based on search criteria.
	 * @param PlotSearch searchPlot
	 * @return long
	 * @exception Exception
	 */
	public long getPlotCountBySearch(PlotSearch searchPlot){
		if(log.isDebugEnabled()){
			log.debug("getPlotCountBySearch Method is called");
		}
		
		try{
			
			String number=CommonUtils.getEscapedSQLString(searchPlot.getNumber());
			long plotTypeId=searchPlot.getPlotTypeId();
			long sectorId=searchPlot.getSectorId();
			long nodeId=searchPlot.getNodeMasterId();
			long wardId=searchPlot.getWardId();
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(plot) from Plot plot";
			List list=null;
			boolean flag=false;
			
			if(number!=null && number.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(plot.number) like upper('%"+ number +"%')");
			}
			if(plotTypeId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.plotType.plotTypeId=" + plotTypeId);
			}
			if(sectorId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else 
					sql.append(" and ");
				 
				    sql.append("plot.sector.sectorId=" + sectorId);
			}
			if(nodeId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.sector.nodeMaster.nodeMasterId=" + nodeId);
			}
			if(wardId>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("plot.sector.nodeMaster.ward.wardId=" + wardId);
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
	 * This method returns list of Plot objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of Plot objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Plot.class);
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
	 * This method returns list of Plot objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Plot instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select plot from Plot plot where plot."+ propertyName + "= ?";
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
	 * This method returns Plot object for a given data
	 * 
	 * @param Plot as plot
	 * @return Plot as model object
	 */
	public Plot checkForDuplicates(Plot plot)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select plot from Plot plot where " ;

			if(plot.getPlotId() > 0)		
				fromClause = fromClause +" plotId <> "+plot.getPlotId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" plot.{Many-to-one}.{Many-to-one}Id = "+plot.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(number) = upper('"+ CommonUtils.getEscapedSQLString(plot.getNumber()) +"')) and " ;
			fromClause = fromClause +" plot.sector.sectorId = " + plot.getSector().getSectorId();
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Plot) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
}

