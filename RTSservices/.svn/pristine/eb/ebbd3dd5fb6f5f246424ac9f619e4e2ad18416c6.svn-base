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

import com.mars.common.model.ReceivedMode;
import com.mars.common.search.ReceivedModeSearch;
import com.mars.common.service.ReceivedModeService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: FileTypeController.java </p>

 * <p>Description: This is a  fileType controller class for controlling fileType related actions</p>

 * @see com.mars.common.model.DeliveryMode
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class ReceivedModeController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(ReceivedModeController.class);

    @Autowired
    private ReceivedModeService receivedModeService;


    

    /**
     * @param fileTypeService
     *            sets the FileTypeService object.
     */
    




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
     *         FileType entries to the database.
     */
    @RequestMapping("/receivedMode/saveReceivedMode.do")
    public ModelAndView saveReceivedMode(HttpServletRequest request, HttpServletResponse response, ReceivedMode receivedMode) throws ServletException
    {
		HttpSession session = request.getSession();
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveFileReceivedMode");
		}
		ReceivedMode receivedModeObj = null;
		if (receivedMode != null)
		{  	    
		
			//receivedModeService.save(receivedMode);
			receivedModeObj = receivedModeService.checkForDuplicates(receivedMode);
			if (CommonTokenUtils.allowFormSubmit(request))
		    {
			if (receivedModeObj != null)
			{
			    session.setAttribute("message", "ReceivedMode with the same name already exists.");
			} else
			{
				receivedModeService.save(receivedMode);
			    session.setAttribute("message", "ReceivedMode details saved successfully");
			}
		    }
		    // Check for Duplicate FileType
		    //TODO: Uncomment if you need to check duplicates and update the query in the FileTypedaoImpl.checkForDuplicates
		   /* fileTypeObj = deliveryModeService.checkForDuplicates(fileType);
		    if (CommonTokenUtils.allowFormSubmit(request))
		    {
			if (fileTypeObj != null)
			{
			    session.setAttribute("message", "FileType with the same name already exists.");
			} else
			{
			    fileTypeService.save(fileType);
			    session.setAttribute("message", "FileType details saved successfully");
			}
		    }*/
		}
	
		//ModelAndView modelandView = new ModelAndView("listeReceivedMode");
		//modelandView.addObject("receivedMode", receivedMode);
		//return modelandView;
		
		//return listReceivedMode(request, response);
		return new ModelAndView("manageReceivedMode","receivedMode", receivedMode);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating FileType entries
     */
    @RequestMapping("/receivedMode/editReceivedMode.do")
    public ModelAndView editReceivedMode(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editFileReceivedMode");
		}
	
		ReceivedMode fileReceivedMode = null;
		String fileReceivedModeId = request.getParameter("receivedModeId");
		if (StringUtils.isNotEmpty(fileReceivedModeId))
		{
			fileReceivedMode = receivedModeService.get(Long.parseLong(fileReceivedModeId));
		} else
		{
			fileReceivedMode = new ReceivedMode();
		}
		
		
		CommonTokenUtils.setNewToken(request);
		return new ModelAndView("manageReceivedMode", "receivedMode", fileReceivedMode);
	
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of FileType
     */
    @RequestMapping("/receivedMode/listReceivedMode.do")
    public ModelAndView listReceivedMode(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listFileReceivedMode");
		}
		    ReceivedModeSearch fileReceivedModeSearch=new ReceivedModeSearch();
		    setSearchParameters(fileReceivedModeSearch, request);
			
			List<ReceivedMode> fileReceivedModeList = receivedModeService.getReceivedModeListBySearch(fileReceivedModeSearch);
			try
			{
				long totalCount = receivedModeService.getReceivedModeCountBySearch(fileReceivedModeSearch);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the FileTypeList is null 		
		if(fileReceivedModeList==null)
			fileReceivedModeList = new ArrayList<ReceivedMode>();
			
			request.setAttribute("currentPage", fileReceivedModeSearch.getCurrentPage());
			request.setAttribute(const_OrderBy, fileReceivedModeSearch.getOrderBy());
			request.setAttribute(const_SortBy, fileReceivedModeSearch.getSortBy());
			request.setAttribute("fileReceivedModeSearch", fileReceivedModeSearch);
		return new ModelAndView("listReceivedMode","listReceivedMode",fileReceivedModeList);
    }
    
    /**
     * @param FileTypeSearch searchFileType
     * @param request
     */
    private void setSearchParameters(ReceivedModeSearch fileReceivedModeSearch,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on fileTypeId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(receivedModeName)";
				sortBy = "asc";
			}
			if(request.getParameter("searchName")!=null){			
				fileReceivedModeSearch.setName(request.getParameter("searchName"));
			}
			fileReceivedModeSearch.setCurrentPage(longCurrentPage);
			fileReceivedModeSearch.setOrderBy(orderBy);
			fileReceivedModeSearch.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a FileType
     *         entry from database
     */
   
}
