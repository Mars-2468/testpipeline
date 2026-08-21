package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DurgaUtsavDAO;
import com.mars.rti.model.DurgaUtsavMandapPermission;
import com.mars.rti.service.DurgaUtsavService;

@Service
public class DurgaUtsavServiceImpl implements DurgaUtsavService{

	@Autowired
	private DurgaUtsavDAO durgaUtsavDAO;
	
	
	@Override
	public void saveDurgaUtsavMandapForm(
			DurgaUtsavMandapPermission mandapPermission) {
		durgaUtsavDAO.saveDurgaUtsavMandapPermission(mandapPermission);
	}

	@Override
	public long durgaUtsavMandapPermission(
			DurgaUtsavMandapPermission mandapPermission) {
		return durgaUtsavDAO.ganeshMandapPermissionSave(mandapPermission);
	}

	@Override
	public DurgaUtsavMandapPermission get(long rtiApplicationRefId) {
		return durgaUtsavDAO.get(rtiApplicationRefId);
	}

	@Override
	public DurgaUtsavMandapPermission merge(
			DurgaUtsavMandapPermission durgaUtsavMandapPermission) {
		return durgaUtsavDAO.merge(durgaUtsavMandapPermission);
	}

	@Override
	public DurgaUtsavMandapPermission getDetails(long rtiApplicationId) {
		return durgaUtsavDAO.getDetails(rtiApplicationId);
	}

	
}
