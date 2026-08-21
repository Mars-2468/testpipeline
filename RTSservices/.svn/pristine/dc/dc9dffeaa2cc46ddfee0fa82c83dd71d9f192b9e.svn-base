package com.mars.rti.dao;

import java.util.List;


import com.mars.rti.model.AnaesthetistDetails;
import com.mars.rti.model.MTPAssistantDetails;
import com.mars.rti.model.MTPBloodBankDetails;
import com.mars.rti.model.MTPDetails;
import com.mars.rti.model.MTPNurseDetails;
import com.mars.rti.model.MTPRegistrationCertificate;
import com.mars.rti.search.RTIApplicationSearch;

public interface MTPRegistrationCertificateDAO {

	public long MTPRegistrationCertificateCertificate(
			MTPRegistrationCertificate MTPRegistrationCertificate);

	public List<MTPRegistrationCertificate> getMTPRegistrationCertificateList(
			RTIApplicationSearch rTIApplicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch searchOptions);

	public MTPRegistrationCertificate get(long id);

	public MTPRegistrationCertificate findMTPRFromRefNum(String rtiapplrefno);
	
	public long nursingHomeApplications(MTPRegistrationCertificate mTPRegistrationCertificate);
	public void saveMTP (MTPRegistrationCertificate mTPRegistrationCertificate) ;
	
	public MTPRegistrationCertificate merge(MTPRegistrationCertificate mTPRegistrationCertificate);


	public MTPDetails mergeMTPDetailsList(MTPDetails tt);
	

	public MTPAssistantDetails mergeMTPAssistantDetailsList(MTPAssistantDetails matt) ;
			
	public MTPNurseDetails mergeMTPNurseDetails(MTPNurseDetails ttN);
	
	public MTPBloodBankDetails mergeMTPBloodBankDetails(MTPBloodBankDetails ttb);
	
	public AnaesthetistDetails mergeMTPAnaesthetistDetails(AnaesthetistDetails ttA);
	
}
