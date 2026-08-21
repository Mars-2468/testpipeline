package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DogtypeDAO;
import com.mars.rti.model.Dogtype;
import com.mars.rti.service.DogtypeService;

@Service
public class DogtypeServiceImpl implements DogtypeService{

	@Autowired
	private DogtypeDAO dogtypeDAO;
	
	@Override
	public List<Dogtype>  getDogtype(String dogtype) {
		return dogtypeDAO.getDogtype(dogtype);
	}

	@Override
	public Dogtype getDogtypes(String dogtype) {
		// TODO Auto-generated method stub
		return dogtypeDAO.getDogtypes(dogtype);
	}

}
