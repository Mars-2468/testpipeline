package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BirthCertificateDAO;
import com.mars.rti.model.BirthCertificate;
import com.mars.rti.service.BirthCertificateService;

@Service("birthCertificateService")
public class BirthCertificateServiceImpl implements BirthCertificateService{

	@Autowired
	private BirthCertificateDAO birthCertificateDAO;
	
	@Override
	public void birthRegistrationCertificate(BirthCertificate birthCertificate) {
		birthCertificateDAO.birthRegistrationSave(birthCertificate);
		           
	}

	@Override
	public long birthCertificate(BirthCertificate birthCertificate) {
		return birthCertificateDAO.birthCertificateSave(birthCertificate);
		
	}

	@Override
	public BirthCertificate get(long id) {
		
		return birthCertificateDAO.get(id);
	}
	
	@Override
	public BirthCertificate getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return birthCertificateDAO.getDetails(rtiApplicationId);
	}


}