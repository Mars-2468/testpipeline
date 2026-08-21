package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PartMap;

@Transactional(readOnly = true)
public interface PartMapService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePartMapForm(PartMap partmap);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long partMap(PartMap partmap);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PartMap get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PartMap getDetails(long rtiApplicationId);
	

}
