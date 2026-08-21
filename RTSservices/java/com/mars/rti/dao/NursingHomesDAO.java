package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.NursingHomes;
import com.mars.rti.search.RTIApplicationSearch;




public interface NursingHomesDAO {
	
	public NursingHomes findNurshingCertificateIdFromRefId(long id);
	
	
	public NursingHomes get(long rtiApplicationRefId);
	
	
	public NursingHomes saveNursingHome(NursingHomes nursingHomes);


	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);


	List<NursingHomes> getList(RTIApplicationSearch rTIApplicationSearch);


	NursingHomes findFromRTIRefNum(String rtiapplrefno);


	public void save(NursingHomes nursingHomes);
	
	public NursingHomes merge(NursingHomes nursingHomes);


	public long nursingHomeApplications(NursingHomes nursingHomes);
	
}
