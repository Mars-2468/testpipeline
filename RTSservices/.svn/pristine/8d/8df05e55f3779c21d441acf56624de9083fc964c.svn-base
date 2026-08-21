package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireFloorName;

public interface FireFloorNameService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireFloorName> getFireFloorName();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireFloorName> getList(long id);
}
