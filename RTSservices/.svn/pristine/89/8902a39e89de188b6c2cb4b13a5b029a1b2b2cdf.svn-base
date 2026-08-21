package com.mars.common.service.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DeliveryModeDAO;
import com.mars.common.model.DeliveryMode;
import com.mars.common.service.DeliveryModeService;
 /**

 * <p>Title: NodeMasterServiceImpl.java </p>

 * @see com.mars.common.model.NodeMaster
 
 * <p>Description: This class is used for hibernate operations for NodeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("deliveryModeService") 
public class DeliveryModeServiceImpl implements DeliveryModeService{

    private static final Log log = LogFactory.getLog(DeliveryModeServiceImpl.class);

  	
	@Autowired
	private DeliveryModeDAO DeliveryModeDAO;


	@Override
	public DeliveryMode get(long id) {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.get(id);
	}


	@Override
	public void save(DeliveryMode entity) {
		// TODO Auto-generated method stub
		DeliveryModeDAO.save(entity);
	}


	@Override
	public DeliveryMode merge(DeliveryMode entity) {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.merge(entity);
	}


	@Override
	public List<DeliveryMode> getAll() {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.getAll();
	}


	@Override
	public long getDeliveryModeCount() {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.getDeliveryModeCount();
	}


	@Override
	public List<DeliveryMode> findByProperty(String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.findByProperty(propertyName, value);
	}


	@Override
	public DeliveryMode checkForDuplicates(DeliveryMode DeliveryMode) {
		// TODO Auto-generated method stub
		return DeliveryModeDAO.checkForDuplicates(DeliveryMode);
	}

 
	
}

