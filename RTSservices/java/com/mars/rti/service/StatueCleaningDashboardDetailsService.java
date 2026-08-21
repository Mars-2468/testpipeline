package com.mars.rti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.transaction.Transactional;

@Transactional
public interface StatueCleaningDashboardDetailsService {
	Map<String, Object> getCleaningSummary(LocalDateTime startDate, LocalDateTime endDate);

}
