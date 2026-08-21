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

import com.mars.common.model.Bank;
import com.mars.common.search.BankSearch;
import com.mars.common.service.BankService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

/**
 * <p>Title: BankController.java </p>

 * <p>Description: This is a  Bank controller class for controlling Bank related actions</p>

 * @see com.mars.common.model.Bank
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class BankController extends MultiActionController implements InitializingBean
{

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";

    private static Log log = LogFactory.getLog(BankController.class);

    @Autowired
    private BankService bankService;

    /**
     * @param bankService
     *            sets the BankService object.
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
     *         Bank entries to the database.
     */
    @RequestMapping("/bank/saveBank.do")
    public ModelAndView saveBank(HttpServletRequest request, HttpServletResponse response, Bank bank) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveBank");
	}

	if (bank != null)
	{

	    Bank bankObj = null;

	    // Check for Duplicate Bank
	    //TODO: Uncomment if you need to check duplicates and update the query in the BankdaoImpl.checkForDuplicates
	    bankObj = bankService.checkForDuplicates(bank);
	    if (CommonTokenUtils.allowFormSubmit(request))
	    {
		if (bankObj != null)
		{
		    session.setAttribute("message", "Bank with the same name already exists.");
		} else
		{
		    bankService.save(bank);
		    session.setAttribute("message", "Bank saved successfully");
		}
	    }
	}

	ModelAndView modelandView = new ModelAndView("manageBank");
	modelandView.addObject("bank", bank);
	return modelandView;
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Bank entries
     */
    @RequestMapping("/bank/editBank.do")
    public ModelAndView editBank(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking editBank");
	}

	Bank bank = null;
	String bankId = request.getParameter("bankId");
	if (StringUtils.isNotEmpty(bankId))
	{
	    bank = bankService.get(Long.parseLong(bankId));
	} else
	{
	    bank = new Bank();
	}

	CommonTokenUtils.setNewToken(request);
	return new ModelAndView("manageBank", "bank", bank);
    }

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Bank
     */
    @RequestMapping("/bank/listBank.do")
    public ModelAndView listBank(HttpServletRequest request, HttpServletResponse response) throws ServletException{
	
		if (log.isDebugEnabled())
		{
	    	log.debug("Invoking listBank");
		}
		    BankSearch searchBank=new BankSearch(); 
		    setSearchParameters(searchBank, request);
						
			List<Bank> BankList = bankService.getBankListBySearch(searchBank);
			try
			{   
				long totalCount = bankService.getBankCountBySearch(searchBank);
		        request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
		        request.setAttribute("totalCount", totalCount);
			} catch (Exception e)
			{
		    	log.error(e.getMessage());
			}			

		//Check if the BankList is null 		
		if(BankList==null)
			BankList = new ArrayList<Bank>();
			
			request.setAttribute("currentPage", searchBank.getCurrentPage());
			request.setAttribute(const_OrderBy, searchBank.getOrderBy());
			request.setAttribute(const_SortBy, searchBank.getSortBy());	
			request.setAttribute("SearchBank", searchBank);
		return new ModelAndView("listBank","BankList",BankList);
    }
    
    
    /**
     * 
     * @param searchBank
     * @param request
     */
    private void setSearchParameters(BankSearch searchBank, HttpServletRequest request) {
    	if(log.isDebugEnabled()){
    		log.debug("setSearchParameters Method is called");
    	}
    	
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);	
		
		// setting default order by on bankId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "upper(bankName)";
			sortBy = "asc";
		}
        try {
        	searchBank.setCurrentPage(longCurrentPage);
        	searchBank.setOrderBy(orderBy);
        	searchBank.setSortBy(sortBy);          
        	searchBank.setBankName(request.getParameter("searchBankName"));
          
        } catch (Exception err) {
          log.error(err.getMessage());
        }
      }
    

    /**
     * 
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Bank
     *         entry from database
     */
    @RequestMapping("/bank/deleteBank.do")
    public ModelAndView deleteBank(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking deleteBank");
	}
	String bankId = request.getParameter("bankId");
	if (StringUtils.isNotEmpty(bankId))
	{
	    Bank bank = bankService.get(Long.parseLong(bankId));
	    if (bank != null)
	    {
		try
		{
		    bankService.delete(Long.parseLong(bankId));
		    session.setAttribute("message", "Bank deleted successfully");
		} catch (Exception exception)
		{
		    session.setAttribute("message", "Cannot delete this record as it is used in other page");
		    return editBank(request, response);
		}
	    } else
	    {
		session.setAttribute("message", "The Bank details you are trying to delete is already deleted.");
	    }
	}
	return listBank(request, response);
    }
    
    
    
    public List<Bank> getBanks(String strName)
    {
	return bankService.getAll();
    }
}
