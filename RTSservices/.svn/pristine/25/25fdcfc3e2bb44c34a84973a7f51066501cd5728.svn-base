package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.AnaesthetistDetails;
import com.mars.rti.model.MTPAssistantDetails;
import com.mars.rti.model.MTPBloodBankDetails;
import com.mars.rti.model.MTPDetails;
import com.mars.rti.model.MTPNurseDetails;
import com.mars.rti.model.MTPRegistrationCertificate;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.search.RTIApplicationSearch;

@Transactional(readOnly = true)
public interface MTPRegistrationCertificateService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long mTPRegistrationCertificate(
			MTPRegistrationCertificate mTPRegistrationCertificate);

	public List<MTPRegistrationCertificate> getMTPRegistrationCertificateList(
			RTIApplicationSearch applicationSearch);

	// public long getDogLicenseCount(RTIApplicationSearch applicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public MTPRegistrationCertificate get(long rtiApplicationRefId);

	public MTPRegistrationCertificate findMTPRegistrationCertificateIdFromRefNum(
			String rtiapplrefno);

	///public void /(MTPRegistrationCertificate oldMTPRegistrationCertificate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long MTPCertificate(MTPRegistrationCertificate mTPRegistrationCertificate);
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveMTP (MTPRegistrationCertificate mTPRegistrationCertificate);
	

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MTPRegistrationCertificate merge(MTPRegistrationCertificate mTPRegistrationCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MTPDetails mergeMTPDetailsList(MTPDetails tt);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MTPAssistantDetails mergeMTPAssistantDetailsList(MTPAssistantDetails matt);
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MTPNurseDetails mergeMTPNurseDetails(MTPNurseDetails ttN);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MTPBloodBankDetails mergeMTPBloodBankDetails(MTPBloodBankDetails ttb);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public AnaesthetistDetails mergeMTPAnaesthetistDetails(AnaesthetistDetails ttA);
	
	
}
