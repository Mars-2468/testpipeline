package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireDetailsDao;
import com.mars.rti.model.FireDetails;
import com.mars.rti.service.FireDetailsService;

@Service
public class FireDetailsServiceImpl implements FireDetailsService {

	@Autowired
	private FireDetailsDao fireDetailsDao;
	
	
	public void saveFireDetails(FireDetails fireDetails)
	{
		 fireDetailsDao.saveFireDetails(fireDetails);
	}
	@Override
	public List<FireDetails> getFireDetails(long id) {
		
		return fireDetailsDao.getFireDetails(id);
	}
	
	public void delete(long id) {
		 fireDetailsDao.delete(id);
	}
}
