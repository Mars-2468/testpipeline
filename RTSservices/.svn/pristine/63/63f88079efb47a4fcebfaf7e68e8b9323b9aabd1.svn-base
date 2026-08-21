package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FeesMasterDAO;
import com.mars.rti.model.FeesMaster;
import com.mars.rti.service.FeesMasterService;

@Service
public class FeesMasterServiceImpl implements FeesMasterService{
	
	@Autowired
	private FeesMasterDAO feesMasterDAO;
	
	@Override
	public FeesMaster getFees(long rtiapplicationserviceid) {
		// TODO Auto-generated method stub
		return feesMasterDAO.getFees(rtiapplicationserviceid);
	}

}
