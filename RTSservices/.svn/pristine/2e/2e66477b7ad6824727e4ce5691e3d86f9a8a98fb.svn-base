package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TreeLocationDao;
import com.mars.rti.model.TreeLocation;
import com.mars.rti.service.TreeLocationService;

@Service
public class TreeLocationServiceImpl implements TreeLocationService {
	
	@Autowired
	private TreeLocationDao treeLocationDao;

	@Override
	public List<TreeLocation> gettreLocations() {
		// TODO Auto-generated method stub
			return  treeLocationDao.gettrLocations();
		}
	


}
