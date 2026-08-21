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

import com.mars.common.model.Sector;
import com.mars.common.search.SectorSearch;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.SectorService;
import com.mars.common.service.WardService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: SectorController.java </p>

 * <p>Description: This is a  Sector controller class for controlling Sector related actions</p>

 * @see com.mars.common.model.Sector
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class SectorController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(SectorController.class);

    @Autowired
    private SectorService sectorService;

    @Autowired
    private NodeMasterService nodeMasterService;
    
    @Autowired
    private WardService wardService;

    /**
     * @param sectorService
     *            sets the SectorService object.
     */
    public void setSectorService(SectorService sectorService)
    {
	this.sectorService = sectorService;
    }

    /**
     * @param nodeMasterService
     *            sets the SectorService object.
     */
    public void setNodeMasterService(NodeMasterService nodeMasterService)
    {
	this.nodeMasterService = nodeMasterService;
    }
    
    public void setWardService(WardService wardService) {
		this.wardService = wardService;
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
     *         Sector entries to the database.
     */
    @RequestMapping("/sector/saveSector.do")
    public ModelAndView saveSector(HttpServletRequest request, HttpServletResponse response, Sector sector) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveSector");
	}

	if (sector != null)
	{

	    if (sector.getNodeMaster() != null || (request.getParameter("nodeMasterId") != null && 
	    		request.getParameter("nodeMasterId").length() > 0))
	    {
		long nodeMasterId = Long.parseLong(request.getParameter("nodeMasterId"));
		if (sector.getNodeMaster() != null && sector.getNodeMaster().getNodeMasterId() > 0)
		{
			nodeMasterId = sector.getNodeMaster().getNodeMasterId();
		}
		sector.setNodeMaster(nodeMasterService.get(nodeMasterId));
	    }
	    Sector sectorObj = null;

	    // Check for Duplicate Sector
	    //TODO: Uncomment if you need to check duplicates and update the query in the SectordaoImpl.checkForDuplicates
	    sectorObj = sectorService.checkForDuplicates(sector);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (sectorObj != null)
		{
		    session.setAttribute("message", "Sector with the same name already exists.");
		} else
		{
		    sectorService.save(sector);
		    session.setAttribute("message", "Sector details saved successfully");
		}
	    }
	}

	request.setAttribute("nodeList", nodeMasterService.getAll());

	ModelAndView modelandView = new ModelAndView("manageSector");
	modelandView.addObject("sector", sector);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Sector entries
     */
    @RequestMapping("/sector/editSector.do")
    public ModelAndView editSector(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editSector");
	}

	Sector sector = null;
	String sectorId = request.getParameter("sectorId");
	if (StringUtils.isNotEmpty(sectorId))
	{
	    sector = sectorService.get(Long.parseLong(sectorId));
	} else
	{
	    sector = new Sector();
	}

	request.setAttribute("nodeList", nodeMasterService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageSector", "sector", sector);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Sector
     */
    @RequestMapping("/sector/listSector.do")
    public ModelAndView listSector(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listSector");
		}
		    SectorSearch searchSector=new SectorSearch();
		    setSearchParamaters(searchSector, request);
			
			List<Sector> SectorList = sectorService.getSectorListBySearch(searchSector);
			try
			{
				long totalCount = sectorService.getSectorCountBySearch(searchSector);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the SectorList is null 		
		if(SectorList==null)
			SectorList = new ArrayList<Sector>();
			
		    request.setAttribute("wardList", wardService.getAll());
//		    request.setAttribute("nodeList", nodeMasterService.getAll());
			request.setAttribute("currentPage", searchSector.getCurrentPage());
			request.setAttribute(const_OrderBy, searchSector.getOrderBy());
			request.setAttribute(const_SortBy, searchSector.getSortBy());
			request.setAttribute("SearchSector", searchSector);
		return new ModelAndView("listSector","SectorList",SectorList);
    }
    
    /**
     * @param SectorSearch searchSector
     * @param request
     */
    private void setSearchParamaters(SectorSearch searchSector,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParamaters Method is called");
    	}
    	
    	try{
    		 
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on sectorId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(sector.name)";
				sortBy = "asc";
			}
			
			if(request.getParameter("searchNodeMasterId")!=null && request.getParameter("searchNodeMasterId").length()>0)
				searchSector.setNodeMasterId(Long.parseLong(request.getParameter("searchNodeMasterId")));
			if(request.getParameter("searchWardId")!=null && request.getParameter("searchWardId").length()>0)
				searchSector.setWardId(Long.parseLong(request.getParameter("searchWardId")));
			
			searchSector.setName(request.getParameter("searchName"));
			searchSector.setCurrentPage(longCurrentPage);
			searchSector.setOrderBy(orderBy);
			searchSector.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a Sector
     *         entry from database
     */
    @RequestMapping("/sector/deleteSector.do")
    public ModelAndView deleteSector(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteSector");
	}
	String sectorId = request.getParameter("sectorId");
	if (StringUtils.isNotEmpty(sectorId))
	{
	    Sector sector = sectorService.get(Long.parseLong(sectorId));
	    if (sector != null)
	    {
		try
		{
		    sectorService.delete(Long.parseLong(sectorId));
		    session.setAttribute("message", "Sector details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editSector(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Sector details you are trying to delete is already deleted.");
	    }
	}
	return listSector(request, response);
    }
    
    public List<Sector> getSectorsOnNode(long nodeMasterId){
    	List<Sector> sectorList = null;    	
    	try {
			sectorList = sectorService.findByProperty("nodeMaster.nodeMasterId", new Long(nodeMasterId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return sectorList;
    }
}
