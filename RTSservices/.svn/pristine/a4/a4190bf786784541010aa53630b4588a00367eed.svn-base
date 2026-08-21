package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.BirthRegistration;
import com.mars.rti.search.RTIApplicationSearch;


@Transactional(readOnly = true)
public interface BirthRegistrationService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void birthRegistrationCertificate(BirthRegistration birthRegistration);
	
	public List<BirthRegistration> getBirthRegistrationList(RTIApplicationSearch rTIApplicationSearch);
	
    public long getRTIApplicationCount(RTIApplicationSearch searchOptions);
    public BirthRegistration get(long id);
    
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long birthRegistrationSave(BirthRegistration birthRegistration);
}
