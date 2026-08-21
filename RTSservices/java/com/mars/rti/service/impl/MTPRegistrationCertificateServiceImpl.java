package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.dao.MTPRegistrationCertificateDAO;
import com.mars.rti.model.AnaesthetistDetails;
import com.mars.rti.model.MTPAssistantDetails;
import com.mars.rti.model.MTPBloodBankDetails;
import com.mars.rti.model.MTPDetails;
import com.mars.rti.model.MTPNurseDetails;
import com.mars.rti.model.MTPRegistrationCertificate;
import com.mars.rti.model.SurgeonsDetails;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.MTPRegistrationCertificateService;

@Service("MTPRegistrationCertificateService")
public class MTPRegistrationCertificateServiceImpl implements
		MTPRegistrationCertificateService {

	@Autowired
	private MTPRegistrationCertificateDAO mtpRegistrationCertificateDAO;

	@Override
	public long mTPRegistrationCertificate(
			MTPRegistrationCertificate mTPRegistrationCertificate) {
	 return	mtpRegistrationCertificateDAO
				.MTPRegistrationCertificateCertificate(mTPRegistrationCertificate);
		
	}

	@Override
	public List<MTPRegistrationCertificate> getMTPRegistrationCertificateList(
			RTIApplicationSearch applicationSearch) {
		return mtpRegistrationCertificateDAO
				.getMTPRegistrationCertificateList(applicationSearch);
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		return mtpRegistrationCertificateDAO
				.getRTIApplicationCount(applicationSearch);
	}

	@Override
	public MTPRegistrationCertificate get(long rtiApplicationRefId) {
		return mtpRegistrationCertificateDAO.get(rtiApplicationRefId);
	}

	@Override
	public MTPRegistrationCertificate findMTPRegistrationCertificateIdFromRefNum(
			String rtiapplrefno) {
		return mtpRegistrationCertificateDAO.findMTPRFromRefNum(rtiapplrefno);
	}

	@Override
	public long MTPCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		// TODO Auto-generated method stub
		return mtpRegistrationCertificateDAO.nursingHomeApplications(mTPRegistrationCertificate);
	}

	@Override
	public void saveMTP (MTPRegistrationCertificate mTPRegistrationCertificate) {
		mtpRegistrationCertificateDAO.saveMTP(mTPRegistrationCertificate);
		
	}
	
	@Override
	public MTPRegistrationCertificate merge(MTPRegistrationCertificate mTPRegistrationCertificate) {
		// TODO Auto-generated method stub
		return mtpRegistrationCertificateDAO.merge(mTPRegistrationCertificate);
	}
	
	
	@Override
	public MTPDetails mergeMTPDetailsList(MTPDetails tt) {
		return mtpRegistrationCertificateDAO.mergeMTPDetailsList(tt);
	}
	
	@Override
	public MTPAssistantDetails mergeMTPAssistantDetailsList(MTPAssistantDetails matt) {
		return mtpRegistrationCertificateDAO.mergeMTPAssistantDetailsList(matt);

	}

	@Override
	public MTPNurseDetails mergeMTPNurseDetails(MTPNurseDetails ttN) {
		return mtpRegistrationCertificateDAO.mergeMTPNurseDetails(ttN);
	}
	
	@Override
	public MTPBloodBankDetails mergeMTPBloodBankDetails(MTPBloodBankDetails ttb) {
		return mtpRegistrationCertificateDAO.mergeMTPBloodBankDetails(ttb);
	}
	
	@Override
	public AnaesthetistDetails mergeMTPAnaesthetistDetails(AnaesthetistDetails ttA) {
		return mtpRegistrationCertificateDAO.mergeMTPAnaesthetistDetails(ttA);
	}



}
