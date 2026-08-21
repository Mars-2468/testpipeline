
package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.RenewalNursingHomesDAO;
import com.mars.rti.model.RenewalNursingHomes;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RenewalNursingHomesService;

@Service("renewalNursingHomesService")
public class RenewalNursingHomesServiceImpl implements RenewalNursingHomesService{
	
	
	@Autowired
	private RenewalNursingHomesDAO renewalNursingHomesDAO;
	

	@Override
	public void saveRenewalNursingHome(RenewalNursingHomes renewalNursingHomes) {
		renewalNursingHomesDAO.save(renewalNursingHomes);
	}

	@Override
	public List<RenewalNursingHomes> getRenewalNursingHomesList(
			RTIApplicationSearch applicationSearch) {
		return renewalNursingHomesDAO.getList(applicationSearch);
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		return renewalNursingHomesDAO
				.getRTIApplicationCount(applicationSearch);
	}

	@Override
	public RenewalNursingHomes getRenewalNursingHomes(
			long rtiApplicationRefId) {
		return renewalNursingHomesDAO.get(rtiApplicationRefId);
	}

	@Override
	public RenewalNursingHomes findRenewalNursingHomesFromRefNum(
			String rtiapplrefno) {
		return renewalNursingHomesDAO.findFromRTIRefNum(rtiapplrefno);
	}

	@Override
	public void renewalNursingHomes(
			RenewalNursingHomes renewalNursingHomes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RenewalNursingHomes get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return renewalNursingHomesDAO.get(rtiApplicationRefId);
	}

	
	@Override
public RenewalNursingHomes merge(RenewalNursingHomes renewalNursingHomes) {
	// TODO Auto-generated method stub
	return renewalNursingHomesDAO.merge(renewalNursingHomes);
}

	@Override
	public long nursingHomeRenewalApplications(RenewalNursingHomes renewalNursingHomes) {
		// TODO Auto-generated method stub
		return renewalNursingHomesDAO.nursingHomeRenewalApplications(renewalNursingHomes);
	}

}




