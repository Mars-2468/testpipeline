package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyWardDAO;
import com.mars.rti.model.PropertyWard;
import com.mars.rti.service.PropertyWardService;

@Service
public class PropertyWardServiceImpl implements PropertyWardService{

	@Autowired
	private PropertyWardDAO propertyWardDAO;
	
	
	@Override
	public List<PropertyWard> getwards(String zoneId) {
		// TODO Auto-generated method stub
		return propertyWardDAO.getWards(zoneId);
	}

}
