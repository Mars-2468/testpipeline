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

import com.mars.common.model.Employee;
import com.mars.common.model.User;
import com.mars.common.search.EmployeeSearch;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.DesignationService;
import com.mars.common.service.EmployeeService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;

/**
 * <p>Title: EmployeeController.java </p>

 * <p>Description: This is a  Employee controller class for controlling Employee related actions</p>

 * @see com.mars.common.model.Employee
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class EmployeeController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DesignationService designationService;

    @Autowired
    private DepartmentService departmentService;

    
    @Autowired
    private UserService userService;
    /**
     * @param employeeService
     *            sets the EmployeeService object.
     */
    public void setEmployeeService(EmployeeService employeeService)
    {
	this.employeeService = employeeService;
    }

    /**
     * @param designationService
     *            sets the EmployeeService object.
     */
    
    
    public void setDesignationService(DesignationService designationService)
    {
	this.designationService = designationService;
    }

    public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
     * @param departmentService
     *            sets the EmployeeService object.
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
     *         Employee entries to the database.
     */
    @RequestMapping("/employee/saveEmployee.do")
    public ModelAndView saveEmployee(HttpServletRequest request, HttpServletResponse response, Employee employee) throws ServletException
    {
	HttpSession session = request.getSession();
	SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
    User user=userService.get(sessionUser.getUserId());
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveEmployee");
	}

	if (employee != null)
	{

	    if (employee.getDesignation() != null || (request.getParameter("designationId") != null && request.getParameter("designationId").length() > 0))
	    {
		long designationId = Long.parseLong(request.getParameter("designationId"));
		if (employee.getDesignation() != null && employee.getDesignation().getDesignationId() > 0)
		{
		    designationId = employee.getDesignation().getDesignationId();
		}
		employee.setDesignation(designationService.get(designationId));
	    }

	    if (employee.getDepartment() != null || (request.getParameter("departmentId") != null && request.getParameter("departmentId").length() > 0))
	    {
		long departmentId = Long.parseLong(request.getParameter("departmentId"));
		if (employee.getDepartment() != null && employee.getDepartment().getDepartmentId() > 0)
		{
		    departmentId = employee.getDepartment().getDepartmentId();
		}
		employee.setDepartment(departmentService.get(departmentId));
	    }

	    if (employee.getSuperior() != null || (request.getParameter("superiorId") != null && request.getParameter("superiorId").length() > 0))
	    {
		long superiorId = Long.parseLong(request.getParameter("superiorId"));
		if (employee.getSuperior() != null && employee.getSuperior().getEmployeeId() > 0)
		{
		    superiorId = employee.getSuperior().getEmployeeId();
		}
		employee.setSuperior(employeeService.get(superiorId));
	    }
	    Employee employeeObj = null;

	    // Check for Duplicate Employee
	    //TODO: Uncomment if you need to check duplicates and update the query in the EmployeedaoImpl.checkForDuplicates
	    //employeeObj = employeeService.checkForDuplicates(employee);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (employeeObj != null)
		{
		    session.setAttribute("message", "Employee with the same name already exists.");
		} else
		{
				//employee.setTenancyId(user.getTenancyId());
			
		    employeeService.save(employee);
		    session.setAttribute("message", "Employee details saved successfully");
		}
	    }
	}

	request.setAttribute("designationList", designationService.getAll());

	request.setAttribute("departmentList", departmentService.getAll());
	request.setAttribute("employeeList", employeeService.getAll()); 

	ModelAndView modelandView = new ModelAndView("manageEmployee");
	modelandView.addObject("employee", employee);
	return modelandView;
	/* return editEmployee(request, response); */
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Employee entries
     */
    @RequestMapping("/employee/editEmployee.do")
    public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editEmployee");
	}

	Employee employee = null;
	String employeeId = request.getParameter("employeeId");
	if (StringUtils.isNotEmpty(employeeId))
	{
	    employee = employeeService.get(Long.parseLong(employeeId));
	} else
	{
	    employee = new Employee();
	}

	request.setAttribute("designationList", designationService.getAll());

	request.setAttribute("departmentList", departmentService.getAll());
	request.setAttribute("employeeList", employeeService.getAll()); 
	

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageEmployee", "employee", employee);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Employee
     */
    @RequestMapping("/employee/listEmployee.do")
    public ModelAndView listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listEmployee");
		}
			
			HttpSession session = request.getSession();
			SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
			long userId = sessionUser.getUserId();
			//String applicationId = request.getParameter("applicationId");

			//String userId = request.getParameter("userId");
			String employeeId = request.getParameter("employeeId");

			EmployeeSearch searchOptions = new EmployeeSearch();
			setSearchParameters(searchOptions, request);

			List<Employee> EmployeeList = employeeService.getEmployeeByType(searchOptions);

			try
			{
				long totalCount = employeeService.getEmployeeCountBySearchOption(searchOptions);
				request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
				request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
			    log.error(e.getMessage());
			}
			
		//Check if the EmployeeList is null 		
		if(EmployeeList==null)
			EmployeeList = new ArrayList<Employee>();
		request.setAttribute("currentPage", searchOptions.getCurrentPage());
		request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
		request.setAttribute(const_SortBy, searchOptions.getSortBy());
		request.setAttribute("departmentList", departmentService.getAll());
		request.setAttribute("designationList", designationService.getAll());
		request.setAttribute("employeeList", employeeService.getAll());
		request.setAttribute("SearchOptions", searchOptions);
		return new ModelAndView("listEmployee","EmployeeList",EmployeeList);
    }

    
    private void setSearchParameters(EmployeeSearch searchOptions, HttpServletRequest request) {
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
    	
    	// setting default order by on userName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "employee.employeeId";
    	    sortBy = "asc";
    	}
		
    	try {
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);							
		
			searchOptions.setFirstName(request.getParameter("searchEmployeeFirstName"));
			searchOptions.setLastName(request.getParameter("searchEmployeeLastName"));
			String departmentId=request.getParameter("searchDepartment");
			if(departmentId==null||departmentId=="")departmentId="0";
			searchOptions.setDepartmentId(Long.parseLong(departmentId));
			String designationId=request.getParameter("searchDesignation");
			if(designationId==null||designationId=="")designationId="0";
			searchOptions.setDesignationId(Long.parseLong(designationId));
			
			/*String designationIdValue = request.getParameter("searchEmployeeDesignationId");
			if(designationIdValue != null && designationIdValue.length() > 0)
				searchOptions.setDesignationId(Long.parseLong(designationIdValue));	*/					
		} catch(Exception err) {
			log.error(err.getMessage());
		}
    }
    
    
    
    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Employee
     *         entry from database
     */
    @RequestMapping("/employee/deleteEmployee.do")
    public ModelAndView deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteEmployee");
	}
	String employeeId = request.getParameter("employeeId");
	String designationId = request.getParameter("designationId");
	if (StringUtils.isNotEmpty(employeeId))
	{
	    Employee employee = employeeService.get(Long.parseLong(employeeId));
	    if (employee != null)
	    {
		try
		{
		    employeeService.delete(Long.parseLong(employeeId));
		    session.setAttribute("message", "Employee details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editEmployee(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Employee details you are trying to delete is already deleted.");
	    }
	}
	return listEmployee(request, response);
    }
}
