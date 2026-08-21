package com.mars.rti.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.ws.model.DashboardStatsDTO;
import com.mars.rti.ws.model.DashboardStatsDetailsDTO;

@Transactional(readOnly = true)
public interface DashboardDetailsService {
		public DashboardStatsDTO getDashboardStats(String startDateStr,String endDateStr) ;
		public List<DashboardStatsDetailsDTO> getRTSDashboardDetailsServiceWise(String startDateStr, String endDateStr) ;


}
