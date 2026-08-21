package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeTypeDAO;
import com.mars.rti.model.TradeType;
import com.mars.rti.service.TradeTypeService;

@Service
public class TradeTypeServiceImpl implements TradeTypeService{

	@Autowired
	private TradeTypeDAO tradeTypeDAO;
	
	@Override
	public List<TradeType> getall() {
		// TODO Auto-generated method stub
		return tradeTypeDAO.getall();
	}

}
