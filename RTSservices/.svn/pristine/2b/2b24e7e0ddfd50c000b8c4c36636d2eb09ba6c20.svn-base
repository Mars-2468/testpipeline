package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.ChangeInOwnershipType;


@Transactional(readOnly = true)
public interface ChangeInOwnershipTypeService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveChangeInOwnershipType(ChangeInOwnershipType changeInOwnershipType);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long changeInOwnershipType(ChangeInOwnershipType changeInOwnershipType);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ChangeInOwnershipType get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<ChangeInOwnershipType> getAllChangeInOwnershipType();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ChangeInOwnershipType getDetails(long rtiApplicationId);
	

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ChangeInOwnershipType merge(ChangeInOwnershipType changeInOwnershipType);
	
}
