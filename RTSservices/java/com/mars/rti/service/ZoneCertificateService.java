package com.mars.rti.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.ZoneCertificate;
import com.mars.rti.search.RTIApplicationSearch;


@Transactional(readOnly = true)
public interface ZoneCertificateService {
	
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveZoneCertificate(ZoneCertificate zoneCertificate);

	public List<ZoneCertificate> getZoneCertificateList(
			RTIApplicationSearch applicationSearch);

	

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public ZoneCertificate get(long rtiApplicationRefId);

	public ZoneCertificate findZoneCertificateIdFromRefNum(String rtiapplrefno);

}
