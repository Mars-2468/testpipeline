package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CountryDao;
import com.mars.rti.model.Country;
import com.mars.rti.service.CountryService;

@Service

public class CountryServiceImpl implements CountryService {
	 @Autowired
	 private CountryDao countryDao;
	 
	 public List<Country> getCountry() {
			return countryDao.getCountry();
		}
		

}
