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

import com.mars.common.model.DeliveryMode;
import com.mars.common.model.DeliveryModeFields;
import com.mars.common.service.DeliveryModeService;
import com.mars.common.utils.CommonTokenUtils;
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
public class DeliveryModeController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DeliveryModeController.class);

    @Autowired
    private DeliveryModeService deliveryModeService;


    

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
    @RequestMapping("/deliveryMode/saveDeliveryMode.do")
    public ModelAndView saveDeliveryMode(HttpServletRequest request, HttpServletResponse response, DeliveryMode deliveryMode) throws ServletException
    {
		HttpSession session = request.getSession();
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveFileReceivedMode");
		}
	
		if (deliveryMode != null)
		{  	    		 
			DeliveryMode DeliveryModeObj = deliveryModeService.checkForDuplicates(deliveryMode);
			if(DeliveryModeObj == null){
				
				List<DeliveryModeFields> DeliveryModeFieldsList = new ArrayList<DeliveryModeFields>();
				String[] fieldName = request.getParameterValues("fieldLabel");
				String[] fieldType = request.getParameterValues("fieldType");
				String[] fieldDataType = request.getParameterValues("fieldDataType");
				if(fieldName!=null && fieldType!=null){
					for(int i=0; i<fieldName.length; i++){
						DeliveryModeFields DeliveryModeFields = new DeliveryModeFields();					
						try{
							if(fieldName[i]!=null && fieldType[i]!=null && fieldDataType[i]!=null){
								DeliveryModeFields.setDeliveryMode(deliveryMode); 								
								DeliveryModeFields.setFieldName(fieldName[i]);	 								
								DeliveryModeFields.setFieldType(fieldType[i]);	
								DeliveryModeFields.setFieldDataType(fieldDataType[i]);
								DeliveryModeFields.setFieldRequired(0);
								if(i==0){
									String isRequired =request.getParameter("fieldRequired");
									if(isRequired!=null){
										DeliveryModeFields.setFieldRequired(Integer.parseInt(isRequired));
									} 									
								}else{	
									String isRequired =request.getParameter("fieldRequired"+(i+1));
									if(isRequired!=null){
										DeliveryModeFields.setFieldRequired(Integer.parseInt(isRequired));
									}								
								}
								
								DeliveryModeFieldsList.add(DeliveryModeFields);
							}
						}catch(ArrayIndexOutOfBoundsException ex){
							 session.setAttribute("errMessage", "Please Try Again");
							return listDeliveryMode(request, response);
						}					
					}	
					deliveryMode.setDeliveryModeFields(DeliveryModeFieldsList);			
				}
				deliveryMode.setStatus(1);
				deliveryModeService.save(deliveryMode);
				session.setAttribute("message", "Acknowledgement Mode Saved Successfully");
			
			}else{
				 session.setAttribute("errMessage", "Duplicate Acknowledgement Mode");
			}		    
		} 
		return listDeliveryMode(request, response);
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
    @RequestMapping("/deliveryMode/editDeliveryMode.do")
    public ModelAndView editDeliveryMode(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editDeliveryMode");
		}
	
		DeliveryMode DeliveryMode = null;
		String DeliveryModeId = request.getParameter("deliveryModeId");
		if (StringUtils.isNotEmpty(DeliveryModeId))
		{
			DeliveryMode = deliveryModeService.get(Long.parseLong(DeliveryModeId));
		} else
		{
			DeliveryMode = new DeliveryMode();
		}
		
		
		CommonTokenUtils.setNewToken(request);
		return new ModelAndView("manageDeliveryMode", "deliveryMode", DeliveryMode);
	
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
    @RequestMapping("/deliveryMode/listDeliveryMode.do")
    public ModelAndView listDeliveryMode(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDeliveryMode");
		}
		    //FileReceivedModeSearch fileReceivedModeSearch=new FileReceivedModeSearch();
		    //setSearchParameters(fileReceivedModeSearch, request);
			
			List<DeliveryMode> DeliveryModeList = deliveryModeService.getAll();
			try
			{
				//long totalCount = fileReceivedModeService.getFileReceivedModeCountBySearch(fileReceivedModeSearch);
		       // request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		       // request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the FileTypeList is null 		
		if(DeliveryModeList==null)
			DeliveryModeList = new ArrayList<DeliveryMode>();
			
			/*request.setAttribute("currentPage", fileReceivedModeSearch.getCurrentPage());
			request.setAttribute(const_OrderBy, fileReceivedModeSearch.getOrderBy());
			request.setAttribute(const_SortBy, fileReceivedModeSearch.getSortBy());
			request.setAttribute("fileReceivedModeSearch", fileReceivedModeSearch);*/
		return new ModelAndView("listDeliveryMode","deliveryModeList",DeliveryModeList);
    }
    
    /**
     * @param FileTypeSearch searchFileType
     * @param request
     */
  /*  private void setSearchParameters(DeliveryModeSearch fileReceivedModeSearch,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
	 
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(deliveryModeName)";
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
    }*/

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
