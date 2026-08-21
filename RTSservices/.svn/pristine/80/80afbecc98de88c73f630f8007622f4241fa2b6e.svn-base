package com.mars.rti.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BirthDashboardDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import com.mars.rti.service.BirthDashboardService;

@Service
public class BirthDashboardServiceImpl implements BirthDashboardService {

	private static final Log log = LogFactory.getLog(BirthDashboardServiceImpl.class);
	
	@Autowired
	private BirthDashboardDAO birthDashboardDAO;

	@Override
	public long getPieChartOrBarChartData() {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return birthDashboardDAO.getPieChartOrBarChartData();
	}
	@Override
	public long getPieChartOrBarChartData(String condValue) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return birthDashboardDAO.getPieChartOrBarChartData(condValue);
	}
	@Override
	public long getPieChartOrBarChartData(String condValue1,
			String condValue2,String condValue3) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return birthDashboardDAO.getPieChartOrBarChartData(condValue1, condValue2,condValue3);
	}
	
	@Override
	public List<BigInteger> getPieChartOrBarChartBasedOnSearch(
			String registrtionFromDate, String registrtionToDate, String category) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartBasedOnSearch Method is called");
		}
		return birthDashboardDAO.getPieChartOrBarChartBasedOnSearch(registrtionFromDate, registrtionToDate, category);
	}
	
	@Override
	public List<RTIApplication> getRTIApplicationListByLabel(
			DashBoardLabelSearch dashBoardLabelSearch) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationListByLabel Method is called");
		}
		return birthDashboardDAO.getRTIApplicationListByLabel(dashBoardLabelSearch);
	}
	
	@Override
	public long getRTIApplicationCountByLabel(
			DashBoardLabelSearch dashBoardLabelSearch) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationCountByLabel Method is called");
		}
		return birthDashboardDAO.getRTIApplicationCountByLabel(dashBoardLabelSearch);
	}
	@Override
	public double getPieChartOrBarChartDatas() {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return birthDashboardDAO.getPieChartOrBarChartDatas();
	}
	

}
