package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenceNewDAO;
import com.mars.rti.model.TradeLicenceNew;
import com.mars.rti.service.TradeLicenceNewService;

@Service
public class TradeLicenceNewServiceImpl implements TradeLicenceNewService {

	@Autowired
	TradeLicenceNewDAO tradeLicenceNewDAO;
	
	@Override
	public void saveTradeLicenceNew(TradeLicenceNew tradeLicenceNew) {
		// TODO Auto-generated method stub
		tradeLicenceNewDAO.saveTradeLicenceNew(tradeLicenceNew);
	}

	@Override
	public long getReferenceId(TradeLicenceNew tradeLicenceNew) {
		// TODO Auto-generated method stub
		return tradeLicenceNewDAO.getTradeLicenceId(tradeLicenceNew);
	}

	@Override
	public TradeLicenceNew get(long rtiApplicationRefId) {
		return tradeLicenceNewDAO.get(rtiApplicationRefId);
		
	}
	
	@Override
	public TradeLicenceNew getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenceNewDAO.getDetails(rtiApplicationId);
	}


}
