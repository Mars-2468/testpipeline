package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NOCOfTradeDAO;
import com.mars.rti.model.NOCOfTrade;
import com.mars.rti.service.NOCOfTradeService;

@Service
public class NOCOfTradeServiceImpl implements NOCOfTradeService{
	
	@Autowired
	private NOCOfTradeDAO nocTradeDAO;


	@Override
	public void saveNOCOfTrade(NOCOfTrade nocTrade) {
		nocTradeDAO.nocTradeSave(nocTrade);
		
	}

	@Override
	public long nocTrade(NOCOfTrade nocTrade) {
		// TODO Auto-generated method stub
		return nocTradeDAO.nocTradeSave(nocTrade);	}

	@Override
	public NOCOfTrade get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return nocTradeDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public NOCOfTrade getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return nocTradeDAO.getDetails(rtiApplicationId);
	}

}
