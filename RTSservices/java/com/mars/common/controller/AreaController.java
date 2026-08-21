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

import com.mars.common.model.Area;
import com.mars.common.search.AreaSearch;
import com.mars.common.service.AreaService;
import com.mars.common.service.CityService;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.SectorService;
import com.mars.common.service.WardService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: AreaController.java </p>

 * <p>Description: This is a  Area controller class for controlling Area related actions</p>

 * @see com.mars.common.model.Area
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

@Controller
public class AreaController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(AreaController.class);

    @Autowired
    private AreaService areaService;

    @Autowired
    private CityService cityService;
    
    @Autowired
    private NodeMasterService nodeMasterService;
    
    @Autowired
    private SectorService sectorService;
    
    @Autowired
    private WardService wardService;
    
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
     * @param areaService
     *            sets the AreaService object.
     */
    public void setAreaService(AreaService areaService)
    {
	this.areaService = areaService;
    }

    /**
     * @param cityService
     *            sets the AreaService object.
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

	/**
	 * @return the wardService
	 */
	public WardService getWardService() {
		return wardService;
	}

	/**
	 * @param wardService the wardService to set
	 */
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
     *         Area entries to the database.
     */
	@RequestMapping("/area/saveArea.do")
    public ModelAndView saveArea(HttpServletRequest request, HttpServletResponse response, Area area) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveArea");
	}

	if (area != null)
	{
	    Area areaObj = null;

	    // Check for Duplicate Area
	    //TODO: Uncomment if you need to check duplicates and update the query in the AreadaoImpl.checkForDuplicates
	    areaObj = areaService.checkForDuplicates(area);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (areaObj != null)
		{
		    session.setAttribute("message", "Area with the same name already exists.");
		} else
		{
		    areaService.save(area);
		    session.setAttribute("message", "Area details saved successfully");
		}
	    }
	}

	request.setAttribute("cityList", cityService.getAll());

	ModelAndView modelandView = new ModelAndView("manageArea");
	modelandView.addObject("area", area);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Area entries
     */
	@RequestMapping("/area/editArea.do")
    public ModelAndView editArea(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editArea");
	}

	Area area = null;
	String areaId = request.getParameter("areaId");
	if (StringUtils.isNotEmpty(areaId))
	{
	    area = areaService.get(Long.parseLong(areaId));
	} else
	{
	    area = new Area();
	}

	request.setAttribute("cityList", cityService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageArea", "area", area);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Area
     */

	@RequestMapping("/area/listArea.do")
	public ModelAndView listArea(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listArea");
		}
		    AreaSearch searchArea=new AreaSearch();
			setSearchParameters(searchArea, request);
		    
			List<Area> AreaList = areaService.getAreaListBySearch(searchArea);
			try
			{
				long totalCount = areaService.getAreaCountBySearch(searchArea);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the AreaList is null 		
		if(AreaList==null)
			AreaList = new ArrayList<Area>();
		
			request.setAttribute("cityList", cityService.getAll());
			request.setAttribute("currentPage", searchArea.getCurrentPage());
			request.setAttribute(const_OrderBy, searchArea.getOrderBy());
			request.setAttribute(const_SortBy, searchArea.getSortBy());	
			request.setAttribute("SearchArea", searchArea);
		return new ModelAndView("listArea","AreaList",AreaList);
    }
    
    /**
     * @param AreaSearch searchArea
     * @param request
     */
    private void setSearchParameters(AreaSearch searchArea,HttpServletRequest request){
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	try{
    		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);	
			
			// setting default order by on areaId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "upper(name)";
				sortBy = "asc";
			}

			searchArea.setName(request.getParameter("searchName"));
			searchArea.setCurrentPage(longCurrentPage);
			searchArea.setOrderBy(orderBy);
			searchArea.setSortBy(sortBy);
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
     * @return a ModelAndView to render the response This method deletes a Area
     *         entry from database
     */
	@RequestMapping("/area/deleteArea.do")
    public ModelAndView deleteArea(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteArea");
	}
	String areaId = request.getParameter("areaId");
	if (StringUtils.isNotEmpty(areaId))
	{
	    Area area = areaService.get(Long.parseLong(areaId));
	    if (area != null)
	    {
		try
		{
		    areaService.delete(Long.parseLong(areaId));
		    session.setAttribute("message", "Area details deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editArea(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Area details you are trying to delete is already deleted.");
	    }
	}
	return listArea(request, response);
    }
	/*@RequestMapping("/area/editAssignedAreaSectors.do")
    public ModelAndView editAssignedAreaSectors(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editAssignedAreaSectors");
		}
	
		Area area = null;
		String areaId = request.getParameter("areaId");
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		    
		    setNodeSectorTreeDeatis(request,area);
			CommonTokenUtils.setNewToken(request);
			return new ModelAndView("editAssignedAreaSectors", "area", area);
			
		} else {
		    return listArea(request,response);
		}
		
	}*/
	/*@RequestMapping("/area/editAssignedAreaWards.do")
	public ModelAndView editAssignedAreaWards(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editAssignedAreaWards");
		}
	
		Area area = null;
		String areaId = request.getParameter("areaId");
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		    
		    setWardTreeDeatis(request,area);
			CommonTokenUtils.setNewToken(request);
			return new ModelAndView("editAssignedAreaWards", "area", area);
			
		} else {
		    return listArea(request,response);
		}
		
	}*/
    
   /* private void setWardTreeDeatis(HttpServletRequest request, Area area)
    {
    	Hashtable<Long,String>  unassignedWardsHT = areaService.getUnassignedWardsOfArea(area.getAreaId());
	    Set<AreaWard> areaWardSet = area.getAreaWardSet();
	    List<Ward> wardList =  wardService.getAll();
	    
	    for (Ward ward : wardList) {
	    	if(unassignedWardsHT.get(new Long(ward.getWardId()))== null)
			{
				//If status is -1 means don't show in UI
				ward.setStatus(-1);
			}
	    	
		    for (AreaWard areaWard : areaWardSet) {
				if(ward.getWardId() == areaWard.getWard().getWardId())
				{
					ward.setAreaWardId(areaWard.getAreaWardId());
					break;
				}
		    }
		}
	    
		request.setAttribute("wardList1", wardList);

    }*/
    
    
   /* private void setNodeSectorTreeDeatis(HttpServletRequest request, Area area)
    {
    	Hashtable<Long,String>  unassignedSectorsHT = areaService.getUnassignedSectorsOfArea(area.getAreaId());
	    Set<AreaSector> areaSectorSet = area.getAreaSectorSet();
	    List<NodeMaster> nodeMasterList1 = new ArrayList<NodeMaster>();
		List<NodeMaster> nodeMasterList2 = new ArrayList<NodeMaster>();
		List<NodeMaster> nodeMasterList3 = new ArrayList<NodeMaster>();
		
	    List<NodeMaster> nodeMasterList =  nodeMasterService.getAll();

	    for (NodeMaster nodeMaster : nodeMasterList) {
	    	 Set<Sector> sectorSet = nodeMaster.getSectorSet();
			for (Sector sector : sectorSet) {
				
				//Its already assigned to some Area
				//One sector can be part of one sector only.
				if(unassignedSectorsHT.get(new Long(sector.getSectorId()))== null)
				{
					//If status is -1 means don't show in UI
					sector.setStatus(-1);
				}
		    	boolean isSectorAssigned = false;
			    for (AreaSector areaSector : areaSectorSet) {
					if(sector.getSectorId() == areaSector.getSector().getSectorId())
					{
						//wardSectorId is already there on Sector.java so we r using it as it is to store AreasScetorId. 
						//Instead of creating another attribute.
						sector.setAssignedWardSectorId(areaSector
								.getAreaSectorId());
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
    }*/

   /* @RequestMapping("/area/saveAreaSectors.do")
    public ModelAndView saveAreaSectors(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveAreaSectors");
		}

		HttpSession session = request.getSession();
		
		Area area = null;
		String areaId = request.getParameter("areaId");
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		}
		
		Set<AreaSector> areaSectorSet = null;
		String deletedAreaSectorIds = "";
		
	    String strAddIds[] = null;
	    try
	    {
			String addSectorIds = request.getParameter("addSectorIds");
	
			if (addSectorIds != null && addSectorIds.length() > 0)
			{
			    strAddIds = addSectorIds.split(",");
			}
	
			long[] areaSectorId = CommonRequestUtils.getLongParameters(request, "areaSectorId");
			long[] sectorId = CommonRequestUtils.getLongParameters(request, "sectorId");
	
			if (areaSectorId != null && areaSectorId.length > 0)
			{
			    int arrayLength = areaSectorId.length;
			    areaSectorSet = new LinkedHashSet<AreaSector>();
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
							    AreaSector areaSector = new AreaSector();
							    areaSector.setAreaSectorId(areaSectorId[i]);
							    areaSector.setSector(sectorService.get(sectorId[i]));
							    areaSector.setArea(area);
							    areaSectorSet.add(areaSector);
							    break;
							}
					    }
					}
					
				    if (!stillChecked && areaSectorId[i] > 0)
				    {
						if (deletedAreaSectorIds.equals(""))
							deletedAreaSectorIds += areaSectorId[i];
						else
							deletedAreaSectorIds += "," + areaSectorId[i];
				    }
			    }
			}
	    } catch (Exception exception)
	    {
		exception.printStackTrace();
		log.error(exception.getMessage());
	    }
	 
		areaService.saveAreaSectors( area,areaSectorSet, deletedAreaSectorIds);
		session.setAttribute("message", "Sectors assigned successfully");
		
		
		//Since area was evicted from session reloading it.
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		}
		
		CommonTokenUtils.setNewToken(request);
		
		setNodeSectorTreeDeatis(request,area);
		return new ModelAndView("editAssignedAreaSectors", "area", area);
    }*/
    
   /* @RequestMapping("/area/saveAreaWards.do")
    public ModelAndView saveAreaWards(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking saveAreaWards");
		}

		HttpSession session = request.getSession();
		
		Area area = null;
		String areaId = request.getParameter("areaId");
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		}
		
		Set<AreaWard> areaWardSet = null;
		String deletedAreaWardIds = "";
		
	    String strAddIds[] = null;
	    try
	    {
			String addWardIds = request.getParameter("addWardIds");
	
			if (addWardIds != null && addWardIds.length() > 0)
			{
			    strAddIds = addWardIds.split(",");
			}
	
			long[] areaWardId = CommonRequestUtils.getLongParameters(request, "areaWardId");
			long[] wardId = CommonRequestUtils.getLongParameters(request, "wardId");
	
			if (areaWardId != null && areaWardId.length > 0)
			{
			    int arrayLength = areaWardId.length;
			    areaWardSet = new LinkedHashSet<AreaWard>();
			    for (int i = 0; i < arrayLength; i++)
			    {
					boolean stillChecked = false;
					if (strAddIds != null && strAddIds.length > 0)
					{
					    for (String addId : strAddIds)
					    {
							if (Long.parseLong(addId) == wardId[i])
							{
							    stillChecked = true;
							    AreaWard areaWard = new AreaWard();
							    areaWard.setAreaWardId(areaWardId[i]);
							    areaWard.setWard(wardService.get(wardId[i]));
							    areaWard.setArea(area);
							    areaWardSet.add(areaWard);
							    break;
							}
					    }
					}
					
				    if (!stillChecked && areaWardId[i] > 0)
				    {
						if (deletedAreaWardIds.equals(""))
							deletedAreaWardIds += areaWardId[i];
						else
							deletedAreaWardIds += "," + areaWardId[i];
				    }
			    }
			}
	    } catch (Exception exception)
	    {
		exception.printStackTrace();
		log.error(exception.getMessage());
	    }
	 
		areaService.saveAreaWards( area,areaWardSet, deletedAreaWardIds);
		session.setAttribute("message", "Wards assigned successfully");
		
		
		//Since area was evicted from session reloading it.
		if (StringUtils.isNotEmpty(areaId))
		{
		    area = areaService.get(Long.parseLong(areaId));
		}
		
		CommonTokenUtils.setNewToken(request);
		
		setWardTreeDeatis(request,area);
		return new ModelAndView("editAssignedAreaWards", "area", area);
    }
    
    
    public List<Sector> getSectorsOnArea(long areaId){
    	List<Sector> sectorList = null;    	
    	try {
			sectorList = areaService.getSectorsOnArea(new Long(areaId));
			
			if(sectorList == null)
				sectorList = new ArrayList<Sector>();
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
    
    public List<Ward> getWardsOnArea(long areaId){
    	List<Ward> wardsList = null;    	
    	try {
    		wardsList = areaService.getWardsOnArea(new Long(areaId));
			
			if(wardsList == null)
				wardsList = new ArrayList<Ward>();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return wardsList;
    }*/
    
    
}
