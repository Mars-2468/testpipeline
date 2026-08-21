package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.RenewalNursingHomes;
import com.mars.rti.search.RTIApplicationSearch;

public interface RenewalNursingHomesDAO {
	
public RenewalNursingHomes findRenewalNurshingCertificateIdFromRefId(long id);
	
	
	public RenewalNursingHomes get(long rtiApplicationRefId);
	
	
	


	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);


	List<RenewalNursingHomes> getList(RTIApplicationSearch rTIApplicationSearch);


	RenewalNursingHomes findFromRTIRefNum(String rtiapplrefno);


	public void save(RenewalNursingHomes renewalNursingHomes);


	public RenewalNursingHomes saveRenewalNursingHome(
			RenewalNursingHomes renewalNursingHomes);


	public RenewalNursingHomes merge(RenewalNursingHomes renewalNursingHomes);


	public long nursingHomeRenewalApplications(RenewalNursingHomes renewalNursingHomes);
	

}
