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

import com.mars.common.model.Department;
import com.mars.common.search.DepartmentSearch;
import com.mars.common.service.DepartmentService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: DepartmentController.java </p>

 * <p>Description: This is a  Department controller class for controlling Department related actions</p>

 * @see com.mars.common.model.Department
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DepartmentController extends MultiActionController implements InitializingBean
{


	private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * @param departmentService
     *            sets the DepartmentService object.
     */
    public void setDepartmentService(DepartmentService departmentService)
    {
	this.departmentService = departmentService;
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
     *         Department entries to the database.
     */
    @RequestMapping("/department/saveDepartment.do")
    public ModelAndView saveDepartment(HttpServletRequest request, HttpServletResponse response, Department department) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDepartment");
	}

	if (department != null)
	{

	    Department departmentObj = null;

	    // Check for Duplicate Department
	    //TODO: Uncomment if you need to check duplicates and update the query in the DepartmentdaoImpl.checkForDuplicates
	    departmentObj = departmentService.checkForDuplicates(department);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (departmentObj != null)
		{
		    session.setAttribute("message", "Department with the same name already exists.");
		} else
		{
		    departmentService.save(department);
		    session.setAttribute("message", "Department details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageDepartment");
	modelandView.addObject("department", department);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Department entries
     */
    @RequestMapping("/department/editDepartment.do")
    public ModelAndView editDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDepartment");
	}

	Department department = null;
	String departmentId = request.getParameter("departmentId");
	if (StringUtils.isNotEmpty(departmentId))
	{
	    department = departmentService.get(Long.parseLong(departmentId));
	} else
	{
	    department = new Department();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDepartment", "department", department);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Department
     */
    @RequestMapping("/department/listDepartment.do")
    public ModelAndView listDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDepartment");
		}
			
		DepartmentSearch searchOptions=new DepartmentSearch(); 
		    setSearchParameters(searchOptions, request);
						
			List<Department> DepartmentList = departmentService.getDepartmentListBySearch(searchOptions);
			try
			{   
				long totalCount = departmentService.getDepartmentCountBySearch(searchOptions);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			
		
		//Check if the DepartmentList is null 		
		if(DepartmentList==null)
			DepartmentList = new ArrayList<Department>();
			
		request.setAttribute("currentPage", searchOptions.getCurrentPage());
		request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
		request.setAttribute(const_SortBy, searchOptions.getSortBy());	
		request.setAttribute("SearchOptions", searchOptions);
		return new ModelAndView("listDepartment","DepartmentList",DepartmentList);
    }

    
    private void setSearchParameters(DepartmentSearch searchDepartment, HttpServletRequest request) {
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
        	searchDepartment.setCurrentPage(longCurrentPage);
        	searchDepartment.setOrderBy(orderBy);
        	searchDepartment.setSortBy(sortBy);          
        	searchDepartment.setName(request.getParameter("searchName"));
    		String strStatus = request.getParameter("searchStatus");
    		if (StringUtils.isNotEmpty(strStatus)) {
    			searchDepartment.setStatus(strStatus);
    		}
    		
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
     * @return a ModelAndView to render the response This method deletes a Department
     *         entry from database
     */
    @RequestMapping("/department/deleteDepartment.do")
    public ModelAndView deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDepartment");
	}
	String departmentId = request.getParameter("departmentId");
	if (StringUtils.isNotEmpty(departmentId))
	{
	    Department department = departmentService.get(Long.parseLong(departmentId));
	    if (department != null)
	    {
		try
		{
		    departmentService.delete(Long.parseLong(departmentId));
		    session.setAttribute("message", "Department details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDepartment(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Department details you are trying to delete is already deleted.");
	    }
	}
	return listDepartment(request, response);
    }
}
