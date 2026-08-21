package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MandapPermission;

@Transactional(readOnly = true)
public interface MandapPermissionService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveMandapForm(MandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long mandapPermission(MandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MandapPermission get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MandapPermission getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MandapPermission merge(MandapPermission mandapPermission);

}
