package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DogDetails;
import com.mars.rti.model.DogLicenseCertificate;

@Transactional(readOnly = true)
public interface DogLicenceCertificateService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	   public long saveDogLicenceCertificate(DogLicenseCertificate dogLicenceCertificate );
	
	public DogLicenseCertificate get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DogDetails merge(DogDetails entity);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DogLicenseCertificate getDetails(long rtiApplicationId);
	
	public DogDetails getDogDetails(long rtiApplicationRefId);

	
}


