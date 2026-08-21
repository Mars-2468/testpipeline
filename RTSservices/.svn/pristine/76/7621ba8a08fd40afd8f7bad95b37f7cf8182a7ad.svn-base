package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DikshaBhumiMandapPermission;

@Transactional(readOnly = true)
public interface DikshaBhumiService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveDikshaBhumiMandapPermission(DikshaBhumiMandapPermission mandapPermission) ;
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long dikshaBhumiMandapPermissionSave(DikshaBhumiMandapPermission mandapPermission);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DikshaBhumiMandapPermission get(long id);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DikshaBhumiMandapPermission merge(
			DikshaBhumiMandapPermission gneshMandapPermission);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DikshaBhumiMandapPermission getDetails(long rtiApplicationId);
	
}
