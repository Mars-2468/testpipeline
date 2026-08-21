package com.mars.rti.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface StatueCleaningDashboardDetailsDAO {
	long getTotalCleanedCount(LocalDateTime startDate, LocalDateTime endDate);

	List<Object[]> getFirestationWiseCount(LocalDateTime startDate, LocalDateTime endDate);

}
