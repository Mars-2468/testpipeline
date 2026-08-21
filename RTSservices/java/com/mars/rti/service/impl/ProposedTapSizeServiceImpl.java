package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ProposedTapSizeDao;
import com.mars.rti.model.ProposedTapSize;
import com.mars.rti.service.ProposedTapSizeService;

@Service

public class ProposedTapSizeServiceImpl implements ProposedTapSizeService {

	@Autowired
	private ProposedTapSizeDao  proposedTapSizeDao;
	
	public List<ProposedTapSize> getPropertapsize() {
		return proposedTapSizeDao.getPropertapsize();
	}
	
}
