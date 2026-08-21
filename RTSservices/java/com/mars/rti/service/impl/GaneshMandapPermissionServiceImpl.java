package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.GaneshMandapPermissionDAO;
import com.mars.rti.model.GaneshMandapPermission;
import com.mars.rti.service.GaneshMandapPermissionService;

@Service
public class GaneshMandapPermissionServiceImpl implements GaneshMandapPermissionService {

	@Autowired
	private GaneshMandapPermissionDAO ganeshMandapPermissionService;
	
	@Override
	public void saveGaneshMandapForm(GaneshMandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		ganeshMandapPermissionService.saveGaneshMandapPermission(mandapPermission);
	}

	@Override
	public long ganeshMandapPermission(
			GaneshMandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		return ganeshMandapPermissionService.ganeshMandapPermissionSave(mandapPermission);
	}

	@Override
	public GaneshMandapPermission get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return ganeshMandapPermissionService.get(rtiApplicationRefId);
	}

	@Override
	public GaneshMandapPermission merge(
			GaneshMandapPermission gneshMandapPermission) {
		// TODO Auto-generated method stub
		return ganeshMandapPermissionService.merge(gneshMandapPermission);
	}

	@Override
	public GaneshMandapPermission getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return ganeshMandapPermissionService.getDetails(rtiApplicationId);
	}

}
