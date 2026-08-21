package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NewlyConstructedProperty;

@Transactional(readOnly = true)
public interface NewlyConstructedPropertyService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNewlyConstructedProperty(NewlyConstructedProperty newlyConstructedProperty);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long newlyConstructedProperty(NewlyConstructedProperty newlyConstructedProperty);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewlyConstructedProperty get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewlyConstructedProperty getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewlyConstructedProperty merge(NewlyConstructedProperty newlyConstructedProperty);


}
