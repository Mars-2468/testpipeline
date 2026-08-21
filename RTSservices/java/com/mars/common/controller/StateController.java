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

import com.mars.common.model.State;
import com.mars.common.search.StateSearch;
import com.mars.common.service.StateService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: StateController.java </p>

 * <p>Description: This is a  State controller class for controlling State related actions</p>

 * @see com.mars.common.model.State
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class StateController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(StateController.class);

    @Autowired
    private StateService stateService;

    /**
     * @param stateService
     *            sets the StateService object.
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
     *         State entries to the database.
     */
    @RequestMapping("/state/saveState.do")
    public ModelAndView saveState(HttpServletRequest request, HttpServletResponse response, State state) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveState");
	}

	if (state != null)
	{

	    State stateObj = null;

	    // Check for Duplicate State
	    //TODO: Uncomment if you need to check duplicates and update the query in the StatedaoImpl.checkForDuplicates
	    stateObj = stateService.checkForDuplicates(state);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (stateObj != null)
		{
		    session.setAttribute("message", "State with the same name already exists.");
		} else
		{
		    stateService.save(state);
		    session.setAttribute("message", "State details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageState");
	modelandView.addObject("state", state);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating State entries
     */
    @RequestMapping("/state/editState.do")
    public ModelAndView editState(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editState");
	}

	State state = null;
	String stateId = request.getParameter("stateId");
	if (StringUtils.isNotEmpty(stateId))
	{
	    state = stateService.get(Long.parseLong(stateId));
	} else
	{
	    state = new State();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageState", "state", state);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of State
     */
    @RequestMapping("/state/listState.do")
    public ModelAndView listState(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listState");
		}
		
		    StateSearch searchState=new StateSearch();
			setSearchParameters(searchState, request);	
			
			
			List<State> StateList = stateService.getStateListBySearch(searchState);
			try
			{
				long totalCount = stateService.getStateCountBySearch(searchState);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the StateList is null 		
		if(StateList==null)
			StateList = new ArrayList<State>();
			
			request.setAttribute("currentPage", searchState.getCurrentPage());
			request.setAttribute(const_OrderBy, searchState.getOrderBy());
			request.setAttribute(const_SortBy, searchState.getSortBy());
			request.setAttribute("SearchState", searchState);
		return new ModelAndView("listState","StateList",StateList);
    }
    
    /**
     * 
     * @param searchState
     * @param request
     */
    private void setSearchParameters(StateSearch searchState, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on StateId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(name)";
			sortBy = "asc";
		}
        try {
        	searchState.setCurrentPage(longCurrentPage);
        	searchState.setOrderBy(orderBy);
        	searchState.setSortBy(sortBy);          
        	searchState.setName(request.getParameter("searchName"));
          
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
     * @return a ModelAndView to render the response This method deletes a State
     *         entry from database
     */
    @RequestMapping("/state/deleteState.do")
    public ModelAndView deleteState(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteState");
	}
	String stateId = request.getParameter("stateId");
	if (StringUtils.isNotEmpty(stateId))
	{
	    State state = stateService.get(Long.parseLong(stateId));
	    if (state != null)
	    {
		try
		{
		    stateService.delete(Long.parseLong(stateId));
		    session.setAttribute("message", "State details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editState(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The State details you are trying to delete is already deleted.");
	    }
	}
	return listState(request, response);
    }
}
