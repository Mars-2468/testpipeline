package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.PropertyWard;

public interface PropertyWardDAO {

	public List<PropertyWard> getWards(String zoneId);
}
