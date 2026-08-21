package com.mars.rti.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.LayoutDAO;
import com.mars.rti.model.LayoutOfBuilding;
import com.mars.rti.service.LayoutOfBuildingService;

@Service
public class LayoutOfBuildingServiceImpl implements LayoutOfBuildingService {


	private static final Log log =LogFactory.getLog(LayoutOfBuildingServiceImpl.class);

	@Autowired
	private LayoutDAO layoutDAO;


	@Override
	public void layoutRegistrationCertificateService(LayoutOfBuilding layOutOfBuilding) {
		// TODO Auto-generated method stub
		layoutDAO.layoutRegistrationCerfificate(layOutOfBuilding);

	}


	@Override
	public long layoutOfBuilding(LayoutOfBuilding layOutOfBuilding) {
		// TODO Auto-generated method stub
		return layoutDAO.layoutOfBuildingSave(layOutOfBuilding);
	}

	@Override
	public LayoutOfBuilding get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return layoutDAO.get(rtiApplicationRefId);
	}


}
