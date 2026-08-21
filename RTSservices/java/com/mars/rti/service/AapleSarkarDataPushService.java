package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.ws.model.PushDepartmentDTO;
@Transactional(readOnly = true)

public interface AapleSarkarDataPushService {
	 public List<PushDepartmentDTO> getRowDataForRTS();

}
