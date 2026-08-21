package com.mars.rti.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NewWaterconnectionPurposeDAO;
import com.mars.rti.model.NewWaterConnectionPurpose;
import com.mars.rti.service.NewWaterconnectionPurposeService;

@Service

public class NewWaterconnectionPurposeServiceImpl implements NewWaterconnectionPurposeService {
	
	 @Autowired
	 private NewWaterconnectionPurposeDAO newWaterconnectionPurposeRestDAo;
	 
	 public List<NewWaterConnectionPurpose> getPurpose() {
			return newWaterconnectionPurposeRestDAo.getPurpose();
		}

}


