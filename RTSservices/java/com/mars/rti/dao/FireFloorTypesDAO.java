package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.FireFloorTypes;

public interface FireFloorTypesDAO {
	public List<FireFloorTypes> getFireFloorTypes();
	
	public List<FireFloorTypes> getList(long id);

}
