package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.RTIApplication;

public interface CitizenMyApplicationDAO {
	public List<RTIApplication> getListOfCitizen(long mobileNo);
}
