package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PartitionOfProperty;

@Transactional(readOnly = true)
public interface PartitionOfPropertyService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePartitionOfPropertyForm(PartitionOfProperty partitionOfProperty);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long partitionOfProperty(PartitionOfProperty partitionOfProperty);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PartitionOfProperty get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PartitionOfProperty getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PartitionOfProperty merge(PartitionOfProperty partitionOfProperty);


}