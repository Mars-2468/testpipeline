package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseTypeChangeDAO;
import com.mars.rti.model.TradeLicenseTypeChange;
import com.mars.rti.service.TradeLicenseTypeChangeService;

@Service
public class TradeLicenseTypeChangeServiceImpl implements TradeLicenseTypeChangeService{
	
	
	@Autowired
	private TradeLicenseTypeChangeDAO tradeLicenseTypeChangeDAO;
	

	@Override
	public void saveTradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange) {
		tradeLicenseTypeChangeDAO.saveTradeLicenseTypeChange(tradeLicenseTypeChange);

	}

	@Override
	public long tradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange) {

		return tradeLicenseTypeChangeDAO.tradeLicenseTypeChangeSave(tradeLicenseTypeChange);
	}

	@Override
	public TradeLicenseTypeChange get(long rtiApplicationRefId) {

		return tradeLicenseTypeChangeDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenseTypeChange getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseTypeChangeDAO.getDetails(rtiApplicationId);
	}

}
