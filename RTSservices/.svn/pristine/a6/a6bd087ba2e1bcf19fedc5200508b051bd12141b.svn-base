package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.GenderDao;
import com.mars.rti.model.Gender;
import com.mars.rti.service.GenderService;

@Service
public class GenderServiceImpl  implements GenderService {
	

	@Autowired
	private GenderDao genderDao;
	
	public List<Gender> getGender() {
		return genderDao.getGender();
	}
	
	

}
