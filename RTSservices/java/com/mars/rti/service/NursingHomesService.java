package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NursingHomes;
import com.mars.rti.search.RTIApplicationSearch;



@Transactional(readOnly = true)
public interface NursingHomesService {
	
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNursingHome(
			NursingHomes nursingHomes);

	

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public NursingHomes getNursingHomes(
			long rtiApplicationRefId);

	public NursingHomes findNursingHomesFromRefNum(
			String rtiapplrefno);

	public void nursingHomes(
			NursingHomes nursingHomes);

	public NursingHomes get(long rtiApplicationRefId);

	List<NursingHomes> getNursingHomesList(
			RTIApplicationSearch applicationSearch);



	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NursingHomes merge(NursingHomes nursingHomes);


	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long nursingHomeApplications(NursingHomes nursingHomes);
	

}
