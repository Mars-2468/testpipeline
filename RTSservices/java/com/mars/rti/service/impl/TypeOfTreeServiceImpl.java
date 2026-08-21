package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TypeOfTreeDAO;
import com.mars.rti.model.TypeOfTree;
import com.mars.rti.service.TypeOfTreeService;

@Service
public class TypeOfTreeServiceImpl implements TypeOfTreeService{

	 @Autowired
	 private TypeOfTreeDAO typeOfTreeDAO;
	 
	@Override
	public List<TypeOfTree> getTypeOfTree() {
		// TODO Auto-generated method stub
		return typeOfTreeDAO.getTypeOfTree();
	}

}
