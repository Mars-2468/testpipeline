package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DeathCertificateDAO;
import com.mars.rti.model.DeathCertificate;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.DeathCertificateService;

@Service("deathCertificateService")
public class DeathCertificateServiceImpl implements DeathCertificateService {
	
	@Autowired
	private DeathCertificateDAO deathCertificateDao;

	@Override
	public void deathRegistrationCertificate(DeathCertificate deathCertificate) {
		
		deathCertificateDao.deathRegistrationSave(deathCertificate);
	}

	@Override
	public List<DeathCertificate> getDeathRegistrationList(RTIApplicationSearch rTIApplicationSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DeathCertificate get(long id) {
		return deathCertificateDao.get(id);
	}

	@Override
	public long deathCertificateSave(DeathCertificate deathCertificate) {
		
		return deathCertificateDao.deathCertificateSave(deathCertificate);
	}
	@Override
	public DeathCertificate getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return deathCertificateDao.getDetails(rtiApplicationId);
	}
	

}
