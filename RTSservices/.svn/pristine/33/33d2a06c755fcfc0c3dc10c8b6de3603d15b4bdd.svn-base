package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NursingHomeChangesApplicationDAO;
import com.mars.rti.model.NursingHomeChangesApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.NursingHomeChangesApplicationService;

@Service("NursingHomeChangesApplicationService")
public class NursingHomeChangesApplicationServiceImpl implements
		NursingHomeChangesApplicationService {

	@Autowired
	private NursingHomeChangesApplicationDAO nursingHomeChangesApplicationDAO;

	@Override
	public void saveNursingHomeChangesApplication(
			NursingHomeChangesApplication nursingHomeChangesApplication) {
		nursingHomeChangesApplicationDAO.save(nursingHomeChangesApplication);
	}

	@Override
	public List<NursingHomeChangesApplication> getNursingHomeChangesApplicationList(
			RTIApplicationSearch applicationSearch) {
		return nursingHomeChangesApplicationDAO.getList(applicationSearch);
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		return nursingHomeChangesApplicationDAO
				.getRTIApplicationCount(applicationSearch);
	}

	@Override
	public NursingHomeChangesApplication getNursingHomeChangesApplication(
			long rtiApplicationRefId) {
		return nursingHomeChangesApplicationDAO.get(rtiApplicationRefId);
	}

	@Override
	public NursingHomeChangesApplication findNursingHomeChangesApplicationFromRefNum(
			String rtiapplrefno) {
		return nursingHomeChangesApplicationDAO.findFromRTIRefNum(rtiapplrefno);
	}


	@Override
	public NursingHomeChangesApplication get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return nursingHomeChangesApplicationDAO.get(rtiApplicationRefId);
	}

	@Override
	public long nursingHomeChangesApplications(NursingHomeChangesApplication nursingHomeChangesApplication) {
		// TODO Auto-generated method stub
		return nursingHomeChangesApplicationDAO.nursingHomeChangesApplications(nursingHomeChangesApplication);
	}

	@Override
	public void nursingHomeChangesApplication(NursingHomeChangesApplication nursingHomeChangesApplication) {
		 nursingHomeChangesApplicationDAO.nursingHomeChangesApplication(nursingHomeChangesApplication);

	}

	@Override
	public NursingHomeChangesApplication merge(NursingHomeChangesApplication nh) {
		// TODO Auto-generated method stub
		return nursingHomeChangesApplicationDAO.merge(nh);
	}
}
