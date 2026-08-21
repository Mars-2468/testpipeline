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

import com.mars.common.model.Designation;
import com.mars.common.search.DesignationSearch;
import com.mars.common.service.DesignationService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: DesignationController.java </p>

 * <p>Description: This is a  Designation controller class for controlling Designation related actions</p>

 * @see com.mars.common.model.Designation
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DesignationController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DesignationController.class);

    @Autowired
    private DesignationService designationService;

    /**
     * @param designationService
     *            sets the DesignationService object.
     */
    public void setDesignationService(DesignationService designationService)
    {
	this.designationService = designationService;
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
     *         Designation entries to the database.
     */
    @RequestMapping("/designation/saveDesignation.do")
    public ModelAndView saveDesignation(HttpServletRequest request, HttpServletResponse response, Designation designation) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDesignation");
	}

	if (designation != null)
	{

	    Designation designationObj = null;

	    // Check for Duplicate Designation
	    //TODO: Uncomment if you need to check duplicates and update the query in the DesignationdaoImpl.checkForDuplicates
	    designationObj = designationService.checkForDuplicates(designation);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (designationObj != null)
		{
		    session.setAttribute("message", "Designation with the same name already exists.");
		} else
		{
			
		    designationService.save(designation);
		    session.setAttribute("message", "Designation details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageDesignation");
	modelandView.addObject("designation", designation);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Designation entries
     */
    @RequestMapping("/designation/editDesignation.do")
    public ModelAndView editDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDesignation");
	}

	Designation designation = null;
	String designationId = request.getParameter("designationId");
	if (StringUtils.isNotEmpty(designationId))
	{
	    designation = designationService.get(Long.parseLong(designationId));
	} else
	{
	    designation = new Designation();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDesignation", "designation", designation);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Designation
     */
    @RequestMapping("/designation/listDesignation.do")
    public ModelAndView listDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDesignation");
		}

		DesignationSearch searchDesignation=new DesignationSearch(); 
		    setSearchParameters(searchDesignation, request);
						
			List<Designation> DesignationList = designationService.getDesignationListBySearch(searchDesignation);
			try
			{   
				long totalCount = designationService.getDesignationCountBySearch(searchDesignation);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}	
			
		//Check if the DesignationList is null 		
		if(DesignationList==null)
			DesignationList = new ArrayList<Designation>();
			
		request.setAttribute("currentPage", searchDesignation.getCurrentPage());
		request.setAttribute(const_OrderBy, searchDesignation.getOrderBy());
		request.setAttribute(const_SortBy, searchDesignation.getSortBy());	
		request.setAttribute("SearchApplication", searchDesignation);
		return new ModelAndView("listDesignation","DesignationList",DesignationList);
    }

    private void setSearchParameters(DesignationSearch searchDesignation, HttpServletRequest request) {
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
        	searchDesignation.setCurrentPage(longCurrentPage);
        	searchDesignation.setOrderBy(orderBy);
        	searchDesignation.setSortBy(sortBy);          
        	searchDesignation.setName(request.getParameter("searchName"));
          
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
     * @return a ModelAndView to render the response This method deletes a Designation
     *         entry from database
     */
    @RequestMapping("/designation/deleteDesignation.do")
    public ModelAndView deleteDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDesignation");
	}
	String designationId = request.getParameter("designationId");
	if (StringUtils.isNotEmpty(designationId))
	{
	    Designation designation = designationService.get(Long.parseLong(designationId));
	    if (designation != null)
	    {
		try
		{
		    designationService.delete(Long.parseLong(designationId));
		    session.setAttribute("message", "Designation details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDesignation(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Designation details you are trying to delete is already deleted.");
	    }
	}
	return listDesignation(request, response);
    }
}
