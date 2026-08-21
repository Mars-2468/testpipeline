package com.mars.common.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.model.UserApplication;
import com.mars.common.model.UserRole;
import com.mars.common.search.RoleSearch;
import com.mars.common.search.UserSearch;
import com.mars.common.service.ApplicationService;
import com.mars.common.service.DepartmentLevelService;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.DesignationService;
import com.mars.common.service.RoleService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserApplicationService;
import com.mars.common.service.UserRoleService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.ObjectDefinitionSourceImpl;
import com.mars.common.utils.SessionUser;
import com.mars.workflow.service.WorkflowService;

/**
 * <p>Title: UserController.java </p>

 * <p>Description: This is a  User controller class for controlling User related actions</p>

 * @see com.mars.common.model.User
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */
@Controller
public class UserController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    @Autowired
    private ObjectDefinitionSourceImpl securityMetadataSource;
    
    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private UserApplicationService userApplicationService; 
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private DesignationService designationService;
    
    @Autowired
    private WorkflowService workflowService;
    
    @Autowired
    private TenancyService tenancyService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Autowired
    private DepartmentLevelService  departmentLevelService;
	
    
    
	public void setWorkflowService(WorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	

	public void setSecurityMetadataSource(
			ObjectDefinitionSourceImpl securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public void setUserApplicationService(UserApplicationService userApplicationService) {
		this.userApplicationService = userApplicationService;
	}

	/**
	 * @return the departmentService
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * @param departmentService the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * @return the designationService
	 */
	public DesignationService getDesignationService() {
		return designationService;
	}

	/**
	 * @param designationService the designationService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

		/** Md5PasswordEncoder */
    /*private Md5PasswordEncoder passwordEncoder;

    *//**
     * @param passwordEncoder
     *            The Md5PasswordEncoder to set
     *//*
    public void setPasswordEncoder(Md5PasswordEncoder passwordEncoder)
    {
	this.passwordEncoder = passwordEncoder;
    }*/
    
 /*private BCryptPasswordEncoder passwordEncoder2;
 

    public BCryptPasswordEncoder getPasswordEncoder2() {
	return passwordEncoder2;
}


public void setPasswordEncoder2(BCryptPasswordEncoder passwordEncoder2) {
	this.passwordEncoder2 = passwordEncoder2;
}*/


	/**
     * @param userService
     *            sets the UserService object.
     */
    public void setUserService(UserService userService)
    {
	this.userService = userService;
    }

    

    public void setTenancyService(TenancyService tenancyService) {
		this.tenancyService = tenancyService;
	}


	public void afterPropertiesSet() throws Exception
    {

    }

    /**
     * This method is to bind the date objects in the specifed format.
     *
     */
    /** protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
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
     *         User entries to the database.
     * @throws Exception 
     */
    @RequestMapping("/user/saveUser.do")
    public ModelAndView saveUser(HttpServletRequest request, HttpServletResponse response, User user) throws Exception
    {
    	try{
		HttpSession session = request.getSession();
		String deleteUserRoleIds = request.getParameter("deleteUserRoleIds");
		List<UserApplication> userApplicationList = new ArrayList<UserApplication>();
		Tenancy tenancy=new Tenancy();
		tenancy.setTenancyId(1);
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveUser");
		}
		int applicationID =0;
		
		if (user != null)
		{
			
			String applicationName = request.getContextPath();
			//if(applicationName.contains(Constants.APPLICATION_NAME))
				applicationID =Constants.APPLICATION_ID;
				user.setStatus(1);
				user.setTenancy(tenancy);
				
			/*if (user.getEmployee() != null || (request.getParameter("employeeId") != null && request.getParameter("employeeId").length() > 0))
		    {
			long mEmpId = Long.parseLong(request.getParameter("employeeId"));
			if (user.getEmployee() != null && user.getEmployee().getEmployeeMasterId() > 0)
			{
			    mEmpId = user.getEmployee().getEmployeeMasterId();
			}
			user.setEmployee(employeeMasterService.get(mEmpId));
		    }*/
			
			/*
			 * if (user.getDesignation() != null || (request.getParameter("designationId")
			 * != null && request.getParameter("designationId").length() > 0)) { long
			 * designationId = Long.parseLong(request.getParameter("designationId")); if
			 * (user.getDesignation() != null && user.getDesignation().getDesignationId() >
			 * 0) { designationId = user.getDesignation().getDesignationId(); }
			 * user.setDesignation(designationService.get(designationId)); }
			 */
			
			if (user.getDepartment() != null || (request.getParameter("departmentId") != null && request.getParameter("departmentId").length() > 0))
		    {
			long departmentId = Long.parseLong(request.getParameter("departmentId"));
			user.setDepartment(departmentService.get(departmentId));
			if (user.getDepartment() != null && user.getDepartment().getDepartmentId() > 0)
			{
				departmentId = user.getDepartment().getDepartmentId();
			}
			user.setDepartment(departmentService.get(departmentId));
		    }
		if (user.getTenancy() != null || (request.getParameter("tenancyId") != null && request.getParameter("tenancyId").length() > 0))
		    {
			long tenancyId = Long.parseLong(request.getParameter("tenancyId"));
			if (user.getTenancy() != null && user.getTenancy().getTenancyId() > 0)
			{
				tenancyId = user.getTenancy().getTenancyId();
			}
			user.setTenancy(tenancyService.get(tenancyId));
		    }
			//String[] applicationIds = CommonRequestUtils.getStringParameters(request,"applicationIds");
			 // Application Id add/delete
			user.setUserApplicationSet(getUserApplicationSet(request,user));
		    // +/- screens
		    user.setUserRoleSet(getUserRoleSet(request,user));

		    User userObj = userService.getByName(user.getUserName(), user.getUserId());
		   if (CommonTokenUtils.allowFormSubmit(request))
		    {
			if (userObj != null) {
				session.setAttribute("errMessage", userObj.getUserName() + " already exists");
			} else {
			    if (user.getUserId() > 0)
			    {
					User dbUser = userService.get(user.getUserId());
					if(!dbUser.getPassword().equals(user.getPassword())){
					    user.setPassword(passwordEncoder.encode(user.getPassword()));    
					}
			    } else {
			    	user.setPassword(passwordEncoder.encode(user.getPassword()));
			    }
			   
			    if(user!=null)
					if(user.getUserId()==0){
						
						//user.setTenancy(user.getTenancy().getTenancyId());
						
						}	
			    userService.save(user,deleteUserRoleIds);
			    securityMetadataSource.refresh();
				
			    user=userService.get(user.getUserId());
			    session.setAttribute("message", "User saved successfully");
			}
		   }
		}
		request.setAttribute("rowsize",user.getUserRoleSet().size());
	    
		request.setAttribute("designationList", designationService.getAll());
		request.setAttribute("departmentList", departmentService.getAll());
	    request.setAttribute("applicationId", applicationID);
		request.setAttribute("roleList",roleService.getAll());		
		request.setAttribute("userApplicationList", userApplicationList);
		request.setAttribute("applicationList", applicationService.getAll());
		request.setAttribute("departmentLevel", departmentLevelService.getAll());

		ModelAndView modelandView = new ModelAndView("manageUser");
		modelandView.addObject("user", user);
    		return modelandView;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    private Set<UserApplication> getUserApplicationSet(HttpServletRequest request, User user) {
    	Set<UserApplication> userApplicationSet = null;
    	String userApplicationIds[] = null;
    	
    	String applicationIds = request.getParameter("applicationIds");
    	String decodedApplicationIds = applicationIds.replaceAll("&#44;", ",");
    	
		userApplicationService.deleteByUserId(user.getUserId(),decodedApplicationIds);
	    if (decodedApplicationIds != null && decodedApplicationIds.length() > 0)
	    {
	    	userApplicationIds = decodedApplicationIds.split(",");
	    }
	    
		if (userApplicationIds != null && userApplicationIds.length > 0)
	    {
			
			long[] userApplicationId = CommonRequestUtils.getLongParameters(request, "userApplicationId");
			long[] applicationId = CommonRequestUtils.getLongParameters(request, "applicationId");
			if (applicationId != null && applicationId.length > 0)
			{
			    int arrayLength = applicationId.length;
			    userApplicationSet = new HashSet<UserApplication>();
			    for (int i = 0; i < arrayLength; i++)
			    {
					if (userApplicationIds != null && userApplicationIds.length > 0)
					{
					    for (String addId : userApplicationIds)
					    {
							if (Long.parseLong(addId) == applicationId[i])
							{
							    
							    UserApplication userApplication = new UserApplication();
							    if(userApplicationId[i]>0)
							    	userApplication.setUserApplicationId(userApplicationId[i]);
								userApplication.setApplication(applicationService.get(applicationId[i]));
								userApplication.setUser(user);
								userApplicationSet.add(userApplication);
								userApplication.setApplication(applicationService.get(Constants.APPLICATION_ID));
							    break;
							}
					    }
					}
					
			    }
			}
		
	    }
		return userApplicationSet;
		
	}

	@SuppressWarnings("deprecation")
    private Set<UserRole> getUserRoleSet(HttpServletRequest request, User user) throws Exception
    {

		Set<UserRole> userRoleSet = null;
		String strDeleteIds[] = null;
		    String deleteUserRoleIds = request.getParameter("deleteUserRoleIds");
		    String decodeddeleteUserRoleIds = deleteUserRoleIds.replaceAll("&#44;", ",");
		    if (decodeddeleteUserRoleIds != null && decodeddeleteUserRoleIds.length() > 0)
		    {
			strDeleteIds = decodeddeleteUserRoleIds.split(",");
		    }
		    long[] userRoleId = CommonRequestUtils.getLongParameters(request, "user.userRoleSet.userRoleId");
		    long[] roleId = CommonRequestUtils.getLongParameters(request, "user.userRoleSet.role");
		  //  String[] userRoleStDate = CommonRequestUtils.getStringParameters(request, "user.userRoleSet.userRoleStDate");
		  //  String[] userRoleEndDate = CommonRequestUtils.getStringParameters(request, "user.userRoleSet.userRoleEndDate");
		 //   int[] isDefault = CommonRequestUtils.getIntParameters(request, "user.userRoleSet.isDefault");
	
		    if (roleId != null && roleId.length > 0)
		    {
			int arrayLength = roleId.length;
			userRoleSet = new HashSet<UserRole>();
			for (int i = 0; i < arrayLength; i++)
			{
			    boolean blndeletedId = false;
			    if (strDeleteIds != null && strDeleteIds.length > 0)
			    {
				for (String deleteId : strDeleteIds)
				{
				    if (Long.parseLong(deleteId) == userRoleId[i])
					blndeletedId = true;
				}
			    }
			    if (!blndeletedId)
			    {
					UserRole userRole = new UserRole();
					userRole.setUserRoleId(userRoleId[i]);
					userRole.setRole(roleService.get(roleId[i]));
					userRole.setUser(user);
					
					String date = CommonRequestUtils.getStringDateParameter(request,"user.userRoleSet.userRoleStDate"+(i+1));
					
					userRole.setUserRoleStDate(date);
					userRole.setUserRoleEndDate(CommonUtils.decodeString(CommonRequestUtils.getStringDateParameter(request,"user.userRoleSet.userRoleEndDate"+(i+1))));
					//userRole.setIsDefault(isDefault[i]);
					userRole.setApplicationId(Constants.APPLICATION_ID);
					userRoleSet.add(userRole);
			
			    }
			}
		    }
		return userRoleSet;
    } 
    
    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating User entries
     */
	@RequestMapping("/user/editUser.do")
    public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editUser");
	}
	int applicationID =0;
	String applicationName = request.getContextPath();
	if(applicationName != null && applicationName.contains(Constants.APPLICATION_NAME))
		applicationID =Constants.APPLICATION_ID;
	
	User user = null;
	String userId = request.getParameter("userId");
	if (userId != null && userId.length() > 0)
	{
	    user = userService.get(Long.parseLong(userId));
	   // request.setAttribute("userApplicationList", userApplicationService.getUserApplicationForUser(Long.parseLong(userId)));
	   
	} else
	{
	    user = new User();
	}
	request.setAttribute("applicationId", applicationID);
	request.setAttribute("rowsize",user.getUserRoleSet().size());
	request.setAttribute("applicationList", applicationService.getAll());
	request.setAttribute("roleList",roleService.getRoleByType(new RoleSearch()));
	request.setAttribute("designationList", designationService.getAll());
	request.setAttribute("departmentList", departmentService.getAll());
	request.setAttribute("departmentLevel", departmentLevelService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageUser", "user", user);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of User
     * @throws Exception 
     */
	@RequestMapping("/user/listUser.do")
    public ModelAndView listUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listUser");
	}

	List<User> UserList =null;
	UserSearch searchOptions = new UserSearch();

		HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
			
		long tenancyId=sessionUser.getTenancyId();
		setSearchParameters(searchOptions, request);
		UserList = userService.getUserByType(searchOptions);
		
		
		long totalCount = userService.getUserCountBySearchOption(searchOptions);
		request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		request.setAttribute("totalCount", totalCount);

	//Check if the UserList is null 		
	if (UserList == null)
	    UserList = new ArrayList<User>();

	request.setAttribute("currentPage", searchOptions.getCurrentPage());
	request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
	request.setAttribute(const_SortBy, searchOptions.getSortBy());
	request.setAttribute("departmentList", departmentService.getAll());
	request.setAttribute("designationList", designationService.getAll());
	request.setAttribute("SearchOptions", searchOptions);

	return new ModelAndView("listUser", "UserList", UserList);
    }
    
    private void setSearchParameters(UserSearch searchOptions, HttpServletRequest request) throws Exception {
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
    	
    	// setting default order by on userName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "user.userName";
    	    sortBy = "asc";
    	}
		
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);							
		
			searchOptions.setUsername(request.getParameter("searchUsername"));
			searchOptions.setFirstName(request.getParameter("searchUserFirstName"));
			searchOptions.setMiddleName(request.getParameter("searchUserMiddleName"));
			searchOptions.setLastName(request.getParameter("searchUserLastName"));	
			//String designationId=request.getParameter("searchDesignation");
			/*if(designationId==null||designationId=="")designationId="0";
			searchOptions.setDesignationId(Long.parseLong(designationId));*/
			
			String applicationName = request.getContextPath();
			if(applicationName.contains(Constants.APPLICATION_NAME))
			{
				searchOptions.setApplicationId(Constants.APPLICATION_ID);
			}}
	/*		String designationIdValue = request.getParameter("searchUserDesignationId");
			if(designationIdValue != null && designationIdValue.length() > 0)
				searchOptions.setDesignationId(Long.parseLong(designationIdValue));							
    }*/

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a User
     *         entry from database
     * @throws Exception 
     */
    @RequestMapping("/user/deleteUser.do")
    public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveUser");
	}
	String userId = request.getParameter("userId");
	if (userId != null && userId.length() > 0)
	{
	    User user = userService.get(Long.parseLong(userId));
	    if (user != null)
	    {
	    try{	
		userService.delete(Long.parseLong(userId));
		securityMetadataSource.refresh();
	    }catch(Exception e){
	    	session.setAttribute("errMessage", "Cannot delete this record as it is used in other page");
    		return editUser(request, response);
	    }
		session.setAttribute("message", "User deleted successfully");
	    }
	}
	return listUser(request, response);
    }
    
    @RequestMapping("/user/myApplications.do")    
    public ModelAndView myApplications(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
    	
    	HttpSession session = request.getSession();
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking myApplications");
		}
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	
		Set<UserApplication> userAppSet = null;
		
		try
		{
			User user = userService.get(sessionUser.getUserId());
			
			userAppSet =  user.getUserApplicationSet();

			long userAppCount = 0;
			userAppCount = userAppSet.size();
			request.setAttribute("userAppCount", userAppCount);
		} catch (Exception e)
		{
		    log.error("Unable to get My Applications",e);
		}

		return new ModelAndView("myApplications", "userAppSet", userAppSet);
    }
    
    @RequestMapping("/user/saveAllJBPMUsers.do")
    public ModelAndView saveAllJBPMUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveAllJBPMUsers");
		}
	
		List<User> UserList = userService.getAll();
	
			//The save method of service will make sure that the latest Users is variable in JBPM Users table.
			for (User user : UserList) {
				workflowService.saveOrUpdateUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail());	
			}
	
		return listUser(request,response);
    }
    
    
}
