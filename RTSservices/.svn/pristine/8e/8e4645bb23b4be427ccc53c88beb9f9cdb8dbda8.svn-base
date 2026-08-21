package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.DogLicense;
import com.mars.rti.search.RTIApplicationSearch;



public interface DogLicenseDAO {

	public void dogLicenseCertificate(DogLicense dogLicense);
	public List<DogLicense> getDogLicenseList(RTIApplicationSearch rTIApplicationSearch);
	public long getRTIApplicationCount(RTIApplicationSearch searchOptions);
	public DogLicense get(long id);
	//public  List<DogLicense>findDogIdFromRefNum(String rtiapplrefno);

	public DogLicense findDogIdFromRefNum(String rtiapplrefno);
	
	public DogLicense dogLicenseSave(DogLicense dogLicense);
}
