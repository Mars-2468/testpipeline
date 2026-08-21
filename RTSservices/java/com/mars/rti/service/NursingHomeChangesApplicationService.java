package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NursingHomeChangesApplication;
import com.mars.rti.search.RTIApplicationSearch;

@Transactional(readOnly = true)
public interface NursingHomeChangesApplicationService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNursingHomeChangesApplication(
			NursingHomeChangesApplication nursingHomeChangesApplication);

	public List<NursingHomeChangesApplication> getNursingHomeChangesApplicationList(
			RTIApplicationSearch applicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public NursingHomeChangesApplication getNursingHomeChangesApplication(
			long rtiApplicationRefId);

	public NursingHomeChangesApplication findNursingHomeChangesApplicationFromRefNum(
			String rtiapplrefno);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void nursingHomeChangesApplication(
			NursingHomeChangesApplication nursingHomeChangesApplication);

	public NursingHomeChangesApplication get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long nursingHomeChangesApplications(NursingHomeChangesApplication nursingHomeChangesApplication);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NursingHomeChangesApplication merge(NursingHomeChangesApplication nh);

}
