package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.GaneshMandapPermission;

@Transactional(readOnly = true)
public interface GaneshMandapPermissionService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveGaneshMandapForm(GaneshMandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long ganeshMandapPermission(GaneshMandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public GaneshMandapPermission get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public GaneshMandapPermission merge(
			GaneshMandapPermission gneshMandapPermission);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public GaneshMandapPermission getDetails(long rtiApplicationId);

}
