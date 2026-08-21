package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.AapleSarkarDataPushDAO;
import com.mars.rti.service.AapleSarkarDataPushService;
import com.mars.rti.ws.model.PushDepartmentDTO;

@Service("aapleSarkarDataPushService")
public class AapleSarkarDataPushServiceImpl implements  AapleSarkarDataPushService{
	@Autowired
	private AapleSarkarDataPushDAO aapleSarkarDataPushDAO;
	
	public List<PushDepartmentDTO> getRowDataForRTS() {

        List<PushDepartmentDTO> list =
        		aapleSarkarDataPushDAO.getPushDepartmentData();

        for (PushDepartmentDTO dto : list) {
            dto.setDivision(4);
            dto.setDistrict(505);
            dto.setTaluka(4032);
            dto.setPaymentMode("NA");
            //dto.setPendingatDepartmentAfterSLA(0);
           // dto.setPendingatDepartmentWithinSLA(0);
            dto.setApplicationSource("U");
        }
        return list;
    }

}


