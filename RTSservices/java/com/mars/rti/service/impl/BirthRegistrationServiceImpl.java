/**
 * 
 */
package com.mars.rti.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BirthRegistrationDAO;
import com.mars.rti.model.BirthRegistration;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.BirthRegistrationService;
/**
 * <p>
 * Title: RTIApplicationServiceImpl.java
 * </p>
 * 
 * @see net.zooin.lms.model.RTIApplication
 *      <p>
 *      Description: This class is used for hibernate operations for RTIApplication module
 *      </p>
 *      Copyright (c) 2014 Mars Telecom India Pvt Ltd
 * @version: 1.0
 * @author : LMS development team <Mars Telecom Systems Pvt Ltd>
 */
@Service("birthRegistrationService")
public class BirthRegistrationServiceImpl implements BirthRegistrationService {
	
	private static final Log log = LogFactory.getLog(BirthRegistrationServiceImpl.class);
	
	@Autowired
	private BirthRegistrationDAO birthRegistrationDAO;
	
	

	/* (non-Javadoc)
	 * @see com.mars.rti.service.BirthRegistrationService#birthRegistrationCertificate(com.mars.rti.model.BirthRegistration)
	 */
	@Override
	public void birthRegistrationCertificate(BirthRegistration birthRegistration) {
		// TODO Auto-generated method stub
		
		birthRegistrationDAO.birthRegistrationCertificate(birthRegistration); 
		
	}
	
	@Override
	public List<BirthRegistration> getBirthRegistrationList(RTIApplicationSearch rTIApplicationSearch){
		
		return birthRegistrationDAO.getBirthRegistrationList(rTIApplicationSearch);
	}
	
	@Override
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationCount Method is called");
		}
		return birthRegistrationDAO.getRTIApplicationCount(searchOptions);
	}
	
	public BirthRegistration get(long id){
		
		return birthRegistrationDAO.get(id);
	}
	
	
	@Override
	public long birthRegistrationSave(BirthRegistration birthRegistration) {
		// TODO Auto-generated method stub
		
		return birthRegistrationDAO.birthRegistrationSave(birthRegistration); 
		
	}
	

}
