package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.FireDetails;

public interface FireDetailsDao {
	
	public void saveFireDetails(FireDetails fireDetails);
	
	public List<FireDetails> getFireDetails(long id);
	
	public void delete(long id);

}
