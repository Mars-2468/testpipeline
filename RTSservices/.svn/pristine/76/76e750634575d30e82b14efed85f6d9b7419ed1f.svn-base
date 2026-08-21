package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DocumentMasterDAO;
import com.mars.common.model.DmsDocumentMaster;
import com.mars.common.model.DocumentMaster;
import com.mars.common.search.DocumentMasterSearch;
import com.mars.common.service.DocumentMasterService;
import com.mars.dms.dao.DmsDocumentDAO;
import com.mars.dms.model.DmsDocument;
import com.mars.dms.model.DmsDocumentCheckList;
import com.mars.dms.service.DmsDocumentCheckListService;
import com.mars.dms.service.DmsDocumentService;
/**

 * <p>Title: DocumentMasterServiceImpl.java </p>

 * @see com.mars.common.model.DocumentMaster
 
 * <p>Description: This class is used for hibernate operations for DocumentMaster module</p>

 * Copyright (c) 2008 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
 @Service("documentMasterService")
public class DocumentMasterServiceImpl implements DocumentMasterService {

    private static final Log log = LogFactory.getLog(DocumentMasterServiceImpl.class);

    @Autowired
    private DmsDocumentCheckListService dmsDocumentCheckListService;  	
	
    @Autowired
	private DocumentMasterDAO documentMasterDAO;
    
    @Autowired
	private DmsDocumentService dmsDocumentService;
	
	@Autowired
	private DmsDocumentDAO dmsDocumentDAO;

	public void setDocumentMasterDAO(DocumentMasterDAO documentMasterDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setDocumentMasterDAO Method is called ");
		}
		this.documentMasterDAO = documentMasterDAO;
	}

	public DmsDocumentCheckListService getDmsDocumentCheckListService() {
		return dmsDocumentCheckListService;
	}

	public void setDmsDocumentCheckListService(DmsDocumentCheckListService dmsDocumentCheckListService) {
		this.dmsDocumentCheckListService = dmsDocumentCheckListService;
	}
	
	public void setDmsDocumentService(DmsDocumentService dmsDocumentService) {
		this.dmsDocumentService = dmsDocumentService;
	}

	public void setDmsDocumentDAO(DmsDocumentDAO dmsDocumentDAO) {
		this.dmsDocumentDAO = dmsDocumentDAO;
	}
	/**
	 * This method is saves the DocumentMaster object
	 * 
	 * @param entity as DocumentMaster object
	 * @return
	 * 
	 */
	public void save(DocumentMaster entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		documentMasterDAO.save(entity);
	}

     /**
	 * This method to merge the DocumentMaster information to the database.
	 * 
	 * @param DocumentMaster object
	 * 
	 */
    public DocumentMaster merge(DocumentMaster entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return documentMasterDAO.merge(entity);
	}

	/**
	 * This method delete the documentMaster
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		documentMasterDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a DocumentMaster Object
	 * 
	 */
	public DocumentMaster get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return documentMasterDAO.get(id);
	}
	
	/**
	 * This method will return a list of all DocumentMaster from the database
	 * 
	 * @return List of DocumentMaster
	 */
	public List<DocumentMaster> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return documentMasterDAO.getAll();
	}
	
	/**
	 * This method returns list of the DocumentMaster objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getDocumentMasterList(long pageNumber,String orderBy, String sortBy){
	
		if (log.isDebugEnabled()) {
			log.debug("getDocumentMasterList Method is called");
		}
		return documentMasterDAO.getDocumentMasterList(pageNumber,orderBy,sortBy);
	}
	
	/**
	 * This method returns list of the DocumentMaster objects available based on Search.
	 * 
	 * @param DocumentMasterSearch searchDocumentMaster
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getDocumentMasterListBySearch(DocumentMasterSearch searchDocumentMaster){
		if(log.isDebugEnabled()){
			log.debug("getDocumentMasterListBySearch Method is called");
		}
		
		return documentMasterDAO.getDocumentMasterListBySearch(searchDocumentMaster);
	}
	
	
	/**
	 * This method returns count of the DocumentMaster objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getDocumentMasterCount(){
	    if (log.isDebugEnabled()) {
			log.debug("getDocumentMasterCount Method is called");
		}
		return documentMasterDAO.getDocumentMasterCount();
	}	

	/**
	 * This method returns count of the DocumentMaster objects available based on search criteria.
	 * @param DocumentMasterSearch searchDocumentmaster
	 * @return long
	 * @exception Exception
	 */
	public long getDocumentMasterCountBySearch(DocumentMasterSearch searchDocumentmaster){
		if(log.isDebugEnabled()){
			log.debug("getDocumentMasterCountBySearch method is called");
		}
		
		return documentMasterDAO.getDocumentMasterCountBySearch(searchDocumentmaster);
	}
		
	
	/**
     * This method save/updates a list of DocumentMaster information to the database.
     * 
     * @param listDocumentMaster as List
     * 
     */
    public void saveAll(List<DocumentMaster> listDocumentMaster){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		documentMasterDAO.saveAll(listDocumentMaster);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDocumentMaster as List
     */
    public void deleteAll(List<DocumentMaster> listDocumentMaster){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		documentMasterDAO.deleteAll(listDocumentMaster);
    }
    
    /**
	 * This method returns list of DocumentMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return documentMasterDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns DocumentMaster object for a given data
	 * 
	 * @param DocumentMaster as documentMaster
	 * @return DocumentMaster as model object
	 */
	public DocumentMaster checkForDuplicates(DocumentMaster documentMaster)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return documentMasterDAO.checkForDuplicates(documentMaster);
		
	}
	
	    /**
	 * This method returns list of DocumentMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return documentMasterDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of DocumentMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<DocumentMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return documentMasterDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes){
		if (log.isDebugEnabled()){
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return documentMasterDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public List<DocumentMaster> getDocumentCheckListByEntity(String entityName, long entityId) {
		
	    // For Document Check list type
		List<DocumentMaster> documentMasterList = findByProperty("stage.description", entityName);
		if(documentMasterList !=null && documentMasterList.size() >0)
		{
			List<DmsDocumentCheckList> dmsDocumentCheckListList=dmsDocumentCheckListService.getDmsDocumentCheckListByEntity(entityName, entityId);
		
			if(dmsDocumentCheckListList !=null && dmsDocumentCheckListList.size() >0){
				for(DocumentMaster documentMaster:documentMasterList){
					for(DmsDocumentCheckList dmsDocumentCheckList:dmsDocumentCheckListList){
						if(documentMaster.getDocumentMasterId()==dmsDocumentCheckList.getDocumentMasterId()){
							documentMaster.setChecked(true);
							documentMaster.setDmsUuid(dmsDocumentCheckList.getDmsUuid());
							documentMaster.setDmsDocumentCheckListId(dmsDocumentCheckList.getDmsDocumentCheckListId());
							documentMaster.setUploadedDate(dmsDocumentCheckList.getUploadedDate());
							documentMaster.setFileName(dmsDocumentCheckList.getFileName());
						}
					}
				}
			}
		} else {
			documentMasterList = new ArrayList<DocumentMaster>();
		}
		
		return documentMasterList;
	}
public List<DocumentMaster> getDocumentsByEntity(String entityName, long entityId) {
		
	    // For Document Check list type
		List<DocumentMaster> documentMasterList = findByProperty("stage.description", entityName);
		if(documentMasterList !=null && documentMasterList.size() >0)
		{
			List<DmsDocumentCheckList> dmsDocumentCheckListList=dmsDocumentCheckListService.getDmsDocumentCheckListByEntity(entityName, entityId);
		
			if(dmsDocumentCheckListList !=null && dmsDocumentCheckListList.size() >0){
				for(DocumentMaster documentMaster:documentMasterList){
					for(DmsDocumentCheckList dmsDocumentCheckList:dmsDocumentCheckListList){
						if(documentMaster.getDocumentMasterId()==dmsDocumentCheckList.getDocumentMasterId()){
							documentMaster.setChecked(true);
							documentMaster.setDmsUuid(dmsDocumentCheckList.getDmsUuid());
							documentMaster.setDmsDocumentCheckListId(dmsDocumentCheckList.getDmsDocumentCheckListId());
							documentMaster.setUploadedDate(dmsDocumentCheckList.getUploadedDate());
							documentMaster.setFileName(dmsDocumentCheckList.getFileName());
						}
					}
				}
			}
		} else {
			documentMasterList = new ArrayList<DocumentMaster>();
		}
		
		return documentMasterList;
	}

	@Override
	public List<DmsDocumentMaster> getDocumentMastersByEntity(String entityName,long entityId) {
		List<DmsDocumentMaster> dmsDocumentMasterslist=new ArrayList<DmsDocumentMaster>();
		try{
			List<DmsDocument> dmsDocumentList=dmsDocumentService.getDocumentsByEntity(entityName, entityId);
			if(dmsDocumentList !=null && dmsDocumentList.size() >0){
				for(DmsDocument dmsDocument:dmsDocumentList){
					DmsDocumentMaster dmsDocumentMaster=new DmsDocumentMaster();
					dmsDocumentMaster.setDmsDocumentId(dmsDocument.getDmsDocumentId());
					dmsDocumentMaster.setDmsDocumentType(dmsDocument.getDmsDocumentType());
					dmsDocumentMaster.setDmsUuid(dmsDocument.getDmsUuid());
					dmsDocumentMaster.setFileName(dmsDocument.getFileName());
					dmsDocumentMaster.setUploadedDate(dmsDocument.getUploadedDate());
					dmsDocumentMaster.setEntityName(dmsDocument.getEntityName());
					dmsDocumentMasterslist.add(dmsDocumentMaster);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dmsDocumentMasterslist;
	}

	@Override
	public void SaveOrUpdateDocumentCheckListByentity(String docDmschecklistId,long entityId) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("DeleteDocumentCheckListByentity Method is called");
		}
		 documentMasterDAO.SaveOrUpdateDocumentCheckListByentity(docDmschecklistId,entityId);
		
	}
	
	public void DeleteDocumentCheckListByentity(String entityName, long entityId) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("DeleteDocumentCheckListByentity Method is called");
		}
		 documentMasterDAO.DeleteDocumentCheckListByentity(entityName,entityId);
		
	}

}

