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

import com.mars.common.model.City;
import com.mars.common.model.CityCategory;
import com.mars.common.search.CitySearch;
import com.mars.common.service.CityCategoryService;
import com.mars.common.service.CityService;
import com.mars.common.service.TalukaService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: CityController.java </p>

 * <p>Description: This is a  City controller class for controlling City related actions</p>

 * @see com.mars.common.model.City
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class CityController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(CityController.class);

    @Autowired
    private CityService cityService;

    @Autowired
    private TalukaService talukaService;
    
    @Autowired
    private CityCategoryService cityCategoryService;

    /**
     * @param cityService
     *            sets the CityService object.
     */
    public void setCityService(CityService cityService)
    {
	this.cityService = cityService;
    }

    public CityCategoryService getCityCategoryService() {
		return cityCategoryService;
	}

	public void setCityCategoryService(CityCategoryService cityCategoryService) {
		this.cityCategoryService = cityCategoryService;
	}

	/**
     * @param talukaService
     *            sets the CityService object.
     */
    public void setTalukaService(TalukaService talukaService)
    {
	this.talukaService = talukaService;
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
     *         City entries to the database.
     */
    @RequestMapping("/city/saveCity.do")
    public ModelAndView saveCity(HttpServletRequest request, HttpServletResponse response, City city) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveCity");
	}

	if (city != null)
	{

	    /*if (city.getTaluka() != null || (request.getParameter("talukaId") != null && request.getParameter("talukaId").length() > 0))
	    {
		long talukaId = Long.parseLong(request.getParameter("talukaId"));
		if (city.getTaluka() != null && city.getTaluka().getTalukaId() > 0)
		{
		    talukaId = city.getTaluka().getTalukaId();
		}
		city.setTaluka(talukaService.get(talukaId));
	    }
	    
	    if (city.getCategory() != null || (request.getParameter("categoryId") != null && request.getParameter("categoryId").length() > 0))
	    {
		long categoryId = Long.parseLong(request.getParameter("categoryId"));
		if (city.getCategory() != null && city.getCategory().getCityCategoryId() > 0)
		{
		    categoryId = city.getCategory().getCityCategoryId();
		}
		city.setCategory(cityCategoryService.get(categoryId));
	    }*/
	    
	    
	    City cityObj = null;

	    // Check for Duplicate City
	    //TODO: Uncomment if you need to check duplicates and update the query in the CitydaoImpl.checkForDuplicates
	    cityObj = cityService.checkForDuplicates(city);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (cityObj != null)
		{
		    session.setAttribute("message", "City with the same name already exists.");
		} else
		{
		    cityService.save(city);
		    session.setAttribute("message", "City details saved successfully");
		}
	    }
	}
	List<CityCategory>  ListcityCategory = cityCategoryService.getAll();
	
	request.setAttribute("cityCategoryList",ListcityCategory);
	
	request.setAttribute("talukaList", talukaService.getAll());

	ModelAndView modelandView = new ModelAndView("manageCity");
	modelandView.addObject("city", city);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating City entries
     */
    @RequestMapping("/city/editCity.do")
    public ModelAndView editCity(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editCity");
	}

	City city = null;
	String cityId = request.getParameter("cityId");
	if (StringUtils.isNotEmpty(cityId))
	{
	    city = cityService.get(Long.parseLong(cityId));
	} else
	{
	    city = new City();
	}
	
	List<CityCategory>  ListcityCategory = cityCategoryService.getAll();
	
	request.setAttribute("cityCategoryList",ListcityCategory);
	request.setAttribute("talukaList", talukaService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageCity", "city", city);
	
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of City
     */
    @RequestMapping("/city/listCity.do")
    public ModelAndView listCity(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listCity");
		}
		    CitySearch searchCity=new CitySearch();
		    setSearchParameters(searchCity, request);
			
			List<City> CityList = cityService.getCityListBySearch(searchCity);
			try
			{
				long totalCount = cityService.getCityCountBySearch(searchCity);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the CityList is null 		
		if(CityList==null)
			CityList = new ArrayList<City>();
			
		    request.setAttribute("talukaList", talukaService.getAll());
			request.setAttribute("currentPage", searchCity.getCurrentPage());
			request.setAttribute(const_OrderBy, searchCity.getOrderBy());
			request.setAttribute(const_SortBy, searchCity.getSortBy());
			request.setAttribute("SearchCity", searchCity);
		return new ModelAndView("listCity","CityList",CityList);
    }
    
    /**
     * @param CitySearch searchCity
     * @param request
     */
    private void setSearchParameters(CitySearch searchCity,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on cityId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			if(request.getParameter("searchTalukaId")!=null && request.getParameter("searchTalukaId").length()>0)
				searchCity.setTalukaId(Long.parseLong(request.getParameter("searchTalukaId")));
			searchCity.setName(request.getParameter("searchName"));
			searchCity.setCurrentPage(longCurrentPage);
			searchCity.setOrderBy(orderBy);
			searchCity.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a City
     *         entry from database
     */
    @RequestMapping("/city/deleteCity.do")
    public ModelAndView deleteCity(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteCity");
	}
	String cityId = request.getParameter("cityId");
	if (StringUtils.isNotEmpty(cityId))
	{
	    City city = cityService.get(Long.parseLong(cityId));
	    if (city != null)
	    {
		try
		{
		    cityService.delete(Long.parseLong(cityId));
		    session.setAttribute("message", "City details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editCity(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The City details you are trying to delete is already deleted.");
	    }
	}
	return listCity(request, response);
    }
}
