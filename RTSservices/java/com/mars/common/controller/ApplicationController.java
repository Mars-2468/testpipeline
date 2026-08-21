package com.mars.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Application;
import com.mars.common.search.ApplicationSearch;
import com.mars.common.service.ApplicationService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: ApplicationController.java </p>

 * <p>Description: This is a  Application controller class for controlling Application related actions</p>

 * @see com.mars.common.model.Application
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class ApplicationController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    /**
     * @param applicationService
     *            sets the ApplicationService object.
     */
    public void setApplicationService(ApplicationService applicationService)
    {
	this.applicationService = applicationService;
    }

    public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for saving
     *         Application entries to the database.
     */
    @RequestMapping("/application/saveApplication.do")
    public ModelAndView saveApplication(HttpServletRequest request, HttpServletResponse response, Application application) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveApplication");
	}

	if (application != null)
	{

	    Application applicationObj = null;

	    // Check for Duplicate Application
	    //TODO: Uncomment if you need to check duplicates and update the query in the ApplicationdaoImpl.checkForDuplicates
	    applicationObj = applicationService.checkForDuplicates(application);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (applicationObj != null)
		{
		    session.setAttribute("message", "Application with the same name already exists.");
		} else
		{
		    applicationService.save(application);
		    session.setAttribute("message", "Application details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageApplication");
	modelandView.addObject("application", application);
	return modelandView;
    }

    /**
     * 
     * @param request                      
     *            current HTTP request     
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Application entries
     */
    @RequestMapping("/application/editApplication.do")
    public ModelAndView editApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editApplication");
		}
	
		Application application = null;
		String applicationId = request.getParameter("applicationId");
		if (StringUtils.isNotEmpty(applicationId))
		{
		    application = applicationService.get(Long.parseLong(applicationId));
		} else
		{
		    application = new Application();
		}
	
		CommonTokenUtils.setNewToken(request);
		return new ModelAndView("manageApplication", "application", application);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Application
     */
    @RequestMapping("/application/listApplication.do")
    public ModelAndView listApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listApplication");
		}
			
			
			
			  ApplicationSearch searchApplication=new ApplicationSearch(); 
			    setSearchParameters(searchApplication, request);
							
				List<Application> ApplicationList = applicationService.getApplicationListBySearch(searchApplication);
				try
				{   
					long totalCount = applicationService.getApplicationCountBySearch(searchApplication);
			        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			        request.setAttribute("totalCount", totalCount);
				} catch (Exception e)
				{
			    	log.error(e.getMessage());
				}			
			
		//Check if the ApplicationList is null 		
		if(ApplicationList==null)
			ApplicationList = new ArrayList<Application>();
			
		request.setAttribute("currentPage", searchApplication.getCurrentPage());
		request.setAttribute(const_OrderBy, searchApplication.getOrderBy());
		request.setAttribute(const_SortBy, searchApplication.getSortBy());	
		request.setAttribute("SearchApplication", searchApplication);
		return new ModelAndView("listApplication","ApplicationList",ApplicationList);
    }
    

    
    
    
    
    private void setSearchParameters(ApplicationSearch searchApplication, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on bankId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(name)";
			sortBy = "asc";
		}
        try {
        	searchApplication.setCurrentPage(longCurrentPage);
        	searchApplication.setOrderBy(orderBy);
        	searchApplication.setSortBy(sortBy);          
        	searchApplication.setName(request.getParameter("searchName"));
          
        } catch (Exception err) {
          log.error(err.getMessage());
        }
      }
    
    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Application
     *         entry from database
     */
    @RequestMapping("/application/deleteApplication.do")
    public ModelAndView deleteApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteApplication");
	}
	String applicationId = request.getParameter("applicationId");
	if (StringUtils.isNotEmpty(applicationId))
	{
	    Application application = applicationService.get(Long.parseLong(applicationId));
	    if (application != null)
	    {
		try
		{
		    applicationService.delete(Long.parseLong(applicationId));
		    session.setAttribute("message", "Application details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editApplication(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Application details you are trying to delete is already deleted.");
	    }
	}
	return listApplication(request, response);
    }
}

