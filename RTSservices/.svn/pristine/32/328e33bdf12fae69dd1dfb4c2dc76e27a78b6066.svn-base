package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicencePartnerCountUpdateDAO;
import com.mars.rti.model.TradeLicencePartnerCountUpdate;
import com.mars.rti.service.TradeLicencePartnerCountUpdateService;

@Service
public class TradeLicencePartnerCountUpdateServiceImpl implements TradeLicencePartnerCountUpdateService{

	
	@Autowired
	TradeLicencePartnerCountUpdateDAO tradeLicencePartnerCountUpdateDAO;

	@Override
	public void saveTradeLicence(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) {
		tradeLicencePartnerCountUpdateDAO.saveTradeLicence(tradeLicencePartnerCountUpdate);	
		}

	@Override
	public long getReferenceId(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) {
		return	tradeLicencePartnerCountUpdateDAO.getTradeLicenceId(tradeLicencePartnerCountUpdate);
	}

	@Override
	public TradeLicencePartnerCountUpdate get(long rtiApplicationRefId) {
		return tradeLicencePartnerCountUpdateDAO.get(rtiApplicationRefId);
		}
	
	@Override
	public TradeLicencePartnerCountUpdate getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicencePartnerCountUpdateDAO.getDetails(rtiApplicationId);
	}

	
}