package com.mars.dms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.dms.model.DmsDocument;
import com.mars.dms.service.DmsDocumentService;

/**
 * <p>
 * Title: DmsDocumentController.java
 * </p>
 * 
 * <p>
 * Description: This is a DmsDocument controller class for controlling
 * DmsDocument related actions
 * </p>
 * 
 * @see com.mars.common.model.DmsDocument Copyright (c) 2014 for eGovernance Goa
 * 
 * @version: 1.0
 * 
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class DmsDocumentController extends MultiActionController implements InitializingBean {

	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory.getLog(DmsDocumentController.class);

	@Autowired
	private DmsDocumentService dmsDocumentService;

	@Autowired
	private ContentUploadController contentUploadController;

	public ContentUploadController getContentUploadController() {
		return contentUploadController;
	}

	public void setContentUploadController(ContentUploadController contentUploadController) {
		this.contentUploadController = contentUploadController;
	}

	/**
	 * @param dmsDocumentService
	 *            sets the DmsDocumentService object.
	 */
	public void setDmsDocumentService(DmsDocumentService dmsDocumentService) {
		this.dmsDocumentService = dmsDocumentService;
	}

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * This method is to bind the date objects in the specifed format.
	 * 
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
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
	 *         DmsDocument entries to the database.
	 */
	@RequestMapping("/dmsdocument/saveDmsDocument.do")
	public ModelAndView saveDmsDocument(HttpServletRequest request, HttpServletResponse response, DmsDocument dmsDocument) throws ServletException {
		HttpSession session = request.getSession();
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveDmsDocument");
		}
		if (dmsDocument != null) {

			DmsDocument dmsDocumentObj = null;

			if (dmsDocumentObj != null) {
				session.setAttribute("message", "Reg Num Genaration with the same name already exists.");
			} else {
				dmsDocumentService.save(dmsDocument);
				session.setAttribute("message", "Reg Num Genaration details saved successfully");
			}
		}

		ModelAndView modelandView = new ModelAndView("manageDmsDocument");
		modelandView.addObject("dmsDocument", dmsDocument);
		return modelandView;
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response. This method is for
	 *         editing/creating DmsDocument entries
	 */
	@RequestMapping("/dmsdocument/editDmsDocument.do")
	public ModelAndView editDmsDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking editDmsDocument");
		}

		DmsDocument dmsDocument = null;
		String dmsDocumentId = request.getParameter("dmsDocumentId");
		if (dmsDocumentId != null && dmsDocumentId.length() > 0) {
			dmsDocument = dmsDocumentService.get(Long.parseLong(dmsDocumentId));
		} else {
			dmsDocument = new DmsDocument();
		}

		return new ModelAndView("manageDmsDocument", "dmsDocument", dmsDocument);
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response This method will display
	 *         list of DmsDocument
	 */
	@RequestMapping("/dmsdocument/listDmsDocument.do")
	public ModelAndView listDmsDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listDmsDocument");
		}
		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);

		// setting default order by on dmsDocumentId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "dmsDocumentId";
			sortBy = "desc";
		}
		List<DmsDocument> DmsDocumentList = dmsDocumentService.getDmsDocumentList(longCurrentPage, orderBy, sortBy);
			long totalCount = dmsDocumentService.getDmsDocumentCount();
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);

		// Check if the DmsDocumentList is null
		if (DmsDocumentList == null)
			DmsDocumentList = new ArrayList<DmsDocument>();

		request.setAttribute("currentPage", new Long(longCurrentPage));
		request.setAttribute(const_OrderBy, orderBy);
		request.setAttribute(const_SortBy, sortBy);
		return new ModelAndView("listDmsDocument", "DmsDocumentList", DmsDocumentList);
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response This method deletes a
	 *         DmsDocument entry from database
	 */

	/*public ModelAndView deleteDmsDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		if (log.isDebugEnabled()) {
			log.debug("Invoking deleteDmsDocument");
		}
		String dmsDocumentId = request.getParameter("dmsDocumentId");
		if (dmsDocumentId != null && dmsDocumentId.length() > 0) {
			DmsDocument dmsDocument = dmsDocumentService.get(Long.parseLong(dmsDocumentId));
			if (dmsDocument != null) {
				try {
					dmsDocumentService.delete(null, Long.parseLong(dmsDocumentId));
					session.setAttribute("message", "Reg Num Genaration details deleted successfully");
				} catch (Exception exception) {
					session.setAttribute("message", "Cannot delete this record as it is used in other page");
					return editDmsDocument(request, response);
				}
			} else {
				session.setAttribute("message", "The Reg Num Genaration details you are trying to delete is already deleted.");
			}
		}
		return listDmsDocument(request, response);
	}*/
	
	@RequestMapping("/dmsdocument/manageFileUpload.do")
	public ModelAndView manageFileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking manageFileUpload");
		}
		String selectedFolderPath = CommonUtils.decodeString(request.getParameter("selectedFolderPath"));
		request.setAttribute("uploadPath", selectedFolderPath);
		String entityId=CommonUtils.decodeString(request.getParameter("entityId"));
		request.setAttribute("entityId",entityId );
		String entityName=CommonUtils.decodeString(request.getParameter("entityName"));
		String uploadType=CommonUtils.decodeString(request.getParameter("uploadType"));
		String workspace=CommonUtils.decodeString(request.getParameter("workspace"));
		request.setAttribute("entityName", entityName);
		request.setAttribute("uploadType",uploadType);
		request.setAttribute("workspace",workspace);
		CommonTokenUtils.setNewUploadToken(request);
		
		return contentUploadController.manageFileUpload(request, response);
	}

	@RequestMapping("/dmsdocument/uploadFile.do")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking uploadFile");
		}
		contentUploadController.uploadFile(request, response);
	}
	
	@RequestMapping("/dmsdocument/uploadFileCertificate.do")
	public void uploadFileCertificate(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking uploadFile");
		}
		contentUploadController.uploadFile(request, response);
	}

	public List<DmsDocument> getDocumentsByEntity(String entityName, long entityId) {
		return dmsDocumentService.getDocumentsByEntity(entityName, entityId);
	}

	public void deleteDmsDocumentsByEntity(String entityName, long entityId) {
		dmsDocumentService.deleteByEntity(entityName,entityId);
	}

	/**
	 * This method delete TaxPolicyAttachment for a given Id
	 * 
	 * @param id
	 *            as long
	 * 
	 */

	public void deleteFileDocument(String uuid, long dmsDocumentId) throws Exception{

			if (log.isDebugEnabled()) {
				log.debug("deleting deleteFileDocument instance");
			}
			
			dmsDocumentService.delete(uuid, dmsDocumentId);
			log.debug("delete successful");
	}
	
}
