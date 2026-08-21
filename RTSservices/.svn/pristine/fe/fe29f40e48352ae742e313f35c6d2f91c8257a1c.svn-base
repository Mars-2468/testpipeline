package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MandapPermissionDAO;
import com.mars.rti.model.MandapPermission;
import com.mars.rti.service.MandapPermissionService;

@Service
public class MandapPermissionServiceImpl implements MandapPermissionService {

	@Autowired
	private MandapPermissionDAO mandapPermissionDAO;

	@Override
	public void saveMandapForm(MandapPermission mandapPermission) {
		mandapPermissionDAO.saveMandapPermission(mandapPermission);

	}

	@Override
	public long mandapPermission(MandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		return mandapPermissionDAO.mandapPermissionSave(mandapPermission);
	}

	@Override
	public MandapPermission get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return mandapPermissionDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public MandapPermission getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return mandapPermissionDAO.getDetails(rtiApplicationId);
	}
	@Override
	public MandapPermission merge(MandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		return mandapPermissionDAO.merge(mandapPermission);
	}


}
