package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CitizenHospitalDAO;
import com.mars.rti.model.CitizenHospital;
import com.mars.rti.service.CitizenHospitalService;

@Service
public class CitizenHospitalServiceImpl implements CitizenHospitalService {
	
	@Autowired
	private CitizenHospitalDAO citizenHospitalDAO;
	
	@Override
	public List<CitizenHospital> getAllHospitalList(String zoneNo)
	{
		return citizenHospitalDAO.getAllHospitalList(zoneNo);

	}
	
}
