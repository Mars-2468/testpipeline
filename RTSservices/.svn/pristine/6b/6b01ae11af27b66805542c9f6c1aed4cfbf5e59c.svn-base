package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NoDuesCertificateDAO;
import com.mars.rti.model.NoDuesCertificate;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.NoDuesCertificateService;

@Service("noDuesCertificateService")
public class NoDuesCertificateServiceImpl implements NoDuesCertificateService {

	@Autowired
	private NoDuesCertificateDAO noDuesCertificateDAO;

	@Override
	public void saveNoDuesCertificate(NoDuesCertificate noDuesCertificate) {
		noDuesCertificateDAO.save(noDuesCertificate);
	}

	@Override
	public List<NoDuesCertificate> getNoDuesCertificateList(
			RTIApplicationSearch applicationSearch) {
		return noDuesCertificateDAO.getList(applicationSearch);
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		return noDuesCertificateDAO.getRTIApplicationCount(applicationSearch);
	}

	@Override
	public NoDuesCertificate getNoDuesCertificate(long id) {
		return noDuesCertificateDAO.get(id);
	}

	@Override
	public NoDuesCertificate findNoDuesCertificateFromRefNum(String rtiapplrefno) {
		return noDuesCertificateDAO.findFromRTIRefNum(rtiapplrefno);
	}

	@Override
	public NoDuesCertificate get(long id) {
		return noDuesCertificateDAO.get(id);
	}

}
