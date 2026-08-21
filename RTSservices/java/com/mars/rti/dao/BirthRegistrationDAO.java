package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.BirthRegistration;
import com.mars.rti.search.RTIApplicationSearch;

public interface BirthRegistrationDAO {
	
	public void birthRegistrationCertificate(BirthRegistration birthRegistration);
	public List<BirthRegistration> getBirthRegistrationList(RTIApplicationSearch rTIApplicationSearch);
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions);
	public BirthRegistration get(long id);
	public long birthRegistrationSave(BirthRegistration birthRegistration);

}
