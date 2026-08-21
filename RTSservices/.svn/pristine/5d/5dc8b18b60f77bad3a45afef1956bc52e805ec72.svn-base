package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenceRenewalDAO;
import com.mars.rti.model.TradeLicenceRenewal;
import com.mars.rti.service.TradeLicenceRenewalService;

@Service
public class TradeLicenceRenewalServiceImpl implements TradeLicenceRenewalService {

	
	@Autowired
	TradeLicenceRenewalDAO tradeLicenceRenewalDAO;
	
	@Override
	public void saveTradeLicence(TradeLicenceRenewal tradeLicenceRenewal) {
		// TODO Auto-generated method stub
		tradeLicenceRenewalDAO.saveTradeLicence(tradeLicenceRenewal);
		
	}

	@Override
	public long getReferenceId(TradeLicenceRenewal tradeLicenceRenewal) {
	return tradeLicenceRenewalDAO.getTradeLicenceId(tradeLicenceRenewal);
		
		
	}

	@Override
	public TradeLicenceRenewal get(long rtiApplicationRefId) {
		
		return tradeLicenceRenewalDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenceRenewal getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenceRenewalDAO.getDetails(rtiApplicationId);
	}


}
