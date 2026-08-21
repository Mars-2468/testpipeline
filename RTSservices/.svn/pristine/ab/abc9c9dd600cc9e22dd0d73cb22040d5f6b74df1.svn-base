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

import com.mars.common.model.Salutation;
import com.mars.common.service.SalutationService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: SalutationController.java </p>

 * <p>Description: This is a  Salutation controller class for controlling Salutation related actions</p>

 * @see com.mars.property.model.Salutation
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class SalutationController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(SalutationController.class);

    @Autowired
    private SalutationService salutationService;

    /**
     * @param salutationService
     *            sets the SalutationService object.
     */
    public void setSalutationService(SalutationService salutationService)
    {
	this.salutationService = salutationService;
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
     *         Salutation entries to the database.
     */
    @RequestMapping("/salutation/saveSalutation.do")
    public ModelAndView saveSalutation(HttpServletRequest request, HttpServletResponse response, Salutation salutation) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveSalutation");
	}

	if (salutation != null)
	{

	    Salutation salutationObj = null;

	    // Check for Duplicate Salutation
	    //TODO: Uncomment if you need to check duplicates and update the query in the SalutationdaoImpl.checkForDuplicates
	    //salutationObj = salutationService.checkForDuplicates(salutation);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (salutationObj != null)
		{
		    session.setAttribute("message", "Salutation with the same name already exists.");
		} else
		{
		    salutationService.save(salutation);
		    session.setAttribute("message", "Salutation details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageSalutation");
	modelandView.addObject("salutation", salutation);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Salutation entries
     */
    @RequestMapping("/salutation/editSalutation.do")
    public ModelAndView editSalutation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editSalutation");
	}

	Salutation salutation = null;
	String salutationId = request.getParameter("salutationId");
	if (StringUtils.isNotEmpty(salutationId))
	{
	    salutation = salutationService.get(Long.parseLong(salutationId));
	} else
	{
	    salutation = new Salutation();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageSalutation", "salutation", salutation);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Salutation
     */
    @RequestMapping("/salutation/listSalutation.do")
    public ModelAndView listSalutation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listSalutation");
		}
			long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on salutationId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "salutationId";
				sortBy = "asc";
			}
			List<Salutation> SalutationList = salutationService.getSalutationList(longCurrentPage,orderBy,sortBy);
			try
			{
				long totalCount = salutationService.getSalutationCount();
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the SalutationList is null 		
		if(SalutationList==null)
			SalutationList = new ArrayList<Salutation>();
			
			request.setAttribute("currentPage", new Long(longCurrentPage));
			request.setAttribute(const_OrderBy, orderBy);
			request.setAttribute(const_SortBy, sortBy);	
		return new ModelAndView("listSalutation","SalutationList",SalutationList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Salutation
     *         entry from database
     */
    @RequestMapping("/salutation/deleteSalutation.do")
    public ModelAndView deleteSalutation(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteSalutation");
	}
	String salutationId = request.getParameter("salutationId");
	if (StringUtils.isNotEmpty(salutationId))
	{
	    Salutation salutation = salutationService.get(Long.parseLong(salutationId));
	    if (salutation != null)
	    {
		try
		{
		    salutationService.delete(Long.parseLong(salutationId));
		    session.setAttribute("message", "Salutation details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editSalutation(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Salutation details you are trying to delete is already deleted.");
	    }
	}
	return listSalutation(request, response);
    }
}
