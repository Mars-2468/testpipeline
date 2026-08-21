package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireComplianceCertificateDAO;
import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.FireComplianceCertificateService;

@Service
public class FireComplianceCertificateServiceImpl implements FireComplianceCertificateService 
{
	@Autowired
	private FireComplianceCertificateDAO fireComplianceCertificateDAO;

	@Override
	public void savefireComplianceCertificateForm(FireComplianceCertificate fireComplianceCertificate) {
		fireComplianceCertificateDAO.savefireComplianceCertificateForm(fireComplianceCertificate);

	}

	@Override
	public long fireComplianceCertificate(FireComplianceCertificate fireComplianceCertificate) {
		// TODO Auto-generated method stub
		return fireComplianceCertificateDAO.fireComplianceCertificate(fireComplianceCertificate);
	}

	@Override
	public FireComplianceCertificate get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return fireComplianceCertificateDAO.get(rtiApplicationRefId);
	}

	@Override
	public List<RTIApplication> getnoc(long serviveid) {
		// TODO Auto-generated method stub
		return fireComplianceCertificateDAO.getnoc(serviveid);
	}
}
