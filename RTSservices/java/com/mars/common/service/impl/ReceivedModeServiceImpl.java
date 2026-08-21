package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.ReceivedModeDAO;
import com.mars.common.model.ReceivedMode;
import com.mars.common.search.ReceivedModeSearch;
import com.mars.common.service.ReceivedModeService; 
 /**

 * <p>Title: NodeMasterServiceImpl.java </p>

 * @see com.mars.common.model.NodeMaster
 
 * <p>Description: This class is used for hibernate operations for NodeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("receivedModeService") 
public class ReceivedModeServiceImpl implements ReceivedModeService{

    private static final Log log = LogFactory.getLog(ReceivedModeServiceImpl.class);

  	
	@Autowired
	private ReceivedModeDAO fileReceivedModeDAO;


	@Override
	public ReceivedMode  get(long id) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.get(id);
	}


	@Override
	public void save(ReceivedMode  entity) {
		// TODO Auto-generated method stub
		fileReceivedModeDAO.save(entity);
	}


	@Override
	public ReceivedMode  merge(ReceivedMode  entity) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.merge(entity);
	}


	@Override
	public void delete(long id) {
		fileReceivedModeDAO.delete(0);
		
	}


	@Override
	public List<ReceivedMode > getAll() {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.getAll();
	}


	@Override
	public void saveAll(List<ReceivedMode > listNode) {
		fileReceivedModeDAO.saveAll(listNode);
		
	}


	@Override
	public void deleteAll(List<ReceivedMode > listNode) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ReceivedMode> getReceivedModeCountList(long pageNumber, String orderBy, String sortBy) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.getReceivedModeCountList(pageNumber, orderBy, sortBy);
	}


	@Override
	public List<ReceivedMode > getReceivedModeListBySearch(ReceivedModeSearch receivedModeSearch) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.getReceivedModeListBySearch(receivedModeSearch);
	}


	@Override
	public long getReceivedModeCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public long getReceivedModeCountBySearch(ReceivedModeSearch fileReceivedModeSearch) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.getReceivedModeCountBySearch(fileReceivedModeSearch);
	}


	@Override
	public List<ReceivedMode > findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ReceivedMode  checkForDuplicates(ReceivedMode  node) {
		// TODO Auto-generated method stub
		return fileReceivedModeDAO.checkForDuplicates(node);
	}


	@Override
	public List<ReceivedMode > getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ReceivedMode > getEntityListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ArrayList> getListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

