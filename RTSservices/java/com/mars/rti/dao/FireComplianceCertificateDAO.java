package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.RTIApplication;

public interface FireComplianceCertificateDAO 
{
	public void savefireComplianceCertificateForm(FireComplianceCertificate fireComplianceCertificate) ;
	public long fireComplianceCertificate(FireComplianceCertificate fireComplianceCertificate);
	public FireComplianceCertificate get(long id);
	public List<RTIApplication> getnoc(long serviceid);


}
