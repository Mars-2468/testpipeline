package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MarriageCertificateDAO;
import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.MarriageCertificateService;
@Service
public class MarriageCertificateServiceImpl implements MarriageCertificateService {
	
	@Autowired
	private MarriageCertificateDAO marriageCertificateDAO;

	@Override
	public void saveMarriageCertificate(MarriageCertificate marriageCertificate) {
		marriageCertificateDAO.saveMarriageCertificate(marriageCertificate);
	}
	

	@Override
	public long marriageCertificate(MarriageCertificate marriageCertificate) {
		return marriageCertificateDAO.marriageCertificateSave(marriageCertificate);
		
	}

	@Override
	public MarriageCertificate get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return marriageCertificateDAO.get(rtiApplicationRefId);
	}


	@Override
	public MarriageCertificate merge(MarriageCertificate marriageCertificate) {
		// TODO Auto-generated method stub
		return marriageCertificateDAO.merge(marriageCertificate);
	}
	
	@Override
	public MarriageCertificate getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return marriageCertificateDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public MarriageCertificate saveOrUpdate(MarriageCertificate entity) {	
	return marriageCertificateDAO.saveOrUpdate(entity);
	}
}
