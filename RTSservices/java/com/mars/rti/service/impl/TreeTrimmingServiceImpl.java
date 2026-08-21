package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TreeTrimmingDAO;
import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.TreeTrimmingDetails;
import com.mars.rti.model.TreesType;
import com.mars.rti.service.TreeTrimmingService;

@Service
public class TreeTrimmingServiceImpl implements TreeTrimmingService{
   
	@Autowired
	private TreeTrimmingDAO treeTrimmingDAO;

	@Override
	public void saveTreeTrimmingForm(TreeTrimming treeTrimming) {
		treeTrimmingDAO.saveTreeTrimming(treeTrimming);
	}

	@Override
	public TreeTrimming get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return treeTrimmingDAO.get(rtiApplicationRefId);
	}
		@Override
		public long treeTrimming(TreeTrimming treeTrimming) {
			// TODO Auto-generated method stub
			return treeTrimmingDAO.treeTrimmingSave(treeTrimming);
		}

		@Override
		public TreeTrimming merge(TreeTrimming treeTrimming) {
			// TODO Auto-generated method stub
			return treeTrimmingDAO.merge(treeTrimming);
		}
		@Override
		public TreeTrimming getDetails(long rtiApplicationId) {
			// TODO Auto-generated method stub
			return treeTrimmingDAO.getDetails(rtiApplicationId);
		}


		@Override
		public void savetreeTypeList(List<TreeTrimmingDetails> ttList) {
			// TODO Auto-generated method stub
			treeTrimmingDAO.savetreeTypeList(ttList);
		}

		@Override
		public List<TreeTrimmingDetails> getTreeTypeList(long id) {
			// TODO Auto-generated method stub
			return treeTrimmingDAO.getTreeTypeList(id);
		}

		@Override
		public String getfees(String nameOfTree) {
			return treeTrimmingDAO.getfees(nameOfTree);

		}
		
}
