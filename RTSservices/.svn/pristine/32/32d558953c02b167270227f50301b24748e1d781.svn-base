package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DogLicense;
import com.mars.rti.search.RTIApplicationSearch;

@Transactional(readOnly = true)
public interface DogLicenseService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void dogLicenseCertificate(DogLicense dogLicense);

	public List<DogLicense> getDogLicenseList(
			RTIApplicationSearch applicationSearch);

	//public long getDogLicenseCount(RTIApplicationSearch applicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public DogLicense get(long rtiApplicationRefId);

	public DogLicense findDogIdFromRefNum(String rtiapplrefno);
	
	public DogLicense dogLicenseSave(DogLicense dogLicense);
	
	
}
