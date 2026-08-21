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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Stage;
import com.mars.common.model.User;
import com.mars.common.search.StageSearch;
import com.mars.common.service.StageService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;

/**
 * <p>Title: StageController.java </p>

 * <p>Description: This is a  Stage controller class for controlling Stage related actions</p>

 * @see com.mars.common.model.Stage
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class StageController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(StageController.class);
    
    @Autowired
    private StageService stageService;

    @Autowired
    private UserService userService;

    
    /**
     * @param stageService
     *            sets the StageService object.
     */
    
    
    public void setStageService(StageService stageService)
    {
	this.stageService = stageService;
    }

    public void setUserService(UserService userService) {
		this.userService = userService;
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
     *         Stage entries to the database.
     */
    @RequestMapping("/stage/saveStage.do")
    public ModelAndView saveStage(HttpServletRequest request, HttpServletResponse response, Stage stage) throws ServletException
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
    	
    	 User user=userService.get(sessionUser.getUserId());
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveStage");
	}

	if (stage != null)
	{

	    Stage stageObj = null;

	    // Check for Duplicate Stage
	    //TODO: Uncomment if you need to check duplicates and update the query in the StagedaoImpl.checkForDuplicates
	    stageObj = stageService.checkForDuplicates(stage);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (stageObj != null)
		{
		    session.setAttribute("message", "Stage with the same name already exists.");
		} else
		{
			stage.setTenancyid(user.getTenancy().getTenancyId());

		    stageService.save(stage);
		    session.setAttribute("message", "Stage details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageStage");
	modelandView.addObject("stage", stage);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Stage entries
     */
    @RequestMapping("/stage/editStage.do")
    public ModelAndView editStage(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editStage");
	}

	Stage stage = null;
	String stageId = request.getParameter("stageId");
	if (StringUtils.isNotEmpty(stageId))
	{
	    stage = stageService.get(Long.parseLong(stageId));
	} else
	{
	    stage = new Stage();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageStage", "stage", stage);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Stage
     */
    @RequestMapping("/stage/listStage.do")
    public ModelAndView listStage(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listStage");
		}
		
		    StageSearch searchStage=new StageSearch();
		    setSearchParameters(searchStage, request);
			
			List<Stage> StageList = stageService.getStageListBySearch(searchStage);
			try
			{
				long totalCount = stageService.getStageCountBySearch(searchStage);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the StageList is null 		
		if(StageList==null)
			StageList = new ArrayList<Stage>();
			
			request.setAttribute("currentPage", searchStage.getCurrentPage());
			request.setAttribute(const_OrderBy, searchStage.getOrderBy());
			request.setAttribute(const_SortBy, searchStage.getSortBy());
			request.setAttribute("SearchStage", searchStage);
		return new ModelAndView("listStage","StageList",StageList);
    }
    
    /**
     * @param StageSearch searchStage
     * @param request
     */
    private void setSearchParameters(StageSearch searchStage,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on stageId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(description)";
				sortBy = "asc";
			}
			
			searchStage.setDescription(request.getParameter("searchDescription"));
			searchStage.setCurrentPage(longCurrentPage);
			searchStage.setOrderBy(orderBy);
			searchStage.setSortBy(sortBy);
    	}catch(Exception err){
    		log.debug(err.getMessage());
    	}
    }
    

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Stage
     *         entry from database
     */
    @RequestMapping("/stage/deleteStage.do")
    public ModelAndView deleteStage(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteStage");
	}
	String stageId = request.getParameter("stageId");
	if (StringUtils.isNotEmpty(stageId))
	{
	    Stage stage = stageService.get(Long.parseLong(stageId));
	    if (stage != null)
	    {
		try
		{
		    stageService.delete(Long.parseLong(stageId));
		    session.setAttribute("message", "Stage details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editStage(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Stage details you are trying to delete is already deleted.");
	    }
	}
	return listStage(request, response);
    }
}
