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

import com.mars.common.model.BankBranch;
import com.mars.common.search.BankBranchSearch;
import com.mars.common.service.BankBranchService;
import com.mars.common.service.BankService;
import com.mars.common.service.CityService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: BankBranchController.java </p>

 * <p>Description: This is a  BankBranch controller class for controlling BankBranch related actions</p>

 * @see com.mars.common.model.BankBranch
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class BankBranchController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(BankBranchController.class);

    @Autowired
    private BankBranchService bankBranchService;

    @Autowired
    private BankService bankService;
    
    @Autowired
    private CityService cityService;

    /**
     * @param bankBranchService
     *            sets the BankBranchService object.
     */
    public void setBankBranchService(BankBranchService bankBranchService)
    {
	this.bankBranchService = bankBranchService;
    }

    public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	/**
     * @param bankService
     *            sets the BankBranchService object.
     */
    public void setBankService(BankService bankService)
    {
	this.bankService = bankService;
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
     *         BankBranch entries to the database.
     */
    @RequestMapping("/bankbranch/saveBankBranch.do")
    public ModelAndView saveBankBranch(HttpServletRequest request, HttpServletResponse response, BankBranch bankBranch) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveBankBranch");
	}

	if (bankBranch != null)
	{

	    if (bankBranch.getBank() != null || (request.getParameter("bankId") != null && request.getParameter("bankId").length() > 0))
	    {
		long bankId = Long.parseLong(request.getParameter("bankId"));
		if (bankBranch.getBank() != null && bankBranch.getBank().getBankId() > 0)
		{
		    bankId = bankBranch.getBank().getBankId();
		}
		bankBranch.setBank(bankService.get(bankId));
	    }
	    
	    if (bankBranch.getCity() != null || (request.getParameter("cityId") != null && request.getParameter("cityId").length() > 0))
	    {
			long cityId = Long.parseLong(request.getParameter("cityId"));
			if (bankBranch.getCity() != null && bankBranch.getCity().getCityId()>0)
			{
		  	  cityId = bankBranch.getCity().getCityId();
			}
			bankBranch.setCity(cityService.get(cityId));
	    }
	    
	    
	    BankBranch bankBranchObj = null;

	    // Check for Duplicate BankBranch
	    //TODO: Uncomment if you need to check duplicates and update the query in the BankBranchdaoImpl.checkForDuplicates
	    bankBranchObj = bankBranchService.checkForDuplicates(bankBranch);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (bankBranchObj != null)
		{
		    session.setAttribute("message", "Bank Branch with the same name already exists.");
		} else
		{
		    bankBranchService.save(bankBranch);
		    session.setAttribute("message", "Bank Branch saved successfully");
		}
	    }
	}

	request.setAttribute("bankList", bankService.getAll());
	request.setAttribute("cityList",cityService.getAll());
	ModelAndView modelandView = new ModelAndView("manageBankBranch");
	modelandView.addObject("bankBranch", bankBranch);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating BankBranch entries
     */
    @RequestMapping("/bankbranch/editBankBranch.do")
    public ModelAndView editBankBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editBankBranch");
	}

	BankBranch bankBranch = null;
	String bankBranchId = request.getParameter("bankBranchId");
	if (StringUtils.isNotEmpty(bankBranchId))
	{
	    bankBranch = bankBranchService.get(Long.parseLong(bankBranchId));
	} else
	{
	    bankBranch = new BankBranch();
	}

	request.setAttribute("bankList", bankService.getAll());
	
	request.setAttribute("cityList",cityService.getAll());
	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageBankBranch", "bankBranch", bankBranch);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of BankBranch
     */
    @RequestMapping("/bankbranch/listBankBranch.do")
    public ModelAndView listBankBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listBankBranch");
		}
		    BankBranchSearch searchBankBranch=new BankBranchSearch();
		    setSearchParameters(searchBankBranch, request);
		    		
			List<BankBranch> BankBranchList = bankBranchService.getBankBranchListBySearch(searchBankBranch);
			try
			{
				long totalCount = bankBranchService.getBankBranchCountBySearch(searchBankBranch);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the BankBranchList is null 		
		if(BankBranchList==null)
			BankBranchList = new ArrayList<BankBranch>();
			
		    request.setAttribute("bankList",bankService.getAll());
			request.setAttribute("currentPage", searchBankBranch.getCurrentPage());
			request.setAttribute(const_OrderBy, searchBankBranch.getOrderBy());
			request.setAttribute(const_SortBy, searchBankBranch.getSortBy());	
			request.setAttribute("SearchBankBranch", searchBankBranch);
		return new ModelAndView("listBankBranch","BankBranchList",BankBranchList);
    }
    
    /**
     * 
     * @param searchBankBranch
     * @param request
     */
    
    private void setSearchParameters(BankBranchSearch searchBankBranch, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on bankId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(branchName)";
			sortBy = "asc";
		}
		    try{        
        	if(request.getParameter("searchBankId")!=null && request.getParameter("searchBankId").length()>0)
				searchBankBranch.setBankId(Long.parseLong(request.getParameter("searchBankId")));
        	searchBankBranch.setBranchName(request.getParameter("searchBranchName"));
        	searchBankBranch.setCurrentPage(longCurrentPage);
        	searchBankBranch.setOrderBy(orderBy);
        	searchBankBranch.setSortBy(sortBy);          
        	
          
        } catch (Exception err) {
          log.error(err.getMessage());
        }
      }
    
    /**
     * @param branchName
     * @return list
     */
    public List<BankBranch> getBankBranchList(String branchName)
    {
    	List<BankBranch> bankBranchList=null;
    	BankBranchSearch searchBankBranch=new BankBranchSearch();
    	
    	try{
        	// setting default order BY
    		searchBankBranch.setOrderBy("branchName");
    		searchBankBranch.setSortBy("asc");
    		
    		if(branchName!=null && branchName.trim().length()>0){
    			searchBankBranch.setBranchName(branchName);
    		}

    		bankBranchList = bankBranchService.getBankBranchListBySearch(searchBankBranch);
    		
    	}catch (Exception exception){		    
    		log.error(exception.getMessage());
		}
    	
    	if(bankBranchList==null)
    		bankBranchList=new ArrayList<BankBranch>();
    	  
    	return bankBranchList;
    		
		 
    }



    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a BankBranch
     *         entry from database
     */
    @RequestMapping("/bankbranch/deleteBankBranch.do")
    public ModelAndView deleteBankBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteBankBranch");
	}
	String bankBranchId = request.getParameter("bankBranchId");
	if (StringUtils.isNotEmpty(bankBranchId))
	{
	    BankBranch bankBranch = bankBranchService.get(Long.parseLong(bankBranchId));
	    if (bankBranch != null)
	    {
		try
		{
		    bankBranchService.delete(Long.parseLong(bankBranchId));
		    session.setAttribute("message", "Bank Branch deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editBankBranch(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Bank Branch details you are trying to delete is already deleted.");
	    }
	}
	return listBankBranch(request, response);
    }
    
    public List<BankBranch> getBankBranchOnBank(long bankId)
    {
    	List<BankBranch> branchList=null;
    	
    	try{
    		branchList=bankBranchService.findByProperty("bank.bankId", new Long(bankId));
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return branchList;
    }
}
