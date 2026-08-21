package com.mars.rti.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.DeliveryMode;
import com.mars.common.model.DeliveryModeFields;
import com.mars.rti.model.Draft;
import com.mars.rti.model.DraftType;
import com.mars.rti.search.DraftSearch;
   
public interface DraftDAO {

 
	public Draft get(long id);
  
	public void save(Draft entity);
	
     public Draft merge(Draft entity);
 
    public void delete(long id) ;
	
 
	public List<Draft> getAll();
 
    public void saveAll(List<Draft> listDraft);
    
 
    public void deleteAll(List<Draft> listDraft);
    
   
	public List<Draft> getDraftList(long pageNumber,String orderBy, String sortBy);
	
 
	public List<Draft> getDraftListBySearch(DraftSearch draftSearch);
	
	 
	public long getDraftCount();
	
 
	public long getDraftCountBySearch(DraftSearch draftSearch);
 
    public List<Draft> findByProperty(String propertyName, Object value);

	public Draft checkForDuplicates(Draft  draft);
	

	public List<Draft> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);
 
	public List<Draft> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
 
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
 
	public List<DeliveryMode> getDraftModeList(); 
	
	public DeliveryMode getDraftMode(long id);
	
	public DeliveryModeFields getDraftModeFields(long id);
	
	public List<DraftType> getAllDraftType();
	public DraftType getDraftTypeById(long id);
	
}


