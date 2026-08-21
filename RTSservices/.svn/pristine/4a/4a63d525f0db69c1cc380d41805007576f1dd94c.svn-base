package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireCrackersShopLicenseDAO;
import com.mars.rti.model.FireCrackersShopLicense;
import com.mars.rti.service.FireCrackersShopLicenseService;

@Service
public class FireCrackersShopLicenseServiceImpl implements FireCrackersShopLicenseService{
	
	@Autowired
	private FireCrackersShopLicenseDAO fireCrackersShopLicenseDAO;
	
	@Override
	public void saveFireCrackersShopLicense(FireCrackersShopLicense fireCrackersShopLicense) {
		fireCrackersShopLicenseDAO.saveFireCrackersShopLicense(fireCrackersShopLicense);

	}

	@Override
	public long fireCrackersShopLicenseSave(FireCrackersShopLicense fireCrackersShopLicense) {
		return fireCrackersShopLicenseDAO.fireCrackersShopLicenseSave(fireCrackersShopLicense);

	}

	@Override
	public FireCrackersShopLicense get(long id) {
		return fireCrackersShopLicenseDAO.get(id);
	}

	@Override
	public FireCrackersShopLicense merge(FireCrackersShopLicense fireCrackersShopLicense) {
		return fireCrackersShopLicenseDAO.merge(fireCrackersShopLicense);
	}

	@Override
	public FireCrackersShopLicense getDetails(long rtiApplicationId) {
		return fireCrackersShopLicenseDAO.getDetails(rtiApplicationId);
	}


}
