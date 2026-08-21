package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NoDuesCertificate;
import com.mars.rti.search.RTIApplicationSearch;

@Transactional(readOnly = true)
public interface NoDuesCertificateService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNoDuesCertificate(NoDuesCertificate noDuesCertificate);

	public List<NoDuesCertificate> getNoDuesCertificateList(
			RTIApplicationSearch applicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch);

	public NoDuesCertificate getNoDuesCertificate(long rtiApplicationRefId);

	public NoDuesCertificate findNoDuesCertificateFromRefNum(String rtiapplrefno);

	public NoDuesCertificate get(long id);

}
