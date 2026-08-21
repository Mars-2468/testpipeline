package com.mars.common.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.RTIApplication;
@Transactional(readOnly = true)
public interface AapleSarkarTrackStatusService {
	public RTIApplication findByRTIApplicationNumber(String applicationNumber);
	public RTIApplication get(long id);


}
