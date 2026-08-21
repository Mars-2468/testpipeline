package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseDuplicateCopyDAO;
import com.mars.rti.model.TradeLicenseDuplicateCopy;
import com.mars.rti.service.TradeLicenseDuplicateCopyService;

@Service
public class TradeLicenseDuplicateServiceImpl implements TradeLicenseDuplicateCopyService {
	
	@Autowired
	private TradeLicenseDuplicateCopyDAO tradeLicenseDuplicateCopyDAO;

	@Override
	public void saveTradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy) {
		tradeLicenseDuplicateCopyDAO.saveTradeLicenseDuplicateCopy(tradeLicenseDuplicateCopy);
		
	}

	@Override
	public long tradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy) {
		
		return tradeLicenseDuplicateCopyDAO.tradeLicenseDuplicateCopySave(tradeLicenseDuplicateCopy);
	}

	@Override
	public TradeLicenseDuplicateCopy get(long rtiApplicationRefId) {
		
		return tradeLicenseDuplicateCopyDAO.get(rtiApplicationRefId);
	}

	@Override
	public TradeLicenseDuplicateCopy getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseDuplicateCopyDAO.getDetails(rtiApplicationId);
	}


}
