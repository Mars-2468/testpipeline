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

import com.mars.common.model.DocumentMaster;
import com.mars.common.model.User;
import com.mars.common.search.DocumentMasterSearch;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.StageService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;

/**
 * <p>Title: DocumentMasterController.java </p>

 * <p>Description: This is a  DocumentMaster controller class for controlling DocumentMaster related actions</p>

 * @see com.mars.common.model.DocumentMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DocumentMasterController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DocumentMasterController.class);
    
    @Autowired
    private DocumentMasterService documentMasterService;
    
    @Autowired
    private StageService stageService;

    
    @Autowired
    private UserService userService;
    /**
     * @param documentMasterService
     *            sets the DocumentMasterService object.
     */
    
    
    
    public void setDocumentMasterService(DocumentMasterService documentMasterService)
    {
	this.documentMasterService = documentMasterService;
    }

    public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
     * @param stageService
     *            sets the DocumentMasterService object.
     */
    public void setStageService(StageService stageService)
    {
	this.stageService = stageService;
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
     *         DocumentMaster entries to the database.
     */
    @RequestMapping("/documentmaster/saveDocumentMaster.do")
    public ModelAndView saveDocumentMaster(HttpServletRequest request, HttpServletResponse response, DocumentMaster documentMaster) throws ServletException
    {
    	HttpSession session = request.getSession();
    	SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
    	
    	 User user=userService.get(sessionUser.getUserId());
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDocumentMaster");
	}

	if (documentMaster != null)
	{

	    if (documentMaster.getStage() != null || (request.getParameter("stageId") != null && request.getParameter("stageId").length() > 0))
	    {
		long stageId = Long.parseLong(request.getParameter("stageId"));
		if (documentMaster.getStage() != null && documentMaster.getStage().getStageId() > 0)
		{
		    stageId = documentMaster.getStage().getStageId();
		}
		documentMaster.setStage(stageService.get(stageId));
	    }

	    DocumentMaster documentMasterObj = null;

	    // Check for Duplicate DocumentMaster
	    //TODO: Uncomment if you need to check duplicates and update the query in the DocumentMasterdaoImpl.checkForDuplicates
	    documentMasterObj = documentMasterService.checkForDuplicates(documentMaster);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (documentMasterObj != null)
		{
		    session.setAttribute("message", "Document Master with the same name already exists.");
		} else
		{
			documentMaster.setTenancyid(user.getTenancy().getTenancyId());

		    documentMasterService.save(documentMaster);
		    session.setAttribute("message", "Document Master details saved successfully");
		}
	    }
	}

	request.setAttribute("stageList", stageService.getAll());

	ModelAndView modelandView = new ModelAndView("manageDocumentMaster");
	modelandView.addObject("documentMaster", documentMaster);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating DocumentMaster entries
     */
    @RequestMapping("/documentmaster/editDocumentMaster.do")
    public ModelAndView editDocumentMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDocumentMaster");
	}

	DocumentMaster documentMaster = null;
	String documentMasterId = request.getParameter("documentMasterId");
	if (StringUtils.isNotEmpty(documentMasterId))
	{
	    documentMaster = documentMasterService.get(Long.parseLong(documentMasterId));
	} else
	{
	    documentMaster = new DocumentMaster();
	}

	request.setAttribute("stageList", stageService.getAll());

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDocumentMaster", "documentMaster", documentMaster);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of DocumentMaster
     */
    @RequestMapping("/documentmaster/listDocumentMaster.do")
    public ModelAndView listDocumentMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDocumentMaster");
		}
		    DocumentMasterSearch searchDocumentMaster=new DocumentMasterSearch();
		    setSearchParameters(searchDocumentMaster, request);
			
			List<DocumentMaster> DocumentMasterList = documentMasterService.getDocumentMasterListBySearch(searchDocumentMaster);
			try
			{
				long totalCount = documentMasterService.getDocumentMasterCountBySearch(searchDocumentMaster);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the DocumentMasterList is null 		
		if(DocumentMasterList==null)
			DocumentMasterList = new ArrayList<DocumentMaster>();
			
		    request.setAttribute("stageList", stageService.getAll());
			request.setAttribute("currentPage", searchDocumentMaster.getCurrentPage());
			request.setAttribute(const_OrderBy, searchDocumentMaster.getOrderBy());
			request.setAttribute(const_SortBy, searchDocumentMaster.getSortBy());
			request.setAttribute("SearchDocumentMaster", searchDocumentMaster);
		return new ModelAndView("listDocumentMaster","DocumentMasterList",DocumentMasterList);
    }
    
    /**
     * @param DocumentMasterSearch searchDocumentMaster
     * @param request
     */
    private void setSearchParameters(DocumentMasterSearch searchDocumentMaster,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on documentMasterId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(description)";
				sortBy = "asc";
			}
			
			searchDocumentMaster.setCurrentPage(longCurrentPage);
			searchDocumentMaster.setOrderBy(orderBy);
			searchDocumentMaster.setSortBy(sortBy);
			searchDocumentMaster.setDescription(request.getParameter("searchDescription"));
			if(request.getParameter("searchStageId")!=null && request.getParameter("searchStageId").length()>0)
				searchDocumentMaster.setStageId(Long.parseLong(request.getParameter("searchStageId")));
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
     * @return a ModelAndView to render the response This method deletes a DocumentMaster
     *         entry from database
     */
    @RequestMapping("/documentmaster/deleteDocumentMaster.do")
    public ModelAndView deleteDocumentMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDocumentMaster");
	}
	String documentMasterId = request.getParameter("documentMasterId");
	if (StringUtils.isNotEmpty(documentMasterId))
	{
	    DocumentMaster documentMaster = documentMasterService.get(Long.parseLong(documentMasterId));
	    if (documentMaster != null)
	    {
		try
		{
		    documentMasterService.delete(Long.parseLong(documentMasterId));
		    session.setAttribute("message", "Document Master details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDocumentMaster(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Document Master details you are trying to delete is already deleted.");
	    }
	}
	return listDocumentMaster(request, response);
    }
}
