package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseOutdatedRenewalDAO;
import com.mars.rti.model.TradeLicenseOutdatedRenewalNotice;
import com.mars.rti.service.TradeLicenseOutdatedRenewalService;

@Service
public class TradeLicenseOutdatedRenewalServiceImpl  implements  TradeLicenseOutdatedRenewalService{
	
	@Autowired
	private TradeLicenseOutdatedRenewalDAO tradeLicenseOutdatedRenewalDAO;

	@Override
	public void saveTradeLicenseOutdatedRenewal(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice) {
		tradeLicenseOutdatedRenewalDAO.saveTradeLicenseOutdatedRenewal(tradeLicenseOutdatedRenewalNotice);

	}

	@Override
	public long tradeLicenseOutdatedRenewal(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice) {

		return tradeLicenseOutdatedRenewalDAO.tradeLicenseOutdatedRenewalSave(tradeLicenseOutdatedRenewalNotice);
	}

	@Override
	public TradeLicenseOutdatedRenewalNotice get(long rtiApplicationRefId) {

		return tradeLicenseOutdatedRenewalDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenseOutdatedRenewalNotice getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseOutdatedRenewalDAO.getDetails(rtiApplicationId);
	}


}
