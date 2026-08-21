package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.BirthCertificate;

@Transactional(readOnly = true)
public interface BirthCertificateService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void birthRegistrationCertificate(BirthCertificate birthCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long birthCertificate(BirthCertificate birthCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
   public BirthCertificate  get(long id);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public BirthCertificate getDetails(long rtiApplicationId);
   
}
