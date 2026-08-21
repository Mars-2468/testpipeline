package com.mars.rti.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DashBoardDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import com.mars.rti.service.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	private static final Log log = LogFactory.getLog(DashBoardServiceImpl.class);
	
	@Autowired
	private DashBoardDAO dashBoardDAO;

	@Override
	public long getPieChartOrBarChartData(String userZone,String serviceId,String currentYear) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return dashBoardDAO.getPieChartOrBarChartData(userZone,serviceId,currentYear);
	}
	@Override
	public long getPieChartOrBarChartData(String condValue,String userZone,String serviceId,String currentYear) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return dashBoardDAO.getPieChartOrBarChartData(condValue,userZone,serviceId,currentYear);
	}
	@Override
	public long getPieChartOrBarChartData(String condValue1,
			String condValue2,String condValue3,String userZone,String serviceId,String currentYear) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return dashBoardDAO.getPieChartOrBarChartData(condValue1, condValue2,condValue3,userZone,serviceId,currentYear);
	}
	
	@Override
	public List<BigInteger> getPieChartOrBarChartBasedOnSearch(String registrtionFromDate,
            String registrtionToDate,
            String departments,
            String services,String userZone,String serviceId,String currentYear){
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartBasedOnSearch Method is called");
		}
		return dashBoardDAO.getPieChartOrBarChartBasedOnSearch(registrtionFromDate, registrtionToDate, departments,services,userZone,serviceId,currentYear);
	}
	
	@Override
	public List<RTIApplication> getRTIApplicationListByLabel(
			DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationListByLabel Method is called");
		}
		return dashBoardDAO.getRTIApplicationListByLabel(dashBoardLabelSearch,userZone,serviceId,currentYear,searchrtiApplnNumber);
	}
	@Override
	public List<RTIApplication> getRTIApplicationListByLabelAll(
			DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationListByLabel Method is called");
		}
		return dashBoardDAO.getRTIApplicationListByLabelAll(dashBoardLabelSearch,userZone,serviceId,currentYear,searchrtiApplnNumber);
	}

	@Override
	public long getRTIApplicationCountByLabel(
			DashBoardLabelSearch dashBoardLabelSearch,String userZone,String serviceId,String currentYear,String searchrtiApplnNumber) {
		if (log.isDebugEnabled()) {
			log.debug("getRTIApplicationCountByLabel Method is called");
		}
		return dashBoardDAO.getRTIApplicationCountByLabel(dashBoardLabelSearch,userZone,serviceId,currentYear,searchrtiApplnNumber);
	}
	@Override
	public double getPieChartOrBarChartDatas(String userZone,String serviceId,String currentYear) {
		if (log.isDebugEnabled()) {
			log.debug("getPieChartOrBarChartData Method is called");
		}
		return dashBoardDAO.getPieChartOrBarChartDatas(userZone,serviceId,currentYear);
	}
	@Override
	public long getPieChartOrBarChartDataForPoliceNoc(String userZone,String serviceId,String currentYear) {
		{
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return dashBoardDAO.getPieChartOrBarChartDataForPoliceNoc(userZone,serviceId,currentYear);
		}
	}
	@Override
	public long getPieChartOrBarChartDataForTrafficNoc(String userZone,String serviceId,String currentYear) {
		{
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return dashBoardDAO.getPieChartOrBarChartDataForTrafficNoc(userZone,serviceId,currentYear);
		}
	}
	@Override
	public long getPieChartOrBarChartDataForFireNoc(String userZone,String serviceId,String currentYear) {
		{
			if (log.isDebugEnabled()) {
				log.debug("getPieChartOrBarChartData Method is called");
			}
			return dashBoardDAO.getPieChartOrBarChartDataForFireNoc(userZone,serviceId,currentYear);
		}
	}
	@Override
	public List<Object> getServiceId(String sql) {
		// TODO Auto-generated method stub
		return dashBoardDAO.getServiceId(sql);
	}


	}
