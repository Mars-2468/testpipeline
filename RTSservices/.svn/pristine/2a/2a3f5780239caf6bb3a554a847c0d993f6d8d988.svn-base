package com.mars.rti.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DeathRegistrationDAO;
import com.mars.rti.model.DeathRegistration;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.DeathRegistrationService;


@Service("deathRegistrationService")
public class DeathRegistrationServiceImpl implements DeathRegistrationService {
	
	private static final Log log = (Log) LogFactory.getLog(DeathRegistrationServiceImpl.class);
	
	@Autowired
	private DeathRegistrationDAO deathRegistrationDAO;
	
	

	/* 
	 * @see com.mars.rti.service.DeathRegistrationService#deathRegistrationCertificate(com.mars.rti.model.BirthRegistration)
	 */
	@Override
	public void deathRegistrationCertificate(DeathRegistration deathRegistration) {
		// TODO Auto-generated method stub
		
		deathRegistrationDAO.deathRegistrationCertificate(deathRegistration); 
		
	}
	
	@Override
	public DeathRegistration deathRegistrationSave(DeathRegistration deathRegistration) {
		// TODO Auto-generated method stub
		
		return deathRegistrationDAO.deathRegistrationSave(deathRegistration); 
		
	}
	
	@Override
	public List<DeathRegistration> getDeathRegistrationList(RTIApplicationSearch rTIApplicationSearch){
		
		return deathRegistrationDAO.getDeathRegistrationList(rTIApplicationSearch);
	}
	
	@Override
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationCount Method is called");
		}
		return deathRegistrationDAO.getRTIApplicationCount(searchOptions);
	}
	
   public DeathRegistration  get(long id){
		
		return deathRegistrationDAO.get(id);
	}

}
