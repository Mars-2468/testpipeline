package com.mars.rti.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.HealthDeptDashboardDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import com.mars.rti.service.HealthDeptDashboardService;
@Service
public class HealthDeptDashboardServiceImpl implements HealthDeptDashboardService{
			private static final Log log = LogFactory.getLog(HealthDeptDashboardServiceImpl.class);
		
		@Autowired
		private HealthDeptDashboardDAO healthDeptDashboardDAO;

		@Override
		public long getPieChartOrBarChartData() {
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return healthDeptDashboardDAO.getPieChartOrBarChartData();
		}
		@Override
		public long getPieChartOrBarChartData(String condValue) {
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return healthDeptDashboardDAO.getPieChartOrBarChartData(condValue);
		}
		@Override
		public long getPieChartOrBarChartData(String condValue1,
				String condValue2,String condValue3) {
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return healthDeptDashboardDAO.getPieChartOrBarChartData(condValue1, condValue2,condValue3);
		}
		
		@Override
		public List<BigInteger> getPieChartOrBarChartBasedOnSearch(
				String registrtionFromDate, String registrtionToDate, String category) {
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartBasedOnSearch Method is called");
			}
			return healthDeptDashboardDAO.getPieChartOrBarChartBasedOnSearch(registrtionFromDate, registrtionToDate, category);
		}
		
		@Override
		public List<RTIApplication> getRTIApplicationListByLabel(
				DashBoardLabelSearch dashBoardLabelSearch) {
			if (log.isDebugEnabled()) {
				log.debug("getRTIApplicationListByLabel Method is called");
			}
			return healthDeptDashboardDAO.getRTIApplicationListByLabel(dashBoardLabelSearch);
		}
		
		@Override
		public long getRTIApplicationCountByLabel(
				DashBoardLabelSearch dashBoardLabelSearch) {
			if (log.isDebugEnabled()) {
				log.debug("getRTIApplicationCountByLabel Method is called");
			}
			return healthDeptDashboardDAO.getRTIApplicationCountByLabel(dashBoardLabelSearch);
		}
		@Override
		public double getPieChartOrBarChartDatas(){
 
			// TODO Auto-generated method stub
						if (log.isDebugEnabled()) {
					log.debug("getPieChartOrBarChartData Method is called");
				}
				return healthDeptDashboardDAO.getPieChartOrBarChartDatas();
			
		}
		


		}
