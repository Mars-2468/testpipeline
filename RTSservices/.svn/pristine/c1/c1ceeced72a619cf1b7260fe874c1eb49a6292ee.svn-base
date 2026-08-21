package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.OccupancyCertificate;


@Transactional(readOnly = true)
public interface OccupancyCertificateService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveOccupancyForm(OccupancyCertificate occupancyCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(OccupancyCertificate occupancyCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public OccupancyCertificate get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public OccupancyCertificate getDetails(long rtiApplicationId);
	
}
