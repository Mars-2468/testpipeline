package com.mars.rti.ws.controller;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.ws.model.DashboardStatsDTO;
import com.mars.rti.ws.model.DashboardStatsDetailsDTO;
import com.mars.rti.service.DashboardDetailsService;

@Controller
public class DashboardDetailsController {

    @Autowired
    private DashboardDetailsService dashboardService;

    @RequestMapping(method = RequestMethod.GET, value = "/getDashboardStats")
    public @ResponseBody DashboardStatsDTO getDashboardStats(
            @RequestParam(value = "fromDate", required = false) String fromDate,
            @RequestParam(value = "toDate", required = false) String toDate,
            HttpServletResponse response) throws ServletException {

        DashboardStatsDTO dashboardStatsDTO = new DashboardStatsDTO();

        try {

            String startDateStr = "";
            String endDateStr = "";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Custom date range
            if (fromDate != null && !fromDate.isEmpty()
                    && toDate != null && !toDate.isEmpty()) {

                startDateStr = fromDate;
                endDateStr = toDate;

            } else {

                // Default running financial year
                LocalDate today = LocalDate.now();

                int financialYearStart;

                if (today.getMonthValue() >= 4) {
                    financialYearStart = today.getYear();
                } else {
                    financialYearStart = today.getYear() - 1;
                }

                LocalDate startDate = LocalDate.of(financialYearStart, 4, 1);
                LocalDate endDate = LocalDate.of(financialYearStart + 1, 3, 31);

                startDateStr = startDate.format(formatter);
                endDateStr = endDate.format(formatter);
            }

            dashboardStatsDTO = dashboardService.getDashboardStats(
                    startDateStr, endDateStr);

            dashboardStatsDTO.setStartDate(startDateStr);
            dashboardStatsDTO.setEndDate(endDateStr);
            dashboardStatsDTO.setDepartment("RTS Department");
            dashboardStatsDTO.setResponseCode(200);
            dashboardStatsDTO.setStatus("Ok");
            dashboardStatsDTO.setResponse("Success");

        } catch (Exception ex) {
            ex.printStackTrace();
            dashboardStatsDTO.setResponseCode(405);
            dashboardStatsDTO.setStatus("Error");
            dashboardStatsDTO.setResponse("Bad Request");
        }

        return dashboardStatsDTO;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getRTSDashboardDetailsServiceWise")
    public @ResponseBody Map<String, Object> getRTSDashboardDetailsServiceWise(
            @RequestParam(value = "fromDate", required = false) String fromDate,
            @RequestParam(value = "toDate", required = false) String toDate,
            HttpServletResponse response) throws ServletException {

        Map<String, Object> result = new HashMap<>();

        try {

            String startDateStr = "";
            String endDateStr = "";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Use custom date range if provided
            if (fromDate != null && !fromDate.isEmpty()
                    && toDate != null && !toDate.isEmpty()) {

                startDateStr = fromDate;
                endDateStr = toDate;

            } else {

                // Default current financial year logic
                LocalDate today = LocalDate.now();

                int financialYearStart;

                if (today.getMonthValue() >= 4) {
                    financialYearStart = today.getYear();
                } else {
                    financialYearStart = today.getYear() - 1;
                }

                LocalDate startDate =
                        LocalDate.of(financialYearStart, 4, 1);

                LocalDate endDate =
                        LocalDate.of(financialYearStart + 1, 3, 31);

                startDateStr = startDate.format(formatter);
                endDateStr = endDate.format(formatter);
            }

            List<DashboardStatsDetailsDTO> zoneList =
                    dashboardService.getRTSDashboardDetailsServiceWise(
                            startDateStr,
                            endDateStr);

            result.put("department", "RTS Department");
            result.put("startDate", startDateStr);
            result.put("endDate", endDateStr);
            result.put("details", zoneList);
            result.put("responseCode", 200);
            result.put("status", "Ok");
            result.put("response", "Success");

        } catch (Exception ex) {

            ex.printStackTrace();

            result.put("responseCode", 405);
            result.put("status", "Error");
            result.put("response", "Bad Request");
        }

        return result;
    }

}
