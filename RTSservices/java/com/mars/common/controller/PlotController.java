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

import com.mars.common.model.Plot;
import com.mars.common.search.PlotSearch;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.PlotService;
import com.mars.common.service.PlotTypeService;
import com.mars.common.service.SectorService;
import com.mars.common.service.WardService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: PlotController.java </p>

 * <p>Description: This is a  Plot controller class for controlling Plot related actions</p>

 * @see com.mars.common.model.Plot
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class PlotController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(PlotController.class);

    @Autowired
    private PlotService plotService;
    
    @Autowired
    private PlotTypeService plotTypeService;
    
    @Autowired
    private SectorService sectorService;
    
    @Autowired
    private WardService wardService;
    
    @Autowired
    private NodeMasterService nodeMasterService;

    public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	public void setPlotTypeService(PlotTypeService plotTypeService) {
		this.plotTypeService = plotTypeService;
	}
	

	/**
     * @param plotService
     *            sets the PlotService object.
     */
    public void setPlotService(PlotService plotService)
    {
	this.plotService = plotService;
    }
    
    public void setWardService(WardService wardService) {
		this.wardService = wardService;
	}

	public void setNodeMasterService(NodeMasterService nodeMasterService) {
		this.nodeMasterService = nodeMasterService;
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
     *         Plot entries to the database.
     */
    @RequestMapping("/plot/savePlot.do")
    public ModelAndView savePlot(HttpServletRequest request, HttpServletResponse response, Plot plot) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking savePlot");
	}

	if (plot != null)
	{
		
		if (plot.getPlotType() != null || (request.getParameter("plotTypeId") != null && request.getParameter("plotTypeId").length() > 0))
	    {
		long plotTypeId = Long.parseLong(request.getParameter("plotTypeId"));
		if (plot.getPlotType() != null && plot.getPlotType().getPlotTypeId() > 0)
		{
			plotTypeId = plot.getPlotType().getPlotTypeId();
		}
		plot.setPlotType(plotTypeService.get(plotTypeId));
	    }
		
		if (plot.getSector() != null || (request.getParameter("sectorId") != null && request.getParameter("sectorId").length() > 0))
	    {
		long sectorId = Long.parseLong(request.getParameter("sectorId"));
		if (plot.getSector() != null && plot.getSector().getSectorId() > 0)
		{
			sectorId = plot.getSector().getSectorId();
		}
		plot.setSector(sectorService.get(sectorId));
	    }

	    Plot plotObj = null;

	    // Check for Duplicate Plot
	    //TODO: Uncomment if you need to check duplicates and update the query in the PlotdaoImpl.checkForDuplicates
	    plotObj = plotService.checkForDuplicates(plot);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (plotObj != null)
		{
		    session.setAttribute("message", "Plot with the same name already exists.");
		} else
		{
		    plotService.save(plot);
		    session.setAttribute("message", "Plot details saved successfully");
		}
	    }
	}
	request.setAttribute("plotTypeList", plotTypeService.getAll());
	request.setAttribute("sectorList", sectorService.getAll());
	
	ModelAndView modelandView = new ModelAndView("managePlot");
	modelandView.addObject("plot", plot);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Plot entries
     */
    @RequestMapping("/plot/editPlot.do")
    public ModelAndView editPlot(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editPlot");
	}

	Plot plot = null;
	String plotId = request.getParameter("plotId");
	if (StringUtils.isNotEmpty(plotId))
	{
	    plot = plotService.get(Long.parseLong(plotId));
	} else
	{
	    plot = new Plot();
	}
	request.setAttribute("plotTypeList", plotTypeService.getAll());
	request.setAttribute("sectorList", sectorService.getSectorList(-1, "nodeMaster.name", "asc"));
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("managePlot", "plot", plot);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Plot
     */
    @RequestMapping("/plot/listPlot.do")
    public ModelAndView listPlot(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listPlot");
		}
		    PlotSearch searchPlot=new PlotSearch();
		    setSearchParameters(searchPlot, request);
			
			List<Plot> PlotList = plotService.getPlotListBySearch(searchPlot);
			try
			{
				long totalCount = plotService.getPlotCountBySearch(searchPlot);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the PlotList is null 		
		if(PlotList==null)
			PlotList = new ArrayList<Plot>();
		
		long wardId=0;
		long nodeId=0;
		long sectorId=0;
		
		if(request.getParameter("searchWardId")!=null && request.getParameter("searchWardId").length()>0)
		wardId=Long.parseLong(request.getParameter("searchWardId"));
		if(request.getParameter("searchNodeMasterId")!=null && request.getParameter("searchNodeMasterId").length()>0)
		nodeId=Long.parseLong(request.getParameter("searchNodeMasterId"));
		if(request.getParameter("searchSectorId")!=null && request.getParameter("searchSectorId").length()>0)
		sectorId=Long.parseLong(request.getParameter("searchSectorId"));
		
		if(wardId>0)
		{
			request.setAttribute("nodeList", nodeMasterService.findByProperty("ward.wardId", wardId));
			
			if(wardId>0 && nodeId==0)
			 request.setAttribute("sectorList", wardService.getSectorsOnWard(wardId));
			
			if(wardId>0 && nodeId>0)
			 request.setAttribute("sectorList", wardService.getSectorsOnWardAndNode(wardId,nodeId));
		}
			
		    request.setAttribute("wardList", wardService.getAll());
		    request.setAttribute("plotTypeList", plotTypeService.getAll());
		//  request.setAttribute("sectorList", sectorService.getAll());
			request.setAttribute("currentPage", searchPlot.getCurrentPage());
			request.setAttribute(const_OrderBy, searchPlot.getOrderBy());
			request.setAttribute(const_SortBy, searchPlot.getSortBy());
			request.setAttribute("SearchPlot", searchPlot);
		return new ModelAndView("listPlot","PlotList",PlotList);
    }
    
    /**
     * @param PlotSearch searchPlot
     * @param request
     */
    private void setSearchParameters(PlotSearch searchPlot,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on plotId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(number)";
				sortBy = "asc";
			}
			
			searchPlot.setNumber(request.getParameter("searchNumber"));
			if(request.getParameter("searchPlotTypeId")!=null && request.getParameter("searchPlotTypeId").length()>0)
				searchPlot.setPlotTypeId(Long.parseLong(request.getParameter("searchPlotTypeId")));
			if(request.getParameter("searchSectorId")!=null && request.getParameter("searchSectorId").length()>0)
				searchPlot.setSectorId(Long.parseLong(request.getParameter("searchSectorId")));
			if(request.getParameter("searchNodeMasterId")!=null && request.getParameter("searchNodeMasterId").length()>0)
				searchPlot.setNodeMasterId(Long.parseLong(request.getParameter("searchNodeMasterId")));
			if(request.getParameter("searchWardId")!=null && request.getParameter("searchWardId").length()>0)
				searchPlot.setWardId(Long.parseLong(request.getParameter("searchWardId")));
			
			searchPlot.setCurrentPage(longCurrentPage);
			searchPlot.setOrderBy(orderBy);
			searchPlot.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a Plot
     *         entry from database
     */
    @RequestMapping("/plot/deletePlot.do")
    public ModelAndView deletePlot(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deletePlot");
	}
	String plotId = request.getParameter("plotId");
	if (StringUtils.isNotEmpty(plotId))
	{
	    Plot plot = plotService.get(Long.parseLong(plotId));
	    if (plot != null)
	    {
		try
		{
		    plotService.delete(Long.parseLong(plotId));
		    session.setAttribute("message", "Plot details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editPlot(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Plot details you are trying to delete is already deleted.");
	    }
	}
	return listPlot(request, response);
    }
    
    public List<Plot> getPlotsOnSector(long sectorId){
    	List<Plot> plotList = null;    	
    	try {
    		plotList =  plotService.findByProperty("sector.sectorId", new Long(sectorId));
    		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return plotList;
    }
}
