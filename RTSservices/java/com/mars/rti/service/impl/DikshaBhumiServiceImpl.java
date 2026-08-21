package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DikshaBhumiDAO;
import com.mars.rti.model.DikshaBhumiMandapPermission;
import com.mars.rti.service.DikshaBhumiService;

@Service
public class DikshaBhumiServiceImpl implements DikshaBhumiService{

	@Autowired
	private DikshaBhumiDAO dikshaBhumiDAO;
	
	@Override
	public void saveDikshaBhumiMandapPermission(
			DikshaBhumiMandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		dikshaBhumiDAO.saveDikshaBhumiMandapPermission(mandapPermission);

	}

	@Override
	public long dikshaBhumiMandapPermissionSave(
			DikshaBhumiMandapPermission mandapPermission) {
		return dikshaBhumiDAO.dikshaBhumiMandapPermissionSave(mandapPermission);

	}

	@Override
	public DikshaBhumiMandapPermission get(long id) {
		// TODO Auto-generated method stub
		return dikshaBhumiDAO.get(id);
	}

	@Override
	public DikshaBhumiMandapPermission merge(
			DikshaBhumiMandapPermission durgaUtsavMandapPermission) {
		// TODO Auto-generated method stub
		return dikshaBhumiDAO.merge(durgaUtsavMandapPermission);
	}

	@Override
	public DikshaBhumiMandapPermission getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return dikshaBhumiDAO.getDetails(rtiApplicationId);
	}

}
