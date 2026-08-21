package com.mars.rti.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ZoneCertificateDAO;
import com.mars.rti.model.ZoneCertificate;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.ZoneCertificateService;


@Service("zoneCertificateService")
public class ZoneCertificateServiceImpl implements ZoneCertificateService {

	private static final Log log= LogFactory.getLog(ZoneCertificateServiceImpl.class);
	
	@Autowired
	private ZoneCertificateDAO zoneCertificateDAO;

	@Override
	public void saveZoneCertificate(ZoneCertificate zoneCertificate) {
		zoneCertificateDAO.saveZoneCertificate(zoneCertificate);
		
	}

	@Override
	public List<ZoneCertificate> getZoneCertificateList(
			RTIApplicationSearch applicationSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRTIApplicationCount(RTIApplicationSearch applicationSearch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ZoneCertificate get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return zoneCertificateDAO.get(rtiApplicationRefId);
	}

	@Override
	public ZoneCertificate findZoneCertificateIdFromRefNum(String rtiapplrefno) {
		// TODO Auto-generated method stub
		return zoneCertificateDAO.findZoneCertificateIdFromRefNum(rtiapplrefno);
	}
		
}

































