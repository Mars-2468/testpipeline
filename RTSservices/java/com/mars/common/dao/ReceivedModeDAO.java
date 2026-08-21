package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.ReceivedMode;
import com.mars.common.search.ReceivedModeSearch;

//@Transactional(readOnly = true)
public interface ReceivedModeDAO {
  
	public ReceivedMode get(long id);
		
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(ReceivedMode entity);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public ReceivedMode merge(ReceivedMode entity); 
	    

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;

	public List<ReceivedMode> getAll();

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<ReceivedMode> listNode);
    
 	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<ReceivedMode> listNode);
    
	public List<ReceivedMode> getReceivedModeCountList(long pageNumber,String orderBy, String sortBy);
		
	public List<ReceivedMode> getReceivedModeListBySearch(ReceivedModeSearch ReceivedModeSearch);
		
	public long getReceivedModeCount();
	
	
	public long getReceivedModeCountBySearch(ReceivedModeSearch ReceivedModeSearch);
	
    public List<ReceivedMode> findByProperty(String propertyName, Object value);	    

	public ReceivedMode checkForDuplicates(ReceivedMode node);    

	public List<ReceivedMode> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

	public List<ReceivedMode> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

