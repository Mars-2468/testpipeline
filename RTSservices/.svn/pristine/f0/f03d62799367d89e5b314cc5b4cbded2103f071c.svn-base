package com.mars.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.mars.common.model.NodeMaster;
import com.mars.common.model.Sector;
import com.mars.common.model.Ward;
import com.mars.common.model.WardSector;
import com.mars.common.search.WardSearch;
import com.mars.common.service.CityService;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.SectorService;
import com.mars.common.service.WardService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: WardController.java </p>

 * <p>Description: This is a  Ward controller class for controlling Ward related actions</p>

 * @see com.mars.common.model.Ward
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class WardController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(WardController.class);

    @Autowired
    private WardService wardService;

    @Autowired
    private CityService cityService;
    
    @Autowired
    private NodeMasterService nodeMasterService;
    
    @Autowired
    private SectorService sectorService;
    
    /**
	 * @return the sectorService
	 */
	public SectorService getSectorService() {
		return sectorService;
	}

	/**
	 * @param sectorService the sectorService to set
	 */
	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	/**
     * @param wardService
     *            sets the WardService object.
     */
    public void setWardService(WardService wardService)
    {
	this.wardService = wardService;
    }

    /**
     * @param cityService
     *            sets the WardService object.
     */
    public void setCityService(CityService cityService)
    {
	this.cityService = cityService;
    }    

    /**
     * 
     * @param nodeMasterService
     */
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
     *         Ward entries to the database.
     */
    @RequestMapping("/ward/saveWard.do")
    public ModelAndView saveWard(HttpServletRequest request, HttpServletResponse response, Ward ward) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveWard");
	}

	if (ward != null)
	{

	    if (ward.getCity() != null || (request.getParameter("cityId") != null && request.getParameter("cityId").length() > 0))
	    {
		long cityId = Long.parseLong(request.getParameter("cityId"));
		if (ward.getCity() != null && ward.getCity().getCityId() > 0)
		{
		    cityId = ward.getCity().getCityId();
		}
		ward.setCity(cityService.get(cityId));
	    }
	    Ward wardObj = null;

	    // Check for Duplicate Ward
	    //TODO: Uncomment if you need to check duplicates and update the query in the WarddaoImpl.checkForDuplicates
	    wardObj = wardService.checkForDuplicates(ward);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (wardObj != null)
		{
		    session.setAttribute("message", "Ward with the same name already exists.");
		} else
		{
		    wardService.save(ward);
		    session.setAttribute("message", "Ward details saved successfully");
		}
	    }
	}

	request.setAttribute("cityList", cityService.getAll());

	ModelAndView modelandView = new ModelAndView("manageWard");
	modelandView.addObject("ward", ward);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Ward entries
     */
    @RequestMapping("/ward/editWard.do")
    public ModelAndView editWard(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editWard");
	}

	Ward ward = null;
	String wardId = request.getParameter("wardId");
	if (StringUtils.isNotEmpty(wardId))
	{
	    ward = wardService.get(Long.parseLong(wardId));
	} else
	{
	    ward = new Ward();
	}

	request.setAttribute("cityList", cityService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageWard", "ward", ward);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Ward
     */
    @RequestMapping("/ward/listWard.do")
    public ModelAndView listWard(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listWard");
		}
		    WardSearch searchWard=new WardSearch();
			setSearchParameters(searchWard, request);
		    
			List<Ward> WardList = wardService.getWardListBySearch(searchWard);
			try
			{
				long totalCount = wardService.getWardCountBySearch(searchWard);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the WardList is null 		
		if(WardList==null)
			WardList = new ArrayList<Ward>();
		
			request.setAttribute("cityList", cityService.getAll());
			request.setAttribute("currentPage", searchWard.getCurrentPage());
			request.setAttribute(const_OrderBy, searchWard.getOrderBy());
			request.setAttribute(const_SortBy, searchWard.getSortBy());	
			request.setAttribute("SearchWard", searchWard);
		return new ModelAndView("listWard","WardList",WardList);
    }
    
    /**
     * @param WardSearch searchWard
     * @param request
     */
    private void setSearchParameters(WardSearch searchWard,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on wardId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}
			
			if(request.getParameter("searchCityId")!=null && request.getParameter("searchCityId").length()>0)
				searchWard.setCityId(Long.parseLong(request.getParameter("searchCityId")));
			searchWard.setName(request.getParameter("searchName"));
			searchWard.setCurrentPage(longCurrentPage);
			searchWard.setOrderBy(orderBy);
			searchWard.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a Ward
     *         entry from database
     */
    @RequestMapping("/ward/deleteWard.do")
    public ModelAndView deleteWard(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteWard");
	}
	String wardId = request.getParameter("wardId");
	if (StringUtils.isNotEmpty(wardId))
	{
	    Ward ward = wardService.get(Long.parseLong(wardId));
	    if (ward != null)
	    {
		try
		{
		    wardService.delete(Long.parseLong(wardId));
		    session.setAttribute("message", "Ward details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editWard(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Ward details you are trying to delete is already deleted.");
	    }
	}
	return listWard(request, response);
    }
        
    /**
     * Used in Property manage page to display ward name
     * 
     * @param nodeMasterId
     * @return
     */
    public Ward getWardOnNode(long nodeMasterId){
    	Ward ward = null;    	
    	try {
    		List<NodeMaster> nodeMasterList = nodeMasterService.findByProperty("nodeMasterId", new Long(nodeMasterId));
    		if(nodeMasterList !=null && nodeMasterList.size() > 0){
    			ward = nodeMasterList.get(0).getWard();
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return ward;
    }  
    
    @RequestMapping("/ward/editAssignedSectors.do")
    public ModelAndView editAssignedSectors(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editAssignedSectors");
		}
	
		Ward ward = null;
		String wardId = request.getParameter("wardId");
		if (StringUtils.isNotEmpty(wardId))
		{
		    ward = wardService.get(Long.parseLong(wardId));
		    
		    setNodeSectorTreeDeatis(request,ward);
			CommonTokenUtils.setNewToken(request);
			return new ModelAndView("editAssignedSectors", "ward", ward);
			
		} else {
		    return listWard(request,response);
		}
		
	}
    
    private void setNodeSectorTreeDeatis(HttpServletRequest request, Ward ward)
    {
	    Set<WardSector> wardSectorSet = ward.getWardSectorSet();
	    List<NodeMaster> nodeMasterList1 = new ArrayList<NodeMaster>();
		List<NodeMaster> nodeMasterList2 = new ArrayList<NodeMaster>();
		List<NodeMaster> nodeMasterList3 = new ArrayList<NodeMaster>();
		
	    List<NodeMaster> nodeMasterList =  nodeMasterService.getAll();

	    for (NodeMaster nodeMaster : nodeMasterList) {
	    	 Set<Sector> sectorSet = nodeMaster.getSectorSet();
			for (Sector sector : sectorSet) {
		    	boolean isSectorAssigned = false;
			    for (WardSector wardSector : wardSectorSet) {
					if(sector.getSectorId() == wardSector.getSector().getSectorId())
					{
						sector.setAssignedWardSectorId(wardSector.getWadrSectorId());
						isSectorAssigned = true;
						break;
					}
			    }
				
				if(isSectorAssigned == false)
					nodeMaster.setChecked(isSectorAssigned);
			}
		}
	    
	    int i = 0;
		for (NodeMaster nodeMaster : nodeMasterList)
		{
		    Set<Sector> hstSectors = nodeMaster.getSectorSet();
		    if (hstSectors != null && hstSectors.size() > 0)
		    {
				if (i % 3 == 0)
					nodeMasterList1.add(nodeMaster);
				else if (i % 3 == 1)
					nodeMasterList2.add(nodeMaster);
				else if (i % 3 == 2)
					nodeMasterList3.add(nodeMaster);
				
				i++;
		    }
		}
		
		request.setAttribute("nodeMasterList1", nodeMasterList1);
		request.setAttribute("nodeMasterList2", nodeMasterList2);
		request.setAttribute("nodeMasterList3", nodeMasterList3);
    }

    @RequestMapping("/ward/saveWardSectors.do")
    public ModelAndView saveWardSectors(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveWardSectors");
		}

		HttpSession session = request.getSession();
		
		Ward ward = null;
		String wardId = request.getParameter("wardId");
		if (StringUtils.isNotEmpty(wardId))
		{
		    ward = wardService.get(Long.parseLong(wardId));
		}
		
		Set<WardSector> wardSectorSet = null;
		String deletedWardSectorIds = "";
		
	    String strAddIds[] = null;
	    try
	    {
			String addSectorIds = request.getParameter("addSectorIds");
	
			if (addSectorIds != null && addSectorIds.length() > 0)
			{
			    strAddIds = addSectorIds.split(",");
			}
	
			long[] wardSectorId = CommonRequestUtils.getLongParameters(request, "wardSectorId");
			long[] sectorId = CommonRequestUtils.getLongParameters(request, "sectorId");
	
			if (wardSectorId != null && wardSectorId.length > 0)
			{
			    int arrayLength = wardSectorId.length;
			    wardSectorSet = new HashSet<WardSector>();
			    for (int i = 0; i < arrayLength; i++)
			    {
					boolean stillChecked = false;
					if (strAddIds != null && strAddIds.length > 0)
					{
					    for (String addId : strAddIds)
					    {
							if (Long.parseLong(addId) == sectorId[i])
							{
							    stillChecked = true;
							    // The Permission is checked so add it to set
							    WardSector wardSector = new WardSector();
							    wardSector.setWadrSectorId(wardSectorId[i]);
							    wardSector.setSector(sectorService.get(sectorId[i]));
							    wardSector.setWard(ward);
							    wardSectorSet.add(wardSector);
							    break;
							}
					    }
					}
					
				    if (!stillChecked && wardSectorId[i] > 0)
				    {
						if (deletedWardSectorIds.equals(""))
							deletedWardSectorIds += wardSectorId[i];
						else
							deletedWardSectorIds += "," + wardSectorId[i];
				    }
			    }
			}
	    } catch (Exception exception)
	    {
		exception.printStackTrace();
		log.error(exception.getMessage());
	    }
	 
		wardService.saveWardSectors( ward,wardSectorSet, deletedWardSectorIds);
		session.setAttribute("message", "Sectors assigned successfully");
		
		
		//Since ward was evicted from session reloading it.
		if (StringUtils.isNotEmpty(wardId))
		{
		    ward = wardService.get(Long.parseLong(wardId));
		}
		
		CommonTokenUtils.setNewToken(request);
		
		setNodeSectorTreeDeatis(request,ward);
		return new ModelAndView("editAssignedSectors", "ward", ward);
    }
    
    
    public List<Sector> getSectorsOnWard(long wardId){
    	List<Sector> sectorList = null;    	
    	try {
			sectorList = wardService.getSectorsOnWard(new Long(wardId));
			
			//Doing this to overcome lazy in case of DWR method call
			for (Sector sector : sectorList) {
				sector.getNodeMaster().getName();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return sectorList;
    }
    
    /**
     * Used in Property manage page to display ward name
     * 
     * @param nodeMasterId
     * @return
     */
    public List<NodeMaster> getNodesOnWard(long wardId){
    	List<NodeMaster> nodeMasterList = null;	
    	try {
    		nodeMasterList = nodeMasterService.findByProperty("ward.wardId", new Long(wardId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return nodeMasterList;
    }  
    
    public List<Sector> getSectorsOnWardAndNode(long wardId,long nodeMasterId){
    	List<Sector> sectorList = null;    	
    	try {
			sectorList = wardService.getSectorsOnWardAndNode(wardId,nodeMasterId);
			
			//Doing this to overcome lazy in case of DWR method call
			for (Sector sector : sectorList) {
				sector.getNodeMaster().getName();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return sectorList;
    }    
    
}
