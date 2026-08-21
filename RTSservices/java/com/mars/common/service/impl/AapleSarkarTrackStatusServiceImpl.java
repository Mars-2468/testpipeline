package com.mars.common.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.AapleSarkarTrackStatusDAO;
import com.mars.common.service.AapleSarkarTrackStatusService;
import com.mars.rti.dao.RTIApplicationDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.impl.RTIApplicationServiceImpl;

@Service("aapleSarkarTrackStatusService")

public class AapleSarkarTrackStatusServiceImpl implements AapleSarkarTrackStatusService{

	private static final Log log = LogFactory.getLog(RTIApplicationServiceImpl.class);
	
	@Autowired
	private AapleSarkarTrackStatusDAO aapleSarkarTrackStatusDAO;
	
public RTIApplication findByRTIApplicationNumber(String applicationNumber) {
		
		return aapleSarkarTrackStatusDAO.findByRTIApplicationNumber(applicationNumber);
	}

public RTIApplication get(long id) {
	if (log.isDebugEnabled()) {
		log.debug("get Method is called");
	}
	return aapleSarkarTrackStatusDAO.get(id);
}
}
