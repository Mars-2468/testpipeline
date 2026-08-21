package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MobileTower;

@Transactional(readOnly = true)
public interface MobileTowerService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveMobileForm(MobileTower mobileTower);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long mobileTower(MobileTower mobileTower);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MobileTower get(long rtiApplicationRefId);
}
