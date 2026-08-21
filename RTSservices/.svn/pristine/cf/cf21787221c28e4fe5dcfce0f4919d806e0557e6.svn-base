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

import com.mars.common.model.Taluka;
import com.mars.common.search.TalukaSearch;
import com.mars.common.service.DistrictService;
import com.mars.common.service.TalukaService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: TalukaController.java </p>

 * <p>Description: This is a  Taluka controller class for controlling Taluka related actions</p>

 * @see com.mars.common.model.Taluka
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class TalukaController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(TalukaController.class);

    @Autowired
    private TalukaService talukaService;

    @Autowired
    private DistrictService districtService;

    /**
     * @param talukaService
     *            sets the TalukaService object.
     */
    public void setTalukaService(TalukaService talukaService)
    {
	this.talukaService = talukaService;
    }

    /**
     * @param districtService
     *            sets the TalukaService object.
     */
    public void setDistrictService(DistrictService districtService)
    {
	this.districtService = districtService;
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
     *         Taluka entries to the database.
     */
    @RequestMapping("/taluka/saveTaluka.do")
    public ModelAndView saveTaluka(HttpServletRequest request, HttpServletResponse response, Taluka taluka) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveTaluka");
	}

	if (taluka != null)
	{

	    if (taluka.getDistrict() != null || (request.getParameter("districtId") != null && request.getParameter("districtId").length() > 0))
	    {
		long districtId = Long.parseLong(request.getParameter("districtId"));
		if (taluka.getDistrict() != null && taluka.getDistrict().getDistrictId() > 0)
		{
		    districtId = taluka.getDistrict().getDistrictId();
		}
		taluka.setDistrict(districtService.get(districtId));
	    }
	    Taluka talukaObj = null;

	    // Check for Duplicate Taluka
	    //TODO: Uncomment if you need to check duplicates and update the query in the TalukadaoImpl.checkForDuplicates
	    talukaObj = talukaService.checkForDuplicates(taluka);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (talukaObj != null)
		{
		    session.setAttribute("message", "Taluka with the same name already exists.");
		} else
		{
		    talukaService.save(taluka);
		    session.setAttribute("message", "Taluka details saved successfully");
		}
	    }
	}

	request.setAttribute("districtList", districtService.getAll());

	ModelAndView modelandView = new ModelAndView("manageTaluka");
	modelandView.addObject("taluka", taluka);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Taluka entries
     */
    @RequestMapping("/taluka/editTaluka.do")
    public ModelAndView editTaluka(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editTaluka");
	}

	Taluka taluka = null;
	String talukaId = request.getParameter("talukaId");
	if (StringUtils.isNotEmpty(talukaId))
	{
	    taluka = talukaService.get(Long.parseLong(talukaId));
	} else
	{
	    taluka = new Taluka();
	}

	request.setAttribute("districtList", districtService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageTaluka", "taluka", taluka);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Taluka
     */
    @RequestMapping("/taluka/listTaluka.do")
    public ModelAndView listTaluka(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listTaluka");
		}
		    TalukaSearch searchTaluka=new TalukaSearch();
			setSearchParameters(searchTaluka, request);
			
			
			List<Taluka> TalukaList = talukaService.getTalukaListBySearch(searchTaluka);
			try
			{
				long totalCount = talukaService.getTalukaCountBySearch(searchTaluka);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the TalukaList is null 		
		if(TalukaList==null)
			TalukaList = new ArrayList<Taluka>();
		
		    request.setAttribute("districtList", districtService.getAll());	
			request.setAttribute("currentPage", searchTaluka.getCurrentPage());
			request.setAttribute(const_OrderBy, searchTaluka.getOrderBy());
			request.setAttribute(const_SortBy, searchTaluka.getSortBy());	
			request.setAttribute("SearchTaluka", searchTaluka);
		return new ModelAndView("listTaluka","TalukaList",TalukaList);
    }
    
    /**
     * 
     * @param TalukaSearch searchTaluka
     * @param request
     */
    private void setSearchParameters(TalukaSearch searchTaluka,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);
			
			// setting default order by on talukaId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			searchTaluka.setCurrentPage(longCurrentPage);
			searchTaluka.setOrderBy(orderBy);
			searchTaluka.setSortBy(sortBy);
			searchTaluka.setName(request.getParameter("searchName"));
			if(request.getParameter("searchDistrictId")!=null && request.getParameter("searchDistrictId").length()>0)
				searchTaluka.setDistrictId(Long.parseLong(request.getParameter("searchDistrictId")));
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
     * @return a ModelAndView to render the response This method deletes a Taluka
     *         entry from database
     */
    @RequestMapping("/taluka/deleteTaluka.do")
    public ModelAndView deleteTaluka(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteTaluka");
	}
	String talukaId = request.getParameter("talukaId");
	if (StringUtils.isNotEmpty(talukaId))
	{
	    Taluka taluka = talukaService.get(Long.parseLong(talukaId));
	    if (taluka != null)
	    {
		try
		{
		    talukaService.delete(Long.parseLong(talukaId));
		    session.setAttribute("message", "Taluka details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editTaluka(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Taluka details you are trying to delete is already deleted.");
	    }
	}
	return listTaluka(request, response);
    }
}
