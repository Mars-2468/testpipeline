package com.mars.rti.dao;
import java.util.List;

import com.mars.rti.model.NOCFireRecommendation;


public interface NOCFirerecommendationDAO {
	
	public List<NOCFireRecommendation> getNOCFirerecommendation();
	public NOCFireRecommendation get(long id);

}
