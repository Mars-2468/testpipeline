package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TradeLicenseTransferDAO;
import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.model.TradeTypes;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.service.TradeLicenseTransferService;

@Service
public class TradeLicenseTransferServiceImpl implements TradeLicenseTransferService{

	@Autowired
	private TradeLicenseTransferDAO tradeLicenseTransferDAO;


	@Override
	public void saveTradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer) {
		tradeLicenseTransferDAO.tradeLicenseTransferSave(tradeLicenseTransfer);
		
	}

	@Override
	public long tradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer) {
		// TODO Auto-generated method stub
		return tradeLicenseTransferDAO.tradeLicenseTransferSave(tradeLicenseTransfer);	}

	@Override
	public TradeLicenseTransfer get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return tradeLicenseTransferDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public TradeLicenseTransfer getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return tradeLicenseTransferDAO.getDetails(rtiApplicationId);
	}

	
	@Override
	public List<TradeTypes> gettradeTypes(){
		return tradeLicenseTransferDAO.gettradeTypes();

	
	}


}
