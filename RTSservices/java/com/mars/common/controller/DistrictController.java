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

import com.mars.common.model.District;
import com.mars.common.search.DistrictSearch;
import com.mars.common.service.DistrictService;
import com.mars.common.service.StateService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: DistrictController.java </p>

 * <p>Description: This is a  District controller class for controlling District related actions</p>

 * @see com.mars.common.model.District
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DistrictController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DistrictController.class);
    
    @Autowired
    private DistrictService districtService;

    @Autowired
    private StateService stateService;

    /**
     * @param districtService
     *            sets the DistrictService object.
     */
    public void setDistrictService(DistrictService districtService)
    {
	this.districtService = districtService;
    }

    /**
     * @param stateService
     *            sets the DistrictService object.
     */
    public void setStateService(StateService stateService)
    {
	this.stateService = stateService;
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
     *         District entries to the database.
     */
    @RequestMapping("/district/saveDistrict.do")
    public ModelAndView saveDistrict(HttpServletRequest request, HttpServletResponse response, District district) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDistrict");
	}

	if (district != null)
	{

	    if (district.getState() != null || (request.getParameter("stateId") != null && request.getParameter("stateId").length() > 0))
	    {
		long stateId = Long.parseLong(request.getParameter("stateId"));
		if (district.getState() != null && district.getState().getStateId() > 0)
		{
		    stateId = district.getState().getStateId();
		}
		district.setState(stateService.get(stateId));
	    }
	    District districtObj = null;

	    // Check for Duplicate District
	    //TODO: Uncomment if you need to check duplicates and update the query in the DistrictdaoImpl.checkForDuplicates
	    districtObj = districtService.checkForDuplicates(district);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (districtObj != null)
		{
		    session.setAttribute("message", "District with the same name already exists.");
		} else
		{
		    districtService.save(district);
		    session.setAttribute("message", "District details saved successfully");
		}
	    }
	}

	request.setAttribute("stateList", stateService.getAll());

	ModelAndView modelandView = new ModelAndView("manageDistrict");
	modelandView.addObject("district", district);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating District entries
     */
    @RequestMapping("/district/editDistrict.do")
    public ModelAndView editDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDistrict");
	}

	District district = null;
	String districtId = request.getParameter("districtId");
	if (StringUtils.isNotEmpty(districtId))
	{
	    district = districtService.get(Long.parseLong(districtId));
	} else
	{
	    district = new District();
	}

	request.setAttribute("stateList", stateService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDistrict", "district", district);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of District
     */
    @RequestMapping("/district/listDistrict.do")
    public ModelAndView listDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDistrict");
		}
		    DistrictSearch searchDistrict=new DistrictSearch(); 
			setSearchParameters(searchDistrict, request);	
			
			
			List<District> DistrictList = districtService.getDistrictListBySearch(searchDistrict);
			try
			{
				long totalCount = districtService.getDistrictCountBySearch(searchDistrict);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the DistrictList is null 		
		if(DistrictList==null)
			DistrictList = new ArrayList<District>();
			
		    request.setAttribute("stateList", stateService.getAll());
			request.setAttribute("currentPage", searchDistrict.getCurrentPage());
			request.setAttribute(const_OrderBy, searchDistrict.getOrderBy());
			request.setAttribute(const_SortBy, searchDistrict.getSortBy());
			request.setAttribute("SearchDistrict", searchDistrict);
		return new ModelAndView("listDistrict","DistrictList",DistrictList);
    }
    
    /**
     * 
     * @param DistrictSearch searchDistrict
     * @param request
     */
    private void setSearchParameters(DistrictSearch searchDistrict, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on districtId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(name)";
			sortBy = "asc";
		}
		    try{        
        	if(request.getParameter("searchStateId")!=null && request.getParameter("searchStateId").length()>0)
        		searchDistrict.setStateId(Long.parseLong(request.getParameter("searchStateId")));
        	searchDistrict.setName(request.getParameter("searchName"));
        	searchDistrict.setCurrentPage(longCurrentPage);
        	searchDistrict.setOrderBy(orderBy);
        	searchDistrict.setSortBy(sortBy);          
        	
          
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
     * @return a ModelAndView to render the response This method deletes a District
     *         entry from database
     */
    @RequestMapping("/district/deleteDistrict.do")
    public ModelAndView deleteDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDistrict");
	}
	String districtId = request.getParameter("districtId");
	if (StringUtils.isNotEmpty(districtId))
	{
	    District district = districtService.get(Long.parseLong(districtId));
	    if (district != null)
	    {
		try
		{
		    districtService.delete(Long.parseLong(districtId));
		    session.setAttribute("message", "District details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDistrict(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The District details you are trying to delete is already deleted.");
	    }
	}
	return listDistrict(request, response);
    }
}
