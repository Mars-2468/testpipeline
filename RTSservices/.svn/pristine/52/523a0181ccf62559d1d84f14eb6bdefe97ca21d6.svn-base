package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ZoneCertificatesDAO;
import com.mars.rti.model.ZoneCertificates;
import com.mars.rti.service.ZoneCertificatesService;

@Service
public class ZoneCertificatesServiceImpl implements ZoneCertificatesService {

	@Autowired
	private ZoneCertificatesDAO zoneCertificatesDAO;

	@Override
	public void saveZoneForm(ZoneCertificates zoneCertificates) {
		zoneCertificatesDAO.saveZoneApplication(zoneCertificates);
		
	}

	@Override
	public long getReferenceId(ZoneCertificates zoneCertificates) {
		
		return zoneCertificatesDAO.getZoneApplicationId(zoneCertificates);
	}

	@Override
public ZoneCertificates get(long rtiApplicationRefId) {
		
		return zoneCertificatesDAO.get(rtiApplicationRefId);
	}
	

	@Override
	public ZoneCertificates getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return zoneCertificatesDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public ZoneCertificates merge(ZoneCertificates zoneCertificates) {
		// TODO Auto-generated method stub
		return zoneCertificatesDAO.merge(zoneCertificates);
	}

	

}
