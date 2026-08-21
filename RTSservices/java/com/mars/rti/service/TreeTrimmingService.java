package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.TreeTrimmingDetails;
import com.mars.rti.model.TreesType;

public interface TreeTrimmingService {
   
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTreeTrimmingForm(TreeTrimming treeTrimming);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long treeTrimming(TreeTrimming treeTrimming);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeTrimming get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeTrimming merge(TreeTrimming treeTrimming);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeTrimming getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savetreeTypeList(List<TreeTrimmingDetails> ttList);

	public List<TreeTrimmingDetails> getTreeTypeList(long id);
	
	public String getfees(String nameOfTree);


}
