package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TitleRestDao;
import com.mars.rti.model.Title;
import com.mars.rti.service.TitleRestService;
@Service

public class TitleRestServiceImpl implements TitleRestService {

	@Autowired
	private TitleRestDao titleRestDao;
	
	public List<Title> getTitle() {
		return titleRestDao.getTitle();
	}


}
