package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.OccupancyCertificateDAO;
import com.mars.rti.model.OccupancyCertificate;
import com.mars.rti.service.OccupancyCertificateService;

@Service
public class OccupancyCertificateServiceImpl implements OccupancyCertificateService {

	@Autowired
	private OccupancyCertificateDAO occupancyCertificateDAO;

	

	@Override
	public void saveOccupancyForm(OccupancyCertificate occupancyCertificate) {
		occupancyCertificateDAO.saveOccupancyApplication(occupancyCertificate);
		
	}
	
	



	@Override
	public long getReferenceId(OccupancyCertificate occupancyCertificate) {
		
		return occupancyCertificateDAO.getOccupancyApplicationId(occupancyCertificate);
	}



	@Override
	public OccupancyCertificate get(long rtiApplicationRefId) {
		return occupancyCertificateDAO.get(rtiApplicationRefId);
	
	}	
	
	@Override
	public OccupancyCertificate getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return occupancyCertificateDAO.getDetails(rtiApplicationId);
	}

	
	
}
