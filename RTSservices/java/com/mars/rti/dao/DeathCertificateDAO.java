package com.mars.rti.dao;

import com.mars.rti.model.DeathCertificate;

public interface DeathCertificateDAO {
	
public void deathRegistrationSave(DeathCertificate deathCertificate);
	
	public long deathCertificateSave(DeathCertificate deathCertificate);
	
	public DeathCertificate get(long id) ;
	
	public DeathCertificate getDetails(long rtiApplicationId);


}
