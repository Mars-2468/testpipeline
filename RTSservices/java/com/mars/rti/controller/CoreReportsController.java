package com.mars.rti.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.service.ReportsService;

/**
 * <p>Title: AccountsController.java </p>

 * <p>Description: This is a a controller to get reports for BND Core</p>

 * Copyright (c) 2009 for eGovernance Goa 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class CoreReportsController extends MultiActionController implements InitializingBean
{
	private static Log log = LogFactory.getLog(CoreReportsController.class);
	
	@Autowired
	private ReportsService reportsService;
	
	public void afterPropertiesSet() throws Exception
	{
	
	}
	
	/**
	 * @param reportsService  sets the ReportsService object.
	 */
	public void setReportsService(ReportsService reportsService)
	{
	this.reportsService = reportsService;
	}
	
	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response 
	 * 
	 */
	@RequestMapping("/corereports/listCoreReports.do")
	public ModelAndView listCoreReports(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listCoreReports");
	}
	List ReportsList = reportsService.getReportListByCategory("RBD");
	request.setAttribute("PAGE_HEADING", "RTI - ");
	request.setAttribute("REPORTS_LIST_PAGE_URL", "/corereports/listCoreReports.do");
	return new ModelAndView("listFormattedReports", "ReportsList", ReportsList);
	}
	
	@RequestMapping("/corereports/listExtraCoreReports.do")
	public ModelAndView listExtraCoreReports(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listCoreReports");
	}
	List ReportsList = reportsService.getReportListByCategory("RBD_OLD");
	request.setAttribute("PAGE_HEADING", "RTI Extra - ");
	request.setAttribute("REPORTS_LIST_PAGE_URL", "/corereports/listExtraCoreReports.do");
	return new ModelAndView("listFormattedReports", "ReportsList", ReportsList);
	}
	
		
}
