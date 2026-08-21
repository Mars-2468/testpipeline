package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.RTIApplication;

@Transactional(readOnly = true)
public interface FireComplianceCertificateService 
{
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savefireComplianceCertificateForm(FireComplianceCertificate fireComplianceCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long fireComplianceCertificate(FireComplianceCertificate fireComplianceCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireComplianceCertificate get(long rtiApplicationRefId);
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<RTIApplication> getnoc(long serviveid);
}
