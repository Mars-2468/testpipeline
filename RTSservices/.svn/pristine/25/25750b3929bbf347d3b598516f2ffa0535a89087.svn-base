package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseCancellationDAO;
import com.mars.rti.model.TradeLicenseCancellation;
import com.mars.rti.service.TradeLicenseCancellationService;


@Service
public class TradeLicenseCancellationServiceImpl implements TradeLicenseCancellationService {
	
	@Autowired
	private TradeLicenseCancellationDAO tradeLicenseCancellationDAO;

	@Override
	public void saveTradeLicenseCancel(TradeLicenseCancellation tradeLicenseCancellation) {
		tradeLicenseCancellationDAO.saveTradeLicenseCancel(tradeLicenseCancellation);

	}

	@Override
	public long tradeLicenseCancellation(TradeLicenseCancellation tradeLicenseCancellation) {
		return tradeLicenseCancellationDAO.tradeLicenseCancelSave(tradeLicenseCancellation);

	}

	@Override
	public TradeLicenseCancellation get(long rtiApplicationRefId) {
		return tradeLicenseCancellationDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenseCancellation getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseCancellationDAO.getDetails(rtiApplicationId);
	}



}
