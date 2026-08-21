package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireFeesMain;

public interface FireFeesMainService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireFeesMain getFireMainFees(long fireBuildingType, long fireBuildingHeight);
}
