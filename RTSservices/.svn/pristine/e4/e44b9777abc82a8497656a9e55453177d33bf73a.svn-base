package com.mars.rti.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DogLicenseDAO;
import com.mars.rti.model.DogLicense;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.DogLicenseService;

@Service("dogLicenseService")
public class DogLicenseServiceImpl implements DogLicenseService {

	private static final Log log= LogFactory.getLog(DogLicenseServiceImpl.class);
	
	@Autowired
	private DogLicenseDAO dogLicenseDAO;
	
	@Override
	public void dogLicenseCertificate(DogLicense dogLicense){
		
		dogLicenseDAO.dogLicenseCertificate(dogLicense);
	}

	@Override
	public List<DogLicense> getDogLicenseList(
			RTIApplicationSearch applicationSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DogLicense get(long dogId) {
		// TODO Auto-generated method stub
		return dogLicenseDAO.get(dogId);
	}

	@Override
	public DogLicense findDogIdFromRefNum(String rtiapplrefno) {
		// TODO Auto-generated method stub
		 return dogLicenseDAO.findDogIdFromRefNum(rtiapplrefno);
	}

	@Override
	public DogLicense dogLicenseSave(DogLicense dogLicense) {
		// TODO Auto-generated method stub
		return dogLicenseDAO.dogLicenseSave(dogLicense);
	}
	
	
	
}
