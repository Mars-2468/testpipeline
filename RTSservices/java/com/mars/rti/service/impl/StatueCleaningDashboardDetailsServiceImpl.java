package com.mars.rti.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.StatueCleaningDashboardDetailsDAO;
import com.mars.rti.service.StatueCleaningDashboardDetailsService;

@Service
public class StatueCleaningDashboardDetailsServiceImpl implements StatueCleaningDashboardDetailsService{
	@Autowired
	private StatueCleaningDashboardDetailsDAO statueCleaningDashboardDetailsDAO;

	@Override
    public Map<String, Object> getCleaningSummary(LocalDateTime startDate, LocalDateTime endDate) {
        long totalCount = statueCleaningDashboardDetailsDAO.getTotalCleanedCount(startDate, endDate);
        List<Object[]> firestationWiseList = statueCleaningDashboardDetailsDAO.getFirestationWiseCount(startDate, endDate);

        List<Map<String, Object>> firestationList = new ArrayList<>();
        for (Object[] row : firestationWiseList) {
            Map<String, Object> map = new HashMap<>();
            map.put("fireStationName", row[0]);
            map.put("cleanedCount", row[1]);
            firestationList.add(map);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("totalCleaned", totalCount);
        response.put("firestationWise", firestationList);
        return response;
    }

}
