package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.SpaceDao;
import com.mars.rti.model.Space;
import com.mars.rti.service.SpaceService;

@Service

public class SpaceServiceImpl implements SpaceService {
	 @Autowired
	 private SpaceDao spaceDao;
	 
	 public List<Space> getSpace() {
			return spaceDao.getSpace();
		}

}
