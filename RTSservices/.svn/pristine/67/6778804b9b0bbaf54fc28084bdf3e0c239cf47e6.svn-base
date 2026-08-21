package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.RenewalNursingHomes;
import com.mars.rti.search.RTIApplicationSearch;


@Transactional(readOnly = true)
public interface RenewalNursingHomesService {
	

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveRenewalNursingHome(
			RenewalNursingHomes renewalNursingHomes);

	public List<RenewalNursingHomes> getRenewalNursingHomesList(
			RTIApplicationSearch applicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public RenewalNursingHomes getRenewalNursingHomes(
			long rtiApplicationRefId);

	public RenewalNursingHomes findRenewalNursingHomesFromRefNum(
			String rtiapplrefno);

	public void renewalNursingHomes(
			RenewalNursingHomes renewalNursingHomes);

	public RenewalNursingHomes get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public RenewalNursingHomes merge(RenewalNursingHomes renewalNursingHomes);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long nursingHomeRenewalApplications(RenewalNursingHomes renewalNursingHomes);

	

}
