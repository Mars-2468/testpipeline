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

import com.mars.common.model.PlotType;
import com.mars.common.search.PlotTypeSearch;
import com.mars.common.service.PlotTypeService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: PlotTypeController.java </p>

 * <p>Description: This is a  Plot Type controller class for controlling Plot Type related actions</p>

 * @see com.mars.common.model.PlotType
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class PlotTypeController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(PlotTypeController.class);

    @Autowired
    private PlotTypeService plotTypeService;

    /**
     * @param plotTypeService
     *            sets the PlotTypeService object.
     */
    public void setPlotTypeService(PlotTypeService plotTypeService)
    {
	this.plotTypeService = plotTypeService;
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
     *         PlotType entries to the database.
     */
    @RequestMapping("/plottype/savePlotType.do")
    public ModelAndView savePlotType(HttpServletRequest request, HttpServletResponse response, PlotType plotType) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePlotType");
	}

	if (plotType != null)
	{

	    PlotType plotTypeObj = null;

	    // Check for Duplicate PlotType
	    //TODO: Uncomment if you need to check duplicates and update the query in the PlotTypedaoImpl.checkForDuplicates
	    plotTypeObj = plotTypeService.checkForDuplicates(plotType);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (plotTypeObj != null)
		{
		    session.setAttribute("message", "PlotType with the same name already exists.");
		} else
		{
		    plotTypeService.save(plotType);
		    session.setAttribute("message", "PlotType details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("managePlotType");
	modelandView.addObject("plotType", plotType);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating PlotType entries
     */
    @RequestMapping("/plottype/editPlotType.do")
    public ModelAndView editPlotType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editPlotType");
	}

	PlotType plotType = null;
	String plotTypeId = request.getParameter("plotTypeId");
	if (StringUtils.isNotEmpty(plotTypeId))
	{
	    plotType = plotTypeService.get(Long.parseLong(plotTypeId));
	} else
	{
	    plotType = new PlotType();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("managePlotType", "plotType", plotType);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of PlotType
     */
    @RequestMapping("/plottype/listPlotType.do")
    public ModelAndView listPlotType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listPlotType");
		}
		    PlotTypeSearch searchPlotType=new PlotTypeSearch();
		    setSearchParameters(searchPlotType, request);
			
			List<PlotType> PlotTypeList = plotTypeService.getPlotTypeListBySearch(searchPlotType);
			try
			{
				long totalCount = plotTypeService.getPlotTypeCountBySearch(searchPlotType);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the PlotTypeList is null 		
		if(PlotTypeList==null)
			PlotTypeList = new ArrayList<PlotType>();
			
		    
			request.setAttribute("currentPage", searchPlotType.getCurrentPage());
			request.setAttribute(const_OrderBy, searchPlotType.getOrderBy());
			request.setAttribute(const_SortBy, searchPlotType.getSortBy());	
			request.setAttribute("SearchPlotType", searchPlotType);
		return new ModelAndView("listPlotType","PlotTypeList",PlotTypeList);
    }
    
    /**
     * @param PlotTypeSearch searchPlotType
     * @param request
     */
    private void setSearchParameters(PlotTypeSearch searchPlotType,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on plotTypeId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(description)";
				sortBy = "asc";
			}
			
			searchPlotType.setDescription(request.getParameter("searchDescription"));
			searchPlotType.setCurrentPage(longCurrentPage);
			searchPlotType.setOrderBy(orderBy);
			searchPlotType.setSortBy(sortBy);
    	}catch(Exception err){
    		log.error(err.getMessage());
    	}
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a PlotType
     *         entry from database
     */
    @RequestMapping("/plottype/deletePlotType.do")
    public ModelAndView deletePlotType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deletePlotType");
	}
	String plotTypeId = request.getParameter("plotTypeId");
	if (StringUtils.isNotEmpty(plotTypeId))
	{
	    PlotType plotType = plotTypeService.get(Long.parseLong(plotTypeId));
	    if (plotType != null)
	    {
		try
		{
		    plotTypeService.delete(Long.parseLong(plotTypeId));
		    session.setAttribute("message", "PlotType details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editPlotType(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The PlotType details you are trying to delete is already deleted.");
	    }
	}
	return listPlotType(request, response);
    }
}
