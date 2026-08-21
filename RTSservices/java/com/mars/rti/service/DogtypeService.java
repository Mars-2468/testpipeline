package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.Dogtype;

@Transactional(readOnly = true)
public interface DogtypeService {

	public List<Dogtype> getDogtype(String dogtype);
	
	public Dogtype getDogtypes(String dogtype);

}
