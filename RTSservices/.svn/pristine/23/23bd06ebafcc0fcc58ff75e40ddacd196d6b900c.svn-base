package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicencePartnerChangeDAO;
import com.mars.rti.model.TradeLicencePartnerChange;
import com.mars.rti.service.TradeLicencePartnerChangeService;

@Service
public class TradeLicencePartnerChangeServiceImpl implements TradeLicencePartnerChangeService {

	
	@Autowired
	TradeLicencePartnerChangeDAO tradeLicencePartnerChangeDAO;
	
	@Override
	public void saveTradeLicence(TradeLicencePartnerChange tradeLicencePartnerChange) {
		// TODO Auto-generated method stub
		tradeLicencePartnerChangeDAO.saveTradeLicence(tradeLicencePartnerChange);	
	}

	@Override
	public long getReferenceId(TradeLicencePartnerChange tradeLicencePartnerChange) {
	return	tradeLicencePartnerChangeDAO.getTradeLicenceId(tradeLicencePartnerChange);
	}

	@Override
	public TradeLicencePartnerChange get(long rtiApplicationRefId) {
		return tradeLicencePartnerChangeDAO.get(rtiApplicationRefId);
	}
	@Override
	public TradeLicencePartnerChange getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicencePartnerChangeDAO.getDetails(rtiApplicationId);
	}


	
	
	
	
}
