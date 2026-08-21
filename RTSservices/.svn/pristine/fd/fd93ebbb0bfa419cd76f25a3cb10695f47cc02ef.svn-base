package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireFloorTypes;

public interface FireFloorTypesService {


	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireFloorTypes> getFireFloorTypes();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireFloorTypes> getList(long id);
}
