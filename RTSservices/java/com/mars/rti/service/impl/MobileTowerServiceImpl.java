package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MobileTowerDAO;
import com.mars.rti.model.MobileTower;
import com.mars.rti.service.MobileTowerService;

@Service
public class MobileTowerServiceImpl implements MobileTowerService {

	@Autowired
	private MobileTowerDAO mobileTowerDAO;

	@Override
	public void saveMobileForm(MobileTower mobileTower) {
		// TODO Auto-generated method stub
		mobileTowerDAO.saveMobileTower(mobileTower);

	}

	@Override
	public long mobileTower(MobileTower mobileTower) {
		return mobileTowerDAO.mobileTowerSave(mobileTower);

	}

	@Override
	public MobileTower get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return mobileTowerDAO.get(rtiApplicationRefId);
	}

}
