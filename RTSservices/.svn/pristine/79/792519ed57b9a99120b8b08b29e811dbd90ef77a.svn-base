package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NOCFirerecommendationDAO;
import com.mars.rti.model.NOCFireRecommendation;
import com.mars.rti.service.NOCFirerecommendationService;

@Service
public class NOCFirerecommendationServiceImpl implements NOCFirerecommendationService {
	
	@Autowired
	private NOCFirerecommendationDAO nOCFirerecommendationDAO;
	
	

	@Override
	public List<NOCFireRecommendation> getNOCFirerecommendation() {
	
		return nOCFirerecommendationDAO.getNOCFirerecommendation();
	}



	@Override
	public NOCFireRecommendation get(long id) {
		// TODO Auto-generated method stub
		return nOCFirerecommendationDAO.get(id);
	}
	

}

