package com.mars.rti.controller;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.User;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.DashboardDTO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import com.mars.rti.service.DashBoardService;


@Controller
public class DashBoardController extends MultiActionController implements InitializingBean {

    private static String const_OrderBy = "OrderBy";
    private static String const_SortBy = "SortBy";
    private static Log log = LogFactory.getLog(DashBoardController.class);

    @Autowired private DashBoardService dashBoardService;
    @Autowired private UserService userService;

    private void commonDashBoardLogic(HttpServletRequest request, ModelAndView modelAndView,
            String departments, String services,
            String registrationFromDateStr, String registrationToDateStr) {
    	

        long newReciepts = 0l, rejectedCount = 0l, closedReciepts = 0l,
             approvedReiepts = 0l, pendingReiepts = 0l, allReciepts = 0l;
        double Totalfees = 0l;
        long policeNoc = 0, trafficNoc = 0, fireNoc = 0;

        HttpSession session = request.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
        User user = userService.get(sessionUser.getUserId());
        String userZone = user.getZone();

        String formattedTotalfees = "";
        String currentYear = request.getParameter("year");
        currentYear = (currentYear != null && !currentYear.isEmpty())
                ? currentYear : String.valueOf(Year.now().getValue());

        if ((((registrationFromDateStr != null && registrationFromDateStr.length() > 0)
                && (registrationToDateStr != null && registrationToDateStr.length() > 0))
                || (departments != null && !departments.isEmpty())
                || (services != null && !services.isEmpty()))
                && (currentYear != null && !currentYear.isEmpty())) {

            List<BigInteger> receiptsCountList = dashBoardService.getPieChartOrBarChartBasedOnSearch(
                    registrationFromDateStr, registrationToDateStr, departments, services,
                    userZone, getServiceId(request), currentYear);

            if (receiptsCountList != null && !receiptsCountList.isEmpty()) {
                allReciepts     = receiptsCountList.get(0).longValue();
                newReciepts     = receiptsCountList.get(1).longValue();
                rejectedCount   = receiptsCountList.get(2).longValue();
                closedReciepts  = receiptsCountList.get(3).longValue();
                approvedReiepts = receiptsCountList.get(4).longValue();
                pendingReiepts  = receiptsCountList.get(5).longValue();
                Totalfees       = receiptsCountList.get(6).doubleValue();
                NumberFormat currencyFormatter = NumberFormat.getNumberInstance(new Locale("en", "IN"));
                currencyFormatter.setMaximumFractionDigits(0);
                currencyFormatter.setMinimumFractionDigits(0);
                formattedTotalfees = currencyFormatter.format(Totalfees);
                policeNoc  = receiptsCountList.get(7).longValue();
                trafficNoc = receiptsCountList.get(8).longValue();
                fireNoc    = receiptsCountList.get(9).longValue();
            }
        } else {
            allReciepts     = dashBoardService.getPieChartOrBarChartData(userZone, getServiceId(request), currentYear);
            newReciepts     = dashBoardService.getPieChartOrBarChartData("0", userZone, getServiceId(request), currentYear);
            closedReciepts  = dashBoardService.getPieChartOrBarChartData("1", userZone, getServiceId(request), currentYear);
            approvedReiepts = dashBoardService.getPieChartOrBarChartData("2", userZone, getServiceId(request), currentYear);
            rejectedCount   = dashBoardService.getPieChartOrBarChartData("5", userZone, getServiceId(request), currentYear);
            Totalfees       = dashBoardService.getPieChartOrBarChartDatas(userZone, getServiceId(request), currentYear);
            NumberFormat currencyFormatter = NumberFormat.getNumberInstance(new Locale("en", "IN"));
            currencyFormatter.setMaximumFractionDigits(0);
            currencyFormatter.setMinimumFractionDigits(0);
            formattedTotalfees = currencyFormatter.format(Totalfees);
            pendingReiepts = dashBoardService.getPieChartOrBarChartData("2", "1", "5", userZone, getServiceId(request), currentYear);
            policeNoc  = dashBoardService.getPieChartOrBarChartDataForPoliceNoc(userZone, getServiceId(request), currentYear);
            trafficNoc = dashBoardService.getPieChartOrBarChartDataForTrafficNoc(userZone, getServiceId(request), currentYear);
            fireNoc    = dashBoardService.getPieChartOrBarChartDataForFireNoc(userZone, getServiceId(request), currentYear);
        }

        modelAndView.addObject("newReciepts", newReciepts);
        modelAndView.addObject("closedReciepts", closedReciepts);
        modelAndView.addObject("approvedReiepts", approvedReiepts);
        modelAndView.addObject("pendingReiepts", pendingReiepts);
        modelAndView.addObject("rejectedCount", rejectedCount);
        modelAndView.addObject("Totalfees", formattedTotalfees);
        modelAndView.addObject("allReciepts", allReciepts);
        modelAndView.addObject("registrationFromDate", registrationFromDateStr);
        modelAndView.addObject("registrationToDate", registrationToDateStr);
        modelAndView.addObject("departments", departments);
        modelAndView.addObject("services", services);
        modelAndView.addObject("currentYear", currentYear);
        modelAndView.addObject("policenoc", policeNoc);
        modelAndView.addObject("trafficnoc", trafficNoc);
        modelAndView.addObject("firenoc", fireNoc);
        modelAndView.setViewName("dashboard");
    }

    @RequestMapping("/dashBoard/openDashBoard.do")
    public ModelAndView openDashBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SessionUser sessionUser = getValidSessionUser(request);
        if (sessionUser == null) {
            return new ModelAndView("redirect:/login.do");
        }

        try {
            HttpSession session = request.getSession();

            String departments = request.getParameter("departments");
            String services = request.getParameter("services");
            String fromDate = request.getParameter("registrationFromDate");
            String toDate = request.getParameter("registrationToDate");

            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if (fromDate != null && fromDate.length() > 0 && toDate != null && toDate.length() > 0) {
                try {
                    fromDate = outputDateFormat.format(inputDateFormat.parse(fromDate));
                    toDate = outputDateFormat.format(inputDateFormat.parse(toDate));
                } catch (java.text.ParseException e) {
                    log.error("Date parse error: " + e.getMessage());
                }
            }

            session.setAttribute("lastDepartments", departments);
            session.setAttribute("lastServices", services);
            session.setAttribute("lastFromDate", fromDate);
            session.setAttribute("lastToDate", toDate);

            ModelAndView modelAndView = new ModelAndView();
            commonDashBoardLogic(request, modelAndView, departments, services, fromDate, toDate);
            return modelAndView;

        } catch (Exception e) {
            log.error("Error in openDashBoard: " + e.getMessage(), e);
            return new ModelAndView("redirect:/login.do");
        }
    }
    @RequestMapping("/dashBoard/getListOnCategory.do")
    public ModelAndView getListOnCategory(HttpServletRequest request, HttpServletResponse response) {
        SessionUser sessionUser = getValidSessionUser(request);
        if (sessionUser == null) {
            return new ModelAndView("redirect:/login.do");
        }

        try {
            HttpSession session = request.getSession();

            String receiptSatus = request.getParameter("receiptSatus");
            String searchrtiApplnNumber = request.getParameter("searchrtiApplnNumber");
            searchrtiApplnNumber = (searchrtiApplnNumber != null) ? searchrtiApplnNumber : "";

            String departments = request.getParameter("departments");
            String services = request.getParameter("services");
            String fromDate = request.getParameter("registrationFromDate");
            String toDate = request.getParameter("registrationToDate");

            // NEW: convert yyyy-MM-dd (from the date input) to dd/MM/yyyy,
            // same as openDashBoard does, BEFORE it's used anywhere below.
            if (fromDate != null && fromDate.length() > 0 && toDate != null && toDate.length() > 0) {
                try {
                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    fromDate = outputDateFormat.format(inputDateFormat.parse(fromDate));
                    toDate = outputDateFormat.format(inputDateFormat.parse(toDate));
                } catch (java.text.ParseException e) {
                    log.error("Date parse error in getListOnCategory: " + e.getMessage());
                }
            }

            if (departments == null) departments = (String) session.getAttribute("lastDepartments");
            if (services == null) services = (String) session.getAttribute("lastServices");
            if (fromDate == null) fromDate = (String) session.getAttribute("lastFromDate");
            if (toDate == null) toDate = (String) session.getAttribute("lastToDate");

            session.setAttribute("lastDepartments", departments);
            session.setAttribute("lastServices", services);
            session.setAttribute("lastFromDate", fromDate);
            session.setAttribute("lastToDate", toDate);

      
            ModelAndView modelAndView = new ModelAndView();
            commonDashBoardLogic(request, modelAndView, departments, services, fromDate, toDate);

            User user = userService.get(sessionUser.getUserId());
            String userZone = user.getZone();

            String currentYear = request.getParameter("year");
            currentYear = (currentYear != null && !currentYear.isEmpty())
                    ? currentYear : String.valueOf(Year.now().getValue());

            DashBoardLabelSearch dashBoardLabelSearch = new DashBoardLabelSearch();
            setSearchParameters(dashBoardLabelSearch, request, departments, services, fromDate, toDate);

            List<RTIApplication> rtiList = dashBoardService.getRTIApplicationListByLabel(
                    dashBoardLabelSearch, userZone, getServiceId(request), currentYear, searchrtiApplnNumber);

            try {
                long totalCount = dashBoardService.getRTIApplicationCountByLabel(
                        dashBoardLabelSearch, userZone, getServiceId(request), currentYear, searchrtiApplnNumber);
                request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
                request.setAttribute("totalCount", totalCount);
            } catch (Exception e) {
                log.error(e.getMessage());
            }

            if (rtiList == null || rtiList.isEmpty()) {
                request.setAttribute("noRecordFound", rtiList);
                rtiList = new ArrayList<RTIApplication>();
            }

            request.setAttribute("currentPage", dashBoardLabelSearch.getCurrentPage());
            request.setAttribute(const_OrderBy, dashBoardLabelSearch.getOrderBy());
            request.setAttribute(const_SortBy, dashBoardLabelSearch.getSortBy());
            request.setAttribute("rtiList", rtiList);
            modelAndView.addObject("receiptSatus", receiptSatus);

            List<RTIApplication> rtiListAll = dashBoardService.getRTIApplicationListByLabelAll(
                    dashBoardLabelSearch, userZone, getServiceId(request), currentYear, searchrtiApplnNumber);

            session.setAttribute("lastExportList", rtiListAll);
            session.setAttribute("lastExportDepartments", departments);

            List<DashboardDTO> dto1 = new ArrayList<>();
            for (RTIApplication rs : rtiListAll) {
                DashboardDTO ds = new DashboardDTO();
                ds.setRtiApplnNumber(rs.getRtiApplnNumber());
                ds.setCreatedDate(rs.getCreatedDate());
                ds.setApplicantName(rs.getApplicantName());
                ds.setApplicantName(rs.getSubject());
                ds.setMobileNumber(rs.getMobileNumber());
                ds.setZone(rs.getZone());
                ds.setWorkFlowStatus(rs.getWorkFlowStatus());
                ds.setApplicationCost(rs.getApplicationCost());
                ds.setPdfFilesSavedPath(rs.getPdfFilesSavedPath());
                ds.setWorkflowComments(rs.getWorkflowComments());
                ds.setRtiApplicationRefId(rs.getRtiApplicationRefId());
                ds.setPoliceNoc(rs.getPoliceNoc());
                ds.setTrafficNoc(rs.getTrafficNoc());
                ds.setFireNoc(rs.getFireNoc());
                dto1.add(ds);
            }
            request.setAttribute("rtiList1", dto1);
            return modelAndView;

        } catch (Exception e) {
            log.error("Error in getListOnCategory: " + e.getMessage(), e);
            return new ModelAndView("redirect:/login.do");
        }
    }

    private void setSearchParameters(DashBoardLabelSearch dashBoardLabelSearch, HttpServletRequest request,
            String departments, String services, String registrationFromDateStr, String registrationToDateStr) {
        try {
            long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
            String orderBy = request.getParameter(const_OrderBy);
            String sortBy = request.getParameter(const_SortBy);
            if (orderBy == null || orderBy.length() < 1) {
                orderBy = "date(r.createdDate)";
                sortBy = "desc";
            }
            dashBoardLabelSearch.setCurrentPage(longCurrentPage);
            dashBoardLabelSearch.setOrderBy(orderBy);
            dashBoardLabelSearch.setSortBy(sortBy);
            dashBoardLabelSearch.setDepartments(departments);
            dashBoardLabelSearch.setServices(services);
            dashBoardLabelSearch.setRegistrationFromDate(registrationFromDateStr);
            dashBoardLabelSearch.setRegistrationToDate(registrationToDateStr);

            String receiptSatus = request.getParameter("receiptSatus");
            if (StringUtils.isNotEmpty(receiptSatus)) {
                dashBoardLabelSearch.setReceiptSatus(receiptSatus);
            }
        } catch (Exception err) {
            log.error(err.getMessage());
        }
    }

 
    @RequestMapping("/exportToExcel")
    public void exportToExcel(HttpServletRequest request, HttpServletResponse response) {
        SessionUser sessionUser = getValidSessionUser(request);
        if (sessionUser == null) {
            try {
                response.sendRedirect(request.getContextPath() + "/login.do");
            } catch (Exception ioEx) {
                log.error("Redirect to login failed: " + ioEx.getMessage(), ioEx);
            }
            return;
        }

        try {
            HttpSession session = request.getSession();

            @SuppressWarnings("unchecked")
            List<RTIApplication> rtiList1 = (List<RTIApplication>) session.getAttribute("lastExportList");
            String departmentValues = (String) session.getAttribute("lastExportDepartments");

            if (rtiList1 == null) {
                rtiList1 = new ArrayList<RTIApplication>();
            }

            Workbook workbook = createExcelWorkbook(rtiList1, departmentValues);

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=RTSApplications.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();

        } catch (Exception e) {
            log.error("Error exporting to Excel: " + e.getMessage(), e);
            try {
                response.sendRedirect(request.getContextPath() + "/login.do");
            } catch (Exception ioEx) {
                log.error("Redirect to login failed: " + ioEx.getMessage(), ioEx);
            }
        }
    }
    private Workbook createExcelWorkbook(List<RTIApplication> rtiList1, String departmentValues) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("RTS_Applications");

       
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Sr.No.");
        headerRow.createCell(1).setCellValue("Application Number");
        headerRow.createCell(2).setCellValue("Registration Date");
        headerRow.createCell(3).setCellValue("Applicant Name");
        headerRow.createCell(4).setCellValue("Service Name");
        headerRow.createCell(5).setCellValue("Mobile No.");
        headerRow.createCell(6).setCellValue("Zone No.");
        headerRow.createCell(7).setCellValue("Payment Status");
        headerRow.createCell(8).setCellValue("Amount");
        headerRow.createCell(9).setCellValue("Application Status");
        headerRow.createCell(10).setCellValue("Remark");
        headerRow.createCell(11).setCellValue("Final Certificate");

        if (departmentValues != null && departmentValues.equals("ESTATE-DEPARTMENT")) {
            headerRow.createCell(12).setCellValue("Police NOC");
            headerRow.createCell(13).setCellValue("Traffic NOC");
            headerRow.createCell(14).setCellValue("Fire NOC");
        }

        int rowNum = 1;

        for (RTIApplication rs : rtiList1) {
            DashboardDTO ds = new DashboardDTO();
            ds.setRtiApplnNumber(rs.getRtiApplnNumber());
            ds.setCreatedDate(rs.getCreatedDate());
            ds.setApplicantName(rs.getApplicantName());
            ds.setSubject(rs.getSubject());
            ds.setMobileNumber(rs.getMobileNumber());
            ds.setZone(rs.getZone());
            ds.setWorkFlowStatus(rs.getWorkFlowStatus());
            ds.setApplicationCost(rs.getApplicationCost()); // keep as double, no reassignment/reformat here
            ds.setRtiApplicationRefId(rs.getRtiApplicationRefId());
            ds.setPdfFilesSavedPath(rs.getPdfFilesSavedPath());
            ds.setWorkflowComments(rs.getWorkflowComments());

            if (departmentValues != null && departmentValues.equals("ESTATE-DEPARTMENT")) {
                ds.setPoliceNoc(rs.getPoliceNoc());
                ds.setTrafficNoc(rs.getTrafficNoc());
                ds.setFireNoc(rs.getFireNoc());
            }

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum - 1);
            row.createCell(1).setCellValue(ds.getRtiApplnNumber());
            row.createCell(2).setCellValue(ds.getCreatedDate());
            row.createCell(3).setCellValue(ds.getApplicantName());
            row.createCell(4).setCellValue(ds.getSubject());
            row.createCell(5).setCellValue(ds.getMobileNumber());
            row.createCell(6).setCellValue(ds.getZone());

            int workFlowStatus = rs.getWorkFlowStatus();
            String statusString;
            if (workFlowStatus == 0 || workFlowStatus == 3 || workFlowStatus == 5
                    || workFlowStatus == 9 || workFlowStatus == 10 || workFlowStatus == 11) {
                statusString = "Pending";
            } else if (workFlowStatus == 1 || workFlowStatus == 2) {
                statusString = "Completed";
            } else {
                statusString = "Pending";
            }
            row.createCell(7).setCellValue(statusString);

            String formattedAmount = formatIndianAmount(rs.getApplicationCost());

            row.createCell(8).setCellValue(formattedAmount);
            
            String statusString1;
            if (workFlowStatus == 0) {
                statusString1 = "Citizen Form Submitted.";
            } else if (workFlowStatus == 3) {
                statusString1 = "Pending.";
            } else if (workFlowStatus == 2) {
                statusString1 = "Approved.";
            } else if (workFlowStatus == 1) {
                statusString1 = "Completed.";
            } else if (workFlowStatus == 5) {
                statusString1 = "Rejected.";
            } else if (workFlowStatus == 9) {
                statusString1 = "Under Approval Authority";
            } else if (workFlowStatus == 10) {
                statusString1 = "Under Higher Approval Authority";
            } else if (workFlowStatus == 11) {
                statusString1 = "MTP Inspection completed";
            } else {
                statusString1 = "Unknown";
            }
            row.createCell(9).setCellValue(statusString1);
            row.createCell(10).setCellValue(ds.getWorkflowComments());

            if (ds.getPdfFilesSavedPath() != null && !ds.getPdfFilesSavedPath().isEmpty()) {
                row.createCell(11).setCellValue("Yes");
            } else {
                row.createCell(11).setCellValue("No");
            }

            if (departmentValues != null && departmentValues.equals("ESTATE-DEPARTMENT")) {
                row.createCell(12).setCellValue(
                        ds.getPoliceNoc() != null && !ds.getPoliceNoc().isEmpty() ? "Yes" : "No");
                row.createCell(13).setCellValue(
                        ds.getTrafficNoc() != null && !ds.getTrafficNoc().isEmpty() ? "Yes" : "No");
                row.createCell(14).setCellValue(
                        ds.getFireNoc() != null && !ds.getFireNoc().isEmpty() ? "Yes" : "No");
            }
        }

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }
    
    
public String getServiceId(HttpServletRequest request) {
    	
    	HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		User user = userService.get(sessionUser.getUserId());
		String userZone = user.getZone();
		//String userDept = user.getDepartment();
		long userDept = sessionUser.getDepartmentId();

		String username = user.getUserName();
		String hqlQuery=null;
			if (userZone != null && userZone.length() > 0 && userDept != 1) {
			  
			 hqlQuery = "SELECT DISTINCT ra2.rti_service_id " +
				    "FROM ( " +
				    "    SELECT DISTINCT ra.* " +
				    "    FROM egovrti.rti_application ra " +
				    "    JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name " +
				    "    JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id " +
				    "    JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id " +
				    "    JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id " +
				    "        AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id " +
				    "    WHERE wtumd.user_name = '" + username + "' " +
				    "      AND ra.zone = '" + userZone + "' " +
				    "      AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != ''  " +
				    ") AS temp " +
				    "JOIN egovrti.rti_application ra2 ON ra2.rti_application_id = temp.rti_application_id;";

			
		} else if ((userZone == null || userZone.length() <= 0) && userDept != 1) {	   

			  
			 hqlQuery = "SELECT DISTINCT ra2.rti_service_id " +
				    "FROM ( " +
				    "    SELECT DISTINCT ra.* " +
				    "    FROM egovrti.rti_application ra " +
				    "    JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name " +
				    "    JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id " +
				    "    JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id " +
				    "    JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id " +
				    "        AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id " +
				    "    WHERE wtumd.user_name = '" + username + "' " +
				    "      AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != ''  " +
				    ") AS temp " +
				    "JOIN egovrti.rti_application ra2 ON ra2.rti_application_id = temp.rti_application_id;";

			
		}
			else {
			hqlQuery = "SELECT DISTINCT ra2.rti_service_id " +
				    "FROM ( " +
				    "    SELECT DISTINCT ra.* " +
				    "    FROM egovrti.rti_application ra " +
				    "    WHERE ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " +
				    ") AS temp " +
				    "JOIN egovrti.rti_application ra2 ON ra2.rti_application_id = temp.rti_application_id;";
		}

			List<Object> serviceIdList = dashBoardService.getServiceId(hqlQuery);

			StringBuilder commaSeparatedServiceIds = new StringBuilder();
 if(serviceIdList!=null && serviceIdList.size()>0) {
			for (Object serviceId : serviceIdList) {
			    commaSeparatedServiceIds.append(serviceId.toString()).append(",");
			}

			if (commaSeparatedServiceIds.length() > 0) {
			    commaSeparatedServiceIds.deleteCharAt(commaSeparatedServiceIds.length() - 1);
			}

			String result = commaSeparatedServiceIds.toString();
			
		       
 
    	return result;
 }
 return "0";
    }

@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	
}

/**
 * Returns the logged-in SessionUser, or null if the session has expired/doesn't exist.
 */
private SessionUser getValidSessionUser(HttpServletRequest request) {
    HttpSession session = request.getSession(false); // false = don't create a new one
    if (session == null) {
        return null;
    }
    return (SessionUser) session.getAttribute("SessionUser");
}

/**
 * Formats a numeric amount using Indian digit grouping (lakh/crore),
 * rounded to the whole rupee (HALF_UP), no paise. Mirrors fmtIndianAmount()
 * in the dashboard JSP so Excel export and screen display always match.
 * e.g. 1215927 -> "12,15,927"
 */
private static String formatIndianAmount(double raw) {
    java.math.BigDecimal bd = java.math.BigDecimal.valueOf(raw)
            .setScale(0, java.math.RoundingMode.HALF_UP);
    boolean neg = bd.signum() < 0;
    String intPart = bd.abs().toPlainString();
    String grouped;
    if (intPart.length() <= 3) {
        grouped = intPart;
    } else {
        String last3 = intPart.substring(intPart.length() - 3);
        String rest = intPart.substring(0, intPart.length() - 3);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = rest.length() - 1; i >= 0; i--) {
            sb.append(rest.charAt(i));
            if (++count % 2 == 0 && i != 0) sb.append(',');
        }
        grouped = sb.reverse().toString() + "," + last3;
    }
    return (neg ? "-" : "") + grouped;
}
}
 

