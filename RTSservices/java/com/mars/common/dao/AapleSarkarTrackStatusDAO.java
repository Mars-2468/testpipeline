package com.mars.common.dao;

import org.springframework.stereotype.Repository;

import com.mars.rti.model.RTIApplication;  

public interface AapleSarkarTrackStatusDAO {
	public RTIApplication findByRTIApplicationNumber(String applicationNumber);
	public RTIApplication get(long id);

}
