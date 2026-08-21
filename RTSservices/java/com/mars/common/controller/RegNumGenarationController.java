package com.mars.common.controller;

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

import com.mars.common.model.RegNumGenaration;
import com.mars.common.model.User;
import com.mars.common.service.RegNumGenarationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;

/**
 * <p>
 * Title: RegNumGenarationController.java
 * </p>
 * 
 * <p>
 * Description: This is a RegNumGenaration controller class for controlling
 * RegNumGenaration related actions
 * </p>
 * 
 * @see com.mars.bnd.model.RegNumGenaration Copyright (c) 2014 for eGovernance
 *      Goa
 * 
 * @version: 1.0
 * 
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class RegNumGenarationController extends MultiActionController implements
		InitializingBean {

	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory
			.getLog(RegNumGenarationController.class);
	
	@Autowired
	private RegNumGenarationService regNumGenarationService;

	@Autowired
	private UserService userService;

	
	/**
	 * @param regNumGenarationService
	 *            sets the RegNumGenarationService object.
	 */
	
	
	public void setRegNumGenarationService(
			RegNumGenarationService regNumGenarationService) {
		this.regNumGenarationService = regNumGenarationService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * This method is to bind the date objects in the specifed format.
	 * 
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		df.setLenient(true);
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				df, true));
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response. This method is for saving
	 *         RegNumGenaration entries to the database.
	 */
	@RequestMapping("/regnumgenaration/saveRegNumGenaration.do")
	public ModelAndView saveRegNumGenaration(HttpServletRequest request,
			HttpServletResponse response, RegNumGenaration regNumGenaration)
			throws ServletException {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		
		 User user=userService.get(sessionUser.getUserId());	
		 if (log.isDebugEnabled()) {
			log.debug("Invoking saveRegNumGenaration");
		}
		if (regNumGenaration != null) {

			RegNumGenaration regNumGenarationObj = null;

			// Check for Duplicate RegNumGenaration
			// TODO: Uncomment if you need to check duplicates and update the
			// query in the RegNumGenarationdaoImpl.checkForDuplicates
			// regNumGenarationObj =
			// regNumGenarationService.checkForDuplicates(regNumGenaration);

			if (regNumGenarationObj != null) {
				session
						.setAttribute("message",
								"Reg Num Genaration with the same name already exists.");
			} else {
				/*if(user.getTenancy()!=null){
					regNumGenaration.setTenancy(user.getTenancy());
				}*/

				regNumGenarationService.save(regNumGenaration);
				session.setAttribute("message",
						"Reg Num Genaration details saved successfully");
			}
		}

		ModelAndView modelandView = new ModelAndView("manageRegNumGenaration");
		modelandView.addObject("regNumGenaration", regNumGenaration);
		return modelandView;
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response. This method is for
	 *         editing/creating RegNumGenaration entries
	 */
	@RequestMapping("/regnumgenaration/editRegNumGenaration.do")
	public ModelAndView editRegNumGenaration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking editRegNumGenaration");
		}

		RegNumGenaration regNumGenaration = null;
		String regNumGenarationId = request.getParameter("regNumGenarationId");
		if (regNumGenarationId != null && regNumGenarationId.length() > 0) {
			regNumGenaration = regNumGenarationService.get(Long
					.parseLong(regNumGenarationId));
		} else {
			regNumGenaration = new RegNumGenaration();
		}

		return new ModelAndView("manageRegNumGenaration", "regNumGenaration",
				regNumGenaration);
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response This method will display
	 *         list of RegNumGenaration
	 */
	@RequestMapping("/regnumgenaration/listRegNumGenaration.do")
	public ModelAndView listRegNumGenaration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listRegNumGenaration");
		}
		long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);

		// setting default order by on regNumGenarationId
		if (orderBy == null || orderBy.length() < 1) {
			orderBy = "regNumGenarationId";
			sortBy = "desc";
		}
		List<RegNumGenaration> RegNumGenarationList = regNumGenarationService
				.getRegNumGenarationList(longCurrentPage, orderBy, sortBy);
		try {
			long totalCount = regNumGenarationService
					.getRegNumGenarationCount();
			request.setAttribute("maximumPages", new Long(CommonUtils
					.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Check if the RegNumGenarationList is null
		if (RegNumGenarationList == null)
			RegNumGenarationList = new ArrayList<RegNumGenaration>();

		request.setAttribute("currentPage", new Long(longCurrentPage));
		request.setAttribute(const_OrderBy, orderBy);
		request.setAttribute(const_SortBy, sortBy);
		return new ModelAndView("listRegNumGenaration", "RegNumGenarationList",
				RegNumGenarationList);
	}

	/**
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @return a ModelAndView to render the response This method deletes a
	 *         RegNumGenaration entry from database
	 */
	@RequestMapping("/regnumgenaration/deleteRegNumGenaration.do")
	public ModelAndView deleteRegNumGenaration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		if (log.isDebugEnabled()) {
			log.debug("Invoking deleteRegNumGenaration");
		}
		String regNumGenarationId = request.getParameter("regNumGenarationId");
		if (regNumGenarationId != null && regNumGenarationId.length() > 0) {
			RegNumGenaration regNumGenaration = regNumGenarationService
					.get(Long.parseLong(regNumGenarationId));
			if (regNumGenaration != null) {
				try {
					regNumGenarationService.delete(Long
							.parseLong(regNumGenarationId));
					session.setAttribute("message",
							"Reg Num Genaration details deleted successfully");
				} catch (Exception exception) {
					session
							.setAttribute("message",
									"Cannot delete this record as it is used in other page");
					return editRegNumGenaration(request, response);
				}
			} else {
				session
						.setAttribute("message",
								"The Reg Num Genaration details you are trying to delete is already deleted.");
			}
		}
		return listRegNumGenaration(request, response);
	}
}
