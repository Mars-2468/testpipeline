package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DurgaUtsavMandapPermission;

@Transactional(readOnly = true)
public interface DurgaUtsavService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveDurgaUtsavMandapForm(DurgaUtsavMandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long durgaUtsavMandapPermission(DurgaUtsavMandapPermission mandapPermission);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DurgaUtsavMandapPermission get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DurgaUtsavMandapPermission merge(
			DurgaUtsavMandapPermission durgaUtsavMandapPermission);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DurgaUtsavMandapPermission getDetails(long rtiApplicationId);
}
