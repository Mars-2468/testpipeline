package com.mars.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Tenancy;
import com.mars.common.search.TenancySearch;
import com.mars.common.service.TenancyService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;

/**
 * <p>Title: TenancyController.java </p>

 * <p>Description: This is a  Tenancy controller class for controlling Tenancy related actions</p>

 * @see com.mars.common.model.Tenancy
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class TenancyController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(TenancyController.class);

    @Autowired
    private TenancyService tenancyService;

    /**
     * @param tenancyService
     *            sets the TenancyService object.
     */
    public void setTenancyService(TenancyService tenancyService)
    {
	this.tenancyService = tenancyService;
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
     *         Tenancy entries to the database.
     * @throws Exception 
     */
    @RequestMapping("/tenancy/saveTenancy.do")
    public ModelAndView saveTenancy(HttpServletRequest request, HttpServletResponse response, Tenancy tenancy) throws Exception
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveTenancy");
	}

	if (tenancy != null)
	{

	    Tenancy tenancyObj = null;

	    // Check for Duplicate Tenancy
	    //TODO: Uncomment if you need to check duplicates and update the query in the TenancydaoImpl.checkForDuplicates
	    tenancyObj = tenancyService.checkForDuplicates(tenancy);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (tenancyObj != null)
		{
		    session.setAttribute("message", "Tenancy with the same name already exists.");
		} else
		{
		    tenancyService.save(tenancy);
		    session.setAttribute("message", "Tenancy saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageTenancy");
	modelandView.addObject("tenancy", tenancy);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Tenancy entries
     */
    @RequestMapping("/tenancy/editTenancy.do")
    public ModelAndView editTenancy(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editTenancy");
	}

	Tenancy tenancy = null;
	String tenancyId = request.getParameter("tenancyId");
	if (StringUtils.isNotEmpty(tenancyId))
	{
	    tenancy = tenancyService.get(Integer.parseInt(tenancyId));
	} else
	{
	    tenancy = new Tenancy();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageTenancy", "tenancy", tenancy);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Tenancy
     */
    @RequestMapping("/tenancy/listTenancy.do")
    public ModelAndView listTenancy(HttpServletRequest request, HttpServletResponse response) throws ServletException{
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listTenancy");
		}
		    TenancySearch searchTenancy=new TenancySearch(); 
		    setSearchParameters(searchTenancy, request);
						
			List<Tenancy> TenancyList = tenancyService.getTenancyListBySearch(searchTenancy);
			try
			{   
				long totalCount = tenancyService.getTenancyCountBySearch(searchTenancy);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the TenancyList is null 		
		if(TenancyList==null)
			TenancyList = new ArrayList<Tenancy>();
			
			request.setAttribute("currentPage", searchTenancy.getCurrentPage());
			request.setAttribute(const_OrderBy, searchTenancy.getOrderBy());
			request.setAttribute(const_SortBy, searchTenancy.getSortBy());	
			request.setAttribute("searchTenancy", searchTenancy);
		return new ModelAndView("listTenancy","tenancyList",TenancyList);
    }
    
    
    /**
     * 
     * @param searchTenancy
     * @param request
     */
    private void setSearchParameters(TenancySearch searchTenancy, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on tenancyId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "name";
			sortBy = "desc";
		}
		else{
    		orderBy = orderBy.replace("&#40;", "(");
			orderBy = orderBy.replace("&#41;", ")");
			orderBy = orderBy.replace("&#39;", "'");
    	}
        try {
        	searchTenancy.setCurrentPage(longCurrentPage);
        	searchTenancy.setOrderBy(orderBy);
        	searchTenancy.setSortBy(sortBy);          
        	searchTenancy.setName(request.getParameter("searchName"));
        	searchTenancy.setCode(request.getParameter("searchCode"));
        	searchTenancy.setCategory(request.getParameter("searchCategory"));
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
     * @return a ModelAndView to render the response This method deletes a Tenancy
     *         entry from database
     */
    @RequestMapping("/tenancy/deleteTenancy.do")
    public ModelAndView deleteTenancy(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteTenancy");
	}
	String tenancyId = request.getParameter("tenancyId");
	if (StringUtils.isNotEmpty(tenancyId))
	{
	    Tenancy tenancy = tenancyService.get(Integer.parseInt(tenancyId));
	    if (tenancy != null)
	    {
		try
		{
		    tenancyService.delete(Integer.parseInt(tenancyId));
		    session.setAttribute("message", "Tenancy deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editTenancy(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Tenancy details you are trying to delete is already deleted.");
	    }
	}
	return listTenancy(request, response);
    }
    
    
    
    @RequestMapping("/tenancy/selectTenancy.do")
   	public ModelAndView selectTenancy(HttpServletRequest request,
   			HttpServletResponse response) throws ServletException {
   		if (log.isDebugEnabled()) {
   			log.debug("Invoking selectDepartmentMaster");
   		}

   		int tenancyId = 0 ;
   		int superadmintenancy = 0;
   		HttpSession session = request.getSession();
   		Integer id =  (Integer) session.getAttribute("loginTenencyId");
   		
   		if (id != 0) {
   			tenancyId = (Integer) session.getAttribute("loginTenencyId");
   		}

   		if (tenancyId != 0)
   			request.setAttribute("tenancyIdSelected", tenancyId);
   		else
   			request.setAttribute("tenancyIdSelected", 0);

   		request.setAttribute("TenancyList", tenancyService.getAll());
   		SessionUser sessionUser = (SessionUser) session
   				.getAttribute("SessionUser");
   		String roleName = sessionUser.getRoleNames();
   		request.setAttribute("roleName", roleName);

   		String selectedTenancy = request.getParameter("tenancyId");
   		if (roleName.equalsIgnoreCase("Super Admin")) {
   			if (StringUtils.isNotEmpty(selectedTenancy)) {
   				if (!selectedTenancy.equalsIgnoreCase("0"))
   					request.getSession().setAttribute("message",getMessageSourceAccessor().getMessage("tenancy.manage.label.selectTenancy"));
   				request.setAttribute("pageAction", "true");
   			}

   			if (request.getParameter("tenancyId") != null && !request.getParameter("tenancyId").equalsIgnoreCase("0")) 
   			{
   				superadmintenancy =  Integer.parseInt( request.getParameter("tenancyId"));   				
   				session.setAttribute("loginTenencyId", superadmintenancy);
   				session.setAttribute("loginTenentCity",	tenancyService.get(superadmintenancy).getName());
   				SecurityContext sec = SecurityContextHolder.getContext();
   				AbstractAuthenticationToken auth = (AbstractAuthenticationToken)sec.getAuthentication();
   				Tenancy tenancy = tenancyService.get(superadmintenancy);
   				HashMap<String, Object> info = new HashMap<String, Object>();
   				info.put("tenancy", tenancy);
   				auth.setDetails(info);
   				 

   			}
   		}

   		return new ModelAndView("selectTenancy");
   }
}
   /* public List<Tenancy> getTenancy(String strName)
    {
	return tenancyService.getAll();
    }
}
    */