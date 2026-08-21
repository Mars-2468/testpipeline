package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CitizenMyApplicationDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.CitizenMyApplicationService;

@Service
public class CitizenMyApplicationServiceImpl implements CitizenMyApplicationService
{
	@Autowired
	private CitizenMyApplicationDAO citizenMyApplicationDAO;
	
	@Override
	public List<RTIApplication> getListOfCitizen(long mobileNo)
	{
		return citizenMyApplicationDAO.getListOfCitizen(mobileNo);
	}
}
