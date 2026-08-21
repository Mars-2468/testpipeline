package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TreeTrimmingReasonDAO;
import com.mars.rti.model.TreeTrimmingReason;
import com.mars.rti.service.TreeTrimmingReasonService;

@Service
public class TreeTrimmingReasonImpl implements TreeTrimmingReasonService{

	 @Autowired
	 private TreeTrimmingReasonDAO  treeTrimmingReasonDAO;
	 
	 
	@Override
	public List<TreeTrimmingReason> getTreeTrimmingReason() {
		// TODO Auto-generated method stub
		return treeTrimmingReasonDAO.getTreeTrimmingReason();
	}

}
