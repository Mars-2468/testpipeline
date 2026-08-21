package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.GenderOfCrematiousDAO;
import com.mars.rti.model.GenderOfCrematious;
import com.mars.rti.service.GenderOfCrematiousService;

@Service
public class GenderOfCrematiousServiceImpl implements GenderOfCrematiousService {
	
	@Autowired
	private GenderOfCrematiousDAO genderOfCrematiousDAO;
	
	public List<GenderOfCrematious> getGenderOfCrematious() {
		return genderOfCrematiousDAO.getGenderOfCrematious();
	}
	
	

}
