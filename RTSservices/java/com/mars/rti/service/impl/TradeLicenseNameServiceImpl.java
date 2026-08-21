package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseNameChangeDAO;
import com.mars.rti.model.TradeLicenseNameChange;
import com.mars.rti.service.TradeLicenseNameChangeService;

@Service
public class TradeLicenseNameServiceImpl implements TradeLicenseNameChangeService {
	
	@Autowired
	private TradeLicenseNameChangeDAO tradeLicenseNameChangeDAO;

	@Override
	public void saveTradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange) {
		tradeLicenseNameChangeDAO.saveTradeLicenseNameChange(tradeLicenseNameChange);
		

	}

	@Override
	public long tradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange) {

		return tradeLicenseNameChangeDAO.tradeLicenseNameChangeSave(tradeLicenseNameChange);
	}

	@Override
	public TradeLicenseNameChange get(long rtiApplicationRefId) {

		return tradeLicenseNameChangeDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenseNameChange getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseNameChangeDAO.getDetails(rtiApplicationId);
	}


}
