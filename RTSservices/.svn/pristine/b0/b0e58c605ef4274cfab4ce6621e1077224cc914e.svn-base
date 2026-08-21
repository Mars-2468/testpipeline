package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DeathCertificate;
import com.mars.rti.search.RTIApplicationSearch;

@Transactional(readOnly = true)
public interface DeathCertificateService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void deathRegistrationCertificate(DeathCertificate deathCertificate);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long deathCertificateSave(DeathCertificate deathCertificate);
	
	public List<DeathCertificate> getDeathRegistrationList(RTIApplicationSearch rTIApplicationSearch);
	
    public long getRTIApplicationCount(RTIApplicationSearch searchOptions);
    public DeathCertificate get(long id);
    
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public DeathCertificate getDetails(long rtiApplicationId);
	

}
