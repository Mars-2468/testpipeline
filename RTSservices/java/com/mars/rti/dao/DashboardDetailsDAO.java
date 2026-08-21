package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.ws.model.DashboardStatsDTO;
import com.mars.rti.ws.model.DashboardStatsDetailsDTO;

public interface DashboardDetailsDAO {
	public DashboardStatsDTO getDashboardStats(String startDateStr,String endDateStr) ;
	public List<DashboardStatsDetailsDTO> getRTSDashboardDetailsServiceWise(String startDateStr, String endDateStr) ;

}
