package com.mars.dms.controller;

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
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.StageService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.dms.model.DmsDocumentCheckList;
import com.mars.dms.service.DmsDocumentCheckListService;

/**
 * <p>Title: DmsDocumentCheckListController.java </p>

 * <p>Description: This is a  DmsDocumentCheckList controller class for controlling DmsDocumentCheckList related actions</p>

 * @see com.mars.common.model.DmsDocumentCheckList
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DmsDocumentCheckListController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(DmsDocumentCheckListController.class);
    
    @Autowired
    private DmsDocumentCheckListService dmsDocumentCheckListService;
    
    @Autowired
    private ContentUploadController contentUploadController;
	
	@Autowired
	private DocumentMasterService documentMasterService;

	@Autowired
    private StageService stageService;

        public ContentUploadController getContentUploadController() {
		return contentUploadController;
	}

	public void setContentUploadController(ContentUploadController contentUploadController) {
		this.contentUploadController = contentUploadController;
	}

	/**
     * @param dmsDocumentCheckListService
     *            sets the DmsDocumentCheckListService object.
     */
    public void setDmsDocumentCheckListService(DmsDocumentCheckListService dmsDocumentCheckListService)
    {
	this.dmsDocumentCheckListService = dmsDocumentCheckListService;
    }

    public DocumentMasterService getDocumentMasterService() {
		return documentMasterService;
	}

	public void setDocumentMasterService(DocumentMasterService documentMasterService) {
		this.documentMasterService = documentMasterService;
	}

	/**
     * @param stageService
     *            sets the DmsDocumentCheckListService object.
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
     *         DmsDocumentCheckList entries to the database.
     * @throws Exception 
     */
    @RequestMapping("/dmsdocumentchecklist/saveDmsDocumentCheckList.do")
    public ModelAndView saveDmsDocumentCheckList(HttpServletRequest request, HttpServletResponse response, DmsDocumentCheckList dmsDocumentCheckList) 
    		throws ServletException, Exception
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveDmsDocumentCheckList");
	}

	if (dmsDocumentCheckList != null)
	{

	    DmsDocumentCheckList dmsDocumentCheckListObj = null;

	    // Check for Duplicate DmsDocumentCheckList
	    //TODO: Uncomment if you need to check duplicates and update the query in the DmsDocumentCheckListdaoImpl.checkForDuplicates
	    //dmsDocumentCheckListObj = dmsDocumentCheckListService.checkForDuplicates(dmsDocumentCheckList);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (dmsDocumentCheckListObj != null)
		{
		    session.setAttribute("message", "Document Master with the same name already exists.");
		} else
		{
		    dmsDocumentCheckListService.save(dmsDocumentCheckList);
		    session.setAttribute("message", "Document Master details saved successfully");
		}
	    }
	}

	request.setAttribute("stageList", stageService.getAll());

	ModelAndView modelandView = new ModelAndView("manageDmsDocumentCheckList");
	modelandView.addObject("dmsDocumentCheckList", dmsDocumentCheckList);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating DmsDocumentCheckList entries
     */
    @RequestMapping("/dmsdocumentchecklist/editDmsDocumentCheckList.do")
    public ModelAndView editDmsDocumentCheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editDmsDocumentCheckList");
	}

	DmsDocumentCheckList dmsDocumentCheckList = null;
	String dmsDocumentCheckListId = request.getParameter("dmsDocumentCheckListId");
	if (StringUtils.isNotEmpty(dmsDocumentCheckListId))
	{
	    dmsDocumentCheckList = dmsDocumentCheckListService.get(Long.parseLong(dmsDocumentCheckListId));
	} else
	{
	    dmsDocumentCheckList = new DmsDocumentCheckList();
	}

	request.setAttribute("stageList", stageService.getAll());

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageDmsDocumentCheckList", "dmsDocumentCheckList", dmsDocumentCheckList);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of DmsDocumentCheckList
     */
    @RequestMapping("/dmsdocumentchecklist/listDmsDocumentCheckList.do")
    public ModelAndView listDmsDocumentCheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listDmsDocumentCheckList");
		}
//		    DmsDocumentCheckListSearch searchDmsDocumentCheckList=new DmsDocumentCheckListSearch();
//		    setSearchParameters(searchDmsDocumentCheckList, request);
			
//			List<DmsDocumentCheckList> DmsDocumentCheckListList = dmsDocumentCheckListService.getDmsDocumentCheckListListBySearch(searchDmsDocumentCheckList);
			try
			{
//				long totalCount = dmsDocumentCheckListService.getDmsDocumentCheckListCountBySearch(searchDmsDocumentCheckList);
//		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
//		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the DmsDocumentCheckListList is null 
			List<DmsDocumentCheckList> DmsDocumentCheckListList=null;
		if(DmsDocumentCheckListList==null)
			DmsDocumentCheckListList = new ArrayList<DmsDocumentCheckList>();
			
		    request.setAttribute("stageList", stageService.getAll());
//			request.setAttribute("currentPage", searchDmsDocumentCheckList.getCurrentPage());
//			request.setAttribute(const_OrderBy, searchDmsDocumentCheckList.getOrderBy());
//			request.setAttribute(const_SortBy, searchDmsDocumentCheckList.getSortBy());
//			request.setAttribute("SearchDmsDocumentCheckList", searchDmsDocumentCheckList);
		return new ModelAndView("listDmsDocumentCheckList","DmsDocumentCheckListList",DmsDocumentCheckListList);
    }
    
 
    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a DmsDocumentCheckList
     *         entry from database
     */

 /*   public ModelAndView deleteDmsDocumentCheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteDmsDocumentCheckList");
	}
	String dmsDocumentCheckListId = request.getParameter("dmsDocumentCheckListId");
	if (StringUtils.isNotEmpty(dmsDocumentCheckListId))
	{
	    DmsDocumentCheckList dmsDocumentCheckList = dmsDocumentCheckListService.get(Long.parseLong(dmsDocumentCheckListId));
	    if (dmsDocumentCheckList != null)
	    {
		try
		{
		    dmsDocumentCheckListService.delete(Long.parseLong(dmsDocumentCheckListId));
		    session.setAttribute("message", "Document Master details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editDmsDocumentCheckList(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Document Master details you are trying to delete is already deleted.");
	    }
	}
	return listDmsDocumentCheckList(request, response);
    }*/
    
    @RequestMapping("/dmsdocumentchecklist/manageFileUpload.do")
	public ModelAndView manageFileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking manageFileUpload");
		}
		String entityId=CommonUtils.decodeString(request.getParameter("entityId"));
		String entityName=CommonUtils.decodeString(request.getParameter("entityName"));
		String uploadType=CommonUtils.decodeString(request.getParameter("uploadType"));
		String documentMasterId=CommonUtils.decodeString(request.getParameter("documentMasterId"));
		String dmsDocumentCheckListId=CommonUtils.decodeString(request.getParameter("dmsDocumentCheckListId"));
		request.setAttribute("entityId",entityId );
		String workspace=CommonUtils.decodeString(request.getParameter("workspace"));
		request.setAttribute("entityName", entityName);
		request.setAttribute("uploadType",uploadType);
		request.setAttribute("workspace",workspace);
		request.setAttribute("documentMasterId",documentMasterId);
		request.setAttribute("dmsDocumentCheckListId",dmsDocumentCheckListId);
		CommonTokenUtils.setNewUploadToken(request);
		
		return contentUploadController.manageFileUpload(request, response);
	}

	public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking uploadFile");
		}

		contentUploadController.uploadFile(request, response);
	}

	public List<DocumentMaster> getDocumentsByEntity(String entityName, long entityId) {
		
		return documentMasterService.getDocumentCheckListByEntity(entityName, entityId);
	}

	public void deleteDmsDocumentsByEntity(String entityName, long entityId) {
		dmsDocumentCheckListService.deleteByEntity(entityName,entityId);
	}

	/**
	 * This method delete TaxPolicyAttachment for a given Id
	 * 
	 * @param id
	 *            as long
	 * 
	 */

	public void deleteFileDocument(String uuid, long dmsDocumentId) throws Exception {

			if (log.isDebugEnabled()) {
				log.debug("deleting deleteFileDocument instance");
			}
			
			dmsDocumentCheckListService.delete(uuid, dmsDocumentId);
			log.debug("delete successful");
	}
}
