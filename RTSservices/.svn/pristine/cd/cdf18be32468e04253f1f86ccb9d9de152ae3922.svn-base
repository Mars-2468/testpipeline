package com.mars.rti.controller;

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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.rti.model.FeeType;
import com.mars.rti.search.FeeTypeSearch;
import com.mars.rti.service.FeeTypeService;

/**
 * <p>Title: FeeTypeController.java </p>

 * <p>Description: This is a  feeType controller class for controlling feeType related actions</p>

 * @see com.mars.common.model.FeeType
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class FeeTypeController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(FeeTypeController.class);

    @Autowired
    private FeeTypeService feeTypeService;


    /**
     * @param feeTypeService
     *            sets the FeeTypeService object.
     */
    public void setFeeTypeService(FeeTypeService feeTypeService)
    {
	this.feeTypeService = feeTypeService;
    }


    public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    @InitBinder
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
     *         FeeType entries to the database.
     */
    @RequestMapping("/feeType/saveFeeType.do")
    public ModelAndView saveFeeType(HttpServletRequest request, HttpServletResponse response, FeeType feeType) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveFeeType");
	}

	if (feeType != null)
	{
	  	    
	    FeeType feeTypeObj = null;

	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		    feeTypeService.save(feeType);
		    session.setAttribute("message", "FeeType details saved successfully");
		}
	    }
	
	
	ModelAndView modelandView = new ModelAndView("manageFeeType");
	modelandView.addObject("feeType", feeType);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating FeeType entries
     */
    @RequestMapping("/feeType/editFeeType.do")
    public ModelAndView editFeeType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editFeeType");
	}

	FeeType feeType = null;
	String feeTypeId = request.getParameter("feeTypeId");
	if (StringUtils.isNotEmpty(feeTypeId))
	{
	    feeType = feeTypeService.get(Long.parseLong(feeTypeId));
	} else
	{
	    feeType = new FeeType();
	}
	
	
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageFeeType", "feeType", feeType);
	
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of FeeType
     */
    @RequestMapping("/feeType/listFeeType.do")
    public ModelAndView listFeeType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listFeeType");
		}
		    FeeTypeSearch searchOptions=new FeeTypeSearch();
		    setSearchParameters(searchOptions, request);
			
			List<FeeType> feeTypeList = feeTypeService.getFeeTypeListBySearch(searchOptions);
			try
			{
				long totalCount = feeTypeService.getFeeTypeCountBySearch(searchOptions);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the FeeTypeList is null 		
		if(feeTypeList==null)
			feeTypeList = new ArrayList<FeeType>();
			
			request.setAttribute("currentPage", searchOptions.getCurrentPage());
			request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
			request.setAttribute(const_SortBy, searchOptions.getSortBy());
			request.setAttribute("searchOptions", searchOptions);
		return new ModelAndView("listFeeType","feeTypeList",feeTypeList);
    }
    
    /**
     * @param FeeTypeSearch searchFeeType
     * @param request
     */
    private void setSearchParameters(FeeTypeSearch searchOptions,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on feeTypeId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);
			
			String searchName = request.getParameter("searchName");
			if (StringUtils.isNotEmpty(searchName)) {
				searchOptions.setName(searchName);
			}
			
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
     * @return a ModelAndView to render the response This method deletes a FeeType
     *         entry from database
     */
    @RequestMapping("/feeType/deleteFeeType.do")
    public ModelAndView deleteFeeType(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteFeeType");
	}
	String feeTypeId = request.getParameter("feeTypeId");
	if (StringUtils.isNotEmpty(feeTypeId))
	{
	    FeeType feeType = feeTypeService.get(Long.parseLong(feeTypeId));
	    if (feeType != null)
	    {
		try
		{
		    feeTypeService.delete(Long.parseLong(feeTypeId));
		    session.setAttribute("message", "FeeType details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editFeeType(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The FeeType details you are trying to delete is already deleted.");
	    }
	}
	return listFeeType(request, response);
    }
}
