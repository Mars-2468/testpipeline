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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Dictionary;
import com.mars.common.service.DictionaryService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: DictionaryController.java </p>

 * <p>Description: This is a  Dictionary controller class for controlling Dictionary related actions</p>

 * @see com.mars.property.model.Dictionary
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DictionaryController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * @param dictionaryService
     *            sets the DictionaryService object.
     */
    public void setDictionaryService(DictionaryService dictionaryService)
    {
	this.dictionaryService = dictionaryService;
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
     *         Dictionary entries to the database.
     */
   
    public ModelAndView saveDictionary(HttpServletRequest request, HttpServletResponse response, Dictionary dictionary) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDictionary");
	}

	if (dictionary != null)
	{

	    Dictionary dictionaryObj = null;

	    // Check for Duplicate Dictionary
	    //TODO: Uncomment if you need to check duplicates and update the query in the DictionarydaoImpl.checkForDuplicates
	    //dictionaryObj = dictionaryService.checkForDuplicates(dictionary);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (dictionaryObj != null)
		{
		    session.setAttribute("message", "Dictionary with the same name already exists.");
		} else
		{
		    dictionaryService.save(dictionary);
		    session.setAttribute("message", "Dictionary details saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageDictionary");
	modelandView.addObject("dictionary", dictionary);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Dictionary entries
     */

    public ModelAndView editDictionary(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDictionary");
	}

	Dictionary dictionary = null;
	String dictionaryId = request.getParameter("dictionaryId");
	if (StringUtils.isNotEmpty(dictionaryId))
	{
	    dictionary = dictionaryService.get(Long.parseLong(dictionaryId));
	} else
	{
	    dictionary = new Dictionary();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDictionary", "dictionary", dictionary);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Dictionary
     */

    public ModelAndView listDictionary(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDictionary");
		}
			long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on dictionaryId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "dictionaryId";
				sortBy = "asc";
			}
			List<Dictionary> DictionaryList = dictionaryService.getDictionaryList(longCurrentPage,orderBy,sortBy);
			try
			{
				long totalCount = dictionaryService.getDictionaryCount();
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the DictionaryList is null 		
		if(DictionaryList==null)
			DictionaryList = new ArrayList<Dictionary>();
			
			request.setAttribute("currentPage", new Long(longCurrentPage));
			request.setAttribute(const_OrderBy, orderBy);
			request.setAttribute(const_SortBy, sortBy);	
		return new ModelAndView("listDictionary","DictionaryList",DictionaryList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Dictionary
     *         entry from database
     */

    public ModelAndView deleteDictionary(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDictionary");
	}
	String dictionaryId = request.getParameter("dictionaryId");
	if (StringUtils.isNotEmpty(dictionaryId))
	{
	    Dictionary dictionary = dictionaryService.get(Long.parseLong(dictionaryId));
	    if (dictionary != null)
	    {
		try
		{
		    dictionaryService.delete(Long.parseLong(dictionaryId));
		    session.setAttribute("message", "Dictionary details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDictionary(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Dictionary details you are trying to delete is already deleted.");
	    }
	}
	return listDictionary(request, response);
    }
    
	public String getValue(String key) {
		
		return dictionaryService.getValueByKey(key);
	}
}
