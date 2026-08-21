package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DashboardDetailsDAO;
import com.mars.rti.service.DashboardDetailsService;
import com.mars.rti.ws.model.DashboardStatsDTO;
import com.mars.rti.ws.model.DashboardStatsDetailsDTO;
@Service
public class DashboardDetailsServiceImpl implements DashboardDetailsService{
	
	@Autowired
	private DashboardDetailsDAO dashboardDetailsDAO;
	
	@Override
	public DashboardStatsDTO getDashboardStats(String startDateStr,String endDateStr) {
		return dashboardDetailsDAO.getDashboardStats(startDateStr, endDateStr);
	}
	
	@Override
	public List<DashboardStatsDetailsDTO> getRTSDashboardDetailsServiceWise(String startDateStr, String endDateStr) {
		return dashboardDetailsDAO.getRTSDashboardDetailsServiceWise(startDateStr, endDateStr);

	}


}
