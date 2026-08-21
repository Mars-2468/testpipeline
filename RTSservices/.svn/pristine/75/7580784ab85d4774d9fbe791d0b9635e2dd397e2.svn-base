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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.service.DepartmentService;
import com.mars.common.service.SectionService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.rti.model.FeeMaster;
import com.mars.rti.search.FeeMasterSearch;
import com.mars.rti.service.FeeMasterService;
import com.mars.rti.service.FeeTypeService;

/**
 * <p>Title: FeeMasterController.java </p>

 * <p>Description: This is a  feeMaster controller class for controlling feeMaster related actions</p>

 * @see com.mars.common.model.FeeMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class FeeMasterController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(FeeMasterController.class);

    @Autowired
    private FeeMasterService feeMasterService;

    @Autowired
    private FeeTypeService feeTypeService;

    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private SectionService sectionService;

    /**
     * @param feeMasterService
     *            sets the FeeMasterService object.
     */
    public void setFeeMasterService(FeeMasterService feeMasterService)
    {
	this.feeMasterService = feeMasterService;
    }

    public void setFeeTypeService(FeeTypeService feeTypeService) {
		this.feeTypeService = feeTypeService;
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
     *         FeeMaster entries to the database.
     */
    @RequestMapping("/feemaster/saveFeeMaster.do")
    public ModelAndView saveFeeMaster(HttpServletRequest request, HttpServletResponse response, FeeMaster feeMaster) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveFeeMaster");
	}
	ModelAndView modelandView = new ModelAndView("manageFeeMaster");
	if (feeMaster != null)
	{
	  	    
	    FeeMaster feeMasterObj = null;
        List list=null;;
	    // Check for Duplicate FeeMaster
	    if(feeMaster.getFeeMasterId()<0){
	    	  list = feeMasterService.checkForDuplicates(feeMaster);
	    }
	   
	    
	    if(list!=null && list.size()>0){
	    
	    	 session.setAttribute("message", "Entered Dates are already available!");
	    	 modelandView.addObject("feeMaster", feeMaster);
	    	return modelandView;
	    }
	    
	    else if (CommonTokenUtils.allowFormSubmit(request))
	    {
	    	
		    feeMasterService.save(feeMaster);
		    modelandView.addObject("feeMaster", new FeeMaster());
		    session.setAttribute("message", "FeeMaster details saved successfully");
		}
	    }
	
	
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating FeeMaster entries
     */
    @RequestMapping("/feemaster/editFeeMaster.do")
    public ModelAndView editFeeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editFeeMaster");
	}

	FeeMaster feeMaster = null;
	String feeMasterId = request.getParameter("feeMasterId");
	if (StringUtils.isNotEmpty(feeMasterId))
	{
	    feeMaster = feeMasterService.get(Long.parseLong(feeMasterId));
	} else
	{
	    feeMaster = new FeeMaster();
	}
	
	request.setAttribute("feeTypeList", feeTypeService.getAll());
	request.setAttribute("departmentList", departmentService.getAll());
	request.setAttribute("sectionList", sectionService.getAll());
	request.setAttribute("userList", userService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageFeeMaster", "feeMaster", feeMaster);
	
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of FeeMaster
     */
    @RequestMapping("/feemaster/listFeeMaster.do")
    public ModelAndView listFeeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listFeeMaster");
		}
		    FeeMasterSearch searchFeeMaster=new FeeMasterSearch();
		    setSearchParameters(searchFeeMaster, request);
			System.out.println("list fee master controller");
			List<FeeMaster> feeMasterList = feeMasterService.getFeeMasterListBySearch(searchFeeMaster);
			try
			{
				long totalCount = feeMasterService.getFeeMasterCountBySearch(searchFeeMaster);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the FeeMasterList is null 		
		if(feeMasterList==null)
			feeMasterList = new ArrayList<FeeMaster>();
			
			request.setAttribute("currentPage", searchFeeMaster.getCurrentPage());
			request.setAttribute(const_OrderBy, searchFeeMaster.getOrderBy());
			request.setAttribute(const_SortBy, searchFeeMaster.getSortBy());
			request.setAttribute("SearchFeeMaster", searchFeeMaster);
		return new ModelAndView("listFeeMaster","feeMasterList",feeMasterList);
    }
    
    /**
     * @param FeeMasterSearch searchFeeMaster
     * @param request
     */
    private void setSearchParameters(FeeMasterSearch searchFeeMaster,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on feeMasterId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			
			searchFeeMaster.setCurrentPage(longCurrentPage);
			searchFeeMaster.setOrderBy(orderBy);
			searchFeeMaster.setSortBy(sortBy);
			
			
			String name = request.getParameter("name");
			if (StringUtils.isNotEmpty(name)) {
				searchFeeMaster.setName(name);
			}
			
			
			String category = request.getParameter("category");
			if (StringUtils.isNotEmpty(category)) {
				searchFeeMaster.setCategory(Integer.parseInt(category));
			}
			
			
			String fromDate = CommonRequestUtils.getStringParameter(request, "fromDate");
            String toDate = CommonRequestUtils.getStringParameter(request, "toDate");
    	      
			if((toDate != null && toDate.length() > 0))
			{
				searchFeeMaster.setToDate(toDate);
			}
			
			if((fromDate != null && fromDate.length() > 0))
			{
				searchFeeMaster.setFromDate(fromDate);
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
     * @return a ModelAndView to render the response This method deletes a FeeMaster
     *         entry from database
     */
    @RequestMapping("/feemaster/deleteFeeMaster.do")
    public ModelAndView deleteFeeMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteFeeMaster");
	}
	String feeMasterId = request.getParameter("feeMasterId");
	if (StringUtils.isNotEmpty(feeMasterId))
	{
	    FeeMaster feeMaster = feeMasterService.get(Long.parseLong(feeMasterId));
	    if (feeMaster != null)
	    {
		try
		{
		    feeMasterService.delete(Long.parseLong(feeMasterId));
		    session.setAttribute("message", "FeeMaster details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editFeeMaster(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The FeeMaster details you are trying to delete is already deleted.");
	    }
	}
	return listFeeMaster(request, response);
    }
}
