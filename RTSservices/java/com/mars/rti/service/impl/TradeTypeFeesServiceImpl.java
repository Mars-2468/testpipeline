package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeTypeFeesDAO;
import com.mars.rti.model.TradeTypeFees;
import com.mars.rti.service.TradeTypeFeesService;

@Service
public class TradeTypeFeesServiceImpl implements TradeTypeFeesService{

	@Autowired
	private TradeTypeFeesDAO  tradeTypeFeesDAO;
	
	@Override
	public List<TradeTypeFees> getall() {
		// TODO Auto-generated method stub
		return tradeTypeFeesDAO.getall();
	}
	
	

}
