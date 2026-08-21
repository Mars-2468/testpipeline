package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.CitizenHospital;

@Transactional(readOnly = true)
public interface CitizenHospitalService 
{
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<CitizenHospital> getAllHospitalList(String zoneNo);


}
