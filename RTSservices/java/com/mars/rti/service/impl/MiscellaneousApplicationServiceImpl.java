package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MiscellaneousApplicationDAO;
import com.mars.rti.model.MisPurposeWithAmount;
import com.mars.rti.model.MiscellaneousApplication;
import com.mars.rti.service.MiscellaneousApplicationService;

@Service
public class MiscellaneousApplicationServiceImpl implements MiscellaneousApplicationService{
	
		
		@Autowired
		private MiscellaneousApplicationDAO miscellanoeousApplicationDAO;


		@Override
		public MiscellaneousApplication saveMiscellaneousApplication(MiscellaneousApplication miscellaneousApplication) {
			// TODO Auto-generated method stub
			miscellaneousApplication =  miscellanoeousApplicationDAO.saveMiscellaneousApplication(miscellaneousApplication);
			return miscellaneousApplication;
		}
		
		@Override
		public MiscellaneousApplication findById(Long miscId) {
		    return miscellanoeousApplicationDAO.findById(miscId);
		}

		@Override
		public List<MisPurposeWithAmount> getPurposeWithAmount() {
			// TODO Auto-generated method stub
		    return miscellanoeousApplicationDAO.getPurposeWithAmount();
		}
		


}
