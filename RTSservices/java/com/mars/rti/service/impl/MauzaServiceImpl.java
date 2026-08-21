package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MauzaDAO;
import com.mars.rti.model.Mauza;
import com.mars.rti.service.MauzaService;

@Service

public class MauzaServiceImpl  implements MauzaService {
	
	 @Autowired
	 private MauzaDAO mauzaDAO;
	 
	 public List<Mauza> getMauza() {
			return mauzaDAO.getMauza();
		}


}
