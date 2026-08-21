package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.ZoneCertificates;


@Transactional(readOnly = true)
public interface ZoneCertificatesService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveZoneForm(ZoneCertificates zoneCertificates);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(ZoneCertificates zoneCertificates);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ZoneCertificates get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ZoneCertificates getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ZoneCertificates merge(ZoneCertificates zoneCertificates);
}
