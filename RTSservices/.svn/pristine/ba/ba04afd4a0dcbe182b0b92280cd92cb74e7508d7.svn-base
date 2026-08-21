package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.RTIApplication;

@Transactional(readOnly = true)
public interface MarriageCertificateService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveMarriageCertificate(MarriageCertificate marriageCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long marriageCertificate(MarriageCertificate marriageCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MarriageCertificate get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MarriageCertificate merge(MarriageCertificate marriageCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MarriageCertificate getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MarriageCertificate saveOrUpdate(MarriageCertificate entity);

	
	
}
