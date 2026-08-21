package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NursingHomesDAO;
import com.mars.rti.model.NursingHomes;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.NursingHomesService;

@Service("nursingHomesService")
public class NursingHomesServiceImpl implements NursingHomesService{
	
	
	@Autowired
	private NursingHomesDAO nursingHomesDAO;
	
	



	
	
	
	@Override
	public void saveNursingHome(
			NursingHomes nursingHomes) {
		nursingHomesDAO.save(nursingHomes);
	}

	@Override
	public List<NursingHomes> getNursingHomesList(
			RTIApplicationSearch applicationSearch) {
		return nursingHomesDAO.getList(applicationSearch);
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		return nursingHomesDAO
				.getRTIApplicationCount(applicationSearch);
	}

	@Override
	public NursingHomes getNursingHomes(
			long rtiApplicationRefId) {
		return nursingHomesDAO.get(rtiApplicationRefId);
	}

	@Override
	public NursingHomes findNursingHomesFromRefNum(
			String rtiapplrefno) {
		return nursingHomesDAO.findFromRTIRefNum(rtiapplrefno);
	}

	@Override
	public void nursingHomes(
			NursingHomes nursingHomes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NursingHomes get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return nursingHomesDAO.get(rtiApplicationRefId);
	}
	
	@Override
public NursingHomes merge(NursingHomes nursingHomes) {
	// TODO Auto-generated method stub
	return nursingHomesDAO.merge(nursingHomes);
}

	@Override
	public long nursingHomeApplications(NursingHomes nursingHomes) {
		// TODO Auto-generated method stub
		return nursingHomesDAO.nursingHomeApplications(nursingHomes);
	}

}
