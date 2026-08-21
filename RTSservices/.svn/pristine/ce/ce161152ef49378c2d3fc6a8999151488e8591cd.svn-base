package com.mars.common.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.DeliveryMode; 

@Transactional(readOnly = true)
public interface DeliveryModeService {
	  
	public DeliveryMode get(long id);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(DeliveryMode entity);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public DeliveryMode merge(DeliveryMode entity); 
	    
	public List<DeliveryMode> getAll();

	/*@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<DeliveryMode> listNode);
    
 	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<DeliveryMode> listNode);
    
	public List<DeliveryMode> getDeliveryModeCountList(long pageNumber,String orderBy, String sortBy);*/
		
	//public List<DeliveryMode> getDeliveryModeListBySearch(DeliveryModeSearch fileReceivedModeSearch);
		
	public long getDeliveryModeCount();
	
	
	//public long getDeliveryModeCountBySearch(DeliveryModeSearch deliveryModeSearch);
	
    public List<DeliveryMode> findByProperty(String propertyName, Object value);	    

	public DeliveryMode checkForDuplicates(DeliveryMode DeliveryMode);    

/*	public List<DeliveryMode> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

	public List<DeliveryMode> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	*/
}

