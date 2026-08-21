package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DeathRegistration;
import com.mars.rti.search.RTIApplicationSearch;


@Transactional(readOnly = true)
public interface DeathRegistrationService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void deathRegistrationCertificate(DeathRegistration deathRegistration);
	
	public List<DeathRegistration> getDeathRegistrationList(RTIApplicationSearch rTIApplicationSearch);
	
    public long getRTIApplicationCount(RTIApplicationSearch searchOptions);
    public DeathRegistration get(long id);

    DeathRegistration deathRegistrationSave(
			DeathRegistration deathRegistration);
	
}
