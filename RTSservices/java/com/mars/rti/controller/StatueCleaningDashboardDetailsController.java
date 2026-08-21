package com.mars.rti.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.service.StatueCleaningDashboardDetailsService;


@Controller
public class StatueCleaningDashboardDetailsController {
	
	private static Log log = LogFactory.getLog(StatueCleaningDashboardDetailsController.class);
	@Autowired
	private StatueCleaningDashboardDetailsService statueCleaningDashboardDetailsService;

//	@RequestMapping(value = "/rtsapplication/getStatueCleaningSummary.do", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody String getStatueCleaningSummary() {
//
//		LocalDate now = LocalDate.now();
//		int year = (now.getMonthValue() >= 4) ? now.getYear() : now.getYear() - 1;
//
////		LocalDate startDate = LocalDate.of(year, 4, 1);
////		LocalDate endDate = LocalDate.of(year + 1, 3, 31);
////		
//		LocalDate today = LocalDate.now();
//
//		LocalDateTime startDate = today.atStartOfDay();
//		LocalDateTime endDate = today.plusDays(1).atStartOfDay();
//
//		Map<String, Object> responseMap = statueCleaningDashboardDetailsService.getCleaningSummary(startDate, endDate);
//
//		StringBuilder json = new StringBuilder("{");
//
//		json.append("\"totalCleaned\":").append(responseMap.get("totalCleaned")).append(",");
//
//		json.append("\"firestationWise\":[");
//		List<?> firestationList = (List<?>) responseMap.get("firestationWise");
//		for (Object item : firestationList) {
//			if (item instanceof Map) {
//				Map<?, ?> map = (Map<?, ?>) item;
//				json.append("{");
//				json.append("\"fireStationName\":\"").append(map.get("fireStationName")).append("\",");
//				json.append("\"cleanedCount\":").append(map.get("cleanedCount"));
//				json.append("},");
//			}
//		}
//		if (json.charAt(json.length() - 1) == ',')
//			json.deleteCharAt(json.length() - 1);
//		json.append("]");
//
//		json.append("}");
//		return json.toString();
//	}
 
	@RequestMapping(value = "/rtsapplication/getStatueCleaningSummary.do",
	        method = RequestMethod.GET,
	        produces = "application/json")
	public @ResponseBody String getStatueCleaningSummary(
	        @RequestParam(value = "fromDate", required = false) String fromDate,
	        @RequestParam(value = "toDate", required = false) String toDate) {

	    LocalDateTime startDate;
	    LocalDateTime endDate;

	    try {

	        // Use custom date range if provided
	        if (fromDate != null && !fromDate.isEmpty()
	                && toDate != null && !toDate.isEmpty()) {

	            LocalDate fromLocalDate = LocalDate.parse(
	                    fromDate,
	                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	            LocalDate toLocalDate = LocalDate.parse(
	                    toDate,
	                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	            startDate = fromLocalDate.atStartOfDay();

	            // Include complete end date till 23:59:59
	            endDate = toLocalDate.plusDays(1).atStartOfDay();

	        } else {

	            // Existing default logic
	            LocalDate today = LocalDate.now();

	            startDate = today.atStartOfDay();
	            endDate = today.plusDays(1).atStartOfDay();
	        }

	        Map<String, Object> responseMap =
	                statueCleaningDashboardDetailsService.getCleaningSummary(
	                        startDate,
	                        endDate);

	        StringBuilder json = new StringBuilder("{");

	        json.append("\"totalCleaned\":")
	            .append(responseMap.get("totalCleaned"))
	            .append(",");

	        json.append("\"firestationWise\":[");

	        List<?> firestationList =
	                (List<?>) responseMap.get("firestationWise");

	        for (Object item : firestationList) {

	            if (item instanceof Map) {

	                Map<?, ?> map = (Map<?, ?>) item;

	                json.append("{");
	                json.append("\"fireStationName\":\"")
	                    .append(map.get("fireStationName"))
	                    .append("\",");

	                json.append("\"cleanedCount\":")
	                    .append(map.get("cleanedCount"));

	                json.append("},");
	            }
	        }

	        if (json.charAt(json.length() - 1) == ',') {
	            json.deleteCharAt(json.length() - 1);
	        }

	        json.append("]");
	        json.append("}");

	        return json.toString();

	    } catch (Exception e) {
	        log.error("Error while fetching cleaning summary", e);

	        return "{\"status\":\"Error\",\"message\":\"Bad Request\"}";
	    }
	}
}
